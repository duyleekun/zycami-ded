/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.inject.Provider;
import java.util.Collections;

public final class ComponentRuntime$$Lambda$5
implements Provider {
    private static final ComponentRuntime$$Lambda$5 instance;

    static {
        ComponentRuntime$$Lambda$5 componentRuntime$$Lambda$5;
        instance = componentRuntime$$Lambda$5 = new ComponentRuntime$$Lambda$5();
    }

    private ComponentRuntime$$Lambda$5() {
    }

    public static Provider lambdaFactory$() {
        return instance;
    }

    public Object get() {
        return Collections.emptySet();
    }
}

