/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.j;
import e.a.q;
import e.a.t;
import e.a.w0.c.b;
import e.a.w0.e.b.z0$a;
import io.reactivex.internal.operators.flowable.FlowableSingle;

public final class z0
extends q
implements b {
    public final j a;

    public z0(j j10) {
        this.a = j10;
    }

    public j l() {
        j j10 = this.a;
        FlowableSingle flowableSingle = new FlowableSingle(j10, null, false);
        return e.a.a1.a.P(flowableSingle);
    }

    public void t1(t t10) {
        j j10 = this.a;
        z0$a z0$a = new z0$a(t10);
        j10.l6(z0$a);
    }
}

