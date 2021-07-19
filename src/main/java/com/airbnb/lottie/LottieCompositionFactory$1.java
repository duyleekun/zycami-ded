/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.L;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieResult;
import com.airbnb.lottie.model.LottieCompositionCache;
import com.airbnb.lottie.network.NetworkFetcher;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$1
implements Callable {
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ Context val$context;
    public final /* synthetic */ String val$url;

    public LottieCompositionFactory$1(Context context, String string2, String string3) {
        this.val$context = context;
        this.val$url = string2;
        this.val$cacheKey = string3;
    }

    public LottieResult call() {
        Object object = L.networkFetcher(this.val$context);
        Object object2 = this.val$url;
        String string2 = this.val$cacheKey;
        object = ((NetworkFetcher)object).fetchSync((String)object2, string2);
        object2 = this.val$cacheKey;
        if (object2 != null && (object2 = ((LottieResult)object).getValue()) != null) {
            object2 = LottieCompositionCache.getInstance();
            string2 = this.val$cacheKey;
            LottieComposition lottieComposition = (LottieComposition)((LottieResult)object).getValue();
            ((LottieCompositionCache)object2).put(string2, lottieComposition);
        }
        return object;
    }
}

