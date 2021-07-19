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

public final class p
extends l$b {
    public p(String string3, String string4, String string5, int n11, int n12) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List a(JSONObject var1_1, String var2_2, int var3_3) {
        var4_4 = "y";
        var5_5 /* !! */  = "x";
        var6_6 /* !! */  = "rk";
        var7_7 = "tp";
        var8_8 = "ne";
        var9_9 = "pid";
        var10_10 = "\",\"";
        var11_11 = var1_1.keys();
        var12_12 = new ArrayList<Object>();
        var13_13 = new StringBuffer();
        while (true) {
            block67: {
                block65: {
                    var14_14 = var11_11.hasNext();
                    var15_15 = "INSERT OR REPLACE INTO %s VALUES %s";
                    var16_16 = 1;
                    if (!var14_14) break;
                    var17_17 = new StringBuffer();
                    var18_18 = (String)var11_11.next();
                    var19_19 = var2_2;
                    l$b.a(var13_13, var18_18, var2_2, var16_16);
                    try {
                        var21_21 /* !! */  = var20_20 = var1_1.getJSONArray(var18_18);
                    }
                    catch (JSONException v0) {
                        var21_21 /* !! */  = null;
                    }
                    if (var21_21 /* !! */  == null) break block65;
                    var22_22 = var11_11;
                    var23_23 = 0;
                    var11_11 = null;
                    block44: while (true) {
                        block66: {
                            block64: {
                                block63: {
                                    block62: {
                                        block61: {
                                            block60: {
                                                block59: {
                                                    block58: {
                                                        block57: {
                                                            block56: {
                                                                block55: {
                                                                    block54: {
                                                                        block53: {
                                                                            block52: {
                                                                                var24_24 = var21_21 /* !! */ .length();
                                                                                var25_25 = "RGCPOI";
                                                                                if (var23_23 >= var24_24) break;
                                                                                var19_19 = var21_21 /* !! */ .getJSONObject(var23_23);
                                                                                var26_26 = var19_19.has(var9_9);
                                                                                if (!var26_26) break block52;
                                                                                var27_27 = var19_19.getString(var9_9);
                                                                                var28_28 = var9_9;
                                                                                var9_9 = var27_27;
                                                                                break block53;
                                                                            }
                                                                            var28_28 = var9_9;
                                                                            var9_9 = null;
                                                                        }
                                                                        var29_29 = var19_19.has(var8_8);
                                                                        if (!var29_29) break block54;
                                                                        var27_27 = var19_19.getString(var8_8);
                                                                        var30_30 = var8_8;
                                                                        var8_8 = var27_27;
                                                                        break block55;
                                                                    }
                                                                    var30_30 = var8_8;
                                                                    var31_31 = 0;
                                                                    var8_8 = null;
                                                                }
                                                                var32_32 = var19_19.has(var7_7);
                                                                if (!var32_32) break block56;
                                                                var27_27 = var19_19.getString(var7_7);
                                                                var33_33 = var7_7;
                                                                var7_7 = var27_27;
                                                                break block57;
                                                            }
                                                            var33_33 = var7_7;
                                                            var34_34 = 0;
                                                            var7_7 = null;
                                                        }
                                                        var35_35 = var19_19.has((String)var6_6 /* !! */ );
                                                        if (var35_35 == 0) break block58;
                                                        var35_35 = var19_19.getInt((String)var6_6 /* !! */ );
                                                        var27_27 = var35_35;
                                                        var36_36 = var6_6 /* !! */ ;
                                                        var6_6 /* !! */  = var27_27;
                                                        break block59;
                                                    }
                                                    var36_36 = var6_6 /* !! */ ;
                                                    var37_37 = 0;
                                                    var6_6 /* !! */  = null;
                                                }
                                                var38_38 = var19_19.has((String)var5_5 /* !! */ );
                                                if (!var38_38) break block60;
                                                var39_39 = var19_19.getDouble((String)var5_5 /* !! */ );
                                                var27_27 = var39_39;
                                                var41_40 = var5_5 /* !! */ ;
                                                var5_5 /* !! */  = var27_27;
                                                break block61;
                                            }
                                            var41_40 = var5_5 /* !! */ ;
                                            var42_41 = 0;
                                            var5_5 /* !! */  = null;
                                        }
                                        var43_42 = var19_19.has((String)var4_4);
                                        if (var43_42 == 0) break block62;
                                        var44_43 = var19_19.getDouble((String)var4_4);
                                        var19_19 = var44_43;
                                        break block63;
                                    }
                                    var24_24 = 0;
                                    var19_19 = null;
                                }
                                var43_42 = var17_17.length();
                                var46_44 = var4_4;
                                var4_4 = ",";
                                if (var43_42 <= 0) break block64;
                                var17_17.append((String)var4_4);
                            }
                            var47_45 = var21_21 /* !! */ ;
                            var21_21 /* !! */  = "(\"";
                            var17_17.append((String)var21_21 /* !! */ );
                            var17_17.append(var9_9);
                            var17_17.append(var10_10);
                            var17_17.append(var18_18);
                            var17_17.append(var10_10);
                            var17_17.append(var8_8);
                            var17_17.append(var10_10);
                            var17_17.append(var7_7);
                            var7_7 = "\",";
                            var17_17.append(var7_7);
                            var17_17.append(var5_5 /* !! */ );
                            var17_17.append((String)var4_4);
                            var17_17.append(var19_19);
                            var17_17.append((String)var4_4);
                            var17_17.append(var6_6 /* !! */ );
                            var4_4 = ")";
                            var17_17.append((String)var4_4);
                            ** GOTO lbl209
                            catch (JSONException v1) {
                                var46_44 = var4_4;
                            }
                            break block66;
                            catch (JSONException v2) {
                                var46_44 = var4_4;
                                var41_40 = var5_5 /* !! */ ;
                            }
                            break block66;
                            catch (JSONException v3) {
                                var46_44 = var4_4;
                                var41_40 = var5_5 /* !! */ ;
                                var36_36 = var6_6 /* !! */ ;
                            }
                            break block66;
                            catch (JSONException v4) {
                                var46_44 = var4_4;
                                var41_40 = var5_5 /* !! */ ;
                                var36_36 = var6_6 /* !! */ ;
                                var33_33 = var7_7;
                            }
                            break block66;
                            catch (JSONException v5) {
                                var46_44 = var4_4;
                                var41_40 = var5_5 /* !! */ ;
                                var36_36 = var6_6 /* !! */ ;
                                var33_33 = var7_7;
                                var30_30 = var8_8;
                            }
                            break block66;
                            catch (JSONException v6) {
                                var46_44 = var4_4;
                                var41_40 = var5_5 /* !! */ ;
                                var36_36 = var6_6 /* !! */ ;
                                var33_33 = var7_7;
                                var30_30 = var8_8;
                                var28_28 = var9_9;
                            }
                        }
lbl207:
                        // 2 sources

                        while (true) {
                            var47_45 = var21_21 /* !! */ ;
lbl209:
                            // 3 sources

                            while (true) {
                                var48_46 = var23_23 % 50;
                                var42_41 = 49;
                                if (var48_46 == var42_41) {
                                    var4_4 = Locale.US;
                                    var6_6 /* !! */  = new Object[2];
                                    var42_41 = 0;
                                    var5_5 /* !! */  = null;
                                    var6_6 /* !! */ [0] = var25_25;
                                    var7_7 = var17_17.toString();
                                    var31_31 = 1;
                                    var6_6 /* !! */ [var31_31] = var7_7;
                                    var4_4 = String.format((Locale)var4_4, var15_15, var6_6 /* !! */ );
                                    var12_12.add(var4_4);
                                    var17_17.setLength(0);
                                } else {
                                    var42_41 = 0;
                                    var5_5 /* !! */  = null;
                                }
                                ++var23_23;
                                var9_9 = var28_28;
                                var8_8 = var30_30;
                                var7_7 = var33_33;
                                var6_6 /* !! */  = var36_36;
                                var5_5 /* !! */  = var41_40;
                                var21_21 /* !! */  = var47_45;
                                var4_4 = var46_44;
                                continue block44;
                                break;
                            }
                            break;
                        }
                        break;
                    }
                    var46_44 = var4_4;
                    var41_40 = var5_5 /* !! */ ;
                    var36_36 = var6_6 /* !! */ ;
                    var33_33 = var7_7;
                    var30_30 = var8_8;
                    var28_28 = var9_9;
                    var42_41 = 0;
                    var5_5 /* !! */  = null;
                    var48_46 = var17_17.length();
                    if (var48_46 > 0) {
                        var4_4 = Locale.US;
                        var37_37 = 2;
                        var6_6 /* !! */  = new Object[var37_37];
                        var6_6 /* !! */ [0] = var25_25;
                        var5_5 /* !! */  = var17_17.toString();
                        var34_34 = 1;
                        var6_6 /* !! */ [var34_34] = var5_5 /* !! */ ;
                        var4_4 = String.format((Locale)var4_4, var15_15, var6_6 /* !! */ );
                        var12_12.add(var4_4);
                    }
                    break block67;
                }
                var46_44 = var4_4;
                var41_40 = var5_5 /* !! */ ;
                var36_36 = var6_6 /* !! */ ;
                var33_33 = var7_7;
                var30_30 = var8_8;
                var28_28 = var9_9;
                var22_22 = var11_11;
            }
            var11_11 = var22_22;
            var9_9 = var28_28;
            var8_8 = var30_30;
            var7_7 = var33_33;
            var6_6 /* !! */  = var36_36;
            var5_5 /* !! */  = var41_40;
            var4_4 = var46_44;
        }
        var48_46 = var13_13.length();
        if (var48_46 > 0) {
            var4_4 = Locale.US;
            var42_41 = 2;
            var5_5 /* !! */  = new Object[var42_41];
            var6_6 /* !! */  = "RGCUPDATE";
            var34_34 = 0;
            var7_7 = null;
            var5_5 /* !! */ [0] = var6_6 /* !! */ ;
            var37_37 = 1;
            var5_5 /* !! */ [var37_37] = var13_13;
            var4_4 = String.format((Locale)var4_4, var15_15, var5_5 /* !! */ );
            var12_12.add(var4_4);
        } else {
            var37_37 = 1;
            var34_34 = 0;
            var7_7 = null;
        }
        var4_4 = Locale.US;
        var5_5 /* !! */  = new Object[var37_37];
        var6_6 /* !! */  = var3_3;
        var5_5 /* !! */ [0] = var6_6 /* !! */ ;
        var4_4 = String.format((Locale)var4_4, "DELETE FROM RGCPOI WHERE pid NOT IN (SELECT pid FROM RGCPOI LIMIT %d);", var5_5 /* !! */ );
        var12_12.add(var4_4);
        return var12_12;
        catch (JSONException v7) {
            ** continue;
        }
        catch (JSONException v8) {
            ** continue;
        }
    }
}

