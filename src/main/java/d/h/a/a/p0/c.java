/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.h.a.a.p0;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.ui.DefaultTimeBar;

public final class c
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ DefaultTimeBar a;

    public /* synthetic */ c(DefaultTimeBar defaultTimeBar) {
        this.a = defaultTimeBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.d(valueAnimator);
    }
}

