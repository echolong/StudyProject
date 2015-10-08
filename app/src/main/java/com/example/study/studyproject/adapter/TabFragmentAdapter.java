package com.example.study.studyproject.adapter;


import android.app.Fragment;
import android.app.FragmentManager;

import java.util.ArrayList;

/**
 * Description:
 * User: xjp
 * Date: 2015/6/15
 * Time: 15:12
 */

public class TabFragmentAdapter extends FragmentStatePagerAdapter {

    private ArrayList<Fragment> mFragments;
    private ArrayList<String> mTitles;

    public TabFragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragments, ArrayList<String> titles) {
        super(fm);
        mFragments = fragments;
        mTitles = titles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles.get(position);
    }


}
