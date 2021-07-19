/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.audio;

import com.tencent.liteav.audio.TXAudioEffectManager$AudioMusicParam;
import com.tencent.liteav.audio.TXAudioEffectManager$TXMusicPlayObserver;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceReverbType;

public interface TXAudioEffectManager {
    public void enableVoiceEarMonitor(boolean var1);

    public long getMusicCurrentPosInMS(int var1);

    public long getMusicDurationInMS(String var1);

    public void pausePlayMusic(int var1);

    public void resumePlayMusic(int var1);

    public void seekMusicToPosInMS(int var1, int var2);

    public void setAllMusicVolume(int var1);

    public void setMusicObserver(int var1, TXAudioEffectManager$TXMusicPlayObserver var2);

    public void setMusicPitch(int var1, float var2);

    public void setMusicPlayoutVolume(int var1, int var2);

    public void setMusicPublishVolume(int var1, int var2);

    public void setMusicSpeedRate(int var1, float var2);

    public void setVoiceCaptureVolume(int var1);

    public void setVoiceChangerType(TXAudioEffectManager$TXVoiceChangerType var1);

    public void setVoiceEarMonitorVolume(int var1);

    public void setVoiceReverbType(TXAudioEffectManager$TXVoiceReverbType var1);

    public boolean startPlayMusic(TXAudioEffectManager$AudioMusicParam var1);

    public void stopPlayMusic(int var1);
}

