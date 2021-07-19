/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;

public final class TrimmingAudioProcessor
extends BaseAudioProcessor {
    private static final int OUTPUT_ENCODING = 2;
    private byte[] endBuffer;
    private int endBufferSize;
    private int pendingTrimStartBytes;
    private boolean reconfigurationPending;
    private int trimEndFrames;
    private int trimStartFrames;
    private long trimmedFrameCount;

    public TrimmingAudioProcessor() {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.endBuffer = byArray;
    }

    public ByteBuffer getOutput() {
        int n10 = super.isEnded();
        if (n10 != 0 && (n10 = this.endBufferSize) > 0) {
            ByteBuffer byteBuffer = this.replaceOutputBuffer(n10);
            byte[] byArray = this.endBuffer;
            int n11 = this.endBufferSize;
            byteBuffer = byteBuffer.put(byArray, 0, n11);
            byteBuffer.flip();
            this.endBufferSize = 0;
        }
        return super.getOutput();
    }

    public long getTrimmedFrameCount() {
        return this.trimmedFrameCount;
    }

    public boolean isEnded() {
        boolean bl2 = super.isEnded();
        bl2 = bl2 && !(bl2 = this.endBufferSize);
        return bl2;
    }

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = 2;
        if (n10 == n11) {
            this.reconfigurationPending = true;
            n10 = this.trimStartFrames;
            if (n10 == 0 && (n10 = this.trimEndFrames) == 0) {
                audioProcessor$AudioFormat = AudioProcessor$AudioFormat.NOT_SET;
            }
            return audioProcessor$AudioFormat;
        }
        AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException = new AudioProcessor$UnhandledAudioFormatException(audioProcessor$AudioFormat);
        throw audioProcessor$UnhandledAudioFormatException;
    }

    public void onFlush() {
        int n10 = this.reconfigurationPending;
        if (n10 != 0) {
            this.reconfigurationPending = false;
            n10 = this.trimEndFrames;
            AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.inputAudioFormat;
            int n11 = audioProcessor$AudioFormat.bytesPerFrame;
            byte[] byArray = new byte[n10 * n11];
            this.endBuffer = byArray;
            this.pendingTrimStartBytes = n10 = this.trimStartFrames * n11;
        }
        this.endBufferSize = 0;
    }

    public void onQueueEndOfStream() {
        int n10 = this.reconfigurationPending;
        if (n10 != 0) {
            n10 = this.endBufferSize;
            if (n10 > 0) {
                long l10 = this.trimmedFrameCount;
                AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.inputAudioFormat;
                int n11 = audioProcessor$AudioFormat.bytesPerFrame;
                long l11 = n10 /= n11;
                this.trimmedFrameCount = l10 += l11;
            }
            n10 = 0;
            this.endBufferSize = 0;
        }
    }

    public void onReset() {
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.endBuffer = byArray;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int n10;
        int n11;
        int n12 = byteBuffer.position();
        int n13 = byteBuffer.limit();
        int n14 = n13 - n12;
        if (n14 == 0) {
            return;
        }
        int n15 = this.pendingTrimStartBytes;
        n15 = Math.min(n14, n15);
        long l10 = this.trimmedFrameCount;
        Object object = this.inputAudioFormat;
        int n16 = ((AudioProcessor$AudioFormat)object).bytesPerFrame;
        n16 = n15 / n16;
        long l11 = n16;
        this.trimmedFrameCount = l10 += l11;
        this.pendingTrimStartBytes = n11 = this.pendingTrimStartBytes - n15;
        byteBuffer.position(n12 += n15);
        n12 = this.pendingTrimStartBytes;
        if (n12 > 0) {
            return;
        }
        n12 = this.endBufferSize + (n14 -= n15);
        n15 = this.endBuffer.length;
        ByteBuffer byteBuffer2 = this.replaceOutputBuffer(n12 -= n15);
        n11 = this.endBufferSize;
        n11 = Util.constrainValue(n12, 0, n11);
        object = this.endBuffer;
        byteBuffer2.put((byte[])object, 0, n11);
        n12 = Util.constrainValue(n12 - n11, 0, n14);
        n16 = byteBuffer.position() + n12;
        byteBuffer.limit(n16);
        byteBuffer2.put(byteBuffer);
        byteBuffer.limit(n13);
        n14 -= n12;
        this.endBufferSize = n12 = this.endBufferSize - n11;
        byte[] byArray = this.endBuffer;
        System.arraycopy(byArray, n11, byArray, 0, n12);
        byte[] byArray2 = this.endBuffer;
        n13 = this.endBufferSize;
        byteBuffer.get(byArray2, n13, n14);
        this.endBufferSize = n10 = this.endBufferSize + n14;
        byteBuffer2.flip();
    }

    public void resetTrimmedFrameCount() {
        this.trimmedFrameCount = 0L;
    }

    public void setTrimFrameCount(int n10, int n11) {
        this.trimStartFrames = n10;
        this.trimEndFrames = n11;
    }
}

