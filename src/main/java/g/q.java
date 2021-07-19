/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.e;
import g.i;
import g.q$a;
import g.q$b;
import g.t;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.List;
import okhttp3.Handshake;
import okhttp3.Protocol;

public abstract class q {
    public static final q a;
    public static final q$b b;

    static {
        Object object = new q$b(null);
        b = object;
        a = object = new q$a();
    }

    public void A(e e10, c0 c02) {
        f0.p(e10, "call");
        f0.p(c02, "response");
    }

    public void B(e e10, Handshake handshake2) {
        f0.p(e10, "call");
    }

    public void C(e e10) {
        f0.p(e10, "call");
    }

    public void a(e e10, c0 c02) {
        f0.p(e10, "call");
        f0.p(c02, "cachedResponse");
    }

    public void b(e e10, c0 c02) {
        f0.p(e10, "call");
        f0.p(c02, "response");
    }

    public void c(e e10) {
        f0.p(e10, "call");
    }

    public void d(e e10) {
        f0.p(e10, "call");
    }

    public void e(e e10, IOException iOException) {
        f0.p(e10, "call");
        f0.p(iOException, "ioe");
    }

    public void f(e e10) {
        f0.p(e10, "call");
    }

    public void g(e e10) {
        f0.p(e10, "call");
    }

    public void h(e e10, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol) {
        f0.p(e10, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
    }

    public void i(e e10, InetSocketAddress inetSocketAddress, Proxy proxy, Protocol protocol, IOException iOException) {
        f0.p(e10, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
        f0.p(iOException, "ioe");
    }

    public void j(e e10, InetSocketAddress inetSocketAddress, Proxy proxy) {
        f0.p(e10, "call");
        f0.p(inetSocketAddress, "inetSocketAddress");
        f0.p(proxy, "proxy");
    }

    public void k(e e10, i i10) {
        f0.p(e10, "call");
        f0.p(i10, "connection");
    }

    public void l(e e10, i i10) {
        f0.p(e10, "call");
        f0.p(i10, "connection");
    }

    public void m(e e10, String string2, List list) {
        f0.p(e10, "call");
        f0.p(string2, "domainName");
        f0.p(list, "inetAddressList");
    }

    public void n(e e10, String string2) {
        f0.p(e10, "call");
        f0.p(string2, "domainName");
    }

    public void o(e e10, t t10, List list) {
        f0.p(e10, "call");
        f0.p(t10, "url");
        f0.p(list, "proxies");
    }

    public void p(e e10, t t10) {
        f0.p(e10, "call");
        f0.p(t10, "url");
    }

    public void q(e e10, long l10) {
        f0.p(e10, "call");
    }

    public void r(e e10) {
        f0.p(e10, "call");
    }

    public void s(e e10, IOException iOException) {
        f0.p(e10, "call");
        f0.p(iOException, "ioe");
    }

    public void t(e e10, a0 a02) {
        f0.p(e10, "call");
        f0.p(a02, "request");
    }

    public void u(e e10) {
        f0.p(e10, "call");
    }

    public void v(e e10, long l10) {
        f0.p(e10, "call");
    }

    public void w(e e10) {
        f0.p(e10, "call");
    }

    public void x(e e10, IOException iOException) {
        f0.p(e10, "call");
        f0.p(iOException, "ioe");
    }

    public void y(e e10, c0 c02) {
        f0.p(e10, "call");
        f0.p(c02, "response");
    }

    public void z(e e10) {
        f0.p(e10, "call");
    }
}

