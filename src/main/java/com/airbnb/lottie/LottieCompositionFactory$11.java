/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieListener;

public class LottieCompositionFactory$11
implements LottieListener {
    public final /* synthetic */ String val$cacheKey;

    public LottieCompositionFactory$11(String string2) {
        this.val$cacheKey = string2;
    }

    public void onResult(Throwable object) {
        object = LottieCompositionFactory.access$000();
        String string2 = this.val$cacheKey;
        object.remove(string2);
    }
}

