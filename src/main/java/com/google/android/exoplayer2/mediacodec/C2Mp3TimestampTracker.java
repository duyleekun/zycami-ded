/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.MpegAudioUtil;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;

public final class C2Mp3TimestampTracker {
    private static final long DECODER_DELAY_SAMPLES = 529L;
    private static final String TAG = "C2Mp3TimestampTracker";
    private long anchorTimestampUs;
    private long processedSamples;
    private boolean seenInvalidMpegAudioHeader;

    private long getProcessedDurationUs(Format format) {
        long l10 = this.processedSamples * 1000000L;
        long l11 = format.sampleRate;
        return l10 / l11;
    }

    public void reset() {
        long l10;
        this.processedSamples = l10 = 0L;
        this.anchorTimestampUs = l10;
        this.seenInvalidMpegAudioHeader = false;
    }

    public long updateAndGetPresentationTimeUs(Format format, DecoderInputBuffer decoderInputBuffer) {
        int n10;
        int n11;
        int n12 = this.seenInvalidMpegAudioHeader;
        if (n12 != 0) {
            return decoderInputBuffer.timeUs;
        }
        ByteBuffer byteBuffer = (ByteBuffer)Assertions.checkNotNull(decoderInputBuffer.data);
        int n13 = 0;
        for (n11 = 0; n11 < (n10 = 4); ++n11) {
            n13 <<= 8;
            n10 = byteBuffer.get(n11) & 0xFF;
            n13 |= n10;
        }
        n12 = MpegAudioUtil.parseMpegAudioFrameSampleCount(n13);
        if (n12 == (n11 = -1)) {
            this.seenInvalidMpegAudioHeader = true;
            Log.w(TAG, "MPEG audio header is invalid.");
            return decoderInputBuffer.timeUs;
        }
        long l10 = this.processedSamples;
        long l11 = 0L;
        long l12 = l10 - l11;
        n11 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
        if (n11 == 0) {
            long l13;
            long l14;
            this.anchorTimestampUs = l14 = decoderInputBuffer.timeUs;
            this.processedSamples = l13 = (long)n12 - 529L;
            return l14;
        }
        long l15 = this.getProcessedDurationUs(format);
        l10 = this.processedSamples;
        l11 = n12;
        this.processedSamples = l10 += l11;
        return this.anchorTimestampUs + l15;
    }
}

