/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.animation.ValueAnimator
 *  android.animation.ValueAnimator$AnimatorUpdateListener
 */
package com.airbnb.lottie;

import android.animation.ValueAnimator;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.model.layer.CompositionLayer;
import com.airbnb.lottie.utils.LottieValueAnimator;

public class LottieDrawable$1
implements ValueAnimator.AnimatorUpdateListener {
    public final /* synthetic */ LottieDrawable this$0;

    public LottieDrawable$1(LottieDrawable lottieDrawable) {
        this.this$0 = lottieDrawable;
    }

    public void onAnimationUpdate(ValueAnimator object) {
        object = LottieDrawable.access$000(this.this$0);
        if (object != null) {
            object = LottieDrawable.access$000(this.this$0);
            LottieValueAnimator lottieValueAnimator = LottieDrawable.access$100(this.this$0);
            float f10 = lottieValueAnimator.getAnimatedValueAbsolute();
            ((CompositionLayer)object).setProgress(f10);
        }
    }
}

