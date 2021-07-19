/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.SurfaceTexture
 *  android.opengl.Matrix
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.text.TextUtils
 *  android.view.Surface
 *  android.view.TextureView
 *  android.view.View
 */
package com.tencent.liteav;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.Matrix;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import com.tencent.liteav.TXCRenderAndDec;
import com.tencent.liteav.TXCRenderAndDec$a;
import com.tencent.liteav.TXCRenderAndDec$b;
import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.b.a;
import com.tencent.liteav.b.a$a;
import com.tencent.liteav.b.a$b;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.o;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.g;
import com.tencent.liteav.f$1;
import com.tencent.liteav.f$2;
import com.tencent.liteav.f$3;
import com.tencent.liteav.f$4;
import com.tencent.liteav.f$5;
import com.tencent.liteav.f$6;
import com.tencent.liteav.f$a;
import com.tencent.liteav.network.TXCStreamDownloader;
import com.tencent.liteav.network.h;
import com.tencent.liteav.q;
import com.tencent.liteav.r;
import com.tencent.liteav.renderer.e;
import com.tencent.rtmp.TXLivePlayer$ITXAudioRawDataListener;
import com.tencent.rtmp.ui.TXCloudVideoView;
import com.tencent.ugc.TXRecordCommon$ITXVideoRecordListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Map;

