/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 *  android.view.View
 */
package d.h.a.a.p0;

import android.animation.ValueAnimator;
import android.view.View;
import com.google.android.exoplayer2.ui.StyledPlayerControlViewLayoutManager;

public final class s
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ StyledPlayerControlViewLayoutManager a;
    public final /* synthetic */ View b;

    public /* synthetic */ s(StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager, View view) {
        this.a = styledPlayerControlViewLayoutManager;
        this.b = view;
    }

    public final void onAnimationUpdate(ValueAnimator valueAnimator) {
        StyledPlayerControlViewLayoutManager styledPlayerControlViewLayoutManager = this.a;
        View view = this.b;
        styledPlayerControlViewLayoutManager.l(view, valueAnimator);
    }
}

