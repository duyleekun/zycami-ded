/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.util.List;

public interface Player$EventListener {
    default public void onEvents(Player player, Player.Events events) {
    }

    default public void onExperimentalOffloadSchedulingEnabledChanged(boolean bl2) {
    }

    default public void onExperimentalSleepingForOffloadChanged(boolean bl2) {
    }

    default public void onIsLoadingChanged(boolean bl2) {
        this.onLoadingChanged(bl2);
    }

    default public void onIsPlayingChanged(boolean bl2) {
    }

    default public void onLoadingChanged(boolean bl2) {
    }

    default public void onMediaItemTransition(MediaItem mediaItem, int n10) {
    }

    default public void onPlayWhenReadyChanged(boolean bl2, int n10) {
    }

    default public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
    }

    default public void onPlaybackStateChanged(int n10) {
    }

    default public void onPlaybackSuppressionReasonChanged(int n10) {
    }

    default public void onPlayerError(ExoPlaybackException exoPlaybackException) {
    }

    default public void onPlayerStateChanged(boolean bl2, int n10) {
    }

    default public void onPositionDiscontinuity(int n10) {
    }

    default public void onRepeatModeChanged(int n10) {
    }

    default public void onSeekProcessed() {
    }

    default public void onShuffleModeEnabledChanged(boolean bl2) {
    }

    default public void onStaticMetadataChanged(List list) {
    }

    default public void onTimelineChanged(Timeline timeline, int n10) {
        Object object;
        int n11;
        int n12 = timeline.getWindowCount();
        if (n12 == (n11 = 1)) {
            object = new Timeline$Window();
            n11 = 0;
            object = timeline.getWindow((int)0, (Timeline$Window)object).manifest;
        } else {
            n12 = 0;
            object = null;
        }
        this.onTimelineChanged(timeline, object, n10);
    }

    default public void onTimelineChanged(Timeline timeline, Object object, int n10) {
    }

    default public void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }
}

