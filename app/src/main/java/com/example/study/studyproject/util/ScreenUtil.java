package com.example.study.studyproject.util;

import android.content.Context;

/**
 * @autho：liuyulong on 2015/9/24 14:35
 */
public class ScreenUtil {

    /**
     * 返回头部高度
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen","android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }
}
