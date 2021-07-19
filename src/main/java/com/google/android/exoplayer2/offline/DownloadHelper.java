/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.net.Uri
 *  android.os.Handler
 *  android.util.SparseIntArray
 */
package com.google.android.exoplayer2.offline;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.util.SparseIntArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$Builder;
import com.google.android.exoplayer2.MediaItem$DrmConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.offline.DownloadHelper$1;
import com.google.android.exoplayer2.offline.DownloadHelper$2;
import com.google.android.exoplayer2.offline.DownloadHelper$Callback;
import com.google.android.exoplayer2.offline.DownloadHelper$DownloadTrackSelection;
import com.google.android.exoplayer2.offline.DownloadHelper$DownloadTrackSelection$Factory;
import com.google.android.exoplayer2.offline.DownloadHelper$FakeBandwidthMeter;
import com.google.android.exoplayer2.offline.DownloadHelper$MediaPreparer;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.offline.DownloadRequest$Builder;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.TrackGroup;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$ParametersBuilder;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection$Factory;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector$MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector$InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import d.h.a.a.k0.a;
import d.h.a.a.k0.b;
import d.h.a.a.k0.c;
import d.h.a.a.k0.e;
import d.h.a.a.k0.f;
import d.h.a.a.k0.g;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class DownloadHelper {
    public static final DefaultTrackSelector$Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS;
    public static final DefaultTrackSelector$Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
    public static final DefaultTrackSelector$Parameters DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT;
    private DownloadHelper$Callback callback;
    private final Handler callbackHandler;
    private List[][] immutableTrackSelectionsByPeriodAndRenderer;
    private boolean isPreparedWithMedia;
    private MappingTrackSelector$MappedTrackInfo[] mappedTrackInfos;
    private DownloadHelper$MediaPreparer mediaPreparer;
    private final MediaSource mediaSource;
    private final MediaItem$PlaybackProperties playbackProperties;
    private final RendererCapabilities[] rendererCapabilities;
    private final SparseIntArray scratchSet;
    private TrackGroupArray[] trackGroupArrays;
    private List[][] trackSelectionsByPeriodAndRenderer;
    private final DefaultTrackSelector trackSelector;
    private final Timeline$Window window;

    static {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters;
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT = defaultTrackSelector$Parameters = DefaultTrackSelector$Parameters.DEFAULT_WITHOUT_CONTEXT.buildUpon().setForceHighestSupportedBitrate(true).build();
        DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_VIEWPORT = defaultTrackSelector$Parameters;
        DEFAULT_TRACK_SELECTOR_PARAMETERS = defaultTrackSelector$Parameters;
    }

    public DownloadHelper(MediaItem object, MediaSource object2, DefaultTrackSelector$Parameters object3, RendererCapabilities[] rendererCapabilitiesArray) {
        this.playbackProperties = object = (MediaItem$PlaybackProperties)Assertions.checkNotNull(((MediaItem)object).playbackProperties);
        this.mediaSource = object2;
        object2 = new DownloadHelper$DownloadTrackSelection$Factory(null);
        this.trackSelector = object = new DefaultTrackSelector((DefaultTrackSelector$Parameters)object3, (ExoTrackSelection$Factory)object2);
        this.rendererCapabilities = rendererCapabilitiesArray;
        object2 = new SparseIntArray();
        this.scratchSet = object2;
        object2 = e.a;
        object3 = new DownloadHelper$FakeBandwidthMeter(null);
        ((TrackSelector)object).init((TrackSelector$InvalidationListener)object2, (BandwidthMeter)object3);
        object = Util.createHandlerForCurrentOrMainLooper();
        this.callbackHandler = object;
        this.window = object = new Timeline$Window();
    }

    public static /* synthetic */ void a(List list) {
    }

    public static /* synthetic */ void access$200(DownloadHelper downloadHelper) {
        downloadHelper.onMediaPrepared();
    }

    public static /* synthetic */ void access$300(DownloadHelper downloadHelper, IOException iOException) {
        downloadHelper.onMediaPreparationFailed(iOException);
    }

    private void assertPreparedWithMedia() {
        Assertions.checkState(this.isPreparedWithMedia);
    }

    public static /* synthetic */ void b(Metadata metadata) {
    }

    public static /* synthetic */ void c() {
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource$Factory dataSource$Factory) {
        return DownloadHelper.createMediaSource(downloadRequest, dataSource$Factory, null);
    }

    public static MediaSource createMediaSource(DownloadRequest downloadRequest, DataSource$Factory dataSource$Factory, DrmSessionManager drmSessionManager) {
        return DownloadHelper.createMediaSourceInternal(downloadRequest.toMediaItem(), dataSource$Factory, drmSessionManager);
    }

    private static MediaSource createMediaSourceInternal(MediaItem mediaItem, DataSource$Factory dataSource$Factory, DrmSessionManager drmSessionManager) {
        ExtractorsFactory extractorsFactory = ExtractorsFactory.EMPTY;
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(dataSource$Factory, extractorsFactory);
        return defaultMediaSourceFactory.setDrmSessionManager(drmSessionManager).createMediaSource(mediaItem);
    }

    private /* synthetic */ void d(IOException iOException) {
        ((DownloadHelper$Callback)Assertions.checkNotNull(this.callback)).onPrepareError(this, iOException);
    }

    private /* synthetic */ void f() {
        ((DownloadHelper$Callback)Assertions.checkNotNull(this.callback)).onPrepared(this);
    }

    public static DownloadHelper forDash(Context object, Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory) {
        object = DownloadHelper.getDefaultTrackSelectorParameters(object);
        return DownloadHelper.forDash(uri, dataSource$Factory, renderersFactory, null, (DefaultTrackSelector$Parameters)object);
    }

    public static DownloadHelper forDash(Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        return DownloadHelper.forMediaItem(mediaItem$Builder.setUri(uri).setMimeType("application/dash+xml").build(), defaultTrackSelector$Parameters, renderersFactory, dataSource$Factory, drmSessionManager);
    }

    public static DownloadHelper forHls(Context object, Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory) {
        object = DownloadHelper.getDefaultTrackSelectorParameters(object);
        return DownloadHelper.forHls(uri, dataSource$Factory, renderersFactory, null, (DefaultTrackSelector$Parameters)object);
    }

    public static DownloadHelper forHls(Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        return DownloadHelper.forMediaItem(mediaItem$Builder.setUri(uri).setMimeType("application/x-mpegURL").build(), defaultTrackSelector$Parameters, renderersFactory, dataSource$Factory, drmSessionManager);
    }

    public static DownloadHelper forMediaItem(Context object, MediaItem mediaItem) {
        Assertions.checkArgument(DownloadHelper.isProgressive((MediaItem$PlaybackProperties)Assertions.checkNotNull(mediaItem.playbackProperties)));
        object = DownloadHelper.getDefaultTrackSelectorParameters(object);
        return DownloadHelper.forMediaItem(mediaItem, (DefaultTrackSelector$Parameters)object, null, null, null);
    }

    public static DownloadHelper forMediaItem(Context object, MediaItem mediaItem, RenderersFactory renderersFactory, DataSource$Factory dataSource$Factory) {
        object = DownloadHelper.getDefaultTrackSelectorParameters(object);
        return DownloadHelper.forMediaItem(mediaItem, (DefaultTrackSelector$Parameters)object, renderersFactory, dataSource$Factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, RenderersFactory renderersFactory, DataSource$Factory dataSource$Factory) {
        return DownloadHelper.forMediaItem(mediaItem, defaultTrackSelector$Parameters, renderersFactory, dataSource$Factory, null);
    }

    public static DownloadHelper forMediaItem(MediaItem mediaItem, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters, RenderersFactory rendererCapabilitiesArray, DataSource$Factory object, DrmSessionManager drmSessionManager) {
        DownloadHelper downloadHelper;
        boolean bl2;
        MediaItem$PlaybackProperties mediaItem$PlaybackProperties = (MediaItem$PlaybackProperties)Assertions.checkNotNull(mediaItem.playbackProperties);
        boolean bl3 = DownloadHelper.isProgressive(mediaItem$PlaybackProperties);
        if (!bl3 && object == null) {
            bl2 = false;
            downloadHelper = null;
        } else {
            bl2 = true;
        }
        Assertions.checkArgument(bl2);
        if (bl3) {
            object = null;
        } else {
            object = (DataSource$Factory)Util.castNonNull(object);
            object = DownloadHelper.createMediaSourceInternal(mediaItem, (DataSource$Factory)object, drmSessionManager);
        }
        rendererCapabilitiesArray = rendererCapabilitiesArray != null ? DownloadHelper.getRendererCapabilities((RenderersFactory)rendererCapabilitiesArray) : new RendererCapabilities[]{};
        downloadHelper = new DownloadHelper(mediaItem, (MediaSource)object, defaultTrackSelector$Parameters, rendererCapabilitiesArray);
        return downloadHelper;
    }

    public static DownloadHelper forProgressive(Context context, Uri object) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).build();
        return DownloadHelper.forMediaItem(context, (MediaItem)object);
    }

    public static DownloadHelper forProgressive(Context context, Uri object, String string2) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        object = mediaItem$Builder.setUri((Uri)object).setCustomCacheKey(string2).build();
        return DownloadHelper.forMediaItem(context, (MediaItem)object);
    }

    public static DownloadHelper forSmoothStreaming(Context object, Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory) {
        object = DownloadHelper.getDefaultTrackSelectorParameters(object);
        return DownloadHelper.forSmoothStreaming(uri, dataSource$Factory, renderersFactory, null, (DefaultTrackSelector$Parameters)object);
    }

    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory) {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT;
        return DownloadHelper.forSmoothStreaming(uri, dataSource$Factory, renderersFactory, null, defaultTrackSelector$Parameters);
    }

    public static DownloadHelper forSmoothStreaming(Uri uri, DataSource$Factory dataSource$Factory, RenderersFactory renderersFactory, DrmSessionManager drmSessionManager, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        MediaItem$Builder mediaItem$Builder = new MediaItem$Builder();
        return DownloadHelper.forMediaItem(mediaItem$Builder.setUri(uri).setMimeType("application/vnd.ms-sstr+xml").build(), defaultTrackSelector$Parameters, renderersFactory, dataSource$Factory, drmSessionManager);
    }

    public static DefaultTrackSelector$Parameters getDefaultTrackSelectorParameters(Context context) {
        return DefaultTrackSelector$Parameters.getDefaults(context).buildUpon().setForceHighestSupportedBitrate(true).build();
    }

    public static RendererCapabilities[] getRendererCapabilities(RenderersFactory rendererArray) {
        int n10;
        Handler handler = Util.createHandlerForCurrentOrMainLooper();
        Object object = new DownloadHelper$1();
        DownloadHelper$2 downloadHelper$2 = new DownloadHelper$2();
        f f10 = f.a;
        a a10 = a.a;
        Object[] objectArray = rendererArray;
        rendererArray = rendererArray.createRenderers(handler, (VideoRendererEventListener)object, downloadHelper$2, f10, a10);
        int n11 = rendererArray.length;
        objectArray = new RendererCapabilities[n11];
        handler = null;
        for (int i10 = 0; i10 < (n10 = rendererArray.length); ++i10) {
            objectArray[i10] = object = rendererArray[i10].getCapabilities();
        }
        return objectArray;
    }

    private /* synthetic */ void h(DownloadHelper$Callback downloadHelper$Callback) {
        downloadHelper$Callback.onPrepared(this);
    }

    private static boolean isProgressive(MediaItem$PlaybackProperties object) {
        int n10;
        Uri uri = ((MediaItem$PlaybackProperties)object).uri;
        object = ((MediaItem$PlaybackProperties)object).mimeType;
        int n11 = Util.inferContentTypeForUriAndMimeType(uri, (String)object);
        if (n11 == (n10 = 3)) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    private void onMediaPreparationFailed(IOException iOException) {
        Handler handler = (Handler)Assertions.checkNotNull(this.callbackHandler);
        c c10 = new c(this, iOException);
        handler.post((Runnable)c10);
    }

    private void onMediaPrepared() {
        Assertions.checkNotNull(this.mediaPreparer);
        Assertions.checkNotNull(this.mediaPreparer.mediaPeriods);
        Assertions.checkNotNull(this.mediaPreparer.timeline);
        Handler handler = this.mediaPreparer.mediaPeriods;
        int n10 = ((MediaPeriod[])handler).length;
        Object object = this.rendererCapabilities;
        int n11 = ((RendererCapabilities[])object).length;
        int n12 = 2;
        Object object2 = new int[n12];
        int n13 = 1;
        object2[n13] = n11;
        int n14 = 0;
        object2[0] = n10;
        List<Object> list = List.class;
        object2 = (List[][])Array.newInstance(list, object2);
        this.trackSelectionsByPeriodAndRenderer = (List[][])object2;
        Object object3 = new int[n12];
        object3[n13] = n11;
        object3[0] = n10;
        object2 = List.class;
        object3 = (List[][])Array.newInstance(object2, (int[])object3);
        this.immutableTrackSelectionsByPeriodAndRenderer = (List[][])object3;
        object3 = null;
        for (n12 = 0; n12 < n10; ++n12) {
            object2 = null;
            for (int i10 = 0; i10 < n11; ++i10) {
                List[] listArray = this.trackSelectionsByPeriodAndRenderer[n12];
                listArray[i10] = list = new List<Object>();
                listArray = this.immutableTrackSelectionsByPeriodAndRenderer[n12];
                listArray[i10] = list = Collections.unmodifiableList(this.trackSelectionsByPeriodAndRenderer[n12][i10]);
            }
        }
        object = new TrackGroupArray[n10];
        this.trackGroupArrays = object;
        object = new MappingTrackSelector$MappedTrackInfo[n10];
        this.mappedTrackInfos = object;
        while (n14 < n10) {
            object = this.trackGroupArrays;
            object3 = this.mediaPreparer.mediaPeriods[n14].getTrackGroups();
            object[n14] = object3;
            object = this.runTrackSelection(n14);
            object3 = this.trackSelector;
            object = object.info;
            ((MappingTrackSelector)object3).onSelectionActivated(object);
            object = this.mappedTrackInfos;
            object[n14] = object3 = (MappingTrackSelector$MappedTrackInfo)Assertions.checkNotNull(this.trackSelector.getCurrentMappedTrackInfo());
            ++n14;
        }
        this.setPreparedWithMedia();
        handler = (Handler)Assertions.checkNotNull(this.callbackHandler);
        object = new b(this);
        handler.post((Runnable)object);
    }

    private TrackSelectorResult runTrackSelection(int n10) {
        int n11;
        Object object = this.trackSelector;
        RendererCapabilities[] rendererCapabilitiesArray = this.rendererCapabilities;
        Object object2 = this.trackGroupArrays;
        object2 = object2[n10];
        List[][] listArray = this.mediaPreparer;
        listArray = listArray.timeline;
        listArray = listArray.getUidOfPeriod(n10);
        Object object3 = new MediaSource$MediaPeriodId(listArray);
        listArray = this.mediaPreparer;
        listArray = listArray.timeline;
        try {
            object = ((MappingTrackSelector)object).selectTracks(rendererCapabilitiesArray, (TrackGroupArray)object2, (MediaSource$MediaPeriodId)object3, (Timeline)listArray);
            rendererCapabilitiesArray = null;
            n11 = 0;
            object2 = null;
        }
        catch (ExoPlaybackException exoPlaybackException) {
            object = new UnsupportedOperationException(exoPlaybackException);
            throw object;
        }
        while (true) {
            block52: {
                int n12;
                block54: {
                    int n13 = ((TrackSelectorResult)object).length;
                    if (n11 >= n13) break;
                    object3 = ((TrackSelectorResult)object).selections;
                    object3 = object3[n11];
                    if (object3 == null) break block52;
                    listArray = this.trackSelectionsByPeriodAndRenderer;
                    listArray = listArray[n10];
                    listArray = listArray[n11];
                    n12 = 0;
                    while (true) {
                        block53: {
                            int n14;
                            int n15;
                            int n16 = listArray.size();
                            if (n12 >= n16) break;
                            Object object4 = listArray.get(n12);
                            object4 = (ExoTrackSelection)object4;
                            Object object5 = object4.getTrackGroup();
                            Object object6 = object3.getTrackGroup();
                            if (object5 != object6) break block53;
                            object5 = this.scratchSet;
                            object5.clear();
                            int n17 = 0;
                            object5 = null;
                            while (true) {
                                n15 = object4.length();
                                if (n17 >= n15) break;
                                object6 = this.scratchSet;
                                n14 = object4.getIndexInTrackGroup(n17);
                                object6.put(n14, 0);
                                ++n17;
                                continue;
                                break;
                            }
                            n17 = 0;
                            object5 = null;
                            while (true) {
                                n15 = object3.length();
                                if (n17 >= n15) break;
                                object6 = this.scratchSet;
                                n14 = object3.getIndexInTrackGroup(n17);
                                object6.put(n14, 0);
                                ++n17;
                                continue;
                                break;
                            }
                            object5 = this.scratchSet;
                            n17 = object5.size();
                            object5 = new int[n17];
                            n15 = 0;
                            object6 = null;
                            while (true) {
                                SparseIntArray sparseIntArray = this.scratchSet;
                                n14 = sparseIntArray.size();
                                if (n15 >= n14) break;
                                sparseIntArray = this.scratchSet;
                                n14 = sparseIntArray.keyAt(n15);
                                object5[n15] = n14;
                                ++n15;
                                continue;
                                break;
                            }
                            object4 = object4.getTrackGroup();
                            object6 = new DownloadHelper$DownloadTrackSelection((TrackGroup)object4, (int[])object5);
                            listArray.set(n12, object6);
                            n12 = 1;
                            break block54;
                        }
                        ++n12;
                    }
                    n12 = 0;
                }
                if (n12 == 0) {
                    listArray.add(object3);
                }
            }
            ++n11;
        }
        return object;
    }

    private void setPreparedWithMedia() {
        this.isPreparedWithMedia = true;
    }

    public void addAudioLanguagesToSelection(String ... stringArray) {
        Object object;
        int n10;
        this.assertPreparedWithMedia();
        for (int i10 = 0; i10 < (n10 = ((MappingTrackSelector$MappedTrackInfo[])(object = this.mappedTrackInfos)).length); ++i10) {
            object = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo = this.mappedTrackInfos[i10];
            int n11 = mappingTrackSelector$MappedTrackInfo.getRendererCount();
            Object var8_9 = null;
            for (int i11 = 0; i11 < n11; ++i11) {
                int n12;
                int n13 = mappingTrackSelector$MappedTrackInfo.getRendererType(i11);
                if (n13 == (n12 = 1)) continue;
                ((DefaultTrackSelector$ParametersBuilder)object).setRendererDisabled(i11, n12 != 0);
            }
            for (String string2 : stringArray) {
                ((DefaultTrackSelector$ParametersBuilder)object).setPreferredAudioLanguage(string2);
                DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = ((DefaultTrackSelector$ParametersBuilder)object).build();
                this.addTrackSelection(i10, defaultTrackSelector$Parameters);
            }
        }
    }

    public void addTextLanguagesToSelection(boolean bl2, String ... stringArray) {
        Object object;
        int n10;
        this.assertPreparedWithMedia();
        for (int i10 = 0; i10 < (n10 = ((MappingTrackSelector$MappedTrackInfo[])(object = this.mappedTrackInfos)).length); ++i10) {
            object = DEFAULT_TRACK_SELECTOR_PARAMETERS_WITHOUT_CONTEXT.buildUpon();
            MappingTrackSelector$MappedTrackInfo mappingTrackSelector$MappedTrackInfo = this.mappedTrackInfos[i10];
            int n11 = mappingTrackSelector$MappedTrackInfo.getRendererCount();
            Object var9_10 = null;
            for (int i11 = 0; i11 < n11; ++i11) {
                int n12;
                int n13 = mappingTrackSelector$MappedTrackInfo.getRendererType(i11);
                if (n13 == (n12 = 3)) continue;
                n13 = 1;
                ((DefaultTrackSelector$ParametersBuilder)object).setRendererDisabled(i11, n13 != 0);
            }
            ((DefaultTrackSelector$ParametersBuilder)object).setSelectUndeterminedTextLanguage(bl2);
            for (String string2 : stringArray) {
                ((DefaultTrackSelector$ParametersBuilder)object).setPreferredTextLanguage(string2);
                DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = ((DefaultTrackSelector$ParametersBuilder)object).build();
                this.addTrackSelection(i10, defaultTrackSelector$Parameters);
            }
        }
    }

    public void addTrackSelection(int n10, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        this.assertPreparedWithMedia();
        this.trackSelector.setParameters(defaultTrackSelector$Parameters);
        this.runTrackSelection(n10);
    }

    public void addTrackSelectionForSingleRenderer(int n10, int n11, DefaultTrackSelector$Parameters object, List list) {
        Object object2;
        int n12;
        int n13;
        this.assertPreparedWithMedia();
        object = ((DefaultTrackSelector$Parameters)object).buildUpon();
        int n14 = 0;
        TrackGroupArray trackGroupArray = null;
        for (n13 = 0; n13 < (n12 = ((MappingTrackSelector$MappedTrackInfo)(object2 = this.mappedTrackInfos[n10])).getRendererCount()); ++n13) {
            if (n13 != n11) {
                n12 = 1;
            } else {
                n12 = 0;
                object2 = null;
            }
            ((DefaultTrackSelector$ParametersBuilder)object).setRendererDisabled(n13, n12 != 0);
        }
        n13 = (int)(list.isEmpty() ? 1 : 0);
        if (n13 != 0) {
            DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = ((DefaultTrackSelector$ParametersBuilder)object).build();
            this.addTrackSelection(n10, defaultTrackSelector$Parameters);
        } else {
            trackGroupArray = this.mappedTrackInfos[n10].getTrackGroups(n11);
            while (n14 < (n12 = list.size())) {
                object2 = (DefaultTrackSelector$SelectionOverride)list.get(n14);
                ((DefaultTrackSelector$ParametersBuilder)object).setSelectionOverride(n11, trackGroupArray, (DefaultTrackSelector$SelectionOverride)object2);
                object2 = ((DefaultTrackSelector$ParametersBuilder)object).build();
                this.addTrackSelection(n10, (DefaultTrackSelector$Parameters)object2);
                ++n14;
            }
        }
    }

    public void clearTrackSelections(int n10) {
        Object object;
        int n11;
        this.assertPreparedWithMedia();
        for (int i10 = 0; i10 < (n11 = ((RendererCapabilities[])(object = this.rendererCapabilities)).length); ++i10) {
            object = this.trackSelectionsByPeriodAndRenderer[n10][i10];
            object.clear();
        }
    }

    public /* synthetic */ void e(IOException iOException) {
        this.d(iOException);
    }

    public /* synthetic */ void g() {
        this.f();
    }

    public DownloadRequest getDownloadRequest(String object, byte[] object2) {
        List[][] listArray = this.playbackProperties.uri;
        Object object3 = new Object((String)object, (Uri)listArray);
        object = this.playbackProperties.mimeType;
        object = ((DownloadRequest$Builder)object3).setMimeType((String)object);
        object3 = this.playbackProperties.drmConfiguration;
        object3 = object3 != null ? (Object)((MediaItem$DrmConfiguration)object3).getKeySetId() : null;
        object = ((DownloadRequest$Builder)object).setKeySetId((byte[])object3);
        object3 = this.playbackProperties.customCacheKey;
        object = ((DownloadRequest$Builder)object).setCustomCacheKey((String)object3).setData((byte[])object2);
        object2 = this.mediaSource;
        if (object2 == null) {
            return ((DownloadRequest$Builder)object).build();
        }
        this.assertPreparedWithMedia();
        object2 = new ArrayList;
        ((ArrayList)object2)();
        object3 = new Object();
        listArray = this.trackSelectionsByPeriodAndRenderer;
        int n10 = listArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            object3.clear();
            Object object4 = this.trackSelectionsByPeriodAndRenderer[i10];
            int n11 = ((List[])object4).length;
            for (int i11 = 0; i11 < n11; ++i11) {
                List list = this.trackSelectionsByPeriodAndRenderer[i10][i11];
                object3.addAll(list);
            }
            object4 = this.mediaPreparer.mediaPeriods[i10].getStreamKeys((List)object3);
            object2.addAll(object4);
        }
        return ((DownloadRequest$Builder)object).setStreamKeys((List)object2).build();
    }

    public DownloadRequest getDownloadRequest(byte[] byArray) {
        String string2 = this.playbackProperties.uri.toString();
        return this.getDownloadRequest(string2, byArray);
    }

    public Object getManifest() {
        Object object = this.mediaSource;
        Object object2 = null;
        if (object == null) {
            return null;
        }
        this.assertPreparedWithMedia();
        object = this.mediaPreparer.timeline;
        int n10 = ((Timeline)object).getWindowCount();
        if (n10 > 0) {
            object = this.mediaPreparer.timeline;
            Timeline$Window timeline$Window = this.window;
            object = ((Timeline)object).getWindow(0, timeline$Window);
            object2 = ((Timeline$Window)object).manifest;
        }
        return object2;
    }

    public MappingTrackSelector$MappedTrackInfo getMappedTrackInfo(int n10) {
        this.assertPreparedWithMedia();
        return this.mappedTrackInfos[n10];
    }

    public int getPeriodCount() {
        MediaSource mediaSource = this.mediaSource;
        if (mediaSource == null) {
            return 0;
        }
        this.assertPreparedWithMedia();
        return this.trackGroupArrays.length;
    }

    public TrackGroupArray getTrackGroups(int n10) {
        this.assertPreparedWithMedia();
        return this.trackGroupArrays[n10];
    }

    public List getTrackSelections(int n10, int n11) {
        this.assertPreparedWithMedia();
        return this.immutableTrackSelectionsByPeriodAndRenderer[n10][n11];
    }

    public /* synthetic */ void i(DownloadHelper$Callback downloadHelper$Callback) {
        this.h(downloadHelper$Callback);
    }

    public void prepare(DownloadHelper$Callback object) {
        boolean bl2;
        Object object2 = this.callback;
        if (object2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        Assertions.checkState(bl2);
        this.callback = object;
        object2 = this.mediaSource;
        if (object2 != null) {
            this.mediaPreparer = object = new DownloadHelper$MediaPreparer((MediaSource)object2, this);
        } else {
            object2 = this.callbackHandler;
            g g10 = new g(this, (DownloadHelper$Callback)object);
            object2.post((Runnable)g10);
        }
    }

    public void release() {
        DownloadHelper$MediaPreparer downloadHelper$MediaPreparer = this.mediaPreparer;
        if (downloadHelper$MediaPreparer != null) {
            downloadHelper$MediaPreparer.release();
        }
    }

    public void replaceTrackSelections(int n10, DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        this.clearTrackSelections(n10);
        this.addTrackSelection(n10, defaultTrackSelector$Parameters);
    }
}

