package com.jiuzhou.guanwang.jzcp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.adapter.ScoreAdapter;
import com.jiuzhou.guanwang.jzcp.bean.ScoreBean;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

/**
 */
public class FourFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    @ViewInject(R.id.listView)
    ListView listView;
    @ViewInject(R.id.tv_title)
    TextView tv_title;
    private ScoreAdapter adapter;

    private String mParam1;
    private String mParam2;

    public FourFragment() {
    }

    public static FourFragment newInstance(String param1, String param2) {
        FourFragment fragment = new FourFragment();
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
        View view = inflater.inflate(R.layout.fragment_four, container, false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //得到本地json文本内容
        String fileName = "score.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        //转换为对象
        ScoreBean scoreBean = LocalJsonResolutionUtils.JsonToObject(foodJson, ScoreBean.class);
        tv_title.setText(Html.fromHtml(scoreBean.getTitle()));

        adapter = new ScoreAdapter(getActivity(),scoreBean.getHistory_list());
        listView.setAdapter(adapter);
    }
}
