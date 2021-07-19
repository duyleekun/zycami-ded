/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.behavior;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;

public class HideBottomViewOnScrollBehavior$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ HideBottomViewOnScrollBehavior this$0;

    public HideBottomViewOnScrollBehavior$1(HideBottomViewOnScrollBehavior hideBottomViewOnScrollBehavior) {
        this.this$0 = hideBottomViewOnScrollBehavior;
    }

    public void onAnimationEnd(Animator animator2) {
        HideBottomViewOnScrollBehavior.access$002(this.this$0, null);
    }
}

