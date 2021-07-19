/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final class ComponentRuntime$$Lambda$1
implements Provider {
    private final ComponentRuntime arg$1;
    private final Component arg$2;

    private ComponentRuntime$$Lambda$1(ComponentRuntime componentRuntime, Component component) {
        this.arg$1 = componentRuntime;
        this.arg$2 = component;
    }

    public static Provider lambdaFactory$(ComponentRuntime componentRuntime, Component component) {
        ComponentRuntime$$Lambda$1 componentRuntime$$Lambda$1 = new ComponentRuntime$$Lambda$1(componentRuntime, component);
        return componentRuntime$$Lambda$1;
    }

    public Object get() {
        ComponentRuntime componentRuntime = this.arg$1;
        Component component = this.arg$2;
        return ComponentRuntime.lambda$discoverComponents$0(componentRuntime, component);
    }
}

