/*
 * Decompiled with CFR 0.151.
 */
package f.r2;

import f.h2.t.f0;
import f.r2.d;
import f.r2.h;
import java.util.concurrent.TimeUnit;

public final class e {
    public static final double A(int n10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return e.W(n10, timeUnit);
    }

    public static final double B(long l10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void C(double d10) {
    }

    public static /* synthetic */ void D(int n10) {
    }

    public static /* synthetic */ void E(long l10) {
    }

    public static final double F(double d10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return e.V(d10, timeUnit);
    }

    public static final double G(int n10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return e.W(n10, timeUnit);
    }

    public static final double H(long l10) {
        TimeUnit timeUnit = TimeUnit.NANOSECONDS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void I(double d10) {
    }

    public static /* synthetic */ void J(int n10) {
    }

    public static /* synthetic */ void K(long l10) {
    }

    public static final double L(double d10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return e.V(d10, timeUnit);
    }

    public static final double M(int n10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return e.W(n10, timeUnit);
    }

    public static final double N(long l10) {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void O(double d10) {
    }

    public static /* synthetic */ void P(int n10) {
    }

    public static /* synthetic */ void Q(long l10) {
    }

    private static final TimeUnit R() {
        return TimeUnit.NANOSECONDS;
    }

    private static /* synthetic */ void S() {
    }

    private static final double T(double d10, double d11) {
        return d.K(d11, d10);
    }

    private static final double U(int n10, double d10) {
        return d.L(d10, n10);
    }

    public static final double V(double d10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
        return d.f(h.b(d10, timeUnit, timeUnit2));
    }

    public static final double W(int n10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        return e.V(n10, timeUnit);
    }

    public static final double X(long l10, TimeUnit timeUnit) {
        f0.p((Object)timeUnit, "unit");
        return e.V(l10, timeUnit);
    }

    public static final /* synthetic */ TimeUnit a() {
        return e.R();
    }

    public static final double b(double d10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        return e.V(d10, timeUnit);
    }

    public static final double c(int n10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        return e.W(n10, timeUnit);
    }

    public static final double d(long l10) {
        TimeUnit timeUnit = TimeUnit.DAYS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void e(double d10) {
    }

    public static /* synthetic */ void f(int n10) {
    }

    public static /* synthetic */ void g(long l10) {
    }

    public static final double h(double d10) {
        TimeUnit timeUnit = TimeUnit.HOURS;
        return e.V(d10, timeUnit);
    }

    public static final double i(int n10) {
        TimeUnit timeUnit = TimeUnit.HOURS;
        return e.W(n10, timeUnit);
    }

    public static final double j(long l10) {
        TimeUnit timeUnit = TimeUnit.HOURS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void k(double d10) {
    }

    public static /* synthetic */ void l(int n10) {
    }

    public static /* synthetic */ void m(long l10) {
    }

    public static final double n(double d10) {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return e.V(d10, timeUnit);
    }

    public static final double o(int n10) {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return e.W(n10, timeUnit);
    }

    public static final double p(long l10) {
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void q(double d10) {
    }

    public static /* synthetic */ void r(int n10) {
    }

    public static /* synthetic */ void s(long l10) {
    }

    public static final double t(double d10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return e.V(d10, timeUnit);
    }

    public static final double u(int n10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return e.W(n10, timeUnit);
    }

    public static final double v(long l10) {
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        return e.X(l10, timeUnit);
    }

    public static /* synthetic */ void w(double d10) {
    }

    public static /* synthetic */ void x(int n10) {
    }

    public static /* synthetic */ void y(long l10) {
    }

    public static final double z(double d10) {
        TimeUnit timeUnit = TimeUnit.MINUTES;
        return e.V(d10, timeUnit);
    }
}

