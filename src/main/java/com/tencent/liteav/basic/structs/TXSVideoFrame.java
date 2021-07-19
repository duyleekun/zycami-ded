/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.basic.structs;

import android.opengl.GLES20;
import java.nio.Buffer;
import java.nio.ByteBuffer;

public class TXSVideoFrame {
    public ByteBuffer buffer;
    public byte[] data;
    public Object eglContext;
    public int frameType;
    public int height;
    public long pts;
    public int rotation;
    public int textureId;
    public int width;

    private native void nativeLoadArrayFromBuffer(byte[] var1, int var2);

    private native void nativeLoadArrayFromGL(byte[] var1, int var2, int var3);

    private native void nativeLoadBufferFromGL(int var1, int var2);

    private native void nativeLoadNV21BufferFromI420Buffer(int var1, int var2);

    public byte[] I420toNV21(byte[] byArray, byte[] byArray2, int n10, int n11) {
        if (byArray2 == null) {
            int n12 = byArray.length;
            byArray2 = new byte[n12];
        }
        n10 *= n11;
        n11 = n10 / 4 + n10;
        System.arraycopy(byArray, 0, byArray2, 0, n10);
        int n13 = n10;
        int n14 = n11;
        while (n10 < n11) {
            byte by2;
            int n15;
            byArray2[n13] = n15 = byArray[n14];
            n15 = n13 + 1;
            byArray2[n15] = by2 = byArray[n10];
            ++n10;
            ++n14;
            n13 += 2;
        }
        return byArray2;
    }

    public TXSVideoFrame clone() {
        Object object;
        long l10;
        int n10;
        TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
        tXSVideoFrame.width = n10 = this.width;
        tXSVideoFrame.height = n10 = this.height;
        tXSVideoFrame.frameType = n10 = this.frameType;
        tXSVideoFrame.rotation = n10 = this.rotation;
        tXSVideoFrame.pts = l10 = this.pts;
        tXSVideoFrame.data = object = this.data;
        tXSVideoFrame.textureId = n10 = this.textureId;
        object = this.eglContext;
        tXSVideoFrame.eglContext = object;
        object = this.buffer;
        tXSVideoFrame.nativeClone((ByteBuffer)object);
        return tXSVideoFrame;
    }

    public void finalize() {
        this.release();
        super.finalize();
    }

    public void loadNV21BufferFromI420Buffer() {
        int n10 = this.width;
        int n11 = this.height;
        this.nativeLoadNV21BufferFromI420Buffer(n10, n11);
    }

    public void loadYUVArray(byte[] byArray) {
        int n10;
        int n11;
        int n12;
        int n13;
        if (byArray != null && (n13 = byArray.length) >= (n12 = (n11 = this.width) * (n10 = this.height) * 3 / 2)) {
            ByteBuffer byteBuffer = this.buffer;
            if (byteBuffer == null) {
                int n14 = n10 * 3 / 8;
                n10 = 0;
                n12 = 0;
                int n15 = 6408;
                int n16 = 5121;
                ByteBuffer byteBuffer2 = ByteBuffer.wrap(byArray);
                GLES20.glReadPixels((int)0, (int)0, (int)n11, (int)n14, (int)n15, (int)n16, (Buffer)byteBuffer2);
            } else {
                n11 = n11 * n10 * 3 / 2;
                this.nativeLoadArrayFromBuffer(byArray, n11);
            }
        }
    }

    public void loadYUVBufferFromGL() {
        int n10 = this.width;
        int n11 = this.height;
        this.nativeLoadBufferFromGL(n10, n11);
    }

    public native void nativeClone(ByteBuffer var1);

    public native void release();
}

