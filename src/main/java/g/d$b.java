/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import f.q2.u;
import g.d;
import g.s;
import java.util.Objects;
import kotlin.text.StringsKt__StringsKt;

public final class d$b {
    private d$b() {
    }

    public /* synthetic */ d$b(f.h2.t.u u10) {
        this();
    }

    private final int a(String string2, String string3, int n10) {
        int n11 = string2.length();
        while (n10 < n11) {
            char c10 = string2.charAt(n10);
            int n12 = 2;
            if ((c10 = (char)(StringsKt__StringsKt.O2(string3, c10, false, n12, null) ? 1 : 0)) != '\u0000') {
                return n10;
            }
            ++n10;
        }
        return string2.length();
    }

    public static /* synthetic */ int b(d$b d$b, String string2, String string3, int n10, int n11, Object object) {
        if ((n11 &= 2) != 0) {
            n10 = 0;
        }
        return d$b.a(string2, string3, n10);
    }

    /*
     * Unable to fully structure code
     */
    public final d c(s var1_1) {
        var2_2 = this;
        var3_3 = var1_1;
        var4_4 = "headers";
        f0.p(var1_1, var4_4);
        var5_5 = var1_1.size();
        var6_6 = 1;
        var7_7 = 1.4E-45f;
        var8_8 = var6_6;
        var9_9 = var7_7;
        var11_11 = 0;
        var12_12 = null;
        var13_13 = 0;
        var14_14 = 0;
        var15_15 = -1;
        var16_16 = -1;
        var17_17 = 0;
        var18_18 = 0;
        var19_19 = 0;
        var20_20 = -1;
        var21_21 = -1;
        var22_22 = 0;
        var23_23 = 0;
        var24_24 = 0;
        for (var10_10 = 0; var10_10 < var5_5; var10_10 += 1) {
            block28: {
                block18: {
                    block17: {
                        block16: {
                            block15: {
                                var25_25 = var3_3.h(var10_10);
                                var26_26 = var3_3.n(var10_10);
                                var27_27 = "Cache-Control";
                                var28_28 = u.I1(var25_25, var27_27, (boolean)var6_6);
                                if (var28_28 == 0) break block15;
                                if (var12_12 != null) break block16;
                                var12_12 = var26_26;
                                break block17;
                            }
                            var27_27 = "Pragma";
                            var29_29 = u.I1(var25_25, var27_27, (boolean)var6_6);
                            if (var29_29 == 0) break block18;
                        }
                        var8_8 = 0;
                        var9_9 = 0.0f;
                        var30_30 = null;
                    }
                    var29_29 = 0;
                    var25_25 = null;
                    while (var29_29 < (var28_28 = var26_26.length())) {
                        block14: {
                            block27: {
                                block26: {
                                    block25: {
                                        block24: {
                                            block23: {
                                                block22: {
                                                    block21: {
                                                        block20: {
                                                            block19: {
                                                                var27_27 = "=,;";
                                                                var28_28 = var2_2.a(var26_26, var27_27, var29_29);
                                                                var31_31 = "null cannot be cast to non-null type java.lang.String";
                                                                Objects.requireNonNull(var26_26, var31_31);
                                                                var25_25 = var26_26.substring(var29_29, var28_28);
                                                                var3_3 = "(this as java.lang.Strin\u2026ing(startIndex, endIndex)";
                                                                f0.o(var25_25, (String)var3_3);
                                                                var32_32 = var5_5;
                                                                var4_4 = "null cannot be cast to non-null type kotlin.CharSequence";
                                                                Objects.requireNonNull(var25_25, var4_4);
                                                                var25_25 = StringsKt__StringsKt.p5(var25_25).toString();
                                                                var33_33 = var8_8;
                                                                var34_34 = var9_9;
                                                                var8_8 = var26_26.length();
                                                                if (var28_28 == var8_8) break block19;
                                                                var8_8 = var26_26.charAt(var28_28);
                                                                var35_35 = var12_12;
                                                                var11_11 = 44;
                                                                if (var8_8 == var11_11 || (var8_8 = (int)var26_26.charAt(var28_28)) == (var11_11 = 59)) break block20;
                                                                ++var28_28;
                                                                if ((var28_28 = g.h0.d.G(var26_26, var28_28)) < (var8_8 = var26_26.length()) && (var8_8 = (int)var26_26.charAt(var28_28)) == (var11_11 = 34)) {
                                                                    var36_36 = '\"';
                                                                    var37_37 = 4;
                                                                    var5_5 = StringsKt__StringsKt.i3(var26_26, var36_36, ++var28_28, false, var37_37, null);
                                                                    Objects.requireNonNull(var26_26, var31_31);
                                                                    var27_27 = var26_26.substring(var28_28, var5_5);
                                                                    f0.o(var27_27, (String)var3_3);
                                                                    var38_38 = 1;
                                                                    var5_5 += var38_38;
                                                                } else {
                                                                    var30_30 = ",;";
                                                                    var8_8 = var2_2.a(var26_26, var30_30, var28_28);
                                                                    Objects.requireNonNull(var26_26, var31_31);
                                                                    var27_27 = var26_26.substring(var28_28, var8_8);
                                                                    f0.o(var27_27, (String)var3_3);
                                                                    Objects.requireNonNull(var27_27, var4_4);
                                                                    var3_3 = StringsKt__StringsKt.p5(var27_27);
                                                                    var27_27 = var3_3.toString();
                                                                    var5_5 = var8_8;
                                                                }
                                                                break block21;
                                                            }
                                                            var35_35 = var12_12;
                                                        }
                                                        var5_5 = var28_28 + 1;
                                                        var28_28 = 0;
                                                        var27_27 = null;
                                                    }
                                                    var3_3 = "no-cache";
                                                    var6_6 = 1;
                                                    var7_7 = 1.4E-45f;
                                                    var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                                    if (var38_38 != 0) {
                                                        var13_13 = var6_6;
lbl103:
                                                        // 6 sources

                                                        while (true) {
                                                            var38_38 = -1;
                                                            break block14;
                                                            break;
                                                        }
                                                    }
                                                    var3_3 = "no-store";
                                                    var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                                    if (var38_38 == 0) break block22;
                                                    var14_14 = var6_6;
                                                    ** GOTO lbl103
                                                }
                                                var3_3 = "max-age";
                                                var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                                if (var38_38 == 0) break block23;
                                                var38_38 = -1;
                                                var15_15 = g.h0.d.f0(var27_27, var38_38);
                                                break block14;
                                            }
                                            var38_38 = -1;
                                            var30_30 = "s-maxage";
                                            var8_8 = (int)u.I1(var30_30, var25_25, (boolean)var6_6);
                                            if (!var8_8) break block24;
                                            var16_16 = g.h0.d.f0(var27_27, var38_38);
                                            break block14;
                                        }
                                        var3_3 = "private";
                                        var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                        if (var38_38 == 0) break block25;
                                        var17_17 = var6_6;
                                        ** GOTO lbl103
                                    }
                                    var3_3 = "public";
                                    var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                    if (var38_38 == 0) break block26;
                                    var18_18 = var6_6;
                                    ** GOTO lbl103
                                }
                                var3_3 = "must-revalidate";
                                var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                                if (var38_38 == 0) break block27;
                                var19_19 = var6_6;
                                ** GOTO lbl103
                            }
                            var3_3 = "max-stale";
                            var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                            if (var38_38 != 0) {
                                var38_38 = -1 >>> 1;
                                var20_20 = g.h0.d.f0(var27_27, var38_38);
                                ** continue;
                            }
                            var3_3 = "min-fresh";
                            var38_38 = (int)u.I1((String)var3_3, var25_25, (boolean)var6_6);
                            if (var38_38 != 0) {
                                var38_38 = -1;
                                var21_21 = g.h0.d.f0(var27_27, var38_38);
                            } else {
                                var38_38 = -1;
                                var27_27 = "only-if-cached";
                                var28_28 = (int)u.I1(var27_27, var25_25, (boolean)var6_6);
                                if (var28_28 != 0) {
                                    var22_22 = var6_6;
                                } else {
                                    var27_27 = "no-transform";
                                    var28_28 = (int)u.I1(var27_27, var25_25, (boolean)var6_6);
                                    if (var28_28 != 0) {
                                        var23_23 = var6_6;
                                    } else {
                                        var27_27 = "immutable";
                                        var29_29 = (int)u.I1(var27_27, var25_25, (boolean)var6_6);
                                        if (var29_29 != 0) {
                                            var24_24 = var6_6;
                                        }
                                    }
                                }
                            }
                        }
                        var3_3 = var1_1;
                        var29_29 = var5_5;
                        var5_5 = var32_32;
                        var8_8 = var33_33;
                        var9_9 = var34_34;
                        var12_12 = var35_35;
                    }
                    var32_32 = var5_5;
                    var33_33 = var8_8;
                    var34_34 = var9_9;
                    var35_35 = var12_12;
                    break block28;
                }
                var32_32 = var5_5;
            }
            var38_38 = -1;
            var3_3 = var1_1;
            var5_5 = var32_32;
        }
        var39_39 = var8_8 == 0 ? null : var12_12;
        var12_12 = var3_3;
        var3_3 = new d((boolean)var13_13, (boolean)var14_14, var15_15, var16_16, (boolean)var17_17, (boolean)var18_18, (boolean)var19_19, var20_20, var21_21, (boolean)var22_22, (boolean)var23_23, (boolean)var24_24, (String)var39_39, null);
        return var3_3;
    }
}

