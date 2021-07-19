/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.media.AudioTrack
 *  android.os.Handler
 *  android.os.Looper
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.SurfaceView
 *  android.view.TextureView
 */
package com.google.android.exoplayer2;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager;
import com.google.android.exoplayer2.AudioFocusManager;
import com.google.android.exoplayer2.BasePlayer;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerImpl;
import com.google.android.exoplayer2.ExoTimeoutException;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.LivePlaybackSpeedControl;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player$AudioComponent;
import com.google.android.exoplayer2.Player$DeviceComponent;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.Player$MetadataComponent;
import com.google.android.exoplayer2.Player$TextComponent;
import com.google.android.exoplayer2.Player$VideoComponent;
import com.google.android.exoplayer2.PlayerMessage;
import com.google.android.exoplayer2.PlayerMessage$Target;
import com.google.android.exoplayer2.Renderer;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.SimpleExoPlayer$Builder;
import com.google.android.exoplayer2.SimpleExoPlayer$ComponentListener;
import com.google.android.exoplayer2.StreamVolumeManager;
import com.google.android.exoplayer2.StreamVolumeManager$Listener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.WakeLockManager;
import com.google.android.exoplayer2.WifiLockManager;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.audio.AudioListener;
import com.google.android.exoplayer2.audio.AuxEffectInfo;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.MediaSourceFactory;
import com.google.android.exoplayer2.source.ShuffleOrder;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Clock;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.VideoDecoderGLSurfaceView;
import com.google.android.exoplayer2.video.VideoDecoderOutputBufferRenderer;
import com.google.android.exoplayer2.video.VideoFrameMetadataListener;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public class SimpleExoPlayer
extends BasePlayer
implements ExoPlayer,
Player$AudioComponent,
Player$VideoComponent,
Player$TextComponent,
Player$MetadataComponent,
Player$DeviceComponent {
    public static final long DEFAULT_DETACH_SURFACE_TIMEOUT_MS = 2000L;
    private static final String TAG = "SimpleExoPlayer";
    private static final String WRONG_THREAD_ERROR_MESSAGE = "Player is accessed on the wrong thread. See https://exoplayer.dev/issues/player-accessed-on-wrong-thread";
    private final AnalyticsCollector analyticsCollector;
    private final Context applicationContext;
    private AudioAttributes audioAttributes;
    private final AudioBecomingNoisyManager audioBecomingNoisyManager;
    private DecoderCounters audioDecoderCounters;
    private final AudioFocusManager audioFocusManager;
    private Format audioFormat;
    private final CopyOnWriteArraySet audioListeners;
    private int audioSessionId;
    private float audioVolume;
    private CameraMotionListener cameraMotionListener;
    private final SimpleExoPlayer$ComponentListener componentListener;
    private List currentCues;
    private final long detachSurfaceTimeoutMs;
    private DeviceInfo deviceInfo;
    private final CopyOnWriteArraySet deviceListeners;
    private boolean hasNotifiedFullWrongThreadWarning;
    private boolean isPriorityTaskManagerRegistered;
    private AudioTrack keepSessionIdAudioTrack;
    private final CopyOnWriteArraySet metadataOutputs;
    private boolean ownsSurface;
    private final ExoPlayerImpl player;
    private boolean playerReleased;
    private PriorityTaskManager priorityTaskManager;
    public final Renderer[] renderers;
    private boolean skipSilenceEnabled;
    private final StreamVolumeManager streamVolumeManager;
    private Surface surface;
    private int surfaceHeight;
    private SurfaceHolder surfaceHolder;
    private int surfaceWidth;
    private final CopyOnWriteArraySet textOutputs;
    private TextureView textureView;
    private boolean throwsWhenUsingWrongThread;
    private DecoderCounters videoDecoderCounters;
    private Format videoFormat;
    private VideoFrameMetadataListener videoFrameMetadataListener;
    private final CopyOnWriteArraySet videoListeners;
    private int videoScalingMode;
    private final WakeLockManager wakeLockManager;
    private final WifiLockManager wifiLockManager;

    public SimpleExoPlayer(Context object, RenderersFactory renderersFactory, TrackSelector trackSelector, MediaSourceFactory mediaSourceFactory, LoadControl loadControl, BandwidthMeter bandwidthMeter, AnalyticsCollector analyticsCollector, boolean bl2, Clock clock, Looper looper) {
        SimpleExoPlayer$Builder simpleExoPlayer$Builder = new SimpleExoPlayer$Builder((Context)object, renderersFactory);
        object = simpleExoPlayer$Builder.setTrackSelector(trackSelector).setMediaSourceFactory(mediaSourceFactory).setLoadControl(loadControl).setBandwidthMeter(bandwidthMeter).setAnalyticsCollector(analyticsCollector).setUseLazyPreparation(bl2).setClock(clock).setLooper(looper);
        this((SimpleExoPlayer$Builder)object);
    }

    public SimpleExoPlayer(SimpleExoPlayer$Builder simpleExoPlayer$Builder) {
        boolean bl2;
        int n10;
        int n11;
        float f10;
        SimpleExoPlayer$ComponentListener simpleExoPlayer$ComponentListener;
        long l10;
        int n12;
        AnalyticsCollector analyticsCollector;
        SimpleExoPlayer simpleExoPlayer = this;
        Object object = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder).getApplicationContext();
        this.applicationContext = object;
        this.analyticsCollector = analyticsCollector = SimpleExoPlayer$Builder.access$100(simpleExoPlayer$Builder);
        Object object2 = SimpleExoPlayer$Builder.access$200(simpleExoPlayer$Builder);
        this.priorityTaskManager = object2;
        this.audioAttributes = object2 = SimpleExoPlayer$Builder.access$300(simpleExoPlayer$Builder);
        this.videoScalingMode = n12 = SimpleExoPlayer$Builder.access$400(simpleExoPlayer$Builder);
        n12 = (int)(SimpleExoPlayer$Builder.access$500(simpleExoPlayer$Builder) ? 1 : 0);
        this.skipSilenceEnabled = n12;
        this.detachSurfaceTimeoutMs = l10 = SimpleExoPlayer$Builder.access$600(simpleExoPlayer$Builder);
        Object object3 = null;
        this.componentListener = simpleExoPlayer$ComponentListener = new SimpleExoPlayer$ComponentListener(this, null);
        object2 = new CopyOnWriteArraySet();
        this.videoListeners = object2;
        object2 = new CopyOnWriteArraySet();
        this.audioListeners = object2;
        object2 = new CopyOnWriteArraySet();
        this.textOutputs = object2;
        object2 = new CopyOnWriteArraySet();
        this.metadataOutputs = object2;
        object2 = new CopyOnWriteArraySet();
        this.deviceListeners = object2;
        object2 = SimpleExoPlayer$Builder.access$800(simpleExoPlayer$Builder);
        Object object4 = new Handler((Looper)object2);
        Object object5 = SimpleExoPlayer$Builder.access$900(simpleExoPlayer$Builder);
        Object object6 = object4;
        Object object7 = simpleExoPlayer$ComponentListener;
        Object object8 = simpleExoPlayer$ComponentListener;
        object2 = object5.createRenderers((Handler)object4, simpleExoPlayer$ComponentListener, simpleExoPlayer$ComponentListener, simpleExoPlayer$ComponentListener, simpleExoPlayer$ComponentListener);
        this.renderers = object2;
        this.audioVolume = f10 = 1.0f;
        int n13 = Util.SDK_INT;
        boolean bl3 = false;
        int n14 = 21;
        this.audioSessionId = n13 < n14 ? (n11 = this.initializeKeepSessionIdAudioTrack(0)) : (n10 = C.generateAudioSessionIdV21((Context)object));
        object = Collections.emptyList();
        simpleExoPlayer.currentCues = object;
        simpleExoPlayer.throwsWhenUsingWrongThread = bl2 = true;
        Object object9 = SimpleExoPlayer$Builder.access$1000(simpleExoPlayer$Builder);
        MediaSourceFactory mediaSourceFactory = SimpleExoPlayer$Builder.access$1100(simpleExoPlayer$Builder);
        LoadControl loadControl = SimpleExoPlayer$Builder.access$1200(simpleExoPlayer$Builder);
        object5 = SimpleExoPlayer$Builder.access$1300(simpleExoPlayer$Builder);
        boolean bl4 = SimpleExoPlayer$Builder.access$1400(simpleExoPlayer$Builder);
        object7 = SimpleExoPlayer$Builder.access$1500(simpleExoPlayer$Builder);
        LivePlaybackSpeedControl livePlaybackSpeedControl = SimpleExoPlayer$Builder.access$1600(simpleExoPlayer$Builder);
        long l11 = SimpleExoPlayer$Builder.access$1700(simpleExoPlayer$Builder);
        boolean bl5 = SimpleExoPlayer$Builder.access$1800(simpleExoPlayer$Builder);
        Clock clock = SimpleExoPlayer$Builder.access$1900(simpleExoPlayer$Builder);
        Looper looper = SimpleExoPlayer$Builder.access$800(simpleExoPlayer$Builder);
        object = object8;
        Handler handler = object4;
        object4 = object5;
        object6 = object7;
        object7 = livePlaybackSpeedControl;
        livePlaybackSpeedControl = null;
        bl3 = bl5;
        object3 = clock;
        SimpleExoPlayer$ComponentListener simpleExoPlayer$ComponentListener2 = simpleExoPlayer$ComponentListener;
        simpleExoPlayer$ComponentListener = looper;
        simpleExoPlayer = this;
        object8 = new ExoPlayerImpl((Renderer[])object2, (TrackSelector)object9, mediaSourceFactory, loadControl, (BandwidthMeter)object5, analyticsCollector, bl4, (SeekParameters)object6, (LivePlaybackSpeedControl)object7, l11, bl5, clock, looper, this);
        object = this;
        object2 = object8;
        this.player = object8;
        object9 = simpleExoPlayer$ComponentListener2;
        ((ExoPlayerImpl)object8).addListener(simpleExoPlayer$ComponentListener2);
        mediaSourceFactory = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder);
        loadControl = handler;
        super((Context)mediaSourceFactory, handler, simpleExoPlayer$ComponentListener2);
        this.audioBecomingNoisyManager = object2;
        n14 = (int)(SimpleExoPlayer$Builder.access$2000(simpleExoPlayer$Builder) ? 1 : 0);
        ((AudioBecomingNoisyManager)object2).setEnabled(n14 != 0);
        mediaSourceFactory = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder);
        this.audioFocusManager = object2 = new AudioFocusManager((Context)mediaSourceFactory, handler, simpleExoPlayer$ComponentListener2);
        n14 = SimpleExoPlayer$Builder.access$2100(simpleExoPlayer$Builder);
        object3 = n14 != 0 ? this.audioAttributes : null;
        ((AudioFocusManager)object2).setAudioAttributes((AudioAttributes)object3);
        mediaSourceFactory = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder);
        ((SimpleExoPlayer)object).streamVolumeManager = object2 = new StreamVolumeManager((Context)mediaSourceFactory, (Handler)loadControl, (StreamVolumeManager$Listener)object9);
        n13 = Util.getStreamTypeForAudioUsage(object.audioAttributes.usage);
        ((StreamVolumeManager)object2).setStreamType(n13);
        mediaSourceFactory = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder);
        ((SimpleExoPlayer)object).wakeLockManager = object9 = new WakeLockManager((Context)mediaSourceFactory);
        n14 = SimpleExoPlayer$Builder.access$2200(simpleExoPlayer$Builder);
        bl3 = n14 != 0;
        ((WakeLockManager)object9).setEnabled(bl3);
        mediaSourceFactory = SimpleExoPlayer$Builder.access$000(simpleExoPlayer$Builder);
        ((SimpleExoPlayer)object).wifiLockManager = object9 = new WifiLockManager((Context)mediaSourceFactory);
        n14 = SimpleExoPlayer$Builder.access$2200(simpleExoPlayer$Builder);
        int n15 = 2;
        bl3 = n14 == n15;
        ((WifiLockManager)object9).setEnabled(bl3);
        ((SimpleExoPlayer)object).deviceInfo = object2 = SimpleExoPlayer.createDeviceInfo((StreamVolumeManager)object2);
        object2 = ((SimpleExoPlayer)object).audioSessionId;
        n13 = 102;
        n14 = 1;
        super.sendRendererMessage(n14, n13, object2);
        object2 = ((SimpleExoPlayer)object).audioSessionId;
        super.sendRendererMessage(n15, n13, object2);
        object9 = ((SimpleExoPlayer)object).audioAttributes;
        super.sendRendererMessage(n14, 3, object9);
        object9 = ((SimpleExoPlayer)object).videoScalingMode;
        super.sendRendererMessage(n15, 4, object9);
        object9 = ((SimpleExoPlayer)object).skipSilenceEnabled;
        super.sendRendererMessage(n14, 101, object9);
    }

    public static /* synthetic */ DecoderCounters access$2302(SimpleExoPlayer simpleExoPlayer, DecoderCounters decoderCounters) {
        simpleExoPlayer.videoDecoderCounters = decoderCounters;
        return decoderCounters;
    }

    public static /* synthetic */ AnalyticsCollector access$2400(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.analyticsCollector;
    }

    public static /* synthetic */ Format access$2502(SimpleExoPlayer simpleExoPlayer, Format format) {
        simpleExoPlayer.videoFormat = format;
        return format;
    }

    public static /* synthetic */ CopyOnWriteArraySet access$2600(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.videoListeners;
    }

    public static /* synthetic */ Surface access$2700(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.surface;
    }

    public static /* synthetic */ DecoderCounters access$2802(SimpleExoPlayer simpleExoPlayer, DecoderCounters decoderCounters) {
        simpleExoPlayer.audioDecoderCounters = decoderCounters;
        return decoderCounters;
    }

    public static /* synthetic */ Format access$2902(SimpleExoPlayer simpleExoPlayer, Format format) {
        simpleExoPlayer.audioFormat = format;
        return format;
    }

    public static /* synthetic */ boolean access$3000(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.skipSilenceEnabled;
    }

    public static /* synthetic */ boolean access$3002(SimpleExoPlayer simpleExoPlayer, boolean bl2) {
        simpleExoPlayer.skipSilenceEnabled = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$3100(SimpleExoPlayer simpleExoPlayer) {
        simpleExoPlayer.notifySkipSilenceEnabledChanged();
    }

    public static /* synthetic */ List access$3202(SimpleExoPlayer simpleExoPlayer, List list) {
        simpleExoPlayer.currentCues = list;
        return list;
    }

    public static /* synthetic */ CopyOnWriteArraySet access$3300(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.textOutputs;
    }

    public static /* synthetic */ CopyOnWriteArraySet access$3400(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.metadataOutputs;
    }

    public static /* synthetic */ void access$3500(SimpleExoPlayer simpleExoPlayer, Surface surface, boolean bl2) {
        simpleExoPlayer.setVideoSurfaceInternal(surface, bl2);
    }

    public static /* synthetic */ void access$3600(SimpleExoPlayer simpleExoPlayer, int n10, int n11) {
        simpleExoPlayer.maybeNotifySurfaceSizeChanged(n10, n11);
    }

    public static /* synthetic */ void access$3700(SimpleExoPlayer simpleExoPlayer) {
        simpleExoPlayer.sendVolumeToRenderers();
    }

    public static /* synthetic */ int access$3800(boolean bl2, int n10) {
        return SimpleExoPlayer.getPlayWhenReadyChangeReason(bl2, n10);
    }

    public static /* synthetic */ void access$3900(SimpleExoPlayer simpleExoPlayer, boolean bl2, int n10, int n11) {
        simpleExoPlayer.updatePlayWhenReady(bl2, n10, n11);
    }

    public static /* synthetic */ StreamVolumeManager access$4000(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.streamVolumeManager;
    }

    public static /* synthetic */ DeviceInfo access$4100(StreamVolumeManager streamVolumeManager) {
        return SimpleExoPlayer.createDeviceInfo(streamVolumeManager);
    }

    public static /* synthetic */ DeviceInfo access$4200(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.deviceInfo;
    }

    public static /* synthetic */ DeviceInfo access$4202(SimpleExoPlayer simpleExoPlayer, DeviceInfo deviceInfo) {
        simpleExoPlayer.deviceInfo = deviceInfo;
        return deviceInfo;
    }

    public static /* synthetic */ CopyOnWriteArraySet access$4300(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.deviceListeners;
    }

    public static /* synthetic */ PriorityTaskManager access$4400(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.priorityTaskManager;
    }

    public static /* synthetic */ boolean access$4500(SimpleExoPlayer simpleExoPlayer) {
        return simpleExoPlayer.isPriorityTaskManagerRegistered;
    }

    public static /* synthetic */ boolean access$4502(SimpleExoPlayer simpleExoPlayer, boolean bl2) {
        simpleExoPlayer.isPriorityTaskManagerRegistered = bl2;
        return bl2;
    }

    public static /* synthetic */ void access$4600(SimpleExoPlayer simpleExoPlayer) {
        simpleExoPlayer.updateWakeAndWifiLock();
    }

    private static DeviceInfo createDeviceInfo(StreamVolumeManager streamVolumeManager) {
        int n10 = streamVolumeManager.getMinVolume();
        int n11 = streamVolumeManager.getMaxVolume();
        DeviceInfo deviceInfo = new DeviceInfo(0, n10, n11);
        return deviceInfo;
    }

    private static int getPlayWhenReadyChangeReason(boolean bl2, int n10) {
        int n11 = 1;
        if (bl2 && n10 != n11) {
            n11 = 2;
        }
        return n11;
    }

    private int initializeKeepSessionIdAudioTrack(int n10) {
        int n11;
        AudioTrack audioTrack = this.keepSessionIdAudioTrack;
        if (audioTrack != null && (n11 = audioTrack.getAudioSessionId()) != n10) {
            this.keepSessionIdAudioTrack.release();
            n11 = 0;
            audioTrack = null;
            this.keepSessionIdAudioTrack = null;
        }
        if ((audioTrack = this.keepSessionIdAudioTrack) == null) {
            int n12 = 4000;
            int n13 = 4;
            int n14 = 2;
            int n15 = 2;
            int n16 = 3;
            this.keepSessionIdAudioTrack = audioTrack = new AudioTrack(n16, n12, n13, n14, n15, 0, n10);
        }
        return this.keepSessionIdAudioTrack.getAudioSessionId();
    }

    private void maybeNotifySurfaceSizeChanged(int n10, int n11) {
        int n12 = this.surfaceWidth;
        if (n10 != n12 || n11 != (n12 = this.surfaceHeight)) {
            boolean bl2;
            this.surfaceWidth = n10;
            this.surfaceHeight = n11;
            this.analyticsCollector.onSurfaceSizeChanged(n10, n11);
            Iterator iterator2 = this.videoListeners.iterator();
            while (bl2 = iterator2.hasNext()) {
                VideoListener videoListener = (VideoListener)iterator2.next();
                videoListener.onSurfaceSizeChanged(n10, n11);
            }
        }
    }

    private void notifySkipSilenceEnabledChanged() {
        Object object = this.analyticsCollector;
        boolean bl2 = this.skipSilenceEnabled;
        ((AnalyticsCollector)object).onSkipSilenceEnabledChanged(bl2);
        object = this.audioListeners.iterator();
        while (bl2 = object.hasNext()) {
            AudioListener audioListener = (AudioListener)object.next();
            boolean bl3 = this.skipSilenceEnabled;
            audioListener.onSkipSilenceEnabledChanged(bl3);
        }
    }

    private void removeSurfaceCallbacks() {
        Object object;
        Object object2 = this.textureView;
        if (object2 != null) {
            if ((object2 = object2.getSurfaceTextureListener()) != (object = this.componentListener)) {
                object2 = TAG;
                object = "SurfaceTextureListener already unset or replaced.";
                Log.w((String)object2, (String)object);
            } else {
                object2 = this.textureView;
                object2.setSurfaceTextureListener(null);
            }
            this.textureView = null;
        }
        if ((object2 = this.surfaceHolder) != null) {
            object = this.componentListener;
            object2.removeCallback((SurfaceHolder.Callback)object);
            this.surfaceHolder = null;
        }
    }

    private void sendRendererMessage(int n10, int n11, Object object) {
        for (Renderer renderer : this.renderers) {
            int n12 = renderer.getTrackType();
            if (n12 != n10) continue;
            ExoPlayerImpl exoPlayerImpl = this.player;
            PlayerMessage playerMessage = exoPlayerImpl.createMessage(renderer).setType(n11).setPayload(object);
            playerMessage.send();
        }
    }

    private void sendVolumeToRenderers() {
        float f10 = this.audioVolume;
        float f11 = this.audioFocusManager.getVolumeMultiplier();
        Float f12 = Float.valueOf(f10 * f11);
        this.sendRendererMessage(1, 2, f12);
    }

    private void setVideoDecoderOutputBufferRenderer(VideoDecoderOutputBufferRenderer videoDecoderOutputBufferRenderer) {
        this.sendRendererMessage(2, 8, videoDecoderOutputBufferRenderer);
    }

    private void setVideoSurfaceInternal(Surface surface, boolean bl2) {
        Object object = new ArrayList();
        for (Object object2 : this.renderers) {
            int n10;
            int n11 = object2.getTrackType();
            if (n11 != (n10 = 2)) continue;
            ExoPlayerImpl exoPlayerImpl = this.player;
            object2 = exoPlayerImpl.createMessage((PlayerMessage$Target)object2);
            n11 = 1;
            object2 = ((PlayerMessage)object2).setType(n11).setPayload(surface).send();
            object.add(object2);
        }
        Object object3 = this.surface;
        if (object3 != null && object3 != surface) {
            boolean bl3;
            block12: {
                try {
                    object = object.iterator();
                }
                catch (TimeoutException timeoutException) {
                    object = this.player;
                    int n12 = 3;
                    object3 = new ExoTimeoutException(n12);
                    object3 = ExoPlaybackException.createForRenderer((Exception)object3);
                    ((ExoPlayerImpl)object).stop(false, (ExoPlaybackException)object3);
                    break block12;
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
                while (true) {
                    boolean bl4 = object.hasNext();
                    if (!bl4) break;
                    object3 = object.next();
                    object3 = (PlayerMessage)object3;
                    long l10 = this.detachSurfaceTimeoutMs;
                    ((PlayerMessage)object3).blockUntilDelivered(l10);
                    continue;
                    break;
                }
            }
            if (bl3 = this.ownsSurface) {
                object = this.surface;
                object.release();
            }
        }
        this.surface = surface;
        this.ownsSurface = bl2;
    }

    private void updatePlayWhenReady(boolean n10, int n11, int n12) {
        int n13 = 0;
        int n14 = 1;
        if ((n10 = n10 != 0 && n11 != (n10 = -1) ? n14 : 0) != 0 && n11 != n14) {
            n13 = n14;
        }
        this.player.setPlayWhenReady(n10 != 0, n13, n12);
    }

    /*
     * Enabled aggressive block sorting
     */
    private void updateWakeAndWifiLock() {
        int n10;
        int n11 = this.getPlaybackState();
        if (n11 != (n10 = 1)) {
            int n12 = 2;
            if (n11 != n12 && n11 != (n12 = 3)) {
                n10 = 4;
                if (n11 != n10) {
                    IllegalStateException illegalStateException = new IllegalStateException();
                    throw illegalStateException;
                }
            } else {
                n11 = (int)(this.experimentalIsSleepingForOffload() ? 1 : 0);
                WakeLockManager wakeLockManager = this.wakeLockManager;
                boolean bl2 = this.getPlayWhenReady();
                if (!bl2 || n11) {
                    n10 = 0;
                }
                wakeLockManager.setStayAwake(n10 != 0);
                WifiLockManager wifiLockManager = this.wifiLockManager;
                n10 = this.getPlayWhenReady();
                wifiLockManager.setStayAwake(n10 != 0);
                return;
            }
        }
        this.wakeLockManager.setStayAwake(false);
        WifiLockManager wifiLockManager = this.wifiLockManager;
        wifiLockManager.setStayAwake(false);
    }

    private void verifyApplicationThread() {
        Object object;
        Object object2 = Looper.myLooper();
        if (object2 != (object = this.getApplicationLooper())) {
            boolean bl2 = this.throwsWhenUsingWrongThread;
            object = WRONG_THREAD_ERROR_MESSAGE;
            if (!bl2) {
                bl2 = this.hasNotifiedFullWrongThreadWarning;
                if (bl2) {
                    bl2 = false;
                    object2 = null;
                } else {
                    object2 = new IllegalStateException();
                }
                String string2 = TAG;
                Log.w(string2, (String)object, (Throwable)object2);
                this.hasNotifiedFullWrongThreadWarning = bl2 = true;
            } else {
                object2 = new IllegalStateException((String)object);
                throw object2;
            }
        }
    }

    public void addAnalyticsListener(AnalyticsListener analyticsListener) {
        Assertions.checkNotNull(analyticsListener);
        this.analyticsCollector.addListener(analyticsListener);
    }

    public void addAudioListener(AudioListener audioListener) {
        Assertions.checkNotNull(audioListener);
        this.audioListeners.add(audioListener);
    }

    public void addDeviceListener(DeviceListener deviceListener) {
        Assertions.checkNotNull(deviceListener);
        this.deviceListeners.add(deviceListener);
    }

    public void addListener(Player$EventListener player$EventListener) {
        Assertions.checkNotNull(player$EventListener);
        this.player.addListener(player$EventListener);
    }

    public void addMediaItem(int n10, MediaItem mediaItem) {
        this.verifyApplicationThread();
        this.player.addMediaItem(n10, mediaItem);
    }

    public void addMediaItem(MediaItem mediaItem) {
        this.verifyApplicationThread();
        this.player.addMediaItem(mediaItem);
    }

    public void addMediaItems(int n10, List list) {
        this.verifyApplicationThread();
        this.player.addMediaItems(n10, list);
    }

    public void addMediaItems(List list) {
        this.verifyApplicationThread();
        this.player.addMediaItems(list);
    }

    public void addMediaSource(int n10, MediaSource mediaSource) {
        this.verifyApplicationThread();
        this.player.addMediaSource(n10, mediaSource);
    }

    public void addMediaSource(MediaSource mediaSource) {
        this.verifyApplicationThread();
        this.player.addMediaSource(mediaSource);
    }

    public void addMediaSources(int n10, List list) {
        this.verifyApplicationThread();
        this.player.addMediaSources(n10, list);
    }

    public void addMediaSources(List list) {
        this.verifyApplicationThread();
        this.player.addMediaSources(list);
    }

    public void addMetadataOutput(MetadataOutput metadataOutput) {
        Assertions.checkNotNull(metadataOutput);
        this.metadataOutputs.add(metadataOutput);
    }

    public void addTextOutput(TextOutput textOutput) {
        Assertions.checkNotNull(textOutput);
        this.textOutputs.add(textOutput);
    }

    public void addVideoListener(VideoListener videoListener) {
        Assertions.checkNotNull(videoListener);
        this.videoListeners.add(videoListener);
    }

    public void clearAuxEffectInfo() {
        AuxEffectInfo auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        this.setAuxEffectInfo(auxEffectInfo);
    }

    public void clearCameraMotionListener(CameraMotionListener cameraMotionListener) {
        this.verifyApplicationThread();
        CameraMotionListener cameraMotionListener2 = this.cameraMotionListener;
        if (cameraMotionListener2 != cameraMotionListener) {
            return;
        }
        this.sendRendererMessage(6, 7, null);
    }

    public void clearMediaItems() {
        this.verifyApplicationThread();
        this.player.clearMediaItems();
    }

    public void clearVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.verifyApplicationThread();
        VideoFrameMetadataListener videoFrameMetadataListener2 = this.videoFrameMetadataListener;
        if (videoFrameMetadataListener2 != videoFrameMetadataListener) {
            return;
        }
        this.sendRendererMessage(2, 6, null);
    }

    public void clearVideoSurface() {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        this.setVideoSurfaceInternal(null, false);
        this.maybeNotifySurfaceSizeChanged(0, 0);
    }

    public void clearVideoSurface(Surface surface) {
        Surface surface2;
        this.verifyApplicationThread();
        if (surface != null && surface == (surface2 = this.surface)) {
            this.clearVideoSurface();
        }
    }

    public void clearVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        SurfaceHolder surfaceHolder2;
        this.verifyApplicationThread();
        if (surfaceHolder != null && surfaceHolder == (surfaceHolder2 = this.surfaceHolder)) {
            surfaceHolder = null;
            this.setVideoSurfaceHolder(null);
        }
    }

    public void clearVideoSurfaceView(SurfaceView surfaceView) {
        this.verifyApplicationThread();
        boolean bl2 = surfaceView instanceof VideoDecoderGLSurfaceView;
        SurfaceHolder surfaceHolder = null;
        if (bl2) {
            SurfaceHolder surfaceHolder2;
            if ((surfaceView = surfaceView.getHolder()) == (surfaceHolder2 = this.surfaceHolder)) {
                this.setVideoDecoderOutputBufferRenderer(null);
                this.surfaceHolder = null;
            }
        } else {
            if (surfaceView != null) {
                surfaceHolder = surfaceView.getHolder();
            }
            this.clearVideoSurfaceHolder(surfaceHolder);
        }
    }

    public void clearVideoTextureView(TextureView textureView) {
        TextureView textureView2;
        this.verifyApplicationThread();
        if (textureView != null && textureView == (textureView2 = this.textureView)) {
            textureView = null;
            this.setVideoTextureView(null);
        }
    }

    public PlayerMessage createMessage(PlayerMessage$Target playerMessage$Target) {
        this.verifyApplicationThread();
        return this.player.createMessage(playerMessage$Target);
    }

    public void decreaseDeviceVolume() {
        this.verifyApplicationThread();
        this.streamVolumeManager.decreaseVolume();
    }

    public boolean experimentalIsSleepingForOffload() {
        this.verifyApplicationThread();
        return this.player.experimentalIsSleepingForOffload();
    }

    public void experimentalSetOffloadSchedulingEnabled(boolean bl2) {
        this.verifyApplicationThread();
        this.player.experimentalSetOffloadSchedulingEnabled(bl2);
    }

    public AnalyticsCollector getAnalyticsCollector() {
        return this.analyticsCollector;
    }

    public Looper getApplicationLooper() {
        return this.player.getApplicationLooper();
    }

    public AudioAttributes getAudioAttributes() {
        return this.audioAttributes;
    }

    public Player$AudioComponent getAudioComponent() {
        return this;
    }

    public DecoderCounters getAudioDecoderCounters() {
        return this.audioDecoderCounters;
    }

    public Format getAudioFormat() {
        return this.audioFormat;
    }

    public int getAudioSessionId() {
        return this.audioSessionId;
    }

    public long getBufferedPosition() {
        this.verifyApplicationThread();
        return this.player.getBufferedPosition();
    }

    public Clock getClock() {
        return this.player.getClock();
    }

    public long getContentBufferedPosition() {
        this.verifyApplicationThread();
        return this.player.getContentBufferedPosition();
    }

    public long getContentPosition() {
        this.verifyApplicationThread();
        return this.player.getContentPosition();
    }

    public int getCurrentAdGroupIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentAdGroupIndex();
    }

    public int getCurrentAdIndexInAdGroup() {
        this.verifyApplicationThread();
        return this.player.getCurrentAdIndexInAdGroup();
    }

    public List getCurrentCues() {
        this.verifyApplicationThread();
        return this.currentCues;
    }

    public int getCurrentPeriodIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentPeriodIndex();
    }

    public long getCurrentPosition() {
        this.verifyApplicationThread();
        return this.player.getCurrentPosition();
    }

    public List getCurrentStaticMetadata() {
        this.verifyApplicationThread();
        return this.player.getCurrentStaticMetadata();
    }

    public Timeline getCurrentTimeline() {
        this.verifyApplicationThread();
        return this.player.getCurrentTimeline();
    }

    public TrackGroupArray getCurrentTrackGroups() {
        this.verifyApplicationThread();
        return this.player.getCurrentTrackGroups();
    }

    public TrackSelectionArray getCurrentTrackSelections() {
        this.verifyApplicationThread();
        return this.player.getCurrentTrackSelections();
    }

    public int getCurrentWindowIndex() {
        this.verifyApplicationThread();
        return this.player.getCurrentWindowIndex();
    }

    public Player$DeviceComponent getDeviceComponent() {
        return this;
    }

    public DeviceInfo getDeviceInfo() {
        this.verifyApplicationThread();
        return this.deviceInfo;
    }

    public int getDeviceVolume() {
        this.verifyApplicationThread();
        return this.streamVolumeManager.getVolume();
    }

    public long getDuration() {
        this.verifyApplicationThread();
        return this.player.getDuration();
    }

    public Player$MetadataComponent getMetadataComponent() {
        return this;
    }

    public boolean getPauseAtEndOfMediaItems() {
        this.verifyApplicationThread();
        return this.player.getPauseAtEndOfMediaItems();
    }

    public boolean getPlayWhenReady() {
        this.verifyApplicationThread();
        return this.player.getPlayWhenReady();
    }

    public ExoPlaybackException getPlaybackError() {
        return this.getPlayerError();
    }

    public Looper getPlaybackLooper() {
        return this.player.getPlaybackLooper();
    }

    public PlaybackParameters getPlaybackParameters() {
        this.verifyApplicationThread();
        return this.player.getPlaybackParameters();
    }

    public int getPlaybackState() {
        this.verifyApplicationThread();
        return this.player.getPlaybackState();
    }

    public int getPlaybackSuppressionReason() {
        this.verifyApplicationThread();
        return this.player.getPlaybackSuppressionReason();
    }

    public ExoPlaybackException getPlayerError() {
        this.verifyApplicationThread();
        return this.player.getPlayerError();
    }

    public int getRendererCount() {
        this.verifyApplicationThread();
        return this.player.getRendererCount();
    }

    public int getRendererType(int n10) {
        this.verifyApplicationThread();
        return this.player.getRendererType(n10);
    }

    public int getRepeatMode() {
        this.verifyApplicationThread();
        return this.player.getRepeatMode();
    }

    public SeekParameters getSeekParameters() {
        this.verifyApplicationThread();
        return this.player.getSeekParameters();
    }

    public boolean getShuffleModeEnabled() {
        this.verifyApplicationThread();
        return this.player.getShuffleModeEnabled();
    }

    public boolean getSkipSilenceEnabled() {
        return this.skipSilenceEnabled;
    }

    public Player$TextComponent getTextComponent() {
        return this;
    }

    public long getTotalBufferedDuration() {
        this.verifyApplicationThread();
        return this.player.getTotalBufferedDuration();
    }

    public TrackSelector getTrackSelector() {
        this.verifyApplicationThread();
        return this.player.getTrackSelector();
    }

    public Player$VideoComponent getVideoComponent() {
        return this;
    }

    public DecoderCounters getVideoDecoderCounters() {
        return this.videoDecoderCounters;
    }

    public Format getVideoFormat() {
        return this.videoFormat;
    }

    public int getVideoScalingMode() {
        return this.videoScalingMode;
    }

    public float getVolume() {
        return this.audioVolume;
    }

    public void increaseDeviceVolume() {
        this.verifyApplicationThread();
        this.streamVolumeManager.increaseVolume();
    }

    public boolean isDeviceMuted() {
        this.verifyApplicationThread();
        return this.streamVolumeManager.isMuted();
    }

    public boolean isLoading() {
        this.verifyApplicationThread();
        return this.player.isLoading();
    }

    public boolean isPlayingAd() {
        this.verifyApplicationThread();
        return this.player.isPlayingAd();
    }

    public void moveMediaItem(int n10, int n11) {
        this.verifyApplicationThread();
        this.player.moveMediaItem(n10, n11);
    }

    public void moveMediaItems(int n10, int n11, int n12) {
        this.verifyApplicationThread();
        this.player.moveMediaItems(n10, n11, n12);
    }

    public void prepare() {
        this.verifyApplicationThread();
        boolean bl2 = this.getPlayWhenReady();
        int n10 = this.audioFocusManager.updateAudioFocus(bl2, 2);
        int n11 = SimpleExoPlayer.getPlayWhenReadyChangeReason(bl2, n10);
        this.updatePlayWhenReady(bl2, n10, n11);
        this.player.prepare();
    }

    public void prepare(MediaSource mediaSource) {
        boolean bl2 = true;
        this.prepare(mediaSource, bl2, bl2);
    }

    public void prepare(MediaSource object, boolean n10, boolean bl2) {
        this.verifyApplicationThread();
        object = Collections.singletonList(object);
        n10 = n10 != 0 ? 0 : -1;
        this.setMediaSources((List)object, n10, -9223372036854775807L);
        this.prepare();
    }

    public void release() {
        Object object;
        this.verifyApplicationThread();
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 < n11 && (object = this.keepSessionIdAudioTrack) != null) {
            object.release();
            this.keepSessionIdAudioTrack = null;
        }
        object = this.audioBecomingNoisyManager;
        n11 = 0;
        ((AudioBecomingNoisyManager)object).setEnabled(false);
        this.streamVolumeManager.release();
        this.wakeLockManager.setStayAwake(false);
        this.wifiLockManager.setStayAwake(false);
        this.audioFocusManager.release();
        this.player.release();
        this.analyticsCollector.release();
        this.removeSurfaceCallbacks();
        object = this.surface;
        if (object != null) {
            boolean bl2 = this.ownsSurface;
            if (bl2) {
                object.release();
            }
            this.surface = null;
        }
        if ((n10 = (int)(this.isPriorityTaskManagerRegistered ? 1 : 0)) != 0) {
            object = (PriorityTaskManager)Assertions.checkNotNull(this.priorityTaskManager);
            ((PriorityTaskManager)object).remove(0);
            this.isPriorityTaskManagerRegistered = false;
        }
        this.currentCues = object = Collections.emptyList();
        this.playerReleased = true;
    }

    public void removeAnalyticsListener(AnalyticsListener analyticsListener) {
        this.analyticsCollector.removeListener(analyticsListener);
    }

    public void removeAudioListener(AudioListener audioListener) {
        this.audioListeners.remove(audioListener);
    }

    public void removeDeviceListener(DeviceListener deviceListener) {
        this.deviceListeners.remove(deviceListener);
    }

    public void removeListener(Player$EventListener player$EventListener) {
        this.player.removeListener(player$EventListener);
    }

    public void removeMediaItem(int n10) {
        this.verifyApplicationThread();
        this.player.removeMediaItem(n10);
    }

    public void removeMediaItems(int n10, int n11) {
        this.verifyApplicationThread();
        this.player.removeMediaItems(n10, n11);
    }

    public void removeMetadataOutput(MetadataOutput metadataOutput) {
        this.metadataOutputs.remove(metadataOutput);
    }

    public void removeTextOutput(TextOutput textOutput) {
        this.textOutputs.remove(textOutput);
    }

    public void removeVideoListener(VideoListener videoListener) {
        this.videoListeners.remove(videoListener);
    }

    public void retry() {
        this.verifyApplicationThread();
        this.prepare();
    }

    public void seekTo(int n10, long l10) {
        this.verifyApplicationThread();
        this.analyticsCollector.notifySeekStarted();
        this.player.seekTo(n10, l10);
    }

    public void setAudioAttributes(AudioAttributes audioAttributes, boolean bl2) {
        boolean bl3;
        this.verifyApplicationThread();
        boolean bl4 = this.playerReleased;
        if (bl4) {
            return;
        }
        Object object = this.audioAttributes;
        boolean bl5 = Util.areEqual(object, audioAttributes);
        if (!bl5) {
            this.audioAttributes = audioAttributes;
            int n10 = 1;
            this.sendRendererMessage(n10, 3, audioAttributes);
            object = this.streamVolumeManager;
            int n11 = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            ((StreamVolumeManager)object).setStreamType(n11);
            this.analyticsCollector.onAudioAttributesChanged(audioAttributes);
            object = this.audioListeners.iterator();
            while ((n11 = (int)(object.hasNext() ? 1 : 0)) != 0) {
                AudioListener audioListener = (AudioListener)object.next();
                audioListener.onAudioAttributesChanged(audioAttributes);
            }
        }
        object = this.audioFocusManager;
        if (!bl2) {
            bl3 = false;
            audioAttributes = null;
        }
        ((AudioFocusManager)object).setAudioAttributes(audioAttributes);
        bl3 = this.getPlayWhenReady();
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        int n12 = this.getPlaybackState();
        int n13 = audioFocusManager.updateAudioFocus(bl3, n12);
        int n14 = SimpleExoPlayer.getPlayWhenReadyChangeReason(bl3, n13);
        this.updatePlayWhenReady(bl3, n13, n14);
    }

    public void setAudioSessionId(int n10) {
        int n11;
        this.verifyApplicationThread();
        int n12 = this.audioSessionId;
        if (n12 == n10) {
            return;
        }
        n12 = 21;
        if (n10 == 0) {
            Context context;
            n10 = Util.SDK_INT;
            if (n10 < n12) {
                context = null;
                n10 = this.initializeKeepSessionIdAudioTrack(0);
            } else {
                context = this.applicationContext;
                n10 = C.generateAudioSessionIdV21(context);
            }
        } else {
            n11 = Util.SDK_INT;
            if (n11 < n12) {
                this.initializeKeepSessionIdAudioTrack(n10);
            }
        }
        this.audioSessionId = n10;
        Object object = n10;
        int n13 = 102;
        this.sendRendererMessage(1, n13, object);
        n12 = 2;
        object = n10;
        this.sendRendererMessage(n12, n13, object);
        this.analyticsCollector.onAudioSessionIdChanged(n10);
        Iterator iterator2 = this.audioListeners.iterator();
        while ((n11 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            object = (AudioListener)iterator2.next();
            object.onAudioSessionIdChanged(n10);
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo) {
        this.verifyApplicationThread();
        this.sendRendererMessage(1, 5, auxEffectInfo);
    }

    public void setCameraMotionListener(CameraMotionListener cameraMotionListener) {
        this.verifyApplicationThread();
        this.cameraMotionListener = cameraMotionListener;
        this.sendRendererMessage(6, 7, cameraMotionListener);
    }

    public void setDeviceMuted(boolean bl2) {
        this.verifyApplicationThread();
        this.streamVolumeManager.setMuted(bl2);
    }

    public void setDeviceVolume(int n10) {
        this.verifyApplicationThread();
        this.streamVolumeManager.setVolume(n10);
    }

    public void setForegroundMode(boolean bl2) {
        this.verifyApplicationThread();
        this.player.setForegroundMode(bl2);
    }

    public void setHandleAudioBecomingNoisy(boolean bl2) {
        this.verifyApplicationThread();
        boolean bl3 = this.playerReleased;
        if (bl3) {
            return;
        }
        this.audioBecomingNoisyManager.setEnabled(bl2);
    }

    public void setHandleWakeLock(boolean bl2) {
        this.setWakeMode((int)(bl2 ? 1 : 0));
    }

    public void setMediaItem(MediaItem mediaItem) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem);
    }

    public void setMediaItem(MediaItem mediaItem, long l10) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, l10);
    }

    public void setMediaItem(MediaItem mediaItem, boolean bl2) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItem(mediaItem, bl2);
    }

    public void setMediaItems(List list) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list);
    }

    public void setMediaItems(List list, int n10, long l10) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, n10, l10);
    }

    public void setMediaItems(List list, boolean bl2) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaItems(list, bl2);
    }

    public void setMediaSource(MediaSource mediaSource) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource);
    }

    public void setMediaSource(MediaSource mediaSource, long l10) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, l10);
    }

    public void setMediaSource(MediaSource mediaSource, boolean bl2) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSource(mediaSource, bl2);
    }

    public void setMediaSources(List list) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list);
    }

    public void setMediaSources(List list, int n10, long l10) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, n10, l10);
    }

    public void setMediaSources(List list, boolean bl2) {
        this.verifyApplicationThread();
        this.analyticsCollector.resetForNewPlaylist();
        this.player.setMediaSources(list, bl2);
    }

    public void setPauseAtEndOfMediaItems(boolean bl2) {
        this.verifyApplicationThread();
        this.player.setPauseAtEndOfMediaItems(bl2);
    }

    public void setPlayWhenReady(boolean bl2) {
        this.verifyApplicationThread();
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        int n10 = this.getPlaybackState();
        int n11 = audioFocusManager.updateAudioFocus(bl2, n10);
        n10 = SimpleExoPlayer.getPlayWhenReadyChangeReason(bl2, n11);
        this.updatePlayWhenReady(bl2, n11, n10);
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        this.verifyApplicationThread();
        this.player.setPlaybackParameters(playbackParameters);
    }

    public void setPriorityTaskManager(PriorityTaskManager priorityTaskManager) {
        this.verifyApplicationThread();
        PriorityTaskManager priorityTaskManager2 = this.priorityTaskManager;
        boolean bl2 = Util.areEqual(priorityTaskManager2, priorityTaskManager);
        if (bl2) {
            return;
        }
        bl2 = this.isPriorityTaskManagerRegistered;
        if (bl2) {
            priorityTaskManager2 = (PriorityTaskManager)Assertions.checkNotNull(this.priorityTaskManager);
            priorityTaskManager2.remove(0);
        }
        if (priorityTaskManager != null && (bl2 = this.isLoading())) {
            priorityTaskManager.add(0);
            this.isPriorityTaskManagerRegistered = bl2 = true;
        } else {
            this.isPriorityTaskManagerRegistered = false;
        }
        this.priorityTaskManager = priorityTaskManager;
    }

    public void setRepeatMode(int n10) {
        this.verifyApplicationThread();
        this.player.setRepeatMode(n10);
    }

    public void setSeekParameters(SeekParameters seekParameters) {
        this.verifyApplicationThread();
        this.player.setSeekParameters(seekParameters);
    }

    public void setShuffleModeEnabled(boolean bl2) {
        this.verifyApplicationThread();
        this.player.setShuffleModeEnabled(bl2);
    }

    public void setShuffleOrder(ShuffleOrder shuffleOrder) {
        this.verifyApplicationThread();
        this.player.setShuffleOrder(shuffleOrder);
    }

    public void setSkipSilenceEnabled(boolean bl2) {
        this.verifyApplicationThread();
        boolean bl3 = this.skipSilenceEnabled;
        if (bl3 == bl2) {
            return;
        }
        this.skipSilenceEnabled = bl2;
        Boolean bl4 = bl2;
        this.sendRendererMessage(1, 101, bl4);
        this.notifySkipSilenceEnabledChanged();
    }

    public void setThrowsWhenUsingWrongThread(boolean bl2) {
        this.throwsWhenUsingWrongThread = bl2;
    }

    public void setVideoFrameMetadataListener(VideoFrameMetadataListener videoFrameMetadataListener) {
        this.verifyApplicationThread();
        this.videoFrameMetadataListener = videoFrameMetadataListener;
        this.sendRendererMessage(2, 6, videoFrameMetadataListener);
    }

    public void setVideoScalingMode(int n10) {
        this.verifyApplicationThread();
        this.videoScalingMode = n10;
        Integer n11 = n10;
        this.sendRendererMessage(2, 4, n11);
    }

    public void setVideoSurface(Surface surface) {
        int n10;
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        if (surface != null) {
            n10 = 0;
            this.setVideoDecoderOutputBufferRenderer(null);
        }
        n10 = 0;
        this.setVideoSurfaceInternal(surface, false);
        if (surface != null) {
            n10 = -1;
        }
        this.maybeNotifySurfaceSizeChanged(n10, n10);
    }

    public void setVideoSurfaceHolder(SurfaceHolder surfaceHolder) {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        int n10 = 0;
        if (surfaceHolder != null) {
            this.setVideoDecoderOutputBufferRenderer(null);
        }
        this.surfaceHolder = surfaceHolder;
        if (surfaceHolder == null) {
            this.setVideoSurfaceInternal(null, false);
            this.maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            boolean bl2;
            SimpleExoPlayer$ComponentListener simpleExoPlayer$ComponentListener = this.componentListener;
            surfaceHolder.addCallback((SurfaceHolder.Callback)simpleExoPlayer$ComponentListener);
            simpleExoPlayer$ComponentListener = surfaceHolder.getSurface();
            if (simpleExoPlayer$ComponentListener != null && (bl2 = simpleExoPlayer$ComponentListener.isValid())) {
                this.setVideoSurfaceInternal((Surface)simpleExoPlayer$ComponentListener, false);
                surfaceHolder = surfaceHolder.getSurfaceFrame();
                n10 = surfaceHolder.width();
                int n11 = surfaceHolder.height();
                this.maybeNotifySurfaceSizeChanged(n10, n11);
            } else {
                this.setVideoSurfaceInternal(null, false);
                this.maybeNotifySurfaceSizeChanged(0, 0);
            }
        }
    }

    public void setVideoSurfaceView(SurfaceView object) {
        this.verifyApplicationThread();
        boolean bl2 = object instanceof VideoDecoderGLSurfaceView;
        if (bl2) {
            Object object2 = object;
            object2 = ((VideoDecoderGLSurfaceView)((Object)object)).getVideoDecoderOutputBufferRenderer();
            this.clearVideoSurface();
            object = object.getHolder();
            this.surfaceHolder = object;
            this.setVideoDecoderOutputBufferRenderer((VideoDecoderOutputBufferRenderer)object2);
        } else {
            object = object == null ? null : object.getHolder();
            this.setVideoSurfaceHolder((SurfaceHolder)object);
        }
    }

    public void setVideoTextureView(TextureView textureView) {
        this.verifyApplicationThread();
        this.removeSurfaceCallbacks();
        int n10 = 0;
        Surface surface = null;
        if (textureView != null) {
            this.setVideoDecoderOutputBufferRenderer(null);
        }
        this.textureView = textureView;
        boolean bl2 = true;
        if (textureView == null) {
            this.setVideoSurfaceInternal(null, bl2);
            this.maybeNotifySurfaceSizeChanged(0, 0);
        } else {
            Object object = textureView.getSurfaceTextureListener();
            if (object != null) {
                object = TAG;
                String string2 = "Replacing existing SurfaceTextureListener.";
                Log.w((String)object, string2);
            }
            object = this.componentListener;
            textureView.setSurfaceTextureListener(object);
            boolean bl3 = textureView.isAvailable();
            if (bl3) {
                object = textureView.getSurfaceTexture();
            } else {
                bl3 = false;
                object = null;
            }
            if (object == null) {
                this.setVideoSurfaceInternal(null, bl2);
                this.maybeNotifySurfaceSizeChanged(0, 0);
            } else {
                surface = new Surface((SurfaceTexture)object);
                this.setVideoSurfaceInternal(surface, bl2);
                n10 = textureView.getWidth();
                int n11 = textureView.getHeight();
                this.maybeNotifySurfaceSizeChanged(n10, n11);
            }
        }
    }

    public void setVolume(float f10) {
        this.verifyApplicationThread();
        Iterator iterator2 = null;
        int n10 = 1065353216;
        float f11 = 1.0f;
        f10 = Util.constrainValue(f10, 0.0f, f11);
        float f12 = this.audioVolume;
        float f13 = f12 == f10 ? 0 : (f12 > f10 ? 1 : -1);
        if (f13 == false) {
            return;
        }
        this.audioVolume = f10;
        this.sendVolumeToRenderers();
        this.analyticsCollector.onVolumeChanged(f10);
        iterator2 = this.audioListeners.iterator();
        while ((n10 = (int)(iterator2.hasNext() ? 1 : 0)) != 0) {
            AudioListener audioListener = (AudioListener)iterator2.next();
            audioListener.onVolumeChanged(f10);
        }
    }

    public void setWakeMode(int n10) {
        this.verifyApplicationThread();
        int n11 = 0;
        if (n10 != 0) {
            int n12 = 1;
            if (n10 != n12) {
                n11 = 2;
                if (n10 == n11) {
                    this.wakeLockManager.setEnabled(n12 != 0);
                    WifiLockManager wifiLockManager = this.wifiLockManager;
                    wifiLockManager.setEnabled(n12 != 0);
                }
            } else {
                this.wakeLockManager.setEnabled(n12 != 0);
                WifiLockManager wifiLockManager = this.wifiLockManager;
                wifiLockManager.setEnabled(false);
            }
        } else {
            this.wakeLockManager.setEnabled(false);
            WifiLockManager wifiLockManager = this.wifiLockManager;
            wifiLockManager.setEnabled(false);
        }
    }

    public void stop(boolean bl2) {
        List list;
        this.verifyApplicationThread();
        AudioFocusManager audioFocusManager = this.audioFocusManager;
        boolean bl3 = this.getPlayWhenReady();
        audioFocusManager.updateAudioFocus(bl3, 1);
        this.player.stop(bl2);
        this.currentCues = list = Collections.emptyList();
    }
}

