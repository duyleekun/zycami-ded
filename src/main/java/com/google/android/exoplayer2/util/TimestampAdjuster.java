/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.util.Assertions;

public final class TimestampAdjuster {
    public static final long DO_NOT_OFFSET = Long.MAX_VALUE;
    private static final long MAX_PTS_PLUS_ONE = 0x200000000L;
    private long firstSampleTimestampUs;
    private volatile long lastSampleTimestampUs = -9223372036854775807L;
    private long timestampOffsetUs;

    public TimestampAdjuster(long l10) {
        this.setFirstSampleTimestampUs(l10);
    }

    public static long ptsToUs(long l10) {
        return l10 * 1000000L / 90000L;
    }

    public static long usToNonWrappedPts(long l10) {
        return l10 * 90000L / 1000000L;
    }

    public static long usToWrappedPts(long l10) {
        return TimestampAdjuster.usToNonWrappedPts(l10) % 0x200000000L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long adjustSampleTimestamp(long l10) {
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        long l13 = this.lastSampleTimestampUs;
        long l14 = l13 - l11;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false) {
            this.lastSampleTimestampUs = l10;
        } else {
            l11 = this.firstSampleTimestampUs;
            l13 = Long.MAX_VALUE;
            long l15 = l11 - l13;
            object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (object != false) {
                this.timestampOffsetUs = l11 -= l10;
            }
            synchronized (this) {
                this.lastSampleTimestampUs = l10;
                this.notifyAll();
            }
        }
        l11 = this.timestampOffsetUs;
        return l10 + l11;
    }

    public long adjustTsTimestamp(long l10) {
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        long l13 = this.lastSampleTimestampUs;
        long l14 = l13 - l11;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 != false) {
            long l15;
            l11 = TimestampAdjuster.usToNonWrappedPts(this.lastSampleTimestampUs);
            l13 = 0x100000000L + l11;
            long l16 = 0x200000000L;
            long l17 = ((l13 /= l16) - 1L) * l16 + l10;
            if ((object2 = (l15 = (l13 = Math.abs(l17 - l11)) - (l11 = Math.abs((l10 += (l13 *= l16)) - l11))) == 0L ? 0 : (l15 < 0L ? -1 : 1)) < 0) {
                l10 = l17;
            }
        }
        l10 = TimestampAdjuster.ptsToUs(l10);
        return this.adjustSampleTimestamp(l10);
    }

    public long getFirstSampleTimestampUs() {
        return this.firstSampleTimestampUs;
    }

    public long getLastAdjustedTimestampUs() {
        long l10 = this.lastSampleTimestampUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            l10 = this.lastSampleTimestampUs;
            l11 = this.timestampOffsetUs + l10;
        } else {
            l10 = this.firstSampleTimestampUs;
            long l13 = Long.MAX_VALUE;
            long l14 = l10 - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 != false) {
                l11 = l10;
            }
        }
        return l11;
    }

    public long getTimestampOffsetUs() {
        long l10 = this.firstSampleTimestampUs;
        long l11 = Long.MAX_VALUE;
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l12 = -9223372036854775807L;
        if (object == false) {
            l12 = 0L;
        } else {
            long l13 = this.lastSampleTimestampUs;
            long l14 = l13 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) {
                l12 = this.timestampOffsetUs;
            }
        }
        return l12;
    }

    public void reset() {
        this.lastSampleTimestampUs = -9223372036854775807L;
    }

    public void setFirstSampleTimestampUs(long l10) {
        synchronized (this) {
            long l11 = this.lastSampleTimestampUs;
            long l12 = -9223372036854775807L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            l13 = l13 == false ? (long)1 : (long)0;
            Assertions.checkState((boolean)l13);
            this.firstSampleTimestampUs = l10;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void waitUntilInitialized() {
        synchronized (this) {
            long l10;
            long l11;
            long l12;
            long l13;
            while ((l13 = (l12 = (l11 = this.lastSampleTimestampUs) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                this.wait();
            }
            return;
        }
    }
}

