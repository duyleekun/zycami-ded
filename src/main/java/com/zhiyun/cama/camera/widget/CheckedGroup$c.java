/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout$LayoutParams
 */
package com.zhiyun.cama.camera.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class CheckedGroup$c
extends LinearLayout.LayoutParams {
    public CheckedGroup$c(int n10, int n11) {
        super(n10, n11);
    }

    public CheckedGroup$c(int n10, int n11, float f10) {
        super(n10, n11, f10);
    }

    public CheckedGroup$c(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CheckedGroup$c(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public CheckedGroup$c(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }

    public void setBaseAttributes(TypedArray typedArray, int n10, int n11) {
        boolean bl2 = typedArray.hasValue(n10);
        int n12 = -2;
        if (bl2) {
            String string2 = "layout_width";
            this.width = n10 = typedArray.getLayoutDimension(n10, string2);
        } else {
            this.width = n12;
        }
        n10 = (int)(typedArray.hasValue(n11) ? 1 : 0);
        if (n10 != 0) {
            int n13;
            String string3 = "layout_height";
            this.height = n13 = typedArray.getLayoutDimension(n11, string3);
        } else {
            this.height = n12;
        }
    }
}

