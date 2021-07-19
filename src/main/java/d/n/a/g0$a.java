/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.g0;
import d.n.a.g0$a$a;
import d.n.a.q0.u.p;
import d.n.a.q0.v.w;
import d.n.a.r0.b;
import d.n.a.r0.e;
import e.a.e0;
import e.a.f0;
import e.a.h0;
import e.a.v0.g;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.Callable;

public class g0$a
implements Callable {
    public final /* synthetic */ e a;
    public final /* synthetic */ b[] b;
    public final /* synthetic */ g0 c;

    public g0$a(g0 g02, e e10, b[] bArray) {
        this.c = g02;
        this.a = e10;
        this.b = bArray;
    }

    public z a() {
        Object object = this.c.e;
        boolean bl2 = this.a.a();
        object.a(bl2);
        object = this.c.d;
        Object object2 = this.a;
        Object object3 = this.b;
        object = object.a((e)object2, (b)object3);
        object2 = ((w)object).a;
        object2 = this.c.a.d((p)object2);
        object3 = this.c.h;
        object2 = ((z)object2).m7((h0)object3);
        object = ((w)object).b;
        object = ((z)object2).z0((f0)object);
        object2 = this.c.f;
        object = ((z)object).H3((o)object2);
        object2 = new g0$a$a(this);
        object = ((z)object).f2((g)object2);
        object2 = this.c.m();
        return ((z)object).f4((e0)object2);
    }
}

