/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.io.InputStream;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$4
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ InputStream val$stream;

    public LottieCompositionFactory$4(InputStream inputStream, String string2) {
        this.val$stream = inputStream;
        this.val$cacheKey = string2;
    }

    public LottieResult call() {
        InputStream inputStream = this.val$stream;
        String string2 = this.val$cacheKey;
        return LottieCompositionFactory.fromJsonInputStreamSync(inputStream, string2);
    }
}

