/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.OutputBuffer;
import com.google.android.exoplayer2.decoder.OutputBuffer$Owner;
import java.nio.ByteBuffer;

public class VideoDecoderOutputBuffer
extends OutputBuffer {
    public static final int COLORSPACE_BT2020 = 3;
    public static final int COLORSPACE_BT601 = 1;
    public static final int COLORSPACE_BT709 = 2;
    public static final int COLORSPACE_UNKNOWN;
    public int colorspace;
    public ByteBuffer data;
    public int decoderPrivate;
    public Format format;
    public int height;
    public int mode;
    private final OutputBuffer$Owner owner;
    public ByteBuffer supplementalData;
    public int width;
    public ByteBuffer[] yuvPlanes;
    public int[] yuvStrides;

    public VideoDecoderOutputBuffer(OutputBuffer$Owner outputBuffer$Owner) {
        this.owner = outputBuffer$Owner;
    }

    private static boolean isSafeToMultiply(int n10, int n11) {
        int n12;
        n10 = n10 >= 0 && n11 >= 0 && (n11 <= 0 || n10 < (n12 = (-1 >>> 1) / n11)) ? 1 : 0;
        return n10 != 0;
    }

    public void init(long l10, int n10, ByteBuffer byteBuffer) {
        int n11;
        this.timeUs = l10;
        this.mode = n10;
        if (byteBuffer != null && (n11 = byteBuffer.hasRemaining()) != 0) {
            ByteBuffer byteBuffer2;
            int n12;
            this.addFlag(0x10000000);
            n11 = byteBuffer.limit();
            ByteBuffer byteBuffer3 = this.supplementalData;
            if (byteBuffer3 != null && (n12 = byteBuffer3.capacity()) >= n11) {
                byteBuffer2 = this.supplementalData;
                byteBuffer2.clear();
            } else {
                this.supplementalData = byteBuffer2 = ByteBuffer.allocate(n11);
            }
            this.supplementalData.put(byteBuffer);
            this.supplementalData.flip();
            n11 = 0;
            byteBuffer2 = null;
            byteBuffer.position(0);
        } else {
            n11 = 0;
            Object var8_8 = null;
            this.supplementalData = null;
        }
    }

    public void initForPrivateFrame(int n10, int n11) {
        this.width = n10;
        this.height = n11;
    }

    public boolean initForYuvFrame(int n10, int n11, int n12, int n13, int n14) {
        this.width = n10;
        this.height = n11;
        this.colorspace = n14;
        long l10 = (long)n11 + 1L;
        long l11 = 2;
        n10 = (int)(l10 /= l11);
        n14 = (int)(VideoDecoderOutputBuffer.isSafeToMultiply(n12, n11) ? 1 : 0);
        if (n14 != 0 && (n14 = (int)(VideoDecoderOutputBuffer.isSafeToMultiply(n13, n10) ? 1 : 0)) != 0) {
            n14 = (n10 *= n13) * 2 + (n11 *= n12);
            int n15 = 2;
            int n16 = VideoDecoderOutputBuffer.isSafeToMultiply(n10, n15);
            if (n16 != 0 && n14 >= n11) {
                ByteBuffer byteBuffer;
                ByteBuffer byteBuffer2;
                Object object;
                ByteBuffer byteBuffer3 = this.data;
                if (byteBuffer3 != null && (n16 = byteBuffer3.capacity()) >= n14) {
                    this.data.position(0);
                    byteBuffer3 = this.data;
                    byteBuffer3.limit(n14);
                } else {
                    object = ByteBuffer.allocateDirect(n14);
                    this.data = object;
                }
                object = this.yuvPlanes;
                n16 = 3;
                if (object == null) {
                    object = new ByteBuffer[n16];
                    this.yuvPlanes = object;
                }
                object = this.data;
                ByteBuffer[] byteBufferArray = this.yuvPlanes;
                byteBufferArray[0] = byteBuffer2 = ((ByteBuffer)object).slice();
                byteBufferArray[0].limit(n11);
                ((ByteBuffer)object).position(n11);
                byteBuffer2 = ((ByteBuffer)object).slice();
                boolean bl2 = true;
                byteBufferArray[bl2] = byteBuffer2;
                byteBuffer2 = byteBufferArray[bl2];
                byteBuffer2.limit(n10);
                ((ByteBuffer)object).position(n11 += n10);
                byteBufferArray[n15] = byteBuffer = ((ByteBuffer)object).slice();
                byteBuffer = byteBufferArray[n15];
                byteBuffer.limit(n10);
                int[] nArray = this.yuvStrides;
                if (nArray == null) {
                    this.yuvStrides = nArray = new int[n16];
                }
                nArray = this.yuvStrides;
                nArray[0] = n12;
                nArray[bl2] = n13;
                nArray[n15] = n13;
                return bl2;
            }
        }
        return false;
    }

    public void release() {
        this.owner.releaseOutputBuffer(this);
    }
}

