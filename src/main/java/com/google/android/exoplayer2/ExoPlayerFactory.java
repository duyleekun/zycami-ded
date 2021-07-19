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
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl;
import com.google.android.exoplayer2.DefaultLivePlaybackSpeedControl$Builder;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Util;

public final class ExoPlayerFactory {
    private ExoPlayerFactory() {
    }

    public static ExoPlayer newInstance(Context context, Renderer[] rendererArray, TrackSelector trackSelector) {
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl();
        return ExoPlayerFactory.newInstance(context, rendererArray, trackSelector, defaultLoadControl);
    }

    public static ExoPlayer newInstance(Context context, Renderer[] rendererArray, TrackSelector trackSelector, LoadControl loadControl) {
        Looper looper = Util.getCurrentOrMainLooper();
        return ExoPlayerFactory.newInstance(context, rendererArray, trackSelector, loadControl, looper);
    }

    public static ExoPlayer newInstance(Context context, Renderer[] rendererArray, TrackSelector trackSelector, LoadControl loadControl, Looper looper) {
        DefaultBandwidthMeter defaultBandwidthMeter = DefaultBandwidthMeter.getSingletonInstance(context);
        return ExoPlayerFactory.newInstance(context, rendererArray, trackSelector, loadControl, defaultBandwidthMeter, looper);
    }

    public static ExoPlayer newInstance(Context context, Renderer[] rendererArray, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, Looper looper) {
        ExoPlayerImpl exoPlayerImpl;
        Object object = context;
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(context);
        SeekParameters seekParameters = SeekParameters.DEFAULT;
        object = new DefaultLivePlaybackSpeedControl$Builder();
        DefaultLivePlaybackSpeedControl defaultLivePlaybackSpeedControl = ((DefaultLivePlaybackSpeedControl$Builder)object).build();
        Clock clock = Clock.DEFAULT;
        object = exoPlayerImpl;
        exoPlayerImpl = new ExoPlayerImpl(rendererArray, trackSelector, defaultMediaSourceFactory, loadControl, bandwidthMeter, null, true, seekParameters, defaultLivePlaybackSpeedControl, 500L, false, clock, looper, null);
        return exoPlayerImpl;
    }

    public static SimpleExoPlayer newSimpleInstance(Context context) {
        DefaultTrackSelector defaultTrackSelector = new DefaultTrackSelector(context);
        return ExoPlayerFactory.newSimpleInstance(context, defaultTrackSelector);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector) {
        DefaultLoadControl defaultLoadControl = new DefaultLoadControl();
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, defaultLoadControl);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl) {
        Looper looper = Util.getCurrentOrMainLooper();
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, loadControl, looper);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, Looper looper) {
        Clock clock = Clock.DEFAULT;
        AnalyticsCollector analyticsCollector = new AnalyticsCollector(clock);
        clock = context;
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, loadControl, analyticsCollector, looper);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, AnalyticsCollector analyticsCollector) {
        Looper looper = Util.getCurrentOrMainLooper();
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, loadControl, analyticsCollector, looper);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, AnalyticsCollector analyticsCollector, Looper looper) {
        DefaultBandwidthMeter defaultBandwidthMeter = DefaultBandwidthMeter.getSingletonInstance(context);
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, loadControl, defaultBandwidthMeter, analyticsCollector, looper);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter) {
        Clock clock = Clock.DEFAULT;
        AnalyticsCollector analyticsCollector = new AnalyticsCollector(clock);
        Looper looper = Util.getCurrentOrMainLooper();
        clock = context;
        return ExoPlayerFactory.newSimpleInstance(context, renderersFactory, trackSelector, loadControl, bandwidthMeter, analyticsCollector, looper);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, RenderersFactory renderersFactory, TrackSelector trackSelector, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, Looper looper) {
        DefaultMediaSourceFactory defaultMediaSourceFactory = new DefaultMediaSourceFactory(context);
        Clock clock = Clock.DEFAULT;
        SimpleExoPlayer simpleExoPlayer = new SimpleExoPlayer(context, renderersFactory, trackSelector, defaultMediaSourceFactory, loadControl, bandwidthMeter, analyticsCollector, true, clock, looper);
        return simpleExoPlayer;
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        return ExoPlayerFactory.newSimpleInstance(context, defaultRenderersFactory, trackSelector);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        return ExoPlayerFactory.newSimpleInstance(context, defaultRenderersFactory, trackSelector, loadControl);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, int n10) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        DefaultRenderersFactory defaultRenderersFactory2 = defaultRenderersFactory.setExtensionRendererMode(n10);
        return ExoPlayerFactory.newSimpleInstance(context, defaultRenderersFactory2, trackSelector, loadControl);
    }

    public static SimpleExoPlayer newSimpleInstance(Context context, TrackSelector trackSelector, LoadControl loadControl, int n10, long l10) {
        DefaultRenderersFactory defaultRenderersFactory = new DefaultRenderersFactory(context);
        DefaultRenderersFactory defaultRenderersFactory2 = defaultRenderersFactory.setExtensionRendererMode(n10).setAllowedVideoJoiningTimeMs(l10);
        return ExoPlayerFactory.newSimpleInstance(context, defaultRenderersFactory2, trackSelector, loadControl);
    }
}

