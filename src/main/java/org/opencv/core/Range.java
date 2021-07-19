/*
 * Decompiled with CFR 0.151.
 */
package org.opencv.core;

public class Range {
    public int a;
    public int b;

    public Range() {
        this(0, 0);
    }

    public Range(int n10, int n11) {
        this.a = n10;
        this.b = n11;
    }

    public Range(double[] dArray) {
        this.e(dArray);
    }

    public static Range a() {
        Range range = new Range(-1 << -1, -1 >>> 1);
        return range;
    }

    public Range b() {
        int n10 = this.a;
        int n11 = this.b;
        Range range = new Range(n10, n11);
        return range;
    }

    public boolean c() {
        int n10 = this.b;
        int n11 = this.a;
        n10 = n10 <= n11 ? 1 : 0;
        return n10 != 0;
    }

    public Range d(Range range) {
        int n10 = range.a;
        int n11 = this.a;
        n10 = Math.max(n10, n11);
        int n12 = range.b;
        n11 = this.b;
        n12 = Math.min(n12, n11);
        Range range2 = new Range(n10, n12);
        n12 = range2.b;
        n10 = range2.a;
        range2.b = n12 = Math.max(n12, n10);
        return range2;
    }

    public void e(double[] dArray) {
        int n10 = 0;
        if (dArray != null) {
            int n11 = dArray.length;
            if (n11 > 0) {
                double d10 = dArray[0];
                n11 = (int)d10;
            } else {
                n11 = 0;
            }
            this.a = n11;
            n11 = dArray.length;
            int n12 = 1;
            if (n11 > n12) {
                double d11 = dArray[n12];
                n10 = (int)d11;
            }
            this.b = n10;
        } else {
            this.a = 0;
            this.b = 0;
        }
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof Range;
        if (n11 == 0) {
            return false;
        }
        object = (Range)object;
        n11 = this.a;
        int n12 = ((Range)object).a;
        if (n11 != n12 || (n11 = this.b) != (n10 = ((Range)object).b)) {
            bl2 = false;
        }
        return bl2;
    }

    public Range f(int n10) {
        int n11 = this.a + n10;
        int n12 = this.b + n10;
        Range range = new Range(n11, n12);
        return range;
    }

    public int g() {
        int n10 = this.c();
        if (n10 != 0) {
            n10 = 0;
        } else {
            n10 = this.b;
            int n11 = this.a;
            n10 -= n11;
        }
        return n10;
    }

    public int hashCode() {
        long l10 = Double.doubleToLongBits(this.a);
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 31;
        n11 += n12;
        l11 = Double.doubleToLongBits(this.b);
        n11 *= n12;
        n12 = (int)(l11 >>> n10 ^ l11);
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", ");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

