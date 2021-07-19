/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 */
package com.google.android.exoplayer2.analytics;

import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.AnalyticsListener$Events;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import java.io.IOException;
import java.util.List;

public interface AnalyticsListener {
    public static final int EVENT_AUDIO_ATTRIBUTES_CHANGED = 1016;
    public static final int EVENT_AUDIO_DECODER_INITIALIZED = 1009;
    public static final int EVENT_AUDIO_DECODER_RELEASED = 1013;
    public static final int EVENT_AUDIO_DISABLED = 1014;
    public static final int EVENT_AUDIO_ENABLED = 1008;
    public static final int EVENT_AUDIO_INPUT_FORMAT_CHANGED = 1010;
    public static final int EVENT_AUDIO_POSITION_ADVANCING = 1011;
    public static final int EVENT_AUDIO_SESSION_ID = 1015;
    public static final int EVENT_AUDIO_SINK_ERROR = 1018;
    public static final int EVENT_AUDIO_UNDERRUN = 1012;
    public static final int EVENT_BANDWIDTH_ESTIMATE = 1006;
    public static final int EVENT_DOWNSTREAM_FORMAT_CHANGED = 1004;
    public static final int EVENT_DRM_KEYS_LOADED = 1031;
    public static final int EVENT_DRM_KEYS_REMOVED = 1034;
    public static final int EVENT_DRM_KEYS_RESTORED = 1033;
    public static final int EVENT_DRM_SESSION_ACQUIRED = 1030;
    public static final int EVENT_DRM_SESSION_MANAGER_ERROR = 1032;
    public static final int EVENT_DRM_SESSION_RELEASED = 1035;
    public static final int EVENT_DROPPED_VIDEO_FRAMES = 1023;
    public static final int EVENT_IS_LOADING_CHANGED = 4;
    public static final int EVENT_IS_PLAYING_CHANGED = 8;
    public static final int EVENT_LOAD_CANCELED = 1002;
    public static final int EVENT_LOAD_COMPLETED = 1001;
    public static final int EVENT_LOAD_ERROR = 1003;
    public static final int EVENT_LOAD_STARTED = 1000;
    public static final int EVENT_MEDIA_ITEM_TRANSITION = 1;
    public static final int EVENT_METADATA = 1007;
    public static final int EVENT_PLAYBACK_PARAMETERS_CHANGED = 13;
    public static final int EVENT_PLAYBACK_STATE_CHANGED = 5;
    public static final int EVENT_PLAYBACK_SUPPRESSION_REASON_CHANGED = 7;
    public static final int EVENT_PLAYER_ERROR = 11;
    public static final int EVENT_PLAYER_RELEASED = 1036;
    public static final int EVENT_PLAY_WHEN_READY_CHANGED = 6;
    public static final int EVENT_POSITION_DISCONTINUITY = 12;
    public static final int EVENT_RENDERED_FIRST_FRAME = 1027;
    public static final int EVENT_REPEAT_MODE_CHANGED = 9;
    public static final int EVENT_SHUFFLE_MODE_ENABLED_CHANGED = 10;
    public static final int EVENT_SKIP_SILENCE_ENABLED_CHANGED = 1017;
    public static final int EVENT_STATIC_METADATA_CHANGED = 3;
    public static final int EVENT_SURFACE_SIZE_CHANGED = 1029;
    public static final int EVENT_TIMELINE_CHANGED = 0;
    public static final int EVENT_TRACKS_CHANGED = 2;
    public static final int EVENT_UPSTREAM_DISCARDED = 1005;
    public static final int EVENT_VIDEO_DECODER_INITIALIZED = 1021;
    public static final int EVENT_VIDEO_DECODER_RELEASED = 1024;
    public static final int EVENT_VIDEO_DISABLED = 1025;
    public static final int EVENT_VIDEO_ENABLED = 1020;
    public static final int EVENT_VIDEO_FRAME_PROCESSING_OFFSET = 1026;
    public static final int EVENT_VIDEO_INPUT_FORMAT_CHANGED = 1022;
    public static final int EVENT_VIDEO_SIZE_CHANGED = 1028;
    public static final int EVENT_VOLUME_CHANGED = 1019;

    default public void onAudioAttributesChanged(AnalyticsListener$EventTime analyticsListener$EventTime, AudioAttributes audioAttributes) {
    }

