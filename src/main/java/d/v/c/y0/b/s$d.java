/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y0.b;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.zhiyun.device.connection.BleConnection;
import com.zhiyun.stabilizer.Stabilizer;
import d.v.c.s0.a7.n1.a$a;
import d.v.c.y0.b.b;
import d.v.c.y0.b.c;
import d.v.c.y0.b.r;
import d.v.c.y0.b.s;
import d.v.e.l.h2;
import d.v.e.l.m2;
import d.v.e.l.m2$b;
import d.v.e.l.m2$d;
import d.v.e0.ce;
import d.v.f.f.a;
import d.v.f.i.g;

public class s$d {
    public final /* synthetic */ s a;

    public s$d(s s10) {
        this.a = s10;
    }

    public static /* synthetic */ void d(DialogFragment dialogFragment) {
        BleConnection.W().R();
    }

    private /* synthetic */ void e() {
        s.w((s)this.a).e.setVisibility(0);
        s.w((s)this.a).f.setVisibility(8);
    }

    public void a() {
        Object object = s.v(this.a).u();
        if (object != null) {
            Object object2 = new a$a();
            Object object3 = g.s(this.a, 2131951953);
            int n10 = 1;
            Object[] objectArray = new Object[n10];
            objectArray[0] = object = ((Stabilizer)object).b;
            object = String.format((String)object3, objectArray);
            object = ((a$a)object2).o((String)object);
            float f10 = 143.0f;
            int n11 = h2.b(f10);
            object = ((a$a)object).k(n11);
            object2 = g.m(this.a.requireContext(), 2131951833);
            object = ((a$a)object).l((String)object2, null);
            object2 = g.s(this.a, 2131952621);
            object3 = b.a;
            object = ((a$a)object).n((String)object2, (a)object3);
            object2 = new d.v.c.s0.a7.n1.a((a$a)object);
            object = this.a.getChildFragmentManager();
            object3 = this.a;
            int n12 = ((s)object3).k();
            ((d.v.f.g.b)object2).r((FragmentManager)object, n12);
        }
    }

    public void b() {
        this.a.dismiss();
    }

    public void c() {
        Object object = BleConnection.W();
        boolean bl2 = ((BleConnection)object).c0();
        if (!bl2) {
            this.a.dismiss();
            return;
        }
        bl2 = ce.A1();
        if (bl2 && !(bl2 = s.y((s)(object = this.a)))) {
            object = s.z(this.a);
            if (object != null) {
                object = s.z(this.a);
                object.a();
                long l10 = 100;
                s s10 = this.a;
                r r10 = new r(s10);
                m2.Y(l10, r10);
            }
        } else {
            object = this.a;
            ((DialogFragment)object).dismiss();
        }
    }

    public /* synthetic */ void f() {
        this.e();
    }

    public void g() {
        s.v(this.a).G();
        s.w((s)this.a).e.setVisibility(8);
        s.w((s)this.a).f.setVisibility(0);
        s s10 = this.a;
        Object object = new c(this);
        object = m2.X(2000L, s10, (m2$b)object);
        s.x(s10, (m2$d)object);
    }
}

