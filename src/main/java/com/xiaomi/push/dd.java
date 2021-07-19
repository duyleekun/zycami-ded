/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 */
package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.push.ay;
import com.xiaomi.push.az;
import com.xiaomi.push.cz;
import com.xiaomi.push.dc;
import com.xiaomi.push.dd$a;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

public abstract class dd {
    public static int a(int n10, int n11) {
        return (n11 + 243) / 1448 * 132 + 1080 + n10 + n11;
    }

    public static int a(int n10, int n11, int n12) {
        return (n11 + 200) / 1448 * 132 + 1011 + n11 + n10 + n12;
    }

    private static int a(dc dc2, String string2, List list, String string3) {
        int n10;
        int n11 = dc2.a();
        if (n11 == (n10 = 1)) {
            int n12 = string2.length();
            int n13 = dd.a(string3);
            return dd.a(n12, n13);
        }
        int n14 = dc2.a();
        if (n14 == (n11 = 2)) {
            n14 = dd.a(list);
            int n15 = string2.length();
            int n16 = dd.a(string3);
            return dd.a(n15, n14, n16);
        }
        return -1;
    }

    public static int a(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        if (bl2) {
            return 0;
        }
        String string2 = "UTF-8";
        try {
            object = ((String)object).getBytes(string2);
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            return 0;
        }
        return ((Object)object).length;
    }

    public static int a(List object) {
        int n10;
        object = object.iterator();
        int n11 = 0;
        while ((n10 = object.hasNext()) != 0) {
            Object object2 = (ay)object.next();
            String string2 = object2.a();
            int n12 = TextUtils.isEmpty((CharSequence)string2);
            if (n12 == 0) {
                string2 = object2.a();
                n12 = string2.length();
                n11 += n12;
            }
            if ((n12 = (int)(TextUtils.isEmpty((CharSequence)(string2 = object2.b())) ? 1 : 0)) != 0) continue;
            object2 = object2.b();
            n10 = ((String)object2).length();
            n11 += n10;
        }
        return n11 * 2;
    }

    public static String a(Context context, String string2, List list) {
        dd$a dd$a = new dd$a();
        return dd.a(context, string2, list, dd$a, true);
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static String a(Context var0, String var1_1, List var2_2, dc var3_3, boolean var4_4) {
        block40: {
            block41: {
                block32: {
                    block33: {
                        var5_5 = var0;
                        var6_6 = var1_1;
                        var7_10 = var2_2;
                        var8_11 = var3_3;
                        var9_12 = az.b(var0);
                        if (!var9_12) break block40;
                        var10_13 = new ArrayList();
                        if (!var4_4) break block32;
                        var11_14 = cz.a();
                        var11_14 = var11_14.a(var1_1);
                        if (var11_14 == null) break block33;
                        var10_13 = var11_14.a(var1_1);
                    }
                    var12_15 = var11_14;
                    break block41;
                }
                var12_15 = null;
            }
            var13_16 = var10_13.contains(var6_6);
            if (var13_16 != 0) ** GOTO lbl29
            try {
                var10_13.add(var6_6);
lbl29:
                // 2 sources

                var10_13 = var10_13.iterator();
                var13_16 = 0;
                var11_14 = null;
            }
            catch (MalformedURLException var6_9) {
                var6_9.printStackTrace();
            }
            while (true) {
                block42: {
                    block39: {
                        block38: {
                            block36: {
                                block37: {
                                    block35: {
                                        block34: {
                                            var14_17 = var10_13.hasNext();
                                            if (var14_17 == 0) break;
                                            var6_6 = var10_13.next();
                                            var15_18 /* !! */  = var6_6;
                                            var15_18 /* !! */  = var6_6;
                                            if (var7_10 == null) break block34;
                                            var6_6 = new ArrayList(var7_10);
                                            var16_19 = var6_6;
                                            break block35;
                                        }
                                        var16_19 = null;
                                    }
                                    var17_20 = System.currentTimeMillis();
                                    var14_17 = var8_11.a(var5_5, var15_18 /* !! */ , var16_19);
                                    if (var14_17 == 0) break;
                                    var19_21 = var8_11.a(var5_5, var15_18 /* !! */ , var16_19);
                                    var14_17 = TextUtils.isEmpty((CharSequence)var19_21);
                                    if (var14_17 != 0) break block36;
                                    if (var12_15 == null) break block37;
                                    var20_22 = System.currentTimeMillis();
                                    var22_23 = var20_22 - var17_20;
                                    var14_17 = dd.a(var8_11, var15_18 /* !! */ , var16_19, (String)var19_21);
                                    var24_24 = var14_17;
                                    var11_14 = var12_15;
                                    try {
                                        var12_15.a(var15_18 /* !! */ , var22_23, var24_24);
                                        break block37;
                                    }
                                    catch (IOException var26_26) {
                                        var6_6 = var19_21;
                                    }
                                    break block42;
                                }
                                var11_14 = var19_21;
                                break;
                            }
                            if (var12_15 != null) {
                                var20_22 = System.currentTimeMillis();
                                var22_23 = var20_22 - var17_20;
                                var24_24 = dd.a(var8_11, var15_18 /* !! */ , var16_19, (String)var19_21);
                                var14_17 = 0;
                                var6_6 = null;
                                var11_14 = var12_15;
                                var26_25 = var19_21;
                                var19_21 = null;
                                try {
                                    var12_15.a(var15_18 /* !! */ , var22_23, var24_24, null);
                                    break block38;
                                }
                                catch (IOException var6_7) {
                                    break block39;
                                }
                            }
                            var26_25 = var19_21;
                        }
                        var11_14 = var26_25;
                        continue;
                        catch (IOException var6_8) {
                            var26_25 = var19_21;
                        }
                    }
                    var27_28 = var26_25;
                    var26_25 = var6_6;
                    var6_6 = var27_28;
                    break block42;
                    catch (IOException var26_27) {
                        var6_6 = var11_14;
                    }
                }
                if (var12_15 == null) ** GOTO lbl118
                var20_22 = System.currentTimeMillis();
                var22_23 = var20_22 - var17_20;
                var13_16 = dd.a(var8_11, var15_18 /* !! */ , var16_19, (String)var6_6);
                var24_24 = var13_16;
                var11_14 = var12_15;
                var19_21 = var26_25;
                var12_15.a(var15_18 /* !! */ , var22_23, var24_24, (Exception)var26_25);
lbl118:
                // 2 sources

                var26_25.printStackTrace();
                var11_14 = var6_6;
                continue;
                break;
            }
            return var11_14;
        }
        return null;
    }
}

