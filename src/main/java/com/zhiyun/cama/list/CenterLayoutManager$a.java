/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.DisplayMetrics
 */
package com.zhiyun.cama.list;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearSmoothScroller;

public class CenterLayoutManager$a
extends LinearSmoothScroller {
    public CenterLayoutManager$a(Context context) {
        super(context);
    }

    public int calculateDtToFit(int n10, int n11, int n12, int n13, int n14) {
        n13 = (n13 - n12) / 2;
        n11 = (n11 - n10) / 2;
        return (n12 += n13) - (n10 += n11);
    }

    public float calculateSpeedPerPixel(DisplayMetrics displayMetrics) {
        float f10 = displayMetrics.densityDpi;
        return 60.0f / f10;
    }
}

