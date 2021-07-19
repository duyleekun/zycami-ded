/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Handler
 *  android.os.Handler$Callback
 *  android.os.Looper
 *  android.os.SystemClock
 */
package d.c.a.o.m.h;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import d.c.a.h;
import d.c.a.o.c;
import d.c.a.o.i;
import d.c.a.o.k.x.e;
import d.c.a.o.m.h.g$a;
import d.c.a.o.m.h.g$b;
import d.c.a.o.m.h.g$c;
import d.c.a.o.m.h.g$d;
import d.c.a.s.a;
import d.c.a.s.j.p;
import d.c.a.u.k;
import d.c.a.u.m;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public class g {
    private final d.c.a.m.a a;
    private final Handler b;
    private final List c;
    public final d.c.a.i d;
    private final e e;
    private boolean f;
    private boolean g;
    private boolean h;
    private h i;
    private g$a j;
    private boolean k;
    private g$a l;
    private Bitmap m;
    private i n;
    private g$a o;
    private g$d p;
    private int q;
    private int r;
    private int s;

    public g(d.c.a.c c10, d.c.a.m.a a10, int n10, int n11, i i10, Bitmap bitmap) {
        e e10 = c10.g();
        d.c.a.i i11 = d.c.a.c.D(c10.i());
        h h10 = d.c.a.o.m.h.g.k(d.c.a.c.D(c10.i()), n10, n11);
        this(e10, i11, a10, null, h10, i10, bitmap);
    }

    public g(e e10, d.c.a.i i10, d.c.a.m.a a10, Handler handler, h h10, i i11, Bitmap bitmap) {
        Object object = new ArrayList();
        this.c = object;
        this.d = i10;
        if (handler == null) {
            i10 = Looper.getMainLooper();
            object = new g$c(this);
            handler = new Handler((Looper)i10, (Handler.Callback)object);
        }
        this.e = e10;
        this.b = handler;
        this.i = h10;
        this.a = a10;
        this.q(i11, bitmap);
    }

    private static c g() {
        Double d10 = Math.random();
        d.c.a.t.e e10 = new d.c.a.t.e(d10);
        return e10;
    }

    private static h k(d.c.a.i g10, int n10, int n11) {
        g10 = ((d.c.a.i)g10).u();
        d.c.a.s.g g11 = d.c.a.s.g.b1(d.c.a.o.k.h.b);
        boolean bl2 = true;
        a a10 = ((d.c.a.s.g)((d.c.a.s.g)g11.U0(bl2)).K0(bl2)).z0(n10, n11);
        return ((h)g10).X0(a10);
    }

    private void n() {
        int n10 = this.f;
        if (n10 != 0 && (n10 = this.g) == 0) {
            String string2;
            Object object;
            n10 = this.h;
            int n11 = 1;
            if (n10 != 0) {
                object = this.o;
                if (object == null) {
                    n10 = n11;
                } else {
                    n10 = 0;
                    object = null;
                }
                string2 = "Pending target must be null when starting from the first frame";
                d.c.a.u.k.a(n10 != 0, string2);
                object = this.a;
                object.j();
                this.h = false;
            }
            if ((object = this.o) != null) {
                this.o = null;
                this.o((g$a)object);
                return;
            }
            this.g = n11;
            n10 = this.a.i();
            long l10 = SystemClock.uptimeMillis();
            long l11 = n10;
            this.a.b();
            string2 = this.b;
            d.c.a.m.a a10 = this.a;
            int n12 = a10.l();
            this.l = object = new g$a((Handler)string2, n12, l10 += l11);
            object = this.i;
            Object object2 = d.c.a.s.g.s1(d.c.a.o.m.h.g.g());
            object = ((h)object).X0((a)object2);
            object2 = this.a;
            object = ((h)object).u1(object2);
            object2 = this.l;
            ((h)object).j1((p)object2);
        }
    }

    private void p() {
        Bitmap bitmap = this.m;
        if (bitmap != null) {
            e e10 = this.e;
            e10.d(bitmap);
            bitmap = null;
            this.m = null;
        }
    }

    private void t() {
        boolean bl2 = this.f;
        if (bl2) {
            return;
        }
        this.f = true;
        this.k = false;
        this.n();
    }

    private void u() {
        this.f = false;
    }

    public void a() {
        d.c.a.i i10;
        this.c.clear();
        this.p();
        this.u();
        g$a g$a = this.j;
        if (g$a != null) {
            i10 = this.d;
            i10.z(g$a);
            this.j = null;
        }
        if ((g$a = this.l) != null) {
            i10 = this.d;
            i10.z(g$a);
            this.l = null;
        }
        if ((g$a = this.o) != null) {
            i10 = this.d;
            i10.z(g$a);
            this.o = null;
        }
        this.a.clear();
        this.k = true;
    }

    public ByteBuffer b() {
        return this.a.getData().asReadOnlyBuffer();
    }

    public Bitmap c() {
        g$a g$a = this.j;
        g$a = g$a != null ? g$a.n() : this.m;
        return g$a;
    }

    public int d() {
        g$a g$a = this.j;
        int n10 = g$a != null ? g$a.e : -1;
        return n10;
    }

    public Bitmap e() {
        return this.m;
    }

    public int f() {
        return this.a.c();
    }

    public i h() {
        return this.n;
    }

    public int i() {
        return this.s;
    }

    public int j() {
        return this.a.f();
    }

    public int l() {
        int n10 = this.a.o();
        int n11 = this.q;
        return n10 + n11;
    }

    public int m() {
        return this.r;
    }

    public void o(g$a object) {
        Object object2 = this.p;
        if (object2 != null) {
            object2.a();
        }
        object2 = null;
        this.g = false;
        boolean bl2 = this.k;
        int n10 = 2;
        if (bl2) {
            this.b.obtainMessage(n10, object).sendToTarget();
            return;
        }
        bl2 = this.f;
        if (!bl2) {
            this.o = object;
            return;
        }
        object2 = ((g$a)object).n();
        if (object2 != null) {
            this.p();
            object2 = this.j;
            this.j = object;
            object = this.c;
            for (int i10 = object.size() + -1; i10 >= 0; i10 += -1) {
                g$b g$b = (g$b)this.c.get(i10);
                g$b.a();
            }
            if (object2 != null) {
                object = this.b.obtainMessage(n10, object2);
                object.sendToTarget();
            }
        }
        this.n();
    }

    public void q(i object, Bitmap bitmap) {
        int n10;
        Object object2 = (i)d.c.a.u.k.d(object);
        this.n = object2;
        object2 = (Bitmap)d.c.a.u.k.d(bitmap);
        this.m = object2;
        object2 = this.i;
        d.c.a.s.g g10 = new d.c.a.s.g();
        object = g10.N0((i)object);
        this.i = object = ((h)object2).X0((a)object);
        this.q = n10 = d.c.a.u.m.h(bitmap);
        this.r = n10 = bitmap.getWidth();
        this.s = n10 = bitmap.getHeight();
    }

    public void r() {
        boolean bl2 = this.f;
        boolean bl3 = true;
        String string2 = "Can't restart a running animation";
        d.c.a.u.k.a(bl2 ^= bl3, string2);
        this.h = bl3;
        g$a g$a = this.o;
        if (g$a != null) {
            d.c.a.i i10 = this.d;
            i10.z(g$a);
            bl2 = false;
            g$a = null;
            this.o = null;
        }
    }

    public void s(g$d g$d) {
        this.p = g$d;
    }

    public void v(g$b object) {
        boolean bl2 = this.k;
        if (!bl2) {
            List list = this.c;
            bl2 = list.contains(object);
            if (!bl2) {
                list = this.c;
                bl2 = list.isEmpty();
                List list2 = this.c;
                list2.add(object);
                if (bl2) {
                    this.t();
                }
                return;
            }
            object = new IllegalStateException("Cannot subscribe twice in a row");
            throw object;
        }
        object = new IllegalStateException("Cannot subscribe to a cleared frame loader");
        throw object;
    }

    public void w(g$b object) {
        List list = this.c;
        list.remove(object);
        object = this.c;
        boolean bl2 = object.isEmpty();
        if (bl2) {
            this.u();
        }
    }
}

