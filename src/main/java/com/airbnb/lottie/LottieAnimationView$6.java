/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class LottieAnimationView$6
extends LottieValueCallback {
    public final /* synthetic */ LottieAnimationView this$0;
    public final /* synthetic */ SimpleLottieValueCallback val$callback;

    public LottieAnimationView$6(LottieAnimationView lottieAnimationView, SimpleLottieValueCallback simpleLottieValueCallback) {
        this.this$0 = lottieAnimationView;
        this.val$callback = simpleLottieValueCallback;
    }

    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return this.val$callback.getValue(lottieFrameInfo);
    }
}

