/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.os.Message
 */
package com.mob.commons.a;

import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Message;
import com.mob.MobSDK;
import com.mob.commons.a.d;
import com.mob.commons.c;
import com.mob.commons.e;
import com.mob.commons.i;
import com.mob.tools.utils.DeviceHelper;
import com.mob.tools.utils.ReflectHelper;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class b
extends d {
    /*
     * Unable to fully structure code
     * Enabled aggressive exception aggregation
     */
    private boolean a(long var1_1) {
        block18: {
            block16: {
                block17: {
                    var3_2 = Build.VERSION.SDK_INT;
                    var4_3 = 0;
                    var5_4 = null;
                    var6_5 /* !! */  = MobSDK.getContext();
                    var6_5 /* !! */  = DeviceHelper.getInstance(var6_5 /* !! */ );
                    var7_6 = "usagestats";
                    var6_5 /* !! */  = var6_5 /* !! */ .getSystemServiceSafe(var7_6);
                    if (var6_5 /* !! */  == null) {
                        return false;
                    }
                    var7_6 = "android.app.usage.UsageStatsManager";
                    ReflectHelper.importClass(var7_6);
                    var7_6 = "queryUsageStats";
                    var8_7 = 21;
                    var9_8 = 2;
                    var10_9 = 3;
                    var11_10 = 1;
                    if (var3_2 >= var8_7) {
                        var12_11 = new Object[var10_9];
                        var13_12 /* !! */  = 0;
                        var12_11[0] = var13_12 /* !! */ ;
                        var13_12 /* !! */  = 0;
                        var12_11[var11_10] = var13_12 /* !! */ ;
                        var14_13 = System.currentTimeMillis();
                        var13_12 /* !! */  = var14_13;
                        var12_11[var9_8] = var13_12 /* !! */ ;
                        var13_12 /* !! */  = new Class[var10_9];
                        var16_14 /* !! */  = Integer.TYPE;
                        var13_12 /* !! */ [0] = var16_14 /* !! */ ;
                        var13_12 /* !! */ [var11_10] = var16_14 /* !! */  = Long.TYPE;
                        var13_12 /* !! */ [var9_8] = var16_14 /* !! */ ;
                        var12_11 = ReflectHelper.invokeInstanceMethod((Object)var6_5 /* !! */ , var7_6, (Object[])var12_11, (Class[])var13_12 /* !! */ );
                        var12_11 = (List)var12_11;
                    } else {
                        var12_11 = null;
                    }
                    var17_15 = 28;
                    if (var3_2 < var17_15 && (var12_11 == null || (var18_16 = var12_11.isEmpty()) != 0)) {
                        var16_14 /* !! */  = "mService";
                        var6_5 /* !! */  = ReflectHelper.getInstanceField(var6_5 /* !! */ , (String)var16_14 /* !! */ );
                        var18_16 = 4;
                        var19_17 /* !! */  = new Object[var18_16];
                        var20_18 = Integer.valueOf(0);
                        var19_17 /* !! */ [0] = var20_18;
                        var20_18 = Integer.valueOf(0);
                        var19_17 /* !! */ [var11_10] = var20_18;
                        var21_19 = System.currentTimeMillis();
                        var20_18 = Long.valueOf(var21_19);
                        var19_17 /* !! */ [var9_8] = var20_18;
                        var20_18 = "com.android.settings";
                        var19_17 /* !! */ [var10_9] = var20_18;
                        var16_14 /* !! */  = new Class[var18_16];
                        var20_18 = Integer.TYPE;
                        var16_14 /* !! */ [0] = var20_18;
                        var20_18 = Long.TYPE;
                        var16_14 /* !! */ [var11_10] = var20_18;
                        var16_14 /* !! */ [var9_8] = var20_18;
                        var23_20 /* !! */  = String.class;
                        var16_14 /* !! */ [var10_9] = var23_20 /* !! */ ;
                        if ((var6_5 /* !! */  = ReflectHelper.invokeInstanceMethod((Object)var6_5 /* !! */ , var7_6, var19_17 /* !! */ , var16_14 /* !! */ )) != null) {
                            var7_6 = "getList";
                            var23_20 /* !! */  = new Object[]{};
                            var6_5 /* !! */  = ReflectHelper.invokeInstanceMethod((Object)var6_5 /* !! */ , var7_6, var23_20 /* !! */ );
                            var12_11 = var6_5 /* !! */ ;
                            var12_11 = (List)var6_5 /* !! */ ;
                        }
                    }
                    if (var12_11 == null || (var24_21 = var12_11.isEmpty()) != 0) break block16;
                    var25_22 = i.e();
                    var27_23 = com.mob.commons.b.a();
                    var29_24 = 0L;
                    cfr_temp_0 = var25_22 - var29_24;
                    var31_25 /* !! */  = (long)(cfr_temp_0 == 0L ? 0 : (cfr_temp_0 < 0L ? -1 : 1));
                    if (var31_25 /* !! */  > 0 && (var24_21 = (int)(var27_23 == var25_22 ? 0 : (var27_23 < var25_22 ? -1 : 1))) < 0) {
                        return (boolean)var11_10;
                    }
                    var24_21 = var12_11.size();
                    var7_6 = "android.app.usage.UsageStats";
                    ReflectHelper.importClass(var7_6);
                    var7_6 = MobSDK.getContext();
                    var7_6 = var7_6.getPackageManager();
                    var24_21 -= var11_10;
                    var9_8 = 0;
                    var23_20 /* !! */  = null;
                    var10_9 = 0;
                    var32_26 = null;
                    if (var24_21 < 0) ** GOTO lbl-1000
                    try {
                        var20_18 = var12_11.get(var24_21);
                        if (var3_2 >= var8_7) {
                            var33_27 = "getLastTimeUsed";
                            var34_28 = new Object[]{};
                            var33_27 = ReflectHelper.invokeInstanceMethod(var20_18, (String)var33_27, var34_28);
                            var35_29 = (var33_27 = (Long)var33_27).longValue();
                            cfr_temp_1 = var35_29 - var29_24;
                            var37_30 /* !! */  = (long)(cfr_temp_1 == 0L ? 0 : (cfr_temp_1 < 0L ? -1 : 1));
                            if (var37_30 /* !! */  > 0) {
                                var38_31 = "getPackageName";
                                var39_32 = new Object[]{};
                                var38_31 = ReflectHelper.invokeInstanceMethod(var20_18, (String)var38_31, var39_32);
                                var38_31 = (String)var38_31;
                                return (boolean)var38_31;
                            }
                        }
                    }
                    catch (Throwable var47_42) {}
                    finally {
                        var39_32 = this;
                    }
lbl-1000:
                    // 1 sources

                    {
                        var39_32 = this;
                        if (var23_20 /* !! */  == null || (var3_2 = (int)var23_20 /* !! */ .isEmpty()) != 0) break block17;
                        var47_40 = new HashMap<K, V>();
                        var5_4 = var23_20 /* !! */ .entrySet();
                        var5_4 = var5_4.iterator();
                        while ((var24_21 = (int)var5_4.hasNext()) != 0) {
                            var6_5 /* !! */  = var5_4.next();
                            var6_5 /* !! */  = (Map.Entry)var6_5 /* !! */ ;
                            var6_5 /* !! */  = var6_5 /* !! */ .getValue();
                            var47_40.add(var6_5 /* !! */ );
                        }
                        var4_3 = var47_40.size();
                        if (var4_3 <= 0) break block18;
                        var5_4 = new HashMap();
                        var6_5 /* !! */  = "type";
                        var7_6 = "XM_APP_RUNTIMES";
                        var5_4.put(var6_5 /* !! */ , var7_6);
                        var6_5 /* !! */  = "list";
                        var5_4.put(var6_5 /* !! */ , var47_40);
                        var47_40 = "datetime";
                        var25_22 = com.mob.commons.b.a();
                        var6_5 /* !! */  = Long.valueOf(var25_22);
                        var5_4.put(var47_40, var6_5 /* !! */ );
                        var47_40 = c.a();
                        var25_22 = com.mob.commons.b.a();
                        var47_40.a(var25_22, (HashMap)var5_4);
                        var48_44 = com.mob.commons.b.a() + var1_1;
                        i.c(var48_44);
                    }
                    return true;
                }
                return false;
            }
            var39_33 = this;
            return false;
        }
        return false;
    }

    private boolean a(PackageManager packageManager, String string2) {
        int n10 = 0;
        int n11 = 1;
        try {
            packageManager = packageManager.getPackageInfo(string2, 0);
        }
        catch (Throwable throwable) {
            return n11;
        }
        packageManager = packageManager.applicationInfo;
        int n12 = packageManager.flags;
        int n13 = n12 & 1;
        if (n13 == n11) {
            n13 = n11;
        } else {
            n13 = 0;
            string2 = null;
        }
        if ((n12 &= 0x80) == n11) {
            n12 = n11;
        } else {
            n12 = 0;
            packageManager = null;
        }
        if (n13 || n12 != 0) {
            n10 = n11;
        }
        return n10;
    }

    public File a() {
        return e.a("comm/locks/.artc_lock");
    }

    public void a(Message message) {
        int n10 = message.what;
        int n11 = 1;
        if (n10 == n11) {
            long l10;
            long l11 = com.mob.commons.b.A();
            long l12 = l11 - (l10 = 0L);
            n10 = (int)(l12 == 0L ? 0 : (l12 < 0L ? -1 : 1));
            if (n10 > 0 && (n10 = (int)(this.a(l11) ? 1 : 0)) != 0) {
                this.a(n11, l11);
            } else {
                this.e();
            }
        }
    }

    public boolean b_() {
        long l10;
        long l11 = com.mob.commons.b.A();
        long l12 = l11 - (l10 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public void d() {
        this.b(1);
    }
}

