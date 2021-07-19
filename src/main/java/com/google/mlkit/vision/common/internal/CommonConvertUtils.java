/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.os.Build$VERSION
 */
package com.google.mlkit.vision.common.internal;

import android.os.Build;

public class CommonConvertUtils {
    public static int convertToAndroidImageFormat(int n10) {
        int n11 = Build.VERSION.SDK_INT;
        int n12 = 842094169;
        int n13 = 17;
        int n14 = 19;
        if (n11 >= n14) {
            if (n10 != n13) {
                n11 = 35;
                if (n10 != n11) {
                    if (n10 != n12) {
                        return 0;
                    }
                    return n12;
                }
                return n11;
            }
            return n13;
        }
        if (n10 != n13) {
            if (n10 != n12) {
                return 0;
            }
            return n12;
        }
        return n13;
    }

    public static int convertToMVRotation(int n10) {
        if (n10 != 0) {
            int n11 = 90;
            if (n10 != n11) {
                n11 = 180;
                if (n10 != n11) {
                    n11 = 270;
                    if (n10 == n11) {
                        return 3;
                    }
                    StringBuilder stringBuilder = new StringBuilder(29);
                    stringBuilder.append("Invalid rotation: ");
                    stringBuilder.append(n10);
                    String string2 = stringBuilder.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                    throw illegalArgumentException;
                }
                return 2;
            }
            return 1;
        }
        return 0;
    }
}

