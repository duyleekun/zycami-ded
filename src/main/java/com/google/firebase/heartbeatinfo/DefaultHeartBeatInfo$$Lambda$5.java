/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import java.util.concurrent.ThreadFactory;

public final class DefaultHeartBeatInfo$$Lambda$5
implements ThreadFactory {
    private static final DefaultHeartBeatInfo$$Lambda$5 instance;

    static {
        DefaultHeartBeatInfo$$Lambda$5 defaultHeartBeatInfo$$Lambda$5;
        instance = defaultHeartBeatInfo$$Lambda$5 = new DefaultHeartBeatInfo$$Lambda$5();
    }

    private DefaultHeartBeatInfo$$Lambda$5() {
    }

    public static ThreadFactory lambdaFactory$() {
        return instance;
    }

    public Thread newThread(Runnable runnable) {
        return DefaultHeartBeatInfo.lambda$static$0(runnable);
    }
}

