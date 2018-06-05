package com.meizu.lipan.androiddemo.draw;

import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.meizu.lipan.androiddemo.R;

public class PaintDemoActivity extends AppCompatActivity {

    private Paint mPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint_demo);
        init();

    }



    private void init() {
        mPaint = new Paint();
        mPaint.setAntiAlias(true); //设置是否抗锯齿;
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); //设置填充样式
        mPaint.setColor(Color.GREEN);//设置画笔颜色
        mPaint.setStrokeWidth(2);//设置画笔宽度
        mPaint.setShadowLayer(10,15,15,Color.RED);//设置阴影
    }
}
