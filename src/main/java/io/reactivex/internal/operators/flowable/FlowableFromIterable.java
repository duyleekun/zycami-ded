/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.j;
import e.a.w0.c.a;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableFromIterable$IteratorConditionalSubscription;
import io.reactivex.internal.operators.flowable.FlowableFromIterable$IteratorSubscription;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.util.Iterator;

public final class FlowableFromIterable
extends j {
    public final Iterable b;

    public FlowableFromIterable(Iterable iterable) {
        this.b = iterable;
    }

    public static void K8(d d10, Iterator iterator2) {
        boolean bl2;
        block4: {
            try {
                bl2 = iterator2.hasNext();
                if (bl2) break block4;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
            EmptySubscription.complete(d10);
            return;
        }
        bl2 = d10 instanceof a;
        if (bl2) {
            d d11 = d10;
            d11 = (a)d10;
            FlowableFromIterable$IteratorConditionalSubscription flowableFromIterable$IteratorConditionalSubscription = new FlowableFromIterable$IteratorConditionalSubscription((a)d11, iterator2);
            d10.onSubscribe(flowableFromIterable$IteratorConditionalSubscription);
        } else {
            FlowableFromIterable$IteratorSubscription flowableFromIterable$IteratorSubscription = new FlowableFromIterable$IteratorSubscription(d10, iterator2);
            d10.onSubscribe(flowableFromIterable$IteratorSubscription);
        }
    }

    public void m6(d d10) {
        Object object;
        try {
            object = this.b;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            EmptySubscription.error(throwable, d10);
            return;
        }
        object = object.iterator();
        FlowableFromIterable.K8(d10, (Iterator)object);
    }
}

