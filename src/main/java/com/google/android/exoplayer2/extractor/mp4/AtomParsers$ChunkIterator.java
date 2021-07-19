/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.ParsableByteArray;

public final class AtomParsers$ChunkIterator {
    private final ParsableByteArray chunkOffsets;
    private final boolean chunkOffsetsAreLongs;
    public int index;
    public final int length;
    private int nextSamplesPerChunkChangeIndex;
    public int numSamples;
    public long offset;
    private int remainingSamplesPerChunkChanges;
    private final ParsableByteArray stsc;

    public AtomParsers$ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean bl2) {
        this.stsc = parsableByteArray;
        this.chunkOffsets = parsableByteArray2;
        this.chunkOffsetsAreLongs = bl2;
        int n10 = 12;
        parsableByteArray2.setPosition(n10);
        int n11 = parsableByteArray2.readUnsignedIntToInt();
        this.length = n11;
        parsableByteArray.setPosition(n10);
        n11 = parsableByteArray.readUnsignedIntToInt();
        this.remainingSamplesPerChunkChanges = n11;
        int n12 = parsableByteArray.readInt();
        n11 = 1;
        if (n12 != n11) {
            n11 = 0;
            parsableByteArray2 = null;
        }
        Assertions.checkState(n11 != 0, "first_chunk must be 1");
        this.index = -1;
    }

    public boolean moveNext() {
        long l10;
        ParsableByteArray parsableByteArray;
        int n10 = this.index;
        int n11 = 1;
        this.index = n10 += n11;
        int n12 = this.length;
        if (n10 == n12) {
            return false;
        }
        n10 = (int)(this.chunkOffsetsAreLongs ? 1 : 0);
        if (n10 != 0) {
            parsableByteArray = this.chunkOffsets;
            l10 = parsableByteArray.readUnsignedLongToLong();
        } else {
            parsableByteArray = this.chunkOffsets;
            l10 = parsableByteArray.readUnsignedInt();
        }
        this.offset = l10;
        n10 = this.index;
        n12 = this.nextSamplesPerChunkChangeIndex;
        if (n10 == n12) {
            this.numSamples = n10 = this.stsc.readUnsignedIntToInt();
            parsableByteArray = this.stsc;
            n12 = 4;
            parsableByteArray.skipBytes(n12);
            this.remainingSamplesPerChunkChanges = n10 = this.remainingSamplesPerChunkChanges - n11;
            if (n10 > 0) {
                parsableByteArray = this.stsc;
                n10 = parsableByteArray.readUnsignedIntToInt() - n11;
            } else {
                n10 = -1;
            }
            this.nextSamplesPerChunkChangeIndex = n10;
        }
        return n11 != 0;
    }
}

