/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.t.b;
import d.n.a.q0.u.p;
import d.n.a.q0.w.e;
import d.n.a.q0.w.e$b$a;
import d.n.a.q0.w.g;
import e.a.b0;
import e.a.c0;
import e.a.v0.f;

public class e$b
implements c0 {
    public final /* synthetic */ p a;
    public final /* synthetic */ e b;

    public e$b(e e10, p p10) {
        this.b = e10;
        this.a = p10;
    }

    public void subscribe(b0 b02) {
        Object object = this.a;
        g g10 = new g((p)object, b02);
        object = new e$b$a(this, g10);
        b02.setCancellable((f)object);
        d.n.a.q0.t.b.p(this.a);
        this.b.d.a(g10);
    }
}

