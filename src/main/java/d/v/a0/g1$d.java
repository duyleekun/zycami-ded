/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.g1;
import d.v.a0.k1;
import d.v.a0.l1;
import d.v.k0.f.c.j.k;
import d.v.k0.f.d.a;
import d.v.z.n.g;
import e.a.b0;
import java.util.function.Consumer;

public class g1$d
implements k {
    public final /* synthetic */ g a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ b0 c;
    public final /* synthetic */ g1 d;

    public g1$d(g1 g12, g g10, Consumer consumer, b0 b02) {
        this.d = g12;
        this.a = g10;
        this.b = consumer;
        this.c = b02;
    }

    public boolean k(a a10) {
        Object object = this.a;
        boolean bl2 = k1.g((g)object, a10);
        if (bl2) {
            object = g1.D(this.d);
            Consumer consumer = this.b;
            ((l1)object).b(a10, consumer);
            g1.G(this.d).q(this);
            this.c.onComplete();
            return true;
        }
        return false;
    }
}

