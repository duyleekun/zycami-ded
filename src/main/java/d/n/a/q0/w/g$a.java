/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.w;

import d.n.a.q0.w.g;
import d.n.a.q0.w.g$a$a;
import d.n.a.q0.w.j;
import d.n.a.q0.w.k;
import e.a.g0;
import e.a.h0;
import e.a.z;

public class g$a
implements Runnable {
    public final /* synthetic */ k a;
    public final /* synthetic */ h0 b;
    public final /* synthetic */ g c;

    public g$a(g g10, k k10, h0 h02) {
        this.c = g10;
        this.a = k10;
        this.b = h02;
    }

    public void run() {
        Object object = this.c.b;
        Object object2 = this.a;
        object = object.O((j)object2);
        object2 = this.b;
        object = ((z)object).m7((h0)object2);
        object2 = new g$a$a(this);
        ((z)object).subscribe((g0)object2);
    }
}

