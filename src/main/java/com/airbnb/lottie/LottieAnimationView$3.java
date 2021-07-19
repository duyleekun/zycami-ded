/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieListener;

public class LottieAnimationView$3
implements LottieListener {
    public final /* synthetic */ LottieAnimationView this$0;

    public LottieAnimationView$3(LottieAnimationView lottieAnimationView) {
        this.this$0 = lottieAnimationView;
    }

    public void onResult(Throwable throwable) {
        Object object = this.this$0;
        int n10 = LottieAnimationView.access$000((LottieAnimationView)object);
        if (n10 != 0) {
            object = this.this$0;
            int n11 = LottieAnimationView.access$000((LottieAnimationView)object);
            ((LottieAnimationView)object).setImageResource(n11);
        }
        object = (object = LottieAnimationView.access$100(this.this$0)) == null ? LottieAnimationView.access$200() : LottieAnimationView.access$100(this.this$0);
        object.onResult(throwable);
    }
}

