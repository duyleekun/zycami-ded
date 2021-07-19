/*
 * Decompiled with CFR 0.151.
 */
package f.i2;

import f.i2.a;
import f.i2.c;

public class d
extends c {
    private static final double A(double d10) {
        return Math.exp(d10);
    }

    private static final double A0(double d10, double d11) {
        return Math.pow(d10, d11);
    }

    private static final float B(float f10) {
        return (float)Math.exp(f10);
    }

    private static final double B0(double d10, int n10) {
        double d11 = n10;
        return Math.pow(d10, d11);
    }

    private static final double C(double d10) {
        return Math.expm1(d10);
    }

    private static final float C0(float f10, float f11) {
        double d10 = f10;
        double d11 = f11;
        return (float)Math.pow(d10, d11);
    }

    private static final float D(float f10) {
        return (float)Math.expm1(f10);
    }

    private static final float D0(float f10, int n10) {
        double d10 = f10;
        double d11 = n10;
        return (float)Math.pow(d10, d11);
    }

    private static final double E(double d10) {
        return Math.floor(d10);
    }

    private static final double E0(double d10) {
        return Math.rint(d10);
    }

    private static final float F(float f10) {
        return (float)Math.floor(f10);
    }

    private static final float F0(float f10) {
        return (float)Math.rint(f10);
    }

    private static final double G(double d10) {
        return Math.abs(d10);
    }

    public static final int G0(double d10) {
        int n10 = Double.isNaN(d10);
        if (n10 == 0) {
            n10 = -1 >>> 1;
            double d11 = n10;
            double d12 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
            int n11 = -1 << -1;
            if (d12 <= 0) {
                double d13 = n11;
                double d14 = d10 - d13;
                n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
                if (n10 < 0) {
                    n10 = n11;
                } else {
                    long l10 = Math.round(d10);
                    n10 = (int)l10;
                }
            }
            return n10;
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    private static final float H(float f10) {
        return Math.abs(f10);
    }

    public static final int H0(float f10) {
        boolean bl2 = Float.isNaN(f10);
        if (!bl2) {
            return Math.round(f10);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    private static final int I(int n10) {
        return Math.abs(n10);
    }

    public static final long I0(double d10) {
        boolean bl2 = Double.isNaN(d10);
        if (!bl2) {
            return Math.round(d10);
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("Cannot round NaN value.");
        throw illegalArgumentException;
    }

    private static final long J(long l10) {
        return Math.abs(l10);
    }

    public static final long J0(float f10) {
        return d.I0(f10);
    }

    public static /* synthetic */ void K(double d10) {
    }

    private static final double K0(double d10) {
        return Math.signum(d10);
    }

    public static /* synthetic */ void L(float f10) {
    }

    private static final float L0(float f10) {
        return Math.signum(f10);
    }

    public static /* synthetic */ void M(int n10) {
    }

    private static final double M0(double d10) {
        return Math.sin(d10);
    }

    public static /* synthetic */ void N(long l10) {
    }

    private static final float N0(float f10) {
        return (float)Math.sin(f10);
    }

    private static final double O(double d10) {
        return Math.signum(d10);
    }

    private static final double O0(double d10) {
        return Math.sinh(d10);
    }

    private static final float P(float f10) {
        return Math.signum(f10);
    }

    private static final float P0(float f10) {
        return (float)Math.sinh(f10);
    }

    public static final int Q(int n10) {
        n10 = n10 < 0 ? -1 : (n10 > 0 ? 1 : 0);
        return n10;
    }

    private static final double Q0(double d10) {
        return Math.sqrt(d10);
    }

    public static final int R(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object < 0 ? (Object)-1 : (object > 0 ? (Object)1 : (Object)0);
        return (int)object;
    }

    private static final float R0(float f10) {
        return (float)Math.sqrt(f10);
    }

    public static /* synthetic */ void S(double d10) {
    }

    private static final double S0(double d10) {
        return Math.tan(d10);
    }

    public static /* synthetic */ void T(float f10) {
    }

    private static final float T0(float f10) {
        return (float)Math.tan(f10);
    }

    public static /* synthetic */ void U(int n10) {
    }

    private static final double U0(double d10) {
        return Math.tanh(d10);
    }

    public static /* synthetic */ void V(long l10) {
    }

    private static final float V0(float f10) {
        return (float)Math.tanh(f10);
    }

    private static final double W(double d10) {
        return Math.ulp(d10);
    }

    public static final double W0(double d10) {
        Object object = Double.isNaN(d10);
        if (object == 0 && (object = Double.isInfinite(d10)) == 0) {
            double d11 = 0.0;
            double d12 = d10 - d11;
            object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
            d10 = object > 0 ? Math.floor(d10) : Math.ceil(d10);
        }
        return d10;
    }

    private static final float X(float f10) {
        return Math.ulp(f10);
    }

    public static final float X0(float f10) {
        Object object = Float.isNaN(f10);
        if (object == 0 && (object = Float.isInfinite(f10)) == 0) {
            float f11 = 0.0f;
            float f12 = f10 - f11;
            object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
            double d10 = object > 0 ? Math.floor(f10) : Math.ceil(f10);
            f10 = (float)d10;
        }
        return f10;
    }

    public static /* synthetic */ void Y(double d10) {
    }

    private static final double Y0(double d10, double d11) {
        return Math.copySign(d10, d11);
    }

    public static /* synthetic */ void Z(float f10) {
    }

    private static final double Z0(double d10, int n10) {
        double d11 = n10;
        return Math.copySign(d10, d11);
    }

    private static final double a(double d10, double d11) {
        return Math.IEEEremainder(d10, d11);
    }

    private static final double a0(double d10, double d11) {
        return Math.hypot(d10, d11);
    }

    private static final float a1(float f10, float f11) {
        return Math.copySign(f10, f11);
    }

    private static final float b(float f10, float f11) {
        double d10 = f10;
        double d11 = f11;
        return (float)Math.IEEEremainder(d10, d11);
    }

    private static final float b0(float f10, float f11) {
        double d10 = f10;
        double d11 = f11;
        return (float)Math.hypot(d10, d11);
    }

    private static final float b1(float f10, int n10) {
        float f11 = n10;
        return Math.copySign(f10, f11);
    }

    private static final double c(double d10) {
        return Math.abs(d10);
    }

    private static final double c0(double d10) {
        return Math.log(d10);
    }

    private static final float d(float f10) {
        return Math.abs(f10);
    }

    private static final float d0(float f10) {
        return (float)Math.log(f10);
    }

    private static final int e(int n10) {
        return Math.abs(n10);
    }

    private static final double e0(double d10) {
        return Math.log1p(d10);
    }

    private static final long f(long l10) {
        return Math.abs(l10);
    }

    private static final float f0(float f10) {
        return (float)Math.log1p(f10);
    }

    private static final double g(double d10) {
        return Math.acos(d10);
    }

    public static final double g0(double d10, double d11) {
        double d12;
        double d13 = 0.0;
        double d14 = d11 - d13;
        Object object = d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1);
        if (object > 0 && (object = (d12 = d11 - (d13 = 1.0)) == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1)) != false) {
            d10 = Math.log(d10);
            d11 = Math.log(d11);
            return d10 / d11;
        }
        return 0.0 / 0.0;
    }

    private static final float h(float f10) {
        return (float)Math.acos(f10);
    }

    public static final float h0(float f10, float f11) {
        float f12;
        float f13 = 0.0f;
        float f14 = f11 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1);
        if (object > 0 && (object = (f12 = f11 - (f13 = 1.0f)) == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1)) != false) {
            double d10 = Math.log(f10);
            double d11 = Math.log(f11);
            return (float)(d10 / d11);
        }
        return 0.0f / 0.0f;
    }

    public static final double i(double d10) {
        Object object = 1;
        double d11 = object;
        double d12 = d10 - d11;
        Object object2 = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object2 < 0) {
            d10 = 0.0 / 0.0;
        } else {
            double d13 = a.e;
            double d14 = d10 - d13;
            object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object2 > 0) {
                d10 = Math.log(d10);
                d11 = a.a;
                d10 += d11;
            } else {
                d13 = d10 - d11;
                double d15 = a.d;
                double d16 = d13 - d15;
                Object object3 = d16 == 0.0 ? 0 : (d16 > 0.0 ? 1 : -1);
                if (object3 >= 0) {
                    d13 = d10 * d10 - d11;
                    d11 = Math.sqrt(d13);
                    d10 = Math.log(d10 + d11);
                } else {
                    d10 = Math.sqrt(d13);
                    double d17 = d10 - (d11 = a.c);
                    object = d17 == 0.0 ? 0 : (d17 > 0.0 ? 1 : -1);
                    if (object >= 0) {
                        d11 = d10 * d10 * d10;
                        object2 = 12;
                        d13 = object2;
                        d10 -= (d11 /= d13);
                    }
                    d11 = Math.sqrt(2.0);
                    d10 *= d11;
                }
            }
        }
        return d10;
    }

    private static final double i0(double d10) {
        return Math.log10(d10);
    }

    private static final float j(float f10) {
        return (float)d.i(f10);
    }

    private static final float j0(float f10) {
        return (float)Math.log10(f10);
    }

    private static final double k(double d10) {
        return Math.asin(d10);
    }

    public static final double k0(double d10) {
        d10 = Math.log(d10);
        double d11 = a.a;
        return d10 / d11;
    }

    private static final float l(float f10) {
        return (float)Math.asin(f10);
    }

    public static final float l0(float f10) {
        double d10 = Math.log(f10);
        double d11 = a.a;
        return (float)(d10 / d11);
    }

    public static final double m(double d10) {
        double d11 = a.d;
        double d12 = d10 - d11;
        Object object = d12 == 0.0 ? 0 : (d12 > 0.0 ? 1 : -1);
        if (object >= 0) {
            d11 = a.f;
            Object object2 = d10 == d11 ? 0 : (d10 > d11 ? 1 : -1);
            boolean bl2 = true;
            if (object2 > 0) {
                double d13 = a.e;
                double d14 = d10 - d13;
                object2 = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
                if (object2 > 0) {
                    d10 = Math.log(d10);
                    d11 = a.a;
                    d10 += d11;
                } else {
                    object2 = 2;
                    d13 = object2;
                    d11 = (double)bl2 / (d10 *= d13);
                    d10 = Math.log(d10 + d11);
                }
            } else {
                double d15 = d10 * d10;
                d11 = (double)bl2;
                d15 += d11;
                d11 = Math.sqrt(d15);
                d10 = Math.log(d10 + d11);
            }
        } else {
            double d16 = d10 - (d11 = -d11);
            Object object3 = d16 == 0.0 ? 0 : (d16 < 0.0 ? -1 : 1);
            if (object3 <= 0) {
                d10 = -d.m(-d10);
            } else {
                double d17;
                d11 = Math.abs(d10);
                double d18 = d11 - (d17 = a.c);
                object3 = d18 == 0.0 ? 0 : (d18 > 0.0 ? 1 : -1);
                if (object3 >= 0) {
                    d11 = d10 * d10 * d10;
                    object = 6;
                    d17 = object;
                    d10 -= (d11 /= d17);
                }
            }
        }
        return d10;
    }

    private static final double m0(double d10, double d11) {
        return Math.max(d10, d11);
    }

    private static final float n(float f10) {
        return (float)d.m(f10);
    }

    private static final float n0(float f10, float f11) {
        return Math.max(f10, f11);
    }

    private static final double o(double d10) {
        return Math.atan(d10);
    }

    private static final int o0(int n10, int n11) {
        return Math.max(n10, n11);
    }

    private static final float p(float f10) {
        return (float)Math.atan(f10);
    }

    private static final long p0(long l10, long l11) {
        return Math.max(l10, l11);
    }

    private static final double q(double d10, double d11) {
        return Math.atan2(d10, d11);
    }

    private static final double q0(double d10, double d11) {
        return Math.min(d10, d11);
    }

    private static final float r(float f10, float f11) {
        double d10 = f10;
        double d11 = f11;
        return (float)Math.atan2(d10, d11);
    }

    private static final float r0(float f10, float f11) {
        return Math.min(f10, f11);
    }

    public static final double s(double d10) {
        double d11;
        double d12 = Math.abs(d10);
        double d13 = d12 - (d11 = a.d);
        Object object = d13 == 0.0 ? 0 : (d13 < 0.0 ? -1 : 1);
        if (object < 0) {
            d12 = Math.abs(d10);
            double d14 = d12 - (d11 = a.c);
            object = d14 == 0.0 ? 0 : (d14 > 0.0 ? 1 : -1);
            if (object > 0) {
                d12 = d10 * d10 * d10;
                int n10 = 3;
                d11 = n10;
                d10 += (d12 /= d11);
            }
            return d10;
        }
        d12 = 1.0;
        d11 = d12 + d10;
        d12 -= d10;
        d10 = Math.log(d11 / d12);
        d12 = 2;
        return d10 / d12;
    }

    private static final int s0(int n10, int n11) {
        return Math.min(n10, n11);
    }

    private static final float t(float f10) {
        return (float)d.s(f10);
    }

    private static final long t0(long l10, long l11) {
        return Math.min(l10, l11);
    }

    private static final double u(double d10) {
        return Math.ceil(d10);
    }

    private static final double u0(double d10) {
        return Math.nextAfter(d10, -1.0 / 0.0);
    }

    private static final float v(float f10) {
        return (float)Math.ceil(f10);
    }

    private static final float v0(float f10) {
        return Math.nextAfter(f10, -1.0 / 0.0);
    }

    private static final double w(double d10) {
        return Math.cos(d10);
    }

    private static final double w0(double d10, double d11) {
        return Math.nextAfter(d10, d11);
    }

    private static final float x(float f10) {
        return (float)Math.cos(f10);
    }

    private static final float x0(float f10, float f11) {
        double d10 = f11;
        return Math.nextAfter(f10, d10);
    }

    private static final double y(double d10) {
        return Math.cosh(d10);
    }

    private static final double y0(double d10) {
        return Math.nextUp(d10);
    }

    private static final float z(float f10) {
        return (float)Math.cosh(f10);
    }

    private static final float z0(float f10) {
        return Math.nextUp(f10);
    }
}

