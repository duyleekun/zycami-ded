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
import com.google.android.material.bottomappbar.BottomAppBarTopEdgeTreatment;

public class BottomAppBar$2
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ BottomAppBar this$0;

    public BottomAppBar$2(BottomAppBar bottomAppBar) {
        this.this$0 = bottomAppBar;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        BottomAppBarTopEdgeTreatment bottomAppBarTopEdgeTreatment = BottomAppBar.access$100(this.this$0);
        float f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        bottomAppBarTopEdgeTreatment.setHorizontalOffset(f10);
        BottomAppBar.access$200(this.this$0).invalidateSelf();
    }
}

