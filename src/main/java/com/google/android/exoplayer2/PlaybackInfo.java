/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2;

import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.common.collect.ImmutableList;
import java.util.List;

public final class PlaybackInfo {
    private static final MediaSource$MediaPeriodId PLACEHOLDER_MEDIA_PERIOD_ID;
    public volatile long bufferedPositionUs;
    public final boolean isLoading;
    public final MediaSource$MediaPeriodId loadingMediaPeriodId;
    public final boolean offloadSchedulingEnabled;
    public final MediaSource$MediaPeriodId periodId;
    public final boolean playWhenReady;
    public final ExoPlaybackException playbackError;
    public final PlaybackParameters playbackParameters;
    public final int playbackState;
    public final int playbackSuppressionReason;
    public volatile long positionUs;
    public final long requestedContentPositionUs;
    public final boolean sleepingForOffload;
    public final List staticMetadata;
    public final Timeline timeline;
    public volatile long totalBufferedDurationUs;
    public final TrackGroupArray trackGroups;
    public final TrackSelectorResult trackSelectorResult;

    static {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        Object object = new Object();
        PLACEHOLDER_MEDIA_PERIOD_ID = mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object);
    }

    public PlaybackInfo(Timeline timeline, MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10, int n10, ExoPlaybackException exoPlaybackException, boolean bl2, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list, MediaSource$MediaPeriodId mediaSource$MediaPeriodId2, boolean bl3, int n11, PlaybackParameters playbackParameters, long l11, long l12, long l13, boolean bl4, boolean bl5) {
        this.timeline = timeline;
        this.periodId = mediaSource$MediaPeriodId;
        this.requestedContentPositionUs = l10;
        this.playbackState = n10;
        this.playbackError = exoPlaybackException;
        this.isLoading = bl2;
        this.trackGroups = trackGroupArray;
        this.trackSelectorResult = trackSelectorResult;
        this.staticMetadata = list;
        this.loadingMediaPeriodId = mediaSource$MediaPeriodId2;
        this.playWhenReady = bl3;
        this.playbackSuppressionReason = n11;
        this.playbackParameters = playbackParameters;
        this.bufferedPositionUs = l11;
        this.totalBufferedDurationUs = l12;
        this.positionUs = l13;
        this.offloadSchedulingEnabled = bl4;
        this.sleepingForOffload = bl5;
    }

    public static PlaybackInfo createDummy(TrackSelectorResult trackSelectorResult) {
        Timeline timeline = Timeline.EMPTY;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = PLACEHOLDER_MEDIA_PERIOD_ID;
        TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
        ImmutableList immutableList = ImmutableList.of();
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, -9223372036854775807L, 1, null, false, trackGroupArray, trackSelectorResult, immutableList, mediaSource$MediaPeriodId, false, 0, playbackParameters, 0L, 0L, 0L, false, false);
        return playbackInfo;
    }

    public static MediaSource$MediaPeriodId getDummyPeriodForEmptyTimeline() {
        return PLACEHOLDER_MEDIA_PERIOD_ID;
    }

    public PlaybackInfo copyWithIsLoading(boolean bl2) {
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithLoadingMediaPeriodId(MediaSource$MediaPeriodId object) {
        PlaybackInfo playbackInfo;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = object;
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl2 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        object = playbackInfo;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId2, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithNewPosition(MediaSource$MediaPeriodId object, long l10, long l11, long l12, TrackGroupArray trackGroupArray, TrackSelectorResult trackSelectorResult, List list) {
        PlaybackInfo playbackInfo;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = object;
        Timeline timeline = this.timeline;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl2 = this.isLoading;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        object = playbackInfo;
        long l13 = this.bufferedPositionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l11, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l13, l12, l10, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithOffloadSchedulingEnabled(boolean bl2) {
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl3 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl4 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl5 = this.sleepingForOffload;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl3, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl4, n11, playbackParameters, l11, l12, l13, bl2, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPlayWhenReady(boolean bl2, int n10) {
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n11 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl3 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n11, exoPlaybackException, bl3, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl2, n10, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPlaybackError(ExoPlaybackException object) {
        PlaybackInfo playbackInfo;
        ExoPlaybackException exoPlaybackException = object;
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        boolean bl2 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        object = playbackInfo;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPlaybackParameters(PlaybackParameters object) {
        PlaybackInfo playbackInfo;
        PlaybackParameters playbackParameters = object;
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl2 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        object = playbackInfo;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithPlaybackState(int n10) {
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl2 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }

    public PlaybackInfo copyWithSleepingForOffload(boolean bl2) {
        Timeline timeline = this.timeline;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl3 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl4 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl5 = this.offloadSchedulingEnabled;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl3, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl4, n11, playbackParameters, l11, l12, l13, bl5, bl2);
        return playbackInfo;
    }

    public PlaybackInfo copyWithTimeline(Timeline timeline) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.periodId;
        long l10 = this.requestedContentPositionUs;
        int n10 = this.playbackState;
        ExoPlaybackException exoPlaybackException = this.playbackError;
        boolean bl2 = this.isLoading;
        TrackGroupArray trackGroupArray = this.trackGroups;
        TrackSelectorResult trackSelectorResult = this.trackSelectorResult;
        List list = this.staticMetadata;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = this.loadingMediaPeriodId;
        boolean bl3 = this.playWhenReady;
        int n11 = this.playbackSuppressionReason;
        PlaybackParameters playbackParameters = this.playbackParameters;
        long l11 = this.bufferedPositionUs;
        long l12 = this.totalBufferedDurationUs;
        long l13 = this.positionUs;
        boolean bl4 = this.offloadSchedulingEnabled;
        boolean bl5 = this.sleepingForOffload;
        PlaybackInfo playbackInfo = new PlaybackInfo(timeline, mediaSource$MediaPeriodId, l10, n10, exoPlaybackException, bl2, trackGroupArray, trackSelectorResult, list, mediaSource$MediaPeriodId2, bl3, n11, playbackParameters, l11, l12, l13, bl4, bl5);
        return playbackInfo;
    }
}

