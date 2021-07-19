/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.graphics.PointF
 */
package d.v.v.g;

import android.graphics.PointF;
import com.zhiyun.nvseditor.widget.NvsTouchRect;
import com.zhiyun.nvseditor.widget.NvsTouchRect$a;
import d.v.v.g.g;
import d.v.v.m.a;
import d.v.v.q.h;

public class g$b
implements NvsTouchRect$a {
    public final /* synthetic */ g a;

    public g$b(g g10) {
        this.a = g10;
    }

    public void a(float f10) {
        Object object = new Object[1];
        Float f11 = Float.valueOf(f10);
        object[0] = f11;
        m.a.a.b("---scale  = %s", (Object[])object);
        object = d.v.v.m.a.h();
        int n10 = h.p();
        ((a)object).u(n10, f10, f10);
        d.v.v.j.g g10 = g.d(this.a);
        int n11 = h.p();
        g10.t(n11);
    }

    public void b(float f10) {
        int n10 = 1;
        Object object = new Object[n10];
        Float f11 = Float.valueOf(f10);
        object[0] = f11;
        m.a.a.b("---rotation  = %s", (Object[])object);
        object = d.v.v.m.a.h();
        int n11 = h.p();
        int n12 = -((int)f10);
        ((a)object).s(n11, n12, n10 != 0);
        d.v.v.j.g g10 = g.d(this.a);
        n10 = h.p();
        g10.t(n10);
    }

    public void c(PointF object, PointF object2) {
        object = g.b(this.a).mapViewToCanonical((PointF)object);
        object2 = g.b(this.a).mapViewToCanonical((PointF)object2);
        a a10 = d.v.v.m.a.h();
        int n10 = h.p();
        float f10 = ((PointF)object2).x;
        float f11 = ((PointF)object).x;
        float f12 = ((PointF)object2).y;
        float f13 = ((PointF)object).y;
        a10.x(n10, f10 -= f11, f12 -= f13);
        object = g.d(this.a);
        int n11 = h.p();
        ((d.v.v.j.g)object).t(n11);
        object = d.v.v.m.a.h();
        n11 = h.p();
        object = ((a)object).g(n11);
        object2 = g.q(this.a);
        float f14 = Math.abs(((PointF)object).x);
        n10 = 0x40000000;
        float f15 = 2.0f;
        float f16 = f14 == f15 ? 0 : (f14 < f15 ? -1 : 1);
        boolean bl2 = true;
        f10 = Float.MIN_VALUE;
        f11 = 0.0f;
        if (f16 < 0) {
            f16 = (float)bl2;
            f14 = f10;
        } else {
            f16 = 0.0f;
            a10 = null;
            f14 = 0.0f;
        }
        f13 = Math.abs(((PointF)object).y);
        float f17 = f13 == f15 ? 0 : (f13 < f15 ? -1 : 1);
        if (f17 >= 0) {
            bl2 = false;
            f10 = 0.0f;
        }
        ((NvsTouchRect)((Object)object2)).h((boolean)f16, bl2);
    }
}

