/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package cn.sharesdk.framework.utils;

import android.content.Context;
import com.mob.tools.utils.ResHelper;

public class g {
    public static float a = 1.5f;
    public static int b = 540;
    private static Context c;

    public static int a(int n10) {
        Context context = c;
        float f10 = a;
        return ResHelper.designToDevice(context, f10, n10);
    }

    public static void a(Context context) {
        Context context2;
        Context context3 = c;
        if (context3 == null || context3 != (context2 = context.getApplicationContext())) {
            c = context;
        }
    }

    public static int b(int n10) {
        Context context = c;
        int n11 = b;
        return ResHelper.designToDevice(context, n11, n10);
    }
}

