/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$9
implements Callable {
    public final /* synthetic */ LottieComposition val$cachedComposition;

    public LottieCompositionFactory$9(LottieComposition lottieComposition) {
        this.val$cachedComposition = lottieComposition;
    }

    public LottieResult call() {
        LottieComposition lottieComposition = this.val$cachedComposition;
        LottieResult lottieResult = new LottieResult(lottieComposition);
        return lottieResult;
    }
}

