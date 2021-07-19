/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Handler
 *  android.os.HandlerThread
 *  android.os.Looper
 *  android.util.SparseArray
 */
package d.v.d;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.SparseArray;
import d.v.d.h.f;
import d.v.d.i.b.a;
import d.v.d.i.b.b;
import d.v.d.i.b.d;
import d.v.d.i.d.c;
import d.v.d.i.f.a0;
import d.v.d.i.f.g;
import d.v.d.i.f.h;
import d.v.d.i.f.i;
import d.v.d.i.f.j;
import d.v.d.i.f.k;
import d.v.d.i.f.l;
import d.v.d.i.f.m;
import d.v.d.i.f.n;
import d.v.d.i.f.o;
import d.v.d.i.f.q;
import d.v.d.i.f.r;
import d.v.d.i.f.s;
import d.v.d.i.f.t;
import d.v.d.i.f.u;
import d.v.d.i.f.v;
import d.v.d.i.f.w;
import d.v.d.i.f.x;
import d.v.d.i.f.y;
import d.v.d.i.f.z;
import java.util.concurrent.Semaphore;

public class e {
    private q A;
    private k B;
    private v C;
    private o D;
    private d.v.d.i.e.g E;
    private d.v.d.i.e.a F;
    private d.v.d.i.e.b G;
    private d.v.d.i.e.f H;
    private d.v.d.i.e.h I;
    private d.v.d.i.e.c J;
    private d.v.d.i.g.l K;
    private d.v.d.i.g.f L;
    private d.v.d.i.g.k M;
    private d.v.d.i.g.j N;
    private d.v.d.i.g.c O;
    private d.v.d.i.g.n P;
    private d.v.d.i.g.m Q;
    private d.v.d.i.g.e R;
    private d.v.d.i.g.h S;
    private d.v.d.i.g.d T;
    private d.v.d.i.g.g U;
    private d.v.d.i.d.d V;
    private c W;
    private Handler X;
    private Handler Y;
    private final SparseArray a;
    public Semaphore b;
    private b c;
    private d.v.d.i.b.e d;
    private a e;
    private d f;
    private d.v.d.i.c.a g;
    private d.v.d.i.c.c h;
    private d.v.d.i.f.f i;
    private d.v.d.i.f.e j;
    private r k;
    private m l;
    private x m;
    private y n;
    private l o;
    private z p;
    private a0 q;
    private s r;
    private i s;
    private u t;
    private j u;
    private t v;
    private g w;
    private w x;
    private n y;
    private h z;

    public e(Context context) {
        Object object;
        this.a = object = new SparseArray();
        super(1);
        this.b = object;
        this.a0(context);
        this.B(context);
        this.k(context);
        this.S(context);
        this.e();
        this.b1();
    }

    private void A() {
        o o10;
        this.D = o10 = new o();
        this.b(276, o10);
    }

    private void B(Context context) {
        this.d();
        this.c();
        this.q();
        this.p();
        this.I();
        this.K();
        this.L();
        this.y();
        this.D();
        this.E();
        this.r();
        this.H();
        this.w();
        this.z();
        this.s();
        this.C();
        this.u();
        this.t();
        this.v();
        this.J();
        this.F();
        this.F();
        this.G();
        this.x(context);
        this.A();
    }

    private void C() {
        q q10;
        this.A = q10 = new q();
        this.b(275, q10);
    }

    private void D() {
        r r10;
        this.k = r10 = new r();
        this.b(263, r10);
    }

    private void E() {
        t t10;
        this.v = t10 = new t();
        this.b(265, t10);
    }

    private void F() {
        u u10;
        this.t = u10 = new u();
        this.b(257, u10);
    }

    private void G() {
        v v10;
        this.C = v10 = new v();
        this.b(288, v10);
    }

    private void H() {
        w w10;
        this.x = w10 = new w();
        this.b(274, w10);
    }

    private void I() {
        x x10;
        this.m = x10 = new x();
        this.b(261, x10);
    }

    private void J() {
        y y10;
        this.n = y10 = new y();
        this.b(264, y10);
    }

    private void K() {
        z z10;
        this.p = z10 = new z();
        this.b(259, z10);
    }

    private void L() {
        a0 a02;
        this.q = a02 = new a0();
        this.b(290, a02);
    }

    private void M() {
        d.v.d.i.g.c c10;
        this.O = c10 = new d.v.d.i.g.c();
        this.b(774, c10);
    }

    private void N() {
        d.v.d.i.g.d d10;
        this.T = d10 = new d.v.d.i.g.d();
        this.b(786, d10);
    }

    private void O() {
        d.v.d.i.g.e e10;
        this.R = e10 = new d.v.d.i.g.e();
        this.b(784, e10);
    }

    private void P() {
        d.v.d.i.g.f f10;
        this.L = f10 = new d.v.d.i.g.f();
        this.b(776, f10);
    }

