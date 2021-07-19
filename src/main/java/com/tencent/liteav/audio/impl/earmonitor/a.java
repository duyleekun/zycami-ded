/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio.impl.earmonitor;

import com.tencent.liteav.audio.impl.earmonitor.TXSystemAudioKit;

public interface a {
    public void onAudioKitError(TXSystemAudioKit var1);

    public void onAudioKitInitFinished(TXSystemAudioKit var1, boolean var2);

    public void onEarMonitoringInitialized(TXSystemAudioKit var1, boolean var2);
}

