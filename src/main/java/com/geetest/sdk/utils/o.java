/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package com.geetest.sdk.utils;

import android.content.Context;
import android.content.res.Resources;
import com.geetest.sdk.utils.l;

public final class o {
    public static int a(Context context, String string2) {
        return o.a(context, string2, "drawable");
    }

    private static int a(Context object, String string2, String string3) {
        Resources resources = object.getApplicationContext().getResources();
        object = object.getPackageName();
        int n10 = resources.getIdentifier(string2, string3, (String)object);
        return o.a(string2, string3, n10);
    }

    private static int a(String string2, String string3, int n10) {
        if (n10 == 0) {
            StringBuilder stringBuilder = new StringBuilder();
            String string4 = "resource ";
            stringBuilder.append(string4);
            stringBuilder.append(string2);
            stringBuilder.append(", type ");
            stringBuilder.append(string3);
            stringBuilder.append(", undefined.");
            string2 = stringBuilder.toString();
            string3 = "Geetest";
            l.b(string3, string2);
        }
        return n10;
    }

    public static int b(Context context, String string2) {
        return o.a(context, string2, "id");
    }

    public static int c(Context context, String string2) {
        return o.a(context, string2, "layout");
    }

    public static int d(Context context, String string2) {
        return o.a(context, string2, "mipmap");
    }

    public static int e(Context context, String string2) {
        return o.a(context, string2, "string");
    }

    public static int f(Context context, String string2) {
        return o.a(context, string2, "style");
    }
}

