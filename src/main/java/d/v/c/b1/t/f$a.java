/*
 * Decompiled with CFR 0.151.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.view.View
 */
package d.v.c.b1.t;

import android.content.Context;
import android.view.View;
import d.v.c.b1.t.f;
import d.v.c.b1.t.g;
import d.v.c.q0.f.a;
import d.v.e.l.p1;

public class f$a
implements a {
    public final /* synthetic */ f a;

    public f$a(f f10) {
        this.a = f10;
    }

    public void a(View view) {
        boolean bl2 = p1.a();
        if (bl2) {
            return;
        }
        f.x(this.a);
        g g10 = f.y(this.a);
        view = view.getContext();
        g10.D4((Context)view);
    }

    public void b(View view) {
        boolean bl2 = p1.a();
        if (bl2) {
            return;
        }
        f.x(this.a);
        g g10 = f.y(this.a);
        view = view.getContext();
        g10.C4((Context)view);
    }
}

