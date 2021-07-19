/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;

public final class StandaloneMediaClock
implements MediaClock {
    private long baseElapsedMs;
    private long baseUs;
    private final Clock clock;
    private PlaybackParameters playbackParameters;
    private boolean started;

    public StandaloneMediaClock(Clock object) {
        this.clock = object;
        this.playbackParameters = object = PlaybackParameters.DEFAULT;
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackParameters;
    }

    public long getPositionUs() {
        long l10 = this.baseUs;
        boolean bl2 = this.started;
        if (bl2) {
            Clock clock = this.clock;
            long l11 = clock.elapsedRealtime();
            long l12 = this.baseElapsedMs;
            l11 -= l12;
            PlaybackParameters playbackParameters = this.playbackParameters;
            float f10 = playbackParameters.speed;
            float f11 = 1.0f;
            float f12 = f10 - f11;
            Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            l11 = object == false ? C.msToUs(l11) : playbackParameters.getMediaTimeUsForPlayoutTimeMs(l11);
            l10 += l11;
        }
        return l10;
    }

    public void resetPosition(long l10) {
        this.baseUs = l10;
        boolean bl2 = this.started;
        if (bl2) {
            Clock clock = this.clock;
            this.baseElapsedMs = l10 = clock.elapsedRealtime();
        }
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        boolean bl2 = this.started;
        if (bl2) {
            long l10 = this.getPositionUs();
            this.resetPosition(l10);
        }
        this.playbackParameters = playbackParameters;
    }

    public void start() {
        boolean bl2 = this.started;
        if (!bl2) {
            long l10;
            Clock clock = this.clock;
            this.baseElapsedMs = l10 = clock.elapsedRealtime();
            this.started = bl2 = true;
        }
    }

    public void stop() {
        boolean bl2 = this.started;
        if (bl2) {
            long l10 = this.getPositionUs();
            this.resetPosition(l10);
            bl2 = false;
            this.started = false;
        }
    }
}

