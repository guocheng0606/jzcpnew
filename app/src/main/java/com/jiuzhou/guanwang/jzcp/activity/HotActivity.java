package com.jiuzhou.guanwang.jzcp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.ViewGroup;

import com.google.gson.Gson;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.HotBean;
import com.jiuzhou.guanwang.jzcp.utils.LogUtils;
import com.jiuzhou.guanwang.jzcp.utils.Util;
import com.jiuzhou.guanwang.jzcp.viewholder.HotViewHolder;
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

public class HotActivity extends AppCompatActivity implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener {

    @ViewInject(R.id.toolbar)
    Toolbar toolbar;
    @ViewInject(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    private RecyclerArrayAdapter<HotBean.ResultBean.DataBean> adapter;
    private List<HotBean.ResultBean.DataBean> list = new ArrayList<>();
    private int currentPage = 1;
    private String title = "";
    private String programaId = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hot);
        ViewUtils.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        title = getIntent().getStringExtra("title");
        programaId = getIntent().getStringExtra("programaId");
        getSupportActionBar().setTitle(title);

        initView();
        onRefresh();
        initListener();
    }

    private void getNewsData() {
        Kalle.get("http://e.zgtcb.com/portal/news/newsaction!getNewsList.action")
                .param("appCode","1")
                .param("appId","2")
                .param("platform","2")
                .param("requestTime","1531357878")
                .param("appNumber","209")
                .param("category","1")
                .param("apiVer","2")
                .param("curPage",currentPage)
                .param("pageSize","10")
                .param("programaId",programaId)
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onResponse(SimpleResponse<String, String> simpleResponse) {
                        if(simpleResponse.isSucceed()) { // Http成功，业务也成功。
                            String result = simpleResponse.succeed();
                            LogUtils.LogShow(result);
                            Gson gson = new Gson();
                            HotBean bean = gson.fromJson(result,HotBean.class);
                            if(bean.getMsg().indexOf("成功") != -1){
                                List<HotBean.ResultBean.DataBean> list = bean.getResult().getData();
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
                Intent intent = new Intent(HotActivity.this, HotNewsActivity.class);
                intent.putExtra("url",""+adapter.getAllData().get(position).getNewsUrl());
                intent.putExtra("title",title);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        DividerDecoration itemDecoration = new DividerDecoration(0xFFEDEDED, Util.dip2px(this, 0.5f), 0, 0);
        itemDecoration.setDrawLastItem(true);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<HotBean.ResultBean.DataBean>(this) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new HotViewHolder(parent);
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
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
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
