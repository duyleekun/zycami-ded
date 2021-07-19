/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.v0.r;
import e.a.w0.c.b;
import e.a.w0.e.b.f$a;
import io.reactivex.internal.operators.flowable.FlowableAny;

public final class f
extends i0
implements b {
    public final j a;
    public final r b;

    public f(j j10, r r10) {
        this.a = j10;
        this.b = r10;
    }

    public void e1(l0 l02) {
        j j10 = this.a;
        r r10 = this.b;
        f$a f$a = new f$a(l02, r10);
        j10.l6(f$a);
    }

    public j l() {
        j j10 = this.a;
        r r10 = this.b;
        FlowableAny flowableAny = new FlowableAny(j10, r10);
        return e.a.a1.a.P(flowableAny);
    }
}

