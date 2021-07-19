/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.d.r;

import d.v.d.g.d.r.h;
import d.v.d.i.g.n;

public class h$b
implements Runnable {
    public final /* synthetic */ h a;

    public h$b(h h10) {
        this.a = h10;
    }

    public void run() {
        n n10 = this.a.g1();
        Object object = h.V0(this.a);
        n10.n((Integer)object);
        n10 = this.a.s();
        object = h.W0(this.a);
        n10.postDelayed((Runnable)object, 900L);
    }
}

