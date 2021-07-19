/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import com.google.android.material.appbar.ViewOffsetHelper;

public class ViewOffsetBehavior
extends CoordinatorLayout$Behavior {
    private int tempLeftRightOffset = 0;
    private int tempTopBottomOffset = 0;
    private ViewOffsetHelper viewOffsetHelper;

    public ViewOffsetBehavior() {
    }

    public ViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public int getLeftAndRightOffset() {
        int n10;
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            n10 = viewOffsetHelper.getLeftAndRightOffset();
        } else {
            n10 = 0;
            viewOffsetHelper = null;
        }
        return n10;
    }

    public int getTopAndBottomOffset() {
        int n10;
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            n10 = viewOffsetHelper.getTopAndBottomOffset();
        } else {
            n10 = 0;
            viewOffsetHelper = null;
        }
        return n10;
    }

    public void layoutChild(CoordinatorLayout coordinatorLayout, View view, int n10) {
        coordinatorLayout.onLayoutChild(view, n10);
    }

    public boolean onLayoutChild(CoordinatorLayout object, View view, int n10) {
        ViewOffsetHelper viewOffsetHelper;
        this.layoutChild((CoordinatorLayout)object, view, n10);
        object = this.viewOffsetHelper;
        if (object == null) {
            this.viewOffsetHelper = object = new ViewOffsetHelper(view);
        }
        object = this.viewOffsetHelper;
        ((ViewOffsetHelper)object).onViewLayout();
        int n11 = this.tempTopBottomOffset;
        view = null;
        if (n11 != 0) {
            viewOffsetHelper = this.viewOffsetHelper;
            viewOffsetHelper.setTopAndBottomOffset(n11);
            this.tempTopBottomOffset = 0;
        }
        if ((n11 = this.tempLeftRightOffset) != 0) {
            viewOffsetHelper = this.viewOffsetHelper;
            viewOffsetHelper.setLeftAndRightOffset(n11);
            this.tempLeftRightOffset = 0;
        }
        return true;
    }

    public boolean setLeftAndRightOffset(int n10) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setLeftAndRightOffset(n10);
        }
        this.tempLeftRightOffset = n10;
        return false;
    }

    public boolean setTopAndBottomOffset(int n10) {
        ViewOffsetHelper viewOffsetHelper = this.viewOffsetHelper;
        if (viewOffsetHelper != null) {
            return viewOffsetHelper.setTopAndBottomOffset(n10);
        }
        this.tempTopBottomOffset = n10;
        return false;
    }
}

