/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.firebase.heartbeatinfo;

import android.content.Context;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatInfo;
import com.google.firebase.inject.Provider;

public final class DefaultHeartBeatInfo$$Lambda$1
implements Provider {
    private final Context arg$1;

    private DefaultHeartBeatInfo$$Lambda$1(Context context) {
        this.arg$1 = context;
    }

    public static Provider lambdaFactory$(Context context) {
        DefaultHeartBeatInfo$$Lambda$1 defaultHeartBeatInfo$$Lambda$1 = new DefaultHeartBeatInfo$$Lambda$1(context);
        return defaultHeartBeatInfo$$Lambda$1;
    }

    public Object get() {
        return DefaultHeartBeatInfo.lambda$new$1(this.arg$1);
    }
}

