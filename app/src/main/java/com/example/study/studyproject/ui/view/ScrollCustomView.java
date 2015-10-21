package com.example.study.studyproject.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.study.studyproject.R;

/**
 * @autho：liuyulong on 2015/9/23 09:26
 */
public class ScrollCustomView extends View {

    //第一圈的颜色
    private int firstColor;
    //第二圈颜色
    private int secondColor;
    //宽度
    private int widthValue;
    //每一圈的时间
    private float speedValue;

    private Paint mPanit;

    private boolean isFirst = true;
    private int mProcess = 0;
    public ScrollCustomView(Context context) {
        this(context, null);
    }

    public ScrollCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ScrollCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(attrs, defStyleAttr);
    }

    private void initView(AttributeSet attrs, int defStyleAttr) {
        TypedArray typed = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.ScrollCustomView, defStyleAttr, 0);

        int n = typed.getIndexCount();
        for (int i = 0; i < n; i++) {
            int attr = typed.getIndex(i);
            switch (attr) {
                case R.styleable.ScrollCustomView_firstColor:
                    firstColor = typed.getColor(attr, Color.RED);
                    break;
                case R.styleable.ScrollCustomView_secondColor:
                    secondColor = typed.getColor(attr, Color.BLUE);
                    break;
                case R.styleable.ScrollCustomView_speed:
                    speedValue = typed.getFloat(attr, 3);
                    break;
                case R.styleable.ScrollCustomView_widthValue:
                    widthValue = typed.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 3, getResources().getDisplayMetrics()));
                    break;
            }
        }
        typed.recycle();
        mPanit = new Paint();
        new Thread(){
            @Override
            public void run() {
                super.run();
                while (true){
                    mProcess++;
                    if(mProcess == 360){
                        mProcess = 0;
                        isFirst = !isFirst;
                    }
                    postInvalidate();
                    try {
                        Thread.sleep((long) (speedValue*1000/360));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }.start();

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        int center = getWidth()/2;
        int radius = center - widthValue/2;

        mPanit.setStrokeWidth(widthValue);
        mPanit.setAntiAlias(true);
        mPanit.setStyle(Paint.Style.STROKE);

        RectF oval = new RectF(center-radius,center-radius,center+radius,center+radius);
        if(isFirst){
            mPanit.setColor(firstColor);
            canvas.drawCircle(center, center, radius, mPanit);
            mPanit.setColor(secondColor);
            canvas.drawArc(oval,-90,mProcess,false,mPanit);
        }else{
            mPanit.setColor(secondColor);
            canvas.drawCircle(center,center,radius,mPanit);
            mPanit.setColor(firstColor);
            canvas.drawArc(oval,-90,mProcess,false,mPanit);
        }
    }
}
