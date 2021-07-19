/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.Animator
 *  android.animation.AnimatorListenerAdapter
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

public class FabTransformationBehavior$1
extends AnimatorListenerAdapter {
    public final /* synthetic */ FabTransformationBehavior this$0;
    public final /* synthetic */ View val$child;
    public final /* synthetic */ View val$dependency;
    public final /* synthetic */ boolean val$expanded;

    public FabTransformationBehavior$1(FabTransformationBehavior fabTransformationBehavior, boolean bl2, View view, View view2) {
        this.this$0 = fabTransformationBehavior;
        this.val$expanded = bl2;
        this.val$child = view;
        this.val$dependency = view2;
    }

    public void onAnimationEnd(Animator animator2) {
        boolean bl2 = this.val$expanded;
        if (!bl2) {
            this.val$child.setVisibility(4);
            this.val$dependency.setAlpha(1.0f);
            animator2 = this.val$dependency;
            animator2.setVisibility(0);
        }
    }

    public void onAnimationStart(Animator animator2) {
        boolean bl2 = this.val$expanded;
        if (bl2) {
            this.val$child.setVisibility(0);
            this.val$dependency.setAlpha(0.0f);
            animator2 = this.val$dependency;
            int n10 = 4;
            animator2.setVisibility(n10);
        }
    }
}

