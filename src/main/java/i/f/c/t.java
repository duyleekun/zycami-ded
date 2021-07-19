/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;

public class t {
    public double a;
    public double b;
    public double c;

    public t() {
        this(0.0, 0.0, 0.0);
    }

    public t(double d10, double d11, double d12) {
        this.a = d10;
        this.b = d11;
        this.c = d12;
    }

    public t(u u10) {
        double d10;
        this.a = d10 = u10.a;
        this.b = d10 = u10.b;
        this.c = 0.0;
    }

    public t(double[] dArray) {
        this();
        this.d(dArray);
    }

    public t a() {
        double d10 = this.a;
        double d11 = this.b;
        double d12 = this.c;
        t t10 = new t(d10, d11, d12);
        return t10;
    }

    public t b(t t10) {
        double d10 = this.b;
        double d11 = t10.c;
        double d12 = d10 * d11;
        double d13 = this.c;
        double d14 = t10.b;
        double d15 = d13 * d14;
        d12 -= d15;
        d15 = t10.a;
        double d16 = d12;
        d12 = this.a;
        d11 *= d12;
        d11 = (d13 *= d15) - d11;
        d12 *= d14;
        d10 = d16;
        t t11 = new t(d16, d11, d12 -= (d10 *= d15));
        return t11;
    }

    public double c(t t10) {
        double d10 = this.a;
        double d11 = t10.a;
        d10 *= d11;
        d11 = this.b;
        double d12 = t10.b;
        d10 += (d11 *= d12);
        d11 = this.c;
        d12 = t10.c;
        return d10 + (d11 *= d12);
    }

    public void d(double[] dArray) {
        double d10 = 0.0;
        if (dArray != null) {
            double d11;
            int n10 = dArray.length;
            if (n10 > 0) {
                n10 = 0;
                d11 = dArray[0];
            } else {
                d11 = d10;
            }
            this.a = d11;
            n10 = dArray.length;
            int n11 = 1;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.b = d11;
            n10 = dArray.length;
            n11 = 2;
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            this.c = d10;
        } else {
            this.a = d10;
            this.b = d10;
            this.c = d10;
        }
    }

    public boolean equals(Object object) {
        double d10;
        double d11;
        double d12;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof t;
        if (!object2) {
            return false;
        }
        object = (t)object;
        double d13 = this.a;
        double d14 = ((t)object).a;
        double d15 = d13 - d14;
        object2 = d15 == 0.0 ? 0 : (d15 > 0.0 ? 1 : -1);
        if (object2 || (object2 = (d12 = (d13 = this.b) - (d14 = ((t)object).b)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) || (d11 = (d10 = (d13 = this.c) - (d14 = ((t)object).c)) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
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
        stringBuilder.append("{");
        double d10 = this.a;
        stringBuilder.append(d10);
        String string2 = ", ";
        stringBuilder.append(string2);
        double d11 = this.b;
        stringBuilder.append(d11);
        stringBuilder.append(string2);
        d10 = this.c;
        stringBuilder.append(d10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

