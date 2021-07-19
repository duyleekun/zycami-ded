/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Looper
 *  android.util.Pair
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImpl$MediaSourceHolderSnapshot;
import com.google.android.exoplayer2.ExoPlayerImplInternal;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdateListener;
import com.google.android.exoplayer2.ExoPlayerLibraryInfo;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.IllegalSeekPositionException;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceHolder;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$AudioComponent;
import com.google.android.exoplayer2.Player$DeviceComponent;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$Events;
import com.google.android.exoplayer2.Player$MetadataComponent;
import com.google.android.exoplayer2.Player$TextComponent;
import com.google.android.exoplayer2.Player$VideoComponent;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.PlaylistTimeline;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.ShuffleOrder$DefaultShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.ListenerSet$Event;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import d.h.a.a.a;
import d.h.a.a.b0;
import d.h.a.a.c;
import d.h.a.a.d;
import d.h.a.a.e;
import d.h.a.a.f;
import d.h.a.a.g;
import d.h.a.a.h;
import d.h.a.a.i;
import d.h.a.a.j;
import d.h.a.a.k;
import d.h.a.a.l;
import d.h.a.a.m;
import d.h.a.a.n;
import d.h.a.a.o;
import d.h.a.a.p;
import d.h.a.a.q;
import d.h.a.a.r;
import d.h.a.a.s;
import d.h.a.a.t;
import d.h.a.a.u;
import d.h.a.a.v;
import d.h.a.a.w;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ExoPlayerImpl
extends BasePlayer
implements ExoPlayer {
    private static final String TAG = "ExoPlayerImpl";
    private final AnalyticsCollector analyticsCollector;
    private final Looper applicationLooper;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    public final TrackSelectorResult emptyTrackSelectorResult;
    private boolean foregroundMode;
    private boolean hasPendingDiscontinuity;
    private final ExoPlayerImplInternal internalPlayer;
    private final ListenerSet listeners;
    private int maskingPeriodIndex;
    private int maskingWindowIndex;
    private long maskingWindowPositionMs;
    private final MediaSourceFactory mediaSourceFactory;
    private final List mediaSourceHolderSnapshots;
    private boolean pauseAtEndOfMediaItems;
    private int pendingDiscontinuityReason;
    private int pendingOperationAcks;
    private int pendingPlayWhenReadyChangeReason;
    private final Timeline$Period period;
    private PlaybackInfo playbackInfo;
    private final HandlerWrapper playbackInfoUpdateHandler;
    private final ExoPlayerImplInternal$PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Renderer[] renderers;
    private int repeatMode;
    private SeekParameters seekParameters;
    private boolean shuffleModeEnabled;
    private ShuffleOrder shuffleOrder;
    private final TrackSelector trackSelector;
    private final boolean useLazyPreparation;

    public ExoPlayerImpl(Renderer[] rendererArray, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean bl2, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long l10, boolean bl3, Clock clock, Looper looper, Player player) {
        LivePlaybackSpeedControl livePlaybackSpeedControl2;
        Object object = this;
        Renderer[] rendererArray2 = rendererArray;
        BandwidthMeter bandwidthMeter2 = bandwidthMeter;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        Clock clock2 = clock;
        Looper looper2 = looper;
        Object object2 = Integer.toHexString(System.identityHashCode(this));
        Object object3 = Util.DEVICE_DEBUG_INFO;
        int n10 = String.valueOf(object2).length() + 30;
        int n11 = String.valueOf(object3).length();
        Object object4 = new StringBuilder(n10 += n11);
        Object object5 = "Init ";
        object4.append((String)object5);
        object4.append((String)object2);
        object4.append(" [");
        object4.append("ExoPlayerLib/2.13.2");
        object4.append("] [");
        object4.append((String)object3);
        object4.append("]");
        object2 = object4.toString();
        Log.i(TAG, (String)object2);
        boolean bl4 = rendererArray.length;
        int n12 = 0;
        object3 = null;
        if (bl4 > false) {
            bl4 = true;
        } else {
            bl4 = false;
            object2 = null;
        }
        Assertions.checkState(bl4);
        object2 = (Renderer[])Assertions.checkNotNull(rendererArray);
        ((ExoPlayerImpl)object).renderers = object2;
        object2 = (TrackSelector)Assertions.checkNotNull(trackSelector);
        ((ExoPlayerImpl)object).trackSelector = object2;
        object2 = mediaSourceFactory;
        ((ExoPlayerImpl)object).mediaSourceFactory = mediaSourceFactory;
        ((ExoPlayerImpl)object).bandwidthMeter = bandwidthMeter2;
        ((ExoPlayerImpl)object).analyticsCollector = analyticsCollector2;
        bl4 = bl2;
        ((ExoPlayerImpl)object).useLazyPreparation = bl2;
        ((ExoPlayerImpl)object).seekParameters = seekParameters;
        ((ExoPlayerImpl)object).pauseAtEndOfMediaItems = bl3;
        ((ExoPlayerImpl)object).applicationLooper = looper2;
        ((ExoPlayerImpl)object).clock = clock2;
        ((ExoPlayerImpl)object).repeatMode = 0;
        object2 = player != null ? player : object;
        object4 = b0.a;
        l l11 = new l((Player)object2);
        ((ExoPlayerImpl)object).listeners = object5 = new ListenerSet(looper2, clock2, (Supplier)object4, l11);
        object5 = new ArrayList();
        ((ExoPlayerImpl)object).mediaSourceHolderSnapshots = object5;
        ((ExoPlayerImpl)object).shuffleOrder = object5 = new ShuffleOrder$DefaultShuffleOrder(0);
        object3 = new RendererConfiguration[rendererArray2.length];
        n11 = rendererArray2.length;
        object4 = new ExoTrackSelection[n11];
        int n13 = 0;
        l11 = null;
        ((ExoPlayerImpl)object).emptyTrackSelectorResult = object5 = new TrackSelectorResult((RendererConfiguration[])object3, (ExoTrackSelection[])object4, null);
        ((ExoPlayerImpl)object).period = object3;
        ((ExoPlayerImpl)object).maskingWindowIndex = n12 = -1;
        ((ExoPlayerImpl)object).playbackInfoUpdateHandler = object3 = clock2.createHandler(looper2, null);
        o o10 = new o((ExoPlayerImpl)object);
        ((ExoPlayerImpl)object).playbackInfoUpdateListener = o10;
        ((ExoPlayerImpl)object).playbackInfo = object3 = PlaybackInfo.createDummy((TrackSelectorResult)object5);
        if (analyticsCollector2 != null) {
            analyticsCollector2.setPlayer((Player)object2, looper2);
            ((ExoPlayerImpl)object).addListener(analyticsCollector2);
            object2 = new Handler(looper2);
            bandwidthMeter2.addEventListener((Handler)object2, analyticsCollector2);
        }
        object2 = livePlaybackSpeedControl2;
        n13 = ((ExoPlayerImpl)object).repeatMode;
        boolean bl5 = ((ExoPlayerImpl)object).shuffleModeEnabled;
        rendererArray2 = rendererArray;
        object3 = trackSelector;
        object4 = loadControl;
        bandwidthMeter2 = bandwidthMeter;
        analyticsCollector2 = analyticsCollector;
        object = livePlaybackSpeedControl2;
        livePlaybackSpeedControl2 = livePlaybackSpeedControl;
        clock2 = looper;
        super(rendererArray, trackSelector, (TrackSelectorResult)object5, loadControl, bandwidthMeter, n13, bl5, analyticsCollector, seekParameters, livePlaybackSpeedControl, l10, bl3, looper, clock, o10);
        object = this;
        this.internalPlayer = object2;
    }

    public static /* synthetic */ void a(Player player, Player$EventListener player$EventListener, Player$Events player$Events) {
        player$EventListener.onEvents(player, player$Events);
    }

    private List addMediaSourceHolders(int n10, List object) {
        ShuffleOrder shuffleOrder;
        int n11;
        int n12;
        ArrayList<MediaSourceList$MediaSourceHolder> arrayList = new ArrayList<MediaSourceList$MediaSourceHolder>();
        for (n12 = 0; n12 < (n11 = object.size()); ++n12) {
            Object object2 = (MediaSource)object.get(n12);
            int n13 = this.useLazyPreparation;
            Object object3 = new MediaSourceList$MediaSourceHolder((MediaSource)object2, n13 != 0);
            arrayList.add((MediaSourceList$MediaSourceHolder)object3);
            object2 = this.mediaSourceHolderSnapshots;
            n13 = n12 + n10;
            Object object4 = ((MediaSourceList$MediaSourceHolder)object3).uid;
            object3 = ((MediaSourceList$MediaSourceHolder)object3).mediaSource.getTimeline();
            ExoPlayerImpl$MediaSourceHolderSnapshot exoPlayerImpl$MediaSourceHolderSnapshot = new ExoPlayerImpl$MediaSourceHolderSnapshot(object4, (Timeline)object3);
            object2.add(n13, exoPlayerImpl$MediaSourceHolderSnapshot);
        }
        object = this.shuffleOrder;
        n12 = arrayList.size();
        this.shuffleOrder = shuffleOrder = object.cloneAndInsert(n10, n12);
        return arrayList;
    }

    private /* synthetic */ void b(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        this.handlePlaybackInfo(exoPlayerImplInternal$PlaybackInfoUpdate);
    }

    private Timeline createMaskingTimeline() {
        List list = this.mediaSourceHolderSnapshots;
        ShuffleOrder shuffleOrder = this.shuffleOrder;
        PlaylistTimeline playlistTimeline = new PlaylistTimeline(list, shuffleOrder);
        return playlistTimeline;
    }

    private List createMediaSources(List list) {
        int n10;
        ArrayList<Object> arrayList = new ArrayList<Object>();
        for (int i10 = 0; i10 < (n10 = list.size()); ++i10) {
            Object object = this.mediaSourceFactory;
            MediaItem mediaItem = (MediaItem)list.get(i10);
            object = object.createMediaSource(mediaItem);
            arrayList.add(object);
        }
        return arrayList;
    }

    private /* synthetic */ void d(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        HandlerWrapper handlerWrapper = this.playbackInfoUpdateHandler;
        t t10 = new t(this, exoPlayerImplInternal$PlaybackInfoUpdate);
        handlerWrapper.post(t10);
    }

    private Pair evaluateMediaItemTransitionReason(PlaybackInfo object, PlaybackInfo object2, boolean bl2, int n10, boolean bl3) {
        int n11;
        Integer n12;
        int n13;
        Timeline timeline;
        Boolean bl4;
        Boolean bl5;
        block6: {
            block10: {
                int n14;
                block8: {
                    block9: {
                        int n15;
                        block7: {
                            bl5 = Boolean.FALSE;
                            bl4 = Boolean.TRUE;
                            Object object3 = ((PlaybackInfo)object2).timeline;
                            timeline = ((PlaybackInfo)object).timeline;
                            n13 = timeline.isEmpty();
                            int n16 = -1;
                            n12 = n16;
                            if (n13 != 0 && (n13 = ((Timeline)object3).isEmpty()) != 0) {
                                object = new Pair((Object)bl5, (Object)n12);
                                return object;
                            }
                            n13 = timeline.isEmpty();
                            int n17 = ((Timeline)object3).isEmpty();
                            n14 = 3;
                            if (n13 != n17) {
                                object2 = n14;
                                object = new Pair((Object)bl4, object2);
                                return object;
                            }
                            object2 = object2.periodId.periodUid;
                            Object object4 = this.period;
                            int n18 = object3.getPeriodByUid((Object)object2, (Timeline$Period)object4).windowIndex;
                            object4 = this.window;
                            object2 = object3.getWindow((int)n18, (Timeline$Window)object4).uid;
                            object3 = object.periodId.periodUid;
                            object4 = this.period;
                            int n19 = timeline.getPeriodByUid((Object)object3, (Timeline$Period)object4).windowIndex;
                            object4 = this.window;
                            object3 = timeline.getWindow((int)n19, (Timeline$Window)object4).uid;
                            object4 = this.window;
                            n13 = ((Timeline$Window)object4).firstPeriodIndex;
                            n18 = (int)(object2.equals(object3) ? 1 : 0);
                            if (n18 != 0) break block6;
                            n15 = 1;
                            if (!bl2 || n10 != 0) break block7;
                            n14 = n15;
                            break block8;
                        }
                        if (!bl2 || n10 != n15) break block9;
                        n14 = 2;
                        break block8;
                    }
                    if (!bl3) break block10;
                }
                object2 = n14;
                object = new Pair((Object)bl4, object2);
                return object;
            }
            object = new IllegalStateException();
            throw object;
        }
        if (bl2 && n10 == 0 && (n11 = timeline.getIndexOfPeriod(object = object.periodId.periodUid)) == n13) {
            object2 = 0;
            object = new Pair((Object)bl4, object2);
            return object;
        }
        object = new Pair((Object)bl5, (Object)n12);
        return object;
    }

    public static /* synthetic */ void f(Player$EventListener player$EventListener) {
        Exception exception = new ExoTimeoutException(1);
        exception = ExoPlaybackException.createForRenderer(exception);
        player$EventListener.onPlayerError((ExoPlaybackException)exception);
    }

    public static /* synthetic */ void g(int n10, Player$EventListener player$EventListener) {
        player$EventListener.onRepeatModeChanged(n10);
    }

    private int getCurrentWindowIndexInternal() {
        Object object = this.playbackInfo.timeline;
        boolean bl2 = ((Timeline)object).isEmpty();
        if (bl2) {
            return this.maskingWindowIndex;
        }
        object = this.playbackInfo;
        Timeline timeline = ((PlaybackInfo)object).timeline;
        object = object.periodId.periodUid;
        Timeline$Period timeline$Period = this.period;
        return timeline.getPeriodByUid((Object)object, (Timeline$Period)timeline$Period).windowIndex;
    }

    private Pair getPeriodPositionAfterTimelineChanged(Timeline object, Timeline timeline) {
        long l10 = this.getContentPosition();
        boolean bl2 = ((Timeline)object).isEmpty();
        long l11 = -9223372036854775807L;
        int n10 = -1;
        if (!bl2 && !(bl2 = timeline.isEmpty())) {
            int bl3 = this.getCurrentWindowIndex();
            Object object2 = this.window;
            Timeline$Period timeline$Period = this.period;
            long l12 = C.msToUs(l10);
            Object object3 = object;
            Object object4 = ((Timeline)object).getPeriodPosition((Timeline$Window)object2, timeline$Period, bl3, l12);
            Pair pair = (Pair)Util.castNonNull(object4);
            Object object5 = pair.first;
            int n11 = timeline.getIndexOfPeriod(object5);
            if (n11 != n10) {
                return object4;
            }
            object3 = this.window;
            object2 = this.period;
            int n12 = this.repeatMode;
            boolean bl4 = this.shuffleModeEnabled;
            if ((object = ExoPlayerImplInternal.resolveSubsequentPeriod((Timeline$Window)object3, (Timeline$Period)object2, n12, bl4, object5, (Timeline)object, timeline)) != null) {
                object4 = this.period;
                timeline.getPeriodByUid(object, (Timeline$Period)object4);
                int bl42 = this.period.windowIndex;
                object4 = this.window;
                l10 = timeline.getWindow(bl42, (Timeline$Window)object4).getDefaultPositionMs();
                return this.getPeriodPositionOrMaskWindowPosition(timeline, bl42, l10);
            }
            return this.getPeriodPositionOrMaskWindowPosition(timeline, n10, l11);
        }
        boolean bl5 = ((Timeline)object).isEmpty();
        if (!bl5 && (bl5 = timeline.isEmpty())) {
            bl5 = true;
        } else {
            bl5 = false;
            object = null;
        }
        if (!bl5) {
            n10 = this.getCurrentWindowIndexInternal();
        }
        if (bl5) {
            l10 = l11;
        }
        return this.getPeriodPositionOrMaskWindowPosition(timeline, n10, l10);
    }

    private Pair getPeriodPositionOrMaskWindowPosition(Timeline timeline, int n10, long l10) {
        int n11 = timeline.isEmpty();
        if (n11 != 0) {
            this.maskingWindowIndex = n10;
            long l11 = -9223372036854775807L;
            long l12 = l10 - l11;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object == false) {
                l10 = 0L;
            }
            this.maskingWindowPositionMs = l10;
            this.maskingPeriodIndex = 0;
            return null;
        }
        n11 = -1;
        if (n10 == n11 || n10 >= (n11 = timeline.getWindowCount())) {
            n10 = (int)(this.shuffleModeEnabled ? 1 : 0);
            n10 = timeline.getFirstWindowIndex(n10 != 0);
            Timeline$Window timeline$Window = this.window;
            timeline$Window = timeline.getWindow(n10, timeline$Window);
            l10 = timeline$Window.getDefaultPositionMs();
        }
        Timeline$Window timeline$Window = this.window;
        Timeline$Period timeline$Period = this.period;
        long l13 = C.msToUs(l10);
        return timeline.getPeriodPosition(timeline$Window, timeline$Period, n10, l13);
    }

    public static /* synthetic */ void h(boolean bl2, Player$EventListener player$EventListener) {
        player$EventListener.onShuffleModeEnabledChanged(bl2);
    }

    private void handlePlaybackInfo(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        int n10 = this.pendingOperationAcks;
        int n11 = exoPlayerImplInternal$PlaybackInfoUpdate.operationAcks;
        this.pendingOperationAcks = n10 -= n11;
        n11 = (int)(exoPlayerImplInternal$PlaybackInfoUpdate.positionDiscontinuity ? 1 : 0);
        int n12 = 1;
        if (n11 != 0) {
            this.hasPendingDiscontinuity = n12;
            this.pendingDiscontinuityReason = n11 = exoPlayerImplInternal$PlaybackInfoUpdate.discontinuityReason;
        }
        if ((n11 = (int)(exoPlayerImplInternal$PlaybackInfoUpdate.hasPlayWhenReadyChangeReason ? 1 : 0)) != 0) {
            this.pendingPlayWhenReadyChangeReason = n11 = exoPlayerImplInternal$PlaybackInfoUpdate.playWhenReadyChangeReason;
        }
        if (n10 == 0) {
            Object object;
            Object object2 = exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo.timeline;
            Timeline timeline = this.playbackInfo.timeline;
            n11 = (int)(timeline.isEmpty() ? 1 : 0);
            if (n11 == 0 && (n11 = (int)(((Timeline)object2).isEmpty() ? 1 : 0)) != 0) {
                long l10;
                this.maskingWindowIndex = n11 = -1;
                this.maskingWindowPositionMs = l10 = 0L;
                this.maskingPeriodIndex = 0;
            }
            if ((n11 = (int)(((Timeline)object2).isEmpty() ? 1 : 0)) == 0) {
                ExoPlayerImpl$MediaSourceHolderSnapshot exoPlayerImpl$MediaSourceHolderSnapshot;
                int n13;
                n11 = (object2 = ((PlaylistTimeline)object2).getChildTimelines()).size();
                if (n11 != (n13 = (object = this.mediaSourceHolderSnapshots).size())) {
                    n12 = 0;
                    exoPlayerImpl$MediaSourceHolderSnapshot = null;
                }
                Assertions.checkState(n12 != 0);
                timeline = null;
                for (n11 = 0; n11 < (n12 = object2.size()); ++n11) {
                    exoPlayerImpl$MediaSourceHolderSnapshot = (ExoPlayerImpl$MediaSourceHolderSnapshot)this.mediaSourceHolderSnapshots.get(n11);
                    object = (Timeline)object2.get(n11);
                    ExoPlayerImpl$MediaSourceHolderSnapshot.access$002(exoPlayerImpl$MediaSourceHolderSnapshot, (Timeline)object);
                }
            }
            boolean bl2 = this.hasPendingDiscontinuity;
            this.hasPendingDiscontinuity = false;
            PlaybackInfo playbackInfo = exoPlayerImplInternal$PlaybackInfoUpdate.playbackInfo;
            int n14 = this.pendingDiscontinuityReason;
            int n15 = 1;
            int n16 = this.pendingPlayWhenReadyChangeReason;
            object = this;
            this.updatePlaybackInfo(playbackInfo, bl2, n14, n15, n16, false);
        }
    }

    public static /* synthetic */ void i(PlaybackInfo object, TrackSelectionArray trackSelectionArray, Player$EventListener player$EventListener) {
        object = ((PlaybackInfo)object).trackGroups;
        player$EventListener.onTracksChanged((TrackGroupArray)object, trackSelectionArray);
    }

    private static boolean isPlaying(PlaybackInfo playbackInfo) {
        int n10;
        int n11 = playbackInfo.playbackState;
        int n12 = 3;
        if (n11 == n12 && (n11 = (int)(playbackInfo.playWhenReady ? 1 : 0)) != 0 && (n10 = playbackInfo.playbackSuppressionReason) == 0) {
            n10 = 1;
        } else {
            n10 = 0;
            playbackInfo = null;
        }
        return n10 != 0;
    }

    public static /* synthetic */ void j(PlaybackInfo object, Player$EventListener player$EventListener) {
        object = ((PlaybackInfo)object).staticMetadata;
        player$EventListener.onStaticMetadataChanged((List)object);
    }

    public static /* synthetic */ void k(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        boolean bl2 = playbackInfo.isLoading;
        player$EventListener.onIsLoadingChanged(bl2);
    }

    public static /* synthetic */ void l(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        boolean bl2 = playbackInfo.playWhenReady;
        int n10 = playbackInfo.playbackState;
        player$EventListener.onPlayerStateChanged(bl2, n10);
    }

    public static /* synthetic */ void m(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        int n10 = playbackInfo.playbackState;
        player$EventListener.onPlaybackStateChanged(n10);
    }

    private PlaybackInfo maskTimelineAndPosition(PlaybackInfo playbackInfo, Timeline timeline, Pair pair) {
        PlaybackInfo playbackInfo2;
        block14: {
            long l10;
            long l11;
            Object object;
            boolean bl2;
            Object object2;
            Object object3;
            Object object4;
            int n10;
            Object object5;
            ExoPlayerImpl exoPlayerImpl;
            block11: {
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
                block12: {
                    long l12;
                    Object object6;
                    int n12;
                    Object object7;
                    block13: {
                        long l13;
                        exoPlayerImpl = this;
                        object5 = timeline;
                        object7 = pair;
                        n12 = timeline.isEmpty();
                        n10 = 1;
                        if (n12 == 0 && pair == null) {
                            n12 = 0;
                            object4 = null;
                        } else {
                            n12 = n10;
                        }
                        Assertions.checkArgument(n12 != 0);
                        object4 = playbackInfo;
                        object3 = playbackInfo.timeline;
                        playbackInfo2 = playbackInfo.copyWithTimeline(timeline);
                        n12 = timeline.isEmpty();
                        if (n12 != 0) {
                            long l132;
                            object5 = PlaybackInfo.getDummyPeriodForEmptyTimeline();
                            long l14 = C.msToUs(exoPlayerImpl.maskingWindowPositionMs);
                            long l15 = C.msToUs(exoPlayerImpl.maskingWindowPositionMs);
                            TrackGroupArray trackGroupArray = TrackGroupArray.EMPTY;
                            TrackSelectorResult trackSelectorResult = exoPlayerImpl.emptyTrackSelectorResult;
                            ImmutableList immutableList = ImmutableList.of();
                            Object object8 = object5;
                            object5 = playbackInfo2.copyWithNewPosition((MediaSource$MediaPeriodId)object5, l14, l15, 0L, trackGroupArray, trackSelectorResult, immutableList).copyWithLoadingMediaPeriodId((MediaSource$MediaPeriodId)object5);
                            ((PlaybackInfo)object5).bufferedPositionUs = l132 = ((PlaybackInfo)object5).positionUs;
                            return object5;
                        }
                        object4 = playbackInfo2.periodId.periodUid;
                        object2 = ((Pair)Util.castNonNull((Object)pair)).first;
                        bl2 = object4.equals(object2) ^ n10;
                        if (bl2) {
                            Object object9 = ((Pair)object7).first;
                            mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId(object9);
                        } else {
                            mediaSource$MediaPeriodId = playbackInfo2.periodId;
                        }
                        object = mediaSource$MediaPeriodId;
                        object7 = (Long)((Pair)object7).second;
                        l11 = (Long)object7;
                        l10 = C.msToUs(this.getContentPosition());
                        boolean n11 = ((Timeline)object3).isEmpty();
                        if (!n11) {
                            object7 = exoPlayerImpl.period;
                            object7 = ((Timeline)object3).getPeriodByUid(object4, (Timeline$Period)object7);
                            long l16 = ((Timeline$Period)object7).getPositionInWindowUs();
                            l10 -= l16;
                        }
                        if (bl2 || (l13 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) < 0) break block11;
                        if (l13 != false) break block12;
                        object7 = playbackInfo2.loadingMediaPeriodId.periodUid;
                        int n13 = ((Timeline)object5).getIndexOfPeriod(object7);
                        if (n13 == (n12 = -1)) break block13;
                        object4 = exoPlayerImpl.period;
                        object7 = ((Timeline)object5).getPeriod(n13, (Timeline$Period)object4);
                        int n14 = ((Timeline$Period)object7).windowIndex;
                        object4 = ((MediaPeriodId)object).periodUid;
                        object6 = exoPlayerImpl.period;
                        object4 = ((Timeline)object5).getPeriodByUid(object4, (Timeline$Period)object6);
                        n12 = ((Timeline$Period)object4).windowIndex;
                        if (n14 == n12) break block14;
                    }
                    object7 = ((MediaPeriodId)object).periodUid;
                    object4 = exoPlayerImpl.period;
                    ((Timeline)object5).getPeriodByUid(object7, (Timeline$Period)object4);
                    boolean bl3 = ((MediaPeriodId)object).isAd();
                    if (bl3) {
                        object5 = exoPlayerImpl.period;
                        int n15 = ((MediaPeriodId)object).adGroupIndex;
                        n12 = ((MediaPeriodId)object).adIndexInAdGroup;
                        l12 = ((Timeline$Period)object5).getAdDurationUs(n15, n12);
                    } else {
                        object5 = exoPlayerImpl.period;
                        l12 = ((Timeline$Period)object5).durationUs;
                    }
                    l10 = playbackInfo2.positionUs;
                    long l17 = playbackInfo2.positionUs;
                    long l14 = playbackInfo2.positionUs;
                    l11 = l12 - l14;
                    TrackGroupArray trackGroupArray = playbackInfo2.trackGroups;
                    object4 = playbackInfo2.trackSelectorResult;
                    object6 = playbackInfo2.staticMetadata;
                    object2 = object;
                    object3 = object;
                    object = object4;
                    Object object10 = object6;
                    object4 = playbackInfo2.copyWithNewPosition((MediaSource$MediaPeriodId)object2, l10, l17, l11, trackGroupArray, (TrackSelectorResult)object4, (List)object6);
                    playbackInfo2 = ((PlaybackInfo)object4).copyWithLoadingMediaPeriodId((MediaSource$MediaPeriodId)object2);
                    playbackInfo2.bufferedPositionUs = l12;
                    break block14;
                }
                object3 = object;
                boolean bl4 = ((MediaPeriodId)object).isAd() ^ n10;
                Assertions.checkState(bl4);
                long l15 = playbackInfo2.totalBufferedDurationUs;
                long l16 = l11 - l10;
                long l17 = Math.max(0L, l15 -= l16);
                l15 = playbackInfo2.bufferedPositionUs;
                object2 = playbackInfo2.loadingMediaPeriodId;
                mediaSource$MediaPeriodId = playbackInfo2.periodId;
                bl2 = ((MediaPeriodId)object2).equals(mediaSource$MediaPeriodId);
                if (bl2) {
                    l15 = l11 + l17;
                }
                TrackGroupArray trackGroupArray = playbackInfo2.trackGroups;
                object = playbackInfo2.trackSelectorResult;
                List list = playbackInfo2.staticMetadata;
                object2 = object3;
                l10 = l11;
                object3 = list;
                long l22 = l11;
                l11 = l17;
                List list2 = list;
                playbackInfo2 = playbackInfo2.copyWithNewPosition((MediaSource$MediaPeriodId)object2, l10, l10, l17, trackGroupArray, (TrackSelectorResult)object, list);
                playbackInfo2.bufferedPositionUs = l15;
                break block14;
            }
            object3 = object;
            boolean bl5 = ((MediaPeriodId)object).isAd() ^ n10;
            Assertions.checkState(bl5);
            long l18 = 0L;
            object4 = bl2 ? TrackGroupArray.EMPTY : playbackInfo2.trackGroups;
            Object object11 = object4;
            object4 = bl2 ? exoPlayerImpl.emptyTrackSelectorResult : playbackInfo2.trackSelectorResult;
            object = object4;
            object4 = bl2 ? ImmutableList.of() : playbackInfo2.staticMetadata;
            Object object12 = object4;
            object2 = object3;
            l10 = l11;
            long l24 = l11;
            long l19 = l11;
            l11 = l18;
            object5 = playbackInfo2.copyWithNewPosition((MediaSource$MediaPeriodId)object3, l10, l10, l18, (TrackGroupArray)object11, (TrackSelectorResult)object, (List)object4);
            playbackInfo2 = ((PlaybackInfo)object5).copyWithLoadingMediaPeriodId((MediaSource$MediaPeriodId)object3);
            playbackInfo2.bufferedPositionUs = l10;
        }
        return playbackInfo2;
    }

    public static /* synthetic */ void n(PlaybackInfo playbackInfo, int n10, Player$EventListener player$EventListener) {
        boolean bl2 = playbackInfo.playWhenReady;
        player$EventListener.onPlayWhenReadyChanged(bl2, n10);
    }

    public static /* synthetic */ void o(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        int n10 = playbackInfo.playbackSuppressionReason;
        player$EventListener.onPlaybackSuppressionReasonChanged(n10);
    }

    public static /* synthetic */ void p(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        boolean bl2 = ExoPlayerImpl.isPlaying(playbackInfo);
        player$EventListener.onIsPlayingChanged(bl2);
    }

    private long periodPositionUsToWindowPositionMs(MediaSource$MediaPeriodId object, long l10) {
        l10 = C.usToMs(l10);
        Timeline timeline = this.playbackInfo.timeline;
        object = ((MediaPeriodId)object).periodUid;
        Timeline$Period timeline$Period = this.period;
        timeline.getPeriodByUid(object, timeline$Period);
        long l11 = this.period.getPositionInWindowMs();
        return l10 + l11;
    }

    public static /* synthetic */ void q(PlaybackInfo object, Player$EventListener player$EventListener) {
        object = ((PlaybackInfo)object).playbackParameters;
        player$EventListener.onPlaybackParametersChanged((PlaybackParameters)object);
    }

    public static /* synthetic */ void r(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        boolean bl2 = playbackInfo.offloadSchedulingEnabled;
        player$EventListener.onExperimentalOffloadSchedulingEnabledChanged(bl2);
    }

    private PlaybackInfo removeMediaItemsInternal(int n10, int n11) {
        int n12;
        List list;
        int n13;
        int n14 = 0;
        ExoPlayerImplInternal exoPlayerImplInternal = null;
        int n15 = 1;
        if (n10 >= 0 && n11 >= n10 && n11 <= (n13 = (list = this.mediaSourceHolderSnapshots).size())) {
            n13 = n15;
        } else {
            n13 = 0;
            list = null;
        }
        Assertions.checkArgument(n13 != 0);
        n13 = this.getCurrentWindowIndex();
        Object object = this.getCurrentTimeline();
        Object object2 = this.mediaSourceHolderSnapshots;
        int n16 = object2.size();
        this.pendingOperationAcks = n12 = this.pendingOperationAcks + n15;
        this.removeMediaSourceHolders(n10, n11);
        Timeline timeline = this.createMaskingTimeline();
        PlaybackInfo playbackInfo = this.playbackInfo;
        object = this.getPeriodPositionAfterTimelineChanged((Timeline)object, timeline);
        object = this.maskTimelineAndPosition(playbackInfo, timeline, (Pair)object);
        n12 = ((PlaybackInfo)object).playbackState;
        int n17 = 4;
        if (n12 != n15 && n12 != n17 && n10 < n11 && n11 == n16 && n13 >= (n16 = ((Timeline)(object2 = ((PlaybackInfo)object).timeline)).getWindowCount())) {
            n14 = n15;
        }
        if (n14 != 0) {
            object = ((PlaybackInfo)object).copyWithPlaybackState(n17);
        }
        exoPlayerImplInternal = this.internalPlayer;
        ShuffleOrder shuffleOrder = this.shuffleOrder;
        exoPlayerImplInternal.removeMediaSources(n10, n11, shuffleOrder);
        return object;
    }

    private void removeMediaSourceHolders(int n10, int n11) {
        ShuffleOrder shuffleOrder;
        for (int i10 = n11 + -1; i10 >= n10; i10 += -1) {
            List list = this.mediaSourceHolderSnapshots;
            list.remove(i10);
        }
        this.shuffleOrder = shuffleOrder = this.shuffleOrder.cloneAndRemove(n10, n11);
    }

    public static /* synthetic */ void s(PlaybackInfo playbackInfo, Player$EventListener player$EventListener) {
        boolean bl2 = playbackInfo.sleepingForOffload;
        player$EventListener.onExperimentalSleepingForOffloadChanged(bl2);
    }

    private void setMediaSourcesInternal(List list, int n10, long l10, boolean bl2) {
        int n11;
        ExoPlayerImpl exoPlayerImpl = this;
        int n112 = n10;
        int n12 = this.getCurrentWindowIndexInternal();
        long l11 = this.getCurrentPosition();
        int n13 = this.pendingOperationAcks;
        int n14 = 1;
        this.pendingOperationAcks = n13 += n14;
        Object object = this.mediaSourceHolderSnapshots;
        n13 = (int)(object.isEmpty() ? 1 : 0);
        boolean n15 = false;
        if (n13 == 0) {
            object = this.mediaSourceHolderSnapshots;
            n13 = object.size();
            this.removeMediaSourceHolders(0, n13);
        }
        object = list;
        List list2 = this.addMediaSourceHolders(0, list);
        object = this.createMaskingTimeline();
        boolean bl3 = ((Timeline)object).isEmpty();
        if (!bl3 && n112 >= (n11 = ((Timeline)object).getWindowCount())) {
            long l12 = l10;
            IllegalSeekPositionException illegalSeekPositionException = new IllegalSeekPositionException((Timeline)object, n112, l10);
            throw illegalSeekPositionException;
        }
        long l13 = l10;
        int n16 = -1;
        if (bl2) {
            long l14;
            n112 = (int)(exoPlayerImpl.shuffleModeEnabled ? 1 : 0);
            n112 = ((Timeline)object).getFirstWindowIndex(n112 != 0);
            l13 = l14 = -9223372036854775807L;
        } else if (n112 == n16) {
            n112 = n12;
            l13 = l11;
        }
        PlaybackInfo playbackInfo = exoPlayerImpl.playbackInfo;
        Pair pair = this.getPeriodPositionOrMaskWindowPosition((Timeline)object, n112, l13);
        playbackInfo = this.maskTimelineAndPosition(playbackInfo, (Timeline)object, pair);
        int n17 = playbackInfo.playbackState;
        if (n112 != n16 && n17 != n14) {
            n17 = (int)(((Timeline)object).isEmpty() ? 1 : 0);
            n17 = n17 == 0 && n112 < (n17 = ((Timeline)object).getWindowCount()) ? 2 : 4;
        }
        playbackInfo = playbackInfo.copyWithPlaybackState(n17);
        ExoPlayerImplInternal exoPlayerImplInternal = exoPlayerImpl.internalPlayer;
        long l15 = C.msToUs(l13);
        ShuffleOrder shuffleOrder = exoPlayerImpl.shuffleOrder;
        exoPlayerImplInternal.setMediaSources(list2, n112, l15, shuffleOrder);
        this.updatePlaybackInfo(playbackInfo, false, 4, 0, 1, false);
    }

    public static /* synthetic */ void t(PlaybackInfo object, int n10, Player$EventListener player$EventListener) {
        object = ((PlaybackInfo)object).timeline;
        player$EventListener.onTimelineChanged((Timeline)object, n10);
    }

    public static /* synthetic */ void u(int n10, Player$EventListener player$EventListener) {
        player$EventListener.onPositionDiscontinuity(n10);
    }

    /*
     * WARNING - void declaration
     */
    private void updatePlaybackInfo(PlaybackInfo playbackInfo, boolean n10, int n11, int n12, int n13, boolean bl2) {
        int n14;
        int n15;
        void var6_21;
        boolean bl3;
        int n16;
        ListenerSet$Event listenerSet$Event;
        int n17;
        int n18;
        int n19;
        int n20;
        int n21;
        boolean bl4;
        Object object;
        Object object2;
        Object object3;
        int n22;
        int n23;
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo;
        Object object4 = playbackInfo2.timeline;
        Object object5 = playbackInfo.timeline;
        boolean bl5 = ((Timeline)object4).equals(object5);
        int n24 = 1;
        boolean bl6 = bl5 ^ true;
        object4 = this;
        object5 = playbackInfo;
        Object object6 = playbackInfo2;
        object4 = this.evaluateMediaItemTransitionReason(playbackInfo, playbackInfo2, n10 != 0, n23, bl6);
        object5 = (Boolean)((Pair)object4).first;
        boolean bl7 = (Boolean)object5;
        object4 = (Integer)((Pair)object4).second;
        int n25 = (Integer)object4;
        object6 = playbackInfo2.timeline;
        Timeline timeline = playbackInfo.timeline;
        boolean bl8 = ((Timeline)object6).equals(timeline);
        if (!bl8) {
            object6 = this.listeners;
            timeline = null;
            c c10 = new c(playbackInfo, n22);
            ((ListenerSet)object6).queueEvent(0, c10);
        }
        if (n10 != 0) {
            object3 = this.listeners;
            n22 = 12;
            object6 = new d(n23);
            ((ListenerSet)object3).queueEvent(n22, (ListenerSet$Event)object6);
        }
        if (bl7) {
            object3 = playbackInfo.timeline;
            boolean bl9 = ((Timeline)object3).isEmpty();
            if (!bl9) {
                object3 = playbackInfo.timeline;
                object2 = playbackInfo.periodId.periodUid;
                object = this.period;
                int n26 = object3.getPeriodByUid((Object)object2, (Timeline$Period)object).windowIndex;
                object2 = playbackInfo.timeline;
                object = this.window;
                object3 = object2.getWindow((int)n26, (Timeline$Window)object).mediaItem;
            } else {
                boolean bl10 = false;
                object3 = null;
            }
            object2 = this.listeners;
            object = new r((MediaItem)object3, n25);
            ((ListenerSet)object2).queueEvent(n24, (ListenerSet$Event)object);
        }
        if ((object3 = playbackInfo2.playbackError) != (object2 = playbackInfo.playbackError) && object2 != null) {
            object3 = this.listeners;
            n23 = 11;
            object = new n(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, (ListenerSet$Event)object);
        }
        if ((object3 = playbackInfo2.trackSelectorResult) != (object2 = playbackInfo.trackSelectorResult)) {
            object3 = this.trackSelector;
            object2 = ((TrackSelectorResult)object2).info;
            ((TrackSelector)object3).onSelectionActivated(object2);
            object2 = playbackInfo.trackSelectorResult.selections;
            object3 = new TrackSelectionArray((TrackSelection[])object2);
            object2 = this.listeners;
            n22 = 2;
            object4 = new m(playbackInfo, (TrackSelectionArray)object3);
            ((ListenerSet)object2).queueEvent(n22, (ListenerSet$Event)object4);
        }
        if (!(bl4 = (object3 = playbackInfo2.staticMetadata).equals(object2 = playbackInfo.staticMetadata))) {
            object3 = this.listeners;
            n23 = 3;
            object = new j(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, (ListenerSet$Event)object);
        }
        if ((n21 = playbackInfo2.isLoading) != (n23 = (int)(playbackInfo.isLoading ? 1 : 0))) {
            object3 = this.listeners;
            n23 = 4;
            object = new f(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, (ListenerSet$Event)object);
        }
        int n27 = playbackInfo2.playbackState;
        n23 = playbackInfo.playbackState;
        n22 = -1;
        if (n27 != n23 || (n20 = playbackInfo2.playWhenReady) != (n23 = (int)(playbackInfo.playWhenReady ? 1 : 0))) {
            object3 = this.listeners;
            object2 = new p(playbackInfo);
            ((ListenerSet)object3).queueEvent(n22, (ListenerSet$Event)object2);
        }
        if ((n19 = playbackInfo2.playbackState) != (n23 = playbackInfo.playbackState)) {
            object3 = this.listeners;
            n23 = 5;
            object4 = new k(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, (ListenerSet$Event)object4);
        }
        if ((n18 = playbackInfo2.playWhenReady) != (n23 = (int)(playbackInfo.playWhenReady ? 1 : 0))) {
            void var5_20;
            object3 = this.listeners;
            n23 = 6;
            object4 = new v(playbackInfo, (int)var5_20);
            ((ListenerSet)object3).queueEvent(n23, (ListenerSet$Event)object4);
        }
        if ((n17 = playbackInfo2.playbackSuppressionReason) != (n23 = playbackInfo.playbackSuppressionReason)) {
            object3 = this.listeners;
            n23 = 7;
            listenerSet$Event = new s(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, listenerSet$Event);
        }
        if ((n16 = ExoPlayerImpl.isPlaying(playbackInfo2)) != (n23 = (int)(ExoPlayerImpl.isPlaying(playbackInfo) ? 1 : 0))) {
            object3 = this.listeners;
            n23 = 8;
            listenerSet$Event = new i(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, listenerSet$Event);
        }
        if (!(bl3 = ((PlaybackParameters)(object3 = playbackInfo2.playbackParameters)).equals(object2 = playbackInfo.playbackParameters))) {
            object3 = this.listeners;
            n23 = 13;
            listenerSet$Event = new w(playbackInfo);
            ((ListenerSet)object3).queueEvent(n23, listenerSet$Event);
        }
        if (var6_21 != false) {
            object3 = this.listeners;
            object2 = a.a;
            ((ListenerSet)object3).queueEvent(n22, (ListenerSet$Event)object2);
        }
        if ((n15 = playbackInfo2.offloadSchedulingEnabled) != (n23 = (int)(playbackInfo.offloadSchedulingEnabled ? 1 : 0))) {
            object3 = this.listeners;
            object2 = new g(playbackInfo);
            ((ListenerSet)object3).queueEvent(n22, (ListenerSet$Event)object2);
        }
        if ((n14 = playbackInfo2.sleepingForOffload) != (n23 = (int)(playbackInfo.sleepingForOffload ? 1 : 0))) {
            object3 = this.listeners;
            object2 = new u(playbackInfo);
            ((ListenerSet)object3).queueEvent(n22, (ListenerSet$Event)object2);
        }
        this.listeners.flushEvents();
    }

    public static /* synthetic */ void v(MediaItem mediaItem, int n10, Player$EventListener player$EventListener) {
        player$EventListener.onMediaItemTransition(mediaItem, n10);
    }

    public static /* synthetic */ void w(PlaybackInfo object, Player$EventListener player$EventListener) {
        object = ((PlaybackInfo)object).playbackError;
        player$EventListener.onPlayerError((ExoPlaybackException)object);
    }

    public void addListener(Player$EventListener player$EventListener) {
        this.listeners.add(player$EventListener);
    }

    public void addMediaItems(int n10, List list) {
        list = this.createMediaSources(list);
        this.addMediaSources(n10, list);
    }

    public void addMediaItems(List list) {
        int n10 = this.mediaSourceHolderSnapshots.size();
        this.addMediaItems(n10, list);
    }

    public void addMediaSource(int n10, MediaSource object) {
        object = Collections.singletonList(object);
        this.addMediaSources(n10, (List)object);
    }

    public void addMediaSource(MediaSource object) {
        object = Collections.singletonList(object);
        this.addMediaSources((List)object);
    }

    public void addMediaSources(int n10, List list) {
        int n11;
        Object object;
        int n12;
        int n13 = 1;
        if (n10 >= 0) {
            n12 = n13;
        } else {
            n12 = 0;
            object = null;
        }
        Assertions.checkArgument(n12 != 0);
        object = this.getCurrentTimeline();
        this.pendingOperationAcks = n11 = this.pendingOperationAcks + n13;
        list = this.addMediaSourceHolders(n10, list);
        Object object2 = this.createMaskingTimeline();
        PlaybackInfo playbackInfo = this.playbackInfo;
        object = this.getPeriodPositionAfterTimelineChanged((Timeline)object, (Timeline)object2);
        PlaybackInfo playbackInfo2 = this.maskTimelineAndPosition(playbackInfo, (Timeline)object2, (Pair)object);
        object2 = this.internalPlayer;
        object = this.shuffleOrder;
        ((ExoPlayerImplInternal)object2).addMediaSources(n10, list, (ShuffleOrder)object);
        this.updatePlaybackInfo(playbackInfo2, false, 4, 0, 1, false);
    }

    public void addMediaSources(List list) {
        int n10 = this.mediaSourceHolderSnapshots.size();
        this.addMediaSources(n10, list);
    }

    public /* synthetic */ void c(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        this.b(exoPlayerImplInternal$PlaybackInfoUpdate);
    }

    public void clearMediaItems() {
        int n10 = this.mediaSourceHolderSnapshots.size();
        this.removeMediaItems(0, n10);
    }

    public PlayerMessage createMessage(PlayerMessage$Target playerMessage$Target) {
        ExoPlayerImplInternal exoPlayerImplInternal = this.internalPlayer;
        Timeline timeline = this.playbackInfo.timeline;
        int n10 = this.getCurrentWindowIndex();
        Clock clock = this.clock;
        Looper looper = this.internalPlayer.getPlaybackLooper();
        PlayerMessage playerMessage = new PlayerMessage(exoPlayerImplInternal, playerMessage$Target, timeline, n10, clock, looper);
        return playerMessage;
    }

    public /* synthetic */ void e(ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate) {
        this.d(exoPlayerImplInternal$PlaybackInfoUpdate);
    }

    public boolean experimentalIsSleepingForOffload() {
        return this.playbackInfo.sleepingForOffload;
    }

    public void experimentalSetForegroundModeTimeoutMs(long l10) {
        this.internalPlayer.experimentalSetForegroundModeTimeoutMs(l10);
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean bl2) {
        this.internalPlayer.experimentalSetOffloadSchedulingEnabled(bl2);
    }

    public Looper getApplicationLooper() {
        return this.applicationLooper;
    }

    public Player$AudioComponent getAudioComponent() {
        return null;
    }

    public long getBufferedPosition() {
        boolean bl2 = this.isPlayingAd();
        if (bl2) {
            long l10;
            Object object = this.playbackInfo;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object).loadingMediaPeriodId;
            object = ((PlaybackInfo)object).periodId;
            bl2 = mediaSource$MediaPeriodId.equals(object);
            if (bl2) {
                object = this.playbackInfo;
                l10 = C.usToMs(((PlaybackInfo)object).bufferedPositionUs);
            } else {
                l10 = this.getDuration();
            }
            return l10;
        }
        return this.getContentBufferedPosition();
    }

    public Clock getClock() {
        return this.clock;
    }

    public long getContentBufferedPosition() {
        Object object = this.playbackInfo.timeline;
        boolean bl2 = ((Timeline)object).isEmpty();
        if (bl2) {
            return this.maskingWindowPositionMs;
        }
        object = this.playbackInfo;
        Object object2 = ((PlaybackInfo)object).loadingMediaPeriodId;
        long l10 = ((MediaPeriodId)object2).windowSequenceNumber;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object).periodId;
        long l11 = mediaSource$MediaPeriodId.windowSequenceNumber;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            object = ((PlaybackInfo)object).timeline;
            object3 = this.getCurrentWindowIndex();
            Timeline$Window timeline$Window = this.window;
            return ((Timeline)object).getWindow((int)object3, timeline$Window).getDurationMs();
        }
        long l13 = ((PlaybackInfo)object).bufferedPositionUs;
        Object object4 = this.playbackInfo.loadingMediaPeriodId;
        boolean bl3 = ((MediaPeriodId)object4).isAd();
        if (bl3) {
            object = this.playbackInfo;
            object2 = ((PlaybackInfo)object).timeline;
            object = object.loadingMediaPeriodId.periodUid;
            object4 = this.period;
            object = ((Timeline)object2).getPeriodByUid(object, (Timeline$Period)object4);
            object2 = this.playbackInfo.loadingMediaPeriodId;
            object3 = ((MediaPeriodId)object2).adGroupIndex;
            l10 = ((Timeline$Period)object).getAdGroupTimeUs((int)object3);
            long l14 = l10 - (l11 = Long.MIN_VALUE);
            Object object5 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            l13 = object5 == false ? ((Timeline$Period)object).durationUs : l10;
        }
        object4 = this.playbackInfo.loadingMediaPeriodId;
        return this.periodPositionUsToWindowPositionMs((MediaSource$MediaPeriodId)object4, l13);
    }

    public long getContentPosition() {
        boolean bl2 = this.isPlayingAd();
        if (bl2) {
            long l10;
            Object object = this.playbackInfo;
            Timeline timeline = ((PlaybackInfo)object).timeline;
            object = object.periodId.periodUid;
            Object object2 = this.period;
            timeline.getPeriodByUid(object, (Timeline$Period)object2);
            object = this.playbackInfo;
            long l11 = ((PlaybackInfo)object).requestedContentPositionUs;
            long l12 = -9223372036854775807L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 == false) {
                object = ((PlaybackInfo)object).timeline;
                l13 = this.getCurrentWindowIndex();
                object2 = this.window;
                object = ((Timeline)object).getWindow((int)l13, (Timeline$Window)object2);
                l10 = ((Timeline$Window)object).getDefaultPositionMs();
            } else {
                object = this.period;
                l10 = ((Timeline$Period)object).getPositionInWindowMs();
                object2 = this.playbackInfo;
                long l14 = C.usToMs(((PlaybackInfo)object2).requestedContentPositionUs);
                l10 += l14;
            }
            return l10;
        }
        return this.getCurrentPosition();
    }

    public int getCurrentAdGroupIndex() {
        int n10 = this.isPlayingAd();
        if (n10 != 0) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playbackInfo.periodId;
            n10 = mediaSource$MediaPeriodId.adGroupIndex;
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int getCurrentAdIndexInAdGroup() {
        int n10 = this.isPlayingAd();
        if (n10 != 0) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playbackInfo.periodId;
            n10 = mediaSource$MediaPeriodId.adIndexInAdGroup;
        } else {
            n10 = -1;
        }
        return n10;
    }

    public int getCurrentPeriodIndex() {
        Object object = this.playbackInfo.timeline;
        boolean bl2 = ((Timeline)object).isEmpty();
        if (bl2) {
            return this.maskingPeriodIndex;
        }
        object = this.playbackInfo;
        Timeline timeline = ((PlaybackInfo)object).timeline;
        object = object.periodId.periodUid;
        return timeline.getIndexOfPeriod(object);
    }

    public long getCurrentPosition() {
        Object object = this.playbackInfo.timeline;
        boolean bl2 = ((Timeline)object).isEmpty();
        if (bl2) {
            return this.maskingWindowPositionMs;
        }
        object = this.playbackInfo.periodId;
        bl2 = ((MediaPeriodId)object).isAd();
        if (bl2) {
            return C.usToMs(this.playbackInfo.positionUs);
        }
        object = this.playbackInfo;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object).periodId;
        long l10 = ((PlaybackInfo)object).positionUs;
        return this.periodPositionUsToWindowPositionMs(mediaSource$MediaPeriodId, l10);
    }

    public List getCurrentStaticMetadata() {
        return this.playbackInfo.staticMetadata;
    }

    public Timeline getCurrentTimeline() {
        return this.playbackInfo.timeline;
    }

    public TrackGroupArray getCurrentTrackGroups() {
        return this.playbackInfo.trackGroups;
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        TrackSelection[] trackSelectionArray = this.playbackInfo.trackSelectorResult.selections;
        TrackSelectionArray trackSelectionArray2 = new TrackSelectionArray(trackSelectionArray);
        return trackSelectionArray2;
    }

    public int getCurrentWindowIndex() {
        int n10;
        int n11 = this.getCurrentWindowIndexInternal();
        if (n11 == (n10 = -1)) {
            n11 = 0;
        }
        return n11;
    }

    public Player$DeviceComponent getDeviceComponent() {
        return null;
    }

    public long getDuration() {
        boolean bl2 = this.isPlayingAd();
        if (bl2) {
            Object object = this.playbackInfo;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object).periodId;
            object = ((PlaybackInfo)object).timeline;
            Object object2 = mediaSource$MediaPeriodId.periodUid;
            Timeline$Period timeline$Period = this.period;
            ((Timeline)object).getPeriodByUid(object2, timeline$Period);
            object = this.period;
            int n10 = mediaSource$MediaPeriodId.adGroupIndex;
            int n11 = mediaSource$MediaPeriodId.adIndexInAdGroup;
            return C.usToMs(((Timeline$Period)object).getAdDurationUs(n10, n11));
        }
        return this.getContentDuration();
    }

    public Player$MetadataComponent getMetadataComponent() {
        return null;
    }

    public boolean getPauseAtEndOfMediaItems() {
        return this.pauseAtEndOfMediaItems;
    }

    public boolean getPlayWhenReady() {
        return this.playbackInfo.playWhenReady;
    }

    public ExoPlaybackException getPlaybackError() {
        return this.getPlayerError();
    }

    public Looper getPlaybackLooper() {
        return this.internalPlayer.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        return this.playbackInfo.playbackParameters;
    }

    public int getPlaybackState() {
        return this.playbackInfo.playbackState;
    }

    public int getPlaybackSuppressionReason() {
        return this.playbackInfo.playbackSuppressionReason;
    }

    public ExoPlaybackException getPlayerError() {
        return this.playbackInfo.playbackError;
    }

    public int getRendererCount() {
        return this.renderers.length;
    }

    public int getRendererType(int n10) {
        return this.renderers[n10].getTrackType();
    }

    public int getRepeatMode() {
        return this.repeatMode;
    }

    public SeekParameters getSeekParameters() {
        return this.seekParameters;
    }

    public boolean getShuffleModeEnabled() {
        return this.shuffleModeEnabled;
    }

    public Player$TextComponent getTextComponent() {
        return null;
    }

    public long getTotalBufferedDuration() {
        return C.usToMs(this.playbackInfo.totalBufferedDurationUs);
    }

    public TrackSelector getTrackSelector() {
        return this.trackSelector;
    }

    public Player$VideoComponent getVideoComponent() {
        return null;
    }

    public boolean isLoading() {
        return this.playbackInfo.isLoading;
    }

    public boolean isPlayingAd() {
        return this.playbackInfo.periodId.isAd();
    }

    public void moveMediaItems(int n10, int n11, int n12) {
        int n13;
        Object object;
        int n14;
        int n15 = 1;
        if (n10 >= 0 && n10 <= n11 && n11 <= (n14 = (object = this.mediaSourceHolderSnapshots).size()) && n12 >= 0) {
            n14 = n15;
        } else {
            n14 = 0;
            object = null;
        }
        Assertions.checkArgument(n14 != 0);
        object = this.getCurrentTimeline();
        this.pendingOperationAcks = n13 = this.pendingOperationAcks + n15;
        n15 = this.mediaSourceHolderSnapshots.size();
        n13 = n11 - n10;
        n12 = Math.min(n12, n15 -= n13);
        Util.moveItems(this.mediaSourceHolderSnapshots, n10, n11, n12);
        Object object2 = this.createMaskingTimeline();
        PlaybackInfo playbackInfo = this.playbackInfo;
        object = this.getPeriodPositionAfterTimelineChanged((Timeline)object, (Timeline)object2);
        PlaybackInfo playbackInfo2 = this.maskTimelineAndPosition(playbackInfo, (Timeline)object2, (Pair)object);
        object2 = this.internalPlayer;
        object = this.shuffleOrder;
        ((ExoPlayerImplInternal)object2).moveMediaSources(n10, n11, n12, (ShuffleOrder)object);
        this.updatePlaybackInfo(playbackInfo2, false, 4, 0, 1, false);
    }

    public void prepare() {
        int n10;
        PlaybackInfo playbackInfo = this.playbackInfo;
        int n11 = playbackInfo.playbackState;
        int n12 = 1;
        if (n11 != n12) {
            return;
        }
        playbackInfo = playbackInfo.copyWithPlaybackError(null);
        Timeline timeline = playbackInfo.timeline;
        n11 = (int)(timeline.isEmpty() ? 1 : 0);
        n11 = n11 != 0 ? 4 : 2;
        PlaybackInfo playbackInfo2 = playbackInfo.copyWithPlaybackState(n11);
        this.pendingOperationAcks = n10 = this.pendingOperationAcks + n12;
        this.internalPlayer.prepare();
        this.updatePlaybackInfo(playbackInfo2, false, 4, 1, 1, false);
    }

    public void prepare(MediaSource mediaSource) {
        this.setMediaSource(mediaSource);
        this.prepare();
    }

    public void prepare(MediaSource mediaSource, boolean bl2, boolean bl3) {
        this.setMediaSource(mediaSource, bl2);
        this.prepare();
    }

    public void release() {
        long l10;
        int n10;
        Object object = Integer.toHexString(System.identityHashCode(this));
        Object object2 = Util.DEVICE_DEBUG_INFO;
        Object object3 = ExoPlayerLibraryInfo.registeredModules();
        int n11 = String.valueOf(object).length() + 36;
        int n12 = String.valueOf(object2).length();
        n11 += n12;
        n12 = String.valueOf(object3).length();
        StringBuilder stringBuilder = new StringBuilder(n11 += n12);
        String string2 = "Release ";
        stringBuilder.append(string2);
        stringBuilder.append((String)object);
        stringBuilder.append(" [");
        stringBuilder.append("ExoPlayerLib/2.13.2");
        object = "] [";
        stringBuilder.append((String)object);
        stringBuilder.append((String)object2);
        stringBuilder.append((String)object);
        stringBuilder.append((String)object3);
        stringBuilder.append("]");
        object = stringBuilder.toString();
        object2 = TAG;
        Log.i((String)object2, (String)object);
        object = this.internalPlayer;
        boolean bl2 = ((ExoPlayerImplInternal)object).release();
        if (!bl2) {
            object = this.listeners;
            n10 = 11;
            object3 = q.a;
            ((ListenerSet)object).sendEvent(n10, (ListenerSet$Event)object3);
        }
        this.listeners.release();
        object = this.playbackInfoUpdateHandler;
        n10 = 0;
        object2 = null;
        object.removeCallbacksAndMessages(null);
        object = this.analyticsCollector;
        if (object != null) {
            object2 = this.bandwidthMeter;
            object2.removeEventListener((BandwidthMeter$EventListener)object);
        }
        this.playbackInfo = object = this.playbackInfo.copyWithPlaybackState(1);
        object2 = ((PlaybackInfo)object).periodId;
        this.playbackInfo = object = ((PlaybackInfo)object).copyWithLoadingMediaPeriodId((MediaSource$MediaPeriodId)object2);
        ((PlaybackInfo)object).bufferedPositionUs = l10 = ((PlaybackInfo)object).positionUs;
        this.playbackInfo.totalBufferedDurationUs = 0L;
    }

    public void removeListener(Player$EventListener player$EventListener) {
        this.listeners.remove(player$EventListener);
    }

    public void removeMediaItems(int n10, int n11) {
        PlaybackInfo playbackInfo = this.removeMediaItemsInternal(n10, n11);
        this.updatePlaybackInfo(playbackInfo, false, 4, 0, 1, false);
    }

    public void retry() {
        this.prepare();
    }

    public void seekTo(int n10, long l10) {
        int n11;
        Timeline timeline = this.playbackInfo.timeline;
        if (n10 >= 0 && ((n11 = timeline.isEmpty()) != 0 || n10 < (n11 = timeline.getWindowCount()))) {
            n11 = this.pendingOperationAcks;
            int n12 = 1;
            this.pendingOperationAcks = n11 += n12;
            n11 = (int)(this.isPlayingAd() ? 1 : 0);
            if (n11 != 0) {
                Log.w(TAG, "seekTo ignored because an ad is playing");
                PlaybackInfo playbackInfo = this.playbackInfo;
                ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = new ExoPlayerImplInternal$PlaybackInfoUpdate(playbackInfo);
                exoPlayerImplInternal$PlaybackInfoUpdate.incrementPendingOperationAcks(n12);
                this.playbackInfoUpdateListener.onPlaybackInfoUpdate(exoPlayerImplInternal$PlaybackInfoUpdate);
                return;
            }
            n11 = this.getPlaybackState();
            if (n11 != n12) {
                n12 = 2;
            }
            Object object = this.playbackInfo.copyWithPlaybackState(n12);
            Pair pair = this.getPeriodPositionOrMaskWindowPosition(timeline, n10, l10);
            PlaybackInfo playbackInfo = this.maskTimelineAndPosition((PlaybackInfo)object, timeline, pair);
            object = this.internalPlayer;
            l10 = C.msToUs(l10);
            ((ExoPlayerImplInternal)object).seekTo(timeline, n10, l10);
            this.updatePlaybackInfo(playbackInfo, true, 1, 0, 1, true);
            return;
        }
        IllegalSeekPositionException illegalSeekPositionException = new IllegalSeekPositionException(timeline, n10, l10);
        throw illegalSeekPositionException;
    }

    public void setForegroundMode(boolean bl2) {
        boolean bl3 = this.foregroundMode;
        if (bl3 != bl2) {
            this.foregroundMode = bl2;
            Object object = this.internalPlayer;
            if (!(bl2 = ((ExoPlayerImplInternal)object).setForegroundMode(bl2))) {
                bl2 = false;
                int n10 = 2;
                object = new ExoTimeoutException(n10);
                object = ExoPlaybackException.createForRenderer((Exception)object);
                this.stop(false, (ExoPlaybackException)object);
            }
        }
    }

    public void setMediaItems(List list, int n10, long l10) {
        list = this.createMediaSources(list);
        this.setMediaSources(list, n10, l10);
    }

    public void setMediaItems(List list, boolean bl2) {
        list = this.createMediaSources(list);
        this.setMediaSources(list, bl2);
    }

    public void setMediaSource(MediaSource object) {
        object = Collections.singletonList(object);
        this.setMediaSources((List)object);
    }

    public void setMediaSource(MediaSource object, long l10) {
        object = Collections.singletonList(object);
        this.setMediaSources((List)object, 0, l10);
    }

    public void setMediaSource(MediaSource object, boolean bl2) {
        object = Collections.singletonList(object);
        this.setMediaSources((List)object, bl2);
    }

    public void setMediaSources(List list) {
        this.setMediaSources(list, true);
    }

    public void setMediaSources(List list, int n10, long l10) {
        this.setMediaSourcesInternal(list, n10, l10, false);
    }

    public void setMediaSources(List list, boolean bl2) {
        this.setMediaSourcesInternal(list, -1, -9223372036854775807L, bl2);
    }

    public void setPauseAtEndOfMediaItems(boolean bl2) {
        boolean bl3 = this.pauseAtEndOfMediaItems;
        if (bl3 == bl2) {
            return;
        }
        this.pauseAtEndOfMediaItems = bl2;
        this.internalPlayer.setPauseAtEndOfWindow(bl2);
    }

    public void setPlayWhenReady(boolean bl2) {
        this.setPlayWhenReady(bl2, 0, 1);
    }

    public void setPlayWhenReady(boolean n10, int n11, int n12) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        int n13 = playbackInfo.playWhenReady;
        if (n13 == n10 && (n13 = playbackInfo.playbackSuppressionReason) == n11) {
            return;
        }
        this.pendingOperationAcks = n13 = this.pendingOperationAcks + 1;
        PlaybackInfo playbackInfo2 = playbackInfo.copyWithPlayWhenReady(n10 != 0, n11);
        this.internalPlayer.setPlayWhenReady(n10 != 0, n11);
        this.updatePlaybackInfo(playbackInfo2, false, 4, 0, n12, false);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2;
        int n10;
        if (playbackParameters == null) {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        if ((n10 = (playbackParameters2 = this.playbackInfo.playbackParameters).equals(playbackParameters)) != 0) {
            return;
        }
        PlaybackInfo playbackInfo = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        this.pendingOperationAcks = n10 = this.pendingOperationAcks + 1;
        this.internalPlayer.setPlaybackParameters(playbackParameters);
        this.updatePlaybackInfo(playbackInfo, false, 4, 0, 1, false);
    }

    public void setRepeatMode(int n10) {
        int n11 = this.repeatMode;
        if (n11 != n10) {
            this.repeatMode = n10;
            this.internalPlayer.setRepeatMode(n10);
            ListenerSet listenerSet = this.listeners;
            int n12 = 9;
            e e10 = new e(n10);
            listenerSet.sendEvent(n12, e10);
        }
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        Object object;
        boolean bl2;
        if (seekParameters == null) {
            seekParameters = SeekParameters.DEFAULT;
        }
        if (!(bl2 = ((SeekParameters)(object = this.seekParameters)).equals(seekParameters))) {
            this.seekParameters = seekParameters;
            object = this.internalPlayer;
            ((ExoPlayerImplInternal)object).setSeekParameters(seekParameters);
        }
    }

    public void setShuffleModeEnabled(boolean bl2) {
        boolean bl3 = this.shuffleModeEnabled;
        if (bl3 != bl2) {
            this.shuffleModeEnabled = bl2;
            this.internalPlayer.setShuffleModeEnabled(bl2);
            ListenerSet listenerSet = this.listeners;
            int n10 = 10;
            h h10 = new h(bl2);
            listenerSet.sendEvent(n10, h10);
        }
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        int n10;
        Timeline timeline = this.createMaskingTimeline();
        PlaybackInfo playbackInfo = this.playbackInfo;
        int n11 = this.getCurrentWindowIndex();
        long l10 = this.getCurrentPosition();
        Pair pair = this.getPeriodPositionOrMaskWindowPosition(timeline, n11, l10);
        PlaybackInfo playbackInfo2 = this.maskTimelineAndPosition(playbackInfo, timeline, pair);
        this.pendingOperationAcks = n10 = this.pendingOperationAcks + 1;
        this.shuffleOrder = shuffleOrder;
        this.internalPlayer.setShuffleOrder(shuffleOrder);
        this.updatePlaybackInfo(playbackInfo2, false, 4, 0, 1, false);
    }

    public void stop(boolean bl2) {
        this.stop(bl2, null);
    }

    /*
     * WARNING - void declaration
     */
    public void stop(boolean bl2, ExoPlaybackException exoPlaybackException) {
        int n10;
        void var2_4;
        PlaybackInfo playbackInfo;
        int n11;
        if (bl2) {
            boolean bl3 = false;
            n11 = this.mediaSourceHolderSnapshots.size();
            playbackInfo = this.removeMediaItemsInternal(0, n11);
            n11 = 0;
            Object var5_7 = null;
            playbackInfo = playbackInfo.copyWithPlaybackError(null);
        } else {
            long l10;
            playbackInfo = this.playbackInfo;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = playbackInfo.periodId;
            playbackInfo = playbackInfo.copyWithLoadingMediaPeriodId(mediaSource$MediaPeriodId);
            playbackInfo.bufferedPositionUs = l10 = playbackInfo.positionUs;
            playbackInfo.totalBufferedDurationUs = l10 = 0L;
        }
        n11 = 1;
        playbackInfo = playbackInfo.copyWithPlaybackState(n11);
        if (var2_4 != null) {
            playbackInfo = playbackInfo.copyWithPlaybackError((ExoPlaybackException)var2_4);
        }
        PlaybackInfo playbackInfo2 = playbackInfo;
        this.pendingOperationAcks = n10 = this.pendingOperationAcks + n11;
        this.internalPlayer.stop();
        this.updatePlaybackInfo(playbackInfo2, false, 4, 0, 1, false);
    }
}

