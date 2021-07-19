/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.huawei.hms.opendevice;

import android.text.TextUtils;

public class t {
    public static boolean a(String ... stringArray) {
        for (String string2 : stringArray) {
            boolean bl2 = TextUtils.isEmpty((CharSequence)string2);
            if (!bl2) continue;
            return false;
        }
        return true;
    }
}

