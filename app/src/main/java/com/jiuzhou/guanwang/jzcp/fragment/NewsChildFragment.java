package com.jiuzhou.guanwang.jzcp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.activity.WebNewsActivity;
import com.jiuzhou.guanwang.jzcp.bean.NewsBean;
import com.jiuzhou.guanwang.jzcp.utils.LogUtils;
import com.jiuzhou.guanwang.jzcp.utils.Util;
import com.jiuzhou.guanwang.jzcp.viewholder.HomeMoreNewsViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.simple.SimpleCallback;
import com.yanzhenjie.kalle.simple.SimpleResponse;

import java.util.ArrayList;
import java.util.List;

/**
 */
public class NewsChildFragment extends Fragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener  {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private String url = "http://api.zgtcb.com/api/news/getNewsList?appCode=5&appId=12&sid=anzhishichang&platform=2&deviceId=901dc0a2-7bc6-33b6-8cb9-18f6b036804e&softVer=2.1.1&sysVer=5.1&brand=Meizu&network=wifi&requestTime=1527215823&appNumber=209&category=2&apiVer=2";

    @ViewInject(R.id.recyclerView)
    EasyRecyclerView recyclerView;
    private RecyclerArrayAdapter<NewsBean.ResultBean.DataBean> adapter;
    private List<NewsBean.ResultBean.DataBean> list = new ArrayList<>();
    private int currentPage = 1;

    public NewsChildFragment() {
    }

    public static NewsChildFragment newInstance(String param1, String param2) {
        NewsChildFragment fragment = new NewsChildFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_child, container, false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        onRefresh();
        initListener();
    }

    private void getNewsData() {
        Kalle.get(url)
                .param("curPage",currentPage)
                .param("pageSize","10")
                .param("programaId",""+mParam1)
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onResponse(SimpleResponse<String, String> simpleResponse) {
                        if(simpleResponse.isSucceed()) { // Http成功，业务也成功。
                            String result = simpleResponse.succeed();
                            LogUtils.LogShow(result);
                            Gson gson = new Gson();
                            NewsBean newsBean = gson.fromJson(result,NewsBean.class);
                            if(newsBean.getMsg().indexOf("成功") != -1){
                                List<NewsBean.ResultBean.DataBean> list = newsBean.getResult().getData();
                                if(list.size() > 0){
                                    if(currentPage == 1)
                                        adapter.clear();
                                    adapter.addAll(list);
                                }else{
                                    if (currentPage == 1) {
                                        adapter.clear();
                                    } else {
                                        adapter.stopMore();
                                    }
                                }
                            }
                        }else{

                        }
                    }
                });
    }


    private void initListener() {
        adapter.setOnItemClickListener(new RecyclerArrayAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(getActivity(), WebNewsActivity.class);
                intent.putExtra("url",""+adapter.getAllData().get(position).getNewsUrl());
                intent.putExtra("title","资讯详情");
                startActivity(intent);
            }
        });
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(0xFFEDEDED, Util.dip2px(getActivity(), 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(true);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<NewsBean.ResultBean.DataBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new HomeMoreNewsViewHolder(parent);
            }
        });
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore, new RecyclerArrayAdapter.OnNoMoreListener() {
            @Override
            public void onNoMoreShow() {
                adapter.resumeMore();
            }

            @Override
            public void onNoMoreClick() {
                adapter.resumeMore();
            }
        });
        adapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {
            @Override
            public void onErrorShow() {
                adapter.resumeMore();
            }

            @Override
            public void onErrorClick() {
                adapter.resumeMore();
            }
        });
        recyclerView.setRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        currentPage = 1;
        getNewsData();
    }

    @Override
    public void onLoadMore() {
        currentPage++;
        getNewsData();
    }

}
