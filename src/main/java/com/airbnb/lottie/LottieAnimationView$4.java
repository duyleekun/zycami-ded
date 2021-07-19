/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.airbnb.lottie;

import android.content.Context;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieResult;
import java.util.concurrent.Callable;

public class LottieAnimationView$4
implements Callable {
    public final /* synthetic */ LottieAnimationView this$0;
    public final /* synthetic */ int val$rawRes;

    public LottieAnimationView$4(LottieAnimationView lottieAnimationView, int n10) {
        this.this$0 = lottieAnimationView;
        this.val$rawRes = n10;
    }

    public LottieResult call() {
        Object object = this.this$0;
        boolean bl2 = LottieAnimationView.access$300((LottieAnimationView)object);
        if (bl2) {
            object = this.this$0.getContext();
            int n10 = this.val$rawRes;
            object = LottieCompositionFactory.fromRawResSync((Context)object, n10);
        } else {
            object = this.this$0.getContext();
            int n11 = this.val$rawRes;
            object = LottieCompositionFactory.fromRawResSync((Context)object, n11, null);
        }
        return object;
    }
}

