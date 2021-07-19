/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.source.smoothstreaming;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.drm.DrmSessionEventListener$EventDispatcher;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.source.BaseMediaSource;
import com.google.android.exoplayer2.source.CompositeSequenceableLoaderFactory;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.SinglePeriodTimeline;
import com.google.android.exoplayer2.source.smoothstreaming.SsChunkSource$Factory;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaPeriod;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource$1;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest;
import com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifest$StreamElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower$Dummy;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.p.b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public final class SsMediaSource
extends BaseMediaSource
implements Loader$Callback {
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000L;
    private static final int MINIMUM_MANIFEST_REFRESH_PERIOD_MS = 5000;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000L;
    private final SsChunkSource$Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private final DrmSessionManager drmSessionManager;
    private final long livePresentationDelayMs;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private SsManifest manifest;
    private DataSource manifestDataSource;
    private final DataSource$Factory manifestDataSourceFactory;
    private final MediaSourceEventListener$EventDispatcher manifestEventDispatcher;
    private long manifestLoadStartTimestamp;
    private Loader manifestLoader;
    private LoaderErrorThrower manifestLoaderErrorThrower;
    private final ParsingLoadable$Parser manifestParser;
    private Handler manifestRefreshHandler;
    private final Uri manifestUri;
    private final MediaItem mediaItem;
    private final ArrayList mediaPeriods;
    private TransferListener mediaTransferListener;
    private final MediaItem$PlaybackProperties playbackProperties;
    private final boolean sideloadedManifest;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.smoothstreaming");
    }

    private SsMediaSource(MediaItem arrayList, SsManifest ssManifest, DataSource$Factory dataSource$Factory, ParsingLoadable$Parser parsingLoadable$Parser, SsChunkSource$Factory ssChunkSource$Factory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10) {
        Uri uri;
        boolean bl2;
        boolean bl3 = false;
        boolean bl4 = true;
        if (ssManifest != null && (bl2 = ssManifest.isLive)) {
            bl2 = false;
            uri = null;
        } else {
            bl2 = bl4;
        }
        Assertions.checkState(bl2);
        this.mediaItem = arrayList;
        arrayList = (MediaItem$PlaybackProperties)Assertions.checkNotNull(((MediaItem)arrayList).playbackProperties);
        this.playbackProperties = arrayList;
        this.manifest = ssManifest;
        uri = ((MediaItem$PlaybackProperties)arrayList).uri;
        Uri uri2 = Uri.EMPTY;
        bl2 = uri.equals((Object)uri2);
        uri2 = null;
        arrayList = bl2 ? null : Util.fixSmoothStreamingIsmManifestUri(((MediaItem$PlaybackProperties)arrayList).uri);
        this.manifestUri = arrayList;
        this.manifestDataSourceFactory = dataSource$Factory;
        this.manifestParser = parsingLoadable$Parser;
        this.chunkSourceFactory = ssChunkSource$Factory;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.livePresentationDelayMs = l10;
        arrayList = this.createEventDispatcher(null);
        this.manifestEventDispatcher = arrayList;
        if (ssManifest != null) {
            bl3 = bl4;
        }
        this.sideloadedManifest = bl3;
        this.mediaPeriods = arrayList = new ArrayList();
    }

    public /* synthetic */ SsMediaSource(MediaItem mediaItem, SsManifest ssManifest, DataSource$Factory dataSource$Factory, ParsingLoadable$Parser parsingLoadable$Parser, SsChunkSource$Factory ssChunkSource$Factory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10, SsMediaSource$1 ssMediaSource$1) {
        this(mediaItem, ssManifest, dataSource$Factory, parsingLoadable$Parser, ssChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l10);
    }

    public static /* synthetic */ void a(SsMediaSource ssMediaSource) {
        ssMediaSource.startLoadingManifest();
    }

    private void processManifest() {
        long l10;
        long l11;
        Object object;
        int n10;
        Object object2;
        Object object3;
        boolean bl2;
        SsMediaSource ssMediaSource = this;
        Object object4 = 0;
        Object object5 = null;
        SsManifest ssManifest = null;
        for (boolean bl3 = false; bl3 < (bl2 = ((ArrayList)(object3 = ssMediaSource.mediaPeriods)).size()); bl3 += 1) {
            object3 = (SsMediaPeriod)ssMediaSource.mediaPeriods.get((int)(bl3 ? 1 : 0));
            object2 = ssMediaSource.manifest;
            ((SsMediaPeriod)object3).updateManifest((SsManifest)object2);
        }
        long l12 = Long.MIN_VALUE;
        object2 = ssMediaSource.manifest.streamElements;
        int n11 = ((SsManifest$StreamElement[])object2).length;
        long l13 = Long.MAX_VALUE;
        long l14 = l13;
        for (n10 = 0; n10 < n11; ++n10) {
            object = object2[n10];
            int n12 = ((SsManifest$StreamElement)object).chunkCount;
            if (n12 <= 0) continue;
            l11 = ((SsManifest$StreamElement)object).getStartTimeUs(0);
            l14 = Math.min(l14, l11);
            n12 = ((SsManifest$StreamElement)object).chunkCount + -1;
            l11 = ((SsManifest$StreamElement)object).getStartTimeUs(n12);
            int n13 = ((SsManifest$StreamElement)object).chunkCount + -1;
            l10 = ((SsManifest$StreamElement)object).getChunkDurationUs(n13);
            l12 = Math.max(l12, l11 += l10);
        }
        object4 = l14 == l13 ? 0 : (l14 < l13 ? -1 : 1);
        long l15 = 0L;
        l13 = -9223372036854775807L;
        if (object4 == 0) {
            object5 = ssMediaSource.manifest;
            object4 = ((SsManifest)object5).isLive;
            long l16 = object4 != 0 ? l13 : l15;
            long l17 = 0L;
            long l18 = 0L;
            long l19 = 0L;
            boolean bl4 = true;
            ssManifest = ssMediaSource.manifest;
            bl2 = ssManifest.isLive;
            object2 = ssMediaSource.mediaItem;
            boolean bl5 = bl2;
            object5 = new SinglePeriodTimeline(l16, l17, l18, l19, bl4, bl2, bl2, (Object)ssManifest, (MediaItem)object2);
        } else {
            object5 = ssMediaSource.manifest;
            n10 = (int)(((SsManifest)object5).isLive ? 1 : 0);
            if (n10 != 0) {
                long l20 = ((SsManifest)object5).dvrWindowLengthUs;
                long l21 = l20 - l13;
                object4 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                if (object4 != 0 && (object4 = l20 == l15 ? 0 : (l20 < l15 ? -1 : 1)) > 0) {
                    l15 = l12 - l20;
                    l14 = Math.max(l14, l15);
                }
                long l22 = l14;
                long l23 = l12 - l14;
                long l24 = C.msToUs(ssMediaSource.livePresentationDelayMs);
                long l25 = 5000000L;
                long l26 = (l24 = l23 - l24) - l25;
                n11 = (int)(l26 == 0L ? 0 : (l26 < 0L ? -1 : 1));
                if (n11 < 0) {
                    l24 = l23 / (long)2;
                    l24 = Math.min(l25, l24);
                }
                long l27 = -9223372036854775807L;
                boolean bl6 = true;
                boolean bl7 = true;
                boolean bl8 = true;
                ssManifest = ssMediaSource.manifest;
                object3 = ssMediaSource.mediaItem;
                object5 = new SinglePeriodTimeline(l27, l23, l22, l24, bl6, bl7, bl8, (Object)ssManifest, (MediaItem)object3);
            } else {
                l15 = ((SsManifest)object5).durationUs;
                long l28 = l15 - l13;
                object4 = l28 == 0L ? 0 : (l28 < 0L ? -1 : 1);
                l10 = object4 != 0 ? l15 : (l12 -= l14);
                l11 = l14 + l10;
                long l29 = 0L;
                boolean bl9 = true;
                ssManifest = ssMediaSource.manifest;
                object3 = ssMediaSource.mediaItem;
                object = object5;
                object5 = new SinglePeriodTimeline(l11, l10, l14, l29, bl9, false, false, (Object)ssManifest, (MediaItem)object3);
            }
        }
        ssMediaSource.refreshSourceInfo((Timeline)object5);
    }

    private void scheduleManifestRefresh() {
        SsManifest ssManifest = this.manifest;
        boolean bl2 = ssManifest.isLive;
        if (!bl2) {
            return;
        }
        long l10 = this.manifestLoadStartTimestamp + 5000L;
        long l11 = SystemClock.elapsedRealtime();
        l10 -= l11;
        l10 = Math.max(0L, l10);
        Handler handler = this.manifestRefreshHandler;
        b b10 = new b(this);
        handler.postDelayed((Runnable)b10, l10);
    }

    private void startLoadingManifest() {
        Object object = this.manifestLoader;
        boolean n10 = ((Loader)object).hasFatalError();
        if (n10) {
            return;
        }
        Object object2 = this.manifestDataSource;
        Object object3 = this.manifestUri;
        ParsingLoadable$Parser parsingLoadable$Parser = this.manifestParser;
        object = new ParsingLoadable((DataSource)object2, (Uri)object3, 4, parsingLoadable$Parser);
        object2 = this.manifestLoader;
        object3 = this.loadErrorHandlingPolicy;
        int n11 = ((ParsingLoadable)object).type;
        int n12 = object3.getMinimumLoadableRetryCount(n11);
        long l10 = ((Loader)object2).startLoading((Loader$Loadable)object, this, n12);
        object2 = this.manifestEventDispatcher;
        long l11 = ((ParsingLoadable)object).loadTaskId;
        DataSpec dataSpec = ((ParsingLoadable)object).dataSpec;
        object3 = new LoadEventInfo(l11, dataSpec, l10);
        int n13 = ((ParsingLoadable)object).type;
        ((MediaSourceEventListener$EventDispatcher)object2).loadStarted((LoadEventInfo)object3, n13);
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId object, Allocator allocator, long l10) {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.createEventDispatcher((MediaSource$MediaPeriodId)object);
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.createDrmEventDispatcher((MediaSource$MediaPeriodId)object);
        SsManifest ssManifest = this.manifest;
        SsChunkSource$Factory ssChunkSource$Factory = this.chunkSourceFactory;
        TransferListener transferListener = this.mediaTransferListener;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.compositeSequenceableLoaderFactory;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        LoaderErrorThrower loaderErrorThrower = this.manifestLoaderErrorThrower;
        object = new SsMediaPeriod(ssManifest, ssChunkSource$Factory, transferListener, compositeSequenceableLoaderFactory, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher, loaderErrorThrower, allocator);
        this.mediaPeriods.add(object);
        return object;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return this.playbackProperties.tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
        this.manifestLoaderErrorThrower.maybeThrowError();
    }

    public void onLoadCanceled(ParsingLoadable parsingLoadable, long l10, long l11, boolean bl2) {
        LoadEventInfo loadEventInfo;
        long l12 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l13 = parsingLoadable.bytesLoaded();
        Object object = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        object = this.loadErrorHandlingPolicy;
        l12 = parsingLoadable.loadTaskId;
        object.onLoadTaskConcluded(l12);
        object = this.manifestEventDispatcher;
        int n10 = parsingLoadable.type;
        ((MediaSourceEventListener$EventDispatcher)object).loadCanceled(loadEventInfo, n10);
    }

    public void onLoadCompleted(ParsingLoadable parsingLoadable, long l10, long l11) {
        long l12;
        LoadEventInfo loadEventInfo;
        Object object = parsingLoadable;
        long l13 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l14 = parsingLoadable.bytesLoaded();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l13, dataSpec, uri, map, l10, l11, l14);
        object2 = this.loadErrorHandlingPolicy;
        l13 = parsingLoadable.loadTaskId;
        object2.onLoadTaskConcluded(l13);
        object2 = this.manifestEventDispatcher;
        int n10 = parsingLoadable.type;
        ((MediaSourceEventListener$EventDispatcher)object2).loadCompleted(loadEventInfo, n10);
        this.manifest = object = (SsManifest)parsingLoadable.getResult();
        this.manifestLoadStartTimestamp = l12 = l10 - l11;
        this.processManifest();
        this.scheduleManifestRefresh();
    }

    public Loader$LoadErrorAction onLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException, int n10) {
        long l12;
        LoadEventInfo loadEventInfo;
        SsMediaSource ssMediaSource = this;
        ParsingLoadable parsingLoadable2 = parsingLoadable;
        Object object = iOException;
        long l13 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l14 = parsingLoadable.bytesLoaded();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l13, dataSpec, uri, map, l10, l11, l14);
        int bl2 = parsingLoadable.type;
        object2 = new MediaLoadData(bl2);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        int n11 = n10;
        Object object3 = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object2, iOException, n10);
        long l15 = loadErrorHandlingPolicy.getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object3);
        long l16 = l15 - (l12 = -9223372036854775807L);
        Object object4 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object4 == false) {
            object2 = Loader.DONT_RETRY_FATAL;
        } else {
            object4 = 0;
            object3 = null;
            object2 = Loader.createRetryAction(false, l15);
        }
        boolean bl3 = ((Loader$LoadErrorAction)object2).isRetry() ^ true;
        object3 = ssMediaSource.manifestEventDispatcher;
        n11 = parsingLoadable2.type;
        ((MediaSourceEventListener$EventDispatcher)object3).loadError(loadEventInfo, n11, (IOException)object, bl3);
        if (bl3) {
            object = ssMediaSource.loadErrorHandlingPolicy;
            l13 = parsingLoadable2.loadTaskId;
            object.onLoadTaskConcluded(l13);
        }
        return object2;
    }

    public void prepareSourceInternal(TransferListener object) {
        this.mediaTransferListener = object;
        object = this.drmSessionManager;
        object.prepare();
        boolean bl2 = this.sideloadedManifest;
        if (bl2) {
            this.manifestLoaderErrorThrower = object = new LoaderErrorThrower$Dummy();
            this.processManifest();
        } else {
            this.manifestDataSource = object = this.manifestDataSourceFactory.createDataSource();
            String string2 = "Loader:Manifest";
            this.manifestLoader = object = new Loader(string2);
            this.manifestLoaderErrorThrower = object;
            object = Util.createHandlerForCurrentLooper();
            this.manifestRefreshHandler = object;
            this.startLoadingManifest();
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        ((SsMediaPeriod)mediaPeriod).release();
        this.mediaPeriods.remove(mediaPeriod);
    }

    public void releaseSourceInternal() {
        long l10;
        Object object;
        boolean bl2 = this.sideloadedManifest;
        if (bl2) {
            object = this.manifest;
        } else {
            bl2 = false;
            object = null;
        }
        this.manifest = object;
        this.manifestDataSource = null;
        this.manifestLoadStartTimestamp = l10 = 0L;
        object = this.manifestLoader;
        if (object != null) {
            ((Loader)object).release();
            this.manifestLoader = null;
        }
        if ((object = this.manifestRefreshHandler) != null) {
            object.removeCallbacksAndMessages(null);
            this.manifestRefreshHandler = null;
        }
        this.drmSessionManager.release();
    }
}

