/*
 * Decompiled with CFR 0.151.
 */
package com.airbnb.lottie;

import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieComposition$1;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.OnCompositionLoadedListener;

public final class LottieComposition$Factory$ListenerAdapter
implements LottieListener,
Cancellable {
    private boolean cancelled = false;
    private final OnCompositionLoadedListener listener;

    private LottieComposition$Factory$ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener) {
        this.listener = onCompositionLoadedListener;
    }

    public /* synthetic */ LottieComposition$Factory$ListenerAdapter(OnCompositionLoadedListener onCompositionLoadedListener, LottieComposition$1 lottieComposition$1) {
        this(onCompositionLoadedListener);
    }

    public void cancel() {
        this.cancelled = true;
    }

    public void onResult(LottieComposition lottieComposition) {
        boolean bl2 = this.cancelled;
        if (bl2) {
            return;
        }
        this.listener.onCompositionLoaded(lottieComposition);
    }
}

