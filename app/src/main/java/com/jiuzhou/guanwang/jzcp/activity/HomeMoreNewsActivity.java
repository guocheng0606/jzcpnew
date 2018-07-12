package com.jiuzhou.guanwang.jzcp.activity;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.adapter.MyViewPagerAdapter;
import com.jiuzhou.guanwang.jzcp.fragment.NewsChildFragment;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

public class HomeMoreNewsActivity extends AppCompatActivity {

    @ViewInject(R.id.toolbar)
    Toolbar toolbar;

    @ViewInject(R.id.tabLayout)
    TabLayout tabLayout;
    @ViewInject(R.id.viewPager)
    ViewPager viewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_more_news);
        ViewUtils.inject(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("体彩资讯");

        setupTabLayout();
    }

    private void setupTabLayout() {
        viewPager.setOffscreenPageLimit(7);
        //ViewPager关联适配器
        MyViewPagerAdapter adapter = new MyViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(NewsChildFragment.newInstance("1",null),"热点");
        adapter.addFragment(NewsChildFragment.newInstance("2",null),"竞彩");
        adapter.addFragment(NewsChildFragment.newInstance("3",null),"专家");
        adapter.addFragment(NewsChildFragment.newInstance("21",null),"公告");
        adapter.addFragment(NewsChildFragment.newInstance("22",null),"星站");
        adapter.addFragment(NewsChildFragment.newInstance("24",null),"专题");
        adapter.addFragment(NewsChildFragment.newInstance("28",null),"新闻");
        adapter.addFragment(NewsChildFragment.newInstance("30",null),"实闻");
        viewPager.setAdapter(adapter);
        //ViewPager和TabLayout关联
        tabLayout.setupWithViewPager(viewPager);
        viewPager.setCurrentItem(0);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}
