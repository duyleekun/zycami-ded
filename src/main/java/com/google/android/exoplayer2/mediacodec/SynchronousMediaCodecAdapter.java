/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaCodec$CryptoInfo
 *  android.media.MediaCodec$OnFrameRenderedListener
 *  android.media.MediaCrypto
 *  android.media.MediaFormat
 *  android.os.Bundle
 *  android.os.Handler
 *  android.view.Surface
 */
package com.google.android.exoplayer2.mediacodec;

import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.Handler;
import android.view.Surface;
import com.google.android.exoplayer2.decoder.CryptoInfo;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter;
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;
import com.google.android.exoplayer2.mediacodec.SynchronousMediaCodecAdapter$1;
import com.google.android.exoplayer2.util.Util;
import d.h.a.a.i0.i;
import java.nio.ByteBuffer;

public final class SynchronousMediaCodecAdapter
implements MediaCodecAdapter {
    private final MediaCodec codec;
    private ByteBuffer[] inputByteBuffers;
    private ByteBuffer[] outputByteBuffers;

    private SynchronousMediaCodecAdapter(MediaCodec mediaCodec) {
        this.codec = mediaCodec;
    }

    public /* synthetic */ SynchronousMediaCodecAdapter(MediaCodec mediaCodec, SynchronousMediaCodecAdapter$1 synchronousMediaCodecAdapter$1) {
        this(mediaCodec);
    }

    private /* synthetic */ void a(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, MediaCodec mediaCodec, long l10, long l11) {
        mediaCodecAdapter$OnFrameRenderedListener.onFrameRendered(this, l10, l11);
    }

    public /* synthetic */ void b(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, MediaCodec mediaCodec, long l10, long l11) {
        this.a(mediaCodecAdapter$OnFrameRenderedListener, mediaCodec, l10, l11);
    }

    public void configure(MediaFormat mediaFormat, Surface surface, MediaCrypto mediaCrypto, int n10) {
        this.codec.configure(mediaFormat, surface, mediaCrypto, n10);
    }

    public int dequeueInputBufferIndex() {
        return this.codec.dequeueInputBuffer(0L);
    }

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo bufferInfo) {
        int n10;
        int n11;
        do {
            int n12;
            int n13;
            long l10;
            MediaCodec mediaCodec;
            if ((n11 = (mediaCodec = this.codec).dequeueOutputBuffer(bufferInfo, l10 = 0L)) != (n10 = -3) || (n13 = Util.SDK_INT) >= (n12 = 21)) continue;
            ByteBuffer[] byteBufferArray = this.codec.getOutputBuffers();
            this.outputByteBuffers = byteBufferArray;
        } while (n11 == n10);
        return n11;
    }

    public void flush() {
        this.codec.flush();
    }

    public ByteBuffer getInputBuffer(int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return this.codec.getInputBuffer(n10);
        }
        return ((ByteBuffer[])Util.castNonNull(this.inputByteBuffers))[n10];
    }

    public ByteBuffer getOutputBuffer(int n10) {
        int n11 = Util.SDK_INT;
        int n12 = 21;
        if (n11 >= n12) {
            return this.codec.getOutputBuffer(n10);
        }
        return ((ByteBuffer[])Util.castNonNull(this.outputByteBuffers))[n10];
    }

    public MediaFormat getOutputFormat() {
        return this.codec.getOutputFormat();
    }

    public void queueInputBuffer(int n10, int n11, int n12, long l10, int n13) {
        this.codec.queueInputBuffer(n10, n11, n12, l10, n13);
    }

    public void queueSecureInputBuffer(int n10, int n11, CryptoInfo cryptoInfo, long l10, int n12) {
        MediaCodec mediaCodec = this.codec;
        MediaCodec.CryptoInfo cryptoInfo2 = cryptoInfo.getFrameworkCryptoInfo();
        mediaCodec.queueSecureInputBuffer(n10, n11, cryptoInfo2, l10, n12);
    }

    public void release() {
        this.inputByteBuffers = null;
        this.outputByteBuffers = null;
        this.codec.release();
    }

    public void releaseOutputBuffer(int n10, long l10) {
        this.codec.releaseOutputBuffer(n10, l10);
    }

    public void releaseOutputBuffer(int n10, boolean bl2) {
        this.codec.releaseOutputBuffer(n10, bl2);
    }

    public void setOnFrameRenderedListener(MediaCodecAdapter$OnFrameRenderedListener mediaCodecAdapter$OnFrameRenderedListener, Handler handler) {
        MediaCodec mediaCodec = this.codec;
        i i10 = new i(this, mediaCodecAdapter$OnFrameRenderedListener);
        mediaCodec.setOnFrameRenderedListener((MediaCodec.OnFrameRenderedListener)i10, handler);
    }

    public void setOutputSurface(Surface surface) {
        this.codec.setOutputSurface(surface);
    }

    public void setParameters(Bundle bundle) {
        this.codec.setParameters(bundle);
    }

    public void setVideoScalingMode(int n10) {
        this.codec.setVideoScalingMode(n10);
    }

    public void start() {
        ByteBuffer[] byteBufferArray = this.codec;
        byteBufferArray.start();
        int n10 = Util.SDK_INT;
        int n11 = 21;
        if (n10 < n11) {
            byteBufferArray = this.codec.getInputBuffers();
            this.inputByteBuffers = byteBufferArray;
            byteBufferArray = this.codec.getOutputBuffers();
            this.outputByteBuffers = byteBufferArray;
        }
    }
}