    private void Q(Context context) {
        d.v.d.i.g.g g10;
        this.U = g10 = new d.v.d.i.g.g(context);
        this.b(787, g10);
    }

    private void R() {
        d.v.d.i.g.h h10;
        this.S = h10 = new d.v.d.i.g.h();
        this.b(785, h10);
    }

    private void S(Context context) {
        this.V();
        this.P();
        this.W();
        this.U();
        this.O();
        this.R();
        this.Q(context);
        this.N();
        this.T();
        this.M();
        this.X();
    }

    private void T() {
        d.v.d.i.g.j j10;
        this.N = j10 = new d.v.d.i.g.j();
        this.b(773, j10);
    }

    private void U() {
        d.v.d.i.g.k k10;
        this.M = k10 = new d.v.d.i.g.k();
        this.b(771, k10);
    }

    private void V() {
        d.v.d.i.g.l l10;
        this.K = l10 = new d.v.d.i.g.l();
        this.b(770, l10);
    }

    private void W() {
        d.v.d.i.g.m m10;
        this.Q = m10 = new d.v.d.i.g.m();
        this.b(769, m10);
    }

    private void X() {
        d.v.d.i.g.n n10;
        this.P = n10 = new d.v.d.i.g.n();
        this.b(777, n10);
    }

    private void Y(Context context) {
        a a10;
        this.e = a10 = new a(context);
        this.b(2, a10);
    }

    private void Z(Context context) {
        b b10;
        this.c = b10 = new b(context);
        this.b(1, b10);
    }

    private void a0(Context context) {
        this.Y(context);
        this.Z(context);
        this.b0();
        this.c0();
    }

    private void b0() {
        d d10;
        this.f = d10 = new d();
        this.b(3, d10);
    }

    private void b1() {
        Handler handler;
        HandlerThread handlerThread = new HandlerThread("camera_handler");
        handlerThread.start();
        handlerThread = handlerThread.getLooper();
        this.X = handler = new Handler((Looper)handlerThread);
        handlerThread = new HandlerThread("parameter_handler");
        handlerThread.start();
        handlerThread = handlerThread.getLooper();
        this.Y = handler = new Handler((Looper)handlerThread);
    }

    private void c() {
        d.v.d.i.c.a a10;
        this.g = a10 = new d.v.d.i.c.a();
        this.b(81, a10);
    }

    private void c0() {
        d.v.d.i.b.e e10;
        this.d = e10 = new d.v.d.i.b.e();
        this.b(0, e10);
    }

    private void d() {
        d.v.d.i.c.c c10;
        this.h = c10 = new d.v.d.i.c.c();
        this.b(80, c10);
    }

    private void e() {
        this.g();
        this.f();
    }

    private void f() {
        c c10;
        this.W = c10 = new c();
        this.b(1025, c10);
    }

    private void g() {
        d.v.d.i.d.d d10;
        this.V = d10 = new d.v.d.i.d.d();
        this.b(1024, d10);
    }

    private void h() {
        d.v.d.i.e.a a10;
        this.F = a10 = new d.v.d.i.e.a();
        this.b(512, a10);
    }

    private void i() {
        d.v.d.i.e.b b10;
        this.G = b10 = new d.v.d.i.e.b();
        this.b(514, b10);
    }

    private void j() {
        d.v.d.i.e.c c10;
        this.J = c10 = new d.v.d.i.e.c();
        this.b(518, c10);
    }

    private void k(Context context) {
        this.l(context);
        this.n();
        this.h();
        this.i();
        this.m();
        this.o();
        this.j();
    }

    private void l(Context context) {
        d.v.d.i.e.e e10 = new d.v.d.i.e.e(context);
        this.b(515, e10);
    }

    private void m() {
        d.v.d.i.e.f f10;
        this.H = f10 = new d.v.d.i.e.f();
        this.b(516, f10);
    }

    private void n() {
        d.v.d.i.e.g g10;
        this.E = g10 = new d.v.d.i.e.g();
        this.b(513, g10);
    }

    private void o() {
        d.v.d.i.e.h h10;
        this.I = h10 = new d.v.d.i.e.h();
        this.b(517, h10);
    }

    private void p() {
        d.v.d.i.f.e e10;
        this.j = e10 = new d.v.d.i.f.e();
        this.b(260, e10);
    }

    private void q() {
        d.v.d.i.f.f f10;
        this.i = f10 = new d.v.d.i.f.f();
        this.b(258, f10);
    }

    private void r() {
        g g10;
        this.w = g10 = new g();
        this.b(272, g10);
    }

    private void s() {
        h h10;
        this.z = h10 = new h();
        this.b(277, h10);
    }

    private void t() {
        s s10;
        this.r = s10 = new s();
        this.b(289, s10);
    }

    private void u() {
        i i10;
        this.s = i10 = new i();
        this.b(279, i10);
    }

    private void v() {
        j j10;
        this.u = j10 = new j();
        this.b(278, j10);
    }

