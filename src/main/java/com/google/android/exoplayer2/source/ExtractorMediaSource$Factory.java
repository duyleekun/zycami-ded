/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;

public final class ExtractorMediaSource$Factory
implements MediaSourceFactory {
    private int continueLoadingCheckIntervalBytes;
    private String customCacheKey;
    private final DataSource$Factory dataSourceFactory;
    private ExtractorsFactory extractorsFactory;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private Object tag;

    public ExtractorMediaSource$Factory(DataSource$Factory object) {
        this.dataSourceFactory = object;
        this.extractorsFactory = object = new DefaultExtractorsFactory();
        this.loadErrorHandlingPolicy = object = new DefaultLoadErrorHandlingPolicy();
        this.continueLoadingCheckIntervalBytes = 0x100000;
    }

    public ExtractorMediaSource createMediaSource(Uri object) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).build();
        return this.createMediaSource((MediaItem)object);
    }

    public ExtractorMediaSource createMediaSource(MediaItem object) {
        Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        object = ((MediaItem)object).playbackProperties;
        Uri uri = ((MediaItem$PlaybackProperties)object).uri;
        DataSource$Factory dataSource$Factory = this.dataSourceFactory;
        ExtractorsFactory extractorsFactory = this.extractorsFactory;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        String string2 = this.customCacheKey;
        int n10 = this.continueLoadingCheckIntervalBytes;
        object = ((MediaItem$PlaybackProperties)object).tag;
        if (object == null) {
            object = this.tag;
        }
        ExtractorMediaSource extractorMediaSource = new ExtractorMediaSource(uri, dataSource$Factory, extractorsFactory, loadErrorHandlingPolicy, string2, n10, object, null);
        return extractorMediaSource;
    }

    public int[] getSupportedTypes() {
        int[] nArray = new int[]{3};
        return nArray;
    }

    public ExtractorMediaSource$Factory setContinueLoadingCheckIntervalBytes(int n10) {
        this.continueLoadingCheckIntervalBytes = n10;
        return this;
    }

    public ExtractorMediaSource$Factory setCustomCacheKey(String string2) {
        this.customCacheKey = string2;
        return this;
    }

    public MediaSourceFactory setDrmHttpDataSourceFactory(HttpDataSource$Factory object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ExtractorMediaSource$Factory setDrmSessionManager(DrmSessionManager object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ExtractorMediaSource$Factory setDrmSessionManagerProvider(DrmSessionManagerProvider object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public MediaSourceFactory setDrmUserAgent(String object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public ExtractorMediaSource$Factory setExtractorsFactory(ExtractorsFactory extractorsFactory) {
        if (extractorsFactory == null) {
            extractorsFactory = new DefaultExtractorsFactory();
        }
        this.extractorsFactory = extractorsFactory;
        return this;
    }

    public ExtractorMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public ExtractorMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }
}

