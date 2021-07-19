/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSearchResult;
import com.google.android.exoplayer2.extractor.BinarySearchSeeker$TimestampSeeker;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker;
import com.google.android.exoplayer2.extractor.ts.PsBinarySearchSeeker$1;
import com.google.android.exoplayer2.extractor.ts.PsDurationReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class PsBinarySearchSeeker$PsScrSeeker
implements BinarySearchSeeker$TimestampSeeker {
    private final ParsableByteArray packetBuffer;
    private final TimestampAdjuster scrTimestampAdjuster;

    private PsBinarySearchSeeker$PsScrSeeker(TimestampAdjuster object) {
        this.scrTimestampAdjuster = object;
        this.packetBuffer = object = new ParsableByteArray();
    }

    public /* synthetic */ PsBinarySearchSeeker$PsScrSeeker(TimestampAdjuster timestampAdjuster, PsBinarySearchSeeker$1 psBinarySearchSeeker$1) {
        this(timestampAdjuster);
    }

    private BinarySearchSeeker$TimestampSearchResult searchForScrValueInBuffer(ParsableByteArray parsableByteArray, long l10, long l11) {
        int n10;
        int n11;
        int n12 = -1;
        long l12 = -9223372036854775807L;
        int n13 = n12;
        long l13 = l12;
        while ((n11 = parsableByteArray.bytesLeft()) >= (n10 = 4)) {
            byte[] byArray = parsableByteArray.getData();
            int n14 = parsableByteArray.getPosition();
            n11 = PsBinarySearchSeeker.access$100(byArray, n14);
            if (n11 != (n14 = 442)) {
                n11 = 1;
                parsableByteArray.skipBytes(n11);
                continue;
            }
            parsableByteArray.skipBytes(n10);
            long l14 = PsDurationReader.readScrValueFromPack(parsableByteArray);
            n12 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
            if (n12 != 0) {
                TimestampAdjuster timestampAdjuster = this.scrTimestampAdjuster;
                long l15 = (l14 = timestampAdjuster.adjustTsTimestamp(l14)) - l10;
                n12 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                if (n12 > 0) {
                    Object object = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                    if (object == false) {
                        return BinarySearchSeeker$TimestampSearchResult.overestimatedResult(l14, l11);
                    }
                    long l16 = n13;
                    return BinarySearchSeeker$TimestampSearchResult.targetFoundResult(l11 + l16);
                }
                long l17 = 100000L + l14;
                long l18 = l17 - l10;
                n12 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                if (n12 > 0) {
                    long l19 = parsableByteArray.getPosition();
                    return BinarySearchSeeker$TimestampSearchResult.targetFoundResult(l11 + l19);
                }
                n13 = n12 = parsableByteArray.getPosition();
                l13 = l14;
            }
            PsBinarySearchSeeker$PsScrSeeker.skipToEndOfCurrentPack(parsableByteArray);
            n12 = parsableByteArray.getPosition();
        }
        Object object = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
        if (object != false) {
            long l20 = n12;
            return BinarySearchSeeker$TimestampSearchResult.underestimatedResult(l13, l11 += l20);
        }
        return BinarySearchSeeker$TimestampSearchResult.NO_TIMESTAMP_IN_RANGE_RESULT;
    }

    private static void skipToEndOfCurrentPack(ParsableByteArray parsableByteArray) {
        int n10;
        int n11 = parsableByteArray.limit();
        int n12 = parsableByteArray.bytesLeft();
        if (n12 < (n10 = 10)) {
            parsableByteArray.setPosition(n11);
            return;
        }
        parsableByteArray.skipBytes(9);
        n12 = parsableByteArray.readUnsignedByte() & 7;
        n10 = parsableByteArray.bytesLeft();
        if (n10 < n12) {
            parsableByteArray.setPosition(n11);
            return;
        }
        parsableByteArray.skipBytes(n12);
        n12 = parsableByteArray.bytesLeft();
        n10 = 4;
        if (n12 < n10) {
            parsableByteArray.setPosition(n11);
            return;
        }
        byte[] byArray = parsableByteArray.getData();
        int n13 = parsableByteArray.getPosition();
        n12 = PsBinarySearchSeeker.access$100(byArray, n13);
        if (n12 == (n13 = 443)) {
            parsableByteArray.skipBytes(n10);
            n12 = parsableByteArray.readUnsignedShort();
            n13 = parsableByteArray.bytesLeft();
            if (n13 < n12) {
                parsableByteArray.setPosition(n11);
                return;
            }
            parsableByteArray.skipBytes(n12);
        }
        while ((n12 = parsableByteArray.bytesLeft()) >= n10) {
            byArray = parsableByteArray.getData();
            n13 = parsableByteArray.getPosition();
            n12 = PsBinarySearchSeeker.access$100(byArray, n13);
            if (n12 == (n13 = 442) || n12 == (n13 = 441) || (n12 >>>= 8) != (n13 = 1)) break;
            parsableByteArray.skipBytes(n10);
            n12 = parsableByteArray.bytesLeft();
            n13 = 2;
            if (n12 < n13) {
                parsableByteArray.setPosition(n11);
                return;
            }
            n12 = parsableByteArray.readUnsignedShort();
            n13 = parsableByteArray.limit();
            int n14 = parsableByteArray.getPosition() + n12;
            n12 = Math.min(n13, n14);
            parsableByteArray.setPosition(n12);
        }
    }

    public void onSeekFinished() {
        ParsableByteArray parsableByteArray = this.packetBuffer;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(byArray);
    }

    public BinarySearchSeeker$TimestampSearchResult searchForTimestamp(ExtractorInput extractorInput, long l10) {
        long l11 = extractorInput.getPosition();
        long l12 = extractorInput.getLength() - l11;
        int n10 = (int)Math.min(20000L, l12);
        this.packetBuffer.reset(n10);
        Object object = this.packetBuffer.getData();
        extractorInput.peekFully((byte[])object, 0, n10);
        object = this.packetBuffer;
        return this.searchForScrValueInBuffer((ParsableByteArray)object, l10, l11);
    }
}

