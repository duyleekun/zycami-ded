/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.a0;
import g.c0$a;
import g.d;
import g.d$b;
import g.d0;
import g.d0$b;
import g.h0.i.c;
import g.h0.j.e;
import g.s;
import g.v;
import h.m;
import h.m0;
import java.io.Closeable;
import java.util.List;
import kotlin.collections.CollectionsKt__CollectionsKt;
import okhttp3.Handshake;
import okhttp3.Protocol;

public final class c0
implements Closeable {
    private d a;
    private final a0 b;
    private final Protocol c;
    private final String d;
    private final int e;
    private final Handshake f;
    private final s g;
    private final d0 h;
    private final c0 i;
    private final c0 j;
    private final c0 k;
    private final long l;
    private final long m;
    private final c n;

    public c0(a0 a02, Protocol protocol, String string2, int n10, Handshake handshake2, s s10, d0 d02, c0 c02, c0 c03, c0 c04, long l10, long l11, c c10) {
        f0.p(a02, "request");
        f0.p((Object)protocol, "protocol");
        f0.p(string2, "message");
        f0.p(s10, "headers");
        this.b = a02;
        this.c = protocol;
        this.d = string2;
        this.e = n10;
        this.f = handshake2;
        this.g = s10;
        this.h = d02;
        this.i = c02;
        this.j = c03;
        this.k = c04;
        this.l = l10;
        this.m = l11;
        this.n = c10;
    }

    public static /* synthetic */ String A0(c0 c02, String string2, String string3, int n10, Object object) {
        if ((n10 &= 2) != 0) {
            string3 = null;
        }
        return c02.z0(string2, string3);
    }

    public final int B() {
        return this.e;
    }

    public final List B0(String string2) {
        f0.p(string2, "name");
        return this.g.o(string2);
    }

    public final Handshake C() {
        return this.f;
    }

    public final s C0() {
        return this.g;
    }

    public final s D() {
        return this.g;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public final boolean D0() {
        int n10 = this.e;
        int n11 = 307;
        if (n10 == n11) return 1 != 0;
        n11 = 308;
        if (n10 == n11) return 1 != 0;
        switch (n10 ? 1 : 0) {
            default: {
                return 0 != 0;
            }
            case 300: 
            case 301: 
            case 302: 
            case 303: {
                return 1 != 0;
            }
        }
    }

    public final String E() {
        return this.d;
    }

    public final String E0() {
        return this.d;
    }

    public final c0 F0() {
        return this.i;
    }

    public final c0$a G0() {
        c0$a c0$a = new c0$a(this);
        return c0$a;
    }

    public final d0 H0(long l10) {
        Closeable closeable = this.h;
        f0.m(closeable);
        closeable = ((d0)closeable).source().peek();
        m m10 = new m();
        closeable.request(l10);
        long l11 = closeable.getBuffer().S0();
        l10 = Math.min(l10, l11);
        m10.Y0((m0)closeable, l10);
        d0$b d0$b = d0.Companion;
        v v10 = this.h.contentType();
        l11 = m10.S0();
        return d0$b.f(m10, v10, l11);
    }

    public final c0 I0() {
        return this.k;
    }

    public final Protocol J0() {
        return this.c;
    }

    public final long K0() {
        return this.m;
    }

    public final a0 L0() {
        return this.b;
    }

    public final long M0() {
        return this.l;
    }

    public final s N0() {
        Object object = this.n;
        if (object != null) {
            return ((c)object).u();
        }
        String string2 = "trailers not available".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final c0 O() {
        return this.i;
    }

    public final c0 S() {
        return this.k;
    }

    public final d0 a() {
        return this.h;
    }

    public void close() {
        Object object = this.h;
        if (object != null) {
            ((d0)object).close();
            return;
        }
        String string2 = "response is not eligible for a body and must not be closed".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final d h() {
        return this.s0();
    }

    public final boolean isSuccessful() {
        int n10 = 200;
        int n11 = this.e;
        n11 = n10 <= n11 && (n10 = 299) >= n11 ? 1 : 0;
        return n11 != 0;
    }

    public final Protocol n0() {
        return this.c;
    }

    public final long o0() {
        return this.m;
    }

    public final a0 p0() {
        return this.b;
    }

    public final c0 q() {
        return this.j;
    }

    public final long q0() {
        return this.l;
    }

    public final d0 r0() {
        return this.h;
    }

    public final d s0() {
        Object object = this.a;
        if (object == null) {
            object = g.d.p;
            s s10 = this.g;
            this.a = object = ((d$b)object).c(s10);
        }
        return object;
    }

    public final c0 t0() {
        return this.j;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Response{protocol=");
        Object object = this.c;
        stringBuilder.append(object);
        stringBuilder.append(", code=");
        int n10 = this.e;
        stringBuilder.append(n10);
        stringBuilder.append(", message=");
        object = this.d;
        stringBuilder.append((String)object);
        stringBuilder.append(", url=");
        object = this.b.q();
        stringBuilder.append(object);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }

    public final List u0() {
        String string2;
        s s10 = this.g;
        int n10 = this.e;
        int n11 = 401;
        if (n10 != n11) {
            n11 = 407;
            if (n10 != n11) {
                return CollectionsKt__CollectionsKt.E();
            }
            string2 = "Proxy-Authenticate";
        } else {
            string2 = "WWW-Authenticate";
        }
        return g.h0.j.e.b(s10, string2);
    }

    public final int v0() {
        return this.e;
    }

    public final c w0() {
        return this.n;
    }

    public final Handshake x0() {
        return this.f;
    }

    public final String y0(String string2) {
        return c0.A0(this, string2, null, 2, null);
    }

    public final String z0(String string2, String string3) {
        f0.p(string2, "name");
        s s10 = this.g;
        string2 = s10.e(string2);
        if (string2 != null) {
            string3 = string2;
        }
        return string3;
    }
}

