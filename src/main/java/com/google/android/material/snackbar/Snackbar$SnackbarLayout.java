/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 */
package com.google.android.material.snackbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.material.snackbar.BaseTransientBottomBar$SnackbarBaseLayout;

public final class Snackbar$SnackbarLayout
extends BaseTransientBottomBar$SnackbarBaseLayout {
    public Snackbar$SnackbarLayout(Context context) {
        super(context);
    }

    public Snackbar$SnackbarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onMeasure(int n10, int n11) {
        super.onMeasure(n10, n11);
        n10 = this.getChildCount();
        n11 = this.getMeasuredWidth();
        int n12 = this.getPaddingLeft();
        n11 -= n12;
        n12 = this.getPaddingRight();
        n11 -= n12;
        for (n12 = 0; n12 < n10; ++n12) {
            View view = this.getChildAt(n12);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            int n13 = layoutParams.width;
            int n14 = -1;
            if (n13 != n14) continue;
            n13 = 0x40000000;
            n14 = View.MeasureSpec.makeMeasureSpec((int)n11, (int)n13);
            int n15 = view.getMeasuredHeight();
            n13 = View.MeasureSpec.makeMeasureSpec((int)n15, (int)n13);
            view.measure(n14, n13);
        }
    }
}

