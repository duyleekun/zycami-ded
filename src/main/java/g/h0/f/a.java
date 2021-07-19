/*
 * Decompiled with CFR 0.151.
 */
package g.h0.f;

import f.h2.t.f0;
import g.a0;
import g.c0;
import g.c0$a;
import g.d0;
import g.e;
import g.h0.d;
import g.h0.f.a$a;
import g.h0.f.a$b;
import g.h0.f.b;
import g.h0.f.c;
import g.h0.f.c$a;
import g.h0.f.c$b;
import g.h0.j.f;
import g.h0.j.h;
import g.q;
import g.s;
import g.u;
import g.u$a;
import h.k0;
import h.m0;
import h.n;
import h.o;
import h.z;
import java.io.Closeable;
import java.io.IOException;
import okhttp3.Protocol;

public final class a
implements u {
    public static final a$a c;
    private final g.c b;

    static {
        a$a a$a;
        c = a$a = new a$a(null);
    }

    public a(g.c c10) {
        this.b = c10;
    }

    private final c0 a(b object, c0 object2) {
        if (object == null) {
            return object2;
        }
        k0 k02 = object.b();
        Closeable closeable = ((c0)object2).r0();
        f0.m(closeable);
        closeable = closeable.source();
        k02 = z.c(k02);
        m0 m02 = new a$b((o)closeable, (b)object, (n)k02);
        object = c0.A0((c0)object2, "Content-Type", null, 2, null);
        long l10 = ((c0)object2).r0().contentLength();
        object2 = ((c0)object2).G0();
        m02 = z.d(m02);
        h h10 = new h((String)object, l10, (o)m02);
        return ((c0$a)object2).b(h10).c();
    }

    public final g.c b() {
        return this.b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public c0 intercept(u$a object) {
        int n10;
        Object object2;
        Object object3;
        Object object4;
        int n11;
        Object object5;
        Object object6;
        Object object7;
        Object object8;
        block19: {
            f0.p(object, "chain");
            object8 = object.call();
            object7 = this.b;
            object6 = null;
            if (object7 != null) {
                object5 = object.C();
                object7 = ((g.c)object7).D((a0)object5);
            } else {
                n11 = 0;
                object7 = null;
            }
            long l10 = System.currentTimeMillis();
            object4 = object.C();
            object3 = new c$b(l10, (a0)object4, (c0)object7);
            object5 = ((c$b)object3).b();
            object2 = ((c)object5).b();
            object3 = ((c)object5).a();
            object4 = this.b;
            if (object4 != null) {
                ((g.c)object4).z0((c)object5);
            }
            if ((n10 = object8 instanceof g.h0.i.e) != 0) {
                object6 = object8;
            }
            object6 = (g.h0.i.e)object6;
            if (object6 == null || (object6 = ((g.h0.i.e)object6).n()) == null) {
                object6 = q.a;
            }
            if (object7 != null && object3 == null && (object5 = ((c0)object7).r0()) != null) {
                d.l((Closeable)object5);
            }
            if (object2 == null && object3 == null) {
                object7 = new c0$a();
                object = object.C();
                object = ((c0$a)object7).E((a0)object);
                object7 = Protocol.HTTP_1_1;
                object = ((c0$a)object).B((Protocol)((Object)object7)).g(504).y("Unsatisfiable Request (only-if-cached)");
                object7 = d.c;
                object = ((c0$a)object).b((d0)object7).F(-1);
                l10 = System.currentTimeMillis();
                object = ((c0$a)object).C(l10).c();
                ((q)object6).A((e)object8, (c0)object);
                return object;
            }
            if (object2 == null) {
                f0.m(object3);
                object = ((c0)object3).G0();
                object7 = a$a.b(c, (c0)object3);
                object = ((c0$a)object).d((c0)object7).c();
                ((q)object6).b((e)object8, (c0)object);
                return object;
            }
            if (object3 != null) {
                ((q)object6).a((e)object8, (c0)object3);
            } else {
                object5 = this.b;
                if (object5 != null) {
                    ((q)object6).c((e)object8);
                }
            }
            try {
                object = object.c((a0)object2);
                if (object != null || object7 == null || (object7 = ((c0)object7).r0()) == null) break block19;
            }
            catch (Throwable throwable) {
                if (object7 == null) throw throwable;
                object8 = ((c0)object7).r0();
                if (object8 == null) throw throwable;
                d.l((Closeable)object8);
                throw throwable;
            }
            d.l((Closeable)object7);
        }
        if (object3 != null) {
            if (object != null && (n11 = ((c0)object).v0()) == (n10 = 304)) {
                object7 = ((c0)object3).G0();
                object5 = c;
                object2 = ((c0)object3).C0();
                object4 = ((c0)object).C0();
                object2 = a$a.a((a$a)object5, (s)object2, (s)object4);
                object7 = ((c0$a)object7).w((s)object2);
                long l11 = ((c0)object).M0();
                object7 = ((c0$a)object7).F(l11);
                l11 = ((c0)object).K0();
                object7 = ((c0$a)object7).C(l11);
                object2 = a$a.b((a$a)object5, (c0)object3);
                object7 = ((c0$a)object7).d((c0)object2);
                object5 = a$a.b((a$a)object5, (c0)object);
                object7 = ((c0$a)object7).z((c0)object5).c();
                object = ((c0)object).r0();
                f0.m(object);
                ((d0)object).close();
                object = this.b;
                f0.m(object);
                ((g.c)object).y0();
                this.b.A0((c0)object3, (c0)object7);
                ((q)object6).b((e)object8, (c0)object7);
                return object7;
            }
            object7 = ((c0)object3).r0();
            if (object7 != null) {
                d.l((Closeable)object7);
            }
        }
        f0.m(object);
        object7 = ((c0)object).G0();
        object5 = c;
        object4 = a$a.b((a$a)object5, (c0)object3);
        object7 = ((c0$a)object7).d((c0)object4);
        object = a$a.b((a$a)object5, (c0)object);
        object = ((c0$a)object7).z((c0)object).c();
        object7 = this.b;
        if (object7 == null) return object;
        n11 = (int)(g.h0.j.e.c((c0)object) ? 1 : 0);
        if (n11 != 0 && (n11 = (int)(((c$a)(object7 = g.h0.f.c.c)).a((c0)object, (a0)object2) ? 1 : 0)) != 0) {
            object7 = this.b.s0((c0)object);
            object = this.a((b)object7, (c0)object);
            if (object3 == null) return object;
            ((q)object6).c((e)object8);
            return object;
        }
        object8 = f.a;
        object7 = ((a0)object2).m();
        boolean bl2 = ((f)object8).a((String)object7);
        if (!bl2) return object;
        try {}
        catch (IOException iOException) {
            return object;
        }
        object8 = this.b;
        ((g.c)object8).t0((a0)object2);
        return object;
    }
}

