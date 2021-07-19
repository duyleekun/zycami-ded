/*
 * Decompiled with CFR 0.151.
 */
package androidx.camera.core.impl;

import java.util.Objects;

public class LensFacingConverter {
    private LensFacingConverter() {
    }

    public static String nameOf(int n10) {
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                return "BACK";
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Unknown lens facing ");
            stringBuilder.append(n10);
            String string2 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        return "FRONT";
    }

    public static int valueOf(String string2) {
        Objects.requireNonNull(string2, "name cannot be null");
        string2.hashCode();
        Object object = "BACK";
        boolean bl2 = string2.equals(object);
        if (!bl2) {
            object = "FRONT";
            bl2 = string2.equals(object);
            if (!bl2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown len facing name ");
                stringBuilder.append(string2);
                string2 = stringBuilder.toString();
                object = new IllegalArgumentException(string2);
                throw object;
            }
            return 0;
        }
        return 1;
    }

    public static Integer[] values() {
        Integer n10;
        Integer[] integerArray = new Integer[2];
        integerArray[0] = n10 = Integer.valueOf(0);
        int n11 = 1;
        integerArray[n11] = n10 = Integer.valueOf(n11);
        return integerArray;
    }
}

