/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.view.Surface
 *  android.view.SurfaceHolder
 *  android.view.SurfaceHolder$Callback
 *  android.view.TextureView$SurfaceTextureListener
 */
package com.google.android.exoplayer2;

import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.TextureView;
import com.google.android.exoplayer2.AudioBecomingNoisyManager$EventListener;
import com.google.android.exoplayer2.AudioFocusManager$PlayerControl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.Player$EventListener;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer$1;
import com.google.android.exoplayer2.StreamVolumeManager$Listener;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.device.DeviceInfo;
import com.google.android.exoplayer2.device.DeviceListener;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.util.PriorityTaskManager;
import com.google.android.exoplayer2.video.VideoListener;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import java.util.Iterator;
import java.util.List;

public final class SimpleExoPlayer$ComponentListener
implements VideoRendererEventListener,
AudioRendererEventListener,
TextOutput,
MetadataOutput,
SurfaceHolder.Callback,
TextureView.SurfaceTextureListener,
AudioFocusManager$PlayerControl,
AudioBecomingNoisyManager$EventListener,
StreamVolumeManager$Listener,
Player$EventListener {
    public final /* synthetic */ SimpleExoPlayer this$0;

    private SimpleExoPlayer$ComponentListener(SimpleExoPlayer simpleExoPlayer) {
        this.this$0 = simpleExoPlayer;
    }

    public /* synthetic */ SimpleExoPlayer$ComponentListener(SimpleExoPlayer simpleExoPlayer, SimpleExoPlayer$1 simpleExoPlayer$1) {
        this(simpleExoPlayer);
    }

    public void executePlayerCommand(int n10) {
        boolean bl2 = this.this$0.getPlayWhenReady();
        SimpleExoPlayer simpleExoPlayer = this.this$0;
        int n11 = SimpleExoPlayer.access$3800(bl2, n10);
        SimpleExoPlayer.access$3900(simpleExoPlayer, bl2, n10, n11);
    }

    public void onAudioBecomingNoisy() {
        SimpleExoPlayer.access$3900(this.this$0, false, -1, 3);
    }

    public void onAudioDecoderInitialized(String string2, long l10, long l11) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioDecoderInitialized(string2, l10, l11);
    }

    public void onAudioDecoderReleased(String string2) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioDecoderReleased(string2);
    }

    public void onAudioDisabled(DecoderCounters decoderCounters) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioDisabled(decoderCounters);
        SimpleExoPlayer.access$2902(this.this$0, null);
        SimpleExoPlayer.access$2802(this.this$0, null);
    }

    public void onAudioEnabled(DecoderCounters decoderCounters) {
        SimpleExoPlayer.access$2802(this.this$0, decoderCounters);
        SimpleExoPlayer.access$2400(this.this$0).onAudioEnabled(decoderCounters);
    }

    public void onAudioInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        SimpleExoPlayer.access$2902(this.this$0, format);
        SimpleExoPlayer.access$2400(this.this$0).onAudioInputFormatChanged(format, decoderReuseEvaluation);
    }

    public void onAudioPositionAdvancing(long l10) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioPositionAdvancing(l10);
    }

    public void onAudioSinkError(Exception exception) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioSinkError(exception);
    }

    public void onAudioUnderrun(int n10, long l10, long l11) {
        SimpleExoPlayer.access$2400(this.this$0).onAudioUnderrun(n10, l10, l11);
    }

    public void onCues(List list) {
        boolean bl2;
        SimpleExoPlayer.access$3202(this.this$0, list);
        Iterator iterator2 = SimpleExoPlayer.access$3300(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            TextOutput textOutput = (TextOutput)iterator2.next();
            textOutput.onCues(list);
        }
    }

    public void onDroppedFrames(int n10, long l10) {
        SimpleExoPlayer.access$2400(this.this$0).onDroppedFrames(n10, l10);
    }

    public void onExperimentalSleepingForOffloadChanged(boolean bl2) {
        SimpleExoPlayer.access$4600(this.this$0);
    }

    public void onIsLoadingChanged(boolean bl2) {
        PriorityTaskManager priorityTaskManager = SimpleExoPlayer.access$4400(this.this$0);
        if (priorityTaskManager != null) {
            SimpleExoPlayer simpleExoPlayer;
            SimpleExoPlayer simpleExoPlayer2;
            boolean bl3;
            boolean bl4 = false;
            priorityTaskManager = null;
            if (bl2 && !(bl3 = SimpleExoPlayer.access$4500(simpleExoPlayer2 = this.this$0))) {
                SimpleExoPlayer.access$4400(this.this$0).add(0);
                SimpleExoPlayer simpleExoPlayer3 = this.this$0;
                bl4 = true;
                SimpleExoPlayer.access$4502(simpleExoPlayer3, bl4);
            } else if (!bl2 && (bl2 = SimpleExoPlayer.access$4500(simpleExoPlayer = this.this$0))) {
                SimpleExoPlayer.access$4400(this.this$0).remove(0);
                simpleExoPlayer = this.this$0;
                SimpleExoPlayer.access$4502(simpleExoPlayer, false);
            }
        }
    }

    public void onMetadata(Metadata metadata) {
        boolean bl2;
        SimpleExoPlayer.access$2400(this.this$0).onMetadata(metadata);
        Iterator iterator2 = SimpleExoPlayer.access$3400(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            MetadataOutput metadataOutput = (MetadataOutput)iterator2.next();
            metadataOutput.onMetadata(metadata);
        }
    }

    public void onPlayWhenReadyChanged(boolean bl2, int n10) {
        SimpleExoPlayer.access$4600(this.this$0);
    }

    public void onPlaybackStateChanged(int n10) {
        SimpleExoPlayer.access$4600(this.this$0);
    }

    public void onRenderedFirstFrame(Surface object) {
        SimpleExoPlayer.access$2400(this.this$0).onRenderedFirstFrame((Surface)object);
        Object object2 = SimpleExoPlayer.access$2700(this.this$0);
        if (object2 == object) {
            boolean bl2;
            object = SimpleExoPlayer.access$2600(this.this$0).iterator();
            while (bl2 = object.hasNext()) {
                object2 = (VideoListener)object.next();
                object2.onRenderedFirstFrame();
            }
        }
    }

    public void onSkipSilenceEnabledChanged(boolean bl2) {
        SimpleExoPlayer simpleExoPlayer = this.this$0;
        boolean bl3 = SimpleExoPlayer.access$3000(simpleExoPlayer);
        if (bl3 == bl2) {
            return;
        }
        SimpleExoPlayer.access$3002(this.this$0, bl2);
        SimpleExoPlayer.access$3100(this.this$0);
    }

    public void onStreamTypeChanged(int n10) {
        Object object;
        DeviceInfo deviceInfo = SimpleExoPlayer.access$4100(SimpleExoPlayer.access$4000(this.this$0));
        boolean bl2 = deviceInfo.equals(object = SimpleExoPlayer.access$4200(this.this$0));
        if (!bl2) {
            boolean bl3;
            SimpleExoPlayer.access$4202(this.this$0, deviceInfo);
            object = SimpleExoPlayer.access$4300(this.this$0).iterator();
            while (bl3 = object.hasNext()) {
                DeviceListener deviceListener = (DeviceListener)object.next();
                deviceListener.onDeviceInfoChanged(deviceInfo);
            }
        }
    }

    public void onStreamVolumeChanged(int n10, boolean bl2) {
        boolean bl3;
        Iterator iterator2 = SimpleExoPlayer.access$4300(this.this$0).iterator();
        while (bl3 = iterator2.hasNext()) {
            DeviceListener deviceListener = (DeviceListener)iterator2.next();
            deviceListener.onDeviceVolumeChanged(n10, bl2);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int n10, int n11) {
        SimpleExoPlayer simpleExoPlayer = this.this$0;
        Surface surface = new Surface(surfaceTexture);
        SimpleExoPlayer.access$3500(simpleExoPlayer, surface, true);
        SimpleExoPlayer.access$3600(this.this$0, n10, n11);
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture object) {
        object = this.this$0;
        boolean bl2 = true;
        SimpleExoPlayer.access$3500((SimpleExoPlayer)object, null, bl2);
        SimpleExoPlayer.access$3600(this.this$0, 0, 0);
        return bl2;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int n10, int n11) {
        SimpleExoPlayer.access$3600(this.this$0, n10, n11);
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void onVideoDecoderInitialized(String string2, long l10, long l11) {
        SimpleExoPlayer.access$2400(this.this$0).onVideoDecoderInitialized(string2, l10, l11);
    }

    public void onVideoDecoderReleased(String string2) {
        SimpleExoPlayer.access$2400(this.this$0).onVideoDecoderReleased(string2);
    }

    public void onVideoDisabled(DecoderCounters decoderCounters) {
        SimpleExoPlayer.access$2400(this.this$0).onVideoDisabled(decoderCounters);
        SimpleExoPlayer.access$2502(this.this$0, null);
        SimpleExoPlayer.access$2302(this.this$0, null);
    }

    public void onVideoEnabled(DecoderCounters decoderCounters) {
        SimpleExoPlayer.access$2302(this.this$0, decoderCounters);
        SimpleExoPlayer.access$2400(this.this$0).onVideoEnabled(decoderCounters);
    }

    public void onVideoFrameProcessingOffset(long l10, int n10) {
        SimpleExoPlayer.access$2400(this.this$0).onVideoFrameProcessingOffset(l10, n10);
    }

    public void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
        SimpleExoPlayer.access$2502(this.this$0, format);
        SimpleExoPlayer.access$2400(this.this$0).onVideoInputFormatChanged(format, decoderReuseEvaluation);
    }

    public void onVideoSizeChanged(int n10, int n11, int n12, float f10) {
        boolean bl2;
        SimpleExoPlayer.access$2400(this.this$0).onVideoSizeChanged(n10, n11, n12, f10);
        Iterator iterator2 = SimpleExoPlayer.access$2600(this.this$0).iterator();
        while (bl2 = iterator2.hasNext()) {
            VideoListener videoListener = (VideoListener)iterator2.next();
            videoListener.onVideoSizeChanged(n10, n11, n12, f10);
        }
    }

    public void setVolumeMultiplier(float f10) {
        SimpleExoPlayer.access$3700(this.this$0);
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int n10, int n11, int n12) {
        SimpleExoPlayer.access$3600(this.this$0, n11, n12);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        SimpleExoPlayer simpleExoPlayer = this.this$0;
        surfaceHolder = surfaceHolder.getSurface();
        SimpleExoPlayer.access$3500(simpleExoPlayer, (Surface)surfaceHolder, false);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        SimpleExoPlayer.access$3500(this.this$0, null, false);
        SimpleExoPlayer.access$3600(this.this$0, 0, 0);
    }
}

