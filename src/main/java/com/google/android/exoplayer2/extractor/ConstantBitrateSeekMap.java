/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;

public class ConstantBitrateSeekMap
implements SeekMap {
    private final int bitrate;
    private final long dataSize;
    private final long durationUs;
    private final long firstFrameBytePosition;
    private final int frameSize;
    private final long inputLength;

    public ConstantBitrateSeekMap(long l10, long l11, int n10, int n11) {
        this.inputLength = l10;
        this.firstFrameBytePosition = l11;
        int n12 = -1;
        if (n11 == n12) {
            n11 = 1;
        }
        this.frameSize = n11;
        this.bitrate = n10;
        long l12 = -1;
        long l13 = l10 - l12;
        n11 = (int)(l13 == 0L ? 0 : (l13 < 0L ? -1 : 1));
        if (n11 == 0) {
            this.dataSize = l12;
            this.durationUs = l10 = -9223372036854775807L;
        } else {
            this.dataSize = l12 = l10 - l11;
            this.durationUs = l10 = ConstantBitrateSeekMap.getTimeUsAtPosition(l10, l11, n10);
        }
    }

    private long getFramePositionForTimeUs(long l10) {
        long l11 = this.bitrate;
        l10 = l10 * l11 / 8000000L;
        int n10 = this.frameSize;
        long l12 = n10;
        l10 /= l12;
        l12 = n10;
        long l13 = l10 * l12;
        l10 = this.dataSize;
        l11 = n10;
        long l14 = l10 - l11;
        l10 = Util.constrainValue(l13, 0L, l14);
        return this.firstFrameBytePosition + l10;
    }

    private static long getTimeUsAtPosition(long l10, long l11, int n10) {
        l10 -= l11;
        l10 = Math.max(0L, l10) * (long)8 * 1000000L;
        l11 = n10;
        return l10 / l11;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        long l11;
        long l12;
        long l13;
        long l14 = this.dataSize;
        long l15 = -1;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            l15 = this.firstFrameBytePosition;
            SeekPoint seekPoint = new SeekPoint(0L, l15);
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
            return seekMap$SeekPoints;
        }
        l14 = this.getFramePositionForTimeUs(l10);
        l15 = this.getTimeUsAtPosition(l14);
        SeekPoint seekPoint = new SeekPoint(l15, l14);
        Object object2 = l15 == l10 ? 0 : (l15 < l10 ? -1 : 1);
        if (object2 < 0 && (l13 = (l12 = (l15 = (long)(object2 = (Object)this.frameSize) + l14) - (l11 = this.inputLength)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            l10 = object2;
            l14 += l10;
            l10 = this.getTimeUsAtPosition(l14);
            SeekPoint seekPoint2 = new SeekPoint(l10, l14);
            SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint, seekPoint2);
            return seekMap$SeekPoints;
        }
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public long getTimeUsAtPosition(long l10) {
        long l11 = this.firstFrameBytePosition;
        int n10 = this.bitrate;
        return ConstantBitrateSeekMap.getTimeUsAtPosition(l10, l11, n10);
    }

    public boolean isSeekable() {
        long l10 = this.dataSize;
        long l11 = -1;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object != false ? (Object)1 : (Object)0;
        return (boolean)object;
    }
}

