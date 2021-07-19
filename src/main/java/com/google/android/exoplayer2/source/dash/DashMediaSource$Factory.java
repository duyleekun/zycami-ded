/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 */
package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManagerProvider;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManagerProvider;
import com.google.android.exoplayer2.offline.FilteringManifestParser;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.DefaultCompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.dash.DashChunkSource$Factory;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.dash.DefaultDashChunkSource$Factory;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.DashManifestParser;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DefaultLoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.HttpDataSource$Factory;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;
import d.h.a.a.m0.n.b;
import java.util.Collections;
import java.util.List;

public final class DashMediaSource$Factory
implements MediaSourceFactory {
    private final DashChunkSource$Factory chunkSourceFactory;
    private CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DrmSessionManagerProvider drmSessionManagerProvider;
    private long fallbackTargetLiveOffsetMs;
    private LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private final DataSource$Factory manifestDataSourceFactory;
    private ParsingLoadable$Parser manifestParser;
    private List streamKeys;
    private Object tag;
    private long targetLiveOffsetOverrideMs;
    private boolean usingCustomDrmSessionManagerProvider;

    public DashMediaSource$Factory(DashChunkSource$Factory list, DataSource$Factory dataSource$Factory) {
        list = (DashChunkSource$Factory)Assertions.checkNotNull(list);
        this.chunkSourceFactory = list;
        this.manifestDataSourceFactory = dataSource$Factory;
        list = new List();
        this.drmSessionManagerProvider = list;
        list = new List();
        this.loadErrorHandlingPolicy = list;
        this.targetLiveOffsetOverrideMs = -9223372036854775807L;
        this.fallbackTargetLiveOffsetMs = 30000L;
        list = new List();
        this.compositeSequenceableLoaderFactory = list;
        this.streamKeys = list = Collections.emptyList();
    }

    public DashMediaSource$Factory(DataSource$Factory dataSource$Factory) {
        DefaultDashChunkSource$Factory defaultDashChunkSource$Factory = new DefaultDashChunkSource$Factory(dataSource$Factory);
        this(defaultDashChunkSource$Factory, dataSource$Factory);
    }

    public static /* synthetic */ DrmSessionManager a(DrmSessionManager drmSessionManager, MediaItem mediaItem) {
        return drmSessionManager;
    }

    public DashMediaSource createMediaSource(Uri object) {
        Object object2 = new MediaItem$Builder();
        object = ((MediaItem$Builder)object2).setUri((Uri)object).setMimeType("application/dash+xml");
        object2 = this.tag;
        object = ((MediaItem$Builder)object).setTag(object2).build();
        return this.createMediaSource((MediaItem)object);
    }

    /*
     * Enabled aggressive block sorting
     */
    public DashMediaSource createMediaSource(MediaItem mediaItem) {
        long l10;
        ParsingLoadable$Parser parsingLoadable$Parser;
        Object object;
        boolean bl2;
        List list;
        boolean bl3;
        DashMediaSource$Factory dashMediaSource$Factory = this;
        Object object2 = mediaItem;
        Assertions.checkNotNull(mediaItem.playbackProperties);
        Object object3 = this.manifestParser;
        if (object3 == null) {
            object3 = new DashManifestParser();
        }
        if (!(bl3 = (list = (bl2 = (list = object2.playbackProperties.streamKeys).isEmpty()) ? dashMediaSource$Factory.streamKeys : object2.playbackProperties.streamKeys).isEmpty())) {
            object = new FilteringManifestParser((ParsingLoadable$Parser)object3, list);
            parsingLoadable$Parser = object;
        } else {
            parsingLoadable$Parser = object3;
        }
        object3 = ((MediaItem)object2).playbackProperties;
        object = ((MediaItem$PlaybackProperties)object3).tag;
        boolean bl4 = true;
        Object object4 = null;
        if (object == null && (object = dashMediaSource$Factory.tag) != null) {
            bl3 = bl4;
        } else {
            bl3 = false;
            object = null;
        }
        object3 = ((MediaItem$PlaybackProperties)object3).streamKeys;
        boolean bl5 = object3.isEmpty();
        if (bl5 && !(bl5 = list.isEmpty())) {
            bl5 = bl4;
        } else {
            bl5 = false;
            object3 = null;
        }
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration = ((MediaItem)object2).liveConfiguration;
        long l11 = mediaItem$LiveConfiguration.targetOffsetMs;
        long l12 = -9223372036854775807L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 != false || (l13 = (l10 = (l11 = dashMediaSource$Factory.targetLiveOffsetOverrideMs) - l12) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            bl4 = false;
        }
        if (bl3 || bl5 || bl4) {
            object2 = mediaItem.buildUpon();
            if (bl3) {
                object = dashMediaSource$Factory.tag;
                ((MediaItem$Builder)object2).setTag(object);
            }
            if (bl5) {
                ((MediaItem$Builder)object2).setStreamKeys(list);
            }
            if (bl4) {
                long l14 = dashMediaSource$Factory.targetLiveOffsetOverrideMs;
                ((MediaItem$Builder)object2).setLiveTargetOffsetMs(l14);
            }
            object2 = ((MediaItem$Builder)object2).build();
        }
        object4 = object2;
        DataSource$Factory dataSource$Factory = dashMediaSource$Factory.manifestDataSourceFactory;
        DashChunkSource$Factory dashChunkSource$Factory = dashMediaSource$Factory.chunkSourceFactory;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = dashMediaSource$Factory.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = dashMediaSource$Factory.drmSessionManagerProvider.get((MediaItem)object4);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = dashMediaSource$Factory.loadErrorHandlingPolicy;
        long l15 = dashMediaSource$Factory.fallbackTargetLiveOffsetMs;
        return new DashMediaSource((MediaItem)object4, null, dataSource$Factory, parsingLoadable$Parser, dashChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l15, null);
    }

    public DashMediaSource createMediaSource(DashManifest dashManifest) {
        Object object = new MediaItem$Builder();
        Object object2 = Uri.EMPTY;
        object = ((MediaItem$Builder)object).setUri((Uri)object2).setMediaId("DashMediaSource").setMimeType("application/dash+xml");
        object2 = this.streamKeys;
        object = ((MediaItem$Builder)object).setStreamKeys((List)object2);
        object2 = this.tag;
        object = ((MediaItem$Builder)object).setTag(object2).build();
        return this.createMediaSource(dashManifest, (MediaItem)object);
    }

    public DashMediaSource createMediaSource(DashManifest dashManifest, MediaItem mediaItem) {
        long l10;
        boolean bl2;
        Object object;
        boolean bl3;
        DashMediaSource$Factory dashMediaSource$Factory = this;
        Object object2 = dashManifest;
        Object object3 = mediaItem;
        boolean bl4 = dashManifest.dynamic;
        boolean bl5 = true;
        Assertions.checkArgument(bl4 ^= bl5);
        Object object4 = mediaItem.playbackProperties;
        object4 = object4 != null && !(bl4 = (object4 = ((MediaItem$PlaybackProperties)object4).streamKeys).isEmpty()) ? mediaItem.playbackProperties.streamKeys : dashMediaSource$Factory.streamKeys;
        boolean bl6 = object4.isEmpty();
        if (!bl6) {
            object2 = ((DashManifest)object2).copy((List)object4);
        }
        DashManifest dashManifest2 = object2;
        object2 = ((MediaItem)object3).playbackProperties;
        bl6 = false;
        Object object5 = null;
        if (object2 != null) {
            bl3 = bl5;
        } else {
            bl3 = false;
            object = null;
        }
        if (bl3 && (object2 = ((MediaItem$PlaybackProperties)object2).tag) != null) {
            bl2 = bl5;
        } else {
            bl2 = false;
            object2 = null;
        }
        Object object6 = ((MediaItem)object3).liveConfiguration;
        long l11 = ((MediaItem$LiveConfiguration)object6).targetOffsetMs;
        long l12 = -9223372036854775807L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false) {
            bl5 = false;
        }
        object5 = mediaItem.buildUpon();
        object6 = "application/dash+xml";
        object5 = ((MediaItem$Builder)object5).setMimeType((String)object6);
        object = bl3 ? object3.playbackProperties.uri : Uri.EMPTY;
        object5 = ((MediaItem$Builder)object5).setUri((Uri)object);
        object2 = bl2 ? object3.playbackProperties.tag : dashMediaSource$Factory.tag;
        object2 = ((MediaItem$Builder)object5).setTag(object2);
        if (bl5) {
            object3 = ((MediaItem)object3).liveConfiguration;
            l10 = ((MediaItem$LiveConfiguration)object3).targetOffsetMs;
        } else {
            l10 = dashMediaSource$Factory.targetLiveOffsetOverrideMs;
        }
        object = ((MediaItem$Builder)object2).setLiveTargetOffsetMs(l10).setStreamKeys((List)object4).build();
        DashChunkSource$Factory dashChunkSource$Factory = dashMediaSource$Factory.chunkSourceFactory;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = dashMediaSource$Factory.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = dashMediaSource$Factory.drmSessionManagerProvider.get((MediaItem)object);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = dashMediaSource$Factory.loadErrorHandlingPolicy;
        long l14 = dashMediaSource$Factory.fallbackTargetLiveOffsetMs;
        object5 = object2;
        object2 = new DashMediaSource((MediaItem)object, dashManifest2, null, null, dashChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l14, null);
        return object2;
    }

    public int[] getSupportedTypes() {
        int[] nArray = new int[]{0};
        return nArray;
    }

    public DashMediaSource$Factory setCompositeSequenceableLoaderFactory(CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory) {
        if (compositeSequenceableLoaderFactory == null) {
            compositeSequenceableLoaderFactory = new DefaultCompositeSequenceableLoaderFactory();
        }
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        return this;
    }

    public DashMediaSource$Factory setDrmHttpDataSourceFactory(HttpDataSource$Factory httpDataSource$Factory) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmHttpDataSourceFactory(httpDataSource$Factory);
        }
        return this;
    }

    public DashMediaSource$Factory setDrmSessionManager(DrmSessionManager drmSessionManager) {
        if (drmSessionManager == null) {
            drmSessionManager = null;
            this.setDrmSessionManagerProvider(null);
        } else {
            b b10 = new b(drmSessionManager);
            this.setDrmSessionManagerProvider(b10);
        }
        return this;
    }

    public DashMediaSource$Factory setDrmSessionManagerProvider(DrmSessionManagerProvider drmSessionManagerProvider) {
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

    public DashMediaSource$Factory setDrmUserAgent(String string2) {
        boolean bl2 = this.usingCustomDrmSessionManagerProvider;
        if (!bl2) {
            DefaultDrmSessionManagerProvider defaultDrmSessionManagerProvider = (DefaultDrmSessionManagerProvider)this.drmSessionManagerProvider;
            defaultDrmSessionManagerProvider.setDrmUserAgent(string2);
        }
        return this;
    }

    public DashMediaSource$Factory setFallbackTargetLiveOffsetMs(long l10) {
        this.fallbackTargetLiveOffsetMs = l10;
        return this;
    }

    public DashMediaSource$Factory setLivePresentationDelayMs(long l10, boolean bl2) {
        long l11 = bl2 ? l10 : -9223372036854775807L;
        this.targetLiveOffsetOverrideMs = l11;
        if (!bl2) {
            this.setFallbackTargetLiveOffsetMs(l10);
        }
        return this;
    }

    public DashMediaSource$Factory setLoadErrorHandlingPolicy(LoadErrorHandlingPolicy loadErrorHandlingPolicy) {
        if (loadErrorHandlingPolicy == null) {
            loadErrorHandlingPolicy = new DefaultLoadErrorHandlingPolicy();
        }
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        return this;
    }

    public DashMediaSource$Factory setManifestParser(ParsingLoadable$Parser parsingLoadable$Parser) {
        this.manifestParser = parsingLoadable$Parser;
        return this;
    }

    public DashMediaSource$Factory setStreamKeys(List list) {
        if (list == null) {
            list = Collections.emptyList();
        }
        this.streamKeys = list;
        return this;
    }

    public DashMediaSource$Factory setTag(Object object) {
        this.tag = object;
        return this;
    }
}

