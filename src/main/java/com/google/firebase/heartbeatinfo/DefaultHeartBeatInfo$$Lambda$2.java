/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.Callable;

public final class DefaultHeartBeatInfo$$Lambda$2
implements Callable {
    private final DefaultHeartBeatInfo arg$1;

    private DefaultHeartBeatInfo$$Lambda$2(DefaultHeartBeatInfo defaultHeartBeatInfo) {
        this.arg$1 = defaultHeartBeatInfo;
    }

    public static Callable lambdaFactory$(DefaultHeartBeatInfo defaultHeartBeatInfo) {
        DefaultHeartBeatInfo$$Lambda$2 defaultHeartBeatInfo$$Lambda$2 = new DefaultHeartBeatInfo$$Lambda$2(defaultHeartBeatInfo);
        return defaultHeartBeatInfo$$Lambda$2;
    }

    public Object call() {
        return DefaultHeartBeatInfo.lambda$getAndClearStoredHeartBeatInfo$2(this.arg$1);
    }
}

