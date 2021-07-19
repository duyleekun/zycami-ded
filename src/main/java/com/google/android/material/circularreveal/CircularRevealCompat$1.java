/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.circularreveal;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;

public final class CircularRevealCompat$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ CircularRevealWidget val$view;

    public CircularRevealCompat$1(CircularRevealWidget circularRevealWidget) {
        this.val$view = circularRevealWidget;
    }

    public void onAnimationEnd(Animator animator2) {
        this.val$view.destroyCircularRevealCache();
    }

    public void onAnimationStart(Animator animator2) {
        this.val$view.buildCircularRevealCache();
    }
}

