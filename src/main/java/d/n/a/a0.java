/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.bluetooth.BluetoothAdapter
 *  android.content.Context
 */
package d.n.a;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import com.polidea.rxandroidble2.RxBleClient;
import d.n.a.a0$a;
import d.n.a.a0$b;
import d.n.a.b;
import d.n.a.b$b;
import d.n.a.b$d;
import d.n.a.d;
import d.n.a.e;
import d.n.a.f;
import d.n.a.f0;
import d.n.a.g;
import d.n.a.h;
import d.n.a.h0;
import d.n.a.i;
import d.n.a.j;
import d.n.a.k;
import d.n.a.o;
import d.n.a.q0.v.b0;
import d.n.a.q0.v.d0;
import d.n.a.q0.w.c;
import d.n.a.q0.x.l;
import d.n.a.q0.x.n;
import d.n.a.q0.x.p;
import d.n.a.q0.x.q;
import d.n.a.q0.x.r;
import d.n.a.q0.x.t;
import d.n.a.q0.x.v;
import d.n.a.q0.x.y;
import d.n.a.q0.x.z;
import d.n.a.s;
import d.n.a.u;
import d.n.a.w;

public final class a0
implements b {
    private d.n.a.q0.v.b A;
    private b0 B;
    private d0 C;
    private c.b.a.c D;
    private d.n.a.q0.v.p E;
    private d.n.a.q0.v.r F;
    private u G;
    private d.n.a.q0.v.j H;
    private c.b.a.c I;
    private c.b.a.c J;
    private o K;
    private d.n.a.q0.v.d L;
    private h0 M;
    private c.b.a.c N;
    private g O;
    private Context a;
    private c.b.a.c b;
    private j c;
    private d.n.a.q d;
    private l e;
    private w f;
    private d.n.a.t g;
    private c.b.a.c h;
    private d.n.a.p i;
    private v j;
    private z k;
    private c.b.a.c l;
    private c.b.a.c m;
    private c n;
    private c.b.a.c o;
    private f0 p;
    private s q;
    private q r;
    private d.n.a.r s;
    private n t;
    private c.b.a.c u;
    private c.b.a.c v;
    private c.b.a.c w;
    private c.b.a.c x;
    private d.n.a.q0.v.v y;
    private d.n.a.q0.v.z z;

    private a0(a0$b a0$b) {
        this.q(a0$b);
    }

    public /* synthetic */ a0(a0$b a0$b, a0$a a0$a) {
        this(a0$b);
    }

    public static /* synthetic */ c.b.a.c c(a0 a02) {
        return a02.I;
    }

    public static /* synthetic */ Context d(a0 a02) {
        return a02.a;
    }

    public static /* synthetic */ f0 e(a0 a02) {
        return a02.p;
    }

    public static /* synthetic */ c.b.a.c f(a0 a02) {
        return a02.J;
    }

    public static /* synthetic */ c.b.a.c g(a0 a02) {
        return a02.m;
    }

    public static /* synthetic */ g h(a0 a02) {
        return a02.O;
    }

    public static /* synthetic */ y i(a0 a02) {
        return a02.p();
    }

    public static /* synthetic */ z j(a0 a02) {
        return a02.k;
    }

    public static /* synthetic */ c.b.a.c k(a0 a02) {
        return a02.o;
    }

    public static b$b l() {
        a0$b a0$b = new a0$b(null);
        return a0$b;
    }

    private p m() {
        Context context = this.a;
        r r10 = this.n();
        return d.n.a.q0.x.q.c(context, r10);
    }

    private r n() {
        int n10 = b$d.n();
        t t10 = d.n.a.q0.x.t.a();
        v v10 = this.j;
        return d.n.a.s.c(n10, t10, v10);
    }

    private e.a.z o() {
        int n10 = b$d.n();
        p p10 = this.m();
        return d.n.a.r.c(n10, p10);
    }

    private y p() {
        BluetoothAdapter bluetoothAdapter = b$d.f();
        y y10 = new y(bluetoothAdapter);
        return y10;
    }

    private void q(a0$b object) {
        Object object2;
        this.a = object2 = a0$b.b((a0$b)object);
        this.b = object = c.a.l.g.a(a0$b.b((a0$b)object));
        this.c = object = d.n.a.j.a((c.b.a.c)object);
        this.d = object = d.n.a.q.a(this.b);
        this.e = object = d.n.a.q0.x.l.a(this.c, (c.b.a.c)object);
        this.f = object = d.n.a.w.a(this.b);
        object = d.n.a.k.a();
        object2 = this.f;
        this.g = object = d.n.a.t.a((c.b.a.c)object, (c.b.a.c)object2);
        this.h = object = c.a.l.d.b(d.n.a.q0.x.j.a(this.b, (c.b.a.c)object));
        object = this.b;
        object2 = d.n.a.k.a();
        this.i = object = d.n.a.p.a((c.b.a.c)object, (c.b.a.c)object2);
        object2 = this.e;
        c.b.a.c c10 = this.h;
        c.a.l.e e10 = this.f;
        this.j = object = d.n.a.q0.x.v.a((c.b.a.c)object2, c10, e10, (c.b.a.c)object);
        this.k = object = d.n.a.q0.x.z.a(d.n.a.c.a());
        this.l = object = c.a.l.d.b(d.n.a.e.a());
        this.m = object = c.a.l.d.b(d.n.a.f.a((c.b.a.c)object));
        this.n = object = d.n.a.q0.w.c.a((c.b.a.c)object);
        this.o = object = c.a.l.d.b((c.b.a.c)object);
        this.p = object = f0.a(this.b);
        object = d.n.a.k.a();
        object2 = d.n.a.q0.x.t.a();
        c10 = this.j;
        this.q = object = d.n.a.s.a((c.b.a.c)object, (c.b.a.c)object2, c10);
        this.r = object = d.n.a.q0.x.q.a(this.b, (c.b.a.c)object);
        object = d.n.a.k.a();
        object2 = this.r;
        this.s = object = d.n.a.r.a((c.b.a.c)object, (c.b.a.c)object2);
        object2 = this.k;
        c10 = this.p;
        e10 = this.q;
        c.a.l.e e11 = d.n.a.h.a();
        this.t = object = d.n.a.q0.x.n.a((c.b.a.c)object2, c10, (c.b.a.c)object, e10, e11);
        this.u = object = c.a.l.d.b(d.n.a.q0.r.c.a());
        this.v = object = new a0$a(this);
        this.w = object = c.a.l.d.b(d.n.a.q0.o.a(this.u, (c.b.a.c)object));
        this.x = object = c.a.l.d.b(d.n.a.q0.v.h.a(d.n.a.q0.x.b0.a()));
        this.y = object = d.n.a.q0.v.v.a(d.n.a.h.a());
        object2 = this.k;
        c10 = this.x;
        this.z = object = d.n.a.q0.v.z.a((c.b.a.c)object2, c10, (c.b.a.c)object);
        this.A = object = d.n.a.q0.v.b.a(d.n.a.k.a());
        object2 = this.k;
        c10 = this.x;
        e10 = this.y;
        this.B = object = b0.a((c.b.a.c)object2, c10, e10, (c.b.a.c)object);
        object = this.k;
        object2 = this.x;
        c10 = this.y;
        e10 = this.A;
        this.C = object = d0.a((c.b.a.c)object, (c.b.a.c)object2, c10, e10);
        object = d.n.a.k.a();
        object2 = this.z;
        c10 = this.B;
        e10 = this.C;
        this.D = object = c.a.l.d.b(d.n.a.v.a((c.b.a.c)object, (c.b.a.c)object2, c10, e10));
        object = this.k;
        object2 = this.q;
        this.E = object = d.n.a.q0.v.p.a((c.b.a.c)object, (c.b.a.c)object2);
        object2 = d.n.a.h.a();
        this.F = object = d.n.a.q0.v.r.a((c.b.a.c)object, (c.b.a.c)object2);
        object = d.n.a.k.a();
        object2 = this.E;
        c10 = this.F;
        this.G = object = d.n.a.u.a((c.b.a.c)object, (c.b.a.c)object2, c10);
        this.H = object = d.n.a.q0.v.j.a(this.w);
        this.I = object = c.a.l.d.b(d.n.a.d.a());
        this.J = object = c.a.l.d.b(d.n.a.i.a());
        object2 = this.l;
        c10 = this.I;
        this.K = object = d.n.a.o.a((c.b.a.c)object2, c10, (c.b.a.c)object);
        object = this.k;
        object2 = this.A;
        c10 = this.x;
        e10 = this.H;
        this.L = object = d.n.a.q0.v.d.a((c.b.a.c)object, (c.b.a.c)object2, c10, e10);
        object2 = this.k;
        c10 = this.o;
        e10 = this.p;
        e11 = d.n.a.q0.x.b0.a();
        s s10 = this.q;
        n n10 = this.t;
        c.b.a.c c11 = this.w;
        c.b.a.c c12 = this.D;
        u u10 = this.G;
        d.n.a.q0.v.j j10 = this.H;
        c.b.a.c c13 = this.m;
        o o10 = this.K;
        d.n.a.q0.v.d d10 = this.L;
        c.b.a.c c14 = this.h;
        this.M = object = h0.a((c.b.a.c)object2, c10, e10, e11, s10, n10, c11, c12, u10, j10, c13, o10, d10, c14);
        this.N = object = c.a.l.d.b((c.b.a.c)object);
        this.O = object = d.n.a.g.a(this.b);
    }

    public d.n.a.p0.c a() {
        return d.n.a.p0.d.c(this.o());
    }

    public RxBleClient b() {
        return (RxBleClient)this.N.get();
    }
}

