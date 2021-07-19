/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.text.TextUtils
 */
package com.heytap.mcssdk.f;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.heytap.mcssdk.f.c;
import java.lang.reflect.Method;

public class g {
    private static final int a = 26;

    public static int a(String string2) {
        int n10;
        block3: {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) {
                try {
                    n10 = Integer.parseInt(string2);
                    break block3;
                }
                catch (NumberFormatException numberFormatException) {
                    StringBuilder stringBuilder = new StringBuilder();
                    String string3 = "parseInt--NumberFormatException";
                    stringBuilder.append(string3);
                    String string4 = numberFormatException.getMessage();
                    stringBuilder.append(string4);
                    string4 = stringBuilder.toString();
                    c.e(string4);
                }
            }
            n10 = -1;
        }
        return n10;
    }

    public static String a(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        try {
            object = object.versionName;
        }
        catch (Exception exception) {
            object = "0";
        }
        return object;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static String a(String object, String object2) {
        Object object3 = String.class;
        Object object4 = "android.os.SystemProperties";
        object4 = Class.forName((String)object4);
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = object3;
        int n11 = 1;
        classArray[n11] = object3;
        object3 = "get";
        object3 = ((Class)object4).getMethod((String)object3, classArray);
        Object[] objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[n11] = object2;
        object = ((Method)object3).invoke(object4, objectArray);
        try {
            return object = (String)object;
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw illegalArgumentException;
        }
        catch (Exception exception) {
            return object2;
        }
    }

    public static String a(int[] nArray) {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = nArray.length;
        for (int i10 = 0; i10 < n10; ++i10) {
            char c10 = (char)nArray[i10];
            stringBuilder.append(c10);
        }
        return stringBuilder.toString();
    }

    public static boolean a(Context context, String charSequence) {
        boolean bl2;
        try {
            context = context.getPackageManager();
            bl2 = true;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isExistPackage NameNotFoundException:");
            String string2 = nameNotFoundException.getMessage();
            ((StringBuilder)charSequence).append(string2);
            c.e(((StringBuilder)charSequence).toString());
            return false;
        }
        context.getPackageInfo((String)charSequence, (int)(bl2 ? 1 : 0));
        return bl2;
    }

    public static boolean a(Context object, String charSequence, String string2) {
        boolean bl2;
        object = object.getPackageManager();
        int n10 = 128;
        try {
            object = object.getApplicationInfo((String)charSequence, n10);
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            charSequence = new StringBuilder();
            String string3 = "isSupportPush NameNotFoundException:";
            ((StringBuilder)charSequence).append(string3);
            object = nameNotFoundException.getMessage();
            ((StringBuilder)charSequence).append((String)object);
            c.e(((StringBuilder)charSequence).toString());
            bl2 = false;
            object = null;
        }
        boolean bl3 = false;
        charSequence = null;
        if (object != null && (bl2 = (object = object.metaData).getBoolean(string2, false))) {
            bl3 = true;
        }
        return bl3;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static int b(Context object) {
        PackageManager packageManager;
        int n10 = 0;
        try {
            packageManager = object.getPackageManager();
        }
        catch (Exception exception) {
            return n10;
        }
        String string2 = object.getPackageName();
        PackageInfo packageInfo = packageManager.getPackageInfo(string2, 0);
        return packageInfo.versionCode;
    }

    public static int b(Context context, String charSequence) {
        try {
            context = context.getPackageManager();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getVersionCode--Exception:");
            String string2 = exception.getMessage();
            ((StringBuilder)charSequence).append(string2);
            c.b(((StringBuilder)charSequence).toString());
            return 0;
        }
        context = context.getPackageInfo((String)charSequence, 0);
        return context.versionCode;
    }

    public static String c(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        try {
            object = object.packageName;
        }
        catch (Exception exception) {
            c.a(exception);
            object = "0";
        }
        return object;
    }

    public static String c(Context context, String charSequence) {
        try {
            context = context.getPackageManager();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("getVersionName--Exception:");
            String string2 = exception.getMessage();
            ((StringBuilder)charSequence).append(string2);
            c.b(((StringBuilder)charSequence).toString());
            return null;
        }
        context = context.getPackageInfo((String)charSequence, 0);
        return context.versionName;
    }

    public static String d(Context context) {
        PackageManager packageManager;
        try {
            packageManager = context.getPackageManager();
        }
        catch (Exception exception) {
            c.a(exception);
            return "app";
        }
        String string2 = context.getPackageName();
        packageManager = packageManager.getPackageInfo(string2, 0);
        packageManager = packageManager.applicationInfo;
        int n10 = packageManager.labelRes;
        context = context.getResources();
        return context.getString(n10);
    }
}

