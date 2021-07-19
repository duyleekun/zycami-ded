/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk.utils;

import android.content.Context;

public class g {
    public static int a(Context context) {
        return g.a(context, 140.0f);
    }

    public static int a(Context context, float f10) {
        float f11 = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int)(f10 * f11 + 0.5f);
    }

    public static int b(Context context) {
        return g.a(context, 220.0f);
    }

    public static int b(Context context, float f10) {
        float f11 = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (int)(f10 / f11 + 0.5f);
    }
}

