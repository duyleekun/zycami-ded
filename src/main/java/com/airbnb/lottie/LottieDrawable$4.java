/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$4
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ int val$minFrame;

    public LottieDrawable$4(LottieDrawable lottieDrawable, int n10) {
        this.this$0 = lottieDrawable;
        this.val$minFrame = n10;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        int n10 = this.val$minFrame;
        ((LottieDrawable)((Object)object)).setMinFrame(n10);
    }
}

