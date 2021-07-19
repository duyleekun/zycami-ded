/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.pm.PackageManager
 *  android.os.Build$VERSION
 *  android.text.TextUtils
 */
package com.huawei.hms.hatool;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.hatool.g0;
import com.huawei.hms.hatool.y;
import java.io.File;

public class p0 {
    public static boolean a(Context context) {
        String string2 = "Privacy_MY";
        String string3 = "flashKeyTime";
        long l10 = g0.a(context, string2, string3, -1);
        long l11 = System.currentTimeMillis() - l10;
        long l12 = l11 - (l10 = 43200000L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object > 0) {
            object = 1;
        } else {
            object = 0;
            context = null;
        }
        return (boolean)object;
    }

    public static boolean a(Context object, String string2) {
        boolean bl2 = true;
        if (object == null) {
            return bl2;
        }
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 23;
        String string3 = "not have read phone permission!";
        String string4 = "hmsSdk";
        if (n10 < n11) {
            PackageManager packageManager = object.getPackageManager();
            int n12 = packageManager.checkPermission(string2, (String)(object = object.getPackageName()));
            if (n12 != 0) {
                y.f(string4, string3);
                return bl2;
            }
        } else {
            int n13 = object.checkSelfPermission(string2);
            if (n13 != 0) {
                y.f(string4, string3);
                return bl2;
            }
        }
        return false;
    }

    public static boolean a(Context object, String string2, int n10) {
        Comparable<StringBuilder> comparable = new Comparable<StringBuilder>();
        string2 = g0.c(object, string2);
        ((StringBuilder)comparable).append(string2);
        ((StringBuilder)comparable).append(".xml");
        string2 = ((StringBuilder)comparable).toString();
        object = object.getFilesDir();
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "../shared_prefs/";
        stringBuilder.append(string3);
        stringBuilder.append(string2);
        string2 = stringBuilder.toString();
        comparable = new Comparable<StringBuilder>((File)object, string2);
        long l10 = ((File)comparable).length();
        long l11 = n10;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        stringBuilder = null;
        if (l12 > 0) {
            comparable = new Object[2];
            comparable[0] = object = Long.valueOf(l10);
            object = n10;
            boolean bl2 = true;
            comparable[bl2] = object;
            object = String.format("reach local file limited size - file len: %d limitedSize: %d", comparable);
            y.c("hmsSdk", (String)object);
            return bl2;
        }
        return false;
    }

    public static boolean a(String string2, long l10, long l11) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
        boolean bl3 = true;
        if (bl2) {
            return bl3;
        }
        try {
            long l12 = Long.parseLong(string2);
            long l13 = (l10 -= l12) - l11;
            long l14 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (l14 <= 0) {
                bl3 = false;
            }
            return bl3;
        }
        catch (NumberFormatException numberFormatException) {
            y.f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return bl3;
        }
    }
}

