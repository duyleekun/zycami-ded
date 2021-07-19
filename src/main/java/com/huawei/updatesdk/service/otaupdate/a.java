/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.content.BroadcastReceiver
 *  android.content.Context
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 */
package com.huawei.updatesdk.service.otaupdate;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;

public abstract class a {
    public static void a(Context context, BroadcastReceiver object) {
        if (object != null && context != null) {
            try {
                context.unregisterReceiver((BroadcastReceiver)object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = new StringBuilder();
                String string2 = "unregisterReceiver error:";
                ((StringBuilder)object).append(string2);
                String string3 = illegalArgumentException.toString();
                ((StringBuilder)object).append(string3);
                string3 = ((StringBuilder)object).toString();
                object = "ActivityUtil";
                com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string3);
            }
        }
    }

    public static void a(Context context, IntentFilter object, BroadcastReceiver object2) {
        if (object != null && object2 != null) {
            boolean bl2 = a.a(context);
            if (bl2) {
                return;
            }
            try {
                context.registerReceiver(object2, (IntentFilter)object);
            }
            catch (IllegalArgumentException illegalArgumentException) {
                object = new StringBuilder();
                object2 = "registerReceiver error:";
                ((StringBuilder)object).append((String)object2);
                String string2 = illegalArgumentException.toString();
                ((StringBuilder)object).append(string2);
                string2 = ((StringBuilder)object).toString();
                object = "ActivityUtil";
                com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, string2);
            }
        }
    }

    public static boolean a(Context object) {
        int n10;
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        int n11 = object instanceof Activity;
        if (n11 != 0 && ((n11 = (object = (Activity)object).isFinishing()) != 0 || (n11 = Build.VERSION.SDK_INT) >= (n10 = 17) && (n11 = (int)(object.isDestroyed() ? 1 : 0)) != 0)) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("activity has bean finished, cannot instance:");
            stringBuilder.append(object);
            object = stringBuilder.toString();
            com.huawei.updatesdk.a.a.c.a.a.a.b("ActivityUtil", (String)object);
            return bl2;
        }
        return false;
    }
}

