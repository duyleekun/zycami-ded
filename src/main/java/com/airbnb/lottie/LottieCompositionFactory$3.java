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
import java.lang.ref.WeakReference;
import java.util.concurrent.Callable;

public class LottieCompositionFactory$3
implements Callable {
    public final /* synthetic */ Context val$appContext;
    public final /* synthetic */ String val$cacheKey;
    public final /* synthetic */ WeakReference val$contextRef;
    public final /* synthetic */ int val$rawRes;

    public LottieCompositionFactory$3(WeakReference weakReference, Context context, int n10, String string2) {
        this.val$contextRef = weakReference;
        this.val$appContext = context;
        this.val$rawRes = n10;
        this.val$cacheKey = string2;
    }

    public LottieResult call() {
        Context context = (Context)this.val$contextRef.get();
        if (context == null) {
            context = this.val$appContext;
        }
        int n10 = this.val$rawRes;
        String string2 = this.val$cacheKey;
        return LottieCompositionFactory.fromRawResSync(context, n10, string2);
    }
}

