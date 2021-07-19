/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioProcessor$AudioFormat;
import com.google.android.exoplayer2.audio.BaseAudioProcessor;
import com.google.android.exoplayer2.audio.TeeAudioProcessor$AudioBufferSink;
import com.google.android.exoplayer2.util.Assertions;
import java.nio.ByteBuffer;

public final class TeeAudioProcessor
extends BaseAudioProcessor {
    private final TeeAudioProcessor$AudioBufferSink audioBufferSink;

    public TeeAudioProcessor(TeeAudioProcessor$AudioBufferSink teeAudioProcessor$AudioBufferSink) {
        this.audioBufferSink = teeAudioProcessor$AudioBufferSink = (TeeAudioProcessor$AudioBufferSink)Assertions.checkNotNull(teeAudioProcessor$AudioBufferSink);
    }

    private void flushSinkIfActive() {
        boolean bl2 = this.isActive();
        if (bl2) {
            TeeAudioProcessor$AudioBufferSink teeAudioProcessor$AudioBufferSink = this.audioBufferSink;
            AudioProcessor$AudioFormat audioProcessor$AudioFormat = this.inputAudioFormat;
            int n10 = audioProcessor$AudioFormat.sampleRate;
            int n11 = audioProcessor$AudioFormat.channelCount;
            int n12 = audioProcessor$AudioFormat.encoding;
            teeAudioProcessor$AudioBufferSink.flush(n10, n11, n12);
        }
    }

    public AudioProcessor$AudioFormat onConfigure(AudioProcessor$AudioFormat audioProcessor$AudioFormat) {
        return audioProcessor$AudioFormat;
    }

    public void onFlush() {
        this.flushSinkIfActive();
    }

    public void onQueueEndOfStream() {
        this.flushSinkIfActive();
    }

    public void onReset() {
        this.flushSinkIfActive();
    }

    public void queueInput(ByteBuffer byteBuffer) {
        int n10 = byteBuffer.remaining();
        if (n10 == 0) {
            return;
        }
        TeeAudioProcessor$AudioBufferSink teeAudioProcessor$AudioBufferSink = this.audioBufferSink;
        ByteBuffer byteBuffer2 = byteBuffer.asReadOnlyBuffer();
        teeAudioProcessor$AudioBufferSink.handleBuffer(byteBuffer2);
        this.replaceOutputBuffer(n10).put(byteBuffer).flip();
    }
}

