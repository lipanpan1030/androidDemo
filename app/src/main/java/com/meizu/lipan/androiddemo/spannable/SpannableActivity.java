package com.meizu.lipan.androiddemo.spannable;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.view.View;
import android.widget.TextView;

import com.meizu.lipan.androiddemo.R;

public class SpannableActivity extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spannable);

        textView1 = findViewById(R.id.text1);
        String text = "倒计时 4 天 23 小时 55 分 9 秒";
        String text1 = "4";
        String text2 = "23";
        String text3 = "55";
        String text4 = "9";

        int dayStart = text.indexOf(text1 + " 天");
        int dayEnd = dayStart + text1.length();

        int hourStart = text.indexOf(text2 + " 小时");
        int houEnd = hourStart + text2.length();

        int minStart = text.indexOf(text3 + " 分");
        int minEnd = minStart + text3.length();

        int secStart = text.indexOf(text4 + " 秒");
        int secEnd = secStart + text4.length();

        int bgRadius = getResources().getDimensionPixelOffset(R.dimen.bg_radius);
        int bgSize = getResources().getDimensionPixelOffset(R.dimen.bg_size);
        int textSize = getResources().getDimensionPixelSize(R.dimen.text_size);
        SpannableStringBuilder mBuilder = new SpannableStringBuilder();
        mBuilder.append(text);

        IconTextSpan topSpan = new IconTextSpan(
                getApplicationContext(), R.color.colorPrimary, text1);

        RadiusBackgroundSpan backgroundSpan1 = new RadiusBackgroundSpan(
                0xFFC4AF80, bgRadius, bgSize, bgSize, textSize);
        RadiusBackgroundSpan backgroundSpan2 = new RadiusBackgroundSpan(
                0xFFC4AF80, bgRadius, bgSize, bgSize, textSize);
        RadiusBackgroundSpan backgroundSpan3 = new RadiusBackgroundSpan(
                0xFFC4AF80, bgRadius, bgSize, bgSize, textSize);
        RadiusBackgroundSpan backgroundSpan4 = new RadiusBackgroundSpan(
                0xFFC4AF80, bgRadius, bgSize, bgSize, textSize);
        mBuilder.setSpan(backgroundSpan1, dayStart, dayEnd,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mBuilder.setSpan(backgroundSpan2, hourStart, houEnd,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mBuilder.setSpan(backgroundSpan3, minStart, minEnd,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        mBuilder.setSpan(backgroundSpan4, secStart, secEnd,
                Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        textView1.setText(mBuilder);


        // 启动文本周围的动画
        textView2 = findViewById(R.id.text2);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startAnimation(textView2);
            }
        });
    }

    private void startAnimation(TextView textView) {
        Drawable[] drawables = textView.getCompoundDrawables();
        for (Drawable drawable : drawables) {
            if (drawable != null && drawable instanceof Animatable) {
                ((Animatable) drawable).start();
            }
        }
    }

}
