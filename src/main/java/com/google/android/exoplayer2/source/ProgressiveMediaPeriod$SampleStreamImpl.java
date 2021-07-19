/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.source.SampleStream;

public final class ProgressiveMediaPeriod$SampleStreamImpl
implements SampleStream {
    public final /* synthetic */ ProgressiveMediaPeriod this$0;
    private final int track;

    public ProgressiveMediaPeriod$SampleStreamImpl(ProgressiveMediaPeriod progressiveMediaPeriod, int n10) {
        this.this$0 = progressiveMediaPeriod;
        this.track = n10;
    }

    public static /* synthetic */ int access$000(ProgressiveMediaPeriod$SampleStreamImpl progressiveMediaPeriod$SampleStreamImpl) {
        return progressiveMediaPeriod$SampleStreamImpl.track;
    }

    public boolean isReady() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.this$0;
        int n10 = this.track;
        return progressiveMediaPeriod.isReady(n10);
    }

    public void maybeThrowError() {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.this$0;
        int n10 = this.track;
        progressiveMediaPeriod.maybeThrowError(n10);
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer decoderInputBuffer, boolean bl2) {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.this$0;
        int n10 = this.track;
        return progressiveMediaPeriod.readData(n10, formatHolder, decoderInputBuffer, bl2);
    }

    public int skipData(long l10) {
        ProgressiveMediaPeriod progressiveMediaPeriod = this.this$0;
        int n10 = this.track;
        return progressiveMediaPeriod.skipData(n10, l10);
    }
}

