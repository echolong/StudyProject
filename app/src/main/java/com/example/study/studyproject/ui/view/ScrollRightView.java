package com.example.study.studyproject.ui.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * @autho：liuyulong on 2015/9/23 13:55
 * @ http://blog.csdn.net/zhaokaiqiang1992/article/details/48470305
 */
public class ScrollRightView extends View {

    private long mCircleTime = 2000;
    private float mCircleValue;
    //画圆动画
    private ValueAnimator mCircleAnimator;
    private ValueAnimator mStartAnimator;
    private ValueAnimator mEndAnimator;

    public ScrollRightView(Context context) {
        super(context);
    }

    public ScrollRightView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollRightView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化动画
     */
    private void initAnimator() {
        mStartAnimator = ValueAnimator.ofFloat(0.0F, 1.0F);
        mEndAnimator = ValueAnimator.ofFloat(0.0F, 1.0F);
        mCircleAnimator = ValueAnimator.ofFloat(0.0F, 1.0F);

        mStartAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });


        mEndAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {

            }
        });

        mCircleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        mCircleAnimator.setRepeatCount(-1);
        mCircleAnimator.setDuration(mCircleTime);

        mCircleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float value = (float) animation.getAnimatedValue();
                setCircleValue(value);
            }
        });
    }

    //更新页面显示
    private void setCircleValue(float value) {
        this.mCircleValue = value;
        invalidate();
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);
    }

    private void drawCircle(Canvas canvas) {

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public enum ProgessType {
        Success, Fail, Progressing
    }
}
