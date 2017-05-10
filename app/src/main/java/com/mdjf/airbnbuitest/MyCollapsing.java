package com.mdjf.airbnbuitest;

import android.content.Context;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/4/14.
 */

public class MyCollapsing extends CollapsingToolbarLayout{
    public MyCollapsing(Context context) {
        super(context);
    }

    public MyCollapsing(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyCollapsing(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void onStopNestedScroll(View child) {
        super.onStopNestedScroll(child);
    }
}
