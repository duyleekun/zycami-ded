/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.circularreveal.CircularRevealWidget$RevealInfo;
import com.google.android.material.transformation.FabTransformationBehavior;

public class FabTransformationBehavior$4
extends AnimatorListenerAdapter {
    public final /* synthetic */ FabTransformationBehavior this$0;
    public final /* synthetic */ CircularRevealWidget val$circularRevealChild;

    public FabTransformationBehavior$4(FabTransformationBehavior fabTransformationBehavior, CircularRevealWidget circularRevealWidget) {
        this.this$0 = fabTransformationBehavior;
        this.val$circularRevealChild = circularRevealWidget;
    }

    public void onAnimationEnd(Animator object) {
        object = this.val$circularRevealChild.getRevealInfo();
        object.radius = Float.MAX_VALUE;
        this.val$circularRevealChild.setRevealInfo((CircularRevealWidget$RevealInfo)object);
    }
}

