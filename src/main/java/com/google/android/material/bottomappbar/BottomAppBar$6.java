/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.google.android.material.bottomappbar;

import android.animation.ValueAnimator;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.shape.MaterialShapeDrawable;

public class BottomAppBar$6
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomAppBar this$0;

    public BottomAppBar$6(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        MaterialShapeDrawable materialShapeDrawable = BottomAppBar.access$200(this.this$0);
        float f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        materialShapeDrawable.setInterpolation(f10);
    }
}

