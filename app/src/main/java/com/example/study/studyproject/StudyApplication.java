package com.example.study.studyproject;

import android.app.Application;

/**
 * Created by liuyulong on 15/11/14.
 */
public class StudyApplication extends Application {

    private static StudyApplication app;

    public static  StudyApplication getInstance(){
        return app;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
    }
}
