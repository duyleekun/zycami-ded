/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.view.animation.AnimationUtils
 *  android.view.animation.Interpolator
 *  android.widget.LinearLayout$LayoutParams
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import com.google.android.material.R$styleable;

public class AppBarLayout$LayoutParams
extends LinearLayout.LayoutParams {
    public static final int COLLAPSIBLE_FLAGS = 10;
    public static final int FLAG_QUICK_RETURN = 5;
    public static final int FLAG_SNAP = 17;
    public static final int SCROLL_FLAG_ENTER_ALWAYS = 4;
    public static final int SCROLL_FLAG_ENTER_ALWAYS_COLLAPSED = 8;
    public static final int SCROLL_FLAG_EXIT_UNTIL_COLLAPSED = 2;
    public static final int SCROLL_FLAG_SCROLL = 1;
    public static final int SCROLL_FLAG_SNAP = 16;
    public static final int SCROLL_FLAG_SNAP_MARGINS = 32;
    public int scrollFlags = 1;
    public Interpolator scrollInterpolator;

    public AppBarLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
    }

    public AppBarLayout$LayoutParams(int n10, int n11, float f10) {
        super(n10, n11, f10);
    }

    public AppBarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.AppBarLayout_Layout;
        attributeSet = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.AppBarLayout_Layout_layout_scrollFlags;
        this.scrollFlags = n10 = attributeSet.getInt(n10, 0);
        n10 = R$styleable.AppBarLayout_Layout_layout_scrollInterpolator;
        boolean bl2 = attributeSet.hasValue(n10);
        if (bl2) {
            n10 = attributeSet.getResourceId(n10, 0);
            context = AnimationUtils.loadInterpolator((Context)context, (int)n10);
            this.scrollInterpolator = context;
        }
        attributeSet.recycle();
    }

    public AppBarLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AppBarLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public AppBarLayout$LayoutParams(LinearLayout.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public AppBarLayout$LayoutParams(AppBarLayout$LayoutParams appBarLayout$LayoutParams) {
        super((LinearLayout.LayoutParams)appBarLayout$LayoutParams);
        int n10;
        this.scrollFlags = n10 = appBarLayout$LayoutParams.scrollFlags;
        appBarLayout$LayoutParams = appBarLayout$LayoutParams.scrollInterpolator;
        this.scrollInterpolator = appBarLayout$LayoutParams;
    }

    public int getScrollFlags() {
        return this.scrollFlags;
    }

    public Interpolator getScrollInterpolator() {
        return this.scrollInterpolator;
    }

    public boolean isCollapsible() {
        int n10 = this.scrollFlags;
        int n11 = n10 & 1;
        int n12 = 1;
        if (n11 != n12 || (n10 &= 0xA) == 0) {
            n12 = 0;
        }
        return n12 != 0;
    }

    public void setScrollFlags(int n10) {
        this.scrollFlags = n10;
    }

    public void setScrollInterpolator(Interpolator interpolator2) {
        this.scrollInterpolator = interpolator2;
    }
}

