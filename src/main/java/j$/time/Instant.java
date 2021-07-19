/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.a;
import j$.b;
import j$.time.c;
import j$.time.format.DateTimeFormatter;
import j$.time.q.a_0;
import j$.time.q.b_0;
import j$.time.q.d;
import j$.time.q.e;
import j$.time.q.f;
import j$.time.q.g;
import j$.time.q.h;
import j$.time.q.i;
import j$.time.q.r;
import j$.time.q.s;
import j$.time.q.t;
import j$.time.q.u;
import j$.time.q.w;
import j$.time.q.x;
import j$.time.q.y;
import j$.time.q.z;
import java.io.Serializable;

public final class Instant
implements r,
t,
Comparable,
Serializable {
    public static final Instant c;
    private final long a;
    private final int b;

    static {
        Instant instant;
        long l10 = 0L;
        c = instant = new Instant(l10, 0);
        Instant.L(-31557014167219200L, l10);
        Instant.L(31556889864403199L, 999999999L);
    }

    private Instant(long l10, int n10) {
        this.a = l10;
        this.b = n10;
    }

    public static Instant D(long l10) {
        int n10 = 1000;
        long l11 = j$.a.a(l10, n10);
        int n11 = j$.b.a(l10, n10) * 1000000;
        return Instant.n(l11, n11);
    }

    public static Instant L(long l10, long l11) {
        long l12 = 1000000000L;
        long l13 = Math.floorDiv(l11, l12);
        l10 = Math.addExact(l10, l13);
        int n10 = (int)Math.floorMod(l11, l12);
        return Instant.n(l10, n10);
    }

    private Instant O(long l10, long l11) {
        long l12 = l10 | l11;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        l10 = Math.addExact(this.a, l10);
        l12 = 1000000000L;
        l13 = l11 / l12;
        l10 = Math.addExact(l10, l13);
        l11 %= l12;
        l12 = (long)this.b + l11;
        return Instant.L(l10, l12);
    }

    private static Instant n(long l10, int n10) {
        long l11;
        long l12 = (long)n10 | l10;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return c;
        }
        l12 = -31557014167219200L;
        long l15 = l10 - l12;
        object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object >= 0 && (object = (l11 = l10 - (l12 = 31556889864403199L)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) <= 0) {
            Instant instant = new Instant(l10, n10);
            return instant;
        }
        c c10 = new c("Instant exceeds minimum or maximum instant");
        throw c10;
    }

    public static Instant o(s object) {
        Object object2;
        h h10;
        boolean bl2 = object instanceof Instant;
        if (bl2) {
            return (Instant)object;
        }
        try {
            h10 = h.G;
        }
        catch (c c10) {
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("Unable to obtain Instant from TemporalAccessor: ");
            ((StringBuilder)object2).append(object);
            ((StringBuilder)object2).append(" of type ");
            object = object.getClass().getName();
            ((StringBuilder)object2).append((String)object);
            object = ((StringBuilder)object2).toString();
            c c11 = new c((String)object, c10);
            throw c11;
        }
        long l10 = object.h(h10);
        object2 = h.e;
        int n10 = object.k((u)object2);
        long l11 = n10;
        return Instant.L(l10, l11);
    }

    public int C() {
        return this.b;
    }

    public Instant P(long l10, x x10) {
        int n10 = x10 instanceof i;
        if (n10 != 0) {
            x x11 = x10;
            x11 = (i)x10;
            n10 = ((Enum)((Object)x11)).ordinal();
            long l11 = 1000L;
            long l12 = 0L;
            long l13 = 1000000L;
            switch (n10) {
                default: {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Unsupported unit: ");
                    charSequence.append(x10);
                    charSequence = charSequence.toString();
                    y y10 = new y((String)charSequence);
                    throw y10;
                }
                case 7: {
                    l10 = j$.c.a(l10, 86400);
                    return this.Q(l10);
                }
                case 6: {
                    l10 = j$.c.a(l10, 43200);
                    return this.Q(l10);
                }
                case 5: {
                    l10 = j$.c.a(l10, 3600);
                    return this.Q(l10);
                }
                case 4: {
                    l10 = j$.c.a(l10, 60);
                    return this.Q(l10);
                }
                case 3: {
                    return this.O(l10, l12);
                }
                case 2: {
                    l12 = l10 / l11;
                    l10 = l10 % l11 * l13;
                    return this.O(l12, l10);
                }
                case 1: {
                    l12 = l10 / l13;
                    l10 = l10 % l13 * l11;
                    return this.O(l12, l10);
                }
                case 0: 
            }
            return this.O(l12, l10);
        }
        return (Instant)x10.n(this, l10);
    }

    public Instant Q(long l10) {
        return this.O(l10, 0L);
    }

    public r b(t t10) {
        return (Instant)t10.e(this);
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     */
    public r c(u object, long l10) {
        int n10 = object instanceof h;
        if (n10 == 0) {
            return (Instant)object.n(this, l10);
        }
        Object object2 = object;
        object2 = (h)object;
        ((h)object2).P(l10);
        n10 = ((Enum)object2).ordinal();
        if (n10 != 0) {
            void var9_10;
            int n11 = 2;
            if (n10 != n11) {
                n11 = 4;
                if (n10 != n11) {
                    n11 = 28;
                    if (n10 != n11) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported field: ");
                        stringBuilder.append(object);
                        object = stringBuilder.toString();
                        y y10 = new y((String)object);
                        throw y10;
                    }
                    long l11 = this.a;
                    long l12 = l10 - l11;
                    Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 == false) return this;
                    int n12 = this.b;
                    return Instant.n(l10, (int)var9_10);
                }
                int n13 = (int)l10 * 1000000;
                int n14 = this.b;
                if (n13 == n14) return this;
            } else {
                int n15 = (int)l10 * 1000;
                int n16 = this.b;
                if (n15 == n16) return this;
            }
            l10 = this.a;
            return Instant.n(l10, (int)var9_10);
        }
        long l13 = this.b;
        long l14 = l10 - l13;
        Object object4 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object4 == false) {
            return this;
        }
        l13 = this.a;
        int n17 = (int)l10;
        return Instant.n(l13, n17);
    }

    public int compareTo(Object object) {
        object = (Instant)object;
        long l10 = this.a;
        long l11 = ((Instant)object).a;
        int n10 = Long.compare(l10, l11);
        if (n10 == 0) {
            n10 = this.b;
            int n11 = ((Instant)object).b;
            n10 -= n11;
        }
        return n10;
    }

    public Object d(w w10) {
        w w11 = e.a;
        if (w10 == w11) {
            return i.b;
        }
        w11 = b_0.a;
        if (w10 != w11 && w10 != (w11 = d.a) && w10 != (w11 = g.a) && w10 != (w11 = j$.time.q.c.a) && w10 != (w11 = a_0.a) && w10 != (w11 = f.a)) {
            return w10.a(this);
        }
        return null;
    }

    public r e(r r10) {
        h h10 = h.G;
        long l10 = this.a;
        r10 = r10.c(h10, l10);
        h10 = h.e;
        l10 = this.b;
        return r10.c(h10, l10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof Instant;
        if (object2 != 0) {
            int n10;
            object = (Instant)object;
            long l10 = this.a;
            long l11 = ((Instant)object).a;
            long l12 = l10 - l11;
            object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            if (object2 != 0 || (object2 = this.b) != (n10 = ((Instant)object).b)) {
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
            h h10 = h.G;
            if (u10 != h10 && u10 != (h10 = h.e) && u10 != (h10 = h.g) && u10 != (h10 = h.i)) {
                bl4 = false;
            }
            return bl4;
        }
        if (u10 == null || !(bl2 = u10.L(this))) {
            bl4 = false;
        }
        return bl4;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public long h(u object) {
        int n10;
        int n11 = object instanceof h;
        if (n11 == 0) return object.o(this);
        Object object2 = object;
        object2 = (h)object;
        n11 = ((Enum)object2).ordinal();
        if (n11 != 0) {
            int n12 = 2;
            if (n11 != n12) {
                n12 = 4;
                if (n11 != n12) {
                    n12 = 28;
                    if (n11 == n12) {
                        return this.a;
                    }
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Unsupported field: ");
                    stringBuilder.append(object);
                    object = stringBuilder.toString();
                    object2 = new y((String)object);
                    throw object2;
                }
                n10 = this.b;
                n11 = 1000000;
                n10 /= n11;
                return n10;
            }
            n10 = this.b / 1000;
            return n10;
        }
        n10 = this.b;
        return n10;
    }

    public int hashCode() {
        long l10 = this.a;
        long l11 = l10 >>> 32;
        int n10 = (int)(l10 ^ l11);
        return this.b * 51 + n10;
    }

    public z i(u u10) {
        return s.super.i(u10);
    }

    public int k(u object) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            Object object2 = object;
            object2 = (h)object;
            n10 = ((Enum)object2).ordinal();
            if (n10 != 0) {
                int n11 = 2;
                if (n10 != n11) {
                    n11 = 4;
                    if (n10 != n11) {
                        n11 = 28;
                        if (n10 == n11) {
                            object2 = h.G;
                            long l10 = this.a;
                            ((h)object2).O(l10);
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Unsupported field: ");
                        stringBuilder.append(object);
                        object = stringBuilder.toString();
                        object2 = new y((String)object);
                        throw object2;
                    }
                    return this.b / 1000000;
                }
                return this.b / 1000;
            }
            return this.b;
        }
        z z10 = s.super.i((u)object);
        long l11 = object.o(this);
        return z10.a(l11, (u)object);
    }

    public int m(Instant instant) {
        long l10 = this.a;
        long l11 = instant.a;
        int n10 = Long.compare(l10, l11);
        if (n10 != 0) {
            return n10;
        }
        n10 = this.b;
        int n11 = instant.b;
        return n10 - n11;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long toEpochMilli() {
        long l10 = this.a;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        int n10 = 1000000;
        int n11 = 1000;
        if (l12 < 0 && (l12 = (long)this.b) > 0) {
            long l13 = 1L;
            l10 = j$.c.a(l10 + l13, n11);
            l12 = this.b / n10 - n11;
        } else {
            l10 = j$.c.a(l10, n11);
            l12 = this.b / n10;
        }
        l11 = l12;
        return Math.addExact(l10, l11);
    }

    public String toString() {
        return DateTimeFormatter.f.a(this);
    }

    public long x() {
        return this.a;
    }
}

