/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Deferred$DeferredHandler;
import com.google.firebase.inject.Provider;

public final class OptionalProvider$$Lambda$1
implements Deferred$DeferredHandler {
    private final Deferred$DeferredHandler arg$1;
    private final Deferred$DeferredHandler arg$2;

    private OptionalProvider$$Lambda$1(Deferred$DeferredHandler deferred$DeferredHandler, Deferred$DeferredHandler deferred$DeferredHandler2) {
        this.arg$1 = deferred$DeferredHandler;
        this.arg$2 = deferred$DeferredHandler2;
    }

    public static Deferred$DeferredHandler lambdaFactory$(Deferred$DeferredHandler deferred$DeferredHandler, Deferred$DeferredHandler deferred$DeferredHandler2) {
        OptionalProvider$$Lambda$1 optionalProvider$$Lambda$1 = new OptionalProvider$$Lambda$1(deferred$DeferredHandler, deferred$DeferredHandler2);
        return optionalProvider$$Lambda$1;
    }

    public void handle(Provider provider) {
        Deferred$DeferredHandler deferred$DeferredHandler = this.arg$1;
        Deferred$DeferredHandler deferred$DeferredHandler2 = this.arg$2;
        OptionalProvider.lambda$whenAvailable$2(deferred$DeferredHandler, deferred$DeferredHandler2, provider);
    }
}

