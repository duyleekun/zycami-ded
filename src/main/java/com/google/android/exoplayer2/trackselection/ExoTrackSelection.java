/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.chunk.Chunk;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import java.util.List;

public interface ExoTrackSelection
extends TrackSelection {
    public boolean blacklist(int var1, long var2);

    public void disable();

    public void enable();

    public int evaluateQueueSize(long var1, List var3);

    public Format getSelectedFormat();

    public int getSelectedIndex();

    public int getSelectedIndexInTrackGroup();

    public Object getSelectionData();

    public int getSelectionReason();

    default public void onDiscontinuity() {
    }

    default public void onPlayWhenReadyChanged(boolean bl2) {
    }

    public void onPlaybackSpeed(float var1);

    default public void onRebuffer() {
    }

    default public boolean shouldCancelChunkLoad(long l10, Chunk chunk, List list) {
        return false;
    }

    public void updateSelectedTrack(long var1, long var3, long var5, List var7, MediaChunkIterator[] var8);
}

