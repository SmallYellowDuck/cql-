package com.bawei.utils;

import android.os.Handler;
import android.os.Message;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.x;


/**
 * 作者:程千浪
 * .时间：2017/4/10 19:21
 * 类用途：
 */

public class MyXutils {
    public static void xutilstostr(String url, final Handler handler) {
        RequestParams params = new RequestParams(url);
        x.http().get(params, new Callback.CommonCallback<String>() {
            @Override
            public void onSuccess(String result) {
                Message message = new Message();
                message.obj=result;
                handler.sendMessage(message);
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {

            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {

            }

        });

}}


