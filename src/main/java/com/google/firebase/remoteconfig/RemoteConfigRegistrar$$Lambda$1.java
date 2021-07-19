/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;

public final class RemoteConfigRegistrar$$Lambda$1
implements ComponentFactory {
    private static final RemoteConfigRegistrar$$Lambda$1 instance;

    static {
        RemoteConfigRegistrar$$Lambda$1 remoteConfigRegistrar$$Lambda$1;
        instance = remoteConfigRegistrar$$Lambda$1 = new RemoteConfigRegistrar$$Lambda$1();
    }

    private RemoteConfigRegistrar$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(componentContainer);
    }
}

