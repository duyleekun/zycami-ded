/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.platforminfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.platforminfo.DefaultUserAgentPublisher;

public final class DefaultUserAgentPublisher$$Lambda$1
implements ComponentFactory {
    private static final DefaultUserAgentPublisher$$Lambda$1 instance;

    static {
        DefaultUserAgentPublisher$$Lambda$1 defaultUserAgentPublisher$$Lambda$1;
        instance = defaultUserAgentPublisher$$Lambda$1 = new DefaultUserAgentPublisher$$Lambda$1();
    }

    private DefaultUserAgentPublisher$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return DefaultUserAgentPublisher.lambda$component$0(componentContainer);
    }
}

