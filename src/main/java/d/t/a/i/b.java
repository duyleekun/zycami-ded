/*
 * Decompiled with CFR 0.151.
 */
package d.t.a.i;

public final class b {
    public static float a(float f10, float f11, float f12, float f13) {
        return f12 * (f10 /= f13) * f10 * f10 + f11;
    }

    public static float b(float f10, float f11, float f12, float f13) {
        float f14;
        float f15 = 2.0f;
        f13 = 1.0f;
        float f16 = (f14 = (f10 /= (f13 /= f15)) - f13) == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        f12 /= f15;
        if (f16 < 0) {
            f12 = f12 * f10 * f10 * f10;
        } else {
            f13 = (f10 -= f15) * f10 * f10 + f15;
            f12 *= f13;
        }
        return f12 + f11;
    }

    public static float c(float f10, float f11, float f12, float f13) {
        f10 /= f13;
        f13 = 1.0f;
        float f14 = (f10 -= f13) * f10 * f10 + f13;
        return f12 * f14 + f11;
    }
}

