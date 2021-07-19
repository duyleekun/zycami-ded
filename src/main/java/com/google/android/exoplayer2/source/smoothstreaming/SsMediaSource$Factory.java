/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.smoothstreaming.DefaultSsChunkSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.m0.p.a;
import java.util.Collections;
import java.util.List;

public final class SsMediaSource$Factory
implements MediaSourceFactory {
    private final SsChunkSource$Factory chunkSourceFactory;
    private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DrmSessionManagerProvider drmSessionManagerProvider;
    private long livePresentationDelayMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final DataSource$Factory manifestDataSourceFactory;
    private ParsingLoadable$Parser manifestParser;
    private List streamKeys;
    private Object tag;
    private boolean usingCustomDrmSessionManagerProvider;

    public SsMediaSource$Factory(SsChunkSource$Factory list, DataSource$Factory dataSource$Factory) {
        list = (SsChunkSource$Factory)Assertions.checkNotNull(list);
        this.chunkSourceFactory = list;
        this.manifestDataSourceFactory = dataSource$Factory;
        list = new List();
        this.drmSessionManagerProvider = list;
        list = new List();
        this.loadErrorHandlingPolicy = list;
        this.livePresentationDelayMs = 30000L;
        list = new List();
        this.compositeSequenceableLoaderFactory = list;
        this.streamKeys = list = Collections.emptyList();
    }

    public SsMediaSource$Factory(DataSource$Factory dataSource$Factory) {
        DefaultSsChunkSource$Factory defaultSsChunkSource$Factory = new DefaultSsChunkSource$Factory(dataSource$Factory);
        this(defaultSsChunkSource$Factory, dataSource$Factory);
    }

    public static /* synthetic */ DrmSessionManager a(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    public SsMediaSource createMediaSource(Uri object) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).build();
        return this.createMediaSource((MediaItem)object);
    }

    public SsMediaSource createMediaSource(MediaItem mediaItem) {
        ParsingLoadable$Parser parsingLoadable$Parser;
        Object object;
        boolean bl2;
        List list;
        boolean bl3;
        SsMediaSource$Factory ssMediaSource$Factory = this;
        Object object2 = mediaItem;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        Object object3 = this.manifestParser;
        if (object3 == null) {
            object3 = new SsManifestParser();
        }
        if (!(bl3 = (list = !(bl2 = (list = object2.playbackProperties.streamKeys).isEmpty()) ? object2.playbackProperties.streamKeys : ssMediaSource$Factory.streamKeys).isEmpty())) {
            object = new FilteringManifestParser((ParsingLoadable$Parser)object3, list);
            parsingLoadable$Parser = object;
        } else {
            parsingLoadable$Parser = object3;
        }
        object3 = ((MediaItem)object2).playbackProperties;
        object = ((MediaItem$PlaybackProperties)object3).tag;
        boolean bl4 = true;
        Object object4 = null;
        if (object == null && (object = ssMediaSource$Factory.tag) != null) {
            bl3 = bl4;
        } else {
            bl3 = false;
            object = null;
        }
        object3 = ((MediaItem$PlaybackProperties)object3).streamKeys;
        boolean bl5 = object3.isEmpty();
        if (!bl5 || (bl5 = list.isEmpty())) {
            bl4 = false;
        }
        if (bl3 && bl4) {
            object2 = mediaItem.buildUpon();
            object3 = ssMediaSource$Factory.tag;
            object2 = ((MediaItem$Builder)object2).setTag(object3).setStreamKeys(list).build();
        } else if (bl3) {
            object2 = mediaItem.buildUpon();
            object3 = ssMediaSource$Factory.tag;
            object2 = ((MediaItem$Builder)object2).setTag(object3).build();
        } else if (bl4) {
            object2 = mediaItem.buildUpon().setStreamKeys(list).build();
        }
        object4 = object2;
        DataSource$Factory dataSource$Factory = ssMediaSource$Factory.manifestDataSourceFactory;
        SsChunkSource$Factory ssChunkSource$Factory = ssMediaSource$Factory.chunkSourceFactory;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = ssMediaSource$Factory.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = ssMediaSource$Factory.drmSessionManagerProvider.get((MediaItem)object4);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = ssMediaSource$Factory.loadErrorHandlingPolicy;
        long l10 = ssMediaSource$Factory.livePresentationDelayMs;
        object2 = new SsMediaSource((MediaItem)object4, null, dataSource$Factory, parsingLoadable$Parser, ssChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l10, null);
        return object2;
    }

    public SsMediaSource createMediaSource(SsManifest ssManifest) {
        MediaItem mediaItem = MediaItem.fromUri(Uri.EMPTY);
        return this.createMediaSource(ssManifest, mediaItem);
    }

    public SsMediaSource createMediaSource(SsManifest ssManifest, MediaItem mediaItem) {
        MediaItem mediaItem2;
        boolean bl2;
        SsMediaSource$Factory ssMediaSource$Factory = this;
        Object object = ssManifest;
        Object object2 = mediaItem;
        boolean bl3 = ssManifest.isLive;
        boolean bl4 = true;
        Assertions.checkArgument(bl3 ^= bl4);
        Object object3 = mediaItem.playbackProperties;
        object3 = object3 != null && !(bl3 = (object3 = ((MediaItem$PlaybackProperties)object3).streamKeys).isEmpty()) ? mediaItem.playbackProperties.streamKeys : ssMediaSource$Factory.streamKeys;
        boolean bl5 = object3.isEmpty();
        if (!bl5) {
            object = ((SsManifest)object).copy((List)object3);
        }
        SsManifest ssManifest2 = object;
        object = ((MediaItem)object2).playbackProperties;
        bl5 = false;
        Object object4 = null;
        if (object != null) {
            bl2 = bl4;
        } else {
            bl2 = false;
            mediaItem2 = null;
        }
        if (!bl2 || (object = ((MediaItem$PlaybackProperties)object).tag) == null) {
            bl4 = false;
        }
        object = mediaItem.buildUpon();
        object4 = "application/vnd.ms-sstr+xml";
        object = ((MediaItem$Builder)object).setMimeType((String)object4);
        object4 = bl2 ? object2.playbackProperties.uri : Uri.EMPTY;
        object = ((MediaItem$Builder)object).setUri((Uri)object4);
        object2 = bl4 ? object2.playbackProperties.tag : ssMediaSource$Factory.tag;
        mediaItem2 = ((MediaItem$Builder)object).setTag(object2).setStreamKeys((List)object3).build();
        SsChunkSource$Factory ssChunkSource$Factory = ssMediaSource$Factory.chunkSourceFactory;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = ssMediaSource$Factory.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = ssMediaSource$Factory.drmSessionManagerProvider.get(mediaItem2);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = ssMediaSource$Factory.loadErrorHandlingPolicy;
        long l10 = ssMediaSource$Factory.livePresentationDelayMs;
        object4 = object;
        object = new SsMediaSource(mediaItem2, ssManifest2, null, null, ssChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l10, null);
        return object;
    }

    public int[] getSupportedTypes() {
        int n10 = 1;
        int[] nArray = new int[n10];
        nArray[0] = n10;
        return nArray;
    }

    public SsMediaSource$Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
        if (compositeSequenceableLoaderFactory == null) {
            compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        return this;
    }

    public SsMediaSource$Factory setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmHttpDataSourceFactory(httpDataSource$Factory);
        }
        return this;
    }

    public SsMediaSource$Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        if (drmSessionManager == null) {
            drmSessionManager = null;
            this.setDrmSessionManagerProvider(null);
        } else {
            a a10 = new a(drmSessionManager);
            this.setDrmSessionManagerProvider(a10);
        }
        return this;
    }

    public SsMediaSource$Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
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

    public SsMediaSource$Factory setDrmUserAgent(String string2) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmUserAgent(string2);
        }
        return this;
    }

    public SsMediaSource$Factory setLivePresentationDelayMs(long l10) {
        this.livePresentationDelayMs = l10;
        return this;
    }

    public SsMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public SsMediaSource$Factory setManifestParser(ParsingLoadable$Parser parsingLoadable$Parser) {
        this.manifestParser = parsingLoadable$Parser;
        return this;
    }

    public SsMediaSource$Factory setStreamKeys(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.streamKeys = list;
        return this;
    }

    public SsMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }
}

