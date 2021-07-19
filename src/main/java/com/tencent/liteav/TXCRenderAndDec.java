/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.opengl.GLES20
 *  android.os.Bundle
 *  android.view.Surface
 *  org.json.JSONArray
 */
package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Bundle;
import android.view.Surface;
import com.tencent.liteav.TXCRenderAndDec$a;
import com.tencent.liteav.TXCRenderAndDec$b;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.h;
import com.tencent.liteav.r;
import com.tencent.liteav.renderer.a;
import com.tencent.liteav.renderer.a$a;
import com.tencent.liteav.renderer.e;
import com.tencent.liteav.renderer.f;
import com.tencent.liteav.videodecoder.TXCVideoDecoder;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class TXCRenderAndDec
extends com.tencent.liteav.basic.module.a
implements b,
a$a,
f,
com.tencent.liteav.videodecoder.f {
    public static final String TAG = "TXCRenderAndDec";
    private h mConfig = null;
    private Context mContext = null;
    private int mCustomRenderFrameBufferId = -1;
    private TXCRenderAndDec$a mDecListener;
    private boolean mEnableDecoderChange = false;
    private boolean mEnableLimitHWDecCache = false;
    private boolean mEnableRestartDecoder = false;
    private boolean mFirstRender;
    private long mFrameDecErrCnt;
    private boolean mIsRendering;
    private long mLastRenderCalculateTS;
    private long mLastRenderFrameCount;
    private long mLastReqKeyFrameTS;
    private WeakReference mNotifyListener;
    private i mRGBA2YUVFilter = null;
    private boolean mRealTime;
    private WeakReference mRenderAndDecDelegate;
    private long mRenderFrameCount;
    private int mRenderMode;
    private int mRenderRotation;
    private int mStreamType;
    private TXCVideoDecoder mVideoDecoder = null;
    private com.tencent.liteav.basic.a.b mVideoFrameFormat;
    private r mVideoFrameListener;
    private e mVideoRender = null;

    public TXCRenderAndDec(Context object) {
        long l10;
        com.tencent.liteav.basic.a.b b10;
        this.mVideoFrameFormat = b10 = com.tencent.liteav.basic.a.b.a;
        this.mRealTime = false;
        this.mIsRendering = false;
        this.mStreamType = 0;
        this.mFrameDecErrCnt = l10 = 0L;
        this.mLastReqKeyFrameTS = l10;
        this.mFirstRender = false;
        this.mRenderMode = 0;
        this.mRenderRotation = 0;
        this.mLastRenderCalculateTS = l10;
        this.mRenderFrameCount = l10;
        this.mLastRenderFrameCount = l10;
        this.mDecListener = null;
        this.mContext = object;
        object = c.a();
        Context context = this.mContext;
        ((c)object).a(context);
    }

    private void notifyEvent(int n10, String string2) {
        Bundle bundle = new Bundle();
        String string3 = this.getID();
        String string4 = "EVT_USERID";
        bundle.putString(string4, string3);
        string3 = "EVT_ID";
        bundle.putInt(string3, n10);
        long l10 = TXCTimeUtil.getTimeTick();
        String string5 = "EVT_TIME";
        bundle.putLong(string5, l10);
        if (string2 != null) {
            string3 = "EVT_MSG";
            bundle.putCharSequence(string3, (CharSequence)string2);
        }
        int n11 = this.mStreamType;
        bundle.putInt("EVT_STREAM_TYPE", n11);
        g.a(this.mNotifyListener, n10, bundle);
    }

    private void requestKeyFrame() {
        long l10 = TXCTimeUtil.getTimeTick();
        long l11 = this.mLastReqKeyFrameTS;
        long l12 = 3000L;
        long l13 = l10 - (l11 += l12);
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object > 0) {
            this.mLastReqKeyFrameTS = l10;
            Object object2 = new StringBuilder();
            ((StringBuilder)object2).append("requestKeyFrame: ");
            String string2 = this.getID();
            ((StringBuilder)object2).append(string2);
            object2 = ((StringBuilder)object2).toString();
            string2 = TAG;
            TXCLog.e(string2, (String)object2);
            object2 = this.mRenderAndDecDelegate;
            if (object2 != null && (object2 = (TXCRenderAndDec$b)((Reference)object2).get()) != null) {
                string2 = this.getID();
                object = this.mStreamType;
                object2.b(string2, (int)object);
            }
        }
    }

    private void startDecode() {
        e e10 = this.mVideoRender;
        e10 = e10 != null ? e10.a() : null;
        this.startDecode((SurfaceTexture)e10);
    }

    private void startDecode(SurfaceTexture object) {
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.stop();
            boolean bl2 = this.mConfig.h;
            tXCVideoDecoder.enableHWDec(bl2);
            Object object2 = this.mConfig.y;
            tXCVideoDecoder.config((JSONArray)object2);
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("trtc_ start decode ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(", hw: ");
            boolean bl3 = this.mConfig.h;
            ((StringBuilder)object2).append(bl3);
            ((StringBuilder)object2).append(", id ");
            String string2 = this.getID();
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append("_");
            int n10 = this.mStreamType;
            ((StringBuilder)object2).append(n10);
            object2 = ((StringBuilder)object2).toString();
            string2 = TAG;
            TXCLog.i(string2, (String)object2);
            bl2 = false;
            object2 = null;
            if (object != null) {
                boolean bl4 = this.mRealTime ^ true;
                tXCVideoDecoder.setup((SurfaceTexture)object, null, null, bl4);
                object = this.getID();
                tXCVideoDecoder.setUserId((String)object);
                tXCVideoDecoder.start();
            } else {
                object = this.mConfig;
                boolean bl5 = ((h)object).h;
                if (!bl5) {
                    bl5 = this.mRealTime ^ true;
                    tXCVideoDecoder.setup((Surface)null, (ByteBuffer)null, (ByteBuffer)null, bl5);
                    object = this.getID();
                    tXCVideoDecoder.setUserId((String)object);
                    tXCVideoDecoder.start();
                }
            }
        }
    }

    public void decVideo(TXSNALPacket tXSNALPacket) {
    }

    public void enableDecoderChange(boolean bl2) {
        this.mEnableDecoderChange = bl2;
    }

    public void enableLimitDecCache(boolean bl2) {
        this.mEnableLimitHWDecCache = bl2;
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null) {
            tXCVideoDecoder.enableLimitDecCache(bl2);
        }
    }

    public void enableRestartDecoder(boolean bl2) {
        this.mEnableRestartDecoder = bl2;
    }

    public long getAVNetRecvInterval() {
        return this.getLongValue(6014, 2);
    }

    public long getAVPlayInterval() {
        return this.getLongValue(6013, 2);
    }

    public h getConfig() {
        return this.mConfig;
    }

    public int getStreamType() {
        return this.mStreamType;
    }

    public long getVideoCacheDuration() {
        return this.getIntValue(6010, 2);
    }

    public long getVideoCacheFrameCount() {
        return this.getIntValue(6011, 2);
    }

    public int getVideoDecCacheFrameCount() {
        return this.getIntValue(6012, 2);
    }

    public int getVideoGop() {
        return this.getIntValue(7120);
    }

    public e getVideoRender() {
        return this.mVideoRender;
    }

    public boolean isRendering() {
        return this.mIsRendering;
    }

    public void muteVideo(boolean bl2) {
        e e10;
        if (!bl2 && (e10 = this.mVideoRender) != null) {
            e10.m();
        }
    }

    public void onDecodeFailed(int n10) {
        long l10;
        Comparable<StringBuilder> comparable = new StringBuilder();
        comparable.append("video decode failed ");
        comparable.append(n10);
        String string2 = comparable.toString();
        TXCLog.e(TAG, string2);
        this.requestKeyFrame();
        n10 = this.mStreamType;
        this.mFrameDecErrCnt = l10 = this.mFrameDecErrCnt + 1L;
        comparable = l10;
        this.setStatusValue(17014, n10, comparable);
    }

    public void onDecodeFrame(TXSVideoFrame tXSVideoFrame, int n10, int n11, long l10, long l11, int n12) {
        Object object;
        int n13;
        Object object2;
        Object object3;
        Object object4;
        r r10;
        int n14;
        TXCRenderAndDec tXCRenderAndDec = this;
        TXSVideoFrame tXSVideoFrame2 = tXSVideoFrame;
        int n15 = n12;
        int n16 = 2;
        int n17 = 1;
        if (n12 == 0 || n12 == n17 || n12 == n16 || n12 == (n14 = 3)) {
            n15 *= 90;
            n15 = 360 - n15;
        }
        if ((r10 = tXCRenderAndDec.mVideoFrameListener) != null && tXSVideoFrame2 != null && ((object4 = tXCRenderAndDec.mVideoFrameFormat) == (object3 = com.tencent.liteav.basic.a.b.b) || object4 == (object3 = com.tencent.liteav.basic.a.b.e))) {
            int n18;
            object4 = tXCRenderAndDec.mVideoRender;
            object4 = object4 != null ? tXSVideoFrame.clone() : tXSVideoFrame2;
            ((TXSVideoFrame)object4).rotation = n18 = (tXCRenderAndDec.mRenderRotation + n15) % 360;
            object3 = tXCRenderAndDec.mVideoFrameFormat;
            object2 = com.tencent.liteav.basic.a.b.e;
            if (object3 == object2) {
                ((TXSVideoFrame)object4).loadNV21BufferFromI420Buffer();
            }
            object3 = this.getID();
            n13 = tXCRenderAndDec.mStreamType;
            r10.a((String)object3, n13, (TXSVideoFrame)object4);
        }
        n14 = (int)(tXCRenderAndDec.mFirstRender ? 1 : 0);
        long l12 = 0L;
        if (n14 == 0) {
            tXCRenderAndDec.mFirstRender = n17;
            object2 = this.getID();
            int n19 = 5007;
            long l13 = -1;
            long l14 = -1;
            int n20 = tXCRenderAndDec.mStreamType;
            String string2 = "";
            TXCEventRecorderProxy.a(object2, n19, l13, l14, string2, n20);
            Object object5 = tXCRenderAndDec.mVideoRender;
            if (object5 == null) {
                object5 = this.getID();
                n14 = 40022;
                n13 = tXCRenderAndDec.mStreamType;
                TXCKeyPointReportProxy.a((String)object5, n14, l12, n13);
            }
            if ((object5 = tXCRenderAndDec.mVideoDecoder) != null) {
                object5 = this.getID();
                n14 = 40029;
                object2 = tXCRenderAndDec.mVideoDecoder;
                long l15 = ((TXCVideoDecoder)object2).GetDecodeFirstFrameTS();
                int n21 = tXCRenderAndDec.mStreamType;
                TXCKeyPointReportProxy.a((String)object5, n14, l15, n21);
            }
            if ((n17 = tXCRenderAndDec.mStreamType) == n16) {
                object = this.getID();
                n17 = 32004;
                TXCKeyPointReportProxy.a((String)object, n17);
            }
        }
        if ((object = tXCRenderAndDec.mVideoRender) != null) {
            n17 = n10;
            n14 = n11;
            ((e)object).a(tXSVideoFrame2, n10, n11, n15);
        } else {
            long l16 = tXCRenderAndDec.mLastRenderCalculateTS;
            long l17 = l16 - l12;
            Object object6 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
            if (object6 == false) {
                tXCRenderAndDec.mLastRenderCalculateTS = l16 = System.currentTimeMillis();
                tXCRenderAndDec.mLastRenderFrameCount = l12;
                tXCRenderAndDec.mRenderFrameCount = l12;
            } else {
                l16 = tXCRenderAndDec.mRenderFrameCount;
                long l18 = 1L;
                tXCRenderAndDec.mRenderFrameCount = l16 += l18;
            }
        }
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        int n11 = 2106;
        if (n10 == n11) {
            this.mConfig.h = false;
            TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
            if (tXCVideoDecoder != null) {
                tXCVideoDecoder.restart(false);
            }
        } else {
            n11 = 2020;
            if (n10 == n11) {
                TXCLog.e(TAG, "decoding too many frame(>40) without output! request key frame now.");
                this.requestKeyFrame();
                return;
            }
        }
        n11 = this.mStreamType;
        bundle.putInt("EVT_STREAM_TYPE", n11);
        g.a(this.mNotifyListener, n10, bundle);
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("play decode when surface texture create hw ");
        boolean bl2 = this.mConfig.h;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.w(string2, (String)object);
        object = this.mVideoDecoder;
        if (object != null) {
            bl2 = this.mRealTime ^ true;
            ((TXCVideoDecoder)object).setup(surfaceTexture, null, null, bl2);
        }
        object = this.mConfig;
        boolean bl3 = ((h)object).h;
        if (bl3) {
            this.startDecode(surfaceTexture);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onSurfaceTextureDestroy(SurfaceTexture surfaceTexture) {
        String string2 = TAG;
        Object object = "play:stop decode when surface texture release";
        try {
            int n10;
            TXCLog.w(string2, (String)object);
            object = this.mConfig;
            int n11 = ((h)object).h;
            if (n11 != 0 && (object = this.mVideoDecoder) != null) {
                ((TXCVideoDecoder)object).stop();
            }
            if ((n11 = this.mCustomRenderFrameBufferId) != (n10 = -1)) {
                TXCOpenGlUtils.b(n11);
                this.mCustomRenderFrameBufferId = n10;
            }
            if ((object = this.mRGBA2YUVFilter) != null) {
                ((i)object).d();
                n11 = 0;
                object = null;
                this.mRGBA2YUVFilter = null;
            }
            if ((object = this.mDecListener) == null) return;
            object.a(surfaceTexture);
            return;
        }
        catch (Exception exception) {
            object = "onSurfaceTextureDestroy failed.";
            TXCLog.e(string2, (String)object, exception);
        }
    }

    public void onTextureProcess(int n10, int n11, int n12, int n13) {
        long l10;
        r r10 = this.mVideoFrameListener;
        if (r10 == null) {
            return;
        }
        TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
        tXSVideoFrame.width = n11;
        tXSVideoFrame.height = n12;
        tXSVideoFrame.pts = l10 = TXCTimeUtil.getTimeTick();
        int n14 = this.mRenderRotation;
        tXSVideoFrame.rotation = n13 = (n13 + n14) % 360;
        Object object = this.mVideoFrameFormat;
        Object object2 = com.tencent.liteav.basic.a.b.f;
        int n15 = 36160;
        if (object == object2) {
            Object object3;
            tXSVideoFrame.textureId = n10;
            tXSVideoFrame.eglContext = object3 = TXCOpenGlUtils.e();
            n11 = this.mCustomRenderFrameBufferId;
            n12 = -1;
            if (n11 == n12) {
                this.mCustomRenderFrameBufferId = n11 = TXCOpenGlUtils.d();
            }
            n11 = this.mCustomRenderFrameBufferId;
            TXCOpenGlUtils.a(n10, n11);
            n10 = this.mCustomRenderFrameBufferId;
            GLES20.glBindFramebuffer((int)n15, (int)n10);
            r r11 = this.mVideoFrameListener;
            object3 = this.getID();
            n12 = this.mStreamType;
            r11.a((String)object3, n12, tXSVideoFrame);
            n10 = this.mCustomRenderFrameBufferId;
            TXCOpenGlUtils.d(n10);
        } else {
            object2 = com.tencent.liteav.basic.a.b.c;
            if (object == object2) {
                tXSVideoFrame.textureId = n10;
                Object object4 = this.mVideoRender;
                n11 = object4 instanceof a;
                if (n11 != 0) {
                    tXSVideoFrame.eglContext = object4 = ((a)object4).b();
                }
                object4 = this.getID();
                n11 = this.mStreamType;
                r10.a((String)object4, n11, tXSVideoFrame);
            } else {
                object = this.mVideoDecoder;
                if (object != null && (n13 = (int)(((TXCVideoDecoder)object).isHardwareDecode() ? 1 : 0)) == 0) {
                    return;
                }
                object = this.mRGBA2YUVFilter;
                if (object == null) {
                    object = this.mVideoFrameFormat;
                    object2 = com.tencent.liteav.basic.a.b.e;
                    boolean bl2 = true;
                    if (object == object2) {
                        n14 = 3;
                        object = new o(n14);
                        this.mRGBA2YUVFilter = object;
                    } else {
                        object = new o((int)(bl2 ? 1 : 0));
                        this.mRGBA2YUVFilter = object;
                    }
                    this.mRGBA2YUVFilter.a(bl2);
                    object = this.mRGBA2YUVFilter;
                    n13 = (int)(((i)object).a() ? 1 : 0);
                    if (n13 != 0) {
                        object = this.mRGBA2YUVFilter;
                        ((i)object).a(n11, n12);
                    } else {
                        object2 = "throwVideoFrame->release mVideoFrameFilter";
                        TXCLog.i(TAG, (String)object2);
                        n13 = 0;
                        object = null;
                        this.mRGBA2YUVFilter = null;
                    }
                }
                if ((object = this.mRGBA2YUVFilter) != null) {
                    n13 = 0;
                    object = null;
                    GLES20.glViewport((int)0, (int)0, (int)n11, (int)n12);
                    object2 = this.mRGBA2YUVFilter;
                    ((i)object2).a(n11, n12);
                    i i10 = this.mRGBA2YUVFilter;
                    i10.b(n10);
                    n10 = this.mRGBA2YUVFilter.m();
                    GLES20.glBindFramebuffer((int)n15, (int)n10);
                    String string2 = this.getID();
                    n11 = this.mStreamType;
                    r10.a(string2, n11, tXSVideoFrame);
                    GLES20.glBindFramebuffer((int)n15, (int)0);
                }
            }
        }
    }

    public void onVideoSizeChange(int n10, int n11) {
        Object object = this.mVideoRender;
        if (object != null) {
            ((e)object).c(n10, n11);
        }
        object = new Bundle();
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Resolution changed to");
        charSequence.append(n10);
        charSequence.append("x");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        object.putCharSequence("EVT_MSG", charSequence);
        object.putInt("EVT_PARAM1", n10);
        object.putInt("EVT_PARAM2", n11);
        charSequence = this.getID();
        object.putString("EVT_USERID", (String)charSequence);
        long l10 = TXCTimeUtil.getTimeTick();
        object.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        object.putLong("EVT_UTC_TIME", l10);
        this.onNotifyEvent(2009, (Bundle)object);
        int n12 = this.mStreamType;
        Object object2 = n10 << 16 | n11;
        this.setStatusValue(5003, n12, object2);
        String string2 = this.getID();
        long l11 = n10;
        long l12 = n11;
        int n13 = this.mStreamType;
        TXCEventRecorderProxy.a(string2, 4003, l11, l12, "", n13);
        object2 = this.getID();
        int n14 = this.mStreamType;
        TXCKeyPointReportProxy.a((String)object2, 40002, l11, n14);
        object = this.getID();
        int n15 = this.mStreamType;
        TXCKeyPointReportProxy.a((String)object, 40003, l12, n15);
    }

    public void restartDecoder() {
        boolean bl2;
        TXCVideoDecoder tXCVideoDecoder = this.mVideoDecoder;
        if (tXCVideoDecoder != null && (bl2 = tXCVideoDecoder.isHevc())) {
            bl2 = true;
            tXCVideoDecoder.restart(bl2);
        }
    }

    public void setBlockInterval(int n10) {
        e e10 = this.mVideoRender;
        if (e10 != null) {
            e10.f(n10);
        }
    }

    public void setConfig(h h10) {
        this.mConfig = h10;
        e e10 = this.mVideoRender;
        if (e10 != null) {
            int n10 = h10.d;
            e10.b(n10);
        }
    }

    public void setDecListener(TXCRenderAndDec$a tXCRenderAndDec$a) {
        this.mDecListener = tXCRenderAndDec$a;
    }

    public void setID(String string2) {
        super.setID(string2);
        Object object = this.mVideoRender;
        if (object != null) {
            String string3 = this.getID();
            ((com.tencent.liteav.basic.module.a)object).setID(string3);
        }
        if ((object = this.mVideoDecoder) != null) {
            ((TXCVideoDecoder)object).setUserId(string2);
        }
    }

    public void setNotifyListener(b b10) {
        WeakReference<b> weakReference;
        this.mNotifyListener = weakReference = new WeakReference<b>(b10);
    }

    public void setRenderAndDecDelegate(TXCRenderAndDec$b tXCRenderAndDec$b) {
        WeakReference<TXCRenderAndDec$b> weakReference;
        this.mRenderAndDecDelegate = weakReference = new WeakReference<TXCRenderAndDec$b>(tXCRenderAndDec$b);
    }

    public void setRenderMirrorType(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setRenderMirrorType ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        object = this.mVideoRender;
        if (object != null) {
            ((e)object).d(n10);
        }
    }

    public void setRenderMode(int n10) {
        this.mRenderMode = n10;
        e e10 = this.mVideoRender;
        if (e10 != null) {
            e10.c(n10);
        }
    }

    public void setRenderRotation(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("vrotation setRenderRotation ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = TAG;
        TXCLog.i(string2, (String)object);
        this.mRenderRotation = n10;
        object = this.mVideoRender;
        if (object != null) {
            ((e)object).e(n10);
        }
    }

    public void setStreamType(int n10) {
        TXCVideoDecoder tXCVideoDecoder;
        this.mStreamType = n10;
        e e10 = this.mVideoRender;
        if (e10 != null) {
            e10.a(n10);
        }
        if ((tXCVideoDecoder = this.mVideoDecoder) != null) {
            int n11 = this.mStreamType;
            tXCVideoDecoder.setStreamType(n11);
        }
    }

    public void setVideoFrameListener(r object, com.tencent.liteav.basic.a.b object2) {
        boolean bl2;
        this.mVideoFrameListener = object;
        this.mVideoFrameFormat = object2;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("setVideoFrameListener->enter listener: ");
        charSequence.append(object);
        String string2 = ", format: ";
        charSequence.append(string2);
        charSequence.append(object2);
        object2 = charSequence.toString();
        charSequence = TAG;
        TXCLog.i((String)charSequence, (String)object2);
        object2 = this.mVideoRender;
        if (object2 != null && (bl2 = object2 instanceof a)) {
            if (object == null) {
                TXCLog.i((String)charSequence, "setCustomRenderListener-> clean listener.");
                object = (a)this.mVideoRender;
                bl2 = false;
                object2 = null;
                ((a)object).b((a$a)null);
            } else {
                TXCLog.i((String)charSequence, "setCustomRenderListener-> set listener.");
                object = (a)this.mVideoRender;
                ((a)object).b(this);
            }
        }
    }

    public void setVideoRender(e object) {
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("set video render ");
        ((StringBuilder)object2).append(object);
        ((StringBuilder)object2).append(" id ");
        String string2 = this.getID();
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(", ");
        int n10 = this.mStreamType;
        ((StringBuilder)object2).append(n10);
        object2 = ((StringBuilder)object2).toString();
        string2 = TAG;
        TXCLog.i(string2, (String)object2);
        this.mVideoRender = object;
        if (object == null) {
            return;
        }
        object2 = this.getID();
        ((com.tencent.liteav.basic.module.a)object).setID((String)object2);
        object = this.mVideoRender;
        int n11 = this.mStreamType;
        ((e)object).a(n11);
        this.mVideoRender.a(this);
        object = this.mVideoRender;
        n11 = this.mRenderMode;
        ((e)object).c(n11);
        object = this.mVideoRender;
        n11 = this.mRenderRotation;
        ((e)object).e(n11);
        object = this.mVideoFrameListener;
        if (object != null && (n11 = (object = this.mVideoRender) instanceof a) != 0) {
            object = (a)object;
            ((a)object).b(this);
        }
        if ((object = this.mConfig) != null) {
            object2 = this.mVideoRender;
            int n12 = ((h)object).d;
            ((e)object2).b(n12);
        }
    }

    public void start(boolean bl2) {
        long l10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("start render dec ");
        String string2 = this.getID();
        charSequence.append(string2);
        charSequence.append(", ");
        int n10 = this.mStreamType;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        string2 = TAG;
        TXCLog.i(string2, (String)charSequence);
        this.mRealTime = bl2;
        this.mFrameDecErrCnt = l10 = 0L;
        this.mLastReqKeyFrameTS = l10;
        Object object = this.mVideoRender;
        if (object != null) {
            ((e)object).a(this);
            this.mVideoRender.e();
            object = this.mVideoRender;
            charSequence = this.getID();
            ((com.tencent.liteav.basic.module.a)object).setID((String)charSequence);
        }
        this.mVideoDecoder = object = new TXCVideoDecoder();
        charSequence = this.getID();
        ((TXCVideoDecoder)object).setUserId((String)charSequence);
        object = this.mVideoDecoder;
        int bl3 = this.mStreamType;
        ((TXCVideoDecoder)object).setStreamType(bl3);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        object = this.mVideoDecoder;
        boolean bl4 = this.mEnableDecoderChange;
        ((TXCVideoDecoder)object).enableChange(bl4);
        object = this.mVideoDecoder;
        boolean bl5 = this.mEnableLimitHWDecCache;
        ((TXCVideoDecoder)object).enableLimitDecCache(bl5);
        object = this.mVideoDecoder;
        boolean bl6 = this.mEnableRestartDecoder;
        ((TXCVideoDecoder)object).enableRestart(bl6);
        this.startDecode();
        this.mIsRendering = true;
    }

    public void startVideo() {
        String string2;
        long l10;
        boolean bl2;
        this.stopVideo();
        this.mRealTime = bl2 = true;
        this.mFrameDecErrCnt = l10 = 0L;
        this.mLastReqKeyFrameTS = l10;
        Object object = this.mVideoRender;
        if (object != null) {
            ((e)object).a(this);
            this.mVideoRender.e();
            object = this.mVideoRender;
            string2 = this.getID();
            ((com.tencent.liteav.basic.module.a)object).setID(string2);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("start video dec ");
        string2 = this.getID();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", ");
        int bl3 = this.mStreamType;
        ((StringBuilder)object).append(bl3);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        this.mVideoDecoder = object = new TXCVideoDecoder();
        string2 = this.getID();
        ((TXCVideoDecoder)object).setUserId(string2);
        object = this.mVideoDecoder;
        int n10 = this.mStreamType;
        ((TXCVideoDecoder)object).setStreamType(n10);
        this.mVideoDecoder.setListener(this);
        this.mVideoDecoder.setNotifyListener(this);
        object = this.mVideoDecoder;
        boolean bl4 = this.mEnableDecoderChange;
        ((TXCVideoDecoder)object).enableChange(bl4);
        object = this.mVideoDecoder;
        boolean bl5 = this.mEnableRestartDecoder;
        ((TXCVideoDecoder)object).enableRestart(bl5);
        object = this.mVideoDecoder;
        boolean bl6 = this.mEnableLimitHWDecCache;
        ((TXCVideoDecoder)object).enableLimitDecCache(bl6);
        this.startDecode();
        this.mIsRendering = bl2;
    }

    public void stop() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stop video render dec ");
        String string2 = this.getID();
        ((StringBuilder)object).append(string2);
        ((StringBuilder)object).append(", ");
        int n10 = this.mStreamType;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        TXCLog.i(TAG, (String)object);
        this.mIsRendering = false;
        this.mRealTime = false;
        object = this.mVideoDecoder;
        n10 = 0;
        string2 = null;
        if (object != null) {
            ((TXCVideoDecoder)object).setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            object = this.mVideoDecoder;
            ((TXCVideoDecoder)object).stop();
        }
        if ((object = this.mVideoRender) != null) {
            ((e)object).l();
            object = this.mVideoRender;
            boolean bl2 = true;
            ((e)object).a(bl2);
            object = this.mVideoRender;
            ((e)object).a((f)null);
        }
    }

    public void stopVideo() {
        e e10 = null;
        this.mIsRendering = false;
        Object object = this.mVideoDecoder;
        if (object != null) {
            object = new StringBuilder();
            ((StringBuilder)object).append("stop video dec ");
            String string2 = this.getID();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(", ");
            int n10 = this.mStreamType;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            string2 = TAG;
            TXCLog.i(string2, (String)object);
            this.mVideoDecoder.setListener(null);
            this.mVideoDecoder.setNotifyListener(null);
            object = this.mVideoDecoder;
            ((TXCVideoDecoder)object).stop();
        }
        if ((object = this.mVideoRender) != null) {
            ((e)object).l();
            object = this.mVideoRender;
            ((e)object).a(false);
            e10 = this.mVideoRender;
            e10.a((f)null);
        }
    }

    public void updateLoadInfo() {
        int n11;
        Object object = this.mVideoDecoder;
        if (object != null) {
            boolean bl2;
            n11 = 5002;
            int n13 = this.mStreamType;
            boolean n10 = ((TXCVideoDecoder)object).isHardwareDecode();
            long l10 = n10 == (bl2 = true) ? 1L : 0L;
            object = l10;
            this.setStatusValue(n11, n13, object);
        }
        if ((object = this.mVideoRender) != null) {
            ((e)object).n();
        } else {
            long l11 = System.currentTimeMillis();
            long l12 = this.mLastRenderCalculateTS;
            long l13 = 1000L;
            long l14 = (l12 = l11 - l12) - l13;
            Object object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object2 >= 0) {
                l13 = this.mRenderFrameCount;
                long l15 = this.mLastRenderFrameCount;
                l15 = l13 - l15;
                double d10 = l15;
                double d11 = 1000.0;
                d10 *= d11;
                double d12 = l12;
                this.mLastRenderFrameCount = l13;
                this.mLastRenderCalculateTS = l11;
                int n10 = 6002;
                n11 = this.mStreamType;
                Double d13 = d10 /= d12;
                this.setStatusValue(n10, n11, d13);
            }
        }
    }
}

