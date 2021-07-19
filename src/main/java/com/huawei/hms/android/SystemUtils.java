/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.net.ConnectivityManager
 *  android.text.TextUtils
 */
package com.huawei.hms.android;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.text.TextUtils;
import com.huawei.hms.android.HwBuildEx$VERSION;
import com.huawei.hms.support.log.HMSLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Locale;

public class SystemUtils {
    public static String a() {
        return SystemUtils.getSystemProperties("ro.product.locale", "");
    }

    public static String b() {
        return SystemUtils.getSystemProperties("ro.product.locale.region", "");
    }

    public static String getLocalCountry() {
        Object object = Locale.getDefault();
        object = object != null ? ((Locale)object).getCountry() : "";
        return object;
    }

    public static String getNetType(Context object) {
        boolean bl2;
        String string2;
        object = object != null && (object = (ConnectivityManager)object.getSystemService(string2 = "connectivity")) != null && (object = object.getActiveNetworkInfo()) != null && (bl2 = object.isAvailable()) ? object.getTypeName() : "";
        return object;
    }

    public static String getSystemProperties(String string2, String string3) {
        Object object = String.class;
        Object object2 = "android.os.SystemProperties";
        object2 = Class.forName((String)object2);
        Object[] objectArray = "get";
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = object;
        int n11 = 1;
        classArray[n11] = object;
        object = ((Class)object2).getDeclaredMethod((String)objectArray, classArray);
        objectArray = new Object[n10];
        objectArray[0] = string2;
        objectArray[n11] = string3;
        object = ((Method)object).invoke(object2, objectArray);
        try {
            return (String)object;
        }
        catch (ClassCastException | ClassNotFoundException | IllegalAccessException | IllegalArgumentException | NoSuchMethodException | InvocationTargetException exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("An exception occurred while reading: getSystemProperties:");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            HMSLog.e("SystemUtils", string2);
            return string3;
        }
    }

    public static boolean isChinaROM() {
        String string2 = SystemUtils.b();
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        String string3 = "cn";
        if (!bl2) {
            return string3.equalsIgnoreCase(string2);
        }
        string2 = SystemUtils.a();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            Locale locale = Locale.US;
            return string2.toLowerCase(locale).contains(string3);
        }
        string2 = SystemUtils.getLocalCountry();
        bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (!bl2) {
            return string3.equalsIgnoreCase(string2);
        }
        return false;
    }

    public static boolean isEMUI() {
        boolean bl2;
        CharSequence charSequence = new StringBuilder();
        String string2 = "is Emui :";
        charSequence.append(string2);
        int n10 = HwBuildEx$VERSION.EMUI_SDK_INT;
        charSequence.append(n10);
        charSequence = charSequence.toString();
        String string3 = "SystemUtils";
        HMSLog.i(string3, (String)charSequence);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            charSequence = null;
        }
        return bl2;
    }

    public static boolean isSystemApp(Context object, String charSequence) {
        int n10;
        block6: {
            block5: {
                int n11;
                object = object.getPackageManager();
                int n12 = 16384;
                try {
                    object = object.getPackageInfo((String)charSequence, n12);
                }
                catch (PackageManager.NameNotFoundException nameNotFoundException) {
                    charSequence = new StringBuilder();
                    String string2 = "isSystemApp Exception: ";
                    ((StringBuilder)charSequence).append(string2);
                    ((StringBuilder)charSequence).append((Object)nameNotFoundException);
                    object = ((StringBuilder)charSequence).toString();
                    charSequence = "SystemUtils";
                    HMSLog.e((String)charSequence, (String)object);
                    n11 = 0;
                    object = null;
                }
                n10 = 1;
                if (object == null) break block5;
                object = object.applicationInfo;
                n11 = object.flags & n10;
                if (n11 > 0) break block6;
            }
            n10 = 0;
            charSequence = null;
        }
        return n10 != 0;
    }

    public static boolean isTVDevice() {
        return SystemUtils.getSystemProperties("ro.build.characteristics", "default").equalsIgnoreCase("tv");
    }
}

