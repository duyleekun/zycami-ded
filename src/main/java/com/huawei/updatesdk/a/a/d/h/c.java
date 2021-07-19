/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 *  android.util.DisplayMetrics
 *  android.view.Window
 *  android.view.WindowManager
 *  android.view.WindowManager$LayoutParams
 */
package com.huawei.updatesdk.a.a.d.h;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Window;
import android.view.WindowManager;
import com.huawei.updatesdk.a.a.d.e;
import com.huawei.updatesdk.b.h.a;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class c {
    private static c c;
    private static String d;
    private int a;
    private int b;

    static {
        c c10;
        c = c10 = new c();
        d = null;
        com.huawei.updatesdk.a.a.d.h.c.a("ro.product.brand", "");
    }

    private c() {
        int n10 = 0;
        this.a = 0;
        this.b = 0;
        String string2 = "ro.maple.enable";
        int n11 = com.huawei.updatesdk.a.a.d.h.c.a(string2, 0);
        int n12 = 1;
        if (n11 == n12) {
            this.a = n12;
        }
        this.b = n10 = com.huawei.updatesdk.a.a.d.h.c.a("ro.build.version.ark", 0);
    }

    public static int a(String object, int n10) {
        int n11;
        String string2;
        Object object2 = "android.os.SystemProperties";
        try {
            object2 = Class.forName((String)object2);
            string2 = "getInt";
            n11 = 2;
        }
        catch (Throwable throwable) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("DeviceUtil", "Exception while getting system property: ", throwable);
            return n10;
        }
        Class[] classArray = new Class[n11];
        Class clazz = String.class;
        classArray[0] = clazz;
        clazz = Integer.TYPE;
        int n12 = 1;
        classArray[n12] = clazz;
        object2 = ((Class)object2).getMethod(string2, classArray);
        string2 = null;
        Object[] objectArray = new Object[n11];
        objectArray[0] = object;
        object = n10;
        objectArray[n12] = object;
        object = ((Method)object2).invoke(null, objectArray);
        object = (Integer)object;
        return (Integer)object;
    }

    public static String a(Context object) {
        String string2 = d;
        if (string2 == null) {
            object = com.huawei.updatesdk.a.a.d.h.c.b(object);
            string2 = ",";
            object = e.a((List)object, string2);
            d = object;
        }
        return d;
    }

    public static String a(Context object, String string2) {
        int n10;
        StringBuilder stringBuilder;
        String string3 = "";
        try {
            stringBuilder = new StringBuilder();
            object = object.getPackageManager();
            n10 = 16;
        }
        catch (Exception exception) {
            return string3;
        }
        object = object.getPackageInfo(string2, n10);
        object = object.versionName;
        stringBuilder.append((String)object);
        stringBuilder.append(string3);
        return stringBuilder.toString();
    }

    public static String a(String object, String string2) {
        int n10;
        Object[] objectArray;
        Object object2 = String.class;
        Object object3 = "android.os.SystemProperties";
        try {
            object3 = Class.forName((String)object3);
            objectArray = "get";
            n10 = 2;
        }
        catch (Throwable throwable) {
            com.huawei.updatesdk.a.a.c.a.a.a.a("DeviceUtil", "Exception while getting system property: ", throwable);
            return string2;
        }
        Class[] classArray = new Class[n10];
        classArray[0] = object2;
        int n11 = 1;
        classArray[n11] = object2;
        object2 = ((Class)object3).getMethod((String)objectArray, classArray);
        object3 = null;
        objectArray = new Object[n10];
        objectArray[0] = object;
        objectArray[n11] = string2;
        object = ((Method)object2).invoke(null, objectArray);
        return (String)object;
    }

    public static List a(List object, String[] stringArray) {
        boolean bl2;
        ArrayList<String> arrayList = new ArrayList<String>();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            String string2 = (String)object.next();
            boolean bl3 = com.huawei.updatesdk.a.a.d.h.c.a(string2, stringArray);
            if (bl3) continue;
            arrayList.add(string2);
        }
        return arrayList;
    }

    public static boolean a(String string2, String[] stringArray) {
        int n10;
        int n11 = stringArray.length;
        int n12 = 0;
        int n13 = 0;
        int n14 = 0;
        int n15 = 0;
        int n16 = 0;
        while (true) {
            CharSequence charSequence;
            n10 = 1;
            if (n13 >= n11) break;
            String string3 = stringArray[n13];
            String string4 = "config.";
            boolean bl2 = string3.startsWith(string4);
            if (bl2) {
                n14 = n10;
            } else {
                charSequence = ".config.";
                n10 = (int)(string3.contains(charSequence) ? 1 : 0);
                if (n10 == 0) {
                    ++n15;
                }
            }
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            n10 = (int)(string3.endsWith((String)charSequence) ? 1 : 0);
            if (n10 != 0) {
                ++n16;
            }
            ++n13;
        }
        if ((n14 += n15) == n16) {
            n12 = n10;
        }
        return n12 != 0;
    }

    public static String b(Context object, String string2) {
        int n10;
        object = com.huawei.updatesdk.a.a.d.h.c.a((Context)object, string2);
        string2 = null;
        int n11 = 0;
        int n12 = 0;
        while (true) {
            int n13 = ((String)object).length();
            n10 = 3;
            if (n11 >= n13 || n12 >= n10) break;
            n13 = ((String)object).charAt(n11);
            if (n13 == (n10 = 46)) {
                ++n12;
            }
            ++n11;
        }
        if (n10 == n12) {
            object = ((String)object).substring(0, n11 += -1);
        }
        return object;
    }

    private static List b(Context featureInfoArray) {
        ArrayList<String> arrayList = new ArrayList<String>();
        if ((featureInfoArray = featureInfoArray.getPackageManager().getSystemAvailableFeatures()) != null) {
            int n10 = featureInfoArray.length;
            for (int i10 = 0; i10 < n10; ++i10) {
                String string2 = featureInfoArray[i10].name;
                if (string2 == null) continue;
                string2 = com.huawei.updatesdk.a.a.d.c.a(string2);
                arrayList.add(string2);
            }
        }
        return arrayList;
    }

    private static DisplayMetrics c(Context object) {
        String string2 = "window";
        object = object.getSystemService(string2);
        boolean bl2 = object instanceof WindowManager;
        DisplayMetrics displayMetrics = null;
        object = bl2 ? (WindowManager)object : null;
        if (object != null && (object = object.getDefaultDisplay()) != null) {
            displayMetrics = new DisplayMetrics();
            object.getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static String c() {
        Object object;
        block10: {
            block9: {
                object = "com.huawei.system.BuildEx";
                object = Class.forName((String)object);
                String string2 = "DISPLAY";
                object = ((Class)object).getField(string2);
                string2 = null;
                object = ((Field)object).get(null);
                if (object != null) break block9;
                object = Build.DISPLAY;
                break block10;
            }
            try {
                object = object.toString();
            }
            catch (Throwable throwable) {
                return Build.DISPLAY;
            }
            catch (ClassNotFoundException classNotFoundException) {
                return Build.DISPLAY;
            }
            catch (NoSuchFieldException noSuchFieldException) {
                return Build.DISPLAY;
            }
            catch (IllegalAccessException illegalAccessException) {
                return Build.DISPLAY;
            }
        }
        return object;
    }

    public static c d() {
        return c;
    }

    public static List d(Context object) {
        ArrayList<String> arrayList = new ArrayList<String>();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 24;
        object = object.getResources().getConfiguration();
        if (n10 >= n11) {
            object = object.getLocales();
            for (n10 = 0; n10 < (n11 = object.size()); ++n10) {
                String string2 = object.get(n10).getLanguage();
                boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
                if (bl2 || (bl2 = arrayList.contains(string2))) continue;
                arrayList.add(string2);
            }
        } else {
            object = object.locale.getLanguage();
            arrayList.add((String)object);
        }
        return arrayList;
    }

    public static String e() {
        Object object = Locale.getDefault();
        String string2 = ((Locale)object).getLanguage();
        String string3 = ((Locale)object).getCountry();
        String string4 = ((Locale)object).getVariant();
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        object = n10 >= n11 ? ((Locale)object).getScript() : null;
        n10 = (int)(TextUtils.isEmpty((CharSequence)object) ? 1 : 0);
        String string5 = "_";
        if (n10 != 0 && (n10 = (int)(TextUtils.isEmpty((CharSequence)string4) ? 1 : 0)) != 0) {
            object = new StringBuilder();
            ((StringBuilder)object).append(string2);
            ((StringBuilder)object).append(string5);
            ((StringBuilder)object).append(string3);
            object = ((StringBuilder)object).toString();
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            stringBuilder.append(string5);
            stringBuilder.append((String)object);
            stringBuilder.append(string5);
            stringBuilder.append(string3);
            stringBuilder.append(string5);
            stringBuilder.append(string4);
            object = stringBuilder.toString();
        }
        return object;
    }

    public static String e(Context object) {
        if ((object = com.huawei.updatesdk.a.a.d.h.c.c(object)) != null) {
            int n10 = object.widthPixels;
            String string2 = String.valueOf(n10);
            int n11 = object.heightPixels;
            object = String.valueOf(n11);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(string2);
            string2 = "_";
            stringBuilder.append(string2);
            stringBuilder.append((String)object);
            object = stringBuilder.toString();
        } else {
            object = "";
        }
        return object;
    }

    public static String f(Context object) {
        if ((object = com.huawei.updatesdk.a.a.d.h.c.c(object)) != null) {
            int n10 = object.densityDpi;
            object = String.valueOf(n10);
        } else {
            object = "";
        }
        return object;
    }

    public static String[] f() {
        String[] stringArray;
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 21;
        if (n10 >= n11) {
            stringArray = Build.SUPPORTED_ABIS;
            if (stringArray == null) {
                stringArray = new String[]{};
            }
        } else {
            String string2;
            n10 = 1;
            stringArray = new String[n10];
            stringArray[0] = string2 = Build.CPU_ABI;
        }
        return stringArray;
    }

    public static int g() {
        String string2;
        String string3 = com.huawei.updatesdk.a.a.d.h.c.a("ro.product.cpu.abi", "");
        int n10 = string3.contains(string2 = "arm64");
        n10 = n10 != 0 ? 2 : 1;
        return n10;
    }

    public static int g(Context object) {
        PackageManager packageManager;
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            packageManager = object.getPackageManager();
        }
        catch (Exception exception) {
            return 1;
        }
        object = object.getPackageName();
        int n10 = 16;
        object = packageManager.getPackageInfo((String)object, n10);
        int n11 = object.versionCode;
        stringBuilder.append(n11);
        object = "";
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        return Integer.parseInt((String)object);
    }

    public static String h() {
        int n10;
        String string2;
        Object object = Locale.getDefault();
        CharSequence charSequence = "";
        if (object != null) {
            string2 = ((Locale)object).getLanguage();
            n10 = Build.VERSION.SDK_INT;
            int n11 = 21;
            if (n10 >= n11) {
                charSequence = ((Locale)object).getScript();
            }
            object = ((Locale)object).getCountry();
        } else {
            string2 = "en";
            object = "US";
        }
        n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
        String string3 = "_";
        if (n10 != 0) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append(string3);
            ((StringBuilder)charSequence).append((String)object);
            return ((StringBuilder)charSequence).toString();
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(string2);
        stringBuilder.append(string3);
        stringBuilder.append((String)charSequence);
        stringBuilder.append(string3);
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static String h(Context object) {
        PackageManager packageManager;
        StringBuilder stringBuilder;
        try {
            stringBuilder = new StringBuilder();
            packageManager = object.getPackageManager();
        }
        catch (Exception exception) {
            return null;
        }
        object = object.getPackageName();
        int n10 = 16;
        object = packageManager.getPackageInfo((String)object, n10);
        object = object.versionName;
        stringBuilder.append((String)object);
        object = "";
        stringBuilder.append((String)object);
        return stringBuilder.toString();
    }

    public static boolean i() {
        a a10 = com.huawei.updatesdk.b.h.a.d();
        int n10 = a10.a();
        if (n10 > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            a10 = null;
        }
        return n10 != 0;
    }

    public static boolean i(Context object) {
        String string2 = "DeviceUtil";
        object = object.getPackageManager();
        String string3 = "com.google.android.gsf.login";
        int n10 = 16;
        try {
            object.getPackageInfo(string3, n10);
            string3 = "com.google.android.gsf";
        }
        catch (Exception exception) {
            object = exception.getMessage();
            com.huawei.updatesdk.a.a.c.a.a.a.d(string2, (String)object);
            return false;
        }
        object.getPackageInfo(string3, n10);
        string3 = "com.google.android.gms";
        object = object.getPackageInfo(string3, n10);
        object = object.applicationInfo;
        int n11 = object.flags;
        int n12 = 1;
        if ((n11 &= n12) != 0) {
            return n12 != 0;
        }
        return false;
    }

    public int a() {
        return this.a;
    }

    public void a(Window object) {
        int n10;
        Object object2 = com.huawei.updatesdk.b.h.a.d();
        int n11 = ((a)object2).a();
        if (n11 >= (n10 = 21) && object != null) {
            object = object.getAttributes();
            object2 = "com.huawei.android.view.WindowManagerEx$LayoutParamsEx";
            object2 = Class.forName((String)object2);
            n10 = 1;
            Object object3 = new Class[n10];
            Object[] objectArray = WindowManager.LayoutParams.class;
            object3[0] = objectArray;
            object3 = ((Class)object2).getConstructor((Class<?>)object3);
            objectArray = new Object[n10];
            objectArray[0] = object;
            object = ((Constructor)object3).newInstance(objectArray);
            object3 = "setDisplaySideMode";
            objectArray = new Class[n10];
            Class<Integer> clazz = Integer.TYPE;
            objectArray[0] = clazz;
            object2 = ((Class)object2).getMethod((String)object3, (Class<?>[])objectArray);
            object3 = new Object[n10];
            Integer n12 = n10;
            object3[0] = n12;
            try {
                ((Method)object2).invoke(object, (Object[])object3);
            }
            catch (Throwable throwable) {
                object = "DeviceUtil";
                object2 = "setWindowDisplaySideMode: exception";
                com.huawei.updatesdk.a.a.c.a.a.a.b((String)object, (String)object2);
            }
        }
    }

    public int b() {
        return this.b;
    }
}

