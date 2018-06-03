package com.meizu.lipan.androiddemo.ch03.activity.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;

import com.orhanobut.logger.Logger;

/**
 * Created by lipan on 18-5-28.
 */

public class TouchViewGroupB extends ViewGroup {
    public TouchViewGroupB(Context context) {
        super(context);
    }

    public TouchViewGroupB(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TouchViewGroupB(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        Logger.d("TouchViewGroupB dispatchTouchEvent " + ev);
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Logger.d("TouchViewGroupB onTouchEvent " + event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        Logger.d("TouchViewGroupB onInterceptTouchEvent  " + ev);
        return super.onInterceptTouchEvent(ev);
    }
}
