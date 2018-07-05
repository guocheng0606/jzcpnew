package com.jiuzhou.guanwang.jzcp.adapter;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.bean.SeasonBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class SeasonAdapter extends BaseAdapter {
    private Context context;
    private List<SeasonBean> list;
    public SeasonAdapter(Context context, List<SeasonBean> list){
        this.context = context;
        this.list = list;
    }

    public List<SeasonBean> getAllData() {
        return list;
    }

    @Override
    public int getCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public Object getItem(int i) {
        return list == null ?  null : list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.item_season_layout,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getSeason_image()).into(holder.iv);
        holder.tv.setText(""+list.get(i).getSeason_name());

    // 获取背景颜色，并且改变颜色
        GradientDrawable myGrad = (GradientDrawable) holder.rl_bg.getBackground();
        myGrad.setColor(Color.parseColor("#"+list.get(i).getColor()));
        return view;
    }

    class ViewHolder{
        @ViewInject(R.id.rl_bg)
        RelativeLayout rl_bg;
        @ViewInject(R.id.iv)
        ImageView iv;
        @ViewInject(R.id.tv)
        TextView tv;
        public ViewHolder (View view){
            ViewUtils.inject(this,view);
        }
    }

}
