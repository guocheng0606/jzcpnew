package com.jiuzhou.guanwang.jzcp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.activity.HomeMoreNewsActivity;
import com.jiuzhou.guanwang.jzcp.activity.SeasonDetailActivity;
import com.jiuzhou.guanwang.jzcp.activity.WebNewsActivity;
import com.jiuzhou.guanwang.jzcp.adapter.HomeNewsAdapter;
import com.jiuzhou.guanwang.jzcp.adapter.SeasonAdapter;
import com.jiuzhou.guanwang.jzcp.bean.HomeNewsBean;
import com.jiuzhou.guanwang.jzcp.bean.SeasonBean;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.jiuzhou.guanwang.jzcp.views.HorizontalListView;
import com.jiuzhou.guanwang.jzcp.views.NoScrollListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 *
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @ViewInject(R.id.tv_more)
    TextView tv_more;
    @ViewInject(R.id.listView)
    NoScrollListView listView;
    @ViewInject(R.id.horizontalListView)
    HorizontalListView horizontalListView;
    private HomeNewsAdapter homeNewsAdapter;
    private SeasonAdapter seasonAdapter;

    public HomeFragment() {
    }

    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getSeasonsData();
        getNewsData();
        initListener();
    }

    private void getSeasonsData() {
        horizontalListView.setFocusable(false);
        //得到本地json文本内容
        String fileName = "猜你喜欢的联赛.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        List<SeasonBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, SeasonBean.class);
        seasonAdapter = new SeasonAdapter(getActivity(),list);
        horizontalListView.setAdapter(seasonAdapter);
    }

    private void getNewsData() {
        listView.setFocusable(false);
        //得到本地json文本内容
        String fileName = "热点资讯.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        //转换为对象
        List<HomeNewsBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, HomeNewsBean.class).subList(0,5);
        homeNewsAdapter = new HomeNewsAdapter(getActivity(),list);
        listView.setAdapter(homeNewsAdapter);
    }

    private void initListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), WebNewsActivity.class);
                intent.putExtra("url",""+homeNewsAdapter.getAllData().get(i).getNewsUrl());
                startActivity(intent);
            }
        });
        horizontalListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), SeasonDetailActivity.class);
                intent.putExtra("title_name",seasonAdapter.getAllData().get(i).getSeason_name());
                startActivity(intent);
            }
        });
        tv_more.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_more:
                startActivity(new Intent(getActivity(), HomeMoreNewsActivity.class));
                break;
        }
    }


}
