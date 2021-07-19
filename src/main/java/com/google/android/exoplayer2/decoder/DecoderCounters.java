/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.decoder;

public final class DecoderCounters {
    public int decoderInitCount;
    public int decoderReleaseCount;
    public int droppedBufferCount;
    public int droppedToKeyframeCount;
    public int inputBufferCount;
    public int maxConsecutiveDroppedBufferCount;
    public int renderedOutputBufferCount;
    public int skippedInputBufferCount;
    public int skippedOutputBufferCount;
    public long totalVideoFrameProcessingOffsetUs;
    public int videoFrameProcessingOffsetCount;

    private void addVideoFrameProcessingOffsets(long l10, int n10) {
        int n11;
        long l11;
        this.totalVideoFrameProcessingOffsetUs = l11 = this.totalVideoFrameProcessingOffsetUs + l10;
        this.videoFrameProcessingOffsetCount = n11 = this.videoFrameProcessingOffsetCount + n10;
    }

    public void addVideoFrameProcessingOffset(long l10) {
        this.addVideoFrameProcessingOffsets(l10, 1);
    }

    /*
     * Enabled aggressive block sorting
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void ensureUpdated() {
        // MONITORENTER : this
        // MONITOREXIT : this
    }

    public void merge(DecoderCounters decoderCounters) {
        int n10 = this.decoderInitCount;
        int n11 = decoderCounters.decoderInitCount;
        this.decoderInitCount = n10 += n11;
        n10 = this.decoderReleaseCount;
        n11 = decoderCounters.decoderReleaseCount;
        this.decoderReleaseCount = n10 += n11;
        n10 = this.inputBufferCount;
        n11 = decoderCounters.inputBufferCount;
        this.inputBufferCount = n10 += n11;
        n10 = this.skippedInputBufferCount;
        n11 = decoderCounters.skippedInputBufferCount;
        this.skippedInputBufferCount = n10 += n11;
        n10 = this.renderedOutputBufferCount;
        n11 = decoderCounters.renderedOutputBufferCount;
        this.renderedOutputBufferCount = n10 += n11;
        n10 = this.skippedOutputBufferCount;
        n11 = decoderCounters.skippedOutputBufferCount;
        this.skippedOutputBufferCount = n10 += n11;
        n10 = this.droppedBufferCount;
        n11 = decoderCounters.droppedBufferCount;
        this.droppedBufferCount = n10 += n11;
        n10 = this.maxConsecutiveDroppedBufferCount;
        n11 = decoderCounters.maxConsecutiveDroppedBufferCount;
        this.maxConsecutiveDroppedBufferCount = n10 = Math.max(n10, n11);
        n10 = this.droppedToKeyframeCount;
        n11 = decoderCounters.droppedToKeyframeCount;
        this.droppedToKeyframeCount = n10 += n11;
        long l10 = decoderCounters.totalVideoFrameProcessingOffsetUs;
        int n12 = decoderCounters.videoFrameProcessingOffsetCount;
        this.addVideoFrameProcessingOffsets(l10, n12);
    }
}

