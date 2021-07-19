/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;
import i.f.c.z;

public class w {
    public int a;
    public int b;
    public int c;
    public int d;

    public w() {
        this(0, 0, 0, 0);
    }

    public w(int n10, int n11, int n12, int n13) {
        this.a = n10;
        this.b = n11;
        this.c = n12;
        this.d = n13;
    }

    public w(u u10, u u11) {
        int n10;
        int n11;
        double d10 = u10.a;
        double d11 = u11.a;
        double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        double d13 = d12 < 0 ? d10 : d11;
        d12 = (int)d13;
        this.a = (int)d12;
        double d14 = u10.b;
        double d15 = u11.b;
        double d16 = d14 == d15 ? 0 : (d14 < d15 ? -1 : 1);
        double d17 = d16 < 0 ? d14 : d15;
        d16 = (int)d17;
        this.b = (int)d16;
        double d18 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
        if (d18 <= 0) {
            d10 = d11;
        }
        this.c = n11 = (int)d10 - d12;
        n11 = (int)(d14 == d15 ? 0 : (d14 > d15 ? 1 : -1));
        if (n11 <= 0) {
            d14 = d15;
        }
        this.d = n10 = (int)d14 - d16;
    }

    public w(u u10, z z10) {
        int n10 = (int)u10.a;
        int n11 = (int)u10.b;
        int n12 = (int)z10.a;
        int n13 = (int)z10.b;
        this(n10, n11, n12, n13);
    }

    public w(double[] dArray) {
        this.f(dArray);
    }

    public double a() {
        int n10 = this.c;
        int n11 = this.d;
        return n10 * n11;
    }

    public u b() {
        int n10 = this.a;
        int n11 = this.c;
        double d10 = n10 + n11;
        int n12 = this.b;
        int n13 = this.d;
        double d11 = n12 + n13;
        u u10 = new u(d10, d11);
        return u10;
    }

    public w c() {
        int n10 = this.a;
        int n11 = this.b;
        int n12 = this.c;
        int n13 = this.d;
        w w10 = new w(n10, n11, n12, n13);
        return w10;
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public boolean d(u u10) {
        int n10 = this.a;
        double d10 = n10;
        double d11 = u10.a;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object > 0) return 0 != 0;
        int n11 = this.c;
        double d13 = n10 + n11;
        double d14 = d11 - d13;
        if ((n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1))) >= 0) return 0 != 0;
        n10 = this.b;
        d10 = n10;
        d11 = u10.b;
        double d15 = d10 - d11;
        Object object2 = d15 == 0.0 ? 0 : (d15 < 0.0 ? -1 : 1);
        if (object2 > 0) return 0 != 0;
        object2 = this.d;
        d13 = n10 += object2;
        double d16 = d11 - d13;
        if ((object2 = (Object)(d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1))) >= 0) return 0 != 0;
        return 1 != 0;
    }

    public boolean e() {
        int n10 = this.c;
        n10 = n10 > 0 && (n10 = this.d) > 0 ? 0 : 1;
        return n10 != 0;
    }

    public boolean equals(Object object) {
        int n10;
        boolean bl2 = true;
        if (this == object) {
            return bl2;
        }
        int n11 = object instanceof w;
        if (n11 == 0) {
            return false;
        }
        object = (w)object;
        n11 = this.a;
        int n12 = ((w)object).a;
        if (n11 != n12 || (n11 = this.b) != (n12 = ((w)object).b) || (n11 = this.c) != (n12 = ((w)object).c) || (n11 = this.d) != (n10 = ((w)object).d)) {
            bl2 = false;
        }
        return bl2;
    }

    public void f(double[] dArray) {
        int n10 = 0;
        if (dArray != null) {
            double d10;
            int n11 = dArray.length;
            if (n11 > 0) {
                d10 = dArray[0];
                n11 = (int)d10;
            } else {
                n11 = 0;
            }
            this.a = n11;
            n11 = dArray.length;
            int n12 = 1;
            if (n11 > n12) {
                d10 = dArray[n12];
                n11 = (int)d10;
            } else {
                n11 = 0;
            }
            this.b = n11;
            n11 = dArray.length;
            n12 = 2;
            if (n11 > n12) {
                d10 = dArray[n12];
                n11 = (int)d10;
            } else {
                n11 = 0;
            }
            this.c = n11;
            n11 = dArray.length;
            n12 = 3;
            if (n11 > n12) {
                double d11 = dArray[n12];
                n10 = (int)d11;
            }
            this.d = n10;
        } else {
            this.a = 0;
            this.b = 0;
            this.c = 0;
            this.d = 0;
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
        int n10 = this.a;
        stringBuilder.append(n10);
        String string2 = ", ";
        stringBuilder.append(string2);
        int n11 = this.b;
        stringBuilder.append(n11);
        stringBuilder.append(string2);
        n10 = this.c;
        stringBuilder.append(n10);
        stringBuilder.append("x");
        n10 = this.d;
        stringBuilder.append(n10);
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}

