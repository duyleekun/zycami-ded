/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.media.MediaCodec$BufferInfo
 *  android.media.MediaFormat
 *  android.os.AsyncTask
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.Surface
 *  javax.microedition.khronos.egl.EGL10
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.rtmp;

import android.content.Context;
import android.graphics.Bitmap;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceChangerType;
import com.tencent.liteav.audio.TXAudioEffectManager$TXVoiceReverbType;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.audio.TXCLiveBGMPlayer;
import com.tencent.liteav.audio.impl.TXCAudioEngineJNI;
import com.tencent.liteav.basic.b.a;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.license.LicenceCheck;
import com.tencent.liteav.basic.license.f;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCCommonUtil;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.d;
import com.tencent.liteav.d$a;
import com.tencent.liteav.e;
import com.tencent.liteav.network.TXCStreamUploader;
import com.tencent.liteav.network.l;
import com.tencent.liteav.p;
import com.tencent.liteav.qos.TXCQoS;
import com.tencent.liteav.screencapture.a$a;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePushConfig;
import com.tencent.rtmp.TXLivePusher$AudioCustomProcessListener;
import com.tencent.rtmp.TXLivePusher$ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher$ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher$OnBGMNotify;
import com.tencent.rtmp.TXLivePusher$VideoCustomProcessListener;
import com.tencent.rtmp.b$10;
import com.tencent.rtmp.b$11;
import com.tencent.rtmp.b$12;
import com.tencent.rtmp.b$13;
import com.tencent.rtmp.b$14;
import com.tencent.rtmp.b$2;
import com.tencent.rtmp.b$3;
import com.tencent.rtmp.b$4;
import com.tencent.rtmp.b$5;
import com.tencent.rtmp.b$6;
import com.tencent.rtmp.b$a;
import com.tencent.rtmp.b$b;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import java.io.File;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;

