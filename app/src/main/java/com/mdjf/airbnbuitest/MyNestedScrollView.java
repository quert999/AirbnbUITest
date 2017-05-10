package com.mdjf.airbnbuitest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.view.NestedScrollingParent;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

public class MyNestedScrollView extends LinearLayout implements NestedScrollingParent{
    private int mTopViewHeight;
    private NestedScrollView nsv;
    public MyNestedScrollView(Context context) {
        this(context,null);
    }

    public MyNestedScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyNestedScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return true;
    }

    @Override
    public void onNestedScrollAccepted(View child, View target, int nestedScrollAxes) {

    }

    @Override
    public void onStopNestedScroll(View target) {

    }

    @Override
    public void onNestedScroll(View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed) {

    }

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        int curScrollY = getScrollY();
        boolean hiddenTop = dy > 0 && curScrollY < mTopViewHeight;
        boolean showTop = dy < 0 && curScrollY >= 0 && !ViewCompat.canScrollVertically(target, -1);

        System.out.println("nsv：" + nsv.getMeasuredHeight() + ",linearHeight=" + getMeasuredHeight());
        if (hiddenTop || showTop) {
            scrollBy(0, dy);
            consumed[1] = dy;
        }
    }

    @Override
    public boolean onNestedFling(View target, float velocityX, float velocityY, boolean consumed) {
        return false;
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        return false;
    }

    @Override
    public int getNestedScrollAxes() {
        return 0;
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mTopViewHeight = getChildAt(0).getMeasuredHeight();
        System.out.println("头部高度：" + mTopViewHeight);

        nsv = (NestedScrollView) findViewById(R.id.nsv);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        View v1 = getChildAt(0);
        View v2 = getChildAt(1);
        View v3 = getChildAt(2);
        getChildAt(2).getLayoutParams().height = getMeasuredHeight() - getChildAt(1).getMeasuredHeight();
        setMeasuredDimension(getMeasuredWidth(),v1.getMeasuredHeight()+v2.getMeasuredHeight()+v3.getMeasuredHeight());
    }

    @Override
    public void scrollTo(int x, int y)
    {
        if (y < 0)
        {
            y = 0;
        }
        if (y > mTopViewHeight)
        {
            y = mTopViewHeight;
        }
        if (y != getScrollY())
        {
            super.scrollTo(x, y);
        }
        View head = getChildAt(0);
        if (head != null) {
            head.scrollTo(0, (int) -(y*0.5));
        }
    }
}
