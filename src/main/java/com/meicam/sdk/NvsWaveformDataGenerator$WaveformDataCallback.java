/*
 * Decompiled with CFR 0.151.
 */
package com.meicam.sdk;

public interface NvsWaveformDataGenerator$WaveformDataCallback {
    public void onWaveformDataGenerationFailed(long var1, String var3, long var4);

    public void onWaveformDataReady(long var1, String var3, long var4, long var6, float[] var8, float[] var9);
}

