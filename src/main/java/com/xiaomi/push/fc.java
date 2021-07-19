/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ServiceInfo
 */
package com.xiaomi.push;

import android.content.Context;
import android.content.pm.ServiceInfo;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.fc$a;
import com.xiaomi.push.fd;
import com.xiaomi.push.ff;
import com.xiaomi.push.service.XMJobService;
import com.xiaomi.push.t;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class fc {
    private static int a;
    private static fc$a a;
    private static final String a;

    static {
        a = XMJobService.class.getCanonicalName();
        a = 0;
    }

    public static void a() {
        Class<fc> clazz = fc.class;
        synchronized (clazz) {
            Object object;
            block5: {
                object = a;
                if (object != null) break block5;
                return;
            }
            object = "stop alarm.";
            b.c((String)object);
            object = a;
            object.a();
            return;
        }
    }

    /*
     * Unable to fully structure code
     * Could not resolve type clashes
     */
    public static void a(Context var0) {
        block29: {
            block33: {
                var1_1 = "android.permission.BIND_JOB_SERVICE";
                var3_5 = "com.xiaomi.xmsf";
                var2_2 = (var0 /* !! */  = var0 /* !! */ .getApplicationContext()).getPackageName();
                var4_6 = var3_5.equals(var2_2);
                if (var4_6 != 0) {
                    var1_1 = new fd(var0 /* !! */ );
lbl7:
                    // 2 sources

                    while (true) {
                        continue;
                        break;
                    }
                }
                var2_2 = var0 /* !! */ .getPackageManager();
                var3_5 = null;
                var6_8 = var0 /* !! */ .getPackageName();
                var7_9 = 4;
                var2_2 = var2_2.getPackageInfo((String)var6_8, var7_9);
                var2_2 = var2_2.services;
                var8_10 = 1;
                var9_11 = 1.4E-45f;
                if (var2_2 == null) break block29;
                try {
                    var7_9 = ((ServiceInfo[])var2_2).length;
                    var10_12 = 0;
                }
                catch (Exception var2_4) {
                    // empty catch block
                }
                for (var5_7 = 0; var5_7 < var7_9; ++var5_7) {
                    block30: {
                        block32: {
                            block31: {
                                var11_13 /* !! */  = var2_2[var5_7];
                                var12_14 = var11_13 /* !! */ .permission;
                                var13_15 = var1_1.equals(var12_14);
                                if (!var13_15) break block30;
                                var12_14 = fc.a;
                                var14_16 = var11_13 /* !! */ .name;
                                var15_17 = var12_14.equals(var14_16);
                                if (!var15_17) break block31;
lbl39:
                                // 2 sources

                                while (true) {
                                    var10_12 = var8_10;
                                    break block32;
                                    break;
                                }
                            }
                            try {
                                var14_16 = var11_13 /* !! */ .name;
                            }
                            catch (Exception v0) {}
                            var14_16 = t.a(var0 /* !! */ , (String)var14_16);
                            var14_16 = var14_16.getSuperclass();
                            var14_16 = var14_16.getCanonicalName();
                            var13_15 = var12_14.equals(var14_16);
                            if (var13_15) {
                                ** continue;
                            }
                        }
                        if (var10_12 == var8_10) break;
                    }
                    try {
                        var12_14 = fc.a;
                    }
                    catch (Exception var2_3) {
                        var5_7 = var10_12;
                        break block33;
                    }
                    var14_16 = var11_13 /* !! */ .name;
                    var13_15 = var12_14.equals(var14_16);
                    if (!var13_15) continue;
                    var11_13 /* !! */  = var11_13 /* !! */ .permission;
                    var16_18 = var1_1.equals(var11_13 /* !! */ );
                    if (!var16_18) continue;
                    var5_7 = var8_10;
                    break block29;
                }
                var5_7 = var10_12;
                break block29;
            }
            var6_8 = new StringBuilder();
            var17_19 = "check service err : ";
            var6_8.append(var17_19);
            var2_2 = var2_2.getMessage();
            var6_8.append((String)var2_2);
            var2_2 = var6_8.toString();
            b.a((String)var2_2);
        }
        if (var5_7 == 0 && (var4_6 = t.a(var0 /* !! */ )) != 0) {
            var2_2 = new StringBuilder();
            var2_2.append("Should export service: ");
            var3_5 = fc.a;
            var2_2.append(var3_5);
            var2_2.append(" with permission ");
            var2_2.append((String)var1_1);
            var2_2.append(" in AndroidManifest.xml file");
            var1_1 = var2_2.toString();
            var0 /* !! */  = new RuntimeException((String)var1_1);
            throw var0 /* !! */ ;
        }
        var4_6 = 21;
        var1_1 = new fd(var0 /* !! */ );
        ** while (true)
        fc.a = var1_1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Context context, int n10) {
        Class<fc> clazz = fc.class;
        synchronized (clazz) {
            ff ff2;
            int n11;
            int n12 = a;
            String string2 = "com.xiaomi.xmsf";
            String string3 = context.getPackageName();
            boolean bl2 = string2.equals(string3);
            int n13 = 2;
            if (!bl2) {
                if (n11 == n13) {
                    a = n13;
                } else {
                    n11 = 0;
                    ff2 = null;
                    a = 0;
                }
            }
            if (n12 != (n11 = a) && n11 == n13) {
                fc.a();
                ff2 = new ff(context);
                a = ff2;
            }
            return;
        }
    }

    public static void a(boolean bl2) {
        Class<fc> clazz = fc.class;
        synchronized (clazz) {
            Object object;
            block10: {
                object = a;
                if (object != null) break block10;
                String string2 = "timer is not initialized";
                b.a(string2);
                return;
            }
            object = new StringBuilder();
            String string3 = "register alarm. (";
            ((StringBuilder)object).append(string3);
            ((StringBuilder)object).append(bl2);
            string3 = ")";
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
            b.c((String)object);
            object = a;
            object.a(bl2);
            return;
        }
    }

    public static boolean a() {
        Class<fc> clazz = fc.class;
        synchronized (clazz) {
            fc$a fc$a;
            block5: {
                fc$a = a;
                if (fc$a != null) break block5;
                return false;
            }
            boolean bl2 = fc$a.a();
            return bl2;
        }
    }
}

