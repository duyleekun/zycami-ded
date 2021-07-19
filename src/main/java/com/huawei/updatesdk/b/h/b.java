/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.h;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import com.huawei.updatesdk.a.a.a;
import com.huawei.updatesdk.b.h.b$a;
import com.huawei.updatesdk.b.h.b$b;
import com.huawei.updatesdk.b.h.b$c;
import com.huawei.updatesdk.service.otaupdate.f;
import java.lang.reflect.Field;

public class b {
    private static Integer a;
    private static boolean b = false;
    private static boolean c = false;
    private static Field d;

    public static int a(PackageInfo packageInfo) {
        packageInfo = packageInfo.applicationInfo;
        int n10 = packageInfo.flags;
        int n11 = 1;
        if ((n10 &= n11) == 0) {
            return 0;
        }
        boolean bl2 = com.huawei.updatesdk.b.h.b.a((ApplicationInfo)packageInfo);
        if (bl2) {
            return n11;
        }
        return 2;
    }

    public static int a(String string2) {
        boolean bl2;
        int n10;
        Object object = com.huawei.updatesdk.a.b.a.a.c().a();
        try {
            object = object.getPackageManager();
            n10 = 128;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("getMapleStatus not found: ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", string2);
            return 0;
        }
        string2 = object.getPackageInfo(string2, n10);
        if (string2 != null && (string2 = ((PackageInfo)string2).applicationInfo) != null && (string2 = ((ApplicationInfo)string2).metaData) != null && (bl2 = string2.containsKey((String)(object = "com.huawei.maple.flag")))) {
            return 1;
        }
        return 0;
    }

