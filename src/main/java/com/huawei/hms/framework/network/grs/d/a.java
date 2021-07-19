/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.content.pm.PackageManager$NameNotFoundException
 *  android.os.Build
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.huawei.hms.framework.network.grs.d;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.framework.common.Logger;
import java.util.Locale;

public class a {
    public static String a() {
        return "4.0.20.301";
    }

    public static String a(Context object) {
        int n10;
        String string2 = "";
        if (object == null) {
            return string2;
        }
        PackageManager packageManager = object.getPackageManager();
        try {
            object = object.getPackageName();
            n10 = 16384;
        }
        catch (PackageManager.NameNotFoundException nameNotFoundException) {
            Logger.w("AgentUtil", string2, nameNotFoundException);
            return string2;
        }
        object = packageManager.getPackageInfo((String)object, n10);
        return object.versionName;
    }

    public static String a(Context object, String string2, String charSequence) {
        int n10 = 1;
        if (object == null) {
            object = Locale.ROOT;
            charSequence = new StringBuilder();
            ((StringBuilder)charSequence).append(string2);
            ((StringBuilder)charSequence).append("/%s");
            string2 = ((StringBuilder)charSequence).toString();
            charSequence = new Object[n10];
            String string3 = a.a();
            charSequence[0] = string3;
            return String.format((Locale)object, string2, (Object[])charSequence);
        }
        String string4 = object.getPackageName();
        object = a.a(object);
        String string5 = Build.VERSION.RELEASE;
        String string6 = Build.MODEL;
        Locale locale = Locale.ROOT;
        Object[] objectArray = new StringBuilder();
        String string7 = "%s/%s (Linux; Android %s; %s) ";
        objectArray.append(string7);
        objectArray.append(string2);
        objectArray.append("/%s %s");
        string2 = objectArray.toString();
        int n11 = 6;
        objectArray = new Object[n11];
        objectArray[0] = string4;
        objectArray[n10] = object;
        objectArray[2] = string5;
        objectArray[3] = string6;
        object = a.a();
        objectArray[4] = object;
        int n12 = 5;
        n10 = (int)(TextUtils.isEmpty((CharSequence)charSequence) ? 1 : 0);
        if (n10 != 0) {
            charSequence = "no_service_name";
        }
        objectArray[n12] = charSequence;
        return String.format(locale, string2, objectArray);
    }

    public static String b(Context context, String string2, String string3) {
        return a.a(context, string2, string3);
    }
}

