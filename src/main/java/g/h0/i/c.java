/*
 * Decompiled with CFR 0.151.
 */
package g.h0.i;

import f.h2.t.f0;
import g.a0;
import g.b0;
import g.c0;
import g.c0$a;
import g.d0;
import g.h0.i.c$a;
import g.h0.i.c$b;
import g.h0.i.d;
import g.h0.i.e;
import g.h0.j.h;
import g.h0.q.e$d;
import g.q;
import g.s;
import h.k0;
import h.m0;
import h.o;
import h.z;
import java.io.IOException;
import okhttp3.internal.connection.RealConnection;

public final class c {
    private boolean a;
    private final RealConnection b;
    private final e c;
    private final q d;
    private final d e;
    private final g.h0.j.d f;

    public c(e object, q q10, d d10, g.h0.j.d d11) {
        f0.p(object, "call");
        f0.p(q10, "eventListener");
        f0.p(d10, "finder");
        f0.p(d11, "codec");
        this.c = object;
        this.d = q10;
        this.e = d10;
        this.f = d11;
        this.b = object = d11.c();
    }

    private final void t(IOException iOException) {
        this.e.h(iOException);
        RealConnection realConnection = this.f.c();
        e e10 = this.c;
        realConnection.N(e10, iOException);
    }

    public final IOException a(long l10, boolean bl2, boolean bl3, IOException iOException) {
        e e10;
        q q10;
        if (iOException != null) {
            this.t(iOException);
        }
        if (bl3) {
            if (iOException != null) {
                q10 = this.d;
                e10 = this.c;
                q10.s(e10, iOException);
            } else {
                q10 = this.d;
                e10 = this.c;
                q10.q(e10, l10);
            }
        }
        if (bl2) {
            if (iOException != null) {
                q q11 = this.d;
                e e11 = this.c;
                q11.x(e11, iOException);
            } else {
                q10 = this.d;
                e10 = this.c;
                q10.v(e10, l10);
            }
        }
        return this.c.t(this, bl3, bl2, iOException);
    }

    public final void b() {
        this.f.cancel();
    }

    public final k0 c(a0 object, boolean bl2) {
        f0.p(object, "request");
        this.a = bl2;
        Object object2 = ((a0)object).f();
        f0.m(object2);
        long l10 = ((b0)object2).contentLength();
        object2 = this.d;
        e e10 = this.c;
        ((q)object2).r(e10);
        object = this.f.e((a0)object, l10);
        object2 = new c$a(this, (k0)object, l10);
        return object2;
    }

    public final void d() {
        this.f.cancel();
        e e10 = this.c;
        boolean bl2 = true;
        e10.t(this, bl2, bl2, null);
    }

    public final void e() {
        g.h0.j.d d10;
        try {
            d10 = this.f;
        }
        catch (IOException iOException) {
            q q10 = this.d;
            e e10 = this.c;
            q10.s(e10, iOException);
            this.t(iOException);
            throw iOException;
        }
        d10.a();
    }

    public final void f() {
        g.h0.j.d d10;
        try {
            d10 = this.f;
        }
        catch (IOException iOException) {
            q q10 = this.d;
            e e10 = this.c;
            q10.s(e10, iOException);
            this.t(iOException);
            throw iOException;
        }
        d10.h();
    }

    public final e g() {
        return this.c;
    }

    public final RealConnection h() {
        return this.b;
    }

    public final q i() {
        return this.d;
    }

    public final d j() {
        return this.e;
    }

    public final boolean k() {
        String string2 = this.e.d().w().F();
        String string3 = this.b.b().d().w().F();
        return f0.g(string2, string3) ^ true;
    }

    public final boolean l() {
        return this.a;
    }

    public final e.d m() {
        this.c.A();
        return this.f.c().E(this);
    }

    public final void n() {
        this.f.c().G();
    }

    public final void o() {
        this.c.t(this, true, false, null);
    }

    public final d0 p(c0 closeable) {
        Object object;
        f0.p(closeable, "response");
        Object object2 = "Content-Type";
        int n10 = 2;
        try {
            object2 = c0.A0(closeable, (String)object2, null, n10, null);
        }
        catch (IOException iOException) {
            object2 = this.d;
            object = this.c;
            ((q)object2).x((g.e)object, iOException);
            this.t(iOException);
            throw iOException;
        }
        object = this.f;
        long l10 = object.d((c0)closeable);
        Object object3 = this.f;
        closeable = object3.b((c0)closeable);
        object3 = new c$b(this, (m0)closeable, l10);
        object3 = z.d((m0)object3);
        closeable = new h((String)object2, l10, (o)object3);
        return closeable;
    }

    public final c0$a q(boolean bl2) {
        c0$a c0$a;
        block4: {
            Object object;
            try {
                object = this.f;
            }
            catch (IOException iOException) {
                object = this.d;
                e e10 = this.c;
                ((q)object).x(e10, iOException);
                this.t(iOException);
                throw iOException;
            }
            c0$a = object.g(bl2);
            if (c0$a == null) break block4;
            c0$a.x(this);
        }
        return c0$a;
    }

    public final void r(c0 c02) {
        f0.p(c02, "response");
        q q10 = this.d;
        e e10 = this.c;
        q10.y(e10, c02);
    }

    public final void s() {
        q q10 = this.d;
        e e10 = this.c;
        q10.z(e10);
    }

    public final s u() {
        return this.f.i();
    }

    public final void v() {
        this.a(-1, true, true, null);
    }

    public final void w(a0 a02) {
        e e10;
        Object object = "request";
        f0.p(a02, (String)object);
        try {
            object = this.d;
        }
        catch (IOException iOException) {
            object = this.d;
            e10 = this.c;
            ((q)object).s(e10, iOException);
            this.t(iOException);
            throw iOException;
        }
        e10 = this.c;
        ((q)object).u(e10);
        object = this.f;
        object.f(a02);
        object = this.d;
        e10 = this.c;
        ((q)object).t(e10, a02);
    }
}

