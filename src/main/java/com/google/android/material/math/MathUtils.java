/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.material.math;

public final class MathUtils {
    public static final float DEFAULT_EPSILON = 1.0E-4f;

    private MathUtils() {
    }

    public static float dist(float f10, float f11, float f12, float f13) {
        double d10 = f12 -= f10;
        double d11 = f13 -= f11;
        return (float)Math.hypot(d10, d11);
    }

    public static float distanceToFurthestCorner(float f10, float f11, float f12, float f13, float f14, float f15) {
        float f16 = MathUtils.dist(f10, f11, f12, f13);
        f13 = MathUtils.dist(f10, f11, f14, f13);
        f14 = MathUtils.dist(f10, f11, f14, f15);
        f10 = MathUtils.dist(f10, f11, f12, f15);
        return MathUtils.max(f16, f13, f14, f10);
    }

    public static boolean geq(float f10, float f11, float f12) {
        float f13 = (f10 += f12) - f11;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object >= 0) {
            object = true;
            f10 = Float.MIN_VALUE;
        } else {
            object = false;
            f10 = 0.0f;
        }
        return (boolean)object;
    }

    public static float lerp(float f10, float f11, float f12) {
        float f13 = (1.0f - f12) * f10;
        return f13 + (f12 *= f11);
    }

    private static float max(float f10, float f11, float f12, float f13) {
        Object object = f10 == f11 ? 0 : (f10 > f11 ? 1 : -1);
        if (object <= 0 || (object = f10 == f12 ? 0 : (f10 > f12 ? 1 : -1)) <= 0 || (object = f10 == f13 ? 0 : (f10 > f13 ? 1 : -1)) <= 0) {
            Object object2 = f11 == f12 ? 0 : (f11 > f12 ? 1 : -1);
            f10 = object2 > 0 && (object2 = f11 == f13 ? 0 : (f11 > f13 ? 1 : -1)) > 0 ? f11 : ((object2 = f12 == f13 ? 0 : (f12 > f13 ? 1 : -1)) > 0 ? f12 : f13);
        }
        return f10;
    }
}

