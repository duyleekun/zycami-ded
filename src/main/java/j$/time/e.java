/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.a;
import j$.time.LocalDate;
import j$.time.c;
import j$.time.f;
import j$.time.i;
import j$.time.l;
import j$.time.o;
import j$.time.p.b;
import j$.time.p.d;
import j$.time.q.a_0;
import j$.time.q.h;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.z;
import java.io.Serializable;
import java.util.Objects;

public final class e
implements r,
t,
d,
Serializable {
    public static final e c;
    public static final e d;
    private final LocalDate a;
    private final f b;

    static {
        LocalDate localDate = LocalDate.d;
        f f10 = f.e;
        c = e.P(localDate, f10);
        localDate = LocalDate.e;
        f10 = f.f;
        d = e.P(localDate, f10);
    }

    private e(LocalDate localDate, f f10) {
        this.a = localDate;
        this.b = f10;
    }

    public static e O(int n10, int n11, int n12, int n13, int n14) {
        LocalDate localDate = LocalDate.D(n10, n11, n12);
        f f10 = f.L(n13, n14);
        e e10 = new e(localDate, f10);
        return e10;
    }

    public static e P(LocalDate localDate, f f10) {
        Objects.requireNonNull(localDate, "date");
        Objects.requireNonNull(f10, "time");
        e e10 = new e(localDate, f10);
        return e10;
    }

    public static e Q(long l10, int n10, l l11) {
        Objects.requireNonNull(l11, "offset");
        h h10 = h.e;
        long l12 = n10;
        h10.P(l12);
        long l13 = l11.C();
        n10 = 86400;
        long l14 = j$.a.a(l10 += l13, n10);
        int n11 = j$.b.a(l10, n10);
        LocalDate localDate = LocalDate.L(l14);
        f f10 = f.O((long)n11 * 1000000000L + l12);
        e e10 = new e(localDate, f10);
        return e10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    private e V(LocalDate localDate, long l10, long l11, long l12, long l13, int n10) {
        f f10;
        e e10 = this;
        LocalDate localDate2 = localDate;
        long l14 = l10 | l11 | l12 | l13;
        long l15 = 0L;
        long l16 = l14 - l15;
        Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
        if (object == false) {
            f10 = this.b;
            return e10.X(localDate2, f10);
        }
        l14 = 86400000000000L;
        l15 = l13 / l14;
        long l17 = 86400L;
        long l18 = l12 / l17 + l15;
        l15 = 1440L;
        long l19 = l11 / l15 + l18;
        l18 = 24;
        long l20 = l10 / l18 + l19;
        l19 = n10;
        long l21 = l13 % l14;
        l17 = l12 % l17;
        long l22 = 1000000000L;
        l17 = l17 * l22 + l21;
        l15 = l11 % l15;
        l21 = 60000000000L;
        l15 = l15 * l21 + l17;
        l17 = l10 % l18 * 3600000000000L + l15;
        f f11 = this.b;
        l15 = f11.T();
        l17 = l17 * l19 + l15;
        l18 = Math.floorDiv(l17, l14) + (l20 *= l19);
        long l23 = (l14 = Math.floorMod(l17, l14)) - l15;
        Object object2 = l23 == 0L ? 0 : (l23 < 0L ? -1 : 1);
        f10 = object2 == false ? this.b : f.O(l14);
        localDate2 = localDate2.Q(l18);
        return e10.X(localDate2, f10);
    }

    private e X(LocalDate localDate, f f10) {
        t t10 = this.a;
        if (t10 == localDate && (t10 = this.b) == f10) {
            return this;
        }
        t10 = new e(localDate, f10);
        return t10;
    }

    private int m(e t10) {
        t t11 = this.a;
        LocalDate localDate = t10.a;
        int n10 = ((LocalDate)t11).m(localDate);
        if (n10 == 0) {
            t11 = this.b;
            t10 = t10.b;
            n10 = ((f)t11).m((f)t10);
        }
        return n10;
    }

    public static e n(s object) {
        Serializable serializable;
        Comparable<StringBuilder> comparable;
        LocalDate localDate;
        boolean bl2 = object instanceof e;
        if (bl2) {
            return (e)object;
        }
        bl2 = object instanceof o;
        if (bl2) {
            return ((o)object).L();
        }
        bl2 = object instanceof i;
        if (bl2) {
            return ((i)object).n();
        }
        try {
            localDate = LocalDate.n((s)object);
        }
        catch (c c10) {
            comparable = new Comparable<StringBuilder>();
            ((StringBuilder)comparable).append("Unable to obtain LocalDateTime from TemporalAccessor: ");
            ((StringBuilder)comparable).append(object);
            ((StringBuilder)comparable).append(" of type ");
            object = object.getClass().getName();
            ((StringBuilder)comparable).append((String)object);
            object = ((StringBuilder)comparable).toString();
            serializable = new c((String)object, c10);
            throw serializable;
        }
        serializable = f.o((s)object);
        comparable = new Comparable<StringBuilder>(localDate, (f)serializable);
        return comparable;
    }

    public int C() {
        return this.a.getYear();
    }

    public boolean D(d t10) {
        long l10;
        long l11;
        t t11;
        long l12;
        Object object = t10 instanceof e;
        boolean bl2 = false;
        boolean bl3 = true;
        if (object != 0) {
            int n10 = this.m((e)(t10 = (e)t10));
            if (n10 > 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        long l13 = ((LocalDate)this.l()).s();
        long l14 = l13 - (l12 = (t11 = t10.l()).s());
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object > 0 || object == 0 && (l11 = (l10 = (l13 = ((f)(t11 = this.j())).T()) - (l12 = ((f)(t10 = t10.j())).T())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) > 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public boolean L(d t10) {
        long l10;
        long l11;
        t t11;
        long l12;
        Object object = t10 instanceof e;
        boolean bl2 = false;
        boolean bl3 = true;
        if (object != 0) {
            int n10 = this.m((e)(t10 = (e)t10));
            if (n10 < 0) {
                bl2 = bl3;
            }
            return bl2;
        }
        long l13 = ((LocalDate)this.l()).s();
        long l14 = l13 - (l12 = (t11 = t10.l()).s());
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object < 0 || object == 0 && (l11 = (l10 = (l13 = ((f)(t11 = this.j())).T()) - (l12 = ((f)(t10 = t10.j())).T())) == 0L ? 0 : (l10 < 0L ? -1 : 1)) < 0) {
            bl2 = bl3;
        }
        return bl2;
    }

    public int M(d d10) {
        boolean bl2 = d10 instanceof e;
        if (bl2) {
            d10 = (e)d10;
            return this.m((e)d10);
        }
        return d.super.M(d10);
    }

    public e R(long l10, x x10) {
        long l11 = l10;
        Object object = x10;
        int n10 = x10 instanceof j$.time.q.i;
        if (n10 != 0) {
            Object object2 = x10;
            object2 = (j$.time.q.i)x10;
            n10 = ((Enum)object2).ordinal();
            switch (n10) {
                default: {
                    object = this.a.P(l10, x10);
                    object2 = this.b;
                    return this.X((LocalDate)object, (f)object2);
                }
                case 6: {
                    long l12 = 256L;
                    long l13 = l10 / l12;
                    e e10 = this.S(l13);
                    long l14 = l10 % l12 * (long)12;
                    LocalDate localDate = e10.a;
                    return e10.V(localDate, l14, 0L, 0L, 0L, 1);
                }
                case 5: {
                    object2 = this.a;
                    object = this;
                    long l15 = l10;
                    l11 = 0L;
                    long l16 = 0L;
                    long l17 = 0L;
                    return this.V((LocalDate)object2, l10, l11, l16, l17, 1);
                }
                case 4: {
                    object2 = this.a;
                    object = this;
                    return this.V((LocalDate)object2, 0L, l10, 0L, 0L, 1);
                }
                case 3: {
                    return this.U(l10);
                }
                case 2: {
                    long l18 = 86400000L;
                    long l19 = l10 / l18;
                    e e11 = this.S(l19);
                    l18 = l10 % l18 * 1000000L;
                    return e11.T(l18);
                }
                case 1: {
                    long l20 = 86400000000L;
                    long l21 = l10 / l20;
                    e e12 = this.S(l21);
                    l20 = l10 % l20 * 1000L;
                    return e12.T(l20);
                }
                case 0: 
            }
            return this.T(l10);
        }
        return (e)x10.n(this, l10);
    }

    public e S(long l10) {
        LocalDate localDate = this.a.Q(l10);
        f f10 = this.b;
        return this.X(localDate, f10);
    }

    public e T(long l10) {
        LocalDate localDate = this.a;
        return this.V(localDate, 0L, 0L, 0L, l10, 1);
    }

    public e U(long l10) {
        LocalDate localDate = this.a;
        return this.V(localDate, 0L, 0L, l10, 0L, 1);
    }

    public LocalDate W() {
        return this.a;
    }

    public e Y(t t10) {
        boolean bl2 = t10 instanceof LocalDate;
        if (bl2) {
            t10 = (LocalDate)t10;
            f f10 = this.b;
            return this.X((LocalDate)t10, f10);
        }
        bl2 = t10 instanceof f;
        if (bl2) {
            LocalDate localDate = this.a;
            t10 = (f)t10;
            return this.X(localDate, (f)t10);
        }
        bl2 = t10 instanceof e;
        if (bl2) {
            return (e)t10;
        }
        return (e)t10.e(this);
    }

    public e Z(u object, long l10) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            Object object2 = object;
            object2 = (h)object;
            bl2 = ((h)object2).C();
            if (bl2) {
                object2 = this.a;
                object = this.b.V((u)object, l10);
                return this.X((LocalDate)object2, (f)object);
            }
            object = this.a.V((u)object, l10);
            f f10 = this.b;
            return this.X((LocalDate)object, f10);
        }
        return (e)object.n(this, l10);
    }

    public Object d(w w10) {
        a_0 a_02 = a_0.a;
        if (w10 == a_02) {
            return this.a;
        }
        return d.super.d(w10);
    }

    public r e(r r10) {
        return d.super.e(r10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof e;
        if (bl3) {
            boolean bl4;
            object = (e)object;
            t t10 = this.a;
            LocalDate localDate = ((e)object).a;
            bl3 = ((LocalDate)t10).equals(localDate);
            if (!bl3 || !(bl4 = ((f)(t10 = this.b)).equals(object = ((e)object).b))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        boolean bl4 = true;
        if (bl3) {
            boolean bl5;
            bl3 = ((h)(u10 = (h)u10)).m();
            if (!bl3 && !(bl5 = ((h)u10).C())) {
                bl4 = false;
            }
            return bl4;
        }
        if (u10 == null || !(bl2 = u10.L(this))) {
            bl4 = false;
        }
        return bl4;
    }

    public long h(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            long l10;
            Object object = u10;
            object = (h)u10;
            bl2 = ((h)object).C();
            if (bl2) {
                object = this.b;
                l10 = ((f)object).h(u10);
            } else {
                object = this.a;
                l10 = ((LocalDate)object).h(u10);
            }
            return l10;
        }
        return u10.o(this);
    }

    public int hashCode() {
        int n10 = this.a.hashCode();
        int n11 = this.b.hashCode();
        return n10 ^ n11;
    }

    public z i(u object) {
        boolean bl2 = object instanceof h;
        if (bl2) {
            Object object2 = object;
            object2 = (h)object;
            bl2 = ((h)object2).C();
            if (bl2) {
                object2 = this.b;
                object = ((f)object2).i((u)object);
            } else {
                object2 = this.a;
                object = ((LocalDate)object2).i((u)object);
            }
            return object;
        }
        return object.D(this);
    }

    public f j() {
        return this.b;
    }

    public int k(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            int n10;
            Object object = u10;
            object = (h)u10;
            bl2 = ((h)object).C();
            if (bl2) {
                object = this.b;
                n10 = ((f)object).k(u10);
            } else {
                object = this.a;
                n10 = ((LocalDate)object).k(u10);
            }
            return n10;
        }
        return s.super.k(u10);
    }

    public b l() {
        return this.a;
    }

    public int o() {
        return this.b.C();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a.toString();
        stringBuilder.append(string2);
        stringBuilder.append('T');
        string2 = this.b.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public int x() {
        return this.b.D();
    }
}

