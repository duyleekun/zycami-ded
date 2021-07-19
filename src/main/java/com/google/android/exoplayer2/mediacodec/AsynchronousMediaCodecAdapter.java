/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CodecException
 *  android.media.MediaCodec$OnFrameRenderedListener
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.view.Surface
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecAdapter$1;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecBufferEnqueuer;
import com.google.android.exoplayer2.mediacodec.AsynchronousMediaCodecCallback;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;
import d.h.a.a.i0.c;
import d.h.a.a.i0.j;
import java.nio.ByteBuffer;
import java.util.Objects;

public final class AsynchronousMediaCodecAdapter
implements MediaCodecAdapter {
    private static final int STATE_CONFIGURED = 1;
    private static final int STATE_CREATED = 0;
    private static final int STATE_SHUT_DOWN = 3;
    private static final int STATE_STARTED = 2;
    private final AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
    private final AsynchronousMediaCodecBufferEnqueuer bufferEnqueuer;
    private final MediaCodec codec;
    private boolean codecReleased;
    private int state;
    private final boolean synchronizeCodecInteractionsWithQueueing;

    private AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread object, HandlerThread handlerThread, boolean bl2, boolean bl3) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback;
        this.codec = mediaCodec;
        this.asynchronousMediaCodecCallback = asynchronousMediaCodecCallback = new AsynchronousMediaCodecCallback((HandlerThread)object);
        super(mediaCodec, handlerThread, bl2);
        this.bufferEnqueuer = object;
        this.synchronizeCodecInteractionsWithQueueing = bl3;
        this.state = 0;
    }

    public /* synthetic */ AsynchronousMediaCodecAdapter(MediaCodec mediaCodec, HandlerThread handlerThread, HandlerThread handlerThread2, boolean bl2, boolean bl3, AsynchronousMediaCodecAdapter$1 asynchronousMediaCodecAdapter$1) {
        this(mediaCodec, handlerThread, handlerThread2, bl2, bl3);
    }

    private /* synthetic */ void a(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, MediaCodec mediaCodec, long l10, long l11) {
        mediaCodecAdapter$OnFrameRenderedListener.onFrameRendered(this, l10, l11);
    }

    public static /* synthetic */ String access$100(int n10) {
        return AsynchronousMediaCodecAdapter.createQueueingThreadLabel(n10);
    }

    public static /* synthetic */ String access$200(int n10) {
        return AsynchronousMediaCodecAdapter.createCallbackThreadLabel(n10);
    }

    private static String createCallbackThreadLabel(int n10) {
        return AsynchronousMediaCodecAdapter.createThreadLabel(n10, "ExoPlayer:MediaCodecAsyncAdapter:");
    }

    private static String createQueueingThreadLabel(int n10) {
        return AsynchronousMediaCodecAdapter.createThreadLabel(n10, "ExoPlayer:MediaCodecQueueingThread:");
    }

    private static String createThreadLabel(int n10, String string2) {
        StringBuilder stringBuilder = new StringBuilder(string2);
        int n11 = 1;
        if (n10 == n11) {
            String string3 = "Audio";
            stringBuilder.append(string3);
        } else {
            n11 = 2;
            if (n10 == n11) {
                String string4 = "Video";
                stringBuilder.append(string4);
            } else {
                string2 = "Unknown(";
                stringBuilder.append(string2);
                stringBuilder.append(n10);
                String string5 = ")";
                stringBuilder.append(string5);
            }
        }
        return stringBuilder.toString();
    }

    private void maybeBlockOnQueueing() {
        boolean bl2 = this.synchronizeCodecInteractionsWithQueueing;
        if (bl2) {
            AsynchronousMediaCodecBufferEnqueuer asynchronousMediaCodecBufferEnqueuer;
            try {
                asynchronousMediaCodecBufferEnqueuer = this.bufferEnqueuer;
            }
            catch (InterruptedException interruptedException) {
                Thread.currentThread().interrupt();
                IllegalStateException illegalStateException = new IllegalStateException(interruptedException);
                throw illegalStateException;
            }
            asynchronousMediaCodecBufferEnqueuer.waitUntilQueueingComplete();
        }
    }

    public /* synthetic */ void b(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, MediaCodec mediaCodec, long l10, long l11) {
        this.a(mediaCodecAdapter$OnFrameRenderedListener, mediaCodec, l10, l11);
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int n10) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        asynchronousMediaCodecCallback.initialize(mediaCodec);
        this.codec.configure(mediaFormat, surface, mediaCrypto, n10);
        this.state = 1;
    }

    public int dequeueInputBufferIndex() {
        return this.asynchronousMediaCodecCallback.dequeueInputBufferIndex();
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        return this.asynchronousMediaCodecCallback.dequeueOutputBufferIndex(bufferInfo);
    }

    public void flush() {
        this.bufferEnqueuer.flush();
        this.codec.flush();
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        Objects.requireNonNull(mediaCodec);
        j j10 = new j(mediaCodec);
        asynchronousMediaCodecCallback.flushAsync(j10);
    }

    public ByteBuffer getInputBuffer(int n10) {
        return this.codec.getInputBuffer(n10);
    }

    public ByteBuffer getOutputBuffer(int n10) {
        return this.codec.getOutputBuffer(n10);
    }

    public MediaFormat getOutputFormat() {
        return this.asynchronousMediaCodecCallback.getOutputFormat();
    }

    public void onError(MediaCodec.CodecException codecException) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        asynchronousMediaCodecCallback.onError(mediaCodec, codecException);
    }

    public void onOutputFormatChanged(MediaFormat mediaFormat) {
        AsynchronousMediaCodecCallback asynchronousMediaCodecCallback = this.asynchronousMediaCodecCallback;
        MediaCodec mediaCodec = this.codec;
        asynchronousMediaCodecCallback.onOutputFormatChanged(mediaCodec, mediaFormat);
    }

    public void queueInputBuffer(int n10, int n11, int n12, long l10, int n13) {
        this.bufferEnqueuer.queueInputBuffer(n10, n11, n12, l10, n13);
    }

    public void queueSecureInputBuffer(int n10, int n11, CryptoInfo cryptoInfo, long l10, int n12) {
        this.bufferEnqueuer.queueSecureInputBuffer(n10, n11, cryptoInfo, l10, n12);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void release() {
        Object object;
        int n10;
        int n11 = 1;
        try {
            n10 = this.state;
            int n12 = 2;
            if (n10 == n12) {
                object = this.bufferEnqueuer;
                ((AsynchronousMediaCodecBufferEnqueuer)object).shutdown();
            }
            if ((n10 = this.state) == n11 || n10 == n12) {
                object = this.asynchronousMediaCodecCallback;
                ((AsynchronousMediaCodecCallback)((Object)object)).shutdown();
            }
            this.state = n10 = 3;
        }
        catch (Throwable throwable) {
            boolean bl2 = this.codecReleased;
            if (!bl2) {
                MediaCodec mediaCodec = this.codec;
                mediaCodec.release();
                this.codecReleased = n11;
            }
            throw throwable;
        }
        n10 = (int)(this.codecReleased ? 1 : 0);
        if (n10 == 0) {
            object = this.codec;
            object.release();
            this.codecReleased = n11;
        }
    }

    public void releaseOutputBuffer(int n10, long l10) {
        this.codec.releaseOutputBuffer(n10, l10);
    }

    public void releaseOutputBuffer(int n10, boolean bl2) {
        this.codec.releaseOutputBuffer(n10, bl2);
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, Handler handler) {
        this.maybeBlockOnQueueing();
        MediaCodec mediaCodec = this.codec;
        c c10 = new c(this, mediaCodecAdapter$OnFrameRenderedListener);
        mediaCodec.setOnFrameRenderedListener((MediaCodec.OnFrameRenderedListener)c10, handler);
    }

    public void setOutputSurface(Surface surface) {
        this.maybeBlockOnQueueing();
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        this.maybeBlockOnQueueing();
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int n10) {
        this.maybeBlockOnQueueing();
        this.codec.setVideoScalingMode(n10);
    }

    public void start() {
        this.bufferEnqueuer.start();
        this.codec.start();
        this.state = 2;
    }
}

