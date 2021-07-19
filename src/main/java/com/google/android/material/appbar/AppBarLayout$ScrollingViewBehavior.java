/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import androidx.core.view.ViewCompat;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior;
import com.google.android.material.appbar.HeaderScrollingViewBehavior;
import java.util.List;

public class AppBarLayout$ScrollingViewBehavior
extends HeaderScrollingViewBehavior {
    public AppBarLayout$ScrollingViewBehavior() {
    }

    public AppBarLayout$ScrollingViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int[] nArray = R$styleable.ScrollingViewBehavior_Layout;
        context = context.obtainStyledAttributes(attributeSet, nArray);
        int n10 = R$styleable.ScrollingViewBehavior_Layout_behavior_overlapTop;
        n10 = context.getDimensionPixelSize(n10, 0);
        this.setOverlayTop(n10);
        context.recycle();
    }

    private static int getAppBarLayoutOffset(AppBarLayout object) {
        boolean bl2 = (object = ((CoordinatorLayout$LayoutParams)object.getLayoutParams()).getBehavior()) instanceof AppBarLayout$BaseBehavior;
        if (bl2) {
            return ((AppBarLayout$BaseBehavior)object).getTopBottomOffsetForScrollingSibling();
        }
        return 0;
    }

    private void offsetChildAsNeeded(View view, View view2) {
        CoordinatorLayout$Behavior coordinatorLayout$Behavior = ((CoordinatorLayout$LayoutParams)view2.getLayoutParams()).getBehavior();
        int n10 = coordinatorLayout$Behavior instanceof AppBarLayout$BaseBehavior;
        if (n10 != 0) {
            coordinatorLayout$Behavior = (AppBarLayout$BaseBehavior)coordinatorLayout$Behavior;
            n10 = view2.getBottom();
            int n11 = view.getTop();
            n10 -= n11;
            int n12 = AppBarLayout$BaseBehavior.access$000((AppBarLayout$BaseBehavior)coordinatorLayout$Behavior);
            n10 += n12;
            n12 = this.getVerticalLayoutGap();
            n10 += n12;
            int n13 = this.getOverlapPixelsForOffset(view2);
            ViewCompat.offsetTopAndBottom(view, n10 -= n13);
        }
    }

    private void updateLiftedStateIfNeeded(View view, View object) {
        boolean bl2 = object instanceof AppBarLayout;
        if (bl2 && (bl2 = ((AppBarLayout)((Object)(object = (AppBarLayout)((Object)object)))).isLiftOnScroll())) {
            int n10 = view.getScrollY();
            if (n10 > 0) {
                n10 = 1;
            } else {
                n10 = 0;
                view = null;
            }
            ((AppBarLayout)((Object)object)).setLiftedState(n10 != 0);
        }
    }

    public AppBarLayout findFirstDependency(List list) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            View view = (View)list.get(i10);
            boolean bl2 = view instanceof AppBarLayout;
            if (!bl2) continue;
            return (AppBarLayout)view;
        }
        return null;
    }

    public float getOverlapRatioForOffset(View object) {
        int n10 = object instanceof AppBarLayout;
        if (n10 != 0) {
            int n11;
            object = (AppBarLayout)((Object)object);
            n10 = ((AppBarLayout)((Object)object)).getTotalScrollRange();
            int n12 = ((AppBarLayout)((Object)object)).getDownNestedPreScrollRange();
            int n13 = AppBarLayout$ScrollingViewBehavior.getAppBarLayoutOffset((AppBarLayout)((Object)object));
            if (n12 != 0 && (n11 = n10 + n13) <= n12) {
                return 0.0f;
            }
            if ((n10 -= n12) != 0) {
                float f10 = n13;
                float f11 = n10;
                return f10 / f11 + 1.0f;
            }
        }
        return 0.0f;
    }

    public int getScrollRange(View view) {
        boolean bl2 = view instanceof AppBarLayout;
        if (bl2) {
            return ((AppBarLayout)view).getTotalScrollRange();
        }
        return super.getScrollRange(view);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof AppBarLayout;
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        this.offsetChildAsNeeded(view, view2);
        this.updateLiftedStateIfNeeded(view, view2);
        return false;
    }

    public boolean onRequestChildRectangleOnScreen(CoordinatorLayout coordinatorLayout, View view, Rect rect, boolean bl2) {
        Object object = coordinatorLayout.getDependencies(view);
        if ((object = this.findFirstDependency((List)object)) != null) {
            int n10 = view.getLeft();
            int bl3 = view.getTop();
            rect.offset(n10, bl3);
            view = this.tempRect1;
            n10 = coordinatorLayout.getWidth();
            int n11 = coordinatorLayout.getHeight();
            view.set(0, 0, n10, n11);
            n11 = (int)(view.contains(rect) ? 1 : 0);
            if (n11 == 0) {
                boolean bl4 = bl2 ^ true;
                ((AppBarLayout)((Object)object)).setExpanded(false, bl4);
                return true;
            }
        }
        return false;
    }
}

