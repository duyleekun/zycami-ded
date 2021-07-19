/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.SparseLongArray
 */
package com.google.android.exoplayer2.transformer;

import android.util.SparseLongArray;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.Util;

public final class TransformerMediaClock
implements MediaClock {
    private long minTrackTimeUs;
    private final SparseLongArray trackTypeToTimeUs;

    public TransformerMediaClock() {
        SparseLongArray sparseLongArray;
        this.trackTypeToTimeUs = sparseLongArray = new SparseLongArray();
    }

    public PlaybackParameters getPlaybackParameters() {
        return PlaybackParameters.DEFAULT;
    }

    public long getPositionUs() {
        return this.minTrackTimeUs;
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
    }

    public void updateTimeForTrackType(int n10, long l10) {
        long l11;
        long l12;
        long l13;
        SparseLongArray sparseLongArray = this.trackTypeToTimeUs;
        long l14 = -9223372036854775807L;
        long l15 = sparseLongArray.get(n10, l14);
        long l16 = l15 - l14;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object != false && (l13 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1)) <= 0) {
            return;
        }
        SparseLongArray sparseLongArray2 = this.trackTypeToTimeUs;
        sparseLongArray2.put(n10, l10);
        if (object == false || (n10 = (int)((l12 = l15 - (l11 = this.minTrackTimeUs)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) == 0) {
            SparseLongArray sparseLongArray3 = this.trackTypeToTimeUs;
            this.minTrackTimeUs = l11 = Util.minValue(sparseLongArray3);
        }
    }
}

