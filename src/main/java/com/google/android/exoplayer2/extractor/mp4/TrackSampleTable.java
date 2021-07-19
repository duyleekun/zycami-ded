/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.Track;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class TrackSampleTable {
    public final long durationUs;
    public final int[] flags;
    public final int maximumSize;
    public final long[] offsets;
    public final int sampleCount;
    public final int[] sizes;
    public final long[] timestampsUs;
    public final Track track;

    public TrackSampleTable(Track track, long[] lArray, int[] nArray, int n10, long[] lArray2, int[] nArray2, long l10) {
        int n11;
        int n12 = nArray.length;
        int n13 = lArray2.length;
        int n14 = 0;
        int n15 = 1;
        n12 = n12 == n13 ? n15 : 0;
        Assertions.checkArgument(n12 != 0);
        n12 = lArray.length;
        n13 = lArray2.length;
        n12 = n12 == n13 ? n15 : 0;
        Assertions.checkArgument(n12 != 0);
        n12 = nArray2.length;
        n13 = lArray2.length;
        if (n12 == n13) {
            n14 = n15;
        }
        Assertions.checkArgument(n14 != 0);
        this.track = track;
        this.offsets = lArray;
        this.sizes = nArray;
        this.maximumSize = n10;
        this.timestampsUs = lArray2;
        this.flags = nArray2;
        this.durationUs = l10;
        this.sampleCount = n11 = lArray.length;
        n11 = nArray2.length;
        if (n11 > 0) {
            n11 = nArray2.length - n15;
            int n16 = nArray2[n11];
            int n17 = 0x20000000;
            nArray2[n11] = n16 |= n17;
        }
    }

    public int getIndexOfEarlierOrEqualSynchronizationSample(long l10) {
        long[] lArray = this.timestampsUs;
        int n10 = 1;
        for (int i10 = Util.binarySearchFloor(lArray, l10, n10 != 0, false); i10 >= 0; i10 += -1) {
            int[] nArray = this.flags;
            int n11 = nArray[i10] & n10;
            if (n11 == 0) continue;
            return i10;
        }
        return -1;
    }

    public int getIndexOfLaterOrEqualSynchronizationSample(long l10) {
        Object[] objectArray;
        int n10;
        long[] lArray = this.timestampsUs;
        int n11 = 1;
        for (int i10 = Util.binarySearchCeil(lArray, l10, n11 != 0, false); i10 < (n10 = (objectArray = this.timestampsUs).length); ++i10) {
            objectArray = this.flags;
            n10 = objectArray[i10] & n11;
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }
}

