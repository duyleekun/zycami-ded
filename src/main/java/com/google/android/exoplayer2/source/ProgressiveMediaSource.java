/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod;
import com.google.android.exoplayer2.source.ProgressiveMediaPeriod$Listener;
import com.google.android.exoplayer2.source.ProgressiveMediaSource$1;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;

public final class ProgressiveMediaSource
extends BaseMediaSource
implements ProgressiveMediaPeriod$Listener {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 0x100000;
    private final int continueLoadingCheckIntervalBytes;
    private final DataSource$Factory dataSourceFactory;
    private final DrmSessionManager drmSessionManager;
    private final ExtractorsFactory extractorsFactory;
    private final LoadErrorHandlingPolicy loadableLoadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final MediaItem$PlaybackProperties playbackProperties;
    private long timelineDurationUs;
    private boolean timelineIsLive;
    private boolean timelineIsPlaceholder;
    private boolean timelineIsSeekable;
    private TransferListener transferListener;

    public ProgressiveMediaSource(MediaItem mediaItem, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, int n10) {
        MediaItem$PlaybackProperties mediaItem$PlaybackProperties;
        this.playbackProperties = mediaItem$PlaybackProperties = (MediaItem$PlaybackProperties)Assertions.checkNotNull(mediaItem.playbackProperties);
        this.mediaItem = mediaItem;
        this.dataSourceFactory = dataSource$Factory;
        this.extractorsFactory = extractorsFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadableLoadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.continueLoadingCheckIntervalBytes = n10;
        this.timelineIsPlaceholder = true;
        this.timelineDurationUs = -9223372036854775807L;
    }

    private void notifySourceInfoRefreshed() {
        SinglePeriodTimeline singlePeriodTimeline;
        long l10 = this.timelineDurationUs;
        boolean bl2 = this.timelineIsSeekable;
        boolean bl3 = this.timelineIsLive;
        MediaItem mediaItem = this.mediaItem;
        Timeline timeline = singlePeriodTimeline;
        singlePeriodTimeline = new SinglePeriodTimeline(l10, bl2, false, bl3, null, mediaItem);
        boolean bl4 = this.timelineIsPlaceholder;
        if (bl4) {
            singlePeriodTimeline = timeline = new ProgressiveMediaSource$1(this, singlePeriodTimeline);
        }
        this.refreshSourceInfo(singlePeriodTimeline);
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        ProgressiveMediaPeriod progressiveMediaPeriod;
        ProgressiveMediaSource progressiveMediaSource = this;
        DataSource dataSource = this.dataSourceFactory.createDataSource();
        Object object = this.transferListener;
        if (object != null) {
            dataSource.addTransferListener((TransferListener)object);
        }
        Uri uri = progressiveMediaSource.playbackProperties.uri;
        ExtractorsFactory extractorsFactory = progressiveMediaSource.extractorsFactory;
        DrmSessionManager drmSessionManager = progressiveMediaSource.drmSessionManager;
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.createDrmEventDispatcher(mediaSource$MediaPeriodId);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = progressiveMediaSource.loadableLoadErrorHandlingPolicy;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.createEventDispatcher(mediaSource$MediaPeriodId);
        String string2 = progressiveMediaSource.playbackProperties.customCacheKey;
        int n10 = progressiveMediaSource.continueLoadingCheckIntervalBytes;
        object = progressiveMediaPeriod;
        progressiveMediaPeriod = new ProgressiveMediaPeriod(uri, dataSource, extractorsFactory, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher, this, allocator, string2, n10);
        return progressiveMediaPeriod;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return this.playbackProperties.tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void onSourceInfoRefreshed(long l10, boolean bl2, boolean bl3) {
        long l11;
        long l12 = -9223372036854775807L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            l10 = this.timelineDurationUs;
        }
        if ((object = (Object)this.timelineIsPlaceholder) == false && (object = (l11 = (l12 = this.timelineDurationUs) - l10) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false && (object = (Object)this.timelineIsSeekable) == bl2 && (object = (Object)this.timelineIsLive) == bl3) {
            return;
        }
        this.timelineDurationUs = l10;
        this.timelineIsSeekable = bl2;
        this.timelineIsLive = bl3;
        this.timelineIsPlaceholder = false;
        this.notifySourceInfoRefreshed();
    }

    public void prepareSourceInternal(TransferListener transferListener) {
        this.transferListener = transferListener;
        this.drmSessionManager.prepare();
        this.notifySourceInfoRefreshed();
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((ProgressiveMediaPeriod)mediaPeriod).release();
    }

    public void releaseSourceInternal() {
        this.drmSessionManager.release();
    }
}

