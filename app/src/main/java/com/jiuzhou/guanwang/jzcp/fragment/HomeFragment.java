package com.jiuzhou.guanwang.jzcp.fragment;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiuzhou.guanwang.jzcp.R;

import java.util.Random;

/**
 *
 */
public class HomeFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private View view;
    private TextView tv_c;
    private TextView tv_01;
    private TextView tv_02;
    private TextView tv_03;
    private TextView tv_04;
    private TextView tv_05;
    private TextView tv_06;
    private TextView tv_07;
    private TextView tv_08;
    private TextView tv_09;
    private TextView tv_10;
    private TextView tv_time;

    private String mParam1;
    private String mParam2;

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
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        Random random = new Random();
        start(random.nextInt(5*60*1000));
        tv_01.setText(""+random.nextInt(9));
        tv_02.setText(""+random.nextInt(9));
        tv_03.setText(""+random.nextInt(9));
        tv_04.setText(""+random.nextInt(9));
        tv_05.setText(""+random.nextInt(9));
        tv_06.setText(""+random.nextInt(9));
        tv_07.setText(""+random.nextInt(9));
        tv_08.setText(""+random.nextInt(9));
        tv_09.setText(""+random.nextInt(9));
        tv_10.setText(""+random.nextInt(9));
    }

    private void start(int num) {
        /** 倒计时60秒，一次1秒 */
        new CountDownTimer(num, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                int minutes = (int) ((millisUntilFinished/1000) / 60);
                int remainingSeconds = (int) ((millisUntilFinished/1000) % 60);
                String min = ""+minutes,sec=""+remainingSeconds;
                if(minutes <= 9 )
                    min = "0"+ minutes;
                if(remainingSeconds <= 9 )
                    sec = "0"+ remainingSeconds;
                tv_time.setText("距下期开奖剩余："+min+":"+sec);
            }

            @Override
            public void onFinish() {
                tv_time.setText("等待开奖");
            }
        }.start();
    }

    private void initView() {
        tv_c = view.findViewById(R.id.tv_c);
        tv_01 = view.findViewById(R.id.tv_01);
        tv_02 = view.findViewById(R.id.tv_02);
        tv_03 = view.findViewById(R.id.tv_03);
        tv_04 = view.findViewById(R.id.tv_04);
        tv_05 = view.findViewById(R.id.tv_05);
        tv_06 = view.findViewById(R.id.tv_06);
        tv_07 = view.findViewById(R.id.tv_07);
        tv_08 = view.findViewById(R.id.tv_08);
        tv_09 = view.findViewById(R.id.tv_09);
        tv_10 = view.findViewById(R.id.tv_10);
        tv_time = view.findViewById(R.id.tv_time);
    }
}
