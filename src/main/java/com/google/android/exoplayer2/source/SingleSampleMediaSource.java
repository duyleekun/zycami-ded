/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Format$Builder;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.MediaItem$Subtitle;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.SingleSampleMediaPeriod;
import com.google.android.exoplayer2.source.SingleSampleMediaSource$1;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DataSpec$Builder;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import java.util.List;

public final class SingleSampleMediaSource
extends BaseMediaSource {
    private final DataSource$Factory dataSourceFactory;
    private final DataSpec dataSpec;
    private final long durationUs;
    private final Format format;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final MediaItem mediaItem;
    private final Timeline timeline;
    private TransferListener transferListener;
    private final boolean treatLoadErrorsAsEndOfStream;

    private SingleSampleMediaSource(String string2, MediaItem$Subtitle mediaItem$Subtitle, DataSource$Factory dataSource$Factory, long l10, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean bl2, Object object) {
        SinglePeriodTimeline singlePeriodTimeline;
        MediaItem mediaItem;
        Object object2 = mediaItem$Subtitle;
        this.dataSourceFactory = dataSource$Factory;
        this.durationUs = l10;
        Object object3 = loadErrorHandlingPolicy;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        boolean bl3 = bl2;
        this.treatLoadErrorsAsEndOfStream = bl2;
        object3 = new MediaItem$Builder();
        Object object4 = Uri.EMPTY;
        object3 = ((MediaItem$Builder)object3).setUri((Uri)object4);
        object4 = mediaItem$Subtitle.uri.toString();
        object3 = ((MediaItem$Builder)object3).setMediaId((String)object4);
        object4 = Collections.singletonList(mediaItem$Subtitle);
        object3 = ((MediaItem$Builder)object3).setSubtitles((List)object4);
        object4 = object;
        this.mediaItem = mediaItem = ((MediaItem$Builder)object3).setTag(object).build();
        object3 = new Format$Builder();
        object4 = string2;
        object3 = ((Format$Builder)object3).setId(string2);
        object4 = mediaItem$Subtitle.mimeType;
        object3 = ((Format$Builder)object3).setSampleMimeType((String)object4);
        object4 = mediaItem$Subtitle.language;
        object3 = ((Format$Builder)object3).setLanguage((String)object4);
        int n10 = mediaItem$Subtitle.selectionFlags;
        object3 = ((Format$Builder)object3).setSelectionFlags(n10);
        n10 = mediaItem$Subtitle.roleFlags;
        object3 = ((Format$Builder)object3).setRoleFlags(n10);
        object4 = mediaItem$Subtitle.label;
        this.format = object3 = ((Format$Builder)object3).setLabel((String)object4).build();
        object3 = new DataSpec$Builder();
        object2 = mediaItem$Subtitle.uri;
        object2 = ((DataSpec$Builder)object3).setUri((Uri)object2);
        bl3 = true;
        this.dataSpec = object2 = ((DataSpec$Builder)object2).setFlags((int)(bl3 ? 1 : 0)).build();
        object2 = singlePeriodTimeline;
        singlePeriodTimeline = new SinglePeriodTimeline(l10, bl3, false, false, null, mediaItem);
        this.timeline = singlePeriodTimeline;
    }

    public /* synthetic */ SingleSampleMediaSource(String string2, MediaItem$Subtitle mediaItem$Subtitle, DataSource$Factory dataSource$Factory, long l10, LoadErrorHandlingPolicy loadErrorHandlingPolicy, boolean bl2, Object object, SingleSampleMediaSource$1 singleSampleMediaSource$1) {
        this(string2, mediaItem$Subtitle, dataSource$Factory, l10, loadErrorHandlingPolicy, bl2, object);
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator object, long l10) {
        DataSpec dataSpec = this.dataSpec;
        DataSource$Factory dataSource$Factory = this.dataSourceFactory;
        TransferListener transferListener = this.transferListener;
        Format format = this.format;
        long l11 = this.durationUs;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.createEventDispatcher(mediaSource$MediaPeriodId);
        boolean bl2 = this.treatLoadErrorsAsEndOfStream;
        object = new SingleSampleMediaPeriod(dataSpec, dataSource$Factory, transferListener, format, l11, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher, bl2);
        return object;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return ((MediaItem$PlaybackProperties)Util.castNonNull((Object)this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
    }

    public void prepareSourceInternal(TransferListener object) {
        this.transferListener = object;
        object = this.timeline;
        this.refreshSourceInfo((Timeline)object);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SingleSampleMediaPeriod)mediaPeriod).release();
    }

    public void releaseSourceInternal() {
    }
}

