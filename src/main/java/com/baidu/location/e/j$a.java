/*
 * Decompiled with CFR 0.151.
 */
package com.baidu.location.e;

import com.baidu.location.BDLocation;
import java.util.LinkedHashMap;

public final class j$a {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final boolean e;
    public final int f;
    public final BDLocation g;
    public final boolean h;
    public final LinkedHashMap i;

    /*
     * Unable to fully structure code
     */
    public j$a(String[] var1_1) {
        block97: {
            block98: {
                block89: {
                    block96: {
                        var2_2 = this;
                        var3_3 = var1_1;
                        super();
                        var4_4 = 8;
                        var5_5 = 0;
                        var6_6 = null;
                        var7_7 = 0;
                        var8_8 = null;
                        if (var1_1 != null) break block96;
                        this.a = null;
                        this.b = null;
                        this.i = null;
                        this.c = false;
                        this.d = false;
                        this.e = false;
                        this.g = null;
                        this.h = false;
                        this.f = var4_4;
                        break block97;
                    }
                    var9_9 = new LinkedHashMap<Object, Object>();
                    var10_10 = 0;
                    var11_11 = null;
                    var12_12 = 0;
                    var13_13 = null;
                    var14_14 = 0;
                    var15_15 = null;
                    var16_16 = 0;
                    var17_17 = 0;
                    var18_18 = 0;
                    var19_19 = 0;
                    var20_20 = 0;
                    block73: while (true) {
                        block91: {
                            block95: {
                                block94: {
                                    block93: {
                                        block92: {
                                            block90: {
                                                block83: {
                                                    block84: {
                                                        var21_21 = var3_3.length;
                                                        if (var16_16 >= var21_21) break;
                                                        var22_22 = var3_3[var16_16];
                                                        var6_6 = "-loc";
                                                        var5_5 = var22_22.equals(var6_6);
                                                        var22_22 = ";";
                                                        if (var5_5 == 0) break block83;
                                                        var5_5 = var16_16 + 1;
                                                        var11_11 = var3_3[var5_5];
                                                        var6_6 = "&";
                                                        try {
                                                            var6_6 = var11_11.split((String)var6_6);
                                                            var7_7 = 0;
                                                            var8_8 = null;
                                                        }
                                                        catch (Exception v3) {
                                                            var25_25 = var11_11;
                                                            break block89;
                                                        }
                                                        while (true) {
                                                            block87: {
                                                                block86: {
                                                                    block85: {
                                                                        var23_23 = ((String[])var6_6).length;
                                                                        if (var7_7 >= var23_23) break block84;
                                                                        var24_24 = var6_6[var7_7];
                                                                        var25_25 = var11_11;
                                                                        var11_11 = "cl=";
                                                                        var10_10 = var24_24.startsWith((String)var11_11);
                                                                        if (var10_10 == 0) break block85;
                                                                        var11_11 = var6_6[var7_7];
                                                                        var23_23 = 3;
                                                                        var11_11 = var11_11.substring(var23_23);
                                                                        var26_26 = var6_6;
                                                                        var13_13 = var11_11;
                                                                    }
                                                                    var11_11 = var6_6[var7_7];
                                                                    var24_24 = "wf=";
                                                                    var10_10 = var11_11.startsWith((String)var24_24);
                                                                    if (var10_10 == 0) break block86;
                                                                    var11_11 = var6_6[var7_7];
                                                                    var23_23 = 3;
                                                                    var11_11 = var11_11.substring(var23_23);
                                                                    var24_24 = "\\|";
                                                                    var11_11 = var11_11.split((String)var24_24);
                                                                    var26_26 = var6_6;
                                                                    var23_23 = 0;
                                                                    var24_24 = null;
                                                                    while (true) {
                                                                        block88: {
                                                                            var5_5 = ((Object)var11_11).length;
                                                                            if (var23_23 >= var5_5) break block87;
                                                                            var6_6 = var11_11[var23_23];
                                                                            var6_6 = var6_6.split(var22_22);
                                                                            var27_27 = var11_11;
                                                                            var10_10 = ((Object)var6_6).length;
                                                                            var28_28 = var13_13;
                                                                            var12_12 = 2;
                                                                            if (var10_10 < var12_12) break block88;
                                                                            var10_10 = 0;
                                                                            var11_11 = null;
                                                                            try {
                                                                                var13_13 = var6_6[0];
                                                                                var10_10 = 1;
                                                                            }
                                                                            catch (Exception v0) {
                                                                                var11_11 = var25_25;
                                                                                var13_13 = var28_28;
                                                                                break block89;
                                                                            }
                                                                            var6_6 = var6_6[var10_10];
                                                                            var6_6 = Integer.valueOf((String)var6_6);
                                                                            var9_9.put(var13_13, var6_6);
                                                                        }
                                                                        ++var23_23;
                                                                        var11_11 = var27_27;
                                                                        var13_13 = var28_28;
                                                                    }
                                                                }
                                                                var26_26 = var6_6;
                                                            }
                                                            var28_28 = var13_13;
                                                            ++var7_7;
                                                            var11_11 = var25_25;
                                                            var6_6 = var26_26;
                                                        }
                                                        catch (Exception v1) {
                                                            var28_28 = var13_13;
lbl135:
                                                            // 2 sources

                                                            while (true) {
                                                                var11_11 = var25_25;
                                                                break block89;
                                                                break;
                                                            }
                                                        }
                                                    }
                                                    var25_25 = var11_11;
                                                    var28_28 = var13_13;
                                                    break block91;
                                                    catch (Exception v2) {
                                                        var25_25 = var11_11;
                                                        var28_28 = var13_13;
                                                        break block89;
                                                    }
                                                }
                                                var6_6 = var3_3[var16_16];
                                                var8_8 = "-com";
                                                var5_5 = (int)var6_6.equals(var8_8);
                                                if (var5_5 == 0) break block90;
                                                var5_5 = var16_16 + 1;
                                                var6_6 = var3_3[var5_5];
                                                var6_6 = var6_6.split(var22_22);
                                                var7_7 = ((Object)var6_6).length;
                                                if (var7_7 <= 0) break block91;
                                                var8_8 = new BDLocation();
                                                var23_23 = 0;
                                                var24_24 = null;
                                                try {
                                                    var15_15 = var6_6[0];
                                                }
                                                catch (Exception v4) {
                                                    var15_15 = var8_8;
                                                    break block89;
                                                }
                                                var15_15 = Double.valueOf((String)var15_15);
                                                var29_29 = var15_15.doubleValue();
                                                var8_8.setLatitude(var29_29);
                                                var23_23 = 1;
                                                var15_15 = var6_6[var23_23];
                                                var15_15 = Double.valueOf((String)var15_15);
                                                var31_30 = var15_15.doubleValue();
                                                var8_8.setLongitude(var31_30);
                                                var14_14 = 2;
                                                var15_15 = var6_6[var14_14];
                                                var15_15 = Integer.valueOf((String)var15_15);
                                                var14_14 = var15_15.intValue();
                                                var8_8.setLocType(var14_14);
                                                var14_14 = 3;
                                                var6_6 = var6_6[var14_14];
                                                var8_8.setNetworkLocationType((String)var6_6);
                                                var15_15 = var8_8;
                                                break block91;
                                            }
                                            var23_23 = 1;
                                            var6_6 = var3_3[var16_16];
                                            var8_8 = "-log";
                                            var5_5 = (int)var6_6.equals(var8_8);
                                            var8_8 = "true";
                                            if (var5_5 == 0) break block92;
                                            var5_5 = var16_16 + 1;
                                            var6_6 = var3_3[var5_5];
                                            var5_5 = (int)var6_6.equals(var8_8);
                                            if (var5_5 != 0) {
                                                var17_17 = var23_23;
                                            }
                                            break block91;
                                        }
                                        var6_6 = var3_3[var16_16];
                                        var22_22 = "-rgc";
                                        var5_5 = (int)var6_6.equals(var22_22);
                                        if (var5_5 == 0) break block93;
                                        var5_5 = var16_16 + 1;
                                        var6_6 = var3_3[var5_5];
                                        var5_5 = (int)var6_6.equals(var8_8);
                                        if (var5_5 != 0) {
                                            var19_19 = var23_23;
                                        }
                                        break block91;
                                    }
                                    var6_6 = var3_3[var16_16];
                                    var22_22 = "-poi";
                                    var5_5 = (int)var6_6.equals(var22_22);
                                    if (var5_5 == 0) break block94;
                                    var5_5 = var16_16 + 1;
                                    var6_6 = var3_3[var5_5];
                                    var5_5 = (int)var6_6.equals(var8_8);
                                    if (var5_5 != 0) {
                                        var18_18 = var23_23;
                                    }
                                    break block91;
                                }
                                var6_6 = var3_3[var16_16];
                                var22_22 = "-minap";
                                var5_5 = (int)var6_6.equals(var22_22);
                                if (var5_5 == 0) break block95;
                                var5_5 = var16_16 + 1;
                                var6_6 = var3_3[var5_5];
                                var6_6 = Integer.valueOf((String)var6_6);
                                var4_4 = var6_6.intValue();
                                break block91;
                            }
                            var6_6 = var3_3[var16_16];
                            var22_22 = "-des";
                            var5_5 = (int)var6_6.equals(var22_22);
                            if (var5_5 == 0) break block91;
                            var5_5 = var16_16 + 1;
                            var6_6 = var3_3[var5_5];
                            var5_5 = (int)var6_6.equals(var8_8);
                            if (var5_5 == 0) break block91;
                            var20_20 = var23_23;
                        }
lbl281:
                        // 2 sources

                        while (true) {
                            var16_16 += 2;
                            var5_5 = 0;
                            var6_6 = null;
                            var7_7 = 0;
                            var8_8 = null;
                            continue block73;
                            break;
                        }
                        break;
                    }
                    var23_23 = 1;
                    if (var17_17 == 0) {
                        var5_5 = 0;
                        var6_6 = null;
                    } else {
                        var6_6 = var11_11;
                    }
                    var7_7 = var23_23;
                    break block98;
                    catch (Exception v5) {}
                }
                var6_6 = var11_11;
                var7_7 = 0;
                var8_8 = null;
            }
            var2_2.a = var6_6;
            var2_2.b = var13_13;
            var2_2.i = var9_9;
            var2_2.c = var7_7;
            var2_2.d = var18_18;
            var2_2.e = var19_19;
            var2_2.f = var4_4;
            var2_2.g = var15_15;
            var2_2.h = var20_20;
        }
        return;
        catch (Exception v6) {
            ** continue;
        }
        catch (Exception v7) {
            ** continue;
        }
    }
}

