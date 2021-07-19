/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.SurfaceTexture
 *  android.media.MediaFormat
 *  android.opengl.GLES20
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.os.Looper
 *  android.view.Surface
 */
package com.tencent.liteav;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.media.MediaFormat;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.b$b;
import com.tencent.liteav.basic.c.c;
import com.tencent.liteav.basic.datareport.TXCDRApi;
import com.tencent.liteav.basic.datareport.a;
import com.tencent.liteav.basic.license.e;
import com.tencent.liteav.basic.license.g;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCEventRecorderProxy;
import com.tencent.liteav.basic.module.TXCKeyPointReportProxy;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.opengl.TXCOpenGlUtils;
import com.tencent.liteav.basic.opengl.m;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.liteav.basic.structs.TXSVideoFrame;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.f;
import com.tencent.liteav.beauty.TXBeautyManager;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.beauty.b.o;
import com.tencent.liteav.beauty.d$d;
import com.tencent.liteav.d$1;
import com.tencent.liteav.d$10;
import com.tencent.liteav.d$11;
import com.tencent.liteav.d$12;
import com.tencent.liteav.d$13;
import com.tencent.liteav.d$14;
import com.tencent.liteav.d$15;
import com.tencent.liteav.d$16;
import com.tencent.liteav.d$2;
import com.tencent.liteav.d$3;
import com.tencent.liteav.d$4;
import com.tencent.liteav.d$5;
import com.tencent.liteav.d$6;
import com.tencent.liteav.d$7;
import com.tencent.liteav.d$8;
import com.tencent.liteav.d$9;
import com.tencent.liteav.d$a;
import com.tencent.liteav.i;
import com.tencent.liteav.n;
import com.tencent.liteav.p;
import com.tencent.liteav.r;
import com.tencent.liteav.renderer.TXCGLSurfaceView;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import com.tencent.liteav.screencapture.a$a;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.b;
import com.tencent.rtmp.TXLog;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;

