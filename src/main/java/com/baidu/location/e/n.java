/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.baidu.location.e;

import com.baidu.location.e.l$b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

public final class n
extends l$b {
    public n(String string3, String string4, String string5, int n11, int n12) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List a(JSONObject var1_1, String var2_2, int var3_3) {
        var4_4 = "y2";
        var5_5 /* !! */  = "x2";
        var6_6 = "y1";
        var7_7 = "x1";
        var8_8 = "st";
        var9_9 = var1_1.keys();
        var10_10 = new ArrayList<Object>();
        var11_11 = new StringBuffer();
        while (true) {
            block61: {
                block59: {
                    var12_12 = var9_9.hasNext();
                    var13_13 = "INSERT OR REPLACE INTO %s VALUES %s";
                    var14_14 = 0;
                    if (!var12_12) break;
                    var15_15 = new StringBuffer();
                    var16_16 = (String)var9_9.next();
                    l$b.a(var11_11, var16_16, var2_2, 0);
                    try {
                        var18_18 = var17_17 = var1_1.getJSONArray(var16_16);
                    }
                    catch (JSONException v0) {
                        var18_18 = null;
                    }
                    if (var18_18 == null) break block59;
                    while (true) {
                        block58: {
                            block60: {
                                block57: {
                                    block56: {
                                        block55: {
                                            block54: {
                                                block53: {
                                                    block52: {
                                                        block51: {
                                                            block50: {
                                                                block49: {
                                                                    block48: {
                                                                        block47: {
                                                                            var19_19 = var18_18.length();
                                                                            var20_20 = "RGCROAD";
                                                                            if (var14_14 >= var19_19) break;
                                                                            var21_21 /* !! */  = var18_18.getJSONObject(var14_14);
                                                                            var22_22 = var21_21 /* !! */ .has(var8_8);
                                                                            if (!var22_22) break block47;
                                                                            var23_23 = var21_21 /* !! */ .getString(var8_8);
                                                                            var24_24 = var8_8;
                                                                            var8_8 = var23_23;
                                                                            break block48;
                                                                        }
                                                                        var24_24 = var8_8;
                                                                        var25_25 = 0;
                                                                        var8_8 = null;
                                                                    }
                                                                    var26_26 = var21_21 /* !! */ .has((String)var7_7);
                                                                    if (!var26_26) break block49;
                                                                    var27_27 = var21_21 /* !! */ .getDouble((String)var7_7);
                                                                    var23_23 = var27_27;
                                                                    var29_28 = var7_7;
                                                                    var7_7 = var23_23;
                                                                    break block50;
                                                                }
                                                                var29_28 = var7_7;
                                                                var30_29 = 0;
                                                                var7_7 = null;
                                                            }
                                                            var31_30 = var21_21 /* !! */ .has((String)var6_6);
                                                            if (!var31_30) break block51;
                                                            var32_31 = var21_21 /* !! */ .getDouble((String)var6_6);
                                                            var23_23 = var32_31;
                                                            var34_32 = var6_6;
                                                            var6_6 = var23_23;
                                                            break block52;
                                                        }
                                                        var34_32 = var6_6;
                                                        var35_33 = 0;
                                                        var6_6 = null;
                                                    }
                                                    var36_34 = var21_21 /* !! */ .has((String)var5_5 /* !! */ );
                                                    if (!var36_34) break block53;
                                                    var37_35 = var21_21 /* !! */ .getDouble((String)var5_5 /* !! */ );
                                                    var23_23 = var37_35;
                                                    var39_36 = var5_5 /* !! */ ;
                                                    var5_5 /* !! */  = var23_23;
                                                    break block54;
                                                }
                                                var39_36 = var5_5 /* !! */ ;
                                                var40_37 = 0;
                                                var5_5 /* !! */  = null;
                                            }
                                            try {
                                                var41_38 = var21_21 /* !! */ .has((String)var4_4);
                                                if (var41_38 == 0) break block55;
                                            }
                                            catch (JSONException v1) {}
                                            var42_39 = var21_21 /* !! */ .getDouble((String)var4_4);
                                            var21_21 /* !! */  = Double.valueOf(var42_39);
                                            break block56;
                                        }
                                        var19_19 = 0;
                                        var21_21 /* !! */  = null;
                                    }
                                    if (var8_8 == null || var7_7 == null || var6_6 == null || var5_5 /* !! */  == null || var21_21 /* !! */  == null) break block60;
                                    var41_38 = var15_15.length();
                                    var44_40 = var4_4;
                                    var4_4 = ",";
                                    if (var41_38 <= 0) break block57;
                                    var15_15.append((String)var4_4);
                                }
                                var45_41 = var9_9;
                                var9_9 = "(NULL,\"";
                                var15_15.append((String)var9_9);
                                var15_15.append(var16_16);
                                var9_9 = "\",\"";
                                var15_15.append((String)var9_9);
                                var15_15.append(var8_8);
                                var8_8 = "\",";
                                var15_15.append(var8_8);
                                var15_15.append(var7_7);
                                var15_15.append((String)var4_4);
                                var15_15.append(var6_6);
                                var15_15.append((String)var4_4);
                                var15_15.append(var5_5 /* !! */ );
                                var15_15.append((String)var4_4);
                                var15_15.append(var21_21 /* !! */ );
                                var4_4 = ")";
                                try {
                                    var15_15.append((String)var4_4);
                                    break block58;
                                }
                                catch (JSONException v6) {}
                            }
                            var44_40 = var4_4;
lbl157:
                            // 6 sources

                            while (true) {
                                var45_41 = var9_9;
                                break block58;
                                break;
                            }
                            catch (JSONException v2) {
                                var44_40 = var4_4;
                                var39_36 = var5_5 /* !! */ ;
                            }
                            ** GOTO lbl157
                            catch (JSONException v3) {
                                var44_40 = var4_4;
                                var39_36 = var5_5 /* !! */ ;
                                var34_32 = var6_6;
                            }
                            ** GOTO lbl157
                            catch (JSONException v4) {
                                var44_40 = var4_4;
                                var39_36 = var5_5 /* !! */ ;
                                var34_32 = var6_6;
                                var29_28 = var7_7;
                            }
                            ** GOTO lbl157
                            catch (JSONException v5) {
                                var44_40 = var4_4;
                                var39_36 = var5_5 /* !! */ ;
                                var34_32 = var6_6;
                                var29_28 = var7_7;
                                var24_24 = var8_8;
                            }
                            ** GOTO lbl157
                        }
                        var46_42 = var14_14 % 50;
                        var40_37 = 49;
                        if (var46_42 == var40_37 && (var46_42 = var15_15.length()) > 0) {
                            var4_4 = Locale.US;
                            var6_6 = new Object[2];
                            var40_37 = 0;
                            var5_5 /* !! */  = null;
                            var6_6[0] = var20_20;
                            var7_7 = var15_15.toString();
                            var25_25 = 1;
                            var6_6[var25_25] = var7_7;
                            var4_4 = String.format((Locale)var4_4, var13_13, var6_6);
                            var10_10.add(var4_4);
                            var15_15.setLength(0);
                        } else {
                            var40_37 = 0;
                            var5_5 /* !! */  = null;
                        }
                        ++var14_14;
                        var8_8 = var24_24;
                        var7_7 = var29_28;
                        var6_6 = var34_32;
                        var5_5 /* !! */  = var39_36;
                        var9_9 = var45_41;
                        var4_4 = var44_40;
                    }
                    var44_40 = var4_4;
                    var39_36 = var5_5 /* !! */ ;
                    var34_32 = var6_6;
                    var29_28 = var7_7;
                    var24_24 = var8_8;
                    var45_41 = var9_9;
                    var40_37 = 0;
                    var5_5 /* !! */  = null;
                    var46_42 = var15_15.length();
                    if (var46_42 > 0) {
                        var4_4 = Locale.US;
                        var35_33 = 2;
                        var6_6 = new Object[var35_33];
                        var6_6[0] = var20_20;
                        var5_5 /* !! */  = var15_15.toString();
                        var30_29 = 1;
                        var6_6[var30_29] = var5_5 /* !! */ ;
                        var4_4 = String.format((Locale)var4_4, var13_13, var6_6);
                        var10_10.add(var4_4);
                    }
                    break block61;
                }
                var44_40 = var4_4;
                var39_36 = var5_5 /* !! */ ;
                var34_32 = var6_6;
                var29_28 = var7_7;
                var24_24 = var8_8;
                var45_41 = var9_9;
            }
            var8_8 = var24_24;
            var7_7 = var29_28;
            var6_6 = var34_32;
            var5_5 /* !! */  = var39_36;
            var9_9 = var45_41;
            var4_4 = var44_40;
        }
        var46_42 = var11_11.length();
        if (var46_42 > 0) {
            var4_4 = Locale.US;
            var40_37 = 2;
            var5_5 /* !! */  = new Object[var40_37];
            var6_6 = "RGCUPDATE";
            var30_29 = 0;
            var7_7 = null;
            var5_5 /* !! */ [0] = var6_6;
            var35_33 = 1;
            var5_5 /* !! */ [var35_33] = var11_11;
            var4_4 = String.format((Locale)var4_4, var13_13, var5_5 /* !! */ );
            var10_10.add(var4_4);
        } else {
            var35_33 = 1;
            var30_29 = 0;
            var7_7 = null;
        }
        var4_4 = Locale.US;
        var5_5 /* !! */  = new Object[var35_33];
        var6_6 = var3_3;
        var5_5 /* !! */ [0] = var6_6;
        var4_4 = String.format((Locale)var4_4, "DELETE FROM RGCROAD WHERE _id NOT IN (SELECT _id FROM RGCROAD LIMIT %d);", var5_5 /* !! */ );
        var10_10.add(var4_4);
        return var10_10;
        catch (JSONException v7) {
            ** continue;
        }
    }
}

