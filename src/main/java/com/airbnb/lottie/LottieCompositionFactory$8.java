/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;
import java.util.zip.ZipInputStream;

public class LottieCompositionFactory$8
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ ZipInputStream val$inputStream;

    public LottieCompositionFactory$8(ZipInputStream zipInputStream, String string2) {
        this.val$inputStream = zipInputStream;
        this.val$cacheKey = string2;
    }

    public LottieResult call() {
        ZipInputStream zipInputStream = this.val$inputStream;
        String string2 = this.val$cacheKey;
        return LottieCompositionFactory.fromZipStreamSync(zipInputStream, string2);
    }
}

