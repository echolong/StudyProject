package com.example.study.studyproject.ui.view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * @author：liuyulong on 2015/10/21 17:37
 */
public class AutoNestedScrollView extends NestedScrollView {
    public AutoNestedScrollView(Context context) {
        super(context);
    }

    public AutoNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public AutoNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
