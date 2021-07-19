/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.time.f;
import j$.time.l;
import j$.time.p.b;
import j$.time.p.e;
import j$.time.p.j;
import j$.time.q.b_0;
import j$.time.q.c;
import j$.time.q.g;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import java.util.Objects;

public interface d
extends r,
t,
Comparable {
    default public int M(d comparable) {
        t t10;
        Comparable comparable2 = this.l();
        int n10 = comparable2.K((b)(t10 = comparable.l()));
        if (n10 == 0 && (n10 = ((f)(comparable2 = this.j())).m((f)(t10 = comparable.j()))) == 0) {
            comparable2 = this.f();
            comparable = comparable.f();
            n10 = comparable2.p((j)comparable);
        }
        return n10;
    }

    default public long N(l l10) {
        Objects.requireNonNull(l10, "offset");
        long l11 = this.l().s() * 86400L;
        long l12 = this.j().U();
        l11 += l12;
        l12 = l10.C();
        return l11 - l12;
    }

    public d a(long var1, x var3);

    default public d b(t object) {
        j j10 = this.f();
        object = object.e(this);
        return e.m(j10, (r)object);
    }

    public d c(u var1, long var2);

    default public Object d(w w10) {
        w w11 = j$.time.q.d.a;
        if (w10 != w11 && w10 != (w11 = g.a) && w10 != (w11 = c.a)) {
            w11 = j$.time.q.f.a;
            if (w10 == w11) {
                return this.j();
            }
            w11 = b_0.a;
            if (w10 == w11) {
                return this.f();
            }
            w11 = j$.time.q.e.a;
            if (w10 == w11) {
                return i.b;
            }
            return w10.a(this);
        }
        return null;
    }

    default public r e(r r10) {
        h h10 = h.y;
        long l10 = this.l().s();
        r10 = r10.c(h10, l10);
        h10 = h.f;
        l10 = this.j().T();
        return r10.c(h10, l10);
    }

    default public j f() {
        return this.l().f();
    }

    public f j();

    public b l();
}

