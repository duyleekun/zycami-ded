/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package com.google.android.material.transformation;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.material.transformation.FabTransformationBehavior;

public class FabTransformationBehavior$2
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FabTransformationBehavior this$0;
    public final /* synthetic */ View val$child;

    public FabTransformationBehavior$2(FabTransformationBehavior fabTransformationBehavior, View view) {
        this.this$0 = fabTransformationBehavior;
        this.val$child = view;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.val$child.invalidate();
    }
}

