package com.jiuzhou.guanwang.jzcp.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.DiscoverBean;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.jiuzhou.guanwang.jzcp.utils.Util;
import com.jiuzhou.guanwang.jzcp.viewholder.DiscoverViewHolder;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.easyrecyclerview.decoration.DividerDecoration;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import java.util.ArrayList;
import java.util.List;

/**
 */
public class ThreeFragment extends Fragment implements View.OnClickListener ,RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener{
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @ViewInject(R.id.tv_tab1)
    TextView tv_tab1;
    @ViewInject(R.id.tv_tab2)
    TextView tv_tab2;
    @ViewInject(R.id.tv_tab3)
    TextView tv_tab3;
    @ViewInject(R.id.tv_tab4)
    TextView tv_tab4;
    @ViewInject(R.id.recyclerView)
    EasyRecyclerView recyclerView;

    private RecyclerArrayAdapter<DiscoverBean> adapter;
    private List<DiscoverBean> datas = new ArrayList<>();

    public ThreeFragment() {
    }

    public static ThreeFragment newInstance(String param1, String param2) {
        ThreeFragment fragment = new ThreeFragment();
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
        View view = inflater.inflate(R.layout.fragment_three, container, false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tv_tab1.setSelected(true);

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        DividerDecoration itemDecoration = new DividerDecoration(Color.GRAY, Util.dip2px(getActivity(), 0.5f), Util.dip2px(getActivity(), 72), 0);
        itemDecoration.setDrawLastItem(true);
        recyclerView.addItemDecoration(itemDecoration);

        recyclerView.setAdapterWithProgress(adapter = new RecyclerArrayAdapter<DiscoverBean>(getActivity()) {
            @Override
            public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
                return new DiscoverViewHolder(parent);
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
        onRefresh();
        tv_tab1.setOnClickListener(this);
        tv_tab2.setOnClickListener(this);
        tv_tab3.setOnClickListener(this);
        tv_tab4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_tab1:
                tv_tab1.setSelected(true);
                tv_tab2.setSelected(false);
                tv_tab3.setSelected(false);
                tv_tab4.setSelected(false);
                break;
            case R.id.tv_tab2:
                tv_tab1.setSelected(false);
                tv_tab2.setSelected(true);
                tv_tab3.setSelected(false);
                tv_tab4.setSelected(false);
                break;
            case R.id.tv_tab3:
                tv_tab1.setSelected(false);
                tv_tab2.setSelected(false);
                tv_tab3.setSelected(true);
                tv_tab4.setSelected(false);
                break;
            case R.id.tv_tab4:
                tv_tab1.setSelected(false);
                tv_tab2.setSelected(false);
                tv_tab3.setSelected(false);
                tv_tab4.setSelected(true);
                break;
        }
        onRefresh();
    }

    @Override
    public void onRefresh() {
        datas.clear();
        //得到本地json文本内容
        String fileName = "";
        if(tv_tab1.isSelected())
            fileName = "全部.json";
        if(tv_tab2.isSelected())
            fileName = "实力对比.json";
        if(tv_tab3.isSelected())
            fileName = "近期状态.json";
        if(tv_tab4.isSelected())
            fileName = "伤停.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        //转换为对象
        List<DiscoverBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, DiscoverBean.class);
        datas.addAll(list);
        adapter.clear();
        adapter.addAll(datas);
    }

    @Override
    public void onLoadMore() {
        adapter.stopMore();
    }
}
