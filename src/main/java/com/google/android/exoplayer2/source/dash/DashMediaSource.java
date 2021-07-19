/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Handler
 *  android.os.SystemClock
 *  android.util.SparseArray
 */
package com.google.android.exoplayer2.source.dash;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaItem$PlaybackProperties;
import com.google.android.exoplayer2.ParserException;
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
import com.google.android.exoplayer2.source.dash.DashChunkSource$Factory;
import com.google.android.exoplayer2.source.dash.DashManifestStaleException;
import com.google.android.exoplayer2.source.dash.DashMediaPeriod;
import com.google.android.exoplayer2.source.dash.DashMediaSource$1;
import com.google.android.exoplayer2.source.dash.DashMediaSource$DashTimeline;
import com.google.android.exoplayer2.source.dash.DashMediaSource$DefaultPlayerEmsgCallback;
import com.google.android.exoplayer2.source.dash.DashMediaSource$Iso8601Parser;
import com.google.android.exoplayer2.source.dash.DashMediaSource$ManifestCallback;
import com.google.android.exoplayer2.source.dash.DashMediaSource$ManifestLoadErrorThrower;
import com.google.android.exoplayer2.source.dash.DashMediaSource$UtcTimestampCallback;
import com.google.android.exoplayer2.source.dash.DashMediaSource$XsDateTimeParser;
import com.google.android.exoplayer2.source.dash.PlayerEmsgHandler$PlayerEmsgCallback;
import com.google.android.exoplayer2.source.dash.manifest.AdaptationSet;
import com.google.android.exoplayer2.source.dash.manifest.DashManifest;
import com.google.android.exoplayer2.source.dash.manifest.Period;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import com.google.android.exoplayer2.source.dash.manifest.UtcTimingElement;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSource$Factory;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy;
import com.google.android.exoplayer2.upstream.LoadErrorHandlingPolicy$LoadErrorInfo;
import com.google.android.exoplayer2.upstream.Loader;
import com.google.android.exoplayer2.upstream.Loader$Callback;
import com.google.android.exoplayer2.upstream.Loader$LoadErrorAction;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower;
import com.google.android.exoplayer2.upstream.LoaderErrorThrower$Dummy;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.upstream.ParsingLoadable$Parser;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.SntpClient;
import com.google.android.exoplayer2.util.Util;
import com.google.common.math.LongMath;
import d.h.a.a.m0.n.a;
import d.h.a.a.m0.n.c;
import java.io.IOException;
import java.math.RoundingMode;
import java.util.List;
import java.util.Map;

