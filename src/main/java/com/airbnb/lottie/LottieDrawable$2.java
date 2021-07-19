/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$2
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;

    public LottieDrawable$2(LottieDrawable lottieDrawable) {
        this.this$0 = lottieDrawable;
    }

    public void run(LottieComposition lottieComposition) {
        this.this$0.playAnimation();
    }
}

