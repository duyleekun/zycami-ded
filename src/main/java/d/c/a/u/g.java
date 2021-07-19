/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 *  android.os.SystemClock
 */
package d.c.a.u;

import android.os.Build;
import android.os.SystemClock;

public final class g {
    private static final double a;

    static {
        int n10 = Build.VERSION.SDK_INT;
        double d10 = 1.0;
        int n11 = 17;
        if (n10 >= n11) {
            double d11 = 6.0;
            double d12 = Math.pow(10.0, d11);
            d10 /= d12;
        }
        a = d10;
    }

    private g() {
    }

    public static double a(long l10) {
        double d10 = g.b() - l10;
        double d11 = a;
        return d10 * d11;
    }

    public static long b() {
        int n10 = Build.VERSION.SDK_INT;
        int n11 = 17;
        if (n10 >= n11) {
            return SystemClock.elapsedRealtimeNanos();
        }
        return SystemClock.uptimeMillis();
    }
}

