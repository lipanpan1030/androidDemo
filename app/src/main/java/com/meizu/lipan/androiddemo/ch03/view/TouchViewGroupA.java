package com.meizu.lipan.androiddemo.ch03.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

/**
 * Created by lipan on 18-5-28.
 */

public class TouchViewGroupA extends ViewGroup {
    public TouchViewGroupA(Context context) {
        super(context);
    }

    public TouchViewGroupA(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewGroupA(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d("TouchViewGroupA dispatchTouchEvent " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("TouchViewGroupA onTouchEvent " + event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d("TouchViewGroupA onInterceptTouchEvent  " + ev);
        return super.onInterceptTouchEvent(ev);
    }
}
