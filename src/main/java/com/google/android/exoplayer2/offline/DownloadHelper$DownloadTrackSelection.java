/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.offline;

import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

public final class DownloadHelper$DownloadTrackSelection
extends BaseTrackSelection {
    public DownloadHelper$DownloadTrackSelection(TrackGroup trackGroup, int[] nArray) {
        super(trackGroup, nArray);
    }

    public int getSelectedIndex() {
        return 0;
    }

    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return 0;
    }

    public void updateSelectedTrack(long l10, long l11, long l12, List list, MediaChunkIterator[] mediaChunkIteratorArray) {
    }
}

