/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.v.b.f0;

import android.animation.ValueAnimator;
import d.v.b.f0.k;

public final class g
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ k a;

    public /* synthetic */ g(k k10) {
        this.a = k10;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        k.p(this.a, valueAnimator);
    }
}

