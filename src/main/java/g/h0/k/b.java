/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import f.q2.u;
import g.a0;
import g.b0;
import g.c0;
import g.c0$a;
import g.h0.d;
import g.h0.j.e;
import g.h0.j.i;
import g.h0.j.k;
import g.h0.j.k$a;
import g.h0.k.a;
import g.h0.k.b$b;
import g.h0.k.b$c;
import g.h0.k.b$d;
import g.h0.k.b$e;
import g.h0.k.b$f;
import g.h0.k.b$g;
import g.s;
import g.t;
import g.z;
import h.k0;
import h.m0;
import h.n;
import h.o;
import h.o0;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.util.concurrent.TimeUnit;
import okhttp3.Protocol;
import okhttp3.internal.connection.RealConnection;

public final class b
implements g.h0.j.d {
    private static final long j = 255L;
    private static final int k = 0;
    private static final int l = 1;
    private static final int m = 2;
    private static final int n = 3;
    private static final int o = 4;
    private static final int p = 5;
    private static final int q = 6;
    public static final b$d r;
    private int c;
    private final a d;
    private s e;
    private final z f;
    private final RealConnection g;
    private final o h;
    private final n i;

    static {
        b$d b$d;
        r = b$d = new b$d(null);
    }

    public b(z object, RealConnection realConnection, o o10, n n10) {
        f0.p(realConnection, "connection");
        f0.p(o10, "source");
        f0.p(n10, "sink");
        this.f = object;
        this.g = realConnection;
        this.h = o10;
        this.i = n10;
        this.d = object = new a(o10);
    }

    private final m0 A() {
        Object object;
        int n10 = this.c;
        int n11 = 4;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            this.c = 5;
            this.c().G();
            object = new b$g(this);
            return object;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("state: ");
        n11 = this.c;
        ((StringBuilder)object).append(n11);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)object);
        throw illegalStateException;
    }

    public static final /* synthetic */ void j(b b10, h.s s10) {
        b10.s(s10);
    }

    public static final /* synthetic */ z k(b b10) {
        return b10.f;
    }

    public static final /* synthetic */ a l(b b10) {
        return b10.d;
    }

    public static final /* synthetic */ n m(b b10) {
        return b10.i;
    }

    public static final /* synthetic */ o n(b b10) {
        return b10.h;
    }

    public static final /* synthetic */ int o(b b10) {
        return b10.c;
    }

    public static final /* synthetic */ s p(b b10) {
        return b10.e;
    }

    public static final /* synthetic */ void q(b b10, int n10) {
        b10.c = n10;
    }

    public static final /* synthetic */ void r(b b10, s s10) {
        b10.e = s10;
    }

    private final void s(h.s s10) {
        o0 o02 = s10.l();
        o0 o03 = o0.d;
        s10.m(o03);
        o02.a();
        o02.b();
    }

    private final boolean t(a0 object) {
        object = ((a0)object).i("Transfer-Encoding");
        return u.I1("chunked", (String)object, true);
    }

    private final boolean u(c0 object) {
        object = c0.A0((c0)object, "Transfer-Encoding", null, 2, null);
        return u.I1("chunked", (String)object, true);
    }

    private final k0 w() {
        IllegalStateException illegalStateException;
        int n10 = this.c;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
            illegalStateException = null;
        }
        if (n11 != 0) {
            this.c = 2;
            b$b b$b = new b$b(this);
            return b$b;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("state: ");
        n11 = this.c;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private final m0 x(t object) {
        Object object2;
        int n10 = this.c;
        int n11 = 4;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object2 = null;
        }
        if (n10 != 0) {
            this.c = 5;
            object2 = new b$c(this, (t)object);
            return object2;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("state: ");
        n10 = this.c;
        ((StringBuilder)object).append(n10);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    private final m0 y(long l10) {
        b$e b$e;
        int n10 = this.c;
        int n11 = 4;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            b$e = null;
        }
        if (n10 != 0) {
            this.c = 5;
            b$e = new b$e(this, l10);
            return b$e;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("state: ");
        int n12 = this.c;
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    private final k0 z() {
        IllegalStateException illegalStateException;
        int n10 = this.c;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
            illegalStateException = null;
        }
        if (n11 != 0) {
            this.c = 2;
            b$f b$f = new b$f(this);
            return b$f;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("state: ");
        n11 = this.c;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public final void B(c0 closeable) {
        String string2 = "response";
        f0.p(closeable, string2);
        long l10 = g.h0.d.x((c0)closeable);
        long l11 = -1;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 == false) {
            return;
        }
        closeable = this.y(l10);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        g.h0.d.T((m0)closeable, -1 >>> 1, timeUnit);
        closeable.close();
    }

    public final void C(s object, String object2) {
        f0.p(object, "headers");
        String string2 = "requestLine";
        f0.p(object2, string2);
        int n10 = this.c;
        int n11 = 0;
        int n12 = 1;
        if (n10 == 0) {
            n10 = n12;
        } else {
            n10 = 0;
            string2 = null;
        }
        if (n10 != 0) {
            object2 = this.i.r((String)object2);
            string2 = "\r\n";
            object2.r(string2);
            int n13 = ((s)object).size();
            while (n11 < n13) {
                n n14 = this.i;
                String string3 = ((s)object).h(n11);
                n14 = n14.r(string3).r(": ");
                string3 = ((s)object).n(n11);
                n14 = n14.r(string3);
                n14.r(string2);
                ++n11;
            }
            this.i.r(string2);
            this.c = n12;
            return;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("state: ");
        int n15 = this.c;
        ((StringBuilder)object).append(n15);
        object = ((StringBuilder)object).toString();
        object = object.toString();
        object2 = new IllegalStateException((String)object);
        throw object2;
    }

    public void a() {
        this.i.flush();
    }

    public m0 b(c0 object) {
        String string2 = "response";
        f0.p(object, string2);
        boolean bl2 = g.h0.j.e.c((c0)object);
        if (!bl2) {
            long l10 = 0L;
            object = this.y(l10);
        } else {
            bl2 = this.u((c0)object);
            if (bl2) {
                object = ((c0)object).L0().q();
                object = this.x((t)object);
            } else {
                long l11;
                long l12 = g.h0.d.x((c0)object);
                long l13 = l12 - (l11 = (long)-1);
                Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
                object = object2 != false ? this.y(l12) : this.A();
            }
        }
        return object;
    }

    public RealConnection c() {
        return this.g;
    }

    public void cancel() {
        this.c().k();
    }

    public long d(c0 c02) {
        String string2 = "response";
        f0.p(c02, string2);
        boolean bl2 = g.h0.j.e.c(c02);
        long l10 = !bl2 ? 0L : ((bl2 = this.u(c02)) ? (long)-1 : g.h0.d.x(c02));
        return l10;
    }

    public k0 e(a0 object, long l10) {
        block6: {
            block5: {
                Object object2;
                block4: {
                    boolean bl2;
                    f0.p(object, "request");
                    b0 b02 = ((a0)object).f();
                    if (b02 != null && (bl2 = (b02 = ((a0)object).f()).isDuplex())) {
                        object = new ProtocolException("Duplex connections are not supported for HTTP/1");
                        throw object;
                    }
                    object2 = this.t((a0)object);
                    if (!object2) break block4;
                    object = this.w();
                    break block5;
                }
                long l11 = -1;
                long l12 = l10 - l11;
                object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (!object2) break block6;
                object = this.z();
            }
            return object;
        }
        object = new IllegalStateException("Cannot stream a request body without chunked encoding or a known content length!");
        throw object;
    }

    public void f(a0 object) {
        f0.p(object, "request");
        Object object2 = g.h0.j.i.a;
        Proxy.Type type = this.c().b().e().type();
        f0.o((Object)type, "connection.route().proxy.type()");
        object2 = ((i)object2).a((a0)object, type);
        object = ((a0)object).k();
        this.C((s)object, (String)object2);
    }

    public c0$a g(boolean n10) {
        int n11;
        block22: {
            Object object;
            block21: {
                int n12;
                Object object2;
                int n13;
                block20: {
                    n11 = this.c;
                    n13 = 3;
                    int n14 = 1;
                    if (n11 != n14 && n11 != n13) {
                        n14 = 0;
                        object = null;
                    }
                    if (n14 == 0) break block22;
                    try {
                        object2 = g.h0.j.k.h;
                    }
                    catch (EOFException eOFException) {
                        object2 = this.c().b().d().w().V();
                        object = new StringBuilder();
                        ((StringBuilder)object).append("unexpected end of stream on ");
                        ((StringBuilder)object).append((String)object2);
                        object2 = ((StringBuilder)object).toString();
                        IOException iOException = new IOException((String)object2, eOFException);
                        throw iOException;
                    }
                    object = this.d;
                    object = ((a)object).c();
                    object2 = ((k$a)object2).b((String)object);
                    object = new c0$a();
                    Object object3 = ((k)object2).a;
                    object = ((c0$a)object).B((Protocol)((Object)object3));
                    n12 = ((k)object2).b;
                    object = ((c0$a)object).g(n12);
                    object3 = ((k)object2).c;
                    object = ((c0$a)object).y((String)object3);
                    object3 = this.d;
                    object3 = ((a)object3).b();
                    object = ((c0$a)object).w((s)object3);
                    n12 = 100;
                    if (n10 == 0) break block20;
                    n10 = ((k)object2).b;
                    if (n10 != n12) break block20;
                    n14 = 0;
                    object = null;
                }
                n10 = ((k)object2).b;
                if (n10 != n12) break block21;
                this.c = n13;
            }
            n10 = 4;
            this.c = n10;
            return object;
        }
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("state: ");
        n11 = this.c;
        ((StringBuilder)charSequence).append(n11);
        charSequence = ((StringBuilder)charSequence).toString();
        charSequence = ((Object)charSequence).toString();
        IllegalStateException illegalStateException = new IllegalStateException((String)charSequence);
        throw illegalStateException;
    }

    public void h() {
        this.i.flush();
    }

    public s i() {
        Object object;
        int n10 = this.c;
        int n11 = 6;
        if (n10 == n11) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        if (n10 != 0) {
            object = this.e;
            if (object == null) {
                object = g.h0.d.b;
            }
            return object;
        }
        String string2 = "too early; can't read the trailers yet".toString();
        object = new IllegalStateException(string2);
        throw object;
    }

    public final boolean v() {
        int n10 = this.c;
        int n11 = 6;
        n10 = n10 == n11 ? 1 : 0;
        return n10 != 0;
    }
}

