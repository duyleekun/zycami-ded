/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.os.Build$VERSION
 *  android.os.Handler
 *  android.os.Process
 */
package com.huawei.hms.framework.common;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.Process;
import com.huawei.hms.framework.common.Logger;

public class ContextCompat {
    private static final String TAG = "ContextCompat";

    public static boolean checkSelfPermission(Context context, String string2) {
        String string3 = TAG;
        int n10 = 0;
        if (context != null && string2 != null) {
            int n11 = Process.myPid();
            int n12 = Process.myUid();
            try {
                int n13 = context.checkPermission(string2, n11, n12);
                if (n13 == 0) {
                    n10 = n13 = 1;
                }
            }
            catch (RuntimeException runtimeException) {
                string2 = "dealType rethrowFromSystemServer:";
                Logger.e(string3, string2, runtimeException);
            }
            return n10 != 0;
        }
        Logger.w(string3, "param is null");
        return false;
    }

    public static Context getProtectedStorageContext(Context context) {
        if (context == null) {
            Logger.w(TAG, "context is null");
            return null;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 < n11) {
            return context;
        }
        return context.createDeviceProtectedStorageContext();
    }

    public static Object getSystemService(Context context, String string2) {
        String string3 = TAG;
        Object object = null;
        if (context == null) {
            Logger.w(string3, "context is null");
            return null;
        }
        try {
            object = context.getSystemService(string2);
        }
        catch (RuntimeException runtimeException) {
            string2 = "SystemServer error:";
            Logger.e(string3, string2, runtimeException);
        }
        return object;
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver object, IntentFilter intentFilter) {
        String string2 = TAG;
        Intent intent = null;
        if (context == null) {
            Logger.w(string2, "context is null");
            return null;
        }
        try {
            intent = context.registerReceiver(object, intentFilter);
        }
        catch (RuntimeException runtimeException) {
            object = "dealType rethrowFromSystemServer:";
            Logger.e(string2, (String)object, runtimeException);
        }
        return intent;
    }

    public static Intent registerReceiver(Context context, BroadcastReceiver object, IntentFilter intentFilter, String string2, Handler handler) {
        String string3 = TAG;
        Intent intent = null;
        if (context == null) {
            Logger.w(string3, "context is null");
            return null;
        }
        try {
            intent = context.registerReceiver(object, intentFilter, string2, handler);
        }
        catch (RuntimeException runtimeException) {
            object = "dealType rethrowFromSystemServer:";
            Logger.e(string3, (String)object, runtimeException);
        }
        return intent;
    }

    public static ComponentName startService(Context context, Intent object) {
        String string2 = TAG;
        ComponentName componentName = null;
        if (context == null) {
            Logger.w(string2, "context is null");
            return null;
        }
        try {
            componentName = context.startService(object);
        }
        catch (RuntimeException runtimeException) {
            object = "SystemServer error:";
            Logger.e(string2, (String)object, runtimeException);
        }
        return componentName;
    }

    public static void unregisterReceiver(Context context, BroadcastReceiver object) {
        String string2 = TAG;
        if (context == null) {
            Logger.w(string2, "context is null");
            return;
        }
        try {
            context.unregisterReceiver(object);
        }
        catch (RuntimeException runtimeException) {
            object = "SystemServer error:";
            Logger.e(string2, (String)object, runtimeException);
        }
    }
}

