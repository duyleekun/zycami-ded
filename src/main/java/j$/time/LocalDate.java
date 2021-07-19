/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.Instant;
import j$.time.a;
import j$.time.b;
import j$.time.c;
import j$.time.d;
import j$.time.e;
import j$.time.f;
import j$.time.format.DateTimeFormatter;
import j$.time.g;
import j$.time.k;
import j$.time.l;
import j$.time.p.j;
import j$.time.q.a_0;
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
import java.util.Map;
import java.util.Objects;
import java.util.TimeZone;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class LocalDate
implements r,
t,
j$.time.p.b,
Serializable {
    public static final LocalDate d;
    public static final LocalDate e;
    private final int a;
    private final short b;
    private final short c;

    static {
        int n10 = 1;
        d = LocalDate.D(-999999999, n10, n10);
        e = LocalDate.D(999999999, 12, 31);
    }

    private LocalDate(int n10, int n11, int n12) {
        this.a = n10;
        n10 = (short)n11;
        this.b = (short)n10;
        n10 = (short)n12;
        this.c = (short)n10;
    }

    public static LocalDate C(b object) {
        Instant instant = Instant.D(System.currentTimeMillis());
        object = ((b)object).a().m().d(instant);
        long l10 = instant.x();
        long l11 = ((l)object).C();
        return LocalDate.L(j$.a.a(l10 + l11, 86400));
    }

    public static LocalDate D(int n10, int n11, int n12) {
        Object object = h.E;
        long l10 = n10;
        ((h)object).P(l10);
        object = h.B;
        long l11 = n11;
        ((h)object).P(l11);
        object = h.w;
        l11 = n12;
        ((h)object).P(l11);
        int n13 = 28;
        if (n12 > n13) {
            int n14 = 31;
            int n15 = 2;
            int n16 = 29;
            if (n11 != n15) {
                n13 = 4;
                n13 = n11 != n13 && n11 != (n13 = 6) && n11 != (n13 = 9) && n11 != (n13 = 11) ? n14 : 30;
            } else {
                j$.time.p.k k10 = j$.time.p.k.a;
                boolean bl2 = k10.y(l10);
                if (bl2) {
                    n13 = n16;
                }
            }
            if (n12 > n13) {
                if (n12 == n16) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("Invalid date 'February 29' as '");
                    stringBuilder.append(n10);
                    stringBuilder.append("' is not a leap year");
                    String string2 = stringBuilder.toString();
                    c c10 = new c(string2);
                    throw c10;
                }
                object = j$.e.a.a.a.a.b("Invalid date '");
                String string3 = g.o(n11).name();
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(" ");
                ((StringBuilder)object).append(n12);
                ((StringBuilder)object).append("'");
                string3 = ((StringBuilder)object).toString();
                c c11 = new c(string3);
                throw c11;
            }
        }
        object = new LocalDate(n10, n11, n12);
        return object;
    }

    public static LocalDate L(long l10) {
        long l11;
        long l12;
        long l13 = l10 + 719528L - (long)60;
        long l14 = 0L;
        long l15 = l13 == l14 ? 0 : (l13 < l14 ? -1 : 1);
        long l16 = 146097L;
        long l17 = 1L;
        long l18 = 400L;
        if (l15 < 0) {
            l12 = (l13 + l17) / l16 - l17;
            l11 = l12 * l18;
            l12 = -l12 * l16;
            l13 += l12;
        } else {
            l11 = l14;
        }
        l12 = (l13 * l18 + 591L) / l16;
        long l19 = 365L;
        long l20 = l12 * l19;
        long l21 = 4;
        long l22 = l12 / l21 + l20;
        l20 = 100;
        long l23 = l12 / l20;
        l22 -= l23;
        l23 = l12 / l18 + l22;
        l22 = l13 - l23;
        long l24 = l22 == l14 ? 0 : (l22 < l14 ? -1 : 1);
        if (l24 < 0) {
            l14 = l12 / l21 + (l19 *= (l12 -= l17));
            l19 = l12 / l20;
            l14 -= l19;
            l19 = l12 / l18 + l14;
            l22 = l13 - l19;
        }
        l13 = l22;
        l12 += l11;
        int n10 = (int)l22;
        int n11 = (n10 * 5 + 2) / 153;
        l24 = (n11 + 2) % 12 + 1;
        int n12 = (n11 * 306 + 5) / 10;
        n10 = n10 - n12 + 1;
        long l25 = n11 / 10;
        n11 = h.E.O(l12 += l25);
        LocalDate localDate = new LocalDate(n11, (int)l24, n10);
        return localDate;
    }

    public static LocalDate O(int n10, int n11) {
        Object object = h.E;
        long l10 = n10;
        ((h)object).P(l10);
        object = h.x;
        long l11 = n11;
        ((h)object).P(l11);
        object = j$.time.p.k.a;
        boolean n12 = ((j$.time.p.k)object).y(l10);
        int n13 = 366;
        if (n11 == n13 && !n12) {
            object = new StringBuilder();
            ((StringBuilder)object).append("Invalid date 'DayOfYear 366' as '");
            ((StringBuilder)object).append(n10);
            ((StringBuilder)object).append("' is not a leap year");
            String string2 = ((StringBuilder)object).toString();
            c c10 = new c(string2);
            throw c10;
        }
        n13 = n11 + -1;
        int n14 = 31;
        n13 /= n14;
        int n15 = 1;
        g g10 = g.o(n13 += n15);
        int n16 = g10.m(n12);
        int n17 = g10.ordinal();
        if (n17 != n15) {
            int n18 = 3;
            if (n17 == n18 || n17 == (n18 = 5) || n17 == (n18 = 8) || n17 == (n18 = 10)) {
                n14 = 30;
            }
        } else {
            n14 = n12 ? 29 : 28;
        }
        n16 = n16 + n14 - n15;
        if (n11 > n16) {
            long l12 = 1L;
            g10 = g10.x(l12);
        }
        int n19 = g10.m(n12);
        n11 = n11 - n19 + n15;
        n13 = g10.n();
        object = new LocalDate(n10, n13, n11);
        return object;
    }

    /*
     * Enabled aggressive block sorting
     */
    private static LocalDate U(int n10, int n11, int n12) {
        block1: {
            int n13;
            block2: {
                block0: {
                    n13 = 2;
                    if (n11 == n13) break block0;
                    n13 = 4;
                    if (n11 != n13 && n11 != (n13 = 6) && n11 != (n13 = 9) && n11 != (n13 = 11)) break block1;
                    n13 = 30;
                    break block2;
                }
                j$.time.p.k k10 = j$.time.p.k.a;
                long l10 = n10;
                n13 = (int)(k10.y(l10) ? 1 : 0);
                n13 = n13 != 0 ? 29 : 28;
            }
            n12 = Math.min(n12, n13);
        }
        return new LocalDate(n10, n11, n12);
    }

    public static LocalDate n(s object) {
        Objects.requireNonNull(object, "temporal");
        Object object2 = a_0.a;
        object2 = (LocalDate)object.d((w)object2);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalDate from TemporalAccessor: ");
        stringBuilder.append(object);
        stringBuilder.append(" of type ");
        object = object.getClass().getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new c((String)object);
        throw object2;
    }

    public static LocalDate now() {
        Object object = k.a;
        object = TimeZone.getDefault().getID();
        Map map = k.a;
        object = k.n((String)object, map);
        a a10 = new a((k)object);
        return LocalDate.C(a10);
    }

    private int o(u object) {
        Object object2 = object;
        object2 = (h)object;
        int n10 = ((Enum)object2).ordinal();
        int n11 = 1;
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2 = new y((String)object);
                throw object2;
            }
            case 27: {
                int n12 = this.a;
                if (n12 < n11) {
                    n11 = 0;
                    Object var5_6 = null;
                }
                return n11;
            }
            case 26: {
                return this.a;
            }
            case 24: {
                object = new y("Invalid field 'ProlepticMonth' for get() method, use getLong() instead");
                throw object;
            }
            case 23: {
                return this.b;
            }
            case 22: {
                return (this.getDayOfYear() - n11) / 7 + n11;
            }
            case 20: {
                object = new y("Invalid field 'EpochDay' for get() method, use getLong() instead");
                throw object;
            }
            case 17: {
                return (this.getDayOfYear() - n11) % 7 + n11;
            }
            case 16: {
                return (this.c - n11) % 7 + n11;
            }
            case 15: {
                return this.x().m();
            }
            case 25: {
                int n13 = this.a;
                if (n13 < n11) {
                    n13 = 1 - n13;
                }
                return n13;
            }
            case 21: {
                return (this.c - n11) / 7 + n11;
            }
            case 19: {
                return this.getDayOfYear();
            }
            case 18: 
        }
        return this.c;
    }

    public int E() {
        int n10 = this.G();
        n10 = n10 != 0 ? 366 : 365;
        return n10;
    }

    public j$.time.p.d F(f f10) {
        return j$.time.e.P(this, f10);
    }

    public boolean G() {
        j$.time.p.k k10 = j$.time.p.k.a;
        long l10 = this.a;
        return k10.y(l10);
    }

    public int K(j$.time.p.b b10) {
        boolean bl2 = b10 instanceof LocalDate;
        if (bl2) {
            b10 = (LocalDate)b10;
            return this.m((LocalDate)b10);
        }
        return j$.time.p.b.super.K(b10);
    }

    public LocalDate P(long l10, x object) {
        int n10 = object instanceof i;
        if (n10 != 0) {
            x x10 = object;
            x10 = (i)object;
            n10 = ((Enum)((Object)x10)).ordinal();
            switch (n10) {
                default: {
                    CharSequence charSequence = new StringBuilder();
                    charSequence.append("Unsupported unit: ");
                    charSequence.append(object);
                    charSequence = charSequence.toString();
                    y y10 = new y((String)charSequence);
                    throw y10;
                }
                case 14: {
                    object = h.F;
                    l10 = Math.addExact(this.h((u)object), l10);
                    return this.V((u)object, l10);
                }
                case 13: {
                    l10 = j$.c.a(l10, 1000);
                    return this.T(l10);
                }
                case 12: {
                    l10 = j$.c.a(l10, 100);
                    return this.T(l10);
                }
                case 11: {
                    l10 = j$.c.a(l10, 10);
                    return this.T(l10);
                }
                case 10: {
                    return this.T(l10);
                }
                case 9: {
                    return this.R(l10);
                }
                case 8: {
                    return this.S(l10);
                }
                case 7: 
            }
            return this.Q(l10);
        }
        return (LocalDate)object.n(this, l10);
    }

    public LocalDate Q(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        return LocalDate.L(Math.addExact(this.s(), l10));
    }

    public LocalDate R(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        l11 = (long)this.a * (long)12;
        long l13 = this.b + -1;
        l11 = l11 + l13 + l10;
        h h10 = h.E;
        int n10 = 12;
        l13 = j$.a.a(l11, n10);
        int n11 = h10.O(l13);
        n10 = j$.b.a(l11, n10) + 1;
        object = this.c;
        return LocalDate.U(n11, n10, (int)object);
    }

    public LocalDate S(long l10) {
        l10 = j$.c.a(l10, 7);
        return this.Q(l10);
    }

    public LocalDate T(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        h h10 = h.E;
        long l13 = (long)this.a + l10;
        int n10 = h10.O(l13);
        short s10 = this.b;
        object = this.c;
        return LocalDate.U(n10, s10, (int)object);
    }

    /*
     * Unable to fully structure code
     */
    public LocalDate V(u var1_1, long var2_2) {
        block21: {
            block20: {
                block22: {
                    var4_3 = var1_1 instanceof h;
                    if (var4_3 == 0) break block20;
                    var5_4 = var1_1;
                    var5_4 = (h)var1_1;
                    var5_4.P(var2_2);
                    var4_3 = var5_4.ordinal();
                    var6_5 = 1L;
                    var8_6 = 1;
                    switch (var4_3) {
                        default: {
                            var10_9 = new StringBuilder();
                            var10_9.append("Unsupported field: ");
                            var10_9.append(var1_1);
                            var1_1 = var10_9.toString();
                            var9_7 = new y((String)var1_1);
                            throw var9_7;
                        }
                        case 27: {
                            var1_1 = h.F;
                            var11_10 = this.h((u)var1_1);
                            var13_14 = var11_10 == var2_2 ? 0 : (var11_10 < var2_2 ? -1 : 1);
                            if (var13_14 == false) {
                                var1_1 = this;
                            } else {
                                var13_14 = this.a;
                                var1_1 = this.X(var8_6 -= var13_14);
                            }
                            return var1_1;
                        }
                        case 25: {
                            var13_15 = this.a;
                            if (var13_15 < var8_6) {
                                var2_2 = var6_5 - var2_2;
                            }
                        }
                        case 26: {
                            var13_15 = (int)var2_2;
                            var1_1 = this.X(var13_15);
                            break block21;
                        }
                        case 24: {
                            var14_21 = (long)this.a * (long)12;
                            var13_16 = this.b;
                            var16_22 = var13_16;
                            var14_21 = var14_21 + var16_22 - var6_5;
                            var1_1 = this.R(var2_2 -= var14_21);
                            break block21;
                        }
                        case 23: {
                            var13_17 = (int)var2_2;
                            var18_23 = this.b;
                            if (var18_23 == var13_17) ** GOTO lbl-1000
                            var9_8 = h.B;
                            var11_11 = var13_17;
                            var9_8.P(var11_11);
                            var18_23 = this.a;
                            var19_26 = this.c;
                            var1_1 = LocalDate.U(var18_23, var13_17, var19_26);
                            break block21;
                        }
                        case 22: {
                            var1_1 = h.A;
                            ** GOTO lbl62
                        }
                        case 21: {
                            var1_1 = h.z;
lbl62:
                            // 2 sources

                            var11_12 = this.h((u)var1_1);
                            var1_1 = this.S(var2_2 -= var11_12);
                            break block21;
                        }
                        case 20: {
                            var1_1 = LocalDate.L(var2_2);
                            break block21;
                        }
                        case 19: {
                            var13_18 = (int)var2_2;
                            var18_24 = this.getDayOfYear();
                            if (var18_24 == var13_18) ** GOTO lbl-1000
                            var18_24 = this.a;
                            var1_1 = LocalDate.O(var18_24, var13_18);
                            break block21;
                        }
                        case 18: {
                            var13_19 = (int)var2_2;
                            var18_25 = this.c;
                            if (var18_25 == var13_19) lbl-1000:
                            // 3 sources

                            {
                                var1_1 = this;
                            } else {
                                var18_25 = this.a;
                                var19_27 = this.b;
                                var1_1 = LocalDate.D(var18_25, var19_27, var13_19);
                            }
                            break block21;
                        }
                        case 17: {
                            var1_1 = h.v;
                            ** GOTO lbl90
                        }
                        case 16: {
                            var1_1 = h.u;
lbl90:
                            // 2 sources

                            var11_13 = this.h((u)var1_1);
                            break block22;
                        }
                        case 15: 
                    }
                    var1_1 = this.x();
                    var13_20 = var1_1.m();
                    var11_13 = var13_20;
                }
                var1_1 = this.Q(var2_2 -= var11_13);
                break block21;
            }
            var1_1 = (LocalDate)var1_1.n(this, var2_2);
        }
        return var1_1;
    }

    public LocalDate W(int n10) {
        int n11 = this.getDayOfYear();
        if (n11 == n10) {
            return this;
        }
        return LocalDate.O(this.a, n10);
    }

    public LocalDate X(int n10) {
        int n11 = this.a;
        if (n11 == n10) {
            return this;
        }
        h h10 = h.E;
        long l10 = n10;
        h10.P(l10);
        n11 = this.b;
        short s10 = this.c;
        return LocalDate.U(n10, n11, s10);
    }

    public j$.time.p.b b(t object) {
        boolean bl2 = object instanceof LocalDate;
        if (!bl2) {
            object = object.e(this);
        }
        return (LocalDate)object;
    }

    public r b(t object) {
        boolean bl2 = object instanceof LocalDate;
        if (!bl2) {
            object = object.e(this);
        }
        return (LocalDate)object;
    }

    public int compareTo(Object object) {
        int n10;
        boolean bl2 = (object = (j$.time.p.b)object) instanceof LocalDate;
        if (bl2) {
            object = (LocalDate)object;
            n10 = this.m((LocalDate)object);
        } else {
            n10 = j$.time.p.b.super.K((j$.time.p.b)object);
        }
        return n10;
    }

    public Object d(w w10) {
        a_0 a_02 = a_0.a;
        if (w10 == a_02) {
            return this;
        }
        return j$.time.p.b.super.d(w10);
    }

    public r e(r r10) {
        return j$.time.p.b.super.e(r10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof LocalDate;
        if (bl3) {
            int n10 = this.m((LocalDate)(object = (LocalDate)object));
            if (n10 != 0) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public j f() {
        return j$.time.p.k.a;
    }

    public String format(DateTimeFormatter dateTimeFormatter) {
        Objects.requireNonNull(dateTimeFormatter, "formatter");
        return dateTimeFormatter.a(this);
    }

    public boolean g(u u10) {
        return j$.time.p.b.super.g(u10);
    }

    public int getDayOfYear() {
        g g10 = g.o(this.b);
        short s10 = this.G();
        int n10 = g10.m(s10 != 0);
        s10 = this.c;
        return n10 + s10 + -1;
    }

    public int getYear() {
        return this.a;
    }

    public long h(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            h h10 = h.y;
            if (u10 == h10) {
                return this.s();
            }
            h10 = h.C;
            if (u10 == h10) {
                long l10 = (long)this.a * (long)12;
                long l11 = this.b;
                return l10 + l11 - 1L;
            }
            return this.o(u10);
        }
        return u10.o(this);
    }

    public int hashCode() {
        int n10 = this.a;
        int n11 = this.b;
        short s10 = this.c;
        int n12 = n10 & 0xFFFFF800;
        return (n10 <<= 11) + (n11 <<= 6) + s10 ^ n12;
    }

    public z i(u object) {
        int n10 = object instanceof h;
        if (n10 != 0) {
            Object object2 = object;
            object2 = (h)object;
            boolean n11 = ((h)object2).m();
            if (n11) {
                int n12;
                n10 = ((Enum)object2).ordinal();
                int n13 = 18;
                long l10 = 1L;
                if (n10 != n13) {
                    int n14 = 19;
                    if (n10 != n14) {
                        int n15 = 21;
                        if (n10 != n15) {
                            int n16 = 25;
                            if (n10 != n16) {
                                return ((u)object).x();
                            }
                            int n17 = this.getYear();
                            long l11 = n17 <= 0 ? 1000000000L : 999999999L;
                            return z.i(l10, l11);
                        }
                        short s10 = this.b;
                        object = g.o(s10);
                        long l12 = object == (object2 = g.b) && (s10 = (short)(this.G() ? 1 : 0)) == 0 ? (long)4 : (long)5;
                        return z.i(l10, l12);
                    }
                    n12 = (int)(this.G() ? 1 : 0);
                    n12 = n12 != 0 ? 366 : 365;
                } else {
                    n12 = this.b;
                    n10 = 2;
                    n12 = n12 != n10 ? (n12 != (n10 = 4) && n12 != (n10 = 6) && n12 != (n10 = 9) && n12 != (n10 = 11) ? 31 : 30) : ((n12 = (int)(this.G() ? 1 : 0)) != 0 ? 29 : 28);
                }
                long l13 = n12;
                return z.i(l10, l13);
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unsupported field: ");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            object2 = new y((String)object);
            throw object2;
        }
        return object.D(this);
    }

    public int k(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            return this.o(u10);
        }
        return s.super.k(u10);
    }

    int m(LocalDate localDate) {
        int n10 = this.a;
        int n11 = localDate.a;
        if ((n10 -= n11) == 0) {
            n10 = this.b;
            n11 = localDate.b;
            if ((n10 -= n11) == 0) {
                n10 = this.c;
                short s10 = localDate.c;
                n10 -= s10;
            }
        }
        return n10;
    }

    public long s() {
        int n10 = this.a;
        long l10 = n10;
        short s10 = this.b;
        long l11 = s10;
        long l12 = 365L * l10;
        long l13 = 0L;
        l12 += l13;
        Object object = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
        if (object >= 0) {
            l13 = ((long)3 + l10) / (long)4;
            long l14 = (long)99 + l10;
            long l15 = 100;
            l10 += 399L;
            l14 = 400L;
            l10 = l10 / l14 + (l13 -= (l14 /= l15)) + l12;
        } else {
            l13 = l10 / (long)-4;
            long l16 = l10 / (long)-100;
            l13 -= l16;
            l16 = -400L;
            l10 = l10 / l16 + l13;
            l10 = l12 - l10;
        }
        l12 = 367L * l11 - 362L;
        l13 = 12;
        l12 = l12 / l13 + l10;
        l10 = this.c + -1;
        l12 += l10;
        l10 = 2;
        n10 = (int)(l11 == l10 ? 0 : (l11 < l10 ? -1 : 1));
        if (n10 > 0) {
            l10 = 1L;
            l12 -= l10;
            s10 = (short)(this.G() ? 1 : 0);
            if (s10 == 0) {
                l12 -= l10;
            }
        }
        return l12 - 719528L;
    }

    public String toString() {
        String string2;
        int n10 = this.a;
        short s10 = this.b;
        short s11 = this.c;
        int c10 = Math.abs(n10);
        short s12 = 10;
        StringBuilder stringBuilder = new StringBuilder(s12);
        int n11 = 1000;
        if (c10 < n11) {
            if (n10 < 0) {
                stringBuilder.append(n10 += -10000);
                n10 = 1;
            } else {
                stringBuilder.append(n10 += 10000);
                n10 = 0;
                string2 = null;
            }
            stringBuilder.deleteCharAt(n10);
        } else {
            int n12 = 9999;
            if (n10 > n12) {
                char c11 = '+';
                stringBuilder.append(c11);
            }
            stringBuilder.append(n10);
        }
        string2 = "-0";
        String string3 = "-";
        String string4 = s10 < s12 ? string2 : string3;
        stringBuilder.append(string4);
        stringBuilder.append(s10);
        if (s11 >= s12) {
            string2 = string3;
        }
        stringBuilder.append(string2);
        stringBuilder.append(s11);
        return stringBuilder.toString();
    }

    public j$.time.p.b w(long l10, x x10) {
        LocalDate localDate;
        long l11 = Long.MIN_VALUE;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            l10 = Long.MAX_VALUE;
            localDate = this.P(l10, x10);
            l11 = 1L;
            localDate = localDate.P(l11, x10);
        } else {
            l10 = -l10;
            localDate = this.P(l10, x10);
        }
        return localDate;
    }

    public d x() {
        return j$.time.d.n(j$.b.a(this.s() + (long)3, 7) + 1);
    }
}

