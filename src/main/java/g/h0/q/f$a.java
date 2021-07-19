/*
 * Decompiled with CFR 0.151.
 */
package g.h0.q;

import f.h2.t.f0;
import f.q2.t;
import f.q2.u;
import g.h0.d;
import g.h0.q.f;
import g.s;
import kotlin.text.StringsKt__StringsKt;

public final class f$a {
    private f$a() {
    }

    public /* synthetic */ f$a(f.h2.t.u u10) {
        this();
    }

    /*
     * Unable to fully structure code
     */
    public final f a(s var1_1) {
        var2_2 = var1_1;
        var3_3 = "responseHeaders";
        f0.p(var1_1, var3_3);
        var4_4 = var1_1.size();
        var6_6 = 0;
        var7_7 = null;
        var8_8 = null;
        var9_9 = 0;
        var10_10 = null;
        var11_11 = 0;
        var12_12 = 0;
        for (var5_5 = 0; var5_5 < var4_4; ++var5_5) {
            var13_13 = var2_2.h(var5_5);
            var16_16 = u.I1((String)var13_13, var14_14 = "Sec-WebSocket-Extensions", (boolean)(var15_15 = 1));
            if (!var16_16) continue;
            var13_13 = var2_2.n(var5_5);
            var17_17 = 0;
            var14_14 = null;
            while (var17_17 < (var18_18 = var13_13.length())) {
                block14: {
                    var19_19 = 4;
                    var18_18 = d.r((String)var13_13, ',', var17_17, 0, var19_19, null);
                    var20_20 = ';';
                    var21_21 = d.p((String)var13_13, var20_20, var17_17, var18_18);
                    var14_14 = d.g0((String)var13_13, var17_17, var21_21);
                    var21_21 += var15_15;
                    var22_22 = "permessage-deflate";
                    var23_23 = u.I1(var14_14, var22_22, (boolean)var15_15);
                    if (var23_23 == 0) break block14;
                    if (var6_6 != 0) {
                        var12_12 = var15_15;
                    }
                    while (var21_21 < var18_18) {
                        block16: {
                            block18: {
                                block17: {
                                    block15: {
                                        var23_23 = d.p((String)var13_13, var20_20, var21_21, var18_18);
                                        var6_6 = d.p((String)var13_13, '=', var21_21, var23_23);
                                        var24_24 = d.g0((String)var13_13, var21_21, var6_6);
                                        if (var6_6 < var23_23) {
                                            var7_7 = d.g0((String)var13_13, ++var6_6, var23_23);
                                            var14_14 = "\"";
                                            var7_7 = StringsKt__StringsKt.d4(var7_7, var14_14);
                                        } else {
                                            var6_6 = 0;
                                            var7_7 = null;
                                        }
                                        ++var23_23;
                                        var14_14 = "client_max_window_bits";
                                        var17_17 = (int)u.I1((String)var24_24, var14_14, (boolean)var15_15);
                                        if (var17_17 == 0) break block15;
                                        if (var8_8 != null) {
                                            var12_12 = var15_15;
                                        }
                                        if ((var8_8 = var7_7 != null ? (var24_24 = t.X0(var7_7)) : null) != null) break block16;
                                        ** GOTO lbl-1000
                                    }
                                    var14_14 = "client_no_context_takeover";
                                    var17_17 = (int)u.I1((String)var24_24, var14_14, (boolean)var15_15);
                                    if (var17_17 == 0) break block17;
                                    if (var9_9 != 0) {
                                        var12_12 = var15_15;
                                    }
                                    if (var7_7 != null) {
                                        var12_12 = var15_15;
                                    }
                                    var9_9 = var15_15;
                                    break block16;
                                }
                                var14_14 = "server_max_window_bits";
                                var17_17 = (int)u.I1((String)var24_24, var14_14, (boolean)var15_15);
                                if (var17_17 == 0) break block18;
                                if (var10_10 != null) {
                                    var12_12 = var15_15;
                                }
                                if ((var10_10 = var7_7 != null ? (var24_24 = t.X0(var7_7)) : null) != null) break block16;
                                ** GOTO lbl-1000
                            }
                            var14_14 = "server_no_context_takeover";
                            var21_21 = (int)u.I1((String)var24_24, var14_14, (boolean)var15_15);
                            if (var21_21 != 0) {
                                if (var11_11 != 0) {
                                    var12_12 = var15_15;
                                }
                                if (var7_7 != null) {
                                    var12_12 = var15_15;
                                }
                                var11_11 = var15_15;
                            } else lbl-1000:
                            // 3 sources

                            {
                                var12_12 = var15_15;
                            }
                        }
                        var21_21 = var23_23;
                    }
                    var17_17 = var21_21;
                    var6_6 = var15_15;
                    continue;
                }
                var17_17 = var21_21;
                var12_12 = var15_15;
            }
        }
        var13_13 = var2_2;
        var2_2 = new f((boolean)var6_6, (Integer)var8_8, (boolean)var9_9, (Integer)var10_10, (boolean)var11_11, (boolean)var12_12);
        return var2_2;
    }
}

