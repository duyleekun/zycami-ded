/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.w0.c.b;
import e.a.w0.e.b.a1$a;
import io.reactivex.internal.operators.flowable.FlowableSingle;

public final class a1
extends i0
implements b {
    public final j a;
    public final Object b;

    public a1(j j10, Object object) {
        this.a = j10;
        this.b = object;
    }

    public void e1(l0 l02) {
        j j10 = this.a;
        Object object = this.b;
        a1$a a1$a = new a1$a(l02, object);
        j10.l6(a1$a);
    }

    public j l() {
        j j10 = this.a;
        Object object = this.b;
        FlowableSingle flowableSingle = new FlowableSingle(j10, object, true);
        return e.a.a1.a.P(flowableSingle);
    }
}

