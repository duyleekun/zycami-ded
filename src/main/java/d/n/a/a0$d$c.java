/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothDevice
 *  android.content.Context
 */
package d.n.a;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import c.a.l.o;
import com.polidea.rxandroidble2.RxBleConnection;
import d.n.a.a0;
import d.n.a.a0$a;
import d.n.a.a0$d;
import d.n.a.a0$d$b;
import d.n.a.l;
import d.n.a.m;
import d.n.a.n;
import d.n.a.q0.s.a;
import d.n.a.q0.s.a1;
import d.n.a.q0.s.b;
import d.n.a.q0.s.b0;
import d.n.a.q0.s.c;
import d.n.a.q0.s.c1;
import d.n.a.q0.s.e0;
import d.n.a.q0.s.g;
import d.n.a.q0.s.h;
import d.n.a.q0.s.h0;
import d.n.a.q0.s.i;
import d.n.a.q0.s.j;
import d.n.a.q0.s.j0;
import d.n.a.q0.s.l0;
import d.n.a.q0.s.o0;
import d.n.a.q0.s.q0;
import d.n.a.q0.s.t;
import d.n.a.q0.s.t0;
import d.n.a.q0.s.v;
import d.n.a.q0.s.w0;
import d.n.a.q0.s.x0;
import d.n.a.q0.s.y0;
import d.n.a.q0.s.z;
import d.n.a.q0.u.d;
import d.n.a.q0.u.e;
import d.n.a.q0.u.s;
import d.n.a.q0.u.u;
import d.n.a.q0.w.f;
import java.util.Set;

