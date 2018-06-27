package com.jiuzhou.guanwang.jzcp;

import android.app.Application;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by ydd on 2017/4/11.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        JPushInterface.setDebugMode(true);
        JPushInterface.init(this);
    }


}
