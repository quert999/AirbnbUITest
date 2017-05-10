package com.mdjf.airbnbuitest;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    View collapsed_container,collapsed_container_inner;
    View conBg,navBtm,navBg;
    View con1,con2,con3;
    TextView tv1,tv2,tv3,nav1,nav2,nav3,nav4,tv_collapsed;
    boolean nowBlue = true;
    int eachHeight;
    ValueAnimator[] animArr2White;
    ValueAnimator[] animArr2Blue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        collapsed_container = findViewById(R.id.collapsed_container);
        collapsed_container_inner = findViewById(R.id.collapsed_container_inner);
        conBg = findViewById(R.id.conBg);
        con1 = findViewById(R.id.con1);
        con2 = findViewById(R.id.con2);
        con3 = findViewById(R.id.con3);
        navBtm = findViewById(R.id.navBtm);
        navBg = findViewById(R.id.navBg);
        nav1 = (TextView) findViewById(R.id.nav1);
        nav2 = (TextView) findViewById(R.id.nav2);
        nav3 = (TextView) findViewById(R.id.nav3);
        nav4 = (TextView) findViewById(R.id.nav4);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        tv3 = (TextView) findViewById(R.id.tv3);
        tv_collapsed = (TextView) findViewById(R.id.tv_collapsed);
        con3.postDelayed(new Runnable() {
            @Override
            public void run() {
                eachHeight = con3.getMeasuredHeight();
            }
        },50);

        ((AppBarLayout) findViewById(R.id.abl)).addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                System.out.println("当前偏移量：" + verticalOffset);
                //移动到上方时使用另外一个view来和下方一起移动
                if (verticalOffset <= -320 && collapsed_container.getVisibility() == View.GONE){
                    collapsed_container.setVisibility(View.VISIBLE);
                }
                if (verticalOffset > -320 && collapsed_container.getVisibility() == View.VISIBLE){
                    collapsed_container.setVisibility(View.GONE);
                }
                //移动到上方时使用另外一个view来和下方一起移动

                if (verticalOffset == 0){
                    con3.setAlpha(1);
                    con2.setAlpha(1);
                }else if(verticalOffset >= -eachHeight){
                    con3.setAlpha(1);
                    con3.setAlpha((eachHeight+verticalOffset*1F)/eachHeight);
                }else if(verticalOffset >= -eachHeight*2){
                    con3.setAlpha(0);
                    con2.setAlpha((eachHeight*2+verticalOffset*1F)/eachHeight);
                }


                if (nowBlue && verticalOffset <= -350){
                    nowBlue = false;
                    setBlue(false);
                }

                if (!nowBlue && verticalOffset > -200){
                    nowBlue = true;
                    setBlue(true);
                }
            }
        });



    }


    protected int dp2px(int dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, getResources().getDisplayMetrics());
    }

    private void setBlue(boolean isBlue){
        if (animArr2White == null){
            animArr2White = new ValueAnimator[16];

            animArr2White[0] = ObjectAnimator.ofInt(tv1,"textColor",0xffffffff,0xff333333);
            animArr2White[1] = ObjectAnimator.ofInt(tv2,"textColor",0xffffffff,0xff333333);
            animArr2White[2] = ObjectAnimator.ofInt(tv3,"textColor",0xffffffff,0xff333333);
            animArr2White[3] = ObjectAnimator.ofInt(nav1,"textColor",0xffffffff,0xff008186);
            animArr2White[4] = ObjectAnimator.ofInt(nav2,"textColor",0xffffffff,0xff333333);
            animArr2White[5] = ObjectAnimator.ofInt(nav3,"textColor",0xffffffff,0xff333333);
            animArr2White[6] = ObjectAnimator.ofInt(nav4,"textColor",0xffffffff,0xff333333);
            animArr2White[7] = ObjectAnimator.ofInt(navBg,"backgroundColor",0xff008186,0xffffffff);
            animArr2White[8] = ObjectAnimator.ofInt(conBg,"backgroundColor",0xff008186,0xffffffff);
            animArr2White[9] = ObjectAnimator.ofInt(navBtm,"backgroundColor",0xffffffff,0xff008186);
            animArr2White[10] = ObjectAnimator.ofInt(con1,"backgroundColor",0xff2f9a9e,0xffeeeeee);
            animArr2White[11] = ObjectAnimator.ofInt(con2,"backgroundColor",0xff2f9a9e,0xffeeeeee);
            animArr2White[12] = ObjectAnimator.ofInt(con3,"backgroundColor",0xff2f9a9e,0xffeeeeee);
            animArr2White[13] = ObjectAnimator.ofInt(collapsed_container,"backgroundColor",0xff008186,0xffffffff);
            animArr2White[14] = ObjectAnimator.ofInt(collapsed_container_inner,"backgroundColor",0xff2f9a9e,0xffeeeeee);
            animArr2White[15] = ObjectAnimator.ofInt(tv_collapsed,"textColor",0xffffffff,0xff333333);

            TypeEvaluator colorEvaluator = new ArgbEvaluator();
            for (int i = 0; i < animArr2White.length; i++) {
                animArr2White[i].setEvaluator(colorEvaluator);
                animArr2White[i].setDuration(300);
            }
        }
        if (animArr2Blue == null){
            animArr2Blue = new ValueAnimator[16];

            animArr2Blue[0] = ObjectAnimator.ofInt(tv1,"textColor",0xff333333,0xffffffff);
            animArr2Blue[1] = ObjectAnimator.ofInt(tv2,"textColor",0xff333333,0xffffffff);
            animArr2Blue[2] = ObjectAnimator.ofInt(tv3,"textColor",0xff333333,0xffffffff);
            animArr2Blue[3] = ObjectAnimator.ofInt(nav1,"textColor",0xff008186,0xffffffff);
            animArr2Blue[4] = ObjectAnimator.ofInt(nav2,"textColor",0xff333333,0xffffffff);
            animArr2Blue[5] = ObjectAnimator.ofInt(nav3,"textColor",0xff333333,0xffffffff);
            animArr2Blue[6] = ObjectAnimator.ofInt(nav4,"textColor",0xff333333,0xffffffff);
            animArr2Blue[7] = ObjectAnimator.ofInt(navBg,"backgroundColor",0xffffffff,0xff008186);
            animArr2Blue[8] = ObjectAnimator.ofInt(conBg,"backgroundColor",0xffffffff,0xff008186);
            animArr2Blue[9] = ObjectAnimator.ofInt(navBtm,"backgroundColor",0xff008186,0xffffffff);
            animArr2Blue[10] = ObjectAnimator.ofInt(con1,"backgroundColor",0xffeeeeee,0xff2f9a9e);
            animArr2Blue[11] = ObjectAnimator.ofInt(con2,"backgroundColor",0xffeeeeee,0xff2f9a9e);
            animArr2Blue[12] = ObjectAnimator.ofInt(con3,"backgroundColor",0xffeeeeee,0xff2f9a9e);
            animArr2Blue[13] = ObjectAnimator.ofInt(collapsed_container,"backgroundColor",0xffffffff,0xff008186);
            animArr2Blue[14] = ObjectAnimator.ofInt(collapsed_container_inner,"backgroundColor",0xffeeeeee,0xff2f9a9e);
            animArr2Blue[15] = ObjectAnimator.ofInt(tv_collapsed,"textColor",0xff333333,0xffffffff);

            TypeEvaluator colorEvaluator = new ArgbEvaluator();
            for (int i = 0; i < animArr2Blue.length; i++) {
                animArr2Blue[i].setEvaluator(colorEvaluator);
                animArr2Blue[i].setDuration(300);
            }
        }

        if (isBlue){
            for (int i = 0; i < animArr2White.length; i++) {
                animArr2White[i].cancel();
            }
            for (int i = 0; i < animArr2Blue.length; i++) {
                animArr2Blue[i].start();
            }
        }else{
            for (int i = 0; i < animArr2Blue.length; i++) {
                animArr2Blue[i].cancel();
            }
            for (int i = 0; i < animArr2White.length; i++) {
                animArr2White[i].start();
            }
        }
    }
}
