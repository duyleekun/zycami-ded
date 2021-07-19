/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.View$MeasureSpec
 *  android.view.ViewGroup$LayoutParams
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.math.MathUtils;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import com.google.android.material.appbar.ViewOffsetBehavior;
import java.util.List;

public abstract class HeaderScrollingViewBehavior
extends ViewOffsetBehavior {
    private int overlayTop;
    public final Rect tempRect1;
    public final Rect tempRect2;
    private int verticalLayoutGap;

    public HeaderScrollingViewBehavior() {
        Rect rect;
        this.tempRect1 = rect = new Rect();
        this.tempRect2 = rect = new Rect();
        this.verticalLayoutGap = 0;
    }

    public HeaderScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super();
        this.tempRect1 = context;
        super();
        this.tempRect2 = context;
        this.verticalLayoutGap = 0;
    }

    private static int resolveGravity(int n10) {
        if (n10 == 0) {
            n10 = 0x800033;
        }
        return n10;
    }

    public abstract View findFirstDependency(List var1);

    public final int getOverlapPixelsForOffset(View view) {
        int n10 = this.overlayTop;
        int n11 = 0;
        if (n10 != 0) {
            float f10 = this.getOverlapRatioForOffset(view);
            n10 = this.overlayTop;
            float f11 = n10;
            int n12 = (int)(f10 *= f11);
            n11 = MathUtils.clamp(n12, 0, n10);
        }
        return n11;
    }

    public float getOverlapRatioForOffset(View view) {
        return 1.0f;
    }

    public final int getOverlayTop() {
        return this.overlayTop;
    }

    public int getScrollRange(View view) {
        return view.getMeasuredHeight();
    }

    public final int getVerticalLayoutGap() {
        return this.verticalLayoutGap;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int n10) {
        List list = coordinatorLayout.getDependencies(view);
        if ((list = this.findFirstDependency(list)) != null) {
            int n11;
            CoordinatorLayout$LayoutParams coordinatorLayout$LayoutParams = (CoordinatorLayout$LayoutParams)view.getLayoutParams();
            Rect rect = this.tempRect1;
            int n12 = coordinatorLayout.getPaddingLeft();
            int n13 = coordinatorLayout$LayoutParams.leftMargin;
            n12 += n13;
            n13 = list.getBottom();
            int n14 = coordinatorLayout$LayoutParams.topMargin;
            n13 += n14;
            n14 = coordinatorLayout.getWidth();
            int n15 = coordinatorLayout.getPaddingRight();
            n14 -= n15;
            n15 = coordinatorLayout$LayoutParams.rightMargin;
            n14 -= n15;
            n15 = coordinatorLayout.getHeight();
            int n16 = list.getBottom();
            n15 += n16;
            n16 = coordinatorLayout.getPaddingBottom();
            n15 -= n16;
            n16 = coordinatorLayout$LayoutParams.bottomMargin;
            rect.set(n12, n13, n14, n15 -= n16);
            WindowInsetsCompat windowInsetsCompat = coordinatorLayout.getLastWindowInsets();
            if (windowInsetsCompat != null && (n11 = ViewCompat.getFitsSystemWindows((View)coordinatorLayout)) != 0 && (n11 = ViewCompat.getFitsSystemWindows(view)) == 0) {
                n11 = rect.left;
                n13 = windowInsetsCompat.getSystemWindowInsetLeft();
                rect.left = n11 += n13;
                n11 = rect.right;
                n12 = windowInsetsCompat.getSystemWindowInsetRight();
                rect.right = n11 -= n12;
            }
            coordinatorLayout = this.tempRect2;
            n12 = HeaderScrollingViewBehavior.resolveGravity(coordinatorLayout$LayoutParams.gravity);
            n13 = view.getMeasuredWidth();
            n14 = view.getMeasuredHeight();
            n16 = n10;
            GravityCompat.apply(n12, n13, n14, rect, (Rect)coordinatorLayout, n10);
            n10 = this.getOverlapPixelsForOffset((View)list);
            int n17 = ((Rect)coordinatorLayout).left;
            n12 = ((Rect)coordinatorLayout).top - n10;
            n13 = ((Rect)coordinatorLayout).right;
            n14 = ((Rect)coordinatorLayout).bottom - n10;
            view.layout(n17, n12, n13, n14);
            n11 = ((Rect)coordinatorLayout).top;
            int n18 = list.getBottom();
            this.verticalLayoutGap = n11 -= n18;
        } else {
            super.layoutChild(coordinatorLayout, view, n10);
            boolean bl2 = false;
            coordinatorLayout = null;
            this.verticalLayoutGap = 0;
        }
    }

    public boolean onMeasureChild(CoordinatorLayout coordinatorLayout, View view, int n10, int n11, int n12, int n13) {
        int n14;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        int n15 = layoutParams.height;
        int n16 = -1;
        if (n15 == n16 || n15 == (n14 = -2)) {
            List list = coordinatorLayout.getDependencies(view);
            if ((list = this.findFirstDependency(list)) != null) {
                int n17;
                boolean bl2 = ViewCompat.getFitsSystemWindows((View)list);
                boolean bl3 = true;
                if (bl2 && !(bl2 = ViewCompat.getFitsSystemWindows(view))) {
                    ViewCompat.setFitsSystemWindows(view, bl3);
                    n17 = (int)(ViewCompat.getFitsSystemWindows(view) ? 1 : 0);
                    if (n17 != 0) {
                        view.requestLayout();
                        return bl3;
                    }
                }
                if ((n17 = View.MeasureSpec.getSize((int)n12)) == 0) {
                    n17 = coordinatorLayout.getHeight();
                }
                int n18 = list.getMeasuredHeight();
                n17 -= n18;
                n14 = this.getScrollRange((View)list);
                n15 = n15 == n16 ? 0x40000000 : -1 << -1;
                int n19 = View.MeasureSpec.makeMeasureSpec((int)(n17 += n14), (int)n15);
                coordinatorLayout.onMeasureChild(view, n10, n11, n19, n13);
                return bl3;
            }
        }
        return false;
    }

    public final void setOverlayTop(int n10) {
        this.overlayTop = n10;
    }
}

