/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableToList$ToListSubscriber;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Collection;
import java.util.concurrent.Callable;

public final class FlowableToList
extends a {
    public final Callable c;

    public FlowableToList(j j10, Callable callable) {
        super(j10);
        this.c = callable;
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.c;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.call();
        Object object2 = "The collectionSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.";
        object = e.a.w0.b.a.g(object, (String)object2);
        object = (Collection)object;
        object2 = this.b;
        FlowableToList$ToListSubscriber flowableToList$ToListSubscriber = new FlowableToList$ToListSubscriber(d10, (Collection)object);
        ((j)object2).l6(flowableToList$ToListSubscriber);
    }
}

