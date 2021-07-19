/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.animation.ValueAnimator
 */
package com.google.android.material.internal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import com.google.android.material.internal.StateListAnimator;

public class StateListAnimator$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ StateListAnimator this$0;

    public StateListAnimator$1(StateListAnimator stateListAnimator) {
        this.this$0 = stateListAnimator;
    }

    public void onAnimationEnd(Animator animator2) {
        StateListAnimator stateListAnimator = this.this$0;
        ValueAnimator valueAnimator = stateListAnimator.runningAnimator;
        if (valueAnimator == animator2) {
            animator2 = null;
            stateListAnimator.runningAnimator = null;
        }
    }
}

