package com.jiuzhou.guanwang.jzcp.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.adapter.RankAdapter;
import com.jiuzhou.guanwang.jzcp.bean.RankBean;
import com.jiuzhou.guanwang.jzcp.utils.LocalJsonResolutionUtils;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 */
public class DataFragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    @ViewInject(R.id.listView)
    ListView listView;
    private RankAdapter adapter;

    public DataFragment() {
    }

    public static DataFragment newInstance(String param1, String param2) {
        DataFragment fragment = new DataFragment();
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
        View view = inflater.inflate(R.layout.fragment_data, container, false);
        ViewUtils.inject(this,view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //得到本地json文本内容
        String fileName = "data.json";
        String foodJson = LocalJsonResolutionUtils.getJson(getActivity(), fileName);
        //转换为对象
        List<RankBean> list = LocalJsonResolutionUtils.jsonToArrayList(foodJson, RankBean.class);
        adapter = new RankAdapter(getActivity(),list.get(Integer.parseInt(mParam1)).getRanks_data());
        listView.setAdapter(adapter);
    }
}
