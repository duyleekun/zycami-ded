/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;

public final class DefaultHeartBeatInfo$$Lambda$4
implements ComponentFactory {
    private static final DefaultHeartBeatInfo$$Lambda$4 instance;

    static {
        DefaultHeartBeatInfo$$Lambda$4 defaultHeartBeatInfo$$Lambda$4;
        instance = defaultHeartBeatInfo$$Lambda$4 = new DefaultHeartBeatInfo$$Lambda$4();
    }

    private DefaultHeartBeatInfo$$Lambda$4() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.lambda$component$4(componentContainer);
    }
}

