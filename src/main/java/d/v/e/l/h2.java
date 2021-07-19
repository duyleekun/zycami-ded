/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.res.Resources
 */
package d.v.e.l;

import android.content.Context;
import android.content.res.Resources;

public final class h2 {
    private h2() {
        AssertionError assertionError = new AssertionError((Object)"no instance");
        throw assertionError;
    }

    public static float a(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        return f10 * f11;
    }

    public static int b(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        return (int)(f10 * f11 + 0.5f);
    }

    public static boolean c(Context context) {
        context = context.getResources().getConfiguration();
        int n10 = context.orientation;
        int n11 = 1;
        if (n10 != n11) {
            n11 = 0;
        }
        return n11 != 0;
    }

    public static int d(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().density;
        return (int)(f10 / f11 + 0.5f);
    }

    public static int e(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int)(f10 / f11 + 0.5f);
    }

    public static int f(float f10, float f11) {
        return (int)(f10 * f11 + 0.5f);
    }

    public static int g(float f10) {
        float f11 = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int)(f10 * f11);
    }
}

