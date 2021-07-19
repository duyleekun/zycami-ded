/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.v.c.s0.h7;

import android.animation.ValueAnimator;
import d.v.c.s0.h7.k0;
import e.a.b0;

public final class k
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ b0 a;

    public /* synthetic */ k(b0 b02) {
        this.a = b02;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        k0.C(this.a, valueAnimator);
    }
}

