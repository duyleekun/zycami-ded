/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

import com.meicam.sdk.NvsTimeline;

public interface NvsStreamingContext$StreamingEngineCallback {
    public void onFirstVideoFramePresented(NvsTimeline var1);

    public void onStreamingEngineStateChanged(int var1);
}

