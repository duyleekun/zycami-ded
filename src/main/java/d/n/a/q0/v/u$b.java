/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.v;

import d.n.a.q0.v.u;
import d.n.a.q0.v.u$b$a;
import e.a.f0;
import e.a.h0;
import e.a.z;
import java.util.concurrent.TimeUnit;

public class u$b
implements f0 {
    public final /* synthetic */ int a;
    public final /* synthetic */ long b;
    public final /* synthetic */ u c;

    public u$b(u u10, int n10, long l10) {
        this.c = u10;
        this.a = n10;
        this.b = l10;
    }

    public z b(z z10) {
        long l10 = this.a;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        h0 h02 = this.c.a;
        z10 = z10.d6(l10, timeUnit, h02);
        u$b$a u$b$a = new u$b$a(this);
        return z10.C4(u$b$a);
    }
}

