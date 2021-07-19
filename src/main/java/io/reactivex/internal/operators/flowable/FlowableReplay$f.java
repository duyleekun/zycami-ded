/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.t0.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableReplay$InnerSubscription;
import io.reactivex.internal.operators.flowable.FlowableReplay$ReplaySubscriber;
import io.reactivex.internal.operators.flowable.FlowableReplay$d;
import io.reactivex.internal.subscriptions.EmptySubscription;
import java.io.Serializable;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableReplay$f
implements c {
    private final AtomicReference a;
    private final Callable b;

    public FlowableReplay$f(AtomicReference atomicReference, Callable callable) {
        this.a = atomicReference;
        this.b = callable;
    }

    public void subscribe(d d10) {
        Serializable serializable;
        Object object;
        while ((object = (FlowableReplay$ReplaySubscriber)this.a.get()) == null) {
            try {
                object = this.b;
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                EmptySubscription.error(throwable, d10);
                return;
            }
            object = object.call();
            object = (FlowableReplay$d)object;
            serializable = new FlowableReplay$ReplaySubscriber((FlowableReplay$d)object);
            object = this.a;
            boolean bl2 = ((AtomicReference)object).compareAndSet(null, serializable);
            if (!bl2) continue;
            object = serializable;
            break;
        }
        serializable = new FlowableReplay$InnerSubscription((FlowableReplay$ReplaySubscriber)object, d10);
        d10.onSubscribe((e)((Object)serializable));
        ((FlowableReplay$ReplaySubscriber)object).add((FlowableReplay$InnerSubscription)serializable);
        boolean bl3 = ((FlowableReplay$InnerSubscription)serializable).isDisposed();
        if (bl3) {
            ((FlowableReplay$ReplaySubscriber)object).remove((FlowableReplay$InnerSubscription)serializable);
            return;
        }
        ((FlowableReplay$ReplaySubscriber)object).manageRequests();
        ((FlowableReplay$ReplaySubscriber)object).buffer.replay((FlowableReplay$InnerSubscription)serializable);
    }
}

