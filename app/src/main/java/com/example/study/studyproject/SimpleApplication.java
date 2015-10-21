package com.example.study.studyproject;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * @autho：liuyulong on 2015/10/12 10:41
 */
public class SimpleApplication extends Application {

    public static RequestQueue mQuene;

    @Override
    public void onCreate() {
        super.onCreate();
        mQuene = Volley.newRequestQueue(this);
    }
}
