/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.content.pm.ProviderInfo
 *  android.os.Build$VERSION
 */
package com.xiaomi.push.service;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.Build;
import com.xiaomi.channel.commonutils.logger.b;

public class f {
    public static boolean a(Context context, String serviceInfoArray) {
        boolean bl2;
        block14: {
            bl2 = false;
            PackageManager packageManager = context.getPackageManager();
            int n10 = 4;
            serviceInfoArray = packageManager.getPackageInfo((String)serviceInfoArray, n10);
            serviceInfoArray = serviceInfoArray.services;
            if (serviceInfoArray == null) break block14;
            int n11 = serviceInfoArray.length;
            for (n10 = 0; n10 < n11; ++n10) {
                Object object = serviceInfoArray[n10];
                boolean bl3 = object.exported;
                if (!bl3) continue;
                bl3 = object.enabled;
                if (!bl3) continue;
                String string2 = "com.xiaomi.mipush.sdk.PushMessageHandler";
                String string3 = object.name;
                bl3 = string2.equals(string3);
                if (!bl3) continue;
                string2 = context.getPackageName();
                object = object.packageName;
                try {
                    boolean bl4;
                    boolean bl5 = string2.equals(object);
                    if (bl5) continue;
                    bl2 = bl4 = true;
                    break;
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    b.a(nameNotFoundException);
                    break;
                }
            }
        }
        return bl2;
    }

    public static boolean a(Context object, String string2, String string3) {
        boolean bl2;
        block8: {
            bl2 = false;
            object = object.getPackageManager();
            Intent intent = new Intent(string3);
            intent.setPackage(string2);
            int n10 = 32;
            object = object.queryIntentServices(intent, n10);
            if (object == null) break block8;
            try {
                boolean bl3 = object.isEmpty();
                if (!bl3) {
                    bl2 = bl3 = true;
                }
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
        return bl2;
    }

    public static boolean b(Context object, String string2) {
        boolean bl2;
        block14: {
            float f10;
            float f11;
            boolean bl3;
            block15: {
                bl3 = false;
                f11 = 0.0f;
                object = object.getPackageManager();
                int n10 = Build.VERSION.SDK_INT;
                int n11 = 19;
                bl2 = true;
                f10 = Float.MIN_VALUE;
                if (n10 < n11) break block14;
                n10 = 0;
                Object object2 = null;
                n11 = 8;
                object = object.queryContentProviders(null, 0, n11);
                if (object == null) break block15;
                n10 = (int)(object.isEmpty() ? 1 : 0);
                if (n10 != 0) break block15;
                try {
                    object = object.iterator();
                }
                catch (Exception exception) {
                    b.a(exception);
                }
                while (true) {
                    n10 = (int)(object.hasNext() ? 1 : 0);
                    if (n10 == 0) break;
                    object2 = object.next();
                    object2 = (ProviderInfo)object2;
                    n11 = (int)(((ProviderInfo)object2).enabled ? 1 : 0);
                    if (n11 == 0) continue;
                    n11 = (int)(((ProviderInfo)object2).exported ? 1 : 0);
                    if (n11 == 0) continue;
                    object2 = ((ProviderInfo)object2).authority;
                    n10 = (int)(((String)object2).equals(string2) ? 1 : 0);
                    if (n10 == 0) continue;
                    bl3 = bl2;
                    f11 = f10;
                    continue;
                    break;
                }
            }
            bl2 = bl3;
            f10 = f11;
        }
        return bl2;
    }

    public static boolean b(Context object, String string2, String string3) {
        boolean bl2;
        block8: {
            bl2 = false;
            object = object.getPackageManager();
            Intent intent = new Intent(string3);
            intent.setPackage(string2);
            int n10 = 32;
            object = object.queryIntentActivities(intent, n10);
            if (object == null) break block8;
            try {
                boolean bl3 = object.isEmpty();
                if (!bl3) {
                    bl2 = bl3 = true;
                }
            }
            catch (Exception exception) {
                b.a(exception);
            }
        }
        return bl2;
    }
}

