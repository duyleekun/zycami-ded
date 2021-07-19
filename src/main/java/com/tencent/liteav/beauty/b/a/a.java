/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.opengl.GLES20
 */
package com.tencent.liteav.beauty.b.a;

import android.opengl.GLES20;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.a.b;
import com.tencent.liteav.beauty.b.a.c;
import com.tencent.liteav.beauty.b.a.d;
import com.tencent.liteav.beauty.b.a.e;
import com.tencent.liteav.beauty.b.h;
import com.tencent.liteav.beauty.b.q;

public class a
extends com.tencent.liteav.beauty.b.b {
    private int A = 0;
    private float B = 1.0f;
    private final float C;
    private float D = 0.8f;
    private float E = 2.0f;
    private int F = 0;
    private int G = 0;
    private int H = 0;
    private int I = 0;
    private c r = null;
    private d s = null;
    private e t = null;
    private h u = null;
    private q v = null;
    private b w = null;
    private String x = "TXCBeauty2Filter";
    private int y = 0;
    private int z = 0;

    public a() {
        this.C = 0.7f;
    }

    /*
     * WARNING - void declaration
     */
    private boolean d(int n10, int n11) {
        float f10;
        this.F = n10;
        this.G = n11;
        this.H = n10;
        this.I = n11;
        float f11 = this.E;
        int n12 = 1065353216;
        float f12 = 1.0f;
        float f13 = f12 - f11;
        Object object = f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1);
        if (object != false) {
            int bl2;
            object = (int)((float)n10 / f11);
            this.H = (int)object;
            f10 = (float)n11 / f11;
            this.I = bl2 = (int)f10;
        }
        Object object2 = this.x;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("mResampleRatio ");
        float f14 = this.E;
        charSequence.append(f14);
        charSequence.append(" mResampleWidth ");
        int n13 = this.H;
        charSequence.append(n13);
        String string2 = " mResampleHeight ";
        charSequence.append(string2);
        int n14 = this.I;
        charSequence.append(n14);
        charSequence = charSequence.toString();
        TXCLog.i((String)object2, (String)charSequence);
        object2 = this.w;
        object = false;
        f10 = 0.0f;
        charSequence = null;
        boolean bl2 = true;
        f14 = Float.MIN_VALUE;
        if (object2 == null) {
            this.w = object2 = new b();
            ((i)object2).a(bl2);
            object2 = this.w;
            boolean bl3 = ((b)object2).a();
            if (!bl3) {
                TXCLog.e(this.x, "mBeautyBlendFilter init failed!!, break init");
                return false;
            }
        }
        this.w.a(n10, n11);
        object2 = this.s;
        if (object2 == null) {
            this.s = object2 = new d();
            ((i)object2).a(bl2);
            object2 = this.s;
            boolean bl4 = ((d)object2).a();
            if (!bl4) {
                TXCLog.e(this.x, "m_horizontalFilter init failed!!, break init");
                return false;
            }
        }
        object2 = this.s;
        int n15 = this.H;
        int n16 = this.I;
        ((d)object2).a(n15, n16);
        object2 = this.t;
        if (object2 == null) {
            void var8_14;
            this.t = object2 = new e();
            ((i)object2).a(bl2);
            f11 = this.E;
            float f15 = f12 == f11 ? 0 : (f12 > f11 ? 1 : -1);
            if (f15 == false) {
                boolean bl5 = false;
                object2 = null;
                f11 = 0.0f;
            } else {
                boolean bl6 = bl2;
                f11 = f14;
            }
            e e10 = this.t;
            e10.b((boolean)var8_14);
            object2 = this.t;
            boolean bl7 = ((e)object2).a();
            if (!bl7) {
                TXCLog.e(this.x, "m_verticalFilter init failed!!, break init");
                return false;
            }
        }
        object2 = this.t;
        n15 = this.H;
        n16 = this.I;
        ((e)object2).a(n15, n16);
        object2 = this.u;
        if (object2 == null) {
            this.u = object2 = new h(f12);
            ((i)object2).a(bl2);
            object2 = this.u;
            boolean bl8 = ((i)object2).a();
            if (!bl8) {
                TXCLog.e(this.x, "m_gammaFilter init failed!!, break init");
                return false;
            }
        }
        object2 = this.u;
        n12 = this.H;
        n15 = this.I;
        ((i)object2).a(n12, n15);
        object2 = this.v;
        if (object2 == null) {
            this.v = object2 = new q();
            ((i)object2).a(bl2);
            object2 = this.v;
            boolean bl9 = ((i)object2).a();
            if (!bl9) {
                TXCLog.e(this.x, "mSharpenFilter init failed!!, break init");
                return false;
            }
        }
        this.v.a(n10, n11);
        return bl2;
    }

    private void g(int n10) {
        float f10;
        float f11 = (float)n10 / 50.0f;
        this.B = f10 = 1.0f - f11;
        h h10 = this.u;
        if (h10 != null) {
            h10.a(f10);
        }
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
        int n11;
        float f11 = this.E;
        int n12 = 1065353216;
        float f12 = 1.0f;
        float f13 = f12 == f11 ? 0 : (f12 > f11 ? 1 : -1);
        float f14 = 0.0f;
        if (f13 != false) {
            f13 = this.H;
            n11 = this.I;
            GLES20.glViewport((int)0, (int)0, (int)f13, (int)n11);
        }
        d d10 = this.s;
        f13 = d10.b(n10);
        e e10 = this.t;
        f13 = e10.c((int)f13, n10);
        float f15 = this.E;
        float f16 = f12 - f15;
        n12 = (int)(f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1));
        if (n12 != 0) {
            n12 = this.F;
            n11 = this.G;
            GLES20.glViewport((int)0, (int)0, (int)n12, (int)n11);
        }
        if ((n12 = (int)((f10 = (f12 = this.D) - (f14 = 0.7f)) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1))) > 0) {
            q q10 = this.v;
            f13 = q10.b((int)f13);
        }
        return this.w.c((int)f13, n10);
    }

    public void c(int n10) {
        e e10 = this.t;
        if (e10 != null) {
            float f10 = n10;
            float f11 = 10.0f;
            e10.a(f10 /= f11);
        }
        this.y = n10;
        this.g(n10);
    }

    public boolean c(int n10, int n11) {
        return this.d(n10, n11);
    }

    public void d(int n10) {
        b b10 = this.w;
        if (b10 != null) {
            float f10 = n10;
            float f11 = 10.0f;
            b10.a(f10 /= f11);
        }
        this.z = n10;
    }

    public void e() {
        super.e();
        this.r();
    }

    public void e(int n10) {
        b b10 = this.w;
        if (b10 != null) {
            float f10 = n10;
            float f11 = 10.0f;
            b10.b(f10 /= f11);
        }
        this.A = n10;
    }

    public void f(int n10) {
        double d10;
        float f10 = (float)n10 / 12.0f + 0.7f;
        float f11 = Math.abs(this.D - f10);
        double d11 = f11;
        double d12 = d11 - (d10 = 0.001);
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            return;
        }
        this.D = f10;
        String string2 = this.x;
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "set mSharpenLevel ";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        Object object2 = stringBuilder.toString();
        TXCLog.i(string2, (String)object2);
        object2 = this.v;
        if (object2 != null) {
            f10 = this.D;
            ((q)object2).a(f10);
        }
    }

    public void r() {
        i i10 = this.w;
        if (i10 != null) {
            i10.d();
            this.w = null;
        }
        if ((i10 = this.s) != null) {
            i10.d();
            this.s = null;
        }
        if ((i10 = this.t) != null) {
            i10.d();
            this.t = null;
        }
        if ((i10 = this.u) != null) {
            i10.d();
            this.u = null;
        }
        if ((i10 = this.v) != null) {
            i10.d();
            this.v = null;
        }
    }
}

