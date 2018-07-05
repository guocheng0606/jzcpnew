package com.jiuzhou.guanwang.jzcp.viewholder;

import android.text.Html;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.DiscoverBean;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * Created by Administrator on 2018/7/4.
 */

public class DiscoverViewHolder extends BaseViewHolder<DiscoverBean> {
    private TextView tv_time;
    private TextView tv_name;
    private TextView tv_title;
    private TextView tv_content;

    public DiscoverViewHolder(ViewGroup parent) {
        super(parent, R.layout.item_discover_layout);
        tv_time = $(R.id.tv_time);
        tv_name = $(R.id.tv_name);
        tv_title = $(R.id.tv_title);
        tv_content = $(R.id.tv_content);
    }

    @Override
    public void setData(DiscoverBean data) {
        super.setData(data);
        tv_time.setText(""+data.getFlash_time());
        tv_name.setText(""+data.getLeague_name());
        tv_title.setText(""+data.getTitle());
        tv_content.setText(Html.fromHtml(data.getContent()));
    }
}
