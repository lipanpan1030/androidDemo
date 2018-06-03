package com.meizu.lipan.androiddemo.spannable;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import android.util.Log;

import com.meizu.lipan.androiddemo.tools.Constant;


/**
 * Created by lipan on 18-5-17.
 */

public class RadiusBackgroundSpan extends ReplacementSpan {

    private int mBgColor;
    private int mRadius;
    private float mTextWidth;
    private Paint mTextPaint;//文本画笔
    private Paint mBgPaint; //背景画笔
    private int mBgWidth;//背景宽度
    private int mBgHeight;//背景高度

    private int mTextSize;//文字大小

    /**
     * @param bgColor  背景颜色
     * @param bgRadius 圆角半径
     */
    public RadiusBackgroundSpan(int bgColor, int bgRadius,
                                int bgWidth, int bgHeight,
                                int textSize) {
        mBgColor = bgColor;
        mRadius = bgRadius;
        mBgWidth = bgWidth;
        mBgHeight = bgHeight;
        mTextSize = textSize;
        Log.d(Constant.TAG, "mBgWidth:" + mBgWidth +
            "mBgHeight:" + mBgHeight);
        initPaint();
    }

    /**
     * 初始化画笔
     */
    private void initPaint() {
        //初始化背景画笔
        mBgPaint = new Paint();
        mBgPaint.setColor(mBgColor);
        mBgPaint.setStyle(Paint.Style.FILL);
        mBgPaint.setAntiAlias(true);

        //初始化文字画笔
        mTextPaint = new TextPaint();
        mTextPaint.setColor(Color.RED);
        mTextPaint.setTextSize(mTextSize);
        mTextPaint.setAntiAlias(true);
    }

    @Override
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        mTextWidth = mTextPaint.measureText(text, start, end);
        return mBgWidth;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        Paint.FontMetrics fm = paint.getFontMetrics();

        float textHeight = fm.descent - fm.ascent;
        Log.d(Constant.TAG,  "x:" + x + "y:" + y  +
                ",textHeight:" + textHeight +
                ",fm.descent:" + fm.descent +
                ",fm.ascent:" + fm.ascent);

        RectF oval = new RectF(x, y - textHeight,
                x + mBgWidth, y -textHeight + mBgHeight);
        canvas.drawRoundRect(oval, mRadius, mRadius, mBgPaint);

        float textY = y + fm.descent / 2;
        float textX = x + (mBgWidth - mTextWidth) / 2;
        Log.d(Constant.TAG, "mTextWidth:" + mTextWidth);
        canvas.drawText(text, start, end, textX, textY, mTextPaint);//绘制文字
    }
}
