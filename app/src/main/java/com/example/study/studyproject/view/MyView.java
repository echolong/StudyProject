package com.example.study.studyproject.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import com.example.study.studyproject.R;

/**
 * TODO: document your custom view class.
 */
public class MyView extends View {

    private String mTextString;
    private int mTextColor;
    private int mTextSize;

    private Paint mPaint;
    private Rect mRect;

    public MyView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        TypedArray typedArray = getContext().getTheme().obtainStyledAttributes(attrs, R.styleable.FirstView, defStyle, 0);
        int length = typedArray.getIndexCount();
        for (int i = 0; i < length; i++) {
            int type = typedArray.getIndex(i);
            if (type == R.styleable.FirstView_textColor) {
                mTextColor = typedArray.getColor(type, Color.RED);
            } else if (type == R.styleable.FirstView_textSize) {
                mTextSize = typedArray.getDimensionPixelSize(type, (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_PX, 20, getResources().getDisplayMetrics()));
            } else if (type == R.styleable.FirstView_textString) {
                mTextString = typedArray.getString(type);
            }
        }

        typedArray.recycle();

        mPaint = new Paint();
        mPaint.setTextSize(mTextSize);

        mRect = new Rect();
        mPaint.getTextBounds(mTextString, 0, mTextString.length(), mRect);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthValue = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightValue = MeasureSpec.getSize(heightMeasureSpec);
        int width, height;
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthValue;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTextString, 0, mTextString.length(), mRect);
            float textwidth = mRect.width();
            int allWidth = (int) (getPaddingLeft() + getPaddingRight() + textwidth);
            width = allWidth;
        }
        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightValue;
        } else {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mTextString, 0, mTextString.length(), mRect);
            float textHeight = mRect.height();
            int allHeight = (int) (getPaddingTop() + getPaddingBottom() + textHeight);
            height = allHeight;
        }
        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        mPaint.setColor(Color.YELLOW);
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        canvas.drawText(mTextString, getWidth() / 2 - mRect.width() / 2, getHeight() / 2 + mRect.height() / 2, mPaint);
    }
}
