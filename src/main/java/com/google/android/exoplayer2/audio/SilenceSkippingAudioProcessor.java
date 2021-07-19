/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public final class SilenceSkippingAudioProcessor
extends BaseAudioProcessor {
    public static final long DEFAULT_MINIMUM_SILENCE_DURATION_US = 150000L;
    public static final long DEFAULT_PADDING_SILENCE_US = 20000L;
    public static final short DEFAULT_SILENCE_THRESHOLD_LEVEL = 1024;
    private static final int STATE_MAYBE_SILENT = 1;
    private static final int STATE_NOISY = 0;
    private static final int STATE_SILENT = 2;
    private int bytesPerFrame;
    private boolean enabled;
    private boolean hasOutputNoise;
    private byte[] maybeSilenceBuffer;
    private int maybeSilenceBufferSize;
    private final long minimumSilenceDurationUs;
    private byte[] paddingBuffer;
    private final long paddingSilenceUs;
    private int paddingSize;
    private final short silenceThresholdLevel;
    private long skippedFrames;
    private int state;

    public SilenceSkippingAudioProcessor() {
        this(150000L, 20000L, 1024);
    }

    public SilenceSkippingAudioProcessor(long l10, long l11, short s10) {
        long l12 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
        l12 = l12 <= 0 ? (long)1 : (long)0;
        Assertions.checkArgument((boolean)l12);
        this.minimumSilenceDurationUs = l10;
        this.paddingSilenceUs = l11;
        this.silenceThresholdLevel = s10;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = byArray;
        this.paddingBuffer = byArray;
    }

    private int durationUsToFrames(long l10) {
        long l11 = this.inputAudioFormat.sampleRate;
        return (int)(l10 * l11 / 1000000L);
    }

    private int findNoiseLimit(ByteBuffer byteBuffer) {
        int n10;
        for (int i10 = byteBuffer.limit() + -2; i10 >= (n10 = byteBuffer.position()); i10 += -2) {
            short s10;
            n10 = Math.abs(byteBuffer.getShort(i10));
            if (n10 <= (s10 = this.silenceThresholdLevel)) continue;
            int n11 = this.bytesPerFrame;
            return i10 / n11 * n11 + n11;
        }
        return byteBuffer.position();
    }

    private int findNoisePosition(ByteBuffer byteBuffer) {
        int n10;
        for (int i10 = byteBuffer.position(); i10 < (n10 = byteBuffer.limit()); i10 += 2) {
            short s10;
            n10 = Math.abs(byteBuffer.getShort(i10));
            if (n10 <= (s10 = this.silenceThresholdLevel)) continue;
            int n11 = this.bytesPerFrame;
            return n11 * (i10 /= n11);
        }
        return byteBuffer.limit();
    }

    private void output(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        ByteBuffer byteBuffer2 = this.replaceOutputBuffer(n10);
        byteBuffer = byteBuffer2.put(byteBuffer);
        byteBuffer.flip();
        if (n10 > 0) {
            boolean bl2;
            this.hasOutputNoise = bl2 = true;
        }
    }

    private void output(byte[] object, int n10) {
        ByteBuffer byteBuffer = this.replaceOutputBuffer(n10);
        object = byteBuffer.put((byte[])object, 0, n10);
        ((ByteBuffer)object).flip();
        if (n10 > 0) {
            boolean bl2;
            this.hasOutputNoise = bl2 = true;
        }
    }

    private void processMaybeSilence(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.limit();
        int n11 = this.findNoisePosition(byteBuffer);
        int n12 = byteBuffer.position();
        n12 = n11 - n12;
        byte[] byArray = this.maybeSilenceBuffer;
        int n13 = byArray.length;
        int n14 = this.maybeSilenceBufferSize;
        if (n11 < n10 && n12 < (n13 -= n14)) {
            this.output(byArray, n14);
            this.maybeSilenceBufferSize = 0;
            this.state = 0;
        } else {
            n11 = Math.min(n12, n13);
            n12 = byteBuffer.position() + n11;
            byteBuffer.limit(n12);
            byte[] byArray2 = this.maybeSilenceBuffer;
            int n15 = this.maybeSilenceBufferSize;
            byteBuffer.get(byArray2, n15, n11);
            this.maybeSilenceBufferSize = n12 = this.maybeSilenceBufferSize + n11;
            byte[] byArray3 = this.maybeSilenceBuffer;
            n15 = byArray3.length;
            if (n12 == n15) {
                n15 = (int)(this.hasOutputNoise ? 1 : 0);
                n13 = 2;
                if (n15 != 0) {
                    n12 = this.paddingSize;
                    this.output(byArray3, n12);
                    long l10 = this.skippedFrames;
                    n15 = this.maybeSilenceBufferSize;
                    n14 = this.paddingSize * n13;
                    n15 -= n14;
                    n14 = this.bytesPerFrame;
                    long l11 = n15 /= n14;
                    this.skippedFrames = l10 += l11;
                } else {
                    long l12 = this.skippedFrames;
                    n11 = this.paddingSize;
                    n12 -= n11;
                    n11 = this.bytesPerFrame;
                    long l13 = n12 /= n11;
                    this.skippedFrames = l12 += l13;
                }
                byArray3 = this.maybeSilenceBuffer;
                n12 = this.maybeSilenceBufferSize;
                this.updatePaddingBuffer(byteBuffer, byArray3, n12);
                this.maybeSilenceBufferSize = 0;
                this.state = n13;
            }
            byteBuffer.limit(n10);
        }
    }

    private void processNoisy(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.limit();
        int n11 = byteBuffer.position();
        byte[] byArray = this.maybeSilenceBuffer;
        int n12 = byArray.length;
        n11 += n12;
        n11 = Math.min(n10, n11);
        byteBuffer.limit(n11);
        n11 = this.findNoiseLimit(byteBuffer);
        n12 = byteBuffer.position();
        if (n11 == n12) {
            this.state = n11 = 1;
        } else {
            byteBuffer.limit(n11);
            this.output(byteBuffer);
        }
        byteBuffer.limit(n10);
    }

    private void processSilence(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.limit();
        int n11 = this.findNoisePosition(byteBuffer);
        byteBuffer.limit(n11);
        long l10 = this.skippedFrames;
        int n12 = byteBuffer.remaining();
        int n13 = this.bytesPerFrame;
        long l11 = n12 /= n13;
        this.skippedFrames = l10 += l11;
        byte[] byArray = this.paddingBuffer;
        int n14 = this.paddingSize;
        this.updatePaddingBuffer(byteBuffer, byArray, n14);
        if (n11 < n10) {
            byte[] byArray2 = this.paddingBuffer;
            int n15 = this.paddingSize;
            this.output(byArray2, n15);
            n11 = 0;
            byArray2 = null;
            this.state = 0;
            byteBuffer.limit(n10);
        }
    }

    private void updatePaddingBuffer(ByteBuffer byteBuffer, byte[] byArray, int n10) {
        int n11 = byteBuffer.remaining();
        int n12 = this.paddingSize;
        n11 = Math.min(n11, n12);
        n12 = this.paddingSize - n11;
        byte[] byArray2 = this.paddingBuffer;
        System.arraycopy(byArray, n10 -= n12, byArray2, 0, n12);
        int n13 = byteBuffer.limit() - n11;
        byteBuffer.position(n13);
        byArray = this.paddingBuffer;
        byteBuffer.get(byArray, n12, n11);
    }

    public long getSkippedFrames() {
        return this.skippedFrames;
    }

    public boolean isActive() {
        return this.enabled;
    }

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = 2;
        if (n10 == n11) {
            n10 = (int)(this.enabled ? 1 : 0);
            if (n10 == 0) {
                audioProcessor$AudioFormat = AudioProcessor$AudioFormat.NOT_SET;
            }
            return audioProcessor$AudioFormat;
        }
        AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException = new AudioProcessor$UnhandledAudioFormatException(audioProcessor$AudioFormat);
        throw audioProcessor$UnhandledAudioFormatException;
    }

    public void onFlush() {
        int n10 = this.enabled;
        if (n10 != 0) {
            Object object = this.inputAudioFormat;
            this.bytesPerFrame = n10 = ((AudioProcessor$AudioFormat)object).bytesPerFrame;
            long l10 = this.minimumSilenceDurationUs;
            n10 = this.durationUsToFrames(l10);
            int n11 = this.bytesPerFrame;
            byte[] byArray = this.maybeSilenceBuffer;
            n11 = byArray.length;
            if (n11 != (n10 *= n11)) {
                object = new byte[n10];
                this.maybeSilenceBuffer = (byte[])object;
            }
            l10 = this.paddingSilenceUs;
            n10 = this.durationUsToFrames(l10);
            n11 = this.bytesPerFrame;
            this.paddingSize = n10 *= n11;
            byArray = this.paddingBuffer;
            n11 = byArray.length;
            if (n11 != n10) {
                object = new byte[n10];
                this.paddingBuffer = (byte[])object;
            }
        }
        this.state = 0;
        this.skippedFrames = 0L;
        this.maybeSilenceBufferSize = 0;
        this.hasOutputNoise = false;
    }

    public void onQueueEndOfStream() {
        int n10 = this.maybeSilenceBufferSize;
        if (n10 > 0) {
            byte[] byArray = this.maybeSilenceBuffer;
            this.output(byArray, n10);
        }
        if ((n10 = (int)(this.hasOutputNoise ? 1 : 0)) == 0) {
            long l10 = this.skippedFrames;
            int n11 = this.paddingSize;
            int n12 = this.bytesPerFrame;
            long l11 = n11 /= n12;
            this.skippedFrames = l10 += l11;
        }
    }

    public void onReset() {
        this.enabled = false;
        this.paddingSize = 0;
        byte[] byArray = Util.EMPTY_BYTE_ARRAY;
        this.maybeSilenceBuffer = byArray;
        this.paddingBuffer = byArray;
    }

    public void queueInput(ByteBuffer object) {
        int n10;
        while ((n10 = ((Buffer)object).hasRemaining()) != 0 && (n10 = this.hasPendingOutput()) == 0) {
            n10 = this.state;
            if (n10 != 0) {
                int n11 = 1;
                if (n10 != n11) {
                    n11 = 2;
                    if (n10 == n11) {
                        this.processSilence((ByteBuffer)object);
                        continue;
                    }
                    object = new IllegalStateException();
                    throw object;
                }
                this.processMaybeSilence((ByteBuffer)object);
                continue;
            }
            this.processNoisy((ByteBuffer)object);
        }
    }

    public void setEnabled(boolean bl2) {
        this.enabled = bl2;
    }
}

