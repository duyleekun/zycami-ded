/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import g.h0.a;
import g.h0.d;
import g.l;
import g.s;
import g.t;
import java.util.ArrayList;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.TimeZone;
import java.util.regex.Pattern;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt__StringsKt;
import okhttp3.internal.publicsuffix.PublicSuffixDatabase;

public final class l$b {
    private l$b() {
    }

    public /* synthetic */ l$b(f.h2.t.u u10) {
        this();
    }

    public static final /* synthetic */ boolean a(l$b l$b, String string2, String string3) {
        return l$b.d(string2, string3);
    }

    public static final /* synthetic */ boolean b(l$b l$b, t t10, String string2) {
        return l$b.k(t10, string2);
    }

    /*
     * Unable to fully structure code
     */
    private final int c(String var1_1, int var2_2, int var3_3, boolean var4_4) {
        while (var2_2 < var3_3) {
            var5_5 = var1_1.charAt(var2_2);
            var6_6 = 32;
            var7_7 = 1;
            if (var5_5 < var6_6 && var5_5 != (var6_6 = 9) || var5_5 >= (var6_6 = 127)) ** GOTO lbl-1000
            var6_6 = 57;
            var8_8 = 48;
            if (var8_8 <= var5_5 && var6_6 >= var5_5) ** GOTO lbl-1000
            var6_6 = 122;
            var8_8 = 97;
            if (var8_8 <= var5_5 && var6_6 >= var5_5) ** GOTO lbl-1000
            var6_6 = 90;
            var8_8 = 65;
            if ((var8_8 > var5_5 || var6_6 < var5_5) && var5_5 != (var6_6 = 58)) {
                var5_5 = 0;
            } else lbl-1000:
            // 4 sources

            {
                var5_5 = var7_7;
            }
            var6_6 = var4_4 ^ 1;
            if (var5_5 == var6_6) {
                return var2_2;
            }
            ++var2_2;
        }
        return var3_3;
    }

    private final boolean d(String string2, String string3) {
        int n10;
        block5: {
            block4: {
                boolean bl2;
                int n11 = f0.g(string2, string3);
                n10 = 1;
                if (n11 != 0) {
                    return n10 != 0;
                }
                n11 = u.H1(string2, string3, false, 2, null);
                if (n11 == 0) break block4;
                n11 = string2.length();
                int n12 = string3.length();
                n11 = n11 - n12 - n10;
                n12 = string2.charAt(n11);
                if (n12 == (n11 = 46) && !(bl2 = d.h(string2))) break block5;
            }
            n10 = 0;
        }
        return n10 != 0;
    }

    private final String h(String object) {
        String string2 = ".";
        int n10 = 2;
        boolean bl2 = u.H1((String)object, string2, false, n10, null) ^ true;
        if (bl2) {
            if ((object = a.e(StringsKt__StringsKt.U3((String)object, string2))) != null) {
                return object;
            }
            object = new IllegalArgumentException();
            throw object;
        }
        string2 = "Failed requirement.".toString();
        object = new IllegalArgumentException(string2);
        throw object;
    }

