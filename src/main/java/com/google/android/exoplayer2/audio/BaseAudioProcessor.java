/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class BaseAudioProcessor
implements AudioProcessor {
    private ByteBuffer buffer;
    public AudioProcessor$AudioFormat inputAudioFormat;
    private boolean inputEnded;
    public AudioProcessor$AudioFormat outputAudioFormat;
    private ByteBuffer outputBuffer;
    private AudioProcessor$AudioFormat pendingInputAudioFormat;
    private AudioProcessor$AudioFormat pendingOutputAudioFormat;

    public BaseAudioProcessor() {
        Object object = AudioProcessor.EMPTY_BUFFER;
        this.buffer = object;
        this.outputBuffer = object;
        this.pendingInputAudioFormat = object = AudioProcessor$AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = object;
        this.inputAudioFormat = object;
        this.outputAudioFormat = object;
    }

    public final AudioProcessor$AudioFormat configure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        this.pendingInputAudioFormat = audioProcessor$AudioFormat;
        this.pendingOutputAudioFormat = audioProcessor$AudioFormat = this.onConfigure(audioProcessor$AudioFormat);
        boolean bl2 = this.isActive();
        audioProcessor$AudioFormat = bl2 ? this.pendingOutputAudioFormat : AudioProcessor$AudioFormat.NOT_SET;
        return audioProcessor$AudioFormat;
    }

    public final void flush() {
        Object object = AudioProcessor.EMPTY_BUFFER;
        this.outputBuffer = object;
        this.inputEnded = false;
        this.inputAudioFormat = object = this.pendingInputAudioFormat;
        this.outputAudioFormat = object = this.pendingOutputAudioFormat;
        this.onFlush();
    }

    public ByteBuffer getOutput() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2 = this.outputBuffer;
        this.outputBuffer = byteBuffer = AudioProcessor.EMPTY_BUFFER;
        return byteBuffer2;
    }

    public final boolean hasPendingOutput() {
        return this.outputBuffer.hasRemaining();
    }

    public boolean isActive() {
        boolean bl2;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.pendingOutputAudioFormat;
        AudioProcessor$AudioFormat audioProcessor$AudioFormat2 = AudioProcessor$AudioFormat.NOT_SET;
        if (audioProcessor$AudioFormat != audioProcessor$AudioFormat2) {
            bl2 = true;
        } else {
            bl2 = false;
            audioProcessor$AudioFormat = null;
        }
        return bl2;
    }

    public boolean isEnded() {
        ByteBuffer byteBuffer;
        ByteBuffer byteBuffer2;
        boolean bl2 = this.inputEnded;
        if (bl2 && (byteBuffer2 = this.outputBuffer) == (byteBuffer = AudioProcessor.EMPTY_BUFFER)) {
            bl2 = true;
        } else {
            bl2 = false;
            byteBuffer2 = null;
        }
        return bl2;
    }

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        return AudioProcessor$AudioFormat.NOT_SET;
    }

    public void onFlush() {
    }

    public void onQueueEndOfStream() {
    }

    public void onReset() {
    }

    public final void queueEndOfStream() {
        this.inputEnded = true;
        this.onQueueEndOfStream();
    }

    public final ByteBuffer replaceOutputBuffer(int n10) {
        ByteBuffer byteBuffer;
        Object object = this.buffer;
        int n11 = ((Buffer)object).capacity();
        if (n11 < n10) {
            byteBuffer = ByteBuffer.allocateDirect(n10);
            object = ByteOrder.nativeOrder();
            this.buffer = byteBuffer = byteBuffer.order((ByteOrder)object);
        } else {
            byteBuffer = this.buffer;
            byteBuffer.clear();
        }
        this.outputBuffer = byteBuffer = this.buffer;
        return byteBuffer;
    }

    public final void reset() {
        this.flush();
        Object object = AudioProcessor.EMPTY_BUFFER;
        this.buffer = object;
        this.pendingInputAudioFormat = object = AudioProcessor$AudioFormat.NOT_SET;
        this.pendingOutputAudioFormat = object;
        this.inputAudioFormat = object;
        this.outputAudioFormat = object;
        this.onReset();
    }
}

