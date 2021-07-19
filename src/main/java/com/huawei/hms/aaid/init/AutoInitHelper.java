/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

public class AutoInitHelper {
    public static void doAutoInit(Context context) {
        block6: {
            String string2 = "AutoInit";
            boolean bl2 = AutoInitHelper.isAutoInitEnabled(context);
            if (!bl2) break block6;
            Object object = "Push init start";
            HMSLog.i(string2, (String)object);
            f f10 = new f(context);
            try {
                object = new Thread(f10);
                ((Thread)object).start();
            }
            catch (Exception exception) {
                object = "Push init failed";
                HMSLog.e(string2, (String)object, exception);
            }
        }
    }

    public static boolean isAutoInitEnabled(Context object) {
        String string2;
        i i10 = i.a(object);
        int n10 = i10.containsKey(string2 = "push_kit_auto_init_enabled");
        if (n10 != 0) {
            return i10.getBoolean(string2);
        }
        try {
            i10 = object.getPackageManager();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            return false;
        }
        object = object.getPackageName();
        n10 = 128;
        object = i10.getApplicationInfo((String)object, n10);
        object = object.metaData;
        return object.getBoolean(string2);
    }

    public static void setAutoInitEnabled(Context context, boolean bl2) {
        i i10 = i.a(context);
        String string2 = "push_kit_auto_init_enabled";
        boolean bl3 = i10.getBoolean(string2);
        i10.saveBoolean(string2, bl2);
        if (bl2 && !bl3) {
            AutoInitHelper.doAutoInit(context);
        }
    }
}

