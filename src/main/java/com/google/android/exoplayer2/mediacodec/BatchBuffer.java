/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.mediacodec;

import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class BatchBuffer
extends DecoderInputBuffer {
    public static final int DEFAULT_MAX_SAMPLE_COUNT = 32;
    public static final int MAX_SIZE_BYTES = 0x2EE000;
    private long lastSampleTimeUs;
    private int maxSampleCount = 32;
    private int sampleCount;

    public BatchBuffer() {
        super(2);
    }

    private boolean canAppendSampleBuffer(DecoderInputBuffer object) {
        ByteBuffer byteBuffer;
        int n10 = this.hasSamples();
        boolean bl2 = true;
        if (n10 == 0) {
            return bl2;
        }
        n10 = this.sampleCount;
        int n11 = this.maxSampleCount;
        if (n10 >= n11) {
            return false;
        }
        n10 = (int)(((com.google.android.exoplayer2.decoder.Buffer)object).isDecodeOnly() ? 1 : 0);
        if (n10 != (n11 = (int)(this.isDecodeOnly() ? 1 : 0))) {
            return false;
        }
        object = ((DecoderInputBuffer)object).data;
        if (object != null && (byteBuffer = this.data) != null) {
            n10 = byteBuffer.position();
            int n12 = ((Buffer)object).remaining();
            if ((n10 += n12) > (n12 = 0x2EE000)) {
                return false;
            }
        }
        return bl2;
    }

    public boolean append(DecoderInputBuffer decoderInputBuffer) {
        ByteBuffer byteBuffer;
        long l10;
        int n10;
        int n11 = decoderInputBuffer.isEncrypted();
        boolean bl2 = true;
        Assertions.checkArgument(n11 ^ bl2);
        Assertions.checkArgument(decoderInputBuffer.hasSupplementalData() ^ bl2);
        Assertions.checkArgument(decoderInputBuffer.isEndOfStream() ^ bl2);
        n11 = this.canAppendSampleBuffer(decoderInputBuffer);
        if (n11 == 0) {
            return false;
        }
        n11 = this.sampleCount;
        this.sampleCount = n10 = n11 + 1;
        if (n11 == 0) {
            this.timeUs = l10 = decoderInputBuffer.timeUs;
            n11 = (int)(decoderInputBuffer.isKeyFrame() ? 1 : 0);
            if (n11 != 0) {
                this.setFlags((int)(bl2 ? 1 : 0));
            }
        }
        if ((n11 = (int)(decoderInputBuffer.isDecodeOnly() ? 1 : 0)) != 0) {
            n11 = -1 << -1;
            this.setFlags(n11);
        }
        if ((byteBuffer = decoderInputBuffer.data) != null) {
            n10 = byteBuffer.remaining();
            this.ensureSpaceForWrite(n10);
            ByteBuffer byteBuffer2 = this.data;
            byteBuffer2.put(byteBuffer);
        }
        this.lastSampleTimeUs = l10 = decoderInputBuffer.timeUs;
        return bl2;
    }

    public void clear() {
        super.clear();
        this.sampleCount = 0;
    }

    public long getFirstSampleTimeUs() {
        return this.timeUs;
    }

    public long getLastSampleTimeUs() {
        return this.lastSampleTimeUs;
    }

    public int getSampleCount() {
        return this.sampleCount;
    }

    public boolean hasSamples() {
        int n10 = this.sampleCount;
        n10 = n10 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public void setMaxSampleCount(int n10) {
        boolean bl2 = n10 > 0;
        Assertions.checkArgument(bl2);
        this.maxSampleCount = n10;
    }
}

