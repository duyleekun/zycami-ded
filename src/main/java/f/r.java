/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import f.r$a;

public final class r
implements Comparable {
    public static final int e = 255;
    public static final r f;
    public static final r$a g;
    private final int a;
    private final int b;
    private final int c;
    private final int d;

    static {
        Object object = new r$a(null);
        g = object;
        f = object = new r(1, 4, 10);
    }

    public r(int n10, int n11) {
        this(n10, n11, 0);
    }

    public r(int n10, int n11, int n12) {
        this.b = n10;
        this.c = n11;
        this.d = n12;
        this.a = n10 = this.g(n10, n11, n12);
    }

    private final int g(int n10, int n11, int n12) {
        StringBuilder stringBuilder;
        int n13;
        if (n10 >= 0 && (n13 = 255) >= n10 && n11 >= 0 && n13 >= n11 && n12 >= 0 && n13 >= n12) {
            n13 = 1;
        } else {
            n13 = 0;
            stringBuilder = null;
        }
        if (n13 != 0) {
            return (n10 <<= 16) + (n11 <<= 8) + n12;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Version components are out of range: ");
        stringBuilder.append(n10);
        n10 = 46;
        stringBuilder.append((char)n10);
        stringBuilder.append(n11);
        stringBuilder.append((char)n10);
        stringBuilder.append(n12);
        String string2 = stringBuilder.toString();
        string2 = string2.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
        throw illegalArgumentException;
    }

    public int a(r r10) {
        f0.p(r10, "other");
        int n10 = this.a;
        int n11 = r10.a;
        return n10 - n11;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        return this.c;
    }

    public final int d() {
        return this.d;
    }

    public final boolean e(int n10, int n11) {
        int n12 = this.b;
        n10 = n12 <= n10 && (n12 != n10 || (n10 = this.c) < n11) ? 0 : 1;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        boolean bl3 = object instanceof r;
        if (!bl3) {
            n10 = 0;
            object = null;
        }
        object = (r)object;
        bl3 = false;
        if (object != null) {
            int n11 = this.a;
            n10 = ((r)object).a;
            if (n11 != n10) {
                bl2 = false;
            }
            return bl2;
        }
        return false;
    }

    public final boolean f(int n10, int n11, int n12) {
        int n13 = this.b;
        n10 = n13 <= n10 && (n13 != n10 || (n10 = this.c) <= n11 && (n10 != n11 || (n10 = this.d) < n12)) ? 0 : 1;
        return n10 != 0;
    }

    public int hashCode() {
        return this.a;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = this.b;
        stringBuilder.append(n10);
        n10 = 46;
        stringBuilder.append((char)n10);
        int n11 = this.c;
        stringBuilder.append(n11);
        stringBuilder.append((char)n10);
        n10 = this.d;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

