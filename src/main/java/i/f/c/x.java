/*
 * Decompiled with CFR 0.151.
 */
package i.f.c;

import i.f.c.u;
import i.f.c.w;
import i.f.c.z;

public class x {
    public u a;
    public z b;
    public double c;

    public x() {
        Object object = new u();
        this.a = object;
        this.b = object = new z();
        this.c = 0.0;
    }

    public x(u object, z z10, double d10) {
        object = ((u)object).a();
        this.a = object;
        this.b = object = z10.b();
        this.c = d10;
    }

    public x(double[] dArray) {
        this();
        this.d(dArray);
    }

    public w a() {
        u[] uArray = new u[4];
        this.c(uArray);
        double d10 = uArray[0].a;
        int n10 = 1;
        double d11 = uArray[n10].a;
        d10 = Math.min(d10, d11);
        int n11 = 2;
        double d12 = uArray[n11].a;
        d10 = Math.min(d10, d12);
        int n12 = 3;
        double d13 = uArray[n12].a;
        int n13 = (int)Math.floor(Math.min(d10, d13));
        d13 = uArray[0].b;
        double d14 = uArray[n10].b;
        d13 = Math.min(d13, d14);
        d14 = uArray[n11].b;
        d13 = Math.min(d13, d14);
        d14 = uArray[n12].b;
        int n14 = (int)Math.floor(Math.min(d13, d14));
        d13 = uArray[0].a;
        d14 = uArray[n10].a;
        d13 = Math.max(d13, d14);
        d14 = uArray[n11].a;
        d13 = Math.max(d13, d14);
        d14 = uArray[n12].a;
        int n15 = (int)Math.ceil(Math.max(d13, d14));
        double d15 = uArray[0].b;
        double d16 = uArray[n10].b;
        d15 = Math.max(d15, d16);
        d16 = uArray[n11].b;
        d15 = Math.max(d15, d16);
        d11 = uArray[n12].b;
        int n16 = (int)Math.ceil(Math.max(d15, d11));
        w w10 = new w(n13, n14, n15, n16);
        n16 = w10.c;
        int n17 = w10.a - n10;
        w10.c = n16 -= n17;
        n16 = w10.d;
        n17 = w10.b - n10;
        w10.d = n16 -= n17;
        return w10;
    }

    public x b() {
        u u10 = this.a;
        z z10 = this.b;
        double d10 = this.c;
        x x10 = new x(u10, z10, d10);
        return x10;
    }

    public void c(u[] uArray) {
        u u10;
        u u11;
        double d10 = this.c * Math.PI / 180.0;
        double d11 = Math.cos(d10);
        double d12 = 0.5;
        d10 = Math.sin(d10) * d12;
        u u12 = this.a;
        double d13 = u12.a;
        z z10 = this.b;
        double d14 = z10.b;
        double d15 = d10 * d14;
        d13 -= d15;
        d15 = z10.a;
        double d16 = (d11 *= d12) * d15;
        d13 -= d16;
        d16 = u12.b;
        d16 += (d14 *= d11);
        uArray[0] = u11 = new u(d13, d16 -= (d15 *= d10));
        u u13 = this.a;
        double d17 = u13.a;
        z z11 = this.b;
        double d18 = z11.b;
        double d19 = d10 * d18;
        d17 += d19;
        d19 = z11.a;
        double d20 = d11 * d19;
        double d21 = u13.b;
        d21 -= (d11 *= d18);
        u11 = new u(d17 -= d20, d21 -= (d10 *= d19));
        int n10 = 1;
        uArray[n10] = u11;
        u u14 = this.a;
        double d22 = u14.a;
        d21 = 2.0;
        d22 *= d21;
        double d23 = uArray[0].a;
        d22 -= d23;
        d23 = u14.b * d21;
        d18 = uArray[0].b;
        uArray[2] = u10 = new u(d22, d23 -= d18);
        u14 = this.a;
        d22 = u14.a * d21;
        d17 = uArray[n10].a;
        d22 -= d17;
        d17 = u14.b * d21;
        d21 = uArray[n10].b;
        uArray[3] = u10 = new u(d22, d17 -= d21);
    }

    public void d(double[] object) {
        double d10 = 0.0;
        if (object != null) {
            double d11;
            Object object2 = this.a;
            int n10 = ((double[])object).length;
            if (n10 > 0) {
                n10 = 0;
                d11 = object[0];
            } else {
                d11 = d10;
            }
            ((u)object2).a = d11;
            n10 = ((double[])object).length;
            int n11 = 1;
            d11 = n10 > n11 ? object[n11] : d10;
            ((u)object2).b = d11;
            object2 = this.b;
            n10 = ((double[])object).length;
            n11 = 2;
            d11 = n10 > n11 ? object[n11] : d10;
            ((z)object2).a = d11;
            n10 = ((double[])object).length;
            n11 = 3;
            d11 = n10 > n11 ? object[n11] : d10;
            ((z)object2).b = d11;
            int n12 = ((double[])object).length;
            n10 = 4;
            if (n12 > n10) {
                d10 = object[n10];
            }
            this.c = d10;
        } else {
            object = this.a;
            object.a = d10;
            object.b = d10;
            object = this.b;
            object.a = d10;
            object.b = d10;
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
        boolean bl3 = object instanceof x;
        if (!bl3) {
            return false;
        }
        object = (x)object;
        Object object2 = this.a;
        Object object3 = ((x)object).a;
        bl3 = ((u)object2).equals(object3);
        if (!bl3 || !(bl3 = ((z)(object2 = this.b)).equals(object3 = ((x)object).b)) || (d13 = (d12 = (d11 = this.c) - (d10 = ((x)object).c)) == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1)) != false) {
            bl2 = false;
        }
        return bl2;
    }

    public int hashCode() {
        long l10 = Double.doubleToLongBits(this.a.a);
        int n10 = 32;
        long l11 = l10 >>> n10;
        int n11 = (int)(l10 ^ l11);
        int n12 = 31;
        n11 += n12;
        l11 = Double.doubleToLongBits(this.a.b);
        n11 *= n12;
        long l12 = l11 >>> n10;
        int n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.b.a);
        n11 *= n12;
        l12 = l11 >>> n10;
        n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.b.b);
        n11 *= n12;
        l12 = l11 >>> n10;
        n13 = (int)(l11 ^ l12);
        n11 += n13;
        l11 = Double.doubleToLongBits(this.c);
        n11 *= n12;
        n12 = (int)(l11 >>> n10 ^ l11);
        return n11 + n12;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{ ");
        Object object = this.a;
        stringBuilder.append(object);
        stringBuilder.append(" ");
        object = this.b;
        stringBuilder.append(object);
        stringBuilder.append(" * ");
        double d10 = this.c;
        stringBuilder.append(d10);
        stringBuilder.append(" }");
        return stringBuilder.toString();
    }
}

