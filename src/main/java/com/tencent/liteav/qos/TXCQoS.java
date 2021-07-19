/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Handler
 */
package com.tencent.liteav.qos;

import android.os.Handler;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.qos.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class TXCQoS {
    public static final int AUTO_ADJUST_LIVEPUSH_RESOLUTION_STRATEGY = 1;
    public static final int AUTO_ADJUST_REALTIME_VIDEOCHAT_STRATEGY = 5;
    private static final Map RESOLUTION_MAP;
    public static final String TAG = "TXCQos";
    private int mAutoStrategy = -1;
    private int mBitrate = 0;
    private Handler mHandler;
    private int mHeight = 0;
    private long mInstance;
    private long mInterval = 1000L;
    private boolean mIsEnableDrop = false;
    private a mListener;
    private b mNotifyListener;
    private Runnable mRunnable;
    private String mUserID = "";
    private int mWidth = 0;

    static {
        HashMap<Integer, c> hashMap = new HashMap<Integer, c>();
        Integer n10 = 0;
        c c10 = c.b;
        hashMap.put(n10, c10);
        n10 = 1;
        c10 = c.c;
        hashMap.put(n10, c10);
        n10 = 2;
        c10 = c.d;
        hashMap.put(n10, c10);
        n10 = 3;
        c10 = c.e;
        hashMap.put(n10, c10);
        n10 = 4;
        c10 = c.f;
        hashMap.put(n10, c10);
        n10 = 5;
        c10 = c.g;
        hashMap.put(n10, c10);
        n10 = 6;
        c10 = c.h;
        hashMap.put(n10, c10);
        n10 = 7;
        c10 = c.i;
        hashMap.put(n10, c10);
        n10 = 8;
        c10 = c.j;
        hashMap.put(n10, c10);
        n10 = 9;
        c10 = c.k;
        hashMap.put(n10, c10);
        n10 = 10;
        c10 = c.l;
        hashMap.put(n10, c10);
        n10 = 11;
        c10 = c.m;
        hashMap.put(n10, c10);
        n10 = 12;
        c10 = c.n;
        hashMap.put(n10, c10);
        n10 = 13;
        c10 = c.o;
        hashMap.put(n10, c10);
        n10 = 14;
        c10 = c.p;
        hashMap.put(n10, c10);
        n10 = 15;
        c10 = c.q;
        hashMap.put(n10, c10);
        n10 = 16;
        c10 = c.r;
        hashMap.put(n10, c10);
        n10 = 17;
        c10 = c.s;
        hashMap.put(n10, c10);
        n10 = 18;
        c10 = c.t;
        hashMap.put(n10, c10);
        n10 = 19;
        c10 = c.u;
        hashMap.put(n10, c10);
        RESOLUTION_MAP = Collections.unmodifiableMap(hashMap);
        g.f();
    }

    public TXCQoS(boolean bl2) {
        long l10;
        Object object;
        this.mHandler = object = new Handler();
        super(this);
        this.mRunnable = object;
        this.mInstance = l10 = this.nativeInit(bl2);
    }

    public static /* synthetic */ a access$000(TXCQoS tXCQoS) {
        return tXCQoS.mListener;
    }

    public static /* synthetic */ long access$100(TXCQoS tXCQoS) {
        return tXCQoS.mInstance;
    }

    public static /* synthetic */ int access$1000(TXCQoS tXCQoS) {
        return tXCQoS.mHeight;
    }

    public static /* synthetic */ int access$1002(TXCQoS tXCQoS, int n10) {
        tXCQoS.mHeight = n10;
        return n10;
    }

    public static /* synthetic */ int access$1100(TXCQoS tXCQoS) {
        return tXCQoS.mAutoStrategy;
    }

    public static /* synthetic */ b access$1200(TXCQoS tXCQoS) {
        return tXCQoS.mNotifyListener;
    }

    public static /* synthetic */ int access$1300(TXCQoS tXCQoS) {
        return tXCQoS.mBitrate;
    }

    public static /* synthetic */ int access$1302(TXCQoS tXCQoS, int n10) {
        tXCQoS.mBitrate = n10;
        return n10;
    }

    public static /* synthetic */ String access$1400(TXCQoS tXCQoS) {
        return tXCQoS.mUserID;
    }

    public static /* synthetic */ long access$1500(TXCQoS tXCQoS) {
        return tXCQoS.mInterval;
    }

    public static /* synthetic */ Handler access$1600(TXCQoS tXCQoS) {
        return tXCQoS.mHandler;
    }

    public static /* synthetic */ void access$200(TXCQoS tXCQoS, long l10, int n10) {
        tXCQoS.nativeSetVideoRealBitrate(l10, n10);
    }

    public static /* synthetic */ void access$300(TXCQoS tXCQoS, long l10, int n10, int n11, int n12, int n13, int n14, int n15) {
        tXCQoS.nativeAdjustBitrate(l10, n10, n11, n12, n13, n14, n15);
    }

    public static /* synthetic */ boolean access$400(TXCQoS tXCQoS, long l10) {
        return tXCQoS.nativeIsEnableDrop(l10);
    }

    public static /* synthetic */ boolean access$500(TXCQoS tXCQoS) {
        return tXCQoS.mIsEnableDrop;
    }

    public static /* synthetic */ boolean access$502(TXCQoS tXCQoS, boolean bl2) {
        tXCQoS.mIsEnableDrop = bl2;
        return bl2;
    }

    public static /* synthetic */ int access$600(TXCQoS tXCQoS, long l10) {
        return tXCQoS.nativeGetBitrate(l10);
    }

    public static /* synthetic */ int access$700(TXCQoS tXCQoS, long l10) {
        return tXCQoS.nativeGetWidth(l10);
    }

    public static /* synthetic */ int access$800(TXCQoS tXCQoS, long l10) {
        return tXCQoS.nativeGetHeight(l10);
    }

    public static /* synthetic */ int access$900(TXCQoS tXCQoS) {
        return tXCQoS.mWidth;
    }

    public static /* synthetic */ int access$902(TXCQoS tXCQoS, int n10) {
        tXCQoS.mWidth = n10;
        return n10;
    }

    /*
     * WARNING - void declaration
     */
    public static c getProperResolutionByVideoBitrate(boolean bl2, int n10, int n11) {
        void var2_3;
        void var1_2;
        int n12 = TXCQoS.nativeGetProperResolutionByVideoBitrate(bl2, (int)var1_2, (int)var2_3);
        Map map = RESOLUTION_MAP;
        Integer n13 = n12;
        return (c)((Object)map.get(n13));
    }

    private native void nativeAddQueueInputSize(long var1, int var3);

    private native void nativeAddQueueOutputSize(long var1, int var3);

    private native void nativeAdjustBitrate(long var1, int var3, int var4, int var5, int var6, int var7, int var8);

    private native void nativeDeinit(long var1);

    private native int nativeGetBitrate(long var1);

    private native int nativeGetHeight(long var1);

    private static native int nativeGetProperResolutionByVideoBitrate(boolean var0, int var1, int var2);

    private native int nativeGetWidth(long var1);

    private native long nativeInit(boolean var1);

    private native boolean nativeIsEnableDrop(long var1);

    private native void nativeReset(long var1, boolean var3);

    private native void nativeSetAutoAdjustBitrate(long var1, boolean var3);

    private native void nativeSetAutoAdjustStrategy(long var1, int var3);

    private native void nativeSetHasVideo(long var1, boolean var3);

    private native void nativeSetVideoDefaultResolution(long var1, int var3);

    private native void nativeSetVideoEncBitrate(long var1, int var3, int var4, int var5);

    private native void nativeSetVideoExpectBitrate(long var1, int var3);

    private native void nativeSetVideoRealBitrate(long var1, int var3);

    public void finalize() {
        try {
            long l10 = this.mInstance;
            this.nativeDeinit(l10);
            return;
        }
        finally {
            super.finalize();
        }
    }

    public String getUserID() {
        return this.mUserID;
    }

    public boolean isEnableDrop() {
        long l10 = this.mInstance;
        return this.nativeIsEnableDrop(l10);
    }

    public void reset(boolean bl2) {
        long l10 = this.mInstance;
        this.nativeReset(l10, bl2);
    }

    public void setAutoAdjustBitrate(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        String string2 = "autoAdjustBitrate is ";
        charSequence.append(string2);
        string2 = bl2 ? "yes" : "no";
        charSequence.append(string2);
        charSequence = charSequence.toString();
        TXCLog.i("TXCQos", (String)charSequence);
        long l10 = this.mInstance;
        this.nativeSetAutoAdjustBitrate(l10, bl2);
    }

    public void setAutoAdjustStrategy(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("autoAdjustStrategy is ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i("TXCQos", (String)charSequence);
        long l10 = this.mInstance;
        this.nativeSetAutoAdjustStrategy(l10, n10);
        this.mAutoStrategy = n10;
    }

    public void setDefaultVideoResolution(c c10) {
        boolean bl2;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("DefaultVideoResolution is ");
        ((StringBuilder)object).append((Object)c10);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCQos", (String)object);
        int n10 = 0;
        object = null;
        this.mWidth = 0;
        this.mHeight = 0;
        Iterator iterator2 = RESOLUTION_MAP.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Object v10 = entry.getValue();
            if (v10 != c10) continue;
            object = (Integer)entry.getKey();
            n10 = (Integer)object;
        }
        long l10 = this.mInstance;
        this.nativeSetVideoDefaultResolution(l10, n10);
    }

    public void setHasVideo(boolean bl2) {
        long l10 = this.mInstance;
        this.nativeSetHasVideo(l10, bl2);
    }

    public void setListener(a a10) {
        this.mListener = a10;
    }

    public void setNotifyListener(b b10) {
        this.mNotifyListener = b10;
    }

    public void setUserID(String string2) {
        this.mUserID = string2;
    }

    public void setVideoEncBitrate(int n10, int n11, int n12) {
        this.mBitrate = 0;
        long l10 = this.mInstance;
        this.nativeSetVideoEncBitrate(l10, n10, n11, n12);
    }

    public void setVideoExpectBitrate(int n10) {
        long l10 = this.mInstance;
        this.nativeSetVideoExpectBitrate(l10, n10);
    }

    public void start(long l10) {
        this.mInterval = l10;
        Handler handler = this.mHandler;
        Runnable runnable = this.mRunnable;
        handler.postDelayed(runnable, l10);
    }

    public void stop() {
        Handler handler = this.mHandler;
        Runnable runnable = this.mRunnable;
        handler.removeCallbacks(runnable);
        this.mAutoStrategy = -1;
    }
}

