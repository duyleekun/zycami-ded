/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.c;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$a;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$b;
import io.reactivex.internal.subscriptions.EmptySubscription;

public final class FlowablePublishMulticast
extends a {
    public final o c;
    public final int d;
    public final boolean e;

    public FlowablePublishMulticast(j j10, o o10, int n10, boolean bl2) {
        super(j10);
        this.c = o10;
        this.d = n10;
        this.e = bl2;
    }

    public void m6(d d10) {
        Object object;
        int n10 = this.d;
        boolean bl2 = this.e;
        FlowablePublishMulticast$a flowablePublishMulticast$a = new FlowablePublishMulticast$a(n10, bl2);
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.apply(flowablePublishMulticast$a);
        Object object2 = "selector returned a null Publisher";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (c)object;
        object2 = new FlowablePublishMulticast$b(d10, flowablePublishMulticast$a);
        object.subscribe((d)object2);
        this.b.l6(flowablePublishMulticast$a);
    }
}

