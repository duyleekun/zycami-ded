/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.Duration;
import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.e;
import j$.time.f;
import j$.time.i;
import j$.time.k;
import j$.time.l;
import j$.time.n;
import j$.time.p.b;
import j$.time.p.d;
import j$.time.p.g;
import j$.time.q.a_0;
import j$.time.q.h;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;
import j$.time.q.z;
import j$.time.r.a;
import j$.time.r.c;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public final class o
implements r,
g,
Serializable {
    private final e a;
    private final l b;
    private final k c;

    private o(e e10, l l10, k k10) {
        this.a = e10;
        this.b = l10;
        this.c = k10;
    }

    private o C(e e10) {
        k k10 = this.c;
        l l10 = this.b;
        return o.o(e10, k10, l10);
    }

    private o D(l l10) {
        Object object = this.b;
        boolean bl2 = l10.equals(object);
        if (!bl2) {
            object = this.c.m();
            e e10 = this.a;
            bl2 = (object = ((c)object).g(e10)).contains(l10);
            if (bl2) {
                e10 = this.a;
                k k10 = this.c;
                object = new o(e10, l10, k10);
                return object;
            }
        }
        return this;
    }

    private static o m(long l10, int n10, k k10) {
        Serializable serializable = k10.m();
        long l11 = n10;
        Instant instant = Instant.L(l10, l11);
        serializable = serializable.d(instant);
        e e10 = e.Q(l10, n10, (l)serializable);
        o o10 = new o(e10, (l)serializable, k10);
        return o10;
    }

    public static o n(Instant instant, k k10) {
        Objects.requireNonNull(instant, "instant");
        Objects.requireNonNull(k10, "zone");
        long l10 = instant.x();
        int n10 = instant.C();
        return o.m(l10, n10, k10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static o o(e e10, k k10, l comparable) {
        int n10;
        Objects.requireNonNull(e10, "localDateTime");
        Object object = "zone";
        Objects.requireNonNull(k10, (String)object);
        boolean bl2 = k10 instanceof l;
        if (bl2) {
            object = k10;
            object = (l)k10;
            return new o(e10, (l)object, k10);
        }
        object = k10.m();
        List list = ((c)object).g(e10);
        int n11 = list.size();
        if (n11 == (n10 = 1)) {
            comparable = list.get(0);
            return new o(e10, (l)comparable, k10);
        } else {
            n11 = list.size();
            if (n11 == 0) {
                comparable = ((c)object).f(e10);
                object = ((a)comparable).o();
                long l10 = ((Duration)object).getSeconds();
                e10 = e10.U(l10);
                comparable = ((a)comparable).C();
                return new o(e10, (l)comparable, k10);
            } else {
                if (comparable != null && (bl2 = list.contains(comparable))) return new o(e10, (l)comparable, k10);
                comparable = (l)list.get(0);
                object = "offset";
                Objects.requireNonNull(comparable, (String)object);
                return new o(e10, (l)comparable, k10);
            }
        }
    }

    public k J() {
        return this.c;
    }

    public e L() {
        return this.a;
    }

    public o O(t t10) {
        boolean bl2 = t10 instanceof LocalDate;
        if (bl2) {
            t10 = (LocalDate)t10;
            Serializable serializable = this.a.j();
            t10 = e.P((LocalDate)t10, serializable);
            serializable = this.c;
            l l10 = this.b;
            return o.o((e)t10, (k)serializable, l10);
        }
        bl2 = t10 instanceof f;
        if (bl2) {
            Serializable serializable = this.a.W();
            t10 = (f)t10;
            t10 = e.P(serializable, (f)t10);
            serializable = this.c;
            l l11 = this.b;
            return o.o((e)t10, (k)serializable, l11);
        }
        bl2 = t10 instanceof e;
        if (bl2) {
            t10 = (e)t10;
            return this.C((e)t10);
        }
        bl2 = t10 instanceof i;
        if (bl2) {
            t10 = (i)t10;
            e e10 = ((i)t10).n();
            k k10 = this.c;
            t10 = ((i)t10).z();
            return o.o(e10, k10, (l)t10);
        }
        bl2 = t10 instanceof Instant;
        if (bl2) {
            t10 = (Instant)t10;
            long l12 = ((Instant)t10).x();
            int n10 = ((Instant)t10).C();
            k k11 = this.c;
            return o.m(l12, n10, k11);
        }
        bl2 = t10 instanceof l;
        if (bl2) {
            t10 = (l)t10;
            return this.D((l)t10);
        }
        return (o)t10.e(this);
    }

    public o P(u object, long l10) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            Object object2 = object;
            object2 = (h)object;
            int[] nArray = n.a;
            int n10 = ((Enum)object2).ordinal();
            int n11 = nArray[n10];
            if (n11 != (n10 = 1)) {
                n10 = 2;
                if (n11 != n10) {
                    object = this.a.Z((u)object, l10);
                    return this.C((e)object);
                }
                object = l.O(((h)object2).O(l10));
                return this.D((l)object);
            }
            int n12 = this.a.o();
            object2 = this.c;
            return o.m(l10, n12, (k)object2);
        }
        return (o)object.n(this, l10);
    }

    public Object d(w w10) {
        a_0 a_02 = a_0.a;
        if (w10 == a_02) {
            return this.a.W();
        }
        return g.super.d(w10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof o;
        if (bl3) {
            boolean bl4;
            object = (o)object;
            Serializable serializable = this.a;
            s s10 = ((o)object).a;
            bl3 = ((e)serializable).equals(s10);
            if (!(bl3 && (bl3 = ((l)(serializable = this.b)).equals(s10 = ((o)object).b)) && (bl4 = ((k)(serializable = this.c)).equals(object = ((o)object).c)))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        if (!(bl3 || u10 != null && (bl2 = u10.L(this)))) {
            bl2 = false;
            u10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public long h(u u10) {
        int n10 = u10 instanceof h;
        if (n10 != 0) {
            int[] nArray = n.a;
            u u11 = u10;
            u11 = (h)u10;
            int n11 = ((Enum)((Object)u11)).ordinal();
            n10 = nArray[n11];
            if (n10 != (n11 = 1)) {
                n11 = 2;
                if (n10 != n11) {
                    return this.a.h(u10);
                }
                return this.b.C();
            }
            return this.H();
        }
        return u10.o(this);
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = this.b.hashCode();
        n10 ^= n11;
        n11 = Integer.rotateLeft(this.c.hashCode(), 3);
        return n10 ^ n11;
    }

    public z i(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            h h10 = h.G;
            if (u10 != h10 && u10 != (h10 = h.H)) {
                return this.a.i(u10);
            }
            return u10.x();
        }
        return u10.D(this);
    }

    public f j() {
        return this.a.j();
    }

    public int k(u object) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            int[] nArray = n.a;
            u u10 = object;
            u10 = (h)object;
            int n11 = ((Enum)((Object)u10)).ordinal();
            n10 = nArray[n11];
            if (n10 != (n11 = 1)) {
                n11 = 2;
                if (n10 != n11) {
                    return this.a.k((u)object);
                }
                return this.b.C();
            }
            object = new y("Invalid field 'InstantSeconds' for get() method, use getLong() instead");
            throw object;
        }
        return g.super.k((u)object);
    }

    public b l() {
        return this.a.W();
    }

    public String toString() {
        CharSequence charSequence = new StringBuilder();
        Object object = this.a.toString();
        charSequence.append((String)object);
        object = this.b.toString();
        charSequence.append((String)object);
        charSequence = charSequence.toString();
        object = this.b;
        k k10 = this.c;
        if (object != k10) {
            object = new StringBuilder();
            ((StringBuilder)object).append((String)charSequence);
            ((StringBuilder)object).append('[');
            charSequence = this.c.toString();
            ((StringBuilder)object).append((String)charSequence);
            char c10 = ']';
            ((StringBuilder)object).append(c10);
            charSequence = ((StringBuilder)object).toString();
        }
        return charSequence;
    }

    public d v() {
        return this.a;
    }

    public o x(long l10, x object) {
        boolean bl2 = object instanceof j$.time.q.i;
        if (bl2) {
            bl2 = object.m();
            if (bl2) {
                e e10 = this.a.R(l10, (x)object);
                return this.C(e10);
            }
            e e11 = this.a.R(l10, (x)object);
            l l11 = this.b;
            object = this.c;
            Objects.requireNonNull(e11, "localDateTime");
            Objects.requireNonNull(l11, "offset");
            Objects.requireNonNull(object, "zone");
            Object object2 = ((k)object).m().g(e11);
            bl2 = object2.contains(l11);
            if (bl2) {
                object2 = new o(e11, l11, (k)object);
            } else {
                long l12 = e11.N(l11);
                int n10 = e11.o();
                object2 = o.m(l12, n10, (k)object);
            }
            return object2;
        }
        return (o)object.n(this, l10);
    }

    public l z() {
        return this.b;
    }
}