    /*
     * Unable to fully structure code
     */
    private final long i(String var1_1, int var2_2, int var3_3) {
        var4_4 = this;
        var5_5 = var1_1;
        var6_6 = var3_3;
        var7_7 = 0;
        var8_8 = null;
        var9_9 = var2_2;
        var9_9 = this.c(var1_1, var2_2, var3_3, false);
        var10_10 = l.l().matcher(var1_1);
        var12_12 = var11_11 = -1;
        var13_13 = var11_11;
        var14_14 = var11_11;
        var15_15 = var11_11;
        var16_16 = var11_11;
        var17_17 = var11_11;
        while (true) {
            block26: {
                block27: {
                    block25: {
                        var18_18 = 2;
                        var19_19 = 1;
                        if (var9_9 >= var6_6) break;
                        var20_20 = var9_9 + 1;
                        var20_20 = var4_4.c((String)var5_5, var20_20, var6_6, (boolean)var19_19);
                        var10_10.region(var9_9, var20_20);
                        var21_21 = "matcher.group(1)";
                        if (var13_13 != var11_11) break block25;
                        var8_8 = l.l();
                        var7_7 = (var8_8 = var10_10.usePattern((Pattern)var8_8)).matches();
                        if (var7_7 == 0) break block25;
                        var8_8 = var10_10.group(var19_19);
                        f0.o(var8_8, (String)var21_21);
                        var13_13 = Integer.parseInt((String)var8_8);
                        var8_8 = var10_10.group(var18_18);
                        f0.o(var8_8, "matcher.group(2)");
                        var16_16 = Integer.parseInt((String)var8_8);
                        var7_7 = 3;
                        var8_8 = var10_10.group(var7_7);
                        var21_21 = "matcher.group(3)";
                        f0.o(var8_8, (String)var21_21);
                        var17_17 = Integer.parseInt((String)var8_8);
                        break block26;
                    }
                    if (var14_14 != var11_11) break block27;
                    var8_8 = l.j();
                    var7_7 = (var8_8 = var10_10.usePattern((Pattern)var8_8)).matches();
                    if (var7_7 == 0) break block27;
                    var8_8 = var10_10.group(var19_19);
                    f0.o(var8_8, (String)var21_21);
                    var14_14 = Integer.parseInt((String)var8_8);
                    break block26;
                }
                if (var15_15 != var11_11) ** GOTO lbl-1000
                var8_8 = l.k();
                var7_7 = (var8_8 = var10_10.usePattern((Pattern)var8_8)).matches();
                if (var7_7 != 0) {
                    var8_8 = var10_10.group(var19_19);
                    f0.o(var8_8, (String)var21_21);
                    var21_21 = Locale.US;
                    f0.o(var21_21, "Locale.US");
                    Objects.requireNonNull(var8_8, "null cannot be cast to non-null type java.lang.String");
                    var8_8 = var8_8.toLowerCase((Locale)var21_21);
                    f0.o(var8_8, "(this as java.lang.String).toLowerCase(locale)");
                    var21_21 = l.k().pattern();
                    var22_22 = "MONTH_PATTERN.pattern()";
                    f0.o(var21_21, var22_22);
                    var23_23 = 6;
                    var7_7 = StringsKt__StringsKt.j3((CharSequence)var21_21, (String)var8_8, 0, false, var23_23, null);
                    var15_15 = var7_7 / 4;
                } else if (var12_12 == var11_11) {
                    var8_8 = l.m();
                    var7_7 = (var8_8 = var10_10.usePattern((Pattern)var8_8)).matches();
                    if (var7_7 != 0) {
                        var8_8 = var10_10.group(var19_19);
                        f0.o(var8_8, (String)var21_21);
                        var12_12 = Integer.parseInt((String)var8_8);
                    }
                }
            }
            var7_7 = 0;
            var8_8 = null;
            var9_9 = var4_4.c((String)var5_5, ++var20_20, var6_6, false);
        }
        var24_24 = 99;
        var6_6 = 70;
        if (var6_6 <= var12_12 && var24_24 >= var12_12) {
            var12_12 += 1900;
        }
        var24_24 = 69;
        if (var12_12 >= 0 && var24_24 >= var12_12) {
            var12_12 += 2000;
        }
        if (var12_12 >= (var24_24 = 1601)) {
            var24_24 = var19_19;
        } else {
            var24_24 = 0;
            var5_5 = null;
        }
        var25_25 = "Failed requirement.";
        if (var24_24 != 0) {
            if (var15_15 != var11_11) {
                var24_24 = var19_19;
            } else {
                var24_24 = 0;
                var5_5 = null;
            }
            if (var24_24 != 0) {
                var24_24 = 31;
                if (var19_19 <= var14_14 && var24_24 >= var14_14) {
                    var24_24 = var19_19;
                } else {
                    var24_24 = 0;
                    var5_5 = null;
                }
                if (var24_24 != 0) {
                    var24_24 = 23;
                    if (var13_13 >= 0 && var24_24 >= var13_13) {
                        var24_24 = var19_19;
                    } else {
                        var24_24 = 0;
                        var5_5 = null;
                    }
                    if (var24_24 != 0) {
                        var24_24 = 59;
                        if (var16_16 >= 0 && var24_24 >= var16_16) {
                            var7_7 = var19_19;
                        } else {
                            var7_7 = 0;
                            var8_8 = null;
                        }
                        if (var7_7 != 0) {
                            if (var17_17 >= 0 && var24_24 >= var17_17) {
                                var24_24 = var19_19;
                            } else {
                                var24_24 = 0;
                                var5_5 = null;
                            }
                            if (var24_24 != 0) {
                                var25_25 = d.f;
                                var5_5 = new GregorianCalendar((TimeZone)var25_25);
                                var5_5.setLenient(false);
                                var5_5.set(var19_19, var12_12);
                                var5_5.set(var18_18, var15_15 -= var19_19);
                                var5_5.set(5, var14_14);
                                var5_5.set(11, var13_13);
                                var5_5.set(12, var16_16);
                                var5_5.set(13, var17_17);
                                var5_5.set(14, 0);
                                return var5_5.getTimeInMillis();
                            }
                            var25_25 = var25_25.toString();
                            var5_5 = new IllegalArgumentException((String)var25_25);
                            throw var5_5;
                        }
                        var25_25 = var25_25.toString();
                        var5_5 = new IllegalArgumentException((String)var25_25);
                        throw var5_5;
                    }
                    var25_25 = var25_25.toString();
                    var5_5 = new IllegalArgumentException((String)var25_25);
                    throw var5_5;
                }
                var25_25 = var25_25.toString();
                var5_5 = new IllegalArgumentException((String)var25_25);
                throw var5_5;
            }
            var25_25 = var25_25.toString();
            var5_5 = new IllegalArgumentException((String)var25_25);
            throw var5_5;
        }
        var25_25 = var25_25.toString();
        var5_5 = new IllegalArgumentException((String)var25_25);
        throw var5_5;
    }