public class b
implements com.tencent.liteav.audio.f,
com.tencent.liteav.basic.b.b,
d$a,
com.tencent.liteav.qos.a {
    private static final String d = "b";
    private ArrayList A;
    private TXLivePusher$ITXAudioVolumeEvaluationListener B;
    private int C;
    private a D;
    private final p E;
    private com.tencent.liteav.audio.g F;
    private b$a G;
    private Runnable H;
    private com.tencent.liteav.muxer.c I;
    private boolean J;
    private String K;
    private long L;
    private boolean M;
    private TXRecordCommon$ITXVideoRecordListener N;
    private boolean O;
    public TXLivePusher$OnBGMNotify a;
    public final TXAudioEffectManager$TXVoiceReverbType[] b;
    public final TXAudioEffectManager$TXVoiceChangerType[] c;
    private TXCloudVideoView e;
    private TXLivePushConfig f;
    private ITXLivePushListener g;
    private int h;
    private TXLivePusher$VideoCustomProcessListener i;
    private TXLivePusher$AudioCustomProcessListener j;
    private com.tencent.liteav.g k;
    private d l;
    private TXCStreamUploader m;
    private Context n;
    private Handler o;
    private TXCQoS p;
    private e q;
    private String r;
    private String s;
    private boolean t;
    private int u;
    private int v;
    private boolean w;
    private boolean x;
    private HashSet y;
    private HashMap z;

    public b(Context object) {
        long l10;
        int n10;
        Integer n11 = null;
        this.f = null;
        this.g = null;
        this.h = n10 = -1;
        this.k = null;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.p = null;
        this.q = null;
        Object object2 = "";
        this.r = object2;
        this.s = object2;
        boolean bl2 = false;
        this.t = false;
        this.u = n10;
        this.v = n10;
        this.w = false;
        this.x = false;
        Object object3 = new HashSet();
        this.y = object3;
        this.z = object3;
        n10 = 8;
        Object object4 = new TXAudioEffectManager$TXVoiceReverbType[n10];
        Enum enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_0;
        object4[0] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_1;
        boolean bl3 = true;
        object4[bl3] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_2;
        int n12 = 2;
        object4[n12] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_3;
        int n13 = 3;
        object4[n13] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_4;
        int n14 = 4;
        object4[n14] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_5;
        int n15 = 5;
        object4[n15] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_6;
        int n16 = 6;
        object4[n16] = enum_;
        enum_ = TXAudioEffectManager$TXVoiceReverbType.TXLiveVoiceReverbType_7;
        int n17 = 7;
        object4[n17] = enum_;
        this.b = object4;
        int n18 = 12;
        object4 = new TXAudioEffectManager$TXVoiceChangerType[n18];
        object4[0] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_0;
        object4[bl3] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_1;
        object4[n12] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_2;
        object4[n13] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_3;
        object4[n14] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_4;
        object4[n15] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_5;
        object4[n16] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_6;
        object4[n17] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_7;
        object4[n10] = enum_ = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_8;
        object3 = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_9;
        object4[9] = object3;
        object3 = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_10;
        object4[10] = object3;
        object3 = TXAudioEffectManager$TXVoiceChangerType.TXLiveVoiceChangerType_11;
        object4[11] = object3;
        this.c = object4;
        super();
        this.A = object3;
        this.B = null;
        this.C = 0;
        super(this);
        this.D = object3;
        super(this);
        this.E = object3;
        super(this);
        this.F = object3;
        this.G = null;
        super(this);
        this.H = object3;
        this.I = null;
        this.J = false;
        this.K = object2;
        long l11 = 0L;
        object4 = l11;
        this.L = l11;
        this.M = false;
        this.O = false;
        super();
        this.f = object3;
        super();
        this.k = object3;
        object = object.getApplicationContext();
        this.n = object;
        TXCCommonUtil.setAppContext((Context)object);
        TXCLog.init();
        object3 = Looper.getMainLooper();
        super(object3);
        this.o = object;
        object = com.tencent.liteav.basic.c.c.a();
        object3 = this.n;
        ((c)object).a((Context)object3);
        object = this.n;
        object3 = this.R();
        TXCAudioEngine.CreateInstance((Context)object, (String)object3);
        TXCAudioEngine.getInstance().clean();
        object = TXCAudioEngine.getInstance();
        object2 = this.D;
        super(object2);
        ((TXCAudioEngine)object).addEventCallback((WeakReference)object3);
        object = com.tencent.liteav.basic.c.c.a();
        object3 = "Audio";
        object2 = "EnableAutoRestartDevice";
        l11 = ((c)object).a((String)object3, (String)object2);
        object = TXCAudioEngine.getInstance();
        long l12 = 1L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false || (n10 = (int)((l10 = l11 - (l12 = (long)-1)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) == 0) {
            bl2 = bl3;
        }
        ((TXCAudioEngine)object).enableAutoRestartDevice(bl2);
        object3 = this.n;
        this.l = object = new d((Context)object3);
        ((d)object).c(bl3);
        this.l.a(this);
        object = LicenceCheck.a();
        object3 = this.n;
        ((LicenceCheck)object).a((f)null, (Context)object3);
        TXCTimeUtil.initAppStartTime();
        object = this.z;
        n11 = -1303;
        ((HashMap)object).put(n11, object4);
        object = this.z;
        n11 = 1101;
        ((HashMap)object).put(n11, object4);
        object = this.z;
        n11 = 1006;
        ((HashMap)object).put(n11, object4);
    }

    private void A() {
        Handler handler = this.o;
        b$13 b$13 = new b$13(this);
        handler.post((Runnable)b$13);
    }

    private void B() {
        TXLivePushConfig tXLivePushConfig = this.f;
        int n10 = tXLivePushConfig.mAudioSample;
        int n11 = tXLivePushConfig.mAudioChannels;
        int n12 = 2;
        tXLivePushConfig = com.tencent.liteav.basic.util.g.a(n10, n11, n12);
        com.tencent.liteav.muxer.c c10 = this.I;
        if (c10 != null) {
            c10.b((MediaFormat)tXLivePushConfig);
        }
    }

    private void C() {
        boolean bl2;
        this.O = bl2 = true;
        Handler handler = this.o;
        if (handler != null) {
            b$4 b$4 = new b$4(this);
            long l10 = 2000L;
            handler.postDelayed((Runnable)b$4, l10);
        }
    }

    private void D() {
        this.O = false;
    }

    private void E() {
        com.tencent.liteav.a.a(this.s, null);
    }

    private void F() {
        b b10 = this;
        this.E();
        Object object = com.tencent.liteav.basic.util.g.a();
        boolean bl2 = false;
        b$5 b$5 = null;
        int n10 = object[0] / 10;
        int n11 = 1;
        int n12 = object[n11] / 10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(n10);
        charSequence.append("/");
        charSequence.append(n12);
        charSequence.append("%");
        object = charSequence.toString();
        String string2 = this.s;
        float f10 = 9.815E-42f;
        n10 = TXCStatus.c(string2, 7004);
        int n13 = TXCStatus.c(this.s, 7003);
        String string3 = this.s;
        int n14 = TXCStatus.c(string3, 7002);
        String string4 = this.s;
        int n15 = TXCStatus.c(string4, 7001);
        Object[] objectArray = this.s;
        int n16 = TXCStatus.c((String)objectArray, 7007);
        String string5 = this.s;
        int n17 = TXCStatus.c(string5, 7005);
        String string6 = this.s;
        int n18 = 7006;
        int n19 = TXCStatus.c(string6, n18);
        String string7 = this.s;
        int n20 = 7012;
        string7 = TXCStatus.b(string7, n20);
        String string8 = this.s;
        int n21 = 4001;
        double d10 = TXCStatus.d(string8, n21);
        String string9 = this.s;
        int n22 = 4006;
        int n23 = TXCStatus.c(string9, n22);
        Bundle bundle = new Bundle();
        string2 = "NET_SPEED";
        bundle.putInt(string2, n13 += n10);
        n10 = (int)d10;
        charSequence = "VIDEO_FPS";
        bundle.putInt((String)charSequence, n10);
        double d11 = 1.0;
        n10 = (int)(d10 == d11 ? 0 : (d10 < d11 ? -1 : 1));
        if (n10 < 0) {
            d10 = 15.0;
        }
        n23 *= 10;
        n10 = (int)d10;
        float f11 = n23 /= n10;
        n13 = 1092616192;
        f10 = 10.0f;
        d10 = f11 /= f10;
        d11 = 0.5;
        n10 = (int)(d10 += d11);
        charSequence = "VIDEO_GOP";
        bundle.putInt((String)charSequence, n10);
        bundle.putInt("VIDEO_DROP", n16);
        bundle.putInt("VIDEO_BITRATE", n15);
        bundle.putInt("AUDIO_BITRATE", n14);
        bundle.putInt("AUDIO_CACHE", n19);
        bundle.putInt("VIDEO_CACHE", n17);
        bundle.putCharSequence("SERVER_IP", (CharSequence)string7);
        string2 = "CPU_USAGE";
        bundle.putCharSequence(string2, (CharSequence)object);
        object = b10.l;
        if (object != null) {
            object = new StringBuilder;
            ((StringBuilder)object)();
            n10 = TXCAudioEngine.getInstance().getAECType();
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(" | ");
            n10 = b10.f.mAudioSample;
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(" , ");
            n10 = b10.f.mAudioChannels;
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            bundle.putString("AUDIO_PLAY_INFO", (String)object);
            n12 = b10.l.c();
            bundle.putInt("VIDEO_WIDTH", n12);
            object = b10.l;
            n12 = ((d)object).d();
            string2 = "VIDEO_HEIGHT";
            bundle.putInt(string2, n12);
        }
        if ((object = (Object)((Object)b10.e)) != null) {
            n10 = 0;
            f11 = 0.0f;
            string2 = null;
            ((TXCloudVideoView)((Object)object)).setLogText(bundle, null, 0);
        }
        if ((object = (Object)b10.g) != null) {
            object.onNetStatus(bundle);
        }
        if ((object = b10.q) != null) {
            ((e)object).e();
        }
        object = b10.n;
        n12 = com.tencent.liteav.basic.util.g.d((Context)object);
        string2 = b10.n;
        n10 = (int)(com.tencent.liteav.basic.util.g.a((Context)string2) ? 1 : 0);
        n13 = b10.u;
        string3 = "";
        n15 = 2;
        if (n13 != n12) {
            objectArray = new Object[n15];
            charSequence = b10.g(n13);
            objectArray[0] = charSequence;
            charSequence = b10.g(n12);
            objectArray[n11] = charSequence;
            charSequence = String.format("Network: net type change from %s to %s", objectArray);
            Monitor.a(n15, (String)charSequence, string3, 0);
            b10.u = n12;
        }
        if ((n12 = b10.v) != n10) {
            object = new Object[n11];
            String string10 = n10 == n11 ? "background" : "foreground";
            object[0] = string10;
            string10 = "app: switch to %s";
            object = String.format(string10, (Object[])object);
            Monitor.a(n15, (String)object, string3, 0);
            b10.v = n10;
        }
        if ((object = b10.o) != null && (bl2 = b10.O)) {
            b$5 = new b$5(b10);
            long l10 = 2000L;
            object.postDelayed((Runnable)b$5, l10);
        }
    }

    private void G() {
        int n10;
        int n11;
        int n12;
        boolean bl2;
        int n13;
        int bl22;
        Object object = new l();
        Object object2 = this.f;
        ((l)object).d = bl22 = ((TXLivePushConfig)object2).mAudioChannels;
        ((l)object).e = n13 = ((TXLivePushConfig)object2).mAudioSample;
        boolean bl3 = false;
        object2 = null;
        ((l)object).a = 0;
        ((l)object).c = 20;
        ((l)object).b = 0;
        ((l)object).f = 3;
        ((l)object).j = bl2 = true;
        ((l)object).l = bl2;
        ((l)object).k = false;
        ((l)object).h = n12 = 40;
        ((l)object).i = 5000;
        Object object3 = this.k;
        ((l)object).m = n11 = ((com.tencent.liteav.g)object3).P;
        ((l)object).n = n10 = ((com.tencent.liteav.g)object3).Q;
        n10 = this.h;
        ((l)object).o = n10 = this.i(n10);
        Object object4 = this.n;
        this.m = object3 = new TXCStreamUploader((Context)object4, (l)object);
        object = this.s;
        ((com.tencent.liteav.basic.module.a)object3).setID((String)object);
        object = this.m;
        object3 = this.f.mMetaData;
        ((TXCStreamUploader)object).setMetaData((HashMap)object3);
        object = this.m;
        if (object != null) {
            object3 = this.k;
            n11 = ((com.tencent.liteav.g)object3).s;
            n10 = ((com.tencent.liteav.g)object3).t;
            ((TXCStreamUploader)object).setAudioInfo(n11, n10);
        }
        this.m.setNotifyListener(this);
        object = this.k;
        boolean bl4 = ((com.tencent.liteav.g)object).M;
        if (bl4) {
            object = this.m;
            n10 = (int)(this.x ? 1 : 0);
            ((TXCStreamUploader)object).setAudioMute(n10 != 0);
        }
        object = this.m;
        object3 = this.r;
        object4 = this.k;
        boolean bl5 = object4.N;
        n11 = object4.O;
        this.r = object = ((TXCStreamUploader)object).start((String)object3, bl5, n11);
        object = this.k;
        bl4 = ((com.tencent.liteav.g)object).M;
        if (bl4) {
            object = this.m;
            ((TXCStreamUploader)object).setMode((int)(bl2 ? 1 : 0));
        }
        object = this.k;
        n10 = ((com.tencent.liteav.g)object).P;
        if (n10 != 0) {
            boolean bl6;
            n12 = ((com.tencent.liteav.g)object).q;
            bl4 = ((com.tencent.liteav.g)object).r;
            n10 = 5;
            if (n12 < n10) {
                n12 = n10;
            }
            if (bl4 <= bl2) {
                bl6 = bl4;
            }
            this.m.setRetryInterval((int)(bl6 ? 1 : 0));
            this.m.setRetryTimes(n12);
            object = this.m;
            com.tencent.liteav.g g10 = this.k;
            int n14 = g10.h;
            n12 = 1000;
            ((TXCStreamUploader)object).setVideoDropParams(false, n14, n12);
        } else {
            object2 = this.m;
            bl4 = ((com.tencent.liteav.g)object).r;
            ((TXCStreamUploader)object2).setRetryInterval((int)(bl4 ? 1 : 0));
            object = this.m;
            object2 = this.k;
            int n15 = ((com.tencent.liteav.g)object2).q;
            ((TXCStreamUploader)object).setRetryTimes(n15);
            object = this.m;
            int n16 = 3000;
            ((TXCStreamUploader)object).setVideoDropParams(bl2, n12, n16);
        }
        object = this.m;
        object2 = this.k;
        boolean bl7 = ((com.tencent.liteav.g)object2).P;
        boolean bl8 = ((com.tencent.liteav.g)object2).Q;
        ((TXCStreamUploader)object).setSendStrategy(bl7, bl8);
    }

    private void H() {
        TXCStreamUploader tXCStreamUploader = this.m;
        if (tXCStreamUploader != null) {
            tXCStreamUploader.stop();
            tXCStreamUploader = this.m;
            tXCStreamUploader.setNotifyListener(null);
            this.m = null;
        }
    }

    private void I() {
        Object object = new TXCQoS(true);
        this.p = object;
        ((TXCQoS)object).setListener(this);
        this.p.setNotifyListener(this);
        object = this.p;
        int n10 = this.k.g;
        ((TXCQoS)object).setAutoAdjustBitrate(n10 != 0);
        object = this.p;
        n10 = this.k.f;
        ((TXCQoS)object).setAutoAdjustStrategy(n10);
        object = this.p;
        Object object2 = this.k.k;
        ((TXCQoS)object).setDefaultVideoResolution((com.tencent.liteav.basic.a.c)((Object)object2));
        object = this.p;
        object2 = this.k;
        int n11 = ((com.tencent.liteav.g)object2).e;
        int n12 = ((com.tencent.liteav.g)object2).d;
        n10 = ((com.tencent.liteav.g)object2).c;
        ((TXCQoS)object).setVideoEncBitrate(n11, n12, n10);
        object = this.k;
        boolean bl2 = ((com.tencent.liteav.g)object).g;
        if (bl2) {
            object = this.p;
            long l10 = 2000L;
            ((TXCQoS)object).start(l10);
        }
    }

    private void J() {
        TXCQoS tXCQoS = this.p;
        if (tXCQoS != null) {
            tXCQoS.stop();
            this.p.setListener(null);
            tXCQoS = this.p;
            tXCQoS.setNotifyListener(null);
            this.p = null;
        }
    }

    private void K() {
        e e10;
        Object object = this.n;
        this.q = e10 = new e((Context)object);
        object = this.s;
        e10.d((String)object);
        e10 = this.q;
        int n10 = this.k.c;
        e10.a(n10);
        e10 = this.q;
        n10 = this.k.s;
        e10.b(n10);
        e10 = this.q;
        object = this.k;
        int n11 = object.a;
        n10 = object.b;
        e10.a(n11, n10);
        e10 = this.q;
        object = this.r;
        e10.a((String)object);
        this.q.a();
    }

    private void L() {
        e e10 = this.q;
        if (e10 != null) {
            e10.b();
            e10 = null;
            this.q = null;
        }
    }

    private void M() {
        d d10 = this.l;
        if (d10 != null) {
            String string2 = this.s;
            d10.setID(string2);
            this.l.a(this);
            d10 = this.l;
            d10.e();
        }
    }

    private void N() {
        d d10 = this.l;
        if (d10 != null) {
            d10.a((d$a)null);
            this.l.f();
            d10 = this.l;
            d10.a((d$a)null);
        }
    }

    private void O() {
        Object object = TXCAudioEngine.getInstance();
        int n10 = this.f.mAudioSample;
        ((TXCAudioEngine)object).setEncoderSampleRate(n10);
        object = TXCAudioEngine.getInstance();
        TXLivePushConfig tXLivePushConfig = this.f;
        n10 = tXLivePushConfig.mAudioChannels;
        ((TXCAudioEngine)object).setEncoderChannels(n10);
        object = TXCAudioEngine.getInstance();
        n10 = (int)(this.x ? 1 : 0);
        ((TXCAudioEngine)object).muteLocalAudio(n10 != 0);
        object = this.f;
        int n11 = ((TXLivePushConfig)object).mCustomModeType;
        n10 = 1;
        if ((n11 &= n10) != 0) {
            n11 = n10;
        } else {
            n11 = 0;
            object = null;
        }
        TXCAudioEngine.getInstance().setAudioCaptureDataListener(this);
        TXCAudioEngineJNI.nativeUseSysAudioDevice((TXCAudioEngine.hasTrae() ^ n10) != 0);
        TXCAudioEngine.getInstance().startLocalAudio(10, n11 != 0);
        TXCAudioEngine.getInstance().enableEncodedDataCallback(n10 != 0);
    }

    private void P() {
        TXCAudioEngine.getInstance().stopLocalAudio();
    }

    private void Q() {
        Object object = this.l;
        if (object == null) {
            return;
        }
        object = TXCAudioEngine.getInstance();
        int n10 = this.k.v;
        int n11 = 100;
        ((TXCAudioEngine)object).enableSoftAGC(n10 != 0, n11);
        object = TXCAudioEngine.getInstance();
        n10 = this.k.w;
        ((TXCAudioEngine)object).enableSoftANS(n10 != 0, n11);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.setSystemVolumeType(this.k.x);
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioEarMonitoring(this.k.z);
        object = this.l;
        Object object2 = this.k;
        ((d)object).a((com.tencent.liteav.g)object2);
        object = this.l;
        object2 = this.k;
        n10 = object2.o;
        ((d)object).b(n10);
        object = this.l;
        boolean bl2 = ((d)object).i();
        if (bl2) {
            int n12;
            object = this.m;
            if (object != null) {
                object2 = this.k;
                n11 = (int)(object2.P ? 1 : 0);
                n12 = 1;
                if (n11 != 0) {
                    n11 = object2.q;
                    n10 = object2.r;
                    int n13 = 5;
                    if (n11 < n13) {
                        n11 = n13;
                    }
                    if (n10 <= n12) {
                        n12 = n10;
                    }
                    ((TXCStreamUploader)object).setRetryInterval(n12);
                    this.m.setRetryTimes(n11);
                    object = this.m;
                    n10 = 0;
                    object2 = null;
                    com.tencent.liteav.g g10 = this.k;
                    n11 = g10.h;
                    n12 = 1000;
                    ((TXCStreamUploader)object).setVideoDropParams(false, n11, n12);
                } else {
                    n10 = object2.r;
                    ((TXCStreamUploader)object).setRetryInterval(n10);
                    object = this.m;
                    object2 = this.k;
                    n10 = object2.q;
                    ((TXCStreamUploader)object).setRetryTimes(n10);
                    object = this.m;
                    n10 = 40;
                    n11 = 3000;
                    ((TXCStreamUploader)object).setVideoDropParams(n12 != 0, n10, n11);
                }
                object = this.m;
                object2 = this.k;
                n11 = (int)(object2.P ? 1 : 0);
                n10 = (int)(object2.Q ? 1 : 0);
                ((TXCStreamUploader)object).setSendStrategy(n11 != 0, n10 != 0);
            }
            if ((object = this.p) != null) {
                ((TXCQoS)object).stop();
                object = this.p;
                n10 = (int)(this.k.g ? 1 : 0);
                ((TXCQoS)object).setAutoAdjustBitrate(n10 != 0);
                object = this.p;
                n10 = this.k.f;
                ((TXCQoS)object).setAutoAdjustStrategy(n10);
                object = this.p;
                object2 = this.k.k;
                ((TXCQoS)object).setDefaultVideoResolution((com.tencent.liteav.basic.a.c)((Object)object2));
                object = this.p;
                object2 = this.k;
                n11 = object2.e;
                n12 = object2.d;
                n10 = object2.c;
                ((TXCQoS)object).setVideoEncBitrate(n11, n12, n10);
                object = this.k;
                bl2 = ((com.tencent.liteav.g)object).g;
                if (bl2) {
                    object = this.p;
                    long l10 = 2000L;
                    ((TXCQoS)object).start(l10);
                }
            }
        } else {
            object = this.m;
            if (object != null) {
                object2 = this.k;
                n11 = object2.s;
                n10 = object2.t;
                ((TXCStreamUploader)object).setAudioInfo(n11, n10);
            }
        }
    }

    private String R() {
        c c10 = com.tencent.liteav.basic.c.c.a();
        String string2 = c10.c();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return string2;
        }
        string2 = this.n;
        boolean bl3 = c10.i();
        long l10 = c10.j();
        return TXCAudioEngine.buildTRAEConfig((Context)string2, null, bl3, l10);
    }

    public static /* synthetic */ ITXLivePushListener a(b b10) {
        return b10.g;
    }

    private void a(int n10, Bundle bundle) {
        int n11 = -1307;
        switch (n10) {
            default: {
                return;
            }
            case 3006: 
            case 3007: {
                n10 = 3005;
                break;
            }
            case 3003: {
                n10 = 3003;
                break;
            }
            case 3002: {
                n10 = 3002;
                break;
            }
            case 2110: {
                n10 = 2110;
                break;
            }
            case 1103: {
                n10 = 1103;
                break;
            }
            case 1102: {
                n10 = 1102;
                break;
            }
            case 1101: {
                n10 = 1101;
                break;
            }
            case 1021: {
                n10 = 1021;
                break;
            }
            case 1020: {
                n10 = 1020;
                break;
            }
            case 1019: {
                n10 = 1019;
                break;
            }
            case 1018: {
                n10 = 1018;
                break;
            }
            case 1008: 
            case 1027: 
            case 1028: {
                n10 = 1008;
                break;
            }
            case 1002: {
                n10 = 1002;
                break;
            }
            case 1001: {
                n10 = 1001;
                break;
            }
            case -1303: {
                n10 = -1303;
                break;
            }
            case -1313: {
                n10 = -1313;
                break;
            }
            case -1315: 
            case -1314: 
            case -1301: {
                n10 = -1301;
                break;
            }
            case -1317: 
            case -1302: {
                n10 = -1302;
                break;
            }
            case -1325: 
            case -1324: 
            case -1307: 
            case 3008: {
                n10 = n11;
                break;
            }
            case -1326: {
                n10 = 3004;
            }
            case -1309: 
            case -1308: 
            case 1003: 
            case 1004: 
            case 1005: 
            case 1006: 
            case 1007: 
            case 3001: 
        }
        Handler handler = this.o;
        if (handler != null) {
            b$6 b$6 = new b$6(this, n10, bundle);
            handler.post((Runnable)b$6);
        }
    }

    private void a(TXSNALPacket tXSNALPacket, byte[] object) {
        long l10 = this.L;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2 == false) {
            this.L = l10 = tXSNALPacket.pts;
        }
        l10 = tXSNALPacket.pts;
        l11 = this.L;
        l11 = l10 - l11;
        int n10 = 0;
        Object object3 = tXSNALPacket.info;
        if (object3 == null) {
            int n11 = tXSNALPacket.nalType;
            if (n11 == 0) {
                n10 = 1;
            }
        } else {
            n10 = ((MediaCodec.BufferInfo)object3).flags;
        }
        object3 = this.I;
        int n12 = ((byte[])object).length;
        long l13 = 1000L * l10;
        ((com.tencent.liteav.muxer.c)object3).b((byte[])object, 0, n12, l13, n10);
        tXSNALPacket = this.o;
        object = new b$2;
        object(this, l11);
        tXSNALPacket.post((Runnable)object);
    }

    private void a(TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener, Bitmap bitmap) {
        if (tXLivePusher$ITXSnapshotListener == null) {
            return;
        }
        Object object = Looper.getMainLooper();
        Handler handler = new Handler(object);
        object = new b$3(this, tXLivePusher$ITXSnapshotListener, bitmap);
        handler.post((Runnable)object);
    }

    public static /* synthetic */ void a(b b10, TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener, Bitmap bitmap) {
        b10.a(tXLivePusher$ITXSnapshotListener, bitmap);
    }

    public static /* synthetic */ void a(b b10, String string2, String string3) {
        b10.a(string2, string3);
    }

    private void a(String string2, String string3) {
        Handler handler = this.o;
        b$14 b$14 = new b$14(this, string2, string3);
        handler.post((Runnable)b$14);
    }

    private void a(boolean bl2, boolean bl3) {
        if ((bl2 = this.b(bl2, bl3)) == (bl3 = -1)) {
            TXLivePushConfig tXLivePushConfig = this.f;
            boolean bl4 = false;
            tXLivePushConfig.setAutoAdjustBitrate(false);
            tXLivePushConfig = this.f;
            tXLivePushConfig.setAutoAdjustStrategy((int)(bl3 ? 1 : 0));
        } else {
            TXLivePushConfig tXLivePushConfig = this.f;
            boolean bl5 = true;
            tXLivePushConfig.setAutoAdjustBitrate(bl5);
            tXLivePushConfig = this.f;
            tXLivePushConfig.setAutoAdjustStrategy((int)(bl2 ? 1 : 0));
        }
    }

    public static /* synthetic */ boolean a(b b10, boolean bl2) {
        b10.t = bl2;
        return bl2;
    }

    private byte[] a(int n10, byte[] byArray) {
        byte[] byArray2 = this.h(n10);
        int n11 = byArray2.length;
        int n12 = 1;
        int n13 = byArray.length;
        byte[] byArray3 = new byte[(n11 += n12) + n13 + n12];
        byArray3[0] = -14;
        n13 = byArray2.length;
        System.arraycopy(byArray2, 0, byArray3, n12, n13);
        n10 = byArray2.length;
        n12 += n10;
        n10 = byArray.length;
        System.arraycopy(byArray, 0, byArray3, n12, n10);
        n10 = byArray.length;
        byArray3[n12 += n10] = -128;
        return byArray3;
    }

    private int b(boolean n10, boolean n11) {
        int n12 = 1;
        if (n10 == n12) {
            if (n11 == n12) {
                return n12;
            }
            return 0;
        }
        return -1;
    }

    public static /* synthetic */ TXLivePusher$VideoCustomProcessListener b(b b10) {
        return b10.i;
    }

    private void b(TXLivePushConfig tXLivePushConfig) {
        boolean bl2;
        float f10;
        com.tencent.liteav.basic.a.c c10;
        int n10;
        com.tencent.liteav.g g10 = this.k;
        g10.c = n10 = tXLivePushConfig.mVideoBitrate;
        g10.e = n10 = tXLivePushConfig.mMinVideoBitrate;
        g10.d = n10 = tXLivePushConfig.mMaxVideoBitrate;
        g10.f = n10 = tXLivePushConfig.mAutoAdjustStrategy;
        n10 = (int)(tXLivePushConfig.mAutoAdjustBitrate ? 1 : 0);
        g10.g = n10;
        g10.h = n10 = tXLivePushConfig.mVideoFPS;
        g10.i = n10 = tXLivePushConfig.mVideoEncodeGop;
        g10.j = n10 = tXLivePushConfig.mHardwareAccel;
        g10.k = c10 = tXLivePushConfig.mVideoResolution;
        n10 = (int)(tXLivePushConfig.mEnableVideoHardEncoderMainProfile ? 1 : 0);
        if (n10 != 0) {
            n10 = 3;
            f10 = 4.2E-45f;
        } else {
            n10 = 1;
            f10 = Float.MIN_VALUE;
        }
        g10.n = n10;
        g10.o = n10 = tXLivePushConfig.mLocalVideoMirrorType;
        g10.s = n10 = tXLivePushConfig.mAudioSample;
        g10.t = n10 = tXLivePushConfig.mAudioChannels;
        n10 = (int)(tXLivePushConfig.mEnableAec ? 1 : 0);
        g10.u = n10;
        n10 = (int)(tXLivePushConfig.mEnableAgc ? 1 : 0);
        g10.v = n10;
        n10 = (int)(tXLivePushConfig.mEnableAns ? 1 : 0);
        g10.w = n10;
        g10.x = n10 = tXLivePushConfig.mVolumeType;
        g10.D = n10 = tXLivePushConfig.mPauseFlag;
        g10.C = n10 = tXLivePushConfig.mPauseFps;
        c10 = tXLivePushConfig.mPauseImg;
        g10.A = c10;
        g10.B = n10 = tXLivePushConfig.mPauseTime;
        n10 = (int)(tXLivePushConfig.mEnablePureAudioPush ? 1 : 0);
        g10.M = n10;
        n10 = (int)(tXLivePushConfig.mTouchFocus ? 1 : 0);
        g10.K = n10;
        n10 = (int)(tXLivePushConfig.mEnableZoom ? 1 : 0);
        g10.L = n10;
        c10 = tXLivePushConfig.mWatermark;
        g10.E = c10;
        g10.F = n10 = tXLivePushConfig.mWatermarkX;
        g10.G = n10 = tXLivePushConfig.mWatermarkY;
        g10.H = f10 = tXLivePushConfig.mWatermarkXF;
        g10.I = f10 = tXLivePushConfig.mWatermarkYF;
        g10.J = f10 = tXLivePushConfig.mWatermarkWidth;
        g10.l = n10 = tXLivePushConfig.mHomeOrientation;
        n10 = (int)(tXLivePushConfig.mEnableNearestIP ? 1 : 0);
        g10.N = n10;
        g10.O = n10 = tXLivePushConfig.mRtmpChannelType;
        g10.q = n10 = tXLivePushConfig.mConnectRetryCount;
        g10.r = n10 = tXLivePushConfig.mConnectRetryInterval;
        n10 = (int)(tXLivePushConfig.mFrontCamera ? 1 : 0);
        g10.m = n10;
        g10.R = n10 = tXLivePushConfig.mCustomModeType;
        n10 = (int)(tXLivePushConfig.mVideoEncoderXMirror ? 1 : 0);
        g10.S = n10;
        n10 = (int)(tXLivePushConfig.mEnableHighResolutionCapture ? 1 : 0);
        g10.T = n10;
        n10 = (int)(tXLivePushConfig.mEnableScreenCaptureAutoRotate ? 1 : 0);
        g10.V = n10;
        g10.z = bl2 = tXLivePushConfig.mEnableAudioPreview;
        g10.a();
    }

    public static /* synthetic */ TXLivePusher$ITXAudioVolumeEvaluationListener c(b b10) {
        return b10.B;
    }

    public static /* synthetic */ Handler d(b b10) {
        return b10.o;
    }

    private byte[] d(byte[] byArray) {
        int n10;
        int n11 = byArray.length;
        byte[] byArray2 = new byte[n11];
        System.arraycopy(byArray, 0, byArray2, 0, n11);
        int n12 = 0;
        while ((n10 = n12 + 4) < n11) {
            int n13 = 4;
            ByteBuffer byteBuffer = ByteBuffer.wrap(byArray, n12, n13);
            int n14 = byteBuffer.getInt();
            if ((n10 += n14) <= n11) {
                byte by2;
                byArray2[n12] = 0;
                n10 = n12 + 1;
                byArray2[n10] = 0;
                n10 = n12 + 2;
                byArray2[n10] = 0;
                n10 = n12 + 3;
                byArray2[n10] = by2 = 1;
            }
            n12 = n12 + n14 + n13;
        }
        return byArray2;
    }

    public static /* synthetic */ b$a e(b b10) {
        return b10.G;
    }

    private byte[] e(byte[] byArray) {
        int n10;
        int n11;
        int n12 = byArray.length * 4;
        int n13 = 3;
        n12 = n12 / n13 + 2;
        byte[] byArray2 = new byte[n12];
        int n14 = 0;
        for (n11 = 0; n14 < (n10 = byArray.length) && n11 < n12; ++n14, ++n11) {
            byte by2;
            n10 = n14 + 3;
            int n15 = byArray.length;
            if (n10 < n15 && (n10 = byArray[n14]) == 0 && (n15 = byArray[n10 = n14 + 1]) == 0 && (by2 = byArray[n15 = n14 + 2]) >= 0 && (n15 = byArray[n15]) <= n13) {
                n15 = n11 + 1;
                byArray2[n11] = n14 = byArray[n14];
                n14 = n15 + 1;
                n11 = n10 + 1;
                byArray2[n15] = n10 = byArray[n10];
                n10 = n14 + 1;
                byArray2[n14] = n13;
                n14 = n11;
                n11 = n10;
            }
            byArray2[n11] = n10 = byArray[n14];
        }
        byArray = new byte[n11];
        System.arraycopy(byArray2, 0, byArray, 0, n11);
        return byArray;
    }

    public static /* synthetic */ Runnable f(b b10) {
        return b10.H;
    }

    private boolean f(String stringArray) {
        int n10 = 0;
        String string2 = "[?&]";
        stringArray = stringArray.split(string2);
        int n11 = stringArray.length;
        StringBuilder stringBuilder = null;
        for (int i10 = 0; i10 < n11; ++i10) {
            Object object = stringArray[i10];
            String string3 = "=";
            int n12 = object.indexOf(string3);
            int n13 = -1;
            if (n12 == n13) continue;
            string3 = "[=]";
            object = object.split(string3);
            n12 = ((String[])object).length;
            n13 = 2;
            if (n12 != n13) continue;
            string3 = object[0];
            n13 = 1;
            object = object[n13];
            boolean bl2 = TextUtils.isEmpty((CharSequence)string3);
            if (bl2) continue;
            bl2 = TextUtils.isEmpty((CharSequence)object);
            if (bl2) continue;
            String string4 = "enableblackstream";
            n12 = (int)(string3.equalsIgnoreCase(string4) ? 1 : 0);
            if (!n12) continue;
            try {
                int n14 = Integer.parseInt((String)object);
                if (n14 == n13) {
                    n10 = n13;
                }
                return n10;
            }
            catch (Exception exception) {
                string2 = d;
                stringBuilder = new StringBuilder();
                object = "parse black stream flag error ";
                stringBuilder.append((String)object);
                String string5 = exception.toString();
                stringBuilder.append(string5);
                string5 = stringBuilder.toString();
                TXCLog.w(string2, string5);
                break;
            }
        }
        return false;
    }

    public static /* synthetic */ TXCloudVideoView g(b b10) {
        return b10.e;
    }

    private String g(int n10) {
        int n11 = 1;
        if (n10 != n11) {
            n11 = 2;
            if (n10 != n11) {
                n11 = 3;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 5;
                        if (n10 != n11) {
                            return "UNKNOWN";
                        }
                        return "WIRED";
                    }
                    return "2G";
                }
                return "3G";
            }
            return "4G";
        }
        return "WIFI";
    }

    private void g(String string2) {
        Object object = this.m;
        if (object != null) {
            ((com.tencent.liteav.basic.module.a)object).setID(string2);
        }
        if ((object = this.l) != null) {
            ((d)object).setID(string2);
        }
        if ((object = this.q) != null) {
            ((e)object).d(string2);
        }
        this.s = string2;
    }

    public static /* synthetic */ TXRecordCommon$ITXVideoRecordListener h(b b10) {
        return b10.N;
    }

    private byte[] h(int n10) {
        int n11;
        int n12 = n10 / 255 + 1;
        byte[] byArray = new byte[n12];
        for (int i10 = 0; i10 < (n11 = n12 + -1); ++i10) {
            byArray[i10] = n11 = -1;
        }
        byArray[n11] = n10 = (int)((byte)(n10 % 255 & 0xFF));
        return byArray;
    }

    private int i(int n10) {
        block9: {
            long l10;
            String string2 = "Live";
            String string3 = "QUICMode";
            switch (n10) {
                default: {
                    n10 = 0;
                    Object var4_4 = null;
                    break block9;
                }
                case 7: {
                    c c10 = com.tencent.liteav.basic.c.c.a();
                    l10 = c10.a(string3, string2);
                    break;
                }
                case 6: {
                    c c11 = com.tencent.liteav.basic.c.c.a();
                    string2 = "RTC";
                    l10 = c11.a(string3, string2);
                    break;
                }
                case 5: {
                    c c12 = com.tencent.liteav.basic.c.c.a();
                    string2 = "LinkSub";
                    l10 = c12.a(string3, string2);
                    break;
                }
                case 4: {
                    c c13 = com.tencent.liteav.basic.c.c.a();
                    string2 = "LinkMain";
                    l10 = c13.a(string3, string2);
                    break;
                }
                case 3: {
                    c c14 = com.tencent.liteav.basic.c.c.a();
                    l10 = c14.a(string3, string2);
                    break;
                }
                case 2: {
                    c c15 = com.tencent.liteav.basic.c.c.a();
                    l10 = c15.a(string3, string2);
                    break;
                }
                case 1: {
                    c c16 = com.tencent.liteav.basic.c.c.a();
                    l10 = c16.a(string3, string2);
                }
            }
            n10 = (int)l10;
        }
        return n10;
    }

    public static /* synthetic */ boolean i(b b10) {
        return b10.O;
    }

    public static /* synthetic */ void j(b b10) {
        b10.F();
    }

    public static /* synthetic */ String x() {
        return d;
    }

    private void y() {
        int n10 = this.C;
        if (n10 > 0 && (n10 = (int)(this.m() ? 1 : 0))) {
            b$a b$a;
            TXCAudioEngine.getInstance();
            n10 = 1;
            int n11 = 300;
            TXCAudioEngine.enableAudioVolumeEvaluation(n10 != 0, n11);
            b$a b$a2 = this.G;
            if (b$a2 == null) {
                n11 = 0;
                b$a = null;
                this.G = b$a2 = new b$a(this, null);
            }
            b$a2 = this.G;
            n11 = this.C;
            b$a2.a(n11);
            b$a2 = this.o;
            if (b$a2 != null) {
                b$a = this.G;
                b$a2.removeCallbacks(b$a);
                b$a2 = this.o;
                b$a = this.G;
                int n12 = this.C;
                long l10 = n12;
                b$a2.postDelayed(b$a, l10);
            }
        }
    }

    private void z() {
        TXCAudioEngine.getInstance();
        int n10 = 300;
        TXCAudioEngine.enableAudioVolumeEvaluation(false, n10);
        b$a b$a = this.G;
        if (b$a != null) {
            b$a.a(0);
        }
        if ((b$a = this.o) != null) {
            b$a b$a2 = this.G;
            b$a.removeCallbacks(b$a2);
        }
        this.G = null;
        this.C = 0;
    }

    public int a(String object) {
        boolean bl2;
        Object object2;
        CharSequence charSequence;
        int n10;
        Object object3;
        int n11 = this.w;
        int n12 = 1;
        if (!n11) {
            object3 = LicenceCheck.a();
            n10 = 0;
            charSequence = null;
            object2 = this.n;
            n11 = object3.a((f)null, (Context)object2);
            if (!n11) {
                n11 = n12;
            } else {
                n11 = 0;
                object3 = null;
            }
            this.w = n11;
        }
        if (!(n11 = this.w)) {
            object = d;
            object3 = new StringBuilder();
            object3.append("liteav_api startPusher error licence expired");
            object3.append(this);
            object3 = object3.toString();
            TXCLog.i((String)object, (String)object3);
            return -5;
        }
        n11 = TextUtils.isEmpty((CharSequence)object);
        n10 = -1;
        if (n11) {
            object = d;
            object3 = new StringBuilder();
            object3.append("start push error when url is empty ");
            object3.append(this);
            object3 = object3.toString();
            TXCLog.e((String)object, (String)object3);
            return n10;
        }
        object3 = this.r;
        n11 = (int)(TextUtils.isEmpty((CharSequence)object3) ? 1 : 0);
        if (!n11 && (n11 = (int)(this.m() ? 1 : 0))) {
            object3 = this.r;
            n11 = (int)(object3.equalsIgnoreCase((String)object) ? 1 : 0);
            if (n11) {
                object = d;
                object3 = new StringBuilder();
                object3.append("ignore start push when new url is the same with old url  ");
                object3.append(this);
                object3 = object3.toString();
                TXCLog.w((String)object, (String)object3);
                return n10;
            }
            object3 = d;
            charSequence = new StringBuilder();
            object2 = " stop old push when new url is not the same with old url  ";
            ((StringBuilder)charSequence).append((String)object2);
            ((StringBuilder)charSequence).append(this);
            charSequence = ((StringBuilder)charSequence).toString();
            TXCLog.w((String)object3, (String)charSequence);
            this.j();
        }
        object3 = d;
        charSequence = "================================================================================================================================================";
        TXCLog.i((String)object3, (String)charSequence);
        TXCLog.i((String)object3, (String)charSequence);
        object2 = new StringBuilder();
        ((StringBuilder)object2).append("============= startPush pushUrl = ");
        ((StringBuilder)object2).append((String)object);
        ((StringBuilder)object2).append(" SDKVersion = ");
        int n13 = TXCCommonUtil.getSDKID();
        ((StringBuilder)object2).append(n13);
        ((StringBuilder)object2).append(" , ");
        String string2 = TXCCommonUtil.getSDKVersionStr();
        ((StringBuilder)object2).append(string2);
        string2 = "=============";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object3, (String)object2);
        TXCLog.i((String)object3, (String)charSequence);
        TXCLog.i((String)object3, (String)charSequence);
        this.r = object;
        this.g((String)object);
        this.G();
        this.M();
        this.O();
        this.I();
        this.K();
        Monitor.a(this.r, 0, "");
        object3 = new StringBuilder();
        charSequence = "startPusher url:";
        object3.append((String)charSequence);
        object3.append((String)object);
        object = object3.toString();
        object3 = new Object[]{};
        this.a((String)object, object3);
        this.C();
        object = this.e;
        if (object != null) {
            ((TXCloudVideoView)((Object)object)).clearLog();
        }
        if (bl2 = this.f((String)(object = this.r))) {
            object = this.l;
            ((d)object).a(n12 != 0);
        }
        this.y();
        return 0;
    }

    public int a(byte[] byArray, int n10, int n11, int n12) {
        d d10 = this.l;
        int n13 = -1000;
        if (d10 != null) {
            int n14 = 3;
            if (n10 != n14) {
                n14 = 5;
                if (n10 != n14) {
                    return n13;
                }
                n10 = 2;
            } else {
                n10 = 1;
            }
            n14 = n10;
            return d10.a(byArray, n10, n11, n12, 0L);
        }
        return n13;
    }

    public void a() {
        TXCAudioEngine.getInstance().resumeAudioCapture();
        TXCAudioEngine.getInstance().muteLocalAudio(false);
    }

    public void a(float f10) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setExposureCompensation ";
        charSequence.append(string2);
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).a(f10);
    }

    public void a(float f10, float f11) {
        d d10 = this.l;
        if (d10 != null) {
            d10.a(f10, f11);
        }
    }

    public void a(int n10) {
        Object object = d;
        String string2 = "liteav_api setRenderRotation ";
        TXCLog.i((String)object, string2);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).c(n10);
    }

    public void a(int n10, int n11) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setSurfaceSize ");
        charSequence.append(n10);
        String string2 = ",";
        charSequence.append(string2);
        charSequence.append(n11);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).a(n10, n11);
    }

    public void a(int n10, int n11, int n12) {
        Object object = this.l;
        if (object != null) {
            ((d)object).a(n10, n11, n12);
        }
        if (n11 != 0 && n12 != 0) {
            object = this.k;
            ((com.tencent.liteav.g)object).a = n11;
            ((com.tencent.liteav.g)object).b = n12;
        }
        if (n10 != 0) {
            Object object2;
            Object object3;
            object = this.k;
            ((com.tencent.liteav.g)object).c = n10;
            int n13 = 4;
            Object[] objectArray = new Object[n13];
            objectArray[0] = object = Integer.valueOf(((com.tencent.liteav.g)object).f);
            int n14 = 1;
            objectArray[n14] = object3 = Integer.valueOf(n10);
            object3 = n11;
            n11 = 2;
            objectArray[n11] = object3;
            n10 = 3;
            objectArray[n10] = object2 = Integer.valueOf(n12);
            object3 = String.format("Qos: Change [mode:%d][bitrate:%d][videosize:%d*%d]", objectArray);
            object2 = "";
            Monitor.a(n11, (String)object3, (String)object2, 0);
        }
    }

    public void a(int n10, String string2) {
    }

    /*
     * Unable to fully structure code
     */
    public void a(int var1_1, boolean var2_2, boolean var3_3) {
        var4_4 = this;
        var5_5 = var1_1;
        var6_6 = var2_2;
        var7_7 = var3_3;
        var8_8 = 3;
        var9_9 = new Object[var8_8];
        var10_10 = var1_1;
        var11_11 = 0;
        var9_9[0] = var10_10;
        var10_10 = "true";
        var12_12 = "false";
        var13_13 = var2_2 != 0 ? var10_10 : var12_12;
        var14_14 = 1;
        var9_9[var14_14] = var13_13;
        if (var7_7 == 0) {
            var10_10 = var12_12;
        }
        var15_15 = 2;
        var9_9[var15_15] = var10_10;
        var10_10 = "setVideoQuality:[quality:%d][adjustBitrate:%s][adjustResolution:%s]";
        var4_4.a((String)var10_10, (Object[])var9_9);
        var16_16 = Build.VERSION.SDK_INT;
        var17_17 = 18;
        if (var16_16 < var17_17 && (var5_5 == var15_15 || var5_5 == var8_8)) {
            var5_5 = var14_14;
        }
        if ((var13_13 = var4_4.f) == null) {
            var4_4.f = var13_13 = new TXLivePushConfig();
        }
        var13_13 = var4_4.f;
        var13_13.setVideoFPS(var17_17);
        if (var7_7 != 0 && var6_6 != 0) {
            var18_18 = var14_14;
        } else {
            var18_18 = 0;
            var13_13 = null;
        }
        var19_19 = 30;
        var20_20 = 500;
        var21_21 = 900;
        var22_22 = 3000;
        var23_23 = 800;
        var15_15 = 48000;
        block0 : switch (var5_5) {
            default: {
                var4_4.f.setHardwareAcceleration(2);
                var24_24 = com.tencent.rtmp.b.d;
                var25_28 = new StringBuilder();
                var25_28.append("setVideoPushQuality: invalid quality ");
                var25_28.append(var5_5);
                var26_35 = var25_28.toString();
                TXCLog.e(var24_24, var26_35);
                return;
            }
            case 7: {
                var4_4.f.enableAEC(false);
                var4_4.f.setHardwareAcceleration(var14_14);
                var4_4.f.setVideoResolution(var19_19);
                var25_29 = var4_4.f;
                var25_29.setAudioSampleRate(var15_15);
                var4_4.a((boolean)var6_6, false);
                var24_25 = var4_4.f;
                var7_7 = 2500;
                var24_25.setMinVideoBitrate(var7_7);
                var4_4.f.setVideoBitrate(var22_22);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var22_22);
lbl65:
                // 7 sources

                while (true) {
                    var6_6 = 0;
                    var24_25 = null;
                    break block0;
                    break;
                }
            }
            case 6: {
                var4_4.f.enableAEC((boolean)var14_14);
                var4_4.f.setHardwareAcceleration(var14_14);
                var4_4.f.setVideoResolution(0);
                var4_4.f.setAudioSampleRate(var15_15);
                var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                var4_4.f.setAutoAdjustStrategy(5);
                var4_4.f.setMinVideoBitrate(190);
                var4_4.f.setVideoBitrate(400);
                var24_26 = var4_4.f;
                var7_7 = 810;
                var24_26.setMaxVideoBitrate(var7_7);
                var6_6 = var14_14;
                var11_11 = var14_14;
                break;
            }
            case 5: {
                var4_4.f.enableAEC((boolean)var14_14);
                var4_4.f.setHardwareAcceleration(var14_14);
                var4_4.f.setVideoResolution(6);
                var4_4.f.setAutoAdjustBitrate(false);
                var24_27 = var4_4.f;
                var7_7 = 350;
                var24_27.setVideoBitrate(var7_7);
                var24_27 = var4_4.f;
                var24_27.setAudioSampleRate(var15_15);
lbl94:
                // 2 sources

                while (true) {
                    var6_6 = 0;
                    var24_27 = null;
                    var11_11 = var14_14;
                    break block0;
                    break;
                }
            }
            case 4: {
                var6_6 = 4;
                if (var16_16 < var17_17) {
                    var4_4.f.enableAEC((boolean)var14_14);
                    var4_4.f.setHardwareAcceleration(0);
                    var4_4.f.setVideoResolution(0);
                    var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                    var25_30 = var4_4.f;
                    var25_30.setAutoAdjustStrategy(var6_6);
                    var4_4.f.setMinVideoBitrate(var20_20);
                    var4_4.f.setVideoBitrate(var23_23);
                    var24_27 = var4_4.f;
                    var24_27.setMaxVideoBitrate(var21_21);
                } else {
                    var7_7 = var4_4.h;
                    if (var7_7 == var14_14) {
                        var4_4.f.enableAEC((boolean)var14_14);
                        var4_4.f.setHardwareAcceleration(var14_14);
                        var4_4.f.setVideoResolution(0);
                        var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                        var25_31 = var4_4.f;
                        var25_31.setAutoAdjustStrategy(var6_6);
                        var4_4.f.setMinVideoBitrate(var20_20);
                        var4_4.f.setVideoBitrate(var23_23);
                        var24_27 = var4_4.f;
                        var24_27.setMaxVideoBitrate(var21_21);
                    } else if (var7_7 == var8_8) {
                        var4_4.f.enableAEC((boolean)var14_14);
                        var4_4.f.setHardwareAcceleration(var14_14);
                        var25_32 = var4_4.f;
                        var16_16 = 2;
                        var25_32.setVideoResolution(var16_16);
                        var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                        var25_32 = var4_4.f;
                        var25_32.setAutoAdjustStrategy(var6_6);
                        var4_4.f.setMinVideoBitrate(1000);
                        var24_27 = var4_4.f;
                        var7_7 = 1800;
                        var24_27.setVideoBitrate(var7_7);
                        var24_27 = var4_4.f;
                        var24_27.setMaxVideoBitrate(var7_7);
                    } else {
                        var16_16 = 7;
                        if (var7_7 == var16_16) {
                            var4_4.f.enableAEC((boolean)var14_14);
                            var4_4.f.setHardwareAcceleration(var14_14);
                            var4_4.f.setVideoResolution(var19_19);
                            var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                            var25_33 = var4_4.f;
                            var25_33.setAutoAdjustStrategy(var6_6);
                            var24_27 = var4_4.f;
                            var7_7 = 2000;
                            var24_27.setMinVideoBitrate(var7_7);
                            var4_4.f.setVideoBitrate(var22_22);
                            var24_27 = var4_4.f;
                            var24_27.setMaxVideoBitrate(var22_22);
                        } else {
                            var4_4.f.enableAEC((boolean)var14_14);
                            var4_4.f.setHardwareAcceleration(var14_14);
                            var4_4.f.setVideoResolution(var14_14);
                            var4_4.f.setAutoAdjustBitrate((boolean)var14_14);
                            var25_34 = var4_4.f;
                            var25_34.setAutoAdjustStrategy(var6_6);
                            var4_4.f.setMinVideoBitrate(var23_23);
                            var4_4.f.setVideoBitrate(1200);
                            var24_27 = var4_4.f;
                            var7_7 = 1500;
                            var24_27.setMaxVideoBitrate(var7_7);
                        }
                    }
                }
                var24_27 = var4_4.f;
                var24_27.setAudioSampleRate(var15_15);
                ** continue;
            }
            case 3: {
                var4_4.f.enableAEC(false);
                var4_4.f.setHardwareAcceleration(var14_14);
                var9_9 = var4_4.f;
                var17_17 = 2;
                var9_9.setVideoResolution(var17_17);
                var9_9 = var4_4.f;
                var9_9.setAudioSampleRate(var15_15);
                var4_4.a((boolean)var6_6, (boolean)var7_7);
                if (var18_18 == 0) ** GOTO lbl188
                var4_4.f.setMinVideoBitrate(600);
                var24_25 = var4_4.f;
                var7_7 = 1800;
                var24_25.setVideoBitrate(var7_7);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var7_7);
                ** GOTO lbl65
lbl188:
                // 1 sources

                var7_7 = 1800;
                var24_25 = var4_4.f;
                var16_16 = 1000;
                var24_25.setMinVideoBitrate(var16_16);
                var4_4.f.setVideoBitrate(var7_7);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var7_7);
                ** GOTO lbl65
            }
            case 2: {
                var4_4.f.enableAEC(false);
                var4_4.f.setHardwareAcceleration(var14_14);
                var4_4.f.setVideoResolution(var14_14);
                var9_9 = var4_4.f;
                var9_9.setAudioSampleRate(var15_15);
                var4_4.a((boolean)var6_6, (boolean)var7_7);
                if (var18_18 == 0) ** GOTO lbl212
                var4_4.f.setMinVideoBitrate(600);
                var24_25 = var4_4.f;
                var7_7 = 1200;
                var24_25.setVideoBitrate(var7_7);
                var24_25 = var4_4.f;
                var16_16 = 1500;
                var24_25.setMaxVideoBitrate(var16_16);
                ** GOTO lbl65
lbl212:
                // 1 sources

                var7_7 = 1200;
                var16_16 = 1500;
                var4_4.f.setMinVideoBitrate(var23_23);
                var4_4.f.setVideoBitrate(var7_7);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var16_16);
                ** GOTO lbl65
            }
            case 1: {
                var4_4.f.enableAEC(false);
                var9_9 = var4_4.f;
                var17_17 = 2;
                var9_9.setHardwareAcceleration(var17_17);
                var4_4.f.setVideoResolution(0);
                var9_9 = var4_4.f;
                var9_9.setAudioSampleRate(var15_15);
                var4_4.a((boolean)var6_6, (boolean)var7_7);
                if (var18_18 == 0) ** GOTO lbl236
                var24_25 = var4_4.f;
                var7_7 = 301;
                var24_25.setMinVideoBitrate(var7_7);
                var4_4.f.setVideoBitrate(var23_23);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var21_21);
                ** GOTO lbl65
