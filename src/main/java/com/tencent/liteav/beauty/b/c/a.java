/*
 * Decompiled with CFR 0.151.
 */
package com.tencent.liteav.beauty.b.c;

import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.c.b;
import com.tencent.liteav.beauty.b.c.c;
import com.tencent.liteav.beauty.b.c.d;
import com.tencent.liteav.beauty.b.t;

public class a
extends com.tencent.liteav.beauty.b.b {
    private d r = null;
    private d s = null;
    private b t = null;
    private c u = null;
    private d v = null;
    private d w = null;
    private float x;
    private float y;
    private float z;

    public a() {
        float f10;
        this.x = f10 = 0.2f;
        this.y = f10;
        this.z = f10;
    }

    private boolean d(int n10, int n11) {
        boolean bl2;
        i i10 = this.r;
        String string2 = "TXCBeauty4Filter";
        boolean bl3 = true;
        if (i10 == null) {
            i10 = new d(bl3);
            this.r = i10;
            i10.a(bl3);
            i10 = this.r;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mSkinBlurFilterVertical init failed!!, break init");
                return false;
            }
        }
        if ((i10 = this.s) == null) {
            i10 = new d(false);
            this.s = i10;
            i10.a(bl3);
            i10 = this.s;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mSkinBlurFilterHorizontal init failed!!, break init");
                return false;
            }
        }
        if ((i10 = this.t) == null) {
            i10 = new b();
            this.t = i10;
            i10.a(bl3);
            i10 = this.t;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mBorderFilter init failed!!, break init");
                return false;
            }
        }
        if ((i10 = this.v) == null) {
            i10 = new d(bl3);
            this.v = i10;
            i10.a(bl3);
            i10 = this.v;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mBorderBlurFilterVertical init failed!!, break init");
                return false;
            }
        }
        if ((i10 = this.w) == null) {
            i10 = new d(false);
            this.w = i10;
            i10.a(bl3);
            i10 = this.w;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mBorderBlurFilterHorizontal init failed!!, break init");
                return false;
            }
        }
        if ((i10 = this.u) == null) {
            i10 = new c();
            this.u = i10;
            i10.a(bl3);
            i10 = this.u;
            bl2 = i10.a();
            if (!bl2) {
                TXCLog.e(string2, "mSmoothFilter init failed!!, break init");
                return false;
            }
        }
        this.u.a(360.0f, 640.0f);
        i10 = this.u;
        float f10 = this.x;
        ((c)i10).a(f10);
        i10 = this.u;
        f10 = this.y;
        ((c)i10).b(f10);
        i10 = this.u;
        f10 = this.z;
        ((c)i10).c(f10);
        this.a(n10, n11);
        return bl3;
    }

    public void a(int n10, int n11) {
        super.a(n10, n11);
        this.e = n10;
        this.f = n11;
        this.r.a(n10, n11);
        this.s.a(n10, n11);
        this.t.a(n10, n11);
        this.v.a(n10, n11);
        this.w.a(n10, n11);
        this.u.a(n10, n11);
    }

    public int b(int n10) {
        float f10;
        float f11;
        float f12 = this.x;
        int n11 = 0;
        b b10 = null;
        float f13 = f12 - 0.0f;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object > 0 || (object = (f11 = (f12 = this.y) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0 || (object = (f10 = (f12 = this.z) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            d d10 = this.r;
            object = d10.b(n10);
            object = this.s.b((int)object);
            b10 = this.t;
            n11 = b10.c(n10, (int)object);
            n11 = this.v.b(n11);
            n11 = this.w.b(n11);
            c c10 = this.u;
            n10 = c10.a(n10, (int)object, n11);
        }
        return n10;
    }

    public void c(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.x = f10 /= f11;
        c c10 = this.u;
        if (c10 != null) {
            c10.a(f10);
        }
    }

    public boolean c(int n10, int n11) {
        this.e = n10;
        this.f = n11;
        return this.d(n10, n11);
    }

    public void d(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.y = f10 /= f11;
        c c10 = this.u;
        if (c10 != null) {
            c10.b(f10);
        }
    }

    public void e() {
        super.e();
        this.r();
    }

    public void e(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.z = f10 /= f11;
        c c10 = this.u;
        if (c10 != null) {
            c10.c(f10);
        }
    }

    public void f(int n10) {
        c c10 = this.u;
        float f10 = (float)n10 / 10.0f;
        c10.d(f10);
    }

    public void r() {
        i i10 = this.r;
        if (i10 != null) {
            i10.e();
            this.r = null;
        }
        if ((i10 = this.s) != null) {
            i10.e();
            this.s = null;
        }
        if ((i10 = this.t) != null) {
            ((t)i10).e();
            this.t = null;
        }
        if ((i10 = this.u) != null) {
            i10.e();
            this.u = null;
        }
        if ((i10 = this.v) != null) {
            i10.e();
            this.v = null;
        }
        if ((i10 = this.w) != null) {
            i10.e();
            this.w = null;
        }
    }
}

