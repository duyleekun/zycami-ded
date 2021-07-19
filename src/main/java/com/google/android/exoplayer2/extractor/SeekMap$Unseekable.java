/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;

public class SeekMap$Unseekable
implements SeekMap {
    private final long durationUs;
    private final SeekMap$SeekPoints startSeekPoints;

    public SeekMap$Unseekable(long l10) {
        this(l10, 0L);
    }

    public SeekMap$Unseekable(long l10, long l11) {
        SeekMap$SeekPoints seekMap$SeekPoints;
        this.durationUs = l10;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        SeekPoint seekPoint = l13 == false ? SeekPoint.START : new SeekPoint(l12, l11);
        this.startSeekPoints = seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        return this.startSeekPoints;
    }

    public boolean isSeekable() {
        return false;
    }
}

