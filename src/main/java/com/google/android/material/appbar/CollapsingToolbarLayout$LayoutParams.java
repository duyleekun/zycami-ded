/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.FrameLayout$LayoutParams
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.material.R$styleable;

public class CollapsingToolbarLayout$LayoutParams
extends FrameLayout.LayoutParams {
    public static final int COLLAPSE_MODE_OFF = 0;
    public static final int COLLAPSE_MODE_PARALLAX = 2;
    public static final int COLLAPSE_MODE_PIN = 1;
    private static final float DEFAULT_PARALLAX_MULTIPLIER = 0.5f;
    public int collapseMode = 0;
    public float parallaxMult;

    public CollapsingToolbarLayout$LayoutParams(int n10, int n11) {
        super(n10, n11);
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(int n10, int n11, int n12) {
        super(n10, n11, n12);
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        float f10;
        this.parallaxMult = f10 = 0.5f;
        int[] nArray = R$styleable.CollapsingToolbarLayout_Layout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode;
        this.collapseMode = n10 = context.getInt(n10, 0);
        n10 = R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier;
        float f11 = context.getFloat(n10, f10);
        this.setParallaxMultiplier(f11);
        context.recycle();
    }

    public CollapsingToolbarLayout$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
        this.parallaxMult = 0.5f;
    }

    public CollapsingToolbarLayout$LayoutParams(FrameLayout.LayoutParams layoutParams) {
        super(layoutParams);
        this.parallaxMult = 0.5f;
    }

    public int getCollapseMode() {
        return this.collapseMode;
    }

    public float getParallaxMultiplier() {
        return this.parallaxMult;
    }

    public void setCollapseMode(int n10) {
        this.collapseMode = n10;
    }

    public void setParallaxMultiplier(float f10) {
        this.parallaxMult = f10;
    }
}

