/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.audio.AudioAttributes;

public interface AudioListener {
    default public void onAudioAttributesChanged(AudioAttributes audioAttributes) {
    }

    default public void onAudioSessionIdChanged(int n10) {
    }

    default public void onSkipSilenceEnabledChanged(boolean bl2) {
    }

    default public void onVolumeChanged(float f10) {
    }
}

