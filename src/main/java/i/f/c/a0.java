/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

public class a0 {
    public static final int d = 1;
    public static final int e = 1;
    public static final int f = 2;
    public int a;
    public int b;
    public double c;

    public a0() {
        this(0, 0, 0.0);
    }

    public a0(int n10, int n11, double d10) {
        this.a = n10;
        this.b = n11;
        this.c = d10;
    }

    public a0(double[] dArray) {
        this.b(dArray);
    }

    public a0 a() {
        int n10 = this.a;
        int n11 = this.b;
        double d10 = this.c;
        a0 a02 = new a0(n10, n11, d10);
        return a02;
    }

    public void b(double[] dArray) {
        double d10 = 0.0;
        int n10 = 0;
        if (dArray != null) {
            int n11 = dArray.length;
            if (n11 > 0) {
                double d11 = dArray[0];
                n11 = (int)d11;
            } else {
                n11 = 0;
            }
            this.a = n11;
            n11 = dArray.length;
            int n12 = 1;
            if (n11 > n12) {
                double d12 = dArray[n12];
                n10 = (int)d12;
            }
            this.b = n10;
            n10 = dArray.length;
            n11 = 2;
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            this.c = d10;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = d10;
        }
    }

    public boolean equals(Object object) {
        double d10;
        double d11;
        double d12;
        double d13;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n10 = object instanceof a0;
        if (n10 == 0) {
            return false;
        }
        object = (a0)object;
        n10 = this.a;
        int n11 = ((a0)object).a;
        if (n10 != n11 || (n10 = this.b) != (n11 = ((a0)object).b) || (d13 = (d12 = (d11 = this.c) - (d10 = ((a0)object).c)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
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
        long l12 = l11 >>> n10;
        int n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.c);
        n11 *= n12;
        n12 = (int)(l11 >>> n10 ^ l11);
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ type: ");
        int n10 = this.a;
        stringBuilder.append(n10);
        stringBuilder.append(", maxCount: ");
        n10 = this.b;
        stringBuilder.append(n10);
        stringBuilder.append(", epsilon: ");
        double d10 = this.c;
        stringBuilder.append(d10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

