/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime$Builder;
import com.google.firebase.inject.Provider;

public final class ComponentRuntime$Builder$$Lambda$1
implements Provider {
    private final ComponentRegistrar arg$1;

    private ComponentRuntime$Builder$$Lambda$1(ComponentRegistrar componentRegistrar) {
        this.arg$1 = componentRegistrar;
    }

    public static Provider lambdaFactory$(ComponentRegistrar componentRegistrar) {
        ComponentRuntime$Builder$$Lambda$1 componentRuntime$Builder$$Lambda$1 = new ComponentRuntime$Builder$$Lambda$1(componentRegistrar);
        return componentRuntime$Builder$$Lambda$1;
    }

    public Object get() {
        return ComponentRuntime$Builder.lambda$addComponentRegistrar$0(this.arg$1);
    }
}

