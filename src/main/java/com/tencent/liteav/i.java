/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  javax.microedition.khronos.egl.EGLContext
 */
package com.tencent.liteav;

import android.content.Context;
import com.tencent.liteav.basic.a.c;
import com.tencent.liteav.basic.b.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.basic.module.TXCStatus;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.g;
import com.tencent.liteav.n;
import com.tencent.liteav.o;
import com.tencent.liteav.screencapture.a;
import com.tencent.liteav.screencapture.a$a;
import java.lang.ref.WeakReference;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.TimeUnit;
import javax.microedition.khronos.egl.EGLContext;

public class i
implements n,
com.tencent.liteav.screencapture.b {
    private final a a;
    private o b;
    private EGLContext c = null;
    private WeakReference d = null;
    private int e;
    private e f;
    private int g;
    private int h;
    private String i = "";
    private int j = 0;
    private long k;
    private long l;
    private long m;
    private boolean n;
    private final Queue o;

    public i(Context object, g objectArray, a$a a$a) {
        int n10;
        Object object2 = new LinkedList();
        this.o = object2;
        boolean bl2 = objectArray.V;
        this.a = object2 = new a((Context)object, bl2, a$a);
        ((a)object2).a(this);
        objectArray.a();
        int n11 = objectArray.a;
        int n12 = objectArray.b;
        object = this.b(n11, n12);
        this.f = object;
        this.e = n12 = objectArray.h;
        this.g = n12 = objectArray.a;
        this.h = n10 = objectArray.b;
        objectArray = new Object[3];
        objectArray[0] = object;
        object = n12;
        objectArray[1] = object;
        object = this.h;
        objectArray[2] = object;
        TXCLog.i("TXCScreenCaptureSource", "capture size: %s, encode size: %dx%d", objectArray);
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

    private e b(int n10, int n11) {
        boolean bl2 = n10 > n11;
        e e10 = new e();
        int n12 = 1280;
        if (n10 <= n12 && n11 <= n12) {
            n10 = 720;
            float f10 = 1.009E-42f;
            n11 = bl2 ? n12 : n10;
            e10.a = n11;
            if (bl2) {
                n12 = n10;
            }
            e10.b = n12;
        } else {
            n12 = bl2 ? Math.max(n10, n11) : Math.min(n10, n11);
            e10.a = n12;
            n10 = bl2 ? Math.min(n10, n11) : Math.max(n10, n11);
            e10.b = n10;
        }
        return e10;
    }

    private void f(boolean n10) {
        if (n10 != 0) {
            n10 = this.g;
            int n11 = this.h;
            if (n10 > n11) {
                this.a(n11, n10);
            }
        } else {
            n10 = this.g;
            int n12 = this.h;
            if (n10 < n12) {
                this.a(n12, n10);
            }
        }
    }

    public void a() {
        long l10;
        int n10 = 1;
        Object object = new Object[n10];
        Integer n11 = this.hashCode();
        object[0] = n11;
        object = String.format("VideoCapture[%d]: start screen", object);
        Monitor.a(2, (String)object, "", 0);
        this.k = l10 = 0L;
        this.l = l10;
        this.m = l10;
        this.n = n10;
        a a10 = this.a;
        object = this.f;
        int n12 = object.a;
        int n13 = object.b;
        int n14 = this.e;
        a10.a(n12, n13, n14);
    }

    public void a(float f10) {
    }

    public void a(float f10, float f11) {
    }

    public void a(int n10, int n11) {
        this.g = n10;
        this.h = n11;
    }

    public void a(int n10, EGLContext object, int n11, int n12, int n13, long l10) {
        Object object2;
        Object object3;
        Object object4;
        int n14;
        this.c = object;
        while ((n14 = this.a((Queue)(object = this.o))) != 0) {
        }
        object = "TXCScreenCaptureSource";
        if (n10 != 0) {
            TXCLog.e((String)object, "onScreenCaptureFrame failed");
            return;
        }
        n10 = (int)(this.n ? 1 : 0);
        int n15 = 1;
        if (n10 != 0) {
            this.n = false;
            n10 = 2;
            Object object5 = new Object[n15];
            int n16 = this.hashCode();
            object5[0] = object4 = Integer.valueOf(n16);
            object5 = String.format("VideoCapture[%d]: capture first frame", object5);
            Monitor.a(n10, (String)object5, "", 0);
            object3 = this.d;
            object2 = 1007;
            object4 = "First frame capture completed";
            com.tencent.liteav.basic.util.g.a((WeakReference)object3, (int)object2, (String)object4);
            object3 = "on Got first frame";
            TXCLog.i((String)object, (String)object3);
        }
        long l11 = this.k;
        long l12 = 1L;
        this.k = l11 += l12;
        l11 = System.currentTimeMillis();
        long l13 = this.l;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        long l14 = (l11 -= l13) - (l12 = timeUnit.toMillis(l12));
        object2 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object2 >= 0) {
            l12 = this.k;
            l13 = this.m;
            l13 = l12 - l13;
            double d10 = l13;
            double d11 = 1000.0;
            d10 *= d11;
            double d12 = l11;
            this.m = l12;
            this.l = l11 = System.currentTimeMillis();
            object3 = this.i;
            n14 = 1001;
            object2 = this.j;
            object4 = d10 /= d12;
            TXCStatus.a((String)object3, n14, (int)object2, object4);
        }
        if ((object3 = this.b) != null) {
            if (n12 >= n13) {
                n15 = 0;
            }
            this.f(n15 != 0);
            object3 = new com.tencent.liteav.basic.structs.b();
            ((com.tencent.liteav.basic.structs.b)object3).e = n12;
            ((com.tencent.liteav.basic.structs.b)object3).f = n13;
            ((com.tencent.liteav.basic.structs.b)object3).g = n14 = this.g;
            ((com.tencent.liteav.basic.structs.b)object3).h = n15 = this.h;
            ((com.tencent.liteav.basic.structs.b)object3).a = n11;
            ((com.tencent.liteav.basic.structs.b)object3).b = 0;
            ((com.tencent.liteav.basic.structs.b)object3).j = 0;
            object = com.tencent.liteav.basic.util.g.a(n12, n13, n14, n15);
            ((com.tencent.liteav.basic.structs.b)object3).l = object;
            object = this.b;
            object.b((com.tencent.liteav.basic.structs.b)object3);
        }
    }

    public void a(c c10) {
    }

    public void a(b b10) {
        Object object = new WeakReference(b10);
        this.d = object;
        object = this.a;
        if (object != null) {
            ((a)object).a(b10);
        }
    }

    public void a(com.tencent.liteav.basic.structs.b b10) {
    }

    public void a(o o10) {
        this.b = o10;
    }

    public void a(Object object) {
        boolean bl2;
        while (bl2 = this.a((Queue)(object = this.o))) {
        }
        object = this.b;
        if (object != null) {
            object.m();
        }
    }

    public void a(Runnable runnable) {
        a a10 = this.a;
        if (a10 != null) {
            a10.a(runnable);
        }
    }

    public void a(String string2) {
        this.i = string2;
    }

    public void a(boolean bl2) {
        Object object = new Object[1];
        Integer n10 = this.hashCode();
        object[0] = n10;
        object = String.format("VideoCapture[%d]: stop screen", object);
        Monitor.a(2, (String)object, "", 0);
        this.a.a((Object)null);
    }

    public boolean a(int n10) {
        return false;
    }

    public void b() {
        this.a.a(true);
    }

    public void b(int n10) {
    }

    public void b(boolean bl2) {
        Object object;
        int n10 = this.g;
        int n11 = this.h;
        Object[] objectArray = this.b(n10, n11);
        if ((n11 = (int)(objectArray.equals(object = this.f) ? 1 : 0)) == 0) {
            Object object2;
            this.f = objectArray;
            object = this.a;
            int n12 = objectArray.a;
            int n13 = objectArray.b;
            ((a)object).a(n12, n13);
            int n14 = 3;
            objectArray = new Object[n14];
            objectArray[0] = object2 = this.f;
            objectArray[1] = object2 = Integer.valueOf(this.g);
            n11 = 2;
            n12 = this.h;
            objectArray[n11] = object2 = Integer.valueOf(n12);
            object = "TXCScreenCaptureSource";
            object2 = "capture size: %s, encode size: %dx%d";
            TXCLog.i((String)object, (String)object2, objectArray);
        }
    }

    public void c() {
        this.a.a(false);
    }

    public void c(int n10) {
    }

    public void c(boolean bl2) {
    }

    public void d(int n10) {
    }

    public boolean d() {
        return true;
    }

    public boolean d(boolean bl2) {
        return false;
    }

    public int e() {
        return 0;
    }

    public void e(int n10) {
    }

    public void e(boolean bl2) {
    }

    public EGLContext f() {
        return this.c;
    }

    public void f(int n10) {
        this.e = n10;
        this.a.a(n10);
    }

    public void g(int n10) {
        this.j = n10;
    }

    public boolean g() {
        return false;
    }
}

