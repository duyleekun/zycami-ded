/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package androidx.recyclerview.widget;

import android.animation.ValueAnimator;
import androidx.recyclerview.widget.FastScroller;

public class FastScroller$AnimatorUpdater
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ FastScroller this$0;

    public FastScroller$AnimatorUpdater(FastScroller fastScroller) {
        this.this$0 = fastScroller;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int n10 = (int)(((Float)valueAnimator.getAnimatedValue()).floatValue() * 255.0f);
        this.this$0.mVerticalThumbDrawable.setAlpha(n10);
        this.this$0.mVerticalTrackDrawable.setAlpha(n10);
        this.this$0.requestRedraw();
    }
}

