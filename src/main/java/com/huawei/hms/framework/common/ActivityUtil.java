/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.app.ActivityManager$RunningAppProcessInfo
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 */
package com.huawei.hms.framework.common;

import android.app.ActivityManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import com.huawei.hms.framework.common.ContextCompat;
import com.huawei.hms.framework.common.Logger;
import java.util.List;

public class ActivityUtil {
    private static final String TAG = "ActivityUtil";

    public static PendingIntent getActivities(Context context, int n10, Intent[] intentArray, int n11) {
        String string2 = TAG;
        PendingIntent pendingIntent = null;
        if (context == null) {
            Logger.w(string2, "context is null");
            return null;
        }
        try {
            pendingIntent = PendingIntent.getActivities((Context)context, (int)n10, (Intent[])intentArray, (int)n11);
        }
        catch (RuntimeException runtimeException) {
            String string3 = "dealType rethrowFromSystemServer:";
            Logger.e(string2, string3, runtimeException);
        }
        return pendingIntent;
    }

    public static boolean isForeground(Context context) {
        Object object;
        String string2 = TAG;
        if (context != null && (object = (ActivityManager)ContextCompat.getSystemService(context, "activity")) != null) {
            String string3;
            int n10 = 0;
            List list = null;
            try {
                list = object.getRunningAppProcesses();
            }
            catch (RuntimeException runtimeException) {
                string3 = "activityManager getRunningAppProcesses occur exception: ";
                Logger.w(string2, string3, runtimeException);
            }
            if (list != null) {
                object = list.iterator();
                while ((n10 = object.hasNext()) != 0) {
                    String string4;
                    int n11;
                    list = (ActivityManager.RunningAppProcessInfo)object.next();
                    string3 = ((ActivityManager.RunningAppProcessInfo)list).processName;
                    if (string3 == null || (n11 = string3.equals(string4 = context.getPackageName())) == 0 || (n10 = ((ActivityManager.RunningAppProcessInfo)list).importance) != (n11 = 100)) continue;
                    Logger.v(string2, "isForeground true");
                    return true;
                }
            }
        }
        return false;
    }
}

