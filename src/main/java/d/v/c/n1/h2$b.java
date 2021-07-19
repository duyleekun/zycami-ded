/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.n1;

import android.content.Context;
import android.view.View;
import d.v.c.n1.h2;
import d.v.c.u0.m;
import d.v.i0.b;

public class h2$b {
    public final /* synthetic */ h2 a;

    public h2$b(h2 h22) {
        this.a = h22;
    }

    public void a(View object) {
        object = h2.k(this.a).v();
        boolean bl2 = (Boolean)object;
        if (!bl2) {
            return;
        }
        h2.m(this.a);
    }

    public void b(View view) {
        h2.j(this.a);
    }

    public void c(View view) {
        m m10 = (m)b.c(this.a.requireActivity()).get(m.class);
        view = view.getContext();
        m10.b((Context)view);
        h2.j(this.a);
    }

    public void d(View object) {
        object = h2.k(this.a).v();
        boolean bl2 = (Boolean)object;
        if (bl2) {
            return;
        }
        h2.l(this.a);
    }
}

