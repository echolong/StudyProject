package com.example.study.studyproject.ui;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.study.studyproject.util.ScreenUtil;

public class BaseActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 设置沉浸式
     * @param view
     */
    protected void setImmerse(View view){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            int top = ScreenUtil.getStatusBarHeight(this);
            view.setPadding(0,top,0,0);
        }
    }
}
