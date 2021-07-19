/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.time.f;
import j$.time.p.c;
import j$.time.p.d;
import j$.time.p.e;
import j$.time.p.j;
import j$.time.q.b_0;
import j$.time.q.g;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;

public interface b
extends r,
t,
Comparable {
    default public int E() {
        int n10 = this.G();
        n10 = n10 != 0 ? 366 : 365;
        return n10;
    }

    default public d F(f f10) {
        return e.n(this, f10);
    }

    default public boolean G() {
        j j10 = this.f();
        h h10 = h.E;
        long l10 = this.h(h10);
        return j10.y(l10);
    }

    default public int K(b comparable) {
        long l10;
        long l11 = this.s();
        int n10 = Long.compare(l11, l10 = comparable.s());
        if (n10 == 0) {
            j j10 = this.f();
            comparable = comparable.f();
            n10 = j10.p((j)comparable);
        }
        return n10;
    }

    default public b a(long l10, x x10) {
        boolean bl2 = x10 instanceof i;
        if (!bl2) {
            j j10 = this.f();
            r r10 = x10.n(this, l10);
            return c.m(j10, r10);
        }
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Unsupported unit: ");
        charSequence.append(x10);
        charSequence = charSequence.toString();
        y y10 = new y((String)charSequence);
        throw y10;
    }

    default public b b(t object) {
        j j10 = this.f();
        object = object.e(this);
        return c.m(j10, (r)object);
    }

    default public b c(u object, long l10) {
        boolean bl2 = object instanceof h;
        if (!bl2) {
            j j10 = this.f();
            object = object.n(this, l10);
            return c.m(j10, (r)object);
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unsupported field: ");
        stringBuilder.append(object);
        object = stringBuilder.toString();
        y y10 = new y((String)object);
        throw y10;
    }

    default public Object d(w w10) {
        w w11 = j$.time.q.d.a;
        if (w10 != w11 && w10 != (w11 = g.a) && w10 != (w11 = j$.time.q.c.a)) {
            w11 = j$.time.q.f.a;
            if (w10 == w11) {
                return null;
            }
            w11 = b_0.a;
            if (w10 == w11) {
                return this.f();
            }
            w11 = j$.time.q.e.a;
            if (w10 == w11) {
                return i.i;
            }
            return w10.a(this);
        }
        return null;
    }

    default public r e(r r10) {
        h h10 = h.y;
        long l10 = this.s();
        return r10.c(h10, l10);
    }

    public j f();

    default public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        if (bl3) {
            return u10.m();
        }
        if (u10 != null && (bl2 = u10.L(this))) {
            bl2 = true;
        } else {
            bl2 = false;
            u10 = null;
        }
        return bl2;
    }

    public int hashCode();

    default public long s() {
        h h10 = h.y;
        return this.h(h10);
    }

    public String toString();

    default public b w(long l10, x x10) {
        r r10;
        j j10 = this.f();
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = Long.MAX_VALUE;
            r10 = this.a(l10, x10);
            l11 = 1L;
            r10 = r10.a(l11, x10);
        } else {
            l10 = -l10;
            r10 = this.a(l10, x10);
        }
        return c.m(j10, r10);
    }
}

