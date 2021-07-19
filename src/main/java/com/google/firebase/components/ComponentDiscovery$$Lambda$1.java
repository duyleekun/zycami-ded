/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.components;

import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.inject.Provider;

public final class ComponentDiscovery$$Lambda$1
implements Provider {
    private final String arg$1;

    private ComponentDiscovery$$Lambda$1(String string2) {
        this.arg$1 = string2;
    }

    public static Provider lambdaFactory$(String string2) {
        ComponentDiscovery$$Lambda$1 componentDiscovery$$Lambda$1 = new ComponentDiscovery$$Lambda$1(string2);
        return componentDiscovery$$Lambda$1;
    }

    public Object get() {
        return ComponentDiscovery.lambda$discoverLazy$0(this.arg$1);
    }
}

