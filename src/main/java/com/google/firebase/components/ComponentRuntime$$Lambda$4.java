/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.LazySet;
import com.google.firebase.inject.Provider;

public final class ComponentRuntime$$Lambda$4
implements Runnable {
    private final LazySet arg$1;
    private final Provider arg$2;

    private ComponentRuntime$$Lambda$4(LazySet lazySet, Provider provider) {
        this.arg$1 = lazySet;
        this.arg$2 = provider;
    }

    public static Runnable lambdaFactory$(LazySet lazySet, Provider provider) {
        ComponentRuntime$$Lambda$4 componentRuntime$$Lambda$4 = new ComponentRuntime$$Lambda$4(lazySet, provider);
        return componentRuntime$$Lambda$4;
    }

    public void run() {
        LazySet lazySet = this.arg$1;
        Provider provider = this.arg$2;
        ComponentRuntime.lambda$processSetComponents$3(lazySet, provider);
    }
}

