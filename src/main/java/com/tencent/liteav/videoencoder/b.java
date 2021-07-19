/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Bundle
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav.videoencoder;

import android.os.Bundle;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.TXCTimeUtil;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.beauty.b.k;
import com.tencent.liteav.videoencoder.TXCSWVideoEncoder;
import com.tencent.liteav.videoencoder.TXSVideoEncoderParam;
import com.tencent.liteav.videoencoder.a;
import com.tencent.liteav.videoencoder.b$1;
import com.tencent.liteav.videoencoder.b$2;
import com.tencent.liteav.videoencoder.b$3;
import com.tencent.liteav.videoencoder.b$4;
import com.tencent.liteav.videoencoder.b$5;
import com.tencent.liteav.videoencoder.b$6;
import com.tencent.liteav.videoencoder.b$a;
import com.tencent.liteav.videoencoder.c;
import com.tencent.liteav.videoencoder.d;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class b
extends com.tencent.liteav.basic.module.a {
    private static Integer s = 1;
    private static final String v = b.class.getSimpleName();
    private static int w = 0;
    private final com.tencent.liteav.basic.util.c a;
    private c b;
    private d c;
    private WeakReference d;
    private int e;
    private int f;
    private int g;
    private Timer h;
    private TimerTask i;
    private LinkedList j;
    private TXSVideoEncoderParam k;
    private float l;
    private float m;
    private float n;
    private int o;
    private int p;
    private com.tencent.liteav.basic.opengl.b q;
    private h r;
    private boolean t;
    private k u;

    public b(int n10) {
        int n11 = (int)TimeUnit.SECONDS.toMillis(5);
        LinkedList linkedList = new LinkedList("video-encoder", n11);
        this.a = linkedList;
        this.b = null;
        this.c = null;
        this.d = null;
        this.e = 0;
        this.f = 2;
        this.g = 1;
        this.h = null;
        this.i = null;
        this.j = linkedList = new LinkedList();
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0;
        this.p = 0;
        this.f = n10;
    }

    public static /* synthetic */ float a(b b10, float f10) {
        b10.l = f10;
        return f10;
    }

    public static /* synthetic */ int a(b b10, int n10) {
        b10.g = n10;
        return n10;
    }

    public static /* synthetic */ com.tencent.liteav.basic.opengl.b a(b b10) {
        return b10.q;
    }

    public static /* synthetic */ com.tencent.liteav.basic.opengl.b a(b b10, com.tencent.liteav.basic.opengl.b b11) {
        b10.q = b11;
        return b11;
    }

    public static /* synthetic */ k a(b b10, k k10) {
        b10.u = k10;
        return k10;
    }

    public static /* synthetic */ c a(b b10, c c10) {
        b10.b = c10;
        return c10;
    }

    private void a(int n10, String string2) {
        Object object = this.d;
        if (object == null) {
            return;
        }
        if ((object = (com.tencent.liteav.basic.b.b)((Reference)object).get()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", n10);
        long l10 = TXCTimeUtil.getTimeTick();
        bundle.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        bundle.putLong("EVT_UTC_TIME", l10);
        bundle.putCharSequence("EVT_MSG", (CharSequence)string2);
        object.onNotifyEvent(n10, bundle);
    }

    private void a(int n10, String string2, int n11) {
        Object object = this.d;
        if (object == null) {
            return;
        }
        if ((object = (com.tencent.liteav.basic.b.b)((Reference)object).get()) == null) {
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("EVT_ID", n10);
        long l10 = TXCTimeUtil.getTimeTick();
        bundle.putLong("EVT_TIME", l10);
        l10 = TXCTimeUtil.getUtcTimeTick();
        bundle.putLong("EVT_UTC_TIME", l10);
        bundle.putCharSequence("EVT_MSG", (CharSequence)string2);
        bundle.putInt("EVT_PARAM1", n11);
        object.onNotifyEvent(n10, bundle);
    }

    public static /* synthetic */ void a(b b10, int n10, String string2) {
        b10.a(n10, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private boolean a(Queue queue) {
        // MONITORENTER : queue
        boolean bl2 = queue.isEmpty();
        if (bl2) {
            // MONITOREXIT : queue
            return false;
        }
        Object object = queue.poll();
        object = (Runnable)object;
        // MONITOREXIT : queue
        if (object == null) {
            return false;
        }
        object.run();
        return true;
    }

    public static /* synthetic */ float b(b b10, float f10) {
        b10.m = f10;
        return f10;
    }

    public static /* synthetic */ k b(b b10) {
        return b10.u;
    }

    public static /* synthetic */ float c(b b10, float f10) {
        b10.n = f10;
        return f10;
    }

    public static /* synthetic */ LinkedList c(b b10) {
        return b10.j;
    }

    public static /* synthetic */ c d(b b10) {
        return b10.b;
    }

    public static /* synthetic */ d e(b b10) {
        return b10.c;
    }

    private void e() {
        Timer timer;
        TimerTask timerTask = this.i;
        if (timerTask == null) {
            this.i = timerTask = new b$a(this);
        }
        this.h = timer = new Timer();
        TimerTask timerTask2 = this.i;
        timer.schedule(timerTask2, 1000L, 1000L);
    }

    public static /* synthetic */ int f(b b10) {
        return b10.e;
    }

    private void f() {
        Object object = this.h;
        if (object != null) {
            ((Timer)object).cancel();
            this.h = null;
        }
        if ((object = this.i) != null) {
            this.i = null;
        }
    }

    public static /* synthetic */ int g(b b10) {
        return b10.g;
    }

    private void g() {
        b$6 b$6 = new b$6(this);
        this.a(b$6);
        TXCLog.w("TXCVideoEncoder", "switchSWToHW");
    }

    public static /* synthetic */ TXSVideoEncoderParam h(b b10) {
        return b10.k;
    }

    public static /* synthetic */ int i(b b10) {
        return b10.o;
    }

    public static /* synthetic */ int j(b b10) {
        return b10.p;
    }

    public static /* synthetic */ int k(b b10) {
        int n10;
        b10.o = n10 = b10.o + 1;
        return n10;
    }

    public static /* synthetic */ float l(b b10) {
        return b10.l;
    }

    public static /* synthetic */ float m(b b10) {
        return b10.m;
    }

    public static /* synthetic */ float n(b b10) {
        return b10.n;
    }

    public static /* synthetic */ void o(b b10) {
        b10.g();
    }

    public static /* synthetic */ void p(b b10) {
        b10.f();
    }

    public int a(TXSVideoEncoderParam tXSVideoEncoderParam) {
        int n10;
        int n11;
        Object object;
        this.k = tXSVideoEncoderParam;
        int n12 = tXSVideoEncoderParam.enableBlackList;
        int n13 = 2;
        if (n12 != 0) {
            object = com.tencent.liteav.basic.c.c.a();
            n12 = ((com.tencent.liteav.basic.c.c)object).d();
        } else {
            n12 = n13;
        }
        int n14 = this.f;
        String string2 = "Enables hardware encoding";
        int n15 = 3;
        int n16 = 1008;
        int n17 = 1;
        if (n14 == n17 && n12 != 0) {
            this.b = object = new a();
            this.g = n17;
            this.a(n16, string2, n17);
        } else if (n14 == n15 && (n14 = tXSVideoEncoderParam.width) == (n11 = 720) && (n14 = tXSVideoEncoderParam.height) == (n11 = 1280) && n12 != 0) {
            this.b = object = new a();
            this.g = n17;
            this.a(n16, string2, n17);
        } else {
            this.b = object = new TXCSWVideoEncoder();
            this.g = n13;
            object = "Enables software encoding";
            this.a(n16, (String)object, n13);
        }
        n12 = 4007;
        n13 = this.g;
        long l10 = n13;
        Object object2 = l10;
        this.setStatusValue(n12, object2);
        object = this.b;
        if (object != null) {
            object2 = this.c;
            if (object2 != null) {
                ((c)object).setListener((d)object2);
            }
            if ((n12 = this.e) != 0) {
                object2 = this.b;
                ((c)object2).setBitrate(n12);
            }
            object = this.b;
            object2 = this.getID();
            ((com.tencent.liteav.basic.module.a)object).setID((String)object2);
            object = this.b;
            n10 = ((c)object).start(tXSVideoEncoderParam);
            if (n10 != 0) {
                n12 = this.g;
                object = n12 == n17 ? "hw" : "sw";
                object2 = v;
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("start video encode ");
                stringBuilder.append((String)object);
                object = stringBuilder.toString();
                TXCLog.i((String)object2, (String)object);
                return n10;
            }
        } else {
            n10 = 10000002;
        }
        if ((n12 = this.f) == n15) {
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            this.o = 0;
            object = com.tencent.liteav.basic.c.c.a();
            this.p = n12 = ((com.tencent.liteav.basic.c.c)object).h();
            this.e();
        }
        return n10;
    }

    public long a(int n10, int n11, int n12, long l10) {
        long l11;
        int n13;
        Object object = this.a;
        ((com.tencent.liteav.basic.util.c)object).a();
        while ((n13 = this.a((Queue)(object = this.j))) != 0) {
        }
        object = this.b;
        if (object != null) {
            long l12 = this.c();
            Object object2 = l12;
            this.setStatusValue(4002, object2);
            object2 = this.k;
            int n14 = ((TXSVideoEncoderParam)object2).streamType;
            double d10 = this.b();
            Number number = d10;
            this.setStatusValue(4001, n14, number);
            n13 = this.g;
            n14 = 1;
            if (n13 == n14) {
                n13 = 8002;
                object2 = this.k;
                n14 = ((TXSVideoEncoderParam)object2).streamType;
                int n15 = this.d();
                number = n15;
                this.setStatusValue(n13, n14, number);
            }
            c c10 = this.b;
            l11 = c10.pushVideoFrame(n10, n11, n12, l10);
        } else {
            l11 = 10000002L;
        }
        return l11;
    }

    public long a(byte[] byArray, int n10, int n11, int n12, long l10) {
        b$2 b$2;
        Object object = this.q;
        if (object == null) {
            return -1;
        }
        h h10 = this.r;
        object = b$2;
        b$2 = new b$2(this, n11, n12, n10, byArray, l10);
        h10.b(b$2);
        return 0L;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public EGLContext a(int n10, int n11) {
        int n12 = this.t;
        EGLContext eGLContext = null;
        if (n12 == 0) {
            h h10;
            n12 = 1;
            this.t = n12;
            Object object = s;
            synchronized (object) {
                Integer n13;
                CharSequence charSequence = new StringBuilder();
                Object object2 = "CVGLThread";
                charSequence.append((String)object2);
                object2 = s;
                int n14 = (Integer)object2 + n12;
                s = n13 = Integer.valueOf(n14);
                charSequence.append(object2);
                charSequence = charSequence.toString();
                this.r = h10 = new h((String)charSequence);
            }
            boolean[] blArray = new boolean[n12];
            object = new b$1(this, n10, n11, blArray);
            h10.a((Runnable)object);
            Object var12_12 = null;
            n10 = blArray[0];
            if (n10 == 0) return null;
            return this.q.d();
        }
        com.tencent.liteav.basic.opengl.b b10 = this.q;
        if (b10 == null) return eGLContext;
        return b10.d();
    }

    public void a() {
        b$3 b$3;
        Object object = this.r;
        if (object != null) {
            com.tencent.liteav.basic.opengl.b b10 = this.q;
            b$3 = new b$3(this, b10);
            ((h)object).b(b$3);
            this.r = null;
            this.q = null;
        } else {
            this.j.clear();
            object = this.b;
            if (object != null) {
                ((c)object).stop();
            }
        }
        int n10 = this.f;
        int n11 = 3;
        b$3 = null;
        if (n10 == n11) {
            n10 = 0;
            object = null;
            this.l = 0.0f;
            this.m = 0.0f;
            this.n = 0.0f;
            this.o = 0;
            this.f();
        }
        this.c = null;
        this.e = 0;
    }

    public void a(int n10) {
        c c10 = this.b;
        if (c10 != null) {
            c10.setRotation(n10);
        }
    }

    public void a(com.tencent.liteav.basic.b.b b10) {
        WeakReference<com.tencent.liteav.basic.b.b> weakReference;
        this.d = weakReference = new WeakReference<com.tencent.liteav.basic.b.b>(b10);
    }

    public void a(d object) {
        this.c = object;
        object = new b$4(this);
        this.a((Runnable)object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable runnable) {
        LinkedList linkedList = this.j;
        synchronized (linkedList) {
            LinkedList linkedList2 = this.j;
            linkedList2.add(runnable);
            return;
        }
    }

    public void a(boolean bl2) {
        c c10 = this.b;
        if (c10 != null) {
            c10.setXMirror(bl2);
        }
    }

    public double b() {
        c c10 = this.b;
        double d10 = c10 != null ? c10.getRealFPS() : 0.0;
        return d10;
    }

    public void b(int n10) {
        this.e = n10;
        b$5 b$5 = new b$5(this);
        this.a(b$5);
    }

    public void b(boolean bl2) {
        c c10 = this.b;
        if (c10 != null) {
            c10.setGLFinishedTextureNeed(bl2);
        }
    }

    public long c() {
        c c10 = this.b;
        long l10 = c10 != null ? c10.getRealBitrate() : 0L;
        return l10;
    }

    public boolean c(int n10) {
        c c10 = this.b;
        if (c10 != null) {
            c10.setEncodeIdrFpsFromQos(n10);
            return true;
        }
        return false;
    }

    public int d() {
        int n10;
        c c10 = this.b;
        if (c10 != null) {
            n10 = c10.getEncodeCost();
        } else {
            n10 = 0;
            c10 = null;
        }
        return n10;
    }

    public void setID(String string2) {
        super.setID(string2);
        Object object = this.b;
        if (object != null) {
            ((com.tencent.liteav.basic.module.a)object).setID(string2);
        }
        object = (long)this.g;
        this.setStatusValue(4007, object);
    }
}

