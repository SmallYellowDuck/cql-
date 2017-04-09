package com.bawei.cql0408;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:程千浪
 * .时间：2017/4/8 11:17
 * 类用途：
 */

public class LeftFragment extends Fragment {
    private View mView;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null)
        {
            initView(inflater, container);
        }
        return mView;
    }

    private void initView(LayoutInflater inflater, ViewGroup container)
    {
        mView = inflater.inflate(R.layout.layout, container, false);
    }
}

