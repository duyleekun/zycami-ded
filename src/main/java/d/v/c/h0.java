/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 */
package d.v.c;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import d.c.a.c;
import d.c.a.i;
import d.c.a.p.h;
import d.c.a.p.l;
import d.c.a.s.f;
import d.c.a.s.g;
import d.v.c.f0;
import d.v.c.g0;
import java.io.File;
import java.net.URL;

public class h0
extends i {
    public h0(c c10, h h10, l l10, Context context) {
        super(c10, h10, l10, context);
    }

    public void X(g g10) {
        boolean bl2 = g10 instanceof f0;
        if (bl2) {
            super.X(g10);
        } else {
            f0 f02 = new f0();
            g10 = f02.w1(g10);
            super.X(g10);
        }
    }

    public h0 c0(f f10) {
        return (h0)super.r(f10);
    }

    public h0 d0(g object) {
        synchronized (this) {
            object = super.s((g)object);
            object = (h0)object;
            return object;
        }
    }

    public g0 e0(Class clazz) {
        c c10 = this.a;
        Context context = this.b;
        g0 g02 = new g0(c10, this, clazz, context);
        return g02;
    }

    public g0 f0() {
        return (g0)super.u();
    }

    public g0 g0() {
        return (g0)super.v();
    }

    public g0 h0() {
        return (g0)super.w();
    }

    public g0 i0() {
        return (g0)super.x();
    }

    public g0 j0(Object object) {
        return (g0)super.A(object);
    }

    public g0 k0() {
        return (g0)super.B();
    }

    public g0 l0(Bitmap bitmap) {
        return (g0)super.G(bitmap);
    }

    public g0 m0(Drawable drawable2) {
        return (g0)super.H(drawable2);
    }

    public g0 n0(Uri uri) {
        return (g0)super.I(uri);
    }

    public g0 o0(File file) {
        return (g0)super.J(file);
    }

    public g0 p0(Integer n10) {
        return (g0)super.K(n10);
    }

    public g0 q0(Object object) {
        return (g0)super.L(object);
    }

    public g0 r0(String string2) {
        return (g0)super.M(string2);
    }

    public g0 s0(URL uRL) {
        return (g0)super.N(uRL);
    }

    public g0 t0(byte[] byArray) {
        return (g0)super.O(byArray);
    }

    public h0 u0(g object) {
        synchronized (this) {
            object = super.V((g)object);
            object = (h0)object;
            return object;
        }
    }
}

