/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;

public class z {
    public double a;
    public double b;

    public z() {
        double d10 = 0.0;
        this(d10, d10);
    }

    public z(double d10, double d11) {
        this.a = d10;
        this.b = d11;
    }

    public z(u u10) {
        double d10;
        this.a = d10 = u10.a;
        this.b = d10 = u10.b;
    }

    public z(double[] dArray) {
        this.d(dArray);
    }

    public double a() {
        double d10 = this.a;
        double d11 = this.b;
        return d10 * d11;
    }

    public z b() {
        double d10 = this.a;
        double d11 = this.b;
        z z10 = new z(d10, d11);
        return z10;
    }

    public boolean c() {
        double d10;
        double d11 = this.a;
        double d12 = 0.0;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        object = object > 0 && (object = (d10 = (d11 = this.b) - d12) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1)) > 0 ? (Object)false : (Object)true;
        return (boolean)object;
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
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            this.b = d10;
        } else {
            this.a = d10;
            this.b = d10;
        }
    }

    public boolean equals(Object object) {
        double d10;
        double d11;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        Object object2 = object instanceof z;
        if (!object2) {
            return false;
        }
        object = (z)object;
        double d12 = this.a;
        double d13 = ((z)object).a;
        double d14 = d12 - d13;
        object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
        if (object2 || (d11 = (d10 = (d12 = this.b) - (d13 = ((z)object).b)) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        long l10 = Double.doubleToLongBits(this.b);
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 31;
        n11 += n12;
        l11 = Double.doubleToLongBits(this.a);
        n11 *= n12;
        n12 = (int)(l11 >>> n10 ^ l11);
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        int n10 = (int)this.a;
        stringBuilder.append(n10);
        stringBuilder.append("x");
        n10 = (int)this.b;
        stringBuilder.append(n10);
        return stringBuilder.toString();
    }
}

