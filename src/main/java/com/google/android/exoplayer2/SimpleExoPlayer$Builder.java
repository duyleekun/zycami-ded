/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Looper
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Looper;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl$Builder;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;

public final class SimpleExoPlayer$Builder {
    private AnalyticsCollector analyticsCollector;
    private AudioAttributes audioAttributes;
    private BandwidthMeter bandwidthMeter;
    private boolean buildCalled;
    private Clock clock;
    private final Context context;
    private long detachSurfaceTimeoutMs;
    private boolean handleAudioBecomingNoisy;
    private boolean handleAudioFocus;
    private LivePlaybackSpeedControl livePlaybackSpeedControl;
    private LoadControl loadControl;
    private Looper looper;
    private MediaSourceFactory mediaSourceFactory;
    private boolean pauseAtEndOfMediaItems;
    private PriorityTaskManager priorityTaskManager;
    private long releaseTimeoutMs;
    private final RenderersFactory renderersFactory;
    private SeekParameters seekParameters;
    private boolean skipSilenceEnabled;
    private TrackSelector trackSelector;
    private boolean useLazyPreparation;
    private int videoScalingMode;
    private int wakeMode;

    public SimpleExoPlayer$Builder(Context context) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        this(context, defaultRenderersFactory, defaultExtractorsFactory);
    }

    public SimpleExoPlayer$Builder(Context context, RenderersFactory renderersFactory) {
        DefaultExtractorsFactory defaultExtractorsFactory = new DefaultExtractorsFactory();
        this(context, renderersFactory, defaultExtractorsFactory);
    }

    public SimpleExoPlayer$Builder(Context context, RenderersFactory renderersFactory, ExtractorsFactory object) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(context, (ExtractorsFactory)object);
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl();
        DefaultBandwidthMeter defaultBandwidthMeter = DefaultBandwidthMeter.getSingletonInstance(context);
        object = Clock.DEFAULT;
        AnalyticsCollector analyticsCollector = new AnalyticsCollector((Clock)object);
        this(context, renderersFactory, defaultTrackSelector, defaultMediaSourceFactory, defaultLoadControl, defaultBandwidthMeter, analyticsCollector);
    }

    public SimpleExoPlayer$Builder(Context object, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector) {
        int n10;
        this.context = object;
        this.renderersFactory = renderersFactory;
        this.trackSelector = trackSelector;
        this.mediaSourceFactory = mediaSourceFactory;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        this.analyticsCollector = analyticsCollector;
        object = Util.getCurrentOrMainLooper();
        this.looper = object;
        object = AudioAttributes.DEFAULT;
        this.audioAttributes = object;
        this.wakeMode = 0;
        this.videoScalingMode = n10 = 1;
        this.useLazyPreparation = n10;
        object = SeekParameters.DEFAULT;
        this.seekParameters = object;
        this.livePlaybackSpeedControl = object = ((DefaultLivePlaybackSpeedControl$Builder)object).build();
        this.clock = object = Clock.DEFAULT;
        this.releaseTimeoutMs = 500L;
        this.detachSurfaceTimeoutMs = 2000L;
    }

    public SimpleExoPlayer$Builder(Context context, ExtractorsFactory extractorsFactory) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        this(context, defaultRenderersFactory, extractorsFactory);
    }

    public static /* synthetic */ Context access$000(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.context;
    }

    public static /* synthetic */ AnalyticsCollector access$100(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.analyticsCollector;
    }

    public static /* synthetic */ TrackSelector access$1000(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.trackSelector;
    }

    public static /* synthetic */ MediaSourceFactory access$1100(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.mediaSourceFactory;
    }

    public static /* synthetic */ LoadControl access$1200(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.loadControl;
    }

    public static /* synthetic */ BandwidthMeter access$1300(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.bandwidthMeter;
    }

    public static /* synthetic */ boolean access$1400(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.useLazyPreparation;
    }

    public static /* synthetic */ SeekParameters access$1500(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.seekParameters;
    }

    public static /* synthetic */ LivePlaybackSpeedControl access$1600(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.livePlaybackSpeedControl;
    }

    public static /* synthetic */ long access$1700(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.releaseTimeoutMs;
    }

    public static /* synthetic */ boolean access$1800(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.pauseAtEndOfMediaItems;
    }

    public static /* synthetic */ Clock access$1900(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.clock;
    }

    public static /* synthetic */ PriorityTaskManager access$200(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.priorityTaskManager;
    }

    public static /* synthetic */ boolean access$2000(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.handleAudioBecomingNoisy;
    }

    public static /* synthetic */ boolean access$2100(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.handleAudioFocus;
    }

    public static /* synthetic */ int access$2200(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.wakeMode;
    }

    public static /* synthetic */ AudioAttributes access$300(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.audioAttributes;
    }

    public static /* synthetic */ int access$400(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.videoScalingMode;
    }

    public static /* synthetic */ boolean access$500(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.skipSilenceEnabled;
    }

    public static /* synthetic */ long access$600(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.detachSurfaceTimeoutMs;
    }

    public static /* synthetic */ Looper access$800(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.looper;
    }

    public static /* synthetic */ RenderersFactory access$900(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        return simpleExoPlayer$Builder.renderersFactory;
    }

    public SimpleExoPlayer build() {
        boolean bl2 = this.buildCalled;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^ bl3);
        this.buildCalled = bl3;
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer(this);
        return simpleExoPlayer;
    }

    public SimpleExoPlayer$Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
        Assertions.checkState(this.buildCalled ^ true);
        this.analyticsCollector = analyticsCollector;
        return this;
    }

    public SimpleExoPlayer$Builder setAudioAttributes(AudioAttributes audioAttributes, boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.audioAttributes = audioAttributes;
        this.handleAudioFocus = bl2;
        return this;
    }

    public SimpleExoPlayer$Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
        Assertions.checkState(this.buildCalled ^ true);
        this.bandwidthMeter = bandwidthMeter;
        return this;
    }

    public SimpleExoPlayer$Builder setClock(Clock clock) {
        Assertions.checkState(this.buildCalled ^ true);
        this.clock = clock;
        return this;
    }

    public SimpleExoPlayer$Builder setDetachSurfaceTimeoutMs(long l10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.detachSurfaceTimeoutMs = l10;
        return this;
    }

    public SimpleExoPlayer$Builder setHandleAudioBecomingNoisy(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.handleAudioBecomingNoisy = bl2;
        return this;
    }

    public SimpleExoPlayer$Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
        Assertions.checkState(this.buildCalled ^ true);
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        return this;
    }

    public SimpleExoPlayer$Builder setLoadControl(LoadControl loadControl) {
        Assertions.checkState(this.buildCalled ^ true);
        this.loadControl = loadControl;
        return this;
    }

    public SimpleExoPlayer$Builder setLooper(Looper looper) {
        Assertions.checkState(this.buildCalled ^ true);
        this.looper = looper;
        return this;
    }

    public SimpleExoPlayer$Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
        Assertions.checkState(this.buildCalled ^ true);
        this.mediaSourceFactory = mediaSourceFactory;
        return this;
    }

    public SimpleExoPlayer$Builder setPauseAtEndOfMediaItems(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.pauseAtEndOfMediaItems = bl2;
        return this;
    }

    public SimpleExoPlayer$Builder setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        Assertions.checkState(this.buildCalled ^ true);
        this.priorityTaskManager = priorityTaskManager;
        return this;
    }

    public SimpleExoPlayer$Builder setReleaseTimeoutMs(long l10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.releaseTimeoutMs = l10;
        return this;
    }

    public SimpleExoPlayer$Builder setSeekParameters(SeekParameters seekParameters) {
        Assertions.checkState(this.buildCalled ^ true);
        this.seekParameters = seekParameters;
        return this;
    }

    public SimpleExoPlayer$Builder setSkipSilenceEnabled(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.skipSilenceEnabled = bl2;
        return this;
    }

    public SimpleExoPlayer$Builder setTrackSelector(TrackSelector trackSelector) {
        Assertions.checkState(this.buildCalled ^ true);
        this.trackSelector = trackSelector;
        return this;
    }

    public SimpleExoPlayer$Builder setUseLazyPreparation(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.useLazyPreparation = bl2;
        return this;
    }

    public SimpleExoPlayer$Builder setVideoScalingMode(int n10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.videoScalingMode = n10;
        return this;
    }

    public SimpleExoPlayer$Builder setWakeMode(int n10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.wakeMode = n10;
        return this;
    }
}

