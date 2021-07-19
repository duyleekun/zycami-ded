/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  javax.microedition.khronos.egl.EGLConfig
 *  javax.microedition.khronos.opengles.GL10
 */
package com.tencent.liteav.renderer;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$h;
import com.tencent.liteav.renderer.TXCGLSurfaceViewBase$j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public class TXCGLSurfaceViewBase$i
extends Thread {
    private boolean a;
    private boolean b;
    private boolean c;
    private boolean d;
    private boolean e;
    private boolean f;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private boolean o;
    private boolean p;
    private ArrayList q;
    private boolean r;
    private TXCGLSurfaceViewBase$h s;
    private WeakReference t;

    public TXCGLSurfaceViewBase$i(WeakReference weakReference) {
        boolean bl2;
        ArrayList arrayList;
        this.q = arrayList = new ArrayList();
        this.r = bl2 = true;
        this.l = 0;
        this.m = 0;
        this.o = bl2;
        this.n = (int)(bl2 ? 1 : 0);
        this.t = weakReference;
    }

    public static /* synthetic */ boolean a(TXCGLSurfaceViewBase$i tXCGLSurfaceViewBase$i, boolean bl2) {
        tXCGLSurfaceViewBase$i.b = bl2;
        return bl2;
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     * Converted monitor instructions to comments
     * Lifted jumps to return sites
     */
    private void j() {
        var1_1 = this;
        var3_5 = this.t;
        var2_2 = new TXCGLSurfaceViewBase$h((WeakReference)var3_5);
        this.s = var2_2;
        var4_6 = 0;
        var3_5 = null;
        this.h = false;
        this.i = false;
        var5_7 = 0;
        var2_2 = null;
        var6_8 = 0.0f;
        var7_9 = 0;
        var8_10 = false;
        var9_11 = false;
        var10_12 = null;
        var11_13 = false;
        var12_14 = null;
        var13_15 = false;
        var14_16 = false;
        var15_17 = false;
        var16_18 = 0;
        var17_19 = 0;
        var18_20 = null;
        block24: while (true) {
            var19_21 = null;
            block25: while (true) {
                var20_22 = TXCGLSurfaceViewBase.f();
                // MONITORENTER : var20_22
                while (true) {
                    block62: {
                        block63: {
                            block58: {
                                block59: {
                                    block61: {
                                        block60: {
                                            if ((var21_23 = var1_1.a) != 0) {
                                                // MONITOREXIT : var20_22
                                                var3_5 = TXCGLSurfaceViewBase.f();
                                                // MONITORENTER : var3_5
                                                this.k();
                                                this.l();
                                                // MONITOREXIT : var3_5
                                                return;
                                            }
                                            var22_24 = var1_1.q;
                                            var21_23 = var22_24.isEmpty();
                                            if (var21_23 != 0) break block60;
                                            var22_24 = var1_1.q;
                                            var19_21 = null;
                                            var19_21 = var22_24 = var22_24.remove(0);
                                            var19_21 = (Runnable)var22_24;
                                            var4_6 = 0;
                                            var3_5 = null;
                                            break block61;
                                        }
                                        var21_23 = var1_1.d;
                                        var4_6 = var1_1.c;
                                        if (var21_23 != var4_6) {
                                            var1_1.d = var4_6;
                                            var22_24 = TXCGLSurfaceViewBase.f();
                                            var22_24.notifyAll();
                                        } else {
                                            var4_6 = 0;
                                            var3_5 = null;
                                        }
                                        var21_23 = var1_1.k;
                                        if (var21_23 != 0) {
                                            this.k();
                                            this.l();
                                            var21_23 = 0;
                                            var23_25 = 0.0f;
                                            var22_24 = null;
                                            var1_1.k = false;
                                            var8_10 = true;
                                        }
                                        if (var5_7 != 0) {
                                            this.k();
                                            this.l();
                                            var21_23 = 0;
                                            var23_25 = 0.0f;
                                            var22_24 = null;
                                        } else {
                                            var21_23 = var5_7;
                                            var23_25 = var6_8;
                                        }
                                        if (var4_6 != 0 && (var5_7 = var1_1.i) != 0) {
                                            this.k();
                                        }
                                        if (var4_6 != 0 && (var5_7 = var1_1.h) != 0) {
                                            var2_2 = var1_1.t;
                                            var2_2 = var2_2.get();
                                            if ((var2_2 = (TXCGLSurfaceViewBase)var2_2) == null) {
                                                var5_7 = 0;
                                                var6_8 = 0.0f;
                                                var2_2 = null;
                                            } else {
                                                var5_7 = (int)TXCGLSurfaceViewBase.a((TXCGLSurfaceViewBase)var2_2);
                                            }
                                            if (var5_7 == 0 || (var5_7 = (int)(var2_2 = TXCGLSurfaceViewBase.f()).a()) != 0) {
                                                this.l();
                                            }
                                        }
                                        if (var4_6 != 0 && (var5_7 = (var2_2 = TXCGLSurfaceViewBase.f()).b()) != 0) {
                                            var2_2 = var1_1.s;
                                            var2_2.h();
                                        }
                                        if ((var5_7 = var1_1.e) == 0 && (var5_7 = var1_1.g) == 0) {
                                            var5_7 = var1_1.i;
                                            if (var5_7 != 0) {
                                                this.k();
                                            }
                                            var4_6 = 1;
                                            var1_1.g = var4_6;
                                            var4_6 = 0;
                                            var3_5 = null;
                                            var1_1.f = false;
                                            var2_2 = TXCGLSurfaceViewBase.f();
                                            var2_2.notifyAll();
                                        }
                                        if ((var5_7 = var1_1.e) != 0 && (var5_7 = var1_1.g) != 0) {
                                            var4_6 = 0;
                                            var3_5 = null;
                                            var1_1.g = false;
                                            var2_2 = TXCGLSurfaceViewBase.f();
                                            var2_2.notifyAll();
                                        }
                                        if (var7_9 != 0) {
                                            var4_6 = 1;
                                            var1_1.p = var4_6;
                                            var2_2 = TXCGLSurfaceViewBase.f();
                                            var2_2.notifyAll();
                                            var7_9 = 0;
                                            var15_17 = false;
                                        }
                                        if ((var5_7 = this.m()) == 0) break block62;
                                        var5_7 = (int)var1_1.h;
                                        if (var5_7 == 0) {
                                            if (var8_10) {
                                                var8_10 = false;
                                            } else {
                                                var2_2 = TXCGLSurfaceViewBase.f();
                                                var5_7 = (int)var2_2.b(var1_1);
                                                if (var5_7 != 0) {
                                                    try {
                                                        var2_2 = var1_1.s;
                                                        var2_2.a();
                                                    }
                                                    catch (RuntimeException var2_3) {
                                                        var3_5 = TXCGLSurfaceViewBase.f();
                                                        var3_5.c(var1_1);
                                                        var3_5 = "TXCGLSurfaceViewBase";
                                                        var10_12 = "egl start error ";
                                                        TXCLog.e((String)var3_5, (String)var10_12, var2_3);
                                                    }
                                                    var4_6 = 1;
                                                    var1_1.h = var4_6;
                                                    var2_2 = TXCGLSurfaceViewBase.f();
                                                    var2_2.notifyAll();
                                                    var9_11 = true;
                                                }
                                            }
                                        }
                                        if ((var5_7 = (int)var1_1.h) != 0 && (var5_7 = (int)var1_1.i) == 0) {
                                            var4_6 = 1;
                                            var1_1.i = var4_6;
                                            var11_13 = true;
                                            var13_15 = true;
                                            var14_16 = true;
                                        }
                                        if ((var5_7 = (int)var1_1.i) == 0) break block62;
                                        var5_7 = (int)var1_1.r;
                                        if (var5_7 != 0) {
                                            var5_7 = var1_1.l;
                                            var4_6 = var1_1.m;
                                            var11_13 = false;
                                            var12_14 = null;
                                            var1_1.r = false;
                                            var16_18 = var5_7;
                                            var17_19 = var4_6;
                                            var4_6 = 0;
                                            var3_5 = null;
                                            var11_13 = true;
                                            var14_16 = true;
                                            var15_17 = true;
                                        } else {
                                            var4_6 = 0;
                                            var3_5 = null;
                                        }
                                        var1_1.o = false;
                                        var2_2 = TXCGLSurfaceViewBase.f();
                                        var2_2.notifyAll();
                                        var5_7 = var21_23;
                                        var6_8 = var23_25;
                                    }
                                    // MONITOREXIT : var20_22
                                    if (var19_21 == null) ** GOTO lbl176
                                    var19_21.run();
                                    continue block24;
lbl176:
                                    // 1 sources

                                    if (!var11_13) ** GOTO lbl-1000
                                    var22_24 = var1_1.s;
                                    var21_23 = var22_24.b();
                                    if (var21_23 == 0) ** GOTO lbl-1000
                                    var22_24 = TXCGLSurfaceViewBase.f();
                                    // MONITORENTER : var22_24
                                    var1_1.j = var11_13 = true;
                                    var12_14 = TXCGLSurfaceViewBase.f();
                                    var12_14.notifyAll();
                                    // MONITOREXIT : var22_24
                                    var11_13 = false;
                                    var12_14 = null;
                                    ** GOTO lbl-1000
lbl-1000:
                                    // 1 sources

                                    {
                                        var22_24 = TXCGLSurfaceViewBase.f();
                                        // MONITORENTER : var22_24
                                    }
                                    var1_1.j = var24_26 = 1;
                                    var1_1.f = var24_26;
                                    var20_22 = TXCGLSurfaceViewBase.f();
                                    var20_22.notifyAll();
                                    // MONITOREXIT : var22_24
                                    continue block25;
lbl-1000:
                                    // 2 sources

                                    {
                                        if (var13_15) {
                                            var22_24 = var1_1.s;
                                            var18_20 = var22_24 = var22_24.e();
                                            var18_20 = (GL10)var22_24;
                                            var22_24 = TXCGLSurfaceViewBase.f();
                                            var22_24.a((GL10)var18_20);
                                            var13_15 = false;
                                        }
                                        if (var9_11) {
                                            var22_24 = var1_1.t;
                                            var22_24 = var22_24.get();
                                            if ((var22_24 = (TXCGLSurfaceViewBase)var22_24) != null) {
                                                var22_24 = TXCGLSurfaceViewBase.b((TXCGLSurfaceViewBase)var22_24);
                                                var10_12 = var1_1.s;
                                                var10_12 = var10_12.d;
                                                var22_24.onSurfaceCreated((GL10)var18_20, (EGLConfig)var10_12);
                                            }
                                            var9_11 = false;
                                            var10_12 = null;
                                        }
                                        if (var14_16) {
                                            var22_24 = var1_1.t;
                                            var22_24 = var22_24.get();
                                            if ((var22_24 = (TXCGLSurfaceViewBase)var22_24) != null) {
                                                var22_24 = TXCGLSurfaceViewBase.b((TXCGLSurfaceViewBase)var22_24);
                                                var22_24.onSurfaceChanged((GL10)var18_20, var16_18, var17_19);
                                            }
                                            var14_16 = false;
                                        }
                                        var22_24 = var1_1.t;
                                        var22_24 = var22_24.get();
                                        var22_24 = (TXCGLSurfaceViewBase)var22_24;
                                        var24_26 = 12288;
                                        if (var22_24 != null) {
                                            var3_5 = TXCGLSurfaceViewBase.b((TXCGLSurfaceViewBase)var22_24);
                                            var3_5.onDrawFrame((GL10)var18_20);
                                            var4_6 = var22_24.c();
                                        } else {
                                            var4_6 = var24_26;
                                        }
                                        if (var4_6 == var24_26) break block58;
                                        var21_23 = 12302;
                                        var23_25 = 1.7239E-41f;
                                        if (var4_6 == var21_23) break block59;
                                        var22_24 = "GLThread";
                                        var20_22 = "eglSwapBuffers";
                                        TXCGLSurfaceViewBase$h.a((String)var22_24, (String)var20_22, var4_6);
                                        var3_5 = TXCGLSurfaceViewBase.f();
                                        // MONITORENTER : var3_5
                                    }
                                    var21_23 = 1;
                                    var23_25 = 1.4E-45f;
                                    var1_1.f = var21_23;
                                    var20_22 = TXCGLSurfaceViewBase.f();
                                    var20_22.notifyAll();
                                    // MONITOREXIT : var3_5
                                    break block63;
                                }
                                var21_23 = 1;
                                var23_25 = 1.4E-45f;
                                var5_7 = var21_23;
                                var6_8 = var23_25;
                                break block63;
                            }
                            var21_23 = 1;
                            var23_25 = 1.4E-45f;
                        }
                        if (var15_17) {
                            var7_9 = var21_23;
                        }
                        var4_6 = 0;
                        var3_5 = null;
                        continue block25;
                    }
                    var2_2 = TXCGLSurfaceViewBase.f();
                    var2_2.wait();
                    var5_7 = var21_23;
                    var6_8 = var23_25;
                    var4_6 = 0;
                    var3_5 = null;
                }
                break;
            }
            break;
        }
        catch (Throwable var2_4) {
            var3_5 = TXCGLSurfaceViewBase.f();
            // MONITORENTER : var3_5
            this.k();
            this.l();
            // MONITOREXIT : var3_5
            throw var2_4;
        }
    }

    private void k() {
        boolean bl2 = this.i;
        if (bl2) {
            bl2 = false;
            this.i = false;
            TXCGLSurfaceViewBase$h tXCGLSurfaceViewBase$h = this.s;
            tXCGLSurfaceViewBase$h.g();
        }
    }

    private void l() {
        boolean bl2 = this.h;
        if (bl2) {
            this.s.h();
            bl2 = false;
            TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = null;
            this.h = false;
            TXCGLSurfaceViewBase tXCGLSurfaceViewBase = (TXCGLSurfaceViewBase)((Object)this.t.get());
            if (tXCGLSurfaceViewBase != null) {
                tXCGLSurfaceViewBase.f = false;
            }
            tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
            tXCGLSurfaceViewBase$j.c(this);
        }
    }

    private boolean m() {
        int n10 = this.d;
        int n11 = 1;
        if (n10 != 0 || (n10 = this.e) == 0 || (n10 = this.f) != 0 || (n10 = this.l) <= 0 || (n10 = this.m) <= 0 || (n10 = (int)(this.o ? 1 : 0)) == 0 && (n10 = this.n) != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10) {
        int n11;
        if (n10 >= 0 && n10 <= (n11 = 1)) {
            TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
            synchronized (tXCGLSurfaceViewBase$j) {
                this.n = n10;
                TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j2 = TXCGLSurfaceViewBase.f();
                tXCGLSurfaceViewBase$j2.notifyAll();
                return;
            }
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("renderMode");
        throw illegalArgumentException;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(int n10, int n11) {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
        synchronized (tXCGLSurfaceViewBase$j) {
            this.l = n10;
            this.m = n11;
            n10 = 1;
            this.r = n10;
            this.o = n10;
            n10 = 0;
            Object object = null;
            this.p = false;
            object = TXCGLSurfaceViewBase.f();
            object.notifyAll();
            while ((n10 = (int)(this.b ? 1 : 0)) == 0 && (n10 = (int)(this.d ? 1 : 0)) == 0 && (n10 = (int)(this.p ? 1 : 0)) == 0 && (n10 = (int)(this.d() ? 1 : 0)) != 0) {
                try {
                    object = TXCGLSurfaceViewBase.f();
                    object.wait();
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void a(Runnable object) {
        if (object != null) {
            TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
            synchronized (tXCGLSurfaceViewBase$j) {
                ArrayList arrayList = this.q;
                arrayList.add(object);
                object = TXCGLSurfaceViewBase.f();
                object.notifyAll();
                return;
            }
        }
        object = new IllegalArgumentException("r must not be null");
        throw object;
    }

    public boolean a() {
        return this.s.c();
    }

    public int b() {
        return this.s.d();
    }

    public TXCGLSurfaceViewBase$h c() {
        return this.s;
    }

    public boolean d() {
        boolean bl2 = this.h;
        bl2 = bl2 && (bl2 = this.i) && (bl2 = this.m());
        return bl2;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int e() {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
        synchronized (tXCGLSurfaceViewBase$j) {
            return this.n;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void f() {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
        synchronized (tXCGLSurfaceViewBase$j) {
            boolean bl2;
            this.e = bl2 = true;
            bl2 = false;
            Object object = null;
            this.j = false;
            object = TXCGLSurfaceViewBase.f();
            object.notifyAll();
            while ((bl2 = this.g) && !(bl2 = this.j) && !(bl2 = this.b)) {
                try {
                    object = TXCGLSurfaceViewBase.f();
                    object.wait();
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void g() {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
        synchronized (tXCGLSurfaceViewBase$j) {
            boolean bl2 = false;
            Object object = null;
            this.e = false;
            object = TXCGLSurfaceViewBase.f();
            object.notifyAll();
            while (!(bl2 = this.g) && !(bl2 = this.b)) {
                try {
                    object = TXCGLSurfaceViewBase.f();
                    object.wait();
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                }
            }
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void h() {
        TXCGLSurfaceViewBase$j tXCGLSurfaceViewBase$j = TXCGLSurfaceViewBase.f();
        synchronized (tXCGLSurfaceViewBase$j) {
            boolean bl2;
            this.a = bl2 = true;
            Object object = TXCGLSurfaceViewBase.f();
            object.notifyAll();
            while (!(bl2 = this.b)) {
                try {
                    object = TXCGLSurfaceViewBase.f();
                    object.wait();
                }
                catch (InterruptedException interruptedException) {
                    object = Thread.currentThread();
                    ((Thread)object).interrupt();
                    continue;
                }
                break;
            }
            return;
        }
    }

    public void i() {
        this.k = true;
        TXCGLSurfaceViewBase.f().notifyAll();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        Object object = new StringBuilder();
        String string2 = "GLThread ";
        ((StringBuilder)object).append(string2);
        long l10 = this.getId();
        ((StringBuilder)object).append(l10);
        object = ((StringBuilder)object).toString();
        this.setName((String)object);
        try {
            this.j();
        }
        catch (Throwable throwable) {
            TXCGLSurfaceViewBase.f().a(this);
            throw throwable;
        }
        catch (InterruptedException interruptedException) {}
        object = TXCGLSurfaceViewBase.f();
        ((TXCGLSurfaceViewBase$j)object).a(this);
    }
}