    private void w() {
        k k10;
        this.B = k10 = new k();
        this.b(281, k10);
    }

    private void x(Context context) {
        l l10;
        this.o = l10 = new l(context);
        this.b(256, l10);
    }

    private void y() {
        m m10;
        this.l = m10 = new m();
        this.b(262, m10);
    }

    private void z() {
        n n10;
        this.y = n10 = new n();
        this.b(273, n10);
    }

    public q A0() {
        return this.A;
    }

    public r B0() {
        return this.k;
    }

    public s C0() {
        return this.r;
    }

    public t D0() {
        return this.v;
    }

    public u E0() {
        return this.t;
    }

    public v F0() {
        return this.C;
    }

    public w G0() {
        return this.x;
    }

    public x H0() {
        return this.m;
    }

    public y I0() {
        return this.n;
    }

    public z J0() {
        return this.p;
    }

    public a0 K0() {
        return this.q;
    }

    public d.v.d.i.g.c L0() {
        return this.O;
    }

    public d.v.d.i.g.d M0() {
        return this.T;
    }

    public d.v.d.i.g.e N0() {
        return this.R;
    }

    public d.v.d.i.g.f O0() {
        return this.L;
    }

    public d.v.d.i.g.g P0() {
        return this.U;
    }

    public d.v.d.i.g.h Q0() {
        return this.S;
    }

    public d.v.d.i.g.j R0() {
        return this.N;
    }

    public d.v.d.i.g.k S0() {
        return this.M;
    }

    public d.v.d.i.g.l T0() {
        return this.K;
    }

    public d.v.d.i.g.m U0() {
        return this.Q;
    }

    public d.v.d.i.g.n V0() {
        return this.P;
    }

    public a W0() {
        return this.e;
    }

    public b X0() {
        return this.c;
    }

    public d Y0() {
        return this.f;
    }

    public d.v.d.i.b.e Z0() {
        return this.d;
    }

    public void a() {
        Object object = new StringBuilder();
        Object object2 = "mSemaphore acquire =";
        ((StringBuilder)object).append((String)object2);
        object2 = Thread.currentThread();
        object2 = ((Thread)object2).getName();
        ((StringBuilder)object).append((String)object2);
        object = ((StringBuilder)object).toString();
        d.v.d.h.f.a((String)object);
        object = this.b;
        try {
            ((Semaphore)object).acquire();
        }
        catch (InterruptedException interruptedException) {
            interruptedException.printStackTrace();
            object2 = new StringBuilder();
            String string2 = "get lock interrupted exception e=";
            ((StringBuilder)object2).append(string2);
            ((StringBuilder)object2).append(interruptedException);
            String string3 = ((StringBuilder)object2).toString();
            d.v.d.h.f.a(string3);
        }
    }

    public SparseArray a1() {
        return this.a;
    }

    public void b(int n10, d.v.d.i.a.a a10) {
        this.a.append(n10, (Object)a10);
    }

    public void c1() {
        Object object;
        int n10;
        d.v.d.h.f.a("release camera parameter");
        for (int i10 = 0; i10 < (n10 = (object = this.a).size()); ++i10) {
            object = (d.v.d.i.a.c)this.a.valueAt(i10);
            object.b();
        }
        this.X.removeCallbacksAndMessages(null);
        this.X.getLooper().quitSafely();
        this.Y.removeCallbacksAndMessages(null);
        this.Y.getLooper().quitSafely();
    }

    public Handler d0() {
        return this.X;
    }

    public void d1() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("mSemaphore release=");
        String string2 = Thread.currentThread().getName();
        stringBuilder.append(string2);
        d.v.d.h.f.a(stringBuilder.toString());
        this.b.release();
    }

    public d.v.d.i.c.a e0() {
        return this.g;
    }

    public d.v.d.i.c.c f0() {
        return this.h;
    }

    public c g0() {
        return this.W;
    }

    public d.v.d.i.d.d h0() {
        return this.V;
    }

    public Handler i0() {
        return this.Y;
    }

    public d.v.d.i.e.a j0() {
        return this.F;
    }

    public d.v.d.i.e.b k0() {
        return this.G;
    }

    public d.v.d.i.e.c l0() {
        return this.J;
    }

    public d.v.d.i.e.f m0() {
        return this.H;
    }

    public d.v.d.i.e.g n0() {
        return this.E;
    }

    public d.v.d.i.e.h o0() {
        return this.I;
    }

    public d.v.d.i.f.e p0() {
        return this.j;
    }

    public d.v.d.i.f.f q0() {
        return this.i;
    }

    public g r0() {
        return this.w;
    }

    public h s0() {
        return this.z;
    }

    public i t0() {
        return this.s;
    }

    public j u0() {
        return this.u;
    }

    public k v0() {
        return this.B;
    }

    public l w0() {
        return this.o;
    }

    public m x0() {
        return this.l;
    }

    public n y0() {
        return this.y;
    }

    public o z0() {
        return this.D;
    }
}

