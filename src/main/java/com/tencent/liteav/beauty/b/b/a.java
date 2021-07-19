/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.beauty.b.b;

import android.util.Log;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.b.b;
import com.tencent.liteav.beauty.b.r;

public class a
extends com.tencent.liteav.beauty.b.b {
    private b r = null;
    private r s = null;
    private String t = "TXCBeauty3Filter";
    private float u = 0.0f;
    private float v = 0.0f;
    private float w = 0.0f;
    private float x = 0.0f;

    private boolean d(int n10, int n11) {
        boolean bl2;
        i i10 = this.r;
        boolean bl3 = true;
        if (i10 == null) {
            i10 = new b();
            this.r = i10;
            i10.a(bl3);
            i10 = this.r;
            bl2 = ((b)i10).a();
            if (!bl2) {
                Log.e((String)this.t, (String)"m_verticalFilter init failed!!, break init");
                return false;
            }
        }
        this.r.a(n10, n11);
        i10 = this.s;
        if (i10 == null) {
            i10 = new r();
            this.s = i10;
            i10.a(bl3);
            i10 = this.s;
            bl2 = i10.a();
            if (!bl2) {
                Log.e((String)this.t, (String)"mSharpnessFilter init failed!!, break init");
                return false;
            }
        }
        this.s.a(n10, n11);
        return bl3;
    }

    public void a(int n10, int n11) {
        int n12 = this.e;
        if (n12 == n10 && (n12 = this.f) == n11) {
            return;
        }
        this.e = n10;
        this.f = n11;
        this.d(n10, n11);
    }

    public int b(int n10) {
        float f10;
        i i10;
        float f11;
        float f12;
        float f13 = this.u;
        float f14 = f13 - 0.0f;
        Object object = f14 == 0.0f ? 0 : (f14 > 0.0f ? 1 : -1);
        if (object > 0 || (object = (f12 = (f13 = this.v) - 0.0f) == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1)) > 0 || (object = (f11 = (f13 = this.w) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0) {
            i10 = this.r;
            n10 = i10.b(n10);
        }
        if ((object = (f10 = (f13 = this.x) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            i10 = this.s;
            n10 = i10.b(n10);
        }
        return n10;
    }

    public void c(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.u = f10 /= f11;
        b b10 = this.r;
        if (b10 != null) {
            b10.a(f10);
        }
    }

    public boolean c(int n10, int n11) {
        return this.d(n10, n11);
    }

    public void d(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.v = f10 /= f11;
        b b10 = this.r;
        if (b10 != null) {
            b10.b(f10);
        }
    }

    public void e() {
        super.e();
        this.r();
    }

    public void e(int n10) {
        float f10 = n10;
        float f11 = 10.0f;
        this.w = f10 /= f11;
        b b10 = this.r;
        if (b10 != null) {
            b10.c(f10);
        }
    }

    public void f(int n10) {
        double d10;
        float f10 = (float)n10 / 20.0f;
        float f11 = Math.abs(this.x - f10);
        double d11 = f11;
        double d12 = d11 - (d10 = 0.001);
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            return;
        }
        this.x = f10;
        r r10 = this.s;
        if (r10 != null) {
            r10.a(f10);
        }
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
    }
}

