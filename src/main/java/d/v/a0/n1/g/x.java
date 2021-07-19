/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.h1;
import d.v.a0.n1.g.j;
import d.v.a0.n1.g.k;
import d.v.a0.n1.g.l;
import d.v.a0.n1.g.m;
import d.v.a0.n1.g.n;
import d.v.a0.n1.g.o;
import d.v.a0.n1.g.p;
import d.v.a0.n1.g.q;
import d.v.a0.n1.g.r;
import d.v.a0.n1.g.s;
import d.v.a0.n1.g.w;
import d.v.k0.g.d;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class x {
    private final List a;

    public x() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public static /* synthetic */ void c(h1 h12, d.v.z.l.d d10, w w10) {
        w10.e(h12, d10);
    }

    public static /* synthetic */ void d(h1 h12, w w10) {
        w10.c(h12);
    }

    public static /* synthetic */ void e(h1 h12, w w10) {
        w10.a(h12);
    }

    public static /* synthetic */ void f(h1 h12, w w10) {
        w10.b(h12);
    }

    public static /* synthetic */ void g(h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, w w10) {
        w10.d(h12, zYEnumDefine$ConnectAction);
    }

    private /* synthetic */ void h(h1 h12) {
        Stream stream = this.a.stream();
        n n10 = new n(h12);
        stream.forEach(n10);
    }

    private /* synthetic */ void j(h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        Stream stream = this.a.stream();
        r r10 = new r(h12, zYEnumDefine$ConnectAction);
        stream.forEach(r10);
    }

    private /* synthetic */ void l(h1 h12) {
        Stream stream = this.a.stream();
        k k10 = new k(h12);
        stream.forEach(k10);
    }

    private /* synthetic */ void n(h1 h12) {
        Stream stream = this.a.stream();
        q q10 = new q(h12);
        stream.forEach(q10);
    }

    private /* synthetic */ void p(h1 h12, d.v.z.l.d d10) {
        Stream stream = this.a.stream();
        s s10 = new s(h12, d10);
        stream.forEach(s10);
    }

    public void a(w w10) {
        if (w10 == null) {
            return;
        }
        this.a.add(w10);
    }

    public void b() {
        this.a.clear();
    }

    public /* synthetic */ void i(h1 h12) {
        this.h(h12);
    }

    public /* synthetic */ void k(h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.j(h12, zYEnumDefine$ConnectAction);
    }

    public /* synthetic */ void m(h1 h12) {
        this.l(h12);
    }

    public /* synthetic */ void o(h1 h12) {
        this.n(h12);
    }

    public /* synthetic */ void q(h1 h12, d.v.z.l.d d10) {
        this.p(h12, d10);
    }

    public void r(w w10) {
        if (w10 == null) {
            return;
        }
        this.a.remove(w10);
    }

    public void s(h1 h12) {
        m m10 = new m(this, h12);
        d.i(m10);
    }

    public void t(h1 h12, ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        p p10 = new p(this, h12, zYEnumDefine$ConnectAction);
        d.i(p10);
    }

    public void u(h1 h12) {
        l l10 = new l(this, h12);
        d.i(l10);
    }

    public void v(h1 h12) {
        o o10 = new o(this, h12);
        d.i(o10);
    }

    public void w(h1 h12, d.v.z.l.d d10) {
        j j10 = new j(this, h12, d10);
        d.i(j10);
    }
}

