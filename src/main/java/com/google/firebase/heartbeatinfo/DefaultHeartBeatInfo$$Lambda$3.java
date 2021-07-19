/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.Callable;

public final class DefaultHeartBeatInfo$$Lambda$3
implements Callable {
    private final DefaultHeartBeatInfo arg$1;
    private final String arg$2;

    private DefaultHeartBeatInfo$$Lambda$3(DefaultHeartBeatInfo defaultHeartBeatInfo, String string2) {
        this.arg$1 = defaultHeartBeatInfo;
        this.arg$2 = string2;
    }

    public static Callable lambdaFactory$(DefaultHeartBeatInfo defaultHeartBeatInfo, String string2) {
        DefaultHeartBeatInfo$$Lambda$3 defaultHeartBeatInfo$$Lambda$3 = new DefaultHeartBeatInfo$$Lambda$3(defaultHeartBeatInfo, string2);
        return defaultHeartBeatInfo$$Lambda$3;
    }

    public Object call() {
        DefaultHeartBeatInfo defaultHeartBeatInfo = this.arg$1;
        String string2 = this.arg$2;
        return DefaultHeartBeatInfo.lambda$storeHeartBeatInfo$3(defaultHeartBeatInfo, string2);
    }
}

