/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;

public class LottieAnimationView$1
implements LottieListener {
    public void onResult(Throwable throwable) {
        boolean bl2 = Utils.isNetworkException(throwable);
        if (bl2) {
            Logger.warning("Unable to load composition.", throwable);
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException("Unable to parse composition", throwable);
        throw illegalStateException;
    }
}

