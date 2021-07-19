/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.j;
import e.a.q;
import e.a.t;
import e.a.w0.c.b;
import e.a.w0.c.h;
import e.a.w0.e.b.t0$a;
import i.g.c;
import io.reactivex.internal.operators.flowable.FlowableReduce;

public final class t0
extends q
implements h,
b {
    public final j a;
    public final e.a.v0.c b;

    public t0(j j10, e.a.v0.c c10) {
        this.a = j10;
        this.b = c10;
    }

    public j l() {
        j j10 = this.a;
        e.a.v0.c c10 = this.b;
        FlowableReduce flowableReduce = new FlowableReduce(j10, c10);
        return e.a.a1.a.P(flowableReduce);
    }

    public c source() {
        return this.a;
    }

    public void t1(t t10) {
        j j10 = this.a;
        e.a.v0.c c10 = this.b;
        t0$a t0$a = new t0$a(t10, c10);
        j10.l6(t0$a);
    }
}

