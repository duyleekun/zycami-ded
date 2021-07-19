/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.Drawable
 */
package d.v.c;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import d.c.a.o.c;
import d.c.a.o.e;
import d.c.a.o.i;
import d.c.a.o.k.h;
import d.c.a.s.a;
import d.c.a.s.g;

public final class f0
extends g
implements Cloneable {
    private static f0 q0;
    private static f0 r0;
    private static f0 s0;
    private static f0 t0;
    private static f0 u0;
    private static f0 v0;

    public static f0 A1() {
        f0 f02 = s0;
        if (f02 == null) {
            f02 = new f0();
            s0 = f02 = f02.z1().x1();
        }
        return s0;
    }

    public static f0 C1() {
        f0 f02 = r0;
        if (f02 == null) {
            f02 = new f0();
            r0 = f02 = f02.B1().x1();
        }
        return r0;
    }

    public static f0 C2(c c10) {
        f0 f02 = new f0();
        return f02.B2(c10);
    }

    public static f0 E1() {
        f0 f02 = t0;
        if (f02 == null) {
            f02 = new f0();
            t0 = f02 = f02.D1().x1();
        }
        return t0;
    }

    public static f0 E2(float f10) {
        f0 f02 = new f0();
        return f02.D2(f10);
    }

    public static f0 G2(boolean bl2) {
        f0 f02 = new f0();
        return f02.F2(bl2);
    }

    public static f0 H1(Class clazz) {
        f0 f02 = new f0();
        return f02.G1(clazz);
    }

    public static f0 J2(int n10) {
        f0 f02 = new f0();
        return f02.I2(n10);
    }

    public static f0 K1(h h10) {
        f0 f02 = new f0();
        return f02.J1(h10);
    }

    public static f0 O1(DownsampleStrategy downsampleStrategy) {
        f0 f02 = new f0();
        return f02.N1(downsampleStrategy);
    }

    public static f0 Q1(Bitmap.CompressFormat compressFormat) {
        f0 f02 = new f0();
        return f02.P1(compressFormat);
    }

    public static f0 S1(int n10) {
        f0 f02 = new f0();
        return f02.R1(n10);
    }

    public static f0 V1(int n10) {
        f0 f02 = new f0();
        return f02.T1(n10);
    }

    public static f0 W1(Drawable drawable2) {
        f0 f02 = new f0();
        return f02.U1(drawable2);
    }

    public static f0 a2() {
        f0 f02 = q0;
        if (f02 == null) {
            f02 = new f0();
            q0 = f02 = f02.Z1().x1();
        }
        return q0;
    }

    public static f0 c2(DecodeFormat decodeFormat) {
        f0 f02 = new f0();
        return f02.b2(decodeFormat);
    }

    public static f0 e2(long l10) {
        f0 f02 = new f0();
        return f02.d2(l10);
    }

    public static f0 g2() {
        f0 f02 = v0;
        if (f02 == null) {
            f02 = new f0();
            v0 = f02 = f02.L1().x1();
        }
        return v0;
    }

    public static f0 h2() {
        f0 f02 = u0;
        if (f02 == null) {
            f02 = new f0();
            u0 = f02 = f02.M1().x1();
        }
        return u0;
    }

    public static f0 j2(e e10, Object object) {
        f0 f02 = new f0();
        return f02.A2(e10, object);
    }

    public static f0 s2(int n10) {
        f0 f02 = new f0();
        return f02.q2(n10);
    }

    public static f0 t2(int n10, int n11) {
        f0 f02 = new f0();
        return f02.r2(n10, n11);
    }

    public static f0 w2(int n10) {
        f0 f02 = new f0();
        return f02.u2(n10);
    }

    public static f0 x2(Drawable drawable2) {
        f0 f02 = new f0();
        return f02.v2(drawable2);
    }

    public static f0 y1(i i10) {
        f0 f02 = new f0();
        return f02.K2(i10);
    }

    public static f0 z2(Priority priority) {
        f0 f02 = new f0();
        return f02.y2(priority);
    }

    public f0 A2(e e10, Object object) {
        return (f0)super.H0(e10, object);
    }

    public f0 B1() {
        return (f0)super.j();
    }

    public f0 B2(c c10) {
        return (f0)super.I0(c10);
    }

    public f0 D1() {
        return (f0)super.l();
    }

    public f0 D2(float f10) {
        return (f0)super.J0(f10);
    }

    public f0 F1() {
        return (f0)super.m();
    }

    public f0 F2(boolean bl2) {
        return (f0)super.K0(bl2);
    }

    public f0 G1(Class clazz) {
        return (f0)super.p(clazz);
    }

    public f0 H2(Resources.Theme theme) {
        return (f0)super.L0(theme);
    }

    public f0 I1() {
        return (f0)super.r();
    }

    public f0 I2(int n10) {
        return (f0)super.M0(n10);
    }

    public f0 J1(h h10) {
        return (f0)super.s(h10);
    }

    public f0 K2(i i10) {
        return (f0)super.N0(i10);
    }

    public f0 L1() {
        return (f0)super.t();
    }

    public f0 L2(Class clazz, i i10) {
        return (f0)super.Q0(clazz, i10);
    }

    public f0 M1() {
        return (f0)super.u();
    }

    public final f0 M2(i ... iArray) {
        return (f0)super.S0(iArray);
    }

    public f0 N1(DownsampleStrategy downsampleStrategy) {
        return (f0)super.v(downsampleStrategy);
    }

    public final f0 N2(i ... iArray) {
        return (f0)super.T0(iArray);
    }

    public f0 O2(boolean bl2) {
        return (f0)super.U0(bl2);
    }

    public f0 P1(Bitmap.CompressFormat compressFormat) {
        return (f0)super.w(compressFormat);
    }

    public f0 P2(boolean bl2) {
        return (f0)super.V0(bl2);
    }

    public f0 R1(int n10) {
        return (f0)super.x(n10);
    }

    public f0 T1(int n10) {
        return (f0)super.y(n10);
    }

    public f0 U1(Drawable drawable2) {
        return (f0)super.z(drawable2);
    }

    public f0 X1(int n10) {
        return (f0)super.A(n10);
    }

    public f0 Y1(Drawable drawable2) {
        return (f0)super.B(drawable2);
    }

    public f0 Z1() {
        return (f0)super.E();
    }

    public f0 b2(DecodeFormat decodeFormat) {
        return (f0)super.F(decodeFormat);
    }

    public f0 d2(long l10) {
        return (f0)super.G(l10);
    }

    public f0 f2() {
        return (f0)super.o0();
    }

    public f0 i2(boolean bl2) {
        return (f0)super.p0(bl2);
    }

    public f0 k2() {
        return (f0)super.q0();
    }

    public f0 l2() {
        return (f0)super.r0();
    }

    public f0 m2() {
        return (f0)super.s0();
    }

    public f0 n2() {
        return (f0)super.t0();
    }

    public f0 o2(i i10) {
        return (f0)super.v0(i10);
    }

    public f0 p2(Class clazz, i i10) {
        return (f0)super.x0(clazz, i10);
    }

    public f0 q2(int n10) {
        return (f0)super.y0(n10);
    }

    public f0 r2(int n10, int n11) {
        return (f0)super.z0(n10, n11);
    }

    public f0 u2(int n10) {
        return (f0)super.A0(n10);
    }

    public f0 v2(Drawable drawable2) {
        return (f0)super.B0(drawable2);
    }

    public f0 w1(a a10) {
        return (f0)super.a(a10);
    }

    public f0 x1() {
        return (f0)super.g();
    }

    public f0 y2(Priority priority) {
        return (f0)super.C0(priority);
    }

    public f0 z1() {
        return (f0)super.i();
    }
}

