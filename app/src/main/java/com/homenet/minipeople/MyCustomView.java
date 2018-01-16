package com.homenet.minipeople;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;

/**
 * Description:自定义控件View User: xjp Date: 2015/5/27 Time: 14:50
 */
/**
 * Created by weijunpeng on 2018/1/6.
 */

public class MyCustomView extends ImageView {

    private String titleText = "Hello world";

    private int titleColor = Color.BLACK;
    static int titleBackgroundColor = Color.WHITE;
    private int titleSize = 16;

    private Paint mPaint;
    private Rect mBound;

    public MyCustomView(Context context) {
        this(context, null);
    }

    public MyCustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyCustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        final Resources.Theme theme = context.getTheme();
        TypedArray a = theme.obtainStyledAttributes(attrs,
                R.styleable.MyCustomView, defStyleAttr, 0);
        if (null != a) {
            int n = a.getIndexCount();
            for (int i = 0; i < n; i++) {
                int attr = a.getIndex(i);
                switch (attr) {
                    case R.styleable.MyCustomView_titleColor:
                        titleColor = a.getColor(attr, Color.BLACK);
                        break;
                    case R.styleable.MyCustomView_titleSize:
                        titleSize = a.getDimensionPixelSize(attr, titleSize);
                        break;
                    case R.styleable.MyCustomView_titleText:
                        titleText = a.getString(attr);
                        break;
                    case R.styleable.MyCustomView_titleBackgroundColor:
                        titleBackgroundColor = a.getColor(attr, Color.WHITE);
                        break;
                }
            }
            a.recycle();
            init();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int x = (int) event.getX();
        final int y = (int) event.getY();
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            // 填色
            // fillColorToSameArea(x, y);
        }

        return super.onTouchEvent(event);
    }

    /**
     * 初始化
     */
    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setTextSize(titleSize);
        /**
         * 得到自定义View的titleText内容的宽和高
         */
        mBound = new Rect();
        mPaint.getTextBounds(titleText, 0, titleText.length(), mBound);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(titleBackgroundColor);
        canvas.drawCircle(getWidth() / 2f, getWidth() / 2f, getWidth() / 2f,
                mPaint);
        mPaint.setColor(titleColor);
        canvas.drawText(titleText, getWidth() / 2 - mBound.width() / 2,
                getHeight() / 2 + mBound.height() / 2, mPaint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        /**
         * 测量模式
         */
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        /**
         * 父布局希望子布局的大小,如果布局里面设置的是固定值,这里取布局里面的固定值和父布局大小值中的最小值.
         * 如果设置的是match_parent,则取父布局的大小
         */
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int width;
        int height;
        Rect mBounds = new Rect();
        if (widthMode == MeasureSpec.EXACTLY) {
            width = widthSize;
        } else {
            mPaint.setTextSize(titleSize);
            mPaint.getTextBounds(titleText, 0, titleText.length(), mBounds);
            float textWidth = mBounds.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY) {
            height = heightSize;
        } else {

            height = width;
        }
        /**
         * 最后调用父类方法,把View的大小告诉父布局。
         */
        setMeasuredDimension(width, height);

    }
}