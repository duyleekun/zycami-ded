/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

public final class FixedTrackSelection
extends BaseTrackSelection {
    private final Object data;
    private final int reason;

    public FixedTrackSelection(TrackGroup trackGroup, int n10) {
        this(trackGroup, n10, 0, null);
    }

    public FixedTrackSelection(TrackGroup trackGroup, int n10, int n11, Object object) {
        int[] nArray = new int[]{n10};
        super(trackGroup, nArray);
        this.reason = n11;
        this.data = object;
    }

    public int getSelectedIndex() {
        return 0;
    }

    public Object getSelectionData() {
        return this.data;
    }

    public int getSelectionReason() {
        return this.reason;
    }

    public void updateSelectedTrack(long l10, long l11, long l12, List list, MediaChunkIterator[] mediaChunkIteratorArray) {
    }
}

