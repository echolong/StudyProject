package com.example.study.studyproject.util;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.study.studyproject.StudyApplication;

import java.util.HashMap;

/**
 * Created by liuyulong on 15/11/14.
 * 操作sharedPreference的公共类库
 */
public class SharedPreferencesManager {

    private static String TAG = "com.example.study.studyproject";
    private HashMap shareMap = new HashMap();
    private static SharedPreferencesManager gInstance;
    private SharedPreferences shared;

    public static synchronized SharedPreferencesManager getInstance() {
        if(gInstance == null){
            gInstance = new SharedPreferencesManager();
        }
        return gInstance;
    }

    public SharedPreferencesManager() {
        StudyApplication app = StudyApplication.getInstance();
        shared = app.getSharedPreferences(TAG, Context.MODE_PRIVATE);
    }

    /**
     * 保存字符串
     *
     * @param key   key值
     * @param value
     */
    public void saveString(String key, String value) {
        shared.edit().putString(key, value).apply();
    }

    /**
     * 获取字符串
     *
     * @param key
     * @param defaultValue
     * @return
     */
    public String getString(String key, String defaultValue) {
        return shared.getString(key, defaultValue);
    }

    /**
     * 移除key值
     *
     * @param key
     */
    public void removeKey(String key) {
        shared.edit().remove(key).apply();
    }

    /**
     * 清除全部信息
     */
    public void clearShared() {
        shared.edit().clear().apply();
    }
}
