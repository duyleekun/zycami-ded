/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.SurfaceTexture
 *  android.os.Bundle
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.os.Message
 *  android.view.Surface
 *  org.json.JSONArray
 */
package com.tencent.liteav.videodecoder;

import android.graphics.SurfaceTexture;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.view.Surface;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.videodecoder.TXCVideoDecoder$a;
import com.tencent.liteav.videodecoder.b;
import com.tencent.liteav.videodecoder.e;
import com.tencent.liteav.videodecoder.f;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import org.json.JSONArray;

public class TXCVideoDecoder
implements com.tencent.liteav.basic.b.b,
f {
    private static final boolean NEW_DECODER = true;
    private static final String TAG = "TXCVideoDecoder";
    private static long mDecodeFirstFrameTS;
    private JSONArray mDecFormat = null;
    private int mDecoderCacheNum;
    private TXCVideoDecoder$a mDecoderHandler;
    public f mDecoderListener;
    private boolean mEnableDecoderChange = false;
    private boolean mEnableLimitDecCache = false;
    private boolean mEnableRestartDecoder = false;
    public boolean mHWDec;
    public boolean mHevc;
    private ArrayList mNALList;
    private long mNativeContext;
    public boolean mNeedSortFrame;
    private WeakReference mNotifyListener;
    private ByteBuffer mPps;
    public boolean mRecvFirstFrame;
    private boolean mRestarting = false;
    private ByteBuffer mSps;
    private int mStreamType = 0;
    public Surface mSurface;
    private String mUserId;
    public b mVideoDecoder;
    private int mVideoHeight = 0;
    private int mVideoWidth = 0;

    static {
        g.f();
    }

    public TXCVideoDecoder() {
        boolean bl2;
        ArrayList arrayList;
        this.mNALList = arrayList = new ArrayList();
        this.mHWDec = bl2 = true;
        this.mHevc = false;
        this.mNeedSortFrame = bl2;
        this.mRecvFirstFrame = false;
        mDecodeFirstFrameTS = 0L;
    }

    private void addOneNalToDecoder(TXSNALPacket tXSNALPacket) {
        Object object;
        int n10 = tXSNALPacket.nalType;
        int n11 = 1;
        if (n10 == 0) {
            n10 = n11;
        } else {
            n10 = 0;
            object = null;
        }
        Bundle bundle = new Bundle();
        bundle.putBoolean("iframe", n10 != 0);
        object = tXSNALPacket.nalData;
        String string2 = "nal";
        bundle.putByteArray(string2, object);
        long l10 = tXSNALPacket.pts;
        bundle.putLong("pts", l10);
        l10 = tXSNALPacket.dts;
        bundle.putLong("dts", l10);
        int n12 = tXSNALPacket.codecId;
        bundle.putInt("codecId", n12);
        tXSNALPacket = new Message();
        ((Message)tXSNALPacket).what = n10 = 101;
        tXSNALPacket.setData(bundle);
        object = (Object)this.mDecoderHandler;
        if (object != null) {
            object.sendMessage((Message)tXSNALPacket);
        }
        this.mDecoderCacheNum = n12 = this.mDecoderCacheNum + n11;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void decNALByNewWay(TXSNALPacket tXSNALPacket) {
        boolean bl2 = this.mHWDec;
        if (bl2) {
            byte[] byArray = tXSNALPacket.nalData;
            long l10 = tXSNALPacket.pts;
            long l11 = tXSNALPacket.dts;
            int n10 = tXSNALPacket.rotation;
            int n11 = tXSNALPacket.codecId;
            boolean bl3 = false;
            int n12 = tXSNALPacket.nalType;
            this.decodeFrame(byArray, l10, l11, n10, n11, 0, 0, n12);
            return;
        }
        synchronized (this) {
            long l12 = this.mNativeContext;
            byte[] byArray = tXSNALPacket.nalData;
            int n13 = tXSNALPacket.nalType;
            long l13 = tXSNALPacket.pts;
            long l14 = tXSNALPacket.dts;
            int n14 = tXSNALPacket.rotation;
            int n15 = tXSNALPacket.codecId;
            this.nativeDecodeFrame(l12, byArray, n13, l13, l14, n14, n15);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void decNALByOldWay(TXSNALPacket object) {
        String string2 = TAG;
        try {
            Object object2;
            Object object3;
            Object object4;
            int n10 = ((TXSNALPacket)object).nalType;
            int n11 = 1;
            if (n10 == 0) {
                n10 = n11;
            } else {
                n10 = 0;
                object4 = null;
            }
            int n12 = this.mRecvFirstFrame;
            if (n12 == 0 && n10 == 0) {
                object = "play:decode: push nal ignore p frame when not got i frame";
                TXCLog.i(string2, (String)object);
                return;
            }
            if (n12 == 0 && n10 != 0) {
                object3 = "play:decode: push first i frame";
                TXCLog.w(string2, (String)object3);
                this.mRecvFirstFrame = n11;
            }
            if ((n12 = this.mRestarting) == 0 && (n12 = ((TXSNALPacket)object).codecId) == n11 && (n12 = (int)(this.mHWDec ? 1 : 0)) == 0) {
                object3 = "play:decode: hevc decode error  ";
                TXCLog.w(string2, (String)object3);
                object3 = this.mNotifyListener;
                int n13 = -2304;
                String string3 = "h265 Decoding failed";
                g.a((WeakReference)object3, n13, string3);
                this.mRestarting = n11;
            }
            if ((object2 = this.mDecoderHandler) != null) {
                object4 = this.mNALList;
                n10 = (int)(((ArrayList)object4).isEmpty() ? 1 : 0);
                if (n10 == 0) {
                    object4 = this.mNALList;
                    object4 = ((ArrayList)object4).iterator();
                    while ((n11 = (int)(object4.hasNext() ? 1 : 0)) != 0) {
                        object2 = object4.next();
                        object2 = (TXSNALPacket)object2;
                        this.addOneNalToDecoder((TXSNALPacket)object2);
                    }
                }
                object4 = this.mNALList;
                ((ArrayList)object4).clear();
                this.addOneNalToDecoder((TXSNALPacket)object);
                return;
            }
            if (n10 != 0 && (n10 = (int)(((ArrayList)(object4 = this.mNALList)).isEmpty() ? 1 : 0)) == 0) {
                object4 = this.mNALList;
                ((ArrayList)object4).clear();
            }
            object4 = this.mNALList;
            ((ArrayList)object4).add(object);
            boolean bl2 = this.mRestarting;
            if (bl2) return;
            this.start();
            return;
        }
        catch (Exception exception) {
            String string4 = "decode NAL By Old way failed.";
            TXCLog.e(string2, string4, exception);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void decodeFrame(byte[] object, long l10, long l11, int n10, int n11, int n12, int n13, int n14) {
        TXSNALPacket tXSNALPacket = new TXSNALPacket();
        tXSNALPacket.nalData = object;
        tXSNALPacket.pts = l10;
        tXSNALPacket.dts = l11;
        tXSNALPacket.rotation = n10;
        tXSNALPacket.codecId = n11;
        tXSNALPacket.nalType = n14;
        synchronized (this) {
            long l12 = this.mNativeContext;
            long l13 = 0L;
            long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
            if (l14 != false && (object = (Object)this.mVideoDecoder) == null) {
                object = new e;
                ((e)object)();
                ((e)object).a(n12, n13);
                ((e)object).setListener(this);
                Object object2 = new WeakReference(this);
                ((e)object).setNotifyListener((WeakReference)object2);
                object2 = this.mDecFormat;
                ((e)object).a((JSONArray)object2);
                object2 = this.mSurface;
                ((e)object).config((Surface)object2);
                boolean bl2 = this.mEnableLimitDecCache;
                ((e)object).enableLimitDecCache(bl2);
                object2 = this.mSps;
                ByteBuffer byteBuffer = this.mPps;
                boolean bl3 = this.mNeedSortFrame;
                boolean bl4 = this.mHevc;
                ((e)object).start((ByteBuffer)object2, byteBuffer, bl3, bl4);
                bl2 = true;
                this.notifyDecoderStartEvent(bl2);
                this.mVideoDecoder = object;
            }
            if ((object = (Object)this.mVideoDecoder) != null) {
                object.decode(tXSNALPacket);
            }
            return;
        }
    }

    private boolean hasSurface() {
        boolean bl2;
        Surface surface = this.mSurface;
        if (surface != null) {
            bl2 = true;
        } else {
            bl2 = false;
            surface = null;
        }
        return bl2;
    }

    private native long nativeCreateContext(boolean var1);

    private native void nativeDecCache(long var1);

    private native void nativeDecodeFrame(long var1, byte[] var3, int var4, long var5, long var7, int var9, int var10);

    private native void nativeDestroyContext(long var1);

    private native void nativeEnableDecodeChange(long var1, boolean var3);

    private native void nativeEnableRestartDecoder(long var1, boolean var3);

    private native void nativeNotifyHWDecoderError(long var1);

    private native void nativeNotifyPts(long var1, long var3, int var5, int var6);

    private native void nativeReStart(long var1, boolean var3);

    private native void nativeSetID(long var1, String var3);

    private native void nativeSetStreamType(long var1, int var3);

    private void notifyDecoderStartEvent(boolean bl2) {
        long l10;
        String string2 = this.mUserId;
        long l11 = 1L;
        long l12 = bl2 ? l11 : (l10 = 0L);
        long l13 = -1;
        int n10 = this.mStreamType;
        int n11 = 4005;
        String string3 = "";
        TXCEventRecorderProxy.a(string2, n11, l12, l13, string3, n10);
        string2 = new Bundle();
        int n12 = 2008;
        string2.putInt("EVT_ID", n12);
        long l14 = TXCTimeUtil.getTimeTick();
        string2.putLong("EVT_TIME", l14);
        l14 = TXCTimeUtil.getUtcTimeTick();
        Object object = "EVT_UTC_TIME";
        string2.putLong((String)object, l14);
        object = bl2 ? "Enables hardware decoding" : "Enables software decoding";
        String string4 = "EVT_MSG";
        string2.putCharSequence(string4, (CharSequence)object);
        n11 = bl2 ? 1 : 2;
        string2.putInt("EVT_PARAM1", n11);
        object = this.mNotifyListener;
        string4 = this.mUserId;
        g.a((WeakReference)object, string4, n12, (Bundle)string2);
        string2 = this.mUserId;
        n11 = 40026;
        if (!bl2) {
            l11 = 2;
        }
        int n13 = this.mStreamType;
        TXCKeyPointReportProxy.a(string2, n11, l11, n13);
    }

    private void onDecodeDone(TXSVideoFrame tXSVideoFrame, int n10, int n11, long l10, long l11, int n12, int n13) {
        f f10;
        int n14;
        int n15;
        Object object;
        TXCVideoDecoder tXCVideoDecoder = this;
        TXSVideoFrame tXSVideoFrame2 = tXSVideoFrame;
        int n16 = n10;
        int n17 = n11;
        long l12 = mDecodeFirstFrameTS;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 == false) {
            mDecodeFirstFrameTS = l12 = TXCTimeUtil.getTimeTick();
            object = new StringBuilder();
            ((StringBuilder)object).append("[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:");
            n15 = this.hashCode();
            ((StringBuilder)object).append(n15);
            ((StringBuilder)object).append(" isHWAcc:false isHEVC:");
            n15 = (int)(this.mHevc ? 1 : 0);
            ((StringBuilder)object).append(n15 != 0);
            ((StringBuilder)object).append(" userId:");
            String string2 = this.mUserId;
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(" type:");
            n15 = this.mStreamType;
            ((StringBuilder)object).append(n15);
            object = ((StringBuilder)object).toString();
            string2 = "TXCVideoDecoder";
            TXCLog.i(string2, (String)object);
            object = this.mUserId;
            n15 = 5005;
            n14 = this.mStreamType;
            l13 = mDecodeFirstFrameTS;
            Long l15 = l13;
            TXCStatus.a((String)object, n15, n14, l15);
            object2 = this.mHevc;
            if (object2 != false) {
                object2 = 2;
            } else {
                object2 = 0;
                object = null;
            }
            string2 = tXCVideoDecoder.mUserId;
            n14 = 5004;
            int n18 = tXCVideoDecoder.mStreamType;
            object = (int)object2;
            TXCStatus.a(string2, n14, n18, object);
        }
        if ((f10 = tXCVideoDecoder.mDecoderListener) != null) {
            tXSVideoFrame2.width = n16;
            tXSVideoFrame2.height = n17;
            tXSVideoFrame2.rotation = n12;
            l13 = l10;
            tXSVideoFrame2.pts = l10;
            object2 = n13;
            tXSVideoFrame2.frameType = n13;
            object = f10;
            tXSVideoFrame2 = tXSVideoFrame;
            n15 = n10;
            n14 = n11;
            f10.onDecodeFrame(tXSVideoFrame, n10, n11, l10, l11, n12);
            object2 = tXCVideoDecoder.mVideoWidth;
            if (object2 != n16 || (object2 = (Object)tXCVideoDecoder.mVideoHeight) != n17) {
                tXCVideoDecoder.mVideoWidth = n16;
                tXCVideoDecoder.mVideoHeight = n17;
                f10.onVideoSizeChange(n10, n17);
            }
        }
    }

    private void onStartDecoder(boolean bl2) {
        this.notifyDecoderStartEvent(bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private int startDecodeThread() {
        synchronized (this) {
            Object object;
            Object object2 = this.mDecoderHandler;
            if (object2 != null) {
                object2 = "TXCVideoDecoder";
                String string2 = "play:decode: start decoder error when decoder is started";
                TXCLog.e((String)object2, string2);
                return -1;
            }
            boolean bl2 = false;
            object2 = null;
            this.mDecoderCacheNum = 0;
            this.mRestarting = false;
            Object object3 = "VDecoder";
            Object object4 = new HandlerThread((String)object3);
            object4.start();
            boolean bl3 = this.mHWDec;
            if (bl3) {
                object3 = new StringBuilder();
                object = "VideoWDec";
                ((StringBuilder)object3).append((String)object);
                long l10 = object4.getId();
                ((StringBuilder)object3).append(l10);
                object3 = ((StringBuilder)object3).toString();
                object4.setName((String)object3);
            } else {
                object3 = new StringBuilder();
                object = "VideoSWDec";
                ((StringBuilder)object3).append((String)object);
                long l11 = object4.getId();
                ((StringBuilder)object3).append(l11);
                object3 = ((StringBuilder)object3).toString();
                object4.setName((String)object3);
            }
            object4 = object4.getLooper();
            object3 = new TXCVideoDecoder$a((Looper)object4);
            boolean bl4 = this.mHevc;
            boolean bl5 = this.mHWDec;
            Surface surface = this.mSurface;
            ByteBuffer byteBuffer = this.mSps;
            ByteBuffer byteBuffer2 = this.mPps;
            object = object3;
            ((TXCVideoDecoder$a)((Object)object3)).a(bl4, bl5, surface, byteBuffer, byteBuffer2, this, this);
            object4 = "TXCVideoDecoder";
            object = "play:decode: start decode thread";
            TXCLog.w((String)object4, (String)object);
            object4 = Message.obtain();
            boolean bl6 = 100 != 0;
            object4.what = bl6;
            bl6 = this.mNeedSortFrame;
            object4.obj = object = Boolean.valueOf(bl6);
            object3.sendMessage((Message)object4);
            this.mDecoderHandler = object3;
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void stopDecodeThread() {
        synchronized (this) {
            TXCVideoDecoder$a tXCVideoDecoder$a = this.mDecoderHandler;
            if (tXCVideoDecoder$a != null) {
                int n10 = 102;
                tXCVideoDecoder$a.sendEmptyMessage(n10);
            }
            tXCVideoDecoder$a = null;
            this.mDecoderHandler = null;
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void stopHWDecoder() {
        synchronized (this) {
            b b10 = this.mVideoDecoder;
            if (b10 != null) {
                b10.stop();
                b10 = this.mVideoDecoder;
                b10.setListener(null);
                b10 = this.mVideoDecoder;
                b10.setNotifyListener(null);
                this.mVideoDecoder = null;
            }
            return;
        }
    }

    public long GetDecodeFirstFrameTS() {
        return mDecodeFirstFrameTS;
    }

    public void config(JSONArray jSONArray) {
        this.mDecFormat = jSONArray;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void enableChange(boolean bl2) {
        this.mEnableDecoderChange = bl2;
        synchronized (this) {
            long l10 = this.mNativeContext;
            bl2 = this.mEnableDecoderChange;
            this.nativeEnableDecodeChange(l10, bl2);
            return;
        }
    }

    public void enableHWDec(boolean bl2) {
        this.mHWDec = bl2;
    }

    public void enableLimitDecCache(boolean bl2) {
        this.mEnableLimitDecCache = bl2;
        b b10 = this.mVideoDecoder;
        if (b10 != null) {
            b10.enableLimitDecCache(bl2);
        }
    }

    public void enableRestart(boolean bl2) {
        this.mEnableRestartDecoder = bl2;
    }

    public int getDecoderCacheNum() {
        int n10 = this.mDecoderCacheNum;
        int n11 = this.mNALList.size();
        return n10 + n11;
    }

    public boolean isHardwareDecode() {
        boolean bl2;
        b b10 = this.mVideoDecoder;
        if (b10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            b10 = null;
        }
        return bl2;
    }

    public boolean isHevc() {
        TXCVideoDecoder$a tXCVideoDecoder$a = this.mDecoderHandler;
        if (tXCVideoDecoder$a != null) {
            return tXCVideoDecoder$a.a();
        }
        return false;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDecodeFailed(int n10) {
        Object object = this.mUserId;
        int n11 = this.mStreamType;
        Integer n12 = n10;
        int n13 = 9007;
        TXCStatus.a((String)object, n13, n11, n12);
        object = this.mDecoderListener;
        if (object != null) {
            object.onDecodeFailed(n10);
        }
        synchronized (this) {
            long l10 = this.mNativeContext;
            this.nativeDecCache(l10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int n10, int n11, long l10, long l11, int n12) {
        Object object;
        f f10;
        long l12;
        int n13;
        Object object2;
        int n14;
        TXCVideoDecoder tXCVideoDecoder = this;
        long l13 = mDecodeFirstFrameTS;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        int n15 = 1;
        if (l15 == false) {
            mDecodeFirstFrameTS = l14 = TXCTimeUtil.getTimeTick();
            CharSequence charSequence = new StringBuilder();
            charSequence.append("[FirstFramePath][Video][Decoder] TXCVideoDecoder: decode first frame success. instance:");
            n14 = this.hashCode();
            charSequence.append(n14);
            charSequence.append(" isHWAcc:true isHEVC:");
            n14 = (int)(this.mHevc ? 1 : 0);
            charSequence.append(n14 != 0);
            charSequence.append(" userId:");
            String string2 = this.mUserId;
            charSequence.append(string2);
            string2 = " type:";
            charSequence.append(string2);
            n14 = this.mStreamType;
            charSequence.append(n14);
            charSequence = charSequence.toString();
            TXCLog.i("TXCVideoDecoder", (String)charSequence);
            object2 = this.mUserId;
            n13 = 5005;
            n14 = this.mStreamType;
            l12 = mDecodeFirstFrameTS;
            Long l16 = l12;
            TXCStatus.a((String)object2, n13, n14, l16);
            l15 = (long)this.mHevc;
            l15 = l15 != false ? (long)3 : (long)n15;
            charSequence = tXCVideoDecoder.mUserId;
            n14 = 5004;
            int n16 = tXCVideoDecoder.mStreamType;
            object2 = (int)l15;
            TXCStatus.a((String)charSequence, n14, n16, object2);
        }
        if ((f10 = tXCVideoDecoder.mDecoderListener) != null) {
            f10.onDecodeFrame(tXSVideoFrame, n10, n11, l10, l11, n12);
        }
        if ((l15 = (long)tXCVideoDecoder.mDecoderCacheNum) > 0) {
            tXCVideoDecoder.mDecoderCacheNum = (int)(l15 -= n15);
        }
        if (tXSVideoFrame == null) {
            synchronized (this) {
                l14 = tXCVideoDecoder.mNativeContext;
                object = this;
                l12 = l10;
                this.nativeNotifyPts(l14, l10, n10, n11);
            }
        }
        object2 = tXCVideoDecoder.mVideoDecoder;
        l15 = object2.GetDecodeCost();
        n15 = tXCVideoDecoder.mHWDec;
        if (n15 != 0) {
            object = tXCVideoDecoder.mUserId;
            n13 = 8004;
            n14 = tXCVideoDecoder.mStreamType;
            object2 = (int)l15;
            TXCStatus.a((String)object, n13, n14, object2);
            return;
        }
        object = tXCVideoDecoder.mUserId;
        n13 = 8003;
        n14 = tXCVideoDecoder.mStreamType;
        object2 = (int)l15;
        TXCStatus.a((String)object, n13, n14, object2);
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        int n11 = 2106;
        if (n10 == n11) {
            long l10 = this.mNativeContext;
            this.nativeNotifyHWDecoderError(l10);
        }
        WeakReference weakReference = this.mNotifyListener;
        String string2 = this.mUserId;
        g.a(weakReference, string2, n10, bundle);
    }

    public void onVideoSizeChange(int n10, int n11) {
        int n12;
        f f10 = this.mDecoderListener;
        if (f10 != null && ((n12 = this.mVideoWidth) != n10 || (n12 = this.mVideoHeight) != n11)) {
            this.mVideoWidth = n10;
            this.mVideoHeight = n11;
            f10.onVideoSizeChange(n10, n11);
        }
    }

    public void pushNAL(TXSNALPacket tXSNALPacket) {
        this.decNALByNewWay(tXSNALPacket);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void restart(boolean bl2) {
        synchronized (this) {
            this.mHWDec = bl2;
            long l10 = this.mNativeContext;
            this.nativeReStart(l10, bl2);
            return;
        }
    }

    public void setListener(f f10) {
        this.mDecoderListener = f10;
    }

    public void setNotifyListener(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.mNotifyListener = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setStreamType(int n10) {
        this.mStreamType = n10;
        synchronized (this) {
            long l10 = this.mNativeContext;
            n10 = this.mStreamType;
            this.nativeSetStreamType(l10, n10);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void setUserId(String string2) {
        this.mUserId = string2;
        synchronized (this) {
            long l10 = this.mNativeContext;
            string2 = this.mUserId;
            this.nativeSetID(l10, string2);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int setup(SurfaceTexture surfaceTexture, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean bl2) {
        Surface surface;
        synchronized (this) {
            surface = this.mSurface;
            if (surface != null) {
                surface.release();
                surface = null;
                this.mSurface = null;
            }
        }
        surface = new Surface(surfaceTexture);
        return this.setup(surface, byteBuffer, byteBuffer2, bl2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int setup(Surface surface, ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean bl2) {
        synchronized (this) {
            this.mSurface = surface;
        }
        this.mSps = byteBuffer;
        this.mPps = byteBuffer2;
        this.mNeedSortFrame = bl2;
        return 0;
    }

    public int start() {
        synchronized (this) {
            Object object;
            int n10;
            boolean bl2;
            block38: {
                block37: {
                    bl2 = this.mHWDec;
                    n10 = -1;
                    if (!bl2) break block37;
                    object = this.mSurface;
                    if (object != null) break block37;
                    object = "TXCVideoDecoder";
                    CharSequence charSequence = new StringBuilder();
                    String string2 = "play:decode: start decoder error when not setup surface, id ";
                    charSequence.append(string2);
                    string2 = this.mUserId;
                    charSequence.append(string2);
                    string2 = "_";
                    charSequence.append(string2);
                    int n11 = this.mStreamType;
                    charSequence.append(n11);
                    charSequence = charSequence.toString();
                    TXCLog.i((String)object, (String)charSequence);
                    return n10;
                }
                long l10 = this.mNativeContext;
                long l11 = 0L;
                bl2 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
                if (!bl2) break block38;
                object = "TXCVideoDecoder";
                CharSequence charSequence = new StringBuilder();
                String string3 = "play:decode: start decoder error when decoder is started, id ";
                charSequence.append(string3);
                string3 = this.mUserId;
                charSequence.append(string3);
                string3 = "_";
                charSequence.append(string3);
                int n12 = this.mStreamType;
                charSequence.append(n12);
                charSequence = charSequence.toString();
                TXCLog.w((String)object, (String)charSequence);
                return n10;
            }
            object = new StringBuilder();
            String string4 = "[FirstFramePath][Video][Decoder] TXCVideoDecoder: start decode. instance:";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(this);
            string4 = " userId:";
            ((StringBuilder)object).append(string4);
            string4 = this.mUserId;
            ((StringBuilder)object).append(string4);
            string4 = " type:";
            ((StringBuilder)object).append(string4);
            n10 = this.mStreamType;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            string4 = "TXCVideoDecoder";
            TXCLog.i(string4, (String)object);
            bl2 = this.mHWDec;
            long l12 = this.nativeCreateContext(bl2);
            this.mNativeContext = l12;
            String string5 = this.mUserId;
            this.nativeSetID(l12, string5);
            l12 = this.mNativeContext;
            int bl3 = this.mStreamType;
            this.nativeSetStreamType(l12, bl3);
            l12 = this.mNativeContext;
            boolean bl4 = this.mEnableDecoderChange;
            this.nativeEnableDecodeChange(l12, bl4);
            l12 = this.mNativeContext;
            boolean bl5 = this.mEnableRestartDecoder;
            this.nativeEnableRestartDecoder(l12, bl5);
            return 0;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    public void stop() {
        // MONITORENTER : this
        long l10 = this.mNativeContext;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            String string2 = "TXCVideoDecoder";
            CharSequence charSequence = new StringBuilder();
            String string3 = "play:decode: stop decoder ignore when decoder is stopped, id ";
            charSequence.append(string3);
            string3 = this.mUserId;
            charSequence.append(string3);
            string3 = "_";
            charSequence.append(string3);
            int n10 = this.mStreamType;
            charSequence.append(n10);
            charSequence = charSequence.toString();
            TXCLog.w(string2, (String)charSequence);
            // MONITOREXIT : this
            return;
        }
        Object object = "TXCVideoDecoder";
        CharSequence charSequence = new StringBuilder();
        String string4 = "play:decode: stop decoder java id ";
        charSequence.append(string4);
        string4 = this.mUserId;
        charSequence.append(string4);
        string4 = "_";
        charSequence.append(string4);
        int n11 = this.mStreamType;
        charSequence.append(n11);
        string4 = " ";
        charSequence.append(string4);
        n11 = this.hashCode();
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.w((String)object, (String)charSequence);
        l10 = this.mNativeContext;
        this.nativeDestroyContext(l10);
        this.mNativeContext = l11;
        object = this.mNALList;
        ((ArrayList)object).clear();
        l12 = 0;
        object = null;
        this.mRecvFirstFrame = false;
        this.mDecoderCacheNum = 0;
        mDecodeFirstFrameTS = l11;
        // MONITORENTER : this
        object = this.mVideoDecoder;
        charSequence = null;
        if (object != null) {
            object.stop();
            object = this.mVideoDecoder;
            object.setListener(null);
            object = this.mVideoDecoder;
            object.setNotifyListener(null);
            this.mVideoDecoder = null;
        }
        if ((object = this.mSurface) != null) {
            object.release();
            this.mSurface = null;
        }
        // MONITOREXIT : this
        // MONITOREXIT : this
    }
}

