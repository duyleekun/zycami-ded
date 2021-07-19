/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.ContentResolver
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.provider.Settings$Secure
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.huawei.hms.hatool.f$a;
import com.huawei.hms.hatool.y;
import java.lang.reflect.InvocationTargetException;

public abstract class f {
    /*
     * Unable to fully structure code
     */
    public static Object a(Class var0, String var1_1, Class[] var2_2, Object[] var3_3) {
        block9: {
            block12: {
                block13: {
                    block11: {
                        block10: {
                            var4_4 = "hmsSdk";
                            if (var0 == null) break block9;
                            if (var2_2 != null) break block10;
                            if (var3_3 != null) {
                                var0 = new f$a("paramsType is null, but params is not null");
                                throw var0;
                            }
                            break block11;
                        }
                        if (var3_3 == null) break block12;
                        var5_5 = var2_2.length;
                        var6_6 = var3_3.length;
                        if (var5_5 != var6_6) break block13;
                    }
                    var5_5 = 0;
                    var0 = var0.getMethod((String)var1_1, var2_2);
                    try {
                        return var0.invoke(null, var3_3);
                    }
                    catch (InvocationTargetException v0) {
                        var0 = "invokeStaticFun(): Invocation Target Exception!";
lbl21:
                        // 3 sources

                        while (true) {
                            y.f(var4_4, (String)var0);
                            break;
                        }
                    }
                    catch (IllegalArgumentException v1) {
                        var0 = "invokeStaticFun(): Illegal Argument!";
                        ** GOTO lbl21
                    }
                    catch (IllegalAccessException v2) {
                        var0 = "invokeStaticFun(): method invoke Exception!";
                        ** continue;
                    }
                    {
                        catch (NoSuchMethodException v3) {
                            var0 = "invokeStaticFun(): cls.getMethod(),No Such Method !";
                            y.f(var4_4, (String)var0);
                        }
                    }
                    return null;
                }
                var1_1 = new StringBuilder();
                var1_1.append("paramsType len:");
                var7_7 = var2_2.length;
                var1_1.append(var7_7);
                var1_1.append(" should equal params.len:");
                var7_7 = var3_3.length;
                var1_1.append(var7_7);
                var1_1 = var1_1.toString();
                var0 = new f$a((String)var1_1);
                throw var0;
            }
            var0 = new f$a("paramsType or params should be same");
            throw var0;
        }
        var0 = new f$a("class is null in invokeStaticFun");
        throw var0;
    }

    public static Object a(String object, String string2, Class[] classArray, Object[] objectArray) {
        String string3 = "hmsSdk";
        object = Class.forName((String)object);
        try {
            return f.a((Class)object, string2, classArray, objectArray);
        }
        catch (f$a f$a) {
            object = "invokeStaticFun(): Static function call Exception ";
        }
        catch (ClassNotFoundException classNotFoundException) {
            object = "invokeStaticFun() Not found class!";
        }
        y.f(string3, (String)object);
        return null;
    }

    public static String a() {
        return f.a("ro.build.version.emui", "");
    }

    public static String a(Context context) {
        if (context == null) {
            return "";
        }
        return Settings.Secure.getString((ContentResolver)context.getContentResolver(), (String)"android_id");
    }

    public static String a(String string2, String string3) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            return string3;
        }
        String string4 = f.a("android.os.SystemProperties", string2, string3);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string4);
        if (bl3) {
            string4 = f.a("com.huawei.android.os.SystemPropertiesEx", string2, string3);
        }
        return string4;
    }

    public static String a(String object, String string2, String object2) {
        Object[] objectArray = String.class;
        int n10 = 2;
        Class[] classArray = new Class[n10];
        classArray[0] = objectArray;
        int n11 = 1;
        classArray[n11] = objectArray;
        objectArray = new Object[n10];
        objectArray[0] = string2;
        objectArray[n11] = object2;
        string2 = "get";
        if ((object = f.a((String)object, string2, classArray, objectArray)) != null) {
            object2 = object;
            object2 = (String)object;
        }
        return object2;
    }

    public static String b() {
        String string2 = f.a("com.huawei.android.os.SystemPropertiesEx", "ro.huawei.build.display.id", "");
        CharSequence charSequence = new StringBuilder();
        ((StringBuilder)charSequence).append("SystemPropertiesEx: get rom_ver: ");
        ((StringBuilder)charSequence).append(string2);
        charSequence = ((StringBuilder)charSequence).toString();
        String string3 = "hmsSdk";
        y.c(string3, (String)charSequence);
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        if (bl2) {
            string2 = Build.DISPLAY;
            charSequence = new StringBuilder();
            String string4 = "SystemProperties: get rom_ver: ";
            ((StringBuilder)charSequence).append(string4);
            ((StringBuilder)charSequence).append(string2);
            charSequence = ((StringBuilder)charSequence).toString();
            y.c(string3, (String)charSequence);
        }
        return string2;
    }

    public static String b(Context object) {
        Object object2;
        block9: {
            object2 = "Unknown";
            Object object3 = object.getPackageManager();
            object = object.getPackageName();
            int n10 = 128;
            object = object3.getApplicationInfo((String)object, n10);
            if (object == null) break block9;
            object = ((ApplicationInfo)object).metaData;
            if (object == null) break block9;
            object3 = "CHANNEL";
            object = object.get((String)object3);
            if (object == null) break block9;
            object = object.toString();
            try {
                int n11 = ((String)object).length();
                n10 = 256;
                if (n11 <= n10) {
                    object2 = object;
                }
            }
            catch (PackageManager.NameNotFoundException nameNotFoundException) {
                object = "hmsSdk";
                object3 = "getChannel(): The packageName is not correct!";
                y.f((String)object, (String)object3);
            }
        }
        return object2;
    }

    public static String c(Context context) {
        if (context == null) {
            return "";
        }
        return context.getPackageName();
    }

    public static String d(Context object) {
        String string2 = "";
        if (object == null) {
            return string2;
        }
        Object object2 = object.getPackageManager();
        object = f.c(object);
        object = object2.getPackageInfo((String)object, 0);
        try {
            string2 = object.versionName;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            object = "hmsSdk";
            object2 = "getVersion(): The package name is not correct!";
            y.f((String)object, (String)object2);
        }
        return string2;
    }
}

