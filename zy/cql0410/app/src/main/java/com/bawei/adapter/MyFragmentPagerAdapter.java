package com.bawei.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.bawei.fragment.MyFragment;

import java.util.List;

/**
 * 作者:程千浪
 * .时间：2017/4/10 18:51
 * 类用途：
 */

public class MyFragmentPagerAdapter extends FragmentPagerAdapter {
    private List<String>mList;
    private List<String>mUrl;

    public MyFragmentPagerAdapter(FragmentManager fm, List<String> list, List<String> url) {
        super(fm);
        mList = list;
        mUrl = url;
    }

    @Override
    public Fragment getItem(int position) {
        return MyFragment.getFragment(mUrl.get(position));
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mList.get(position%mList.size()).toUpperCase();
    }
}
