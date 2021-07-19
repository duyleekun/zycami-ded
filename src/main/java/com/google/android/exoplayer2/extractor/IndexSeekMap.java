/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class IndexSeekMap
implements SeekMap {
    private final long durationUs;
    private final boolean isSeekable;
    private final long[] positions;
    private final long[] timesUs;

    public IndexSeekMap(long[] lArray, long[] lArray2, long l10) {
        long l11;
        long l12;
        long l13;
        long[] lArray3;
        int n10 = lArray.length;
        int n11 = lArray2.length;
        int n12 = 1;
        n10 = n10 == n11 ? n12 : 0;
        Assertions.checkArgument(n10 != 0);
        n10 = lArray2.length;
        if (n10 > 0) {
            n11 = n12;
        } else {
            n11 = 0;
            lArray3 = null;
        }
        this.isSeekable = n11;
        if (n11 != 0 && (n11 = (int)((l13 = (l12 = lArray2[0]) - (l11 = 0L)) == 0L ? 0 : (l13 < 0L ? -1 : 1))) > 0) {
            n11 = n10 + 1;
            long[] lArray4 = new long[n11];
            this.positions = lArray4;
            lArray3 = new long[n11];
            this.timesUs = lArray3;
            System.arraycopy(lArray, 0, lArray4, n12, n10);
            System.arraycopy(lArray2, 0, lArray3, n12, n10);
        } else {
            this.positions = lArray;
            this.timesUs = lArray2;
        }
        this.durationUs = l10;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object;
        int n10 = this.isSeekable;
        if (n10 == 0) {
            SeekPoint seekPoint = SeekPoint.START;
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
            return seekMap$SeekPoints;
        }
        long[] lArray = this.timesUs;
        int n11 = 1;
        n10 = Util.binarySearchFloor(lArray, l10, n11 != 0, n11 != 0);
        long l11 = this.timesUs[n10];
        long[] lArray2 = this.positions;
        long l12 = lArray2[n10];
        SeekPoint seekPoint = new SeekPoint(l11, l12);
        long l13 = seekPoint.timeUs;
        long l14 = l13 - l10;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false && n10 != (object2 = (Object)(((Object)(object = (Object)this.timesUs)).length - n11))) {
            Object object3 = this.timesUs;
            l13 = object3[n10 += n11];
            long l15 = this.positions[n10];
            object = new SeekPoint(l13, l15);
            object3 = new SeekMap$SeekPoints;
            object3(seekPoint, (SeekPoint)object);
            return object3;
        }
        object = new SeekMap$SeekPoints(seekPoint);
        return object;
    }

    public boolean isSeekable() {
        return this.isSeekable;
    }
}

