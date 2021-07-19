/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.t.b;
import d.n.a.q0.u.p;
import d.n.a.q0.w.e$b;
import d.n.a.q0.w.g;
import d.n.a.q0.w.h;
import e.a.v0.f;

public class e$b$a
implements f {
    public final /* synthetic */ g a;
    public final /* synthetic */ e$b b;

    public e$b$a(e$b b10, g g10) {
        this.b = b10;
        this.a = g10;
    }

    public void cancel() {
        Object object = this.b.b.d;
        g g10 = this.a;
        boolean bl2 = ((h)object).c(g10);
        if (bl2) {
            object = this.b.a;
            d.n.a.q0.t.b.q((p)object);
        }
    }
}

