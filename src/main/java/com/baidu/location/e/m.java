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

public final class m
extends l$b {
    public m(String string3, String string4, String string5, int n11, int n12) {
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public List a(JSONObject var1_1, String var2_2, int var3_3) {
        var4_4 = "dist";
        var5_5 /* !! */  = "ct";
        var6_6 = "ctc";
        var7_7 /* !! */  = "prov";
        var8_8 = "cyc";
        var9_9 = "cy";
        var10_10 = "\",\"";
        var11_11 = var1_1.keys();
        var12_12 = new StringBuffer();
        var13_13 = new StringBuffer();
        var14_14 = new ArrayList<Object>();
        var15_15 = 0;
        block42: while (true) {
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
                                                    block51: {
                                                        block50: {
                                                            block49: {
                                                                var16_16 = var11_11.hasNext();
                                                                var17_17 = "RGCUPDATE";
                                                                var18_18 = "RGCAREA";
                                                                var19_19 = "INSERT OR REPLACE INTO %s VALUES %s";
                                                                var20_20 = var17_17;
                                                                if (!var16_16) break;
                                                                var21_21 = (String)var11_11.next();
                                                                var17_17 = var1_1;
                                                                var22_22 = var11_11;
                                                                var11_11 = var1_1.getJSONObject(var21_21);
                                                                var23_23 = var11_11.has(var9_9);
                                                                var24_24 = 0;
                                                                var25_25 = null;
                                                                if (!var23_23) break block49;
                                                                var26_26 = var11_11.getString(var9_9);
                                                                var27_27 = var9_9;
                                                                var9_9 = var26_26;
                                                                break block50;
                                                            }
                                                            var27_27 = var9_9;
                                                            var28_28 = 0;
                                                            var9_9 = null;
                                                        }
                                                        var29_29 = var11_11.has(var8_8);
                                                        if (!var29_29) break block51;
                                                        var26_26 = var11_11.getString(var8_8);
                                                        var30_30 = var8_8;
                                                        var8_8 = var26_26;
                                                        break block52;
                                                    }
                                                    var30_30 = var8_8;
                                                    var8_8 = null;
                                                }
                                                var31_31 = var11_11.has((String)var7_7 /* !! */ );
                                                if (!var31_31) break block53;
                                                var26_26 = var11_11.getString((String)var7_7 /* !! */ );
                                                var32_32 = var7_7 /* !! */ ;
                                                var7_7 /* !! */  = var26_26;
                                                break block54;
                                            }
                                            var32_32 = var7_7 /* !! */ ;
                                            var33_33 = 0;
                                            var7_7 /* !! */  = null;
                                        }
                                        var34_34 = var11_11.has((String)var6_6);
                                        if (!var34_34) break block55;
                                        var26_26 = var11_11.getString((String)var6_6);
                                        var35_35 = var6_6;
                                        var6_6 = var26_26;
                                        break block56;
                                    }
                                    var35_35 = var6_6;
                                    var36_36 = 0;
                                    var6_6 = null;
                                }
                                var37_37 = var11_11.has((String)var5_5 /* !! */ );
                                if (!var37_37) break block57;
                                var26_26 = var11_11.getString((String)var5_5 /* !! */ );
                                var38_38 = var5_5 /* !! */ ;
                                var5_5 /* !! */  = var26_26;
                                break block58;
                            }
                            var38_38 = var5_5 /* !! */ ;
                            var39_39 = 0;
                            var5_5 /* !! */  = null;
                        }
                        var40_40 = var11_11.has((String)var4_4);
                        if (!var40_40) break block59;
                        var25_25 = var11_11.getString((String)var4_4);
                    }
                    var11_11 = var25_25;
                    var24_24 = var12_12.length();
                    if (var24_24 <= 0) break block60;
                    var25_25 = var4_4;
                    var4_4 = ",";
                    var12_12.append((String)var4_4);
                }
                var25_25 = var4_4;
                var4_4 = "(\"";
                var12_12.append((String)var4_4);
                var12_12.append(var21_21);
                var12_12.append(var10_10);
                var12_12.append(var9_9);
                var12_12.append(var10_10);
                var12_12.append(var8_8);
                var12_12.append(var10_10);
                var12_12.append((String)var7_7 /* !! */ );
                var12_12.append(var10_10);
                var12_12.append((String)var5_5 /* !! */ );
                var12_12.append(var10_10);
                var12_12.append((String)var6_6);
                var12_12.append(var10_10);
                var12_12.append((String)var11_11);
                var4_4 = "\",";
                var12_12.append((String)var4_4);
                var41_41 = System.currentTimeMillis();
                var43_42 = 1000L;
                var41_41 /= var43_42;
                var12_12.append(var41_41);
                var4_4 = ",\"\")";
                var12_12.append((String)var4_4);
                var4_4 = var2_2;
                var39_39 = 0;
                var5_5 /* !! */  = null;
                l$b.a(var13_13, var21_21, var2_2, 0);
                ** GOTO lbl208
                catch (JSONException v0) {
                    var25_25 = var4_4;
                }
                break block61;
                catch (JSONException v1) {
                    var25_25 = var4_4;
                    var38_38 = var5_5 /* !! */ ;
                }
                break block61;
                catch (JSONException v2) {
                    var25_25 = var4_4;
                    var38_38 = var5_5 /* !! */ ;
                    var35_35 = var6_6;
                }
                break block61;
                catch (JSONException v3) {
                    var25_25 = var4_4;
                    var38_38 = var5_5 /* !! */ ;
                    var35_35 = var6_6;
                    var32_32 = var7_7 /* !! */ ;
                }
                break block61;
                catch (JSONException v4) {
                    var25_25 = var4_4;
                    var38_38 = var5_5 /* !! */ ;
                    var35_35 = var6_6;
                    var32_32 = var7_7 /* !! */ ;
                    var30_30 = var8_8;
                }
                break block61;
                catch (JSONException v5) {
                    var25_25 = var4_4;
                    var38_38 = var5_5 /* !! */ ;
                    var35_35 = var6_6;
                    var32_32 = var7_7 /* !! */ ;
                    var30_30 = var8_8;
                    var27_27 = var9_9;
                }
            }
