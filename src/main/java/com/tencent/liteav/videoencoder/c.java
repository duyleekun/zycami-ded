/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  org.json.JSONArray
 */
package com.tencent.liteav.videoencoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.tencent.liteav.basic.module.a;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.d;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class c
extends a {
    public boolean mEnableXMirror = false;
    public JSONArray mEncFmt = null;
    public i mEncodeFilter;
    private boolean mEncodeFirstGOP = false;
    public Object mGLContextExternal = null;
    public boolean mInit;
    public i mInputFilter;
    public int mInputHeight = 0;
    public int mInputTextureID = -1;
    public int mInputWidth = 0;
    public d mListener = null;
    public int mOutputHeight = 0;
    public int mOutputWidth = 0;
    public int mRotation = 0;
    public int mStreamType = 2;
    private long mVideoGOPEncode = 0L;

    public void callDelegate(int n10) {
        this.callDelegate(null, 0, 0L, 0L, 0L, 0L, 0L, 0L, n10, null, null);
    }

    public void callDelegate(MediaFormat mediaFormat) {
        d d10 = this.mListener;
        if (d10 != null) {
            d10.a(mediaFormat);
        }
    }

    public void callDelegate(byte[] byArray, int n10, long l10, long l11, long l12, long l13, long l14, long l15, int n11, ByteBuffer byteBuffer, MediaCodec.BufferInfo bufferInfo) {
        TXSNALPacket tXSNALPacket;
        ByteBuffer byteBuffer2;
        int n12;
        c c10 = this;
        int n13 = n10;
        Object object = bufferInfo;
        MediaCodec.BufferInfo bufferInfo2 = null;
        if (byteBuffer == null) {
            n12 = 0;
            byteBuffer2 = null;
        } else {
            byteBuffer2 = byteBuffer.asReadOnlyBuffer();
        }
        if (object != null) {
            bufferInfo2 = new MediaCodec.BufferInfo();
        }
        if (bufferInfo2 != null) {
            int n14 = ((MediaCodec.BufferInfo)object).offset;
            int n15 = ((MediaCodec.BufferInfo)object).size;
            long l16 = ((MediaCodec.BufferInfo)object).presentationTimeUs;
            int n16 = ((MediaCodec.BufferInfo)object).flags;
            tXSNALPacket = bufferInfo2;
            bufferInfo2.set(n14, n15, l16, n16);
        }
        if ((object = c10.mListener) != null) {
            tXSNALPacket = new TXSNALPacket();
            tXSNALPacket.nalData = byArray;
            tXSNALPacket.nalType = n13;
            tXSNALPacket.gopIndex = l10;
            tXSNALPacket.gopFrameIndex = l11;
            tXSNALPacket.frameIndex = l12;
            tXSNALPacket.refFremeIndex = l13;
            tXSNALPacket.pts = l14;
            tXSNALPacket.dts = l15;
            tXSNALPacket.buffer = byteBuffer2;
            tXSNALPacket.streamType = n12 = c10.mStreamType;
            if (bufferInfo2 != null) {
                tXSNALPacket.info = bufferInfo2;
            }
            object.a(tXSNALPacket, n11);
            int n17 = 4006;
            long l17 = 1L;
            if (n13 == 0) {
                long l18 = c10.mVideoGOPEncode;
                long l19 = 0L;
                long l20 = l18 - l19;
                n13 = (int)(l20 == 0L ? 0 : (l20 < 0L ? -1 : 1));
                if (n13 != 0) {
                    n13 = 1;
                    c10.mEncodeFirstGOP = n13;
                    Long l21 = l18;
                    this.setStatusValue(n17, l21);
                }
                c10.mVideoGOPEncode = l17;
            } else {
                long l22;
                c10.mVideoGOPEncode = l22 = c10.mVideoGOPEncode + l17;
                n13 = (int)(c10.mEncodeFirstGOP ? 1 : 0);
                if (n13 == 0) {
                    Long l23 = l22;
                    this.setStatusValue(n17, l23);
                }
            }
        }
    }

    public void enableNearestRPS(int n10) {
    }

    public int getEncodeCost() {
        return 0;
    }

    public long getRealBitrate() {
        return 0L;
    }

    public double getRealFPS() {
        return 0.0;
    }

    public int getVideoHeight() {
        return this.mOutputHeight;
    }

    public int getVideoWidth() {
        return this.mOutputWidth;
    }

    public void onEncodeFinished(int n10, long l10, long l11) {
        d d10 = this.mListener;
        if (d10 != null) {
            d10.a(n10, l10, l11);
        }
    }

    public long pushVideoFrame(int n10, int n11, int n12, long l10) {
        return 10000002L;
    }

    public long pushVideoFrameAsync(int n10, int n11, int n12, long l10) {
        return 10000002L;
    }

    public long pushVideoFrameSync(int n10, int n11, int n12, long l10) {
        return 10000002L;
    }

    public void restartIDR() {
    }

    public void setBitrate(int n10) {
    }

    public void setBitrateFromQos(int n10, int n11) {
    }

    public void setEncodeIdrFpsFromQos(int n10) {
    }

    public void setFPS(int n10) {
    }

    public void setGLFinishedTextureNeed(boolean bl2) {
    }

    public void setListener(d d10) {
        this.mListener = d10;
    }

    public void setRPSRefBitmap(int n10, int n11, long l10) {
    }

    public void setRotation(int n10) {
        this.mRotation = n10;
    }

    public void setXMirror(boolean bl2) {
        this.mEnableXMirror = bl2;
    }

    public void signalEOSAndFlush() {
    }

    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        if (tXSVideoEncoderParam != null) {
            Object object;
            int n10;
            int n11;
            this.mOutputWidth = n11 = tXSVideoEncoderParam.width;
            this.mOutputHeight = n10 = tXSVideoEncoderParam.height;
            this.mInputWidth = n11;
            this.mInputHeight = n10;
            this.mGLContextExternal = object = tXSVideoEncoderParam.glContext;
            this.mStreamType = n11 = tXSVideoEncoderParam.streamType;
            tXSVideoEncoderParam = tXSVideoEncoderParam.encFmt;
            this.mEncFmt = tXSVideoEncoderParam;
        }
        this.mVideoGOPEncode = 0L;
        this.mEncodeFirstGOP = false;
        return 10000002;
    }

    public void stop() {
    }
}

