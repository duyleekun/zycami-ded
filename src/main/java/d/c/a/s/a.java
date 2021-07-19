/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.res.Resources$Theme
 *  android.graphics.Bitmap
 *  android.graphics.Bitmap$CompressFormat
 *  android.graphics.drawable.BitmapDrawable
 *  android.graphics.drawable.Drawable
 */
package d.c.a.s;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy;
import d.c.a.o.d;
import d.c.a.o.e;
import d.c.a.o.f;
import d.c.a.o.i;
import d.c.a.o.k.h;
import d.c.a.o.m.d.g0;
import d.c.a.o.m.d.l;
import d.c.a.o.m.d.n;
import d.c.a.o.m.d.o;
import d.c.a.o.m.d.q;
import d.c.a.o.m.d.s;
import d.c.a.t.c;
import d.c.a.u.b;
import d.c.a.u.k;
import d.c.a.u.m;
import java.util.Map;

public abstract class a
implements Cloneable {
    private static final int A = 255;
    private static final int B = 2;
    private static final int C = 4;
    private static final int D = 8;
    private static final int E = 16;
    private static final int F = 32;
    private static final int G = 64;
    private static final int H = 128;
    private static final int I = 256;
    private static final int J = 512;
    private static final int K = 1024;
    private static final int L = 2048;
    private static final int M = 4096;
    private static final int N = 8192;
    private static final int O = 16384;
    private static final int P = 32768;
    private static final int Q = 65536;
    private static final int R = 131072;
    private static final int S = 262144;
    private static final int T = 524288;
    private static final int U = 0x100000;
    private int a;
    private float b = 1.0f;
    private h c;
    private Priority d;
    private Drawable e;
    private int f;
    private Drawable g;
    private int h;
    private boolean i;
    private int j;
    private int k;
    private d.c.a.o.c l;
    private boolean m;
    private boolean n;
    private Drawable o;
    private int p;
    private f q;
    private Map r;
    private Class s;
    private boolean t;
    private Resources.Theme u;
    private boolean v;
    private boolean w;
    private boolean x;
    private boolean y;
    private boolean z;

    public a() {
        int n10;
        boolean bl2;
        Object object;
        this.c = object = d.c.a.o.k.h.e;
        object = Priority.NORMAL;
        this.d = object;
        this.i = bl2 = true;
        this.j = n10 = -1;
        this.k = n10;
        Object object2 = d.c.a.t.c.c();
        this.l = object2;
        this.n = bl2;
        this.q = object2;
        this.r = object2 = new b();
        this.s = Object.class;
        this.y = bl2;
    }

    private a D0(DownsampleStrategy downsampleStrategy, i i10) {
        return this.E0(downsampleStrategy, i10, true);
    }

    private a E0(DownsampleStrategy object, i i10, boolean bl2) {
        object = bl2 ? this.P0((DownsampleStrategy)object, i10) : this.w0((DownsampleStrategy)object, i10);
        ((a)object).y = true;
        return object;
    }

    private a F0() {
        return this;
    }

    private a G0() {
        boolean bl2 = this.t;
        if (!bl2) {
            return this.F0();
        }
        IllegalStateException illegalStateException = new IllegalStateException("You cannot modify locked T, consider clone()");
        throw illegalStateException;
    }

    private boolean h0(int n10) {
        return d.c.a.s.a.i0(this.a, n10);
    }

    private static boolean i0(int n10, int n11) {
        n10 = (n10 &= n11) != 0 ? 1 : 0;
        return n10 != 0;
    }

    private a u0(DownsampleStrategy downsampleStrategy, i i10) {
        return this.E0(downsampleStrategy, i10, false);
    }

    public a A(int n10) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().A(n10);
        }
        this.p = n10;
        this.a = n10 = this.a | 0x4000;
        this.o = null;
        this.a = n10 &= 0xFFFFDFFF;
        return this.G0();
    }

    public a A0(int n10) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().A0(n10);
        }
        this.h = n10;
        this.a = n10 = this.a | 0x80;
        this.g = null;
        this.a = n10 &= 0xFFFFFFBF;
        return this.G0();
    }

    public a B(Drawable drawable2) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().B(drawable2);
        }
        this.o = drawable2;
        this.a = n10 = this.a | 0x2000;
        this.p = 0;
        this.a = n10 &= 0xFFFFBFFF;
        return this.G0();
    }

    public a B0(Drawable drawable2) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().B0(drawable2);
        }
        this.g = drawable2;
        this.a = n10 = this.a | 0x40;
        this.h = 0;
        this.a = n10 &= 0xFFFFFF7F;
        return this.G0();
    }

    public a C0(Priority priority) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().C0(priority);
        }
        this.d = priority = (Priority)((Object)d.c.a.u.k.d((Object)priority));
        this.a = n10 = this.a | 8;
        return this.G0();
    }

    public a E() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.c;
        s s10 = new s();
        return this.D0(downsampleStrategy, s10);
    }

    public a F(DecodeFormat decodeFormat) {
        d.c.a.u.k.d((Object)decodeFormat);
        Object object = d.c.a.o.m.d.o.g;
        object = this.H0((e)object, (Object)decodeFormat);
        e e10 = d.c.a.o.m.h.i.a;
        return ((a)object).H0(e10, (Object)decodeFormat);
    }

    public a G(long l10) {
        e e10 = g0.g;
        Long l11 = l10;
        return this.H0(e10, l11);
    }

    public final h H() {
        return this.c;
    }

    public a H0(e e10, Object object) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().H0(e10, object);
        }
        d.c.a.u.k.d(e10);
        d.c.a.u.k.d(object);
        this.q.e(e10, object);
        return this.G0();
    }

    public final int I() {
        return this.f;
    }

    public a I0(d.c.a.o.c c10) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().I0(c10);
        }
        this.l = c10 = (d.c.a.o.c)d.c.a.u.k.d(c10);
        this.a = n10 = this.a | 0x400;
        return this.G0();
    }

    public final Drawable J() {
        return this.e;
    }

    public a J0(float f10) {
        float f11;
        Object object = this.v;
        if (object != 0) {
            return this.m().J0(f10);
        }
        float f12 = 0.0f;
        float f13 = f10 - 0.0f;
        object = f13 == 0.0f ? 0 : (f13 < 0.0f ? -1 : 1);
        if (object >= 0 && (object = (Object)((f11 = f10 - (f12 = 1.0f)) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1))) <= 0) {
            int n10;
            this.b = f10;
            this.a = n10 = this.a | 2;
            return this.G0();
        }
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException("sizeMultiplier must be between 0 and 1");
        throw illegalArgumentException;
    }

    public final Drawable K() {
        return this.o;
    }

    public a K0(boolean bl2) {
        int n10;
        boolean bl3;
        boolean bl4 = this.v;
        boolean bl5 = true;
        if (bl4) {
            return this.m().K0(bl5);
        }
        this.i = bl3 = bl2 ^ bl5;
        this.a = n10 = this.a | 0x100;
        return this.G0();
    }

    public final int L() {
        return this.p;
    }

    public a L0(Resources.Theme theme) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().L0(theme);
        }
        this.u = theme;
        this.a = n10 = this.a | 0x8000;
        return this.G0();
    }

    public final boolean M() {
        return this.x;
    }

    public a M0(int n10) {
        e e10 = d.c.a.o.l.y.b.b;
        Integer n11 = n10;
        return this.H0(e10, n11);
    }

    public final f N() {
        return this.q;
    }

    public a N0(i i10) {
        return this.O0(i10, true);
    }

    public final int O() {
        return this.j;
    }

    public a O0(i i10, boolean bl2) {
        boolean bl3 = this.v;
        if (bl3) {
            return this.m().O0(i10, bl2);
        }
        i i11 = new q(i10, bl2);
        this.R0(Bitmap.class, i10, bl2);
        this.R0(Drawable.class, i11, bl2);
        i11 = i11.c();
        this.R0(BitmapDrawable.class, i11, bl2);
        d.c.a.o.m.h.f f10 = new d.c.a.o.m.h.f(i10);
        this.R0(d.c.a.o.m.h.c.class, f10, bl2);
        return this.G0();
    }

    public final int P() {
        return this.k;
    }

    public final a P0(DownsampleStrategy downsampleStrategy, i i10) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().P0(downsampleStrategy, i10);
        }
        this.v(downsampleStrategy);
        return this.N0(i10);
    }

    public final Drawable Q() {
        return this.g;
    }

    public a Q0(Class clazz, i i10) {
        return this.R0(clazz, i10, true);
    }

    public final int R() {
        return this.h;
    }

    public a R0(Class clazz, i i10, boolean bl2) {
        boolean bl3;
        int n10;
        boolean bl4 = this.v;
        if (bl4) {
            return this.m().R0(clazz, i10, bl2);
        }
        d.c.a.u.k.d(clazz);
        d.c.a.u.k.d(i10);
        this.r.put(clazz, i10);
        this.a = n10 = this.a | 0x800;
        this.n = bl3 = true;
        this.a = n10 |= 0x10000;
        bl4 = false;
        this.y = false;
        if (bl2) {
            int n11 = 131072;
            this.a = n10 |= n11;
            this.m = bl3;
        }
        return this.G0();
    }

    public a S0(i ... object) {
        boolean bl2 = ((i[])object).length;
        boolean bl3 = true;
        if (bl2 > bl3) {
            d d10 = new d((i)object);
            return this.O0(d10, bl3);
        }
        bl2 = ((i[])object).length;
        if (bl2 == bl3) {
            object = object[0];
            return this.N0((i)object);
        }
        return this.G0();
    }

    public final Priority T() {
        return this.d;
    }

    public a T0(i ... iArray) {
        d d10 = new d(iArray);
        return this.O0(d10, true);
    }

    public final Class U() {
        return this.s;
    }

    public a U0(boolean bl2) {
        int n10;
        boolean bl3 = this.v;
        if (bl3) {
            return this.m().U0(bl2);
        }
        this.z = bl2;
        this.a = n10 = this.a | 0x100000;
        return this.G0();
    }

    public final d.c.a.o.c V() {
        return this.l;
    }

    public a V0(boolean bl2) {
        int n10;
        boolean bl3 = this.v;
        if (bl3) {
            return this.m().V0(bl2);
        }
        this.w = bl2;
        this.a = n10 = this.a | 0x40000;
        return this.G0();
    }

    public final float W() {
        return this.b;
    }

    public final Resources.Theme X() {
        return this.u;
    }

    public final Map Y() {
        return this.r;
    }

    public final boolean Z() {
        return this.z;
    }

    public a a(a object) {
        Object object2;
        float f10;
        int n10 = this.v;
        if (n10 != 0) {
            return this.m().a((a)object);
        }
        n10 = ((a)object).a;
        int n11 = 2;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n11) ? 1 : 0)) != 0) {
            this.b = f10 = ((a)object).b;
        }
        n10 = ((a)object).a;
        n11 = 262144;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n11) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).w ? 1 : 0);
            this.w = n10;
        }
        n10 = ((a)object).a;
        n11 = 0x100000;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n11) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).z ? 1 : 0);
            this.z = n10;
        }
        n10 = ((a)object).a;
        n11 = 4;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n11) ? 1 : 0)) != 0) {
            object2 = ((a)object).c;
            this.c = object2;
        }
        n10 = ((a)object).a;
        n11 = 8;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n11) ? 1 : 0)) != 0) {
            object2 = ((a)object).d;
            this.d = object2;
        }
        n10 = (int)(d.c.a.s.a.i0(((a)object).a, 16) ? 1 : 0);
        n11 = 0;
        if (n10 != 0) {
            object2 = ((a)object).e;
            this.e = object2;
            this.f = 0;
            this.a = n10 = this.a & 0xFFFFFFDF;
        }
        n10 = (int)(d.c.a.s.a.i0(((a)object).a, 32) ? 1 : 0);
        int n12 = 0;
        Map map = null;
        if (n10 != 0) {
            this.f = n10 = ((a)object).f;
            this.e = null;
            this.a = n10 = this.a & 0xFFFFFFEF;
        }
        n10 = ((a)object).a;
        int n13 = 64;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            object2 = ((a)object).g;
            this.g = object2;
            this.h = 0;
            this.a = n10 = this.a & 0xFFFFFF7F;
        }
        n10 = ((a)object).a;
        n13 = 128;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            this.h = n10 = ((a)object).h;
            this.g = null;
            this.a = n10 = this.a & 0xFFFFFFBF;
        }
        n10 = ((a)object).a;
        n13 = 256;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).i ? 1 : 0);
            this.i = n10;
        }
        n10 = ((a)object).a;
        n13 = 512;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            this.k = n10 = ((a)object).k;
            this.j = n10 = ((a)object).j;
        }
        n10 = ((a)object).a;
        n13 = 1024;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            object2 = ((a)object).l;
            this.l = object2;
        }
        n10 = ((a)object).a;
        n13 = 4096;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            object2 = ((a)object).s;
            this.s = object2;
        }
        n10 = ((a)object).a;
        n13 = 8192;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            object2 = ((a)object).o;
            this.o = object2;
            this.p = 0;
            this.a = n10 = this.a & 0xFFFFBFFF;
        }
        n10 = ((a)object).a;
        n13 = 16384;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n13) ? 1 : 0)) != 0) {
            this.p = n10 = ((a)object).p;
            this.o = null;
            this.a = n10 = this.a & 0xFFFFDFFF;
        }
        n10 = ((a)object).a;
        n12 = 32768;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n12) ? 1 : 0)) != 0) {
            object2 = ((a)object).u;
            this.u = object2;
        }
        n10 = ((a)object).a;
        n12 = 65536;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n12) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).n ? 1 : 0);
            this.n = n10;
        }
        n10 = ((a)object).a;
        n12 = 131072;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n12) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).m ? 1 : 0);
            this.m = n10;
        }
        n10 = ((a)object).a;
        n12 = 2048;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n12) ? 1 : 0)) != 0) {
            object2 = this.r;
            map = ((a)object).r;
            object2.putAll(map);
            n10 = (int)(((a)object).y ? 1 : 0);
            this.y = n10;
        }
        n10 = ((a)object).a;
        n12 = 524288;
        if ((n10 = (int)(d.c.a.s.a.i0(n10, n12) ? 1 : 0)) != 0) {
            n10 = (int)(((a)object).x ? 1 : 0);
            this.x = n10;
        }
        if ((n10 = (int)(this.n ? 1 : 0)) == 0) {
            object2 = this.r;
            object2.clear();
            this.a = n10 = this.a & 0xFFFFF7FF;
            this.m = false;
            n11 = -131073;
            this.a = n10 &= n11;
            n10 = 1;
            f10 = Float.MIN_VALUE;
            this.y = n10;
        }
        n10 = this.a;
        n11 = ((a)object).a;
        this.a = n10 |= n11;
        object2 = this.q;
        object = ((a)object).q;
        ((f)object2).d((f)object);
        return this.G0();
    }

    public final boolean a0() {
        return this.w;
    }

    public boolean b0() {
        return this.v;
    }

    public final boolean c0() {
        return this.h0(4);
    }

    public final boolean d0() {
        return this.t;
    }

    public final boolean e0() {
        return this.i;
    }

    public boolean equals(Object object) {
        int n10 = object instanceof a;
        boolean bl2 = false;
        if (n10 != 0) {
            boolean bl3;
            Object object2;
            Object object3;
            int n11;
            object = (a)object;
            float f10 = ((a)object).b;
            float f11 = this.b;
            n10 = Float.compare(f10, f11);
            if (n10 == 0 && (n10 = this.f) == (n11 = ((a)object).f) && (n10 = (int)(d.c.a.u.m.d(object3 = this.e, object2 = ((a)object).e) ? 1 : 0)) != 0 && (n10 = this.h) == (n11 = ((a)object).h) && (n10 = (int)(d.c.a.u.m.d(object3 = this.g, object2 = ((a)object).g) ? 1 : 0)) != 0 && (n10 = this.p) == (n11 = ((a)object).p) && (n10 = (int)(d.c.a.u.m.d(object3 = this.o, object2 = ((a)object).o) ? 1 : 0)) != 0 && (n10 = (int)(this.i ? 1 : 0)) == (n11 = (int)(((a)object).i ? 1 : 0)) && (n10 = this.j) == (n11 = ((a)object).j) && (n10 = this.k) == (n11 = ((a)object).k) && (n10 = (int)(this.m ? 1 : 0)) == (n11 = (int)(((a)object).m ? 1 : 0)) && (n10 = (int)(this.n ? 1 : 0)) == (n11 = (int)(((a)object).n ? 1 : 0)) && (n10 = (int)(this.w ? 1 : 0)) == (n11 = (int)(((a)object).w ? 1 : 0)) && (n10 = (int)(this.x ? 1 : 0)) == (n11 = (int)(((a)object).x ? 1 : 0)) && (n10 = (int)((object3 = this.c).equals(object2 = ((a)object).c) ? 1 : 0)) != 0 && (object3 = this.d) == (object2 = ((a)object).d) && (n10 = (int)(((f)(object3 = this.q)).equals(object2 = ((a)object).q) ? 1 : 0)) != 0 && (n10 = (int)((object3 = this.r).equals(object2 = ((a)object).r) ? 1 : 0)) != 0 && (n10 = (int)((object3 = this.s).equals(object2 = ((a)object).s) ? 1 : 0)) != 0 && (n10 = (int)(d.c.a.u.m.d(object3 = this.l, object2 = ((a)object).l) ? 1 : 0)) != 0 && (bl3 = d.c.a.u.m.d(object3 = this.u, object = ((a)object).u))) {
                bl2 = true;
            }
        }
        return bl2;
    }

    public final boolean f0() {
        return this.h0(8);
    }

    public a g() {
        boolean bl2 = this.t;
        if (bl2 && !(bl2 = this.v)) {
            IllegalStateException illegalStateException = new IllegalStateException("You cannot auto lock an already locked options object, try clone() first");
            throw illegalStateException;
        }
        this.v = true;
        return this.o0();
    }

    public boolean g0() {
        return this.y;
    }

    public int hashCode() {
        int n10 = d.c.a.u.m.l(this.b);
        n10 = d.c.a.u.m.o(this.f, n10);
        n10 = d.c.a.u.m.p(this.e, n10);
        n10 = d.c.a.u.m.o(this.h, n10);
        n10 = d.c.a.u.m.p(this.g, n10);
        n10 = d.c.a.u.m.o(this.p, n10);
        n10 = d.c.a.u.m.p(this.o, n10);
        n10 = d.c.a.u.m.r(this.i, n10);
        n10 = d.c.a.u.m.o(this.j, n10);
        n10 = d.c.a.u.m.o(this.k, n10);
        n10 = d.c.a.u.m.r(this.m, n10);
        n10 = d.c.a.u.m.r(this.n, n10);
        n10 = d.c.a.u.m.r(this.w, n10);
        n10 = d.c.a.u.m.r(this.x, n10);
        n10 = d.c.a.u.m.p(this.c, n10);
        n10 = d.c.a.u.m.p((Object)this.d, n10);
        n10 = d.c.a.u.m.p(this.q, n10);
        n10 = d.c.a.u.m.p(this.r, n10);
        n10 = d.c.a.u.m.p(this.s, n10);
        n10 = d.c.a.u.m.p(this.l, n10);
        return d.c.a.u.m.p(this.u, n10);
    }

    public a i() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.e;
        l l10 = new l();
        return this.P0(downsampleStrategy, l10);
    }

    public a j() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.d;
        d.c.a.o.m.d.m m10 = new d.c.a.o.m.d.m();
        return this.D0(downsampleStrategy, m10);
    }

    public final boolean j0() {
        return this.h0(256);
    }

    public final boolean k0() {
        return this.n;
    }

    public a l() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.d;
        n n10 = new n();
        return this.P0(downsampleStrategy, n10);
    }

    public final boolean l0() {
        return this.m;
    }

    public a m() {
        Object object;
        Object object2;
        try {
            object2 = super.clone();
        }
        catch (CloneNotSupportedException cloneNotSupportedException) {
            object = new RuntimeException(cloneNotSupportedException);
            throw object;
        }
        object2 = (a)object2;
        object = new f();
        ((a)object2).q = object;
        Object object3 = this.q;
        ((f)object).d((f)object3);
        object = new b();
        ((a)object2).r = object;
        object3 = this.r;
        object.putAll(object3);
        object = null;
        ((a)object2).t = false;
        ((a)object2).v = false;
        return object2;
    }

    public final boolean m0() {
        return this.h0(2048);
    }

    public final boolean n0() {
        int n10 = this.k;
        int n11 = this.j;
        return d.c.a.u.m.v(n10, n11);
    }

    public a o0() {
        this.t = true;
        return this.F0();
    }

    public a p(Class clazz) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().p(clazz);
        }
        this.s = clazz = (Class)d.c.a.u.k.d(clazz);
        this.a = n10 = this.a | 0x1000;
        return this.G0();
    }

    public a p0(boolean bl2) {
        int n10;
        boolean bl3 = this.v;
        if (bl3) {
            return this.m().p0(bl2);
        }
        this.x = bl2;
        this.a = n10 = this.a | 0x80000;
        return this.G0();
    }

    public a q0() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.e;
        l l10 = new l();
        return this.w0(downsampleStrategy, l10);
    }

    public a r() {
        e e10 = d.c.a.o.m.d.o.k;
        Boolean bl2 = Boolean.FALSE;
        return this.H0(e10, bl2);
    }

    public a r0() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.d;
        d.c.a.o.m.d.m m10 = new d.c.a.o.m.d.m();
        return this.u0(downsampleStrategy, m10);
    }

    public a s(h h10) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().s(h10);
        }
        this.c = h10 = (h)d.c.a.u.k.d(h10);
        this.a = n10 = this.a | 4;
        return this.G0();
    }

    public a s0() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.e;
        n n10 = new n();
        return this.w0(downsampleStrategy, n10);
    }

    public a t() {
        e e10 = d.c.a.o.m.h.i.b;
        Boolean bl2 = Boolean.TRUE;
        return this.H0(e10, bl2);
    }

    public a t0() {
        DownsampleStrategy downsampleStrategy = DownsampleStrategy.c;
        s s10 = new s();
        return this.u0(downsampleStrategy, s10);
    }

    public a u() {
        int n10 = this.v;
        if (n10 != 0) {
            return this.m().u();
        }
        this.r.clear();
        this.a = n10 = this.a & 0xFFFFF7FF;
        this.m = false;
        this.a = n10 &= 0xFFFDFFFF;
        this.n = false;
        this.a = n10 |= 0x10000;
        this.y = true;
        return this.G0();
    }

    public a v(DownsampleStrategy object) {
        e e10 = DownsampleStrategy.h;
        object = d.c.a.u.k.d(object);
        return this.H0(e10, object);
    }

    public a v0(i i10) {
        return this.O0(i10, false);
    }

    public a w(Bitmap.CompressFormat object) {
        e e10 = d.c.a.o.m.d.e.c;
        object = d.c.a.u.k.d(object);
        return this.H0(e10, object);
    }

    public final a w0(DownsampleStrategy downsampleStrategy, i i10) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().w0(downsampleStrategy, i10);
        }
        this.v(downsampleStrategy);
        return this.O0(i10, false);
    }

    public a x(int n10) {
        e e10 = d.c.a.o.m.d.e.b;
        Integer n11 = n10;
        return this.H0(e10, n11);
    }

    public a x0(Class clazz, i i10) {
        return this.R0(clazz, i10, false);
    }

    public a y(int n10) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().y(n10);
        }
        this.f = n10;
        this.a = n10 = this.a | 0x20;
        this.e = null;
        this.a = n10 &= 0xFFFFFFEF;
        return this.G0();
    }

    public a y0(int n10) {
        return this.z0(n10, n10);
    }

    public a z(Drawable drawable2) {
        int n10;
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().z(drawable2);
        }
        this.e = drawable2;
        this.a = n10 = this.a | 0x10;
        this.f = 0;
        this.a = n10 &= 0xFFFFFFDF;
        return this.G0();
    }

    public a z0(int n10, int n11) {
        boolean bl2 = this.v;
        if (bl2) {
            return this.m().z0(n10, n11);
        }
        this.k = n10;
        this.j = n11;
        this.a = n10 = this.a | 0x200;
        return this.G0();
    }
}

