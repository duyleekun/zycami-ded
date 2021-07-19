/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import com.geetest.sdk.views.GT3GeetestView;

public class GT3GeetestView$a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GT3GeetestView a;

    public GT3GeetestView$a(GT3GeetestView gT3GeetestView) {
        this.a = gT3GeetestView;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        GT3GeetestView gT3GeetestView = this.a;
        int n10 = (Integer)valueAnimator.getAnimatedValue();
        GT3GeetestView.a(gT3GeetestView, n10);
    }
}

