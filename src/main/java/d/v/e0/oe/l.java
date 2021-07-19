/*
 * Decompiled with CFR 0.151.
 */
package d.v.e0.oe;

import com.zhiyun.stabilizer.Stabilizer;
import d.v.e0.oe.a;
import d.v.e0.oe.b;
import d.v.e0.oe.c;
import d.v.e0.oe.d;
import d.v.e0.oe.e;
import d.v.e0.oe.f;
import d.v.e0.oe.g;
import d.v.e0.oe.h;
import d.v.e0.oe.i;
import e.a.e0;
import e.a.v0.o;
import e.a.v0.r;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class l {
    private static final float g = 0.01f;
    private static final float h = 0.2f;
    private static final float i = 0.6f;
    private static final int j = 65535;
    private static final int k = 10;
    private static final int l = 1;
    private float a;
    private float b;
    private float c;
    private int d;
    private Stabilizer e;
    private e.a.s0.b f;

    private l(Stabilizer stabilizer) {
        this.e = stabilizer;
    }

    private float a() {
        return this.p() * 0.049999997f;
    }

    public static l b(Stabilizer stabilizer) {
        l l10 = new l(stabilizer);
        return l10;
    }

    private void c() {
        float f10 = this.d;
        float f11 = 20.0f;
        float f12 = f10 - f11;
        Object object = f12 == 0.0f ? 0 : (f12 > 0.0f ? 1 : -1);
        if (object >= 0) {
            object = false;
            f10 = 0.0f;
            this.d = 0;
        }
    }

    public static /* synthetic */ void d(Boolean bl2) {
    }

    private /* synthetic */ void e(Integer n10) {
        float f10;
        this.a = f10 = (float)n10.intValue();
    }

    public static /* synthetic */ Long g(Integer n10) {
        return 10;
    }

    public static /* synthetic */ e0 h(Long object) {
        long l10 = object;
        object = TimeUnit.MILLISECONDS;
        return z.n3(l10, (TimeUnit)((Object)object));
    }

    private /* synthetic */ Integer i(Long l10) {
        return this.q();
    }

    private /* synthetic */ boolean k(Integer n10) {
        int n11 = this.d;
        n11 = n11 == 0 ? 1 : 0;
        return n11 != 0;
    }

    private /* synthetic */ z m(boolean bl2, Integer n10) {
        Stabilizer stabilizer = this.e;
        return this.r(n10, bl2, stabilizer);
    }

    public static /* synthetic */ void o(z z10) {
        h h10 = d.v.e0.oe.h.a;
        i i10 = d.v.e0.oe.i.a;
        z10.c(h10, i10);
    }

    private float p() {
        return 13107.0f;
    }

    private int q() {
        int n10;
        this.d = n10 = this.d + 1;
        float f10 = this.a();
        float f11 = this.b;
        f10 *= f11;
        f11 = this.c * 0.6f + 0.1f;
        f10 *= f11;
        f11 = Math.abs(f10);
        double d10 = f11;
        double d11 = 1.0;
        double d12 = d10 == d11 ? 0 : (d10 < d11 ? -1 : 1);
        int n11 = -1;
        if (d12 < 0) {
            this.c();
            return n11;
        }
        float f12 = Math.abs(f10);
        f11 = 655.35f / f12;
        float f13 = f11 - (f12 = 10.0f);
        d12 = (double)(f13 == 0.0f ? 0 : (f13 > 0.0f ? 1 : -1));
        if (d12 > 0) {
            this.c();
            return n11;
        }
        this.a = f11 = this.a + f10;
        n10 = 1199570688;
        f10 = 65535.0f;
        n11 = (int)(f11 == f10 ? 0 : (f11 > f10 ? 1 : -1));
        f12 = 0.0f;
        if (n11 >= 0) {
            this.a = 0.0f;
        } else {
            float f14 = f11 - 0.0f;
            n11 = (int)(f14 == 0.0f ? 0 : (f14 < 0.0f ? -1 : 1));
            if (n11 < 0) {
                this.a = f11 += f10;
            }
        }
        n10 = (int)this.a;
        this.c();
        return n10;
    }

    private z r(Integer object, boolean bl2, Stabilizer stabilizer) {
        int n10 = (Integer)object;
        object = bl2 ? stabilizer.w1(n10) : stabilizer.G0(n10);
        return object;
    }

    public /* synthetic */ void f(Integer n10) {
        this.e(n10);
    }

    public /* synthetic */ Integer j(Long l10) {
        return this.i(l10);
    }

    public /* synthetic */ boolean l(Integer n10) {
        return this.k(n10);
    }

    public /* synthetic */ z n(boolean bl2, Integer n10) {
        return this.m(bl2, n10);
    }

    public void s(boolean bl2) {
        this.a = 0.0f;
        this.d = 0;
        this.t();
        Object object = this.e;
        object = bl2 ? ((Stabilizer)object).n() : ((Stabilizer)object).d();
        Object object2 = new b(this);
        object = ((z)object).f2((e.a.v0.g)object2);
        object2 = d.v.e0.oe.a.a;
        object = ((z)object).H3((o)object2);
        object2 = d.v.e0.oe.e.a;
        object = ((z)object).s2((o)object2);
        object2 = new d(this);
        object = ((z)object).H3((o)object2);
        object2 = new g(this);
        object = ((z)object).o2((r)object2);
        object2 = new c(this, bl2);
        Object object3 = ((z)object).H3((o)object2);
        object = d.v.e0.oe.f.a;
        object2 = d.v.e0.oe.i.a;
        this.f = object3 = ((z)object3).c((e.a.v0.g)object, (e.a.v0.g)object2);
    }

    public void t() {
        e.a.s0.b b10 = this.f;
        if (b10 != null) {
            b10.dispose();
            b10 = null;
            this.f = null;
        }
    }

    public void u(float f10) {
        this.v(f10, 1.0f);
    }

    public void v(float f10, float f11) {
        this.b = f10;
        this.c = f11;
    }
}