public final class a0$d$c
implements c {
    public final /* synthetic */ a0$d A;
    private Boolean a;
    private c.b.a.c b;
    private c.b.a.c c;
    private c.b.a.c d;
    private c.b.a.c e;
    private g f;
    private d.n.a.q0.t.d g;
    private c.b.a.c h;
    private j i;
    private u j;
    private s k;
    private c.b.a.c l;
    private c.b.a.c m;
    private c.b.a.c n;
    private c.b.a.c o;
    private c.b.a.c p;
    private c.b.a.c q;
    private j0 r;
    private c.b.a.c s;
    private e0 t;
    private h0 u;
    private c1 v;
    private i w;
    private b0 x;
    private d.n.a.q0.u.l y;
    private c.b.a.c z;

    private a0$d$c(a0$d a0$d, a0$d$b a0$d$b) {
        this.A = a0$d;
        this.f(a0$d$b);
    }

    public /* synthetic */ a0$d$c(a0$d a0$d, a0$d$b a0$d$b, a0$a a0$a) {
        this(a0$d, a0$d$b);
    }

    private d.n.a.q0.x.b e() {
        Context context = a0.d(this.A.j);
        d.n.a.q0.x.b b10 = new d.n.a.q0.x.b(context);
        return b10;
    }

    private void f(a0$d$b object) {
        Object object2 = c.a.l.d.b(d.n.a.q0.s.b.a());
        this.b = object2;
        object2 = a0$d.b(this.A);
        c.b.a.c c10 = a0.j(this.A.j);
        c.b.a.c c11 = a0.e(this.A.j);
        object2 = c.a.l.d.b(d.n.a.q0.s.z.a((c.b.a.c)object2, c10, c11));
        this.c = object2;
        object2 = a0.c(this.A.j);
        c10 = this.b;
        c11 = this.c;
        c.b.a.c c12 = q0.a();
        object2 = c.a.l.d.b(y0.a((c.b.a.c)object2, c10, c11, c12));
        this.d = object2;
        this.a = object2 = a0$d$b.d((a0$d$b)object);
        object2 = a0$d.b(this.A);
        c10 = this.c;
        c11 = a0.f(this.A.j);
        c12 = a0.g(this.A.j);
        this.e = object2 = c.a.l.d.b(d.n.a.q0.w.f.a((c.b.a.c)object2, c10, c11, c12));
        this.f = object2 = d.n.a.q0.s.g.a(this.b);
        this.g = object2 = d.n.a.q0.t.d.a(d.n.a.q0.s.h.a());
        this.h = object2 = c.a.l.g.a(a0$d$b.e((a0$d$b)object));
        object2 = d.n.a.h.a();
        c10 = this.h;
        this.i = object2 = d.n.a.q0.s.j.a((c.b.a.c)object2, c10);
        c10 = this.d;
        c11 = this.f;
        this.j = object2 = d.n.a.q0.u.u.a(c10, c11, (c.b.a.c)object2);
        c10 = this.d;
        c11 = this.f;
        c12 = this.g;
        c.b.a.c c13 = this.i;
        c.b.a.c c14 = a0.g(this.A.j);
        c.b.a.c c15 = d.n.a.h.a();
        c.b.a.c c16 = this.j;
        this.k = object2 = d.n.a.q0.u.s.a(c10, c11, c12, c13, c14, c15, c16);
        c10 = this.e;
        c11 = this.f;
        this.l = object2 = c.a.l.d.b(a1.a(c10, c11, (c.b.a.c)object2));
        object2 = this.e;
        c10 = this.k;
        this.m = object2 = c.a.l.d.b(d.n.a.q0.s.t.a((c.b.a.c)object2, c10));
        c10 = d.n.a.n.a();
        c11 = d.n.a.m.a();
        c12 = d.n.a.l.a();
        c13 = this.f;
        c14 = this.d;
        c15 = this.m;
        this.n = object2 = c.a.l.d.b(t0.a(c10, c11, c12, c13, c14, c15));
        object2 = this.d;
        c10 = d.n.a.q0.s.f.a();
        this.o = object2 = c.a.l.d.b(o0.a((c.b.a.c)object2, c10));
        this.p = object2 = new c.a.l.c();
        c10 = d.n.a.q0.s.e.a();
        this.q = object2 = c.a.l.d.b(l0.a((c.b.a.c)object2, c10));
        c10 = this.e;
        c11 = this.p;
        c12 = this.k;
        this.r = object2 = j0.a(c10, (c.b.a.c)object2, c11, c12);
        this.s = object = c.a.l.g.a(a0$d$b.f((a0$d$b)object));
        this.t = object = e0.a(d.n.a.q0.s.h.a());
        this.u = object = h0.a((c.b.a.c)object);
        this.v = object = c1.a(this.t);
        object2 = this.s;
        c10 = this.u;
        this.w = object = d.n.a.q0.s.i.a((c.b.a.c)object2, c10, (c.b.a.c)object);
        this.x = object = b0.a((c.b.a.c)object);
        object = (c.a.l.c)this.p;
        object2 = this.e;
        c10 = this.d;
        c11 = this.f;
        c12 = this.l;
        c13 = this.n;
        c14 = this.o;
        c15 = this.m;
        c16 = this.k;
        j0 j02 = this.r;
        c.b.a.c c17 = a0.g(this.A.j);
        b0 b02 = this.x;
        this.p = object2 = c.a.l.d.b(w0.a((c.b.a.c)object2, c10, c11, c12, c13, c14, c15, c16, j02, c17, b02));
        ((c.a.l.c)object).a((c.b.a.c)object2);
        c10 = this.d;
        c11 = this.b;
        c12 = a0$d.b(this.A);
        c13 = a0.h(this.A.j);
        c14 = a0.g(this.A.j);
        c15 = a0$d.c(this.A);
        c16 = a0$d.d(this.A);
        this.y = object = d.n.a.q0.u.l.a(c10, c11, c12, c13, c14, c15, c16);
        object = a0.k(this.A.j);
        object2 = this.y;
        this.z = object = c.a.l.d.b(d.n.a.q0.s.v.a((c.b.a.c)object, (c.b.a.c)object2));
    }

    public Set a() {
        o o10 = c.a.l.o.d(3);
        Object object = (d.n.a.q0.s.n)this.o.get();
        o10 = o10.a(object);
        object = (d.n.a.q0.s.n)this.z.get();
        o10 = o10.a(object);
        object = this.e.get();
        return o10.a(object).c();
    }

    public d b() {
        Object object;
        BluetoothDevice bluetoothDevice = a0$d.e(this.A);
        d.n.a.q0.x.b b10 = this.e();
        Object object2 = object = this.d.get();
        object2 = (x0)object;
        Object object3 = object = this.b.get();
        object3 = (a)object;
        d.n.a.q0.u.z z10 = a0$d.f(this.A);
        boolean bl2 = this.a;
        Object object4 = object = a0$d.d(this.A).get();
        object4 = (d.n.a.q0.s.m)object;
        return d.n.a.q0.u.e.c(bluetoothDevice, b10, (x0)object2, (a)object3, z10, bl2, (d.n.a.q0.s.m)object4);
    }

    public x0 c() {
        return (x0)this.d.get();
    }

    public RxBleConnection d() {
        return (RxBleConnection)this.p.get();
    }
}

