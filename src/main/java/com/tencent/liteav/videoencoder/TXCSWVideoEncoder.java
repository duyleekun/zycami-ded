/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.videoencoder;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.opengl.i$a;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.videoencoder.TXCSWVideoEncoder$1;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.c;
import java.lang.ref.WeakReference;

public class TXCSWVideoEncoder
extends c {
    private static final boolean DEBUG = false;
    private static final String TAG = "TXCSWVideoEncoder";
    private int mBitrate;
    private long mNativeEncoder;
    private long mPTS;
    private int mPopIdx;
    private int mPushIdx;
    private i mRawFrameFilter;
    private int mRendIdx;
    private i mResizeFilter;

    static {
        g.f();
        TXCSWVideoEncoder.nativeClassInit();
    }

    public TXCSWVideoEncoder() {
        long l10;
        this.mNativeEncoder = l10 = 0L;
        this.mBitrate = 0;
        this.mPTS = l10;
        this.mPushIdx = 0;
        this.mRendIdx = 0;
        this.mPopIdx = 0;
    }

    public static /* synthetic */ long access$000(TXCSWVideoEncoder tXCSWVideoEncoder) {
        return tXCSWVideoEncoder.mNativeEncoder;
    }

    public static /* synthetic */ long access$100(TXCSWVideoEncoder tXCSWVideoEncoder) {
        return tXCSWVideoEncoder.mPTS;
    }

    public static /* synthetic */ int access$200(TXCSWVideoEncoder tXCSWVideoEncoder, long l10, int n10, int n11, int n12, long l11) {
        return tXCSWVideoEncoder.nativeEncodeSync(l10, n10, n11, n12, l11);
    }

    public static /* synthetic */ int access$300(TXCSWVideoEncoder tXCSWVideoEncoder, long l10, int n10, int n11, int n12, long l11) {
        return tXCSWVideoEncoder.nativeEncode(l10, n10, n11, n12, l11);
    }

    public static long getAndIncreaseGopIndex() {
        return TXCSWVideoEncoder.nativeGetAndIncreaseGopIndex();
    }

    public static long getAndIncreateSeq() {
        return TXCSWVideoEncoder.nativeGetAndIncreaseSeq();
    }

    private static native void nativeClassInit();

    private native void nativeEnableNearestRPS(long var1, int var3);

    private native int nativeEncode(long var1, int var3, int var4, int var5, long var6);

    private native int nativeEncodeSync(long var1, int var3, int var4, int var5, long var6);

    private static native long nativeGetAndIncreaseGopIndex();

    private static native long nativeGetAndIncreaseSeq();

    private native long nativeGetRealFPS(long var1);

    private native long nativeInit(WeakReference var1);

    private native void nativeRelease(long var1);

    private native void nativeRestartIDR(long var1);

    private native void nativeSetBitrate(long var1, int var3);

    private native void nativeSetBitrateFromQos(long var1, int var3, int var4);

    private native void nativeSetEncodeIdrFpsFromQos(long var1, int var3);

    private native void nativeSetFPS(long var1, int var3);

    private native void nativeSetID(long var1, String var3);

    private native void nativeSetRPSRefBitmap(long var1, int var3, int var4, long var5);

    private native void nativeSignalEOSAndFlush(long var1);

    private native int nativeStart(long var1, TXSVideoEncoderParam var3);

    private native void nativeStop(long var1);

    private native long nativegetRealBitrate(long var1);

    private static void onEncodeFinishedFromNative(WeakReference weakReference, int n10, long l10, long l11) {
        weakReference = weakReference.get();
        Object object = weakReference;
        object = (TXCSWVideoEncoder)((Object)weakReference);
        if (object != null) {
            ((c)object).onEncodeFinished(n10, l10, l11);
        }
    }

    private static void postEventFromNative(WeakReference weakReference, byte[] byArray, int n10, long l10, long l11, long l12, long l13, long l14, long l15, int n11) {
        Object t10 = weakReference.get();
        Object object = t10;
        object = (TXCSWVideoEncoder)t10;
        if (object != null) {
            ((c)object).callDelegate(byArray, n10, l10, l11, l12, l13, l14, l15, n11, null, null);
        }
    }

    private long pushVideoFrameInternal(int n10, int n11, int n12, long l10, boolean bl2) {
        TXCSWVideoEncoder tXCSWVideoEncoder = this;
        i i10 = this.mResizeFilter;
        Object object = this.mRawFrameFilter;
        Object object2 = this.mGLContextExternal;
        if (object2 != null) {
            int n13;
            int n14 = n11;
            this.mInputWidth = n11;
            this.mInputHeight = n12;
            boolean bl3 = true;
            if (i10 == null) {
                this.mResizeFilter = i10 = new i();
                i10.a();
                i10.a(bl3);
            }
            int n15 = tXCSWVideoEncoder.mOutputWidth;
            int n16 = tXCSWVideoEncoder.mOutputHeight;
            i10.a(n15, n16);
            n15 = tXCSWVideoEncoder.mOutputWidth;
            n16 = tXCSWVideoEncoder.mOutputHeight;
            GLES20.glViewport((int)0, (int)0, (int)n15, (int)n16);
            if (i10 != null) {
                n15 = tXCSWVideoEncoder.mRotation;
                n13 = (720 - n15) % 360;
                n15 = 270;
                float f10 = 3.78E-43f;
                n16 = 90;
                float f11 = 1.26E-43f;
                int n17 = n13 != n16 && n13 != n15 ? tXCSWVideoEncoder.mOutputWidth : tXCSWVideoEncoder.mOutputHeight;
                n15 = n13 != n16 && n13 != n15 ? tXCSWVideoEncoder.mOutputHeight : tXCSWVideoEncoder.mOutputWidth;
                f11 = n17;
                f10 = n15;
                float f12 = f11 / f10;
                boolean bl4 = tXCSWVideoEncoder.mEnableXMirror;
                n16 = n11;
                n17 = 0;
                boolean bl5 = bl4;
                bl4 = false;
                i10.a(n11, n12, n13, null, f12, bl5, false);
                n14 = n10;
                i10.b(n10);
            } else {
                n14 = n10;
            }
            Object object3 = i10 != null ? i10.l() : n14;
            object2 = new int[bl3];
            long l11 = l10;
            tXCSWVideoEncoder.mPTS = l10;
            l11 = 10000004L;
            if (object == null) {
                object = TAG;
                TXCLog.i((String)object, "pushVideoFrameInternal->create mRawFrameFilter");
                o o10 = new o((int)(bl3 ? 1 : 0));
                tXCSWVideoEncoder.mRawFrameFilter = o10;
                o10.a(bl3);
                n13 = (int)(((i)o10).a() ? 1 : 0);
                if (n13 == 0) {
                    TXCLog.i((String)object, "pushVideoFrameInternal->destroy mRawFrameFilter, init failed!");
                    tXCSWVideoEncoder.mRawFrameFilter = null;
                    return l11;
                }
                int n18 = tXCSWVideoEncoder.mOutputWidth;
                n13 = tXCSWVideoEncoder.mOutputHeight;
                ((i)o10).a(n18, n13);
                n13 = (int)(bl2 ? 1 : 0);
                object = new TXCSWVideoEncoder$1(this, bl2, (int)object3);
                o10.a((i$a)object);
                object = o10;
            }
            if (object == null) {
                return l11;
            }
            n15 = tXCSWVideoEncoder.mOutputWidth;
            n16 = tXCSWVideoEncoder.mOutputHeight;
            GLES20.glViewport((int)0, (int)0, (int)n15, (int)n16);
            ((i)object).b((int)object3);
            object3 = object2[0];
            if (object3 != 0) {
                this.callDelegate((int)object3);
            }
        }
        return 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void enableNearestRPS(int n10) {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeEnableNearestRPS(l10, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public long getRealBitrate() {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            return this.nativegetRealBitrate(l10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public double getRealFPS() {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            l10 = this.nativeGetRealFPS(l10);
            return l10;
        }
    }

    public long pushVideoFrame(int n10, int n11, int n12, long l10) {
        return this.pushVideoFrameInternal(n10, n11, n12, l10, false);
    }

    public long pushVideoFrameAsync(int n10, int n11, int n12, long l10) {
        return this.pushVideoFrameInternal(n10, n11, n12, l10, true);
    }

    public long pushVideoFrameSync(int n10, int n11, int n12, long l10) {
        return this.pushVideoFrameInternal(n10, n11, n12, l10, true);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void restartIDR() {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeRestartIDR(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setBitrate(int n10) {
        this.mBitrate = n10;
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSetBitrate(l10, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setBitrateFromQos(int n10, int n11) {
        this.mBitrate = n10;
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSetBitrateFromQos(l10, n10, n11);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setEncodeIdrFpsFromQos(int n10) {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSetEncodeIdrFpsFromQos(l10, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setFPS(int n10) {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSetFPS(l10, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setID(String string2) {
        super.setID(string2);
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSetID(l10, string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setRPSRefBitmap(int n10, int n11, long l10) {
        synchronized (this) {
            long l11 = this.mNativeEncoder;
            this.nativeSetRPSRefBitmap(l11, n10, n11, l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void signalEOSAndFlush() {
        synchronized (this) {
            long l10 = this.mNativeEncoder;
            this.nativeSignalEOSAndFlush(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int start(TXSVideoEncoderParam tXSVideoEncoderParam) {
        CharSequence charSequence;
        WeakReference<TXCSWVideoEncoder> weakReference;
        super.start(tXSVideoEncoderParam);
        int n10 = tXSVideoEncoderParam.width;
        int n11 = (n10 + 7) / 8 * 8;
        int n12 = tXSVideoEncoderParam.height;
        int n13 = (n12 + 1) / 2 * 2;
        if (n11 != n10 || n13 != n12) {
            weakReference = TAG;
            TXCLog.w((String)((Object)weakReference), "Encode Resolution not supportted, transforming...");
            charSequence = new StringBuilder();
            int n14 = tXSVideoEncoderParam.width;
            charSequence.append(n14);
            charSequence.append("x");
            n14 = tXSVideoEncoderParam.height;
            charSequence.append(n14);
            charSequence.append("-> ");
            charSequence.append(n11);
            String string2 = "x";
            charSequence.append(string2);
            charSequence.append(n13);
            charSequence = charSequence.toString();
            TXCLog.w(weakReference, (String)charSequence);
        }
        tXSVideoEncoderParam.width = n11;
        tXSVideoEncoderParam.height = n13;
        this.mOutputWidth = n11;
        this.mOutputHeight = n13;
        this.mInputWidth = n11;
        this.mInputHeight = n13;
        n10 = 0;
        weakReference = null;
        this.mRawFrameFilter = null;
        this.mResizeFilter = null;
        synchronized (this) {
            long l10;
            weakReference = new WeakReference<TXCSWVideoEncoder>(this);
            this.mNativeEncoder = l10 = this.nativeInit(weakReference);
            n12 = this.mBitrate;
            this.nativeSetBitrate(l10, n12);
            l10 = this.mNativeEncoder;
            charSequence = this.getID();
            this.nativeSetID(l10, (String)charSequence);
            l10 = this.mNativeEncoder;
            this.nativeStart(l10, tXSVideoEncoderParam);
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void stop() {
        long l10;
        String string2 = TAG;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop->enter with mRawFrameFilter:");
        i i10 = this.mRawFrameFilter;
        ((StringBuilder)object).append(i10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string2, (String)object);
        string2 = null;
        this.mGLContextExternal = null;
        synchronized (this) {
            long l11;
            l10 = this.mNativeEncoder;
            this.mNativeEncoder = l11 = 0L;
        }
        this.nativeStop(l10);
        this.nativeRelease(l10);
        object = this.mRawFrameFilter;
        if (object != null) {
            ((i)object).d();
            this.mRawFrameFilter = null;
        }
        if ((object = this.mResizeFilter) != null) {
            ((i)object).d();
            this.mResizeFilter = null;
        }
        super.stop();
    }
}