public final class DashMediaSource
extends BaseMediaSource {
    public static final long DEFAULT_FALLBACK_TARGET_LIVE_OFFSET_MS = 30000L;
    public static final long DEFAULT_LIVE_PRESENTATION_DELAY_MS = 30000L;
    public static final String DEFAULT_MEDIA_ID = "DashMediaSource";
    private static final long DEFAULT_NOTIFY_MANIFEST_INTERVAL_MS = 5000L;
    private static final long MIN_LIVE_DEFAULT_START_POSITION_US = 5000000L;
    private static final String TAG = "DashMediaSource";
    private final DashChunkSource$Factory chunkSourceFactory;
    private final CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory;
    private DataSource dataSource;
    private final DrmSessionManager drmSessionManager;
    private long elapsedRealtimeOffsetMs;
    private long expiredManifestPublishTimeUs;
    private final long fallbackTargetLiveOffsetMs;
    private int firstPeriodId;
    private Handler handler;
    private Uri initialManifestUri;
    private MediaItem$LiveConfiguration liveConfiguration;
    private final LoadErrorHandlingPolicy loadErrorHandlingPolicy;
    private Loader loader;
    private DashManifest manifest;
    private final DashMediaSource$ManifestCallback manifestCallback;
    private final DataSource$Factory manifestDataSourceFactory;
    private final MediaSourceEventListener$EventDispatcher manifestEventDispatcher;
    private IOException manifestFatalError;
    private long manifestLoadEndTimestampMs;
    private final LoaderErrorThrower manifestLoadErrorThrower;
    private boolean manifestLoadPending;
    private long manifestLoadStartTimestampMs;
    private final ParsingLoadable$Parser manifestParser;
    private Uri manifestUri;
    private final Object manifestUriLock;
    private final MediaItem mediaItem;
    private TransferListener mediaTransferListener;
    private final SparseArray periodsById;
    private final PlayerEmsgHandler$PlayerEmsgCallback playerEmsgCallback;
    private final Runnable refreshManifestRunnable;
    private final boolean sideloadedManifest;
    private final Runnable simulateManifestRefreshRunnable;
    private int staleManifestReloadAttempt;

    static {
        ExoPlayerLibraryInfo.registerModule("goog.exo.dash");
    }

    private DashMediaSource(MediaItem object, DashManifest dashManifest, DataSource$Factory dataSource$Factory, ParsingLoadable$Parser parsingLoadable$Parser, DashChunkSource$Factory object2, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10) {
        long l11;
        boolean bl2;
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration;
        this.mediaItem = object;
        this.liveConfiguration = mediaItem$LiveConfiguration = ((MediaItem)object).liveConfiguration;
        mediaItem$LiveConfiguration = ((MediaItem$PlaybackProperties)Assertions.checkNotNull((Object)object.playbackProperties)).uri;
        this.manifestUri = mediaItem$LiveConfiguration;
        object = object.playbackProperties.uri;
        this.initialManifestUri = object;
        this.manifest = dashManifest;
        this.manifestDataSourceFactory = dataSource$Factory;
        this.manifestParser = parsingLoadable$Parser;
        this.chunkSourceFactory = object2;
        this.drmSessionManager = drmSessionManager;
        this.loadErrorHandlingPolicy = loadErrorHandlingPolicy;
        this.fallbackTargetLiveOffsetMs = l10;
        this.compositeSequenceableLoaderFactory = compositeSequenceableLoaderFactory;
        boolean bl3 = true;
        if (dashManifest != null) {
            bl2 = bl3;
        } else {
            bl2 = false;
            dataSource$Factory = null;
        }
        this.sideloadedManifest = bl2;
        parsingLoadable$Parser = null;
        this.manifestEventDispatcher = object2 = this.createEventDispatcher(null);
        this.manifestUriLock = object2 = new Object();
        object2 = new SparseArray();
        this.periodsById = object2;
        this.playerEmsgCallback = object2 = new DashMediaSource$DefaultPlayerEmsgCallback(this, null);
        this.expiredManifestPublishTimeUs = l11 = -9223372036854775807L;
        this.elapsedRealtimeOffsetMs = l11;
        if (bl2) {
            boolean bl4 = dashManifest.dynamic;
            Assertions.checkState(bl3 ^= bl4);
            this.manifestCallback = null;
            this.refreshManifestRunnable = null;
            this.simulateManifestRefreshRunnable = null;
            this.manifestLoadErrorThrower = object = new LoaderErrorThrower$Dummy();
        } else {
            this.manifestCallback = object = new DashMediaSource$ManifestCallback(this, null);
            this.manifestLoadErrorThrower = object = new DashMediaSource$ManifestLoadErrorThrower(this);
            this.refreshManifestRunnable = object = new a(this);
            this.simulateManifestRefreshRunnable = object = new c(this);
        }
    }

    public /* synthetic */ DashMediaSource(MediaItem mediaItem, DashManifest dashManifest, DataSource$Factory dataSource$Factory, ParsingLoadable$Parser parsingLoadable$Parser, DashChunkSource$Factory dashChunkSource$Factory, CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory, DrmSessionManager drmSessionManager, LoadErrorHandlingPolicy loadErrorHandlingPolicy, long l10, DashMediaSource$1 dashMediaSource$1) {
        this(mediaItem, dashManifest, dataSource$Factory, parsingLoadable$Parser, dashChunkSource$Factory, compositeSequenceableLoaderFactory, drmSessionManager, loadErrorHandlingPolicy, l10);
    }

    public static /* synthetic */ void a(DashMediaSource dashMediaSource) {
        dashMediaSource.startLoadingManifest();
    }

    public static /* synthetic */ void access$500(DashMediaSource dashMediaSource, long l10) {
        dashMediaSource.onUtcTimestampResolved(l10);
    }

    public static /* synthetic */ void access$600(DashMediaSource dashMediaSource, IOException iOException) {
        dashMediaSource.onUtcTimestampResolutionError(iOException);
    }

    public static /* synthetic */ Loader access$700(DashMediaSource dashMediaSource) {
        return dashMediaSource.loader;
    }

    public static /* synthetic */ IOException access$800(DashMediaSource dashMediaSource) {
        return dashMediaSource.manifestFatalError;
    }

    private /* synthetic */ void b() {
        this.processManifest(false);
    }

    private static long getAvailableEndTimeInManifestUs(Period period, long l10, long l11) {
        long l12;
        Object object;
        int n10;
        Period period2 = period;
        long l13 = l10;
        long l14 = l11;
        long l15 = C.msToUs(period.startMs);
        boolean bl2 = DashMediaSource.hasVideoOrAudioAdaptationSets(period);
        long l16 = Long.MAX_VALUE;
        for (int i10 = 0; i10 < (n10 = (object = period2.adaptationSets).size()); ++i10) {
            int n11;
            object = (AdaptationSet)period2.adaptationSets.get(i10);
            List list = ((AdaptationSet)object).representations;
            if (bl2 && (n10 = ((AdaptationSet)object).type) == (n11 = 3) || (n10 = (int)(list.isEmpty() ? 1 : 0)) != 0) continue;
            object = ((Representation)list.get(0)).getIndex();
            if (object == null) {
                return l15 + l13;
            }
            int n12 = object.getAvailableSegmentCount(l13, l14);
            if (n12 == 0) {
                return l15;
            }
            long l17 = object.getFirstAvailableSegmentNum(l13, l14);
            long l18 = n12;
            l17 = l17 + l18 - 1L;
            l18 = object.getTimeUs(l17) + l15;
            l12 = object.getDurationUs(l17, l13);
            l18 += l12;
            l12 = l16;
            l16 = l18 = Math.min(l16, l18);
        }
        l12 = l16;
        return l16;
    }

    private static long getAvailableStartTimeInManifestUs(Period period, long l10, long l11) {
        Object object;
        int n10;
        long l12 = C.msToUs(period.startMs);
        boolean bl2 = DashMediaSource.hasVideoOrAudioAdaptationSets(period);
        long l13 = l12;
        for (int i10 = 0; i10 < (n10 = (object = period.adaptationSets).size()); ++i10) {
            int n11;
            object = (AdaptationSet)period.adaptationSets.get(i10);
            List list = ((AdaptationSet)object).representations;
            if (bl2 && (n10 = ((AdaptationSet)object).type) == (n11 = 3) || (n10 = (int)(list.isEmpty() ? 1 : 0)) != 0) continue;
            object = ((Representation)list.get(0)).getIndex();
            if (object == null) {
                return l12;
            }
            int n12 = object.getAvailableSegmentCount(l10, l11);
            if (n12 == 0) {
                return l12;
            }
            long l14 = object.getFirstAvailableSegmentNum(l10, l11);
            long l15 = object.getTimeUs(l14) + l12;
            l13 = Math.max(l13, l15);
        }
        return l13;
    }

    private static long getIntervalUntilNextManifestRefreshMs(DashManifest dashManifest, long l10) {
        Object object;
        int n10;
        int n11 = dashManifest.getPeriodCount() + -1;
        Object object2 = dashManifest.getPeriod(n11);
        long l11 = C.msToUs(object2.startMs);
        long l12 = dashManifest.getPeriodDurationUs(n11);
        long l13 = C.msToUs(l10);
        long l14 = C.msToUs(dashManifest.availabilityStartTimeMs);
        long l15 = C.msToUs(5000L);
        for (int i10 = 0; i10 < (n10 = (object = object2.adaptationSets).size()); ++i10) {
            long l16;
            object = ((AdaptationSet)object2.adaptationSets.get((int)i10)).representations;
            boolean bl2 = object.isEmpty();
            if (bl2 || (object = ((Representation)object.get(0)).getIndex()) == null) continue;
            long l17 = l14 + l11;
            long l18 = object.getNextSegmentAvailableTimeUs(l12, l13);
            long l19 = l15 - (l18 = 100000L);
            long l20 = (l17 = l17 + l18 - l13) - l19;
            n10 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
            if (n10 >= 0 && ((n10 = (int)(l17 == l15 ? 0 : (l17 < l15 ? -1 : 1))) <= 0 || (n10 = (int)((l16 = l17 - (l18 = l15 + l18)) == 0L ? 0 : (l16 < 0L ? -1 : 1))) >= 0)) continue;
            l15 = l17;
        }
        object2 = RoundingMode.CEILING;
        return LongMath.divide(l15, 1000L, (RoundingMode)((Object)object2));
    }

    private long getManifestLoadRetryDelayMillis() {
        return Math.min((this.staleManifestReloadAttempt + -1) * 1000, 5000);
    }

    private static boolean hasVideoOrAudioAdaptationSets(Period period) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = period.adaptationSets).size()); ++i10) {
            int n11;
            object = (AdaptationSet)period.adaptationSets.get(i10);
            n10 = ((AdaptationSet)object).type;
            int n12 = 1;
            if (n10 != n12 && n10 != (n11 = 2)) {
                continue;
            }
            return n12 != 0;
        }
        return false;
    }

    private static boolean isIndexExplicit(Period period) {
        Object object;
        int n10;
        for (int i10 = 0; i10 < (n10 = (object = period.adaptationSets).size()); ++i10) {
            object = ((Representation)((AdaptationSet)period.adaptationSets.get((int)i10)).representations.get(0)).getIndex();
            if (object != null && (n10 = (int)(object.isExplicit() ? 1 : 0)) == 0) {
                continue;
            }
            return true;
        }
        return false;
    }

    private void loadNtpTimeOffset() {
        Loader loader = this.loader;
        DashMediaSource$1 dashMediaSource$1 = new DashMediaSource$1(this);
        SntpClient.initialize(loader, dashMediaSource$1);
    }

    private void onUtcTimestampResolutionError(IOException iOException) {
        Log.e("DashMediaSource", "Failed to resolve time offset.", iOException);
        this.processManifest(true);
    }

    private void onUtcTimestampResolved(long l10) {
        this.elapsedRealtimeOffsetMs = l10;
        this.processManifest(true);
    }

    private void processManifest(boolean bl2) {
        MediaItem$LiveConfiguration mediaItem$LiveConfiguration;
        long l10;
        long l11;
        long l12;
        Object object;
        long l13;
        Object object2;
        Object object3;
        int n10;
        Object object4;
        int n11;
        int n12;
        DashMediaSource dashMediaSource = this;
        Object object5 = 0;
        Object object6 = null;
        Object object7 = null;
        for (n12 = 0; n12 < (n11 = (object4 = dashMediaSource.periodsById).size()); ++n12) {
            object4 = dashMediaSource.periodsById;
            n11 = object4.keyAt(n12);
            if (n11 < (n10 = dashMediaSource.firstPeriodId)) continue;
            object3 = (DashMediaPeriod)dashMediaSource.periodsById.valueAt(n12);
            object2 = dashMediaSource.manifest;
            int n13 = dashMediaSource.firstPeriodId;
            ((DashMediaPeriod)object3).updateManifest((DashManifest)object2, n11 -= n13);
        }
        object7 = dashMediaSource.manifest.getPeriod(0);
        n11 = dashMediaSource.manifest.getPeriodCount();
        n10 = 1;
        object2 = dashMediaSource.manifest.getPeriod(n11 -= n10);
        DashManifest dashManifest = dashMediaSource.manifest;
        long l14 = dashManifest.getPeriodDurationUs(n11);
        long l15 = C.msToUs(Util.getNowUnixTimeMs(dashMediaSource.elapsedRealtimeOffsetMs));
        long l16 = dashMediaSource.manifest.getPeriodDurationUs(0);
        l16 = DashMediaSource.getAvailableStartTimeInManifestUs((Period)object7, l16, l15);
        l14 = DashMediaSource.getAvailableEndTimeInManifestUs((Period)object2, l14, l15);
        object4 = dashMediaSource.manifest;
        n11 = (int)(object4.dynamic ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(DashMediaSource.isIndexExplicit((Period)object2) ? 1 : 0)) == 0) {
            n11 = n10;
        } else {
            n11 = 0;
            object4 = null;
        }
        long l17 = -9223372036854775807L;
        if (n11 != 0) {
            object2 = dashMediaSource.manifest;
            l13 = ((DashManifest)object2).timeShiftBufferDepthMs;
            long l18 = l13 - l17;
            object = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
            if (object != false) {
                l13 = C.msToUs(l13);
                l13 = l14 - l13;
                l16 = Math.max(l16, l13);
            }
        }
        long l19 = l14 - l16;
        DashManifest dashManifest2 = dashMediaSource.manifest;
        boolean bl3 = dashManifest2.dynamic;
        Period period = object7;
        if (bl3) {
            l12 = dashManifest2.availabilityStartTimeMs;
            long l20 = l12 - l17;
            object5 = l20 == 0L ? 0 : (l20 < 0L ? -1 : 1);
            if (object5 != 0) {
                object5 = n10;
            } else {
                object5 = 0;
                object6 = null;
            }
            Assertions.checkState((boolean)object5);
            l12 = C.msToUs(dashMediaSource.manifest.availabilityStartTimeMs);
            l15 = l15 - l12 - l16;
            dashMediaSource.updateMediaItemLiveConfiguration(l15, l19);
            object6 = dashMediaSource.manifest;
            l12 = ((DashManifest)object6).availabilityStartTimeMs;
            l13 = C.usToMs(l16);
            l12 += l13;
            object3 = dashMediaSource.liveConfiguration;
            l13 = C.msToUs(((MediaItem$LiveConfiguration)object3).targetOffsetMs);
            l15 -= l13;
            l13 = 5000000L;
            l17 = l19 / (long)2;
            l17 = Math.min(l13, l17);
            n10 = (int)(l15 == l17 ? 0 : (l15 < l17 ? -1 : 1));
            l11 = l12;
            l10 = n10 < 0 ? l17 : l15;
            object6 = period;
        } else {
            object6 = object7;
            l11 = -9223372036854775807L;
            l10 = 0L;
        }
        l12 = C.msToUs(((Period)object6).startMs);
        long l21 = l16 - l12;
        object7 = dashMediaSource.manifest;
        long l22 = ((DashManifest)object7).availabilityStartTimeMs;
        long l23 = dashMediaSource.elapsedRealtimeOffsetMs;
        n10 = dashMediaSource.firstPeriodId;
        MediaItem mediaItem = dashMediaSource.mediaItem;
        boolean bl4 = ((DashManifest)object7).dynamic;
        if (bl4) {
            mediaItem$LiveConfiguration = dashMediaSource.liveConfiguration;
        } else {
            bl4 = false;
            mediaItem$LiveConfiguration = null;
        }
        object6 = new DashMediaSource$DashTimeline(l22, l11, l23, n10, l21, l19, l10, (DashManifest)object7, mediaItem, mediaItem$LiveConfiguration);
        dashMediaSource.refreshSourceInfo((Timeline)object6);
        object5 = dashMediaSource.sideloadedManifest;
        if (object5 == 0) {
            long l24;
            object6 = dashMediaSource.handler;
            object7 = dashMediaSource.simulateManifestRefreshRunnable;
            object6.removeCallbacks((Runnable)object7);
            if (n11 != 0) {
                object6 = dashMediaSource.handler;
                object7 = dashMediaSource.simulateManifestRefreshRunnable;
                object4 = dashMediaSource.manifest;
                long l25 = Util.getNowUnixTimeMs(dashMediaSource.elapsedRealtimeOffsetMs);
                l24 = DashMediaSource.getIntervalUntilNextManifestRefreshMs((DashManifest)object4, l25);
                object6.postDelayed((Runnable)object7, l24);
            }
            if ((object5 = (Object)dashMediaSource.manifestLoadPending) != 0) {
                this.startLoadingManifest();
            } else if (bl2) {
                long l26;
                object6 = dashMediaSource.manifest;
                n12 = (int)(((DashManifest)object6).dynamic ? 1 : 0);
                if (n12 != 0 && (n11 = (int)((l26 = (l12 = ((DashManifest)object6).minUpdatePeriodMs) - (l24 = -9223372036854775807L)) == 0L ? 0 : (l26 < 0L ? -1 : 1))) != 0) {
                    l24 = 0L;
                    long l27 = l12 - l24;
                    object = l27 == 0L ? 0 : (l27 < 0L ? -1 : 1);
                    if (object == false) {
                        l12 = 5000L;
                    }
                    l19 = dashMediaSource.manifestLoadStartTimestampMs + l12;
                    l12 = SystemClock.elapsedRealtime();
                    l19 -= l12;
                    l12 = Math.max(l24, l19);
                    dashMediaSource.scheduleManifestRefresh(l12);
                }
            }
        }
    }

    private void resolveUtcTimingElement(UtcTimingElement object) {
        Object object2 = ((UtcTimingElement)object).schemeIdUri;
        String string2 = "urn:mpeg:dash:utc:direct:2014";
        boolean bl2 = Util.areEqual(object2, string2);
        if (!bl2 && !(bl2 = Util.areEqual(object2, string2 = "urn:mpeg:dash:utc:direct:2012"))) {
            string2 = "urn:mpeg:dash:utc:http-iso:2014";
            bl2 = Util.areEqual(object2, string2);
            if (!bl2 && !(bl2 = Util.areEqual(object2, string2 = "urn:mpeg:dash:utc:http-iso:2012"))) {
                string2 = "urn:mpeg:dash:utc:http-xsdate:2014";
                bl2 = Util.areEqual(object2, string2);
                if (!bl2 && !(bl2 = Util.areEqual(object2, string2 = "urn:mpeg:dash:utc:http-xsdate:2012"))) {
                    object = "urn:mpeg:dash:utc:ntp:2014";
                    boolean bl3 = Util.areEqual(object2, object);
                    if (!bl3 && !(bl3 = Util.areEqual(object2, object = "urn:mpeg:dash:utc:ntp:2012"))) {
                        object2 = "Unsupported UTC timing scheme";
                        object = new IOException((String)object2);
                        this.onUtcTimestampResolutionError((IOException)object);
                    } else {
                        this.loadNtpTimeOffset();
                    }
                } else {
                    bl2 = false;
                    string2 = null;
                    object2 = new DashMediaSource$XsDateTimeParser(null);
                    this.resolveUtcTimingElementHttp((UtcTimingElement)object, (ParsingLoadable$Parser)object2);
                }
            } else {
                object2 = new DashMediaSource$Iso8601Parser();
                this.resolveUtcTimingElementHttp((UtcTimingElement)object, (ParsingLoadable$Parser)object2);
            }
        } else {
            this.resolveUtcTimingElementDirect((UtcTimingElement)object);
        }
    }

    private void resolveUtcTimingElementDirect(UtcTimingElement object) {
        object = ((UtcTimingElement)object).value;
        long l10 = Util.parseXsDateTime((String)object);
        long l11 = this.manifestLoadEndTimestampMs;
        l10 -= l11;
        try {
            this.onUtcTimestampResolved(l10);
        }
        catch (ParserException parserException) {
            this.onUtcTimestampResolutionError(parserException);
        }
    }

    private void resolveUtcTimingElementHttp(UtcTimingElement object, ParsingLoadable$Parser parsingLoadable$Parser) {
        DataSource dataSource = this.dataSource;
        object = Uri.parse((String)((UtcTimingElement)object).value);
        ParsingLoadable parsingLoadable = new ParsingLoadable(dataSource, (Uri)object, 5, parsingLoadable$Parser);
        object = new DashMediaSource$UtcTimestampCallback(this, null);
        this.startLoading(parsingLoadable, (Loader$Callback)object, 1);
    }

    private void scheduleManifestRefresh(long l10) {
        Handler handler = this.handler;
        Runnable runnable = this.refreshManifestRunnable;
        handler.postDelayed(runnable, l10);
    }

    private void startLoading(ParsingLoadable parsingLoadable, Loader$Callback object, int n10) {
        long l10 = this.loader.startLoading(parsingLoadable, (Loader$Callback)object, n10);
        object = this.manifestEventDispatcher;
        long l11 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        LoadEventInfo loadEventInfo = new LoadEventInfo(l11, dataSpec, l10);
        int n11 = parsingLoadable.type;
        ((MediaSourceEventListener$EventDispatcher)object).loadStarted(loadEventInfo, n11);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void startLoadingManifest() {
        Object object = this.handler;
        Object object2 = this.refreshManifestRunnable;
        object.removeCallbacks((Runnable)object2);
        object = this.loader;
        boolean bl2 = ((Loader)object).hasFatalError();
        if (bl2) {
            return;
        }
        object = this.loader;
        bl2 = ((Loader)object).isLoading();
        if (bl2) {
            this.manifestLoadPending = true;
            return;
        }
        object = this.manifestUriLock;
        synchronized (object) {
            object2 = this.manifestUri;
        }
        this.manifestLoadPending = false;
        DataSource dataSource = this.dataSource;
        ParsingLoadable$Parser parsingLoadable$Parser = this.manifestParser;
        int n10 = 4;
        object = new ParsingLoadable(dataSource, (Uri)object2, n10, parsingLoadable$Parser);
        object2 = this.manifestCallback;
        int n11 = this.loadErrorHandlingPolicy.getMinimumLoadableRetryCount(n10);
        this.startLoading((ParsingLoadable)object, (Loader$Callback)object2, n11);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void updateMediaItemLiveConfiguration(long var1_1, long var3_2) {
        var5_3 = this;
        var6_4 = this.mediaItem.liveConfiguration;
        var7_5 = var6_4.maxOffsetMs;
        var9_6 = -9223372036854775807L;
        cfr_temp_0 = var7_5 - var9_6;
        var11_7 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
        if (var11_7 /* !! */  == false && ((var6_4 = this.manifest.serviceDescription) == null || (var11_7 /* !! */  = (cfr_temp_1 = (var7_5 = var6_4.maxOffsetMs) - var9_6) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1)) == false)) {
            var7_5 = C.usToMs(var1_1);
        }
        var12_8 = var5_3.mediaItem.liveConfiguration;
        var13_9 = var12_8.minOffsetMs;
        cfr_temp_2 = var13_9 - var9_6;
        var15_10 /* !! */  = (long)(cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1));
        if (var15_10 /* !! */  != false) lbl-1000:
        // 4 sources

        {
            while (true) {
                continue;
                break;
            }
        }
        var12_8 = var5_3.manifest.serviceDescription;
        if (var12_8 != null && (var15_10 /* !! */  = (cfr_temp_3 = (var13_9 = var12_8.minOffsetMs) - var9_6) == 0L ? 0 : (cfr_temp_3 < 0L ? -1 : 1)) != false) ** GOTO lbl-1000
        var13_9 = C.usToMs(var1_1 - var3_2);
        cfr_temp_4 = var13_9 - (var18_11 = 0L);
        var20_13 /* !! */  = (long)(cfr_temp_4 == 0L ? 0 : (cfr_temp_4 < 0L ? -1 : 1));
        if (var20_13 /* !! */  < 0 && (var20_13 /* !! */  = var7_5 == var18_11 ? 0 : (var7_5 < var18_11 ? -1 : 1)) > 0) {
            var13_9 = var18_11;
        }
        var21_14 = var5_3.manifest;
        var18_11 = var21_14.minBufferTimeMs;
        cfr_temp_5 = var18_11 - var9_6;
        var20_13 /* !! */  = (long)(cfr_temp_5 == 0L ? 0 : (cfr_temp_5 < 0L ? -1 : 1));
        if (var20_13 /* !! */  == false) ** GOTO lbl-1000
        var13_9 = Math.min(var13_9 + var18_11, var7_5);
        ** while (true)
        var16_12 = var13_9;
        var12_8 = var5_3.liveConfiguration;
        var13_9 = var12_8.targetOffsetMs;
        var15_10 /* !! */  = var13_9 == var9_6 ? 0 : (var13_9 < var9_6 ? -1 : 1);
        if (var15_10 /* !! */  == false) {
            var12_8 = var5_3.manifest;
            var22_15 = var12_8.serviceDescription;
            if (var22_15 != null && (var25_17 = (cfr_temp_6 = (var23_16 = var22_15.targetOffsetMs) - var9_6) == 0L ? 0 : (cfr_temp_6 < 0L ? -1 : 1)) != false) {
                var13_9 = var23_16;
            } else {
                var13_9 = var12_8.suggestedPresentationDelayMs;
                cfr_temp_7 = var13_9 - var9_6;
                var26_18 /* !! */  = (long)(cfr_temp_7 == 0L ? 0 : (cfr_temp_7 < 0L ? -1 : 1));
                if (var26_18 /* !! */  == false) {
                    var13_9 = var5_3.fallbackTargetLiveOffsetMs;
                }
            }
        }
        var26_18 /* !! */  = var13_9 == var16_12 ? 0 : (var13_9 < var16_12 ? -1 : 1);
        if (var26_18 /* !! */  < 0) {
            var13_9 = var16_12;
        }
        if ((var26_18 /* !! */  = var13_9 == var7_5 ? 0 : (var13_9 < var7_5 ? -1 : 1)) > 0) {
            var13_9 = var3_2 / (long)2;
            var9_6 = Math.min(5000000L, var13_9);
            var13_9 = C.usToMs(var1_1 - var9_6);
            var18_11 = var16_12;
            var23_16 = var9_6 = Util.constrainValue(var13_9, var16_12, var7_5);
        } else {
            var23_16 = var13_9;
        }
        var27_19 = var5_3.mediaItem.liveConfiguration;
        var28_20 = var27_19.minPlaybackSpeed;
        var11_7 /* !! */  = -8388609;
        var29_21 = -3.4028235E38f;
        var25_17 = (long)(var28_20 == var29_21 ? 0 : (var28_20 > var29_21 ? 1 : -1));
        if (var25_17 == false) {
            var30_22 = var5_3.manifest.serviceDescription;
            var28_20 = var30_22 != null ? var30_22.minPlaybackSpeed : var29_21;
        }
        if ((var25_17 = (long)((cfr_temp_8 = (var31_23 = var27_19.maxPlaybackSpeed) - var29_21) == 0.0f ? 0 : (cfr_temp_8 > 0.0f ? 1 : -1))) != false) lbl-1000:
        // 2 sources

        {
            while (true) {
                var32_24 = var31_23;
                break;
            }
        } else {
            var27_19 = var5_3.manifest.serviceDescription;
            if (var27_19 != null) {
                var31_23 = var27_19.maxPlaybackSpeed;
                ** continue;
            }
            var32_24 = var29_21;
        }
        var12_8 = var27_19;
        var5_3.liveConfiguration = var27_19 = new MediaItem$LiveConfiguration(var23_16, var16_12, var7_5, var28_20, var32_24);
    }

    public /* synthetic */ void c() {
        this.b();
    }

    public MediaPeriod createPeriod(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, Allocator allocator, long l10) {
        Object object = mediaSource$MediaPeriodId;
        int n10 = (Integer)mediaSource$MediaPeriodId.periodUid;
        int n11 = this.firstPeriodId;
        int n12 = n10 - n11;
        long l11 = this.manifest.getPeriod((int)n12).startMs;
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher = this.createEventDispatcher(mediaSource$MediaPeriodId, l11);
        DrmSessionEventListener$EventDispatcher drmSessionEventListener$EventDispatcher = this.createDrmEventDispatcher(mediaSource$MediaPeriodId);
        int n13 = this.firstPeriodId + n12;
        DashManifest dashManifest = this.manifest;
        DashChunkSource$Factory dashChunkSource$Factory = this.chunkSourceFactory;
        TransferListener transferListener = this.mediaTransferListener;
        DrmSessionManager drmSessionManager = this.drmSessionManager;
        LoadErrorHandlingPolicy loadErrorHandlingPolicy = this.loadErrorHandlingPolicy;
        long l12 = this.elapsedRealtimeOffsetMs;
        LoaderErrorThrower loaderErrorThrower = this.manifestLoadErrorThrower;
        CompositeSequenceableLoaderFactory compositeSequenceableLoaderFactory = this.compositeSequenceableLoaderFactory;
        PlayerEmsgHandler$PlayerEmsgCallback playerEmsgHandler$PlayerEmsgCallback = this.playerEmsgCallback;
        object = new DashMediaPeriod(n13, dashManifest, n12, dashChunkSource$Factory, transferListener, drmSessionManager, drmSessionEventListener$EventDispatcher, loadErrorHandlingPolicy, mediaSourceEventListener$EventDispatcher, l12, loaderErrorThrower, allocator, compositeSequenceableLoaderFactory, playerEmsgHandler$PlayerEmsgCallback);
        loaderErrorThrower = this.periodsById;
        n11 = ((DashMediaPeriod)object).id;
        loaderErrorThrower.put(n11, object);
        return object;
    }

    public MediaItem getMediaItem() {
        return this.mediaItem;
    }

    public Object getTag() {
        return ((MediaItem$PlaybackProperties)Util.castNonNull((Object)this.mediaItem.playbackProperties)).tag;
    }

    public void maybeThrowSourceInfoRefreshError() {
        this.manifestLoadErrorThrower.maybeThrowError();
    }

    public void onDashManifestPublishTimeExpired(long l10) {
        long l11;
        long l12 = this.expiredManifestPublishTimeUs;
        long l13 = -9223372036854775807L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false || (l11 = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1)) < 0) {
            this.expiredManifestPublishTimeUs = l10;
        }
    }

    public void onDashManifestRefreshRequested() {
        Handler handler = this.handler;
        Runnable runnable = this.simulateManifestRefreshRunnable;
        handler.removeCallbacks(runnable);
        this.startLoadingManifest();
    }

    public void onLoadCanceled(ParsingLoadable parsingLoadable, long l10, long l11) {
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

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onManifestLoadCompleted(ParsingLoadable var1_1, long var2_2, long var4_3) {
        block17: {
            block18: {
                var6_4 = this;
                var7_5 = var1_1;
                var9_7 = var1_1.loadTaskId;
                var11_8 = var1_1.dataSpec;
                var12_9 = var1_1.getUri();
                var13_10 = var1_1.getResponseHeaders();
                var14_11 = var1_1.bytesLoaded();
                var16_12 = var8_6;
                var17_13 = var2_2;
                var19_14 = var4_3;
                var21_15 = var14_11;
                var8_6 = new LoadEventInfo(var9_7, (DataSpec)var11_8, var12_9, var13_10, var2_2, var4_3, var14_11);
                var16_12 = this.loadErrorHandlingPolicy;
                var9_7 = var1_1.loadTaskId;
                var16_12.onLoadTaskConcluded(var9_7);
                var16_12 = this.manifestEventDispatcher;
                var23_16 = var1_1.type;
                var16_12.loadCompleted((LoadEventInfo)var8_6, var23_16);
                var16_12 = (DashManifest)var1_1.getResult();
                var24_17 = this.manifest;
                var25_18 = 0;
                var26_19 = null;
                if (var24_17 == null) {
                    var23_16 = 0;
                    var24_17 = null;
                } else {
                    var23_16 = var24_17.getPeriodCount();
                }
                var11_8 = var16_12.getPeriod(0);
                var27_20 = var11_8.startMs;
                var13_10 = null;
                for (var29_21 = 0; var29_21 < var23_16; ++var29_21) {
                    var30_22 = var6_4.manifest.getPeriod(var29_21);
                    var17_13 = var30_22.startMs;
                    cfr_temp_0 = var17_13 - var27_20;
                    var31_23 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var31_23 /* !! */  >= 0) break;
                }
                var32_24 = var16_12.dynamic;
                var33_25 = 1;
                if (var32_24 == 0) break block17;
                var32_24 = var23_16 - var29_21;
                var31_23 /* !! */  = var16_12.getPeriodCount();
                if (var32_24 <= var31_23 /* !! */ ) break block18;
                var11_8 = "DashMediaSource";
                var30_22 = "Loaded out of sync manifest";
                Log.w((String)var11_8, (String)var30_22);
                ** GOTO lbl69
            }
            var17_13 = var6_4.expiredManifestPublishTimeUs;
            var19_14 = -9223372036854775807L;
            cfr_temp_1 = var17_13 - var19_14;
            var32_24 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
            if (var32_24 != 0 && (var32_24 = (int)((cfr_temp_2 = (var21_15 = 1000L * (var19_14 = var16_12.publishTimeMs)) - var17_13) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) <= 0) {
                var11_8 = "DashMediaSource";
                var34_26 = 73;
                var35_27 = new StringBuilder(var34_26);
                var8_6 = "Loaded stale dynamic manifest: ";
                var35_27.append((String)var8_6);
                var35_27.append(var19_14);
                var36_28 = ", ";
                var35_27.append(var36_28);
                var35_27.append(var17_13);
                var30_22 = var35_27.toString();
                Log.w((String)var11_8, (String)var30_22);
lbl69:
                // 2 sources

                var32_24 = var33_25;
            } else {
                var32_24 = 0;
                var11_8 = null;
            }
            if (var32_24 != 0) {
                var37_29 = var6_4.staleManifestReloadAttempt;
                var6_4.staleManifestReloadAttempt = var23_16 = var37_29 + 1;
                var24_17 = var6_4.loadErrorHandlingPolicy;
                var38_31 = var7_5.type;
                if (var37_29 < (var38_31 = var24_17.getMinimumLoadableRetryCount(var38_31))) {
                    var39_33 = this.getManifestLoadRetryDelayMillis();
                    var6_4.scheduleManifestRefresh(var39_33);
                    return;
                }
                var6_4.manifestFatalError = var7_5 = new DashManifestStaleException();
                return;
            }
            var6_4.staleManifestReloadAttempt = 0;
        }
        var6_4.manifest = var16_12;
        var32_24 = (int)var6_4.manifestLoadPending;
        var37_30 = var16_12.dynamic & var32_24;
        var6_4.manifestLoadPending = var37_30;
        var17_13 = var2_2;
        var6_4.manifestLoadStartTimestampMs = var19_14 = var2_2 - var4_3;
        var6_4.manifestLoadEndTimestampMs = var2_2;
        var16_12 = var6_4.manifestUriLock;
        synchronized (var16_12) {
            var11_8 = var7_5.dataSpec;
            var11_8 = var11_8.uri;
            var30_22 = var6_4.manifestUri;
            if (var11_8 == var30_22) {
                var25_18 = var33_25;
            }
            if (var25_18 != 0) {
                var26_19 = var6_4.manifest;
                var26_19 = var26_19.location;
                if (var26_19 == null) {
                    var26_19 = var1_1.getUri();
                }
                var6_4.manifestUri = var26_19;
            }
            ** if (var23_16 == 0) goto lbl110
        }
lbl-1000:
        // 1 sources

        {
            var6_4.firstPeriodId = var38_32 = var6_4.firstPeriodId + var29_21;
            var6_4.processManifest((boolean)var33_25);
            return;
        }
lbl110:
        // 1 sources

        var7_5 = var6_4.manifest;
        var37_30 = (int)var7_5.dynamic;
        if (var37_30 == 0) {
            var6_4.processManifest((boolean)var33_25);
            return;
        }
        var7_5 = var7_5.utcTiming;
        if (var7_5 != null) {
            var6_4.resolveUtcTimingElement((UtcTimingElement)var7_5);
            return;
        }
        this.loadNtpTimeOffset();
    }

    public Loader$LoadErrorAction onManifestLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException, int n10) {
        MediaSourceEventListener$EventDispatcher mediaSourceEventListener$EventDispatcher;
        long l12;
        LoadEventInfo loadEventInfo;
        DashMediaSource dashMediaSource = this;
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
        int n11 = n10;
        object2 = this.loadErrorHandlingPolicy;
        LoadErrorHandlingPolicy$LoadErrorInfo loadErrorHandlingPolicy$LoadErrorInfo = new LoadErrorHandlingPolicy$LoadErrorInfo(loadEventInfo, (MediaLoadData)object2, iOException, n10);
        long l15 = object2.getRetryDelayMsFor(loadErrorHandlingPolicy$LoadErrorInfo);
        long l16 = l15 - (l12 = -9223372036854775807L);
        n11 = (int)(l16 == 0L ? 0 : (l16 < 0L ? -1 : 1));
        if (n11 == 0) {
            object2 = Loader.DONT_RETRY_FATAL;
        } else {
            n11 = 0;
            mediaSourceEventListener$EventDispatcher = null;
            object2 = Loader.createRetryAction(false, l15);
        }
        boolean bl3 = ((Loader$LoadErrorAction)object2).isRetry() ^ true;
        mediaSourceEventListener$EventDispatcher = dashMediaSource.manifestEventDispatcher;
        int n12 = parsingLoadable2.type;
        mediaSourceEventListener$EventDispatcher.loadError(loadEventInfo, n12, (IOException)object, bl3);
        if (bl3) {
            object = dashMediaSource.loadErrorHandlingPolicy;
            l13 = parsingLoadable2.loadTaskId;
            object.onLoadTaskConcluded(l13);
        }
        return object2;
    }

    public void onUtcTimestampLoadCompleted(ParsingLoadable parsingLoadable, long l10, long l11) {
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
        ((MediaSourceEventListener$EventDispatcher)object).loadCompleted(loadEventInfo, n10);
        long l14 = (Long)parsingLoadable.getResult() - l10;
        this.onUtcTimestampResolved(l14);
    }

    public Loader$LoadErrorAction onUtcTimestampLoadError(ParsingLoadable parsingLoadable, long l10, long l11, IOException iOException) {
        Object object = this.manifestEventDispatcher;
        long l12 = parsingLoadable.loadTaskId;
        DataSpec dataSpec = parsingLoadable.dataSpec;
        Uri uri = parsingLoadable.getUri();
        Map map = parsingLoadable.getResponseHeaders();
        long l13 = parsingLoadable.bytesLoaded();
        LoadEventInfo loadEventInfo = new LoadEventInfo(l12, dataSpec, uri, map, l10, l11, l13);
        int n10 = parsingLoadable.type;
        ((MediaSourceEventListener$EventDispatcher)object).loadError(loadEventInfo, n10, iOException, true);
        object = this.loadErrorHandlingPolicy;
        long l14 = parsingLoadable.loadTaskId;
        object.onLoadTaskConcluded(l14);
        this.onUtcTimestampResolutionError(iOException);
        return Loader.DONT_RETRY;
    }

    public void prepareSourceInternal(TransferListener object) {
        this.mediaTransferListener = object;
        object = this.drmSessionManager;
        object.prepare();
        boolean bl2 = this.sideloadedManifest;
        if (bl2) {
            bl2 = false;
            object = null;
            this.processManifest(false);
        } else {
            this.dataSource = object = this.manifestDataSourceFactory.createDataSource();
            String string2 = "Loader:DashMediaSource";
            this.loader = object = new Loader(string2);
            object = Util.createHandlerForCurrentLooper();
            this.handler = object;
            this.startLoadingManifest();
        }
    }

    public void releasePeriod(MediaPeriod mediaPeriod) {
        mediaPeriod = (DashMediaPeriod)mediaPeriod;
        ((DashMediaPeriod)mediaPeriod).release();
        SparseArray sparseArray = this.periodsById;
        int n10 = ((DashMediaPeriod)mediaPeriod).id;
        sparseArray.remove(n10);
    }

    public void releaseSourceInternal() {
        long l10;
        long l11;
        this.manifestLoadPending = false;
        this.dataSource = null;
        Object object = this.loader;
        if (object != null) {
            ((Loader)object).release();
            this.loader = null;
        }
        this.manifestLoadStartTimestampMs = l11 = 0L;
        this.manifestLoadEndTimestampMs = l11;
        boolean bl2 = this.sideloadedManifest;
        if (bl2) {
            object = this.manifest;
        } else {
            bl2 = false;
            object = null;
        }
        this.manifest = object;
        object = this.initialManifestUri;
        this.manifestUri = object;
        this.manifestFatalError = null;
        object = this.handler;
        if (object != null) {
            object.removeCallbacksAndMessages(null);
            this.handler = null;
        }
        this.elapsedRealtimeOffsetMs = l10 = -9223372036854775807L;
        this.staleManifestReloadAttempt = 0;
        this.expiredManifestPublishTimeUs = l10;
        this.firstPeriodId = 0;
        this.periodsById.clear();
        this.drmSessionManager.release();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void replaceManifestUri(Uri uri) {
        Object object = this.manifestUriLock;
        synchronized (object) {
            this.manifestUri = uri;
            this.initialManifestUri = uri;
            return;
        }
    }
}

