/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

public final class RepeatModeUtil {
    public static final int REPEAT_TOGGLE_MODE_ALL = 2;
    public static final int REPEAT_TOGGLE_MODE_NONE = 0;
    public static final int REPEAT_TOGGLE_MODE_ONE = 1;

    private RepeatModeUtil() {
    }

    public static int getNextRepeatMode(int n10, int n11) {
        int n12;
        for (int i10 = 1; i10 <= (n12 = 2); ++i10) {
            n12 = (n10 + i10) % 3;
            boolean bl2 = RepeatModeUtil.isRepeatModeEnabled(n12, n11);
            if (!bl2) continue;
            return n12;
        }
        return n10;
    }

    public static boolean isRepeatModeEnabled(int n10, int n11) {
        int n12 = 1;
        if (n10 != 0) {
            if (n10 != n12) {
                int n13 = 2;
                if (n10 != n13) {
                    return false;
                }
                n10 = n11 & 2;
                if (n10 == 0) {
                    n12 = 0;
                }
                return n12;
            }
            n10 = n11 & 1;
            if (n10 == 0) {
                n12 = 0;
            }
        }
        return n12;
    }
}

