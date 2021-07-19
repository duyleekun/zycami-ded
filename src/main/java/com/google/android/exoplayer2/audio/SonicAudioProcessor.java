/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.AudioProcessor$UnhandledAudioFormatException;
import com.google.android.exoplayer2.audio.Sonic;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class SonicAudioProcessor
implements AudioProcessor {
    private static final float CLOSE_THRESHOLD = 1.0E-4f;
    private static final int MIN_BYTES_FOR_DURATION_SCALING_CALCULATION = 1024;
    public static final int SAMPLE_RATE_NO_CHANGE = 255;
    private ByteBuffer buffer;
    private AudioProcessor$AudioFormat inputAudioFormat;
    private long inputBytes;
    private boolean inputEnded;
    private AudioProcessor$AudioFormat outputAudioFormat;
    private ByteBuffer outputBuffer;
    private long outputBytes;
    private AudioProcessor$AudioFormat pendingInputAudioFormat;
    private AudioProcessor$AudioFormat pendingOutputAudioFormat;
    private int pendingOutputSampleRate;
    private boolean pendingSonicRecreation;
    private float pitch;
    private ShortBuffer shortBuffer;
    private Sonic sonic;
    private float speed;

    public SonicAudioProcessor() {
        ShortBuffer shortBuffer;
        float f10;
        this.speed = f10 = 1.0f;
        this.pitch = f10;
        Object object = AudioProcessor$AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = object;
        this.pendingOutputAudioFormat = object;
        this.inputAudioFormat = object;
        this.outputAudioFormat = object;
        this.buffer = object = AudioProcessor.EMPTY_BUFFER;
        this.shortBuffer = shortBuffer = ((ByteBuffer)object).asShortBuffer();
        this.outputBuffer = object;
        this.pendingOutputSampleRate = -1;
    }

    public AudioProcessor$AudioFormat configure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        int n10 = audioProcessor$AudioFormat.encoding;
        int n11 = 2;
        if (n10 == n11) {
            AudioProcessor$AudioFormat audioProcessor$AudioFormat2;
            n10 = this.pendingOutputSampleRate;
            int n12 = -1;
            if (n10 == n12) {
                n10 = audioProcessor$AudioFormat.sampleRate;
            }
            this.pendingInputAudioFormat = audioProcessor$AudioFormat;
            int n13 = audioProcessor$AudioFormat.channelCount;
            this.pendingOutputAudioFormat = audioProcessor$AudioFormat2 = new AudioProcessor$AudioFormat(n10, n13, n11);
            this.pendingSonicRecreation = true;
            return audioProcessor$AudioFormat2;
        }
        AudioProcessor$UnhandledAudioFormatException audioProcessor$UnhandledAudioFormatException = new AudioProcessor$UnhandledAudioFormatException(audioProcessor$AudioFormat);
        throw audioProcessor$UnhandledAudioFormatException;
    }

    public void flush() {
        long l10;
        Object object;
        boolean bl2 = this.isActive();
        if (bl2) {
            AudioProcessor$AudioFormat audioProcessor$AudioFormat;
            this.inputAudioFormat = object = this.pendingInputAudioFormat;
            this.outputAudioFormat = audioProcessor$AudioFormat = this.pendingOutputAudioFormat;
            boolean bl3 = this.pendingSonicRecreation;
            if (bl3) {
                Sonic sonic;
                int n10 = ((AudioProcessor$AudioFormat)object).sampleRate;
                int n11 = ((AudioProcessor$AudioFormat)object).channelCount;
                float f10 = this.speed;
                float f11 = this.pitch;
                int n12 = audioProcessor$AudioFormat.sampleRate;
                this.sonic = sonic = new Sonic(n10, n11, f10, f11, n12);
            } else {
                object = this.sonic;
                if (object != null) {
                    ((Sonic)object).flush();
                }
            }
        }
        this.outputBuffer = object = AudioProcessor.EMPTY_BUFFER;
        this.inputBytes = l10 = 0L;
        this.outputBytes = l10;
        this.inputEnded = false;
    }

    public long getMediaDuration(long l10) {
        long l11 = this.outputBytes;
        long l12 = 1024L;
        double d10 = 5.06E-321;
        Object object = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (object >= 0) {
            l11 = this.inputBytes;
            Sonic sonic = (Sonic)Assertions.checkNotNull(this.sonic);
            int n10 = sonic.getPendingInputBytes();
            l12 = n10;
            long l13 = l11 - l12;
            AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.outputAudioFormat;
            object = audioProcessor$AudioFormat.sampleRate;
            AudioProcessor$AudioFormat audioProcessor$AudioFormat2 = this.inputAudioFormat;
            int n11 = audioProcessor$AudioFormat2.sampleRate;
            if (object == n11) {
                long l14 = this.outputBytes;
                l11 = Util.scaleLargeTimestamp(l10, l13, l14);
            } else {
                l12 = object;
                long l15 = l13 * l12;
                l12 = this.outputBytes;
                l11 = n11;
                long l16 = l12 * l11;
                long l17 = l10;
                l11 = Util.scaleLargeTimestamp(l10, l15, l16);
            }
            return l11;
        }
        double d11 = this.speed;
        l12 = l10;
        d10 = l10;
        return (long)(d11 * d10);
    }

    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer;
        int n10;
        Object object = this.sonic;
        if (object != null && (n10 = ((Sonic)object).getOutputSize()) > 0) {
            Buffer buffer = this.buffer;
            int n11 = buffer.capacity();
            if (n11 < n10) {
                buffer = ByteBuffer.allocateDirect(n10);
                ByteOrder byteOrder = ByteOrder.nativeOrder();
                buffer = ((ByteBuffer)buffer).order(byteOrder);
                this.buffer = buffer;
                buffer = ((ByteBuffer)buffer).asShortBuffer();
                this.shortBuffer = buffer;
            } else {
                this.buffer.clear();
                buffer = this.shortBuffer;
                ((ShortBuffer)buffer).clear();
            }
            buffer = this.shortBuffer;
            ((Sonic)object).getOutput((ShortBuffer)buffer);
            long l10 = this.outputBytes;
            long l11 = n10;
            this.outputBytes = l10 += l11;
            this.buffer.limit(n10);
            this.outputBuffer = object = this.buffer;
        }
        object = this.outputBuffer;
        this.outputBuffer = byteBuffer = AudioProcessor.EMPTY_BUFFER;
        return object;
    }

    /*
     * WARNING - void declaration
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean isActive() {
        void var2_8;
        block2: {
            block3: {
                float f10;
                float f11;
                float f12;
                AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.pendingOutputAudioFormat;
                int n10 = audioProcessor$AudioFormat.sampleRate;
                int n11 = -1;
                float f13 = 0.0f / 0.0f;
                if (n10 == n11) break block2;
                float f14 = this.speed;
                n11 = 1065353216;
                f13 = 1.0f;
                float f15 = (f14 = Math.abs(f14 - f13)) - (f12 = 1.0E-4f);
                Object object = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
                if (object >= 0 || (f11 = (f10 = (f14 = Math.abs(this.pitch - f13)) - f12) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) >= 0) break block3;
                audioProcessor$AudioFormat = this.pendingOutputAudioFormat;
                int n12 = audioProcessor$AudioFormat.sampleRate;
                AudioProcessor$AudioFormat audioProcessor$AudioFormat2 = this.pendingInputAudioFormat;
                n11 = audioProcessor$AudioFormat2.sampleRate;
                if (n12 == n11) break block2;
            }
            boolean bl2 = true;
            return (boolean)var2_8;
        }
        boolean bl3 = false;
        return (boolean)var2_8;
    }

    public boolean isEnded() {
        Sonic sonic;
        int n10 = this.inputEnded;
        if (n10 != 0 && ((sonic = this.sonic) == null || (n10 = sonic.getOutputSize()) == 0)) {
            n10 = 1;
        } else {
            n10 = 0;
            sonic = null;
        }
        return n10 != 0;
    }

    public void queueEndOfStream() {
        Sonic sonic = this.sonic;
        if (sonic != null) {
            sonic.queueEndOfStream();
        }
        this.inputEnded = true;
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.hasRemaining();
        if (n10 == 0) {
            return;
        }
        Sonic sonic = (Sonic)Assertions.checkNotNull(this.sonic);
        ShortBuffer shortBuffer = byteBuffer.asShortBuffer();
        int n11 = byteBuffer.remaining();
        long l10 = this.inputBytes;
        long l11 = n11;
        this.inputBytes = l10 += l11;
        sonic.queueInput(shortBuffer);
        n10 = byteBuffer.position() + n11;
        byteBuffer.position(n10);
    }

    public void reset() {
        long l10;
        ShortBuffer shortBuffer;
        float f10;
        this.speed = f10 = 1.0f;
        this.pitch = f10;
        Object object = AudioProcessor$AudioFormat.NOT_SET;
        this.pendingInputAudioFormat = object;
        this.pendingOutputAudioFormat = object;
        this.inputAudioFormat = object;
        this.outputAudioFormat = object;
        this.buffer = object = AudioProcessor.EMPTY_BUFFER;
        this.shortBuffer = shortBuffer = ((ByteBuffer)object).asShortBuffer();
        this.outputBuffer = object;
        this.pendingOutputSampleRate = -1;
        this.pendingSonicRecreation = false;
        this.sonic = null;
        this.inputBytes = l10 = 0L;
        this.outputBytes = l10;
        this.inputEnded = false;
    }

    public void setOutputSampleRateHz(int n10) {
        this.pendingOutputSampleRate = n10;
    }

    public void setPitch(float f10) {
        float f11 = this.pitch;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.pitch = f10;
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            this.pendingSonicRecreation = bl2;
        }
    }

    public void setSpeed(float f10) {
        float f11 = this.speed;
        float f12 = f11 - f10;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            this.speed = f10;
            boolean bl2 = true;
            f10 = Float.MIN_VALUE;
            this.pendingSonicRecreation = bl2;
        }
    }
}

