/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator$AnimatorListener
 *  android.animation.TimeInterpolator
 *  android.content.Context
 *  android.util.AttributeSet
 *  android.view.View
 *  android.view.ViewPropertyAnimator
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewPropertyAnimator;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout$Behavior;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior$1;

public class HideBottomViewOnScrollBehavior
extends CoordinatorLayout$Behavior {
    public static final int ENTER_ANIMATION_DURATION = 225;
    public static final int EXIT_ANIMATION_DURATION = 175;
    private static final int STATE_SCROLLED_DOWN = 1;
    private static final int STATE_SCROLLED_UP = 2;
    private ViewPropertyAnimator currentAnimator;
    private int currentState = 2;
    private int height = 0;

    public HideBottomViewOnScrollBehavior() {
    }

    public HideBottomViewOnScrollBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public static /* synthetic */ ViewPropertyAnimator access$002(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior, ViewPropertyAnimator viewPropertyAnimator) {
        hideBottomViewOnScrollBehavior.currentAnimator = viewPropertyAnimator;
        return viewPropertyAnimator;
    }

    private void animateChildTo(View view, int n10, long l10, TimeInterpolator timeInterpolator) {
        view = view.animate();
        float f10 = n10;
        view = view.translationY(f10).setInterpolator(timeInterpolator).setDuration(l10);
        HideBottomViewOnScrollBehavior$1 hideBottomViewOnScrollBehavior$1 = new HideBottomViewOnScrollBehavior$1(this);
        view = view.setListener((Animator.AnimatorListener)hideBottomViewOnScrollBehavior$1);
        this.currentAnimator = view;
    }

    public boolean onLayoutChild(CoordinatorLayout coordinatorLayout, View view, int n10) {
        int n11;
        this.height = n11 = view.getMeasuredHeight();
        return super.onLayoutChild(coordinatorLayout, view, n10);
    }

    public void onNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, int n10, int n11, int n12, int n13) {
        int n14 = this.currentState;
        int n15 = 1;
        if (n14 != n15 && n11 > 0) {
            this.slideDown(view);
        } else {
            n15 = 2;
            if (n14 != n15 && n11 < 0) {
                this.slideUp(view);
            }
        }
    }

    public boolean onStartNestedScroll(CoordinatorLayout coordinatorLayout, View view, View view2, View view3, int n10) {
        int n11 = 2;
        n11 = n10 == n11 ? 1 : 0;
        return n11 != 0;
    }

    public void slideDown(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.currentState = 1;
        int n10 = this.height;
        TimeInterpolator timeInterpolator = AnimationUtils.FAST_OUT_LINEAR_IN_INTERPOLATOR;
        this.animateChildTo(view, n10, 175L, timeInterpolator);
    }

    public void slideUp(View view) {
        ViewPropertyAnimator viewPropertyAnimator = this.currentAnimator;
        if (viewPropertyAnimator != null) {
            viewPropertyAnimator.cancel();
            view.clearAnimation();
        }
        this.currentState = 2;
        TimeInterpolator timeInterpolator = AnimationUtils.LINEAR_OUT_SLOW_IN_INTERPOLATOR;
        this.animateChildTo(view, 0, 225L, timeInterpolator);
    }
}

