/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableTake$TakeSubscriber;

public final class e1
extends j {
    public final c b;
    public final long c;

    public e1(c c10, long l10) {
        this.b = c10;
        this.c = l10;
    }

    public void m6(d d10) {
        c c10 = this.b;
        long l10 = this.c;
        FlowableTake$TakeSubscriber flowableTake$TakeSubscriber = new FlowableTake$TakeSubscriber(d10, l10);
        c10.subscribe(flowableTake$TakeSubscriber);
    }
}

