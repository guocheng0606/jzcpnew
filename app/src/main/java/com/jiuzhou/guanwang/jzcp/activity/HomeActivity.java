package com.jiuzhou.guanwang.jzcp.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.jiuzhou.guanwang.jzcp.R;
import com.jiuzhou.guanwang.jzcp.event.MessageEvent;
import com.jiuzhou.guanwang.jzcp.fragment.FirstFragment;
import com.jiuzhou.guanwang.jzcp.fragment.FourFragment;
import com.jiuzhou.guanwang.jzcp.fragment.HomeFragment;
import com.jiuzhou.guanwang.jzcp.fragment.ThreeFragment;
import com.jiuzhou.guanwang.jzcp.fragment.TwoFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import me.majiajie.pagerbottomtabstrip.NavigationController;
import me.majiajie.pagerbottomtabstrip.PageNavigationView;
import me.majiajie.pagerbottomtabstrip.item.BaseTabItem;
import me.majiajie.pagerbottomtabstrip.item.NormalItemView;
import me.majiajie.pagerbottomtabstrip.listener.OnTabItemSelectedListener;

public class HomeActivity extends AppCompatActivity {

    private PageNavigationView tab;
    private FragmentManager fragmentManager;
    private FragmentTransaction fragmentTransaction;
    private HomeFragment homeFragment;
    private FirstFragment firstFragment;
    private TwoFragment twoFragment;
    private ThreeFragment threeFragment;
    private FourFragment fourFragment;
    private NavigationController navigationController;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        EventBus.getDefault().register(this);
        tab = (PageNavigationView) findViewById(R.id.tab);
        fragmentManager = getSupportFragmentManager();
        setTabSelection(0);
        initBottomNavigation();
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {
        switch (event.getEventId()) {
            case MessageEvent.EVENT_LOTTERY_TAB:
                navigationController.setSelect(2);
                setTabSelection(2);
                break;
        }
    }

    private void initBottomNavigation() {
        navigationController = tab.custom()
                .addItem(newItem(R.drawable.mh_buy_normal,R.drawable.mh_buy_pressed,"首页"))
                .addItem(newItem(R.drawable.mh_score_normal,R.drawable.mh_score_pressed,"比分"))
                .addItem(newItem(R.drawable.mh_dslt_normal,R.drawable.mh_dslt_pressed,"开奖"))
                .addItem(newItem(R.drawable.mh_find_normal,R.drawable.mh_find_pressed,"发现"))
                .addItem(newItem(R.drawable.mh_user_normal,R.drawable.mh_user_pressed,"足球"))
                .build();
        //navigationController.setSelect(0);
        navigationController.addTabItemSelectedListener(new OnTabItemSelectedListener() {
            @Override
            public void onSelected(int index, int old) {
                //选中时触发
                setTabSelection(index);
            }

            @Override
            public void onRepeat(int index) {
                //System.out.println(index);
                //setTabSelection(index);
            }
        });
    }

    private void setTabSelection(int i) {
        fragmentTransaction = fragmentManager.beginTransaction();
        hideAllFragment(fragmentTransaction);
        switch (i){
            case 0:
                if(homeFragment == null){
                    homeFragment = new HomeFragment();
                    fragmentTransaction.add(R.id.fl_layout,homeFragment);
                }else{
                    fragmentTransaction.show(homeFragment);
                }
                break;
            case 2:
                if(firstFragment == null){
                    firstFragment = new FirstFragment();
                    fragmentTransaction.add(R.id.fl_layout,firstFragment);
                }else{
                    fragmentTransaction.show(firstFragment);
                }
                break;
            case 1:
                if(twoFragment == null){
                    twoFragment = new TwoFragment();
                    fragmentTransaction.add(R.id.fl_layout,twoFragment);
                }else{
                    fragmentTransaction.show(twoFragment);
                }
                break;
            case 3:
                if(threeFragment == null){
                    threeFragment = new ThreeFragment();
                    fragmentTransaction.add(R.id.fl_layout,threeFragment);
                }else{
                    fragmentTransaction.show(threeFragment);
                }
                break;
            case 4:
                if(fourFragment == null){
                    fourFragment = new FourFragment();
                    fragmentTransaction.add(R.id.fl_layout,fourFragment);
                }else{
                    fragmentTransaction.show(fourFragment);
                }
                break;
        }
        fragmentTransaction.commit();
    }

    private void hideAllFragment(FragmentTransaction fragmentTransaction) {
        if(homeFragment != null) fragmentTransaction.hide(homeFragment);
        if(firstFragment != null) fragmentTransaction.hide(firstFragment);
        if(twoFragment != null) fragmentTransaction.hide(twoFragment);
        if(threeFragment != null) fragmentTransaction.hide(threeFragment);
        if(fourFragment != null) fragmentTransaction.hide(fourFragment);
    }

    //创建一个Item
    private BaseTabItem newItem(int drawable, int checkedDrawable, String text) {
        NormalItemView normalItemView = new NormalItemView(this);
        normalItemView.initialize(drawable, checkedDrawable, text);
        normalItemView.setTextDefaultColor(Color.GRAY);
        normalItemView.setTextCheckedColor(0xFFE23A3A);
        return normalItemView;
    }

    long defTime = 0;
    @Override
    public void onBackPressed() {
        if (defTime==0||(System.currentTimeMillis() - defTime)>2000 ){
            Toast.makeText(this,"再按一次离开",Toast.LENGTH_SHORT).show();
            defTime = System.currentTimeMillis();
        }else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

}
