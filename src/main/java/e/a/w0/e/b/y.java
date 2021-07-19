/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.j;
import e.a.q;
import e.a.t;
import e.a.w0.c.b;
import e.a.w0.e.b.y$a;
import io.reactivex.internal.operators.flowable.FlowableElementAt;

public final class y
extends q
implements b {
    public final j a;
    public final long b;

    public y(j j10, long l10) {
        this.a = j10;
        this.b = l10;
    }

    public j l() {
        j j10 = this.a;
        long l10 = this.b;
        FlowableElementAt flowableElementAt = new FlowableElementAt(j10, l10, null, false);
        return e.a.a1.a.P(flowableElementAt);
    }

    public void t1(t t10) {
        j j10 = this.a;
        long l10 = this.b;
        y$a y$a = new y$a(t10, l10);
        j10.l6(y$a);
    }
}

