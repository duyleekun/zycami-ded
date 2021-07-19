/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import android.os.Handler;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.CompositeMediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource$1;
import com.google.android.exoplayer2.source.ExtractorMediaSource$EventListener;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.TransferListener;

public final class ExtractorMediaSource
extends CompositeMediaSource {
    public static final int DEFAULT_LOADING_CHECK_INTERVAL_BYTES = 0x100000;
    private final ProgressiveMediaSource progressiveMediaSource;

    public ExtractorMediaSource(Uri uri, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, Handler handler, ExtractorMediaSource$EventListener extractorMediaSource$EventListener) {
        this(uri, dataSource$Factory, extractorsFactory, handler, extractorMediaSource$EventListener, null);
    }

    public ExtractorMediaSource(Uri uri, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, Handler handler, ExtractorMediaSource$EventListener extractorMediaSource$EventListener, String string2) {
        this(uri, dataSource$Factory, extractorsFactory, handler, extractorMediaSource$EventListener, string2, 0x100000);
    }

    public ExtractorMediaSource(Uri object, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, Handler handler, ExtractorMediaSource$EventListener extractorMediaSource$EventListener, String string2, int n10) {
        DefaultLoadErrorHandlingPolicy defaultLoadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        this((Uri)object, dataSource$Factory, extractorsFactory, defaultLoadErrorHandlingPolicy, string2, n10, null);
        if (extractorMediaSource$EventListener != null && handler != null) {
            super(extractorMediaSource$EventListener);
            this.addEventListener(handler, (MediaSourceEventListener)object);
        }
    }

    private ExtractorMediaSource(Uri uri, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, String string2, int n10, Object object) {
        ProgressiveMediaSource progressiveMediaSource;
        Object object2 = new MediaItem$Builder();
        MediaItem mediaItem = ((MediaItem$Builder)object2).setUri(uri).setCustomCacheKey(string2).setTag(object).build();
        DrmSessionManager drmSessionManager = DrmSessionManager.DRM_UNSUPPORTED;
        object2 = progressiveMediaSource;
        this.progressiveMediaSource = progressiveMediaSource = new ProgressiveMediaSource(mediaItem, dataSource$Factory, extractorsFactory, drmSessionManager, loadErrorHandlingPolicy, n10);
    }

    public /* synthetic */ ExtractorMediaSource(Uri uri, DataSource$Factory dataSource$Factory, ExtractorsFactory extractorsFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, String string2, int n10, Object object, ExtractorMediaSource$1 extractorMediaSource$1) {
        this(uri, dataSource$Factory, extractorsFactory, loadErrorHandlingPolicy, string2, n10, object);
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        return this.progressiveMediaSource.createPeriod(mediaSource$MediaPeriodId, allocator, l10);
    }

    public MediaItem getMediaItem() {
        return this.progressiveMediaSource.getMediaItem();
    }

    public Object getTag() {
        return this.progressiveMediaSource.getTag();
    }

    public void onChildSourceInfoRefreshed(Void void_, MediaSource mediaSource, Timeline timeline) {
        this.refreshSourceInfo(timeline);
    }

    public void prepareSourceInternal(TransferListener object) {
        super.prepareSourceInternal((TransferListener)object);
        object = this.progressiveMediaSource;
        this.prepareChildSource(null, (MediaSource)object);
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        this.progressiveMediaSource.releasePeriod(mediaPeriod);
    }
}

