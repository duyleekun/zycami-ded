/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Pair
 */
package com.google.android.exoplayer2.extractor.mp3;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.mp3.Seeker;
import com.google.android.exoplayer2.metadata.id3.MlltFrame;
import com.google.android.exoplayer2.util.Util;

public final class MlltSeeker
implements Seeker {
    private final long durationUs;
    private final long[] referencePositions;
    private final long[] referenceTimesMs;

    private MlltSeeker(long[] lArray, long[] lArray2, long l10) {
        this.referencePositions = lArray;
        this.referenceTimesMs = lArray2;
        long l11 = -9223372036854775807L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            l12 = lArray2.length + -1;
            long l13 = lArray2[l12];
            l10 = C.msToUs(l13);
        }
        this.durationUs = l10;
    }

    public static MlltSeeker create(long l10, MlltFrame mlltFrame, long l11) {
        long l12;
        int[] nArray = mlltFrame.bytesDeviations;
        int n10 = nArray.length;
        int n11 = n10 + 1;
        long[] lArray = new long[n11];
        long[] lArray2 = new long[n11];
        lArray[0] = l10;
        lArray2[0] = l12 = 0L;
        for (int i10 = 1; i10 <= n10; ++i10) {
            int n12 = mlltFrame.bytesBetweenReference;
            int[] nArray2 = mlltFrame.bytesDeviations;
            int n13 = i10 + -1;
            int n14 = nArray2[n13];
            long l13 = n12 + n14;
            l10 += l13;
            n12 = mlltFrame.millisecondsBetweenReference;
            nArray2 = mlltFrame.millisecondsDeviations;
            n14 = nArray2[n13];
            l13 = n12 += n14;
            lArray[i10] = l10;
            lArray2[i10] = l12 += l13;
        }
        MlltSeeker mlltSeeker = new MlltSeeker(lArray, lArray2, l11);
        return mlltSeeker;
    }

    private static Pair linearlyInterpolate(long l10, long[] lArray, long[] lArray2) {
        double d10;
        int n10 = 1;
        int n11 = Util.binarySearchFloor(lArray, l10, n10 != 0, n10 != 0);
        long l11 = lArray[n11];
        long l12 = lArray2[n11];
        if ((n11 += n10) == (n10 = lArray.length)) {
            Long l13 = l11;
            Long l14 = l12;
            return Pair.create((Object)l13, (Object)l14);
        }
        long l15 = lArray[n11];
        long l16 = lArray2[n11];
        n10 = (int)(l15 == l11 ? 0 : (l15 < l11 ? -1 : 1));
        if (n10 == 0) {
            d10 = 0.0;
        } else {
            d10 = l10;
            double d11 = l11;
            d10 -= d11;
            double d12 = l15 -= l11;
            d10 /= d12;
        }
        double d13 = l16 - l12;
        l16 = (long)(d10 * d13) + l12;
        Long l17 = l10;
        Long l18 = l16;
        return Pair.create((Object)l17, (Object)l18);
    }

    public long getDataEndPosition() {
        return -1;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        long l11 = this.durationUs;
        long l12 = l10;
        l10 = C.usToMs(Util.constrainValue(l10, 0L, l11));
        long[] lArray = this.referenceTimesMs;
        long[] lArray2 = this.referencePositions;
        Pair pair = MlltSeeker.linearlyInterpolate(l10, lArray, lArray2);
        l12 = C.msToUs((Long)pair.first);
        l10 = (Long)pair.second;
        SeekPoint seekPoint = new SeekPoint(l12, l10);
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public long getTimeUs(long l10) {
        long[] lArray = this.referencePositions;
        long[] lArray2 = this.referenceTimesMs;
        return C.msToUs((Long)MlltSeeker.linearlyInterpolate((long)l10, (long[])lArray, (long[])lArray2).second);
    }

    public boolean isSeekable() {
        return true;
    }
}

