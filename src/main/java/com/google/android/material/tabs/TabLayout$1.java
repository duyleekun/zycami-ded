/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.google.android.material.tabs;

import android.animation.ValueAnimator;
import com.google.android.material.tabs.TabLayout;

public class TabLayout$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ TabLayout this$0;

    public TabLayout$1(TabLayout tabLayout) {
        this.this$0 = tabLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        TabLayout tabLayout = this.this$0;
        int n10 = (Integer)valueAnimator.getAnimatedValue();
        tabLayout.scrollTo(n10, 0);
    }
}

