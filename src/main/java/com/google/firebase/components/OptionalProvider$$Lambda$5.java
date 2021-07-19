/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.OptionalProvider;
import com.google.firebase.inject.Provider;

public final class OptionalProvider$$Lambda$5
implements Provider {
    private static final OptionalProvider$$Lambda$5 instance;

    static {
        OptionalProvider$$Lambda$5 optionalProvider$$Lambda$5;
        instance = optionalProvider$$Lambda$5 = new OptionalProvider$$Lambda$5();
    }

    private OptionalProvider$$Lambda$5() {
    }

    public static Provider lambdaFactory$() {
        return instance;
    }

    public Object get() {
        return OptionalProvider.lambda$static$1();
    }
}

