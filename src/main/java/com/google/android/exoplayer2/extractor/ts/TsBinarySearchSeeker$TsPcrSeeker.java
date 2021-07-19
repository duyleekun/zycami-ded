/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ts.TsUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class TsBinarySearchSeeker$TsPcrSeeker
implements BinarySearchSeeker$TimestampSeeker {
    private final ParsableByteArray packetBuffer;
    private final int pcrPid;
    private final TimestampAdjuster pcrTimestampAdjuster;
    private final int timestampSearchBytes;

    public TsBinarySearchSeeker$TsPcrSeeker(int n10, TimestampAdjuster timestampAdjuster, int n11) {
        ParsableByteArray parsableByteArray;
        this.pcrPid = n10;
        this.pcrTimestampAdjuster = timestampAdjuster;
        this.timestampSearchBytes = n11;
        this.packetBuffer = parsableByteArray = new ParsableByteArray();
    }

    private BinarySearchSeeker$TimestampSearchResult searchForPcrValueInBuffer(ParsableByteArray parsableByteArray, long l10, long l11) {
        long l12;
        int n10;
        int n11;
        TsBinarySearchSeeker$TsPcrSeeker tsBinarySearchSeeker$TsPcrSeeker = this;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        long l13 = l11;
        int n12 = parsableByteArray.limit();
        long l14 = -1;
        long l15 = -9223372036854775807L;
        long l16 = l14;
        long l17 = l15;
        while ((n11 = parsableByteArray.bytesLeft()) >= (n10 = 188)) {
            byte[] byArray = parsableByteArray.getData();
            n10 = parsableByteArray.getPosition();
            n11 = TsUtil.findSyncBytePosition(byArray, n10, n12);
            if ((n10 = n11 + 188) > n12) break;
            int n13 = tsBinarySearchSeeker$TsPcrSeeker.pcrPid;
            l14 = TsUtil.readPcrFromPacket(parsableByteArray2, n11, n13);
            long l18 = l14 - l15;
            Object object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object != false) {
                TimestampAdjuster timestampAdjuster = tsBinarySearchSeeker$TsPcrSeeker.pcrTimestampAdjuster;
                long l19 = (l14 = timestampAdjuster.adjustTsTimestamp(l14)) - l10;
                object = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                if (object > 0) {
                    Object object2 = l17 == l15 ? 0 : (l17 < l15 ? -1 : 1);
                    if (object2 == false) {
                        return BinarySearchSeeker$TimestampSearchResult.overestimatedResult(l14, l13);
                    }
                    return BinarySearchSeeker$TimestampSearchResult.targetFoundResult(l13 + l16);
                }
                l16 = 100000L + l14;
                long l20 = l16 - l10;
                Object object3 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
                if (object3 > 0) {
                    long l21 = n11;
                    return BinarySearchSeeker$TimestampSearchResult.targetFoundResult(l13 + l21);
                }
                l16 = n11;
                l17 = l14;
            }
            parsableByteArray2.setPosition(n10);
            l14 = n10;
        }
        if ((l12 = l17 == l15 ? 0 : (l17 < l15 ? -1 : 1)) != false) {
            long l22 = l13 + l14;
            return BinarySearchSeeker$TimestampSearchResult.underestimatedResult(l17, l22);
        }
        return BinarySearchSeeker$TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
    }

    public void onSeekFinished() {
        ParsableByteArray parsableByteArray = this.packetBuffer;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(byArray);
    }

    public BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long l10) {
        long l11 = extractorInput.getPosition();
        long l12 = this.timestampSearchBytes;
        long l13 = extractorInput.getLength() - l11;
        int n10 = (int)Math.min(l12, l13);
        this.packetBuffer.reset(n10);
        Object object = this.packetBuffer.getData();
        extractorInput.peekFully((byte[])object, 0, n10);
        object = this.packetBuffer;
        l13 = l10;
        return this.searchForPcrValueInBuffer((ParsableByteArray)object, l10, l11);
    }
}

