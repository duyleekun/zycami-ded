/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.MediaItem$LiveConfiguration;

public interface LivePlaybackSpeedControl {
    public float getAdjustedPlaybackSpeed(long var1, long var3);

    public long getTargetLiveOffsetUs();

    public void notifyRebuffer();

    public void setLiveConfiguration(MediaItem.LiveConfiguration var1);

    public void setTargetLiveOffsetOverrideUs(long var1);
}

