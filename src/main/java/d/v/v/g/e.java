/*
 * Decompiled with CFR 0.151.
 */
package d.v.v.g;

import com.meicam.sdk.NvsLiveWindow;
import com.meicam.sdk.NvsStreamingContext;
import com.meicam.sdk.NvsTimeline;
import com.meicam.sdk.NvsVideoTrack;
import com.zhiyun.editorinterface.EditConfig$ResourceType;
import com.zhiyun.editorinterface.decoration.DecorationType;
import d.v.h.d.d$a;
import d.v.h.e.c;
import d.v.h.e.d;
import d.v.h.h.a$a;
import d.v.h.k.b;
import d.v.v.d.a;
import d.v.v.f.i;
import d.v.v.f.k;
import d.v.v.g.f;
import d.v.v.g.g;
import d.v.v.g.h;
import d.v.v.q.j;
import java.util.List;

public class e
implements c {
    private g a;

    public long A() {
        return d.v.v.q.h.n();
    }

    public boolean A0(int n10, boolean bl2) {
        new d.v.v.m.a();
        return d.v.v.m.a.h().q(n10, bl2);
    }

    public boolean A1(int n10, boolean bl2) {
        return d.v.v.k.a.j().f(n10, bl2);
    }

    public boolean B(long l10) {
        return d.v.v.k.a.j().B(l10);
    }

    public boolean B0(int n10) {
        return f.k().h(n10);
    }

    public boolean B1(String string2, Long l10) {
        d.v.v.l.e.t().w(string2, l10);
        return false;
    }

    public void C(a$a a$a) {
        d.v.v.l.e.t().C(a$a);
    }

    public boolean C0(float f10) {
        return d.v.v.l.e.t().setVolume(f10);
    }

    public boolean C1(int n10) {
        return this.a.A(n10);
    }

    public boolean D() {
        return d.v.v.l.e.t().D();
    }

    public void D0() {
        g g10 = this.a;
        if (g10 != null) {
            g10.F();
        }
    }

    public boolean D1(int n10) {
        d.v.v.j.h h10 = d.v.v.j.h.t();
        d d10 = h10.v(n10);
        if (d10 == null) {
            return false;
        }
        return d10.j();
    }

    public boolean E() {
        return d.v.v.k.a.j().E();
    }

    public boolean E0(int n10, float f10) {
        return d.v.v.m.a.h().u(n10, f10, f10);
    }

    public boolean E1(boolean bl2) {
        return d.v.v.l.e.t().e(bl2);
    }

    public boolean F(int n10, int n11) {
        return d.v.v.h.a.x().F(n10, n11);
    }

    public void F0(long l10, long l11) {
        h.k().D(l10, l11);
    }

    public void F1(int n10) {
        this.a.setPlayViewBackground(n10);
    }

    public boolean G(boolean bl2) {
        return d.v.v.h.a.x().G(bl2);
    }

    public boolean G0(int n10, int n11, boolean bl2) {
        return d.v.v.e.a.f().j(n10, n11, bl2);
    }

    public long G1(int n10) {
        return d.v.v.q.h.g0(n10);
    }

    public boolean H(int n10) {
        return d.v.v.h.a.x().H(n10);
    }

    public boolean H0(boolean bl2) {
        return d.v.v.n.a.f().m(bl2);
    }

    public boolean H1(long l10) {
        return d.v.v.e.a.f().i(l10);
    }

    public void I(d.v.h.e.b b10) {
        d.v.v.j.g.c().a(b10);
    }

    public void I0(int n10, Long l10, long l11) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.w(n10, l10, l11);
    }

    public boolean I1(int n10, long l10) {
        return d.v.v.e.a.f().b(n10, l10);
    }

    public boolean J() {
        return d.v.v.j.h.t().n().isGlobalVideoMute();
    }

    public boolean J0(long l10) {
        return d.v.v.e.a.f().c(l10);
    }

    public boolean J1(boolean bl2) {
        return d.v.v.u.a.e(bl2);
    }

    public boolean K(int n10, boolean bl2) {
        return d.v.v.h.a.x().K(n10, bl2);
    }

    public boolean K0(int n10, int n11, boolean bl2) {
        return d.v.v.m.a.h().t(n10, n11, bl2);
    }

    public boolean K1(int n10, int n11, boolean bl2) {
        return d.v.v.u.a.f(n10, n11, bl2);
    }

    public boolean L(int n10, long l10) {
        return d.v.v.k.a.j().L(n10, l10);
    }

    public boolean L0(int n10, int n11, int n12) {
        d.v.v.m.a a10 = d.v.v.m.a.h();
        float f10 = n11;
        float f11 = n12;
        return a10.v(n10, f10, f11);
    }

    public float L1(int n10) {
        return d.v.v.m.a.h().f(n10);
    }

    public boolean M() {
        return d.v.v.j.i.e().i();
    }

    public boolean M0(int n10, float f10, float f11) {
        return d.v.v.m.a.h().u(n10, f10, f11);
    }

    public void M1(d.v.h.e.f f10) {
        f10 = (g)f10;
        this.a = f10;
        d.v.v.q.h.h((g)f10);
    }

    public boolean N() {
        return d.v.v.l.e.t().N();
    }

    public boolean N0(int n10, String string2, boolean bl2) {
        return d.v.v.n.a.f().a(n10, string2, bl2);
    }

    public boolean N1() {
        return h.k().s();
    }

    public boolean O(d.v.h.f.a a10, boolean bl2) {
        return d.v.v.h.a.x().O(a10, bl2);
    }

    public void O0(boolean bl2) {
        h.k().J(bl2);
    }

    public boolean O1(int n10, int n11, boolean bl2) {
        return d.v.v.m.a.h().l(n10, n11, bl2);
    }

    public boolean P(float f10) {
        return false;
    }

    public boolean P0() {
        return h.k().q();
    }

    public boolean P1(int n10, long l10) {
        return d.v.v.l.e.t().o(n10, l10);
    }

    public boolean Q(int n10, long l10, long l11) {
        return d.v.v.e.a.f().d(n10, l10, l11);
    }

    public List Q0() {
        return d.v.v.j.h.t().n().getTextInfoList();
    }

    public boolean Q1(int n10) {
        return d.v.v.m.a.h().b(n10);
    }

    public void R() {
        d.v.v.n.a.f().c();
    }

    public List R0() {
        return d.v.v.j.h.t().q();
    }

    public boolean R1(int n10, boolean bl2) {
        return d.v.v.r.a.c().e(n10, bl2);
    }

    public boolean S(long l10) {
        return d.v.v.r.a.c().a(l10);
    }

    public void S0(DecorationType decorationType, int n10, Long l10, long l11) {
        Object object = this.a;
        k k10 = new k((g)((Object)object));
        object = decorationType;
        k10.I(decorationType, n10, l10, l11);
    }

    public boolean S1(long l10) {
        return d.v.v.l.e.t().B(l10);
    }

    public boolean T(int n10, int n11, boolean bl2) {
        return d.v.v.m.a.h().p(n10, n11, bl2);
    }

    public boolean T0(int n10, boolean bl2) {
        return d.v.v.u.a.g(n10, bl2);
    }

    public boolean T1(int n10, boolean bl2) {
        return f.k().p(n10, bl2);
    }

    public boolean U(float f10) {
        return d.v.v.r.a.c().j(f10);
    }

    public void U0() {
        d.v.v.l.e.t().c();
    }

    public double U1() {
        return d.v.v.n.a.f().e();
    }

    public void V(int n10, long l10) {
        d.v.v.k.a.j().s(n10, l10);
    }

    public boolean V0(String string2) {
        return false;
    }

    public boolean V1(int n10, long l10, long l11, long l12, boolean bl2) {
        return d.v.v.l.e.t().m(n10, l10, l11, l12, bl2);
    }

    public boolean W(boolean bl2) {
        return d.v.v.k.a.j().e(bl2);
    }

    public void W0(d.v.h.d.c c10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.b(c10);
    }

    public boolean W1(int n10, d.v.h.e.a a10) {
        f f10 = f.k();
        a10 = j.f(a10);
        return f10.b(n10, (d)a10);
    }

    public void X(boolean bl2) {
        g g10 = this.a;
        if (g10 != null) {
            g10.setSendPlayAreaClickEnable(bl2);
        }
    }

    public void X0() {
        d.v.v.k.a.j().c();
    }

    public List X1() {
        return d.v.v.j.h.t().n().getPasteInfoList();
    }

    public void Y() {
        g g10 = this.a;
        if (g10 != null) {
            g10.W();
        }
    }

    public boolean Y0(boolean bl2) {
        return d.v.v.r.a.c().i(bl2);
    }

    public boolean Y1(int n10) {
        return false;
    }

    public void Z(int n10) {
        Object object = this.a;
        k k10 = new k((g)((Object)object));
        object = DecorationType.GIF_PASTER;
        k10.B((DecorationType)((Object)object), n10);
    }

    public boolean Z0(d.v.h.h.b b10) {
        return d.v.v.l.e.t().l(b10);
    }

    public long Z1(int n10) {
        return d.v.v.q.h.G().getClipByIndex(n10).getFadeInDuration();
    }

    public boolean a() {
        return d.v.v.l.e.t().a();
    }

    public void a0(d.v.h.e.f f10, d.v.h.e.a[] aArray) {
        this.g2(f10, aArray, -1);
    }

    public void a1() {
        d.v.v.l.e.t().c();
    }

    public boolean a2(double d10) {
        return d.v.v.n.a.f().k(d10);
    }

    public void b(d.v.h.e.b b10) {
        d.v.v.j.g.c().d(b10);
    }

    public void b0() {
        d.v.v.p.b.j().e();
    }

    public int b1() {
        return d.v.v.q.h.p();
    }

    public List b2() {
        return d.v.v.l.e.t().p();
    }

    public void c(int n10, int n11) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.c(n10, n11);
    }

    public void c0(int n10) {
        Object object = this.a;
        i i10 = new i((g)((Object)object));
        object = DecorationType.FONT;
        i10.B((DecorationType)((Object)object), n10);
    }

    public boolean c1(int n10, Long l10) {
        return d.v.v.l.e.t().x(n10, l10);
    }

    public boolean c2() {
        d.v.v.j.i.e().a();
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = d.v.v.j.i.e().f();
        NvsLiveWindow nvsLiveWindow = this.a.getNvsLiveWindow();
        nvsStreamingContext.connectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
        return true;
    }

    public void d(int n10, String string2, int n11) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.d(n10, string2, n11);
    }

    public boolean d0(boolean bl2) {
        return f.k().q(bl2);
    }

    public long d1(int n10) {
        return d.v.v.j.h.t().w(n10).i();
    }

    public void d2(int n10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.z(n10);
    }

    public boolean e() {
        return d.v.v.d.a.n().e();
    }

    public void e0(int n10, d.v.h.e.g g10) {
        f.k().o(n10, g10);
    }

    public boolean e1(int n10, String string2) {
        return f.k().r(n10, string2);
    }

    public int e2() {
        return d.v.v.j.h.t().n().getAspectRadio();
    }

    public void f(int n10, d$a d$a) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.f(n10, d$a);
    }

    public List f0() {
        return d.v.v.j.h.t().s();
    }

    public void f1(d.v.h.d.d d10, int n10, d.v.h.e.e e10) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.g(d10, n10, e10);
    }

    public void f2(int n10) {
        Object object = this.a;
        k k10 = new k((g)((Object)object));
        object = DecorationType.IMAGE_PASTER;
        k10.B((DecorationType)((Object)object), n10);
    }

    public boolean g(long l10) {
        return d.v.v.k.a.j().g(l10);
    }

    public int g0() {
        return d.v.v.j.h.t().n().getGlobalZoomMode();
    }

    public boolean g1(boolean bl2) {
        return d.v.v.k.a.j().b(bl2);
    }

    public void g2(d.v.h.e.f object, d.v.h.e.a[] object2, int n10) {
        object = (g)((Object)object);
        this.a = object;
        object = d.v.v.j.i.e();
        boolean bl2 = ((d.v.v.j.i)object).h((d.v.h.e.a[])object2, n10);
        if (bl2) {
            d.v.v.o.a.c.d().f();
            object2 = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = d.v.v.j.i.e().f();
            NvsLiveWindow nvsLiveWindow = this.a.getNvsLiveWindow();
            ((NvsStreamingContext)object2).connectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
            object2 = h.k();
            long l10 = 0L;
            ((h)object2).H(l10);
        }
        d.v.v.j.g.c().n(bl2);
    }

    public boolean h(int n10, b b10, boolean bl2) {
        return d.v.v.p.a.e().h(n10, b10, bl2);
    }

    public boolean h0(int n10, float f10) {
        return d.v.v.l.e.t().h(n10, f10);
    }

    public void h1() {
        f.k().g();
    }

    public boolean h2(int n10, float f10) {
        return d.v.v.k.a.j().h(n10, f10);
    }

    public long i() {
        NvsVideoTrack nvsVideoTrack = d.v.v.q.h.h0();
        if (nvsVideoTrack == null) {
            return -1;
        }
        return nvsVideoTrack.getDuration();
    }

    public boolean i0(int n10, float f10) {
        return d.v.v.r.a.c().k(n10, f10);
    }

    public void i1(long l10, long l11) {
        h.k().o(false, l10, l11);
    }

    public void i2(int n10) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.z(n10);
    }

    public boolean isPlaying() {
        return h.k().r();
    }

    public d.v.h.f.a j() {
        d.v.h.f.a a10 = d.v.v.j.h.t().n().getGlobalFrameEffectInfo();
        if (a10 == null) {
            a10 = new d.v.h.f.a();
        }
        return a10;
    }

    public boolean j0(List list, List list2) {
        return f.k().d(list, list2);
    }

    public boolean j1(boolean bl2) {
        return d.v.v.m.a.h().w(bl2);
    }

    public boolean j2() {
        return d.v.v.l.e.t().E();
    }

    public boolean k(int n10, d.v.h.f.a a10, boolean bl2) {
        return d.v.v.h.a.x().k(n10, a10, bl2);
    }

    public void k0(d.v.h.d.c c10, d.v.h.e.e e10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.e(c10, e10);
    }

    public boolean k1(int n10, long l10, long l11, boolean bl2) {
        return d.v.v.l.e.t().r(n10, l10, l11, bl2);
    }

    public String k2(int n10) {
        return d.v.v.n.a.f().d(n10);
    }

    public boolean l(d.v.h.h.b b10) {
        return d.v.v.k.a.j().l(b10);
    }

    public boolean l0(int n10, boolean bl2) {
        return d.v.v.l.e.t().f(n10, bl2);
    }

    public int l1(int n10) {
        return d.v.v.m.a.h().c(n10);
    }

    public void l2() {
        g g10 = this.a;
        if (g10 != null) {
            g10.V();
        }
    }

    public boolean m(int n10, long l10, long l11, long l12, boolean bl2) {
        return d.v.v.k.a.j().m(n10, l10, l11, l12, bl2);
    }

    public boolean m0(float f10) {
        return d.v.v.k.a.j().setVolume(f10);
    }

    public double m1(int n10) {
        return d.v.v.n.a.f().g(n10);
    }

    public void m2(boolean bl2, String string2) {
        g g10 = this.a;
        if (g10 != null) {
            g10.h0(bl2, string2);
        }
    }

    public boolean n(List list) {
        return d.v.v.k.a.j().n(list);
    }

    public int n0() {
        return d.v.v.j.h.t().n().getGlobalRotationMode();
    }

    public int n1(int n10) {
        return d.v.v.m.a.h().d(n10);
    }

    public boolean n2(int n10, long l10, boolean bl2) {
        return d.v.v.p.a.e().d(n10, l10, bl2);
    }

    public void next() {
        h.k().t();
    }

    public boolean o(int n10, long l10) {
        return d.v.v.k.a.j().o(n10, l10);
    }

    public List o0() {
        return d.v.v.j.h.t().n().getMediaInfoList();
    }

    public boolean o1(int n10, double d10) {
        return d.v.v.n.a.f().l(n10, d10);
    }

    public boolean o2(int n10) {
        return d.v.v.l.e.t().y(n10);
    }

    public List p() {
        return d.v.v.k.a.j().p();
    }

    public boolean p0(int n10, boolean bl2) {
        return d.v.v.p.a.e().c(n10, bl2);
    }

    public boolean p1(int n10, long l10) {
        return d.v.v.e.a.f().h(n10, l10);
    }

    public boolean p2(List list) {
        return d.v.v.l.e.t().n(list);
    }

    public void pause() {
        h.k().B();
    }

    public void play() {
        h.k().C();
    }

    public void previous() {
        h.k().v();
    }

    public boolean q(boolean bl2) {
        return d.v.v.h.a.x().q(bl2);
    }

    public void q0(int n10, Long l10, long l11) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.w(n10, l10, l11);
    }

    public void q1(String string2) {
        a a10 = d.v.v.d.a.n();
        a10.f(string2);
        a10.i();
    }

    public boolean q2(long l10) {
        return d.v.v.l.e.t().g(l10);
    }

    public boolean r(int n10, long l10, long l11, boolean bl2) {
        return d.v.v.k.a.j().r(n10, l10, l11, bl2);
    }

    public String r0() {
        return d.v.v.j.h.t().n().getWaterMarkPath();
    }

    public boolean r1(long l10) {
        return h.k().H(l10);
    }

    public void release() {
        g g10 = this.a;
        if (g10 != null) {
            g10.E();
        }
        NvsStreamingContext.getInstance().stop();
        NvsStreamingContext.getInstance().clearCachedResources(false);
        d.v.v.j.g.c().b();
        d.v.v.j.h.t().m();
        d.v.v.o.a.c.d().i();
        h.k().G();
        d.v.v.d.a.n().m();
        d.v.v.j.i.e().m();
        d.v.v.l.e.t().release();
        d.v.v.q.g.k().s();
    }

    public boolean s(int n10, float f10, boolean bl2) {
        return d.v.v.h.a.x().s(n10, f10, bl2);
    }

    public void s0() {
        h.k().i();
    }

    public boolean s1(boolean bl2) {
        return d.v.v.r.a.c().f(bl2);
    }

    public boolean t(int n10) {
        return f.k().j(n10);
    }

    public void t0() {
        g g10 = this.a;
        if (g10 != null) {
            g10.i0();
        }
    }

    public boolean t1(int n10) {
        return false;
    }

    public float u() {
        return d.v.v.j.h.t().n().getGlobalVideoVolume();
    }

    public void u0(d.v.h.d.d d10) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.a(d10);
    }

    public void u1() {
        g g10 = this.a;
        if (g10 != null) {
            g10.j0();
        }
    }

    public void v(int n10, String string2) {
        g g10 = this.a;
        i i10 = new i(g10);
        i10.v(n10, string2);
    }

    public boolean v0(boolean bl2) {
        return d.v.v.l.e.t().b(bl2);
    }

    public boolean v1(int n10, long l10) {
        return d.v.v.l.e.t().L(n10, l10);
    }

    public boolean w(int n10, int n11, float f10, boolean bl2) {
        return d.v.v.h.a.x().w(n10, n11, f10, bl2);
    }

    public void w0(d.v.h.d.c c10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.b(c10);
    }

    public void w1() {
        g g10 = this.a;
        if (g10 != null) {
            g10.X();
        }
    }

    public boolean x(int n10, Long l10) {
        return d.v.v.k.a.j().x(n10, l10);
    }

    public void x0(d.v.h.d.c c10, int n10, d.v.h.e.e e10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.u(c10, n10, e10);
    }

    public boolean x1(d.v.h.e.a[] aArray) {
        Object object = d.v.v.j.i.e();
        boolean bl2 = ((d.v.v.j.i)object).g(aArray);
        if (bl2) {
            object = NvsStreamingContext.getInstance();
            NvsTimeline nvsTimeline = d.v.v.j.i.e().f();
            NvsLiveWindow nvsLiveWindow = this.a.getNvsLiveWindow();
            ((NvsStreamingContext)object).connectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
            object = h.k();
            long l10 = 0L;
            ((h)object).H(l10);
        }
        return bl2;
    }

    public boolean y(int n10) {
        return d.v.v.k.a.j().y(n10);
    }

    public boolean y0(boolean bl2) {
        d.v.v.j.i.e().d(bl2);
        NvsStreamingContext nvsStreamingContext = NvsStreamingContext.getInstance();
        NvsTimeline nvsTimeline = d.v.v.j.i.e().f();
        NvsLiveWindow nvsLiveWindow = this.a.getNvsLiveWindow();
        nvsStreamingContext.connectTimelineWithLiveWindow(nvsTimeline, nvsLiveWindow);
        h.k().H(0L);
        return true;
    }

    public void y1(int n10, long l10) {
        d.v.v.k.a.j().t(n10, l10);
    }

    public boolean z(boolean bl2) {
        return d.v.v.h.a.x().z(bl2);
    }

    public void z0(int n10) {
        g g10 = this.a;
        k k10 = new k(g10);
        k10.E(n10);
    }

    public boolean z1(EditConfig$ResourceType editConfig$ResourceType, String string2, String string3) {
        return d.v.v.q.f.d().i(editConfig$ResourceType, string2, string3);
    }
}

