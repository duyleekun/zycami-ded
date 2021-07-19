/*
 * Decompiled with CFR 0.151.
 */
package i.f.e;

public class a {
    public double a;
    public double b;
    public double c;
    public double d;
    public double e;
    public double f;
    public double g;
    public double h;
    public double i;
    public double j;
    public double k;
    public double l;
    public double m;
    public double n;
    public double o;
    public double p;
    public double q;
    public double r;
    public double s;
    public double t;
    public double u;
    public double v;
    public double w;
    public double x;

    public a() {
        this(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0);
    }

    public a(double d10, double d11, double d12, double d13, double d14, double d15, double d16, double d17, double d18, double d19) {
        this.a = d10;
        this.b = d11;
        this.c = d12;
        this.d = d13;
        this.e = d14;
        this.f = d15;
        this.g = d16;
        this.h = d17;
        this.i = d18;
        this.j = d19;
        this.a();
    }

    public a(double[] dArray) {
        this.z(dArray);
    }

    public void A(double d10) {
        this.a = d10;
    }

    public void B(double d10) {
        this.c = d10;
    }

    public void C(double d10) {
        this.f = d10;
    }

    public void D(double d10) {
        this.j = d10;
    }

    public void E(double d10) {
        this.b = d10;
    }

    public void F(double d10) {
        this.e = d10;
    }

    public void G(double d10) {
        this.i = d10;
    }

    public void H(double d10) {
        this.d = d10;
    }

    public void I(double d10) {
        this.h = d10;
    }

    public void J(double d10) {
        this.g = d10;
    }

    public void K(double d10) {
        this.m = d10;
    }

    public void L(double d10) {
        this.q = d10;
    }

    public void M(double d10) {
        this.l = d10;
    }

    public void N(double d10) {
        this.p = d10;
    }

    public void O(double d10) {
        this.k = d10;
    }

    public void P(double d10) {
        this.o = d10;
    }

    public void Q(double d10) {
        this.n = d10;
    }

    public void R(double d10) {
        this.t = d10;
    }

    public void S(double d10) {
        this.x = d10;
    }

    public void T(double d10) {
        this.s = d10;
    }

    public void U(double d10) {
        this.w = d10;
    }

    public void V(double d10) {
        this.r = d10;
    }

    public void W(double d10) {
        this.v = d10;
    }

    public void X(double d10) {
        this.u = d10;
    }

    public void a() {
        double d10;
        double d11;
        a a10 = this;
        double d12 = Math.abs(this.a);
        double d13 = 1.0E-8;
        double d14 = d12 == d13 ? 0 : (d12 > d13 ? 1 : -1);
        double d15 = 0.0;
        if (d14 > 0) {
            d12 = 1.0;
            d13 = this.a;
            d15 = d12 / d13;
            d11 = this.b * d15;
            d10 = this.c * d15;
            double d16 = d15;
            d15 = d11;
            d11 = d16;
        } else {
            d11 = d15;
            d10 = d15;
        }
        double d17 = a10.d;
        double d18 = a10.b;
        double d19 = d18 * d15;
        d17 -= d19;
        d19 = a10.e;
        double d20 = d18 * d10;
        d19 -= d20;
        d20 = a10.f;
        double d21 = d11;
        d11 = a10.c;
        double d22 = d11 * d10;
        a10.k = d17;
        a10.l = d19;
        a10.m = d20 -= d22;
        d22 = d20;
        d20 = a10.g;
        double d23 = 3.0;
        double d24 = d17 * d23;
        double d25 = d15 * d18;
        d24 = (d24 + d25) * d15;
        a10.n = d20 -= d24;
        d19 += d19;
        d20 = a10.h;
        d24 = d15 * d11;
        d24 = (d19 + d24) * d15;
        d20 -= d24;
        a10.o = d20 -= (d17 *= d10);
        d17 = a10.i;
        d19 = (d19 + (d18 *= d10)) * d10;
        d17 -= d19;
        a10.p = d17 -= (d15 *= d22);
        d12 = a10.j;
        d20 = d22 * d23;
        d20 += (d11 *= d10);
        a10.q = d12 -= (d10 *= d20);
        d12 = Math.sqrt(Math.abs(d21));
        d11 = d21 * d21;
        a10.r = d10 = a10.k * d11;
        a10.s = d10 = a10.l * d11;
        a10.t = d10 = a10.m * d11;
        a10.u = d13 = a10.n * (d12 *= d11);
        a10.v = d13 = a10.o * d12;
        a10.w = d13 = a10.p * d12;
        a10.x = d13 = a10.q * d12;
    }

    public double b() {
        return this.a;
    }

    public double c() {
        return this.c;
    }

