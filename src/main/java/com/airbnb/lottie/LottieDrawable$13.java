/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$13
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ float val$maxProgress;
    public final /* synthetic */ float val$minProgress;

    public LottieDrawable$13(LottieDrawable lottieDrawable, float f10, float f11) {
        this.this$0 = lottieDrawable;
        this.val$minProgress = f10;
        this.val$maxProgress = f11;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        float f10 = this.val$minProgress;
        float f11 = this.val$maxProgress;
        ((LottieDrawable)((Object)object)).setMinAndMaxProgress(f10, f11);
    }
}

