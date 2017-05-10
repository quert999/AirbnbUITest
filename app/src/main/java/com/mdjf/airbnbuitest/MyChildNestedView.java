package com.mdjf.airbnbuitest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingChild;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Administrator on 2017/4/21.
 */

public class MyChildNestedView extends LinearLayout implements NestedScrollingChild{
    public MyChildNestedView(Context context) {
        this(context,null);
    }

    public MyChildNestedView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyChildNestedView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public void setNestedScrollingEnabled(boolean enabled) {

    }

    @Override
    public boolean isNestedScrollingEnabled() {
        return false;
    }

    @Override
    public boolean startNestedScroll(int axes) {
        return false;
    }

    @Override
    public void stopNestedScroll() {

    }

    @Override
    public boolean hasNestedScrollingParent() {
        return false;
    }

    @Override
    public boolean dispatchNestedScroll(int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int[] offsetInWindow) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreScroll(int dx, int dy, int[] consumed, int[] offsetInWindow) {
        return false;
    }

    @Override
    public boolean dispatchNestedFling(float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean dispatchNestedPreFling(float velocityX, float velocityY) {
        return false;
    }
}
