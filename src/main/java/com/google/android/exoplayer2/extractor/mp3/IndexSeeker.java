/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp3;

import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.util.LongArray;
import com.google.android.exoplayer2.util.Util;

public final class IndexSeeker
implements Seeker {
    public static final long MIN_TIME_BETWEEN_POINTS_US = 100000L;
    private final long dataEndPosition;
    private long durationUs;
    private final LongArray positions;
    private final LongArray timesUs;

    public IndexSeeker(long l10, long l11, long l12) {
        LongArray longArray;
        LongArray longArray2;
        this.durationUs = l10;
        this.dataEndPosition = l12;
        this.timesUs = longArray2 = new LongArray();
        this.positions = longArray = new LongArray();
        longArray2.add(0L);
        longArray.add(l11);
    }

    public long getDataEndPosition() {
        return this.dataEndPosition;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        Object object;
        LongArray longArray = this.timesUs;
        int n10 = 1;
        int n11 = Util.binarySearchFloor(longArray, l10, n10 != 0, n10 != 0);
        LongArray longArray2 = this.timesUs;
        long l11 = longArray2.get(n11);
        LongArray longArray3 = this.positions;
        long l12 = longArray3.get(n11);
        SeekPoint seekPoint = new SeekPoint(l11, l12);
        l11 = seekPoint.timeUs;
        long l13 = l11 - l10;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 != false && n11 != (object2 = (Object)(((LongArray)(object = this.timesUs)).size() - n10))) {
            Object object3 = this.timesUs;
            l11 = ((LongArray)object3).get(n11 += n10);
            long l14 = this.positions.get(n11);
            object = new SeekPoint(l11, l14);
            object3 = new SeekMap$SeekPoints(seekPoint, (SeekPoint)object);
            return object3;
        }
        object = new SeekMap$SeekPoints(seekPoint);
        return object;
    }

    public long getTimeUs(long l10) {
        LongArray longArray = this.positions;
        boolean bl2 = true;
        int n10 = Util.binarySearchFloor(longArray, l10, bl2, bl2);
        return this.timesUs.get(n10);
    }

    public boolean isSeekable() {
        return true;
    }

    public boolean isTimeUsInIndex(long l10) {
        LongArray longArray = this.timesUs;
        int n10 = longArray.size();
        int n11 = 1;
        long l11 = longArray.get(n10 -= n11);
        long l12 = (l10 -= l11) - (l11 = 100000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object >= 0) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public void maybeAddSeekPoint(long l10, long l11) {
        boolean bl2 = this.isTimeUsInIndex(l10);
        if (bl2) {
            return;
        }
        this.timesUs.add(l10);
        this.positions.add(l11);
    }

    public void setDurationUs(long l10) {
        this.durationUs = l10;
    }
}

