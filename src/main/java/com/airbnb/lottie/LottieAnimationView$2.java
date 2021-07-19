/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieListener;

public class LottieAnimationView$2
implements LottieListener {
    public final /* synthetic */ LottieAnimationView this$0;

    public LottieAnimationView$2(LottieAnimationView lottieAnimationView) {
        this.this$0 = lottieAnimationView;
    }

    public void onResult(LottieComposition lottieComposition) {
        this.this$0.setComposition(lottieComposition);
    }
}

