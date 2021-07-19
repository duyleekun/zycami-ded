/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;

public interface AudioRendererEventListener {
    default public void onAudioDecoderInitialized(String string2, long l10, long l11) {
    }

    default public void onAudioDecoderReleased(String string2) {
    }

    default public void onAudioDisabled(DecoderCounters decoderCounters) {
    }

    default public void onAudioEnabled(DecoderCounters decoderCounters) {
    }

    default public void onAudioInputFormatChanged(Format format) {
    }

    default public void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.onAudioInputFormatChanged(format);
    }

    default public void onAudioPositionAdvancing(long l10) {
    }

    default public void onAudioSinkError(Exception exception) {
    }

    default public void onAudioUnderrun(int n10, long l10, long l11) {
    }

    default public void onSkipSilenceEnabledChanged(boolean bl2) {
    }
}

