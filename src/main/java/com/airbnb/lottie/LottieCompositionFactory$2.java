/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$2
implements Callable {
    public final /* synthetic */ Context val$appContext;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ String val$fileName;

    public LottieCompositionFactory$2(Context context, String string2, String string3) {
        this.val$appContext = context;
        this.val$fileName = string2;
        this.val$cacheKey = string3;
    }

    public LottieResult call() {
        Context context = this.val$appContext;
        String string2 = this.val$fileName;
        String string3 = this.val$cacheKey;
        return LottieCompositionFactory.fromAssetSync(context, string2, string3);
    }
}

