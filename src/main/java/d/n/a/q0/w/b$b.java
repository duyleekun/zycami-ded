/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.u.p;
import d.n.a.q0.w.b;
import d.n.a.q0.w.b$b$a;
import d.n.a.q0.w.g;
import e.a.b0;
import e.a.c0;
import e.a.s0.c;
import e.a.v0.a;

public class b$b
implements c0 {
    public final /* synthetic */ p a;
    public final /* synthetic */ b b;

    public b$b(b b10, p p10) {
        this.b = b10;
        this.a = p10;
    }

    public void subscribe(b0 b02) {
        Object object = this.a;
        g g10 = new g((p)object, b02);
        object = new b$b$a(this, g10);
        object = c.c((a)object);
        b02.setDisposable((e.a.s0.b)object);
        d.n.a.q0.t.b.p(this.a);
        this.b.a.a(g10);
    }
}

