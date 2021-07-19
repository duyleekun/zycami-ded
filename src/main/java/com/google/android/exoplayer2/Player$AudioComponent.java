/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;

public interface Player$AudioComponent {
    public void addAudioListener(AudioListener var1);

    public void clearAuxEffectInfo();

    public AudioAttributes getAudioAttributes();

    public int getAudioSessionId();

    public boolean getSkipSilenceEnabled();

    public float getVolume();

    public void removeAudioListener(AudioListener var1);

    public void setAudioAttributes(AudioAttributes var1, boolean var2);

    public void setAudioSessionId(int var1);

    public void setAuxEffectInfo(AuxEffectInfo var1);

    public void setSkipSilenceEnabled(boolean var1);

    public void setVolume(float var1);
}

