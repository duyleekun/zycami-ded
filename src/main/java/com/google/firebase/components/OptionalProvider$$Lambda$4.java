/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Provider;

public final class OptionalProvider$$Lambda$4
implements Deferred$DeferredHandler {
    private static final OptionalProvider$$Lambda$4 instance;

    static {
        OptionalProvider$$Lambda$4 optionalProvider$$Lambda$4;
        instance = optionalProvider$$Lambda$4 = new OptionalProvider$$Lambda$4();
    }

    private OptionalProvider$$Lambda$4() {
    }

    public static Deferred$DeferredHandler lambdaFactory$() {
        return instance;
    }

    public void handle(Provider provider) {
        OptionalProvider.lambda$static$0(provider);
    }
}

