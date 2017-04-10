package com.bawei.utils;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import org.xutils.common.Callback;
import org.xutils.x;

/**
 * 作者:程千浪
 * .时间：2017/4/10 20:21
 * 类用途：
 */

public class MyImageUtils {
    public static void loadpic(String url, final ImageView iv){
        x.image().loadDrawable(url,MyImageOptions.options(), new Callback.CommonCallback<Drawable>() {
            @Override
            public void onSuccess(Drawable result) {
                iv.setImageDrawable(result);
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
    }
}
