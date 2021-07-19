/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.pm.PackageInfo
 *  android.os.Build
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.b.g;

import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;

public final class a {
    private static String a;

    public static String a() {
        Object object;
        CharSequence charSequence;
        String string2;
        block19: {
            block18: {
                string2 = a;
                if (string2 != null) {
                    return string2;
                }
                string2 = com.huawei.updatesdk.a.b.a.a.c().a();
                try {
                    charSequence = string2.getPackageName();
                }
                catch (Exception exception) {
                    charSequence = new StringBuilder();
                    ((StringBuilder)charSequence).append("getUserAgent() ");
                    String string3 = exception.toString();
                    ((StringBuilder)charSequence).append(string3);
                    string3 = ((StringBuilder)charSequence).toString();
                    com.huawei.updatesdk.a.a.c.a.a.a.b("ApplicationSession", string3);
                    return null;
                }
                object = string2.getPackageManager();
                string2 = string2.getPackageName();
                string2 = object.getPackageInfo(string2, 0);
                if (string2 == null) break block18;
                object = new StringBuilder();
                ((StringBuilder)object).append((String)charSequence);
                string2 = ((PackageInfo)string2).versionName;
                ((StringBuilder)object).append(string2);
                charSequence = ((StringBuilder)object).toString();
            }
            string2 = Build.BRAND;
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) break block19;
            string2 = "other";
        }
        object = new StringBuilder();
        ((StringBuilder)object).append((String)charSequence);
        charSequence = "_";
        ((StringBuilder)object).append((String)charSequence);
        ((StringBuilder)object).append(string2);
        string2 = ((StringBuilder)object).toString();
        a = string2;
        return string2;
    }
}

