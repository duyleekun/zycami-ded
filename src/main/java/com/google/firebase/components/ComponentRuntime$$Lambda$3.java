/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Provider;

public final class ComponentRuntime$$Lambda$3
implements Runnable {
    private final OptionalProvider arg$1;
    private final Provider arg$2;

    private ComponentRuntime$$Lambda$3(OptionalProvider optionalProvider, Provider provider) {
        this.arg$1 = optionalProvider;
        this.arg$2 = provider;
    }

    public static Runnable lambdaFactory$(OptionalProvider optionalProvider, Provider provider) {
        ComponentRuntime$$Lambda$3 componentRuntime$$Lambda$3 = new ComponentRuntime$$Lambda$3(optionalProvider, provider);
        return componentRuntime$$Lambda$3;
    }

    public void run() {
        OptionalProvider optionalProvider = this.arg$1;
        Provider provider = this.arg$2;
        ComponentRuntime.lambda$processInstanceComponents$2(optionalProvider, provider);
    }
}

