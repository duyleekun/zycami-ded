/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.e;
import j$.time.f;
import j$.time.h;
import j$.time.k;
import j$.time.l;
import j$.time.p.d;
import j$.time.q.a_0;
import j$.time.q.b_0;
import j$.time.q.c;
import j$.time.q.g;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;
import j$.time.q.z;
import java.io.Serializable;
import java.util.Objects;

public final class i
implements r,
t,
Comparable,
Serializable {
    private final e a;
    private final l b;

    static {
        Object object = e.c;
        s s10 = l.h;
        String string2 = "dateTime";
        Objects.requireNonNull(object, string2);
        object = "offset";
        Objects.requireNonNull(s10, (String)object);
        s10 = e.d;
        l l10 = l.g;
        Objects.requireNonNull(s10, string2);
        Objects.requireNonNull(l10, (String)object);
    }

    private i(e e10, l l10) {
        Objects.requireNonNull(e10, "dateTime");
        this.a = e10;
        Objects.requireNonNull(l10, "offset");
        this.b = l10;
    }

    public static i m(Instant t10, k k10) {
        Objects.requireNonNull(t10, "instant");
        Objects.requireNonNull(k10, "zone");
        k10 = j$.time.r.c.j((l)k10).d((Instant)t10);
        long l10 = t10.x();
        int n10 = t10.C();
        t10 = e.Q(l10, n10, (l)k10);
        i i10 = new i((e)t10, (l)k10);
        return i10;
    }

    private i o(e e10, l l10) {
        boolean bl2;
        s s10 = this.a;
        if (s10 == e10 && (bl2 = ((l)(s10 = this.b)).equals(l10))) {
            return this;
        }
        s10 = new i(e10, l10);
        return s10;
    }

    public long H() {
        e e10 = this.a;
        l l10 = this.b;
        return e10.N(l10);
    }

    public r a(long l10, x x10) {
        t t10;
        boolean bl2 = x10 instanceof j$.time.q.i;
        if (bl2) {
            e e10 = this.a;
            t10 = e10.R(l10, x10);
            l l11 = this.b;
            t10 = this.o((e)t10, l11);
        } else {
            t10 = (i)x10.n(this, l10);
        }
        return t10;
    }

    public r b(t object) {
        boolean bl2 = object instanceof LocalDate;
        if (!(bl2 || (bl2 = object instanceof f) || (bl2 = object instanceof e))) {
            bl2 = object instanceof Instant;
            if (bl2) {
                object = (Instant)object;
                l l10 = this.b;
                object = i.m((Instant)object, l10);
            } else {
                bl2 = object instanceof l;
                if (bl2) {
                    e e10 = this.a;
                    object = (l)object;
                    object = this.o(e10, (l)object);
                } else {
                    bl2 = object instanceof i;
                    if (!bl2) {
                        object = object.e(this);
                    }
                    object = (i)object;
                }
            }
        } else {
            object = this.a.Y((t)object);
            l l11 = this.b;
            object = this.o((e)object, l11);
        }
        return object;
    }

    public r c(u object, long l10) {
        boolean bl2 = object instanceof j$.time.q.h;
        if (bl2) {
            Object object2 = object;
            object2 = (j$.time.q.h)object;
            int[] nArray = h.a;
            int n10 = ((Enum)object2).ordinal();
            int n11 = nArray[n10];
            if (n11 != (n10 = 1)) {
                l l11;
                n10 = 2;
                if (n11 != n10) {
                    object2 = this.a;
                    object = ((e)object2).Z((u)object, l10);
                    l11 = this.b;
                } else {
                    object = this.a;
                    int n12 = ((j$.time.q.h)object2).O(l10);
                    l11 = l.O(n12);
                }
                object = this.o((e)object, l11);
            } else {
                int n13 = this.a.o();
                long l12 = n13;
                object = Instant.L(l10, l12);
                l l13 = this.b;
                object = i.m((Instant)object, l13);
            }
        } else {
            object = (i)object.n(this, l10);
        }
        return object;
    }

    /*
     * WARNING - void declaration
     */
    public int compareTo(Object object) {
        int n10;
        void var4_9;
        object = (i)object;
        s s10 = this.b;
        s s11 = ((i)object).b;
        boolean n102 = ((l)s10).equals(s11);
        if (n102) {
            s10 = this.a;
            s11 = ((i)object).a;
            int n11 = ((e)s10).M((d)s11);
        } else {
            long l10;
            long l11 = this.H();
            int n12 = Long.compare(l11, l10 = ((i)object).H());
            if (n12 == 0) {
                s10 = this.j();
                int n13 = ((f)s10).C();
                s11 = ((i)object).j();
                int n14 = ((f)s11).C();
                int n15 = n13 - n14;
            }
        }
        if (var4_9 == false) {
            s10 = this.a;
            object = ((i)object).a;
            n10 = ((e)s10).M((d)object);
        }
        return n10;
    }

    public Object d(w w10) {
        w w11 = c.a;
        if (w10 != w11 && w10 != (w11 = g.a)) {
            w11 = j$.time.q.d.a;
            if (w10 == w11) {
                return null;
            }
            w11 = a_0.a;
            if (w10 == w11) {
                return this.a.W();
            }
            w11 = j$.time.q.f.a;
            if (w10 == w11) {
                return this.j();
            }
            w11 = b_0.a;
            if (w10 == w11) {
                return j$.time.p.k.a;
            }
            w11 = j$.time.q.e.a;
            if (w10 == w11) {
                return j$.time.q.i.b;
            }
            return w10.a(this);
        }
        return this.b;
    }

    public r e(r r10) {
        j$.time.q.h h10 = j$.time.q.h.y;
        long l10 = this.a.W().s();
        r10 = r10.c(h10, l10);
        h10 = j$.time.q.h.f;
        l10 = this.j().T();
        r10 = r10.c(h10, l10);
        h10 = j$.time.q.h.H;
        l10 = this.b.C();
        return r10.c(h10, l10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof i;
        if (bl3) {
            boolean bl4;
            object = (i)object;
            s s10 = this.a;
            e e10 = ((i)object).a;
            bl3 = ((e)s10).equals(e10);
            if (!bl3 || !(bl4 = ((l)(s10 = this.b)).equals(object = ((i)object).b))) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof j$.time.q.h;
        if (!(bl3 || u10 != null && (bl2 = u10.L(this)))) {
            bl2 = false;
            u10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public long h(u u10) {
        int n10 = u10 instanceof j$.time.q.h;
        if (n10 != 0) {
            int[] nArray = h.a;
            u u11 = u10;
            u11 = (j$.time.q.h)u10;
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
        return n10 ^ n11;
    }

    public z i(u u10) {
        boolean bl2 = u10 instanceof j$.time.q.h;
        if (bl2) {
            j$.time.q.h h10 = j$.time.q.h.G;
            if (u10 != h10 && u10 != (h10 = j$.time.q.h.H)) {
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
        int n10 = object instanceof j$.time.q.h;
        if (n10 != 0) {
            int[] nArray = h.a;
            u u10 = object;
            u10 = (j$.time.q.h)object;
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
        return s.super.k((u)object);
    }

    public e n() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String string2 = this.a.toString();
        stringBuilder.append(string2);
        string2 = this.b.toString();
        stringBuilder.append(string2);
        return stringBuilder.toString();
    }

    public l z() {
        return this.b;
    }
}

