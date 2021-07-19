/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final class ComponentRuntime$$Lambda$2
implements Provider {
    private final ComponentRegistrar arg$1;

    private ComponentRuntime$$Lambda$2(ComponentRegistrar componentRegistrar) {
        this.arg$1 = componentRegistrar;
    }

    public static Provider lambdaFactory$(ComponentRegistrar componentRegistrar) {
        ComponentRuntime$$Lambda$2 componentRuntime$$Lambda$2 = new ComponentRuntime$$Lambda$2(componentRegistrar);
        return componentRuntime$$Lambda$2;
    }

    public Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.arg$1);
    }
}

