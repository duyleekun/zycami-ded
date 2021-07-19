/*
 * Decompiled with CFR 0.151.
 */
package j$.time;

import j$.time.c;
import j$.time.q.a_0;
import j$.time.q.b_0;
import j$.time.q.d;
import j$.time.q.e;
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
import java.util.Objects;

public final class f
implements r,
t,
Comparable,
Serializable {
    public static final f e;
    public static final f f;
    private static final f[] g;
    private final byte a;
    private final byte b;
    private final byte c;
    private final int d;

    static {
        f[] fArray;
        int n10;
        g = new f[24];
        f f10 = null;
        for (int i10 = 0; i10 < (n10 = (fArray = g).length); ++i10) {
            f f11;
            fArray[i10] = f11 = new f(i10, 0, 0, 0);
        }
        f cfr_ignored_0 = fArray[0];
        f cfr_ignored_1 = fArray[12];
        e = fArray[0];
        n10 = 59;
        f = f10 = new f(23, n10, n10, 999999999);
    }

    private f(int n10, int n11, int n12, int n13) {
        n10 = (byte)n10;
        this.a = (byte)n10;
        n10 = (byte)n11;
        this.b = (byte)n10;
        n10 = (byte)n12;
        this.c = (byte)n10;
        this.d = n13;
    }

    public static f L(int n10, int n11) {
        Object object = h.q;
        long l10 = n10;
        ((h)object).P(l10);
        if (n11 == 0) {
            return g[n10];
        }
        object = h.m;
        l10 = n11;
        ((h)object).P(l10);
        object = new f(n10, n11, 0, 0);
        return object;
    }

    public static f O(long l10) {
        h.f.P(l10);
        long l11 = 3600000000000L;
        int n10 = (int)(l10 / l11);
        long l12 = (long)n10 * l11;
        l11 = 60000000000L;
        int n11 = (int)((l10 -= l12) / l11);
        long l13 = (long)n11 * l11;
        l11 = 1000000000L;
        int n12 = (int)((l10 -= l13) / l11);
        long l14 = (long)n12 * l11;
        int n13 = (int)(l10 - l14);
        return j$.time.f.n(n10, n11, n12, n13);
    }

    private static f n(int n10, int n11, int n12, int n13) {
        int n14 = n11 | n12 | n13;
        if (n14 == 0) {
            return g[n10];
        }
        f f10 = new f(n10, n11, n12, n13);
        return f10;
    }

    public static f o(s object) {
        Objects.requireNonNull(object, "temporal");
        Object object2 = j$.time.q.f.a;
        object2 = (f)object.d((w)object2);
        if (object2 != null) {
            return object2;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Unable to obtain LocalTime from TemporalAccessor: ");
        stringBuilder.append(object);
        stringBuilder.append(" of type ");
        object = object.getClass().getName();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        object2 = new c((String)object);
        throw object2;
    }

    private int x(u object) {
        Object object2 = object;
        object2 = (h)object;
        int n10 = ((Enum)object2).ordinal();
        int n11 = 12;
        switch (n10) {
            default: {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unsupported field: ");
                stringBuilder.append(object);
                object = stringBuilder.toString();
                object2 = new y((String)object);
                throw object2;
            }
            case 14: {
                return this.a / n11;
            }
            case 13: {
                int n12 = this.a;
                if (n12 == 0) {
                    n12 = 24;
                }
                return n12;
            }
            case 12: {
                return this.a;
            }
            case 11: {
                int n13 = this.a % n11;
                n10 = n13 % 12;
                if (n10 != 0) {
                    n11 = n13;
                }
                return n11;
            }
            case 10: {
                return this.a % n11;
            }
            case 9: {
                int n14 = this.a * 60;
                n10 = this.b;
                return n14 + n10;
            }
            case 8: {
                return this.b;
            }
            case 7: {
                return this.U();
            }
            case 6: {
                return this.c;
            }
            case 5: {
                return (int)(this.T() / 1000000L);
            }
            case 4: {
                return this.d / 1000000;
            }
            case 3: {
                object = new y("Invalid field 'MicroOfDay' for get() method, use getLong() instead");
                throw object;
            }
            case 2: {
                return this.d / 1000;
            }
            case 1: {
                object = new y("Invalid field 'NanoOfDay' for get() method, use getLong() instead");
                throw object;
            }
            case 0: 
        }
        return this.d;
    }

    public int C() {
        return this.d;
    }

    public int D() {
        return this.c;
    }

    public f P(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        int n10 = (int)(l10 % (long)24);
        byte by2 = this.a;
        n10 = (n10 + by2 + 24) % 24;
        by2 = this.b;
        object = this.c;
        int n11 = this.d;
        return j$.time.f.n(n10, by2, (int)object, n11);
    }

    public f Q(long l10) {
        int n10;
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        object = this.a * 60;
        int n11 = this.b;
        long l13 = 1440L;
        if ((object += n11) == (n10 = ((int)(l10 %= l13) + object + 1440) % 1440)) {
            return this;
        }
        int n12 = n10 / 60;
        object = this.c;
        n11 = this.d;
        return j$.time.f.n(n12, n10 %= 60, (int)object, n11);
    }

    public f R(long l10) {
        long l11;
        long l12 = 0L;
        long l13 = l10 - l12;
        Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        l12 = this.T();
        long l14 = l12 - (l10 = (l10 % (l11 = 86400000000000L) + l12 + l11) % l11);
        object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        object = (int)(l10 / 3600000000000L);
        long l15 = l10 / 60000000000L;
        long l16 = 60;
        int n10 = (int)(l15 % l16);
        long l17 = 1000000000L;
        int n11 = (int)(l10 / l17 % l16);
        int n12 = (int)(l10 % l17);
        return j$.time.f.n((int)object, n10, n11, n12);
    }

    public f S(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object == false) {
            return this;
        }
        object = this.a * 3600;
        int n10 = this.b * 60 + object;
        object = this.c;
        long l13 = 86400L;
        int n11 = (int)(l10 %= l13) + (n10 += object);
        int n12 = 86400;
        if (n10 == (n11 = (n11 + n12) % n12)) {
            return this;
        }
        n12 = n11 / 3600;
        object = n11 / 60 % 60;
        n10 = this.d;
        return j$.time.f.n(n12, (int)object, n11 %= 60, n10);
    }

    public long T() {
        long l10 = (long)this.a * 3600000000000L;
        long l11 = (long)this.b * 60000000000L + l10;
        l10 = (long)this.c * 1000000000L + l11;
        l11 = this.d;
        return l10 + l11;
    }

    public int U() {
        int n10 = this.a * 3600;
        int n11 = this.b * 60 + n10;
        n10 = this.c;
        return n11 + n10;
    }

    /*
     * Unable to fully structure code
     */
    public f V(u var1_1, long var2_2) {
        block23: {
            block22: {
                block24: {
                    var4_3 = var1_1 instanceof h;
                    if (var4_3 == 0) break block22;
                    var5_4 = var1_1;
                    var5_4 = (h)var1_1;
                    var5_4.P(var2_2);
                    var4_3 = var5_4.ordinal();
                    var6_5 = 0L;
                    var8_6 = 12;
                    switch (var4_3) {
                        default: {
                            var11_10 = new StringBuilder();
                            var11_10.append("Unsupported field: ");
                            var11_10.append(var1_1);
                            var1_1 = var11_10.toString();
                            var10_7 = new y((String)var1_1);
                            throw var10_7;
                        }
                        case 14: {
                            var12_11 = this.a / 12;
                            var13_19 = var12_11;
                            var2_2 = (var2_2 - var13_19) * var8_6;
                            ** GOTO lbl42
                        }
                        case 13: {
                            var8_6 = 24;
                            var12_12 = (int)(var2_2 == var8_6 ? 0 : (var2_2 < var8_6 ? -1 : 1));
                            if (var12_12 == 0) {
                                var2_2 = var6_5;
                            }
                        }
                        case 12: {
                            var12_12 = (int)var2_2;
                            var1_1 = this.W(var12_12);
                            break block23;
                        }
                        case 11: {
                            var12_13 = var2_2 == var8_6 ? 0 : (var2_2 < var8_6 ? -1 : 1);
                            if (var12_13 == false) {
                                var2_2 = var6_5;
                            }
                        }
                        case 10: {
                            var12_13 = this.a % 12;
                            var13_20 = var12_13;
                            var2_2 -= var13_20;
lbl42:
                            // 2 sources

                            var1_1 = this.P(var2_2);
                            break block23;
                        }
                        case 9: {
                            var12_14 = this.a * 60;
                            var4_3 = this.b;
                            var13_21 = var12_14 += var4_3;
                            var1_1 = this.Q(var2_2 -= var13_21);
                            break block23;
                        }
                        case 8: {
                            var12_15 = (int)var2_2;
                            var15_26 = this.b;
                            if (var15_26 == var12_15) {
                                while (true) {
                                    var1_1 = this;
                                    ** GOTO lbl109
                                    break;
                                }
                            } else {
                                var10_8 = h.m;
                                var13_22 = var12_15;
                                var10_8.P(var13_22);
                                var15_26 = this.a;
                                var16_29 = this.c;
                                var4_3 = this.d;
                                var1_1 = j$.time.f.n(var15_26, var12_15, var16_29, var4_3);
                            }
                            break block23;
                        }
                        case 7: {
                            var12_16 = this.U();
                            var13_23 = var12_16;
                            var1_1 = this.S(var2_2 -= var13_23);
                            break block23;
                        }
                        case 6: {
                            var12_17 = (int)var2_2;
                            var15_27 = this.c;
                            if (var15_27 == var12_17) ** continue;
                            var10_9 = h.k;
                            var13_24 = var12_17;
                            var10_9.P(var13_24);
                            var15_27 = this.a;
                            var16_30 = this.b;
                            var4_3 = this.d;
                            var1_1 = j$.time.f.n(var15_27, var16_30, var12_17, var4_3);
                            break block23;
                        }
                        case 5: {
                            var13_25 = 1000000L;
                            ** GOTO lbl94
                        }
                        case 4: {
                            var12_18 = (int)var2_2;
                            var15_28 = 1000000;
                            var12_18 *= var15_28;
                            break block24;
                        }
                        case 3: {
                            var13_25 = 1000L;
lbl94:
                            // 2 sources

                            var2_2 *= var13_25;
                            ** GOTO lbl99
                        }
                        case 2: {
                            var12_18 = (int)var2_2 * 1000;
                            break block24;
                        }
lbl99:
                        // 2 sources

                        case 1: {
                            var1_1 = j$.time.f.O(var2_2);
                            break block23;
                        }
                        case 0: 
                    }
                    var12_18 = (int)var2_2;
                }
                var1_1 = this.X(var12_18);
                break block23;
            }
            var1_1 = (f)var1_1.n(this, var2_2);
        }
        return var1_1;
    }

    public f W(int n10) {
        byte by2 = this.a;
        if (by2 == n10) {
            return this;
        }
        h h10 = h.q;
        long l10 = n10;
        h10.P(l10);
        by2 = this.b;
        byte by3 = this.c;
        int n11 = this.d;
        return j$.time.f.n(n10, by2, by3, n11);
    }

    public f X(int n10) {
        int n11 = this.d;
        if (n11 == n10) {
            return this;
        }
        h h10 = h.e;
        long l10 = n10;
        h10.P(l10);
        n11 = this.a;
        byte by2 = this.b;
        byte by3 = this.c;
        return j$.time.f.n(n11, by2, by3, n10);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public r a(long var1_1, x var3_2) {
        block10: {
            block9: {
                var4_3 = var3_2 instanceof i;
                if (var4_3 == 0) break block9;
                var5_4 = var3_2;
                var5_4 = (i)var3_2;
                var4_3 = var5_4.ordinal();
                switch (var4_3) {
                    default: {
                        var7_7 /* !! */  = new StringBuilder();
                        var7_7 /* !! */ .append("Unsupported unit: ");
                        var7_7 /* !! */ .append(var3_2);
                        var7_7 /* !! */  = var7_7 /* !! */ .toString();
                        var6_5 = new y((String)var7_7 /* !! */ );
                        throw var6_5;
                    }
                    case 6: {
                        var1_1 %= (long)2;
                        var8_8 = 12;
                        var1_1 *= var8_8;
                    }
                    case 5: {
                        var6_6 = this.P(var1_1);
                        break block10;
                    }
                    case 4: {
                        var6_6 = this.Q(var1_1);
                        break block10;
                    }
                    case 3: {
                        var6_6 = this.S(var1_1);
                        break block10;
                    }
                    case 2: {
                        var1_1 %= 86400000L;
                        var8_9 = 1000000L;
                        ** GOTO lbl36
                    }
                    case 1: {
                        var1_1 %= 86400000000L;
                        var8_9 = 1000L;
lbl36:
                        // 2 sources

                        var1_1 *= var8_9;
                    }
                    case 0: 
                }
                var6_6 = this.R(var1_1);
                break block10;
            }
            var6_6 = (f)var3_2.n(this, var1_1);
        }
        return var6_6;
    }

    public r b(t object) {
        boolean bl2 = object instanceof f;
        if (!bl2) {
            object = object.e(this);
        }
        return (f)object;
    }

    public Object d(w w10) {
        w w11 = b_0.a;
        if (w10 != w11 && w10 != (w11 = j$.time.q.d.a) && w10 != (w11 = j$.time.q.g.a) && w10 != (w11 = j$.time.q.c.a)) {
            w11 = j$.time.q.f.a;
            if (w10 == w11) {
                return this;
            }
            w11 = a_0.a;
            if (w10 == w11) {
                return null;
            }
            w11 = j$.time.q.e.a;
            if (w10 == w11) {
                return i.b;
            }
            return w10.a(this);
        }
        return null;
    }

    public r e(r r10) {
        h h10 = h.f;
        long l10 = this.T();
        return r10.c(h10, l10);
    }

    public boolean equals(Object object) {
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof f;
        if (n10 != 0) {
            int n11;
            object = (f)object;
            n10 = this.a;
            byte by2 = ((f)object).a;
            if (n10 != by2 || (n10 = this.b) != (by2 = ((f)object).b) || (n10 = this.c) != (by2 = ((f)object).c) || (n10 = this.d) != (n11 = ((f)object).d)) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public boolean g(u u10) {
        boolean bl2;
        boolean bl3 = u10 instanceof h;
        if (bl3) {
            return u10.C();
        }
        if (u10 != null && (bl2 = u10.L(this))) {
            bl2 = true;
        } else {
            bl2 = false;
            u10 = null;
        }
        return bl2;
    }

    public long h(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            h h10 = h.f;
            if (u10 == h10) {
                return this.T();
            }
            h10 = h.h;
            if (u10 == h10) {
                return this.T() / 1000L;
            }
            return this.x(u10);
        }
        return u10.o(this);
    }

    public int hashCode() {
        long l10 = this.T();
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public z i(u u10) {
        return s.super.i(u10);
    }

    public int k(u u10) {
        boolean bl2 = u10 instanceof h;
        if (bl2) {
            return this.x(u10);
        }
        return s.super.k(u10);
    }

    public int m(f f10) {
        int n10 = this.a;
        byte by2 = f10.a;
        if ((n10 = Integer.compare(n10, by2)) == 0) {
            n10 = this.b;
            by2 = f10.b;
            if ((n10 = Integer.compare(n10, by2)) == 0) {
                n10 = this.c;
                by2 = f10.c;
                if ((n10 = Integer.compare(n10, by2)) == 0) {
                    n10 = this.d;
                    int n11 = f10.d;
                    n10 = Integer.compare(n10, n11);
                }
            }
        }
        return n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder(18);
        int n10 = this.a;
        int n11 = this.b;
        byte by2 = this.c;
        int n12 = this.d;
        int n13 = 10;
        String string2 = n10 < n13 ? "0" : "";
        stringBuilder.append(string2);
        stringBuilder.append(n10);
        String string3 = ":0";
        string2 = ":";
        String string4 = n11 < n13 ? string3 : string2;
        stringBuilder.append(string4);
        stringBuilder.append(n11);
        if (by2 <= 0) {
            if (n12 <= 0) return stringBuilder.toString();
        }
        if (by2 >= n13) {
            string3 = string2;
        }
        stringBuilder.append(string3);
        stringBuilder.append(by2);
        if (n12 <= 0) return stringBuilder.toString();
        stringBuilder.append('.');
        n10 = 1000000;
        n11 = n12 % n10;
        by2 = 1;
        if (n11 == 0) {
            n12 = n12 / n10 + 1000;
        } else {
            n11 = n12 % 1000;
            if (n11 == 0) {
                n12 /= 1000;
            } else {
                n10 = 1000000000;
            }
            n12 += n10;
        }
        string3 = Integer.toString(n12).substring(by2);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }
}

