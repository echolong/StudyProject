package com.example.study.studyproject.ui;

import android.annotation.TargetApi;
import android.app.Fragment;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.study.studyproject.R;
import com.example.study.studyproject.adapter.TabFragmentAdapter;
import com.example.study.studyproject.fragment.TabFragment;

import java.util.ArrayList;

public class CustomCoordinatorActivity extends BaseActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private FloatingActionButton mFab;

    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_coordinator);

        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mFab = (FloatingActionButton) findViewById(R.id.fab);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        mFab.setOnClickListener(this);

        initData();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void initData() {

        ArrayList<String> tabList = new ArrayList<>();
        tabList.add("Tab1");
        tabList.add("Tab2");
        tabList.add("Tab3");

        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(0)));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(tabList.get(2)));

        ArrayList<Fragment> viewList = new ArrayList<>();

        for (int i = 0; i < tabList.size(); i++) {
            Fragment f1 = new TabFragment();
            Bundle bundle = new Bundle();
            bundle.putString("content", "http://blog.csdn.net/feiduclear_up \n CSDN 废墟的树");
            f1.setArguments(bundle);
            viewList.add(f1);
        }

        TabFragmentAdapter fragmentAdapter = new TabFragmentAdapter(getFragmentManager(), viewList, tabList);
        viewPager.setAdapter(fragmentAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(viewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(fragmentAdapter);//给Tabs设置适配器

        mToolbar.setLogo(R.mipmap.ic_launcher);
        mToolbar.setLogoDescription("齐鲁壹点");

        mToolbar.setNavigationIcon(R.mipmap.small_logo);
        mToolbar.setNavigationContentDescription("测试");
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CustomCoordinatorActivity.this, "HHHHHH", Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fab:
                Snackbar.make(v, "FAB", Snackbar.LENGTH_LONG).setAction("cancel", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }).show();
                break;
        }
    }
}
