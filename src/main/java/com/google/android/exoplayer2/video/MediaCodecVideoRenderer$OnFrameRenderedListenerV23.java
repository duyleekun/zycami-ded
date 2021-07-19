/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Message
 */
package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.Message;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.MediaCodecVideoRenderer;

public final class MediaCodecVideoRenderer$OnFrameRenderedListenerV23
implements MediaCodecAdapter$OnFrameRenderedListener,
Handler.Callback {
    private static final int HANDLE_FRAME_RENDERED;
    private final Handler handler;
    public final /* synthetic */ MediaCodecVideoRenderer this$0;

    public MediaCodecVideoRenderer$OnFrameRenderedListenerV23(MediaCodecVideoRenderer mediaCodecVideoRenderer, MediaCodecAdapter mediaCodecAdapter) {
        this.this$0 = mediaCodecVideoRenderer;
        mediaCodecVideoRenderer = Util.createHandlerForCurrentLooper(this);
        this.handler = mediaCodecVideoRenderer;
        mediaCodecAdapter.setOnFrameRenderedListener(this, (Handler)mediaCodecVideoRenderer);
    }

    private void handleFrameRendered(long l10) {
        MediaCodecVideoRenderer mediaCodecVideoRenderer = this.this$0;
        MediaCodecVideoRenderer$OnFrameRenderedListenerV23 mediaCodecVideoRenderer$OnFrameRenderedListenerV23 = mediaCodecVideoRenderer.tunnelingOnFrameRenderedListener;
        if (this != mediaCodecVideoRenderer$OnFrameRenderedListenerV23) {
            return;
        }
        long l11 = Long.MAX_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            MediaCodecVideoRenderer.access$000(mediaCodecVideoRenderer);
        } else {
            try {
                mediaCodecVideoRenderer.onProcessedTunneledBuffer(l10);
            }
            catch (ExoPlaybackException exoPlaybackException) {
                MediaCodecVideoRenderer mediaCodecVideoRenderer2 = this.this$0;
                MediaCodecVideoRenderer.access$100(mediaCodecVideoRenderer2, exoPlaybackException);
            }
        }
    }

    public boolean handleMessage(Message message) {
        int n10 = message.what;
        if (n10 != 0) {
            return false;
        }
        n10 = message.arg1;
        int n11 = message.arg2;
        long l10 = Util.toLong(n10, n11);
        this.handleFrameRendered(l10);
        return true;
    }

    public void onFrameRendered(MediaCodecAdapter mediaCodecAdapter, long l10, long l11) {
        int n10 = Util.SDK_INT;
        int n11 = 30;
        if (n10 < n11) {
            mediaCodecAdapter = this.handler;
            n11 = 0;
            long l12 = l10 >> 32;
            int n12 = (int)l12;
            int n13 = (int)l10;
            mediaCodecAdapter = Message.obtain((Handler)mediaCodecAdapter, (int)0, (int)n12, (int)n13);
            Handler handler = this.handler;
            handler.sendMessageAtFrontOfQueue((Message)mediaCodecAdapter);
        } else {
            this.handleFrameRendered(l10);
        }
    }
}

