/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Notification
 *  android.content.Context
 *  android.content.Intent
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build$VERSION
 *  android.os.Bundle
 *  android.text.TextUtils
 */
package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;
import com.xiaomi.push.ba;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aj {
    private static String a;
    private static final String[] a;

    static {
        a = new String[]{"com.mi.globalbrowser", "com.android.browser"};
    }

    public static int a(Context object, String string2) {
        int n10;
        String string3 = object.getPackageName();
        int n11 = string2.equals(string3);
        int n12 = 0;
        if (n11 != 0) {
            object = object.getApplicationInfo();
        } else {
            object = object.getPackageManager();
            try {
                object = object.getApplicationInfo(string2, 0);
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = new StringBuilder();
                string3 = "not found app info ";
                ((StringBuilder)object).append(string3);
                ((StringBuilder)object).append(string2);
                b.a(((StringBuilder)object).toString());
                object = null;
            }
        }
        if (object != null && (n12 = ((ApplicationInfo)object).icon) == 0 && (n10 = Build.VERSION.SDK_INT) >= (n11 = 9)) {
            n12 = ((ApplicationInfo)object).logo;
        }
        return n12;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(Notification object) {
        Object[] objectArray;
        int n10;
        int n11;
        String string2;
        block10: {
            string2 = null;
            try {
                n11 = Build.VERSION.SDK_INT;
                n10 = 19;
                if (n11 < n10) break block10;
            }
            catch (Exception exception) {
                return string2;
            }
            Bundle bundle = object.extras;
            if (bundle == null) break block10;
            objectArray = "target_package";
            string2 = bundle.getString((String)objectArray);
        }
        n11 = (int)(TextUtils.isEmpty(string2) ? 1 : 0);
        if (n11 == 0) return string2;
        String string3 = "extraNotification";
        Object object2 = ba.a(object, string3);
        if (object2 == null) return string2;
        String string4 = "getTargetPkg";
        n10 = 0;
        objectArray = null;
        objectArray = new Object[]{};
        Object object3 = ba.a(object2, string4, objectArray);
        String string5 = (String)object3;
        return string5;
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public static void a(Notification object, String string2) {
        try {
            Object object2;
            void var1_2;
            Object[] objectArray;
            String string3;
            int n10 = Build.VERSION.SDK_INT;
            int n11 = 19;
            if (n10 >= n11 && (string3 = object.extras) != null) {
                objectArray = "target_package";
                string3.putString((String)objectArray, (String)var1_2);
            }
            if ((object2 = ba.a(object, string3 = "extraNotification")) == null) return;
            string3 = "setTargetPkg";
            n11 = 1;
            objectArray = new Object[n11];
            objectArray[0] = var1_2;
            ba.a(object2, string3, objectArray);
            return;
        }
        catch (Exception exception) {
            return;
        }
    }

    public static void a(Context context, Intent intent) {
        Object object;
        block5: {
            int n10;
            int n11 = -1;
            do {
                int n12;
                if ((n12 = TextUtils.isEmpty((CharSequence)(object = n11 < 0 ? a : a[n11]))) != 0) continue;
                intent.setPackage((String)object);
                Object object2 = context.getPackageManager();
                int n13 = 65536;
                object2 = object2.queryIntentActivities(intent, n13);
                if (object2 == null) continue;
                try {
                    n12 = object2.size();
                    if (n12 <= 0) continue;
                    break block5;
                }
                catch (Exception exception) {
                    object2 = new StringBuilder();
                    String string2 = "not found xm browser:";
                    ((StringBuilder)object2).append(string2);
                    ((StringBuilder)object2).append(exception);
                    object = ((StringBuilder)object2).toString();
                    b.a((String)object);
                }
            } while (++n11 < (n10 = ((String[])(object = a)).length));
            n10 = 0;
            object = null;
        }
        intent.setPackage((String)object);
        a = object;
    }
}

