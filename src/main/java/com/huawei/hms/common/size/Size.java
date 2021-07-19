/*
 * Decompiled with CFR 0.151.
 */
package com.huawei.hms.common.size;

public class Size {
    private final int height;
    private final int width;

    public Size(int n10, int n11) {
        this.width = n10;
        this.height = n11;
    }

    public static Size parseSize(String object) {
        int n10;
        block9: {
            String string2 = "x";
            try {
                n10 = ((String)object).indexOf(string2);
                if (n10 >= 0) break block9;
                string2 = "*";
            }
            catch (Exception exception) {
                object = new IllegalArgumentException("Size parses failed");
                throw object;
            }
            n10 = ((String)object).indexOf(string2);
        }
        int n11 = 0;
        String string3 = null;
        string3 = ((String)object).substring(0, n10);
        n11 = Integer.parseInt(string3);
        ++n10;
        object = ((String)object).substring(n10);
        int n12 = Integer.parseInt((String)object);
        Size size = new Size(n11, n12);
        return size;
    }

    public final boolean equals(Object object) {
        boolean bl2 = false;
        if (object == null) {
            return false;
        }
        boolean bl3 = true;
        if (this == object) {
            return bl3;
        }
        int n10 = object instanceof Size;
        if (n10 != 0) {
            int n11;
            object = (Size)object;
            n10 = this.width;
            int n12 = ((Size)object).width;
            if (n10 == n12 && (n10 = this.height) == (n11 = ((Size)object).height)) {
                bl2 = bl3;
            }
        }
        return bl2;
    }

    public final int getHeight() {
        return this.height;
    }

    public final int getWidth() {
        return this.width;
    }

    public final String toString() {
        int n10 = this.width;
        int n11 = this.height;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Width is ");
        stringBuilder.append(n10);
        stringBuilder.append(" Height is ");
        stringBuilder.append(n11);
        return stringBuilder.toString();
    }
}

