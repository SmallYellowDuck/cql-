package com.bawei.cql0410;

import android.app.Application;

import org.xutils.x;

/**
 * 作者:程千浪
 * .时间：2017/4/10 18:43
 * 类用途：
 */

public class Myapplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
    }
}
