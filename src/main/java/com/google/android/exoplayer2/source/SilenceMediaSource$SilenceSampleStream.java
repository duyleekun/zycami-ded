/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.decoder.Buffer;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.SilenceMediaSource;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class SilenceMediaSource$SilenceSampleStream
implements SampleStream {
    private final long durationBytes;
    private long positionBytes;
    private boolean sentFormat;

    public SilenceMediaSource$SilenceSampleStream(long l10) {
        this.durationBytes = l10 = SilenceMediaSource.access$300(l10);
        this.seekTo(0L);
    }

    public boolean isReady() {
        return true;
    }

    public void maybeThrowError() {
    }

    public int readData(FormatHolder formatHolder, DecoderInputBuffer object, boolean bl2) {
        boolean bl3 = this.sentFormat;
        int n10 = 1;
        if (bl3 && !bl2) {
            long l10 = this.durationBytes;
            long l11 = this.positionBytes;
            long l12 = 0L;
            long l13 = (l10 -= l11) - l12;
            long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            int n11 = -4;
            if (l14 == false) {
                ((Buffer)object).addFlag(4);
                return n11;
            }
            ((DecoderInputBuffer)object).timeUs = l11 = SilenceMediaSource.access$400(l11);
            ((Buffer)object).addFlag(n10);
            l14 = (long)((DecoderInputBuffer)object).isFlagsOnly();
            if (l14 != false) {
                return n11;
            }
            l14 = (int)Math.min((long)SilenceMediaSource.access$500().length, l10);
            ((DecoderInputBuffer)object).ensureSpaceForWrite((int)l14);
            object = ((DecoderInputBuffer)object).data;
            byte[] byArray = SilenceMediaSource.access$500();
            ((ByteBuffer)object).put(byArray, 0, (int)l14);
            long l15 = this.positionBytes;
            long l16 = l14;
            this.positionBytes = l15 += l16;
            return n11;
        }
        formatHolder.format = object = SilenceMediaSource.access$200();
        this.sentFormat = n10;
        return -5;
    }

    public void seekTo(long l10) {
        long l11 = SilenceMediaSource.access$300(l10);
        long l12 = this.durationBytes;
        this.positionBytes = l10 = Util.constrainValue(l11, 0L, l12);
    }

    public int skipData(long l10) {
        long l11 = this.positionBytes;
        this.seekTo(l10);
        l10 = this.positionBytes - l11;
        l11 = SilenceMediaSource.access$500().length;
        return (int)(l10 / l11);
    }
}

