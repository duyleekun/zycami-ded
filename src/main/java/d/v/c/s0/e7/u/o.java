/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.Point
 */
package d.v.c.s0.e7.u;

import android.graphics.Point;
import androidx.core.math.MathUtils;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.s0.e7.u.d;
import d.v.c.s0.e7.u.e;
import d.v.c.s0.e7.u.f;
import d.v.c.s0.e7.u.g;
import d.v.c.s0.e7.u.h;
import d.v.c.s0.e7.u.i;
import d.v.c.s0.e7.u.j;
import d.v.c.s0.e7.u.k;
import d.v.e0.ce;
import e.a.a;
import e.a.i0;
import e.a.s0.b;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class o {
    private final Point a;
    private e.a.s0.a b;

    public o() {
        Point point;
        this.a = point = new Point();
    }

    private z a(Stabilizer stabilizer) {
        Object object = TimeUnit.MILLISECONDS;
        object = z.l3(0L, 50, (TimeUnit)((Object)object));
        g g10 = new g(stabilizer);
        return ((z)object).H3(g10);
    }

    private z b(Stabilizer stabilizer) {
        Object object = TimeUnit.SECONDS;
        object = z.l3(0L, 1L, (TimeUnit)((Object)object));
        j j10 = new j(stabilizer);
        return ((z)object).H3(j10);
    }

    public static /* synthetic */ a d(o o10, Stabilizer stabilizer) {
        return o10.n(stabilizer);
    }

    public static /* synthetic */ a e(o o10, Stabilizer stabilizer) {
        return o10.o(stabilizer);
    }

    public static /* synthetic */ void f(Throwable throwable) {
        o.l(throwable);
    }

    public static /* synthetic */ z g(o o10, Stabilizer stabilizer) {
        return o10.b(stabilizer);
    }

    public static /* synthetic */ void h(o o10) {
        o10.m();
    }

    public static /* synthetic */ Stabilizer i(Stabilizer stabilizer, Long l10) {
        return stabilizer;
    }

    public static /* synthetic */ Stabilizer j(Stabilizer stabilizer, Long l10) {
        return stabilizer;
    }

    public static /* synthetic */ z k(o o10, Stabilizer stabilizer) {
        return o10.a(stabilizer);
    }

    private static void l(Throwable throwable) {
        throwable.printStackTrace();
    }

    private void m() {
        Object[] objectArray = new Object[]{};
        m.a.a.i("Live assistant ble cmd", objectArray);
    }

    private a n(Stabilizer stabilizer) {
        Point point = this.a;
        int n10 = point.x;
        int n11 = point.y;
        return stabilizer.B7(n10, n11).k3();
    }

    private a o(Stabilizer stabilizer) {
        return stabilizer.g7(1.0f);
    }

    public boolean c() {
        boolean bl2;
        e.a.s0.a a10 = this.b;
        if (a10 != null && !(bl2 = a10.isDisposed())) {
            bl2 = true;
        } else {
            bl2 = false;
            a10 = null;
        }
        return bl2;
    }

    public void p(float f10, float f11) {
        float f12 = -1.0f;
        float f13 = 1.0f;
        f10 = MathUtils.clamp(f10, f12, f13);
        f11 = MathUtils.clamp(f11, f12, f13);
        f12 = 500.0f;
        int n10 = Math.round((f10 += f13) * f12);
        int n11 = Math.round((f11 + f13) * f12);
        this.a.set(n10, n11);
    }

    public void q() {
        boolean bl2 = this.c();
        if (bl2) {
            return;
        }
        Object object = this.a;
        int n10 = 500;
        object.set(n10, n10);
        object = ce.E0().X0();
        Object object2 = new k(this);
        object = ((i0)object).k0((e.a.v0.o)object2);
        object2 = new d(this);
        object = ((z)object).E2((e.a.v0.o)object2);
        object2 = new i(this);
        Object object3 = f.a;
        object = ((a)object).h((e.a.v0.a)object2, (e.a.v0.g)object3);
        object2 = ce.E0().X0();
        b[] bArray = new h(this);
        object2 = ((i0)object2).k0((e.a.v0.o)bArray);
        bArray = new e(this);
        object2 = ((z)object2).E2((e.a.v0.o)bArray);
        bArray = new i(this);
        object2 = ((a)object2).h((e.a.v0.a)bArray, (e.a.v0.g)object3);
        bArray = new b[]{object, object2};
        this.b = object3 = new e.a.s0.a(bArray);
    }

    public void r() {
        e.a.s0.a a10 = this.b;
        if (a10 != null) {
            a10.dispose();
        }
    }
}

