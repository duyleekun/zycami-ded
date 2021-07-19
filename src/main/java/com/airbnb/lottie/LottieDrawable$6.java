/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$6
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ int val$maxFrame;

    public LottieDrawable$6(LottieDrawable lottieDrawable, int n10) {
        this.this$0 = lottieDrawable;
        this.val$maxFrame = n10;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        int n10 = this.val$maxFrame;
        ((LottieDrawable)((Object)object)).setMaxFrame(n10);
    }
}

