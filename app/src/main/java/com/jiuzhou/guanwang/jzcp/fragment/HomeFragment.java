package com.jiuzhou.guanwang.jzcp.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.activity.HomeMoreNewsActivity;
import com.jiuzhou.guanwang.jzcp.activity.SeasonDetailActivity;
import com.jiuzhou.guanwang.jzcp.activity.WebNewsActivity;
import com.jiuzhou.guanwang.jzcp.adapter.HomeNewsAdapter;
import com.jiuzhou.guanwang.jzcp.adapter.SeasonAdapter;
import com.jiuzhou.guanwang.jzcp.bean.BannerBean;
import com.jiuzhou.guanwang.jzcp.bean.HomeNewsBean;
import com.jiuzhou.guanwang.jzcp.bean.SeasonBean;
import com.jiuzhou.guanwang.jzcp.loader.GlideImageLoader;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.jiuzhou.guanwang.jzcp.views.HorizontalListView;
import com.jiuzhou.guanwang.jzcp.views.NoScrollListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragment extends Fragment implements View.OnClickListener {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @ViewInject(R.id.banner)
    Banner mBanner;
    @ViewInject(R.id.tv_more)
    TextView tv_more;
    @ViewInject(R.id.listView)
    NoScrollListView listView;
    @ViewInject(R.id.horizontalListView)
    HorizontalListView horizontalListView;

    @ViewInject(R.id.ll_01)
    LinearLayout ll_01;
    @ViewInject(R.id.rl_02)
    RelativeLayout rl_02;
    @ViewInject(R.id.ll_03)
    LinearLayout ll_03;
    @ViewInject(R.id.ll_04)
    LinearLayout ll_04;
    @ViewInject(R.id.ll_group)
    LinearLayout ll_group;
    @ViewInject(R.id.ll_group_01)
    LinearLayout ll_group_01;
    @ViewInject(R.id.ll_group_02)
    LinearLayout ll_group_02;
    @ViewInject(R.id.ll_group_03)
    LinearLayout ll_group_03;
    @ViewInject(R.id.ll_group_04)
    LinearLayout ll_group_04;
    @ViewInject(R.id.iv_show)
    ImageView iv_show;

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
        rl_02.setSelected(false);
        getSeasonsData();
        setBannerData();
        getNewsData();
        initListener();
    }

    private void setBannerData() {
        //得到本地json文本内容
        String fileName = "banner.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        final List<BannerBean> bannerList = LocalJsonResolutionUtils.jsonToArrayList(foodJson, BannerBean.class);
        List<String> images = new ArrayList<>();
        for(BannerBean bean : bannerList){
            images.add(""+bean.getPicture());
        }
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        mBanner.setImages(images)
                .setImageLoader(new GlideImageLoader())
                .start();
        mBanner.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int i) {
                Uri uri = Uri.parse(""+bannerList.get(i).getClickHref());
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });
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
                intent.putExtra("title","资讯详情");
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
        ll_01.setOnClickListener(this);
        rl_02.setOnClickListener(this);
        ll_03.setOnClickListener(this);
        ll_04.setOnClickListener(this);
        ll_group_01.setOnClickListener(this);
        ll_group_02.setOnClickListener(this);
        ll_group_03.setOnClickListener(this);
        ll_group_04.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        switch (view.getId()){
            case R.id.tv_more:
                intent.setClass(getActivity(), HomeMoreNewsActivity.class);
                startActivity(intent);
                break;
            case R.id.ll_01:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://zxwap.caipiao.163.com/?time==153112131&from=caipiao");
                intent.putExtra("title","彩票资讯");
                startActivity(intent);
                break;
            case R.id.rl_02:
                if(rl_02.isSelected()){
                    rl_02.setSelected(false);
                    iv_show.setVisibility(View.GONE);
                    ll_group.setVisibility(View.GONE);
                }else{
                    rl_02.setSelected(true);
                    iv_show.setVisibility(View.VISIBLE);
                    ll_group.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.ll_03:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://caipiao.163.com/t/awardlive.html");
                intent.putExtra("title","体彩开奖直播");
                startActivity(intent);
                break;
            case R.id.ll_04:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://caipiao.163.com/t/awardliveC.html");
                intent.putExtra("title","福彩开奖直播");
                startActivity(intent);
                break;
            case R.id.ll_group_01:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://zxwap.caipiao.163.com/ssq");
                intent.putExtra("title","双色球");
                startActivity(intent);
                break;
            case R.id.ll_group_02:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://zxwap.caipiao.163.com/dlt");
                intent.putExtra("title","大乐透");
                startActivity(intent);
                break;
            case R.id.ll_group_03:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://zxwap.caipiao.163.com/jingcai");
                intent.putExtra("title","竞彩足球");
                startActivity(intent);
                break;
            case R.id.ll_group_04:
                intent.setClass(getActivity(), WebNewsActivity.class);
                intent.putExtra("url","http://zxwap.caipiao.163.com/lancai");
                intent.putExtra("title","竞彩篮球");
                startActivity(intent);
                break;
        }
    }


}
