/*
 * Decompiled with CFR 0.151.
 */
package d.j.d.a.o;

import d.j.d.a.g;
import d.j.d.a.k;
import d.j.d.a.o.h;
import d.j.d.a.o.h$d;

public final class h$d$a
implements g {
    public final /* synthetic */ h$d a;

    public h$d$a(h$d d10) {
        this.a = d10;
    }

    public final void onComplete(k object) {
        boolean bl2 = ((k)object).v();
        if (bl2) {
            h h10 = this.a.b;
            object = ((k)object).r();
            h10.A(object);
            return;
        }
        bl2 = ((k)object).t();
        if (bl2) {
            this.a.b.B();
            return;
        }
        h h11 = this.a.b;
        object = ((k)object).q();
        h11.z((Exception)object);
    }
}

