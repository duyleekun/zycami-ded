/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.remoteconfig;

import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.concurrent.Callable;

public final class RemoteConfigComponent$$Lambda$1
implements Callable {
    private final RemoteConfigComponent arg$1;

    private RemoteConfigComponent$$Lambda$1(RemoteConfigComponent remoteConfigComponent) {
        this.arg$1 = remoteConfigComponent;
    }

    public static Callable lambdaFactory$(RemoteConfigComponent remoteConfigComponent) {
        RemoteConfigComponent$$Lambda$1 remoteConfigComponent$$Lambda$1 = new RemoteConfigComponent$$Lambda$1(remoteConfigComponent);
        return remoteConfigComponent$$Lambda$1;
    }

    public Object call() {
        return this.arg$1.getDefault();
    }
}

