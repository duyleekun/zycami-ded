/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.u;

import d.n.a.q0.u.d;
import d.n.a.q0.u.z;
import e.a.h0;
import e.a.i0;
import e.a.p0;
import java.util.concurrent.TimeUnit;

public class d$b
implements p0 {
    public final /* synthetic */ d a;

    public d$b(d d10) {
        this.a = d10;
    }

    public i0 a(i0 i02) {
        d d10 = this.a;
        boolean bl2 = d10.f;
        if (!bl2) {
            z z10 = d10.e;
            long l10 = z10.a;
            TimeUnit timeUnit = z10.b;
            h0 h02 = z10.c;
            i0 i03 = d10.f();
            i02 = i02.l1(l10, timeUnit, h02, i03);
        }
        return i02;
    }
}

