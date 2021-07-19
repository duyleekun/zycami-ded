/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.v.c.b2;

import android.animation.ValueAnimator;
import com.zhiyun.cama.widget.RingProgressBar;

public final class l
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ RingProgressBar a;

    public /* synthetic */ l(RingProgressBar ringProgressBar) {
        this.a = ringProgressBar;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.d(valueAnimator);
    }
}

