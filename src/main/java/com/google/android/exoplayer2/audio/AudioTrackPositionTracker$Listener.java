/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

public interface AudioTrackPositionTracker$Listener {
    public void onInvalidLatency(long var1);

    public void onPositionAdvancing(long var1);

    public void onPositionFramesMismatch(long var1, long var3, long var5, long var7);

    public void onSystemTimeUsMismatch(long var1, long var3, long var5, long var7);

    public void onUnderrun(int var1, long var2);
}

