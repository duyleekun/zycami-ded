/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.graphics.Rect
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package com.google.android.material.bottomappbar;

import android.animation.TimeInterpolator;
import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$LayoutParams;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class BottomAppBar$Behavior
extends HideBottomViewOnScrollBehavior {
    private final Rect fabContentRect;

    public BottomAppBar$Behavior() {
        Rect rect;
        this.fabContentRect = rect = new Rect();
    }

    public BottomAppBar$Behavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super();
        this.fabContentRect = context;
    }

    private boolean updateFabPositionAndVisibility(FloatingActionButton floatingActionButton, BottomAppBar bottomAppBar) {
        ((CoordinatorLayout$LayoutParams)floatingActionButton.getLayoutParams()).anchorGravity = 17;
        BottomAppBar.access$1000(bottomAppBar, floatingActionButton);
        return true;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, int n10) {
        int n11;
        FloatingActionButton floatingActionButton = BottomAppBar.access$1100(bottomAppBar);
        if (floatingActionButton != null) {
            this.updateFabPositionAndVisibility(floatingActionButton, bottomAppBar);
            Rect rect = this.fabContentRect;
            floatingActionButton.getMeasuredContentRect(rect);
            floatingActionButton = this.fabContentRect;
            n11 = floatingActionButton.height();
            bottomAppBar.setFabDiameter(n11);
        }
        if ((n11 = BottomAppBar.access$1200(bottomAppBar)) == 0) {
            BottomAppBar.access$1300(bottomAppBar);
        }
        coordinatorLayout.onLayoutChild((View)bottomAppBar, n10);
        return super.onLayoutChild(coordinatorLayout, (View)bottomAppBar, n10);
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, BottomAppBar bottomAppBar, View view, View view2, int n10, int n11) {
        boolean bl2;
        boolean bl3 = bottomAppBar.getHideOnScroll();
        if (bl3 && (bl2 = super.onStartNestedScroll(coordinatorLayout, (View)bottomAppBar, view, view2, n10, n11))) {
            bl2 = true;
        } else {
            bl2 = false;
            coordinatorLayout = null;
        }
        return bl2;
    }

    public void slideDown(BottomAppBar object) {
        super.slideDown((View)object);
        object = BottomAppBar.access$1100((BottomAppBar)object);
        if (object != null) {
            Rect rect = this.fabContentRect;
            ((FloatingActionButton)object).getContentRect(rect);
            int n10 = object.getMeasuredHeight();
            int n11 = this.fabContentRect.height();
            float f10 = n10 -= n11;
            object.clearAnimation();
            ViewPropertyAnimator viewPropertyAnimator = object.animate();
            int n12 = -object.getPaddingBottom();
            float f11 = (float)n12 + f10;
            object = viewPropertyAnimator.translationY(f11);
            rect = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
            object = object.setInterpolator((TimeInterpolator)rect);
            long l10 = 175L;
            object.setDuration(l10);
        }
    }

    public void slideUp(BottomAppBar bottomAppBar) {
        super.slideUp((View)bottomAppBar);
        FloatingActionButton floatingActionButton = BottomAppBar.access$1100(bottomAppBar);
        if (floatingActionButton != null) {
            floatingActionButton.clearAnimation();
            floatingActionButton = floatingActionButton.animate();
            float f10 = BottomAppBar.access$1400(bottomAppBar);
            bottomAppBar = floatingActionButton.translationY(f10);
            floatingActionButton = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
            bottomAppBar = bottomAppBar.setInterpolator((TimeInterpolator)floatingActionButton);
            long l10 = 225L;
            bottomAppBar.setDuration(l10);
        }
    }
}

