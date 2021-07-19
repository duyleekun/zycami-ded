/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.Drawable
 */
package d.c.a.s;

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

public class g
extends a {
    private static g V;
    private static g W;
    private static g X;
    private static g Y;
    private static g Z;
    private static g k0;
    private static g o0;
    private static g p0;

    public static g W0(i i10) {
        g g10 = new g();
        return (g)g10.N0(i10);
    }

    public static g X0() {
        g g10 = Z;
        if (g10 == null) {
            g10 = new g();
            Z = g10 = (g)((g)g10.i()).g();
        }
        return Z;
    }

    public static g Y0() {
        g g10 = Y;
        if (g10 == null) {
            g10 = new g();
            Y = g10 = (g)((g)g10.j()).g();
        }
        return Y;
    }

    public static g Z0() {
        g g10 = k0;
        if (g10 == null) {
            g10 = new g();
            k0 = g10 = (g)((g)g10.l()).g();
        }
        return k0;
    }

    public static g a1(Class clazz) {
        g g10 = new g();
        return (g)g10.p(clazz);
    }

    public static g b1(h h10) {
        g g10 = new g();
        return (g)g10.s(h10);
    }

    public static g c1(DownsampleStrategy downsampleStrategy) {
        g g10 = new g();
        return (g)g10.v(downsampleStrategy);
    }

    public static g d1(Bitmap.CompressFormat compressFormat) {
        g g10 = new g();
        return (g)g10.w(compressFormat);
    }

    public static g e1(int n10) {
        g g10 = new g();
        return (g)g10.x(n10);
    }

    public static g f1(int n10) {
        g g10 = new g();
        return (g)g10.y(n10);
    }

    public static g g1(Drawable drawable2) {
        g g10 = new g();
        return (g)g10.z(drawable2);
    }

    public static g h1() {
        g g10 = X;
        if (g10 == null) {
            g10 = new g();
            X = g10 = (g)((g)g10.E()).g();
        }
        return X;
    }

    public static g i1(DecodeFormat decodeFormat) {
        g g10 = new g();
        return (g)g10.F(decodeFormat);
    }

    public static g j1(long l10) {
        g g10 = new g();
        return (g)g10.G(l10);
    }

    public static g k1() {
        g g10 = p0;
        if (g10 == null) {
            g10 = new g();
            p0 = g10 = (g)((g)g10.t()).g();
        }
        return p0;
    }

    public static g l1() {
        g g10 = o0;
        if (g10 == null) {
            g10 = new g();
            o0 = g10 = (g)((g)g10.u()).g();
        }
        return o0;
    }

    public static g m1(e e10, Object object) {
        g g10 = new g();
        return (g)g10.H0(e10, object);
    }

    public static g n1(int n10) {
        return g.o1(n10, n10);
    }

    public static g o1(int n10, int n11) {
        g g10 = new g();
        return (g)g10.z0(n10, n11);
    }

    public static g p1(int n10) {
        g g10 = new g();
        return (g)g10.A0(n10);
    }

    public static g q1(Drawable drawable2) {
        g g10 = new g();
        return (g)g10.B0(drawable2);
    }

    public static g r1(Priority priority) {
        g g10 = new g();
        return (g)g10.C0(priority);
    }

    public static g s1(c c10) {
        g g10 = new g();
        return (g)g10.I0(c10);
    }

    public static g t1(float f10) {
        g g10 = new g();
        return (g)g10.J0(f10);
    }

    public static g u1(boolean bl2) {
        if (bl2) {
            g g10 = V;
            if (g10 == null) {
                g10 = new g();
                boolean bl3 = true;
                V = g10 = (g)((g)g10.K0(bl3)).g();
            }
            return V;
        }
        g g11 = W;
        if (g11 == null) {
            g11 = new g();
            boolean bl4 = false;
            W = g11 = (g)((g)g11.K0(false)).g();
        }
        return W;
    }

    public static g v1(int n10) {
        g g10 = new g();
        return (g)g10.M0(n10);
    }
}

