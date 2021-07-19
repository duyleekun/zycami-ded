/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$6
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ String val$json;

    public LottieCompositionFactory$6(String string2, String string3) {
        this.val$json = string2;
        this.val$cacheKey = string3;
    }

    public LottieResult call() {
        String string2 = this.val$json;
        String string3 = this.val$cacheKey;
        return LottieCompositionFactory.fromJsonStringSync(string2, string3);
    }
}

