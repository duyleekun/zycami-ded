/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$9
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ String val$markerName;

    public LottieDrawable$9(LottieDrawable lottieDrawable, String string2) {
        this.this$0 = lottieDrawable;
        this.val$markerName = string2;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        String string2 = this.val$markerName;
        ((LottieDrawable)((Object)object)).setMaxFrame(string2);
    }
}

