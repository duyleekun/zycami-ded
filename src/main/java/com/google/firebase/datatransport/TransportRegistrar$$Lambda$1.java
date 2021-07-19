/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.datatransport;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.datatransport.TransportRegistrar;

public final class TransportRegistrar$$Lambda$1
implements ComponentFactory {
    private static final TransportRegistrar$$Lambda$1 instance;

    static {
        TransportRegistrar$$Lambda$1 transportRegistrar$$Lambda$1;
        instance = transportRegistrar$$Lambda$1 = new TransportRegistrar$$Lambda$1();
    }

    private TransportRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return TransportRegistrar.lambda$getComponents$0(componentContainer);
    }
}

