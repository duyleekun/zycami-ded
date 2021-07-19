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
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaSourceEventListener$EventDispatcher;
import com.google.android.exoplayer2.source.hls.playlist.DefaultHlsPlaylistTracker;
import com.google.android.exoplayer2.source.hls.playlist.HlsMasterPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$Part;
import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist$ServerControl;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylist;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistParser$DeltaUpdateException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistResetException;
import com.google.android.exoplayer2.source.hls.playlist.HlsPlaylistTracker$PlaylistStuckException;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.HttpDataSource$InvalidResponseCodeException;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.Loader$Loadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.util.Util;
import com.google.common.collect.Iterables;
import d.h.a.a.m0.o.g.a;
import java.io.IOException;
import java.util.Map;

public final class DefaultHlsPlaylistTracker$MediaPlaylistBundle
implements Loader$Callback {
    private static final String BLOCK_MSN_PARAM = "_HLS_msn";
    private static final String BLOCK_PART_PARAM = "_HLS_part";
    private static final String SKIP_PARAM = "_HLS_skip";
    private long earliestNextLoadTimeMs;
    private long excludeUntilMs;
    private long lastSnapshotChangeMs;
    private long lastSnapshotLoadMs;
    private boolean loadPending;
    private final DataSource mediaPlaylistDataSource;
    private final Loader mediaPlaylistLoader;
    private IOException playlistError;
    private HlsMediaPlaylist playlistSnapshot;
    private final Uri playlistUrl;
    public final /* synthetic */ DefaultHlsPlaylistTracker this$0;

    public DefaultHlsPlaylistTracker$MediaPlaylistBundle(DefaultHlsPlaylistTracker object, Uri object2) {
        this.this$0 = object;
        this.playlistUrl = object2;
        super("DefaultHlsPlaylistTracker:MediaPlaylist");
        this.mediaPlaylistLoader = object2;
        this.mediaPlaylistDataSource = object = DefaultHlsPlaylistTracker.access$400((DefaultHlsPlaylistTracker)object).createDataSource(4);
    }

    private /* synthetic */ void a(Uri uri) {
        this.loadPending = false;
        this.loadPlaylistImmediately(uri);
    }

    public static /* synthetic */ void access$000(DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle, HlsMediaPlaylist hlsMediaPlaylist, LoadEventInfo loadEventInfo) {
        defaultHlsPlaylistTracker$MediaPlaylistBundle.processLoadedPlaylist(hlsMediaPlaylist, loadEventInfo);
    }

    public static /* synthetic */ long access$100(DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle) {
        return defaultHlsPlaylistTracker$MediaPlaylistBundle.excludeUntilMs;
    }

    public static /* synthetic */ Uri access$200(DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle) {
        return defaultHlsPlaylistTracker$MediaPlaylistBundle.playlistUrl;
    }

    public static /* synthetic */ void access$300(DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle, Uri uri) {
        defaultHlsPlaylistTracker$MediaPlaylistBundle.loadPlaylistInternal(uri);
    }

    private boolean excludePlaylist(long l10) {
        long l11;
        this.excludeUntilMs = l11 = SystemClock.elapsedRealtime() + l10;
        Object object = this.playlistUrl;
        Uri uri = DefaultHlsPlaylistTracker.access$1400(this.this$0);
        boolean bl2 = object.equals((Object)uri);
        if (bl2 && !(bl2 = DefaultHlsPlaylistTracker.access$1500((DefaultHlsPlaylistTracker)(object = this.this$0)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    private Uri getMediaPlaylistUriForReload() {
        Object object = this.playlistSnapshot;
        if (object != null) {
            boolean bl2;
            object = ((HlsMediaPlaylist)object).serverControl;
            long l10 = ((HlsMediaPlaylist$ServerControl)object).skipUntilUs;
            long l11 = -9223372036854775807L;
            long l12 = l10 - l11;
            Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != false || (bl2 = ((HlsMediaPlaylist$ServerControl)object).canBlockReload)) {
                long l13;
                object = this.playlistUrl.buildUpon();
                Object object3 = this.playlistSnapshot;
                Object object4 = ((HlsMediaPlaylist)object3).serverControl;
                Object object5 = ((HlsMediaPlaylist$ServerControl)object4).canBlockReload;
                if (object5 != 0) {
                    l13 = ((HlsMediaPlaylist)object3).mediaSequence;
                    object2 = ((HlsMediaPlaylist)object3).segments.size();
                    l10 = object2;
                    object3 = String.valueOf(l13 + l10);
                    object4 = BLOCK_MSN_PARAM;
                    object.appendQueryParameter((String)object4, (String)object3);
                    object3 = this.playlistSnapshot;
                    l13 = ((HlsMediaPlaylist)object3).partTargetDurationUs;
                    object5 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1);
                    if (object5 != 0) {
                        object3 = ((HlsMediaPlaylist)object3).trailingParts;
                        object5 = object3.size();
                        boolean bl3 = object3.isEmpty();
                        if (!bl3) {
                            object3 = (HlsMediaPlaylist$Part)Iterables.getLast((Iterable)object3);
                            object2 = ((HlsMediaPlaylist$Part)object3).isPreload;
                            if (object2 != false) {
                                object5 += -1;
                            }
                        }
                        object3 = String.valueOf(object5);
                        object4 = BLOCK_PART_PARAM;
                        object.appendQueryParameter((String)object4, (String)object3);
                    }
                }
                object3 = this.playlistSnapshot.serverControl;
                l13 = ((HlsMediaPlaylist$ServerControl)object3).skipUntilUs;
                long l14 = l13 - l11;
                object5 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (object5 != 0) {
                    object2 = ((HlsMediaPlaylist$ServerControl)object3).canSkipDateRanges;
                    object3 = object2 != false ? "v2" : "YES";
                    object4 = SKIP_PARAM;
                    object.appendQueryParameter((String)object4, (String)object3);
                }
                return object.build();
            }
        }
        return this.playlistUrl;
    }

    private void loadPlaylistImmediately(Uri object) {
        Object object2 = DefaultHlsPlaylistTracker.access$1000(this.this$0);
        Object object3 = DefaultHlsPlaylistTracker.access$900(this.this$0);
        Object object4 = this.playlistSnapshot;
        object2 = object2.createPlaylistParser((HlsMasterPlaylist)object3, (HlsMediaPlaylist)object4);
        object4 = this.mediaPlaylistDataSource;
        object3 = new ParsingLoadable((DataSource)object4, (Uri)object, 4, (ParsingLoadable$Parser)object2);
        object = this.mediaPlaylistLoader;
        object2 = DefaultHlsPlaylistTracker.access$600(this.this$0);
        int n10 = ((ParsingLoadable)object3).type;
        int n11 = object2.getMinimumLoadableRetryCount(n10);
        long l10 = ((Loader)object).startLoading((Loader$Loadable)object3, this, n11);
        object = DefaultHlsPlaylistTracker.access$500(this.this$0);
        long l11 = ((ParsingLoadable)object3).loadTaskId;
        DataSpec dataSpec = ((ParsingLoadable)object3).dataSpec;
        object4 = object2;
        object2 = new LoadEventInfo(l11, dataSpec, l10);
        int n12 = ((ParsingLoadable)object3).type;
        ((MediaSourceEventListener$EventDispatcher)object).loadStarted((LoadEventInfo)object2, n12);
    }

    private void loadPlaylistInternal(Uri uri) {
        Loader loader;
        long l10;
        this.excludeUntilMs = l10 = 0L;
        boolean bl2 = this.loadPending;
        if (!(bl2 || (bl2 = (loader = this.mediaPlaylistLoader).isLoading()) || (bl2 = (loader = this.mediaPlaylistLoader).hasFatalError()))) {
            long l11;
            l10 = SystemClock.elapsedRealtime();
            long l12 = l10 - (l11 = this.earliestNextLoadTimeMs);
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object < 0) {
                object = 1;
                this.loadPending = object;
                Handler handler = DefaultHlsPlaylistTracker.access$800(this.this$0);
                a a10 = new a(this, uri);
                long l13 = this.earliestNextLoadTimeMs - l10;
                handler.postDelayed((Runnable)a10, l13);
            } else {
                this.loadPlaylistImmediately(uri);
            }
        }
    }

    private void processLoadedPlaylist(HlsMediaPlaylist object, LoadEventInfo object2) {
        long l10;
        Object object3;
        int n10;
        double d10;
        long l11;
        int n11;
        long l12;
        HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
        this.lastSnapshotLoadMs = l12 = SystemClock.elapsedRealtime();
        Object object4 = DefaultHlsPlaylistTracker.access$1100(this.this$0, hlsMediaPlaylist, (HlsMediaPlaylist)object);
        this.playlistSnapshot = object4;
        int n12 = 1;
        long l13 = -9223372036854775807L;
        if (object4 != hlsMediaPlaylist) {
            n11 = 0;
            this.playlistError = null;
            this.lastSnapshotChangeMs = l12;
            object = this.this$0;
            object2 = this.playlistUrl;
            DefaultHlsPlaylistTracker.access$1200((DefaultHlsPlaylistTracker)object, (Uri)object2, (HlsMediaPlaylist)object4);
        } else {
            Object object5 = ((HlsMediaPlaylist)object4).hasEndTag;
            if (object5 == 0) {
                l11 = ((HlsMediaPlaylist)object).mediaSequence;
                n11 = ((HlsMediaPlaylist)object).segments.size();
                long l14 = n11;
                l11 += l14;
                object = this.playlistSnapshot;
                l14 = ((HlsMediaPlaylist)object).mediaSequence;
                long l15 = l11 - l14;
                object5 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                if (object5 < 0) {
                    object2 = this.playlistUrl;
                    this.playlistError = object = new HlsPlaylistTracker$PlaylistResetException((Uri)object2);
                    object = this.this$0;
                    object2 = this.playlistUrl;
                    DefaultHlsPlaylistTracker.access$700((DefaultHlsPlaylistTracker)object, (Uri)object2, l13);
                } else {
                    l11 = this.lastSnapshotChangeMs;
                    l11 = l12 - l11;
                    d10 = l11;
                    l14 = C.usToMs(((HlsMediaPlaylist)object).targetDurationUs);
                    double d11 = l14;
                    object = this.this$0;
                    double d12 = DefaultHlsPlaylistTracker.access$1300((DefaultHlsPlaylistTracker)object);
                    double d13 = d10 - (d11 *= d12);
                    n11 = (int)(d13 == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1));
                    if (n11 > 0) {
                        object4 = this.playlistUrl;
                        this.playlistError = object = new HlsPlaylistTracker$PlaylistStuckException((Uri)object4);
                        n10 = 4;
                        object4 = new MediaLoadData(n10);
                        object3 = this.playlistError;
                        object = new LoadErrorHandlingPolicy$LoadErrorInfo((LoadEventInfo)object2, (MediaLoadData)object4, (IOException)object3, n12);
                        object2 = DefaultHlsPlaylistTracker.access$600(this.this$0);
                        l10 = object2.getBlacklistDurationMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object);
                        object4 = this.this$0;
                        object3 = this.playlistUrl;
                        DefaultHlsPlaylistTracker.access$700((DefaultHlsPlaylistTracker)object4, (Uri)object3, l10);
                        object5 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
                        if (object5 != 0) {
                            this.excludePlaylist(l10);
                        }
                    }
                }
            }
        }
        l10 = 0L;
        object4 = this.playlistSnapshot;
        object3 = ((HlsMediaPlaylist)object4).serverControl;
        n10 = ((HlsMediaPlaylist$ServerControl)object3).canBlockReload;
        if (n10 == 0) {
            if (object4 != hlsMediaPlaylist) {
                l10 = ((HlsMediaPlaylist)object4).targetDurationUs;
            } else {
                l10 = ((HlsMediaPlaylist)object4).targetDurationUs;
                l11 = 2;
                d10 = 1.0E-323;
                l10 /= l11;
            }
        }
        l10 = C.usToMs(l10);
        this.earliestNextLoadTimeMs = l12 += l10;
        object = this.playlistSnapshot;
        l10 = ((HlsMediaPlaylist)object).partTargetDurationUs;
        long l16 = l10 - l13;
        n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
        if (n11 == 0 && (n11 = (int)((object = this.playlistUrl).equals(object2 = DefaultHlsPlaylistTracker.access$1400(this.this$0)) ? 1 : 0)) == 0) {
            n12 = 0;
        }
        if (n12 != 0) {
            object = this.playlistSnapshot;
            n11 = (int)(((HlsMediaPlaylist)object).hasEndTag ? 1 : 0);
            if (n11 == 0) {
                object = this.getMediaPlaylistUriForReload();
                this.loadPlaylistInternal((Uri)object);
            }
        }
    }

    public /* synthetic */ void b(Uri uri) {
        this.a(uri);
    }

    public HlsMediaPlaylist getPlaylistSnapshot() {
        return this.playlistSnapshot;
    }

    public boolean isSnapshotValid() {
        long l10;
        long l11;
        int n10;
        HlsMediaPlaylist hlsMediaPlaylist = this.playlistSnapshot;
        int n11 = 0;
        if (hlsMediaPlaylist == null) {
            return false;
        }
        long l12 = SystemClock.elapsedRealtime();
        long l13 = C.usToMs(this.playlistSnapshot.durationUs);
        long l14 = Math.max(30000L, l13);
        hlsMediaPlaylist = this.playlistSnapshot;
        int n12 = hlsMediaPlaylist.hasEndTag;
        int n13 = 1;
        if (n12 != 0 || (n10 = hlsMediaPlaylist.playlistType) == (n12 = 2) || n10 == n13 || (n10 = (int)((l11 = (l10 = this.lastSnapshotLoadMs + l14) - l12) == 0L ? 0 : (l11 < 0L ? -1 : 1))) > 0) {
            n11 = n13;
        }
        return n11 != 0;
    }

    public void loadPlaylist() {
        Uri uri = this.playlistUrl;
        this.loadPlaylistInternal(uri);
    }

    public void maybeThrowPlaylistRefreshError() {
        this.mediaPlaylistLoader.maybeThrowError();
        IOException iOException = this.playlistError;
        if (iOException == null) {
            return;
        }
        throw iOException;
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
        object = DefaultHlsPlaylistTracker.access$600(this.this$0);
        l12 = parsingLoadable.loadTaskId;
        object.onLoadTaskConcluded(l12);
        DefaultHlsPlaylistTracker.access$500(this.this$0).loadCanceled(loadEventInfo, 4);
    }

    public void onLoadCompleted(ParsingLoadable parsingLoadable, long l10, long l11) {
        LoadEventInfo loadEventInfo;
        DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle = this;
        ParsingLoadable parsingLoadable2 = parsingLoadable;
        Object object = (HlsPlaylist)parsingLoadable.getResult();
        long l12 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l13 = parsingLoadable.bytesLoaded();
        Object object2 = loadEventInfo;
        loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        boolean bl2 = object instanceof HlsMediaPlaylist;
        int n10 = 4;
        if (bl2) {
            object = (HlsMediaPlaylist)object;
            this.processLoadedPlaylist((HlsMediaPlaylist)object, loadEventInfo);
            object = DefaultHlsPlaylistTracker.access$500(this.this$0);
            ((MediaSourceEventListener$EventDispatcher)object).loadCompleted(loadEventInfo, n10);
        } else {
            this.playlistError = object = new ParserException("Loaded playlist has unexpected type.");
            object = DefaultHlsPlaylistTracker.access$500(this.this$0);
            object2 = this.playlistError;
            boolean bl3 = true;
            ((MediaSourceEventListener$EventDispatcher)object).loadError(loadEventInfo, n10, (IOException)object2, bl3);
        }
        object = DefaultHlsPlaylistTracker.access$600(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0);
        long l14 = parsingLoadable2.loadTaskId;
        object.onLoadTaskConcluded(l14);
    }

    public Loader$LoadErrorAction onLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException, int n10) {
        long l12;
        int n11;
        Object object;
        LoadEventInfo loadEventInfo;
        Object object2;
        ParsingLoadable parsingLoadable2;
        DefaultHlsPlaylistTracker$MediaPlaylistBundle defaultHlsPlaylistTracker$MediaPlaylistBundle;
        block13: {
            long l13;
            long l14;
            int n12;
            int n13;
            Object object3;
            boolean bl2;
            long l15;
            Object object4;
            long l16;
            block12: {
                defaultHlsPlaylistTracker$MediaPlaylistBundle = this;
                parsingLoadable2 = parsingLoadable;
                object2 = iOException;
                l16 = parsingLoadable.loadTaskId;
                object4 = parsingLoadable.dataSpec;
                Uri uri = parsingLoadable.getUri();
                Map map = parsingLoadable.getResponseHeaders();
                long l17 = parsingLoadable.bytesLoaded();
                object = loadEventInfo;
                l15 = l10;
                loadEventInfo = new LoadEventInfo(l16, (DataSpec)object4, uri, map, l10, l11, l17);
                object = parsingLoadable.getUri().getQueryParameter(BLOCK_MSN_PARAM);
                bl2 = false;
                n11 = 1;
                if (object != null) {
                    object3 = n11;
                } else {
                    object3 = 0;
                    object = null;
                }
                n13 = object2 instanceof HlsPlaylistParser$DeltaUpdateException;
                if (object3 == 0 && n13 == 0) break block12;
                object3 = -1 >>> 1;
                n12 = object2 instanceof HttpDataSource$InvalidResponseCodeException;
                if (n12 != 0) {
                    object = object2;
                    object = (HttpDataSource$InvalidResponseCodeException)object2;
                    object3 = ((HttpDataSource$InvalidResponseCodeException)object).responseCode;
                }
                if (n13 != 0 || object3 == (n13 = 400) || object3 == (n13 = 503)) break block13;
            }
            n13 = parsingLoadable2.type;
            object = new MediaLoadData(n13);
            n12 = n10;
            object4 = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object, (IOException)object2, n10);
            object = DefaultHlsPlaylistTracker.access$600(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0);
            long l18 = object.getBlacklistDurationMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object4);
            long l19 = l18 - (l15 = -9223372036854775807L);
            object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
            if (object3 != 0) {
                object3 = n11;
            } else {
                object3 = 0;
                object = null;
            }
            DefaultHlsPlaylistTracker defaultHlsPlaylistTracker = defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0;
            Uri uri = defaultHlsPlaylistTracker$MediaPlaylistBundle.playlistUrl;
            int n14 = DefaultHlsPlaylistTracker.access$700(defaultHlsPlaylistTracker, uri, l18);
            if (n14 == 0 && object3 != 0) {
                n14 = 0;
                defaultHlsPlaylistTracker = null;
            } else {
                n14 = n11;
            }
            if (object3 != 0) {
                object3 = defaultHlsPlaylistTracker$MediaPlaylistBundle.excludePlaylist(l18);
                n14 |= object3;
            }
            object = n14 != 0 ? ((object3 = (l14 = (l13 = (object = DefaultHlsPlaylistTracker.access$600(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0)).getRetryDelayMsFor((LoadErrorHandlingPolicy$LoadErrorInfo)object4)) - l15) == 0L ? 0 : (l14 < 0L ? -1 : 1)) != 0 ? Loader.createRetryAction(false, l13) : Loader.DONT_RETRY_FATAL) : Loader.DONT_RETRY;
            bl2 = ((Loader$LoadErrorAction)object).isRetry() ^ n11;
            MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = DefaultHlsPlaylistTracker.access$500(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0);
            n13 = parsingLoadable2.type;
            mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, n13, (IOException)object2, bl2);
            if (bl2) {
                object2 = DefaultHlsPlaylistTracker.access$600(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0);
                l16 = parsingLoadable2.loadTaskId;
                object2.onLoadTaskConcluded(l16);
            }
            return object;
        }
        defaultHlsPlaylistTracker$MediaPlaylistBundle.earliestNextLoadTimeMs = l12 = SystemClock.elapsedRealtime();
        this.loadPlaylist();
        object = (MediaSourceEventListener$EventDispatcher)Util.castNonNull(DefaultHlsPlaylistTracker.access$500(defaultHlsPlaylistTracker$MediaPlaylistBundle.this$0));
        int n15 = parsingLoadable2.type;
        ((MediaSourceEventListener$EventDispatcher)object).loadError(loadEventInfo, n15, (IOException)object2, n11 != 0);
        return Loader.DONT_RETRY;
    }

    public void release() {
        this.mediaPlaylistLoader.release();
    }
}

