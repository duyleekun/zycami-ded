/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;
import i.f.c.z;

public class v {
    public double a;
    public double b;
    public double c;
    public double d;

    public v() {
        this(0.0, 0.0, 0.0, 0.0);
    }

    public v(double d10, double d11, double d12, double d13) {
        this.a = d10;
        this.b = d11;
        this.c = d12;
        this.d = d13;
    }

    public v(u u10, u u11) {
        double d10 = u10.a;
        double d11 = u11.a;
        double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        double d13 = d12 < 0 ? d10 : d11;
        this.a = d13;
        double d14 = u10.b;
        double d15 = u11.b;
        double d16 = d14 == d15 ? 0 : (d14 < d15 ? -1 : 1);
        double d17 = d16 < 0 ? d14 : d15;
        this.b = d17;
        double d18 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (d18 <= 0) {
            d10 = d11;
        }
        this.c = d10 -= d13;
        double d19 = d14 == d15 ? 0 : (d14 > d15 ? 1 : -1);
        if (d19 <= 0) {
            d14 = d15;
        }
        this.d = d14 -= d17;
    }

    public v(u u10, z z10) {
        double d10 = u10.a;
        double d11 = u10.b;
        double d12 = z10.a;
        double d13 = z10.b;
        this(d10, d11, d12, d13);
    }

    public v(double[] dArray) {
        this.f(dArray);
    }

    public double a() {
        double d10 = this.c;
        double d11 = this.d;
        return d10 * d11;
    }

    public u b() {
        double d10 = this.a;
        double d11 = this.c;
        d10 += d11;
        d11 = this.b;
        double d12 = this.d;
        u u10 = new u(d10, d11 += d12);
        return u10;
    }

    public v c() {
        double d10 = this.a;
        double d11 = this.b;
        double d12 = this.c;
        double d13 = this.d;
        v v10 = new v(d10, d11, d12, d13);
        return v10;
    }

    public boolean d(u u10) {
        double d10;
        double d11;
        int n10;
        double d12;
        double d13;
        double d14;
        double d15 = this.a;
        double d16 = u10.a;
        double d17 = d15 - d16;
        Object object = d17 == 0.0 ? 0 : (d17 < 0.0 ? -1 : 1);
        if (object <= 0 && (d14 = (d13 = d16 - (d15 += (d12 = this.c))) == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1)) < 0 && (n10 = (d11 = (d15 = this.b) - (d16 = u10.b)) == 0.0 ? 0 : (d11 < 0.0 ? -1 : 1)) <= 0 && (n10 = (int)((d10 = d16 - (d15 += (d12 = this.d))) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1))) < 0) {
            n10 = 1;
        } else {
            n10 = 0;
            u10 = null;
        }
        return n10 != 0;
    }

    public boolean e() {
        double d10;
        double d11 = this.c;
        double d12 = 0.0;
        double d13 = d11 - d12;
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        object = object > 0 && (object = (d10 = (d11 = this.d) - d12) == 0.0 ? 0 : (d10 < 0.0 ? -1 : 1)) > 0 ? (Object)false : (Object)true;
        return (boolean)object;
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
        Object object2 = object instanceof v;
        if (!object2) {
            return false;
        }
        object = (v)object;
        double d14 = this.a;
        double d15 = ((v)object).a;
        double d16 = d14 - d15;
        object2 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
        if (object2 || (object2 = (d13 = (d14 = this.b) - (d15 = ((v)object).b)) == 0.0 ? 0 : (d13 > 0.0 ? 1 : -1)) || (object2 = (d12 = (d14 = this.c) - (d15 = ((v)object).c)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) || (d11 = (d10 = (d14 = this.d) - (d15 = ((v)object).d)) == 0.0 ? 0 : (d10 > 0.0 ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public void f(double[] dArray) {
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
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.c = d11;
            n10 = dArray.length;
            n11 = 3;
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            this.d = d10;
        } else {
            this.a = d10;
            this.b = d10;
            this.c = d10;
            this.d = d10;
        }
    }

    public z g() {
        double d10 = this.c;
        double d11 = this.d;
        z z10 = new z(d10, d11);
        return z10;
    }

    public u h() {
        double d10 = this.a;
        double d11 = this.b;
        u u10 = new u(d10, d11);
        return u10;
    }

    public int hashCode() {
        long l10 = Double.doubleToLongBits(this.d);
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 31;
        n11 += n12;
        l11 = Double.doubleToLongBits(this.c);
        n11 *= n12;
        long l12 = l11 >>> n10;
        int n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.a);
        n11 *= n12;
        l12 = l11 >>> n10;
        n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.b);
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
        stringBuilder.append("x");
        d10 = this.d;
        stringBuilder.append(d10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

