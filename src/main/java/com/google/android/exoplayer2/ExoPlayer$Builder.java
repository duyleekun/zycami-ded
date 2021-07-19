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
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

public final class ExoPlayer$Builder {
    private AnalyticsCollector analyticsCollector;
    private BandwidthMeter bandwidthMeter;
    private boolean buildCalled;
    private Clock clock;
    private LivePlaybackSpeedControl livePlaybackSpeedControl;
    private LoadControl loadControl;
    private Looper looper;
    private MediaSourceFactory mediaSourceFactory;
    private boolean pauseAtEndOfMediaItems;
    private long releaseTimeoutMs;
    private final Renderer[] renderers;
    private SeekParameters seekParameters;
    private long setForegroundModeTimeoutMs;
    private TrackSelector trackSelector;
    private boolean useLazyPreparation;

    public ExoPlayer$Builder(Context context, Renderer ... rendererArray) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(context);
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl();
        DefaultBandwidthMeter defaultBandwidthMeter = DefaultBandwidthMeter.getSingletonInstance(context);
        this(rendererArray, defaultTrackSelector, defaultMediaSourceFactory, defaultLoadControl, defaultBandwidthMeter);
    }

    public ExoPlayer$Builder(Renderer[] object, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter) {
        boolean bl2 = ((Renderer[])object).length;
        boolean bl3 = true;
        bl2 = bl2 > false ? bl3 : false;
        Assertions.checkArgument(bl2);
        this.renderers = object;
        this.trackSelector = trackSelector;
        this.mediaSourceFactory = mediaSourceFactory;
        this.loadControl = loadControl;
        this.bandwidthMeter = bandwidthMeter;
        object = Util.getCurrentOrMainLooper();
        this.looper = object;
        this.useLazyPreparation = bl3;
        object = SeekParameters.DEFAULT;
        this.seekParameters = object;
        this.livePlaybackSpeedControl = object = ((DefaultLivePlaybackSpeedControl$Builder)object).build();
        this.clock = object = Clock.DEFAULT;
        this.releaseTimeoutMs = 500L;
    }

    public ExoPlayer build() {
        boolean bl2 = this.buildCalled;
        boolean bl3 = true;
        Assertions.checkState(bl2 ^= bl3);
        this.buildCalled = bl3;
        Renderer[] rendererArray = this.renderers;
        TrackSelector trackSelector = this.trackSelector;
        MediaSourceFactory mediaSourceFactory = this.mediaSourceFactory;
        LoadControl loadControl = this.loadControl;
        BandwidthMeter bandwidthMeter = this.bandwidthMeter;
        AnalyticsCollector analyticsCollector = this.analyticsCollector;
        boolean bl4 = this.useLazyPreparation;
        SeekParameters seekParameters = this.seekParameters;
        LivePlaybackSpeedControl livePlaybackSpeedControl = this.livePlaybackSpeedControl;
        long l10 = this.releaseTimeoutMs;
        boolean bl5 = this.pauseAtEndOfMediaItems;
        Clock clock = this.clock;
        Looper looper = this.looper;
        ExoPlayerImpl exoPlayerImpl = new ExoPlayerImpl(rendererArray, trackSelector, mediaSourceFactory, loadControl, bandwidthMeter, analyticsCollector, bl4, seekParameters, livePlaybackSpeedControl, l10, bl5, clock, looper, null);
        long l11 = this.setForegroundModeTimeoutMs;
        long l12 = 0L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 > 0) {
            exoPlayerImpl.experimentalSetForegroundModeTimeoutMs(l11);
        }
        return exoPlayerImpl;
    }

    public ExoPlayer$Builder experimentalSetForegroundModeTimeoutMs(long l10) {
        this.setForegroundModeTimeoutMs = l10;
        return this;
    }

    public ExoPlayer$Builder setAnalyticsCollector(AnalyticsCollector analyticsCollector) {
        Assertions.checkState(this.buildCalled ^ true);
        this.analyticsCollector = analyticsCollector;
        return this;
    }

    public ExoPlayer$Builder setBandwidthMeter(BandwidthMeter bandwidthMeter) {
        Assertions.checkState(this.buildCalled ^ true);
        this.bandwidthMeter = bandwidthMeter;
        return this;
    }

    public ExoPlayer$Builder setClock(Clock clock) {
        Assertions.checkState(this.buildCalled ^ true);
        this.clock = clock;
        return this;
    }

    public ExoPlayer$Builder setLivePlaybackSpeedControl(LivePlaybackSpeedControl livePlaybackSpeedControl) {
        Assertions.checkState(this.buildCalled ^ true);
        this.livePlaybackSpeedControl = livePlaybackSpeedControl;
        return this;
    }

    public ExoPlayer$Builder setLoadControl(LoadControl loadControl) {
        Assertions.checkState(this.buildCalled ^ true);
        this.loadControl = loadControl;
        return this;
    }

    public ExoPlayer$Builder setLooper(Looper looper) {
        Assertions.checkState(this.buildCalled ^ true);
        this.looper = looper;
        return this;
    }

    public ExoPlayer$Builder setMediaSourceFactory(MediaSourceFactory mediaSourceFactory) {
        Assertions.checkState(this.buildCalled ^ true);
        this.mediaSourceFactory = mediaSourceFactory;
        return this;
    }

    public ExoPlayer$Builder setPauseAtEndOfMediaItems(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.pauseAtEndOfMediaItems = bl2;
        return this;
    }

    public ExoPlayer$Builder setReleaseTimeoutMs(long l10) {
        Assertions.checkState(this.buildCalled ^ true);
        this.releaseTimeoutMs = l10;
        return this;
    }

    public ExoPlayer$Builder setSeekParameters(SeekParameters seekParameters) {
        Assertions.checkState(this.buildCalled ^ true);
        this.seekParameters = seekParameters;
        return this;
    }

    public ExoPlayer$Builder setTrackSelector(TrackSelector trackSelector) {
        Assertions.checkState(this.buildCalled ^ true);
        this.trackSelector = trackSelector;
        return this;
    }

    public ExoPlayer$Builder setUseLazyPreparation(boolean bl2) {
        Assertions.checkState(this.buildCalled ^ true);
        this.useLazyPreparation = bl2;
        return this;
    }
}

