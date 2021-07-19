/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.hls.DefaultHlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.HlsExtractorFactory;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.FilteringHlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$Factory;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.m0.o.a;
import java.util.Collections;
import java.util.List;

public final class HlsMediaSource$Factory
implements MediaSourceFactory {
    private boolean allowChunklessPreparation;
    private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DrmSessionManagerProvider drmSessionManagerProvider;
    private long elapsedRealTimeOffsetMs;
    private HlsExtractorFactory extractorFactory;
    private final HlsDataSourceFactory hlsDataSourceFactory;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private int metadataType;
    private HlsPlaylistParserFactory playlistParserFactory;
    private HlsPlaylistTracker$Factory playlistTrackerFactory;
    private List streamKeys;
    private Object tag;
    private boolean useSessionKeys;
    private boolean usingCustomDrmSessionManagerProvider;

    public HlsMediaSource$Factory(HlsDataSourceFactory list) {
        list = (HlsDataSourceFactory)Assertions.checkNotNull(list);
        this.hlsDataSourceFactory = list;
        list = new List();
        this.drmSessionManagerProvider = list;
        list = new List();
        this.playlistParserFactory = list;
        list = DefaultHlsPlaylistTracker.FACTORY;
        this.playlistTrackerFactory = list;
        list = HlsExtractorFactory.DEFAULT;
        this.extractorFactory = list;
        list = new List();
        this.loadErrorHandlingPolicy = list;
        list = new List();
        this.compositeSequenceableLoaderFactory = list;
        this.metadataType = 1;
        this.streamKeys = list = Collections.emptyList();
        this.elapsedRealTimeOffsetMs = -9223372036854775807L;
    }

    public HlsMediaSource$Factory(DataSource$Factory dataSource$Factory) {
        DefaultHlsDataSourceFactory defaultHlsDataSourceFactory = new DefaultHlsDataSourceFactory(dataSource$Factory);
        this(defaultHlsDataSourceFactory);
    }

    public static /* synthetic */ DrmSessionManager a(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    public HlsMediaSource createMediaSource(Uri object) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setMimeType("application/x-mpegURL").build();
        return this.createMediaSource((MediaItem)object);
    }

    public HlsMediaSource createMediaSource(MediaItem mediaItem) {
        HlsExtractorFactory hlsExtractorFactory;
        boolean bl2;
        Object object;
        HlsMediaSource$Factory hlsMediaSource$Factory = this;
        Object object2 = mediaItem;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        Object object3 = this.playlistParserFactory;
        Object object4 = mediaItem.playbackProperties.streamKeys;
        boolean bl3 = object4.isEmpty();
        object4 = bl3 ? this.streamKeys : mediaItem.playbackProperties.streamKeys;
        boolean bl4 = object4.isEmpty();
        if (!bl4) {
            object3 = object = new FilteringHlsPlaylistParserFactory((HlsPlaylistParserFactory)object3, (List)object4);
        }
        object = ((MediaItem)object2).playbackProperties;
        Object object5 = ((MediaItem$PlaybackProperties)object).tag;
        boolean bl5 = true;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = null;
        if (object5 == null && (object5 = hlsMediaSource$Factory.tag) != null) {
            bl2 = bl5;
        } else {
            bl2 = false;
            object5 = null;
        }
        object = ((MediaItem$PlaybackProperties)object).streamKeys;
        bl4 = object.isEmpty();
        if (!bl4 || (bl4 = object4.isEmpty())) {
            bl5 = false;
            hlsExtractorFactory = null;
        }
        if (bl2 && bl5) {
            object2 = mediaItem.buildUpon();
            object = hlsMediaSource$Factory.tag;
            object2 = ((MediaItem$Builder)object2).setTag(object).setStreamKeys((List)object4).build();
        } else if (bl2) {
            object2 = mediaItem.buildUpon();
            object4 = hlsMediaSource$Factory.tag;
            object2 = ((MediaItem$Builder)object2).setTag(object4).build();
        } else if (bl5) {
            object2 = mediaItem.buildUpon().setStreamKeys((List)object4).build();
        }
        object = object2;
        object5 = hlsMediaSource$Factory.hlsDataSourceFactory;
        hlsExtractorFactory = hlsMediaSource$Factory.extractorFactory;
        compositeSequenceableLoaderFactory = hlsMediaSource$Factory.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = hlsMediaSource$Factory.drmSessionManagerProvider.get((MediaItem)object);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = hlsMediaSource$Factory.loadErrorHandlingPolicy;
        object4 = hlsMediaSource$Factory.playlistTrackerFactory;
        Object object6 = hlsMediaSource$Factory.hlsDataSourceFactory;
        object6 = object4.createTracker((HlsDataSourceFactory)object6, loadErrorHandlingPolicy, (HlsPlaylistParserFactory)object3);
        long l10 = hlsMediaSource$Factory.elapsedRealTimeOffsetMs;
        boolean bl6 = hlsMediaSource$Factory.allowChunklessPreparation;
        int n10 = hlsMediaSource$Factory.metadataType;
        boolean bl7 = hlsMediaSource$Factory.useSessionKeys;
        object4 = object2;
        object2 = new HlsMediaSource((MediaItem)object, (HlsDataSourceFactory)object5, hlsExtractorFactory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, (HlsPlaylistTracker)object6, l10, bl6, n10, bl7, null);
        return object2;
    }

    public int[] getSupportedTypes() {
        int[] nArray = new int[]{2};
        return nArray;
    }

    public HlsMediaSource$Factory setAllowChunklessPreparation(boolean bl2) {
        this.allowChunklessPreparation = bl2;
        return this;
    }

    public HlsMediaSource$Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
        if (compositeSequenceableLoaderFactory == null) {
            compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        return this;
    }

    public HlsMediaSource$Factory setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmHttpDataSourceFactory(httpDataSource$Factory);
        }
        return this;
    }

    public HlsMediaSource$Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        if (drmSessionManager == null) {
            drmSessionManager = null;
            this.setDrmSessionManagerProvider(null);
        } else {
            a a10 = new a(drmSessionManager);
            this.setDrmSessionManagerProvider(a10);
        }
        return this;
    }

    public HlsMediaSource$Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
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

    public HlsMediaSource$Factory setDrmUserAgent(String string2) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmUserAgent(string2);
        }
        return this;
    }

    public HlsMediaSource$Factory setElapsedRealTimeOffsetMs(long l10) {
        this.elapsedRealTimeOffsetMs = l10;
        return this;
    }

    public HlsMediaSource$Factory setExtractorFactory(HlsExtractorFactory hlsExtractorFactory) {
        if (hlsExtractorFactory == null) {
            hlsExtractorFactory = HlsExtractorFactory.DEFAULT;
        }
        this.extractorFactory = hlsExtractorFactory;
        return this;
    }

    public HlsMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public HlsMediaSource$Factory setMetadataType(int n10) {
        this.metadataType = n10;
        return this;
    }

    public HlsMediaSource$Factory setPlaylistParserFactory(HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        if (hlsPlaylistParserFactory == null) {
            hlsPlaylistParserFactory = new DefaultHlsPlaylistParserFactory();
        }
        this.playlistParserFactory = hlsPlaylistParserFactory;
        return this;
    }

    public HlsMediaSource$Factory setPlaylistTrackerFactory(HlsPlaylistTracker$Factory hlsPlaylistTracker$Factory) {
        if (hlsPlaylistTracker$Factory == null) {
            hlsPlaylistTracker$Factory = DefaultHlsPlaylistTracker.FACTORY;
        }
        this.playlistTrackerFactory = hlsPlaylistTracker$Factory;
        return this;
    }

    public HlsMediaSource$Factory setStreamKeys(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.streamKeys = list;
        return this;
    }

    public HlsMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }

    public HlsMediaSource$Factory setUseSessionKeys(boolean bl2) {
        this.useSessionKeys = bl2;
        return this;
    }
}

