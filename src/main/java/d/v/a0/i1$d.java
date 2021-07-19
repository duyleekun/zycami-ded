/*
 * Decompiled with CFR 0.151.
 */
package d.v.a0;

import d.v.a0.i1;
import d.v.a0.k1;
import d.v.a0.l1;
import d.v.k0.f.c.j.k;
import d.v.k0.f.d.a;
import d.v.z.n.g;
import e.a.b0;
import java.util.function.Consumer;

public class i1$d
implements k {
    public final /* synthetic */ g a;
    public final /* synthetic */ Consumer b;
    public final /* synthetic */ b0 c;
    public final /* synthetic */ i1 d;

    public i1$d(i1 i12, g g10, Consumer consumer, b0 b02) {
        this.d = i12;
        this.a = g10;
        this.b = consumer;
        this.c = b02;
    }

    public boolean k(a a10) {
        Object object = this.a;
        boolean bl2 = k1.g((g)object, a10);
        if (bl2) {
            object = i1.E(this.d);
            Consumer consumer = this.b;
            ((l1)object).b(a10, consumer);
            i1.G(this.d).r(this);
            this.c.onComplete();
            return true;
        }
        return false;
    }
}

