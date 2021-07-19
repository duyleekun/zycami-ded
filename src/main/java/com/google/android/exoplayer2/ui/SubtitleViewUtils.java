/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.ui;

public final class SubtitleViewUtils {
    private SubtitleViewUtils() {
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static float resolveTextSize(int n10, float f10, int n11, int n12) {
        float f11;
        float f12 = -3.4028235E38f;
        float f13 = f10 - f12;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object == false) {
            return f12;
        }
        if (n10 != 0) {
            n12 = 1;
            if (n10 != n12) {
                n11 = 2;
                if (n10 == n11) return f10;
                return f12;
            }
            f11 = n11;
            return f10 * f11;
        }
        f11 = n12;
        return f10 * f11;
    }
}

