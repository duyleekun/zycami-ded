/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.LottieDrawable$LazyCompositionTask;

public class LottieDrawable$11
implements LottieDrawable$LazyCompositionTask {
    public final /* synthetic */ LottieDrawable this$0;
    public final /* synthetic */ String val$endMarkerName;
    public final /* synthetic */ boolean val$playEndMarkerStartFrame;
    public final /* synthetic */ String val$startMarkerName;

    public LottieDrawable$11(LottieDrawable lottieDrawable, String string2, String string3, boolean bl2) {
        this.this$0 = lottieDrawable;
        this.val$startMarkerName = string2;
        this.val$endMarkerName = string3;
        this.val$playEndMarkerStartFrame = bl2;
    }

    public void run(LottieComposition object) {
        object = this.this$0;
        String string2 = this.val$startMarkerName;
        String string3 = this.val$endMarkerName;
        boolean bl2 = this.val$playEndMarkerStartFrame;
        ((LottieDrawable)((Object)object)).setMinAndMaxFrame(string2, string3, bl2);
    }
}

