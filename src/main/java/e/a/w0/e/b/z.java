/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.a1.a;
import e.a.i0;
import e.a.j;
import e.a.l0;
import e.a.w0.c.b;
import e.a.w0.e.b.z$a;
import io.reactivex.internal.operators.flowable.FlowableElementAt;

public final class z
extends i0
implements b {
    public final j a;
    public final long b;
    public final Object c;

    public z(j j10, long l10, Object object) {
        this.a = j10;
        this.b = l10;
        this.c = object;
    }

    public void e1(l0 l02) {
        j j10 = this.a;
        long l10 = this.b;
        Object object = this.c;
        z$a z$a = new z$a(l02, l10, object);
        j10.l6(z$a);
    }

    public j l() {
        j j10 = this.a;
        long l10 = this.b;
        Object object = this.c;
        FlowableElementAt flowableElementAt = new FlowableElementAt(j10, l10, object, true);
        return e.a.a1.a.P(flowableElementAt);
    }
}

