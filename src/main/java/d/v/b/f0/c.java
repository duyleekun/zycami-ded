/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.v.b.f0;

import android.animation.ValueAnimator;
import d.v.b.f0.j;

public final class c
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ j a;

    public /* synthetic */ c(j j10) {
        this.a = j10;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        j.p(this.a, valueAnimator);
    }
}

