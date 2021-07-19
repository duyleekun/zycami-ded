/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.framework.common;

import com.huawei.hms.framework.common.Logger;
import java.util.Objects;

public class CheckParamUtils {
    private static final String TAG = "CheckParamUtils";

    public static Object checkNotNull(Object object, String string2) {
        Objects.requireNonNull(object, string2);
        return object;
    }

    public static int checkNumParam(int n10, int n11, int n12, int n13, String string2) {
        if (n10 <= n12 && n10 >= n11) {
            Logger.d(TAG, string2);
            return n10;
        }
        return n13;
    }

    public static long checkNumParam(long l10, long l11, long l12, long l13, String string2) {
        long l14;
        Object object = l10 == l12 ? 0 : (l10 < l12 ? -1 : 1);
        if (object <= 0 && (l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) >= 0) {
            Logger.d(TAG, string2);
            return l10;
        }
        return l13;
    }

    public static void checkOffsetAndCount(long l10, long l11, long l12) {
        long l13;
        long l14;
        long l15 = l11 | l12;
        long l16 = 0L;
        long l17 = l15 - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object >= 0 && (object = l11 == l10 ? 0 : (l11 < l10 ? -1 : 1)) <= 0 && (l14 = (l13 = (l10 -= l11) - l12) == 0L ? 0 : (l13 < 0L ? -1 : 1)) >= 0) {
            return;
        }
        ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException = new ArrayIndexOutOfBoundsException();
        throw arrayIndexOutOfBoundsException;
    }
}

