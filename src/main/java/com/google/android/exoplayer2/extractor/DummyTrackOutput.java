/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.extractor;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.TrackOutput$CryptoData;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.EOFException;

public final class DummyTrackOutput
implements TrackOutput {
    private final byte[] readBuffer;

    public DummyTrackOutput() {
        byte[] byArray = new byte[4096];
        this.readBuffer = byArray;
    }

    public void format(Format format) {
    }

    public int sampleData(DataReader object, int n10, boolean bl2, int n11) {
        n11 = this.readBuffer.length;
        n10 = Math.min(n11, n10);
        byte[] byArray = this.readBuffer;
        int n12 = object.read(byArray, 0, n10);
        if (n12 == (n10 = -1)) {
            if (bl2) {
                return n10;
            }
            object = new EOFException();
            throw object;
        }
        return n12;
    }

    public void sampleData(ParsableByteArray parsableByteArray, int n10, int n11) {
        parsableByteArray.skipBytes(n10);
    }

    public void sampleMetadata(long l10, int n10, int n11, int n12, TrackOutput$CryptoData trackOutput$CryptoData) {
    }
}

