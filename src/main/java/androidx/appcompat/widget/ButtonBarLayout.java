/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.TypedArray
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.widget.LinearLayout
 *  android.widget.LinearLayout$LayoutParams
 */
package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.appcompat.R$id;
import androidx.appcompat.R$styleable;
import androidx.core.view.ViewCompat;

public class ButtonBarLayout
extends LinearLayout {
    private static final int PEEK_BUTTON_DP = 16;
    private boolean mAllowStacking;
    private int mLastWidthSize = -1;
    private int mMinimumHeight = 0;

    public ButtonBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.ButtonBarLayout;
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, nArray);
        ViewCompat.saveAttributeDataForStyleable((View)this, context, nArray, attributeSet, typedArray, 0, 0);
        int n10 = R$styleable.ButtonBarLayout_allowStacking;
        n10 = typedArray.getBoolean(n10, true) ? 1 : 0;
        this.mAllowStacking = n10;
        typedArray.recycle();
    }

    private int getNextVisibleChildIndex(int n10) {
        int n11 = this.getChildCount();
        while (n10 < n11) {
            View view = this.getChildAt(n10);
            int n12 = view.getVisibility();
            if (n12 == 0) {
                return n10;
            }
            ++n10;
        }
        return -1;
    }

    private boolean isStacked() {
        int n10;
        int n11 = this.getOrientation();
        if (n11 != (n10 = 1)) {
            n10 = 0;
        }
        return n10 != 0;
    }

    private void setStacked(boolean n10) {
        this.setOrientation(n10);
        int n11 = n10 != 0 ? 0x800005 : 80;
        this.setGravity(n11);
        n11 = R$id.spacer;
        View view = this.findViewById(n11);
        if (view != null) {
            n10 = n10 != 0 ? 8 : 4;
            view.setVisibility(n10);
        }
        for (n10 = this.getChildCount() + -2; n10 >= 0; n10 += -1) {
            view = this.getChildAt(n10);
            this.bringChildToFront(view);
        }
    }

    public int getMinimumHeight() {
        int n10 = this.mMinimumHeight;
        int n11 = super.getMinimumHeight();
        return Math.max(n10, n11);
    }

    public void onMeasure(int n10, int n11) {
        LinearLayout.LayoutParams layoutParams;
        float f10;
        int n12;
        int n13 = View.MeasureSpec.getSize((int)n10);
        int n14 = this.mAllowStacking;
        int n15 = 0;
        if (n14 != 0) {
            n14 = this.mLastWidthSize;
            if (n13 > n14 && (n14 = (int)(this.isStacked() ? 1 : 0)) != 0) {
                this.setStacked(false);
            }
            this.mLastWidthSize = n13;
        }
        n14 = this.isStacked() ? 1 : 0;
        int n16 = 1;
        float f11 = Float.MIN_VALUE;
        if (n14 == 0 && (n14 = View.MeasureSpec.getMode((int)n10)) == (n12 = 0x40000000)) {
            n13 = View.MeasureSpec.makeMeasureSpec((int)n13, (int)(-1 << -1));
            n14 = n16;
        } else {
            n13 = n10;
            n14 = 0;
        }
        super.onMeasure(n13, n11);
        n13 = this.mAllowStacking ? 1 : 0;
        if (n13 != 0 && (n13 = (int)(this.isStacked() ? 1 : 0)) == 0) {
            n13 = this.getMeasuredWidthAndState() & 0xFF000000;
            if (n13 == (n12 = 0x1000000)) {
                n13 = n16;
                f10 = f11;
            } else {
                n13 = 0;
                layoutParams = null;
                f10 = 0.0f;
            }
            if (n13 != 0) {
                this.setStacked(n16 != 0);
                n14 = n16;
            }
        }
        if (n14 != 0) {
            super.onMeasure(n10, n11);
        }
        if ((n10 = this.getNextVisibleChildIndex(0)) >= 0) {
            View view = this.getChildAt(n10);
            layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            n14 = this.getPaddingTop();
            n11 = view.getMeasuredHeight();
            n14 += n11;
            n11 = layoutParams.topMargin;
            n14 += n11;
            n11 = layoutParams.bottomMargin;
            n14 = n14 + n11 + 0;
            n11 = this.isStacked() ? 1 : 0;
            if (n11 != 0) {
                n10 += n16;
                if ((n10 = this.getNextVisibleChildIndex(n10)) >= 0) {
                    View view2 = this.getChildAt(n10);
                    n10 = view2.getPaddingTop();
                    float f12 = 16.0f;
                    layoutParams = this.getResources().getDisplayMetrics();
                    f10 = layoutParams.density * f12;
                    n11 = (int)f10;
                    n14 += (n10 += n11);
                }
                n15 = n14;
            } else {
                n10 = this.getPaddingBottom();
                n15 = n14 + n10;
            }
        }
        if ((n10 = ViewCompat.getMinimumHeight((View)this)) != n15) {
            this.setMinimumHeight(n15);
        }
    }

    public void setAllowStacking(boolean bl2) {
        boolean bl3 = this.mAllowStacking;
        if (bl3 != bl2) {
            this.mAllowStacking = bl2;
            if (!bl2 && (bl2 = this.getOrientation()) == (bl3 = true)) {
                bl2 = false;
                this.setStacked(false);
            }
            this.requestLayout();
        }
    }
}

