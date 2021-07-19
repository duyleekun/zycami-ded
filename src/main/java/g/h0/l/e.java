/*
 * Decompiled with CFR 0.151.
 */
package g.h0.l;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.c0$a;
import g.h0.l.d;
import g.h0.l.e$a;
import g.h0.l.g;
import g.s;
import g.z;
import h.k0;
import h.m0;
import h.o0;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.http2.ErrorCode;

public final class e
implements g.h0.j.d {
    private static final String i = "connection";
    private static final String j = "host";
    private static final String k = "keep-alive";
    private static final String l = "proxy-connection";
    private static final String m = "transfer-encoding";
    private static final String n = "te";
    private static final String o = "encoding";
    private static final String p = "upgrade";
    private static final List q;
    private static final List r;
    public static final e$a s;
    private volatile g c;
    private final Protocol d;
    private volatile boolean e;
    private final RealConnection f;
    private final g.h0.j.g g;
    private final d h;

    static {
        e$a e$a;
        s = e$a = new e$a(null);
        q = g.h0.d.z(i, j, k, l, n, m, o, p, ":method", ":path", ":scheme", ":authority");
        r = g.h0.d.z(i, j, k, l, n, m, o, p);
    }

    public e(z object, RealConnection object2, g.h0.j.g g10, d d10) {
        f0.p(object, "client");
        f0.p(object2, i);
        f0.p(g10, "chain");
        String string2 = "http2Connection";
        f0.p(d10, string2);
        this.f = object2;
        this.g = g10;
        this.h = d10;
        object = ((z)object).e0();
        object2 = Protocol.H2_PRIOR_KNOWLEDGE;
        boolean bl2 = object.contains(object2);
        if (!bl2) {
            object2 = Protocol.HTTP_2;
        }
        this.d = object2;
    }

    public static final /* synthetic */ List j() {
        return q;
    }

    public static final /* synthetic */ List k() {
        return r;
    }

    public void a() {
        g g10 = this.c;
        f0.m(g10);
        g10.o().close();
    }

    public m0 b(c0 object) {
        f0.p(object, "response");
        object = this.c;
        f0.m(object);
        return ((g)object).r();
    }

    public RealConnection c() {
        return this.f;
    }

    public void cancel() {
        boolean bl2;
        this.e = bl2 = true;
        g g10 = this.c;
        if (g10 != null) {
            ErrorCode errorCode = ErrorCode.CANCEL;
            g10.f(errorCode);
        }
    }

    public long d(c0 c02) {
        String string2 = "response";
        f0.p(c02, string2);
        boolean bl2 = g.h0.j.e.c(c02);
        long l10 = !bl2 ? 0L : g.h0.d.x(c02);
        return l10;
    }

    public k0 e(a0 object, long l10) {
        f0.p(object, "request");
        object = this.c;
        f0.m(object);
        return ((g)object).o();
    }

    public void f(a0 object) {
        boolean bl2;
        f0.p(object, "request");
        Object object2 = this.c;
        if (object2 != null) {
            return;
        }
        object2 = ((a0)object).f();
        if (object2 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        object = s.a((a0)object);
        d d10 = this.h;
        this.c = object = d10.S0((List)object, bl2);
        boolean bl3 = this.e;
        if (!bl3) {
            object = this.c;
            f0.m(object);
            object = ((g)object).x();
            long l10 = this.g.n();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            ((o0)object).i(l10, timeUnit);
            object = this.c;
            f0.m(object);
            object = ((g)object).L();
            l10 = this.g.p();
            ((o0)object).i(l10, timeUnit);
            return;
        }
        object = this.c;
        f0.m(object);
        object2 = ErrorCode.CANCEL;
        ((g)object).f((ErrorCode)((Object)object2));
        object = new IOException("Canceled");
        throw object;
    }

    public c0$a g(boolean n10) {
        int n11;
        Object object = this.c;
        f0.m(object);
        object = ((g)object).H();
        e$a e$a = s;
        Protocol protocol = this.d;
        object = e$a.b((s)object, protocol);
        if (n10 != 0 && (n10 = ((c0$a)object).j()) == (n11 = 100)) {
            object = null;
        }
        return object;
    }

    public void h() {
        this.h.flush();
    }

    public s i() {
        g g10 = this.c;
        f0.m(g10);
        return g10.I();
    }
}

