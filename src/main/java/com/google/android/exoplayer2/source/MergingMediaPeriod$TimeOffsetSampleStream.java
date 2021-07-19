/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;

public final class MergingMediaPeriod$TimeOffsetSampleStream
implements SampleStream {
    private final SampleStream sampleStream;
    private final long timeOffsetUs;

    public MergingMediaPeriod$TimeOffsetSampleStream(SampleStream sampleStream, long l10) {
        this.sampleStream = sampleStream;
        this.timeOffsetUs = l10;
    }

    public SampleStream getChildStream() {
        return this.sampleStream;
    }

    public boolean isReady() {
        return this.sampleStream.isReady();
    }

    public void maybeThrowError() {
        this.sampleStream.maybeThrowError();
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean n10) {
        SampleStream sampleStream = this.sampleStream;
        int n11 = sampleStream.readData(formatHolder, decoderInputBuffer, n10 != 0);
        if (n11 == (n10 = -4)) {
            long l10;
            long l11 = decoderInputBuffer.timeUs;
            long l12 = this.timeOffsetUs;
            decoderInputBuffer.timeUs = l10 = Math.max(0L, l11 += l12);
        }
        return n11;
    }

    public int skipData(long l10) {
        SampleStream sampleStream = this.sampleStream;
        long l11 = this.timeOffsetUs;
        return sampleStream.skipData(l10 -= l11);
    }
}

