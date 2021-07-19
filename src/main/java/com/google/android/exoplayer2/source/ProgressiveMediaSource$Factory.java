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
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.m0.l;

public final class ProgressiveMediaSource$Factory
implements MediaSourceFactory {
    private int continueLoadingCheckIntervalBytes;
    private String customCacheKey;
    private final DataSource$Factory dataSourceFactory;
    private DrmSessionManagerProvider drmSessionManagerProvider;
    private ExtractorsFactory extractorsFactory;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private Object tag;
    private boolean usingCustomDrmSessionManagerProvider;

    public ProgressiveMediaSource$Factory(DataSource$Factory dataSource$Factory) {
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        this(dataSource$Factory, defaultExtractorsFactory);
    }

    public ProgressiveMediaSource$Factory(DataSource$Factory object, ExtractorsFactory extractorsFactory) {
        this.dataSourceFactory = object;
        this.extractorsFactory = extractorsFactory;
        this.drmSessionManagerProvider = object = new DefaultDrmSessionManagerProvider();
        this.loadErrorHandlingPolicy = object = new DefaultLoadErrorHandlingPolicy();
        this.continueLoadingCheckIntervalBytes = 0x100000;
    }

    public static /* synthetic */ DrmSessionManager a(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    public ProgressiveMediaSource createMediaSource(Uri object) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).build();
        return this.createMediaSource((MediaItem)object);
    }

    public ProgressiveMediaSource createMediaSource(MediaItem object) {
        DataSource$Factory dataSource$Factory;
        boolean bl2;
        Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        Object object2 = ((MediaItem)object).playbackProperties;
        Object object3 = ((MediaItem$PlaybackProperties)object2).tag;
        boolean bl3 = true;
        ExtractorsFactory extractorsFactory = null;
        if (object3 == null && (object3 = this.tag) != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            object3 = null;
        }
        object2 = ((MediaItem$PlaybackProperties)object2).customCacheKey;
        if (object2 != null || (object2 = this.customCacheKey) == null) {
            bl3 = false;
            dataSource$Factory = null;
        }
        if (bl2 && bl3) {
            object = ((MediaItem)object).buildUpon();
            object2 = this.tag;
            object = ((MediaItem$Builder)object).setTag(object2);
            object2 = this.customCacheKey;
            object = ((MediaItem$Builder)object).setCustomCacheKey((String)object2).build();
        } else if (bl2) {
            object = ((MediaItem)object).buildUpon();
            object2 = this.tag;
            object = ((MediaItem$Builder)object).setTag(object2).build();
        } else if (bl3) {
            object = ((MediaItem)object).buildUpon();
            object2 = this.customCacheKey;
            object = ((MediaItem$Builder)object).setCustomCacheKey((String)object2).build();
        }
        object3 = object;
        dataSource$Factory = this.dataSourceFactory;
        extractorsFactory = this.extractorsFactory;
        DrmSessionManager drmSessionManager = this.drmSessionManagerProvider.get((MediaItem)object3);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        int n10 = this.continueLoadingCheckIntervalBytes;
        object2 = object;
        object = new ProgressiveMediaSource((MediaItem)object3, dataSource$Factory, extractorsFactory, drmSessionManager, loadErrorHandlingPolicy, n10);
        return object;
    }

    public int[] getSupportedTypes() {
        int[] nArray = new int[]{3};
        return nArray;
    }

    public ProgressiveMediaSource$Factory setContinueLoadingCheckIntervalBytes(int n10) {
        this.continueLoadingCheckIntervalBytes = n10;
        return this;
    }

    public ProgressiveMediaSource$Factory setCustomCacheKey(String string2) {
        this.customCacheKey = string2;
        return this;
    }

    public ProgressiveMediaSource$Factory setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmHttpDataSourceFactory(httpDataSource$Factory);
        }
        return this;
    }

    public ProgressiveMediaSource$Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        if (drmSessionManager == null) {
            drmSessionManager = null;
            this.setDrmSessionManagerProvider(null);
        } else {
            l l10 = new l(drmSessionManager);
            this.setDrmSessionManagerProvider(l10);
        }
        return this;
    }

    public ProgressiveMediaSource$Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
        if (drmSessionManagerProvider != null) {
            boolean bl2;
            this.drmSessionManagerProvider = drmSessionManagerProvider;
            this.usingCustomDrmSessionManagerProvider = bl2 = true;
        } else {
            this.drmSessionManagerProvider = drmSessionManagerProvider = new DefaultDrmSessionManagerProvider();
            boolean bl3 = false;
            drmSessionManagerProvider = null;
            this.usingCustomDrmSessionManagerProvider = false;
        }
        return this;
    }

    public ProgressiveMediaSource$Factory setDrmUserAgent(String string2) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmUserAgent(string2);
        }
        return this;
    }

    public ProgressiveMediaSource$Factory setExtractorsFactory(ExtractorsFactory extractorsFactory) {
        if (extractorsFactory == null) {
            extractorsFactory = new DefaultExtractorsFactory();
        }
        this.extractorsFactory = extractorsFactory;
        return this;
    }

    public ProgressiveMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public ProgressiveMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }
}

