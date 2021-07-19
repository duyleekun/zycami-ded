/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.DecoderAudioRenderer;
import com.google.android.exoplayer2.audio.DecoderAudioRenderer$1;

public final class DecoderAudioRenderer$AudioSinkListener
implements AudioSink$Listener {
    public final /* synthetic */ DecoderAudioRenderer this$0;

    private DecoderAudioRenderer$AudioSinkListener(DecoderAudioRenderer decoderAudioRenderer) {
        this.this$0 = decoderAudioRenderer;
    }

    public /* synthetic */ DecoderAudioRenderer$AudioSinkListener(DecoderAudioRenderer decoderAudioRenderer, DecoderAudioRenderer$1 decoderAudioRenderer$1) {
        this(decoderAudioRenderer);
    }

    public void onAudioSinkError(Exception exception) {
        DecoderAudioRenderer.access$100(this.this$0).audioSinkError(exception);
    }

    public void onPositionAdvancing(long l10) {
        DecoderAudioRenderer.access$100(this.this$0).positionAdvancing(l10);
    }

    public void onPositionDiscontinuity() {
        this.this$0.onPositionDiscontinuity();
    }

    public void onSkipSilenceEnabledChanged(boolean bl2) {
        DecoderAudioRenderer.access$100(this.this$0).skipSilenceEnabledChanged(bl2);
    }

    public void onUnderrun(int n10, long l10, long l11) {
        DecoderAudioRenderer.access$100(this.this$0).underrun(n10, l10, l11);
    }
}

