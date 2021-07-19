/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.view.Surface
 *  org.json.JSONArray
 */
package com.tencent.liteav.videodecoder;

import android.view.Surface;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.videodecoder.b;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class TXCVideoFfmpegDecoder
implements b {
    private boolean mFirstDec;
    private f mListener;
    private long mNativeDecoder;
    private long mNativeNotify;
    private ByteBuffer mPps;
    private byte[] mRawData;
    private ByteBuffer mSps;
    private int mVideoHeight;
    private int mVideoWidth;

    static {
        g.f();
        TXCVideoFfmpegDecoder.nativeClassInit();
    }

    private static native void nativeClassInit();

    private native boolean nativeDecode(byte[] var1, long var2, long var4, long var6);

    private native void nativeInit(WeakReference var1, boolean var2);

    private native void nativeLoadRawData(byte[] var1, long var2, int var4);

    private native void nativeRelease();

    private static void postEventFromNative(WeakReference weakReference, long l10, int n10, int n11, long l11, long l12, int n12) {
    }

    public int GetDecodeCost() {
        return 0;
    }

    public int config(Surface surface) {
        return 0;
    }

    public void config(JSONArray jSONArray) {
    }

    public void decode(TXSNALPacket object) {
        long l10;
        long l11;
        Object object2;
        int n10 = this.mFirstDec;
        int n11 = -2;
        if (n10 != 0) {
            Object object3 = this.mSps;
            if (object3 != null && (object2 = this.mPps) != null) {
                object3 = ((ByteBuffer)object3).array();
                object2 = this.mPps.array();
                int n12 = ((Object)object3).length;
                int n13 = ((Object)object2).length;
                byte[] byArray = new byte[n12 + n13];
                n12 = ((Object)object3).length;
                System.arraycopy(object3, 0, byArray, 0, n12);
                n10 = ((Object)object3).length;
                n12 = ((Object)object2).length;
                System.arraycopy(object2, 0, byArray, n10, n12);
                long l12 = ((TXSNALPacket)object).pts;
                l11 = 1L;
                l12 -= l11;
                l10 = ((TXSNALPacket)object).dts - l11;
                long l13 = ((TXSNALPacket)object).rotation;
                l11 = l12;
                n10 = (int)(this.nativeDecode(byArray, l12, l10, l13) ? 1 : 0);
                if (n10 == 0 && (object3 = this.mListener) != null) {
                    object3.onDecodeFailed(n11);
                }
            }
            this.mFirstDec = false;
        }
        byte[] byArray = ((TXSNALPacket)object).nalData;
        long l14 = ((TXSNALPacket)object).pts;
        l11 = ((TXSNALPacket)object).dts;
        l10 = ((TXSNALPacket)object).rotation;
        object2 = this;
        boolean bl2 = this.nativeDecode(byArray, l14, l11, l10);
        if (!bl2 && (object = this.mListener) != null) {
            object.onDecodeFailed(n11);
        }
    }

    public void enableLimitDecCache(boolean bl2) {
    }

    public boolean isHevc() {
        return false;
    }

    public void loadNativeData(byte[] byArray, long l10, int n10) {
        this.nativeLoadRawData(byArray, l10, n10);
    }

    public void setListener(f f10) {
        this.mListener = f10;
    }

    public void setNotifyListener(WeakReference weakReference) {
    }

    public int start(ByteBuffer byteBuffer, ByteBuffer weakReference, boolean bl2, boolean bl3) {
        this.mSps = byteBuffer;
        this.mPps = weakReference;
        this.mFirstDec = true;
        this.mVideoWidth = 0;
        this.mVideoHeight = 0;
        weakReference = new WeakReference<TXCVideoFfmpegDecoder>(this);
        this.nativeInit(weakReference, bl2);
        return 0;
    }

    public void stop() {
        this.nativeRelease();
    }
}

