/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.upstream.Allocator;

public interface LoadControl {
    public Allocator getAllocator();

    public long getBackBufferDurationUs();

    public void onPrepared();

    public void onReleased();

    public void onStopped();

    public void onTracksSelected(Renderer[] var1, TrackGroupArray var2, ExoTrackSelection[] var3);

    public boolean retainBackBufferFromKeyframe();

    public boolean shouldContinueLoading(long var1, long var3, float var5);

    public boolean shouldStartPlayback(long var1, float var3, boolean var4, long var5);
}

