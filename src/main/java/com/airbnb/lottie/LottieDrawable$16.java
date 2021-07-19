/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;
import com.airbnb.lottie.model.KeyPath;
import com.airbnb.lottie.value.LottieValueCallback;

public class LottieDrawable$16
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ LottieValueCallback val$callback;
    public final /* synthetic */ KeyPath val$keyPath;
    public final /* synthetic */ Object val$property;

    public LottieDrawable$16(LottieDrawable lottieDrawable, KeyPath keyPath, Object object, LottieValueCallback lottieValueCallback) {
        this.this$0 = lottieDrawable;
        this.val$keyPath = keyPath;
        this.val$property = object;
        this.val$callback = lottieValueCallback;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        KeyPath keyPath = this.val$keyPath;
        Object object2 = this.val$property;
        LottieValueCallback lottieValueCallback = this.val$callback;
        ((LottieDrawable)((Object)object)).addValueCallback(keyPath, object2, lottieValueCallback);
    }
}

