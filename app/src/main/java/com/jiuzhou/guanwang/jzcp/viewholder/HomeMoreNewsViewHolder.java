package com.jiuzhou.guanwang.jzcp.viewholder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.HomeNewsBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2018/7/4.
 */

public class HomeMoreNewsViewHolder extends BaseViewHolder<HomeNewsBean> {
    private ImageView iv;
    private TextView tv_title;
    private TextView tv_time;

    public HomeMoreNewsViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_home_news_layout);
        iv = $(R.id.iv);
        tv_title = $(R.id.tv_title);
        tv_time = $(R.id.tv_time);
    }

    @Override
    public void setData(HomeNewsBean data) {
        super.setData(data);

        Glide.with(getContext()).load(data.getNewsImg().get(0).getImgUrl()).into(iv);
        tv_title.setText(""+data.getNewsTitle());

        Long timestamp = data.getCreateAt();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        tv_time.setText(date);
    }
}
