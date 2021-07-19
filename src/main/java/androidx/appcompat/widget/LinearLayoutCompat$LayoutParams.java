/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class LinearLayoutCompat$LayoutParams
extends LinearLayout.LayoutParams {
    public LinearLayoutCompat$LayoutParams(int n10, int n11) {
        super(n10, n11);
    }

    public LinearLayoutCompat$LayoutParams(int n10, int n11, float f10) {
        super(n10, n11, f10);
    }

    public LinearLayoutCompat$LayoutParams(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public LinearLayoutCompat$LayoutParams(ViewGroup.LayoutParams layoutParams) {
        super(layoutParams);
    }

    public LinearLayoutCompat$LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
        super(marginLayoutParams);
    }
}

