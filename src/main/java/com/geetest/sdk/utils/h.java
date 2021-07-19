/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.geetest.sdk.utils;

import android.content.Context;
import com.geetest.sdk.utils.l;
import java.math.BigDecimal;

public class h {
    private static double a;

    private static double a(double d10, int n10) {
        BigDecimal bigDecimal = new BigDecimal(d10);
        return bigDecimal.setScale(n10, 4).doubleValue();
    }

    private static double a(Context context) {
        Object object = h.class;
        double d10 = a;
        double d11 = 0.0;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object2 != false) {
            return d10;
        }
        context = context.getApplicationContext();
        context = context.getResources();
        context = context.getDisplayMetrics();
        int n10 = context.widthPixels;
        int n11 = context.heightPixels;
        CharSequence charSequence = ((Class)object).getSimpleName();
        CharSequence charSequence2 = new StringBuilder();
        String string2 = "realWidth: ";
        charSequence2.append(string2);
        charSequence2.append(n10);
        string2 = " realHeight\uff1a";
        charSequence2.append(string2);
        charSequence2.append(n11);
        charSequence2 = charSequence2.toString();
        l.b((String)charSequence, (String)charSequence2);
        object = ((Class)object).getSimpleName();
        charSequence = new StringBuilder();
        charSequence2 = "density: ";
        ((StringBuilder)charSequence).append((String)charSequence2);
        float f10 = context.density;
        ((StringBuilder)charSequence).append(f10);
        charSequence2 = " densityDpi\uff1a";
        ((StringBuilder)charSequence).append((String)charSequence2);
        int n12 = context.densityDpi;
        ((StringBuilder)charSequence).append(n12);
        charSequence = ((StringBuilder)charSequence).toString();
        l.b((String)object, (String)charSequence);
        float f11 = n10;
        float f12 = context.xdpi;
        float f13 = f11 / f12;
        f13 *= (f11 /= f12);
        f11 = n11;
        float f14 = context.ydpi;
        f12 = f11 / f14;
        double d13 = f13 += (f12 *= (f11 /= f14));
        d13 = Math.sqrt(d13);
        int n13 = 1;
        f14 = Float.MIN_VALUE;
        d13 = h.a(d13, n13);
        try {
            a = d13;
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        return a;
    }

    public static boolean b(Context object) {
        double d10 = h.a(object);
        object = h.class.getSimpleName();
        CharSequence charSequence = new StringBuilder();
        String string2 = "screenInch: ";
        charSequence.append(string2);
        charSequence.append(d10);
        charSequence = charSequence.toString();
        l.b((String)object, (String)charSequence);
        double d11 = 7.0;
        double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        return d12 > 0;
    }
}

