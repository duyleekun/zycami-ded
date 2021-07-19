/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup
 *  android.view.ViewGroup$LayoutParams
 *  android.view.ViewGroup$MarginLayoutParams
 */
package com.google.android.material.internal;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;

public class FlowLayout
extends ViewGroup {
    private int itemSpacing;
    private int lineSpacing;
    private boolean singleLine = false;

    public FlowLayout(Context context) {
        this(context, null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int n10) {
        super(context, attributeSet, n10);
        this.loadFromAttributes(context, attributeSet);
    }

    public FlowLayout(Context context, AttributeSet attributeSet, int n10, int n11) {
        super(context, attributeSet, n10, n11);
        this.loadFromAttributes(context, attributeSet);
    }

    private static int getMeasuredDimension(int n10, int n11, int n12) {
        int n13 = -1 << -1;
        if (n11 != n13) {
            n13 = 0x40000000;
            if (n11 != n13) {
                return n12;
            }
            return n10;
        }
        return Math.min(n12, n10);
    }

    private void loadFromAttributes(Context context, AttributeSet attributeSet) {
        context = context.getTheme();
        int[] nArray = R$styleable.FlowLayout;
        context = context.obtainStyledAttributes(attributeSet, nArray, 0, 0);
        int n10 = R$styleable.FlowLayout_lineSpacing;
        this.lineSpacing = n10 = context.getDimensionPixelSize(n10, 0);
        n10 = R$styleable.FlowLayout_itemSpacing;
        this.itemSpacing = n10 = context.getDimensionPixelSize(n10, 0);
        context.recycle();
    }

    public int getItemSpacing() {
        return this.itemSpacing;
    }

    public int getLineSpacing() {
        return this.lineSpacing;
    }

    public boolean isSingleLine() {
        return this.singleLine;
    }

    public void onLayout(boolean n10, int n11, int n12, int n13, int n14) {
        int n15;
        n10 = this.getChildCount();
        if (n10 == 0) {
            return;
        }
        n10 = ViewCompat.getLayoutDirection((View)this);
        if (n10 != (n12 = 1)) {
            n12 = 0;
        }
        n10 = n12 != 0 ? this.getPaddingRight() : this.getPaddingLeft();
        int n16 = n12 != 0 ? this.getPaddingLeft() : this.getPaddingRight();
        int n17 = this.getPaddingTop();
        n13 = n13 - n11 - n16;
        int n18 = n10;
        n11 = n17;
        for (n16 = 0; n16 < (n15 = this.getChildCount()); ++n16) {
            int n19;
            View view = this.getChildAt(n16);
            int n20 = view.getVisibility();
            if (n20 == (n19 = 8)) continue;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            n19 = layoutParams instanceof ViewGroup.MarginLayoutParams;
            if (n19 != 0) {
                layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
                n19 = MarginLayoutParamsCompat.getMarginStart((ViewGroup.MarginLayoutParams)layoutParams);
                n20 = MarginLayoutParamsCompat.getMarginEnd((ViewGroup.MarginLayoutParams)layoutParams);
            } else {
                n20 = 0;
                layoutParams = null;
                n19 = 0;
            }
            int n21 = n18 + n19;
            int n22 = view.getMeasuredWidth();
            n21 += n22;
            n22 = (int)(this.singleLine ? 1 : 0);
            if (n22 == 0 && n21 > n13) {
                n11 = this.lineSpacing + n17;
                n18 = n10;
            }
            n17 = n18 + n19;
            n21 = view.getMeasuredWidth() + n17;
            n22 = view.getMeasuredHeight() + n11;
            if (n12 != 0) {
                n17 = n13 - n21;
                n21 = n13 - n18 - n19;
                view.layout(n17, n11, n21, n22);
            } else {
                view.layout(n17, n11, n21, n22);
            }
            n19 += n20;
            n17 = view.getMeasuredWidth();
            n19 += n17;
            n17 = this.itemSpacing;
            n18 += (n19 += n17);
            n17 = n22;
        }
    }

    public void onMeasure(int n10, int n11) {
        int n12;
        FlowLayout flowLayout = this;
        int n13 = View.MeasureSpec.getSize((int)n10);
        int n14 = View.MeasureSpec.getMode((int)n10);
        int n15 = View.MeasureSpec.getSize((int)n11);
        int n16 = View.MeasureSpec.getMode((int)n11);
        int n17 = -1 << -1;
        n17 = n14 != n17 && n14 != (n17 = 0x40000000) ? -1 >>> 1 : n13;
        int n18 = this.getPaddingLeft();
        int n19 = this.getPaddingTop();
        int n20 = this.getPaddingRight();
        n17 -= n20;
        int n21 = n19;
        int n22 = 0;
        for (int i10 = 0; i10 < (n12 = this.getChildCount()); ++i10) {
            int n23;
            int n24;
            View view = flowLayout.getChildAt(i10);
            int n25 = view.getVisibility();
            if (n25 == (n24 = 8)) {
                n25 = n10;
                n24 = n11;
                continue;
            }
            n25 = n10;
            n24 = n11;
            flowLayout.measureChild(view, n10, n11);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            n20 = layoutParams instanceof ViewGroup.MarginLayoutParams;
            if (n20 != 0) {
                layoutParams = (ViewGroup.MarginLayoutParams)layoutParams;
                n20 = layoutParams.leftMargin + 0;
                n23 = layoutParams.rightMargin + 0;
            } else {
                n20 = 0;
                n23 = 0;
                layoutParams = null;
            }
            int n26 = n18 + n20;
            int n27 = view.getMeasuredWidth();
            int n28 = n18;
            n18 = n26 + n27;
            if (n18 > n17 && (n18 = (int)(this.isSingleLine() ? 1 : 0)) == 0) {
                n18 = this.getPaddingLeft();
                n21 = flowLayout.lineSpacing + n19;
            } else {
                n18 = n28;
            }
            n19 = n18 + n20;
            n26 = view.getMeasuredWidth();
            n19 += n26;
            n26 = view.getMeasuredHeight();
            n26 = n21 + n26;
            if (n19 > n22) {
                n22 = n19;
            }
            n20 += n23;
            n19 = view.getMeasuredWidth();
            n20 += n19;
            n19 = flowLayout.itemSpacing;
            n18 += (n20 += n19);
            n19 = n26;
        }
        n13 = FlowLayout.getMeasuredDimension(n13, n14, n22);
        n14 = FlowLayout.getMeasuredDimension(n15, n16, n19);
        flowLayout.setMeasuredDimension(n13, n14);
    }

    public void setItemSpacing(int n10) {
        this.itemSpacing = n10;
    }

    public void setLineSpacing(int n10) {
        this.lineSpacing = n10;
    }

    public void setSingleLine(boolean bl2) {
        this.singleLine = bl2;
    }
}

