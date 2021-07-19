/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import com.google.android.material.appbar.CollapsingToolbarLayout;

public class CollapsingToolbarLayout$2
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CollapsingToolbarLayout this$0;

    public CollapsingToolbarLayout$2(CollapsingToolbarLayout collapsingToolbarLayout) {
        this.this$0 = collapsingToolbarLayout;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        CollapsingToolbarLayout collapsingToolbarLayout = this.this$0;
        int n10 = (Integer)valueAnimator.getAnimatedValue();
        collapsingToolbarLayout.setScrimAlpha(n10);
    }
}

