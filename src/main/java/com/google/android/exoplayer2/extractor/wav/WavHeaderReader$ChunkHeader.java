/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.wav;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class WavHeaderReader$ChunkHeader {
    public static final int SIZE_IN_BYTES = 8;
    public final int id;
    public final long size;

    private WavHeaderReader$ChunkHeader(int n10, long l10) {
        this.id = n10;
        this.size = l10;
    }

    public static WavHeaderReader$ChunkHeader peek(ExtractorInput extractorInput, ParsableByteArray object) {
        byte[] byArray = ((ParsableByteArray)object).getData();
        extractorInput.peekFully(byArray, 0, 8);
        ((ParsableByteArray)object).setPosition(0);
        int n10 = ((ParsableByteArray)object).readInt();
        long l10 = ((ParsableByteArray)object).readLittleEndianUnsignedInt();
        object = new WavHeaderReader$ChunkHeader(n10, l10);
        return object;
    }
}

