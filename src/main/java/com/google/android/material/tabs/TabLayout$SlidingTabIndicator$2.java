/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.tabs;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.tabs.TabLayout$SlidingTabIndicator;

public class TabLayout$SlidingTabIndicator$2
extends AnimatorListenerAdapter {
    public final /* synthetic */ TabLayout$SlidingTabIndicator this$1;
    public final /* synthetic */ int val$position;

    public TabLayout$SlidingTabIndicator$2(TabLayout$SlidingTabIndicator tabLayout$SlidingTabIndicator, int n10) {
        this.this$1 = tabLayout$SlidingTabIndicator;
        this.val$position = n10;
    }

    public void onAnimationEnd(Animator object) {
        int n10;
        object = this.this$1;
        object.selectedPosition = n10 = this.val$position;
        object.selectionOffset = 0.0f;
    }
}

