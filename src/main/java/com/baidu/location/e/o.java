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

public final class o
extends l$b {
    public o(String string3, String string4, String string5, int n11, int n12) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List a(JSONObject var1_1, String var2_2, int var3_3) {
        var4_4 = "\",\"";
        var5_5 /* !! */  = "y";
        var6_6 = "x";
        var7_7 /* !! */  = "stn";
        var8_8 = "st";
        var9_9 = var1_1.keys();
        var10_10 = new ArrayList<Object>();
        var11_11 = new StringBuffer();
        while (true) {
            block52: {
                block50: {
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
                    if (var18_18 == null) break block50;
                    block33: while (true) {
                        block51: {
                            block49: {
                                block48: {
                                    block47: {
                                        block46: {
                                            block45: {
                                                block44: {
                                                    block43: {
                                                        block42: {
                                                            block41: {
                                                                var19_19 = var18_18.length();
                                                                var20_20 = "RGCSITE";
                                                                if (var14_14 >= var19_19) break;
                                                                var21_21 /* !! */  = var18_18.getJSONObject(var14_14);
                                                                var22_22 = var21_21 /* !! */ .has(var8_8);
                                                                if (!var22_22) break block41;
                                                                var23_23 = var21_21 /* !! */ .getString(var8_8);
                                                                var24_24 = var8_8;
                                                                var8_8 = var23_23;
                                                                break block42;
                                                            }
                                                            var24_24 = var8_8;
                                                            var25_25 = 0;
                                                            var8_8 = null;
                                                        }
                                                        var26_26 = var21_21 /* !! */ .has((String)var7_7 /* !! */ );
                                                        if (!var26_26) break block43;
                                                        var23_23 = var21_21 /* !! */ .getString((String)var7_7 /* !! */ );
                                                        var27_27 = var7_7 /* !! */ ;
                                                        var7_7 /* !! */  = var23_23;
                                                        break block44;
                                                    }
                                                    var27_27 = var7_7 /* !! */ ;
                                                    var28_28 = 0;
                                                    var7_7 /* !! */  = null;
                                                }
                                                var29_29 = var21_21 /* !! */ .has((String)var6_6);
                                                if (!var29_29) break block45;
                                                var30_30 = var21_21 /* !! */ .getDouble((String)var6_6);
                                                var23_23 = var30_30;
                                                var32_31 = var6_6;
                                                var6_6 = var23_23;
                                                break block46;
                                            }
                                            var32_31 = var6_6;
                                            var33_32 = 0;
                                            var6_6 = null;
                                        }
                                        var34_33 = var21_21 /* !! */ .has((String)var5_5 /* !! */ );
                                        if (var34_33 == 0) break block47;
                                        var35_34 = var21_21 /* !! */ .getDouble((String)var5_5 /* !! */ );
                                        var21_21 /* !! */  = Double.valueOf(var35_34);
                                        break block48;
                                    }
                                    var19_19 = 0;
                                    var21_21 /* !! */  = null;
                                }
                                var34_33 = var15_15.length();
                                var37_35 = var5_5 /* !! */ ;
                                var5_5 /* !! */  = ",";
                                if (var34_33 <= 0) break block49;
                                var15_15.append((String)var5_5 /* !! */ );
                            }
                            var38_36 = var9_9;
                            var9_9 = "(NULL,\"";
                            var15_15.append((String)var9_9);
                            var15_15.append(var16_16);
                            var15_15.append((String)var4_4);
                            var15_15.append(var8_8);
                            var15_15.append((String)var4_4);
                            var15_15.append((String)var7_7 /* !! */ );
                            var7_7 /* !! */  = "\",";
                            var15_15.append((String)var7_7 /* !! */ );
                            var15_15.append(var6_6);
                            var15_15.append((String)var5_5 /* !! */ );
                            var15_15.append(var21_21 /* !! */ );
                            var5_5 /* !! */  = ")";
                            var15_15.append((String)var5_5 /* !! */ );
                            ** GOTO lbl149
                            catch (JSONException v1) {
                                var37_35 = var5_5 /* !! */ ;
                            }
                            break block51;
                            catch (JSONException v2) {
                                var37_35 = var5_5 /* !! */ ;
                                var32_31 = var6_6;
                            }
                            break block51;
                            catch (JSONException v3) {
                                var37_35 = var5_5 /* !! */ ;
                                var32_31 = var6_6;
                                var27_27 = var7_7 /* !! */ ;
                            }
                            break block51;
                            catch (JSONException v4) {
                                var37_35 = var5_5 /* !! */ ;
                                var32_31 = var6_6;
                                var27_27 = var7_7 /* !! */ ;
                                var24_24 = var8_8;
                            }
                        }
lbl147:
                        // 2 sources

                        while (true) {
                            var38_36 = var9_9;
lbl149:
                            // 3 sources

                            while (true) {
                                var39_37 = var14_14 % 50;
                                var33_32 = 49;
                                if (var39_37 == var33_32 && (var39_37 = var15_15.length()) > 0) {
                                    var5_5 /* !! */  = Locale.US;
                                    var7_7 /* !! */  = new Object[2];
                                    var33_32 = 0;
                                    var6_6 = null;
                                    var7_7 /* !! */ [0] = var20_20;
                                    var8_8 = var15_15.toString();
                                    var40_38 = 1;
                                    var7_7 /* !! */ [var40_38] = var8_8;
                                    var5_5 /* !! */  = String.format((Locale)var5_5 /* !! */ , var13_13, var7_7 /* !! */ );
                                    var10_10.add(var5_5 /* !! */ );
                                    var15_15.setLength(0);
                                } else {
                                    var33_32 = 0;
                                    var6_6 = null;
                                }
                                ++var14_14;
                                var8_8 = var24_24;
                                var7_7 /* !! */  = var27_27;
                                var6_6 = var32_31;
                                var9_9 = var38_36;
                                var5_5 /* !! */  = var37_35;
                                continue block33;
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    var37_35 = var5_5 /* !! */ ;
                    var32_31 = var6_6;
                    var27_27 = var7_7 /* !! */ ;
                    var24_24 = var8_8;
                    var38_36 = var9_9;
                    var33_32 = 0;
                    var6_6 = null;
                    var39_37 = var15_15.length();
                    if (var39_37 > 0) {
                        var5_5 /* !! */  = Locale.US;
                        var28_28 = 2;
                        var7_7 /* !! */  = new Object[var28_28];
                        var7_7 /* !! */ [0] = var20_20;
                        var6_6 = var15_15.toString();
                        var25_25 = 1;
                        var7_7 /* !! */ [var25_25] = var6_6;
                        var5_5 /* !! */  = String.format((Locale)var5_5 /* !! */ , var13_13, var7_7 /* !! */ );
                        var10_10.add(var5_5 /* !! */ );
                    }
                    break block52;
                }
                var37_35 = var5_5 /* !! */ ;
                var32_31 = var6_6;
                var27_27 = var7_7 /* !! */ ;
                var24_24 = var8_8;
                var38_36 = var9_9;
            }
            var8_8 = var24_24;
            var7_7 /* !! */  = var27_27;
            var6_6 = var32_31;
            var9_9 = var38_36;
            var5_5 /* !! */  = var37_35;
        }
        var41_39 = var11_11.length();
        if (var41_39 > 0) {
            var4_4 = Locale.US;
            var39_37 = 2;
            var5_5 /* !! */  = new Object[var39_37];
            var6_6 = "RGCUPDATE";
            var28_28 = 0;
            var7_7 /* !! */  = null;
            var5_5 /* !! */ [0] = var6_6;
            var33_32 = 1;
            var5_5 /* !! */ [var33_32] = var11_11;
            var4_4 = String.format((Locale)var4_4, var13_13, var5_5 /* !! */ );
            var10_10.add(var4_4);
        } else {
            var33_32 = 1;
            var28_28 = 0;
            var7_7 /* !! */  = null;
        }
        var4_4 = Locale.US;
        var5_5 /* !! */  = new Object[var33_32];
        var5_5 /* !! */ [0] = var6_6 = Integer.valueOf(var3_3);
        var4_4 = String.format((Locale)var4_4, "DELETE FROM RGCSITE WHERE _id NOT IN (SELECT _id FROM RGCSITE LIMIT %d);", var5_5 /* !! */ );
        var10_10.add(var4_4);
        return var10_10;
        catch (JSONException v5) {
            ** continue;
        }
        catch (JSONException v6) {
            ** continue;
        }
    }
}

