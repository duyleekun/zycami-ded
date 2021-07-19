/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Looper
 */
package d.v.c;

import android.os.Looper;
import d.v.c.h;
import d.v.c.i;
import d.v.c.i0$a;
import d.v.c.i0$b;
import d.v.c.j;
import d.v.c.k;
import d.v.c.l;
import d.v.c.t;
import d.v.c.u;
import d.v.c.y;
import d.v.e.k.e;
import d.v.e.l.c1;
import e.a.f0;
import e.a.s0.b;
import e.a.v0.a;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class i0$c {
    private static final int e = 3;
    private static final int[] f;
    private final List a;
    private int b;
    private int c;
    private b d;

    static {
        int[] nArray;
        int[] nArray2 = nArray = new int[4];
        int[] nArray3 = nArray;
        nArray2[0] = 0;
        nArray3[1] = 45;
        nArray2[2] = 90;
        nArray3[3] = 100;
        f = nArray;
    }

    private i0$c() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
        this.c = 0;
    }

    public /* synthetic */ i0$c(i0$a i0$a) {
        this();
    }

    public static /* synthetic */ int a(i0$c i0$c) {
        return i0$c.c;
    }

    public static /* synthetic */ void e(Throwable throwable, i0$b i0$b) {
        i0$b.onError(throwable);
    }

    public static /* synthetic */ void f(int n10, i0$b i0$b) {
        i0$b.onProgress(n10);
    }

    private /* synthetic */ Integer g(Long l10) {
        int n10;
        this.c = n10 = this.c + 1;
        return n10;
    }

    private /* synthetic */ void i(int n10, int n11) {
        this.c = n10;
        this.b = n11;
    }

    public static /* synthetic */ void k(Throwable throwable) {
    }

    public void b(i0$b i0$b) {
        this.a.add(i0$b);
    }

    public void c() {
        this.a.clear();
    }

    public void d(int n10) {
        int n11;
        int[] nArray = f;
        int n12 = nArray.length;
        if (n10 >= n12) {
            n10 = nArray.length;
        }
        this.c = n11 = nArray[n10];
        this.b = n10;
    }

    public /* synthetic */ Integer h(Long l10) {
        return this.g(l10);
    }

    public /* synthetic */ void j(int n10, int n11) {
        this.i(n10, n11);
    }

    public void l(Runnable runnable) {
        boolean bl2;
        Looper looper;
        Object object = Looper.myLooper();
        if (object == (looper = Looper.getMainLooper())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (bl2) {
            runnable.run();
        } else {
            object = c1.b().c();
            object.execute(runnable);
        }
    }

    public void m(i0$b i0$b) {
        this.a.remove(i0$b);
    }

    public void n() {
        List list = this.a;
        t t10 = t.a;
        list.forEach(t10);
    }

    public void o(Throwable throwable) {
        List list = this.a;
        i i10 = new i(throwable);
        list.forEach(i10);
    }

    public void p(int n10) {
        List list = this.a;
        k k10 = new k(n10);
        list.forEach(k10);
    }

    public void q() {
        List list = this.a;
        y y10 = y.a;
        list.forEach(y10);
    }

    public void r() {
        b b10 = this.d;
        if (b10 != null) {
            b10.dispose();
        }
    }

    public void s(int n10) {
        int n11 = this.b + n10;
        Object object = f;
        int n12 = ((int[])object).length;
        if (n11 >= n12) {
            n11 = ((int[])object).length;
        }
        n10 = object[n11];
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        Object object2 = z.l3(100, 500L, timeUnit);
        int n13 = this.c;
        long l10 = n10 - n13;
        object2 = ((z)object2).b6(l10);
        Object object3 = new l(this);
        object2 = ((z)object2).H3((o)object3);
        object3 = d.v.e.k.e.g();
        object2 = ((z)object2).z0((f0)object3);
        object3 = new j(this, n10, n11);
        object = ((z)object2).X1((a)object3);
        u u10 = new u(this);
        object2 = h.a;
        this.d = object = object.c(u10, (g)object2);
    }
}

