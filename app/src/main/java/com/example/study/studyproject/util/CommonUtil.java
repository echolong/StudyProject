package com.example.study.studyproject.util;

import android.text.TextUtils;

/**
 * Created by liuyulong on 15/11/14.
 * 公共类库
 */
public class CommonUtil {

    public static boolean isEmpty(String str){
        return str == null || str == "" ||  TextUtils.isEmpty(str);
    }
}
