/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom;
import com.google.android.exoplayer2.extractor.mp4.AtomParsers$SampleSizeBox;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class AtomParsers$Stz2SampleSizeBox
implements AtomParsers$SampleSizeBox {
    private int currentByte;
    private final ParsableByteArray data;
    private final int fieldSize;
    private final int sampleCount;
    private int sampleIndex;

    public AtomParsers$Stz2SampleSizeBox(Atom$LeafAtom object) {
        int n10;
        int n11;
        this.data = object = ((Atom$LeafAtom)object).data;
        ((ParsableByteArray)object).setPosition(12);
        this.fieldSize = n11 = ((ParsableByteArray)object).readUnsignedIntToInt() & 0xFF;
        this.sampleCount = n10 = ((ParsableByteArray)object).readUnsignedIntToInt();
    }

    public int getFixedSampleSize() {
        return -1;
    }

    public int getSampleCount() {
        return this.sampleCount;
    }

    public int readNextSampleSize() {
        int n10 = this.fieldSize;
        int n11 = 8;
        if (n10 == n11) {
            return this.data.readUnsignedByte();
        }
        n11 = 16;
        if (n10 == n11) {
            return this.data.readUnsignedShort();
        }
        n10 = this.sampleIndex;
        this.sampleIndex = n11 = n10 + 1;
        if ((n10 %= 2) == 0) {
            this.currentByte = n10 = this.data.readUnsignedByte();
            return (n10 & 0xF0) >> 4;
        }
        return this.currentByte & 0xF;
    }
}

