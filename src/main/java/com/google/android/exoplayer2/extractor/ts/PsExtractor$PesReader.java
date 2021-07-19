/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.extractor.ts.ElementaryStreamReader;
import com.google.android.exoplayer2.util.ParsableBitArray;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;

public final class PsExtractor$PesReader {
    private static final int PES_SCRATCH_SIZE = 64;
    private boolean dtsFlag;
    private int extendedHeaderLength;
    private final ElementaryStreamReader pesPayloadReader;
    private final ParsableBitArray pesScratch;
    private boolean ptsFlag;
    private boolean seenFirstDts;
    private long timeUs;
    private final TimestampAdjuster timestampAdjuster;

    public PsExtractor$PesReader(ElementaryStreamReader object, TimestampAdjuster object2) {
        this.pesPayloadReader = object;
        this.timestampAdjuster = object2;
        object2 = new byte[64];
        this.pesScratch = object = new ParsableBitArray((byte[])object2);
    }

    private void parseHeader() {
        int n10;
        ParsableBitArray parsableBitArray = this.pesScratch;
        int n11 = 8;
        parsableBitArray.skipBits(n11);
        this.ptsFlag = n10 = this.pesScratch.readBit();
        this.dtsFlag = n10 = this.pesScratch.readBit();
        this.pesScratch.skipBits(6);
        this.extendedHeaderLength = n10 = this.pesScratch.readBits(n11);
    }

    private void parseHeaderExtension() {
        long l10;
        this.timeUs = l10 = 0L;
        int n10 = this.ptsFlag;
        if (n10 != 0) {
            Object object = this.pesScratch;
            int n11 = 4;
            ((ParsableBitArray)object).skipBits(n11);
            object = this.pesScratch;
            int n12 = 3;
            long l11 = ((ParsableBitArray)object).readBits(n12);
            n10 = 30;
            l11 <<= n10;
            ParsableBitArray parsableBitArray = this.pesScratch;
            int n13 = 1;
            parsableBitArray.skipBits(n13);
            parsableBitArray = this.pesScratch;
            int n14 = 15;
            long l12 = parsableBitArray.readBits(n14) << n14;
            l11 |= l12;
            this.pesScratch.skipBits(n13);
            l12 = this.pesScratch.readBits(n14);
            l11 |= l12;
            parsableBitArray = this.pesScratch;
            parsableBitArray.skipBits(n13);
            boolean bl2 = this.seenFirstDts;
            if (!bl2 && (bl2 = this.dtsFlag)) {
                parsableBitArray = this.pesScratch;
                parsableBitArray.skipBits(n11);
                ParsableBitArray parsableBitArray2 = this.pesScratch;
                n11 = parsableBitArray2.readBits(n12);
                long l13 = n11;
                l10 = l13 << n10;
                this.pesScratch.skipBits(n13);
                l12 = this.pesScratch.readBits(n14) << n14;
                l10 |= l12;
                this.pesScratch.skipBits(n13);
                n12 = this.pesScratch.readBits(n14);
                long l14 = n12;
                this.pesScratch.skipBits(n13);
                TimestampAdjuster timestampAdjuster = this.timestampAdjuster;
                timestampAdjuster.adjustTsTimestamp(l10 |= l14);
                this.seenFirstDts = n13;
            }
            object = this.timestampAdjuster;
            this.timeUs = l10 = ((TimestampAdjuster)object).adjustTsTimestamp(l11);
        }
    }

    public void consume(ParsableByteArray parsableByteArray) {
        Object object = this.pesScratch.data;
        parsableByteArray.readBytes((byte[])object, 0, 3);
        this.pesScratch.setPosition(0);
        this.parseHeader();
        object = this.pesScratch.data;
        int n10 = this.extendedHeaderLength;
        parsableByteArray.readBytes((byte[])object, 0, n10);
        this.pesScratch.setPosition(0);
        this.parseHeaderExtension();
        object = this.pesPayloadReader;
        long l10 = this.timeUs;
        object.packetStarted(l10, 4);
        this.pesPayloadReader.consume(parsableByteArray);
        this.pesPayloadReader.packetFinished();
    }

    public void seek() {
        this.seenFirstDts = false;
        this.pesPayloadReader.seek();
    }
}

