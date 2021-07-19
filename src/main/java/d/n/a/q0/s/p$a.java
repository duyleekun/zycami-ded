/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.n0;
import d.n.a.q0.s.c;
import d.n.a.q0.s.p;
import d.n.a.q0.s.p$a$a;
import d.n.a.q0.s.p$a$b;
import d.n.a.z;
import e.a.e0;
import e.a.h0;
import e.a.v0.a;
import e.a.v0.g;
import java.util.Set;
import java.util.concurrent.Callable;

public class p$a
implements Callable {
    public final /* synthetic */ z a;
    public final /* synthetic */ p b;

    public p$a(p p10, z z10) {
        this.b = p10;
        this.a = z10;
    }

    public e0 a() {
        Object object = this.b.b;
        boolean bl2 = this.a.a;
        object = object.a(bl2);
        bl2 = this.a.b;
        object = object.b(bl2);
        Object object2 = this.a.c;
        object = object.c((n0)object2).build();
        object2 = object.a();
        Object object3 = p.d((c)object);
        e.a.z z10 = p.c((c)object);
        object3 = ((e.a.z)object3).f4(z10);
        object = this.b.b((c)object);
        object = ((e.a.z)object3).M1((e0)object);
        object3 = new p$a$b(this, (Set)object2);
        object = ((e.a.z)object).g2((g)object3);
        object3 = new p$a$a(this, (Set)object2);
        object = ((e.a.z)object).X1((a)object3);
        object2 = this.b.c;
        object = ((e.a.z)object).L5((h0)object2);
        object2 = this.b.c;
        return ((e.a.z)object).m7((h0)object2);
    }
}

