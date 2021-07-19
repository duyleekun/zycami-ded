/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.updatesdk.a.a.d.h;

import android.text.TextUtils;
import com.huawei.updatesdk.a.a.a;
import com.huawei.updatesdk.a.a.d.h.c;

public class e {
    private static String a = "";

    public static boolean a() {
        String string2 = "KidWatch";
        String string3 = a;
        boolean bl2 = string2.equals(string3);
        if (bl2) {
            return true;
        }
        a = string3 = c.a("ro.vendor.market.type", "");
        CharSequence charSequence = new StringBuilder();
        charSequence.append("Children watch property value is ");
        charSequence.append(string3);
        charSequence = charSequence.toString();
        String string4 = "WearDeviceUtil";
        com.huawei.updatesdk.a.a.a.b(string4, (String)charSequence);
        boolean bl3 = TextUtils.isEmpty((CharSequence)string3);
        if (!bl3) {
            return string2.equals(string3);
        }
        return false;
    }
}

