/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.AppOpsManager
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.os.Build$VERSION
 */
package com.huawei.hms.push;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build;
import com.huawei.hms.aaid.utils.PushPreferences;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class t {
    public static boolean a(Context context) {
        PushPreferences pushPreferences = new PushPreferences(context, "push_notify_flag");
        String string2 = "notify_msg_enable";
        int n10 = pushPreferences.getBoolean(string2);
        if (n10 != 0) {
            return false;
        }
        n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        if (n10 >= n11) {
            return t.b(context);
        }
        n11 = 19;
        if (n10 >= n11) {
            return t.b(context);
        }
        return true;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean b(Context object) {
        AppOpsManager appOpsManager = (AppOpsManager)object.getSystemService("appops");
        ApplicationInfo applicationInfo = object.getApplicationInfo();
        object = object.getApplicationContext().getPackageName();
        int n10 = applicationInfo.uid;
        int n11 = 1;
        Object object2 = AppOpsManager.class;
        object2 = ((Class)object2).getName();
        object2 = Class.forName((String)object2);
        Object object3 = "checkOpNoThrow";
        int n12 = 3;
        Class[] classArray = new Class[n12];
        Class<Integer> clazz = Integer.TYPE;
        classArray[0] = clazz;
        classArray[n11] = clazz;
        Class<String> clazz2 = String.class;
        int n13 = 2;
        classArray[n13] = clazz2;
        object3 = ((Class)object2).getMethod((String)object3, classArray);
        String string2 = "OP_POST_NOTIFICATION";
        object2 = ((Class)object2).getDeclaredField(string2);
        Class<Integer> clazz3 = Integer.class;
        object2 = ((Field)object2).get(clazz3);
        object2 = (Integer)object2;
        int n14 = (Integer)object2;
        Object[] objectArray = new Object[n12];
        object2 = n14;
        objectArray[0] = object2;
        Integer n15 = n10;
        objectArray[n11] = n15;
        objectArray[n13] = object;
        object = ((Method)object3).invoke(appOpsManager, objectArray);
        object = (Integer)object;
        try {
            int n16 = (Integer)object;
            if (n16 != 0) return 0 != 0;
            return n11 != 0;
        }
        catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException | NoSuchMethodException | RuntimeException | InvocationTargetException exception) {
            return n11 != 0;
        }
    }
}