    public static PackageInfo a(String string2, Context object) {
        int n10;
        try {
            object = object.getPackageManager();
            n10 = 64;
        }
        catch (Exception exception) {
            object = new StringBuilder();
            ((StringBuilder)object).append("not found: ");
            ((StringBuilder)object).append(string2);
            string2 = ((StringBuilder)object).toString();
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", string2);
            return null;
        }
        return object.getPackageInfo(string2, n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static b$b a(Context context, String charSequence) {
        String string2;
        int n10;
        String string3 = "versioncode = ";
        String string4 = "PackageUtils";
        b$b b$b = b$b.a;
        if (context == null) {
            return b$b;
        }
        try {
            context = context.getPackageManager();
            n10 = 0;
            string2 = null;
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isInstallByPackage Exception:");
            String string5 = exception.toString();
            ((StringBuilder)charSequence).append(string5);
            string5 = ((StringBuilder)charSequence).toString();
            com.huawei.updatesdk.a.a.c.a.a.a.d(string4, string5);
            return b$b;
        }
        context = context.getPackageInfo((String)charSequence, 0);
        if (context == null) return b$b;
        charSequence = new StringBuilder();
        string2 = "appmarket info,";
        ((StringBuilder)charSequence).append(string2);
        ((StringBuilder)charSequence).append(string3);
        n10 = context.versionCode;
        ((StringBuilder)charSequence).append(n10);
        ((StringBuilder)charSequence).append(string3);
        string3 = context.versionName;
        ((StringBuilder)charSequence).append(string3);
        charSequence = ((StringBuilder)charSequence).toString();
        com.huawei.updatesdk.a.a.a.b(string4, (String)charSequence);
        int n11 = context.versionCode;
        int n12 = 70203000;
        if (n11 >= n12) return b$b.b;
        return b$b.c;
    }

    public static void a() {
        Object object = new b$c(null);
        Thread thread = new Thread((Runnable)object);
        thread.setName("delete market file task");
        object = new b$a();
        thread.setUncaughtExceptionHandler((Thread.UncaughtExceptionHandler)object);
        thread.start();
    }

    private static boolean a(ApplicationInfo applicationInfo) {
        block6: {
            int n10;
            String string2 = "PackageUtils";
            String string3 = "can not get hwflags";
            int n11 = applicationInfo.flags;
            Integer n12 = com.huawei.updatesdk.b.h.b.c();
            boolean bl2 = true;
            if (n12 != null && (n11 &= (n10 = n12.intValue())) != 0) {
                return bl2;
            }
            Object object = com.huawei.updatesdk.b.h.b.b();
            if (object != null) {
                String string4;
                try {
                    int n13 = ((Field)object).getInt(applicationInfo);
                    int n14 = 0x2000000;
                    if ((n13 &= n14) != 0) {
                        return bl2;
                    }
                    break block6;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    string4 = illegalArgumentException.toString();
                }
                catch (IllegalAccessException illegalAccessException) {
                    object = new StringBuilder();
                    ((StringBuilder)object).append(string3);
                    string4 = illegalAccessException.toString();
                }
                ((StringBuilder)object).append(string4);
                string4 = ((StringBuilder)object).toString();
                com.huawei.updatesdk.a.a.c.a.a.a.a(string2, string4);
            }
        }
        return false;
    }

    private static int b(Context context, String charSequence) {
        try {
            context = context.getPackageManager();
        }
        catch (Exception exception) {
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append("isInstallByPackage:");
            String string2 = exception.toString();
            ((StringBuilder)charSequence).append(string2);
            string2 = ((StringBuilder)charSequence).toString();
            com.huawei.updatesdk.a.a.c.a.a.a.d("PackageUtils", string2);
            return 0;
        }
        context = context.getPackageInfo((String)charSequence, 0);
        return context.versionCode;
    }

    public static Field b() {
        boolean bl2 = c;
        if (bl2) {
            return d;
        }
        Object object = ApplicationInfo.class;
        String string2 = "hwFlags";
        object = ((Class)object).getField(string2);
        try {
            d = object;
        }
        catch (NoSuchFieldException noSuchFieldException) {
            object = "PackageUtils";
            string2 = "can not find hwFlags";
            com.huawei.updatesdk.a.a.c.a.a.a.a((String)object, string2);
        }
        c = true;
        return d;
    }

    public static Integer c() {
        block11: {
            Object object;
            String string2;
            block12: {
                string2 = "PackageUtils";
                int n10 = b;
                if (n10 != 0) {
                    return a;
                }
                object = "android.content.pm.PackageParser";
                object = Class.forName((String)object);
                Object object2 = "PARSE_IS_REMOVABLE_PREINSTALLED_APK";
                object2 = ((Class)object).getDeclaredField((String)object2);
                n10 = ((Field)object2).getInt(object);
                object = n10;
                try {
                    a = object;
                    break block11;
                }
                catch (Exception exception) {
                    object = exception.toString();
                    break block12;
                }
                catch (IllegalArgumentException illegalArgumentException) {
                    object2 = new StringBuilder();
                    String string3 = "isDelApp error IllegalArgumentException:";
                    ((StringBuilder)object2).append(string3);
                    object = illegalArgumentException.toString();
                }
                catch (IllegalAccessException illegalAccessException) {
                    object2 = new StringBuilder();
                    String string4 = "isDelApp error IllegalAccessException:";
                    ((StringBuilder)object2).append(string4);
                    object = illegalAccessException.toString();
                }
                catch (ClassNotFoundException classNotFoundException) {
                    object2 = new StringBuilder();
                    String string5 = "isDelApp error ClassNotFoundException:";
                    ((StringBuilder)object2).append(string5);
                    object = classNotFoundException.toString();
                }
                catch (NoSuchFieldException noSuchFieldException) {
                    object2 = new StringBuilder();
                    String string6 = "isDelApp error NoSuchFieldException:";
                    ((StringBuilder)object2).append(string6);
                    object = noSuchFieldException.toString();
                }
                ((StringBuilder)object2).append((String)object);
                object = ((StringBuilder)object2).toString();
            }
            com.huawei.updatesdk.a.a.c.a.a.a.a(string2, (String)object);
        }
        b = true;
        return a;
    }

    public static boolean c(Context context, String charSequence) {
        boolean bl2;
        boolean bl3 = false;
        if (context != null && !(bl2 = TextUtils.isEmpty((CharSequence)charSequence))) {
            context = context.getPackageManager();
            try {
                context = context.getPackageInfo((String)charSequence, 0);
                if (context != null) {
                    bl3 = true;
                }
                return bl3;
            }
            catch (Exception exception) {
                charSequence = new StringBuilder();
                String string2 = "isAppInstalled NameNotFoundException:";
                ((StringBuilder)charSequence).append(string2);
                String string3 = exception.toString();
                ((StringBuilder)charSequence).append(string3);
                string3 = ((StringBuilder)charSequence).toString();
                charSequence = "PackageUtils";
                com.huawei.updatesdk.a.a.c.a.a.a.d((String)charSequence, string3);
            }
        }
        return false;
    }

    public static boolean d(Context context, String string2) {
        int n10;
        f f10 = f.f();
        boolean bl2 = f10.e();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        int n11 = com.huawei.updatesdk.b.h.b.b(context, string2);
        if (n11 > (n10 = 90000000)) {
            return bl3;
        }
        return false;
    }

    public static boolean e(Context context, String string2) {
        int n10;
        f f10 = f.f();
        boolean bl2 = f10.e();
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        int n11 = com.huawei.updatesdk.b.h.b.b(context, string2);
        if (n11 > (n10 = 100200000)) {
            return bl3;
        }
        return false;
    }
}

