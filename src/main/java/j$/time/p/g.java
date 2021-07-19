/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.time.f;
import j$.time.k;
import j$.time.l;
import j$.time.p.b;
import j$.time.p.d;
import j$.time.p.i;
import j$.time.p.j;
import j$.time.q.b_0;
import j$.time.q.c;
import j$.time.q.e;
import j$.time.q.h;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;
import j$.time.q.z;

public interface g
extends r,
Comparable {
    default public long H() {
        long l10 = this.l().s() * 86400L;
        long l11 = this.j().U();
        l10 += l11;
        l11 = this.z().C();
        return l10 - l11;
    }

    public k J();

    public g a(long var1, x var3);

    default public g b(t object) {
        j j10 = this.f();
        object = object.e(this);
        return i.m(j10, (r)object);
    }

    public g c(u var1, long var2);

    default public Object d(w w10) {
        w w11 = j$.time.q.g.a;
        if (w10 != w11 && w10 != (w11 = j$.time.q.d.a)) {
            w11 = c.a;
            if (w10 == w11) {
                return this.z();
            }
            w11 = j$.time.q.f.a;
            if (w10 == w11) {
                return this.j();
            }
            w11 = b_0.a;
            if (w10 == w11) {
                return this.f();
            }
            w11 = e.a;
            if (w10 == w11) {
                return j$.time.q.i.b;
            }
            return w10.a(this);
        }
        return this.J();
    }

    default public j f() {
        return this.l().f();
    }

    default public long h(u u10) {
        int n10 = u10 instanceof h;
        if (n10 != 0) {
            int[] nArray = j$.time.p.f.a;
            u u11 = u10;
            u11 = (h)u10;
            int n11 = ((Enum)((Object)u11)).ordinal();
            n10 = nArray[n11];
            if (n10 != (n11 = 1)) {
                n11 = 2;
                if (n10 != n11) {
                    return this.v().h(u10);
                }
                return this.z().C();
            }
            return this.H();
        }
        return u10.o(this);
    }

    default public z i(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            h h10 = h.G;
            if (u10 != h10 && u10 != (h10 = h.H)) {
                return this.v().i(u10);
            }
            return u10.x();
        }
        return u10.D(this);
    }

    default public f j() {
        return this.v().j();
    }

    default public int k(u object) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            int[] nArray = j$.time.p.f.a;
            u u10 = object;
            u10 = (h)object;
            int n11 = ((Enum)((Object)u10)).ordinal();
            n10 = nArray[n11];
            if (n10 != (n11 = 1)) {
                n11 = 2;
                if (n10 != n11) {
                    return this.v().k((u)object);
                }
                return this.z().C();
            }
            object = new y("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            throw object;
        }
        return s.super.k((u)object);
    }

    default public b l() {
        return this.v().l();
    }

    default public int u(g comparable) {
        long l10;
        long l11 = this.H();
        int n10 = Long.compare(l11, l10 = comparable.H());
        if (n10 == 0) {
            Object object = this.j();
            n10 = ((f)object).C();
            Object object2 = comparable.j();
            int n11 = ((f)object2).C();
            if ((n10 -= n11) == 0 && (n10 = (object = this.v()).M((d)(object2 = comparable.v()))) == 0 && (n10 = ((String)(object = this.J().q())).compareTo((String)(object2 = comparable.J().q()))) == 0) {
                object = this.f();
                comparable = comparable.f();
                n10 = object.p((j)comparable);
            }
        }
        return n10;
    }

    public d v();

    public l z();
}

