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
import com.jiuzhou.guanwang.jzcp.bean.RankBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2018/6/26.
 */

public class RankAdapter extends BaseAdapter {
    private Context context;
    private List<RankBean.RanksDataBean> list;
    public RankAdapter(Context context, List<RankBean.RanksDataBean> list){
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
            view = LayoutInflater.from(context).inflate(R.layout.item_data_layout,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        holder.tv_num.setText(""+list.get(i).getRanking());
        Glide.with(context).load(list.get(i).getTeam_logo()).into(holder.iv);
        holder.tv_team_name.setText(""+list.get(i).getTeam_name());
        holder.tv_played.setText(""+list.get(i).getPlayed());
        holder.tv_wins.setText(""+list.get(i).getWins());
        holder.tv_ties.setText(""+list.get(i).getTies());
        holder.tv_losses.setText(""+list.get(i).getLosses());
        holder.tv_goalsFor_goalsAgainst.setText(""+list.get(i).getGoalsFor_goalsAgainst());
        holder.tv_points.setText(""+list.get(i).getPoints());
        return view;
    }

    class ViewHolder{
        @ViewInject(R.id.tv_num)
        TextView tv_num;
        @ViewInject(R.id.iv)
        ImageView iv;
        @ViewInject(R.id.tv_team_name)
        TextView tv_team_name;
        @ViewInject(R.id.tv_played)
        TextView tv_played;
        @ViewInject(R.id.tv_wins)
        TextView tv_wins;
        @ViewInject(R.id.tv_ties)
        TextView tv_ties;
        @ViewInject(R.id.tv_losses)
        TextView tv_losses;
        @ViewInject(R.id.tv_goalsFor_goalsAgainst)
        TextView tv_goalsFor_goalsAgainst;
        @ViewInject(R.id.tv_points)
        TextView tv_points;
        public ViewHolder(View view){
            ViewUtils.inject(this,view);
        }
    }

}
