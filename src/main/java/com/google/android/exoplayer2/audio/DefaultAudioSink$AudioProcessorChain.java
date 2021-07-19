/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;

public interface DefaultAudioSink$AudioProcessorChain {
    public PlaybackParameters applyPlaybackParameters(PlaybackParameters var1);

    public boolean applySkipSilenceEnabled(boolean var1);

    public AudioProcessor[] getAudioProcessors();

    public long getMediaDuration(long var1);

    public long getSkippedOutputFrameCount();
}

