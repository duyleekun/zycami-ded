/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.ts.TsUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;

public final class TsDurationReader {
    private long durationUs;
    private long firstPcrValue;
    private boolean isDurationRead;
    private boolean isFirstPcrValueRead;
    private boolean isLastPcrValueRead;
    private long lastPcrValue;
    private final ParsableByteArray packetBuffer;
    private final TimestampAdjuster pcrTimestampAdjuster;
    private final int timestampSearchBytes;

    public TsDurationReader(int n10) {
        long l10;
        this.timestampSearchBytes = n10;
        Object object = new TimestampAdjuster(0L);
        this.pcrTimestampAdjuster = object;
        this.firstPcrValue = l10 = -9223372036854775807L;
        this.lastPcrValue = l10;
        this.durationUs = l10;
        this.packetBuffer = object = new ParsableByteArray();
    }

    private int finishReadDuration(ExtractorInput extractorInput) {
        ParsableByteArray parsableByteArray = this.packetBuffer;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        parsableByteArray.reset(byArray);
        this.isDurationRead = true;
        extractorInput.resetPeekPosition();
        return 0;
    }

    private int readFirstPcrValue(ExtractorInput object, PositionHolder object2, int n10) {
        long l10;
        long l11 = this.timestampSearchBytes;
        long l12 = object.getLength();
        l11 = Math.min(l11, l12);
        int n11 = (int)l11;
        long l13 = object.getPosition();
        long l14 = 0;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n12 = 1;
        if (l15 != false) {
            ((PositionHolder)object2).position = l14;
            return n12;
        }
        this.packetBuffer.reset(n11);
        object.resetPeekPosition();
        object2 = this.packetBuffer.getData();
        object.peekFully((byte[])object2, 0, n11);
        object = this.packetBuffer;
        this.firstPcrValue = l10 = this.readFirstPcrValueFromBuffer((ParsableByteArray)object, n10);
        this.isFirstPcrValueRead = n12;
        return 0;
    }

    private long readFirstPcrValueFromBuffer(ParsableByteArray parsableByteArray, int n10) {
        long l10;
        int n11 = parsableByteArray.getPosition();
        int n12 = parsableByteArray.limit();
        while (true) {
            long l11;
            long l12;
            long l13;
            byte by2;
            l10 = -9223372036854775807L;
            if (n11 >= n12) break;
            byte[] byArray = parsableByteArray.getData();
            byte by3 = byArray[n11];
            if (by3 == (by2 = 71) && (l13 = (l12 = (l11 = TsUtil.readPcrFromPacket(parsableByteArray, n11, n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                return l11;
            }
            ++n11;
        }
        return l10;
    }

    private int readLastPcrValue(ExtractorInput object, PositionHolder object2, int n10) {
        long l10;
        long l11 = object.getLength();
        long l12 = Math.min((long)this.timestampSearchBytes, l11);
        int n11 = (int)l12;
        long l13 = n11;
        l11 -= l13;
        l13 = object.getPosition();
        long l14 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
        int n12 = 1;
        if (l14 != false) {
            ((PositionHolder)object2).position = l11;
            return n12;
        }
        this.packetBuffer.reset(n11);
        object.resetPeekPosition();
        object2 = this.packetBuffer.getData();
        object.peekFully((byte[])object2, 0, n11);
        object = this.packetBuffer;
        this.lastPcrValue = l10 = this.readLastPcrValueFromBuffer((ParsableByteArray)object, n10);
        this.isLastPcrValueRead = n12;
        return 0;
    }

    private long readLastPcrValueFromBuffer(ParsableByteArray parsableByteArray, int n10) {
        long l10;
        int n11 = parsableByteArray.getPosition();
        int n12 = parsableByteArray.limit() + -1;
        while (true) {
            long l11;
            long l12;
            long l13;
            byte by2;
            l10 = -9223372036854775807L;
            if (n12 < n11) break;
            byte[] byArray = parsableByteArray.getData();
            byte by3 = byArray[n12];
            if (by3 == (by2 = 71) && (l13 = (l12 = (l11 = TsUtil.readPcrFromPacket(parsableByteArray, n12, n10)) - l10) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
                return l11;
            }
            n12 += -1;
        }
        return l10;
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public TimestampAdjuster getPcrTimestampAdjuster() {
        return this.pcrTimestampAdjuster;
    }

    public boolean isDurationReadFinished() {
        return this.isDurationRead;
    }

    public int readDuration(ExtractorInput extractorInput, PositionHolder positionHolder, int n10) {
        if (n10 <= 0) {
            return this.finishReadDuration(extractorInput);
        }
        Object object = this.isLastPcrValueRead;
        if (!object) {
            return this.readLastPcrValue(extractorInput, positionHolder, n10);
        }
        long l10 = this.lastPcrValue;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (!object) {
            return this.finishReadDuration(extractorInput);
        }
        object = this.isFirstPcrValueRead;
        if (!object) {
            return this.readFirstPcrValue(extractorInput, positionHolder, n10);
        }
        long l13 = this.firstPcrValue;
        long l14 = l13 - l11;
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (!object) {
            return this.finishReadDuration(extractorInput);
        }
        l13 = this.pcrTimestampAdjuster.adjustTsTimestamp(l13);
        TimestampAdjuster timestampAdjuster = this.pcrTimestampAdjuster;
        long l15 = this.lastPcrValue;
        this.durationUs = l10 = timestampAdjuster.adjustTsTimestamp(l15) - l13;
        return this.finishReadDuration(extractorInput);
    }
}

