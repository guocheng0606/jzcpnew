package com.jiuzhou.guanwang.jzcp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.MatchBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class MatchAdapter extends BaseAdapter {
    private Context context;
    private List<MatchBean> list;
    public MatchAdapter(Context context,List<MatchBean> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.item_match_layout,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }

        holder.tv_01.setText(" "+list.get(i).getOdds_v2());
        holder.tv_02.setText(""+list.get(i).getMatch_time());
        holder.tv_03.setText(""+list.get(i).getMatch_week()+list.get(i).getMatch_sn());
        holder.tv_04.setText(""+list.get(i).getHost_name());
        holder.tv_05.setText(""+list.get(i).getAway_name());
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
        @ViewInject(R.id.tv_05)
        TextView tv_05;
        @ViewInject(R.id.iv_01)
        ImageView iv_01;
        @ViewInject(R.id.iv_02)
        ImageView iv_02;
        public ViewHolder(View view){
            ViewUtils.inject(this,view);
        }
    }

}
