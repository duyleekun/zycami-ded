/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.DefaultMediaClock$PlaybackParametersListener;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.MediaClock;
import com.google.android.exoplayer2.util.StandaloneMediaClock;

public final class DefaultMediaClock
implements MediaClock {
    private boolean isUsingStandaloneClock;
    private final DefaultMediaClock$PlaybackParametersListener listener;
    private MediaClock rendererClock;
    private Renderer rendererClockSource;
    private final StandaloneMediaClock standaloneClock;
    private boolean standaloneClockIsStarted;

    public DefaultMediaClock(DefaultMediaClock$PlaybackParametersListener object, Clock clock) {
        this.listener = object;
        this.standaloneClock = object = new StandaloneMediaClock(clock);
        this.isUsingStandaloneClock = true;
    }

    private boolean shouldUseStandaloneClock(boolean bl2) {
        Renderer renderer;
        boolean bl3;
        Renderer renderer2 = this.rendererClockSource;
        if (renderer2 != null && !(bl3 = renderer2.isEnded()) && ((bl3 = (renderer2 = this.rendererClockSource).isReady()) || !bl2 && !(bl2 = (renderer = this.rendererClockSource).hasReadStreamToEnd()))) {
            bl2 = false;
            renderer = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private void syncClocks(boolean bl2) {
        StandaloneMediaClock standaloneMediaClock;
        if (bl2 = this.shouldUseStandaloneClock(bl2)) {
            this.isUsingStandaloneClock = true;
            bl2 = this.standaloneClockIsStarted;
            if (bl2) {
                StandaloneMediaClock standaloneMediaClock2 = this.standaloneClock;
                standaloneMediaClock2.start();
            }
            return;
        }
        Object object = (MediaClock)Assertions.checkNotNull(this.rendererClock);
        long l10 = object.getPositionUs();
        Object object2 = this.isUsingStandaloneClock;
        if (object2 != 0) {
            standaloneMediaClock = this.standaloneClock;
            long l11 = standaloneMediaClock.getPositionUs();
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 < 0) {
                this.standaloneClock.stop();
                return;
            }
            standaloneMediaClock = null;
            this.isUsingStandaloneClock = false;
            object2 = this.standaloneClockIsStarted;
            if (object2 != 0) {
                standaloneMediaClock = this.standaloneClock;
                standaloneMediaClock.start();
            }
        }
        standaloneMediaClock = this.standaloneClock;
        standaloneMediaClock.resetPosition(l10);
        object = object.getPlaybackParameters();
        Object object3 = this.standaloneClock.getPlaybackParameters();
        boolean bl3 = ((PlaybackParameters)object).equals(object3);
        if (!bl3) {
            this.standaloneClock.setPlaybackParameters((PlaybackParameters)object);
            object3 = this.listener;
            object3.onPlaybackParametersChanged((PlaybackParameters)object);
        }
    }

    public PlaybackParameters getPlaybackParameters() {
        Object object = this.rendererClock;
        object = object != null ? object.getPlaybackParameters() : this.standaloneClock.getPlaybackParameters();
        return object;
    }

    public long getPositionUs() {
        long l10;
        boolean bl2 = this.isUsingStandaloneClock;
        if (bl2) {
            StandaloneMediaClock standaloneMediaClock = this.standaloneClock;
            l10 = standaloneMediaClock.getPositionUs();
        } else {
            MediaClock mediaClock = (MediaClock)Assertions.checkNotNull(this.rendererClock);
            l10 = mediaClock.getPositionUs();
        }
        return l10;
    }

    public void onRendererDisabled(Renderer renderer) {
        Renderer renderer2 = this.rendererClockSource;
        if (renderer == renderer2) {
            boolean bl2;
            renderer = null;
            this.rendererClock = null;
            this.rendererClockSource = null;
            this.isUsingStandaloneClock = bl2 = true;
        }
    }

    public void onRendererEnabled(Renderer object) {
        MediaClock mediaClock;
        MediaClock mediaClock2 = object.getMediaClock();
        if (mediaClock2 != null && mediaClock2 != (mediaClock = this.rendererClock)) {
            if (mediaClock == null) {
                this.rendererClock = mediaClock2;
                this.rendererClockSource = object;
                object = this.standaloneClock.getPlaybackParameters();
                mediaClock2.setPlaybackParameters((PlaybackParameters)object);
            } else {
                object = new IllegalStateException("Multiple renderer media clocks enabled.");
                throw ExoPlaybackException.createForUnexpected((RuntimeException)object);
            }
        }
    }

    public void resetPosition(long l10) {
        this.standaloneClock.resetPosition(l10);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        MediaClock mediaClock = this.rendererClock;
        if (mediaClock != null) {
            mediaClock.setPlaybackParameters(playbackParameters);
            playbackParameters = this.rendererClock.getPlaybackParameters();
        }
        this.standaloneClock.setPlaybackParameters(playbackParameters);
    }

    public void start() {
        this.standaloneClockIsStarted = true;
        this.standaloneClock.start();
    }

    public void stop() {
        this.standaloneClockIsStarted = false;
        this.standaloneClock.stop();
    }

    public long syncAndGetPositionUs(boolean bl2) {
        this.syncClocks(bl2);
        return this.getPositionUs();
    }
}

