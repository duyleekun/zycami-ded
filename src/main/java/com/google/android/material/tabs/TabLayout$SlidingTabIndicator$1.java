/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.animation.AnimationUtils;
import com.google.android.material.tabs.TabLayout$SlidingTabIndicator;

public class TabLayout$SlidingTabIndicator$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TabLayout$SlidingTabIndicator this$1;
    public final /* synthetic */ int val$finalTargetLeft;
    public final /* synthetic */ int val$finalTargetRight;
    public final /* synthetic */ int val$startLeft;
    public final /* synthetic */ int val$startRight;

    public TabLayout$SlidingTabIndicator$1(TabLayout$SlidingTabIndicator slidingTabIndicator, int n10, int n11, int n12, int n13) {
        this.this$1 = slidingTabIndicator;
        this.val$startLeft = n10;
        this.val$finalTargetLeft = n11;
        this.val$startRight = n12;
        this.val$finalTargetRight = n13;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f10 = valueAnimator.getAnimatedFraction();
        TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator = this.this$1;
        int n10 = this.val$startLeft;
        int n11 = this.val$finalTargetLeft;
        n10 = AnimationUtils.lerp(n10, n11, f10);
        n11 = this.val$startRight;
        int n12 = this.val$finalTargetRight;
        int n13 = AnimationUtils.lerp(n11, n12, f10);
        tabLayout$SlidingTabIndicator.setIndicatorPosition(n10, n13);
    }
}

