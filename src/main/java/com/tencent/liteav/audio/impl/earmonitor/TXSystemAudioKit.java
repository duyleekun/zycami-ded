/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.tencent.liteav.audio.impl.earmonitor;

import android.content.Context;
import com.tencent.liteav.audio.impl.earmonitor.a;

public interface TXSystemAudioKit {
    public void initialize(Context var1, a var2);

    public void setSystemEarMonitoringVolume(int var1);

    public void startSystemEarMonitoring();

    public void stopSystemEarMonitoring();

    public void uninitialize();
}

