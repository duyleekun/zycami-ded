/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 *  android.util.SparseArray
 *  android.view.Surface
 */
package com.google.android.exoplayer2.analytics;

import android.os.Looper;
import android.util.SparseArray;
import android.view.Surface;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsCollector$MediaPeriodQueueTracker;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.analytics.AnalyticsListener$EventTime;
import com.google.android.exoplayer2.analytics.AnalyticsListener$Events;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.LoadEventInfo;
import com.google.android.exoplayer2.source.MediaLoadData;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSourceEventListener;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.BandwidthMeter$EventListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.ListenerSet;
import com.google.android.exoplayer2.util.ListenerSet$Event;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import d.h.a.a.e0.a;
import d.h.a.a.e0.a0;
import d.h.a.a.e0.a1;
import d.h.a.a.e0.b;
import d.h.a.a.e0.b0;
import d.h.a.a.e0.b1;
import d.h.a.a.e0.c;
import d.h.a.a.e0.c0;
import d.h.a.a.e0.c1;
import d.h.a.a.e0.d;
import d.h.a.a.e0.d0;
import d.h.a.a.e0.d1;
import d.h.a.a.e0.e;
import d.h.a.a.e0.e0;
import d.h.a.a.e0.e1;
import d.h.a.a.e0.f;
import d.h.a.a.e0.f0;
import d.h.a.a.e0.g;
import d.h.a.a.e0.g0;
import d.h.a.a.e0.h;
import d.h.a.a.e0.h0;
import d.h.a.a.e0.i;
import d.h.a.a.e0.i0;
import d.h.a.a.e0.j;
import d.h.a.a.e0.j0;
import d.h.a.a.e0.k;
import d.h.a.a.e0.k0;
import d.h.a.a.e0.l;
import d.h.a.a.e0.l0;
import d.h.a.a.e0.m;
import d.h.a.a.e0.m0;
import d.h.a.a.e0.n;
import d.h.a.a.e0.n0;
import d.h.a.a.e0.o;
import d.h.a.a.e0.o0;
import d.h.a.a.e0.p;
import d.h.a.a.e0.p0;
import d.h.a.a.e0.q;
import d.h.a.a.e0.q0;
import d.h.a.a.e0.r;
import d.h.a.a.e0.r0;
import d.h.a.a.e0.s;
import d.h.a.a.e0.s0;
import d.h.a.a.e0.t;
import d.h.a.a.e0.t0;
import d.h.a.a.e0.u;
import d.h.a.a.e0.u0;
import d.h.a.a.e0.v;
import d.h.a.a.e0.v0;
import d.h.a.a.e0.w;
import d.h.a.a.e0.w0;
import d.h.a.a.e0.x;
import d.h.a.a.e0.x0;
import d.h.a.a.e0.y;
import d.h.a.a.e0.y0;
import d.h.a.a.e0.z;
import d.h.a.a.e0.z0;
import java.io.IOException;
import java.util.AbstractCollection;
import java.util.List;

