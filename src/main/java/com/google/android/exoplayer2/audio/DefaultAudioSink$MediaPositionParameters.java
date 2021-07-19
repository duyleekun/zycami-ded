/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.audio;

import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.DefaultAudioSink$1;

public final class DefaultAudioSink$MediaPositionParameters {
    public final long audioTrackPositionUs;
    public final long mediaTimeUs;
    public final PlaybackParameters playbackParameters;
    public final boolean skipSilence;

    private DefaultAudioSink$MediaPositionParameters(PlaybackParameters playbackParameters, boolean bl2, long l10, long l11) {
        this.playbackParameters = playbackParameters;
        this.skipSilence = bl2;
        this.mediaTimeUs = l10;
        this.audioTrackPositionUs = l11;
    }

    public /* synthetic */ DefaultAudioSink$MediaPositionParameters(PlaybackParameters playbackParameters, boolean bl2, long l10, long l11, DefaultAudioSink$1 defaultAudioSink$1) {
        this(playbackParameters, bl2, l10, l11);
    }
}

