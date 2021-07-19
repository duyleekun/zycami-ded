/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.gms.common.images;

public final class Size {
    private final int zane;
    private final int zanf;

    public Size(int n10, int n11) {
        this.zane = n10;
        this.zanf = n11;
    }

    public static Size parseSize(String object) {
        if (object != null) {
            int n10 = ((String)object).indexOf(42);
            if (n10 < 0) {
                n10 = ((String)object).indexOf(120);
            }
            if (n10 >= 0) {
                int n11 = 0;
                String string2 = null;
                try {
                    string2 = ((String)object).substring(0, n10);
                }
                catch (NumberFormatException numberFormatException) {
                    throw Size.zah((String)object);
                }
                n11 = Integer.parseInt(string2);
                ++n10;
                String string3 = ((String)object).substring(n10);
                n10 = Integer.parseInt(string3);
                Size size = new Size(n11, n10);
                return size;
            }
            throw Size.zah((String)object);
        }
        object = new IllegalArgumentException("string must not be null");
        throw object;
    }

    private static NumberFormatException zah(String string2) {
        int n10 = String.valueOf(string2).length() + 16;
        StringBuilder stringBuilder = new StringBuilder(n10);
        stringBuilder.append("Invalid Size: \"");
        stringBuilder.append(string2);
        stringBuilder.append("\"");
        string2 = stringBuilder.toString();
        NumberFormatException numberFormatException = new NumberFormatException(string2);
        throw numberFormatException;
    }

    public final boolean equals(Object object) {
        if (object == null) {
            return false;
        }
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof Size;
        if (n10 != 0) {
            int n11;
            object = (Size)object;
            n10 = this.zane;
            int n12 = ((Size)object).zane;
            if (n10 == n12 && (n10 = this.zanf) == (n11 = ((Size)object).zanf)) {
                return bl2;
            }
        }
        return false;
    }

    public final int getHeight() {
        return this.zanf;
    }

    public final int getWidth() {
        return this.zane;
    }

    public final int hashCode() {
        int n10 = this.zanf;
        int n11 = this.zane;
        int n12 = n11 << 16;
        n11 = n11 >>> 16 | n12;
        return n10 ^ n11;
    }

    public final String toString() {
        int n10 = this.zane;
        int n11 = this.zanf;
        StringBuilder stringBuilder = new StringBuilder(23);
        stringBuilder.append(n10);
        stringBuilder.append("x");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }
}

