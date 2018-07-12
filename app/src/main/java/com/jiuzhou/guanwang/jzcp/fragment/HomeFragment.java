package com.jiuzhou.guanwang.jzcp.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.activity.HomeMoreNewsActivity;
import com.jiuzhou.guanwang.jzcp.activity.HotActivity;
import com.jiuzhou.guanwang.jzcp.activity.SeasonDetailActivity;
import com.jiuzhou.guanwang.jzcp.activity.WebNewsActivity;
import com.jiuzhou.guanwang.jzcp.adapter.HomeNewsAdapter;
import com.jiuzhou.guanwang.jzcp.adapter.SeasonAdapter;
import com.jiuzhou.guanwang.jzcp.bean.IndexLotteryBean;
import com.jiuzhou.guanwang.jzcp.bean.NewsBean;
import com.jiuzhou.guanwang.jzcp.bean.SeasonBean;
import com.jiuzhou.guanwang.jzcp.event.MessageEvent;
import com.jiuzhou.guanwang.jzcp.loader.GlideImageLoader;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.jiuzhou.guanwang.jzcp.utils.LogUtils;
import com.jiuzhou.guanwang.jzcp.views.HorizontalListView;
import com.jiuzhou.guanwang.jzcp.views.NoScrollListView;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;
import com.yanzhenjie.kalle.Kalle;
import com.yanzhenjie.kalle.simple.SimpleCallback;
import com.yanzhenjie.kalle.simple.SimpleResponse;
import com.youth.banner.Banner;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class HomeFragment extends Fragment implements View.OnClickListener,SwipeRefreshLayout.OnRefreshListener {
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
    @ViewInject(R.id.tv_qs)
    TextView tv_qs;
    @ViewInject(R.id.ll_redball)
    LinearLayout ll_redball;
    @ViewInject(R.id.ll_blueball)
    LinearLayout ll_blueball;
    @ViewInject(R.id.rl_lottery)
    RelativeLayout rl_lottery;

    @ViewInject(R.id.swipeRefreshLayout)
    SwipeRefreshLayout swipeRefreshLayout;

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
        setBannerData();
        horizontalListView.setFocusable(false);
        listView.setFocusable(false);
        setLotteryData();
        getSeasonsData();
        onRefresh();
        initListener();
    }

    private void setLotteryData() {
        Kalle.post("http://e.zgtcb.com/portal/lottery/resultsAction!getLatestOne.action")
                .param("appCode","1")
                .param("appId","2")
                .param("platform","2")
                .param("requestTime","1531357878")
                .param("appNumber","209")
                .param("category","1")
                .param("apiVer","2")
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onResponse(SimpleResponse<String, String> simpleResponse) {
                        if(simpleResponse.isSucceed()) { // Http成功，业务也成功。
                            String result = simpleResponse.succeed();
                            LogUtils.LogShow(result);
                            Gson gson = new Gson();
                            IndexLotteryBean bean = gson.fromJson(result, IndexLotteryBean.class);
                            if(bean.getMsg().indexOf("成功") != -1){
                                IndexLotteryBean.ResultBean.DataBean dataBean = bean.getResult().getData().get(0);
                                tv_qs.setText(dataBean.getLotteryName()+"   第"+dataBean.getDrawId()+"期   奖池滚存");
                                if(!TextUtils.isEmpty(dataBean.getResult())){
                                    String[] red_ball = dataBean.getResult().split(",");
                                    for (int i = 0; i < red_ball.length; i++) {
                                        TextView ball = new TextView(getContext());
                                        ball.setText(red_ball[i]);
                                        ball.setTextSize(12);
                                        ball.setGravity(Gravity.CENTER);
                                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(85, 85);
                                        layoutParams.setMarginStart(12);
                                        ball.setLayoutParams(layoutParams);
                                        ball.setPadding(0, 0, 0, 4);
                                        ball.setTextColor(getContext().getResources().getColor(R.color.white));
                                        ball.setBackgroundResource(R.drawable.shape_circle_red_bg);
                                        ll_redball.addView(ball);
                                    }
                                }
                                if(!TextUtils.isEmpty(dataBean.getAddResult())){
                                    String[] red_ball = dataBean.getAddResult().split(",");
                                    for (int i = 0; i < red_ball.length; i++) {
                                        TextView ball = new TextView(getContext());
                                        ball.setText(red_ball[i]);
                                        ball.setTextSize(12);
                                        ball.setGravity(Gravity.CENTER);
                                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(85, 85);
                                        layoutParams.setMarginStart(12);
                                        ball.setLayoutParams(layoutParams);
                                        ball.setPadding(0, 0, 0, 4);
                                        ball.setTextColor(getContext().getResources().getColor(R.color.white));
                                        ball.setBackgroundResource(R.drawable.shape_circle_blue_bg);
                                        ll_blueball.addView(ball);
                                    }
                                }
                            }
                        }else{

                        }
                    }
                });
    }

    private void setBannerData() {
        ArrayList<Integer> BannerList = new ArrayList<>();
        BannerList.add(R.drawable.banner1);
        BannerList.add(R.drawable.banner2);
        BannerList.add(R.drawable.banner3);
        BannerList.add(R.drawable.banner4);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        mBanner.setImages(BannerList)
                .setImageLoader(new GlideImageLoader())
                .start();
    }

    private void getSeasonsData() {
        //得到本地json文本内容
        String fileName = "猜你喜欢的联赛.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        List<SeasonBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, SeasonBean.class);
        seasonAdapter = new SeasonAdapter(getActivity(),list);
        horizontalListView.setAdapter(seasonAdapter);
    }

    private void getNewsData() {
        Kalle.get("http://api.zgtcb.com/api/news/getNewsList?appCode=5&appId=12&sid=anzhishichang&platform=2&deviceId=901dc0a2-7bc6-33b6-8cb9-18f6b036804e&softVer=2.1.1&sysVer=5.1&brand=Meizu&network=wifi&requestTime=1527215823&appNumber=209&category=2&apiVer=2&curPage=1&pageSize=10&programaId=1")
                .perform(new SimpleCallback<String>() {
                    @Override
                    public void onResponse(SimpleResponse<String, String> simpleResponse) {
                        if(simpleResponse.isSucceed()) { // Http成功，业务也成功。
                            String result = simpleResponse.succeed();
                            LogUtils.LogShow(result);
                            Gson gson = new Gson();
                            NewsBean newsBean = gson.fromJson(result,NewsBean.class);
                            if(newsBean.getMsg().indexOf("成功") != -1){
                                List<NewsBean.ResultBean.DataBean> list = newsBean.getResult().getData().subList(2,10);;
                                homeNewsAdapter = new HomeNewsAdapter(getActivity(),list);
                                listView.setAdapter(homeNewsAdapter);
                                swipeRefreshLayout.setRefreshing(false);
                            }
                        }else{

                        }
                    }
                });

        //得到本地json文本内容
        //String fileName = "热点资讯.json";
        //String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        //转换为对象
        //List<HomeNewsBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, HomeNewsBean.class).subList(0,5);
        //homeNewsAdapter = new HomeNewsAdapter(getActivity(),list);
        //listView.setAdapter(homeNewsAdapter);
        //swipeRefreshLayout.setRefreshing(false);
    }

    private void initListener() {
        swipeRefreshLayout.setOnRefreshListener(this);
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
        rl_lottery.setOnClickListener(this);
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
                intent.setClass(getActivity(), HotActivity.class);
                intent.putExtra("programaId","8");
                intent.putExtra("title","彩票资讯");
                startActivity(intent);
                break;
            case R.id.rl_02:
                intent.setClass(getActivity(), HotActivity.class);
                intent.putExtra("programaId","18");
                intent.putExtra("title","彩票预测");
                startActivity(intent);
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
            case R.id.rl_lottery:
                EventBus.getDefault().post(new MessageEvent(MessageEvent.EVENT_LOTTERY_TAB));
                break;
        }
    }


    @Override
    public void onRefresh() {
        getNewsData();
    }
}
