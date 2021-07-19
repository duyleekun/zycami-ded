/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.os.SystemClock
 *  android.util.Pair
 */
package com.google.android.exoplayer2;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultMediaClock;
import com.google.android.exoplayer2.DefaultMediaClock$PlaybackParametersListener;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerImplInternal$1;
import com.google.android.exoplayer2.ExoPlayerImplInternal$MediaSourceListUpdateMessage;
import com.google.android.exoplayer2.ExoPlayerImplInternal$MoveMediaItemsMessage;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PendingMessageInfo;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdate;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PlaybackInfoUpdateListener;
import com.google.android.exoplayer2.ExoPlayerImplInternal$PositionUpdateForPlaylistChange;
import com.google.android.exoplayer2.ExoPlayerImplInternal$SeekPosition;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem$LiveConfiguration;
import com.google.android.exoplayer2.MediaPeriodHolder;
import com.google.android.exoplayer2.MediaPeriodInfo;
import com.google.android.exoplayer2.MediaPeriodQueue;
import com.google.android.exoplayer2.MediaSourceList;
import com.google.android.exoplayer2.MediaSourceList$MediaSourceListInfoRefreshListener;
import com.google.android.exoplayer2.PlaybackInfo;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.PlayerMessage$Sender;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.PlaylistTimeline;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RendererCapabilities;
import com.google.android.exoplayer2.RendererConfiguration;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.Timeline$Period;
import com.google.android.exoplayer2.Timeline$Window;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.Metadata$Entry;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaPeriod$Callback;
import com.google.android.exoplayer2.source.MediaPeriodId;
import com.google.android.exoplayer2.source.MediaSource$MediaPeriodId;
import com.google.android.exoplayer2.source.SampleStream;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.ExoTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector$InvalidationListener;
import com.google.android.exoplayer2.trackselection.TrackSelectorResult;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.HandlerWrapper;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.TraceUtil;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Supplier;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableList$Builder;
import d.h.a.a.d0;
import d.h.a.a.x;
import d.h.a.a.y;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ExoPlayerImplInternal
implements Handler.Callback,
MediaPeriod$Callback,
TrackSelector$InvalidationListener,
MediaSourceList$MediaSourceListInfoRefreshListener,
DefaultMediaClock$PlaybackParametersListener,
PlayerMessage$Sender {
    private static final int ACTIVE_INTERVAL_MS = 10;
    private static final int IDLE_INTERVAL_MS = 1000;
    private static final long MIN_RENDERER_SLEEP_DURATION_MS = 2000L;
    private static final int MSG_ADD_MEDIA_SOURCES = 18;
    private static final int MSG_ATTEMPT_ERROR_RECOVERY = 25;
    private static final int MSG_DO_SOME_WORK = 2;
    private static final int MSG_MOVE_MEDIA_SOURCES = 19;
    private static final int MSG_PERIOD_PREPARED = 8;
    private static final int MSG_PLAYBACK_PARAMETERS_CHANGED_INTERNAL = 16;
    private static final int MSG_PLAYLIST_UPDATE_REQUESTED = 22;
    private static final int MSG_PREPARE = 0;
    private static final int MSG_RELEASE = 7;
    private static final int MSG_REMOVE_MEDIA_SOURCES = 20;
    private static final int MSG_SEEK_TO = 3;
    private static final int MSG_SEND_MESSAGE = 14;
    private static final int MSG_SEND_MESSAGE_TO_TARGET_THREAD = 15;
    private static final int MSG_SET_FOREGROUND_MODE = 13;
    private static final int MSG_SET_MEDIA_SOURCES = 17;
    private static final int MSG_SET_OFFLOAD_SCHEDULING_ENABLED = 24;
    private static final int MSG_SET_PAUSE_AT_END_OF_WINDOW = 23;
    private static final int MSG_SET_PLAYBACK_PARAMETERS = 4;
    private static final int MSG_SET_PLAY_WHEN_READY = 1;
    private static final int MSG_SET_REPEAT_MODE = 11;
    private static final int MSG_SET_SEEK_PARAMETERS = 5;
    private static final int MSG_SET_SHUFFLE_ENABLED = 12;
    private static final int MSG_SET_SHUFFLE_ORDER = 21;
    private static final int MSG_SOURCE_CONTINUE_LOADING_REQUESTED = 9;
    private static final int MSG_STOP = 6;
    private static final int MSG_TRACK_SELECTION_INVALIDATED = 10;
    private static final String TAG = "ExoPlayerImplInternal";
    private final long backBufferDurationUs;
    private final BandwidthMeter bandwidthMeter;
    private final Clock clock;
    private boolean deliverPendingMessageAtStartPositionRequired;
    private final TrackSelectorResult emptyTrackSelectorResult;
    private int enabledRendererCount;
    private boolean foregroundMode;
    private final HandlerWrapper handler;
    private final HandlerThread internalPlaybackThread;
    private boolean isRebuffering;
    private final LivePlaybackSpeedControl livePlaybackSpeedControl;
    private final LoadControl loadControl;
    private final DefaultMediaClock mediaClock;
    private final MediaSourceList mediaSourceList;
    private int nextPendingMessageIndexHint;
    private boolean offloadSchedulingEnabled;
    private boolean pauseAtEndOfWindow;
    private ExoPlayerImplInternal$SeekPosition pendingInitialSeekPosition;
    private final ArrayList pendingMessages;
    private boolean pendingPauseAtEndOfPeriod;
    private ExoPlaybackException pendingRecoverableError;
    private final Timeline$Period period;
    private PlaybackInfo playbackInfo;
    private ExoPlayerImplInternal$PlaybackInfoUpdate playbackInfoUpdate;
    private final ExoPlayerImplInternal$PlaybackInfoUpdateListener playbackInfoUpdateListener;
    private final Looper playbackLooper;
    private final MediaPeriodQueue queue;
    private final long releaseTimeoutMs;
    private boolean released;
    private final RendererCapabilities[] rendererCapabilities;
    private long rendererPositionUs;
    private final Renderer[] renderers;
    private int repeatMode;
    private boolean requestForRendererSleep;
    private final boolean retainBackBufferFromKeyframe;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private boolean shouldContinueLoading;
    private boolean shuffleModeEnabled;
    private final TrackSelector trackSelector;
    private final Timeline$Window window;

    public ExoPlayerImplInternal(Renderer[] rendererArray, TrackSelector trackSelector, TrackSelectorResult trackSelectorResult, LoadControl loadControl, BandwidthMeter bandwidthMeter, int n10, boolean bl2, AnalyticsCollector analyticsCollector, SeekParameters seekParameters, LivePlaybackSpeedControl livePlaybackSpeedControl, long l10, boolean n11, Looper looper, Clock clock, ExoPlayerImplInternal$PlaybackInfoUpdateListener exoPlayerImplInternal$PlaybackInfoUpdateListener) {
        int n12;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        Object object = rendererArray;
        Object object2 = trackSelector;
        BandwidthMeter bandwidthMeter2 = bandwidthMeter;
        AnalyticsCollector analyticsCollector2 = analyticsCollector;
        long l11 = l10;
        Clock clock2 = clock;
        Object object3 = exoPlayerImplInternal$PlaybackInfoUpdateListener;
        this.playbackInfoUpdateListener = exoPlayerImplInternal$PlaybackInfoUpdateListener;
        this.renderers = rendererArray;
        this.trackSelector = trackSelector;
        object3 = trackSelectorResult;
        this.emptyTrackSelectorResult = trackSelectorResult;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.repeatMode = n10;
        this.shuffleModeEnabled = bl2;
        this.seekParameters = seekParameters;
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        this.releaseTimeoutMs = l10;
        this.setForegroundModeTimeoutMs = l10;
        int n13 = n11;
        this.pauseAtEndOfWindow = n11;
        this.clock = clock;
        this.backBufferDurationUs = l11 = loadControl.getBackBufferDurationUs();
        this.retainBackBufferFromKeyframe = n13 = loadControl.retainBackBufferFromKeyframe();
        RendererCapabilities[] rendererCapabilitiesArray = PlaybackInfo.createDummy(trackSelectorResult);
        this.playbackInfo = rendererCapabilitiesArray;
        RendererCapabilities[] rendererCapabilitiesArray2 = new ExoPlayerImplInternal$PlaybackInfoUpdate((PlaybackInfo)rendererCapabilitiesArray);
        this.playbackInfoUpdate = rendererCapabilitiesArray2;
        rendererCapabilitiesArray = new RendererCapabilities[rendererArray.length];
        this.rendererCapabilities = rendererCapabilitiesArray;
        rendererCapabilitiesArray = null;
        for (n13 = 0; n13 < (n12 = ((Renderer[])object).length); ++n13) {
            object[n13].setIndex(n13);
            rendererCapabilitiesArray2 = exoPlayerImplInternal.rendererCapabilities;
            rendererCapabilitiesArray2[n13] = object3 = object[n13].getCapabilities();
        }
        super(this, clock2);
        exoPlayerImplInternal.mediaClock = object;
        super();
        exoPlayerImplInternal.pendingMessages = object;
        super();
        exoPlayerImplInternal.window = object;
        super();
        exoPlayerImplInternal.period = object;
        trackSelector.init(this, bandwidthMeter2);
        exoPlayerImplInternal.deliverPendingMessageAtStartPositionRequired = true;
        object2 = looper;
        object = new Handler(looper);
        exoPlayerImplInternal.queue = object2 = new MediaPeriodQueue(analyticsCollector2, (Handler)object);
        exoPlayerImplInternal.mediaSourceList = object2 = new MediaSourceList(this, analyticsCollector2, (Handler)object);
        super("ExoPlayer:Playback", -16);
        exoPlayerImplInternal.internalPlaybackThread = object;
        object.start();
        object = object.getLooper();
        exoPlayerImplInternal.playbackLooper = object;
        object = clock2.createHandler((Looper)object, this);
        exoPlayerImplInternal.handler = object;
    }

    private /* synthetic */ Boolean a() {
        return this.released;
    }

    public static /* synthetic */ boolean access$602(ExoPlayerImplInternal exoPlayerImplInternal, boolean bl2) {
        exoPlayerImplInternal.requestForRendererSleep = bl2;
        return bl2;
    }

    public static /* synthetic */ HandlerWrapper access$700(ExoPlayerImplInternal exoPlayerImplInternal) {
        return exoPlayerImplInternal.handler;
    }

    private void addMediaItemsInternal(ExoPlayerImplInternal$MediaSourceListUpdateMessage object, int n10) {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        int n11 = -1;
        if (n10 == n11) {
            n10 = mediaSourceList.getSize();
        }
        List list = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$300((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
        object = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$400((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
        object = mediaSourceList.addMediaSources(n10, list, (ShuffleOrder)object);
        this.handleMediaSourceListInfoRefreshed((Timeline)object);
    }

    private void attemptErrorRecovery(ExoPlaybackException exoPlaybackException) {
        boolean bl2 = exoPlaybackException.isRecoverable;
        boolean bl3 = true;
        if (bl2 && (bl2 = exoPlaybackException.type) == bl3) {
            bl2 = bl3;
        } else {
            bl2 = false;
            Object var4_4 = null;
        }
        Assertions.checkArgument(bl2);
        try {
            this.seekToCurrentPosition(bl3);
            return;
        }
        catch (Exception exception) {
            exoPlaybackException.addSuppressed(exception);
            throw exoPlaybackException;
        }
    }

    private /* synthetic */ void c(PlayerMessage playerMessage) {
        try {
            this.deliverMessage(playerMessage);
            return;
        }
        catch (ExoPlaybackException exoPlaybackException) {
            Log.e(TAG, "Unexpected error delivering message on external thread.", exoPlaybackException);
            RuntimeException runtimeException = new RuntimeException(exoPlaybackException);
            throw runtimeException;
        }
    }

    private void deliverMessage(PlayerMessage playerMessage) {
        boolean bl2 = playerMessage.isCanceled();
        if (bl2) {
            return;
        }
        bl2 = true;
        try {
            PlayerMessage$Target playerMessage$Target = playerMessage.getTarget();
            int n10 = playerMessage.getType();
            Object object = playerMessage.getPayload();
            playerMessage$Target.handleMessage(n10, object);
            return;
        }
        finally {
            playerMessage.markAsProcessed(bl2);
        }
    }

    private void disableRenderer(Renderer renderer) {
        int n10;
        boolean bl2 = ExoPlayerImplInternal.isRendererEnabled(renderer);
        if (!bl2) {
            return;
        }
        this.mediaClock.onRendererDisabled(renderer);
        this.ensureStopped(renderer);
        renderer.disable();
        this.enabledRendererCount = n10 = this.enabledRendererCount + -1;
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void doSomeWork() {
        block35: {
            block36: {
                var1_1 = this;
                var2_2 = this.clock;
                var3_3 = var2_2.uptimeMillis();
                this.updatePeriods();
                var5_4 = this.playbackInfo;
                var6_5 = var5_4.playbackState;
                var7_6 = 1;
                if (var6_5 == var7_6 || var6_5 == (var8_7 = 4)) break block35;
                var5_4 = this.queue.getPlayingPeriod();
                var9_8 = 10;
                if (var5_4 == null) {
                    this.scheduleNextWork(var3_3, var9_8);
                    return;
                }
                var11_9 = "doSomeWork";
                TraceUtil.beginSection((String)var11_9);
                this.updatePlaybackPositions();
                var12_10 = var5_4.prepared;
                var13_11 = 1000L;
                if (var12_10 != 0) {
                    var15_12 = SystemClock.elapsedRealtime() * var13_11;
                    var11_9 = var5_4.mediaPeriod;
                    var17_13 = this.playbackInfo;
                    var13_11 = var17_13.positionUs;
                    var9_8 = this.backBufferDurationUs;
                    var18_14 /* !! */  = this.retainBackBufferFromKeyframe;
                    var11_9.discardBuffer(var13_11 -= var9_8, (boolean)var18_14 /* !! */ );
                    var19_15 = var7_6;
                    var12_10 = var7_6;
                    var20_16 = null;
                    for (var18_14 /* !! */  = 0; var18_14 /* !! */  < (var22_18 = ((Renderer[])(var21_17 = var1_1.renderers)).length); ++var18_14 /* !! */ ) {
                        var22_18 = (int)ExoPlayerImplInternal.isRendererEnabled((Renderer)(var21_17 = var21_17[var18_14 /* !! */ ]));
                        if (var22_18 != 0) {
                            var23_19 = var1_1.rendererPositionUs;
                            var21_17.render(var23_19, var15_12);
                            if (var19_15 != 0 && (var25_20 = (int)var21_17.isEnded()) != 0) {
                                var19_15 = 1;
                            } else {
                                var19_15 = 0;
                                var26_21 = null;
                            }
                            var27_22 = var5_4.sampleStreams[var18_14 /* !! */ ];
                            var28_23 = var21_17.getStream();
                            if (var27_22 != var28_23) {
                                var25_20 = 1;
                            } else {
                                var25_20 = 0;
                                var27_22 = null;
                            }
                            if (var25_20 == 0 && (var7_6 = (int)var21_17.hasReadStreamToEnd()) != 0) {
                                var7_6 = 1;
                            } else {
                                var7_6 = 0;
                                var28_23 = null;
                            }
                            if (var25_20 == 0 && var7_6 == 0 && (var25_20 = (int)var21_17.isReady()) == 0 && (var25_20 = (int)var21_17.isEnded()) == 0) {
                                var25_20 = 0;
                                var27_22 = null;
                            } else {
                                var25_20 = 1;
                            }
                            if (var12_10 != 0 && var25_20 != 0) {
                                var12_10 = 1;
                            } else {
                                var12_10 = 0;
                                var11_9 = null;
                            }
                            if (var25_20 == 0) {
                                var21_17.maybeThrowStreamError();
                            }
                        }
                        var7_6 = 1;
                    }
                } else {
                    var27_22 = var5_4.mediaPeriod;
                    var27_22.maybeThrowPrepareError();
                    var19_15 = 1;
                    var12_10 = 1;
                }
                var27_22 = var5_4.info;
                var23_19 = var27_22.durationUs;
                if (var19_15 == 0 || (var18_14 /* !! */  = var5_4.prepared) == 0) ** GOTO lbl-1000
                var9_8 = -9223372036854775807L;
                cfr_temp_0 = var23_19 - var9_8;
                var18_14 /* !! */  = (int)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                if (var18_14 /* !! */  == 0) ** GOTO lbl-1000
                var20_16 = var1_1.playbackInfo;
                var9_8 = var20_16.positionUs;
                cfr_temp_1 = var23_19 - var9_8;
                var25_20 = (int)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var25_20 <= 0) lbl-1000:
                // 2 sources

                {
                    var25_20 = 1;
                } else lbl-1000:
                // 2 sources

                {
                    var25_20 = 0;
                    var27_22 = null;
                }
                if (var25_20 != 0 && (var7_6 = (int)var1_1.pendingPauseAtEndOfPeriod) != 0) {
                    var1_1.pendingPauseAtEndOfPeriod = false;
                    var28_23 = var1_1.playbackInfo;
                    var7_6 = var28_23.playbackSuppressionReason;
                    var18_14 /* !! */  = 5;
                    var1_1.setPlayWhenReadyInternal(false, var7_6, false, var18_14 /* !! */ );
                }
                var7_6 = 3;
                if (var25_20 == 0) ** GOTO lbl-1000
                var27_22 = var5_4.info;
                var25_20 = var27_22.isFinal;
                if (var25_20 != 0) {
                    var1_1.setState(var8_7);
                    this.stopRenderers();
                } else lbl-1000:
                // 2 sources

                {
                    var27_22 = var1_1.playbackInfo;
                    var25_20 = var27_22.playbackState;
                    var18_14 /* !! */  = 2;
                    if (var25_20 == var18_14 /* !! */  && (var25_20 = (int)var1_1.shouldTransitionToReadyState((boolean)var12_10)) != 0) {
                        var1_1.setState(var7_6);
                        var27_22 = null;
                        var1_1.pendingRecoverableError = null;
                        var25_20 = (int)this.shouldPlayWhenReady();
                        if (var25_20 != 0) {
                            this.startRenderers();
                        }
                    } else {
                        var27_22 = var1_1.playbackInfo;
                        var25_20 = var27_22.playbackState;
                        if (var25_20 == var7_6 && !((var25_20 = var1_1.enabledRendererCount) != 0 ? var12_10 != 0 : (var25_20 = (int)this.isTimelineReady()) != 0)) {
                            var25_20 = (int)this.shouldPlayWhenReady();
                            var1_1.isRebuffering = var25_20;
                            var1_1.setState(2);
                            var25_20 = (int)var1_1.isRebuffering;
                            if (var25_20 != 0) {
                                this.notifyTrackSelectionRebuffer();
                                var27_22 = var1_1.livePlaybackSpeedControl;
                                var27_22.notifyRebuffer();
                            }
                            this.stopRenderers();
                        }
                    }
                }
                var27_22 = var1_1.playbackInfo;
                var25_20 = var27_22.playbackState;
                var18_14 /* !! */  = 2;
                if (var25_20 == var18_14 /* !! */ ) {
                    var27_22 = null;
                    for (var25_20 = 0; var25_20 < (var19_15 = ((Renderer[])(var20_16 = var1_1.renderers)).length); ++var25_20) {
                        var18_14 /* !! */  = (int)ExoPlayerImplInternal.isRendererEnabled((Renderer)(var20_16 = var20_16[var25_20]));
                        if (var18_14 /* !! */  == 0 || (var20_16 = var1_1.renderers[var25_20].getStream()) != (var26_21 = var5_4.sampleStreams[var25_20])) continue;
                        var20_16 = var1_1.renderers[var25_20];
                        var20_16.maybeThrowStreamError();
                    }
                    var5_4 = var1_1.playbackInfo;
                    var25_20 = (int)var5_4.isLoading;
                    if (var25_20 == 0 && (var6_5 = (int)((cfr_temp_2 = (var29_24 = var5_4.totalBufferedDurationUs) - (var9_8 = 500000L)) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1))) < 0 && (var6_5 = (int)this.isLoadingPossible()) != 0) {
                        var2_2 = new IllegalStateException("Playback stuck buffering and not loading");
                        throw var2_2;
                    }
                }
                var6_5 = (int)var1_1.offloadSchedulingEnabled;
                var27_22 = var1_1.playbackInfo;
                var18_14 /* !! */  = (int)var27_22.offloadSchedulingEnabled;
                if (var6_5 != var18_14 /* !! */ ) {
                    var1_1.playbackInfo = var5_4 = var27_22.copyWithOffloadSchedulingEnabled((boolean)var6_5);
                }
                if ((var6_5 = this.shouldPlayWhenReady()) == 0) break block36;
                var5_4 = var1_1.playbackInfo;
                var6_5 = var5_4.playbackState;
                if (var6_5 == var7_6) ** GOTO lbl-1000
            }
            var5_4 = var1_1.playbackInfo;
            var6_5 = var5_4.playbackState;
            var25_20 = 2;
            if (var6_5 == var25_20) lbl-1000:
            // 2 sources

            {
                var29_24 = 10;
                var31_25 = var1_1.maybeScheduleWakeup(var3_3, var29_24);
                var32_26 = true;
                var31_25 ^= var32_26;
            } else {
                var25_20 = var1_1.enabledRendererCount;
                if (var25_20 != 0 && var6_5 != var8_7) {
                    var29_24 = 1000L;
                    var1_1.scheduleNextWork(var3_3, var29_24);
                } else {
                    var2_2 = var1_1.handler;
                    var32_27 = 2;
                    var2_2.removeMessages(var32_27);
                }
                var31_25 = 0;
                var2_2 = null;
            }
            var33_28 = var1_1.playbackInfo;
            var6_5 = (int)var33_28.sleepingForOffload;
            if (var6_5 != var31_25) {
                var1_1.playbackInfo = var2_2 = var33_28.copyWithSleepingForOffload((boolean)var31_25);
            }
            var1_1.requestForRendererSleep = false;
            TraceUtil.endSection();
            return;
        }
        var1_1.handler.removeMessages(2);
    }

    /*
     * Unable to fully structure code
     */
    private void enableRenderer(int var1_1, boolean var2_2) {
        var3_3 = this;
        var4_4 = this.renderers[var1_1];
        var5_5 = ExoPlayerImplInternal.isRendererEnabled(var4_4);
        if (var5_5 != 0) {
            return;
        }
        var6_6 = this.queue.getReadingPeriod();
        var7_7 = this.queue.getPlayingPeriod();
        var8_8 = 1;
        var9_9 = var6_6 == var7_7 ? var8_8 : 0;
        var7_7 = var6_6.getTrackSelectorResult();
        var10_10 = var7_7.rendererConfigurations[var1_1];
        var7_7 = var7_7.selections[var1_1];
        var11_11 = ExoPlayerImplInternal.getFormats((ExoTrackSelection)var7_7);
        var12_12 = this.shouldPlayWhenReady();
        if (!var12_12) ** GOTO lbl-1000
        var7_7 = var3_3.playbackInfo;
        var12_12 = var7_7.playbackState;
        var13_13 = 3;
        if (var12_12 == var13_13) {
            var14_14 = var8_8;
        } else lbl-1000:
        // 2 sources

        {
            var14_14 = 0;
        }
        var13_13 = var2_2 == false && var14_14 != 0 ? var8_8 : 0;
        var12_12 = var3_3.enabledRendererCount + var8_8;
        var3_3.enabledRendererCount = var12_12;
        var15_15 = var6_6.sampleStreams[var1_1];
        var16_16 = var3_3.rendererPositionUs;
        var18_17 = var6_6.getStartPositionRendererTime();
        var20_18 = var6_6.getRendererOffset();
        var6_6 = var4_4;
        var7_7 = var10_10;
        var22_19 = var16_16;
        var16_16 = var18_17;
        var18_17 = var20_18;
        var4_4.enable(var10_10, var11_11, var15_15, var22_19, (boolean)var13_13, (boolean)var9_9, var16_16, var20_18);
        var5_5 = 103;
        var7_7 = new ExoPlayerImplInternal$1(var3_3);
        var4_4.handleMessage(var5_5, var7_7);
        var6_6 = var3_3.mediaClock;
        var6_6.onRendererEnabled(var4_4);
        if (var14_14) {
            var4_4.start();
        }
    }

    private void enableRenderers() {
        boolean[] blArray = new boolean[this.renderers.length];
        this.enableRenderers(blArray);
    }

    private void enableRenderers(boolean[] blArray) {
        Object object;
        boolean bl2;
        boolean bl3;
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.getTrackSelectorResult();
        boolean bl4 = false;
        Renderer[] rendererArray = null;
        for (bl3 = false; bl3 < (bl2 = ((Renderer[])(object = this.renderers)).length); bl3 += 1) {
            bl2 = trackSelectorResult.isRendererEnabled((int)(bl3 ? 1 : 0));
            if (bl2) continue;
            object = this.renderers[bl3];
            object.reset();
        }
        while (bl4 < (bl3 = (rendererArray = this.renderers).length)) {
            bl3 = trackSelectorResult.isRendererEnabled((int)(bl4 ? 1 : 0));
            if (bl3) {
                bl3 = blArray[bl4];
                this.enableRenderer((int)(bl4 ? 1 : 0), bl3);
            }
            bl4 += 1;
        }
        mediaPeriodHolder.allRenderersEnabled = true;
    }

    private void ensureStopped(Renderer renderer) {
        int n10;
        int n11 = renderer.getState();
        if (n11 == (n10 = 2)) {
            renderer.stop();
        }
    }

    private ImmutableList extractMetadataFromTrackSelectionArray(ExoTrackSelection[] object) {
        ImmutableList$Builder immutableList$Builder = new ImmutableList$Builder();
        int n10 = ((ExoTrackSelection[])object).length;
        boolean bl2 = false;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = object[i10];
            if (object2 == null) continue;
            object2 = object2.getFormat((int)0).metadata;
            if (object2 == null) {
                Metadata$Entry[] metadata$EntryArray = new Metadata$Entry[]{};
                object2 = new Metadata(metadata$EntryArray);
                immutableList$Builder.add(object2);
                continue;
            }
            immutableList$Builder.add(object2);
            bl2 = true;
        }
        object = bl2 ? immutableList$Builder.build() : ImmutableList.of();
        return object;
    }

    private long getCurrentLiveOffsetUs() {
        PlaybackInfo playbackInfo = this.playbackInfo;
        Timeline timeline = playbackInfo.timeline;
        Object object = playbackInfo.periodId.periodUid;
        long l10 = playbackInfo.positionUs;
        return this.getLiveOffsetUs(timeline, object, l10);
    }

    private static Format[] getFormats(ExoTrackSelection exoTrackSelection) {
        int n10 = exoTrackSelection != null ? exoTrackSelection.length() : 0;
        Format[] formatArray = new Format[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            Format format;
            formatArray[i10] = format = exoTrackSelection.getFormat(i10);
        }
        return formatArray;
    }

    private long getLiveOffsetUs(Timeline object, Object object2, long l10) {
        boolean bl2;
        Object object3 = this.period;
        object2 = ((Timeline)object).getPeriodByUid(object2, (Timeline$Period)object3);
        int n10 = ((Timeline$Period)object2).windowIndex;
        object3 = this.window;
        ((Timeline)object).getWindow(n10, (Timeline$Window)object3);
        object = this.window;
        long l11 = ((Timeline$Window)object).windowStartTimeMs;
        long l12 = -9223372036854775807L;
        n10 = (int)(l11 == l12 ? 0 : (l11 < l12 ? -1 : 1));
        if (n10 != 0 && (bl2 = ((Timeline$Window)object).isLive())) {
            object = this.window;
            n10 = (int)(((Timeline$Window)object).isDynamic ? 1 : 0);
            if (n10 != 0) {
                long l13 = ((Timeline$Window)object).getCurrentUnixTimeMs();
                l11 = this.window.windowStartTimeMs;
                l13 = C.msToUs(l13 - l11);
                l11 = this.period.getPositionInWindowUs();
                return l13 - (l10 += l11);
            }
        }
        return l12;
    }

    private long getMaxRendererReadPositionUs() {
        Object object;
        int n10;
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod();
        if (mediaPeriodHolder == null) {
            return 0L;
        }
        long l10 = mediaPeriodHolder.getRendererOffset();
        int n11 = mediaPeriodHolder.prepared;
        if (n11 == 0) {
            return l10;
        }
        for (n11 = 0; n11 < (n10 = ((Renderer[])(object = this.renderers)).length); ++n11) {
            long l11;
            SampleStream sampleStream;
            boolean bl2 = ExoPlayerImplInternal.isRendererEnabled((Renderer)(object = object[n11]));
            if (!bl2 || (object = this.renderers[n11].getStream()) != (sampleStream = mediaPeriodHolder.sampleStreams[n11])) continue;
            object = this.renderers[n11];
            long l12 = object.getReadingPositionUs();
            long l13 = l12 - (l11 = Long.MIN_VALUE);
            Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object2 == false) {
                return l11;
            }
            l10 = Math.max(l12, l10);
        }
        return l10;
    }

    private Pair getPlaceholderFirstMediaPeriodPosition(Timeline object) {
        boolean n10 = ((Timeline)object).isEmpty();
        long l10 = 0L;
        if (n10) {
            object = PlaybackInfo.getDummyPeriodForEmptyTimeline();
            Long l11 = l10;
            return Pair.create((Object)object, (Object)l11);
        }
        boolean bl2 = this.shuffleModeEnabled;
        int n11 = ((Timeline)object).getFirstWindowIndex(bl2);
        Object object2 = this.window;
        Timeline$Period timeline$Period = this.period;
        long l12 = -9223372036854775807L;
        Object object3 = object;
        Object object4 = ((Timeline)object).getPeriodPosition((Timeline$Window)object2, timeline$Period, n11, l12);
        object3 = this.queue;
        object2 = ((Pair)object4).first;
        object3 = ((MediaPeriodQueue)object3).resolveMediaPeriodIdForAds((Timeline)object, object2, l10);
        object4 = (Long)((Pair)object4).second;
        long l13 = (Long)object4;
        boolean bl3 = ((MediaPeriodId)object3).isAd();
        if (bl3) {
            object4 = ((MediaPeriodId)object3).periodUid;
            object2 = this.period;
            ((Timeline)object).getPeriodByUid(object4, (Timeline$Period)object2);
            int n12 = ((MediaPeriodId)object3).adIndexInAdGroup;
            object4 = this.period;
            int n13 = ((MediaPeriodId)object3).adGroupIndex;
            int n14 = ((Timeline$Period)object4).getFirstAdIndexToPlay(n13);
            if (n12 == n14) {
                object = this.period;
                l10 = ((Timeline$Period)object).getAdResumePositionUs();
            }
            l13 = l10;
        }
        object = l13;
        return Pair.create((Object)object3, (Object)object);
    }

    private long getTotalBufferedDurationUs() {
        long l10 = this.playbackInfo.bufferedPositionUs;
        return this.getTotalBufferedDurationUs(l10);
    }

    private long getTotalBufferedDurationUs(long l10) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.getLoadingPeriod();
        long l11 = 0L;
        if (mediaPeriodHolder == null) {
            return l11;
        }
        long l12 = this.rendererPositionUs;
        l12 = mediaPeriodHolder.toPeriodTime(l12);
        return Math.max(l11, l10 -= l12);
    }

    private void handleContinueLoadingRequested(MediaPeriod object) {
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        boolean bl2 = mediaPeriodQueue.isLoading((MediaPeriod)object);
        if (!bl2) {
            return;
        }
        object = this.queue;
        long l10 = this.rendererPositionUs;
        ((MediaPeriodQueue)object).reevaluateBuffer(l10);
        this.maybeContinueLoading();
    }

    private void handleLoadingMediaPeriodChanged(boolean bl2) {
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId = this.playbackInfo.loadingMediaPeriodId;
        Object object = this.queue.getLoadingPeriod();
        Object object2 = object == null ? this.playbackInfo.periodId : object.info.id;
        boolean bl3 = mediaSource$MediaPeriodId.equals(object2) ^ true;
        if (bl3) {
            PlaybackInfo playbackInfo = this.playbackInfo;
            this.playbackInfo = object2 = playbackInfo.copyWithLoadingMediaPeriodId((MediaSource$MediaPeriodId)object2);
        }
        object2 = this.playbackInfo;
        long l10 = object == null ? ((PlaybackInfo)object2).positionUs : ((MediaPeriodHolder)object).getBufferedPositionUs();
        ((PlaybackInfo)object2).bufferedPositionUs = l10;
        object2 = this.playbackInfo;
        ((PlaybackInfo)object2).totalBufferedDurationUs = l10 = this.getTotalBufferedDurationUs();
        if ((bl3 || bl2) && object != null && (bl2 = ((MediaPeriodHolder)object).prepared)) {
            TrackGroupArray trackGroupArray = ((MediaPeriodHolder)object).getTrackGroups();
            object = ((MediaPeriodHolder)object).getTrackSelectorResult();
            this.updateLoadControlTrackSelection(trackGroupArray, (TrackSelectorResult)object);
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private void handleMediaSourceListInfoRefreshed(Timeline var1_1) {
        block44: {
            block43: {
                block42: {
                    block41: {
                        block40: {
                            block38: {
                                block39: {
                                    block36: {
                                        block37: {
                                            var2_2 = this;
                                            var3_3 = var1_1;
                                            var4_4 = this.playbackInfo;
                                            var5_5 = this.pendingInitialSeekPosition;
                                            var6_6 = this.queue;
                                            var7_7 = this.repeatMode;
                                            var8_8 = this.shuffleModeEnabled;
                                            var9_9 = this.window;
                                            var10_10 = this.period;
                                            var11_14 = var1_1;
                                            var11_14 = ExoPlayerImplInternal.resolvePositionForPlaylistChange(var1_1, (PlaybackInfo)var4_4, var5_5, var6_6, var7_7, var8_8, var9_9, (Timeline$Period)var10_10);
                                            var4_4 = var11_14.periodId;
                                            var12_15 = var11_14.requestedContentPositionUs;
                                            var14_16 /* !! */  = var11_14.forceBufferingState;
                                            var15_17 = var11_14.periodPositionUs;
                                            var17_18 = this.playbackInfo.periodId;
                                            var18_19 /* !! */  = var17_18.equals(var4_4);
                                            var19_20 = true;
                                            var9_9 = null;
                                            if (!var18_19 /* !! */ ) ** GOTO lbl-1000
                                            var17_18 = this.playbackInfo;
                                            var20_21 = var17_18.positionUs;
                                            cfr_temp_0 = var15_17 - var20_21;
                                            var18_19 /* !! */  = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
                                            if (!var18_19 /* !! */ ) {
                                                var22_22 = false;
                                            } else lbl-1000:
                                            // 2 sources

                                            {
                                                var22_22 = var19_20;
                                            }
                                            var23_23 = null;
                                            var24_24 = -9223372036854775807L;
                                            var18_19 /* !! */  = var11_14.endPlayback;
                                            if (!var18_19 /* !! */ ) break block36;
                                            var17_18 = var2_2.playbackInfo;
                                            var18_19 /* !! */  = var17_18.playbackState;
                                            if (var18_19 /* !! */  == var19_20) break block37;
                                            var18_19 /* !! */  = 4 != 0;
                                            var2_2.setState((int)var18_19 /* !! */ );
                                        }
                                        var2_2.resetInternal(false, false, false, var19_20);
                                    }
                                    if (var22_22) ** GOTO lbl61
                                    var17_18 = var2_2.queue;
                                    var20_21 = var2_2.rendererPositionUs;
                                    var26_25 = this.getMaxRendererReadPositionUs();
                                    var28_26 = var1_1;
                                    try {
                                        var14_16 /* !! */  = var17_18.updateQueuedPeriods(var1_1, var20_21, var26_25);
                                        if (var14_16 /* !! */ ) break block38;
                                    }
                                    catch (Throwable var10_11) {}
                                    var2_2.seekToCurrentPosition(false);
                                    break block38;
lbl61:
                                    // 1 sources

                                    var18_19 /* !! */  = var1_1.isEmpty();
                                    if (var18_19 /* !! */ ) break block38;
                                    var17_18 = var2_2.queue;
                                    var17_18 = var17_18.getPlayingPeriod();
                                    if (var17_18 == null) break block39;
                                    var28_26 = var17_18.info;
                                    var28_26 = var28_26.id;
                                    var19_20 = var28_26.equals(var4_4);
                                    if (var19_20) {
                                        var28_26 = var2_2.queue;
                                        var29_27 = var17_18.info;
                                        var17_18.info = var28_26 = var28_26.getUpdatedMediaPeriodInfo(var3_3, (MediaPeriodInfo)var29_27);
                                    }
                                    var17_18 = var17_18.getNext();
                                }
                                var15_17 = var30_28 = var2_2.seekToPeriodPosition((MediaSource$MediaPeriodId)var4_4, var15_17, var14_16 /* !! */ );
                            }
                            var10_10 = var2_2.playbackInfo;
                            var32_29 = var10_10.timeline;
                            var23_23 = var10_10.periodId;
                            var14_16 /* !! */  = var11_14.setTargetLiveOffset;
                            if (var14_16 /* !! */ ) {
                                var24_24 = var15_17;
                            }
                            var17_18 = this;
                            var28_26 = var1_1;
                            var29_27 = var4_4;
                            var11_14 = var3_3;
                            this.updateLivePlaybackSpeedControl(var1_1, (MediaSource$MediaPeriodId)var4_4, var32_29, var23_23, var24_24);
                            if (var22_22) break block40;
                            var10_10 = var2_2.playbackInfo;
                            var30_28 = var10_10.requestedContentPositionUs;
                            cfr_temp_1 = var12_15 - var30_28;
                            var14_16 /* !! */  = cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1);
                            if (!var14_16 /* !! */ ) break block41;
                        }
                        var17_18 = this;
                        var28_26 = var4_4;
                        var20_21 = var15_17;
                        var2_2.playbackInfo = var10_10 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)var4_4, var15_17, var12_15);
                    }
                    this.resetPendingPauseAtEndOfPeriod();
                    var10_10 = var2_2.playbackInfo.timeline;
                    var2_2.resolvePendingMessagePositions((Timeline)var11_14, (Timeline)var10_10);
                    var2_2.playbackInfo = var10_10 = var2_2.playbackInfo.copyWithTimeline((Timeline)var11_14);
                    var14_16 /* !! */  = var1_1.isEmpty();
                    if (!var14_16 /* !! */ ) {
                        var2_2.pendingInitialSeekPosition = null;
                    }
                    var2_2.handleLoadingMediaPeriodChanged(false);
                    return;
                    ** finally { 
lbl114:
                    // 1 sources

                    break block42;
                    catch (Throwable var10_12) {
                        // empty catch block
                    }
                }
                var17_18 = var2_2.playbackInfo;
                var32_30 = var17_18.timeline;
                var23_23 = var17_18.periodId;
                var18_19 /* !! */  = var11_14.setTargetLiveOffset;
                if (var18_19 /* !! */ ) {
                    var24_24 = var15_17;
                }
                var17_18 = this;
                var28_26 = var1_1;
                var29_27 = var4_4;
                var9_9 = null;
                var11_14 = var3_3;
                this.updateLivePlaybackSpeedControl(var1_1, (MediaSource$MediaPeriodId)var4_4, var32_30, var23_23, var24_24);
                if (var22_22) break block43;
                var17_18 = var2_2.playbackInfo;
                var33_31 = var17_18.requestedContentPositionUs;
                cfr_temp_2 = var12_15 - var33_31;
                var18_19 /* !! */  = cfr_temp_2 == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1);
                if (!var18_19 /* !! */ ) break block44;
            }
            var17_18 = this;
            var28_26 = var4_4;
            var20_21 = var15_17;
            var2_2.playbackInfo = var17_18 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)var4_4, var15_17, var12_15);
        }
        this.resetPendingPauseAtEndOfPeriod();
        var17_18 = var2_2.playbackInfo.timeline;
        var2_2.resolvePendingMessagePositions((Timeline)var11_14, (Timeline)var17_18);
        var2_2.playbackInfo = var17_18 = var2_2.playbackInfo.copyWithTimeline((Timeline)var11_14);
        var18_19 /* !! */  = var1_1.isEmpty();
        if (!var18_19 /* !! */ ) {
            var2_2.pendingInitialSeekPosition = null;
        }
        var2_2.handleLoadingMediaPeriodChanged(false);
        throw var10_13;
    }

    private void handlePeriodPrepared(MediaPeriod object) {
        Object object2 = this.queue;
        boolean bl2 = ((MediaPeriodQueue)object2).isLoading((MediaPeriod)object);
        if (!bl2) {
            return;
        }
        object = this.queue.getLoadingPeriod();
        float f10 = this.mediaClock.getPlaybackParameters().speed;
        Object object3 = this.playbackInfo.timeline;
        ((MediaPeriodHolder)object).handlePrepared(f10, (Timeline)object3);
        object2 = ((MediaPeriodHolder)object).getTrackGroups();
        object3 = ((MediaPeriodHolder)object).getTrackSelectorResult();
        this.updateLoadControlTrackSelection((TrackGroupArray)object2, (TrackSelectorResult)object3);
        object2 = this.queue.getPlayingPeriod();
        if (object == object2) {
            long l10 = object.info.startPositionUs;
            this.resetRendererPosition(l10);
            this.enableRenderers();
            object2 = this.playbackInfo;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object2).periodId;
            long l11 = object.info.startPositionUs;
            long l12 = ((PlaybackInfo)object2).requestedContentPositionUs;
            object3 = this;
            this.playbackInfo = object = this.handlePositionDiscontinuity(mediaSource$MediaPeriodId, l11, l12);
        }
        this.maybeContinueLoading();
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, float f10, boolean bl2, boolean n10) {
        if (bl2) {
            Renderer[] rendererArray;
            if (n10) {
                rendererArray = this.playbackInfoUpdate;
                n10 = 1;
                rendererArray.incrementPendingOperationAcks(n10);
            }
            this.playbackInfo = rendererArray = this.playbackInfo.copyWithPlaybackParameters(playbackParameters);
        }
        float f11 = playbackParameters.speed;
        this.updateTrackSelectionPlaybackSpeed(f11);
        for (Renderer renderer : this.renderers) {
            if (renderer == null) continue;
            float f12 = playbackParameters.speed;
            renderer.setPlaybackSpeed(f10, f12);
        }
    }

    private void handlePlaybackParameters(PlaybackParameters playbackParameters, boolean bl2) {
        float f10 = playbackParameters.speed;
        this.handlePlaybackParameters(playbackParameters, f10, true, bl2);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    private PlaybackInfo handlePositionDiscontinuity(MediaSource$MediaPeriodId var1_1, long var2_2, long var4_3) {
        var6_4 = this;
        var7_5 = var4_3;
        var9_6 /* !! */  = this.deliverPendingMessageAtStartPositionRequired;
        if (var9_6 /* !! */ ) ** GOTO lbl-1000
        var10_7 = this.playbackInfo;
        var11_8 = var10_7.positionUs;
        cfr_temp_0 = var2_2 - var11_8;
        var9_6 /* !! */  = cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1);
        if (!var9_6 /* !! */  && (var9_6 /* !! */  = var1_1.equals(var10_7 = this.playbackInfo.periodId))) {
            var9_6 /* !! */  = false;
            var10_7 = null;
        } else lbl-1000:
        // 2 sources

        {
            var9_6 /* !! */  = true;
        }
        var6_4.deliverPendingMessageAtStartPositionRequired = var9_6 /* !! */ ;
        this.resetPendingPauseAtEndOfPeriod();
        var10_7 = var6_4.playbackInfo;
        var13_9 = var10_7.trackGroups;
        var14_10 = var10_7.trackSelectorResult;
        var10_7 = var10_7.staticMetadata;
        var15_11 = var6_4.mediaSourceList;
        var16_12 = var15_11.isPrepared();
        if (var16_12) {
            var10_7 = var6_4.queue.getPlayingPeriod();
            var13_9 = var10_7 == null ? TrackGroupArray.EMPTY : var10_7.getTrackGroups();
            var14_10 = var10_7 == null ? var6_4.emptyTrackSelectorResult : var10_7.getTrackSelectorResult();
            var15_11 = var14_10.selections;
            var15_11 = this.extractMetadataFromTrackSelectionArray((ExoTrackSelection[])var15_11);
            if (var10_7 != null) {
                var17_13 = var10_7.info;
                var18_14 = var17_13.requestedContentPositionUs;
                cfr_temp_1 = var18_14 - var7_5;
                var20_15 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                if (var20_15 /* !! */  != false) {
                    var10_7.info = var17_13 = var17_13.copyWithRequestedContentPositionUs(var7_5);
                }
            }
            var21_16 = var13_9;
            var22_17 = var14_10;
            var23_18 = var15_11;
        } else {
            var15_11 = var6_4.playbackInfo.periodId;
            var16_12 = var1_1.equals(var15_11);
            if (!var16_12) {
                var10_7 = TrackGroupArray.EMPTY;
                var13_9 = var6_4.emptyTrackSelectorResult;
                var14_10 = ImmutableList.of();
                var21_16 = var10_7;
                var22_17 = var13_9;
                var23_18 = var14_10;
            } else {
                var23_18 = var10_7;
                var21_16 = var13_9;
                var22_17 = var14_10;
            }
        }
        var10_7 = var6_4.playbackInfo;
        var24_19 = this.getTotalBufferedDurationUs();
        var11_8 = var2_2;
        var7_5 = var4_3;
        return var10_7.copyWithNewPosition(var1_1, var2_2, var4_3, var24_19, (TrackGroupArray)var21_16, (TrackSelectorResult)var22_17, (List)var23_18);
    }

    private boolean hasReadingPeriodFinishedReading() {
        Object object;
        int n10;
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod();
        int n11 = mediaPeriodHolder.prepared;
        if (n11 == 0) {
            return false;
        }
        for (n11 = 0; n11 < (n10 = ((Renderer[])(object = this.renderers)).length); ++n11) {
            boolean bl2;
            object = object[n11];
            SampleStream sampleStream = mediaPeriodHolder.sampleStreams[n11];
            SampleStream sampleStream2 = object.getStream();
            if (sampleStream2 == sampleStream && (sampleStream == null || (bl2 = object.hasReadStreamToEnd()))) {
                continue;
            }
            return false;
        }
        return true;
    }

    private boolean isLoadingPossible() {
        long l10;
        MediaPeriodHolder mediaPeriodHolder = this.queue.getLoadingPeriod();
        if (mediaPeriodHolder == null) {
            return false;
        }
        long l11 = mediaPeriodHolder.getNextLoadPositionUs();
        long l12 = l11 - (l10 = Long.MIN_VALUE);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        return object != false;
    }

    private static boolean isRendererEnabled(Renderer renderer) {
        int n10 = renderer.getState();
        if (n10) {
            n10 = 1;
        } else {
            n10 = 0;
            renderer = null;
        }
        return n10 != 0;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    private boolean isTimelineReady() {
        void var5_10;
        block2: {
            block3: {
                boolean bl2;
                Object object = this.queue.getPlayingPeriod();
                MediaPeriodInfo mediaPeriodInfo = ((MediaPeriodHolder)object).info;
                long l10 = mediaPeriodInfo.durationUs;
                boolean bl3 = ((MediaPeriodHolder)object).prepared;
                if (!bl3) break block2;
                long l11 = -9223372036854775807L;
                long l12 = l10 - l11;
                Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object2 == false) break block3;
                object = this.playbackInfo;
                l11 = ((PlaybackInfo)object).positionUs;
                long l13 = l11 - l10;
                Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                if (object3 >= 0 && (bl2 = this.shouldPlayWhenReady())) break block2;
            }
            boolean bl4 = true;
            return (boolean)var5_10;
        }
        boolean bl5 = false;
        return (boolean)var5_10;
    }

    private void maybeContinueLoading() {
        boolean bl2;
        this.shouldContinueLoading = bl2 = this.shouldContinueLoading();
        if (bl2) {
            MediaPeriodHolder mediaPeriodHolder = this.queue.getLoadingPeriod();
            long l10 = this.rendererPositionUs;
            mediaPeriodHolder.continueLoading(l10);
        }
        this.updateIsLoading();
    }

    private void maybeNotifyPlaybackInfoChanged() {
        Object object = this.playbackInfoUpdate;
        Object object2 = this.playbackInfo;
        ((ExoPlayerImplInternal$PlaybackInfoUpdate)object).setPlaybackInfo((PlaybackInfo)object2);
        object = this.playbackInfoUpdate;
        boolean bl2 = ExoPlayerImplInternal$PlaybackInfoUpdate.access$100((ExoPlayerImplInternal$PlaybackInfoUpdate)object);
        if (bl2) {
            object = this.playbackInfoUpdateListener;
            object2 = this.playbackInfoUpdate;
            object.onPlaybackInfoUpdate((ExoPlayerImplInternal$PlaybackInfoUpdate)object2);
            object2 = this.playbackInfo;
            this.playbackInfoUpdate = object = new ExoPlayerImplInternal$PlaybackInfoUpdate((PlaybackInfo)object2);
        }
    }

    private boolean maybeScheduleWakeup(long l10, long l11) {
        boolean bl2 = this.offloadSchedulingEnabled;
        if (bl2 && (bl2 = this.requestForRendererSleep)) {
            return false;
        }
        this.scheduleNextWork(l10, l11);
        return true;
    }

    /*
     * Unable to fully structure code
     */
    private void maybeTriggerPendingMessages(long var1_1, long var3_2) {
        block13: {
            block15: {
                block14: {
                    var5_3 = this.pendingMessages;
                    var6_4 = var5_3.isEmpty();
                    if (var6_4 != 0 || (var6_4 = (var5_3 = this.playbackInfo.periodId).isAd()) != 0) break block13;
                    var6_4 = this.deliverPendingMessageAtStartPositionRequired;
                    if (var6_4 != 0) {
                        var7_5 = 1L;
                        var1_1 -= var7_5;
                        var6_4 = 0;
                        var5_3 = null;
                        this.deliverPendingMessageAtStartPositionRequired = false;
                    }
                    var5_3 = this.playbackInfo;
                    var9_6 = var5_3.timeline;
                    var5_3 = var5_3.periodId.periodUid;
                    var6_4 = var9_6.getIndexOfPeriod(var5_3);
                    var10_7 = this.nextPendingMessageIndexHint;
                    var11_8 = this.pendingMessages.size();
                    var10_7 = Math.min(var10_7, var11_8);
                    var11_8 = 0;
                    if (var10_7 <= 0) break block14;
                    var12_9 = this.pendingMessages;
                    var13_10 = var10_7 + -1;
                    var12_9 = (ExoPlayerImplInternal$PendingMessageInfo)var12_9.get(var13_10);
                    ** GOTO lbl28
                }
                block3: while (true) {
                    var14_11 = 0;
                    var12_9 = null;
                    while (var12_9 != null && ((var13_10 = var12_9.resolvedPeriodIndex) > var6_4 || var13_10 == var6_4 && (var14_11 = (int)((cfr_temp_0 = (var15_12 = var12_9.resolvedPeriodTimeUs) - var1_1) == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1))) > 0)) {
                        if ((var10_7 += -1) <= 0) continue block3;
                        var12_9 = this.pendingMessages;
                        var13_10 = var10_7 + -1;
                        var12_9 = (ExoPlayerImplInternal$PendingMessageInfo)var12_9.get(var13_10);
                    }
                    break;
                }
                var12_9 = this.pendingMessages;
                var14_11 = var12_9.size();
                if (var10_7 >= var14_11) break block15;
                var12_9 = (ExoPlayerImplInternal$PendingMessageInfo)this.pendingMessages.get(var10_7);
                ** GOTO lbl43
            }
            block5: while (true) {
                var14_11 = 0;
                var12_9 = null;
                while (var12_9 != null && (var17_13 = var12_9.resolvedPeriodUid) != null && ((var13_10 = var12_9.resolvedPeriodIndex) < var6_4 || var13_10 == var6_4 && (var13_10 = (int)((cfr_temp_1 = (var18_14 = var12_9.resolvedPeriodTimeUs) - var1_1) == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1))) <= 0)) {
                    var12_9 = this.pendingMessages;
                    var14_11 = var12_9.size();
                    if (++var10_7 >= var14_11) continue block5;
                    var12_9 = (ExoPlayerImplInternal$PendingMessageInfo)this.pendingMessages.get(var10_7);
                }
                break;
            }
            while (var12_9 != null && (var17_13 = var12_9.resolvedPeriodUid) != null && (var13_10 = var12_9.resolvedPeriodIndex) == var6_4 && (var20_15 = (cfr_temp_2 = (var18_14 = var12_9.resolvedPeriodTimeUs) - var1_1) == 0L ? 0 : (cfr_temp_2 < 0L ? -1 : 1)) > 0 && (var13_10 = (int)(var18_14 == var3_2 ? 0 : (var18_14 < var3_2 ? -1 : 1))) <= 0) {
                try {
                    var17_13 = var12_9.message;
                }
                catch (Throwable var21_16) {
                    var22_17 = var12_9.message;
                    var23_18 = var22_17.getDeleteAfterDelivery();
                    if (var23_18 || (var23_18 = (var22_17 = var12_9.message).isCanceled())) {
                        var22_17 = this.pendingMessages;
                        var22_17.remove(var10_7);
                    }
                    throw var21_16;
                }
                this.sendMessageToTarget((PlayerMessage)var17_13);
                var17_13 = var12_9.message;
                var13_10 = (int)var17_13.getDeleteAfterDelivery();
                if (var13_10 == 0 && (var14_11 = (int)(var12_9 = var12_9.message).isCanceled()) == 0) {
                    ++var10_7;
                } else {
                    var12_9 = this.pendingMessages;
                    var12_9.remove(var10_7);
                }
                var12_9 = this.pendingMessages;
                var14_11 = var12_9.size();
                if (var10_7 < var14_11) {
                    var12_9 = (ExoPlayerImplInternal$PendingMessageInfo)this.pendingMessages.get(var10_7);
                    continue;
                }
                var14_11 = 0;
                var12_9 = null;
            }
            this.nextPendingMessageIndexHint = var10_7;
        }
    }

    private void maybeUpdateLoadingPeriod() {
        Object object = this.queue;
        long l10 = this.rendererPositionUs;
        ((MediaPeriodQueue)object).reevaluateBuffer(l10);
        object = this.queue;
        boolean bl2 = ((MediaPeriodQueue)object).shouldLoadNextMediaPeriod();
        if (bl2) {
            object = this.queue;
            l10 = this.rendererPositionUs;
            PlaybackInfo playbackInfo = this.playbackInfo;
            if ((object = ((MediaPeriodQueue)object).getNextMediaPeriodInfo(l10, playbackInfo)) != null) {
                MediaPeriodQueue mediaPeriodQueue = this.queue;
                RendererCapabilities[] rendererCapabilitiesArray = this.rendererCapabilities;
                TrackSelector trackSelector = this.trackSelector;
                Allocator allocator = this.loadControl.getAllocator();
                MediaSourceList mediaSourceList = this.mediaSourceList;
                TrackSelectorResult trackSelectorResult = this.emptyTrackSelectorResult;
                MediaPeriodHolder mediaPeriodHolder = mediaPeriodQueue.enqueueNextMediaPeriodHolder(rendererCapabilitiesArray, trackSelector, allocator, mediaSourceList, (MediaPeriodInfo)object, trackSelectorResult);
                MediaPeriod mediaPeriod = mediaPeriodHolder.mediaPeriod;
                long l11 = ((MediaPeriodInfo)object).startPositionUs;
                mediaPeriod.prepare(this, l11);
                object = this.queue.getPlayingPeriod();
                if (object == mediaPeriodHolder) {
                    long l12 = mediaPeriodHolder.getStartPositionRendererTime();
                    this.resetRendererPosition(l12);
                }
                bl2 = false;
                object = null;
                this.handleLoadingMediaPeriodChanged(false);
            }
        }
        if (bl2 = this.shouldContinueLoading) {
            this.shouldContinueLoading = bl2 = this.isLoadingPossible();
            this.updateIsLoading();
        } else {
            this.maybeContinueLoading();
        }
    }

    private void maybeUpdatePlayingPeriod() {
        boolean bl2;
        boolean bl3 = false;
        Object object = null;
        while (bl2 = this.shouldAdvancePlayingPeriod()) {
            if (bl3) {
                this.maybeNotifyPlaybackInfoChanged();
            }
            object = this.queue.getPlayingPeriod();
            Object object2 = this.queue.advancePlayingPeriod();
            Object object3 = ((MediaPeriodHolder)object2).info;
            Object object4 = ((MediaPeriodInfo)object3).id;
            long l10 = ((MediaPeriodInfo)object3).startPositionUs;
            long l11 = ((MediaPeriodInfo)object3).requestedContentPositionUs;
            this.playbackInfo = object3 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object4, l10, l11);
            object3 = ((MediaPeriodHolder)object).info;
            int n10 = ((MediaPeriodInfo)object3).isLastInTimelinePeriod;
            if (n10 != 0) {
                n10 = 0;
                object3 = null;
            } else {
                n10 = 3;
            }
            this.playbackInfoUpdate.setPositionDiscontinuity(n10);
            object3 = this.playbackInfo;
            Timeline timeline = ((PlaybackInfo)object3).timeline;
            object2 = ((MediaPeriodHolder)object2).info;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((MediaPeriodInfo)object2).id;
            object = ((MediaPeriodHolder)object).info;
            MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = ((MediaPeriodInfo)object).id;
            long l12 = -9223372036854775807L;
            object4 = timeline;
            this.updateLivePlaybackSpeedControl(timeline, mediaSource$MediaPeriodId, timeline, mediaSource$MediaPeriodId2, l12);
            this.resetPendingPauseAtEndOfPeriod();
            this.updatePlaybackPositions();
            bl3 = true;
        }
    }

    private void maybeUpdateReadingPeriod() {
        int n10;
        Object object = this.queue.getReadingPeriod();
        if (object == null) {
            return;
        }
        Object object2 = ((MediaPeriodHolder)object).getNext();
        if (object2 != null && (n10 = this.pendingPauseAtEndOfPeriod) == 0) {
            Object object3;
            long l10;
            long l11;
            long l12;
            long l13;
            long l14;
            long l15;
            n10 = this.hasReadingPeriodFinishedReading();
            if (n10 == 0) {
                return;
            }
            object2 = ((MediaPeriodHolder)object).getNext();
            n10 = ((MediaPeriodHolder)object2).prepared;
            if (n10 == 0 && (n10 = (l15 = (l14 = this.rendererPositionUs) - (l13 = ((MediaPeriodHolder)(object2 = ((MediaPeriodHolder)object).getNext())).getStartPositionRendererTime())) == 0L ? 0 : (l15 < 0L ? -1 : 1)) < 0) {
                return;
            }
            object = ((MediaPeriodHolder)object).getTrackSelectorResult();
            object2 = this.queue.advanceReadingPeriod();
            TrackSelectorResult trackSelectorResult = ((MediaPeriodHolder)object2).getTrackSelectorResult();
            int n11 = ((MediaPeriodHolder)object2).prepared;
            if (n11 != 0 && (n10 = (int)((l12 = (l11 = (object2 = ((MediaPeriodHolder)object2).mediaPeriod).readDiscontinuity()) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) != 0) {
                this.setAllRendererStreamsFinal();
                return;
            }
            object2 = null;
            for (n10 = 0; n10 < (n11 = ((Renderer[])(object3 = this.renderers)).length); ++n10) {
                int n12;
                n11 = (int)(((TrackSelectorResult)object).isRendererEnabled(n10) ? 1 : 0);
                boolean bl2 = trackSelectorResult.isRendererEnabled(n10);
                if (n11 == 0 || (n11 = (int)((object3 = this.renderers[n10]).isCurrentStreamFinal() ? 1 : 0)) != 0) continue;
                object3 = this.rendererCapabilities[n10];
                n11 = object3.getTrackType();
                if (n11 == (n12 = 7)) {
                    n11 = 1;
                } else {
                    n11 = 0;
                    object3 = null;
                }
                RendererConfiguration rendererConfiguration = ((TrackSelectorResult)object).rendererConfigurations[n10];
                RendererConfiguration rendererConfiguration2 = trackSelectorResult.rendererConfigurations[n10];
                if (bl2 && (bl2 = rendererConfiguration2.equals(rendererConfiguration)) && n11 == 0) continue;
                object3 = this.renderers[n10];
                object3.setCurrentStreamFinal();
            }
            return;
        }
        object2 = ((MediaPeriodHolder)object).info;
        n10 = ((MediaPeriodInfo)object2).isFinal;
        if (n10 != 0 || (n10 = this.pendingPauseAtEndOfPeriod) != 0) {
            int n13;
            for (int i10 = 0; i10 < (n13 = ((Renderer[])(object2 = this.renderers)).length); ++i10) {
                SampleStream sampleStream;
                object2 = object2[i10];
                SampleStream sampleStream2 = ((MediaPeriodHolder)object).sampleStreams[i10];
                if (sampleStream2 == null || (sampleStream = object2.getStream()) != sampleStream2 || (n13 = (int)(object2.hasReadStreamToEnd() ? 1 : 0)) == 0) continue;
                object2.setCurrentStreamFinal();
            }
        }
    }

    private void maybeUpdateReadingRenderers() {
        boolean bl2;
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2 = this.queue.getReadingPeriod();
        if (mediaPeriodHolder2 != null && (mediaPeriodHolder = this.queue.getPlayingPeriod()) != mediaPeriodHolder2 && !(bl2 = mediaPeriodHolder2.allRenderersEnabled) && (bl2 = this.replaceStreamsOrDisableRendererForTransition())) {
            this.enableRenderers();
        }
    }

    private void mediaSourceListUpdateRequestedInternal() {
        Timeline timeline = this.mediaSourceList.createTimeline();
        this.handleMediaSourceListInfoRefreshed(timeline);
    }

    private void moveMediaItemsInternal(ExoPlayerImplInternal$MoveMediaItemsMessage object) {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        MediaSourceList mediaSourceList = this.mediaSourceList;
        int n10 = ((ExoPlayerImplInternal$MoveMediaItemsMessage)object).fromIndex;
        int n11 = ((ExoPlayerImplInternal$MoveMediaItemsMessage)object).toIndex;
        int n12 = ((ExoPlayerImplInternal$MoveMediaItemsMessage)object).newFromIndex;
        object = ((ExoPlayerImplInternal$MoveMediaItemsMessage)object).shuffleOrder;
        object = mediaSourceList.moveMediaSourceRange(n10, n11, n12, (ShuffleOrder)object);
        this.handleMediaSourceListInfoRefreshed((Timeline)object);
    }

    private void notifyTrackSelectionDiscontinuity() {
        for (MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.getTrackSelectorResult().selections) {
                if (exoTrackSelection == null) continue;
                exoTrackSelection.onDiscontinuity();
            }
        }
    }

    private void notifyTrackSelectionPlayWhenReadyChanged(boolean bl2) {
        for (MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.getTrackSelectorResult().selections) {
                if (exoTrackSelection == null) continue;
                exoTrackSelection.onPlayWhenReadyChanged(bl2);
            }
        }
    }

    private void notifyTrackSelectionRebuffer() {
        for (MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.getTrackSelectorResult().selections) {
                if (exoTrackSelection == null) continue;
                exoTrackSelection.onRebuffer();
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    private void prepareInternal() {
        void var3_6;
        Object object = this.playbackInfoUpdate;
        int n10 = 1;
        ((ExoPlayerImplInternal$PlaybackInfoUpdate)object).incrementPendingOperationAcks(n10);
        this.resetInternal(false, false, false, n10 != 0);
        this.loadControl.onPrepared();
        object = this.playbackInfo.timeline;
        boolean n11 = ((Timeline)object).isEmpty();
        n10 = 2;
        if (n11) {
            int n12 = 4;
        } else {
            int n13 = n10;
        }
        this.setState((int)var3_6);
        object = this.mediaSourceList;
        TransferListener transferListener = this.bandwidthMeter.getTransferListener();
        ((MediaSourceList)object).prepare(transferListener);
        this.handler.sendEmptyMessage(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void releaseInternal() {
        int n10 = 1;
        this.resetInternal(n10 != 0, false, n10 != 0, false);
        this.loadControl.onReleased();
        this.setState(n10);
        HandlerThread handlerThread = this.internalPlaybackThread;
        handlerThread.quit();
        synchronized (this) {
            this.released = n10;
            this.notifyAll();
            return;
        }
    }

    private void removeMediaItemsInternal(int n10, int n11, ShuffleOrder shuffleOrder) {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        Timeline timeline = this.mediaSourceList.removeMediaSourceRange(n10, n11, shuffleOrder);
        this.handleMediaSourceListInfoRefreshed(timeline);
    }

    private boolean replaceStreamsOrDisableRendererForTransition() {
        MediaPeriodHolder mediaPeriodHolder = this.queue.getReadingPeriod();
        TrackSelectorResult trackSelectorResult = mediaPeriodHolder.getTrackSelectorResult();
        int n10 = 0;
        boolean bl2 = false;
        while (true) {
            Object object = this.renderers;
            int n11 = ((Renderer[])object).length;
            boolean bl3 = true;
            if (n10 >= n11) break;
            Renderer renderer = object[n10];
            boolean bl4 = ExoPlayerImplInternal.isRendererEnabled(renderer);
            if (bl4) {
                SampleStream sampleStream;
                object = renderer.getStream();
                if (object != (sampleStream = mediaPeriodHolder.sampleStreams[n10])) {
                    bl4 = bl3;
                } else {
                    bl4 = false;
                    object = null;
                }
                n11 = (int)(trackSelectorResult.isRendererEnabled(n10) ? 1 : 0);
                if (n11 == 0 || bl4) {
                    bl4 = renderer.isCurrentStreamFinal();
                    if (!bl4) {
                        Format[] formatArray = ExoPlayerImplInternal.getFormats(trackSelectorResult.selections[n10]);
                        object = mediaPeriodHolder.sampleStreams;
                        Renderer renderer2 = object[n10];
                        long l10 = mediaPeriodHolder.getStartPositionRendererTime();
                        long l11 = mediaPeriodHolder.getRendererOffset();
                        renderer.replaceStream(formatArray, (SampleStream)((Object)renderer2), l10, l11);
                    } else {
                        bl4 = renderer.isEnded();
                        if (bl4) {
                            this.disableRenderer(renderer);
                        } else {
                            bl2 = bl3;
                        }
                    }
                }
            }
            ++n10;
        }
        return bl2 ^ true;
    }

    private void reselectTracksInternal() {
        boolean bl2;
        boolean bl3;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        Object object = this.mediaClock.getPlaybackParameters();
        float f10 = ((PlaybackParameters)object).speed;
        Object object2 = this.queue.getReadingPeriod();
        Object object3 = bl3 = true;
        for (Object object4 = this.queue.getPlayingPeriod(); object4 != null && (bl2 = ((MediaPeriodHolder)object4).prepared); object4 = ((MediaPeriodHolder)object4).getNext()) {
            SampleStream sampleStream;
            Object object5 = exoPlayerImplInternal.playbackInfo.timeline;
            TrackSelectorResult trackSelectorResult = ((MediaPeriodHolder)object4).selectTracks(f10, (Timeline)object5);
            object5 = ((MediaPeriodHolder)object4).getTrackSelectorResult();
            bl2 = trackSelectorResult.isEquivalent((TrackSelectorResult)object5);
            int n10 = 0;
            if (!bl2) {
                int n11;
                int n12;
                int n13 = 4;
                if (object3) {
                    int n14;
                    long l10;
                    long l11;
                    object5 = exoPlayerImplInternal.queue.getPlayingPeriod();
                    boolean bl4 = exoPlayerImplInternal.queue.removeAfter((MediaPeriodHolder)object5);
                    n12 = exoPlayerImplInternal.renderers.length;
                    boolean[] blArray = new boolean[n12];
                    long l12 = exoPlayerImplInternal.playbackInfo.positionUs;
                    boolean[] blArray2 = blArray;
                    long l13 = ((MediaPeriodHolder)object5).applyTrackSelection(trackSelectorResult, l12, bl4, blArray);
                    object = exoPlayerImplInternal.playbackInfo;
                    object4 = ((PlaybackInfo)object).periodId;
                    l12 = ((PlaybackInfo)object).requestedContentPositionUs;
                    object = this;
                    long l14 = l13;
                    Object object6 = object5;
                    long l15 = l12;
                    exoPlayerImplInternal.playbackInfo = object = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object4, l13, l12);
                    n11 = ((PlaybackInfo)object).playbackState;
                    if (n11 != n13 && (n12 = (int)((l11 = l13 - (l10 = ((PlaybackInfo)object).positionUs)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) != 0) {
                        object = exoPlayerImplInternal.playbackInfoUpdate;
                        ((ExoPlayerImplInternal$PlaybackInfoUpdate)object).setPositionDiscontinuity(n13);
                        exoPlayerImplInternal.resetRendererPosition(l13);
                    }
                    n12 = exoPlayerImplInternal.renderers.length;
                    object = new boolean[n12];
                    while (n10 < (n14 = ((Renderer[])(object4 = exoPlayerImplInternal.renderers)).length)) {
                        object4 = object4[n10];
                        n14 = (int)(ExoPlayerImplInternal.isRendererEnabled((Renderer)object4) ? 1 : 0);
                        object[n10] = n14;
                        object2 = ((MediaPeriodHolder)object6).sampleStreams[n10];
                        object3 = object[n10];
                        if (object3) {
                            sampleStream = object4.getStream();
                            if (object2 != sampleStream) {
                                exoPlayerImplInternal.disableRenderer((Renderer)object4);
                            } else {
                                n14 = blArray2[n10];
                                if (n14 != 0) {
                                    l14 = exoPlayerImplInternal.rendererPositionUs;
                                    object4.resetPosition(l14);
                                }
                            }
                        }
                        ++n10;
                    }
                    exoPlayerImplInternal.enableRenderers((boolean[])object);
                } else {
                    object = exoPlayerImplInternal.queue;
                    ((MediaPeriodQueue)object).removeAfter((MediaPeriodHolder)object4);
                    n12 = ((MediaPeriodHolder)object4).prepared;
                    if (n12 != 0) {
                        object = ((MediaPeriodHolder)object4).info;
                        long l16 = ((MediaPeriodInfo)object).startPositionUs;
                        long l17 = exoPlayerImplInternal.rendererPositionUs;
                        l17 = ((MediaPeriodHolder)object4).toPeriodTime(l17);
                        l16 = Math.max(l16, l17);
                        ((MediaPeriodHolder)object4).applyTrackSelection(trackSelectorResult, l16, false);
                    }
                }
                exoPlayerImplInternal.handleLoadingMediaPeriodChanged(bl3);
                object = exoPlayerImplInternal.playbackInfo;
                n12 = ((PlaybackInfo)object).playbackState;
                if (n12 != n13) {
                    this.maybeContinueLoading();
                    this.updatePlaybackPositions();
                    object = exoPlayerImplInternal.handler;
                    n11 = 2;
                    object.sendEmptyMessage(n11);
                }
                return;
            }
            if (object4 != object2) continue;
            object3 = false;
            sampleStream = null;
        }
    }

    private void resetInternal(boolean bl2, boolean bl3, boolean bl4, boolean bl5) {
        ExoPlaybackException exoPlaybackException;
        long l10;
        long l11;
        Object object;
        boolean bl6;
        Object object2;
        long l12;
        Object object3;
        Object object4;
        long l13;
        ExoPlayerImplInternal exoPlayerImplInternal = this;
        this.handler.removeMessages(2);
        Object object5 = null;
        this.isRebuffering = false;
        Object object6 = this.mediaClock;
        ((DefaultMediaClock)object6).stop();
        this.rendererPositionUs = l13 = 0L;
        Object object7 = this.renderers;
        int n10 = ((Renderer[])object7).length;
        int n11 = 0;
        Object object8 = null;
        while (true) {
            block17: {
                object4 = TAG;
                if (n11 >= n10) break;
                object6 = object7[n11];
                try {
                    exoPlayerImplInternal.disableRenderer((Renderer)object6);
                    break block17;
                }
                catch (RuntimeException runtimeException) {
                }
                catch (ExoPlaybackException exoPlaybackException2) {
                    // empty catch block
                }
                object3 = "Disable failed.";
                Log.e((String)object4, (String)object3, (Throwable)object6);
            }
            ++n11;
        }
        if (bl2) {
            object7 = exoPlayerImplInternal.renderers;
            n10 = ((Renderer[])object7).length;
            object8 = null;
            for (n11 = 0; n11 < n10; ++n11) {
                object6 = object7[n11];
                try {
                    object6.reset();
                    continue;
                }
                catch (RuntimeException runtimeException) {
                    object6 = "Reset failed.";
                    Log.e((String)object4, (String)object6, runtimeException);
                }
            }
        }
        exoPlayerImplInternal.enabledRendererCount = 0;
        object6 = exoPlayerImplInternal.playbackInfo;
        object7 = ((PlaybackInfo)object6).periodId;
        long l14 = ((PlaybackInfo)object6).positionUs;
        object6 = exoPlayerImplInternal.playbackInfo;
        object4 = exoPlayerImplInternal.period;
        object3 = exoPlayerImplInternal.window;
        boolean bl7 = ExoPlayerImplInternal.shouldUseRequestedContentPosition((PlaybackInfo)object6, (Timeline$Period)object4, (Timeline$Window)object3);
        if (bl7) {
            object6 = exoPlayerImplInternal.playbackInfo;
            l12 = ((PlaybackInfo)object6).requestedContentPositionUs;
        } else {
            object6 = exoPlayerImplInternal.playbackInfo;
            l12 = ((PlaybackInfo)object6).positionUs;
        }
        bl7 = false;
        object6 = null;
        if (bl3) {
            exoPlayerImplInternal.pendingInitialSeekPosition = null;
            object7 = exoPlayerImplInternal.playbackInfo.timeline;
            object7 = exoPlayerImplInternal.getPlaceholderFirstMediaPeriodPosition((Timeline)object7);
            object2 = (MediaSource$MediaPeriodId)object7.first;
            long l15 = (Long)object7.second;
            long l16 = -9223372036854775807L;
            object7 = exoPlayerImplInternal.playbackInfo.periodId;
            bl6 = ((MediaPeriodId)object2).equals(object7);
            if (!bl6) {
                bl6 = true;
            } else {
                bl6 = false;
                object7 = null;
            }
            object = object2;
            l11 = l15;
            l10 = l16;
        } else {
            object = object7;
            l11 = l14;
            l10 = l12;
            bl6 = false;
            object7 = null;
        }
        exoPlayerImplInternal.queue.clear();
        exoPlayerImplInternal.shouldContinueLoading = false;
        object2 = exoPlayerImplInternal.playbackInfo;
        Timeline timeline = ((PlaybackInfo)object2).timeline;
        int n12 = ((PlaybackInfo)object2).playbackState;
        if (bl5) {
            exoPlaybackException = null;
        } else {
            object8 = ((PlaybackInfo)object2).playbackError;
            exoPlaybackException = object8;
        }
        object8 = bl6 ? TrackGroupArray.EMPTY : ((PlaybackInfo)object2).trackGroups;
        Object object9 = object8;
        object8 = bl6 ? exoPlayerImplInternal.emptyTrackSelectorResult : ((PlaybackInfo)object2).trackSelectorResult;
        Object object10 = object8;
        object7 = bl6 ? ImmutableList.of() : ((PlaybackInfo)object2).staticMetadata;
        Object object11 = object7;
        object7 = exoPlayerImplInternal.playbackInfo;
        boolean bl8 = object7.playWhenReady;
        n10 = object7.playbackSuppressionReason;
        object7 = object7.playbackParameters;
        long l17 = 0L;
        bl6 = exoPlayerImplInternal.offloadSchedulingEnabled;
        object5 = new PlaybackInfo(timeline, (MediaSource$MediaPeriodId)object, l10, n12, exoPlaybackException, false, (TrackGroupArray)object9, (TrackSelectorResult)object10, (List)object11, (MediaSource$MediaPeriodId)object, bl8, n10, (PlaybackParameters)object7, l11, l17, l11, bl6, false);
        exoPlayerImplInternal.playbackInfo = object5;
        if (bl4) {
            object5 = exoPlayerImplInternal.mediaSourceList;
            ((MediaSourceList)object5).release();
        }
        exoPlayerImplInternal.pendingRecoverableError = null;
    }

    /*
     * Unable to fully structure code
     */
    private void resetPendingPauseAtEndOfPeriod() {
        var1_1 = this.queue.getPlayingPeriod();
        if (var1_1 == null) ** GOTO lbl-1000
        var1_1 = var1_1.info;
        var2_2 = var1_1.isLastInTimelineWindow;
        if (var2_2 && (var2_2 = this.pauseAtEndOfWindow)) {
            var2_2 = true;
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = false;
            var1_1 = null;
        }
        this.pendingPauseAtEndOfPeriod = var2_2;
    }

    private void resetRendererPosition(long l10) {
        MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod();
        if (mediaPeriodHolder != null) {
            l10 = mediaPeriodHolder.toRendererTime(l10);
        }
        this.rendererPositionUs = l10;
        this.mediaClock.resetPosition(l10);
        Renderer[] rendererArray = this.renderers;
        int n10 = rendererArray.length;
        mediaPeriodHolder = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Renderer renderer = rendererArray[i10];
            boolean bl2 = ExoPlayerImplInternal.isRendererEnabled(renderer);
            if (!bl2) continue;
            long l11 = this.rendererPositionUs;
            renderer.resetPosition(l11);
        }
        this.notifyTrackSelectionDiscontinuity();
    }

    private static void resolvePendingMessageEndOfStreamPosition(Timeline object, ExoPlayerImplInternal$PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo, Timeline$Window timeline$Window, Timeline$Period timeline$Period) {
        Object object2 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodUid;
        object2 = ((Timeline)object).getPeriodByUid(object2, timeline$Period);
        int bl2 = ((Timeline$Period)object2).windowIndex;
        timeline$Window = ((Timeline)object).getWindow(bl2, timeline$Window);
        int n10 = timeline$Window.lastPeriodIndex;
        boolean bl3 = true;
        object = object.getPeriod((int)n10, (Timeline$Period)timeline$Period, (boolean)bl3).uid;
        long l10 = timeline$Period.durationUs;
        long l11 = -9223372036854775807L;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            l11 = 1L;
            l10 -= l11;
        } else {
            l10 = Long.MAX_VALUE;
        }
        exoPlayerImplInternal$PendingMessageInfo.setResolvedPosition(n10, l10, object);
    }

    private static boolean resolvePendingMessagePosition(ExoPlayerImplInternal$PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo, Timeline timeline, Timeline timeline2, int n10, boolean bl2, Timeline$Window timeline$Window, Timeline$Period timeline$Period) {
        int n11;
        ExoPlayerImplInternal$PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo2 = exoPlayerImplInternal$PendingMessageInfo;
        Timeline timeline3 = timeline;
        Object object = timeline2;
        Timeline$Window timeline$Window2 = timeline$Window;
        Timeline$Period timeline$Period2 = timeline$Period;
        Object object2 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodUid;
        boolean bl3 = true;
        long l10 = Long.MIN_VALUE;
        if (object2 == null) {
            object = exoPlayerImplInternal$PendingMessageInfo.message;
            long l11 = ((PlayerMessage)object).getPositionMs();
            long l12 = l11 - l10;
            Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object3 == false) {
                l11 = -9223372036854775807L;
            } else {
                object = exoPlayerImplInternal$PendingMessageInfo.message;
                l11 = C.msToUs(((PlayerMessage)object).getPositionMs());
            }
            Timeline timeline4 = exoPlayerImplInternal$PendingMessageInfo2.message.getTimeline();
            PlayerMessage playerMessage = exoPlayerImplInternal$PendingMessageInfo2.message;
            int n12 = playerMessage.getWindowIndex();
            Object object4 = new ExoPlayerImplInternal$SeekPosition(timeline4, n12, l11);
            timeline4 = null;
            object = timeline;
            object2 = object4;
            boolean bl4 = false;
            object4 = null;
            int n13 = n10;
            n12 = (int)(bl2 ? 1 : 0);
            object = ExoPlayerImplInternal.resolveSeekPosition(timeline, (ExoPlayerImplInternal$SeekPosition)object2, false, n10, bl2, timeline$Window, timeline$Period);
            if (object == null) {
                return false;
            }
            object2 = ((Pair)object).first;
            int n14 = timeline3.getIndexOfPeriod(object2);
            object4 = (Long)((Pair)object).second;
            long l13 = (Long)object4;
            object = ((Pair)object).first;
            exoPlayerImplInternal$PendingMessageInfo.setResolvedPosition(n14, l13, object);
            object = exoPlayerImplInternal$PendingMessageInfo2.message;
            l11 = ((PlayerMessage)object).getPositionMs();
            object3 = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1);
            if (object3 == false) {
                ExoPlayerImplInternal.resolvePendingMessageEndOfStreamPosition(timeline3, exoPlayerImplInternal$PendingMessageInfo, timeline$Window2, timeline$Period2);
            }
            return bl3;
        }
        int n15 = timeline.getIndexOfPeriod(object2);
        if (n15 == (n11 = -1)) {
            return false;
        }
        Object object5 = exoPlayerImplInternal$PendingMessageInfo.message;
        long l14 = ((PlayerMessage)object5).getPositionMs();
        long l15 = l14 - l10;
        n11 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
        if (n11 == 0) {
            ExoPlayerImplInternal.resolvePendingMessageEndOfStreamPosition(timeline, exoPlayerImplInternal$PendingMessageInfo, timeline$Window, timeline$Period);
            return bl3;
        }
        exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodIndex = n15;
        object2 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodUid;
        timeline2.getPeriodByUid(object2, timeline$Period);
        n15 = timeline$Period.windowIndex;
        object = timeline2.getWindow(n15, timeline$Window);
        boolean bl5 = ((Timeline$Window)object).isPlaceholder;
        if (bl5) {
            long l16 = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodTimeUs;
            l14 = timeline$Period.getPositionInWindowUs();
            long l17 = l16 + l14;
            object = exoPlayerImplInternal$PendingMessageInfo.resolvedPeriodUid;
            int n16 = timeline.getPeriodByUid((Object)object, (Timeline$Period)timeline$Period).windowIndex;
            object = timeline;
            object2 = timeline$Window;
            object5 = timeline$Period;
            object = timeline.getPeriodPosition(timeline$Window, timeline$Period, n16, l17);
            object2 = ((Pair)object).first;
            n15 = timeline.getIndexOfPeriod(object2);
            object5 = (Long)((Pair)object).second;
            l14 = (Long)object5;
            object = ((Pair)object).first;
            exoPlayerImplInternal$PendingMessageInfo.setResolvedPosition(n15, l14, object);
        }
        return bl3;
    }

    private void resolvePendingMessagePositions(Timeline timeline, Timeline timeline2) {
        int n10 = timeline.isEmpty();
        if (n10 != 0 && (n10 = timeline2.isEmpty()) != 0) {
            return;
        }
        ArrayList arrayList = this.pendingMessages;
        for (n10 = arrayList.size() + -1; n10 >= 0; n10 += -1) {
            Object object = this.pendingMessages.get(n10);
            Object object2 = object;
            object2 = (ExoPlayerImplInternal$PendingMessageInfo)object;
            int n11 = this.repeatMode;
            boolean bl2 = this.shuffleModeEnabled;
            Timeline$Window timeline$Window = this.window;
            Timeline$Period timeline$Period = this.period;
            boolean bl3 = ExoPlayerImplInternal.resolvePendingMessagePosition(object2, timeline, timeline2, n11, bl2, timeline$Window, timeline$Period);
            if (bl3) continue;
            object = ((ExoPlayerImplInternal$PendingMessageInfo)this.pendingMessages.get((int)n10)).message;
            object2 = null;
            ((PlayerMessage)object).markAsProcessed(false);
            object = this.pendingMessages;
            ((ArrayList)object).remove(n10);
        }
        Collections.sort(this.pendingMessages);
    }

    /*
     * Enabled aggressive block sorting
     */
    private static ExoPlayerImplInternal$PositionUpdateForPlaylistChange resolvePositionForPlaylistChange(Timeline timeline, PlaybackInfo playbackInfo, ExoPlayerImplInternal$SeekPosition exoPlayerImplInternal$SeekPosition, MediaPeriodQueue mediaPeriodQueue, int n10, boolean n11, Timeline$Window timeline$Window, Timeline$Period timeline$Period) {
        long l10;
        long l11;
        int n12;
        float f10;
        Object object;
        int n13;
        int n14;
        int n15;
        Object object2;
        Object object3;
        float f11;
        int n16;
        int n17;
        int n18;
        long l12;
        long l13;
        Object object4;
        Object object5;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        int n19;
        Timeline$Period timeline$Period2;
        int n20;
        PlaybackInfo playbackInfo2;
        Timeline timeline2;
        block23: {
            float f12;
            ExoPlayerImplInternal$SeekPosition exoPlayerImplInternal$SeekPosition2;
            block26: {
                block24: {
                    long l14;
                    block25: {
                        block21: {
                            block22: {
                                block19: {
                                    block20: {
                                        block18: {
                                            timeline2 = timeline;
                                            playbackInfo2 = playbackInfo;
                                            exoPlayerImplInternal$SeekPosition2 = exoPlayerImplInternal$SeekPosition;
                                            n20 = n11;
                                            timeline$Period2 = timeline$Period;
                                            n19 = timeline.isEmpty();
                                            if (n19 != 0) {
                                                ExoPlayerImplInternal$PositionUpdateForPlaylistChange exoPlayerImplInternal$PositionUpdateForPlaylistChange;
                                                MediaSource$MediaPeriodId mediaSource$MediaPeriodId2 = PlaybackInfo.getDummyPeriodForEmptyTimeline();
                                                ExoPlayerImplInternal$PositionUpdateForPlaylistChange exoPlayerImplInternal$PositionUpdateForPlaylistChange2 = exoPlayerImplInternal$PositionUpdateForPlaylistChange;
                                                return new ExoPlayerImplInternal$PositionUpdateForPlaylistChange(mediaSource$MediaPeriodId2, 0L, -9223372036854775807L, false, true, false);
                                            }
                                            mediaSource$MediaPeriodId = playbackInfo.periodId;
                                            object5 = mediaSource$MediaPeriodId.periodUid;
                                            object4 = timeline$Window;
                                            n19 = ExoPlayerImplInternal.shouldUseRequestedContentPosition(playbackInfo, timeline$Period, timeline$Window);
                                            l14 = n19 != 0 ? playbackInfo.requestedContentPositionUs : playbackInfo.positionUs;
                                            l13 = l14;
                                            l12 = -9223372036854775807L;
                                            n18 = -1;
                                            f12 = 0.0f / 0.0f;
                                            n17 = 0;
                                            n16 = 1;
                                            f11 = Float.MIN_VALUE;
                                            if (exoPlayerImplInternal$SeekPosition2 == null) break block18;
                                            int n21 = 1;
                                            float f13 = Float.MIN_VALUE;
                                            object3 = timeline;
                                            object2 = exoPlayerImplInternal$SeekPosition;
                                            n15 = n10;
                                            Timeline$Window timeline$Window2 = timeline$Window;
                                            n14 = n18;
                                            object3 = ExoPlayerImplInternal.resolveSeekPosition(timeline, exoPlayerImplInternal$SeekPosition, n21 != 0, n10, n11 != 0, timeline$Window, timeline$Period);
                                            if (object3 == null) {
                                                n19 = timeline2.getFirstWindowIndex(n20 != 0);
                                                n13 = 0;
                                                object2 = null;
                                                float f14 = 0.0f;
                                                n21 = 0;
                                                object = null;
                                                f13 = 0.0f;
                                                n15 = n16;
                                                f10 = f11;
                                            } else {
                                                float f15;
                                                float f16;
                                                l14 = exoPlayerImplInternal$SeekPosition2.windowPositionUs;
                                                long l15 = l14 - l12;
                                                n13 = (int)(l15 == 0L ? 0 : (l15 < 0L ? -1 : 1));
                                                if (n13 == 0) {
                                                    object3 = ((Pair)object3).first;
                                                    n18 = timeline2.getPeriodByUid((Object)object3, (Timeline$Period)timeline$Period2).windowIndex;
                                                    n19 = 0;
                                                    object3 = null;
                                                    f16 = 0.0f;
                                                } else {
                                                    object5 = ((Pair)object3).first;
                                                    object3 = (Long)((Pair)object3).second;
                                                    l13 = (Long)object3;
                                                    n19 = n16;
                                                    f16 = f11;
                                                }
                                                n13 = playbackInfo2.playbackState;
                                                n21 = 4;
                                                f13 = 5.6E-45f;
                                                if (n13 == n21) {
                                                    n13 = n16;
                                                    f15 = f11;
                                                } else {
                                                    n13 = 0;
                                                    object2 = null;
                                                    f15 = 0.0f;
                                                }
                                                n21 = n13;
                                                f13 = f15;
                                                n15 = 0;
                                                f10 = 0.0f;
                                                n13 = n19;
                                                f15 = f16;
                                                n19 = n18;
                                            }
                                            n12 = n13;
                                            n18 = n21;
                                            f12 = f13;
                                            n20 = n15;
                                            break block19;
                                        }
                                        n14 = n18;
                                        object2 = playbackInfo2.timeline;
                                        n13 = ((Timeline)object2).isEmpty();
                                        if (n13 == 0) break block20;
                                        n19 = timeline2.getFirstWindowIndex(n20 != 0);
                                        break block21;
                                    }
                                    n13 = timeline2.getIndexOfPeriod(object5);
                                    if (n13 != n18) break block22;
                                    Timeline timeline3 = playbackInfo2.timeline;
                                    object3 = timeline$Window;
                                    object2 = timeline$Period;
                                    int n22 = n10;
                                    n15 = n11;
                                    object3 = ExoPlayerImplInternal.resolveSubsequentPeriod(timeline$Window, timeline$Period, n10, n11 != 0, object5, timeline3, timeline);
                                    if (object3 == null) {
                                        n19 = timeline2.getFirstWindowIndex(n20 != 0);
                                        n15 = n16;
                                        f10 = f11;
                                    } else {
                                        object3 = timeline2.getPeriodByUid(object3, timeline$Period2);
                                        n19 = ((Timeline$Period)object3).windowIndex;
                                        n15 = 0;
                                        f10 = 0.0f;
                                    }
                                    n20 = n15;
                                    n18 = 0;
                                    f12 = 0.0f;
                                    n12 = 0;
                                    exoPlayerImplInternal$SeekPosition2 = null;
                                }
                                n15 = n19;
                                break block23;
                            }
                            if (n19 == 0) break block24;
                            n19 = (int)(l14 == l12 ? 0 : (l14 < l12 ? -1 : 1));
                            if (n19 != 0) break block25;
                            object3 = timeline2.getPeriodByUid(object5, timeline$Period2);
                            n19 = ((Timeline$Period)object3).windowIndex;
                        }
                        n15 = n19;
                        break block26;
                    }
                    object3 = playbackInfo2.timeline;
                    object2 = mediaSource$MediaPeriodId.periodUid;
                    ((Timeline)object3).getPeriodByUid(object2, timeline$Period2);
                    l11 = timeline$Period.getPositionInWindowUs();
                    l10 = l14 + l11;
                    n15 = timeline2.getPeriodByUid((Object)object5, (Timeline$Period)timeline$Period2).windowIndex;
                    object3 = timeline;
                    object2 = timeline$Window;
                    object = timeline$Period;
                    object3 = timeline.getPeriodPosition(timeline$Window, timeline$Period, n15, l10);
                    object5 = ((Pair)object3).first;
                    object3 = (Long)((Pair)object3).second;
                    l13 = (Long)object3;
                    n15 = n18;
                    f10 = f12;
                    n18 = 0;
                    f12 = 0.0f;
                    n20 = 0;
                    n12 = n16;
                    break block23;
                }
                n15 = n18;
                f10 = f12;
            }
            n18 = 0;
            f12 = 0.0f;
            n12 = 0;
            exoPlayerImplInternal$SeekPosition2 = null;
            n20 = 0;
        }
        if (n15 != n14) {
            object3 = timeline;
            object2 = timeline$Window;
            object = timeline$Period;
            object3 = timeline.getPeriodPosition(timeline$Window, timeline$Period, n15, -9223372036854775807L);
            object5 = ((Pair)object3).first;
            object3 = (Long)((Pair)object3).second;
            l13 = (Long)object3;
            object = mediaPeriodQueue;
            l11 = l13;
            l10 = l12;
        } else {
            object = mediaPeriodQueue;
            l11 = l13;
            l10 = l13;
        }
        object = ((MediaPeriodQueue)object).resolveMediaPeriodIdForAds(timeline2, object5, l11);
        n15 = ((MediaPeriodId)object).nextAdGroupIndex;
        if (n15 != n14 && ((n15 = mediaSource$MediaPeriodId.nextAdGroupIndex) == n14 || (n14 = ((MediaPeriodId)object).adGroupIndex) < n15)) {
            n15 = 0;
            f10 = 0.0f;
        } else {
            n15 = n16;
            f10 = f11;
        }
        object4 = mediaSource$MediaPeriodId.periodUid;
        boolean bl2 = object4.equals(object5);
        if (bl2 && !(bl2 = mediaSource$MediaPeriodId.isAd()) && !(bl2 = ((MediaPeriodId)object).isAd()) && n15 != 0) {
            n17 = n16;
        }
        if (n17 != 0) {
            object = mediaSource$MediaPeriodId;
        }
        if ((n15 = (int)(((MediaPeriodId)object).isAd() ? 1 : 0)) != 0) {
            n19 = (int)(((MediaPeriodId)object).equals(mediaSource$MediaPeriodId) ? 1 : 0);
            if (n19 != 0) {
                l11 = playbackInfo2.positionUs;
            } else {
                object3 = ((MediaPeriodId)object).periodUid;
                timeline2.getPeriodByUid(object3, timeline$Period2);
                n19 = ((MediaPeriodId)object).adIndexInAdGroup;
                n13 = ((MediaPeriodId)object).adGroupIndex;
                n13 = timeline$Period2.getFirstAdIndexToPlay(n13);
                l11 = n19 == n13 ? timeline$Period.getAdResumePositionUs() : 0L;
            }
        }
        object3 = timeline$Period2;
        object2 = object;
        return new ExoPlayerImplInternal$PositionUpdateForPlaylistChange((MediaSource$MediaPeriodId)object, l11, l10, n18 != 0, n20 != 0, n12 != 0);
    }

    private static Pair resolveSeekPosition(Timeline timeline, ExoPlayerImplInternal$SeekPosition exoPlayerImplInternal$SeekPosition, boolean bl2, int n10, boolean bl3, Timeline$Window timeline$Window, Timeline$Period timeline$Period) {
        int n11;
        int n12;
        Object object = exoPlayerImplInternal$SeekPosition;
        Timeline$Period timeline$Period2 = timeline$Period;
        Object object2 = exoPlayerImplInternal$SeekPosition.timeline;
        boolean n13 = timeline.isEmpty();
        if (n13) {
            return null;
        }
        boolean bl4 = ((Timeline)object2).isEmpty();
        Object object3 = bl4 ? timeline : object2;
        try {
            n12 = ((ExoPlayerImplInternal$SeekPosition)object).windowIndex;
        }
        catch (IndexOutOfBoundsException indexOutOfBoundsException) {}
        long l10 = ((ExoPlayerImplInternal$SeekPosition)object).windowPositionUs;
        object2 = object3;
        Object object4 = timeline$Window;
        object2 = ((Timeline)object3).getPeriodPosition(timeline$Window, timeline$Period, n12, l10);
        boolean bl5 = timeline.equals(object3);
        if (bl5) {
            return object2;
        }
        object4 = ((Pair)object2).first;
        int n14 = timeline.getIndexOfPeriod(object4);
        if (n14 != (n11 = -1)) {
            object4 = ((Pair)object2).first;
            ((Timeline)object3).getPeriodByUid(object4, timeline$Period2);
            int n15 = timeline$Period2.windowIndex;
            object4 = ((Timeline)object3).getWindow(n15, timeline$Window);
            boolean bl6 = ((Timeline$Window)object4).isPlaceholder;
            if (bl6) {
                object2 = ((Pair)object2).first;
                n11 = timeline.getPeriodByUid((Object)object2, (Timeline$Period)timeline$Period2).windowIndex;
                long l11 = ((ExoPlayerImplInternal$SeekPosition)object).windowPositionUs;
                object = timeline;
                object2 = timeline$Window;
                object4 = timeline$Period;
                object2 = timeline.getPeriodPosition(timeline$Window, timeline$Period, n11, l11);
            }
            return object2;
        }
        if (bl2) {
            Object object5 = ((Pair)object2).first;
            object = timeline$Window;
            object2 = timeline$Period;
            int n16 = n10;
            n11 = (int)(bl3 ? 1 : 0);
            object = ExoPlayerImplInternal.resolveSubsequentPeriod(timeline$Window, timeline$Period, n10, bl3, object5, (Timeline)object3, timeline);
            if (object != null) {
                n11 = timeline.getPeriodByUid((Object)object, (Timeline$Period)timeline$Period2).windowIndex;
                object = timeline;
                object2 = timeline$Window;
                object4 = timeline$Period;
                return timeline.getPeriodPosition(timeline$Window, timeline$Period, n11, -9223372036854775807L);
            }
        }
        return null;
    }

    public static Object resolveSubsequentPeriod(Timeline$Window object, Timeline$Period timeline$Period, int n10, boolean bl2, Object object2, Timeline timeline, Timeline timeline2) {
        int n11 = timeline.getIndexOfPeriod(object2);
        int n12 = timeline.getPeriodCount();
        int n13 = -1;
        int n14 = n11;
        n11 = n13;
        for (int i10 = 0; i10 < n12 && n11 == n13 && (n14 = timeline.getNextPeriodIndex(n14, timeline$Period, (Timeline$Window)object, n10, bl2)) != n13; ++i10) {
            object2 = timeline.getUidOfPeriod(n14);
            n11 = timeline2.getIndexOfPeriod(object2);
        }
        object = n11 == n13 ? null : timeline2.getUidOfPeriod(n11);
        return object;
    }

    private void scheduleNextWork(long l10, long l11) {
        HandlerWrapper handlerWrapper = this.handler;
        int n10 = 2;
        handlerWrapper.removeMessages(n10);
        handlerWrapper = this.handler;
        handlerWrapper.sendEmptyMessageAtTime(n10, l10 += l11);
    }

    private void seekToCurrentPosition(boolean bl2) {
        Object object = this.queue.getPlayingPeriod().info.id;
        long l10 = this.playbackInfo.positionUs;
        boolean bl3 = true;
        Object object2 = this;
        l10 = this.seekToPeriodPosition((MediaSource$MediaPeriodId)object, l10, bl3, false);
        object2 = this.playbackInfo;
        long l11 = ((PlaybackInfo)object2).positionUs;
        long l12 = l10 - l11;
        Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object3 != false) {
            long l13 = this.playbackInfo.requestedContentPositionUs;
            object2 = this;
            this.playbackInfo = object = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object, l10, l13);
            if (bl2) {
                ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = this.playbackInfoUpdate;
                int n10 = 4;
                exoPlayerImplInternal$PlaybackInfoUpdate.setPositionDiscontinuity(n10);
            }
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void seekToInternal(ExoPlayerImplInternal$SeekPosition exoPlayerImplInternal$SeekPosition) {
        void var3_7;
        long l10;
        int n10;
        long l11;
        int n11;
        Object object;
        Object object2;
        Object object3;
        ExoPlayerImplInternal exoPlayerImplInternal;
        block31: {
            long l12;
            block30: {
                Object object6;
                block28: {
                    long l13;
                    long l14;
                    int n12;
                    long l17;
                    Object object4;
                    Object object5;
                    Object object7;
                    exoPlayerImplInternal = this;
                    object6 = exoPlayerImplInternal$SeekPosition;
                    object3 = this.playbackInfoUpdate;
                    int n14 = 1;
                    float f10 = Float.MIN_VALUE;
                    ((ExoPlayerImplInternal$PlaybackInfoUpdate)object3).incrementPendingOperationAcks(n14);
                    object3 = this.playbackInfo.timeline;
                    int n18 = this.repeatMode;
                    int n13 = this.shuffleModeEnabled;
                    Timeline$Window timeline$Window = this.window;
                    Object object8 = this.period;
                    int n15 = 1;
                    object2 = exoPlayerImplInternal$SeekPosition;
                    object3 = ExoPlayerImplInternal.resolveSeekPosition((Timeline)object3, exoPlayerImplInternal$SeekPosition, n15 != 0, n18, n13 != 0, timeline$Window, (Timeline$Period)object8);
                    long l18 = -9223372036854775807L;
                    timeline$Window = null;
                    if (object3 == null) {
                        object8 = this.playbackInfo.timeline;
                        object8 = this.getPlaceholderFirstMediaPeriodPosition((Timeline)object8);
                        object = (MediaSource$MediaPeriodId)((Pair)object8).first;
                        l12 = (Long)((Pair)object8).second;
                        object8 = this.playbackInfo.timeline;
                        n11 = ((Timeline)object8).isEmpty() ^ n14;
                        l11 = l18;
                    } else {
                        object8 = ((Pair)object3).first;
                        object = (Long)((Pair)object3).second;
                        l12 = (Long)object;
                        l11 = exoPlayerImplInternal$SeekPosition.windowPositionUs;
                        long l15 = l11 - l18;
                        Object object9 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                        l11 = object9 == false ? l18 : l12;
                        object = exoPlayerImplInternal.queue;
                        object7 = exoPlayerImplInternal.playbackInfo.timeline;
                        boolean bl2 = ((MediaPeriodId)(object8 = ((MediaPeriodQueue)object).resolveMediaPeriodIdForAds((Timeline)object7, object8, l12))).isAd();
                        if (bl2) {
                            object5 = exoPlayerImplInternal.playbackInfo.timeline;
                            object4 = ((MediaPeriodId)object8).periodUid;
                            object = exoPlayerImplInternal.period;
                            ((Timeline)object5).getPeriodByUid(object4, (Timeline$Period)object);
                            object5 = exoPlayerImplInternal.period;
                            n13 = ((MediaPeriodId)object8).adGroupIndex;
                            n18 = ((Timeline$Period)object5).getFirstAdIndexToPlay(n13);
                            n13 = ((MediaPeriodId)object8).adIndexInAdGroup;
                            if (n18 == n13) {
                                object5 = exoPlayerImplInternal.period;
                                l12 = l18 = ((Timeline$Period)object5).getAdResumePositionUs();
                            } else {
                                l12 = 0L;
                            }
                            object = object8;
                            n11 = n14;
                        } else {
                            void var27_31;
                            l17 = ((ExoPlayerImplInternal$SeekPosition)object6).windowPositionUs;
                            long l16 = l17 - l18;
                            Object object10 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                            if (object10 == false) {
                                int n19 = n14;
                            } else {
                                boolean bl3 = false;
                                object2 = null;
                            }
                            object = object8;
                            n11 = var27_31;
                        }
                    }
                    n13 = 2;
                    try {
                        block34: {
                            block33: {
                                block32: {
                                    object2 = exoPlayerImplInternal.playbackInfo;
                                    object2 = ((PlaybackInfo)object2).timeline;
                                    boolean bl4 = ((Timeline)object2).isEmpty();
                                    if (!bl4) break block32;
                                    exoPlayerImplInternal.pendingInitialSeekPosition = object6;
                                    break block33;
                                }
                                n12 = 4;
                                if (object3 != null) break block34;
                                object3 = exoPlayerImplInternal.playbackInfo;
                                int n20 = ((PlaybackInfo)object3).playbackState;
                                if (n20 != n14) {
                                    exoPlayerImplInternal.setState(n12);
                                }
                                exoPlayerImplInternal.resetInternal(false, n14 != 0, false, n14 != 0);
                            }
                            n10 = n13;
                            l10 = l12;
                            break block28;
                        }
                        object3 = exoPlayerImplInternal.playbackInfo;
                        object3 = ((PlaybackInfo)object3).periodId;
                        int n17 = ((MediaPeriodId)object).equals(object3);
                        if (n17 != 0) {
                            long l19;
                            long l16;
                            boolean bl5;
                            object3 = exoPlayerImplInternal.queue;
                            if ((object3 = ((MediaPeriodQueue)object3).getPlayingPeriod()) != null && (bl5 = ((MediaPeriodHolder)object3).prepared) && (l16 = (l19 = l12 - (l17 = 0L)) == 0L ? 0 : (l19 < 0L ? -1 : 1)) != false) {
                                object3 = ((MediaPeriodHolder)object3).mediaPeriod;
                                object2 = exoPlayerImplInternal.seekParameters;
                                l14 = object3.getAdjustedSeekPositionUs(l12, (SeekParameters)object2);
                            } else {
                                l14 = l12;
                            }
                            l10 = C.usToMs(l14);
                            object7 = exoPlayerImplInternal.playbackInfo;
                            l13 = l14;
                            long l21 = ((PlaybackInfo)object7).positionUs;
                            l21 = C.usToMs(l21);
                            n12 = l10 == l21 ? 0 : (l10 < l21 ? -1 : 1);
                            if (!n12) {
                                int n16;
                                object6 = exoPlayerImplInternal.playbackInfo;
                                n17 = ((PlaybackInfo)object6).playbackState;
                                if (n17 == n13 || n17 == (n16 = 3)) {
                                    l10 = ((PlaybackInfo)object6).positionUs;
                                    object3 = this;
                                    object2 = object;
                                    int n21 = n13;
                                    exoPlayerImplInternal.playbackInfo = object6 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object, l10, l11);
                                    if (n11) {
                                        object6 = exoPlayerImplInternal.playbackInfoUpdate;
                                        ((ExoPlayerImplInternal$PlaybackInfoUpdate)object6).setPositionDiscontinuity(n13);
                                    }
                                    return;
                                }
                            }
                            n10 = n13;
                            l14 = l13;
                        } else {
                            n10 = n13;
                            l14 = l12;
                        }
                    }
                    catch (Throwable throwable) {
                        n10 = n13;
                        break block30;
                    }
                    try {
                        object6 = exoPlayerImplInternal.playbackInfo;
                        n12 = ((PlaybackInfo)object6).playbackState;
                        n15 = 4;
                        if (n12 == n15) {
                            n12 = n14;
                        } else {
                            n12 = 0;
                            object6 = null;
                        }
                        l13 = exoPlayerImplInternal.seekToPeriodPosition((MediaSource$MediaPeriodId)object, l14, n12 != 0);
                        n12 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
                        if (!n12) {
                            n14 = 0;
                            f10 = 0.0f;
                        }
                        n14 |= n11;
                    }
                    catch (Throwable throwable) {
                        break block30;
                    }
                    try {
                        object6 = exoPlayerImplInternal.playbackInfo;
                        object5 = ((PlaybackInfo)object6).timeline;
                        object4 = ((PlaybackInfo)object6).periodId;
                        object3 = this;
                        object2 = object5;
                        this.updateLivePlaybackSpeedControl((Timeline)object5, (MediaSource$MediaPeriodId)object, (Timeline)object5, (MediaSource$MediaPeriodId)object4, l11);
                        n11 = n14;
                        l10 = l13;
                    }
                    catch (Throwable throwable) {
                        n11 = n14;
                        l10 = l13;
                        break block31;
                    }
                }
                object3 = this;
                object2 = object;
                exoPlayerImplInternal.playbackInfo = object6 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object, l10, l11);
                if (n11) {
                    object6 = exoPlayerImplInternal.playbackInfoUpdate;
                    ((ExoPlayerImplInternal$PlaybackInfoUpdate)object6).setPositionDiscontinuity(n10);
                }
                return;
            }
            l10 = l12;
        }
        object3 = this;
        object2 = object;
        exoPlayerImplInternal.playbackInfo = object3 = this.handlePositionDiscontinuity((MediaSource$MediaPeriodId)object, l10, l11);
        if (n11) {
            object3 = exoPlayerImplInternal.playbackInfoUpdate;
            ((ExoPlayerImplInternal$PlaybackInfoUpdate)object3).setPositionDiscontinuity(n10);
        }
        throw var3_7;
    }

    private long seekToPeriodPosition(MediaSource$MediaPeriodId mediaSource$MediaPeriodId, long l10, boolean bl2) {
        boolean bl3;
        Object object;
        MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod();
        if (mediaPeriodHolder != (object = this.queue.getReadingPeriod())) {
            bl3 = true;
        } else {
            bl3 = false;
            mediaPeriodHolder = null;
        }
        object = this;
        return this.seekToPeriodPosition(mediaSource$MediaPeriodId, l10, bl3, bl2);
    }

    /*
     * WARNING - void declaration
     */
    private long seekToPeriodPosition(MediaSource$MediaPeriodId object, long l10, boolean bl2, boolean bl3) {
        long l11;
        long l12;
        Object object2;
        MediaSource$MediaPeriodId mediaSource$MediaPeriodId;
        boolean bl4;
        Object object3;
        Object object4;
        int n10;
        block15: {
            block14: {
                void var5_5;
                this.stopRenderers();
                this.isRebuffering = false;
                n10 = 2;
                if (var5_5 != false) break block14;
                object4 = this.playbackInfo;
                int n11 = ((PlaybackInfo)object4).playbackState;
                int n12 = 3;
                if (n11 != n12) break block15;
            }
            this.setState(n10);
        }
        for (object3 = object4 = this.queue.getPlayingPeriod(); object3 != null && !(bl4 = ((MediaPeriodId)object).equals(mediaSource$MediaPeriodId = object3.info.id)); object3 = ((MediaPeriodHolder)object3).getNext()) {
        }
        long l13 = 0L;
        if (bl2 || object4 != object3 || object3 != null && (object2 = (l12 = (l11 = ((MediaPeriodHolder)object3).toRendererTime(l10)) - l13) == 0L ? 0 : (l12 < 0L ? -1 : 1)) < 0) {
            void var5_8;
            object = this.renderers;
            int n13 = ((Object)object).length;
            boolean bl5 = false;
            object4 = null;
            while (++var5_8 < n13) {
                Object object5 = object[var5_8];
                this.disableRenderer((Renderer)object5);
            }
            if (object3 != null) {
                while ((object = this.queue.getPlayingPeriod()) != object3) {
                    object = this.queue;
                    ((MediaPeriodQueue)object).advancePlayingPeriod();
                }
                object = this.queue;
                ((MediaPeriodQueue)object).removeAfter((MediaPeriodHolder)object3);
                ((MediaPeriodHolder)object3).setRendererOffset(l13);
                this.enableRenderers();
            }
        }
        if (object3 != null) {
            object = this.queue;
            ((MediaPeriodQueue)object).removeAfter((MediaPeriodHolder)object3);
            object2 = ((MediaPeriodHolder)object3).prepared;
            if (object2 == false) {
                ((MediaPeriodHolder)object3).info = object = ((MediaPeriodHolder)object3).info.copyWithStartPositionUs(l10);
            } else {
                long l14;
                object = ((MediaPeriodHolder)object3).info;
                l11 = ((MediaPeriodInfo)object).durationUs;
                long l15 = -9223372036854775807L;
                long l16 = l11 - l15;
                object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
                if (object2 != false && (object2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) >= 0) {
                    l14 = 1L;
                    l10 = Math.max(l13, l11 -= l14);
                }
                if ((object2 = (Object)((MediaPeriodHolder)object3).hasEnabledTracks) != false) {
                    object = ((MediaPeriodHolder)object3).mediaPeriod;
                    l14 = object.seekToUs(l10);
                    MediaPeriod mediaPeriod = ((MediaPeriodHolder)object3).mediaPeriod;
                    l11 = this.backBufferDurationUs;
                    l11 = l14 - l11;
                    boolean bl6 = this.retainBackBufferFromKeyframe;
                    mediaPeriod.discardBuffer(l11, bl6);
                    l10 = l14;
                }
            }
            this.resetRendererPosition(l10);
            this.maybeContinueLoading();
        } else {
            object = this.queue;
            ((MediaPeriodQueue)object).clear();
            this.resetRendererPosition(l10);
        }
        this.handleLoadingMediaPeriodChanged(false);
        this.handler.sendEmptyMessage(n10);
        return l10;
    }

    private void sendMessageInternal(PlayerMessage object) {
        long l10;
        long l11 = ((PlayerMessage)object).getPositionMs();
        long l12 = l11 - (l10 = -9223372036854775807L);
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.sendMessageToTarget((PlayerMessage)object);
        } else {
            Object object3 = this.playbackInfo.timeline;
            object2 = ((Timeline)object3).isEmpty();
            if (object2 != false) {
                object3 = this.pendingMessages;
                ExoPlayerImplInternal$PendingMessageInfo exoPlayerImplInternal$PendingMessageInfo = new ExoPlayerImplInternal$PendingMessageInfo((PlayerMessage)object);
                ((ArrayList)object3).add(exoPlayerImplInternal$PendingMessageInfo);
            } else {
                object3 = new ExoPlayerImplInternal$PendingMessageInfo((PlayerMessage)object);
                PlaybackInfo playbackInfo = this.playbackInfo;
                Timeline timeline = playbackInfo.timeline;
                int n10 = this.repeatMode;
                boolean bl2 = this.shuffleModeEnabled;
                Timeline$Window timeline$Window = this.window;
                Timeline$Period timeline$Period = this.period;
                boolean bl3 = ExoPlayerImplInternal.resolvePendingMessagePosition((ExoPlayerImplInternal$PendingMessageInfo)object3, timeline, timeline, n10, bl2, timeline$Window, timeline$Period);
                if (bl3) {
                    this.pendingMessages.add(object3);
                    object = this.pendingMessages;
                    Collections.sort(object);
                } else {
                    object2 = 0;
                    object3 = null;
                    ((PlayerMessage)object).markAsProcessed(false);
                }
            }
        }
    }

    private void sendMessageToTarget(PlayerMessage object) {
        Looper looper;
        Object object2 = ((PlayerMessage)object).getLooper();
        if (object2 == (looper = this.playbackLooper)) {
            this.deliverMessage((PlayerMessage)object);
            object = this.playbackInfo;
            int n10 = ((PlaybackInfo)object).playbackState;
            int n11 = 3;
            int n12 = 2;
            if (n10 == n11 || n10 == n12) {
                object = this.handler;
                object.sendEmptyMessage(n12);
            }
        } else {
            object2 = this.handler;
            int n13 = 15;
            object = object2.obtainMessage(n13, object);
            object.sendToTarget();
        }
    }

    private void sendMessageToTargetThread(PlayerMessage playerMessage) {
        Object object = playerMessage.getLooper();
        Runnable runnable = object.getThread();
        boolean bl2 = runnable.isAlive();
        if (!bl2) {
            Log.w("TAG", "Trying to send message on a dead thread.");
            playerMessage.markAsProcessed(false);
            return;
        }
        object = this.clock.createHandler((Looper)object, null);
        runnable = new y(this, playerMessage);
        object.post(runnable);
    }

    private void setAllRendererStreamsFinal() {
        for (Renderer renderer : this.renderers) {
            SampleStream sampleStream = renderer.getStream();
            if (sampleStream == null) continue;
            renderer.setCurrentStreamFinal();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void setForegroundModeInternal(boolean n10, AtomicBoolean atomicBoolean) {
        int n11 = this.foregroundMode;
        if (n11 != n10) {
            this.foregroundMode = n10;
            if (!n10) {
                for (Renderer renderer : this.renderers) {
                    boolean bl2 = ExoPlayerImplInternal.isRendererEnabled(renderer);
                    if (bl2) continue;
                    renderer.reset();
                }
            }
        }
        if (atomicBoolean == null) return;
        synchronized (this) {
            n10 = 1;
            atomicBoolean.set(n10 != 0);
            this.notifyAll();
            return;
        }
    }

    private void setMediaItemsInternal(ExoPlayerImplInternal$MediaSourceListUpdateMessage object) {
        Object object2;
        Object object3 = this.playbackInfoUpdate;
        ((ExoPlayerImplInternal$PlaybackInfoUpdate)object3).incrementPendingOperationAcks(1);
        int n10 = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$200((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
        int n11 = -1;
        if (n10 != n11) {
            List list = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$300((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
            ShuffleOrder shuffleOrder = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$400((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
            object2 = new PlaylistTimeline(list, shuffleOrder);
            int n12 = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$200((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
            long l10 = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$500((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
            this.pendingInitialSeekPosition = object3 = new ExoPlayerImplInternal$SeekPosition((Timeline)object2, n12, l10);
        }
        object3 = this.mediaSourceList;
        object2 = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$300((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
        object = ExoPlayerImplInternal$MediaSourceListUpdateMessage.access$400((ExoPlayerImplInternal$MediaSourceListUpdateMessage)object);
        object = ((MediaSourceList)object3).setMediaSources((List)object2, (ShuffleOrder)object);
        this.handleMediaSourceListInfoRefreshed((Timeline)object);
    }

    private void setOffloadSchedulingEnabledInternal(boolean n10) {
        int n11;
        int n12 = this.offloadSchedulingEnabled;
        if (n10 == n12) {
            return;
        }
        this.offloadSchedulingEnabled = n10;
        PlaybackInfo playbackInfo = this.playbackInfo;
        int n13 = playbackInfo.playbackState;
        if (!n10 && n13 != (n11 = 4) && n13 != (n11 = 1)) {
            HandlerWrapper handlerWrapper = this.handler;
            n12 = 2;
            handlerWrapper.sendEmptyMessage(n12);
        } else {
            PlaybackInfo playbackInfo2;
            this.playbackInfo = playbackInfo2 = playbackInfo.copyWithOffloadSchedulingEnabled(n10 != 0);
        }
    }

    private void setPauseAtEndOfWindowInternal(boolean bl2) {
        MediaPeriodHolder mediaPeriodHolder;
        MediaPeriodHolder mediaPeriodHolder2;
        this.pauseAtEndOfWindow = bl2;
        this.resetPendingPauseAtEndOfPeriod();
        bl2 = this.pendingPauseAtEndOfPeriod;
        if (bl2 && (mediaPeriodHolder2 = this.queue.getReadingPeriod()) != (mediaPeriodHolder = this.queue.getPlayingPeriod())) {
            this.seekToCurrentPosition(true);
            bl2 = false;
            mediaPeriodHolder2 = null;
            this.handleLoadingMediaPeriodChanged(false);
        }
    }

    private void setPlayWhenReadyInternal(boolean n10, int n11, boolean n12, int n13) {
        PlaybackInfo playbackInfo;
        ExoPlayerImplInternal$PlaybackInfoUpdate exoPlayerImplInternal$PlaybackInfoUpdate = this.playbackInfoUpdate;
        exoPlayerImplInternal$PlaybackInfoUpdate.incrementPendingOperationAcks(n12);
        this.playbackInfoUpdate.setPlayWhenReadyChangeReason(n13);
        PlaybackInfo playbackInfo2 = this.playbackInfo;
        this.playbackInfo = playbackInfo = playbackInfo2.copyWithPlayWhenReady(n10 != 0, n11);
        n11 = 0;
        playbackInfo = null;
        this.isRebuffering = false;
        this.notifyTrackSelectionPlayWhenReadyChanged(n10 != 0);
        n10 = this.shouldPlayWhenReady();
        if (n10 == 0) {
            this.stopRenderers();
            this.updatePlaybackPositions();
        } else {
            Object object = this.playbackInfo;
            n10 = ((PlaybackInfo)object).playbackState;
            n11 = 3;
            n12 = 2;
            if (n10 == n11) {
                this.startRenderers();
                object = this.handler;
                object.sendEmptyMessage(n12);
            } else if (n10 == n12) {
                object = this.handler;
                object.sendEmptyMessage(n12);
            }
        }
    }

    private void setPlaybackParametersInternal(PlaybackParameters playbackParameters) {
        this.mediaClock.setPlaybackParameters(playbackParameters);
        playbackParameters = this.mediaClock.getPlaybackParameters();
        this.handlePlaybackParameters(playbackParameters, true);
    }

    private void setRepeatModeInternal(int n10) {
        this.repeatMode = n10;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        Timeline timeline = this.playbackInfo.timeline;
        if ((n10 = (int)(mediaPeriodQueue.updateRepeatMode(timeline, n10) ? 1 : 0)) == 0) {
            n10 = 1;
            this.seekToCurrentPosition(n10 != 0);
        }
        this.handleLoadingMediaPeriodChanged(false);
    }

    private void setSeekParametersInternal(SeekParameters seekParameters) {
        this.seekParameters = seekParameters;
    }

    private void setShuffleModeEnabledInternal(boolean bl2) {
        this.shuffleModeEnabled = bl2;
        MediaPeriodQueue mediaPeriodQueue = this.queue;
        Timeline timeline = this.playbackInfo.timeline;
        if (!(bl2 = mediaPeriodQueue.updateShuffleModeEnabled(timeline, bl2))) {
            bl2 = true;
            this.seekToCurrentPosition(bl2);
        }
        this.handleLoadingMediaPeriodChanged(false);
    }

    private void setShuffleOrderInternal(ShuffleOrder object) {
        this.playbackInfoUpdate.incrementPendingOperationAcks(1);
        object = this.mediaSourceList.setShuffleOrder((ShuffleOrder)object);
        this.handleMediaSourceListInfoRefreshed((Timeline)object);
    }

    private void setState(int n10) {
        PlaybackInfo playbackInfo = this.playbackInfo;
        int n11 = playbackInfo.playbackState;
        if (n11 != n10) {
            PlaybackInfo playbackInfo2;
            this.playbackInfo = playbackInfo2 = playbackInfo.copyWithPlaybackState(n10);
        }
    }

    private boolean shouldAdvancePlayingPeriod() {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2 = this.shouldPlayWhenReady();
        boolean bl3 = false;
        if (!bl2) {
            return false;
        }
        bl2 = this.pendingPauseAtEndOfPeriod;
        if (bl2) {
            return false;
        }
        MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod();
        if (mediaPeriodHolder == null) {
            return false;
        }
        if ((mediaPeriodHolder = mediaPeriodHolder.getNext()) != null && (l13 = (l12 = (l11 = this.rendererPositionUs) - (l10 = mediaPeriodHolder.getStartPositionRendererTime())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0 && (bl2 = mediaPeriodHolder.allRenderersEnabled)) {
            bl3 = true;
        }
        return bl3;
    }

    private boolean shouldContinueLoading() {
        long l10;
        boolean bl2 = this.isLoadingPossible();
        if (!bl2) {
            return false;
        }
        Object object = this.queue.getLoadingPeriod();
        long l11 = ((MediaPeriodHolder)object).getNextLoadPositionUs();
        long l12 = this.getTotalBufferedDurationUs(l11);
        MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod();
        if (object == mediaPeriodHolder) {
            long l13;
            l11 = this.rendererPositionUs;
            l10 = l13 = ((MediaPeriodHolder)object).toPeriodTime(l11);
        } else {
            l11 = this.rendererPositionUs;
            l11 = ((MediaPeriodHolder)object).toPeriodTime(l11);
            object = ((MediaPeriodHolder)object).info;
            long l14 = ((MediaPeriodInfo)object).startPositionUs;
            l10 = l11 -= l14;
        }
        LoadControl loadControl = this.loadControl;
        float f10 = this.mediaClock.getPlaybackParameters().speed;
        return loadControl.shouldContinueLoading(l10, l12, f10);
    }

    private boolean shouldPlayWhenReady() {
        boolean bl2;
        PlaybackInfo playbackInfo = this.playbackInfo;
        boolean bl3 = playbackInfo.playWhenReady;
        if (bl3 && !(bl2 = playbackInfo.playbackSuppressionReason)) {
            bl2 = true;
        } else {
            bl2 = false;
            playbackInfo = null;
        }
        return bl2;
    }

    /*
     * Unable to fully structure code
     */
    private boolean shouldTransitionToReadyState(boolean var1_1) {
        block13: {
            block12: {
                var2_2 = this.enabledRendererCount;
                if (!var2_2) {
                    return this.isTimelineReady();
                }
                var2_2 = 0;
                if (!var1_1) {
                    return false;
                }
                var3_3 = this.playbackInfo;
                var4_4 = var3_3.isLoading;
                var5_5 = true;
                if (!var4_4) {
                    return var5_5;
                }
                var3_3 = var3_3.timeline;
                var6_6 = this.queue.getPlayingPeriod().info.id;
                var1_1 = this.shouldUseLivePlaybackSpeedControl((Timeline)var3_3, (MediaSource$MediaPeriodId)var6_6);
                if (var1_1) {
                    var3_3 = this.livePlaybackSpeedControl;
                    var7_7 = var3_3.getTargetLiveOffsetUs();
                } else {
                    var7_7 = -9223372036854775807L;
                }
                var9_8 = var7_7;
                var3_3 = this.queue.getLoadingPeriod();
                var4_4 = var3_3.isFullyBuffered();
                if (!var4_4) ** GOTO lbl-1000
                var6_6 = var3_3.info;
                var4_4 = var6_6.isFinal;
                if (var4_4) {
                    var4_4 = var5_5;
                } else lbl-1000:
                // 2 sources

                {
                    var4_4 = false;
                    var6_6 = null;
                }
                var11_9 = var3_3.info.id;
                var12_10 = var11_9.isAd();
                if (var12_10 && !(var1_1 = var3_3.prepared)) {
                    var1_1 = var5_5;
                } else {
                    var1_1 = false;
                    var3_3 = null;
                }
                if (var4_4 || var1_1) break block12;
                var13_11 = this.loadControl;
                var14_12 = this.getTotalBufferedDurationUs();
                var3_3 = this.mediaClock.getPlaybackParameters();
                var16_13 = var3_3.speed;
                var17_14 = this.isRebuffering;
                var1_1 = var13_11.shouldStartPlayback(var14_12, var16_13, var17_14, var9_8);
                if (!var1_1) break block13;
            }
            var2_2 = (int)var5_5;
        }
        return (boolean)var2_2;
    }

    private boolean shouldUseLivePlaybackSpeedControl(Timeline object, MediaSource$MediaPeriodId object2) {
        boolean bl2 = ((MediaPeriodId)object2).isAd();
        boolean bl3 = false;
        if (!bl2 && !(bl2 = ((Timeline)object).isEmpty())) {
            object2 = ((MediaPeriodId)object2).periodUid;
            Object object3 = this.period;
            object2 = ((Timeline)object).getPeriodByUid(object2, (Timeline$Period)object3);
            int n10 = ((Timeline$Period)object2).windowIndex;
            object3 = this.window;
            ((Timeline)object).getWindow(n10, (Timeline$Window)object3);
            object = this.window;
            boolean bl4 = ((Timeline$Window)object).isLive();
            if (bl4) {
                long l10;
                long l11;
                long l12;
                object = this.window;
                n10 = (int)(((Timeline$Window)object).isDynamic ? 1 : 0);
                if (n10 != 0 && (bl4 = (l12 = (l11 = ((Timeline$Window)object).windowStartTimeMs) - (l10 = -9223372036854775807L)) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                    bl3 = true;
                }
            }
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private static boolean shouldUseRequestedContentPosition(PlaybackInfo object, Timeline$Period timeline$Period, Timeline$Window timeline$Window) {
        Object object2 = ((PlaybackInfo)object).periodId;
        object = ((PlaybackInfo)object).timeline;
        boolean bl2 = ((MediaPeriodId)object2).isAd();
        if (bl2) return true;
        bl2 = ((Timeline)object).isEmpty();
        if (bl2) return true;
        object2 = ((MediaPeriodId)object2).periodUid;
        timeline$Period = ((Timeline)object).getPeriodByUid(object2, timeline$Period);
        int n10 = timeline$Period.windowIndex;
        object = ((Timeline)object).getWindow(n10, timeline$Window);
        boolean bl3 = ((Timeline$Window)object).isPlaceholder;
        if (!bl3) return false;
        return true;
    }

    private void startRenderers() {
        this.isRebuffering = false;
        this.mediaClock.start();
        for (Renderer renderer : this.renderers) {
            boolean bl2 = ExoPlayerImplInternal.isRendererEnabled(renderer);
            if (!bl2) continue;
            renderer.start();
        }
    }

    private void stopInternal(boolean n10, boolean bl2) {
        int n11 = 1;
        n10 = !n10 && (n10 = this.foregroundMode) ? 0 : n11;
        this.resetInternal(n10 != 0, false, n11 != 0, false);
        this.playbackInfoUpdate.incrementPendingOperationAcks((int)(bl2 ? 1 : 0));
        this.loadControl.onStopped();
        this.setState(n11);
    }

    private void stopRenderers() {
        this.mediaClock.stop();
        for (Renderer renderer : this.renderers) {
            boolean bl2 = ExoPlayerImplInternal.isRendererEnabled(renderer);
            if (!bl2) continue;
            this.ensureStopped(renderer);
        }
    }

    private void updateIsLoading() {
        boolean bl2;
        Object object = this.queue.getLoadingPeriod();
        boolean bl3 = this.shouldContinueLoading;
        if (!(bl3 || object != null && (bl2 = (object = ((MediaPeriodHolder)object).mediaPeriod).isLoading()))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        PlaybackInfo playbackInfo = this.playbackInfo;
        boolean bl4 = playbackInfo.isLoading;
        if (bl2 != bl4) {
            this.playbackInfo = object = playbackInfo.copyWithIsLoading(bl2);
        }
    }

    private void updateLivePlaybackSpeedControl(Timeline object, MediaSource$MediaPeriodId object2, Timeline object3, MediaSource$MediaPeriodId object4, long l10) {
        boolean bl2;
        boolean n10 = ((Timeline)object).isEmpty();
        if (!n10 && (bl2 = this.shouldUseLivePlaybackSpeedControl((Timeline)object, (MediaSource$MediaPeriodId)object2))) {
            Object object5 = ((MediaPeriodId)object2).periodUid;
            Object object6 = this.period;
            int n11 = object.getPeriodByUid((Object)object5, (Timeline$Period)object6).windowIndex;
            object6 = this.window;
            ((Timeline)object).getWindow(n11, (Timeline$Window)object6);
            object5 = this.livePlaybackSpeedControl;
            object6 = (MediaItem$LiveConfiguration)Util.castNonNull(this.window.liveConfiguration);
            object5.setLiveConfiguration((MediaItem$LiveConfiguration)object6);
            long l11 = -9223372036854775807L;
            long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
            if (l12 != false) {
                object3 = this.livePlaybackSpeedControl;
                object2 = ((MediaPeriodId)object2).periodUid;
                long l13 = this.getLiveOffsetUs((Timeline)object, object2, l10);
                object3.setTargetLiveOffsetOverrideUs(l13);
            } else {
                boolean bl3;
                object = this.window.uid;
                int n12 = 0;
                object2 = null;
                boolean bl4 = ((Timeline)object3).isEmpty();
                if (!bl4) {
                    object2 = ((MediaPeriodId)object4).periodUid;
                    object4 = this.period;
                    n12 = object3.getPeriodByUid((Object)object2, (Timeline$Period)object4).windowIndex;
                    object4 = this.window;
                    object2 = object3.getWindow((int)n12, (Timeline$Window)object4).uid;
                }
                if (!(bl3 = Util.areEqual(object2, object))) {
                    object = this.livePlaybackSpeedControl;
                    object.setTargetLiveOffsetOverrideUs(l11);
                }
            }
        }
    }

    private void updateLoadControlTrackSelection(TrackGroupArray trackGroupArray, TrackSelectorResult exoTrackSelectionArray) {
        LoadControl loadControl = this.loadControl;
        Renderer[] rendererArray = this.renderers;
        exoTrackSelectionArray = exoTrackSelectionArray.selections;
        loadControl.onTracksSelected(rendererArray, trackGroupArray, exoTrackSelectionArray);
    }

    private void updatePeriods() {
        Object object = this.playbackInfo.timeline;
        boolean bl2 = ((Timeline)object).isEmpty();
        if (!bl2 && (bl2 = ((MediaSourceList)(object = this.mediaSourceList)).isPrepared())) {
            this.maybeUpdateLoadingPeriod();
            this.maybeUpdateReadingPeriod();
            this.maybeUpdateReadingRenderers();
            this.maybeUpdatePlayingPeriod();
        }
    }

    private void updatePlaybackPositions() {
        long l10;
        int n10;
        Object object;
        float f10;
        long l11;
        long l12;
        Object object2;
        Object object3 = this.queue.getPlayingPeriod();
        if (object3 == null) {
            return;
        }
        int n11 = ((MediaPeriodHolder)object3).prepared;
        long l13 = -9223372036854775807L;
        if (n11 != 0) {
            long l14;
            object2 = ((MediaPeriodHolder)object3).mediaPeriod;
            l12 = l14 = object2.readDiscontinuity();
        } else {
            l12 = l13;
        }
        n11 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        if (n11 != 0) {
            this.resetRendererPosition(l12);
            object3 = this.playbackInfo;
            long l15 = ((PlaybackInfo)object3).positionUs;
            l11 = l12 == l15 ? 0 : (l12 < l15 ? -1 : 1);
            if (l11 != false) {
                object3 = this.playbackInfo;
                MediaSource$MediaPeriodId mediaSource$MediaPeriodId = ((PlaybackInfo)object3).periodId;
                long l16 = ((PlaybackInfo)object3).requestedContentPositionUs;
                this.playbackInfo = object3 = this.handlePositionDiscontinuity(mediaSource$MediaPeriodId, l12, l16);
                object3 = this.playbackInfoUpdate;
                n11 = 4;
                f10 = 5.6E-45f;
                ((ExoPlayerImplInternal$PlaybackInfoUpdate)object3).setPositionDiscontinuity(n11);
            }
        } else {
            object2 = this.mediaClock;
            object = this.queue.getReadingPeriod();
            if (object3 != object) {
                n10 = 1;
            } else {
                n10 = 0;
                object = null;
            }
            this.rendererPositionUs = l10 = ((DefaultMediaClock)object2).syncAndGetPositionUs(n10 != 0);
            long l17 = ((MediaPeriodHolder)object3).toPeriodTime(l10);
            l10 = this.playbackInfo.positionUs;
            this.maybeTriggerPendingMessages(l10, l17);
            object = this.playbackInfo;
            ((PlaybackInfo)object).positionUs = l17;
        }
        object3 = this.queue.getLoadingPeriod();
        object2 = this.playbackInfo;
        ((PlaybackInfo)object2).bufferedPositionUs = l10 = ((MediaPeriodHolder)object3).getBufferedPositionUs();
        object3 = this.playbackInfo;
        ((PlaybackInfo)object3).totalBufferedDurationUs = l10 = this.getTotalBufferedDurationUs();
        object3 = this.playbackInfo;
        n11 = (int)(((PlaybackInfo)object3).playWhenReady ? 1 : 0);
        if (n11 != 0 && (n11 = ((PlaybackInfo)object3).playbackState) == (n10 = 3) && (l11 = (long)this.shouldUseLivePlaybackSpeedControl((Timeline)(object2 = ((PlaybackInfo)object3).timeline), (MediaSource$MediaPeriodId)(object3 = ((PlaybackInfo)object3).periodId))) != false) {
            object3 = this.playbackInfo.playbackParameters;
            float f11 = ((PlaybackParameters)object3).speed;
            n11 = 1065353216;
            f10 = 1.0f;
            float f12 = f11 - f10;
            l11 = (long)(f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1));
            if (l11 == false) {
                object3 = this.livePlaybackSpeedControl;
                l10 = this.getCurrentLiveOffsetUs();
                long l18 = this.getTotalBufferedDurationUs();
                f11 = object3.getAdjustedPlaybackSpeed(l10, l18);
                object2 = this.mediaClock.getPlaybackParameters();
                f10 = ((PlaybackParameters)object2).speed;
                float f13 = f10 - f11;
                n11 = (int)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
                if (n11 != 0) {
                    object2 = this.mediaClock;
                    object = this.playbackInfo.playbackParameters;
                    object3 = ((PlaybackParameters)object).withSpeed(f11);
                    ((DefaultMediaClock)object2).setPlaybackParameters((PlaybackParameters)object3);
                    object3 = this.playbackInfo.playbackParameters;
                    object2 = this.mediaClock.getPlaybackParameters();
                    f10 = ((PlaybackParameters)object2).speed;
                    this.handlePlaybackParameters((PlaybackParameters)object3, f10, false, false);
                }
            }
        }
    }

    private void updateTrackSelectionPlaybackSpeed(float f10) {
        for (MediaPeriodHolder mediaPeriodHolder = this.queue.getPlayingPeriod(); mediaPeriodHolder != null; mediaPeriodHolder = mediaPeriodHolder.getNext()) {
            for (ExoTrackSelection exoTrackSelection : mediaPeriodHolder.getTrackSelectorResult().selections) {
                if (exoTrackSelection == null) continue;
                exoTrackSelection.onPlaybackSpeed(f10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void waitUninterruptibly(Supplier object, long l10) {
        synchronized (this) {
            long l11;
            Clock clock = this.clock;
            long l12 = clock.elapsedRealtime() + l11;
            boolean bl2 = false;
            while (true) {
                long l13;
                long l14;
                Object object2 = object.get();
                int n10 = ((Boolean)(object2 = (Boolean)object2)).booleanValue();
                if (n10 != 0 || (n10 = (l14 = l11 - (l13 = 0L)) == 0L ? 0 : (l14 < 0L ? -1 : 1)) <= 0) break;
                try {
                    this.wait(l11);
                }
                catch (InterruptedException interruptedException) {
                    boolean bl3;
                    bl2 = bl3 = true;
                }
                Clock clock2 = this.clock;
                l11 = clock2.elapsedRealtime();
                l11 = l12 - l11;
            }
            if (bl2) {
                object = Thread.currentThread();
                ((Thread)object).interrupt();
            }
            return;
        }
    }

    public void addMediaSources(int n10, List list, ShuffleOrder shuffleOrder) {
        HandlerWrapper handlerWrapper = this.handler;
        ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage = new ExoPlayerImplInternal$MediaSourceListUpdateMessage(list, shuffleOrder, -1, -9223372036854775807L, null);
        handlerWrapper.obtainMessage(18, n10, 0, exoPlayerImplInternal$MediaSourceListUpdateMessage).sendToTarget();
    }

    public /* synthetic */ Boolean b() {
        return this.a();
    }

    public /* synthetic */ void d(PlayerMessage playerMessage) {
        this.c(playerMessage);
    }

    public void experimentalSetForegroundModeTimeoutMs(long l10) {
        this.setForegroundModeTimeoutMs = l10;
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean bl2) {
        this.handler.obtainMessage(24, (int)(bl2 ? 1 : 0), 0).sendToTarget();
    }

    public Looper getPlaybackLooper() {
        return this.playbackLooper;
    }

    /*
     * Exception decompiling
     */
    public boolean handleMessage(Message var1_1) {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [45[CASE]], but top level block is 3[TRYBLOCK]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:845)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1042)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:929)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:73)
         *     at org.benf.cfr.reader.Main.main(Main.java:49)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    public void moveMediaSources(int n10, int n11, int n12, ShuffleOrder shuffleOrder) {
        ExoPlayerImplInternal$MoveMediaItemsMessage exoPlayerImplInternal$MoveMediaItemsMessage = new ExoPlayerImplInternal$MoveMediaItemsMessage(n10, n11, n12, shuffleOrder);
        this.handler.obtainMessage(19, exoPlayerImplInternal$MoveMediaItemsMessage).sendToTarget();
    }

    public void onContinueLoadingRequested(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(9, mediaPeriod).sendToTarget();
    }

    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(16, playbackParameters).sendToTarget();
    }

    public void onPlaylistUpdateRequested() {
        this.handler.sendEmptyMessage(22);
    }

    public void onPrepared(MediaPeriod mediaPeriod) {
        this.handler.obtainMessage(8, mediaPeriod).sendToTarget();
    }

    public void onTrackSelectionsInvalidated() {
        this.handler.sendEmptyMessage(10);
    }

    public void prepare() {
        this.handler.obtainMessage(0).sendToTarget();
    }

    public boolean release() {
        synchronized (this) {
            block10: {
                boolean bl2 = this.released;
                if (bl2) break block10;
                Object object = this.internalPlaybackThread;
                bl2 = object.isAlive();
                if (!bl2) break block10;
                object = this.handler;
                int n10 = 7;
                object.sendEmptyMessage(n10);
                object = new x(this);
                long l10 = this.releaseTimeoutMs;
                this.waitUninterruptibly((Supplier)object, l10);
                bl2 = this.released;
                return bl2;
            }
            return true;
            finally {
            }
        }
    }

    public void removeMediaSources(int n10, int n11, ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(20, n10, n11, shuffleOrder).sendToTarget();
    }

    public void seekTo(Timeline timeline, int n10, long l10) {
        HandlerWrapper handlerWrapper = this.handler;
        ExoPlayerImplInternal$SeekPosition exoPlayerImplInternal$SeekPosition = new ExoPlayerImplInternal$SeekPosition(timeline, n10, l10);
        handlerWrapper.obtainMessage(3, exoPlayerImplInternal$SeekPosition).sendToTarget();
    }

    public void sendMessage(PlayerMessage playerMessage) {
        synchronized (this) {
            Object object;
            boolean bl2;
            block10: {
                bl2 = this.released;
                if (bl2) break block10;
                object = this.internalPlaybackThread;
                bl2 = object.isAlive();
                if (!bl2) break block10;
                object = this.handler;
                int n10 = 14;
                playerMessage = object.obtainMessage(n10, playerMessage);
                playerMessage.sendToTarget();
                return;
            }
            object = TAG;
            String string2 = "Ignoring messages sent after release.";
            Log.w((String)object, string2);
            bl2 = false;
            object = null;
            playerMessage.markAsProcessed(false);
            return;
        }
    }

    public boolean setForegroundMode(boolean bl2) {
        synchronized (this) {
            boolean bl3;
            block15: {
                Object object;
                Object object2;
                int n10;
                block16: {
                    n10 = this.released;
                    bl3 = true;
                    if (n10 != 0) break block15;
                    object2 = this.internalPlaybackThread;
                    n10 = object2.isAlive();
                    if (n10 == 0) break block15;
                    n10 = 13;
                    if (!bl2) break block16;
                    object = this.handler;
                    object = object.obtainMessage(n10, (int)(bl3 ? 1 : 0), 0);
                    object.sendToTarget();
                    return bl3;
                }
                object = new AtomicBoolean();
                HandlerWrapper handlerWrapper = this.handler;
                object2 = handlerWrapper.obtainMessage(n10, 0, 0, object);
                object2.sendToTarget();
                object2 = new d0((AtomicBoolean)object);
                long l10 = this.setForegroundModeTimeoutMs;
                this.waitUninterruptibly((Supplier)object2, l10);
                bl2 = ((AtomicBoolean)object).get();
                return bl2;
            }
            return bl3;
            finally {
            }
        }
    }

    public void setMediaSources(List list, int n10, long l10, ShuffleOrder shuffleOrder) {
        HandlerWrapper handlerWrapper = this.handler;
        ExoPlayerImplInternal$MediaSourceListUpdateMessage exoPlayerImplInternal$MediaSourceListUpdateMessage = new ExoPlayerImplInternal$MediaSourceListUpdateMessage(list, shuffleOrder, n10, l10, null);
        handlerWrapper.obtainMessage(17, exoPlayerImplInternal$MediaSourceListUpdateMessage).sendToTarget();
    }

    public void setPauseAtEndOfWindow(boolean bl2) {
        this.handler.obtainMessage(23, (int)(bl2 ? 1 : 0), 0).sendToTarget();
    }

    public void setPlayWhenReady(boolean bl2, int n10) {
        this.handler.obtainMessage(1, (int)(bl2 ? 1 : 0), n10).sendToTarget();
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.handler.obtainMessage(4, playbackParameters).sendToTarget();
    }

    public void setRepeatMode(int n10) {
        this.handler.obtainMessage(11, n10, 0).sendToTarget();
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.handler.obtainMessage(5, seekParameters).sendToTarget();
    }

    public void setShuffleModeEnabled(boolean bl2) {
        this.handler.obtainMessage(12, (int)(bl2 ? 1 : 0), 0).sendToTarget();
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.handler.obtainMessage(21, shuffleOrder).sendToTarget();
    }

    public void stop() {
        this.handler.obtainMessage(6).sendToTarget();
    }
}

