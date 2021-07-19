/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$12
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ int val$maxFrame;
    public final /* synthetic */ int val$minFrame;

    public LottieDrawable$12(LottieDrawable lottieDrawable, int n10, int n11) {
        this.this$0 = lottieDrawable;
        this.val$minFrame = n10;
        this.val$maxFrame = n11;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        int n10 = this.val$minFrame;
        int n11 = this.val$maxFrame;
        ((LottieDrawable)((Object)object)).setMinAndMaxFrame(n10, n11);
    }
}

