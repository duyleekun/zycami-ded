/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import com.baidu.location.e.c;
import com.baidu.location.e.c$c;
import org.json.JSONObject;

public class e
extends Thread {
    public final /* synthetic */ c$c a;

    public e(c$c c$c) {
        this.a = c$c;
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void run() {
        block76: {
            block78: {
                block74: {
                    block77: {
                        block72: {
                            block71: {
                                block73: {
                                    block69: {
                                        block70: {
                                            var1_1 = this;
                                            var2_2 = "DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY timestamp DESC, frequency DESC LIMIT %d);";
                                            var3_3 /* !! */  = "rgc";
                                            var4_8 = "bdlist";
                                            var5_9 = "type";
                                            var6_10 = "model";
                                            var7_11 /* !! */  = "CL";
                                            var8_12 = "AP";
                                            var9_13 = "loadurl";
                                            super.run();
                                            var10_14 = c.b(this.a.a);
                                            if (var10_14 == null || (var10_14 = c.c(this.a.a)) == null || !(var11_15 = (var10_14 = c.b(this.a.a)).isOpen()) || !(var11_15 = (var10_14 = c.c(this.a.a)).isOpen())) break block77;
                                            var12_16 = this.a;
                                            var12_16 = var12_16.j;
                                            if (var12_16 == null) break block69;
                                            var13_17 /* !! */  = new JSONObject((String)var12_16);
                                            var14_18 = var13_17 /* !! */ .has((String)var6_10);
                                            if (var14_18) {
                                                var6_10 = var13_17 /* !! */ .getJSONObject((String)var6_10);
                                                break block70;
                                            }
                                            var15_19 = 0;
                                            var6_10 = null;
                                        }
                                        try {
                                            var14_18 = var13_17 /* !! */ .has((String)var3_3 /* !! */ );
                                            if (!var14_18) break block71;
                                            var3_3 /* !! */  = var13_17 /* !! */ .getJSONObject((String)var3_3 /* !! */ );
                                            break block72;
                                        }
                                        catch (Exception var3_4) {
                                            break block73;
                                        }
                                        catch (Exception var3_5) {
                                            var15_19 = 0;
                                            var6_10 = null;
                                        }
                                        break block73;
                                    }
                                    var16_20 = 0;
                                    var3_3 /* !! */  = null;
                                    var15_19 = 0;
                                    var6_10 = null;
                                    var17_21 = 0;
                                    var13_17 /* !! */  = null;
                                    break block72;
                                    catch (Exception var3_6) {
                                        var15_19 = 0;
                                        var6_10 = null;
                                        var17_21 = 0;
                                        var13_17 /* !! */  = null;
                                    }
                                }
                                var3_3 /* !! */ .printStackTrace();
                            }
                            var16_20 = 0;
                            var3_3 /* !! */  = null;
                        }
                        try {
                            var12_16 = var1_1.a;
                            var12_16 = var12_16.a;
                            var12_16 = c.b((c)var12_16);
                            var12_16.beginTransaction();
                            var12_16 = var1_1.a;
                            var12_16 = var12_16.a;
                            var12_16 = c.c((c)var12_16);
                            var12_16.beginTransaction();
                            break block74;
                        }
                        catch (Exception v0) {}
                    }
                    c$c.a(var1_1.a, false);
                    return;
                }
                if (var3_3 /* !! */  == null) ** GOTO lbl79
                var12_16 = var1_1.a;
                var12_16 = var12_16.a;
                var12_16 = c.a((c)var12_16);
                var12_16 = var12_16.k();
                var12_16.a((JSONObject)var3_3 /* !! */ );
lbl79:
                // 2 sources

                if (var13_17 /* !! */  != null && (var16_20 = var13_17 /* !! */ .has((String)var5_9)) != 0 && (var16_20 = (var3_3 /* !! */  = var13_17 /* !! */ .getString((String)var5_9)).equals(var5_9 = "0")) != 0) {
                    var3_3 /* !! */  = var1_1.a;
                    var18_22 = System.currentTimeMillis();
                    c$c.a((c$c)var3_3 /* !! */ , var18_22);
                }
                if (var13_17 /* !! */  != null && (var16_20 = var13_17 /* !! */ .has((String)var4_8)) != 0) {
                    var3_3 /* !! */  = var13_17 /* !! */ .getString((String)var4_8);
                    var4_8 = ";";
                    var3_3 /* !! */  = var3_3 /* !! */ .split((String)var4_8);
                    var4_8 = var1_1.a;
                    var4_8 = c$c.a((c$c)var4_8);
                    c.a((c)var4_8, (String[])var3_3 /* !! */ );
                }
                if (var13_17 /* !! */  != null && (var16_20 = var13_17 /* !! */ .has((String)var9_13)) != 0) {
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = c$c.a((c$c)var3_3 /* !! */ );
                    var4_8 = var13_17 /* !! */ .getJSONObject((String)var9_13);
                    var5_9 = "host";
                    var4_8 = var4_8.getString((String)var5_9);
                    var5_9 = var13_17 /* !! */ .getJSONObject((String)var9_13);
                    var12_16 = "module";
                    var5_9 = var5_9.getString((String)var12_16);
                    var9_13 = var13_17 /* !! */ .getJSONObject((String)var9_13);
                    var12_16 = "req";
                    var9_13 = var9_13.getString((String)var12_16);
                    c.a((c)var3_3 /* !! */ , (String)var4_8, (String)var5_9, (String)var9_13);
                }
                var3_3 /* !! */  = "cell";
                var4_8 = ",";
                if (var6_10 == null || (var20_23 = var6_10.has((String)var3_3 /* !! */ )) == 0) break block78;
                var21_24 = var6_10.getJSONObject((String)var3_3 /* !! */ );
                var22_25 /* !! */  = var21_24.keys();
                var23_26 = new StringBuffer();
                var10_14 = new StringBuffer();
                var24_27 = new StringBuffer();
                var25_28 = 0;
                var26_29 = null;
                var27_30 = true;
                var28_31 = 0;
                var29_32 = null;
                var30_33 = 0;
                var31_34 = null;
                var32_35 = 1;
                var33_36 = true;
                ** GOTO lbl160
            }
            var56_54 /* !! */  = var3_3 /* !! */ ;
            var57_55 = var7_11 /* !! */ ;
            var49_48 = var8_12;
            ** GOTO lbl345
            {
                block79: {
                    block75: {
                        catch (Throwable var3_7) {}
                        try {
                            var2_2 = var1_1.a;
                            var2_2 = var2_2.a;
                            var2_2 = c.b((c)var2_2);
                            if (var2_2 != null) {
                                var2_2 = var1_1.a;
                                var2_2 = var2_2.a;
                                var67_62 = (var2_2 = c.b((c)var2_2)).isOpen();
                                if (var67_62) {
                                    var2_2 = var1_1.a;
                                    var2_2 = var2_2.a;
                                    var2_2 = c.b((c)var2_2);
                                    var2_2.endTransaction();
                                }
                            }
                            var2_2 = var1_1.a;
                            var2_2 = var2_2.a;
                            if ((var2_2 = c.c((c)var2_2)) == null) break block75;
                            var2_2 = var1_1.a;
                            var2_2 = var2_2.a;
                            var67_62 = (var2_2 = c.c((c)var2_2)).isOpen();
                            if (var67_62) {
                                var2_2 = var1_1.a;
                                var2_2 = var2_2.a;
                                var2_2 = c.c((c)var2_2);
                                var2_2.endTransaction();
                            }
                        }
                        catch (Exception v1) {}
                    }
                    var2_2 = var1_1.a;
                    var2_2.j = null;
                    c$c.a((c$c)var2_2, false);
                    throw var3_7;
lbl160:
                    // 1 sources

                    while (true) {
                        var34_37 = var22_25 /* !! */ .hasNext();
                        var13_17 /* !! */  = "INSERT OR REPLACE INTO CL (id,x,y,r,cl,timestamp) VALUES %s;";
                        var12_16 = "DELETE FROM CL WHERE id IN (%s);";
                        if (var34_37 == 0) break;
                        var35_38 = var22_25 /* !! */ .next();
                        var9_13 = var35_38;
                        var9_13 = (String)var35_38;
                        var5_9 = var21_24.getString((String)var9_13);
                        var36_39 = var5_9.split((String)var4_8);
                        var34_37 = 3;
                        var36_39 = var36_39[var34_37];
                        var36_39 = Double.valueOf((String)var36_39);
                        if (var27_30) {
                            var37_40 = var21_24;
                            var27_30 = false;
                            var38_41 /* !! */  = null;
                        } else {
                            var37_40 = var21_24;
                            var20_23 = 44;
                            var10_14.append((char)var20_23);
                        }
                        var10_14.append((String)var9_13);
                        var20_23 = var25_28 + 1;
                        var39_42 = var36_39.doubleValue();
                        var41_43 = 0L;
                        var43_44 = 0.0;
                        var25_28 = (int)(var39_42 == var43_44 ? 0 : (var39_42 > var43_44 ? 1 : -1));
                        if (var25_28 > 0) {
                            if (var33_36) {
                                var36_39 = var22_25 /* !! */ ;
                                var33_36 = false;
                            } else {
                                var36_39 = var22_25 /* !! */ ;
                                var45_45 = ',';
                                var24_27.append(var45_45);
                            }
                            var45_45 = '(';
                            var24_27.append(var45_45);
                            var24_27.append((String)var9_13);
                            var46_46 = ',';
                            var24_27.append(var46_46);
                            var24_27.append((String)var5_9);
                            var5_9 = new StringBuilder();
                            var5_9.append((String)var4_8);
                            var47_47 = System.currentTimeMillis();
                            var41_43 = 1000L;
                            var43_44 = 4.94E-321;
                            var22_25 /* !! */  = var7_11 /* !! */ ;
                            var49_48 = var8_12;
                            var50_49 = var47_47 / var41_43;
                            var5_9.append(var50_49);
                            var5_9 = var5_9.toString();
                            var24_27.append((String)var5_9);
                            var52_50 = 41;
                            var24_27.append((char)var52_50);
                            ++var28_31;
                        } else {
                            var49_48 = var8_12;
                            var36_39 = var22_25 /* !! */ ;
                            var22_25 /* !! */  = var7_11 /* !! */ ;
                            if (var32_35 != 0) {
                                var32_35 = 0;
                                var53_51 = null;
                            } else {
                                var52_50 = 44;
                                var23_26.append((char)var52_50);
                            }
                            var23_26.append((String)var9_13);
                        }
                        var52_50 = var28_31;
                        var54_52 = ++var30_33;
                        var55_53 = 100;
                        if (var20_23 >= var55_53) {
                            var8_12 = var1_1.a;
                            var8_12 = var8_12.a;
                            var8_12 = c.c((c)var8_12);
                            var56_54 /* !! */  = var3_3 /* !! */ ;
                            var46_46 = '\u0001';
                            var3_3 /* !! */  = new Object[var46_46];
                            var9_13 = var10_14.toString();
                            var57_55 = var22_25 /* !! */ ;
                            var45_45 = '\u0000';
                            var22_25 /* !! */  = null;
                            var3_3 /* !! */ [0] = var9_13;
                            var3_3 /* !! */  = String.format((String)var12_16, (Object[])var3_3 /* !! */ );
                            var8_12.execSQL((String)var3_3 /* !! */ );
                            var10_14.setLength(0);
                            var25_28 = var20_23 += -100;
                            var16_20 = 100;
                            var27_30 = true;
                        } else {
                            var56_54 /* !! */  = var3_3 /* !! */ ;
                            var57_55 = var22_25 /* !! */ ;
                            var16_20 = var55_53;
                            var25_28 = var20_23;
                        }
                        if (var52_50 >= var16_20) {
                            var3_3 /* !! */  = var1_1.a;
                            var3_3 /* !! */  = var3_3 /* !! */ .a;
                            var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                            var55_53 = 1;
                            var9_13 = new Object[var55_53];
                            var8_12 = var24_27.toString();
                            var20_23 = 0;
                            var21_24 = null;
                            var9_13[0] = var8_12;
                            var8_12 = String.format((String)var13_17 /* !! */ , (Object[])var9_13);
                            var3_3 /* !! */ .execSQL((String)var8_12);
                            var24_27.setLength(0);
                            var28_31 = var52_50 += -100;
                            var16_20 = 100;
                            var33_36 = true;
                        } else {
                            var28_31 = var52_50;
                        }
                        if (var54_52 >= var16_20) {
                            var3_3 /* !! */  = var1_1.a;
                            var3_3 /* !! */  = var3_3 /* !! */ .a;
                            var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                            var52_50 = 1;
                            var8_12 = new Object[var52_50];
                            var5_9 = var23_26.toString();
                            var46_46 = '\u0000';
                            var9_13 = null;
                            var8_12[0] = var5_9;
                            var5_9 = String.format((String)var12_16, var8_12);
                            var3_3 /* !! */ .execSQL((String)var5_9);
                            var23_26.setLength(0);
                            var30_33 = var54_52 += -100;
                            var32_35 = 1;
                        } else {
                            var30_33 = var54_52;
                        }
                        var22_25 /* !! */  = var36_39;
                        var21_24 = var37_40;
                        var3_3 /* !! */  = var56_54 /* !! */ ;
                        var7_11 /* !! */  = var57_55;
                        var8_12 = var49_48;
                    }
                    var56_54 /* !! */  = var3_3 /* !! */ ;
                    var57_55 = var7_11 /* !! */ ;
                    var49_48 = var8_12;
                    if (var25_28 > 0) {
                        var3_3 /* !! */  = var1_1.a;
                        var3_3 /* !! */  = var3_3 /* !! */ .a;
                        var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
                        var52_50 = 1;
                        var7_11 /* !! */  = new Object[var52_50];
                        var5_9 = var10_14.toString();
                        var55_53 = 0;
                        var8_12 = null;
                        var7_11 /* !! */ [0] = var5_9;
                        var5_9 = String.format((String)var12_16, var7_11 /* !! */ );
                        var3_3 /* !! */ .execSQL((String)var5_9);
                    }
                    if (var28_31 > 0) {
                        var3_3 /* !! */  = var1_1.a;
                        var3_3 /* !! */  = var3_3 /* !! */ .a;
                        var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                        var52_50 = 1;
                        var7_11 /* !! */  = new Object[var52_50];
                        var5_9 = var24_27.toString();
                        var55_53 = 0;
                        var8_12 = null;
                        var7_11 /* !! */ [0] = var5_9;
                        var5_9 = String.format((String)var13_17 /* !! */ , var7_11 /* !! */ );
                        var3_3 /* !! */ .execSQL((String)var5_9);
                    }
                    if (var30_33 > 0) {
                        var3_3 /* !! */  = var1_1.a;
                        var3_3 /* !! */  = var3_3 /* !! */ .a;
                        var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                        var52_50 = 1;
                        var7_11 /* !! */  = new Object[var52_50];
                        var5_9 = var23_26.toString();
                        var55_53 = 0;
                        var8_12 = null;
                        var7_11 /* !! */ [0] = var5_9;
                        var5_9 = String.format((String)var12_16, var7_11 /* !! */ );
                        var3_3 /* !! */ .execSQL((String)var5_9);
                    }
lbl345:
                    // 4 sources

                    var3_3 /* !! */  = "ap";
                    if (var6_10 != null && (var52_50 = var6_10.has((String)var3_3 /* !! */ )) != 0) break block79;
                    {
                        var38_41 /* !! */  = var3_3 /* !! */ ;
                        var26_29 = var6_10;
                        break block80;
                    }
                }
                var5_9 = var6_10.getJSONObject((String)var3_3 /* !! */ );
                var7_11 /* !! */  = var5_9.keys();
                var8_12 = new StringBuffer();
                var9_13 = new StringBuffer();
                var10_14 = new StringBuffer();
                var58_56 = 0;
                var24_27 = null;
                var14_18 = true;
                var17_21 = 0;
                var13_17 /* !! */  = null;
                var20_23 = 0;
                var21_24 = null;
                var45_45 = '\u0001';
                var59_57 = 1;
                {
                    block80: {
                        while (true) {
                            var25_28 = var7_11 /* !! */ .hasNext();
                            var38_41 /* !! */  = var3_3 /* !! */ ;
                            var3_3 /* !! */  = "DELETE FROM AP WHERE id IN (%s);";
                            if (var25_28 == 0) break;
                            var26_29 = var7_11 /* !! */ .next();
                            var29_32 = var7_11 /* !! */ ;
                            var7_11 /* !! */  = var26_29;
                            var7_11 /* !! */  = (String)var26_29;
                            var26_29 = var6_10;
                            var6_10 = var5_9.getString((String)var7_11 /* !! */ );
                            var31_34 = var6_10.split((String)var4_8);
                            var32_35 = 3;
                            var31_34 = var31_34[var32_35];
                            var31_34 = Double.valueOf((String)var31_34);
                            if (var14_18) {
                                var53_51 = var5_9;
                                var14_18 = false;
                                var12_16 = null;
                            } else {
                                var53_51 = var5_9;
                                var52_50 = 44;
                                var9_13.append((char)var52_50);
                            }
                            var9_13.append((String)var7_11 /* !! */ );
                            ++var58_56;
                            var60_58 = var31_34.doubleValue();
                            var41_43 = 0L;
                            var43_44 = 0.0;
                            var52_50 = (int)(var60_58 == var43_44 ? 0 : (var60_58 > var43_44 ? 1 : -1));
                            if (var52_50 > 0) {
                                if (var59_57 != 0) {
                                    var59_57 = 0;
                                    var23_26 = null;
                                } else {
                                    var52_50 = 44;
                                    ** try [egrp 6[TRYBLOCK] [281, 280 : 1867->2970)] { 
lbl403:
                                    // 1 sources

                                    var10_14.append((char)var52_50);
                                }
                                var52_50 = 40;
                                var10_14.append((char)var52_50);
                                var10_14.append((String)var7_11 /* !! */ );
                                var52_50 = 44;
                                var10_14.append((char)var52_50);
                                var10_14.append((String)var6_10);
                                var5_9 = new StringBuilder();
                                var5_9.append((String)var4_8);
                                var62_59 = System.currentTimeMillis();
                                var64_60 = 1000L;
                                var60_58 = 4.94E-321;
                                var5_9.append(var62_59 /= var64_60);
                                var5_9 = var5_9.toString();
                                var10_14.append((String)var5_9);
                                var52_50 = 41;
                                var10_14.append((char)var52_50);
                                ++var17_21;
                                var52_50 = 44;
                            } else {
                                if (var45_45 != '\u0000') {
                                    var52_50 = 44;
                                    var45_45 = '\u0000';
                                    var22_25 /* !! */  = null;
                                } else {
                                    var52_50 = 44;
                                    var8_12.append((char)var52_50);
                                }
                                var8_12.append((String)var7_11 /* !! */ );
                                ++var20_23;
                            }
                            var15_19 = 100;
                            if (var58_56 >= var15_19) {
                                var6_10 = var1_1.a;
                                var6_10 = var6_10.a;
                                var6_10 = c.c((c)var6_10);
                                var54_52 = 1;
                                var12_16 = new Object[var54_52];
                                var7_11 /* !! */  = var9_13.toString();
                                var52_50 = 0;
                                var5_9 = null;
                                var12_16[0] = var7_11 /* !! */ ;
                                var7_11 /* !! */  = String.format((String)var3_3 /* !! */ , var12_16);
                                var6_10.execSQL((String)var7_11 /* !! */ );
                                var9_13.setLength(0);
                                var58_56 += -100;
                                var52_50 = 100;
                                var14_18 = true;
                            } else {
                                var52_50 = var15_19;
                            }
                            if (var17_21 >= var52_50) {
                                var6_10 = var1_1.a;
                                var6_10 = var6_10.a;
                                var6_10 = c.b((c)var6_10);
                                var7_11 /* !! */  = "INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;";
                                var59_57 = 1;
                                var5_9 = new Object[var59_57];
                                var23_26 = var10_14.toString();
                                var31_34 = var4_8;
                                var66_61 = 0;
                                var4_8 = null;
                                var5_9[0] = var23_26;
                                var5_9 = String.format((String)var7_11 /* !! */ , (Object[])var5_9);
                                var6_10.execSQL((String)var5_9);
                                var10_14.setLength(0);
                                var17_21 += -100;
                                var59_57 = 1;
                            } else {
                                var31_34 = var4_8;
                            }
                            if (var20_23 > 0) {
                                var4_8 = var1_1.a;
                                var4_8 = var4_8.a;
                                var4_8 = c.b((c)var4_8);
                                var52_50 = 1;
                                var6_10 = new Object[var52_50];
                                var5_9 = var8_12.toString();
                                var54_52 = 0;
                                var7_11 /* !! */  = null;
                                var6_10[0] = var5_9;
                                var3_3 /* !! */  = String.format((String)var3_3 /* !! */ , (Object[])var6_10);
                                var4_8.execSQL((String)var3_3 /* !! */ );
                            }
                            var6_10 = var26_29;
                            var3_3 /* !! */  = var38_41 /* !! */ ;
                            var7_11 /* !! */  = var29_32;
                            var4_8 = var31_34;
                            var5_9 = var53_51;
                        }
                        var26_29 = var6_10;
                        if (var58_56 > 0) {
                            var4_8 = var1_1.a;
                            var4_8 = var4_8.a;
                            var4_8 = c.c((c)var4_8);
                            var52_50 = 1;
                            var6_10 = new Object[var52_50];
                            var5_9 = var9_13.toString();
                            var54_52 = 0;
                            var7_11 /* !! */  = null;
                            var6_10[0] = var5_9;
                            var5_9 = String.format((String)var3_3 /* !! */ , (Object[])var6_10);
                            var4_8.execSQL((String)var5_9);
                        }
                        if (var17_21 > 0) {
                            var4_8 = var1_1.a;
                            var4_8 = var4_8.a;
                            var4_8 = c.b((c)var4_8);
                            var5_9 = "INSERT OR REPLACE INTO AP (id,x,y,r,cl,timestamp) VALUES %s;";
                            var15_19 = 1;
                            var7_11 /* !! */  = new Object[var15_19];
                            var6_10 = var10_14.toString();
                            var46_46 = '\u0000';
                            var9_13 = null;
                            var7_11 /* !! */ [0] = var6_10;
                            var5_9 = String.format((String)var5_9, var7_11 /* !! */ );
                            var4_8.execSQL((String)var5_9);
                        }
                        if (var20_23 > 0) {
                            var4_8 = var1_1.a;
                            var4_8 = var4_8.a;
                            var4_8 = c.b((c)var4_8);
                            var52_50 = 1;
                            var6_10 = new Object[var52_50];
                            var5_9 = var8_12.toString();
                            var54_52 = 0;
                            var7_11 /* !! */  = null;
                            var6_10[0] = var5_9;
                            var3_3 /* !! */  = String.format((String)var3_3 /* !! */ , (Object[])var6_10);
                            var4_8.execSQL((String)var3_3 /* !! */ );
                        }
                    }
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                    var66_61 = 3;
                    var5_9 = new Object[var66_61];
                    var66_61 = 0;
                    var4_8 = null;
                    var5_9[0] = var49_48;
                    var66_61 = 1;
                    var5_9[var66_61] = var49_48;
                    var66_61 = 200000;
                    var6_10 = var66_61;
                    var54_52 = 2;
                    var5_9[var54_52] = var6_10;
                    var5_9 = String.format((String)var2_2, (Object[])var5_9);
                    var3_3 /* !! */ .execSQL((String)var5_9);
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                    var52_50 = 3;
                    var6_10 = new Object[var52_50];
                    var52_50 = 0;
                    var5_9 = null;
                    var6_10[0] = var57_55;
                    var52_50 = 1;
                    var6_10[var52_50] = var57_55;
                    var4_8 = var66_61;
                    var6_10[var54_52] = var4_8;
                    var2_2 = String.format((String)var2_2, (Object[])var6_10);
                    var3_3 /* !! */ .execSQL((String)var2_2);
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
                    var2_2 = "DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);";
                    var66_61 = 3;
                    var5_9 = new Object[var66_61];
                    var66_61 = 0;
                    var4_8 = null;
                    var5_9[0] = var49_48;
                    var66_61 = 1;
                    var5_9[var66_61] = var49_48;
                    var66_61 = 10000;
                    var4_8 = var66_61;
                    var5_9[var54_52] = var4_8;
                    var2_2 = String.format((String)var2_2, (Object[])var5_9);
                    var3_3 /* !! */ .execSQL((String)var2_2);
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
                    var2_2 = "DELETE FROM %s WHERE id NOT IN (SELECT id FROM %s ORDER BY frequency DESC LIMIT %d);";
                    var66_61 = 3;
                    var4_8 = new Object[var66_61];
                    var52_50 = 0;
                    var5_9 = null;
                    var4_8[0] = var57_55;
                    var52_50 = 1;
                    var4_8[var52_50] = var57_55;
                    var52_50 = 10000;
                    var4_8[var54_52] = var5_9 = Integer.valueOf(var52_50);
                    var2_2 = String.format((String)var2_2, var4_8);
                    var3_3 /* !! */ .execSQL((String)var2_2);
                    if (var26_29 != null) {
                        var6_10 = var26_29;
                        var3_3 /* !! */  = var38_41 /* !! */ ;
                        var16_20 = (int)var26_29.has((String)var38_41 /* !! */ );
                        if (var16_20 == 0) {
                            var3_3 /* !! */  = var56_54 /* !! */ ;
                            var16_20 = (int)var26_29.has((String)var56_54 /* !! */ );
                            if (var16_20 == 0) {
                                var3_3 /* !! */  = var1_1.a;
                                c$c.b((c$c)var3_3 /* !! */ );
                            }
                        }
                    }
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                    var3_3 /* !! */ .setTransactionSuccessful();
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
                    var3_3 /* !! */ .setTransactionSuccessful();
                }
                try {
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                    if (var3_3 /* !! */  != null) {
                        var3_3 /* !! */  = var1_1.a;
                        var3_3 /* !! */  = var3_3 /* !! */ .a;
                        var16_20 = (int)(var3_3 /* !! */  = c.b((c)var3_3 /* !! */ )).isOpen();
                        if (var16_20 != 0) {
                            var3_3 /* !! */  = var1_1.a;
                            var3_3 /* !! */  = var3_3 /* !! */ .a;
                            var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                            var3_3 /* !! */ .endTransaction();
                        }
                    }
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    if ((var3_3 /* !! */  = c.c((c)var3_3 /* !! */ )) == null) break block76;
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var16_20 = (int)(var3_3 /* !! */  = c.c((c)var3_3 /* !! */ )).isOpen();
                    if (var16_20 == 0) break block76;
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
                    ** GOTO lbl668
                }
                catch (Exception v2) {}
lbl642:
                // 2 sources

                catch (Exception v3) {}
                {
                    var3_3 /* !! */  = var1_1.a;
                    c$c.b((c$c)var3_3 /* !! */ );
                }
                var3_3 /* !! */  = var1_1.a;
                var3_3 /* !! */  = var3_3 /* !! */ .a;
                var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                if (var3_3 /* !! */  != null) {
                    var3_3 /* !! */  = var1_1.a;
                    var3_3 /* !! */  = var3_3 /* !! */ .a;
                    var16_20 = (var3_3 /* !! */  = c.b((c)var3_3 /* !! */ )).isOpen();
                    if (var16_20 != 0) {
                        var3_3 /* !! */  = var1_1.a;
                        var3_3 /* !! */  = var3_3 /* !! */ .a;
                        var3_3 /* !! */  = c.b((c)var3_3 /* !! */ );
                        var3_3 /* !! */ .endTransaction();
                    }
                }
                var3_3 /* !! */  = var1_1.a;
                var3_3 /* !! */  = var3_3 /* !! */ .a;
                if ((var3_3 /* !! */  = c.c((c)var3_3 /* !! */ )) == null) break block76;
                var3_3 /* !! */  = var1_1.a;
                var3_3 /* !! */  = var3_3 /* !! */ .a;
                var16_20 = (var3_3 /* !! */  = c.c((c)var3_3 /* !! */ )).isOpen();
                if (var16_20 == 0) break block76;
                var3_3 /* !! */  = var1_1.a;
                var3_3 /* !! */  = var3_3 /* !! */ .a;
                var3_3 /* !! */  = c.c((c)var3_3 /* !! */ );
lbl668:
                // 2 sources

                var3_3 /* !! */ .endTransaction();
            }
        }
        var3_3 /* !! */  = var1_1.a;
        var3_3 /* !! */ .j = null;
        c$c.a((c$c)var3_3 /* !! */ , false);
    }
}

