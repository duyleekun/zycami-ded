/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.util.Log
 */
package com.tencent.liteav.beauty.b;

import android.util.Log;
import com.tencent.liteav.basic.opengl.i;
import com.tencent.liteav.beauty.b.b;
import com.tencent.liteav.beauty.b.c$a;
import com.tencent.liteav.beauty.b.f;
import com.tencent.liteav.beauty.b.r;

public class c
extends b {
    private static final String r = "c";
    private float A;
    private f s;
    private c$a t;
    private r u = null;
    private int v;
    private int w;
    private float x;
    private float y;
    private float z;

    public c() {
        int n10;
        this.v = n10 = -1;
        this.w = n10;
        this.x = 0.0f;
        this.y = 0.0f;
        this.z = 0.0f;
        this.A = 0.0f;
    }

    public static /* synthetic */ float a(float f10) {
        return com.tencent.liteav.beauty.b.c.b(f10);
    }

    private static float a(float f10, float f11, float f12) {
        f12 = (f12 - f11) * f10;
        return f11 + f12;
    }

    private static float b(float f10) {
        int n10 = 1065353216;
        float f11 = 1.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object > 0) {
            double d10 = f10;
            double d11 = 2.5;
            double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
            float f13 = 4.1f;
            float f14 = 1.5f;
            if (d12 < 0) {
                f10 = com.tencent.liteav.beauty.b.c.a((f10 - f11) / f14, f11, f13);
            } else {
                n10 = 0x40800000;
                f11 = 4.0f;
                d12 = (double)(f10 == f11 ? 0 : (f10 < f11 ? -1 : 1));
                float f15 = 5.6f;
                if (d12 < 0) {
                    n10 = 0x40200000;
                    f11 = 2.5f;
                    f10 = com.tencent.liteav.beauty.b.c.a((f10 - f11) / f14, f13, f15);
                } else {
                    d11 = 5.5;
                    d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
                    f13 = 6.8f;
                    if (d12 < 0) {
                        f10 = com.tencent.liteav.beauty.b.c.a((f10 - f11) / f14, f15, f13);
                    } else {
                        double d13 = 7.0;
                        double d14 = d10 - d13;
                        n10 = (int)(d14 == 0.0 ? 0 : (d14 < 0.0 ? -1 : 1));
                        if (n10 <= 0) {
                            f10 = (f10 - 5.5f) / f14;
                            n10 = 0x40E00000;
                            f11 = 7.0f;
                            f10 = com.tencent.liteav.beauty.b.c.a(f10, f13, f11);
                        }
                    }
                }
            }
            return f10 / 10.0f;
        }
        return 0.1f;
    }

    public void a(int n10, int n11) {
        int n12 = this.v;
        if (n12 == n10 && (n12 = this.w) == n11) {
            return;
        }
        String string2 = r;
        CharSequence charSequence = new StringBuilder();
        charSequence.append("onOutputSizeChanged mFrameWidth = ");
        charSequence.append(n10);
        charSequence.append("  mFrameHeight = ");
        charSequence.append(n11);
        charSequence = charSequence.toString();
        Log.i((String)string2, (String)charSequence);
        this.v = n10;
        this.w = n11;
        this.c(n10, n11);
    }

    public int b(int n10) {
        float f10;
        i i10;
        Object object;
        float f11;
        float f12;
        float f13;
        float f14 = this.x;
        float f15 = f14 - 0.0f;
        Object object2 = f15 == 0.0f ? 0 : (f15 > 0.0f ? 1 : -1);
        if (object2 > 0 || (object2 = (f13 = (f12 = this.y) - 0.0f) == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1)) > 0 || (object2 = (f11 = (f12 = this.z) - 0.0f) == 0.0f ? 0 : (f11 > 0.0f ? 1 : -1)) > 0) {
            float f16 = f14 - 0.0f;
            object = f16 == 0.0f ? 0 : (f16 > 0.0f ? 1 : -1);
            if (object != false) {
                i10 = this.s;
                object = ((f)i10).b(n10);
            } else {
                object = n10;
            }
            c$a c$a = this.t;
            n10 = c$a.a((int)object, n10, n10);
        }
        if ((object = (f10 = (f14 = this.A) - 0.0f) == 0.0f ? 0 : (f10 > 0.0f ? 1 : -1)) > 0) {
            i10 = this.u;
            n10 = i10.b(n10);
        }
        return n10;
    }

    public void c(int n10) {
        float f10;
        this.x = f10 = (float)n10;
        c$a c$a = this.t;
        if (c$a != null) {
            c$a.a(f10);
        }
    }

    public boolean c(int n10, int n11) {
        this.v = n10;
        this.w = n11;
        String string2 = r;
        StringBuilder stringBuilder = new StringBuilder();
        String string3 = "init mFrameWidth = ";
        stringBuilder.append(string3);
        stringBuilder.append(n10);
        stringBuilder.append("  mFrameHeight = ");
        stringBuilder.append(n11);
        Object object = stringBuilder.toString();
        Log.i((String)string2, (String)object);
        object = this.s;
        n11 = 0;
        boolean bl2 = true;
        if (object == null) {
            this.s = object = new f();
            ((i)object).a(bl2);
            object = this.s;
            n10 = (int)(((i)object).a() ? 1 : 0);
            if (n10 == 0) {
                Log.e((String)string2, (String)"mNewFaceFilter init Failed");
                return false;
            }
        }
        object = this.s;
        int n12 = this.v;
        int n13 = this.w;
        ((f)object).a(n12, n13);
        object = this.t;
        if (object == null) {
            this.t = object = new c$a();
            ((i)object).a(bl2);
            object = this.t;
            n10 = (int)(((c$a)object).a() ? 1 : 0);
            if (n10 == 0) {
                Log.e((String)string2, (String)"mBeautyCoreFilter init Failed");
                return false;
            }
        }
        object = this.t;
        n12 = this.v;
        n13 = this.w;
        ((c$a)object).a(n12, n13);
        object = this.u;
        if (object == null) {
            this.u = object = new r();
            ((i)object).a(bl2);
            object = this.u;
            n10 = (int)(((i)object).a() ? 1 : 0);
            if (n10 == 0) {
                Log.e((String)string2, (String)"mSharpenessFilter init Failed");
                return false;
            }
        }
        object = this.u;
        n11 = this.v;
        int n14 = this.w;
        ((r)object).a(n11, n14);
        return bl2;
    }

    public void d(int n10) {
        float f10;
        this.y = f10 = (float)n10;
        c$a c$a = this.t;
        if (c$a != null) {
            c$a.b(f10);
        }
    }

    public void e() {
        i i10 = this.t;
        if (i10 != null) {
            i10.d();
            this.t = null;
        }
        if ((i10 = this.s) != null) {
            i10.d();
            this.s = null;
        }
        if ((i10 = this.u) != null) {
            i10.d();
            this.u = null;
        }
    }

    public void e(int n10) {
        float f10;
        this.z = f10 = (float)n10;
        c$a c$a = this.t;
        if (c$a != null) {
            c$a.c(f10);
        }
    }

    public void f(int n10) {
        double d10;
        float f10 = (float)n10 / 15.0f;
        float f11 = Math.abs(this.A - f10);
        double d11 = f11;
        double d12 = d11 - (d10 = 0.001);
        Object object = d12 == 0.0 ? 0 : (d12 < 0.0 ? -1 : 1);
        if (object < 0) {
            return;
        }
        this.A = f10;
        r r10 = this.u;
        if (r10 != null) {
            r10.a(f10);
        }
    }
}

