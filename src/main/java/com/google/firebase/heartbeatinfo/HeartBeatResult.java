/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.firebase.heartbeatinfo.AutoValue_HeartBeatResult;
import com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat;

public abstract class HeartBeatResult {
    public static HeartBeatResult create(String string2, long l10, HeartBeatInfo$HeartBeat heartBeatInfo$HeartBeat) {
        AutoValue_HeartBeatResult autoValue_HeartBeatResult = new AutoValue_HeartBeatResult(string2, l10, heartBeatInfo$HeartBeat);
        return autoValue_HeartBeatResult;
    }

    public abstract HeartBeatInfo$HeartBeat getHeartBeat();

    public abstract long getMillis();

    public abstract String getSdkName();
}

