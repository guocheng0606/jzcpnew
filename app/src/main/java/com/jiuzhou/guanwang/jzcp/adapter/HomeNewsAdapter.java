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
import com.jiuzhou.guanwang.jzcp.bean.HomeNewsBean;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/7/5.
 */

public class HomeNewsAdapter extends BaseAdapter {
    private Context context;
    private List<HomeNewsBean> list;
    public HomeNewsAdapter(Context context,List<HomeNewsBean> list){
        this.context = context;
        this.list = list;
    }

    public List<HomeNewsBean> getAllData() {
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
            view = LayoutInflater.from(context).inflate(R.layout.item_home_news_layout,null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        Glide.with(context).load(list.get(i).getNewsImg().get(0).getImgUrl()).into(holder.iv);
        holder.tv_title.setText(""+list.get(i).getNewsTitle());

        Long timestamp = list.get(i).getCreateAt();
        String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
        holder.tv_time.setText(date);
        return view;
    }

    class ViewHolder{
        @ViewInject(R.id.iv)
        ImageView iv;
        @ViewInject(R.id.tv_title)
        TextView tv_title;
        @ViewInject(R.id.tv_time)
        TextView tv_time;
        public ViewHolder (View view){
            ViewUtils.inject(this,view);
        }
    }

}
