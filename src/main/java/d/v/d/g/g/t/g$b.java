/*
 * Decompiled with CFR 0.151.
 */
package d.v.d.g.g.t;

import d.v.d.g.g.t.g;
import d.v.d.i.g.n;

public class g$b
implements Runnable {
    public final /* synthetic */ g a;

    public g$b(g g10) {
        this.a = g10;
    }

    public void run() {
        n n10 = this.a.Q0();
        Object object = g.D0(this.a);
        n10.n((Integer)object);
        n10 = g.F0(this.a);
        object = g.E0(this.a);
        n10.postDelayed((Runnable)object, 900L);
    }
}

