/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package d.h.a.a.p0;

import android.animation.ValueAnimator;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public final class b0
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager a;

    public /* synthetic */ b0(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager) {
        this.a = styledPlayerControlViewLayoutManager;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        this.a.p(valueAnimator);
    }
}

