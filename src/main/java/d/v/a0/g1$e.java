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
import java.util.function.Consumer;

public class g1$e
implements k {
    public final /* synthetic */ g a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ g1 c;

    public g1$e(g1 g12, g g10, Consumer consumer) {
        this.c = g12;
        this.a = g10;
        this.b = consumer;
    }

    public boolean k(a a10) {
        Object object = this.a;
        boolean bl2 = k1.g((g)object, a10);
        if (bl2) {
            object = g1.D(this.c);
            Consumer consumer = this.b;
            ((l1)object).b(a10, consumer);
            g1.G(this.c).q(this);
            return true;
        }
        return false;
    }
}

