/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.graphics.Bitmap
 *  android.text.TextUtils
 *  android.util.Size
 */
package d.v.c.b2.w;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Size;
import d.v.c.b2.w.c;
import d.v.c.b2.w.h;
import d.v.c.b2.w.l.a;
import d.v.c.b2.w.l.b;
import d.v.c.m0$a;
import d.v.h.e.d;
import java.util.ArrayList;
import java.util.List;

public class j
extends c
implements b {
    public static final int s = m0$a.a;
    public static final int t = m0$a.b;
    public static final int u = m0$a.c;
    private long e;
    private String f;
    private List g;
    private double h;
    private String i;
    private boolean j;
    private double k;
    private long l;
    private long m;
    private boolean n;
    private a o;
    private float p;
    private int q;
    private double r;

    public j(d arrayList) {
        super((d.v.h.b)((Object)arrayList));
        int n10;
        this.g = arrayList = new ArrayList();
        this.h = 1.0;
        this.p = 1.0f;
        this.q = n10 = t;
    }

    private void M(float f10) {
        block4: {
            String string2;
            Object object;
            Object object2;
            block3: {
                long l10;
                long l11;
                double d10;
                float f11 = 0.0f;
                object2 = null;
                float f12 = f10 - 0.0f;
                object = f12 == 0.0f ? 0 : (f12 < 0.0f ? -1 : 1);
                if (object <= 0) {
                    return;
                }
                object2 = this.g;
                object = d.v.j.b.f((List)object2);
                int n10 = 0;
                string2 = null;
                if (object == false) break block3;
                object2 = new ArrayList();
                this.g = object2;
                long l12 = 0L;
                double d11 = 0.0;
                object = s;
                f11 = (float)object / f10;
                int n11 = 0x40800000;
                f10 = 4.0f;
                this.r = d10 = (double)(f11 /= f10);
                while ((n11 = (int)((l11 = l12 - (l10 = this.e)) == 0L ? 0 : (l11 < 0L ? -1 : 1))) <= 0) {
                    d11 = n10;
                    d10 = this.r;
                    l12 = Math.round(d11 *= d10);
                    object2 = this.f;
                    int n12 = this.q;
                    h h10 = new h(l12, (String)object2, n12);
                    object2 = this.g;
                    object2.add(h10);
                    ++n10;
                }
                break block4;
            }
            Object object3 = this.f;
            object2 = ((h)this.g.get(0)).l();
            boolean bl2 = ((String)object3).equals(object2);
            if (bl2) break block4;
            object3 = this.g.iterator();
            while ((object = (Object)object3.hasNext()) != false) {
                object2 = (h)object3.next();
                string2 = this.f;
                ((h)object2).m(string2);
            }
        }
    }

    public boolean A() {
        return this.j;
    }

    public void B(float f10) {
        int n10;
        this.p = f10;
        this.q = n10 = t;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object < 0) {
            int n11;
            float f13 = (float)n10 / f10;
            this.q = n11 = (int)f13;
        }
    }

    public void C(boolean bl2) {
        this.n = bl2;
    }

    public void D(long l10) {
        this.m = l10;
    }

    public void E(boolean bl2) {
        this.j = bl2;
    }

    public void F(long l10) {
        this.l = l10;
    }

    public void G(String string2) {
        this.i = string2;
    }

    public void H(long l10) {
        this.e = l10;
    }

    public void I(double d10) {
        this.h = d10;
    }

    public void J(double d10) {
        this.k = d10;
    }

    public void K(String object) {
        boolean bl2 = TextUtils.isEmpty((CharSequence)object);
        Size size = null;
        if (bl2) {
            object = this.o;
            if (object != null) {
                ((a)object).b();
                this.o = null;
            }
        } else {
            Object object2 = this.o;
            if (object2 != null) {
                bl2 = ((String)object).equals(object2 = ((a)object2).u());
                if (bl2) {
                    return;
                }
                object2 = this.o;
                ((a)object2).b();
                this.o = null;
            }
            int n10 = u;
            size = new Size(n10, n10);
            this.o = object2 = new a(object, size);
        }
    }

    public void L(String string2) {
        this.f = string2;
    }

    public void N(float f10) {
        this.M(f10);
    }

    public void b() {
        d.v.c.b2.w.l.b.k(this.g);
        this.g.clear();
        this.g = null;
        d.v.c.b2.w.l.b.c(this.o);
        this.o = null;
    }

    public boolean f() {
        Object object = this.g;
        boolean bl2 = d.v.c.b2.w.l.b.d((List)object);
        if (bl2 && (bl2 = d.v.c.b2.w.l.b.e((b)(object = this.o)))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public float n() {
        return this.p;
    }

    public long o() {
        return this.m;
    }

    public long p() {
        return this.l;
    }

    public String q() {
        return this.i;
    }

    public double r() {
        return this.r;
    }

    public double s() {
        return this.h;
    }

    public double t() {
        return this.k;
    }

    public List u() {
        return this.g;
    }

    public Bitmap v(Context object, d.v.c.b2.x.d d10) {
        a a10 = this.o;
        object = a10 == null ? null : a10.t((Context)object, d10);
        return object;
    }

    public String w() {
        return ((d)this.d).i();
    }

    public long x() {
        double d10 = this.e;
        double d11 = this.h;
        return (long)(d10 / d11);
    }

    public boolean y() {
        long l10;
        long l11;
        long l12;
        int n10;
        Object object = this.d;
        if (object != null && (object = ((d)object).N()) != null && (n10 = (l12 = (l11 = ((d.v.h.k.b)(object = ((d)this.d).N())).a()) - (l10 = 0L)) == 0L ? 0 : (l12 < 0L ? -1 : 1)) > 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean z() {
        boolean bl2 = this.n;
        bl2 = bl2 || (bl2 = this.y());
        return bl2;
    }
}

