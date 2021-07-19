/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewGroup
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

public class BaselineLayout
extends ViewGroup {
    private int baseline = -1;

    public BaselineLayout(Context context) {
        super(context, null, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
    }

    public BaselineLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
    }

    public int getBaseline() {
        return this.baseline;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        n10 = this.getChildCount();
        n12 = this.getPaddingLeft();
        n13 -= n11;
        n11 = this.getPaddingRight();
        n13 = n13 - n11 - n12;
        n11 = this.getPaddingTop();
        for (n14 = 0; n14 < n10; ++n14) {
            int n15;
            View view = this.getChildAt(n14);
            int n16 = view.getVisibility();
            if (n16 == (n15 = 8)) continue;
            n16 = view.getMeasuredWidth();
            n15 = view.getMeasuredHeight();
            int n17 = (n13 - n16) / 2 + n12;
            int n18 = this.baseline;
            int n19 = -1;
            if (n18 != n19 && (n18 = view.getBaseline()) != n19) {
                n18 = this.baseline + n11;
                n19 = view.getBaseline();
                n18 -= n19;
            } else {
                n18 = n11;
            }
            view.layout(n17, n18, n16 += n17, n15 += n18);
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12 = this.getChildCount();
        int n13 = -1;
        int n14 = n13;
        int n15 = n13;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        for (int i10 = 0; i10 < n12; ++i10) {
            int n19;
            View view = this.getChildAt(i10);
            int n20 = view.getVisibility();
            if (n20 == (n19 = 8)) continue;
            this.measureChild(view, n10, n11);
            n20 = view.getBaseline();
            if (n20 != n13) {
                n14 = Math.max(n14, n20);
                n19 = view.getMeasuredHeight() - n20;
                n15 = Math.max(n15, n19);
            }
            n20 = view.getMeasuredWidth();
            n17 = Math.max(n17, n20);
            n20 = view.getMeasuredHeight();
            n16 = Math.max(n16, n20);
            int n21 = view.getMeasuredState();
            n18 = View.combineMeasuredStates((int)n18, (int)n21);
        }
        if (n14 != n13) {
            n12 = this.getPaddingBottom();
            n12 = Math.max(n15, n12) + n14;
            n16 = Math.max(n16, n12);
            this.baseline = n14;
        }
        n12 = this.getSuggestedMinimumHeight();
        n12 = Math.max(n16, n12);
        n13 = this.getSuggestedMinimumWidth();
        n10 = View.resolveSizeAndState((int)Math.max(n17, n13), (int)n10, (int)n18);
        n13 = n18 << 16;
        n11 = View.resolveSizeAndState((int)n12, (int)n11, (int)n13);
        this.setMeasuredDimension(n10, n11);
    }
}

