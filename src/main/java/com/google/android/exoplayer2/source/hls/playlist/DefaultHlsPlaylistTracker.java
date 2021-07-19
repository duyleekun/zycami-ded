/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.SystemClock
 */
package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.hls.HlsDataSourceFactory;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker$MediaPlaylistBundle;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist$Variant;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$RenditionReport;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Segment;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParserFactory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$Factory;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistEventListener;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PrimaryPlaylistListener;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.m0.o.g.b;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class DefaultHlsPlaylistTracker
implements HlsPlaylistTracker,
Loader$Callback {
    public static final double DEFAULT_PLAYLIST_STUCK_TARGET_DURATION_COEFFICIENT = 3.5;
    public static final HlsPlaylistTracker$Factory FACTORY = b.a;
    private final HlsDataSourceFactory dataSourceFactory;
    private MediaSourceEventListener$EventDispatcher eventDispatcher;
    private Loader initialPlaylistLoader;
    private long initialStartTimeUs;
    private boolean isLive;
    private final List listeners;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private HlsMasterPlaylist masterPlaylist;
    private final HashMap playlistBundles;
    private final HlsPlaylistParserFactory playlistParserFactory;
    private Handler playlistRefreshHandler;
    private final double playlistStuckTargetDurationCoefficient;
    private HlsMediaPlaylist primaryMediaPlaylistSnapshot;
    private Uri primaryMediaPlaylistUrl;
    private HlsPlaylistTracker$PrimaryPlaylistListener primaryPlaylistListener;

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory hlsDataSourceFactory, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory) {
        this(hlsDataSourceFactory, loadErrorHandlingPolicy, hlsPlaylistParserFactory, 3.5);
    }

    public DefaultHlsPlaylistTracker(HlsDataSourceFactory cloneable, LoadErrorHandlingPolicy loadErrorHandlingPolicy, HlsPlaylistParserFactory hlsPlaylistParserFactory, double d10) {
        this.dataSourceFactory = cloneable;
        this.playlistParserFactory = hlsPlaylistParserFactory;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.playlistStuckTargetDurationCoefficient = d10;
        this.listeners = cloneable = new Cloneable();
        this.playlistBundles = cloneable;
        this.initialStartTimeUs = -9223372036854775807L;
    }

    public static /* synthetic */ HlsPlaylistParserFactory access$1000(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.playlistParserFactory;
    }

    public static /* synthetic */ HlsMediaPlaylist access$1100(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        return defaultHlsPlaylistTracker.getLatestPlaylistSnapshot(hlsMediaPlaylist, hlsMediaPlaylist2);
    }

    public static /* synthetic */ void access$1200(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, Uri uri, HlsMediaPlaylist hlsMediaPlaylist) {
        defaultHlsPlaylistTracker.onPlaylistUpdated(uri, hlsMediaPlaylist);
    }

    public static /* synthetic */ double access$1300(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.playlistStuckTargetDurationCoefficient;
    }

    public static /* synthetic */ Uri access$1400(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.primaryMediaPlaylistUrl;
    }

    public static /* synthetic */ boolean access$1500(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.maybeSelectNewPrimaryUrl();
    }

    public static /* synthetic */ HlsDataSourceFactory access$400(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.dataSourceFactory;
    }

    public static /* synthetic */ MediaSourceEventListener$EventDispatcher access$500(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.eventDispatcher;
    }

    public static /* synthetic */ LoadErrorHandlingPolicy access$600(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.loadErrorHandlingPolicy;
    }

    public static /* synthetic */ boolean access$700(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker, Uri uri, long l10) {
        return defaultHlsPlaylistTracker.notifyPlaylistError(uri, l10);
    }

    public static /* synthetic */ Handler access$800(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.playlistRefreshHandler;
    }

    public static /* synthetic */ HlsMasterPlaylist access$900(DefaultHlsPlaylistTracker defaultHlsPlaylistTracker) {
        return defaultHlsPlaylistTracker.masterPlaylist;
    }

    private void createBundles(List list) {
        int n10 = list.size();
        for (int i10 = 0; i10 < n10; ++i10) {
            Uri uri = (Uri)list.get(i10);
            DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle = new DefaultHlsPlaylistTracker$MediaPlaylistBundle(this, uri);
            HashMap hashMap = this.playlistBundles;
            hashMap.put(uri, defaultHlsPlaylistTracker$MediaPlaylistBundle);
        }
    }

    private static HlsMediaPlaylist$Segment getFirstOldOverlappingSegment(HlsMediaPlaylist object, HlsMediaPlaylist hlsMediaPlaylist) {
        long l10 = hlsMediaPlaylist.mediaSequence;
        long l11 = ((HlsMediaPlaylist)object).mediaSequence;
        int n10 = (int)(l10 -= l11);
        object = ((HlsMediaPlaylist)object).segments;
        int n11 = object.size();
        object = n10 < n11 ? (HlsMediaPlaylist$Segment)object.get(n10) : null;
        return object;
    }

    private HlsMediaPlaylist getLatestPlaylistSnapshot(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        boolean bl2 = hlsMediaPlaylist2.isNewerThan(hlsMediaPlaylist);
        if (!bl2) {
            boolean bl3 = hlsMediaPlaylist2.hasEndTag;
            if (bl3) {
                hlsMediaPlaylist = hlsMediaPlaylist.copyWithEndTag();
            }
            return hlsMediaPlaylist;
        }
        long l10 = this.getLoadedPlaylistStartTimeUs(hlsMediaPlaylist, hlsMediaPlaylist2);
        int n10 = this.getLoadedPlaylistDiscontinuitySequence(hlsMediaPlaylist, hlsMediaPlaylist2);
        return hlsMediaPlaylist2.copyWith(l10, n10);
    }

    private int getLoadedPlaylistDiscontinuitySequence(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        int n10 = hlsMediaPlaylist2.hasDiscontinuitySequence;
        if (n10 != 0) {
            return hlsMediaPlaylist2.discontinuitySequence;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        if (hlsMediaPlaylist3 != null) {
            n10 = hlsMediaPlaylist3.discontinuitySequence;
        } else {
            n10 = 0;
            hlsMediaPlaylist3 = null;
        }
        if (hlsMediaPlaylist == null) {
            return n10;
        }
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment = DefaultHlsPlaylistTracker.getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (hlsMediaPlaylist$Segment != null) {
            int n11 = hlsMediaPlaylist.discontinuitySequence;
            n10 = hlsMediaPlaylist$Segment.relativeDiscontinuitySequence;
            int n12 = ((HlsMediaPlaylist$Segment)hlsMediaPlaylist2.segments.get((int)0)).relativeDiscontinuitySequence;
            return (n11 += n10) - n12;
        }
        return n10;
    }

    private long getLoadedPlaylistStartTimeUs(HlsMediaPlaylist hlsMediaPlaylist, HlsMediaPlaylist hlsMediaPlaylist2) {
        boolean bl2 = hlsMediaPlaylist2.hasProgramDateTime;
        if (bl2) {
            return hlsMediaPlaylist2.startTimeUs;
        }
        HlsMediaPlaylist hlsMediaPlaylist3 = this.primaryMediaPlaylistSnapshot;
        long l10 = hlsMediaPlaylist3 != null ? hlsMediaPlaylist3.startTimeUs : 0L;
        if (hlsMediaPlaylist == null) {
            return l10;
        }
        List list = hlsMediaPlaylist.segments;
        int n10 = list.size();
        HlsMediaPlaylist$Segment hlsMediaPlaylist$Segment = DefaultHlsPlaylistTracker.getFirstOldOverlappingSegment(hlsMediaPlaylist, hlsMediaPlaylist2);
        if (hlsMediaPlaylist$Segment != null) {
            long l11 = hlsMediaPlaylist.startTimeUs;
            l10 = hlsMediaPlaylist$Segment.relativeStartTimeUs;
            return l11 + l10;
        }
        long l12 = n10;
        long l13 = hlsMediaPlaylist2.mediaSequence;
        long l14 = hlsMediaPlaylist.mediaSequence;
        long l15 = l12 - (l13 -= l14);
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object == false) {
            return hlsMediaPlaylist.getEndTimeUs();
        }
        return l10;
    }

    private Uri getRequestUriForPrimaryChange(Uri uri) {
        Object object = this.primaryMediaPlaylistSnapshot;
        if (object != null) {
            Object object2 = ((HlsMediaPlaylist)object).serverControl;
            int n10 = ((HlsMediaPlaylist$ServerControl)object2).canBlockReload;
            if (n10 != 0 && (object = (HlsMediaPlaylist$RenditionReport)((HlsMediaPlaylist)object).renditionReports.get(uri)) != null) {
                uri = uri.buildUpon();
                long l10 = ((HlsMediaPlaylist$RenditionReport)object).lastMediaSequence;
                object2 = String.valueOf(l10);
                String string2 = "_HLS_msn";
                uri.appendQueryParameter(string2, (String)object2);
                int n11 = ((HlsMediaPlaylist$RenditionReport)object).lastPartIndex;
                n10 = -1;
                if (n11 != n10) {
                    object = String.valueOf(n11);
                    object2 = "_HLS_part";
                    uri.appendQueryParameter((String)object2, (String)object);
                }
                uri = uri.build();
            }
        }
        return uri;
    }

    private boolean isVariantUrl(Uri uri) {
        int n10;
        List list = this.masterPlaylist.variants;
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Uri uri2 = ((HlsMasterPlaylist$Variant)list.get((int)i10)).url;
            n10 = (int)(uri.equals((Object)uri2) ? 1 : 0);
            if (n10 == 0) continue;
            return true;
        }
        return false;
    }

    private boolean maybeSelectNewPrimaryUrl() {
        List list = this.masterPlaylist.variants;
        int n10 = list.size();
        long l10 = SystemClock.elapsedRealtime();
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.playlistBundles;
            Uri uri = ((HlsMasterPlaylist$Variant)list.get((int)i10)).url;
            long l11 = DefaultHlsPlaylistTracker$MediaPlaylistBundle.access$100((DefaultHlsPlaylistTracker$MediaPlaylistBundle)(object = (DefaultHlsPlaylistTracker$MediaPlaylistBundle)Assertions.checkNotNull((DefaultHlsPlaylistTracker$MediaPlaylistBundle)((HashMap)object).get(uri))));
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 <= 0) continue;
            list = DefaultHlsPlaylistTracker$MediaPlaylistBundle.access$200((DefaultHlsPlaylistTracker$MediaPlaylistBundle)object);
            this.primaryMediaPlaylistUrl = list;
            list = this.getRequestUriForPrimaryChange((Uri)list);
            DefaultHlsPlaylistTracker$MediaPlaylistBundle.access$300((DefaultHlsPlaylistTracker$MediaPlaylistBundle)object, (Uri)list);
            return true;
        }
        return false;
    }

    private void maybeSetPrimaryUrl(Uri uri) {
        Object object = this.primaryMediaPlaylistUrl;
        boolean bl2 = uri.equals(object);
        if (!(bl2 || !(bl2 = this.isVariantUrl(uri)) || (object = this.primaryMediaPlaylistSnapshot) != null && (bl2 = object.hasEndTag))) {
            this.primaryMediaPlaylistUrl = uri;
            object = (DefaultHlsPlaylistTracker$MediaPlaylistBundle)this.playlistBundles.get(uri);
            uri = this.getRequestUriForPrimaryChange(uri);
            DefaultHlsPlaylistTracker$MediaPlaylistBundle.access$300((DefaultHlsPlaylistTracker$MediaPlaylistBundle)object, uri);
        }
    }

    private boolean notifyPlaylistError(Uri uri, long l10) {
        List list = this.listeners;
        int n10 = list.size();
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            HlsPlaylistTracker$PlaylistEventListener hlsPlaylistTracker$PlaylistEventListener = (HlsPlaylistTracker$PlaylistEventListener)this.listeners.get(i10);
            boolean bl3 = hlsPlaylistTracker$PlaylistEventListener.onPlaylistError(uri, l10) ^ true;
            bl2 |= bl3;
        }
        return bl2;
    }

    private void onPlaylistUpdated(Uri object, HlsMediaPlaylist hlsMediaPlaylist) {
        Object object2 = this.primaryMediaPlaylistUrl;
        int n10 = object.equals(object2);
        if (n10 != 0) {
            object = this.primaryMediaPlaylistSnapshot;
            if (object == null) {
                long l10;
                n10 = hlsMediaPlaylist.hasEndTag ^ 1;
                this.isLive = n10;
                this.initialStartTimeUs = l10 = hlsMediaPlaylist.startTimeUs;
            }
            this.primaryMediaPlaylistSnapshot = hlsMediaPlaylist;
            object = this.primaryPlaylistListener;
            object.onPrimaryPlaylistRefreshed(hlsMediaPlaylist);
        }
        object = this.listeners;
        n10 = object.size();
        hlsMediaPlaylist = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            object2 = (HlsPlaylistTracker$PlaylistEventListener)this.listeners.get(i10);
            object2.onPlaylistChanged();
        }
    }

    public void addListener(HlsPlaylistTracker$PlaylistEventListener hlsPlaylistTracker$PlaylistEventListener) {
        Assertions.checkNotNull(hlsPlaylistTracker$PlaylistEventListener);
        this.listeners.add(hlsPlaylistTracker$PlaylistEventListener);
    }

    public long getInitialStartTimeUs() {
        return this.initialStartTimeUs;
    }

    public HlsMasterPlaylist getMasterPlaylist() {
        return this.masterPlaylist;
    }

    public HlsMediaPlaylist getPlaylistSnapshot(Uri uri, boolean bl2) {
        HlsMediaPlaylist hlsMediaPlaylist = ((DefaultHlsPlaylistTracker$MediaPlaylistBundle)this.playlistBundles.get(uri)).getPlaylistSnapshot();
        if (hlsMediaPlaylist != null && bl2) {
            this.maybeSetPrimaryUrl(uri);
        }
        return hlsMediaPlaylist;
    }

    public boolean isLive() {
        return this.isLive;
    }

    public boolean isSnapshotValid(Uri uri) {
        return ((DefaultHlsPlaylistTracker$MediaPlaylistBundle)this.playlistBundles.get(uri)).isSnapshotValid();
    }

    public void maybeThrowPlaylistRefreshError(Uri uri) {
        ((DefaultHlsPlaylistTracker$MediaPlaylistBundle)this.playlistBundles.get(uri)).maybeThrowPlaylistRefreshError();
    }

    public void maybeThrowPrimaryPlaylistRefreshError() {
        Loader loader = this.initialPlaylistLoader;
        if (loader != null) {
            loader.maybeThrowError();
        }
        if ((loader = this.primaryMediaPlaylistUrl) != null) {
            this.maybeThrowPlaylistRefreshError((Uri)loader);
        }
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
        this.eventDispatcher.loadCanceled(loadEventInfo, 4);
    }

    public void onLoadCompleted(ParsingLoadable parsingLoadable, long l10, long l11) {
        Object object;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this;
        ParsingLoadable parsingLoadable2 = parsingLoadable;
        Object object2 = (HlsPlaylist)parsingLoadable.getResult();
        boolean bl2 = object2 instanceof HlsMediaPlaylist;
        if (bl2) {
            object = HlsMasterPlaylist.createSingleVariantMasterPlaylist(((HlsPlaylist)object2).baseUri);
        } else {
            object = object2;
            object = (HlsMasterPlaylist)object2;
        }
        defaultHlsPlaylistTracker.masterPlaylist = object;
        Object object3 = ((HlsMasterPlaylist$Variant)object.variants.get((int)0)).url;
        defaultHlsPlaylistTracker.primaryMediaPlaylistUrl = object3;
        object = ((HlsMasterPlaylist)object).mediaPlaylistUrls;
        defaultHlsPlaylistTracker.createBundles((List)object);
        long l12 = parsingLoadable2.loadTaskId;
        DataSpec dataSpec = parsingLoadable2.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l13 = parsingLoadable.bytesLoaded();
        object3 = object;
        object = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        object3 = defaultHlsPlaylistTracker.playlistBundles;
        Uri uri2 = defaultHlsPlaylistTracker.primaryMediaPlaylistUrl;
        object3 = (DefaultHlsPlaylistTracker$MediaPlaylistBundle)((HashMap)object3).get(uri2);
        if (bl2) {
            object2 = (HlsMediaPlaylist)object2;
            DefaultHlsPlaylistTracker$MediaPlaylistBundle.access$000((DefaultHlsPlaylistTracker$MediaPlaylistBundle)object3, (HlsMediaPlaylist)object2, (LoadEventInfo)object);
        } else {
            ((DefaultHlsPlaylistTracker$MediaPlaylistBundle)object3).loadPlaylist();
        }
        object2 = defaultHlsPlaylistTracker.loadErrorHandlingPolicy;
        long l14 = parsingLoadable2.loadTaskId;
        object2.onLoadTaskConcluded(l14);
        defaultHlsPlaylistTracker.eventDispatcher.loadCompleted((LoadEventInfo)object, 4);
    }

    public Loader$LoadErrorAction onLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException, int n10) {
        LoadEventInfo loadEventInfo;
        DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = this;
        Object object = parsingLoadable;
        Object object2 = iOException;
        long l12 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Object object3 = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l13 = parsingLoadable.bytesLoaded();
        Object object4 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, (Uri)object3, map, l10, l11, l13);
        int n11 = parsingLoadable.type;
        object4 = new MediaLoadData(n11);
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object4, iOException, n10);
        long l14 = loadErrorHandlingPolicy.getRetryDelayMsFor(loadErrorHandlingPolicy$LoadErrorInfo);
        long l15 = -9223372036854775807L;
        long l16 = l14 == l15 ? 0 : (l14 < l15 ? -1 : 1);
        dataSpec = null;
        if (l16 == false) {
            l16 = 1;
        } else {
            l16 = 0;
            loadErrorHandlingPolicy$LoadErrorInfo = null;
        }
        object3 = defaultHlsPlaylistTracker.eventDispatcher;
        int n12 = ((ParsingLoadable)object).type;
        ((MediaSourceEventListener$EventDispatcher)object3).loadError(loadEventInfo, n12, (IOException)object2, (boolean)l16);
        if (l16 != false) {
            object2 = defaultHlsPlaylistTracker.loadErrorHandlingPolicy;
            long l17 = ((ParsingLoadable)object).loadTaskId;
            object2.onLoadTaskConcluded(l17);
        }
        object = l16 != false ? Loader.DONT_RETRY_FATAL : Loader.createRetryAction(false, l14);
        return object;
    }

    public void refreshPlaylist(Uri uri) {
        ((DefaultHlsPlaylistTracker$MediaPlaylistBundle)this.playlistBundles.get(uri)).loadPlaylist();
    }

    public void removeListener(HlsPlaylistTracker$PlaylistEventListener hlsPlaylistTracker$PlaylistEventListener) {
        this.listeners.remove(hlsPlaylistTracker$PlaylistEventListener);
    }

    public void start(Uri object, MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher, HlsPlaylistTracker$PrimaryPlaylistListener object2) {
        boolean bl2;
        Object object3 = Util.createHandlerForCurrentLooper();
        this.playlistRefreshHandler = object3;
        this.eventDispatcher = mediaSourceEventListener$EventDispatcher;
        this.primaryPlaylistListener = object2;
        object3 = this.dataSourceFactory;
        int n10 = 4;
        object3 = object3.createDataSource(n10);
        ParsingLoadable$Parser parsingLoadable$Parser = this.playlistParserFactory.createPlaylistParser();
        object2 = new ParsingLoadable((DataSource)object3, (Uri)object, n10, parsingLoadable$Parser);
        object = this.initialPlaylistLoader;
        if (object == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        Assertions.checkState(bl2);
        object = new Loader("DefaultHlsPlaylistTracker:MasterPlaylist");
        this.initialPlaylistLoader = object;
        object3 = this.loadErrorHandlingPolicy;
        n10 = ((ParsingLoadable)object2).type;
        int n11 = object3.getMinimumLoadableRetryCount(n10);
        long l10 = ((Loader)object).startLoading((Loader$Loadable)object2, this, n11);
        long l11 = ((ParsingLoadable)object2).loadTaskId;
        DataSpec dataSpec = ((ParsingLoadable)object2).dataSpec;
        object = new LoadEventInfo(l11, dataSpec, l10);
        int n12 = ((ParsingLoadable)object2).type;
        mediaSourceEventListener$EventDispatcher.loadStarted((LoadEventInfo)object, n12);
    }

    public void stop() {
        boolean bl2;
        long l10;
        this.primaryMediaPlaylistUrl = null;
        this.primaryMediaPlaylistSnapshot = null;
        this.masterPlaylist = null;
        this.initialStartTimeUs = l10 = -9223372036854775807L;
        this.initialPlaylistLoader.release();
        this.initialPlaylistLoader = null;
        Iterator iterator2 = this.playlistBundles.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle = (DefaultHlsPlaylistTracker$MediaPlaylistBundle)iterator2.next();
            defaultHlsPlaylistTracker$MediaPlaylistBundle.release();
        }
        this.playlistRefreshHandler.removeCallbacksAndMessages(null);
        this.playlistRefreshHandler = null;
        this.playlistBundles.clear();
    }
}

