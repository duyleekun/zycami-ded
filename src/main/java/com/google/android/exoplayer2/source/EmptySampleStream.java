/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;

public final class EmptySampleStream
implements SampleStream {
    public boolean isReady() {
        return true;
    }

    public void maybeThrowError() {
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        decoderInputBuffer.setFlags(4);
        return -4;
    }

    public int skipData(long l10) {
        return 0;
    }
}

