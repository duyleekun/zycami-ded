/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
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
import com.google.android.exoplayer2.mediacodec.MediaCodecAdapter$OnFrameRenderedListener;
import java.nio.ByteBuffer;

public interface MediaCodecAdapter {
    public void configure(MediaFormat var1, Surface var2, MediaCrypto var3, int var4);

    public int dequeueInputBufferIndex();

    public int dequeueOutputBufferIndex(MediaCodec.BufferInfo var1);

    public void flush();

    public ByteBuffer getInputBuffer(int var1);

    public ByteBuffer getOutputBuffer(int var1);

    public MediaFormat getOutputFormat();

    public void queueInputBuffer(int var1, int var2, int var3, long var4, int var6);

    public void queueSecureInputBuffer(int var1, int var2, CryptoInfo var3, long var4, int var6);

    public void release();

    public void releaseOutputBuffer(int var1, long var2);

    public void releaseOutputBuffer(int var1, boolean var2);

    public void setOnFrameRenderedListener(MediaCodecAdapter$OnFrameRenderedListener var1, Handler var2);

    public void setOutputSurface(Surface var1);

    public void setParameters(Bundle var1);

    public void setVideoScalingMode(int var1);

    public void start();
}

