/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.s;

import d.n.a.q0.s.z0;
import d.n.a.q0.u.z;
import e.a.c1.b;
import e.a.h0;
import e.a.v0.g;
import java.util.concurrent.TimeUnit;

public class z0$a
implements g {
    public final /* synthetic */ long a;
    public final /* synthetic */ TimeUnit b;
    public final /* synthetic */ z0 c;

    public z0$a(z0 z02, long l10, TimeUnit timeUnit) {
        this.c = z02;
        this.a = l10;
        this.b = timeUnit;
    }

    public void a(e.a.s0.b object) {
        object = this.c.e;
        long l10 = this.a;
        TimeUnit timeUnit = this.b;
        h0 h02 = e.a.c1.b.a();
        z z10 = new z(l10, timeUnit, h02);
        object.onNext(z10);
    }
}