public class AnalyticsCollector
implements Player$EventListener,
AudioRendererEventListener,
VideoRendererEventListener,
MediaSourceEventListener,
BandwidthMeter$EventListener,
DrmSessionEventListener {
    private final Clock clock;
    private final SparseArray eventTimes;
    private boolean isSeeking;
    private ListenerSet listeners;
    private final AnalyticsCollector$MediaPeriodQueueTracker mediaPeriodQueueTracker;
    private final Timeline$Period period;
    private Player player;
    private final Timeline$Window window;

    public AnalyticsCollector(Clock object) {
        Object object2 = (Clock)Assertions.checkNotNull(object);
        this.clock = object2;
        Looper looper = Util.getCurrentOrMainLooper();
        a a10 = a.a;
        l l10 = l.a;
        this.listeners = object2 = new ListenerSet(looper, (Clock)object, a10, l10);
        this.period = object = new Timeline$Period();
        this.window = object2 = new Timeline$Window();
        this.mediaPeriodQueueTracker = object2 = new AnalyticsCollector$MediaPeriodQueueTracker((Timeline$Period)object);
        object = new SparseArray();
        this.eventTimes = object;
    }

    public static /* synthetic */ void A(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadStarted(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
    }

    public static /* synthetic */ void B(AnalyticsListener$EventTime analyticsListener$EventTime, MediaItem mediaItem, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onMediaItemTransition(analyticsListener$EventTime, mediaItem, n10);
    }

    public static /* synthetic */ void C(AnalyticsListener$EventTime analyticsListener$EventTime, Metadata metadata, AnalyticsListener analyticsListener) {
        analyticsListener.onMetadata(analyticsListener$EventTime, metadata);
    }

    public static /* synthetic */ void D(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onPlayWhenReadyChanged(analyticsListener$EventTime, bl2, n10);
    }

    public static /* synthetic */ void E(AnalyticsListener$EventTime analyticsListener$EventTime, PlaybackParameters playbackParameters, AnalyticsListener analyticsListener) {
        analyticsListener.onPlaybackParametersChanged(analyticsListener$EventTime, playbackParameters);
    }

    public static /* synthetic */ void F(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onPlaybackStateChanged(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void G(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onPlaybackSuppressionReasonChanged(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void H(AnalyticsListener$EventTime analyticsListener$EventTime, ExoPlaybackException exoPlaybackException, AnalyticsListener analyticsListener) {
        analyticsListener.onPlayerError(analyticsListener$EventTime, exoPlaybackException);
    }

    public static /* synthetic */ void I(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onPlayerStateChanged(analyticsListener$EventTime, bl2, n10);
    }

    public static /* synthetic */ void J(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onPositionDiscontinuity(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void K(AnalyticsListener$EventTime analyticsListener$EventTime, Surface surface, AnalyticsListener analyticsListener) {
        analyticsListener.onRenderedFirstFrame(analyticsListener$EventTime, surface);
    }

    public static /* synthetic */ void L(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onRepeatModeChanged(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void M(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onSeekProcessed(analyticsListener$EventTime);
    }

    public static /* synthetic */ void N(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, AnalyticsListener analyticsListener) {
        analyticsListener.onShuffleModeChanged(analyticsListener$EventTime, bl2);
    }

    public static /* synthetic */ void O(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, AnalyticsListener analyticsListener) {
        analyticsListener.onSkipSilenceEnabledChanged(analyticsListener$EventTime, bl2);
    }

    public static /* synthetic */ void P(AnalyticsListener$EventTime analyticsListener$EventTime, List list, AnalyticsListener analyticsListener) {
        analyticsListener.onStaticMetadataChanged(analyticsListener$EventTime, list);
    }

    public static /* synthetic */ void Q(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, AnalyticsListener analyticsListener) {
        analyticsListener.onSurfaceSizeChanged(analyticsListener$EventTime, n10, n11);
    }

    public static /* synthetic */ void R(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onTimelineChanged(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void S(AnalyticsListener$EventTime analyticsListener$EventTime, TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray, AnalyticsListener analyticsListener) {
        analyticsListener.onTracksChanged(analyticsListener$EventTime, trackGroupArray, trackSelectionArray);
    }

    public static /* synthetic */ void T(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData mediaLoadData, AnalyticsListener analyticsListener) {
        analyticsListener.onUpstreamDiscarded(analyticsListener$EventTime, mediaLoadData);
    }

    public static /* synthetic */ void U(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderInitialized(analyticsListener$EventTime, string2, l10);
        analyticsListener.onDecoderInitialized(analyticsListener$EventTime, 2, string2, l10);
    }

    public static /* synthetic */ void V(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDecoderReleased(analyticsListener$EventTime, string2);
    }

    public static /* synthetic */ void W(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoDisabled(analyticsListener$EventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(analyticsListener$EventTime, 2, decoderCounters);
    }

    public static /* synthetic */ void X(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoEnabled(analyticsListener$EventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(analyticsListener$EventTime, 2, decoderCounters);
    }

    public static /* synthetic */ void Y(AnalyticsListener$EventTime analyticsListener$EventTime, long l10, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoFrameProcessingOffset(analyticsListener$EventTime, l10, n10);
    }

    public static /* synthetic */ void Z(AnalyticsListener$EventTime analyticsListener$EventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoInputFormatChanged(analyticsListener$EventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(analyticsListener$EventTime, 2, format);
    }

    public static /* synthetic */ void a(AnalyticsListener analyticsListener, AnalyticsListener$Events analyticsListener$Events) {
    }

    public static /* synthetic */ void a0(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, int n11, int n12, float f10, AnalyticsListener analyticsListener) {
        analyticsListener.onVideoSizeChanged(analyticsListener$EventTime, n10, n11, n12, f10);
    }

    public static /* synthetic */ void b(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onSeekStarted(analyticsListener$EventTime);
    }

    public static /* synthetic */ void b0(AnalyticsListener$EventTime analyticsListener$EventTime, float f10, AnalyticsListener analyticsListener) {
        analyticsListener.onVolumeChanged(analyticsListener$EventTime, f10);
    }

    public static /* synthetic */ void c(AnalyticsListener$EventTime analyticsListener$EventTime, AudioAttributes audioAttributes, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioAttributesChanged(analyticsListener$EventTime, audioAttributes);
    }

    public static /* synthetic */ void c0(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onPlayerReleased(analyticsListener$EventTime);
    }

    public static /* synthetic */ void d(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, long l10, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderInitialized(analyticsListener$EventTime, string2, l10);
        analyticsListener.onDecoderInitialized(analyticsListener$EventTime, 1, string2, l10);
    }

    private /* synthetic */ void d0(Player player, AnalyticsListener analyticsListener, AnalyticsListener$Events analyticsListener$Events) {
        SparseArray sparseArray = this.eventTimes;
        analyticsListener$Events.setEventTimes(sparseArray);
        analyticsListener.onEvents(player, analyticsListener$Events);
    }

    public static /* synthetic */ void e(AnalyticsListener$EventTime analyticsListener$EventTime, String string2, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDecoderReleased(analyticsListener$EventTime, string2);
    }

    public static /* synthetic */ void f(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioDisabled(analyticsListener$EventTime, decoderCounters);
        analyticsListener.onDecoderDisabled(analyticsListener$EventTime, 1, decoderCounters);
    }

    public static /* synthetic */ void g(AnalyticsListener$EventTime analyticsListener$EventTime, DecoderCounters decoderCounters, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioEnabled(analyticsListener$EventTime, decoderCounters);
        analyticsListener.onDecoderEnabled(analyticsListener$EventTime, 1, decoderCounters);
    }

    private AnalyticsListener$EventTime generateEventTime(MediaSource$MediaPeriodId object) {
        int n10;
        Assertions.checkNotNull(this.player);
        int n11 = 0;
        Object object2 = null;
        Timeline timeline = object == null ? null : this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline((MediaSource$MediaPeriodId)object);
        if (object != null && timeline != null) {
            object2 = ((MediaPeriodId)object).periodUid;
            Timeline$Period timeline$Period = this.period;
            n11 = timeline.getPeriodByUid((Object)object2, (Timeline$Period)timeline$Period).windowIndex;
            return this.generateEventTime(timeline, n11, (MediaSource$MediaPeriodId)object);
        }
        object = this.player;
        int n12 = object.getCurrentWindowIndex();
        if (n12 < (n10 = (timeline = this.player.getCurrentTimeline()).getWindowCount())) {
            n10 = 1;
        } else {
            n10 = 0;
            Object var5_6 = null;
        }
        if (n10 == 0) {
            timeline = Timeline.EMPTY;
        }
        return this.generateEventTime(timeline, n12, null);
    }

    private AnalyticsListener$EventTime generateLoadingMediaPeriodEventTime() {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodQueueTracker.getLoadingMediaPeriod();
        return this.generateEventTime(mediaSource$MediaPeriodId);
    }

    private AnalyticsListener$EventTime generateMediaPeriodEventTime(int n10, MediaSource$MediaPeriodId object) {
        Object object2 = this.player;
        Assertions.checkNotNull(object2);
        boolean bl2 = true;
        if (object != null) {
            AnalyticsListener$EventTime analyticsListener$EventTime;
            Timeline timeline = this.mediaPeriodQueueTracker.getMediaPeriodIdTimeline((MediaSource$MediaPeriodId)object);
            if (timeline == null) {
                bl2 = false;
                object2 = null;
            }
            if (bl2) {
                analyticsListener$EventTime = this.generateEventTime((MediaSource$MediaPeriodId)object);
            } else {
                object2 = Timeline.EMPTY;
                analyticsListener$EventTime = this.generateEventTime((Timeline)object2, n10, (MediaSource$MediaPeriodId)object);
            }
            return analyticsListener$EventTime;
        }
        object = this.player.getCurrentTimeline();
        int n11 = ((Timeline)object).getWindowCount();
        if (n10 >= n11) {
            bl2 = false;
            object2 = null;
        }
        if (!bl2) {
            object = Timeline.EMPTY;
        }
        return this.generateEventTime((Timeline)object, n10, null);
    }

    private AnalyticsListener$EventTime generatePlayingMediaPeriodEventTime() {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodQueueTracker.getPlayingMediaPeriod();
        return this.generateEventTime(mediaSource$MediaPeriodId);
    }

    private AnalyticsListener$EventTime generateReadingMediaPeriodEventTime() {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodQueueTracker.getReadingMediaPeriod();
        return this.generateEventTime(mediaSource$MediaPeriodId);
    }

    public static /* synthetic */ void h(AnalyticsListener$EventTime analyticsListener$EventTime, Format format, DecoderReuseEvaluation decoderReuseEvaluation, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioInputFormatChanged(analyticsListener$EventTime, format, decoderReuseEvaluation);
        analyticsListener.onDecoderInputFormatChanged(analyticsListener$EventTime, 1, format);
    }

    public static /* synthetic */ void i(AnalyticsListener$EventTime analyticsListener$EventTime, long l10, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioPositionAdvancing(analyticsListener$EventTime, l10);
    }

    public static /* synthetic */ void j(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioSessionIdChanged(analyticsListener$EventTime, n10);
    }

    public static /* synthetic */ void k(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioSinkError(analyticsListener$EventTime, exception);
    }

    public static /* synthetic */ void l(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11, AnalyticsListener analyticsListener) {
        analyticsListener.onAudioUnderrun(analyticsListener$EventTime, n10, l10, l11);
    }

    public static /* synthetic */ void m(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, long l11, AnalyticsListener analyticsListener) {
        analyticsListener.onBandwidthEstimate(analyticsListener$EventTime, n10, l10, l11);
    }

    public static /* synthetic */ void n(AnalyticsListener$EventTime analyticsListener$EventTime, MediaLoadData mediaLoadData, AnalyticsListener analyticsListener) {
        analyticsListener.onDownstreamFormatChanged(analyticsListener$EventTime, mediaLoadData);
    }

    public static /* synthetic */ void o(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmKeysLoaded(analyticsListener$EventTime);
    }

    public static /* synthetic */ void p(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmKeysRemoved(analyticsListener$EventTime);
    }

    public static /* synthetic */ void q(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmKeysRestored(analyticsListener$EventTime);
    }

    public static /* synthetic */ void r(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionAcquired(analyticsListener$EventTime);
    }

    public static /* synthetic */ void s(AnalyticsListener$EventTime analyticsListener$EventTime, Exception exception, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionManagerError(analyticsListener$EventTime, exception);
    }

    public static /* synthetic */ void t(AnalyticsListener$EventTime analyticsListener$EventTime, AnalyticsListener analyticsListener) {
        analyticsListener.onDrmSessionReleased(analyticsListener$EventTime);
    }

    public static /* synthetic */ void u(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, long l10, AnalyticsListener analyticsListener) {
        analyticsListener.onDroppedVideoFrames(analyticsListener$EventTime, n10, l10);
    }

    public static /* synthetic */ void v(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, AnalyticsListener analyticsListener) {
        analyticsListener.onIsLoadingChanged(analyticsListener$EventTime, bl2);
    }

    public static /* synthetic */ void w(AnalyticsListener$EventTime analyticsListener$EventTime, boolean bl2, AnalyticsListener analyticsListener) {
        analyticsListener.onIsPlayingChanged(analyticsListener$EventTime, bl2);
    }

    public static /* synthetic */ void x(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadCanceled(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
    }

    public static /* synthetic */ void y(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadCompleted(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
    }

    public static /* synthetic */ void z(AnalyticsListener$EventTime analyticsListener$EventTime, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2, AnalyticsListener analyticsListener) {
        analyticsListener.onLoadError(analyticsListener$EventTime, loadEventInfo, mediaLoadData, iOException, bl2);
    }

    public void addListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.listeners.add(analyticsListener);
    }

    public /* synthetic */ void e0(Player player, AnalyticsListener analyticsListener, AnalyticsListener$Events analyticsListener$Events) {
        this.d0(player, analyticsListener, analyticsListener$Events);
    }

    public final AnalyticsListener$EventTime generateCurrentPlayerMediaPeriodEventTime() {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod();
        return this.generateEventTime(mediaSource$MediaPeriodId);
    }

    /*
     * Unable to fully structure code
     */
    public final AnalyticsListener$EventTime generateEventTime(Timeline var1_1, int var2_2, MediaSource$MediaPeriodId var3_3) {
        block9: {
            var4_4 = this;
            var5_5 = var1_1;
            var6_6 = var2_2;
            var7_7 = var1_1.isEmpty();
            if (var7_7 != 0) {
                var7_7 = 0;
                var8_8 = null;
                var9_9 = null;
            } else {
                var9_9 = var3_3;
            }
            var10_10 = var4_4.clock.elapsedRealtime();
            var8_8 = var4_4.player.getCurrentTimeline();
            var7_7 = var5_5.equals(var8_8);
            var12_11 = 1;
            if (var7_7 != 0 && var6_6 == (var7_7 = (var8_8 = var4_4.player).getCurrentWindowIndex())) {
                var7_7 = var12_11;
            } else {
                var7_7 = 0;
                var8_8 = null;
            }
            var13_12 = 0L;
            if (var9_9 == null || (var15_13 = var9_9.isAd()) == 0) break block9;
            if (var7_7 == 0 || (var7_7 = (var8_8 = var4_4.player).getCurrentAdGroupIndex()) != (var15_13 = var9_9.adGroupIndex) || (var7_7 = (var8_8 = var4_4.player).getCurrentAdIndexInAdGroup()) != (var15_13 = var9_9.adIndexInAdGroup)) {
                var12_11 = 0;
            }
            if (var12_11 != 0) {
                var8_8 = var4_4.player;
                var13_12 = var8_8.getCurrentPosition();
            }
            ** GOTO lbl38
        }
        if (var7_7 != 0) {
            var8_8 = var4_4.player;
            var16_14 = var8_8.getContentPosition();
        } else {
            var7_7 = (int)var1_1.isEmpty();
            if (var7_7 == 0) {
                var8_8 = var4_4.window;
                var8_8 = var5_5.getWindow(var6_6, (Timeline$Window)var8_8);
                var13_12 = var8_8.getDefaultPositionMs();
            }
lbl38:
            // 4 sources

            var16_14 = var13_12;
        }
        var18_15 = var4_4.mediaPeriodQueueTracker.getCurrentPlayerMediaPeriod();
        var20_17 = var4_4.player.getCurrentTimeline();
        var21_18 = var4_4.player.getCurrentWindowIndex();
        var22_19 = var4_4.player.getCurrentPosition();
        var24_20 = var4_4.player.getTotalBufferedDuration();
        var8_8 = var19_16;
        var5_5 = var1_1;
        var6_6 = var2_2;
        var19_16 = new AnalyticsListener$EventTime(var10_10, var1_1, var2_2, var9_9, var16_14, var20_17, var21_18, var18_15, var22_19, var24_20);
        return var19_16;
    }

    public final void notifySeekStarted() {
        boolean bl2 = this.isSeeking;
        if (!bl2) {
            AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
            this.isSeeking = true;
            int n10 = -1;
            y0 y02 = new y0(analyticsListener$EventTime);
            this.sendEvent(analyticsListener$EventTime, n10, y02);
        }
    }

    public final void onAudioAttributesChanged(AudioAttributes audioAttributes) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        s s10 = new s(analyticsListener$EventTime, audioAttributes);
        this.sendEvent(analyticsListener$EventTime, 1016, s10);
    }

    public final void onAudioDecoderInitialized(String string2, long l10, long l11) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        x0 x02 = new x0(analyticsListener$EventTime, string2, l11);
        this.sendEvent(analyticsListener$EventTime, 1009, x02);
    }

    public final void onAudioDecoderReleased(String string2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        f f10 = new f(analyticsListener$EventTime, string2);
        this.sendEvent(analyticsListener$EventTime, 1013, f10);
    }

    public final void onAudioDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generatePlayingMediaPeriodEventTime();
        u u10 = new u(analyticsListener$EventTime, decoderCounters);
        this.sendEvent(analyticsListener$EventTime, 1014, u10);
    }

    public final void onAudioEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        r r10 = new r(analyticsListener$EventTime, decoderCounters);
        this.sendEvent(analyticsListener$EventTime, 1008, r10);
    }

    public final void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        o0 o02 = new o0(analyticsListener$EventTime, format, decoderReuseEvaluation);
        this.sendEvent(analyticsListener$EventTime, 1010, o02);
    }

    public final void onAudioPositionAdvancing(long l10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        b1 b12 = new b1(analyticsListener$EventTime, l10);
        this.sendEvent(analyticsListener$EventTime, 1011, b12);
    }

    public final void onAudioSessionIdChanged(int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        a1 a12 = new a1(analyticsListener$EventTime, n10);
        this.sendEvent(analyticsListener$EventTime, 1015, a12);
    }

    public final void onAudioSinkError(Exception exception) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        g g10 = new g(analyticsListener$EventTime, exception);
        this.sendEvent(analyticsListener$EventTime, 1018, g10);
    }

    public final void onAudioUnderrun(int n10, long l10, long l11) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        c1 c12 = new c1(analyticsListener$EventTime, n10, l10, l11);
        this.sendEvent(analyticsListener$EventTime, 1012, c12);
    }

    public final void onBandwidthSample(int n10, long l10, long l11) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateLoadingMediaPeriodEventTime();
        k k10 = new k(analyticsListener$EventTime, n10, l10, l11);
        this.sendEvent(analyticsListener$EventTime, 1006, k10);
    }

    public final void onDownstreamFormatChanged(int n10, MediaSource$MediaPeriodId object, MediaLoadData mediaLoadData) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new e(analyticsListener$EventTime, mediaLoadData);
        this.sendEvent(analyticsListener$EventTime, 1004, (ListenerSet$Event)object);
    }

    public final void onDrmKeysLoaded(int n10, MediaSource$MediaPeriodId object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new z(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, 1031, (ListenerSet$Event)object);
    }

    public final void onDrmKeysRemoved(int n10, MediaSource$MediaPeriodId object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new f0(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, 1034, (ListenerSet$Event)object);
    }

    public final void onDrmKeysRestored(int n10, MediaSource$MediaPeriodId object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new p(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, 1033, (ListenerSet$Event)object);
    }

    public final void onDrmSessionAcquired(int n10, MediaSource$MediaPeriodId object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new b0(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, 1030, (ListenerSet$Event)object);
    }

    public final void onDrmSessionManagerError(int n10, MediaSource$MediaPeriodId object, Exception exception) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new t(analyticsListener$EventTime, exception);
        this.sendEvent(analyticsListener$EventTime, 1032, (ListenerSet$Event)object);
    }

    public final void onDrmSessionReleased(int n10, MediaSource$MediaPeriodId object) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new m0(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, 1035, (ListenerSet$Event)object);
    }

    public final void onDroppedFrames(int n10, long l10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generatePlayingMediaPeriodEventTime();
        a0 a02 = new a0(analyticsListener$EventTime, n10, l10);
        this.sendEvent(analyticsListener$EventTime, 1023, a02);
    }

    public final void onIsLoadingChanged(boolean bl2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        b b10 = new b(analyticsListener$EventTime, bl2);
        this.sendEvent(analyticsListener$EventTime, 4, b10);
    }

    public void onIsPlayingChanged(boolean bl2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        z0 z02 = new z0(analyticsListener$EventTime, bl2);
        this.sendEvent(analyticsListener$EventTime, 8, z02);
    }

    public final void onLoadCanceled(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new k0(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
        this.sendEvent(analyticsListener$EventTime, 1002, (ListenerSet$Event)object);
    }

    public final void onLoadCompleted(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new x(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
        this.sendEvent(analyticsListener$EventTime, 1001, (ListenerSet$Event)object);
    }

    public final void onLoadError(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData, IOException iOException, boolean bl2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new g0(analyticsListener$EventTime, loadEventInfo, mediaLoadData, iOException, bl2);
        this.sendEvent(analyticsListener$EventTime, 1003, (ListenerSet$Event)object);
    }

    public final void onLoadStarted(int n10, MediaSource$MediaPeriodId object, LoadEventInfo loadEventInfo, MediaLoadData mediaLoadData) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new p0(analyticsListener$EventTime, loadEventInfo, mediaLoadData);
        this.sendEvent(analyticsListener$EventTime, 1000, (ListenerSet$Event)object);
    }

    public final void onMediaItemTransition(MediaItem mediaItem, int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        o o10 = new o(analyticsListener$EventTime, mediaItem, n10);
        this.sendEvent(analyticsListener$EventTime, 1, o10);
    }

    public final void onMetadata(Metadata metadata) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        d d10 = new d(analyticsListener$EventTime, metadata);
        this.sendEvent(analyticsListener$EventTime, 1007, d10);
    }

    public final void onPlayWhenReadyChanged(boolean bl2, int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        v0 v02 = new v0(analyticsListener$EventTime, bl2, n10);
        this.sendEvent(analyticsListener$EventTime, 6, v02);
    }

    public final void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        d0 d02 = new d0(analyticsListener$EventTime, playbackParameters);
        this.sendEvent(analyticsListener$EventTime, 13, d02);
    }

    public final void onPlaybackStateChanged(int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        c0 c02 = new c0(analyticsListener$EventTime, n10);
        this.sendEvent(analyticsListener$EventTime, 5, c02);
    }

    public final void onPlaybackSuppressionReasonChanged(int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        c c10 = new c(analyticsListener$EventTime, n10);
        this.sendEvent(analyticsListener$EventTime, 7, c10);
    }

    public final void onPlayerError(ExoPlaybackException exoPlaybackException) {
        Object object = exoPlaybackException.mediaPeriodId;
        if (object != null) {
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = new MediaSource$MediaPeriodId((MediaPeriodId)object);
            object = this.generateEventTime(mediaSource$MediaPeriodId);
        } else {
            object = this.generateCurrentPlayerMediaPeriodEventTime();
        }
        q q10 = new q((AnalyticsListener$EventTime)object, exoPlaybackException);
        this.sendEvent((AnalyticsListener$EventTime)object, 11, q10);
    }

    public final void onPlayerStateChanged(boolean bl2, int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        u0 u02 = new u0(analyticsListener$EventTime, bl2, n10);
        this.sendEvent(analyticsListener$EventTime, -1, u02);
    }

    public final void onPositionDiscontinuity(int n10) {
        Object object;
        int n11 = 1;
        if (n10 == n11) {
            n11 = 0;
            object = null;
            this.isSeeking = false;
        }
        object = this.mediaPeriodQueueTracker;
        Player player = (Player)Assertions.checkNotNull(this.player);
        ((AnalyticsCollector$MediaPeriodQueueTracker)object).onPositionDiscontinuity(player);
        object = this.generateCurrentPlayerMediaPeriodEventTime();
        s0 s02 = new s0((AnalyticsListener$EventTime)object, n10);
        this.sendEvent((AnalyticsListener$EventTime)object, 12, s02);
    }

    public final void onRenderedFirstFrame(Surface surface) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        w0 w02 = new w0(analyticsListener$EventTime, surface);
        this.sendEvent(analyticsListener$EventTime, 1027, w02);
    }

    public final void onRepeatModeChanged(int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        r0 r02 = new r0(analyticsListener$EventTime, n10);
        this.sendEvent(analyticsListener$EventTime, 9, r02);
    }

    public final void onSeekProcessed() {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        l0 l02 = new l0(analyticsListener$EventTime);
        this.sendEvent(analyticsListener$EventTime, -1, l02);
    }

    public final void onShuffleModeEnabledChanged(boolean bl2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        w w10 = new w(analyticsListener$EventTime, bl2);
        this.sendEvent(analyticsListener$EventTime, 10, w10);
    }

    public final void onSkipSilenceEnabledChanged(boolean bl2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        h0 h02 = new h0(analyticsListener$EventTime, bl2);
        this.sendEvent(analyticsListener$EventTime, 1017, h02);
    }

    public final void onStaticMetadataChanged(List list) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        e0 e02 = new e0(analyticsListener$EventTime, list);
        this.sendEvent(analyticsListener$EventTime, 3, e02);
    }

    public void onSurfaceSizeChanged(int n10, int n11) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        n n12 = new n(analyticsListener$EventTime, n10, n11);
        this.sendEvent(analyticsListener$EventTime, 1029, n12);
    }

    public final void onTimelineChanged(Timeline object, int n10) {
        object = this.mediaPeriodQueueTracker;
        Object object2 = (Player)Assertions.checkNotNull(this.player);
        ((AnalyticsCollector$MediaPeriodQueueTracker)object).onTimelineChanged((Player)object2);
        object = this.generateCurrentPlayerMediaPeriodEventTime();
        object2 = new v((AnalyticsListener$EventTime)object, n10);
        this.sendEvent((AnalyticsListener$EventTime)object, 0, (ListenerSet$Event)object2);
    }

    public final void onTracksChanged(TrackGroupArray trackGroupArray, TrackSelectionArray trackSelectionArray) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        h h10 = new h(analyticsListener$EventTime, trackGroupArray, trackSelectionArray);
        this.sendEvent(analyticsListener$EventTime, 2, h10);
    }

    public final void onUpstreamDiscarded(int n10, MediaSource$MediaPeriodId object, MediaLoadData mediaLoadData) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateMediaPeriodEventTime(n10, (MediaSource$MediaPeriodId)object);
        object = new j0(analyticsListener$EventTime, mediaLoadData);
        this.sendEvent(analyticsListener$EventTime, 1005, (ListenerSet$Event)object);
    }

    public final void onVideoDecoderInitialized(String string2, long l10, long l11) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        m m10 = new m(analyticsListener$EventTime, string2, l11);
        this.sendEvent(analyticsListener$EventTime, 1021, m10);
    }

    public final void onVideoDecoderReleased(String string2) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        i0 i02 = new i0(analyticsListener$EventTime, string2);
        this.sendEvent(analyticsListener$EventTime, 1024, i02);
    }

    public final void onVideoDisabled(DecoderCounters decoderCounters) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generatePlayingMediaPeriodEventTime();
        i i10 = new i(analyticsListener$EventTime, decoderCounters);
        this.sendEvent(analyticsListener$EventTime, 1025, i10);
    }

    public final void onVideoEnabled(DecoderCounters decoderCounters) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        d1 d12 = new d1(analyticsListener$EventTime, decoderCounters);
        this.sendEvent(analyticsListener$EventTime, 1020, d12);
    }

    public final void onVideoFrameProcessingOffset(long l10, int n10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generatePlayingMediaPeriodEventTime();
        q0 q02 = new q0(analyticsListener$EventTime, l10, n10);
        this.sendEvent(analyticsListener$EventTime, 1026, q02);
    }

    public final void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        n0 n02 = new n0(analyticsListener$EventTime, format, decoderReuseEvaluation);
        this.sendEvent(analyticsListener$EventTime, 1022, n02);
    }

    public final void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        j j10 = new j(analyticsListener$EventTime, n10, n11, n12, f10);
        this.sendEvent(analyticsListener$EventTime, 1028, j10);
    }

    public final void onVolumeChanged(float f10) {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateReadingMediaPeriodEventTime();
        t0 t02 = new t0(analyticsListener$EventTime, f10);
        this.sendEvent(analyticsListener$EventTime, 1019, t02);
    }

    public void release() {
        AnalyticsListener$EventTime analyticsListener$EventTime = this.generateCurrentPlayerMediaPeriodEventTime();
        Object object = this.eventTimes;
        int n10 = 1036;
        object.put(n10, (Object)analyticsListener$EventTime);
        object = this.listeners;
        y y10 = new y(analyticsListener$EventTime);
        ((ListenerSet)object).lazyRelease(n10, y10);
    }

    public void removeListener(AnalyticsListener analyticsListener) {
        this.listeners.remove(analyticsListener);
    }

    public final void resetForNewPlaylist() {
    }

    public final void sendEvent(AnalyticsListener$EventTime analyticsListener$EventTime, int n10, ListenerSet$Event listenerSet$Event) {
        this.eventTimes.put(n10, (Object)analyticsListener$EventTime);
        this.listeners.sendEvent(n10, listenerSet$Event);
    }

    public void setPlayer(Player object, Looper looper) {
        boolean bl2;
        Object object2 = this.player;
        if (object2 != null && !(bl2 = ((AbstractCollection)(object2 = AnalyticsCollector$MediaPeriodQueueTracker.access$000(this.mediaPeriodQueueTracker))).isEmpty())) {
            bl2 = false;
            object2 = null;
        } else {
            bl2 = true;
        }
        Assertions.checkState(bl2);
        this.player = object2 = (Player)Assertions.checkNotNull(object);
        object2 = this.listeners;
        e1 e12 = new e1(this, (Player)object);
        this.listeners = object = ((ListenerSet)object2).copy(looper, e12);
    }

    public final void updateMediaPeriodQueueInfo(List list, MediaSource$MediaPeriodId mediaSource$MediaPeriodId) {
        AnalyticsCollector$MediaPeriodQueueTracker analyticsCollector$MediaPeriodQueueTracker = this.mediaPeriodQueueTracker;
        Player player = (Player)Assertions.checkNotNull(this.player);
        analyticsCollector$MediaPeriodQueueTracker.onQueueUpdated(list, mediaSource$MediaPeriodId, player);
    }
}

