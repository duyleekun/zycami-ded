/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$7
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ JsonReader val$reader;

    public LottieCompositionFactory$7(JsonReader jsonReader, String string2) {
        this.val$reader = jsonReader;
        this.val$cacheKey = string2;
    }

    public LottieResult call() {
        JsonReader jsonReader = this.val$reader;
        String string2 = this.val$cacheKey;
        return LottieCompositionFactory.fromJsonReaderSync(jsonReader, string2);
    }
}

