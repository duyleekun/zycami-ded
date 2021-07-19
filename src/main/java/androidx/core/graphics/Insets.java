/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Insets
 *  android.graphics.Rect
 */
package androidx.core.graphics;

import android.graphics.Rect;

public final class Insets {
    public static final Insets NONE;
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    static {
        Insets insets;
        NONE = insets = new Insets(0, 0, 0, 0);
    }

    private Insets(int n10, int n11, int n12, int n13) {
        this.left = n10;
        this.top = n11;
        this.right = n12;
        this.bottom = n13;
    }

    public static Insets add(Insets insets, Insets insets2) {
        int n10 = insets.left;
        int n11 = insets2.left;
        n10 += n11;
        n11 = insets.top;
        int n12 = insets2.top;
        n11 += n12;
        n12 = insets.right;
        int n13 = insets2.right;
        int n14 = insets.bottom;
        int n15 = insets2.bottom;
        return Insets.of(n10, n11, n12 += n13, n14 += n15);
    }

    public static Insets max(Insets insets, Insets insets2) {
        int n10 = insets.left;
        int n11 = insets2.left;
        n10 = Math.max(n10, n11);
        n11 = insets.top;
        int n12 = insets2.top;
        n11 = Math.max(n11, n12);
        n12 = insets.right;
        int n13 = insets2.right;
        n12 = Math.max(n12, n13);
        int n14 = insets.bottom;
        int n15 = insets2.bottom;
        n14 = Math.max(n14, n15);
        return Insets.of(n10, n11, n12, n14);
    }

    public static Insets min(Insets insets, Insets insets2) {
        int n10 = insets.left;
        int n11 = insets2.left;
        n10 = Math.min(n10, n11);
        n11 = insets.top;
        int n12 = insets2.top;
        n11 = Math.min(n11, n12);
        n12 = insets.right;
        int n13 = insets2.right;
        n12 = Math.min(n12, n13);
        int n14 = insets.bottom;
        int n15 = insets2.bottom;
        n14 = Math.min(n14, n15);
        return Insets.of(n10, n11, n12, n14);
    }

    public static Insets of(int n10, int n11, int n12, int n13) {
        if (n10 == 0 && n11 == 0 && n12 == 0 && n13 == 0) {
            return NONE;
        }
        Insets insets = new Insets(n10, n11, n12, n13);
        return insets;
    }

    public static Insets of(Rect rect) {
        int n10 = rect.left;
        int n11 = rect.top;
        int n12 = rect.right;
        int n13 = rect.bottom;
        return Insets.of(n10, n11, n12, n13);
    }

    public static Insets subtract(Insets insets, Insets insets2) {
        int n10 = insets.left;
        int n11 = insets2.left;
        n10 -= n11;
        n11 = insets.top;
        int n12 = insets2.top;
        n11 -= n12;
        n12 = insets.right;
        int n13 = insets2.right;
        int n14 = insets.bottom;
        int n15 = insets2.bottom;
        return Insets.of(n10, n11, n12 -= n13, n14 -= n15);
    }

    public static Insets toCompatInsets(android.graphics.Insets insets) {
        int n10 = insets.left;
        int n11 = insets.top;
        int n12 = insets.right;
        int n13 = insets.bottom;
        return Insets.of(n10, n11, n12, n13);
    }

    public static Insets wrap(android.graphics.Insets insets) {
        return Insets.toCompatInsets(insets);
    }

    public boolean equals(Object object) {
        Class<?> clazz;
        Class<Insets> clazz2;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        if (object != null && (clazz2 = Insets.class) == (clazz = object.getClass())) {
            object = (Insets)object;
            int n10 = this.bottom;
            int n11 = ((Insets)object).bottom;
            if (n10 != n11) {
                return false;
            }
            n10 = this.left;
            n11 = ((Insets)object).left;
            if (n10 != n11) {
                return false;
            }
            n10 = this.right;
            n11 = ((Insets)object).right;
            if (n10 != n11) {
                return false;
            }
            n10 = this.top;
            int n12 = ((Insets)object).top;
            if (n10 != n12) {
                return false;
            }
            return bl2;
        }
        return false;
    }

    public int hashCode() {
        int n10 = this.left * 31;
        int n11 = this.top;
        n10 = (n10 + n11) * 31;
        n11 = this.right;
        n10 = (n10 + n11) * 31;
        n11 = this.bottom;
        return n10 + n11;
    }

    public android.graphics.Insets toPlatformInsets() {
        int n10 = this.left;
        int n11 = this.top;
        int n12 = this.right;
        int n13 = this.bottom;
        return android.graphics.Insets.of((int)n10, (int)n11, (int)n12, (int)n13);
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Insets{left=");
        int n10 = this.left;
        stringBuilder.append(n10);
        stringBuilder.append(", top=");
        n10 = this.top;
        stringBuilder.append(n10);
        stringBuilder.append(", right=");
        n10 = this.right;
        stringBuilder.append(n10);
        stringBuilder.append(", bottom=");
        n10 = this.bottom;
        stringBuilder.append(n10);
        stringBuilder.append('}');
        return stringBuilder.toString();
    }
}

