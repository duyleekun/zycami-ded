/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0.n1.g;

import com.zhiyun.proto.ZYEnumDefine$ConnectAction;
import d.v.a0.n1.g.a;
import d.v.a0.n1.g.b;
import d.v.a0.n1.g.c;
import d.v.a0.n1.g.d;
import d.v.a0.n1.g.e;
import d.v.a0.n1.g.f;
import d.v.a0.n1.g.g;
import d.v.a0.n1.g.h;
import d.v.a0.n1.g.i;
import d.v.a0.n1.g.t;
import d.v.a0.n1.g.v;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class u {
    private final List a;

    public u() {
        ArrayList arrayList;
        this.a = arrayList = new ArrayList();
    }

    public static /* synthetic */ void c(String string2, v v10) {
        v10.n(string2);
    }

    public static /* synthetic */ void d(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction, v v10) {
        v10.l(zYEnumDefine$ConnectAction);
    }

    public static /* synthetic */ void e(String string2, Throwable throwable, int n10, v v10) {
        d.v.k0.g.d.h(string2, throwable, n10, v10);
    }

    private /* synthetic */ void f(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        Stream stream = this.a.stream();
        a a10 = new a(zYEnumDefine$ConnectAction);
        stream.forEach(a10);
    }

    private /* synthetic */ void h() {
        Stream stream = this.a.stream();
        i i10 = i.a;
        stream.forEach(i10);
    }

    private /* synthetic */ void j(String string2) {
        Stream stream = this.a.stream();
        g g10 = new g(string2);
        stream.forEach(g10);
    }

    private /* synthetic */ void l() {
        Stream stream = this.a.stream();
        t t10 = t.a;
        stream.forEach(t10);
    }

    private /* synthetic */ void n(String string2, Throwable throwable, int n10) {
        Stream stream = this.a.stream();
        c c10 = new c(string2, throwable, n10);
        stream.forEach(c10);
    }

    public void a(v v10) {
        if (v10 == null) {
            return;
        }
        this.a.add(v10);
    }

    public void b() {
        this.a.clear();
    }

    public /* synthetic */ void g(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        this.f(zYEnumDefine$ConnectAction);
    }

    public /* synthetic */ void i() {
        this.h();
    }

    public /* synthetic */ void k(String string2) {
        this.j(string2);
    }

    public /* synthetic */ void m() {
        this.l();
    }

    public /* synthetic */ void o(String string2, Throwable throwable, int n10) {
        this.n(string2, throwable, n10);
    }

    public void p(v v10) {
        if (v10 == null) {
            return;
        }
        this.a.remove(v10);
    }

    public void q(ZYEnumDefine$ConnectAction zYEnumDefine$ConnectAction) {
        b b10 = new b(this, zYEnumDefine$ConnectAction);
        d.v.k0.g.d.i(b10);
    }

    public void r() {
        d d10 = new d(this);
        d.v.k0.g.d.i(d10);
    }

    public void s(String string2) {
        f f10 = new f(this, string2);
        d.v.k0.g.d.i(f10);
    }

    public void t() {
        e e10 = new e(this);
        d.v.k0.g.d.i(e10);
    }

    public void u(String string2, Throwable throwable, int n10) {
        h h10 = new h(this, string2, throwable, n10);
        d.v.k0.g.d.i(h10);
    }
}

