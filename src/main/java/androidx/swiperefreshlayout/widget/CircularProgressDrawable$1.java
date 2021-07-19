/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package androidx.swiperefreshlayout.widget;

import android.animation.ValueAnimator;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable$Ring;

public class CircularProgressDrawable$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ CircularProgressDrawable this$0;
    public final /* synthetic */ CircularProgressDrawable.Ring val$ring;

    public CircularProgressDrawable$1(CircularProgressDrawable circularProgressDrawable, CircularProgressDrawable.Ring ring) {
        this.this$0 = circularProgressDrawable;
        this.val$ring = ring;
    }

    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        float f10 = ((Float)valueAnimator.getAnimatedValue()).floatValue();
        CircularProgressDrawable circularProgressDrawable = this.this$0;
        CircularProgressDrawable.Ring ring = this.val$ring;
        circularProgressDrawable.updateRingColor(f10, ring);
        circularProgressDrawable = this.this$0;
        ring = this.val$ring;
        circularProgressDrawable.applyTransformation(f10, ring, false);
        this.this$0.invalidateSelf();
    }
}

