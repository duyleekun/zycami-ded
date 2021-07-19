/*
 * Decompiled with CFR 0.151.
 */
package com.google.firebase.heartbeatinfo;

import com.google.android.gms.tasks.Task;
import com.google.firebase.heartbeatinfo.HeartBeatInfo$HeartBeat;

public interface HeartBeatInfo {
    public Task getAndClearStoredHeartBeatInfo();

    public HeartBeatInfo$HeartBeat getHeartBeatCode(String var1);

    public Task storeHeartBeatInfo(String var1);
}

