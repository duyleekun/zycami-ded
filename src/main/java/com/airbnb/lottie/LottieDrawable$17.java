/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.value.LottieFrameInfo;
import com.airbnb.lottie.value.LottieValueCallback;
import com.airbnb.lottie.value.SimpleLottieValueCallback;

public class LottieDrawable$17
extends LottieValueCallback {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ SimpleLottieValueCallback val$callback;

    public LottieDrawable$17(LottieDrawable lottieDrawable, SimpleLottieValueCallback simpleLottieValueCallback) {
        this.this$0 = lottieDrawable;
        this.val$callback = simpleLottieValueCallback;
    }

    public Object getValue(LottieFrameInfo lottieFrameInfo) {
        return this.val$callback.getValue(lottieFrameInfo);
    }
}

