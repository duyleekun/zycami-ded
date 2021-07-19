/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class PsDurationReader {
    private static final int TIMESTAMP_SEARCH_BYTES = 20000;
    private long durationUs;
    private long firstScrValue;
    private boolean isDurationRead;
    private boolean isFirstScrValueRead;
    private boolean isLastScrValueRead;
    private long lastScrValue;
    private final ParsableByteArray packetBuffer;
    private final TimestampAdjuster scrTimestampAdjuster;

    public PsDurationReader() {
        long l10;
        Object object = new TimestampAdjuster(0L);
        this.scrTimestampAdjuster = object;
        this.firstScrValue = l10 = -9223372036854775807L;
        this.lastScrValue = l10;
        this.durationUs = l10;
        this.packetBuffer = object = new ParsableByteArray();
    }

    private static boolean checkMarkerBits(byte[] byArray) {
        int n10 = 0;
        int n11 = byArray[0] & 0xC4;
        int n12 = 68;
        if (n11 != n12) {
            return false;
        }
        n11 = byArray[2];
        n12 = 4;
        if ((n11 &= n12) != n12) {
            return false;
        }
        n11 = byArray[n12] & n12;
        if (n11 != n12) {
            return false;
        }
        n11 = byArray[5];
        n12 = 1;
        if ((n11 &= n12) != n12) {
            return false;
        }
        int n13 = byArray[8];
        n11 = 3;
        if ((n13 &= n11) == n11) {
            n10 = n12;
        }
        return n10 != 0;
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.packetBuffer;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(byArray);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int peekIntAtPosition(byte[] byArray, int n10) {
        int n11 = (byArray[n10] & 0xFF) << 24;
        int n12 = n10 + 1;
        n12 = (byArray[n12] & 0xFF) << 16;
        n11 |= n12;
        n12 = n10 + 2;
        n12 = (byArray[n12] & 0xFF) << 8;
        return byArray[n10 += 3] & 0xFF | (n11 |= n12);
    }

    private int readFirstScrValue(ExtractorInput object, PositionHolder object2) {
        long l10;
        long l11 = object.getLength();
        long l12 = 20000L;
        l11 = Math.min(l12, l11);
        int n10 = (int)l11;
        long l13 = object.getPosition();
        long l14 = 0;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n11 = 1;
        if (l15 != false) {
            ((PositionHolder)object2).position = l14;
            return n11;
        }
        this.packetBuffer.reset(n10);
        object.resetPeekPosition();
        object2 = this.packetBuffer.getData();
        object.peekFully((byte[])object2, 0, n10);
        object = this.packetBuffer;
        this.firstScrValue = l10 = this.readFirstScrValueFromBuffer((ParsableByteArray)object);
        this.isFirstScrValueRead = n11;
        return 0;
    }

    private long readFirstScrValueFromBuffer(ParsableByteArray parsableByteArray) {
        long l10;
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit();
        while (true) {
            int n12;
            int n13 = n11 + -3;
            l10 = -9223372036854775807L;
            if (n10 >= n13) break;
            byte[] byArray = parsableByteArray.getData();
            n13 = this.peekIntAtPosition(byArray, n10);
            if (n13 == (n12 = 442)) {
                n13 = n10 + 4;
                parsableByteArray.setPosition(n13);
                long l11 = PsDurationReader.readScrValueFromPack(parsableByteArray);
                n13 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
                if (n13 != 0) {
                    return l11;
                }
            }
            ++n10;
        }
        return l10;
    }

    private int readLastScrValue(ExtractorInput object, PositionHolder object2) {
        long l10;
        long l11 = object.getLength();
        long l12 = Math.min(20000L, l11);
        int n10 = (int)l12;
        long l13 = n10;
        l11 -= l13;
        l13 = object.getPosition();
        long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
        int n11 = 1;
        if (l14 != false) {
            ((PositionHolder)object2).position = l11;
            return n11;
        }
        this.packetBuffer.reset(n10);
        object.resetPeekPosition();
        object2 = this.packetBuffer.getData();
        object.peekFully((byte[])object2, 0, n10);
        object = this.packetBuffer;
        this.lastScrValue = l10 = this.readLastScrValueFromBuffer((ParsableByteArray)object);
        this.isLastScrValueRead = n11;
        return 0;
    }

    private long readLastScrValueFromBuffer(ParsableByteArray parsableByteArray) {
        long l10;
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.limit() + -4;
        while (true) {
            int n12;
            l10 = -9223372036854775807L;
            if (n11 < n10) break;
            byte[] byArray = parsableByteArray.getData();
            int n13 = this.peekIntAtPosition(byArray, n11);
            if (n13 == (n12 = 442)) {
                n13 = n11 + 4;
                parsableByteArray.setPosition(n13);
                long l11 = PsDurationReader.readScrValueFromPack(parsableByteArray);
                long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
                if (l12 != false) {
                    return l11;
                }
            }
            n11 += -1;
        }
        return l10;
    }

    public static long readScrValueFromPack(ParsableByteArray parsableByteArray) {
        int n10 = parsableByteArray.getPosition();
        int n11 = parsableByteArray.bytesLeft();
        long l10 = -9223372036854775807L;
        int n12 = 9;
        if (n11 < n12) {
            return l10;
        }
        byte[] byArray = new byte[n12];
        parsableByteArray.readBytes(byArray, 0, n12);
        parsableByteArray.setPosition(n10);
        boolean bl2 = PsDurationReader.checkMarkerBits(byArray);
        if (!bl2) {
            return l10;
        }
        return PsDurationReader.readScrValueFromPackHeader(byArray);
    }

    private static long readScrValueFromPackHeader(byte[] byArray) {
        long l10 = (long)byArray[0] & (long)56;
        int n10 = 3;
        l10 = l10 >> n10 << 30;
        long l11 = byArray[0];
        long l12 = 3;
        l11 = (l11 & l12) << 28;
        long l13 = l10 | l11;
        l11 = byArray[1];
        long l14 = 255L;
        l11 = (l11 & l14) << 20;
        l13 |= l11;
        int n11 = 2;
        l11 = byArray[n11];
        long l15 = 248L;
        l11 = (l11 & l15) >> n10 << 15;
        l13 |= l11;
        l11 = ((long)byArray[n11] & l12) << 13;
        l13 |= l11;
        l11 = ((long)byArray[n10] & l14) << 5;
        long l16 = ((long)byArray[4] & l15) >> n10;
        return (l13 |= l11) | l16;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getScrTimestampAdjuster() {
        return this.scrTimestampAdjuster;
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder object) {
        Object object2 = this.isLastScrValueRead;
        if (!object2) {
            return this.readLastScrValue(extractorInput, (PositionHolder)object);
        }
        long l10 = this.lastScrValue;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object2) {
            return this.finishReadDuration(extractorInput);
        }
        object2 = this.isFirstScrValueRead;
        if (!object2) {
            return this.readFirstScrValue(extractorInput, (PositionHolder)object);
        }
        l10 = this.firstScrValue;
        long l13 = l10 - l11;
        Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object3 == false) {
            return this.finishReadDuration(extractorInput);
        }
        l10 = this.scrTimestampAdjuster.adjustTsTimestamp(l10);
        object = this.scrTimestampAdjuster;
        l11 = this.lastScrValue;
        this.durationUs = l11 = ((TimestampAdjuster)object).adjustTsTimestamp(l11) - l10;
        return this.finishReadDuration(extractorInput);
    }
}

