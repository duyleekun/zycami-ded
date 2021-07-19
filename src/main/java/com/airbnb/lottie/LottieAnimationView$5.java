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

public class LottieAnimationView$5
implements Callable {
    public final /* synthetic */ LottieAnimationView this$0;
    public final /* synthetic */ String val$assetName;

    public LottieAnimationView$5(LottieAnimationView lottieAnimationView, String string2) {
        this.this$0 = lottieAnimationView;
        this.val$assetName = string2;
    }

    public LottieResult call() {
        Object object = this.this$0;
        boolean bl2 = LottieAnimationView.access$300((LottieAnimationView)object);
        if (bl2) {
            object = this.this$0.getContext();
            String string2 = this.val$assetName;
            object = LottieCompositionFactory.fromAssetSync((Context)object, string2);
        } else {
            object = this.this$0.getContext();
            String string3 = this.val$assetName;
            object = LottieCompositionFactory.fromAssetSync((Context)object, string3, null);
        }
        return object;
    }
}

