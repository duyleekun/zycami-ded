/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.xiaomi.push;

import android.content.Context;

public class m {
    public static boolean a(Context context, String string2) {
        String string3 = context.getPackageName();
        int n10 = (context = context.getPackageManager()).checkPermission(string2, string3);
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            context = null;
        }
        return n10 != 0;
    }
}