lbl206:
            // 2 sources

            while (true) {
                var4_4 = var2_2;
lbl208:
                // 3 sources

                while (true) {
                    var39_39 = var15_15 % 50;
                    var36_36 = 49;
                    if (var39_39 == var36_36 && (var39_39 = var12_12.length()) > 0) {
                        var5_5 /* !! */  = Locale.US;
                        var36_36 = 2;
                        var7_7 /* !! */  = new Object[var36_36];
                        var8_8 = null;
                        var7_7 /* !! */ [0] = var18_18;
                        var28_28 = 1;
                        var7_7 /* !! */ [var28_28] = var12_12;
                        var7_7 /* !! */  = String.format((Locale)var5_5 /* !! */ , var19_19, var7_7 /* !! */ );
                        var14_14.add(var7_7 /* !! */ );
                        var6_6 = new Object[var36_36];
                        var6_6[0] = var20_20;
                        var6_6[var28_28] = var13_13;
                        var5_5 /* !! */  = String.format((Locale)var5_5 /* !! */ , var19_19, var6_6);
                        var14_14.add(var5_5 /* !! */ );
                        var12_12.setLength(0);
                    } else {
                        var8_8 = null;
                    }
                    ++var15_15;
                    var11_11 = var22_22;
                    var9_9 = var27_27;
                    var4_4 = var25_25;
                    var8_8 = var30_30;
                    var7_7 /* !! */  = var32_32;
                    var6_6 = var35_35;
                    var5_5 /* !! */  = var38_38;
                    continue block42;
                    break;
                }
                break;
            }
            break;
        }
        var8_8 = null;
        var45_43 = var12_12.length();
        if (var45_43 > 0) {
            var4_4 = Locale.US;
            var39_39 = 2;
            var6_6 = new Object[var39_39];
            var6_6[0] = var18_18;
            var33_33 = 1;
            var6_6[var33_33] = var12_12;
            var6_6 = String.format((Locale)var4_4, var19_19, var6_6);
            var14_14.add(var6_6);
            var5_5 /* !! */  = new Object[var39_39];
            var5_5 /* !! */ [0] = var17_17;
            var5_5 /* !! */ [var33_33] = var13_13;
            var4_4 = String.format((Locale)var4_4, var19_19, var5_5 /* !! */ );
            var14_14.add(var4_4);
            var12_12.setLength(0);
        } else {
            var33_33 = 1;
        }
        var4_4 = Locale.US;
        var5_5 /* !! */  = new Object[var33_33];
        var5_5 /* !! */ [0] = var6_6 = Integer.valueOf(var3_3);
        var4_4 = String.format((Locale)var4_4, "DELETE FROM RGCAREA WHERE gridkey NOT IN (SELECT gridkey FROM RGCAREA LIMIT %d);", var5_5 /* !! */ );
        var14_14.add(var4_4);
        return var14_14;
        catch (JSONException v6) {
            ** continue;
        }
        catch (JSONException v7) {
            ** continue;
        }
    }
}

