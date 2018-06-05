package com.meizu.lipan.androiddemo.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by lipan on 18-6-6.
 */

public class CanvasView extends View {

    private Paint mPaint;

    public CanvasView(Context context) {
        super(context);
        init(null, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public CanvasView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(attrs, defStyleAttr);
    }

    private void init(AttributeSet attrs, int defStyle) {


        mPaint = new Paint();
        mPaint.setAntiAlias(true); //设置是否抗锯齿;
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE); //设置填充样式
        mPaint.setColor(Color.GREEN);//设置画笔颜色
        mPaint.setStrokeWidth(2);//设置画笔宽度
        //mPaint.setShadowLayer(10,15,15,Color.RED);//设置阴影
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawLine(canvas);

        drawLines(canvas);

        drawRect(canvas);

        //drawCircle(canvas);

        drawArc(canvas);
    }

    /**
     *  画直线
     *  startX ： 开始点X坐标
        startY ： 开始点Y坐标
        stopX ： 结束点X坐标
        stopY ： 结束点Y坐标
     * @param canvas
     */
    public void drawLine(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.parseColor("#FF0000"));
        canvas.drawLine(100,100,600,600, mPaint);
    }

    //多条直线
    //pts : 是点的集合且大小最小为4而且是2的倍数。表示每2个点连接形成一条直线，pts 的组织方式为{x1,y1,x2,y2….}
    //offset : 集合中跳过的数值个数，注意不是点的个数！一个点是两个数值
    //count : 参与绘制的数值的个数，指pts[]里数值个数，而不是点的个数，因为一个点是两个数值
    public void drawLines(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(10);
        mPaint.setColor(Color.parseColor("#FF00FF"));
        float [] pts={50,50,200,200,400,400,600,600};
        //点（50，50）和点（200，200）连接成一条直线；
        // 点（400，400）和点（600，600）连接成直线
        canvas.drawLines(pts, mPaint);

        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(20);
        float [] pts1 ={50,50,200,200,400,400,600,600};
        //表示从第二个50开始连续的4个点（50，200，200，400）连接的直线
        canvas.drawLines(pts1,1,4,mPaint);
    }

    //绘制矩形
    public void drawRect(Canvas canvas) {
        //RectF ： 绘制的矩形
        //rx ： 生成圆角的椭圆X轴半径
        //ry ： 生成圆角的椭圆Y轴的半径

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(3);
        RectF rectF = new RectF(300f, 50f, 650f, 200f);
        canvas.drawRoundRect(rectF, 10 , 10 ,mPaint);

        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(5);
        rectF.offsetTo(300, 300);
        canvas.drawRect(rectF, mPaint);
    }

    public void drawCircle(Canvas canvas) {
        canvas.drawCircle(600,900,300, mPaint);
    }


    /**
     * oval ： 生成椭圆的矩形
     startAngle ： 弧开始的角度 （X轴正方向为0度，顺时针弧度增大）
     sweepAngle ： 绘制多少弧度 （注意不是结束弧度）
     useCenter ： 是否有弧的两边 true有两边 false无两边
     * @param canvas
     */
    public void drawArc(Canvas canvas) {
        mPaint.setStyle(Paint.Style.FILL);
        RectF rect=new RectF(100,100,800,600);
        canvas.drawArc(rect,0,90,false,mPaint);

        RectF rf=new RectF(100,600,800,1100);
        canvas.drawArc(rf,0,90,true,mPaint);

        mPaint.setStyle(Paint.Style.STROKE);
        RectF rect1=new RectF(300,300,900,700);
        canvas.drawArc(rect1,0,90,false,mPaint);

        RectF rf1=new RectF(100,1100,900,1500);
        canvas.drawArc(rf1,0,20,true,mPaint);

    }

}