    private final long j(String string2) {
        long l10 = Long.MIN_VALUE;
        try {
            long l11 = Long.parseLong(string2);
            long l12 = 0L;
            long l13 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1);
            if (l13 > 0) {
                l10 = l11;
            }
            return l10;
        }
        catch (NumberFormatException numberFormatException) {
            String string3 = "-?\\d+";
            Regex regex = new Regex(string3);
            int n10 = regex.matches(string2);
            if (n10 != 0) {
                Object var9_8 = null;
                n10 = 2;
                string3 = null;
                String string4 = "-";
                boolean bl2 = u.q2(string2, string4, false, n10, null);
                if (!bl2) {
                    l10 = Long.MAX_VALUE;
                }
                return l10;
            }
            throw numberFormatException;
        }
    }

    private final boolean k(t object, String string2) {
        object = ((t)object).x();
        boolean bl2 = f0.g(object, string2);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        bl2 = false;
        int n10 = 2;
        boolean bl4 = u.q2((String)object, string2, false, n10, null);
        if (bl4) {
            String string3 = "/";
            if ((n10 = (int)(u.H1(string2, string3, false, n10, null) ? 1 : 0)) != 0) {
                return bl3;
            }
            int n11 = string2.length();
            char c10 = ((String)object).charAt(n11);
            if (c10 == (n11 = 47)) {
                return bl3;
            }
        }
        return false;
    }

    public final l e(t t10, String string2) {
        f0.p(t10, "url");
        f0.p(string2, "setCookie");
        long l10 = System.currentTimeMillis();
        return this.f(l10, t10, string2);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final l f(long l10, t t10, String string2) {
        l$b l$b = this;
        String string3 = string2;
        f0.p(t10, "url");
        f0.p(string2, "setCookie");
        int n10 = 0;
        Object object = string2;
        int n11 = d.r(string2, ';', 0, 0, 6, null);
        int n12 = 2;
        int n13 = n11;
        int n14 = d.r(string2, '=', 0, n11, n12, null);
        int n15 = 0;
        String string4 = null;
        if (n14 == n11) {
            return null;
        }
        n13 = 1;
        String string5 = d.h0(string2, 0, n14, n13, null);
        n12 = string5.length();
        n12 = n12 == 0 ? n13 : 0;
        if (n12 != 0) return null;
        n12 = d.B(string5);
        if (n12 != (n10 = -1)) {
            return null;
        }
        n14 += n13;
        String string6 = d.g0(string3, n14, n11);
        if ((n14 = d.B(string6)) != n10) {
            return null;
        }
        n11 += n13;
        n14 = string2.length();
        long l11 = -1;
        Object object2 = null;
        Object object3 = null;
        int n16 = 0;
        int n17 = 0;
        int n18 = 0;
        int n19 = n13;
        long l12 = l11;
        long l13 = 253402300799999L;
        while (true) {
            block23: {
                Object object4;
                String string7;
                long l14;
                block31: {
                    block28: {
                        long l15;
                        block30: {
                            block29: {
                                long l16;
                                block27: {
                                    block24: {
                                        String string8;
                                        String string9;
                                        int n20;
                                        block26: {
                                            boolean bl2;
                                            String string10;
                                            block25: {
                                                block22: {
                                                    if (n11 >= n14) break block24;
                                                    n15 = d.p(string3, ';', n11, n14);
                                                    n20 = d.p(string3, '=', n11, n15);
                                                    string9 = d.g0(string3, n11, n20);
                                                    string8 = n20 < n15 ? d.g0(string3, ++n20, n15) : "";
                                                    string10 = "expires";
                                                    bl2 = u.I1(string9, string10, n13 != 0);
                                                    if (bl2) {
                                                        n11 = string8.length();
                                                        l13 = l$b.i(string8, 0, n11);
                                                        break block22;
                                                    }
                                                    string10 = "max-age";
                                                    bl2 = u.I1(string9, string10, n13 != 0);
                                                    if (!bl2) break block25;
                                                    try {
                                                        l12 = l$b.j(string8);
                                                    }
                                                    catch (IllegalArgumentException | NumberFormatException illegalArgumentException) {}
                                                }
                                                n18 = n13;
                                                break block23;
                                            }
                                            string10 = "domain";
                                            bl2 = u.I1(string9, string10, n13 != 0);
                                            if (bl2) {
                                                object2 = l$b.h(string8);
                                                n19 = 0;
                                                break block23;
                                            }
                                            string10 = "path";
                                            bl2 = u.I1(string9, string10, n13 != 0);
                                            if (!bl2) break block26;
                                            object3 = string8;
                                            break block23;
                                        }
                                        string8 = "secure";
                                        n20 = (int)(u.I1(string9, string8, n13 != 0) ? 1 : 0);
                                        if (n20 != 0) {
                                            n16 = n13;
                                            break block23;
                                        } else {
                                            string8 = "httponly";
                                            n11 = u.I1(string9, string8, n13 != 0);
                                            if (n11 != 0) {
                                                n17 = n13;
                                            }
                                        }
                                        break block23;
                                    }
                                    l16 = Long.MIN_VALUE;
                                    long l17 = l12 - l16;
                                    n13 = (int)(l17 == 0L ? 0 : (l17 < 0L ? -1 : 1));
                                    if (n13 == 0) break block27;
                                    n14 = (int)(l12 == l11 ? 0 : (l12 < l11 ? -1 : 1));
                                    if (n14 == 0) break block28;
                                    l16 = 9223372036854775L;
                                    long l18 = l12 - l16;
                                    n14 = (int)(l18 == 0L ? 0 : (l18 < 0L ? -1 : 1));
                                    if (n14 <= 0) {
                                        n14 = 1000;
                                        l16 = n14;
                                        l12 *= l16;
                                    } else {
                                        l12 = Long.MAX_VALUE;
                                    }
                                    l16 = l10 + l12;
                                    n13 = (int)(l16 == l10 ? 0 : (l16 < l10 ? -1 : 1));
                                    if (n13 < 0) break block29;
                                    l15 = 253402300799999L;
                                    long l19 = l16 - l15;
                                    n10 = (int)(l19 == 0L ? 0 : (l19 < 0L ? -1 : 1));
                                    if (n10 > 0) break block30;
                                }
                                l14 = l16;
                                break block31;
                            }
                            l15 = 253402300799999L;
                        }
                        l14 = l15;
                        break block31;
                    }
                    l14 = l13;
                }
                object = t10.F();
                if (object2 == null) {
                    string7 = object;
                    n15 = 0;
                    string4 = null;
                } else {
                    n15 = (int)(l$b.d((String)object, (String)object2) ? 1 : 0);
                    if (n15 == 0) {
                        return null;
                    }
                    n15 = 0;
                    string4 = null;
                    string7 = object2;
                }
                n14 = ((String)object).length();
                n13 = string7.length();
                if (n14 != n13 && (object = PublicSuffixDatabase.j.c().e(string7)) == null) {
                    return null;
                }
                object = "/";
                if (object3 != null && (n15 = (int)(u.q2(object3, (String)object, false, n12 = 2, null) ? 1 : 0)) != 0) {
                    object4 = object3;
                } else {
                    string4 = t10.x();
                    n10 = 47;
                    string3 = null;
                    n11 = 6;
                    object2 = null;
                    n13 = StringsKt__StringsKt.w3(string4, (char)n10, 0, false, n11, null);
                    if (n13 != 0) {
                        Objects.requireNonNull(string4, "null cannot be cast to non-null type java.lang.String");
                        object = string4.substring(0, n13);
                        string4 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                        f0.o(object, string4);
                    }
                    object4 = object;
                }
                object2 = object;
                return new l(string5, string6, l14, string7, (String)object4, n16 != 0, n17 != 0, n18 != 0, n19 != 0, null);
            }
            n11 = n15 + 1;
            n15 = 0;
            string4 = null;
        }
    }

    public final List g(t list, s object) {
        f0.p(list, "url");
        f0.p(object, "headers");
        String string2 = "Set-Cookie";
        object = ((s)object).o(string2);
        int n10 = object.size();
        ArrayList<Object> arrayList = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object2 = (String)object.get(i10);
            if ((object2 = this.e((t)((Object)list), (String)object2)) == null) continue;
            if (arrayList == null) {
                arrayList = new ArrayList<Object>();
            }
            arrayList.add(object2);
        }
        if (arrayList != null) {
            list = Collections.unmodifiableList(arrayList);
            object = "Collections.unmodifiableList(cookies)";
            f0.o(list, (String)object);
        } else {
            list = CollectionsKt__CollectionsKt.E();
        }
        return list;
    }
}