public class d
extends com.tencent.liteav.basic.module.a
implements b$b,
com.tencent.liteav.basic.b.b,
com.tencent.liteav.beauty.f,
com.tencent.liteav.o,
com.tencent.liteav.videoencoder.d {
    private Surface A;
    private int B;
    private int C;
    private com.tencent.liteav.basic.opengl.f D;
    private com.tencent.liteav.basic.structs.b E;
    private int F;
    private boolean G;
    private boolean H;
    private long I;
    private long J;
    private int K;
    private WeakReference L;
    private boolean M;
    private WeakReference N;
    private com.tencent.liteav.basic.opengl.i O;
    private com.tencent.liteav.basic.opengl.i P;
    private com.tencent.liteav.basic.opengl.i Q;
    private k R;
    private int S;
    private boolean T;
    private boolean U;
    private boolean V;
    private final com.tencent.liteav.beauty.b W;
    private boolean X;
    private WeakReference Y;
    private com.tencent.liteav.basic.opengl.e Z;
    public com.tencent.liteav.b a;
    private WeakReference aa;
    private int ab;
    private int ac;
    public com.tencent.liteav.b b;
    private final com.tencent.liteav.basic.util.c c;
    private final f d;
    private n e;
    private com.tencent.liteav.beauty.d f;
    private boolean g;
    private boolean h;
    private TXSVideoEncoderParam i;
    private b j;
    private int k;
    private boolean l;
    private TXSVideoEncoderParam m;
    private b n;
    private final Object o;
    private Context p;
    private com.tencent.liteav.g q;
    private int r;
    private int s;
    private int t;
    private boolean u;
    private int v;
    private int w;
    private boolean x;
    private TXCloudVideoView y;
    private final Object z;

    public d(Context object) {
        boolean bl2;
        long l10;
        Object object2;
        long l11 = TimeUnit.SECONDS.toMillis(5);
        int n10 = (int)l11;
        Object object3 = new com.tencent.liteav.basic.util.c("capturer", n10);
        this.c = object3;
        Object object4 = Looper.getMainLooper();
        super((Looper)object4);
        this.d = object3;
        object3 = null;
        this.e = null;
        this.f = null;
        this.g = false;
        this.h = false;
        this.i = null;
        this.j = null;
        this.k = 15;
        this.l = false;
        this.m = null;
        this.n = null;
        this.o = object2 = new Object();
        this.p = null;
        this.q = null;
        this.r = 0;
        this.s = 0;
        this.t = 0;
        this.u = false;
        this.v = 0;
        this.w = 0;
        this.x = false;
        this.y = null;
        this.z = object2 = new Object();
        this.A = null;
        this.B = 0;
        this.C = 0;
        this.D = null;
        this.F = 0;
        this.G = false;
        this.H = false;
        this.I = l10 = 0L;
        this.J = l10;
        this.K = 2;
        this.M = false;
        this.N = null;
        this.O = null;
        this.S = -1;
        this.T = false;
        this.U = false;
        this.V = false;
        this.X = bl2 = true;
        this.Z = null;
        this.ab = 0;
        this.ac = 0;
        object = object.getApplicationContext();
        this.p = object;
        super();
        this.q = object;
        object4 = this.p;
        super((Context)object4, bl2);
        this.f = object;
        ((com.tencent.liteav.beauty.d)object).a(this);
        this.f.a(this);
        object = this.q;
        n10 = (int)(((com.tencent.liteav.g)object).U ? 1 : 0);
        if (n10 != 0) {
            object = this.f;
            object4 = d$d.a;
            ((com.tencent.liteav.beauty.d)object).a((d$d)((Object)object4));
        } else {
            boolean bl3 = ((com.tencent.liteav.g)object).T;
            if (bl3) {
                object = this.f;
                object4 = d$d.b;
                ((com.tencent.liteav.beauty.d)object).a((d$d)((Object)object4));
            } else {
                object = this.f;
                object4 = d$d.c;
                ((com.tencent.liteav.beauty.d)object).a((d$d)((Object)object4));
            }
        }
        this.i = object = new TXSVideoEncoderParam();
        ((TXSVideoEncoderParam)object).encoderMode = (int)(bl2 ? 1 : 0);
        this.j = null;
        this.m = object = new TXSVideoEncoderParam();
        ((TXSVideoEncoderParam)object).encoderMode = (int)(bl2 ? 1 : 0);
        this.a = object = new com.tencent.liteav.b(this);
        object3 = this.p;
        object = new g((Context)object3);
        super((e)object);
        this.W = object3;
        object = this.f;
        ((com.tencent.liteav.beauty.b)object3).setPreprocessor((com.tencent.liteav.beauty.d)object);
        object = com.tencent.liteav.basic.c.c.a();
        object3 = this.p;
        ((c)object).a((Context)object3);
    }

    private int a(int n10, int n11, Object object) {
        int n12;
        com.tencent.liteav.g g10 = this.q;
        n11 = g10.a;
        int n13 = g10.b;
        int n14 = g10.l;
        if (n14 == 0 || n14 == (n12 = 2)) {
            int n15 = n13;
            n13 = n11;
            n11 = n15;
        }
        if (n11 > 0 && n13 > 0) {
            n10 = (int)(g10.M ? 1 : 0);
            if (n10 != 0) {
                this.u();
                return -1000;
            }
            this.b(n11, n13, object);
            return 0;
        }
        TXCLog.e("TXCCaptureAndEnc", "sendCustomYUVData: invalid video encode resolution");
        return -1;
    }

    public static /* synthetic */ int a(d d10, int n10) {
        d10.B = n10;
        return n10;
    }

    public static /* synthetic */ b a(d d10) {
        return d10.j;
    }

    private void a(int n10, int n11, int n12, long l10) {
        int n13;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = TXCTimeUtil.generatePtsMS();
        }
        Object object2 = this.f.a();
        this.b(n11, n12, object2);
        object2 = this.j;
        if (object2 != null) {
            n13 = this.X;
            ((b)object2).b(n13 != 0);
            n13 = n10;
            ((b)object2).a(n10, n11, n12, l10);
        }
        if ((object2 = this.n) != null) {
            n13 = (int)(this.X ? 1 : 0);
            ((b)object2).b(n13 != 0);
            n13 = n10;
            ((b)object2).a(n10, n11, n12, l10);
        }
    }

    private void a(int n10, int n11, int n12, Object object, int n13, boolean bl2) {
        Object object2;
        long l10;
        long l11;
        d d10 = this;
        int n14 = n10;
        int n15 = n11;
        int n16 = n12;
        Object object3 = object;
        Object object4 = new StringBuilder();
        ((StringBuilder)object4).append("New encode size width = ");
        ((StringBuilder)object4).append(n10);
        ((StringBuilder)object4).append(" height = ");
        ((StringBuilder)object4).append(n11);
        ((StringBuilder)object4).append(" encType = ");
        ((StringBuilder)object4).append(n12);
        ((StringBuilder)object4).append(" eglContext: ");
        ((StringBuilder)object4).append(object);
        object4 = ((StringBuilder)object4).toString();
        TXCLog.i("TXCCaptureAndEnc", (String)object4);
        this.u();
        object4 = new b(n12);
        Object object5 = this.getID();
        int n17 = this.F;
        Integer n18 = n12;
        int n19 = 4005;
        TXCStatus.a((String)object5, n19, n17, n18);
        int n20 = 1;
        if (n12 == n20) {
            String string2 = this.getID();
            int n21 = 4004;
            l11 = 1L;
            long l12 = -1;
            int n22 = this.F;
            String string3 = "";
            TXCEventRecorderProxy.a(string2, n21, l11, l12, string3, n22);
        } else {
            String string4 = this.getID();
            int n23 = 4004;
            long l13 = 0L;
            long l14 = -1;
            n20 = this.F;
            String string5 = "";
            TXCEventRecorderProxy.a(string4, n23, l13, l14, string5, n20);
        }
        n20 = 0;
        d10.U = false;
        object5 = d10.i;
        ((TXSVideoEncoderParam)object5).encodeType = n16;
        ((TXSVideoEncoderParam)object5).width = n14;
        ((TXSVideoEncoderParam)object5).height = n15;
        n16 = n13;
        ((TXSVideoEncoderParam)object5).fps = n13;
        com.tencent.liteav.g g10 = d10.q;
        ((TXSVideoEncoderParam)object5).gop = n17 = g10.i;
        ((TXSVideoEncoderParam)object5).encoderProfile = n16 = g10.n;
        Object object6 = object3 != null ? object3 : ((b)object4).a(n14, n15);
        ((TXSVideoEncoderParam)object5).glContext = object6;
        object6 = d10.i;
        n15 = (int)(bl2 ? 1 : 0);
        ((TXSVideoEncoderParam)object6).realTime = bl2;
        ((TXSVideoEncoderParam)object6).streamType = n15 = d10.F;
        n15 = (int)(d10.H ? 1 : 0);
        ((TXSVideoEncoderParam)object6).annexb = n15;
        n15 = (int)(d10.G ? 1 : 0);
        ((TXSVideoEncoderParam)object6).bMultiRef = n15;
        ((TXSVideoEncoderParam)object6).baseFrameIndex = l10 = d10.I + (long)20;
        l10 = d10.J;
        long l15 = 1L;
        ((TXSVideoEncoderParam)object6).baseGopIndex = l10 = (l10 + l15) % 255L + l15;
        n15 = (int)(d10.h ? 1 : 0);
        ((TXSVideoEncoderParam)object6).bLimitFps = n15;
        n15 = (int)(d10.V ? 1 : 0);
        ((TXSVideoEncoderParam)object6).record = n15;
        ((TXSVideoEncoderParam)object6).encFmt = object2 = d10.q.Y;
        ((b)object4).a(d10);
        ((b)object4).a(d10);
        object6 = d10.i;
        ((b)object4).a((TXSVideoEncoderParam)object6);
        n14 = d10.q.c;
        ((b)object4).b(n14);
        n14 = d10.k;
        ((b)object4).c(n14);
        object6 = this.getID();
        ((b)object4).setID((String)object6);
        n14 = d10.ab;
        ((b)object4).a(n14);
        d10.j = object4;
        object6 = this.getID();
        n16 = d10.F;
        object3 = d10.i;
        int n24 = ((TXSVideoEncoderParam)object3).width << 16;
        object3 = ((TXSVideoEncoderParam)object3).height | n24;
        TXCStatus.a((String)object6, 4003, n16, object3);
        object6 = this.getID();
        n16 = d10.F;
        object3 = d10.i.gop * 1000;
        TXCStatus.a((String)object6, 13003, n16, object3);
        object4 = this.getID();
        object6 = d10.i;
        long l16 = ((TXSVideoEncoderParam)object6).width;
        l11 = ((TXSVideoEncoderParam)object6).height;
        int n25 = d10.F;
        TXCEventRecorderProxy.a((String)object4, 4003, l16, l11, "", n25);
        n15 = d10.i.encodeType;
        n16 = d10.F;
        TXCKeyPointReportProxy.a(40036, n15, n16);
        object2 = d10.i;
        n16 = object2.width << 16;
        n15 = object2.height | n16;
        n16 = d10.F;
        TXCKeyPointReportProxy.a(40037, n15, n16);
    }

    private void a(int n10, String string2) {
        long l10;
        int n11;
        d d10 = this;
        int n12 = n10;
        Object object = string2;
        Bundle bundle = new Bundle();
        String string3 = this.getID();
        String string4 = "EVT_USERID";
        bundle.putString(string4, string3);
        string3 = "EVT_ID";
        bundle.putInt(string3, n10);
        long l11 = TXCTimeUtil.getTimeTick();
        bundle.putLong("EVT_TIME", l11);
        l11 = TXCTimeUtil.getUtcTimeTick();
        Object object2 = "EVT_UTC_TIME";
        bundle.putLong((String)object2, l11);
        if (string2 != null) {
            string3 = "EVT_MSG";
            bundle.putCharSequence(string3, (CharSequence)string2);
        }
        object = d10.aa;
        com.tencent.liteav.basic.util.g.a((WeakReference)object, n12, bundle);
        long l12 = 0L;
        l11 = 1L;
        int n13 = -1314;
        int n14 = -1317;
        if (n12 == n14) {
            String string5 = this.getID();
            int n15 = 2002;
            long l13 = 4;
            long l14 = -1;
            int n16 = d10.F;
            String string6 = "";
            TXCEventRecorderProxy.a(string5, n15, l13, l14, string6, n16);
        } else if (n12 == n13) {
            String string7 = this.getID();
            int n17 = 2002;
            long l15 = 5;
            long l16 = -1;
            n11 = d10.F;
            String string8 = "";
            TXCEventRecorderProxy.a(string7, n17, l15, l16, string8, n11);
        } else {
            n n18;
            n11 = 1003;
            if (n12 == n11 && (n18 = d10.e) != null) {
                String string9 = this.getID();
                int n19 = 4001;
                n18 = d10.e;
                n11 = (int)(n18.g() ? 1 : 0);
                l10 = n11 != 0 ? l12 : l11;
                long l17 = -1;
                n11 = d10.F;
                String string10 = "";
                TXCEventRecorderProxy.a(string9, n19, l10, l17, string10, n11);
            }
        }
        n11 = -1302;
        if (n12 != n11 && n12 != n14 && n12 != (n14 = -1318) && n12 != (n14 = -1319)) {
            n14 = -1301;
            if (n12 == n14 || n12 == n13 || n12 == (n13 = -1315) || n12 == (n13 = -1316)) {
                n13 = 30003;
                TXCKeyPointReportProxy.a(n13, n12);
                object2 = d10.e;
                if (object2 != null) {
                    String string11 = this.getID();
                    n11 = 4002;
                    object2 = d10.e;
                    n13 = (int)(object2.g() ? 1 : 0);
                    long l18 = n13 != 0 ? l12 : l11;
                    l10 = n12;
                    int n20 = d10.F;
                    String string12 = "";
                    TXCEventRecorderProxy.a(string11, n11, l18, l10, string12, n20);
                }
            }
        } else {
            int n21 = 30002;
            TXCKeyPointReportProxy.a(n21, n12);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void a(com.tencent.liteav.basic.structs.b b10, boolean bl2) {
        int n10 = b10.e;
        int n11 = b10.f;
        this.d(n10, n11);
        this.E = b10;
        Object object = this.y;
        if (object != null) {
            n n12 = this.e;
            if (n12 == null) return;
            n12.a(b10);
            return;
        }
        object = this.z;
        synchronized (object) {
            boolean bl3;
            n n13;
            Object object2 = this.A;
            if (object2 != null && (object2 = this.D) == null && (object2 = this.e) != null && (object2 = object2.f()) != null) {
                this.D = object2 = new com.tencent.liteav.basic.opengl.f();
                n13 = this.e;
                n13 = n13.f();
                Surface surface = this.A;
                ((com.tencent.liteav.basic.opengl.f)object2).a(n13, surface);
                object2 = this.D;
                bl3 = this.w;
                ((com.tencent.liteav.basic.opengl.f)object2).a((int)(bl3 ? 1 : 0));
                object2 = this.D;
                bl3 = this.ac;
                ((com.tencent.liteav.basic.opengl.f)object2).b((int)(bl3 ? 1 : 0));
            }
            if ((object2 = this.D) == null) return;
            n13 = this.e;
            if (n13 == null) return;
            boolean bl4 = b10.a;
            int n14 = b10.i;
            int n15 = this.v;
            int n16 = this.B;
            int n17 = this.C;
            int n18 = b10.e;
            int n19 = b10.f;
            boolean bl5 = n13.g();
            bl3 = bl4;
            bl4 = n14 != 0;
            n14 = n15;
            n15 = n16;
            n16 = n17;
            n17 = n18;
            n18 = n19;
            ((com.tencent.liteav.basic.opengl.f)object2).a((int)(bl3 ? 1 : 0), bl4, n14, n15, n16, n17, n19, bl2, bl5);
            return;
        }
    }

    public static /* synthetic */ void a(d d10, int n10, int n11) {
        d10.b(n10, n11);
    }

    public static /* synthetic */ void a(d d10, int n10, int n11, int n12, Object object, int n13, boolean bl2) {
        d10.a(n10, n11, n12, object, n13, bl2);
    }

    public static /* synthetic */ void a(d d10, com.tencent.liteav.basic.structs.b b10, boolean bl2) {
        d10.a(b10, bl2);
    }

    public static /* synthetic */ void a(d d10, Object object, int n10, boolean bl2) {
        d10.a(object, n10, bl2);
    }

    private void a(Object object, int n10, boolean bl2) {
        int n11;
        d d10 = this;
        int n12 = n10;
        this.t();
        b b10 = new b(n10);
        Object object2 = this.getID();
        Object object3 = n10;
        int n13 = 4005;
        int n14 = 3;
        TXCStatus.a((String)object2, n13, n14, object3);
        int n15 = 1;
        if (n10 == n15) {
            String string2 = this.getID();
            int n16 = 4004;
            long l10 = 1L;
            long l11 = -1;
            int n17 = 3;
            String string3 = "";
            TXCEventRecorderProxy.a(string2, n16, l10, l11, string3, n17);
        } else {
            String string4 = this.getID();
            int n18 = 4004;
            long l12 = 0L;
            long l13 = -1;
            int n19 = 3;
            String string5 = "";
            TXCEventRecorderProxy.a(string4, n18, l12, l13, string5, n19);
        }
        object2 = d10.m;
        if (object != null) {
            object3 = object;
        } else {
            n11 = ((TXSVideoEncoderParam)object2).width;
            n13 = ((TXSVideoEncoderParam)object2).height;
            object3 = b10.a(n11, n13);
        }
        ((TXSVideoEncoderParam)object2).glContext = object3;
        object2 = d10.m;
        ((TXSVideoEncoderParam)object2).encodeType = n12;
        n12 = (int)(bl2 ? 1 : 0);
        ((TXSVideoEncoderParam)object2).realTime = bl2;
        TXCLog.i("TXCCaptureAndEnc", "start small video encoder");
        b10.a(d10);
        b10.a(d10);
        Object object4 = d10.m;
        b10.a((TXSVideoEncoderParam)object4);
        n12 = d10.m.bitrate;
        b10.b(n12);
        object4 = this.getID();
        b10.setID((String)object4);
        n12 = d10.ab;
        b10.a(n12);
        d10.n = b10;
        object4 = this.getID();
        object2 = d10.m;
        n11 = ((TXSVideoEncoderParam)object2).width << 16;
        object2 = ((TXSVideoEncoderParam)object2).height | n11;
        TXCStatus.a((String)object4, 4003, n14, object2);
        object4 = this.getID();
        object2 = d10.m.gop * 1000;
        TXCStatus.a((String)object4, 13003, n14, object2);
    }

    private void a(Runnable runnable) {
        Looper looper;
        Object object = Looper.myLooper();
        if (object != (looper = Looper.getMainLooper())) {
            object = this.d;
            ((f)((Object)object)).a(runnable);
        } else {
            runnable.run();
        }
    }

    public static /* synthetic */ int b(d d10, int n10) {
        d10.C = n10;
        return n10;
    }

    public static /* synthetic */ b b(d d10) {
        return d10.n;
    }

    private void b(int n10, int n11) {
        com.tencent.liteav.g g10 = this.q;
        float f10 = g10.J;
        float f11 = -1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object != false) {
            com.tencent.liteav.beauty.d d10 = this.f;
            if (d10 != null) {
                Bitmap bitmap = g10.E;
                f11 = g10.H;
                float f13 = g10.I;
                d10.a(bitmap, f11, f13, f10);
            }
        } else {
            com.tencent.liteav.beauty.d d11 = this.f;
            if (d11 != null && n10 != 0 && n11 != 0) {
                Bitmap bitmap = g10.E;
                int n12 = g10.F;
                float f14 = n12;
                float f15 = n10;
                f14 /= f15;
                int n13 = g10.G;
                float f16 = n13;
                float f17 = n11;
                f16 /= f17;
                if (bitmap == null) {
                    n10 = 0;
                    f15 = 0.0f;
                    Object var7_8 = null;
                } else {
                    n11 = bitmap.getWidth();
                    f17 = n11;
                    f15 = f17 / f15;
                }
                d11.a(bitmap, f14, f16, f15);
            }
        }
    }

    private void b(int n10, int n11, Object object) {
        block17: {
            Object object2;
            int n12;
            block16: {
                block15: {
                    com.tencent.liteav.g g10;
                    block14: {
                        g10 = this.q;
                        int n13 = g10.j;
                        int n14 = 2;
                        float f10 = 2.8E-45f;
                        n12 = 1;
                        float f11 = Float.MIN_VALUE;
                        if (n13 != 0) {
                            if (n13 != n12) {
                                if (n13 == n14) {
                                    n14 = 3;
                                    f10 = 4.2E-45f;
                                }
                            } else {
                                n14 = n12;
                                f10 = f11;
                            }
                        }
                        if ((n13 = this.r) != n12 || (n13 = this.s) != 0) {
                            n12 = n14;
                            f11 = f10;
                        }
                        n13 = g10.i;
                        Object object3 = this.j;
                        if (object3 == null || (n14 = (int)(this.U ? 1 : 0)) != 0) break block14;
                        object3 = this.i;
                        int n15 = ((TXSVideoEncoderParam)object3).width;
                        if (n15 == n10 && (n15 = ((TXSVideoEncoderParam)object3).height) == n11 && (n15 = ((TXSVideoEncoderParam)object3).encodeType) == n12 && (n14 = ((TXSVideoEncoderParam)object3).gop) == n13) break block15;
                    }
                    int n16 = g10.h;
                    boolean bl2 = g10.P;
                    this.a(n10, n11, n12, object, n16, bl2);
                }
                if ((object2 = this.n) == null) break block16;
                object2 = this.m;
                n10 = ((TXSVideoEncoderParam)object2).encodeType;
                if (n10 == n12) break block17;
            }
            if ((n10 = (int)(this.l ? 1 : 0)) != 0) {
                object2 = this.q;
                n10 = (int)(((com.tencent.liteav.g)object2).P ? 1 : 0);
                this.a(object, n12, n10 != 0);
            }
        }
    }

    private int c(com.tencent.liteav.basic.structs.b b10) {
        int n10;
        com.tencent.liteav.basic.opengl.i i10;
        int n11 = this.M;
        if (n11 != 0) {
            return b10.a;
        }
        n11 = b10.a;
        int n12 = this.ac;
        int n13 = 0;
        int n14 = 1;
        if (n12 == n14) {
            n12 = n14;
        } else {
            n12 = 0;
            i10 = null;
        }
        int n15 = b10.i;
        if (n12 != n15) {
            i10 = this.P;
            if (i10 == null) {
                i10 = new com.tencent.liteav.basic.opengl.i();
                i10.a();
                i10.a(n14 != 0);
                n15 = b10.e;
                n10 = b10.f;
                i10.a(n15, n10);
                n15 = b10.e;
                n10 = b10.f;
                if (n15 > n10) {
                    i10.h();
                } else {
                    i10.g();
                }
                this.P = i10;
            }
            if ((i10 = this.P) != null) {
                n11 = b10.e;
                n15 = b10.f;
                i10.a(n11, n15);
                n11 = b10.a;
                n11 = i10.b(n11);
            }
        }
        if ((n12 = this.v) != 0) {
            i10 = this.Q;
            if (i10 == null) {
                i10 = new com.tencent.liteav.basic.opengl.i();
                i10.a();
                i10.a(n14 != 0);
                n14 = b10.e;
                n15 = b10.f;
                i10.a(n14, n15);
                this.Q = i10;
            }
            if ((i10 = this.Q) != null) {
                n14 = b10.e;
                n15 = b10.f;
                GLES20.glViewport((int)0, (int)0, (int)n14, (int)n15);
                n13 = b10.e;
                n14 = b10.f;
                Object object = com.tencent.liteav.basic.util.g.a(n13, n14, n13, n14);
                float f10 = 0.0f;
                int n16 = n13;
                object = i10.a(n13, n14, null, (com.tencent.liteav.basic.opengl.a)object, 0);
                n15 = this.v;
                int n17 = (720 - n15) % 360;
                n15 = 270;
                float f11 = 3.78E-43f;
                n10 = 90;
                n16 = n17 != n10 && n17 != n15 ? b10.e : b10.f;
                int n18 = n17 != n10 && n17 != n15 ? b10.f : b10.e;
                f11 = n16;
                float f12 = n18;
                f10 = f11 / f12;
                n16 = n13;
                i10.a(n13, n14, n17, (float[])object, f10, false, false);
                i10.b(n11);
                n11 = i10.l();
            }
        }
        return n11;
    }

    public static /* synthetic */ TXSVideoEncoderParam c(d d10) {
        return d10.i;
    }

    private void c(int n10, int n11) {
        this.b(n10, n11);
    }

    public static /* synthetic */ com.tencent.liteav.g d(d d10) {
        return d10.q;
    }

    private void d(int n10, int n11) {
        boolean bl2 = this.x;
        if (!bl2) {
            Bundle bundle = new Bundle();
            String string2 = this.getID();
            String string3 = "EVT_USERID";
            bundle.putString(string3, string2);
            int n12 = 2003;
            bundle.putInt("EVT_ID", n12);
            long l10 = TXCTimeUtil.getTimeTick();
            bundle.putLong("EVT_TIME", l10);
            l10 = TXCTimeUtil.getUtcTimeTick();
            bundle.putLong("EVT_UTC_TIME", l10);
            String string4 = "Renders the first video frame";
            bundle.putCharSequence("EVT_MSG", (CharSequence)string4);
            string2 = "EVT_PARAM1";
            bundle.putInt(string2, n10);
            bundle.putInt("EVT_PARAM2", n11);
            com.tencent.liteav.basic.util.g.a(this.aa, n12, bundle);
            CharSequence charSequence = new StringBuilder();
            charSequence.append("trtc_render render first frame ");
            String string5 = this.getID();
            charSequence.append(string5);
            charSequence.append(", ");
            n11 = this.F;
            charSequence.append(n11);
            charSequence = charSequence.toString();
            string5 = "TXCCaptureAndEnc";
            TXCLog.i(string5, (String)charSequence);
            n10 = 1;
            this.x = n10;
        }
    }

    private void d(com.tencent.liteav.basic.structs.b object) {
        boolean bl2;
        long l10;
        int n10;
        int n11;
        Object object2 = this.L;
        int n12 = 0;
        Object object3 = null;
        if (object2 == null) {
            n11 = 0;
            object2 = null;
        } else {
            object2 = (r)((Reference)object2).get();
        }
        if (object2 == null) {
            return;
        }
        TXSVideoFrame tXSVideoFrame = new TXSVideoFrame();
        tXSVideoFrame.width = n10 = ((com.tencent.liteav.basic.structs.b)object).e;
        tXSVideoFrame.height = n10 = ((com.tencent.liteav.basic.structs.b)object).f;
        tXSVideoFrame.pts = l10 = TXCTimeUtil.generatePtsMS();
        n10 = this.c((com.tencent.liteav.basic.structs.b)object);
        int n13 = this.K;
        int n14 = 5;
        int n15 = 36160;
        String string2 = "TXCCaptureAndEnc";
        int n16 = 1;
        if (n13 == n14) {
            tXSVideoFrame.textureId = n10;
            tXSVideoFrame.eglContext = object3 = this.f.a();
            n12 = this.S;
            n13 = -1;
            if (n12 == n13) {
                this.S = n12 = TXCOpenGlUtils.d();
                Object[] objectArray = new Object[n16];
                objectArray[0] = object3 = Integer.valueOf(n12);
                object3 = "create FrameBuffer: %d";
                TXCLog.i(string2, (String)object3, objectArray);
            }
            n12 = tXSVideoFrame.textureId;
            n13 = this.S;
            TXCOpenGlUtils.a(n12, n13);
            n12 = this.S;
            GLES20.glBindFramebuffer((int)n15, (int)n12);
            object3 = this.getID();
            n13 = this.F;
            object2.a((String)object3, n13, tXSVideoFrame);
            TXCOpenGlUtils.d(this.S);
            n11 = (int)(this.M ? 1 : 0);
            if (n11 != 0) {
                object2 = tXSVideoFrame.data;
                object2 = object2 != null ? ByteBuffer.wrap((byte[])object2) : tXSVideoFrame.buffer;
                ((ByteBuffer)object2).position(0);
                n12 = ((com.tencent.liteav.basic.structs.b)object).e;
                int n17 = ((com.tencent.liteav.basic.structs.b)object).f;
                ((com.tencent.liteav.basic.structs.b)object).a = n11 = TXCOpenGlUtils.a((ByteBuffer)object2, n12, n17, n10);
            }
        } else {
            n14 = 2;
            if (n13 == n14) {
                tXSVideoFrame.textureId = n10;
                tXSVideoFrame.eglContext = object3 = this.f.a();
                object3 = this.getID();
                n10 = this.F;
                object2.a((String)object3, n10, tXSVideoFrame);
                n11 = this.M;
                if (n11 != 0) {
                    ((com.tencent.liteav.basic.structs.b)object).a = n11 = tXSVideoFrame.textureId;
                }
            } else {
                n14 = 4;
                if (n13 == n16 || n13 == n14) {
                    int n18;
                    com.tencent.liteav.basic.opengl.i i10 = this.O;
                    int n19 = 3;
                    if (i10 == null) {
                        Object object4 = n13 == n16 ? new o(n16) : new o(n19);
                        ((com.tencent.liteav.basic.opengl.i)object4).a(n16 != 0);
                        n18 = (int)(((com.tencent.liteav.basic.opengl.i)object4).a() ? 1 : 0);
                        if (n18 != 0) {
                            n12 = ((com.tencent.liteav.basic.structs.b)object).e;
                            n18 = ((com.tencent.liteav.basic.structs.b)object).f;
                            ((com.tencent.liteav.basic.opengl.i)object4).a(n12, n18);
                            this.O = object4;
                        } else {
                            object4 = "init filter error ";
                            TXCLog.i(string2, (String)object4);
                            this.O = null;
                        }
                    }
                    if ((object3 = this.O) != null) {
                        n13 = ((com.tencent.liteav.basic.structs.b)object).e;
                        n18 = ((com.tencent.liteav.basic.structs.b)object).f;
                        GLES20.glViewport((int)0, (int)0, (int)n13, (int)n18);
                        n13 = ((com.tencent.liteav.basic.structs.b)object).e;
                        n18 = ((com.tencent.liteav.basic.structs.b)object).f;
                        ((com.tencent.liteav.basic.opengl.i)object3).a(n13, n18);
                        ((com.tencent.liteav.basic.opengl.i)object3).b(n10);
                        n12 = ((com.tencent.liteav.basic.opengl.i)object3).m();
                        GLES20.glBindFramebuffer((int)n15, (int)n12);
                        object3 = this.getID();
                        n10 = this.F;
                        object2.a((String)object3, n10, tXSVideoFrame);
                    }
                    if ((n11 = this.M) != 0 && ((object2 = (Object)tXSVideoFrame.data) != null || (object2 = tXSVideoFrame.buffer) != null)) {
                        n11 = this.K;
                        if (n11 == n16 || n11 != n14) {
                            n19 = n16;
                        }
                        object2 = this.R;
                        if (object2 == null) {
                            object2 = new k(n19);
                            ((com.tencent.liteav.basic.opengl.i)object2).a(n16 != 0);
                            n12 = (int)(((k)object2).a() ? 1 : 0);
                            if (n12 == 0) {
                                object3 = " init i420ToRGBA filter failed";
                                TXCLog.w(string2, (String)object3);
                            }
                            n12 = ((com.tencent.liteav.basic.structs.b)object).e;
                            n10 = ((com.tencent.liteav.basic.structs.b)object).f;
                            ((k)object2).a(n12, n10);
                            this.R = object2;
                        }
                        object2 = this.R;
                        n12 = ((com.tencent.liteav.basic.structs.b)object).e;
                        n10 = ((com.tencent.liteav.basic.structs.b)object).f;
                        GLES20.glViewport((int)0, (int)0, (int)n12, (int)n10);
                        n12 = ((com.tencent.liteav.basic.structs.b)object).e;
                        n10 = ((com.tencent.liteav.basic.structs.b)object).f;
                        ((k)object2).a(n12, n10);
                        object3 = tXSVideoFrame.data;
                        if (object3 != null) {
                            ((k)object2).a((byte[])object3);
                        } else {
                            object3 = tXSVideoFrame.buffer;
                            ((k)object2).a((ByteBuffer)object3);
                        }
                        ((com.tencent.liteav.basic.structs.b)object).a = n11 = ((k)object2).r();
                    }
                }
            }
        }
        if ((bl2 = this.M) && (object = this.y) != null && (object = ((TXCloudVideoView)((Object)object)).getGLSurfaceView()) != null) {
            ((TXCGLSurfaceViewBase)((Object)object)).d();
        }
    }

    public static /* synthetic */ n e(d d10) {
        return d10.e;
    }

    public static /* synthetic */ void f(d d10) {
        d10.u();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private void f(boolean bl2) {
        n n10 = this.e;
        if (n10 == null) {
            return;
        }
        Object object = new d$6(this);
        n10.a((Runnable)object);
        this.n();
        this.e.a(bl2);
        n10 = null;
        this.e = null;
        TXCLog.i("TXCCaptureAndEnc", "stopped CaptureSource");
        object = this.y;
        f f10 = this.d;
        d$7 d$7 = new d$7(this, (TXCloudVideoView)((Object)object), bl2);
        f10.post(d$7);
        this.y = null;
        Object object2 = this.z;
        synchronized (object2) {
            this.A = null;
            object = this.D;
            if (object != null) {
                ((com.tencent.liteav.basic.opengl.f)object).a();
                this.D = null;
            }
        }
        object2 = this.a;
        bl2 = ((com.tencent.liteav.b)object2).a();
        if (bl2) {
            object2 = this.a;
            ((com.tencent.liteav.b)object2).b();
        }
        if (bl2 = this.u) {
            this.q();
        }
    }

    public static /* synthetic */ TXSVideoEncoderParam g(d d10) {
        return d10.m;
    }

    private void g(boolean bl2) {
        n n10 = this.e;
        if (n10 != null) {
            d$12 d$12 = new d$12(this, bl2);
            n10.a(d$12);
        }
    }

    public static /* synthetic */ void h(d d10) {
        d10.t();
    }

    public static /* synthetic */ int i(d d10) {
        return d10.ab;
    }

    public static /* synthetic */ com.tencent.liteav.basic.structs.b j(d d10) {
        return d10.E;
    }

    public static /* synthetic */ com.tencent.liteav.basic.opengl.f k(d d10) {
        return d10.D;
    }

    public static /* synthetic */ com.tencent.liteav.beauty.d l(d d10) {
        return d10.f;
    }

    public static /* synthetic */ int m(d d10) {
        return d10.t;
    }

    public static /* synthetic */ boolean n(d d10) {
        return d10.u;
    }

    public static /* synthetic */ boolean o(d d10) {
        return d10.U;
    }

    public static /* synthetic */ boolean p(d d10) {
        return d10.l;
    }

    private void q() {
        String string2 = " startBlackStream";
        TXCLog.i("TXCCaptureAndEnc", string2);
        com.tencent.liteav.b b10 = this.b;
        if (b10 == null) {
            this.b = b10 = new com.tencent.liteav.b(this);
        }
        this.b.a(10, -1, null, 64, 64);
    }

    private void r() {
        Object object = new StringBuilder();
        ((StringBuilder)object).append(" stopBlackStream when enableBlackStream ");
        boolean bl2 = this.u;
        ((StringBuilder)object).append(bl2);
        object = ((StringBuilder)object).toString();
        String string2 = "TXCCaptureAndEnc";
        TXCLog.i(string2, (String)object);
        object = this.b;
        if (object != null) {
            ((com.tencent.liteav.b)object).b();
        }
    }

    private void s() {
        Object object;
        int n10 = this.S;
        int n11 = -1;
        if (n10 != n11) {
            int n12 = 1;
            Object[] objectArray = new Object[n12];
            objectArray[0] = object = Integer.valueOf(n10);
            object = "TXCCaptureAndEnc";
            String string2 = "destroy FrameBuffer: %d";
            TXCLog.i((String)object, string2, objectArray);
            n10 = this.S;
            TXCOpenGlUtils.b(n10);
            this.S = n11;
        }
        object = this.Z;
        n11 = 0;
        Object object2 = null;
        if (object != null) {
            ((com.tencent.liteav.basic.opengl.e)object).e();
            this.Z = null;
        }
        if ((object = this.Y) != null) {
            object2 = object = ((Reference)object).get();
            object2 = (p)object;
        }
        if (object2 != null) {
            object2.b();
        }
    }

    private void t() {
        block5: {
            b b10 = this.n;
            String string2 = null;
            this.n = null;
            if (b10 == null) break block5;
            b10.a();
            try {
                b10.a((com.tencent.liteav.videoencoder.d)null);
            }
            catch (Exception exception) {
                string2 = "TXCCaptureAndEnc";
                String string3 = "stop video encoder failed.";
                TXCLog.e(string2, string3, exception);
            }
        }
    }

    private void u() {
        String string2;
        String string3;
        block6: {
            string3 = "TXCCaptureAndEnc";
            Object object = "stopBigVideoEncoderInGLThread";
            TXCLog.i(string3, (String)object);
            object = this.j;
            string2 = null;
            this.j = null;
            if (object == null) break block6;
            ((b)object).a();
            ((b)object).a((com.tencent.liteav.videoencoder.d)null);
        }
        boolean bl2 = true;
        try {
            this.U = bl2;
        }
        catch (Exception exception) {
            string2 = "stopBigVideoEncoder failed.";
            TXCLog.e(string3, string2, exception);
        }
    }

    private void v() {
        n n10 = this.e;
        if (n10 != null) {
            d$13 d$13 = new d$13(this);
            n10.a(d$13);
        }
    }

    private void w() {
        com.tencent.liteav.beauty.d d10 = this.f;
        if (d10 != null) {
            Object object = this.q;
            boolean bl2 = object.U;
            if (bl2) {
                object = d$d.a;
                d10.a((d$d)((Object)object));
            } else {
                boolean bl3 = object.T;
                if (bl3) {
                    object = d$d.b;
                    d10.a((d$d)((Object)object));
                } else {
                    object = d$d.c;
                    d10.a((d$d)((Object)object));
                }
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(int n10, int n11, int n12, Object object, long l10) {
        d d10 = this;
        Object object2 = this.o;
        synchronized (object2) {
            int n13;
            com.tencent.liteav.g g10;
            int n14 = this.t;
            int n15 = 2;
            if (n14 == n15) {
                return 0;
            }
            n14 = n11;
            n15 = n12;
            Object object3 = object;
            int n16 = this.a(n11, n12, object);
            if (n16 != 0) {
                return n16;
            }
            long l11 = 0L;
            long l12 = l10 - l11;
            n16 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            long l13 = n16 == 0 ? (l11 = TXCTimeUtil.generatePtsMS()) : l10;
            object3 = d10.j;
            if (object3 != null) {
                g10 = d10.q;
                n13 = g10.S;
                ((b)object3).a(n13 != 0);
                n13 = n10;
                ((b)object3).a(n10, n11, n12, l13);
            }
            if ((object3 = d10.n) != null) {
                g10 = d10.q;
                n13 = (int)(g10.S ? 1 : 0);
                ((b)object3).a(n13 != 0);
                n13 = n10;
                ((b)object3).a(n10, n11, n12, l13);
            }
            return 0;
        }
    }

    public int a(com.tencent.liteav.basic.structs.b b10) {
        int n10;
        Object object = this.Y;
        if (object != null) {
            object = (p)((Reference)object).get();
        } else {
            n10 = 0;
            object = null;
        }
        if (object != null) {
            int n11;
            int n12;
            int n13;
            com.tencent.liteav.basic.opengl.e e10 = this.Z;
            if (e10 == null || (n13 = e10.c()) != (n12 = b10.e) || (n13 = (e10 = this.Z).d()) != (n12 = b10.f)) {
                e10 = this.Z;
                if (e10 != null) {
                    e10.e();
                }
                n12 = b10.e;
                n11 = b10.f;
                this.Z = e10 = new com.tencent.liteav.basic.opengl.e(n12, n11);
                e10.a();
            }
            n13 = b10.a;
            n12 = b10.e;
            n11 = b10.f;
            com.tencent.liteav.basic.opengl.e e11 = this.Z;
            int n14 = e11.b();
            b10.a = n10 = object.a(n13, n12, n11, n14);
            GLES20.glDisable((int)3042);
            n10 = 2929;
            GLES20.glDisable((int)n10);
        }
        this.d(b10);
        this.a(b10, false);
        return b10.a;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int a(byte[] byArray, int n10, int n11, int n12, long l10) {
        Object object = this.o;
        synchronized (object) {
            int n13 = this.t;
            int n14 = 2;
            if (n13 == n14) {
                return 0;
            }
            n13 = 0;
            Object var10_9 = null;
            n14 = n11;
            n13 = this.a(n11, n12, null);
            if (n13 != 0) {
                return n13;
            }
            b b10 = this.j;
            if (b10 != null) {
                long l11 = 0L;
                long l12 = l10 - l11;
                n13 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
                long l13 = n13 == 0 ? (l11 = TXCTimeUtil.generatePtsMS()) : l10;
                b10.a(byArray, n10, n11, n12, l13);
            }
            return 0;
        }
    }

    public void a() {
        String string2 = "onPushEnd";
        TXCLog.i("TXCCaptureAndEnc", string2);
        Object object = this.N;
        if (object == null) {
            return;
        }
        if ((object = (d$a)((Reference)object).get()) == null) {
            return;
        }
        object.a();
    }

    public void a(float f10) {
        n n10 = this.e;
        if (n10 == null) {
            return;
        }
        n10.a(f10);
    }

    public void a(float f10, float f11) {
        n n10 = this.e;
        if (n10 != null) {
            com.tencent.liteav.g g10 = this.q;
            boolean bl2 = g10.K;
            if (bl2) {
                n10.a(f10, f11);
            }
        }
    }

    public void a(int n10) {
        Object object = new StringBuilder();
        ((StringBuilder)object).append("vrotation setVideoEncRotation ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        Object object2 = "TXCCaptureAndEnc";
        TXCLog.i((String)object2, (String)object);
        this.ab = n10;
        object = this.e;
        if (object != null) {
            object2 = new d$1(this, n10);
            object.a((Runnable)object2);
        } else {
            object = this.j;
            if (object != null) {
                ((b)object).a(n10);
            }
            if ((object = this.n) != null) {
                ((b)object).a(n10);
            }
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11) {
        Object object = this.z;
        synchronized (object) {
            com.tencent.liteav.basic.opengl.f f10 = this.D;
            if (f10 != null) {
                d$3 d$3 = new d$3(this, n10, n11);
                f10.a(d$3);
            } else {
                this.B = n10;
                this.C = n11;
            }
            return;
        }
    }

    public void a(int n10, int n11, int n12) {
        n n13 = this.e;
        if (n13 == null) {
            return;
        }
        d$14 d$14 = new d$14(this, n11, n12, n10);
        n13.a(d$14);
    }

    public void a(int n10, long l10, long l11) {
        int n11 = 2;
        if (n10 == n11) {
            this.J = l10;
            this.I = l11;
        }
    }

    public void a(Bitmap object, ByteBuffer byteBuffer, int n10, int n11) {
        d$8 d$8 = new d$8(this, (Bitmap)object, byteBuffer, n10, n11);
        object = this.e;
        if (object != null) {
            object.a(d$8);
        } else {
            d$8.run();
        }
    }

    public void a(SurfaceTexture object) {
        object = this.f;
        if (object != null) {
            ((com.tencent.liteav.beauty.d)object).b();
        }
        if ((object = (object = this.Y) != null ? (p)((Reference)object).get() : null) != null) {
            object.a();
        }
    }

    public void a(MediaFormat mediaFormat) {
        Object object = this.N;
        if (object == null) {
            return;
        }
        if ((object = (d$a)((Reference)object).get()) != null) {
            object.a(mediaFormat);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Surface object) {
        Object object2 = this.y;
        if (object2 != null) {
            TXCLog.w("TXCCaptureAndEnc", "camera preview view is not null, can't set surface");
            return;
        }
        object2 = this.z;
        synchronized (object2) {
            Object object3 = this.A;
            if (object3 != object) {
                object3 = "TXCCaptureAndEnc";
                CharSequence charSequence = new StringBuilder();
                String string2 = "surface-render: set surface ";
                charSequence.append(string2);
                charSequence.append(object);
                charSequence = charSequence.toString();
                TXCLog.i((String)object3, (String)charSequence);
                this.A = object;
                object = this.D;
                if (object != null) {
                    ((com.tencent.liteav.basic.opengl.f)object).a();
                    object = null;
                    this.D = null;
                }
            } else {
                object3 = "TXCCaptureAndEnc";
                StringBuilder stringBuilder = new StringBuilder();
                String string3 = "surface-render: set surface the same";
                stringBuilder.append(string3);
                stringBuilder.append(object);
                object = stringBuilder.toString();
                TXCLog.i((String)object3, (String)object);
            }
            return;
        }
    }

    public void a(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.aa = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public void a(com.tencent.liteav.basic.opengl.o o10) {
        Object object = this.y;
        com.tencent.liteav.basic.opengl.o o11 = null;
        if (object != null) {
            if ((object = ((TXCloudVideoView)((Object)object)).getGLSurfaceView()) != null) {
                o11 = new d$4(this, o10);
                ((TXCGLSurfaceView)object).a(o11);
            } else if (o10 != null) {
                o10.a(null);
            }
        } else {
            object = this.D;
            if (object != null) {
                o11 = new d$5(this, o10);
                ((com.tencent.liteav.basic.opengl.f)object).a(o11);
            } else if (o10 != null) {
                o10.a(null);
            }
        }
    }

    public void a(TXSNALPacket object, int n10) {
        int n11 = 2;
        if (n10 == 0) {
            Object object2;
            n10 = object.streamType;
            if (n10 == n11) {
                long l10;
                this.J = l10 = object.gopIndex;
                this.I = l10 = object.frameIndex;
            }
            if ((object2 = this.N) == null) {
                return;
            }
            if ((object2 = (d$a)((Reference)object2).get()) != null) {
                object2.a((TXSNALPacket)object);
            }
        } else {
            int n12 = 10000004;
            if (n10 == n12 || n10 == (n12 = 10000005)) {
                object = this.i;
                n12 = object.encodeType;
                int n13 = 1;
                if (n12 == n13) {
                    Object object3;
                    object = new Object[n13];
                    object[0] = object3 = Integer.valueOf(n10);
                    object = String.format("VideoEncoder: hardware encoder error %d, switch to software encoder", object);
                    Monitor.a(n11, (String)object, "", 0);
                    this.n();
                    this.s = n12 = this.s + n13;
                    object = this.q;
                    object.j = 0;
                    n12 = 1103;
                    object3 = "Failed to enable hardware encoder, use software encoder";
                    this.a(n12, (String)object3);
                }
            }
        }
    }

    public void a(com.tencent.liteav.basic.structs.b b10, long l10) {
        int n10 = b10.a;
        int n11 = b10.e;
        int n12 = b10.f;
        this.a(n10, n11, n12, l10);
    }

    public void a(d$a d$a) {
        WeakReference<d$a> weakReference;
        this.N = weakReference = new WeakReference<d$a>(d$a);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public void a(com.tencent.liteav.g var1_1) {
        var2_3 = 1;
        var3_4 = 1.4E-45f;
        var4_5 = 0;
        if (var1_1 == null) ** GOTO lbl-1000
        var5_6 = this.q;
        var6_7 /* !! */  = var5_6.E;
        var7_8 /* !! */  = var1_1.E;
        if (var6_7 /* !! */  != var7_8 /* !! */  || (var8_9 = var5_6.F) != (var9_10 = var1_1.F) || (var8_9 = var5_6.G) != (var9_10 = var1_1.G) || (var8_9 = (int)((cfr_temp_0 = (var10_11 = var5_6.J) - (var11_12 = var1_1.J)) == 0.0f ? 0 : (cfr_temp_0 > 0.0f ? 1 : -1))) != 0 || (var8_9 = (int)((cfr_temp_1 = (var10_11 = var5_6.H) - (var11_12 = var1_1.H)) == 0.0f ? 0 : (cfr_temp_1 > 0.0f ? 1 : -1))) != 0 || (var13_14 = (int)((cfr_temp_2 = (var12_13 = var5_6.I) - (var10_11 = var1_1.I)) == 0.0f ? 0 : (cfr_temp_2 > 0.0f ? 1 : -1))) != 0) {
            var13_14 = var2_3;
            var12_13 = var3_4;
        } else lbl-1000:
        // 2 sources

        {
            var13_14 = 0;
            var5_6 = null;
            var12_13 = 0.0f;
        }
        if (var1_1 == null) ** GOTO lbl-1000
        var6_7 /* !! */  = this.q;
        var9_10 = var6_7 /* !! */ .a;
        var14_15 = var1_1.a;
        if (var9_10 != var14_15 || (var8_9 = var6_7 /* !! */ .b) != (var9_10 = var1_1.b)) {
            var8_9 = var2_3;
            var10_11 = var3_4;
        } else lbl-1000:
        // 2 sources

        {
            var8_9 = 0;
            var6_7 /* !! */  = null;
            var10_11 = 0.0f;
        }
        if (var1_1 == null) ** GOTO lbl-1000
        var7_8 /* !! */  = this.q;
        var14_15 = var7_8 /* !! */ .a;
        if (var14_15 <= 0 || (var9_10 = var7_8 /* !! */ .b) <= 0 || (var15_16 = var1_1.a) <= 0 || (var16_17 = var1_1.b) <= 0) ** GOTO lbl-1000
        var11_12 = var14_15 /= var9_10;
        var17_18 = var15_16 /= var16_17;
        var18_19 = var11_12 = Math.abs(var11_12 - var17_18);
        cfr_temp_3 = var18_19 - (var20_20 = 0.1);
        var9_10 = (int)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 > 0.0 ? 1 : -1));
        if (var9_10 > 0) {
            var9_10 = var2_3;
            var11_12 = var3_4;
        } else lbl-1000:
        // 3 sources

        {
            var9_10 = 0;
            var7_8 /* !! */  = null;
            var11_12 = 0.0f;
        }
        if (var1_1 != null) {
            var1_1 = var1_1.clone();
            var1_1 = (com.tencent.liteav.g)var1_1;
            try {
                this.q = var1_1;
            }
            catch (CloneNotSupportedException var1_2) {
                var22_21 = new com.tencent.liteav.g();
                this.q = var22_21;
                var1_2.printStackTrace();
            }
        } else {
            this.q = var1_1 = new com.tencent.liteav.g();
        }
        var23_22 = 3;
        var1_1 = new Object[var23_22];
        var1_1[0] = var22_21 = Integer.valueOf(this.q.a);
        var1_1[var2_3] = var22_21 = Integer.valueOf(this.q.b);
        var2_3 = 2;
        var3_4 = 2.8E-45f;
        var14_15 = this.q.l;
        var1_1[var2_3] = var22_21 = Integer.valueOf(var14_15);
        var1_1 = String.format("vsize setConfig w*h:%d*%d orientation:%d", (Object[])var1_1);
        var24_23 = "TXCCaptureAndEnc";
        TXCLog.i((String)var24_23, (String)var1_1);
        var1_1 = this.e;
        if (var1_1 != null) {
            var24_23 = this.q;
            var2_3 = var24_23.l;
            var1_1.e(var2_3);
        }
        this.w();
        var1_1 = this.q;
        var2_3 = (int)var1_1.T;
        if (var2_3 == 0) {
            var23_22 = (int)var1_1.U;
            var4_5 = var23_22 != 0 ? var8_9 : var9_10;
        }
        this.g((boolean)var4_5);
        var23_22 = (int)this.i();
        if (var23_22 != 0 && var13_14 != 0) {
            this.v();
        }
    }

    public void a(p p10) {
        WeakReference<p> weakReference;
        this.Y = weakReference = new WeakReference<p>(p10);
    }

    public void a(a$a object) {
        int n10 = Build.VERSION.SDK_INT;
        String string2 = "TXCCaptureAndEnc";
        int n11 = 21;
        if (n10 < n11) {
            object = new Bundle();
            object.putString("EVT_MSG", "Screen recording failed, unsupported Android system version. system version should above 5.0");
            this.onNotifyEvent(-1309, (Bundle)object);
            object = new StringBuilder();
            ((StringBuilder)object).append("Screen capture need running on Android Lollipop or higher version, current:");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            TXLog.e(string2, (String)object);
            return;
        }
        this.r = n10 = 1;
        Object object2 = this.e;
        if (object2 == null) {
            Context context = this.p;
            com.tencent.liteav.g g10 = this.q;
            object2 = new i(context, g10, (a$a)object);
            this.e = object2;
            object = "create TXCScreenCaptureSource";
            TXCLog.i(string2, (String)object);
        }
        this.W.a(false);
        int n12 = this.F;
        this.f(n12);
        this.e.a(this);
        this.e.a(this);
        this.e.a();
        object = this.e;
        object2 = this.getID();
        object.a((String)object2);
        object = this.p;
        n10 = com.tencent.liteav.basic.datareport.a.aH;
        TXCDRApi.txReportDAU((Context)object, n10);
    }

    public void a(TXCloudVideoView tXCloudVideoView) {
        Object object;
        Object object2;
        Object object3 = this.q;
        boolean bl2 = ((com.tencent.liteav.g)object3).M;
        Object object4 = "TXCCaptureAndEnc";
        if (bl2) {
            TXCLog.e((String)object4, "enable pure audio push , so can not start preview!");
            return;
        }
        object3 = this.a;
        if (object3 != null) {
            ((com.tencent.liteav.b)object3).b();
        }
        bl2 = false;
        object3 = null;
        this.x = false;
        Object object5 = this.q;
        int n10 = ((com.tencent.liteav.g)object5).W;
        if (tXCloudVideoView != null) {
            int n11 = 1;
            object2 = new TXCGLSurfaceView[n11];
            object = new d$16(this, (TXCGLSurfaceView[])object2, tXCloudVideoView);
            this.a((Runnable)object);
            object = object2[0];
            object2[0].setNotifyListener(this);
            object2 = "start camera preview with GLSurfaceView";
            TXCLog.i((String)object4, (String)object2);
        } else {
            object = new com.tencent.liteav.basic.opengl.g();
            TXCLog.i((String)object4, "start camera preview with SurfaceTexture");
            n10 = 0;
            object5 = null;
        }
        this.r = 0;
        object2 = this.p;
        com.tencent.liteav.g g10 = this.q;
        this.e = object4 = new com.tencent.liteav.c((Context)object2, g10, (m)object, n10 != 0);
        this.r();
        int n12 = this.F;
        this.f(n12);
        object4 = this.e;
        object5 = this.getID();
        object4.a((String)object5);
        this.e.a(this);
        this.e.a(this);
        this.e.a();
        object4 = this.e;
        n10 = this.v;
        object4.b(n10);
        object4 = this.e;
        n10 = this.w;
        object4.c(n10);
        object4 = this.e;
        n10 = this.ac;
        object4.d(n10);
        this.y = tXCloudVideoView;
        object4 = this.d;
        object5 = new d$2(this, tXCloudVideoView);
        object4.post((Runnable)object5);
        this.x = false;
        TXCKeyPointReportProxy.a(30003);
    }

    public void a(boolean bl2) {
        CharSequence charSequence = new StringBuilder();
        charSequence.append("enableBlackStream ");
        charSequence.append(bl2);
        charSequence = charSequence.toString();
        String string2 = "TXCCaptureAndEnc";
        TXCLog.i(string2, (String)charSequence);
        this.u = bl2;
        if (bl2) {
            n n10 = this.e;
            if (n10 == null) {
                this.q();
            }
        } else {
            this.r();
        }
    }

    public TXBeautyManager b() {
        return this.W;
    }

    public void b(int n10) {
        com.tencent.liteav.basic.opengl.f f10;
        Object object = new StringBuilder();
        ((StringBuilder)object).append("setLocalViewMirror ");
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        String string2 = "TXCCaptureAndEnc";
        TXCLog.i(string2, (String)object);
        this.ac = n10;
        object = this.e;
        if (object != null) {
            object.d(n10);
        }
        if ((f10 = this.D) != null) {
            int n11 = this.ac;
            f10.b(n11);
        }
    }

    public void b(int n10, int n11, int n12) {
        com.tencent.liteav.beauty.b b10 = this.W;
        float f10 = n10;
        b10.setBeautyLevel(f10);
        com.tencent.liteav.beauty.b b11 = this.W;
        float f11 = n11;
        b11.setWhitenessLevel(f11);
        b11 = this.W;
        f11 = n12;
        b11.setRuddyLevel(f11);
    }

    public void b(com.tencent.liteav.basic.structs.b b10) {
        Object object;
        int n10;
        Object object2 = this.c;
        ((com.tencent.liteav.basic.util.c)object2).a();
        int n11 = this.T;
        if (n11 == 0) {
            this.T = true;
            n11 = 30003;
            n10 = 0;
            object = null;
            TXCKeyPointReportProxy.a(n11, 0);
        }
        if ((n11 = this.t) == (n10 = 2)) {
            return;
        }
        object2 = this.e;
        object = this.f;
        if (object != null) {
            object = this.q;
            n10 = (int)(((com.tencent.liteav.g)object).M ? 1 : 0);
            if (n10 == 0 && object2 != null) {
                object = this.i;
                int n12 = ((TXSVideoEncoderParam)object).height;
                int n13 = b10.h;
                if (n12 != n13 || (n10 = ((TXSVideoEncoderParam)object).width) != (n12 = b10.g)) {
                    n10 = b10.g;
                    this.c(n10, n13);
                }
                object = this.f;
                object2 = object2.f();
                ((com.tencent.liteav.beauty.d)object).a(object2);
                object2 = this.f;
                object = this.q;
                n10 = ((com.tencent.liteav.g)object).l;
                ((com.tencent.liteav.beauty.d)object2).a(n10);
                com.tencent.liteav.beauty.d d10 = this.f;
                int n14 = b10.b;
                long l10 = 0L;
                d10.a(b10, n14, 0, l10);
            }
        }
    }

    public void b(boolean bl2) {
        this.f(bl2);
    }

    public void b(byte[] byArray, int n10, int n11, int n12, long l10) {
    }

    public int c() {
        return this.i.width;
    }

    public void c(int n10) {
        Object object;
        int n11 = this.v;
        if (n11 != n10) {
            object = new StringBuilder();
            ((StringBuilder)object).append("vrotation setRenderRotation ");
            ((StringBuilder)object).append(n10);
            object = ((StringBuilder)object).toString();
            String string2 = "TXCCaptureAndEnc";
            TXCLog.i(string2, (String)object);
        }
        this.v = n10;
        object = this.e;
        if (object == null) {
            return;
        }
        object.b(n10);
    }

    public void c(boolean bl2) {
        this.V = bl2;
    }

    public int d() {
        return this.i.height;
    }

    public void d(int n10) {
        this.W.setBeautyStyle(n10);
    }

    public boolean d(boolean bl2) {
        n n10 = this.e;
        if (n10 == null) {
            return false;
        }
        return n10.d(bl2);
    }

    public int e() {
        boolean bl2 = this.i();
        String string2 = "TXCCaptureAndEnc";
        if (bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("ignore startPush when pushing, status:");
            int n10 = this.t;
            charSequence.append(n10);
            charSequence = charSequence.toString();
            TXCLog.w(string2, (String)charSequence);
            return -2;
        }
        TXCDRApi.initCrashReport(this.p);
        this.t = 1;
        TXCLog.i(string2, "startWithoutAudio");
        this.w();
        Context context = this.p;
        int n11 = com.tencent.liteav.basic.datareport.a.bv;
        TXCDRApi.txReportDAU(context, n11);
        return 0;
    }

    public boolean e(int n10) {
        n n11 = this.e;
        if (n11 == null) {
            return false;
        }
        return n11.a(n10);
    }

    public boolean e(boolean bl2) {
        this.q.S = bl2;
        n n10 = this.e;
        if (n10 == null) {
            return false;
        }
        n10.c(bl2);
        return true;
    }

    public void f() {
        boolean bl2 = this.i();
        Object object = "TXCCaptureAndEnc";
        if (!bl2) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("ignore stopPush when not pushing, status:");
            int n10 = this.t;
            charSequence.append(n10);
            charSequence = charSequence.toString();
            TXCLog.w((String)object, (String)charSequence);
            return;
        }
        TXCLog.i((String)object, "stop");
        bl2 = false;
        Object var3_4 = null;
        this.t = 0;
        this.n();
        this.q.P = false;
        object = this.a;
        if (object != null) {
            ((com.tencent.liteav.b)object).b();
        }
        this.a(false);
        this.E = null;
    }

    public void f(int n10) {
        this.F = n10;
        n n11 = this.e;
        if (n11 != null) {
            n11.g(n10);
        }
    }

    public void g() {
        int n10 = this.t;
        String string2 = "TXCCaptureAndEnc";
        int n11 = 1;
        if (n10 != n11) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("ignore pause push when is not pushing, status:");
            n11 = this.t;
            charSequence.append(n11);
            charSequence = charSequence.toString();
            TXCLog.w(string2, (String)charSequence);
            return;
        }
        this.t = 2;
        TXCLog.i(string2, "pausePusher");
        Object object = this.q;
        n10 = ((com.tencent.liteav.g)object).D & n11;
        if (n10 == n11) {
            this.n();
            com.tencent.liteav.b b10 = this.a;
            if (b10 != null) {
                object = this.q;
                boolean bl2 = ((com.tencent.liteav.g)object).M;
                if (!bl2) {
                    int n12 = ((com.tencent.liteav.g)object).C;
                    int n13 = ((com.tencent.liteav.g)object).B;
                    Bitmap bitmap = ((com.tencent.liteav.g)object).A;
                    object = this.i;
                    int n14 = ((TXSVideoEncoderParam)object).width;
                    int n15 = ((TXSVideoEncoderParam)object).height;
                    b10.a(n12, n13, bitmap, n14, n15);
                }
            }
            if ((object = this.e) != null) {
                object.c();
            }
        }
    }

    public void g(int n10) {
        Object object = this.i;
        int n11 = ((TXSVideoEncoderParam)object).width;
        int n12 = ((TXSVideoEncoderParam)object).height;
        int n13 = n11 * n12;
        int n14 = 518400;
        if (n13 < n14) {
            object = this.q;
            ((com.tencent.liteav.g)object).j = 0;
        } else if ((n11 *= n12) < (n12 = 921600) && (n12 = (int)(this.g ? 1 : 0)) != 0) {
            object = this.q;
            ((com.tencent.liteav.g)object).j = 0;
        }
        n12 = 3;
        if (n10 == n12) {
            this.p();
        } else {
            n10 = 1;
            this.g = n10;
            this.o();
        }
    }

    public void h() {
        int n10 = this.t;
        Object object = "TXCCaptureAndEnc";
        int n11 = 2;
        if (n10 != n11) {
            CharSequence charSequence = new StringBuilder();
            charSequence.append("ignore resume push when is not pause, status:");
            n11 = this.t;
            charSequence.append(n11);
            charSequence = charSequence.toString();
            TXCLog.w((String)object, (String)charSequence);
            return;
        }
        this.t = n10 = 1;
        String string2 = "resumePusher";
        TXCLog.i((String)object, string2);
        object = this.q;
        n11 = ((com.tencent.liteav.g)object).D & n10;
        if (n11 == n10) {
            boolean bl2;
            Object object2 = this.a;
            if (object2 != null && !(bl2 = ((com.tencent.liteav.g)object).M)) {
                ((com.tencent.liteav.b)object2).b();
            }
            this.n();
            object2 = this.e;
            if (object2 != null) {
                object2.b();
            }
            this.v();
        }
    }

    public void h(int n10) {
    }

    public boolean i() {
        int n10 = this.t;
        n10 = n10 != 0 ? 1 : 0;
        return n10 != 0;
    }

    public void j() {
        n n10 = this.e;
        if (n10 == null) {
            return;
        }
        d$15 d$15 = new d$15(this);
        n10.a(d$15);
    }

    public void k() {
        Object object = this.e;
        if (object == null) {
            return;
        }
        object = this.W;
        boolean bl2 = true;
        ((com.tencent.liteav.beauty.b)object).a(bl2);
        this.f(bl2);
    }

    public int l() {
        n n10 = this.e;
        if (n10 == null) {
            return 0;
        }
        return n10.e();
    }

    public void m() {
        String string2 = "onCaptureDestroy->enter ";
        TXCLog.i("TXCCaptureAndEnc", string2);
        Object object = this.f;
        if (object != null) {
            ((com.tencent.liteav.beauty.d)object).b();
        }
        object = this.O;
        string2 = null;
        if (object != null) {
            ((com.tencent.liteav.basic.opengl.i)object).d();
            this.O = null;
        }
        if ((object = this.Q) != null) {
            ((com.tencent.liteav.basic.opengl.i)object).d();
            this.Q = null;
        }
        if ((object = this.P) != null) {
            ((com.tencent.liteav.basic.opengl.i)object).d();
            this.P = null;
        }
        if ((object = this.R) != null) {
            ((com.tencent.liteav.basic.opengl.i)object).d();
            this.R = null;
        }
        this.u();
        this.t();
        this.s();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void n() {
        d$9 d$9 = new d$9(this);
        Object object = this.e;
        if (object != null) {
            object.a(d$9);
            return;
        }
        object = this.o;
        synchronized (object) {
            d$9.run();
            return;
        }
    }

    public void o() {
        Object object = this.j;
        if (object == null) {
            return;
        }
        object = this.e;
        if (object != null) {
            d$10 d$10 = new d$10(this);
            object.a(d$10);
        } else {
            this.u();
        }
    }

    public void onNotifyEvent(int n10, Bundle bundle) {
        long l10;
        int n11;
        Object object;
        d d10 = this;
        int n12 = n10;
        Bundle bundle2 = bundle;
        if (bundle != null) {
            object = this.getID();
            String string2 = "EVT_USERID";
            bundle.putString(string2, (String)object);
        }
        object = d10.aa;
        com.tencent.liteav.basic.util.g.a((WeakReference)object, n12, bundle2);
        long l11 = 0L;
        long l12 = 1L;
        int n13 = -1314;
        int n14 = -1317;
        if (n12 == n14) {
            String string3 = this.getID();
            int n15 = 2002;
            long l13 = 4;
            long l14 = -1;
            int n16 = d10.F;
            String string4 = "";
            TXCEventRecorderProxy.a(string3, n15, l13, l14, string4, n16);
        } else if (n12 == n13) {
            String string5 = this.getID();
            int n17 = 2002;
            long l15 = 5;
            long l16 = -1;
            n11 = d10.F;
            String string6 = "";
            TXCEventRecorderProxy.a(string5, n17, l15, l16, string6, n11);
        } else {
            n11 = 1003;
            if (n12 == n11) {
                n n18 = d10.e;
                if (n18 != null) {
                    String string7 = this.getID();
                    int n19 = 4001;
                    n18 = d10.e;
                    n11 = (int)(n18.g() ? 1 : 0);
                    l10 = n11 != 0 ? l11 : l12;
                    long l17 = -1;
                    n11 = d10.F;
                    String string8 = "";
                    TXCEventRecorderProxy.a(string7, n19, l10, l17, string8, n11);
                }
            } else {
                n11 = -1308;
                if (n12 == n11) {
                    this.k();
                }
            }
        }
        n11 = -1302;
        if (n12 != n11 && n12 != n14 && n12 != (n14 = -1318) && n12 != (n14 = -1319)) {
            n14 = -1301;
            if (n12 == n14 || n12 == n13 || n12 == (n13 = -1315) || n12 == (n13 = -1316)) {
                n13 = 30003;
                TXCKeyPointReportProxy.a(n13, n12);
                n n20 = d10.e;
                if (n20 != null) {
                    String string9 = this.getID();
                    n11 = 4002;
                    n20 = d10.e;
                    n13 = (int)(n20.g() ? 1 : 0);
                    long l18 = n13 != 0 ? l11 : l12;
                    l10 = n12;
                    int n21 = d10.F;
                    String string10 = "";
                    TXCEventRecorderProxy.a(string9, n11, l18, l10, string10, n21);
                }
            }
        } else {
            int n22 = 30002;
            TXCKeyPointReportProxy.a(n22, n12);
        }
    }

    public void p() {
        Object object = this.n;
        if (object == null) {
            return;
        }
        object = this.e;
        if (object != null) {
            d$11 d$11 = new d$11(this);
            object.a(d$11);
        } else {
            this.t();
        }
    }

    public void setID(String string2) {
        super.setID(string2);
        Object object = this.j;
        if (object != null) {
            ((b)object).setID(string2);
        }
        if ((object = this.n) != null) {
            ((b)object).setID(string2);
        }
        if ((object = this.f) != null) {
            ((com.tencent.liteav.beauty.d)object).setID(string2);
        }
        if ((object = this.e) != null) {
            String string3 = this.getID();
            object.a(string3);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("setID:");
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        TXCLog.w("TXCCaptureAndEnc", string2);
    }
}

