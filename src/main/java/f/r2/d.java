/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.s.p;
import f.h2.s.r;
import f.h2.s.s;
import f.h2.t.f0;
import f.l2.q;
import f.r2.d$a;
import f.r2.e;
import f.r2.h;
import f.r2.i;
import f.r2.k;
import java.util.concurrent.TimeUnit;
import kotlin.text.StringsKt__StringsKt;

public final class d
implements Comparable {
    private static final double b;
    private static final double c;
    public static final d$a d;
    private final double a;

    static {
        d$a d$a;
        d = d$a = new d$a(null);
        b = f.r2.d.f(0.0);
        c = f.r2.d.f(1.0 / 0.0);
    }

    private /* synthetic */ d(double d10) {
        this.a = d10;
    }

    public static final int A(double d10) {
        d10 = f.r2.d.u(d10);
        double d11 = 60;
        return (int)(d10 % d11);
    }

    public static int B(double d10) {
        long l10 = Double.doubleToLongBits(d10);
        long l11 = l10 >>> 32;
        return (int)(l10 ^ l11);
    }

    public static final boolean C(double d10) {
        boolean bl2;
        boolean bl3 = Double.isInfinite(d10);
        bl2 = !bl3 && !(bl2 = Double.isNaN(d10));
        return bl2;
    }

    public static final boolean D(double d10) {
        return Double.isInfinite(d10);
    }

    public static final boolean F(double d10) {
        boolean bl2 = false;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static final boolean G(double d10) {
        boolean bl2 = false;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public static final double H(double d10, double d11) {
        return f.r2.d.f(d10 - d11);
    }

    public static final double I(double d10, double d11) {
        return f.r2.d.f(d10 + d11);
    }

    private static final int J(double d10, double d11) {
        int n10 = 1;
        double d12 = n10;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object < 0) {
            n10 = 3;
        } else {
            d12 = 10;
            double d14 = d11 - d12;
            object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
            if (object < 0) {
                n10 = 2;
            } else {
                d12 = 100;
                double d15 = d11 - d12;
                object = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
                if (object >= 0) {
                    n10 = 0;
                }
            }
        }
        return n10;
    }

    public static final double K(double d10, double d11) {
        return f.r2.d.f(d10 * d11);
    }

    public static final double L(double d10, int n10) {
        double d11 = n10;
        return f.r2.d.f(d10 * d11);
    }

    public static final Object M(double d10, p p10) {
        f0.p(p10, "action");
        Long l10 = (long)f.r2.d.u(d10);
        Integer n10 = f.r2.d.y(d10);
        return p10.invoke(l10, n10);
    }

    public static final Object N(double d10, f.h2.s.q q10) {
        f0.p(q10, "action");
        Integer n10 = (int)f.r2.d.s(d10);
        Integer n11 = f.r2.d.A(d10);
        Integer n12 = f.r2.d.y(d10);
        return q10.invoke(n10, n11, n12);
    }

    public static final Object P(double d10, r r10) {
        f0.p(r10, "action");
        Integer n10 = (int)f.r2.d.p(d10);
        Integer n11 = f.r2.d.w(d10);
        Integer n12 = f.r2.d.A(d10);
        Integer n13 = f.r2.d.y(d10);
        return r10.invoke(n10, n11, n12, n13);
    }

    public static final Object Q(double d10, s s10) {
        f0.p(s10, "action");
        Integer n10 = (int)f.r2.d.o(d10);
        Integer n11 = f.r2.d.n(d10);
        Integer n12 = f.r2.d.w(d10);
        Integer n13 = f.r2.d.A(d10);
        Integer n14 = f.r2.d.y(d10);
        return s10.invoke(n10, n11, n12, n13, n14);
    }

    public static final double R(double d10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        TimeUnit timeUnit2 = e.a();
        return h.b(d10, timeUnit2, timeUnit);
    }

    public static final int S(double d10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        return (int)f.r2.d.R(d10, timeUnit);
    }

    public static final String T(double d10) {
        String string2;
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = f.r2.d.F(d10);
        if (n10 != 0) {
            n10 = 45;
            stringBuilder.append((char)n10);
        }
        String string3 = "PT";
        stringBuilder.append(string3);
        d10 = f.r2.d.l(d10);
        double d11 = f.r2.d.p(d10);
        n10 = (int)d11;
        int c10 = f.r2.d.w(d10);
        int n11 = f.r2.d.A(d10);
        int n12 = f.r2.d.y(d10);
        char c11 = '\u0001';
        char c12 = n10 != 0 ? c11 : (char)'\u0000';
        char c13 = n11 == 0 && n12 == 0 ? (char)'\u0000' : c11;
        if (c10 == 0 && (c13 == '\u0000' || c12 == '\u0000')) {
            c11 = '\u0000';
            string2 = null;
        }
        if (c12 != '\u0000') {
            stringBuilder.append(n10);
            n10 = 72;
            stringBuilder.append((char)n10);
        }
        if (c11 != '\u0000') {
            stringBuilder.append(c10);
            n10 = 77;
            stringBuilder.append((char)n10);
        }
        if (c13 != '\u0000' || c12 == '\u0000' && c11 == '\u0000') {
            stringBuilder.append(n11);
            if (n12 != 0) {
                c11 = '.';
                stringBuilder.append(c11);
                string2 = String.valueOf(n12);
                char c14 = '0';
                string2 = StringsKt__StringsKt.L3(string2, 9, c14);
                n10 = n12 % 1000000;
                String string4 = "this.append(value, startIndex, endIndex)";
                if (n10 == 0) {
                    n12 = 3;
                    stringBuilder.append(string2, 0, n12);
                    f0.o(stringBuilder, string4);
                } else if ((n12 %= 1000) == 0) {
                    n12 = 6;
                    stringBuilder.append(string2, 0, n12);
                    f0.o(stringBuilder, string4);
                } else {
                    stringBuilder.append(string2);
                }
            }
            n12 = 83;
            stringBuilder.append((char)n12);
        }
        String string5 = stringBuilder.toString();
        f0.o(string5, "StringBuilder().apply(builderAction).toString()");
        return string5;
    }

    public static final long U(double d10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        return (long)f.r2.d.R(d10, timeUnit);
    }

    public static final long V(double d10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return f.r2.d.U(d10, timeUnit);
    }

    public static final long W(double d10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return f.r2.d.U(d10, timeUnit);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String X(double var0) {
        block11: {
            block9: {
                block18: {
                    block17: {
                        block16: {
                            block15: {
                                block14: {
                                    block13: {
                                        block12: {
                                            block10: {
                                                var2_1 /* !! */  = f.r2.d.D(var0);
                                                if (var2_1 /* !! */  == 0) break block10;
                                                var3_2 = String.valueOf(var0);
                                                break block11;
                                            }
                                            var4_3 = 0.0;
                                            cfr_temp_0 = var0 - var4_3;
                                            var2_1 /* !! */  = (int)(cfr_temp_0 == 0.0 ? 0 : (cfr_temp_0 < 0.0 ? -1 : 1));
                                            if (var2_1 /* !! */  != 0) break block12;
                                            var3_2 = "0s";
                                            break block11;
                                        }
                                        var4_3 = f.r2.d.t(f.r2.d.l(var0));
                                        var6_4 = 1.0E-6;
                                        var8_5 /* !! */  = var4_3 == var6_4 ? 0 : (var4_3 < var6_4 ? -1 : 1);
                                        var9_6 = false;
                                        var10_7 = true;
                                        if (var8_5 /* !! */  < 0) {
                                            var11_8 = TimeUnit.SECONDS;
lbl20:
                                            // 2 sources

                                            while (true) {
                                                var12_9 = 0;
                                                var9_6 = var10_7;
                                                break block9;
                                                break;
                                            }
                                        }
                                        var13_10 = (double)var10_7;
                                        cfr_temp_1 = var4_3 - var13_10;
                                        var8_5 /* !! */  = (double)(cfr_temp_1 == 0.0 ? 0 : (cfr_temp_1 < 0.0 ? -1 : 1));
                                        if (var8_5 /* !! */  >= 0) break block13;
                                        var11_8 = TimeUnit.NANOSECONDS;
                                        var12_9 = 7;
                                        break block9;
                                    }
                                    var13_10 = 1000.0;
                                    cfr_temp_2 = var4_3 - var13_10;
                                    var8_5 /* !! */  = (double)(cfr_temp_2 == 0.0 ? 0 : (cfr_temp_2 < 0.0 ? -1 : 1));
                                    if (var8_5 /* !! */  < 0) {
                                        var11_8 = TimeUnit.NANOSECONDS;
lbl37:
                                        // 7 sources

                                        while (true) {
                                            var12_9 = 0;
                                            break block9;
                                            break;
                                        }
                                    }
                                    var13_10 = 1000000.0;
                                    cfr_temp_3 = var4_3 - var13_10;
                                    var8_5 /* !! */  = (double)(cfr_temp_3 == 0.0 ? 0 : (cfr_temp_3 < 0.0 ? -1 : 1));
                                    if (var8_5 /* !! */  >= 0) break block14;
                                    var11_8 = TimeUnit.MICROSECONDS;
                                    ** GOTO lbl37
                                }
                                var13_10 = 1.0E9;
                                cfr_temp_4 = var4_3 - var13_10;
                                var8_5 /* !! */  = (double)(cfr_temp_4 == 0.0 ? 0 : (cfr_temp_4 < 0.0 ? -1 : 1));
                                if (var8_5 /* !! */  >= 0) break block15;
                                var11_8 = TimeUnit.MILLISECONDS;
                                ** GOTO lbl37
                            }
                            var13_10 = 1.0E12;
                            cfr_temp_5 = var4_3 - var13_10;
                            var8_5 /* !! */  = (double)(cfr_temp_5 == 0.0 ? 0 : (cfr_temp_5 < 0.0 ? -1 : 1));
                            if (var8_5 /* !! */  >= 0) break block16;
                            var11_8 = TimeUnit.SECONDS;
                            ** GOTO lbl37
                        }
                        var13_10 = 6.0E13;
                        cfr_temp_6 = var4_3 - var13_10;
                        var8_5 /* !! */  = (double)(cfr_temp_6 == 0.0 ? 0 : (cfr_temp_6 < 0.0 ? -1 : 1));
                        if (var8_5 /* !! */  >= 0) break block17;
                        var11_8 = TimeUnit.MINUTES;
                        ** GOTO lbl37
                    }
                    var13_10 = 3.6E15;
                    cfr_temp_7 = var4_3 - var13_10;
                    var8_5 /* !! */  = (double)(cfr_temp_7 == 0.0 ? 0 : (cfr_temp_7 < 0.0 ? -1 : 1));
                    if (var8_5 /* !! */  >= 0) break block18;
                    var11_8 = TimeUnit.HOURS;
                    ** GOTO lbl37
                }
                var13_10 = 8.64E20;
                cfr_temp_8 = var4_3 - var13_10;
                var2_1 /* !! */  = (int)(cfr_temp_8 == 0.0 ? 0 : (cfr_temp_8 < 0.0 ? -1 : 1));
                if (var2_1 /* !! */  < 0) {
                    var11_8 = TimeUnit.DAYS;
                    ** continue;
                }
                var11_8 = TimeUnit.DAYS;
                ** while (true)
            }
            var15_11 = f.r2.d.R(var0, var11_8);
            var17_12 = new StringBuilder();
            if (var9_6) {
                var3_2 = k.b(var15_11);
            } else if (var12_9 > 0) {
                var3_2 = k.d(var15_11, var12_9);
            } else {
                var18_13 = Math.abs(var15_11);
                var20_14 = f.r2.d.J(var0, var18_13);
                var3_2 = k.c(var15_11, var20_14);
            }
            var17_12.append(var3_2);
            var3_2 = i.c(var11_8);
            var17_12.append(var3_2);
            var3_2 = var17_12.toString();
        }
        return var3_2;
    }

    public static final String Y(double d10, TimeUnit timeUnit, int n10) {
        boolean bl2;
        CharSequence charSequence = "unit";
        f0.p((Object)timeUnit, (String)charSequence);
        if (n10 >= 0) {
            bl2 = true;
        } else {
            bl2 = false;
            charSequence = null;
        }
        if (bl2) {
            String string2;
            double d11;
            bl2 = f.r2.d.D(d10);
            if (bl2) {
                return String.valueOf(d10);
            }
            d10 = f.r2.d.R(d10, timeUnit);
            charSequence = new StringBuilder();
            double d12 = Math.abs(d10);
            double d13 = d12 - (d11 = 1.0E14);
            Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
            if (object < 0) {
                object = 12;
                n10 = q.u(n10, (int)object);
                string2 = k.c(d10, n10);
            } else {
                string2 = k.b(d10);
            }
            ((StringBuilder)charSequence).append(string2);
            string2 = i.c(timeUnit);
            ((StringBuilder)charSequence).append(string2);
            return ((StringBuilder)charSequence).toString();
        }
        CharSequence charSequence2 = new StringBuilder();
        ((StringBuilder)charSequence2).append("decimals must be not negative, but was ");
        ((StringBuilder)charSequence2).append(n10);
        charSequence2 = ((StringBuilder)charSequence2).toString();
        charSequence2 = ((Object)charSequence2).toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException((String)charSequence2);
        throw illegalArgumentException;
    }

    public static /* synthetic */ String Z(double d10, TimeUnit timeUnit, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return f.r2.d.Y(d10, timeUnit, n10);
    }

    public static final /* synthetic */ double a() {
        return c;
    }

    public static final double a0(double d10) {
        return f.r2.d.f(-d10);
    }

    public static final /* synthetic */ double b() {
        return b;
    }

    public static final /* synthetic */ d c(double d10) {
        d d11 = new d(d10);
        return d11;
    }

    public static int e(double d10, double d11) {
        return Double.compare(d10, d11);
    }

    public static double f(double d10) {
        return d10;
    }

    public static final double g(double d10, double d11) {
        return d10 / d11;
    }

    public static final double h(double d10, double d11) {
        return f.r2.d.f(d10 / d11);
    }

    public static final double i(double d10, int n10) {
        double d11 = n10;
        return f.r2.d.f(d10 / d11);
    }

    public static boolean j(double d10, Object object) {
        double d11;
        int n10;
        boolean bl2 = object instanceof d;
        return bl2 && (n10 = Double.compare(d10, d11 = ((d)(object = (d)object)).b0())) == 0;
    }

    public static final boolean k(double d10, double d11) {
        int n10 = Double.compare(d10, d11);
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public static final double l(double d10) {
        boolean bl2 = f.r2.d.F(d10);
        if (bl2) {
            d10 = f.r2.d.a0(d10);
        }
        return d10;
    }

    public static /* synthetic */ void m() {
    }

    public static final int n(double d10) {
        d10 = f.r2.d.p(d10);
        double d11 = 24;
        return (int)(d10 % d11);
    }

    public static final double o(double d10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double p(double d10) {
        TimeUnit timeUnit = TimeUnit.HOURS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double q(double d10) {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double r(double d10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double s(double d10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double t(double d10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static final double u(double d10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return f.r2.d.R(d10, timeUnit);
    }

    public static /* synthetic */ void v() {
    }

    public static final int w(double d10) {
        d10 = f.r2.d.s(d10);
        double d11 = 60;
        return (int)(d10 % d11);
    }

    public static /* synthetic */ void x() {
    }

    public static final int y(double d10) {
        return (int)(f.r2.d.t(d10) % 1.0E9);
    }

    public static /* synthetic */ void z() {
    }

    public final /* synthetic */ double b0() {
        return this.a;
    }

    public int d(double d10) {
        return f.r2.d.e(this.a, d10);
    }

    public boolean equals(Object object) {
        return f.r2.d.j(this.a, object);
    }

    public int hashCode() {
        return f.r2.d.B(this.a);
    }

    public String toString() {
        return f.r2.d.X(this.a);
    }
}

