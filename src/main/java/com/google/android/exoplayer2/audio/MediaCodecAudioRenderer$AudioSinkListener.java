/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Renderer$WakeupListener;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer;
import com.google.android.exoplayer2.audio.MediaCodecAudioRenderer$1;

public final class MediaCodecAudioRenderer$AudioSinkListener
implements AudioSink$Listener {
    public final /* synthetic */ MediaCodecAudioRenderer this$0;

    private MediaCodecAudioRenderer$AudioSinkListener(MediaCodecAudioRenderer mediaCodecAudioRenderer) {
        this.this$0 = mediaCodecAudioRenderer;
    }

    public /* synthetic */ MediaCodecAudioRenderer$AudioSinkListener(MediaCodecAudioRenderer mediaCodecAudioRenderer, MediaCodecAudioRenderer$1 mediaCodecAudioRenderer$1) {
        this(mediaCodecAudioRenderer);
    }

    public void onAudioSinkError(Exception exception) {
        MediaCodecAudioRenderer.access$100(this.this$0).audioSinkError(exception);
    }

    public void onOffloadBufferEmptying() {
        Renderer$WakeupListener renderer$WakeupListener = MediaCodecAudioRenderer.access$200(this.this$0);
        if (renderer$WakeupListener != null) {
            renderer$WakeupListener = MediaCodecAudioRenderer.access$200(this.this$0);
            renderer$WakeupListener.onWakeup();
        }
    }

    public void onOffloadBufferFull(long l10) {
        Renderer$WakeupListener renderer$WakeupListener = MediaCodecAudioRenderer.access$200(this.this$0);
        if (renderer$WakeupListener != null) {
            renderer$WakeupListener = MediaCodecAudioRenderer.access$200(this.this$0);
            renderer$WakeupListener.onSleep(l10);
        }
    }

    public void onPositionAdvancing(long l10) {
        MediaCodecAudioRenderer.access$100(this.this$0).positionAdvancing(l10);
    }

    public void onPositionDiscontinuity() {
        this.this$0.onPositionDiscontinuity();
    }

    public void onSkipSilenceEnabledChanged(boolean bl2) {
        MediaCodecAudioRenderer.access$100(this.this$0).skipSilenceEnabledChanged(bl2);
    }

    public void onUnderrun(int n10, long l10, long l11) {
        MediaCodecAudioRenderer.access$100(this.this$0).underrun(n10, l10, l11);
    }
}

