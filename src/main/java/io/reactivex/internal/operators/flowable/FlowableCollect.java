/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.b;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCollect$CollectSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableCollect
extends e.a.w0.e.b.a {
    public final Callable c;
    public final b d;

    public FlowableCollect(j j10, Callable callable, b b10) {
        super(j10);
        this.c = callable;
        this.d = b10;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.call();
        Object object2 = "The initial value supplied is null";
        object = e.a.w0.b.a.g(object, (String)object2);
        object2 = this.b;
        b b10 = this.d;
        FlowableCollect$CollectSubscriber flowableCollect$CollectSubscriber = new FlowableCollect$CollectSubscriber(d10, object, b10);
        ((j)object2).l6(flowableCollect$CollectSubscriber);
    }
}

