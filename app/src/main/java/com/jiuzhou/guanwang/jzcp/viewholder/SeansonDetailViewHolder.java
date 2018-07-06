package com.jiuzhou.guanwang.jzcp.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.SeasonDetailBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/7/4.
 */

public class SeansonDetailViewHolder extends BaseViewHolder<SeasonDetailBean> {
    private TextView tv_01;
    private TextView tv_02;
    private TextView tv_03;
    private ImageView iv_01;
    private TextView tv_04;
    private ImageView iv_02;
    private TextView tv_05;
    private TextView tv_06;

    public SeansonDetailViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_season_detail_layout);
        tv_01 = $(R.id.tv_01);
        tv_02 = $(R.id.tv_02);
        tv_03 = $(R.id.tv_03);
        iv_01 = $(R.id.iv_01);
        tv_04 = $(R.id.tv_04);
        iv_02 = $(R.id.iv_02);
        tv_05 = $(R.id.tv_05);
        tv_06 = $(R.id.tv_06);
    }

    @Override
    public void setData(SeasonDetailBean data) {
        super.setData(data);

        tv_01.setText(""+data.getMatch_week()+data.getMatch_sn());
        tv_02.setText(""+data.getSeason_pre()+data.getGroup_pre());

        if(data.getMatch_status() == 0) {
            tv_03.setText("" + data.getMatch_status_desc());
            tv_06.setText("");
        }else {
            tv_03.setText("上半场" + data.getHost_half_score() + ":" + data.getAway_half_score() + "；" + data.getMatch_status_desc());
            tv_06.setText(""+data.getHost_score()+":"+data.getAway_score());
        }
        Glide.with(getContext()).load(data.getHost_team_image()).into(iv_01);
        tv_04.setText(""+data.getHost_name());
        Glide.with(getContext()).load(data.getAway_team_image()).into(iv_02);
        tv_05.setText(""+data.getAway_name());

    }
}
