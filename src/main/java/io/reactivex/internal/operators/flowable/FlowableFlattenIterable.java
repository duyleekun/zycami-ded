/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.v0.o;
import e.a.w0.e.b.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFlattenIterable$FlattenIterableSubscriber;
import io.reactivex.internal.operators.flowable.FlowableFromIterable;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.concurrent.Callable;

public final class FlowableFlattenIterable
extends a {
    public final o c;
    public final int d;

    public FlowableFlattenIterable(j j10, o o10, int n10) {
        super(j10);
        this.c = o10;
        this.d = n10;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void m6(d d10) {
        Object object;
        block5: {
            object = this.b;
            boolean bl2 = object instanceof Callable;
            if (!bl2) {
                o o11 = this.c;
                int n10 = this.d;
                FlowableFlattenIterable$FlattenIterableSubscriber flowableFlattenIterable$FlattenIterableSubscriber = new FlowableFlattenIterable$FlattenIterableSubscriber(d10, o11, n10);
                ((j)object).l6(flowableFlattenIterable$FlattenIterableSubscriber);
                return;
            }
            try {
                object = (Callable)object;
                object = object.call();
                if (object != null) break block5;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
            EmptySubscription.complete(d10);
            return;
        }
        try {
            o o10 = this.c;
            object = o10.apply(object);
            object = (Iterable)object;
            object = object.iterator();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        FlowableFromIterable.K8(d10, object);
    }
}

