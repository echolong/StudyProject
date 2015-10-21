package com.example.study.studyproject.ui.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * @author：liuyulong on 2015/10/19 14:22
 */
public class LEDTextView extends TextView {

    public LEDTextView(Context context) {
        super(context);
        initView();
    }

    public LEDTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public LEDTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    private void initView() {
        AssetManager assets = getContext().getAssets();
        final Typeface type = Typeface.createFromAsset(assets, "fonts/digital-7.ttf");
        setTypeface(type);
    }

}
