/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioSink$Listener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import java.nio.ByteBuffer;

public interface AudioSink {
    public static final long CURRENT_POSITION_NOT_SET = Long.MIN_VALUE;
    public static final int SINK_FORMAT_SUPPORTED_DIRECTLY = 2;
    public static final int SINK_FORMAT_SUPPORTED_WITH_TRANSCODING = 1;
    public static final int SINK_FORMAT_UNSUPPORTED;

    public void configure(Format var1, int var2, int[] var3);

    public void disableTunneling();

    public void enableTunnelingV21();

    public void experimentalFlushWithoutAudioTrackRelease();

    public void flush();

    public long getCurrentPositionUs(boolean var1);

    public int getFormatSupport(Format var1);

    public PlaybackParameters getPlaybackParameters();

    public boolean getSkipSilenceEnabled();

    public boolean handleBuffer(ByteBuffer var1, long var2, int var4);

    public void handleDiscontinuity();

    public boolean hasPendingData();

    public boolean isEnded();

    public void pause();

    public void play();

    public void playToEndOfStream();

    public void reset();

    public void setAudioAttributes(AudioAttributes var1);

    public void setAudioSessionId(int var1);

    public void setAuxEffectInfo(AuxEffectInfo var1);

    public void setListener(AudioSink$Listener var1);

    public void setPlaybackParameters(PlaybackParameters var1);

    public void setSkipSilenceEnabled(boolean var1);

    public void setVolume(float var1);

    public boolean supportsFormat(Format var1);
}