    public double d() {
        return this.f;
    }

    public double e() {
        return this.j;
    }

    public double f() {
        return this.b;
    }

    public double g() {
        return this.e;
    }

    public double h() {
        return this.i;
    }

    public double i() {
        return this.d;
    }

    public double j() {
        return this.h;
    }

    public double k() {
        return this.g;
    }

    public double l() {
        return this.m;
    }

    public double m() {
        return this.q;
    }

    public double n() {
        return this.l;
    }

    public double o() {
        return this.p;
    }

    public double p() {
        return this.k;
    }

    public double q() {
        return this.o;
    }

    public double r() {
        return this.n;
    }

    public double s() {
        return this.t;
    }

    public double t() {
        return this.x;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Moments [ \nm00=");
        double d10 = this.a;
        stringBuilder.append(d10);
        stringBuilder.append(", \nm10=");
        d10 = this.b;
        stringBuilder.append(d10);
        stringBuilder.append(", m01=");
        d10 = this.c;
        stringBuilder.append(d10);
        stringBuilder.append(", \nm20=");
        d10 = this.d;
        stringBuilder.append(d10);
        stringBuilder.append(", m11=");
        d10 = this.e;
        stringBuilder.append(d10);
        stringBuilder.append(", m02=");
        d10 = this.f;
        stringBuilder.append(d10);
        stringBuilder.append(", \nm30=");
        d10 = this.g;
        stringBuilder.append(d10);
        stringBuilder.append(", m21=");
        d10 = this.h;
        stringBuilder.append(d10);
        stringBuilder.append(", m12=");
        d10 = this.i;
        stringBuilder.append(d10);
        stringBuilder.append(", m03=");
        d10 = this.j;
        stringBuilder.append(d10);
        stringBuilder.append(", \nmu20=");
        d10 = this.k;
        stringBuilder.append(d10);
        stringBuilder.append(", mu11=");
        d10 = this.l;
        stringBuilder.append(d10);
        stringBuilder.append(", mu02=");
        d10 = this.m;
        stringBuilder.append(d10);
        stringBuilder.append(", \nmu30=");
        d10 = this.n;
        stringBuilder.append(d10);
        stringBuilder.append(", mu21=");
        d10 = this.o;
        stringBuilder.append(d10);
        stringBuilder.append(", mu12=");
        d10 = this.p;
        stringBuilder.append(d10);
        stringBuilder.append(", mu03=");
        d10 = this.q;
        stringBuilder.append(d10);
        stringBuilder.append(", \nnu20=");
        d10 = this.r;
        stringBuilder.append(d10);
        stringBuilder.append(", nu11=");
        d10 = this.s;
        stringBuilder.append(d10);
        stringBuilder.append(", nu02=");
        d10 = this.t;
        stringBuilder.append(d10);
        stringBuilder.append(", \nnu30=");
        d10 = this.u;
        stringBuilder.append(d10);
        stringBuilder.append(", nu21=");
        d10 = this.v;
        stringBuilder.append(d10);
        stringBuilder.append(", nu12=");
        d10 = this.w;
        stringBuilder.append(d10);
        stringBuilder.append(", nu03=");
        d10 = this.x;
        stringBuilder.append(d10);
        stringBuilder.append(", \n]");
        return stringBuilder.toString();
    }

    public double u() {
        return this.s;
    }

    public double v() {
        return this.w;
    }

    public double w() {
        return this.r;
    }

    public double x() {
        return this.v;
    }

    public double y() {
        return this.u;
    }

    public void z(double[] dArray) {
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
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.d = d11;
            n10 = dArray.length;
            n11 = 4;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.e = d11;
            n10 = dArray.length;
            n11 = 5;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.f = d11;
            n10 = dArray.length;
            n11 = 6;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.g = d11;
            n10 = dArray.length;
            n11 = 7;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.h = d11;
            n10 = dArray.length;
            n11 = 8;
            d11 = n10 > n11 ? dArray[n11] : d10;
            this.i = d11;
            n10 = dArray.length;
            n11 = 9;
            if (n10 > n11) {
                d10 = dArray[n11];
            }
            this.j = d10;
            this.a();
        } else {
            this.a = d10;
            this.b = d10;
            this.c = d10;
            this.d = d10;
            this.e = d10;
            this.f = d10;
            this.g = d10;
            this.h = d10;
            this.i = d10;
            this.j = d10;
            this.k = d10;
            this.l = d10;
            this.m = d10;
            this.n = d10;
            this.o = d10;
            this.p = d10;
            this.q = d10;
            this.r = d10;
            this.s = d10;
            this.t = d10;
            this.u = d10;
            this.v = d10;
            this.w = d10;
            this.x = d10;
        }
    }
}

