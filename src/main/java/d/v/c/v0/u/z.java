/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.v0.u;

import com.zhiyun.cama.data.api.entity.ServerEntity;
import com.zhiyun.cama.data.me.remote.UpdateManager;
import com.zhiyun.cama.data.me.remote.UpdateManager$OnUpdateVersionCallback;
import com.zhiyun.net.download.DownLoadHelper;
import com.zhiyun.net.download.DownLoadHelper$OnDownloadCallback;
import d.v.a.f.b.a;
import d.v.c.i1.k2;
import d.v.c.v0.u.b0.c;

public class z {
    private static volatile z a;

    private z() {
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static z m() {
        Object object = a;
        if (object != null) return a;
        object = z.class;
        synchronized (object) {
            z z10 = a;
            if (z10 != null) return a;
            a = z10 = new z();
            return a;
        }
    }

    public boolean A() {
        return c.X();
    }

    public boolean B() {
        return c.Y();
    }

    public void C() {
        k2.e().n(false);
        k2.e().l(false);
        k2.e().k(false);
        k2.e().m(false);
        k2.e().i(false);
        k2.e().o(false);
        this.G(false);
        this.P(false);
        this.N(false);
        this.K(false);
        this.R(false);
        this.Q(false);
    }

    public void D(ServerEntity serverEntity) {
        c.l0(serverEntity);
    }

    public void E(boolean bl2) {
        c.b0(bl2);
    }

    public void F(boolean bl2) {
        c.c0(bl2);
    }

    public void G(boolean bl2) {
        c.d0(bl2);
        c.e0(bl2);
    }

    public void H(String string2) {
        c.f0(string2);
    }

    public void I(boolean bl2) {
        c.A0(bl2);
    }

    public void J(boolean bl2) {
        c.h0(bl2);
    }

    public void K(boolean bl2) {
        c.i0(bl2);
    }

    public void L(boolean bl2) {
        c.j0(bl2);
    }

    public void M(boolean bl2) {
        c.k0(bl2);
    }

    public void N(boolean bl2) {
        c.m0(bl2);
    }

    public void O(boolean bl2) {
        c.n0(bl2);
    }

    public void P(boolean bl2) {
        c.o0(bl2);
    }

    public void Q(boolean bl2) {
        c.p0(bl2);
    }

    public void R(boolean bl2) {
        c.q0(bl2);
    }

    public void S(boolean bl2) {
        c.r0(bl2);
    }

    public void T(boolean bl2) {
        c.s0(bl2);
    }

    public void U(boolean bl2) {
        c.t0(bl2);
    }

    public void V(boolean bl2) {
        c.u0(bl2);
    }

    public void W(boolean bl2) {
        c.v0(bl2);
    }

    public void X(boolean bl2) {
        c.y0(bl2);
    }

    public void Y(boolean bl2) {
        c.z0(bl2);
    }

    public void a(UpdateManager$OnUpdateVersionCallback updateManager$OnUpdateVersionCallback) {
        UpdateManager.getInstance().checkUpdate(updateManager$OnUpdateVersionCallback);
    }

    public void b(String string2, String string3, String string4, DownLoadHelper$OnDownloadCallback downLoadHelper$OnDownloadCallback) {
        DownLoadHelper.getInstance().startDownLoad(string4, string2, string3, downLoadHelper$OnDownloadCallback);
    }

    public boolean c() {
        return c.z();
    }

    public boolean d() {
        return c.A();
    }

    public boolean e() {
        return c.B();
    }

    public boolean f() {
        return c.C();
    }

    public String g() {
        return "https://camih5.zhiyun-tech.com/";
    }

    public String h() {
        return c.D();
    }

    public boolean i() {
        return c.F();
    }

    public boolean j() {
        return c.G();
    }

    public boolean k() {
        return c.H();
    }

    public boolean l() {
        return c.I();
    }

    public boolean n() {
        return c.J();
    }

    public ServerEntity o() {
        return c.K();
    }

    public boolean p() {
        return c.L();
    }

    public boolean q() {
        return c.M();
    }

    public boolean r() {
        return c.N();
    }

    public void s(a a10) {
        d.v.c.v0.l.a.a.f().h(a10);
    }

    public boolean t() {
        return c.O();
    }

    public boolean u() {
        return c.P();
    }

    public boolean v() {
        return c.Q();
    }

    public boolean w() {
        return c.R();
    }

    public boolean x() {
        return c.S();
    }

    public boolean y() {
        return c.T();
    }

    public boolean z() {
        return c.U();
    }
}

