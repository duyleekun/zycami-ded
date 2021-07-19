/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

public interface AudioSink$Listener {
    default public void onAudioSinkError(Exception exception) {
    }

    default public void onOffloadBufferEmptying() {
    }

    default public void onOffloadBufferFull(long l10) {
    }

    default public void onPositionAdvancing(long l10) {
    }

    public void onPositionDiscontinuity();

    public void onSkipSilenceEnabledChanged(boolean var1);

    public void onUnderrun(int var1, long var2, long var4);
}

