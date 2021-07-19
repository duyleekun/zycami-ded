/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.MotionEvent
 */
package com.zhiyun.cama.main.home;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.viewpager.widget.ViewPager;

public class ExViewPager
extends ViewPager {
    public ExViewPager(Context context) {
        super(context);
    }

    public ExViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public void setCurrentItem(int n10) {
        super.setCurrentItem(n10, false);
    }

    public void setCurrentItem(int n10, boolean bl2) {
        super.setCurrentItem(n10, false);
    }
}

