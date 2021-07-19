/*
 * Decompiled with CFR 0.151.
 */
package g.h0;

import f.h2.t.f0;
import g.a0;
import g.c;
import g.c0;
import g.k;
import g.l;
import g.s$a;
import g.t;
import javax.net.ssl.SSLSocket;

public final class b {
    public static final s$a a(s$a s$a, String string2) {
        f0.p(s$a, "builder");
        f0.p(string2, "line");
        return s$a.f(string2);
    }

    public static final s$a b(s$a s$a, String string2, String string3) {
        f0.p(s$a, "builder");
        f0.p(string2, "name");
        f0.p(string3, "value");
        return s$a.g(string2, string3);
    }

    public static final void c(k k10, SSLSocket sSLSocket, boolean bl2) {
        f0.p(k10, "connectionSpec");
        f0.p(sSLSocket, "sslSocket");
        k10.f(sSLSocket, bl2);
    }

    public static final c0 d(c c10, a0 a02) {
        f0.p(c10, "cache");
        f0.p(a02, "request");
        return c10.D(a02);
    }

    public static final String e(l l10, boolean bl2) {
        f0.p(l10, "cookie");
        return l10.y(bl2);
    }

    public static final l f(long l10, t t10, String string2) {
        f0.p(t10, "url");
        f0.p(string2, "setCookie");
        return l.n.f(l10, t10, string2);
    }
}

