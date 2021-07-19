/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.source.hls;

import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.chunk.MediaChunkIterator;
import com.google.android.exoplayer2.trackselection.BaseTrackSelection;
import java.util.List;

public final class HlsChunkSource$InitializationTrackSelection
extends BaseTrackSelection {
    private int selectedIndex;

    public HlsChunkSource$InitializationTrackSelection(TrackGroup object, int[] nArray) {
        super((TrackGroup)object, nArray);
        int n10;
        int n11 = nArray[0];
        object = object.getFormat(n11);
        this.selectedIndex = n10 = this.indexOf((Format)object);
    }

    public int getSelectedIndex() {
        return this.selectedIndex;
    }

    public Object getSelectionData() {
        return null;
    }

    public int getSelectionReason() {
        return 0;
    }

    public void updateSelectedTrack(long l10, long l11, long l12, List list, MediaChunkIterator[] mediaChunkIteratorArray) {
        l10 = SystemClock.elapsedRealtime();
        int n10 = this.selectedIndex;
        if ((n10 = (int)(this.isBlacklisted(n10, l10) ? 1 : 0)) == 0) {
            return;
        }
        for (n10 = this.length + -1; n10 >= 0; n10 += -1) {
            boolean bl2 = this.isBlacklisted(n10, l10);
            if (bl2) continue;
            this.selectedIndex = n10;
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }
}

