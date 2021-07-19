/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.v.u;
import d.n.a.q0.v.u$a$a;
import d.n.a.q0.v.u$a$b;
import d.n.a.q0.v.u$a$c;
import e.a.f0;
import e.a.h0;
import e.a.v0.o;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class u$a
implements f0 {
    public final o a;
    public final z b;
    public final o c;
    public final o d;
    public final /* synthetic */ h0 e;
    public final /* synthetic */ u f;

    public u$a(u object, h0 h02) {
        this.f = object;
        this.e = h02;
        this.a = object = u.g();
        object = TimeUnit.SECONDS;
        object = z.P6(10, (TimeUnit)((Object)object), h02);
        this.b = object;
        object = new u$a$a(this);
        this.c = object;
        object = new u$a$b(this);
        this.d = object;
    }

    public z b(z z10) {
        u$a$c u$a$c = new u$a$c(this);
        return z10.s4(u$a$c);
    }
}