lbl236:
                // 1 sources

                var4_4.f.setMinVideoBitrate(var20_20);
                var4_4.f.setVideoBitrate(var23_23);
                var24_25 = var4_4.f;
                var24_25.setMaxVideoBitrate(var21_21);
                ** continue;
            }
        }
        var4_4.h = var5_5;
        var26_36 = var4_4.f;
        var7_7 = var11_11 ^ 1;
        var26_36.enableVideoHardEncoderMainProfile((boolean)var7_7);
        var26_36 = var4_4.f;
        if (var11_11 != 0) {
            var8_8 = var14_14;
        }
        var26_36.setVideoEncodeGop(var8_8);
        var26_36 = var4_4.k;
        if (var26_36 != null) {
            var26_36.P = var11_11;
            var26_36.Q = var6_6;
        }
        var26_36 = var4_4.f;
        var4_4.a((TXLivePushConfig)var26_36);
    }

    public void a(MediaFormat object) {
        com.tencent.liteav.muxer.c c10;
        boolean bl2 = this.M;
        if (bl2 && (c10 = this.I) != null) {
            c10.a((MediaFormat)object);
            boolean bl3 = this.J;
            if (!bl3) {
                long l10;
                object = this.I;
                ((com.tencent.liteav.muxer.c)object).a();
                this.J = bl3 = true;
                this.L = l10 = 0L;
            }
        }
    }

    public void a(Surface surface) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setSurface ";
        charSequence.append(string2);
        charSequence.append(surface);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).a(surface);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(TXSNALPacket tXSNALPacket) {
        Object object;
        int n10;
        Object object2;
        int n11;
        int n12;
        Object object3 = this.p;
        int n13 = 1;
        if (object3 != null) {
            ((TXCQoS)object3).setHasVideo(n13 != 0);
        }
        if ((object3 = this.m) != null && tXSNALPacket != null && (object3 = (Object)tXSNALPacket.nalData) != null) {
            synchronized (this) {
                object3 = this.A;
                if (object3 != null && (n12 = ((ArrayList)object3).isEmpty()) == 0) {
                    Object object4;
                    Object object5;
                    int n14;
                    int n15;
                    int n16;
                    object3 = this.A;
                    object3 = ((ArrayList)object3).iterator();
                    n11 = 0;
                    object2 = null;
                    n10 = 0;
                    object = null;
                    while (true) {
                        n16 = object3.hasNext();
                        n15 = 5;
                        n14 = 10240;
                        if (n16 == 0) break;
                        object5 = object3.next();
                        object5 = (b$b)object5;
                        long l10 = ((b$b)object5).a;
                        long l11 = tXSNALPacket.pts;
                        long l12 = l10 - l11;
                        object4 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                        if (object4 > 0) break;
                        object5 = ((b$b)object5).b;
                        object4 = ((E)object5).length;
                        if (object4 <= n14) {
                            n14 = ((Object)object5).length;
                        }
                        n10 += (n14 += n15);
                    }
                    if (n10 != 0) {
                        boolean bl2;
                        object3 = tXSNALPacket.nalData;
                        n12 = ((Object)object3).length;
                        object3 = new byte[n10 += n12];
                        object = new byte[n15];
                        object5 = this.A;
                        object5 = ((ArrayList)object5).iterator();
                        object4 = 0;
                        int n17 = 0;
                        while (bl2 = object5.hasNext()) {
                            Object object6 = object5.next();
                            object6 = (b$b)object6;
                            long l13 = ((b$b)object6).a;
                            long l14 = tXSNALPacket.pts;
                            long l15 = l13 - l14;
                            Object object7 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
                            if (object7 > 0) break;
                            ++object4;
                            byte[] byArray = ((b$b)object6).b;
                            int n18 = byArray.length;
                            object7 = n18 <= n14 ? (Object)byArray.length : (Object)n14;
                            n18 = (int)(object7 + true);
                            int n19 = n18 >> 24 & 0xFF;
                            object[0] = n19;
                            n19 = (byte)(n18 >> 16 & 0xFF);
                            object[n13] = n19;
                            n19 = 2;
                            byte by2 = (byte)(n18 >> 8 & 0xFF);
                            object[n19] = by2;
                            n19 = 3;
                            n18 = (byte)(n18 & 0xFF);
                            object[n19] = n18;
                            n18 = 4;
                            n19 = 6;
                            object[n18] = n19;
                            System.arraycopy(object, 0, object3, n17, n15);
                            object6 = ((b$b)object6).b;
                            System.arraycopy(object6, 0, object3, n17 += 5, (int)object7);
                            n17 += object7;
                        }
                        object = null;
                        for (n10 = 0; n10 < object4; ++n10) {
                            object5 = this.A;
                            ((ArrayList)object5).remove(0);
                        }
                        object = tXSNALPacket.nalData;
                        n16 = ((Object)object).length;
                        System.arraycopy(object, 0, object3, n17, n16);
                        tXSNALPacket.nalData = (byte[])object3;
                    }
                }
            }
            object3 = this.m;
            ((TXCStreamUploader)object3).pushNAL(tXSNALPacket);
        }
        if ((n12 = this.M) == 0) return;
        object3 = this.I;
        if (object3 == null) return;
        if (tXSNALPacket == null) return;
        object3 = tXSNALPacket.nalData;
        if (object3 == null) return;
        object3 = this.d((byte[])object3);
        n11 = this.J;
        if (n11 != 0) {
            this.a(tXSNALPacket, (byte[])object3);
            return;
        }
        n11 = tXSNALPacket.nalType;
        if (n11 != 0) return;
        n11 = this.l.c();
        object2 = com.tencent.liteav.basic.util.g.a(object3, n11, n10 = ((d)(object = this.l)).d());
        if (object2 != null) {
            long l16;
            object = this.I;
            ((com.tencent.liteav.muxer.c)object).a((MediaFormat)object2);
            object2 = this.I;
            ((com.tencent.liteav.muxer.c)object2).a();
            this.J = n13;
            this.L = l16 = 0L;
        }
        this.a(tXSNALPacket, (byte[])object3);
    }

    public void a(ITXLivePushListener iTXLivePushListener) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setPushListener ");
        charSequence.append(iTXLivePushListener);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        this.g = iTXLivePushListener;
    }

    public void a(TXLivePushConfig objectArray) {
        String string2 = d;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("liteav_api setConfig ");
        ((StringBuilder)object).append(objectArray);
        String string3 = ", ";
        ((StringBuilder)object).append(string3);
        ((StringBuilder)object).append(this);
        object = ((StringBuilder)object).toString();
        TXCLog.i(string2, (String)object);
        if (objectArray == null) {
            objectArray = new TXLivePushConfig();
        }
        this.f = objectArray;
        this.b((TXLivePushConfig)objectArray);
        this.Q();
        object = this.k.h;
        objectArray = new Object[]{object, object = Integer.valueOf(this.k.a), object = Integer.valueOf(this.k.b), object = Integer.valueOf(this.k.c), object = Integer.valueOf(this.k.e), object = Integer.valueOf(this.k.d), object = Integer.valueOf(this.k.i), object = Integer.valueOf(this.k.s), object = Integer.valueOf(this.k.R)};
        this.a("setConfig:[fps:%d][resolution:%d*%d][bitrate:%dkbps][minBitrate:%dkbps][maxBitrate:%dkbps][gop:%d][audioSampleRate:%d][customMode:%d]", objectArray);
    }

    public void a(TXLivePusher$AudioCustomProcessListener tXLivePusher$AudioCustomProcessListener) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setAudioProcessListener ");
        charSequence.append(tXLivePusher$AudioCustomProcessListener);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        this.j = tXLivePusher$AudioCustomProcessListener;
    }

    public void a(TXLivePusher$ITXAudioVolumeEvaluationListener tXLivePusher$ITXAudioVolumeEvaluationListener) {
        this.B = tXLivePusher$ITXAudioVolumeEvaluationListener;
    }

    public void a(TXLivePusher$ITXSnapshotListener tXLivePusher$ITXSnapshotListener) {
        Object object = d;
        Object object2 = new StringBuilder();
        String string2 = "liteav_api snapshot ";
        ((StringBuilder)object2).append(string2);
        ((StringBuilder)object2).append(tXLivePusher$ITXSnapshotListener);
        object2 = ((StringBuilder)object2).toString();
        TXCLog.i((String)object, (String)object2);
        boolean bl2 = this.t;
        if (!bl2 && tXLivePusher$ITXSnapshotListener != null && (object = this.l) != null) {
            if (object != null) {
                boolean bl3;
                this.t = bl3 = true;
                object2 = new b$11(this, tXLivePusher$ITXSnapshotListener);
                ((d)object).a((o)object2);
                tXLivePusher$ITXSnapshotListener = this.o;
                object = this.H;
                long l10 = 2000L;
                tXLivePusher$ITXSnapshotListener.postDelayed((Runnable)object, l10);
            } else {
                tXLivePusher$ITXSnapshotListener = null;
                this.t = false;
            }
        }
    }

    public void a(TXLivePusher$OnBGMNotify object) {
        Object object2 = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setBGMNofify ";
        charSequence.append(string2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        TXCLog.i((String)object2, (String)charSequence);
        this.a = object;
        if (object != null) {
            object = TXCLiveBGMPlayer.getInstance();
            object2 = this.F;
            ((TXCLiveBGMPlayer)object).setOnPlayListener((com.tencent.liteav.audio.g)object2);
        } else {
            object = TXCLiveBGMPlayer.getInstance();
            object2 = null;
            ((TXCLiveBGMPlayer)object).setOnPlayListener(null);
        }
    }

    public void a(TXLivePusher$VideoCustomProcessListener object) {
        Object object2 = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setVideoProcessListener ";
        charSequence.append(string2);
        charSequence.append(object);
        charSequence = charSequence.toString();
        TXCLog.i((String)object2, (String)charSequence);
        this.i = object;
        if (object == null) {
            object = this.l;
            if (object != null) {
                object2 = null;
                ((d)object).a((p)null);
            }
        } else {
            object = this.l;
            if (object != null) {
                object2 = this.E;
                ((d)object).a((p)object2);
            }
        }
    }

    public void a(TXCloudVideoView object) {
        String string2;
        int n10;
        Object object2 = new StringBuilder();
        ((StringBuilder)object2).append("startCameraPreview [view:");
        int n11 = 0;
        Object[] objectArray = null;
        if (object != null) {
            n10 = object.hashCode();
        } else {
            n10 = 0;
            string2 = null;
        }
        ((StringBuilder)object2).append(n10);
        string2 = "]";
        ((StringBuilder)object2).append(string2);
        object2 = ((StringBuilder)object2).toString();
        objectArray = new Object[]{};
        this.a((String)object2, objectArray);
        object2 = this.f;
        this.a((TXLivePushConfig)object2);
        object2 = this.k;
        int n12 = ((com.tencent.liteav.g)object2).M;
        if (n12 != 0) {
            TXCLog.e(d, "enable pure audio push , so can not start preview!");
            return;
        }
        object2 = this.e;
        if (object2 != object && object2 != null) {
            ((TXCloudVideoView)((Object)object2)).removeVideoView();
        }
        this.e = object;
        object2 = this.l;
        if (object2 == null) {
            objectArray = this.n;
            this.l = object2 = new d((Context)objectArray);
        }
        this.l.a(this);
        this.l.a(this);
        this.l.a((TXCloudVideoView)((Object)object));
        object = this.l;
        object2 = this.f;
        n11 = ((TXLivePushConfig)object2).mBeautyLevel;
        n10 = ((TXLivePushConfig)object2).mWhiteningLevel;
        n12 = ((TXLivePushConfig)object2).mRuddyLevel;
        ((d)object).b(n11, n10, n12);
        object = LicenceCheck.a();
        objectArray = this.n;
        ((LicenceCheck)object).a((f)null, (Context)objectArray);
    }

    public void a(TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setVideoRecordListener ");
        charSequence.append(tXRecordCommon$ITXVideoRecordListener);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        this.N = tXRecordCommon$ITXVideoRecordListener;
    }

    public void a(String string2, Object ... objectArray) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api(");
        int n10 = this.hashCode();
        charSequence.append(n10);
        charSequence.append(")");
        charSequence = charSequence.toString();
        string2 = String.format(string2, objectArray);
        Monitor.a(1, string2, "", 0, (String)charSequence);
    }

    public void a(boolean bl2) {
        TXCStreamUploader tXCStreamUploader = this.m;
        if (tXCStreamUploader != null) {
            tXCStreamUploader.setDropEanble(bl2);
        }
    }

    public void a(byte[] byArray) {
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        TXLivePushConfig tXLivePushConfig = this.f;
        int n10 = tXLivePushConfig.mAudioSample;
        int n11 = tXLivePushConfig.mAudioChannels;
        tXCAudioEngine.sendCustomPCMData(byArray, n10, n11);
    }

    public void a(byte[] byArray, long l10, int n10, int n11, int n12) {
        TXLivePusher$AudioCustomProcessListener tXLivePusher$AudioCustomProcessListener = this.j;
        if (tXLivePusher$AudioCustomProcessListener != null) {
            tXLivePusher$AudioCustomProcessListener.onRecordPcmData(byArray, l10, n10, n11, n12);
        }
    }

    public void a(byte[] byArray, long l10, int n10, int n11, int n12, boolean bl2) {
        TXLivePusher$AudioCustomProcessListener tXLivePusher$AudioCustomProcessListener = this.j;
        if (tXLivePusher$AudioCustomProcessListener != null) {
            tXLivePusher$AudioCustomProcessListener.onRecordRawPcmData(byArray, l10, n10, n11, n12, bl2);
        }
    }

    public boolean a(int n10, int n11, int n12, int n13) {
        Object object;
        d d10 = this.l;
        if (d10 != null) {
            d10.d(n10);
            object = this.l;
            ((d)object).b(n11, n12, n13);
        }
        if ((object = this.f) != null) {
            ((TXLivePushConfig)object).mBeautyLevel = n11;
            ((TXLivePushConfig)object).mWhiteningLevel = n12;
            ((TXLivePushConfig)object).mRuddyLevel = n13;
        }
        return true;
    }

    public int b() {
        return TXCStatus.c(this.s, 4002);
    }

    public int b(int n10, int n11, int n12) {
        d d10 = this.l;
        if (d10 != null) {
            EGLContext eGLContext = ((EGL10)EGLContext.getEGL()).eglGetCurrentContext();
            return this.l.a(n10, n11, n12, eGLContext, 0L);
        }
        return -1000;
    }

    public void b(boolean bl2) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("stopCameraPreview needClearLastImg:");
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        Object[] objectArray = new Object[]{};
        this.a((String)object, objectArray);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).b(bl2);
    }

    public void b(byte[] byArray, long l10, int n10, int n11, int n12) {
        com.tencent.liteav.muxer.c c10;
        n10 = (int)(this.M ? 1 : 0);
        if (n10 != 0 && (c10 = this.I) != null && (n10 = (int)(this.J ? 1 : 0)) != 0 && byArray != null) {
            int n13 = byArray.length;
            long l11 = 1000L;
            long l12 = l10 * l11;
            c10.a(byArray, 0, n13, l12, 0);
        }
    }

    public boolean b(float f10) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setBGMVolume ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        return TXCLiveBGMPlayer.getInstance().setVolume(f10);
    }

    public boolean b(int n10) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setZoom ";
        charSequence.append(string2);
        charSequence.append(n10);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.l;
        if (object == null) {
            return false;
        }
        return ((d)object).e(n10);
    }

    public boolean b(String string2) {
        String string3 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api playBGM ");
        charSequence.append(string2);
        charSequence = charSequence.toString();
        TXCLog.i(string3, (String)charSequence);
        return TXCLiveBGMPlayer.getInstance().startPlay(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean b(byte[] object) {
        int n10 = ((byte[])object).length;
        if (n10 <= 0) return false;
        n10 = ((byte[])object).length;
        int n11 = 2048;
        if (n10 > n11) {
            return false;
        }
        synchronized (this) {
            long l10;
            Object object2 = this.A;
            if (object2 == null) return true;
            n11 = 0;
            byte[] byArray = null;
            object2 = new b$b(this, null);
            ((b$b)object2).a = l10 = TXCTimeUtil.generatePtsMS();
            byArray = this.e((byte[])object);
            int n12 = ((byte[])object).length;
            object = this.a(n12, byArray);
            ((b$b)object2).b = object;
            object = this.A;
            ((ArrayList)object).add(object2);
            return true;
        }
    }

    public int c() {
        String string2 = this.s;
        int n10 = TXCStatus.c(string2, 7002);
        Object object = this.k;
        int n11 = ((com.tencent.liteav.g)object).P;
        if (n11 != 0) {
            object = this.s;
            int n12 = 7001;
            n11 = TXCStatus.c((String)object, n12);
        } else {
            object = this.s;
            int n13 = 4002;
            n11 = TXCStatus.c((String)object, n13);
        }
        return n10 + n11;
    }

    public int c(String string2) {
        return TXCLiveBGMPlayer.getInstance().getBGMDuration(string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void c(byte[] object) {
        synchronized (this) {
            Object object2 = this.A;
            if (object2 != null) {
                long l10;
                object2 = new b$b(this, null);
                ((b$b)object2).a = l10 = TXCTimeUtil.generatePtsMS();
                object = this.e((byte[])object);
                ((b$b)object2).b = object;
                object = this.A;
                ((ArrayList)object).add(object2);
            }
            return;
        }
    }

    public boolean c(float f10) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setMicVolume ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        return TXCAudioEngine.getInstance().setSoftwareCaptureVolume(f10);
    }

    public boolean c(int n10) {
        TXCLiveBGMPlayer.getInstance().setBGMPosition(n10);
        return true;
    }

    public boolean c(boolean bl2) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setMirror ";
        charSequence.append(string2);
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.f;
        if (object != null) {
            ((TXLivePushConfig)object).setVideoEncoderXMirror(bl2);
        }
        if ((object = this.l) == null) {
            return false;
        }
        ((d)object).e(bl2);
        return true;
    }

    public int d() {
        TXCStreamUploader tXCStreamUploader = this.m;
        if (tXCStreamUploader == null) {
            return 0;
        }
        int n10 = TXCStatus.c(this.s, 7004);
        int n11 = TXCStatus.c(this.s, 7003);
        return n10 + n11;
    }

    public int d(String object) {
        Object object2 = d;
        Object object3 = new StringBuilder();
        String string2 = "liteav_api startRecord ";
        ((StringBuilder)object3).append(string2);
        ((StringBuilder)object3).append((String)object);
        object3 = ((StringBuilder)object3).toString();
        TXCLog.i((String)object2, (String)object3);
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 18;
        if (n10 < n11) {
            object = new StringBuilder();
            ((StringBuilder)object).append("API levl is too low (record need 18, current is");
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append(")");
            object = ((StringBuilder)object).toString();
            TXCLog.e((String)object2, (String)object);
            return -3;
        }
        n10 = (int)(this.M ? 1 : 0);
        if (n10 != 0) {
            TXCLog.w((String)object2, "ignore start record when recording");
            return -1;
        }
        object3 = this.l;
        if (object3 != null && (n10 = (int)(((d)object3).i() ? 1 : 0)) != 0) {
            int n12;
            object3 = "start record ";
            TXCLog.w((String)object2, (String)object3);
            this.M = n12 = 1;
            this.K = object;
            object2 = new File((String)object);
            boolean bl2 = ((File)object2).exists();
            if (bl2) {
                ((File)object2).delete();
            }
            object2 = this.n;
            n10 = 0;
            object3 = null;
            this.I = object = new com.tencent.liteav.muxer.c((Context)object2, 0);
            this.J = false;
            object2 = this.K;
            ((com.tencent.liteav.muxer.c)object).a((String)object2);
            this.B();
            object = this.n.getApplicationContext();
            n12 = com.tencent.liteav.basic.datareport.a.aI;
            TXCDRApi.txReportDAU((Context)object, n12);
            object = this.l;
            if (object != null) {
                ((d)object).n();
            }
            return 0;
        }
        TXCLog.w((String)object2, "ignore start record when not pushing");
        return -2;
    }

    public void d(float f10) {
        String string2 = d;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("liteav_api setBGMPitch ");
        charSequence.append(f10);
        charSequence = charSequence.toString();
        TXCLog.i(string2, (String)charSequence);
        TXCLiveBGMPlayer.getInstance().setPitch(f10);
    }

    public void d(int n10) {
        int n11;
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setReverb ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i((String)object, (String)charSequence);
        if (n10 >= 0 && n10 <= (n11 = 7)) {
            object = TXCAudioEngine.getInstance();
            TXAudioEffectManager$TXVoiceReverbType tXAudioEffectManager$TXVoiceReverbType = this.b[n10];
            ((TXCAudioEngine)object).setReverbType(tXAudioEffectManager$TXVoiceReverbType);
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("reverbType not support :");
        ((StringBuilder)charSequence).append(n10);
        String string3 = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object, string3);
    }

    public boolean d(boolean bl2) {
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api turnOnFlashLight ";
        charSequence.append(string2);
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.l;
        if (object == null) {
            return false;
        }
        return ((d)object).d(bl2);
    }

    public int e() {
        return 5;
    }

    public void e(int n10) {
        int n11;
        Object object = d;
        CharSequence charSequence = new StringBuilder();
        String string2 = "liteav_api setVoiceChangerType ";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i((String)object, (String)charSequence);
        if (n10 >= 0 && n10 <= (n11 = 11)) {
            object = TXCAudioEngine.getInstance();
            TXAudioEffectManager$TXVoiceChangerType tXAudioEffectManager$TXVoiceChangerType = this.c[n10];
            ((TXCAudioEngine)object).setVoiceChangerType(tXAudioEffectManager$TXVoiceChangerType);
            return;
        }
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("voiceChangerType not support :");
        ((StringBuilder)charSequence).append(n10);
        String string3 = ((StringBuilder)charSequence).toString();
        TXCLog.e((String)object, string3);
    }

    public void e(String string2) {
        TXCLog.i("User", string2);
    }

    public void e(boolean bl2) {
        Object object = new StringBuilder();
        Object object2 = "setMute:";
        ((StringBuilder)object).append((String)object2);
        object2 = bl2 ? "true" : "false";
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        object2 = new Object[]{};
        this.a((String)object, object2);
        this.x = bl2;
        TXCAudioEngine.getInstance().muteLocalAudio(bl2);
        object = this.f;
        boolean bl3 = ((TXLivePushConfig)object).mEnablePureAudioPush;
        if (bl3 && (object = this.m) != null) {
            ((TXCStreamUploader)object).setAudioMute(bl2);
        }
    }

    public int f() {
        return TXCStatus.c(this.s, 7005);
    }

    public void f(int n10) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableAudioVolumeEvaluation intervalMs = ");
        charSequence.append(n10);
        charSequence = charSequence.toString();
        Object[] objectArray = new Object[]{};
        this.a((String)charSequence, objectArray);
        if (n10 > 0) {
            int n11 = 100;
            if (n10 < n11) {
                n10 = n11;
            }
            this.C = n10;
            this.y();
        } else {
            this.C = 0;
            this.z();
        }
    }

    public int g() {
        return TXCStatus.c(this.s, 7007);
    }

    public int h() {
        return TXCStatus.c(this.s, 7021);
    }

    public TXLivePushConfig i() {
        return this.f;
    }

    public void j() {
        Object[] objectArray = new Object[]{};
        this.a("stopPusher", objectArray);
        this.w();
        this.D();
        this.L();
        this.J();
        this.N();
        this.t();
        this.P();
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioEarMonitoring(false);
        this.x = false;
        this.k.P = false;
        this.H();
        this.r = "";
        this.y.clear();
        Monitor.a();
        this.l.a(false);
        this.z();
        TXCAudioEngine.getInstance().clean();
    }

    public void k() {
        boolean bl2 = false;
        Object object = new Object[]{};
        CharSequence charSequence = "pausePusher";
        this.a((String)charSequence, (Object[])object);
        object = this.l;
        if (object != null) {
            ((d)object).g();
        }
        object = d;
        charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("mPauseFlag:");
        TXLivePushConfig tXLivePushConfig = this.f;
        int n10 = tXLivePushConfig.mPauseFlag;
        ((StringBuilder)charSequence).append(n10);
        charSequence = ((StringBuilder)charSequence).toString();
        TXCLog.i((String)object, (String)charSequence);
        object = this.f;
        int n11 = ((TXLivePushConfig)object).mPauseFlag;
        int n12 = 2;
        int n13 = n11 & n12;
        if (n13 == n12) {
            object = TXCAudioEngine.getInstance();
            boolean bl3 = true;
            ((TXCAudioEngine)object).pauseAudioCapture(bl3);
        }
    }

    public void l() {
        Object object = new Object[]{};
        String string2 = "resumePusher";
        this.a(string2, (Object[])object);
        object = this.l;
        if (object != null) {
            ((d)object).h();
        }
        TXCAudioEngine.getInstance().resumeAudioCapture();
    }

    public boolean m() {
        d d10 = this.l;
        if (d10 != null) {
            return d10.i();
        }
        return false;
    }

    public void n() {
        Object object = new Object[]{};
        String string2 = "startScreenCapture";
        this.a(string2, (Object[])object);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).a((a$a)null);
    }

    public void o() {
        Object object = new Object[]{};
        String string2 = "stopScreenCapture";
        this.a(string2, (Object[])object);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).k();
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        Object object;
        Object object2 = this.o;
        if (object2 != null) {
            object = new b$12(this, bundle, n10);
            object2.post((Runnable)object);
        }
        if (n10 < 0) {
            object2 = "";
            object = bundle != null ? bundle.getString("EVT_MSG") : object2;
            Object[] objectArray = new Object[2];
            objectArray[0] = object;
            int n11 = 1;
            Integer n12 = n10;
            objectArray[n11] = n12;
            object = String.format("%s [errcode:%d]", objectArray);
            int n13 = 3;
            Monitor.a(n13, (String)object, (String)object2, 0);
        }
        this.a(n10, bundle);
    }

    public void p() {
        Object object = new Object[]{};
        String string2 = "switchCamera";
        this.a(string2, (Object[])object);
        object = this.l;
        if (object == null) {
            return;
        }
        ((d)object).j();
    }

    public int q() {
        d d10 = this.l;
        if (d10 == null) {
            return 0;
        }
        return d10.l();
    }

    public TXBeautyManager r() {
        d d10 = this.l;
        if (d10 == null) {
            Context context = this.n;
            this.l = d10 = new d(context);
        }
        return this.l.b();
    }

    public boolean s() {
        TXCLog.i(d, "liteav_api stopBGM ");
        return TXCLiveBGMPlayer.getInstance().stopPlay();
    }

    public void t() {
        TXCLog.i(d, "liteav_api stopAllBGM ");
        TXCLiveBGMPlayer.getInstance().stopAll();
    }

    public boolean u() {
        TXCLog.i(d, "liteav_api pauseBGM ");
        return TXCLiveBGMPlayer.getInstance().pause();
    }

    public boolean v() {
        TXCLog.i(d, "liteav_api resumeBGM ");
        return TXCLiveBGMPlayer.getInstance().resume();
    }

    public void w() {
        String string2 = d;
        Object object = "liteav_api stopRecord ";
        TXCLog.i(string2, (String)object);
        int n10 = this.M;
        if (n10 != 0 && (object = this.I) != null) {
            n10 = ((com.tencent.liteav.muxer.c)object).b();
            String string3 = "start record ";
            TXCLog.w(string2, string3);
            string2 = null;
            this.M = false;
            if (n10 == 0) {
                string2 = this.K;
                object = new b$10(this, string2);
                AsyncTask.execute((Runnable)object);
            } else {
                this.A();
            }
        }
    }
}