public class f
extends q
implements TXCRenderAndDec$a,
TXCRenderAndDec$b,
com.tencent.liteav.audio.c,
com.tencent.liteav.audio.e,
b,
h,
com.tencent.liteav.renderer.a$a,
com.tencent.liteav.renderer.g {
    private int A;
    private int B;
    private com.tencent.liteav.renderer.h C;
    private com.tencent.liteav.renderer.h D;
    private float[] E;
    private float[] F;
    private String G;
    private int H;
    private boolean I;
    private com.tencent.liteav.basic.a.b J;
    private Object K;
    private com.tencent.liteav.basic.b.a L;
    private TXLivePlayer$ITXAudioRawDataListener M;
    private String N;
    private boolean O;
    private long P;
    private long Q;
    private f$a R;
    private TXCRenderAndDec a = null;
    private com.tencent.liteav.renderer.a f = null;
    private TXCStreamDownloader g = null;
    private Handler h;
    private TextureView i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private Surface p;
    private int q;
    private int r;
    private int s;
    private boolean t;
    private boolean u;
    private boolean v;
    private int w;
    private a x;
    private TXRecordCommon$ITXVideoRecordListener y;
    private com.tencent.liteav.e z;

    public f(Context object) {
        super((Context)object);
        long l10;
        long l11;
        Object object2;
        int n10;
        boolean bl2 = false;
        this.j = false;
        this.k = false;
        this.l = 100;
        this.m = 0;
        this.n = 0;
        this.o = false;
        this.q = 2;
        this.r = 48000;
        this.s = n10 = 16;
        this.t = false;
        this.u = false;
        this.v = false;
        this.w = 0;
        this.A = 0;
        this.B = 0;
        this.C = null;
        this.D = null;
        float[] fArray = object2 = new float[n10];
        float[] fArray2 = object2;
        fArray[0] = 1.0f;
        fArray2[1] = 0.0f;
        fArray[2] = 0.0f;
        fArray2[3] = 0.0f;
        fArray[4] = 0.0f;
        fArray2[5] = -1.0f;
        fArray[6] = 0.0f;
        fArray2[7] = 0.0f;
        fArray[8] = 0.0f;
        fArray2[9] = 0.0f;
        fArray[10] = 1.0f;
        fArray2[11] = 0.0f;
        fArray[12] = 0.0f;
        fArray2[13] = 1.0f;
        fArray[14] = 0.0f;
        fArray2[15] = 1.0f;
        this.E = object2;
        Object object3 = new float[n10];
        this.F = object3;
        object3 = "";
        this.G = object3;
        this.I = false;
        object2 = (Object)com.tencent.liteav.basic.a.b.a;
        this.J = (com.tencent.liteav.basic.a.b)((Object)object2);
        this.K = null;
        object2 = new f$1;
        super(this);
        this.L = (com.tencent.liteav.basic.b.a)object2;
        this.N = object3;
        this.O = false;
        this.P = l11 = 0L;
        this.Q = l11;
        this.R = null;
        com.tencent.liteav.basic.c.c.a().a((Context)object);
        Object object4 = com.tencent.liteav.basic.c.c.a().c();
        TXCAudioEngine.CreateInstance((Context)object, (String)object4);
        object = TXCAudioEngine.getInstance();
        object3 = this.L;
        object4 = new WeakReference(object3);
        ((TXCAudioEngine)object).addEventCallback((WeakReference)object4);
        object = com.tencent.liteav.basic.c.c.a();
        object4 = "Audio";
        object3 = "EnableAutoRestartDevice";
        l11 = ((c)object).a((String)object4, (String)object3);
        object = TXCAudioEngine.getInstance();
        long l12 = 1L;
        long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
        if (l13 == false || (l13 = (l10 = l11 - (l12 = (long)-1)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false) {
            bl2 = true;
        }
        ((TXCAudioEngine)object).enableAutoRestartDevice(bl2);
        object4 = Looper.getMainLooper();
        object = new Handler((Looper)object4);
        this.h = object;
        this.f = object = new com.tencent.liteav.renderer.a();
        ((e)object).a(this);
        this.R = object = new f$a(this);
        object = new StringBuilder();
        ((StringBuilder)object).append("[FirstFramePath] TXCLivePlayer: create player success. instance:");
        l13 = this.hashCode();
        ((StringBuilder)object).append((int)l13);
        object = ((StringBuilder)object).toString();
        TXCLog.i("TXCLivePlayer", (String)object);
    }

    public static /* synthetic */ TXRecordCommon$ITXVideoRecordListener a(f f10) {
        return f10.y;
    }

    private void a(int n10, String string2) {
        WeakReference weakReference = this.e;
        if (weakReference != null) {
            weakReference = new Bundle();
            Object object = "EVT_ID";
            weakReference.putInt((String)object, n10);
            long l10 = TXCTimeUtil.getTimeTick();
            weakReference.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            String string3 = "EVT_UTC_TIME";
            weakReference.putLong(string3, l10);
            if (string2 != null) {
                object = "EVT_MSG";
                weakReference.putCharSequence((String)object, string2);
            }
            if ((string2 = this.h) != null) {
                object = new f$5(this, n10, (Bundle)weakReference);
                string2.post((Runnable)object);
            }
        }
    }

    public static /* synthetic */ com.tencent.liteav.renderer.a b(f f10) {
        return f10.f;
    }

    private void b(String object) {
        int n10 = 2;
        Object object2 = new Object[n10];
        object2[0] = object;
        long l10 = TXCTimeUtil.getTimeTick();
        long l11 = 10000L;
        object = l10 %= l11;
        int n11 = 1;
        object2[n11] = object;
        this.N = object = String.format("%s-%d", (Object[])object2);
        object2 = this.a;
        if (object2 != null) {
            ((TXCRenderAndDec)object2).setID((String)object);
        }
        if ((object = this.f) != null) {
            object2 = this.N;
            ((com.tencent.liteav.basic.module.a)object).setID((String)object2);
        }
        if ((object = this.g) != null) {
            object2 = this.N;
            ((TXCStreamDownloader)object).setID((String)object2);
        }
        if ((object = this.z) != null) {
            object2 = this.N;
            ((com.tencent.liteav.e)object).d((String)object2);
        }
    }

    private int c(String string2, int n10) {
        Object object;
        boolean bl2;
        Object object2;
        Object object3;
        int n11 = 0;
        com.tencent.liteav.h h10 = null;
        int n12 = 1;
        int n13 = 5;
        if (n10 == 0) {
            object3 = this.c;
            object2 = new TXCStreamDownloader((Context)object3, n12);
            this.g = object2;
        } else if (n10 == n13) {
            object3 = this.c;
            int bl3 = 4;
            object2 = new TXCStreamDownloader((Context)object3, bl3);
            this.g = object2;
        } else {
            object3 = this.c;
            object2 = new TXCStreamDownloader((Context)object3, 0);
            this.g = object2;
            object2 = this.b.l;
            bl2 = TextUtils.isEmpty((CharSequence)object2);
            if (!bl2) {
                object2 = this.g;
                object3 = this.b.l;
                ((TXCStreamDownloader)object2).setFlvSessionKey((String)object3);
            }
        }
        object2 = this.g;
        object3 = this.N;
        ((TXCStreamDownloader)object2).setID((String)object3);
        this.g.setListener(this);
        this.g.setNotifyListener(this);
        object2 = this.g;
        object3 = this.b.q;
        ((TXCStreamDownloader)object2).setHeaders((Map)object3);
        if (n10 == n13) {
            n11 = n12;
        }
        if (n11 != 0) {
            this.g.setRetryTimes(n13);
            object = this.g;
            ((TXCStreamDownloader)object).setRetryInterval(n12);
        } else {
            object = this.g;
            n11 = this.b.e;
            ((TXCStreamDownloader)object).setRetryTimes(n11);
            object = this.g;
            h10 = this.b;
            n11 = h10.f;
            ((TXCStreamDownloader)object).setRetryInterval(n11);
        }
        TXCStreamDownloader tXCStreamDownloader = this.g;
        object = this.b;
        bl2 = ((com.tencent.liteav.h)object).i;
        int n14 = ((com.tencent.liteav.h)object).m;
        boolean bl3 = ((com.tencent.liteav.h)object).j;
        boolean bl4 = ((com.tencent.liteav.h)object).k;
        return tXCStreamDownloader.start(string2, bl2, n14, bl3, bl4);
    }

    public static /* synthetic */ boolean c(f f10) {
        return f10.O;
    }

    public static /* synthetic */ void d(f f10) {
        f10.u();
    }

    public static /* synthetic */ void e(f f10) {
        f10.v();
    }

    public static /* synthetic */ TXCRenderAndDec f(f f10) {
        return f10.a;
    }

    private void f(int n10) {
        Object object = this.i;
        boolean bl2 = false;
        if (object != null) {
            object.setVisibility(0);
        }
        Object object2 = this.c;
        object = new TXCRenderAndDec((Context)object2);
        this.a = object;
        ((TXCRenderAndDec)object).setNotifyListener(this);
        object = this.a;
        object2 = this.f;
        ((TXCRenderAndDec)object).setVideoRender((e)object2);
        this.a.setDecListener(this);
        this.a.setRenderAndDecDelegate(this);
        object = this.a;
        object2 = this.b;
        ((TXCRenderAndDec)object).setConfig((com.tencent.liteav.h)object2);
        object = this.a;
        object2 = this.N;
        ((TXCRenderAndDec)object).setID((String)object2);
        object = this.a;
        int n11 = 5;
        if (n10 == n11) {
            bl2 = true;
        }
        ((TXCRenderAndDec)object).start(bl2);
        TXCRenderAndDec tXCRenderAndDec = this.a;
        int n12 = this.n;
        tXCRenderAndDec.setRenderMode(n12);
        tXCRenderAndDec = this.a;
        n12 = this.m;
        tXCRenderAndDec.setRenderRotation(n12);
    }

    private void j() {
        int n10;
        int n11;
        Object object;
        Object object2;
        Object object3 = this.x;
        if (object3 == null) {
            int n12;
            this.A = n12 = this.f.h();
            this.B = n12 = this.f.i();
            object3 = this.l();
            object2 = this.c;
            this.x = object = new a((Context)object2);
            ((a)object).a((a$a)object3);
            object3 = this.x;
            object = new f$2(this);
            ((a)object3).a((a$b)object);
        }
        if ((object3 = this.C) == null) {
            object = Boolean.TRUE;
            this.C = object3 = new com.tencent.liteav.renderer.h((Boolean)object);
            ((com.tencent.liteav.renderer.h)object3).b();
            object3 = this.C;
            n11 = this.A;
            n10 = this.B;
            ((com.tencent.liteav.renderer.h)object3).b(n11, n10);
            object3 = this.C;
            n11 = this.A;
            n10 = this.B;
            ((com.tencent.liteav.renderer.h)object3).a(n11, n10);
        }
        if ((object3 = this.D) == null) {
            object = Boolean.FALSE;
            this.D = object3 = new com.tencent.liteav.renderer.h((Boolean)object);
            ((com.tencent.liteav.renderer.h)object3).b();
            object3 = this.D;
            n11 = this.f.f();
            n10 = this.f.g();
            ((com.tencent.liteav.renderer.h)object3).b(n11, n10);
            object3 = this.D;
            n11 = this.f.f();
            object2 = this.f;
            n10 = ((e)object2).g();
            ((com.tencent.liteav.renderer.h)object3).a(n11, n10);
            object3 = this.F;
            n11 = 0;
            object = null;
            Matrix.setIdentityM((float[])object3, (int)0);
        }
    }

    private void k() {
        com.tencent.liteav.renderer.h h10 = this.C;
        if (h10 != null) {
            h10.c();
            this.C = null;
        }
        if ((h10 = this.D) != null) {
            h10.c();
            this.D = null;
        }
    }

    private a$a l() {
        int n10;
        int n11 = this.A;
        if (n11 <= 0 || (n10 = this.B) <= 0) {
            n11 = 480;
            n10 = 640;
        }
        a$a a$a = new a$a();
        a$a.a = n11;
        a$a.b = n10;
        a$a.c = 20;
        double d10 = (double)(n11 * n11) * 1.0;
        double d11 = n10 * n10;
        a$a.d = n11 = (int)(Math.sqrt(d10 + d11) * 1.2);
        a$a.h = n11 = this.q;
        a$a.i = n11 = this.r;
        a$a.j = n11 = this.s;
        Object object = com.tencent.liteav.b.a.a(this.c, ".mp4");
        a$a.f = object;
        object = com.tencent.liteav.b.a.a(this.c, ".jpg");
        a$a.g = object;
        a$a.e = object = this.f.b();
        object = new StringBuilder();
        ((StringBuilder)object).append("record config: ");
        ((StringBuilder)object).append(a$a);
        object = ((StringBuilder)object).toString();
        TXCLog.d("TXCLivePlayer", (String)object);
        return a$a;
    }

    private void m() {
        TXCRenderAndDec tXCRenderAndDec = this.a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.stop();
            this.a.setVideoRender(null);
            this.a.setDecListener(null);
            tXCRenderAndDec = this.a;
            tXCRenderAndDec.setNotifyListener(null);
            this.a = null;
        }
    }

    private void n() {
        Object object;
        f f10 = this;
        int n10 = this.H;
        int n11 = 5;
        float f11 = 7.0E-45f;
        int n12 = 1;
        float f12 = Float.MIN_VALUE;
        n10 = n10 == n11 ? n12 : 0;
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(f10.I, 300);
        TXLivePlayer$ITXAudioRawDataListener tXLivePlayer$ITXAudioRawDataListener = f10.M;
        f10.a(tXLivePlayer$ITXAudioRawDataListener);
        int n13 = f10.H;
        float f13 = 1000.0f;
        if (n13 == n11) {
            TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
            String string2 = f10.N;
            object = f10.b;
            n11 = (int)(((com.tencent.liteav.h)object).g ? 1 : 0);
            boolean bl2 = n11 ^ 1;
            f11 = com.tencent.liteav.basic.a.a.b;
            f12 = f11 * f13;
            int n14 = (int)f12;
            int n15 = (int)(f11 * f13);
            f11 = com.tencent.liteav.basic.a.a.c * f13;
            int n16 = (int)f11;
            tXCAudioEngine.setRemoteAudioCacheParams(string2, bl2, n14, n15, n16);
        } else {
            TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
            String string3 = f10.N;
            object = f10.b;
            n13 = (int)(((com.tencent.liteav.h)object).g ? 1 : 0);
            boolean bl3 = n13 ^ 1;
            int n17 = (int)(((com.tencent.liteav.h)object).a * f13);
            f12 = ((com.tencent.liteav.h)object).c * f13;
            n12 = (int)f12;
            f11 = ((com.tencent.liteav.h)object).b * f13;
            n11 = (int)f11;
            tXCAudioEngine.setRemoteAudioCacheParams(string3, bl3, n17, n12, n11);
        }
        object = TXCAudioEngine.getInstance();
        String string4 = f10.N;
        n13 = (int)(f10.j ? 1 : 0);
        ((TXCAudioEngine)object).muteRemoteAudio(string4, n13 != 0);
        object = TXCAudioEngine.getInstance();
        string4 = f10.N;
        n13 = f10.k;
        ((TXCAudioEngine)object).muteRemoteAudioInSpeaker(string4, n13 != 0);
        object = TXCAudioEngine.getInstance();
        string4 = f10.N;
        n13 = f10.l;
        ((TXCAudioEngine)object).setRemotePlayoutVolume(string4, n13);
        object = TXCAudioEngine.getInstance();
        string4 = f10.N;
        ((TXCAudioEngine)object).setRemoteAudioStreamEventListener(string4, f10);
        this.y();
        object = TXCAudioEngine.getInstance();
        string4 = f10.N;
        ((TXCAudioEngine)object).startRemoteAudio(string4, n10 != 0);
    }

    private void o() {
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        String string2 = this.N;
        tXCAudioEngine.setRemoteAudioStreamEventListener(string2, null);
        tXCAudioEngine = TXCAudioEngine.getInstance();
        string2 = this.N;
        tXCAudioEngine.setSetAudioEngineRemoteStreamDataListener(string2, null);
        tXCAudioEngine = TXCAudioEngine.getInstance();
        string2 = this.N;
        tXCAudioEngine.stopRemoteAudio(string2);
    }

    private void p() {
        TXCStreamDownloader tXCStreamDownloader = this.g;
        if (tXCStreamDownloader != null) {
            tXCStreamDownloader.setListener(null);
            this.g.setNotifyListener(null);
            tXCStreamDownloader = this.g;
            tXCStreamDownloader.stop();
            this.g = null;
        }
    }

    /*
     * WARNING - void declaration
     */
    private void r() {
        void var3_6;
        com.tencent.liteav.e e10;
        Object object = this.c;
        this.z = e10 = new com.tencent.liteav.e((Context)object);
        object = this.G;
        e10.a((String)object);
        e10 = this.z;
        int bl2 = this.H;
        int n10 = 5;
        if (bl2 == n10) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        e10.a((boolean)var3_6);
        e10 = this.z;
        object = this.N;
        e10.d((String)object);
        e10 = this.z;
        object = this.g.getRTMPProxyUserId();
        e10.e((String)object);
        this.z.a();
    }

    private void s() {
        com.tencent.liteav.e e10 = this.z;
        if (e10 != null) {
            e10.c();
            e10 = null;
            this.z = null;
        }
    }

    private void t() {
        this.O = false;
        this.y();
    }

    private void u() {
        int n10;
        Bundle bundle;
        long l10 = this.P;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        long l13 = 1000L;
        if (l12 > 0) {
            bundle = new Bundle();
            n10 = (int)(this.P / l13);
            bundle.putInt("EVT_PLAY_PROGRESS", n10);
            long l14 = this.P;
            n10 = (int)l14;
            String string2 = "EVT_PLAY_PROGRESS_MS";
            bundle.putInt(string2, n10);
            n10 = 2005;
            this.onNotifyEvent(n10, bundle);
        }
        if ((bundle = this.h) != null && (n10 = this.O) != 0) {
            f$4 f$4 = new f$4(this);
            bundle.postDelayed((Runnable)f$4, l13);
        }
    }

    private void v() {
        Handler handler = this.h;
        if (handler != null) {
            f$a f$a = this.R;
            long l10 = 2000L;
            handler.postDelayed((Runnable)f$a, l10);
        }
    }

    private void w() {
        Handler handler = this.h;
        if (handler != null) {
            f$a f$a = this.R;
            handler.removeCallbacks((Runnable)f$a);
        }
    }

    private void x() {
        ArrayList<String> arrayList = new ArrayList<String>();
        String string2 = this.N;
        if (string2 != null) {
            arrayList.add(string2);
        }
        com.tencent.liteav.a.a("18446744073709551615", arrayList);
    }

    private void y() {
        String string2;
        Object object;
        boolean bl2 = this.t;
        if (bl2 || (object = this.M) != null || (bl2 = this.O)) {
            object = TXCAudioEngine.getInstance();
            string2 = this.N;
            ((TXCAudioEngine)object).setSetAudioEngineRemoteStreamDataListener(string2, this);
        }
        if (!(bl2 = this.t) && (object = this.M) == null && !(bl2 = this.O)) {
            object = TXCAudioEngine.getInstance();
            string2 = this.N;
            ((TXCAudioEngine)object).setSetAudioEngineRemoteStreamDataListener(string2, null);
        }
    }

    public int a(int n10, float[] object) {
        boolean bl2;
        com.tencent.liteav.renderer.h h10;
        object = this.x;
        boolean bl3 = this.t;
        if (bl3 && object != null && (h10 = this.C) != null) {
            int n11 = h10.d(n10);
            long l10 = TXCTimeUtil.getTimeTick();
            ((a)object).a(n11, l10);
            com.tencent.liteav.renderer.a a10 = this.f;
            int n12 = this.A;
            int n13 = this.B;
            a10.a(n11, n12, n13, false, 0);
        }
        if (bl2 = this.t) {
            this.j();
        } else {
            this.k();
        }
        return n10;
    }

    public int a(String string2) {
        TXCStreamDownloader tXCStreamDownloader;
        boolean bl2 = this.c();
        if (bl2 && (tXCStreamDownloader = this.g) != null) {
            bl2 = tXCStreamDownloader.switchStream(string2);
            long l10 = 0L;
            String string3 = this.N;
            int n10 = 2007;
            int n11 = TXCStatus.c(string3, n10);
            long l11 = n11;
            Object object = this.a;
            if (object != null) {
                l10 = ((TXCRenderAndDec)object).getVideoCacheDuration();
            }
            object = new StringBuilder();
            String string4 = "[SwitchStream] current jitter size when start switch stream. video:";
            ((StringBuilder)object).append(string4);
            ((StringBuilder)object).append(l10);
            ((StringBuilder)object).append(" audio:");
            ((StringBuilder)object).append(l11);
            String string5 = ((StringBuilder)object).toString();
            String string6 = "TXCLivePlayer";
            TXCLog.i(string6, string5);
            if (bl2) {
                this.G = string2;
                return 0;
            }
            return -2;
        }
        return -1;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public int a(String charSequence, int n10) {
        int n11;
        block12: {
            com.tencent.liteav.renderer.a a10;
            TextureView textureView;
            String string2;
            float f10;
            float f11;
            float f12;
            float f13;
            float f14;
            float f15;
            int n12 = this.c();
            String string3 = "TXCLivePlayer";
            if (n12 != 0) {
                TXCLog.w(string3, "play: ignore start play when is playing");
                return -2;
            }
            com.tencent.liteav.h h10 = this.b;
            if (h10 != null && (f15 = (f14 = (f13 = h10.c) - (f12 = h10.b)) == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1)) > 0) {
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("play: can not start play while invalid cache config [minAutoAdjustCacheTime(");
                float f16 = this.b.c;
                ((StringBuilder)charSequence).append(f16);
                ((StringBuilder)charSequence).append(") > maxAutoAdjustCacheTime(");
                f16 = this.b.b;
                ((StringBuilder)charSequence).append(f16);
                ((StringBuilder)charSequence).append(")]!!!!!!");
                charSequence = ((StringBuilder)charSequence).toString();
                TXCLog.e(string3, (String)charSequence);
                return -1;
            }
            f13 = h10.a;
            f12 = h10.b;
            float f17 = f13 - f12;
            Object object = f17 == 0.0f ? 0 : (f17 > 0.0f ? 1 : -1);
            if (object > 0 || (n12 = (f11 = f13 - (f10 = h10.c)) == 0.0f ? 0 : (f11 < 0.0f ? -1 : 1)) < 0) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("play: invalid cacheTime ");
                f13 = this.b.a;
                stringBuilder.append(f13);
                stringBuilder.append(", need between minAutoAdjustCacheTime ");
                f13 = this.b.c;
                stringBuilder.append(f13);
                stringBuilder.append(" and maxAutoAdjustCacheTime ");
                f13 = this.b.b;
                stringBuilder.append(f13);
                string2 = " , fix to maxAutoAdjustCacheTime";
                stringBuilder.append(string2);
                String string4 = stringBuilder.toString();
                TXCLog.w(string3, string4);
                com.tencent.liteav.h h11 = this.b;
                h11.a = f13 = h11.b;
            }
            StringBuilder stringBuilder = new StringBuilder();
            string2 = "[FirstFramePath] TXCLivePlayer: start play. instance: ";
            stringBuilder.append(string2);
            f15 = this.hashCode();
            stringBuilder.append((int)f15);
            String string5 = stringBuilder.toString();
            TXCLog.i(string3, string5);
            this.G = charSequence;
            this.H = n10;
            this.b((String)charSequence);
            n12 = 1;
            f10 = Float.MIN_VALUE;
            this.o = n12;
            string3 = null;
            this.w = 0;
            this.u = n12;
            this.f(n10);
            this.n();
            n11 = this.c((String)charSequence, n10);
            if (n11 != 0) {
                this.o = false;
                this.p();
                this.m();
                this.o();
                TextureView textureView2 = this.i;
                if (textureView2 == null) return n11;
                n12 = 8;
                f10 = 1.1E-44f;
                textureView2.setVisibility(n12);
                return n11;
            }
            Surface surface = this.p;
            this.a(surface);
            this.r();
            this.v();
            com.tencent.liteav.basic.a.b b10 = this.J;
            com.tencent.liteav.basic.a.b b11 = com.tencent.liteav.basic.a.b.c;
            if (b10 == b11 && (textureView = this.i) == null && (a10 = this.f) != null) {
                Object object2 = this.K;
                a10.c(object2);
            }
            Context context = this.c;
            n12 = com.tencent.liteav.basic.datareport.a.bu;
            TXCDRApi.txReportDAU(context, n12);
            String string6 = "com.tencent.liteav.demo.play.SuperPlayerView";
            try {
                Class<?> clazz = Class.forName(string6);
                if (clazz == null) break block12;
            }
            catch (Exception exception) {
                return n11;
            }
            Context context2 = this.c;
            n12 = com.tencent.liteav.basic.datareport.a.bF;
            TXCDRApi.txReportDAU(context2, n12);
        }
        return n11;
    }

    public int a(boolean bl2) {
        com.tencent.liteav.renderer.a a10;
        boolean bl3 = this.c();
        String string2 = "TXCLivePlayer";
        if (!bl3) {
            TXCLog.w(string2, "play: ignore stop play when not started");
            return -2;
        }
        TXCLog.v(string2, "play: stop");
        bl3 = false;
        this.o = false;
        this.p();
        this.m();
        string2 = this.i;
        if (string2 != null && bl2) {
            int n10 = 8;
            string2.setVisibility(n10);
        }
        if ((a10 = this.f) != null) {
            string2 = null;
            a10.a((Surface)null);
        }
        if ((a10 = this.i) == null && (a10 = this.f) != null) {
            a10.d();
        }
        this.o();
        this.s();
        this.w();
        this.t();
        return 0;
    }

    public void a() {
        this.a(false);
    }

    public void a(int n10) {
        this.n = n10;
        TXCRenderAndDec tXCRenderAndDec = this.a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setRenderMode(n10);
        }
    }

    public void a(int n10, int n11) {
        com.tencent.liteav.renderer.a a10 = this.f;
        if (a10 != null) {
            a10.d(n10, n11);
        }
    }

    public void a(SurfaceTexture surfaceTexture) {
        this.k();
        this.e();
    }

    public void a(Surface surface) {
        this.p = surface;
        com.tencent.liteav.renderer.a a10 = this.f;
        if (a10 != null) {
            a10.a(surface);
        }
    }

    public void a(o o10) {
        com.tencent.liteav.renderer.a a10 = this.f;
        if (a10 != null) {
            a10.a(o10);
        }
    }

    public void a(com.tencent.liteav.h h10) {
        super.a(h10);
        TXCRenderAndDec tXCRenderAndDec = this.a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setConfig(h10);
        }
    }

    public void a(r object, com.tencent.liteav.basic.a.b object2, Object object3) {
        Object object4;
        this.J = object2;
        this.K = object3;
        boolean bl2 = this.c();
        if (bl2 && (object3 = this.J) == (object4 = com.tencent.liteav.basic.a.b.c) && (object3 = this.i) == null && object != null && (object3 = this.f) != null) {
            object4 = this.K;
            ((com.tencent.liteav.renderer.a)object3).c(object4);
        }
        if ((object3 = this.a) != null) {
            ((TXCRenderAndDec)object3).setVideoFrameListener((r)object, (com.tencent.liteav.basic.a.b)((Object)object2));
        } else {
            object = "TXCLivePlayer";
            object2 = "setVideoFrameListener->enter with renderAndDec is empty";
            TXCLog.w((String)object, (String)object2);
        }
    }

    public void a(TXLivePlayer$ITXAudioRawDataListener tXLivePlayer$ITXAudioRawDataListener) {
        this.M = tXLivePlayer$ITXAudioRawDataListener;
        this.y();
    }

    public void a(TXCloudVideoView object) {
        TXCloudVideoView tXCloudVideoView = this.d;
        if (tXCloudVideoView != null && tXCloudVideoView != object && (tXCloudVideoView = tXCloudVideoView.getVideoView()) != null) {
            TXCloudVideoView tXCloudVideoView2 = this.d;
            tXCloudVideoView2.removeView((View)tXCloudVideoView);
        }
        super.a((TXCloudVideoView)((Object)object));
        object = this.d;
        if (object != null) {
            object = ((TXCloudVideoView)((Object)object)).getVideoView();
            this.i = object;
            if (object == null) {
                tXCloudVideoView = this.d.getContext();
                object = new TextureView((Context)tXCloudVideoView);
                this.i = object;
            }
            object = this.d;
            tXCloudVideoView = this.i;
            ((TXCloudVideoView)((Object)object)).addVideoView((TextureView)tXCloudVideoView);
        }
        if ((object = this.f) != null) {
            tXCloudVideoView = this.i;
            ((e)object).a((TextureView)tXCloudVideoView);
        }
    }

    public void a(TXRecordCommon$ITXVideoRecordListener tXRecordCommon$ITXVideoRecordListener) {
        this.y = tXRecordCommon$ITXVideoRecordListener;
    }

    public void a(String string2, int n10, String string3) {
        this.onNotifyEvent(n10, null);
    }

    public void a(String object, byte[] byArray, long l10, int n10, int n11) {
        long l11;
        long l12;
        long l13;
        long l14;
        Object object2;
        this.r = n10;
        this.q = n11;
        object = this.x;
        long l15 = 0L;
        if (object != null) {
            object2 = l10 == l15 ? 0 : (l10 < l15 ? -1 : 1);
            if (object2 <= 0) {
                l10 = TXCTimeUtil.getTimeTick();
            }
            object = this.x;
            ((a)object).a(byArray, l10);
        }
        if ((object2 = (l14 = (l13 = this.Q) - l15) == 0L ? 0 : (l14 < 0L ? -1 : 1)) <= 0 && (object = this.M) != null) {
            int n12 = 16;
            object.onAudioInfoChanged(n10, n11, n12);
        }
        if ((object = this.M) != null) {
            object.onPcmDataAvailable(byArray, l10);
        }
        if ((n10 = (int)((l12 = (l11 = this.Q) - l15) == 0L ? 0 : (l12 < 0L ? -1 : 1))) <= 0) {
            this.Q = l10;
            return;
        }
        this.P = l10 -= l11;
    }

    public void a(boolean bl2, int n10) {
        this.I = bl2;
        TXCAudioEngine.getInstance();
        TXCAudioEngine.enableAudioVolumeEvaluation(bl2, n10);
    }

    public void b() {
        String string2 = this.G;
        int n10 = this.H;
        this.a(string2, n10);
    }

    public void b(int n10) {
        this.m = n10;
        TXCRenderAndDec tXCRenderAndDec = this.a;
        if (tXCRenderAndDec != null) {
            tXCRenderAndDec.setRenderRotation(n10);
        }
    }

    public void b(String object, int n10) {
        boolean bl2 = this.o;
        if (bl2 && (object = this.g) != null) {
            String string2 = this.G;
            ((TXCStreamDownloader)object).requestKeyFrame(string2);
        }
    }

    public void b(boolean bl2) {
        this.j = bl2;
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        String string2 = this.N;
        boolean bl3 = this.j;
        tXCAudioEngine.muteRemoteAudio(string2, bl3);
    }

    public void c(int n10) {
        this.l = n10;
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        String string2 = this.N;
        int n11 = this.l;
        tXCAudioEngine.setRemotePlayoutVolume(string2, n11);
    }

    public void c(boolean bl2) {
        this.k = bl2;
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        String string2 = this.N;
        tXCAudioEngine.muteRemoteAudioInSpeaker(string2, bl2);
    }

    public boolean c() {
        return this.o;
    }

    public int d(int n10) {
        n10 = (int)(this.t ? 1 : 0);
        if (n10 != 0) {
            TXCLog.e("TXCLivePlayer", "startRecord: there is existing uncompleted record task");
            return -1;
        }
        this.t = true;
        this.f.a(this);
        this.f.a(this);
        this.y();
        Context context = this.c;
        int n11 = com.tencent.liteav.basic.datareport.a.aw;
        TXCDRApi.txReportDAU(context, n11);
        return 0;
    }

    public TextureView d() {
        return this.i;
    }

    public int e() {
        boolean bl2 = this.t;
        if (!bl2) {
            TXCLog.w("TXCLivePlayer", "stopRecord: no recording task exist");
            return -1;
        }
        bl2 = false;
        this.t = false;
        this.y();
        a a10 = this.x;
        if (a10 != null) {
            a10.a();
            a10 = null;
            this.x = null;
        }
        return 0;
    }

    public boolean f() {
        return true;
    }

    public void g() {
        long l10;
        this.Q = l10 = 0L;
        boolean bl2 = this.O;
        if (bl2) {
            return;
        }
        this.O = bl2 = true;
        this.y();
        Handler handler = this.h;
        if (handler != null) {
            f$3 f$3 = new f$3(this);
            long l11 = 1000L;
            handler.postDelayed((Runnable)f$3, l11);
        }
    }

    public void h() {
        float f10;
        int n10;
        int n11;
        float f11;
        String string2;
        int n12;
        this.x();
        Object object = com.tencent.liteav.basic.util.g.a();
        int n13 = object[0] / 10;
        int n14 = 1;
        int n15 = object[n14] / 10;
        CharSequence charSequence = new StringBuilder();
        charSequence.append(n13);
        charSequence.append("/");
        charSequence.append(n15);
        charSequence.append("%");
        object = charSequence.toString();
        String string3 = this.N;
        n13 = TXCStatus.c(string3, 7102);
        charSequence = this.N;
        int n16 = 7101;
        int n17 = TXCStatus.c((String)charSequence, n16);
        String string4 = TXCStatus.b(this.N, 7110);
        String string5 = this.N;
        int n18 = 6002;
        double d10 = TXCStatus.d(string5, n18);
        int n19 = (int)d10;
        Bundle bundle = new Bundle();
        Object object2 = this.f;
        if (object2 != null) {
            n12 = ((e)object2).h();
            bundle.putInt("VIDEO_WIDTH", n12);
            object2 = this.f;
            n12 = ((e)object2).i();
            string2 = "VIDEO_HEIGHT";
            bundle.putInt(string2, n12);
        }
        if ((object2 = this.a) != null) {
            n12 = (int)((TXCRenderAndDec)object2).getVideoCacheDuration();
            bundle.putInt("VIDEO_CACHE", n12);
            n12 = (int)this.a.getVideoCacheFrameCount();
            bundle.putInt("V_SUM_CACHE_SIZE", n12);
            n12 = this.a.getVideoDecCacheFrameCount();
            bundle.putInt("V_DEC_CACHE_SIZE", n12);
            n12 = (int)this.a.getAVPlayInterval();
            bundle.putInt("AV_PLAY_INTERVAL", n12);
            object2 = this.a;
            long l10 = ((TXCRenderAndDec)object2).getAVNetRecvInterval();
            n12 = (int)l10;
            string2 = "AV_RECV_INTERVAL";
            bundle.putInt(string2, n12);
            if (n19 == 0) {
                n12 = 15;
                f11 = 2.1E-44f;
            } else {
                n12 = n19;
            }
            string2 = this.N;
            n11 = 7120;
            f11 = TXCStatus.c(string2, n11) * 10 / n12;
            n10 = 1092616192;
            f10 = 10.0f;
            double d11 = f11 /= f10;
            double d12 = 0.5;
            n12 = (int)(d11 += d12);
            string2 = "VIDEO_GOP";
            bundle.putInt(string2, n12);
        }
        n12 = TXCAudioEngine.getInstance().getPlayAECType();
        n10 = TXCStatus.c(this.N, 2019);
        String string6 = this.N;
        n11 = TXCStatus.c(string6, 2020);
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        int n20 = tXCAudioEngine.getPlaySampleRate();
        TXCAudioEngine tXCAudioEngine2 = TXCAudioEngine.getInstance();
        int n21 = tXCAudioEngine2.getPlayChannels();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(n12);
        object2 = " | ";
        stringBuilder.append((String)object2);
        stringBuilder.append(n10);
        string2 = ",";
        stringBuilder.append(string2);
        stringBuilder.append(n11);
        stringBuilder.append((String)object2);
        stringBuilder.append(n20);
        stringBuilder.append(string2);
        stringBuilder.append(n21);
        object2 = stringBuilder.toString();
        bundle.putString("AUDIO_PLAY_INFO", (String)object2);
        n12 = TXCStatus.c(this.N, 2007);
        bundle.putInt("AUDIO_CACHE", n12);
        n12 = TXCStatus.c(this.N, 2018);
        bundle.putInt("NET_JITTER", n12);
        f11 = TXCStatus.c(this.N, 2021);
        n10 = 1148846080;
        f10 = 1000.0f;
        bundle.putFloat("AUDIO_CACHE_THRESHOLD", f11 /= f10);
        n12 = n17 + n13;
        string2 = "NET_SPEED";
        bundle.putInt(string2, n12);
        object2 = "VIDEO_FPS";
        bundle.putInt((String)object2, n19);
        string5 = "VIDEO_BITRATE";
        bundle.putInt(string5, n17);
        charSequence = "AUDIO_BITRATE";
        bundle.putInt((String)charSequence, n13);
        bundle.putCharSequence("SERVER_IP", (CharSequence)string4);
        string3 = "CPU_USAGE";
        bundle.putCharSequence(string3, (CharSequence)object);
        this.w = n15 = this.w + n14;
        n13 = 5;
        if (n15 == n13) {
            n15 = (int)(this.v ? 1 : 0);
            n13 = 9009;
            if (n15 != 0) {
                object = this.N;
                long l11 = 0L;
                Long l12 = l11;
                TXCStatus.a((String)object, n13, l12);
            } else {
                object = this.N;
                long l13 = 1L;
                Long l14 = l13;
                TXCStatus.a((String)object, n13, l14);
            }
        }
        object = this.e;
        n13 = 15001;
        com.tencent.liteav.basic.util.g.a((WeakReference)object, n13, bundle);
        object = this.a;
        if (object != null) {
            ((TXCRenderAndDec)object).updateLoadInfo();
        }
        if ((object = this.z) != null) {
            ((com.tencent.liteav.e)object).f();
        }
    }

    public int i() {
        TXCAudioEngine tXCAudioEngine = TXCAudioEngine.getInstance();
        String string2 = this.N;
        return tXCAudioEngine.getRemotePlayoutVolumeLevel(string2);
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        Long l10;
        boolean bl2;
        int n11 = 2003;
        if (n11 == n10 && !(bl2 = this.v)) {
            this.v = bl2 = true;
        }
        Object object = "Video play started";
        int n12 = 2004;
        int n13 = 2026;
        if (n11 == n10 || n13 == n10) {
            n11 = (int)(this.u ? 1 : 0);
            if (n11 != 0) {
                this.a(n12, (String)object);
                n11 = 0;
                l10 = null;
                this.u = false;
            }
            if (n13 == n10) {
                String string2 = this.N;
                l10 = TXCTimeUtil.getTimeTick();
                TXCStatus.a(string2, 2033, l10);
                return;
            }
        }
        if ((n11 = 2025) == n10) {
            this.a(n12, (String)object);
            return;
        }
        n11 = 2023;
        if (n11 != n10 && (n11 = 2024) != n10) {
            l10 = this.h;
            if (l10 != null) {
                object = new f$6(this, n10, bundle);
                l10.post((Runnable)object);
            }
            return;
        }
        this.a(2007, "Video play loading");
    }

    public void onPullAudio(com.tencent.liteav.basic.structs.a a10) {
    }

    public void onPullNAL(TXSNALPacket tXSNALPacket) {
        block4: {
            boolean bl2 = this.o;
            if (!bl2) {
                return;
            }
            Object object = this.a;
            if (object == null) break block4;
            try {
                ((TXCRenderAndDec)object).decVideo(tXSNALPacket);
            }
            catch (Exception exception) {
                object = new StringBuilder();
                String string2 = "decode video failed.";
                ((StringBuilder)object).append(string2);
                String string3 = exception.getMessage();
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                object = "TXCLivePlayer";
                TXCLog.e((String)object, string3);
            }
        }
    }

    public void onTextureProcess(int n10, int n11, int n12, int n13) {
        Object object;
        Object object2 = this.x;
        n12 = (int)(this.t ? 1 : 0);
        if (n12 != 0 && object2 != null && (object = this.D) != null) {
            float[] fArray = this.E;
            ((com.tencent.liteav.renderer.h)object).a(fArray);
            n12 = this.D.d(n10);
            long l10 = TXCTimeUtil.getTimeTick();
            ((a)object2).a(n12, l10);
            object2 = this.D;
            object = this.F;
            ((com.tencent.liteav.renderer.h)object2).a((float[])object);
            object2 = this.D;
            ((com.tencent.liteav.renderer.h)object2).c(n10);
        }
        if ((n10 = (int)(this.t ? 1 : 0)) != 0) {
            this.j();
        } else {
            this.k();
        }
    }
}

