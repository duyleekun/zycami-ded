/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.perf;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.perf.FirebasePerfRegistrar;

public final class FirebasePerfRegistrar$$Lambda$1
implements ComponentFactory {
    private static final FirebasePerfRegistrar$$Lambda$1 instance;

    static {
        FirebasePerfRegistrar$$Lambda$1 firebasePerfRegistrar$$Lambda$1;
        instance = firebasePerfRegistrar$$Lambda$1 = new FirebasePerfRegistrar$$Lambda$1();
    }

    private FirebasePerfRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.lambda$getComponents$0(componentContainer);
    }
}

