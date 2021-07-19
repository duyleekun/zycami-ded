/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.AppBarLayout$BaseBehavior;

public class AppBarLayout$BaseBehavior$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ AppBarLayout$BaseBehavior this$0;
    public final /* synthetic */ AppBarLayout val$child;
    public final /* synthetic */ CoordinatorLayout val$coordinatorLayout;

    public AppBarLayout$BaseBehavior$1(AppBarLayout$BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout) {
        this.this$0 = baseBehavior;
        this.val$coordinatorLayout = coordinatorLayout;
        this.val$child = appBarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        AppBarLayout$BaseBehavior appBarLayout$BaseBehavior = this.this$0;
        CoordinatorLayout coordinatorLayout = this.val$coordinatorLayout;
        AppBarLayout appBarLayout = this.val$child;
        int n10 = (Integer)valueAnimator.getAnimatedValue();
        appBarLayout$BaseBehavior.setHeaderTopBottomOffset(coordinatorLayout, (View)appBarLayout, n10);
    }
}

