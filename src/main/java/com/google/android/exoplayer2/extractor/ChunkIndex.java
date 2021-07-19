/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekMap$SeekPoints;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.util.Util;
import java.util.Arrays;

public final class ChunkIndex
implements SeekMap {
    private final long durationUs;
    public final long[] durationsUs;
    public final int length;
    public final long[] offsets;
    public final int[] sizes;
    public final long[] timesUs;

    public ChunkIndex(int[] nArray, long[] lArray, long[] lArray2, long[] lArray3) {
        int n10;
        this.sizes = nArray;
        this.offsets = lArray;
        this.durationsUs = lArray2;
        this.timesUs = lArray3;
        this.length = n10 = nArray.length;
        if (n10 > 0) {
            int n11 = n10 + -1;
            long l10 = lArray2[n11];
            long l11 = lArray3[n10 += -1];
            this.durationUs = l10 += l11;
        } else {
            long l12;
            this.durationUs = l12 = 0L;
        }
    }

    public int getChunkIndex(long l10) {
        long[] lArray = this.timesUs;
        boolean bl2 = true;
        return Util.binarySearchFloor(lArray, l10, bl2, bl2);
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap$SeekPoints getSeekPoints(long l10) {
        int n10 = this.getChunkIndex(l10);
        long l11 = this.timesUs[n10];
        long[] lArray = this.offsets;
        long l12 = lArray[n10];
        SeekPoint seekPoint = new SeekPoint(l11, l12);
        long l13 = seekPoint.timeUs;
        long l14 = l13 - l10;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0 && n10 != (object = (Object)(this.length + -1))) {
            Object object2 = this.timesUs;
            l13 = object2[++n10];
            long l15 = this.offsets[n10];
            SeekPoint seekPoint2 = new SeekPoint(l13, l15);
            object2 = new SeekMap$SeekPoints;
            object2(seekPoint, seekPoint2);
            return object2;
        }
        SeekMap$SeekPoints seekMap$SeekPoints = new SeekMap$SeekPoints(seekPoint);
        return seekMap$SeekPoints;
    }

    public boolean isSeekable() {
        return true;
    }

    public String toString() {
        int n10 = this.length;
        String string2 = Arrays.toString(this.sizes);
        String string3 = Arrays.toString(this.offsets);
        String string4 = Arrays.toString(this.timesUs);
        String string5 = Arrays.toString(this.durationsUs);
        int n11 = String.valueOf(string2).length() + 71;
        int n12 = String.valueOf(string3).length();
        n11 += n12;
        n12 = String.valueOf(string4).length();
        n11 += n12;
        n12 = String.valueOf(string5).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        stringBuilder.append("ChunkIndex(length=");
        stringBuilder.append(n10);
        stringBuilder.append(", sizes=");
        stringBuilder.append(string2);
        stringBuilder.append(", offsets=");
        stringBuilder.append(string3);
        stringBuilder.append(", timeUs=");
        stringBuilder.append(string4);
        stringBuilder.append(", durationsUs=");
        stringBuilder.append(string5);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

