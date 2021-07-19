/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package d.v.c.q1.h0;

import android.content.Context;
import com.zhiyun.cama.set.bind.DeviceBindViewModel;
import d.v.c.q1.h0.j0;
import d.v.c.q1.h0.k0;
import d.v.c.q1.h0.k0$b;
import d.v.e.l.b2;
import d.v.e.l.m2;
import d.v.e.l.n2;
import d.v.f.i.g;

public class k0$a {
    public final /* synthetic */ k0 a;

    public k0$a(k0 k02) {
        this.a = k02;
    }

    public void a() {
        this.a.dismiss();
    }

    public void b() {
        this.a.dismiss();
        Object object = this.a.requireContext();
        boolean bl2 = b2.m((Context)object);
        if (bl2) {
            object = k0.s(this.a);
            ((DeviceBindViewModel)object).k();
        } else {
            object = this.a.requireContext();
            int n10 = 2131953261;
            object = g.m((Context)object, n10);
            n2.e((String)object);
        }
    }

    public void c() {
        k0$b k0$b = k0.t(this.a);
        if (k0$b != null) {
            k0$b = k0.t(this.a);
            k0$b.a();
        }
        k0 k02 = this.a;
        j0 j02 = new j0(k02);
        m2.Y(100, j02);
    }
}

