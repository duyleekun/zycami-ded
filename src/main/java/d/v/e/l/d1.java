/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.app.Application
 *  android.content.Context
 *  android.content.pm.ApplicationInfo
 *  android.content.pm.PackageInfo
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 */
package d.v.e.l;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.zhiyun.common.R$string;
import d.v.e.f;

public final class d1 {
    private static String a;

    private d1() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static String a() {
        Application application = f.a().b();
        ApplicationInfo applicationInfo = application.getApplicationInfo();
        int n10 = applicationInfo.labelRes;
        if (n10 != 0) {
            application = application.getResources();
            int n11 = applicationInfo.labelRes;
            return application.getString(n11);
        }
        application = application.getPackageManager();
        return applicationInfo.loadLabel((PackageManager)application).toString();
    }

    public static String b(Context object) {
        String string2 = "";
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        StringBuilder stringBuilder = null;
        object = packageManager.getPackageInfo((String)object, 0);
        stringBuilder = new StringBuilder();
        object = ((PackageInfo)object).applicationInfo;
        object = object.loadLabel(packageManager);
        object = object.toString();
        stringBuilder.append((String)object);
        try {
            stringBuilder.append(string2);
            string2 = stringBuilder.toString();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
        }
        return string2;
    }

    public static String c(Context object) {
        String string2 = a;
        if (string2 == null) {
            int n10 = R$string.channelID;
            object = object.getString(n10);
            a = object;
        }
        return a;
    }

    public static String d() {
        return f.a().b().getApplicationInfo().packageName;
    }

    public static String e(Context object) {
        String string2 = "";
        Object object2 = object.getPackageManager();
        object = object.getPackageName();
        object = object2.getPackageInfo((String)object, 0);
        object2 = new StringBuilder();
        object = object.packageName;
        ((StringBuilder)object2).append((String)object);
        try {
            ((StringBuilder)object2).append(string2);
            string2 = ((StringBuilder)object2).toString();
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
        }
        return string2;
    }

    public static int f(Context object) {
        int n10;
        PackageManager packageManager = object.getPackageManager();
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        try {
            n10 = object.versionCode;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            n10 = -1;
        }
        return n10;
    }

    public static String g() {
        return d1.h((Context)f.a().b());
    }

    public static String h(Context object) {
        PackageManager packageManager = object.getPackageManager();
        object.getApplicationInfo();
        object = object.getPackageName();
        object = packageManager.getPackageInfo((String)object, 0);
        try {
            object = object.versionName;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            nameNotFoundException.printStackTrace();
            object = "";
        }
        return object;
    }
}

