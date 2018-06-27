package com.jiuzhou.guanwang.jzcp.adapter;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.ScoreBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by guocheng on 2018/6/26.
 */

public class ScoreAdapter extends BaseAdapter {
    private Context context;
    private List<ScoreBean.HistoryListBean> list;
    public ScoreAdapter(Context context, List<ScoreBean.HistoryListBean> list){
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ? null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_score_layout,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_01.setText(" "+list.get(i).getMatch_time_detail());
        holder.tv_02.setText(Html.fromHtml(list.get(i).getHost_name()));
        holder.tv_03.setText(Html.fromHtml(list.get(i).getAway_name()));
        holder.tv_04.setText(""+list.get(i).getScore());
        Glide.with(context).load(list.get(i).getHost_team_image()).into(holder.iv_01);
        Glide.with(context).load(list.get(i).getAway_team_image()).into(holder.iv_02);
        return view;
    }

    class ViewHolder{
        @ViewInject(R.id.tv_01)
        TextView tv_01;
        @ViewInject(R.id.tv_02)
        TextView tv_02;
        @ViewInject(R.id.tv_03)
        TextView tv_03;
        @ViewInject(R.id.tv_04)
        TextView tv_04;
        @ViewInject(R.id.iv_01)
        ImageView iv_01;
        @ViewInject(R.id.iv_02)
        ImageView iv_02;
        public ViewHolder(View view){
            ViewUtils.inject(this,view);
        }
    }

}
