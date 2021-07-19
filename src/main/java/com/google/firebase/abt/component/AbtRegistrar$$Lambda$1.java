/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.abt.component;

import com.google.firebase.abt.component.AbtRegistrar;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final class AbtRegistrar$$Lambda$1
implements ComponentFactory {
    private static final AbtRegistrar$$Lambda$1 instance;

    static {
        AbtRegistrar$$Lambda$1 abtRegistrar$$Lambda$1;
        instance = abtRegistrar$$Lambda$1 = new AbtRegistrar$$Lambda$1();
    }

    private AbtRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return AbtRegistrar.lambda$getComponents$0(componentContainer);
    }
}

