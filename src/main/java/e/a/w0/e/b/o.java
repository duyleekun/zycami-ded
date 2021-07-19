/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.w0.c.b;
import e.a.w0.e.b.o$a;
import io.reactivex.internal.operators.flowable.FlowableCount;

public final class o
extends i0
implements b {
    public final j a;

    public o(j j10) {
        this.a = j10;
    }

    public void e1(l0 l02) {
        j j10 = this.a;
        o$a o$a = new o$a(l02);
        j10.l6(o$a);
    }

    public j l() {
        j j10 = this.a;
        FlowableCount flowableCount = new FlowableCount(j10);
        return e.a.a1.a.P(flowableCount);
    }
}

