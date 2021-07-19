/*
 * Decompiled with CFR 0.151.
 */
package androidx.core.math;

public class MathUtils {
    private MathUtils() {
    }

    public static double clamp(double d10, double d11, double d12) {
        Object object = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        if (object < 0) {
            return d11;
        }
        Object object2 = d10 == d12 ? 0 : (d10 > d12 ? 1 : -1);
        if (object2 > 0) {
            return d12;
        }
        return d10;
    }

    public static float clamp(float f10, float f11, float f12) {
        Object object = f10 == f11 ? 0 : (f10 < f11 ? -1 : 1);
        if (object < 0) {
            return f11;
        }
        Object object2 = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1);
        if (object2 > 0) {
            return f12;
        }
        return f10;
    }

    public static int clamp(int n10, int n11, int n12) {
        if (n10 < n11) {
            return n11;
        }
        if (n10 > n12) {
            return n12;
        }
        return n10;
    }

    public static long clamp(long l10, long l11, long l12) {
        Object object = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (object < 0) {
            return l11;
        }
        Object object2 = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object2 > 0) {
            return l12;
        }
        return l10;
    }
}