    default public void onAudioDecoderInitialized(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10) {
    }

    default public void onAudioDecoderReleased(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
    }

    default public void onAudioDisabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
    }

    default public void onAudioEnabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
    }

    default public void onAudioInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format format) {
    }

    default public void onAudioInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.onAudioInputFormatChanged(analyticsListener$EventTime, format);
    }

    default public void onAudioPositionAdvancing(AnalyticsListener$EventTime analyticsListener$EventTime, long l10) {
    }

    default public void onAudioSessionIdChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onAudioSinkError(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
    }

    default public void onAudioUnderrun(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
    }

    default public void onBandwidthEstimate(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11) {
    }

    default public void onDecoderDisabled(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, DecoderCounters decoderCounters) {
    }

    default public void onDecoderEnabled(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, DecoderCounters decoderCounters) {
    }

    default public void onDecoderInitialized(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, String string2, long l10) {
    }

    default public void onDecoderInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, Format format) {
    }

    default public void onDownstreamFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData mediaLoadData) {
    }

    default public void onDrmKeysLoaded(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onDrmKeysRemoved(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onDrmKeysRestored(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onDrmSessionAcquired(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onDrmSessionManagerError(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception) {
    }

    default public void onDrmSessionReleased(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onDroppedVideoFrames(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10) {
    }

    default public void onEvents(Player player, Events events) {
    }

    default public void onIsLoadingChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
        this.onLoadingChanged(analyticsListener$EventTime, bl2);
    }

    default public void onIsPlayingChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
    }

    default public void onLoadCanceled(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default public void onLoadCompleted(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default public void onLoadError(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
    }

    default public void onLoadStarted(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
    }

    default public void onLoadingChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
    }

    default public void onMediaItemTransition(AnalyticsListener$EventTime analyticsListener$EventTime, MediaItem mediaItem, int n10) {
    }

    default public void onMetadata(AnalyticsListener$EventTime analyticsListener$EventTime, Metadata metadata) {
    }

    default public void onPlayWhenReadyChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10) {
    }

    default public void onPlaybackParametersChanged(AnalyticsListener$EventTime analyticsListener$EventTime, PlaybackParameters playbackParameters) {
    }

    default public void onPlaybackStateChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onPlaybackSuppressionReasonChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onPlayerError(AnalyticsListener$EventTime analyticsListener$EventTime, ExoPlaybackException exoPlaybackException) {
    }

    default public void onPlayerReleased(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onPlayerStateChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10) {
    }

    default public void onPositionDiscontinuity(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onRenderedFirstFrame(AnalyticsListener$EventTime analyticsListener$EventTime, Surface surface) {
    }

    default public void onRepeatModeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onSeekProcessed(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onSeekStarted(AnalyticsListener$EventTime analyticsListener$EventTime) {
    }

    default public void onShuffleModeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
    }

    default public void onSkipSilenceEnabledChanged(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2) {
    }

    default public void onStaticMetadataChanged(AnalyticsListener$EventTime analyticsListener$EventTime, List list) {
    }

    default public void onSurfaceSizeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11) {
    }

    default public void onTimelineChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10) {
    }

    default public void onTracksChanged(AnalyticsListener$EventTime analyticsListener$EventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
    }

    default public void onUpstreamDiscarded(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData mediaLoadData) {
    }

    default public void onVideoDecoderInitialized(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10) {
    }

    default public void onVideoDecoderReleased(AnalyticsListener$EventTime analyticsListener$EventTime, String string2) {
    }

    default public void onVideoDisabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
    }

    default public void onVideoEnabled(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters) {
    }

    default public void onVideoFrameProcessingOffset(AnalyticsListener$EventTime analyticsListener$EventTime, long l10, int n10) {
    }

    default public void onVideoInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format format) {
    }

    default public void onVideoInputFormatChanged(AnalyticsListener$EventTime analyticsListener$EventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        this.onVideoInputFormatChanged(analyticsListener$EventTime, format);
    }

    default public void onVideoSizeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, int n12, float f10) {
    }

    default public void onVolumeChanged(AnalyticsListener$EventTime analyticsListener$EventTime, float f10) {
    }
}

