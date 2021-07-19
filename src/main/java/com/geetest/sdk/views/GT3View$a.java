/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.geetest.sdk.views;

import android.animation.ValueAnimator;
import com.geetest.sdk.views.GT3View;

public class GT3View$a
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ GT3View a;

    public GT3View$a(GT3View gT3View) {
        this.a = gT3View;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        GT3View gT3View = this.a;
        int n10 = (Integer)valueAnimator.getAnimatedValue();
        GT3View.a(gT3View, n10);
    }
}

