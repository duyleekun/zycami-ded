/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 *  android.content.res.Resources$NotFoundException
 */
package com.huawei.updatesdk.b.h;

import android.content.Context;
import android.content.res.Resources;
import com.huawei.updatesdk.a.a.a;

public final class c {
    private static String a;
    private static Resources b;

    public static int a(Context context, String string2) {
        return c.a(context, string2, "id");
    }

    private static int a(Context object, String string2, String string3) {
        Resources resources = b;
        if (resources == null) {
            b = resources = object.getResources();
        }
        resources = b;
        object = c.a(object);
        return resources.getIdentifier(string2, string3, (String)object);
    }

    private static String a(Context object) {
        String string2 = a;
        if (string2 == null) {
            object = object.getPackageName();
            a = object;
        }
        return a;
    }

    public static int b(Context context, String string2) {
        return c.a(context, string2, "layout");
    }

    public static int c(Context context, String string2) {
        return c.a(context, string2, "string");
    }

    public static String d(Context object, String string2) {
        String string3;
        Resources resources;
        try {
            resources = object.getResources();
            string3 = "string";
        }
        catch (Resources.NotFoundException notFoundException) {
            object = new StringBuilder();
            ((StringBuilder)object).append("recource get error name: ");
            ((StringBuilder)object).append(string2);
            object = ((StringBuilder)object).toString();
            com.huawei.updatesdk.a.a.a.a("UpdateSDK", (String)object);
            return "";
        }
        int n10 = c.a((Context)object, string2, string3);
        return resources.getString(n10);
    }
}

