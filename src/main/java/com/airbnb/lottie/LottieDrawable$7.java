/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$7
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ float val$maxProgress;

    public LottieDrawable$7(LottieDrawable lottieDrawable, float f10) {
        this.this$0 = lottieDrawable;
        this.val$maxProgress = f10;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        float f10 = this.val$maxProgress;
        ((LottieDrawable)((Object)object)).setMaxProgress(f10);
    }
}

