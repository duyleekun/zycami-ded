/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.v0.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscribers.DeferredScalarSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class ParallelReduce$ParallelReduceSubscriber
extends DeferredScalarSubscriber {
    private static final long serialVersionUID = 8200530050639449080L;
    public Object accumulator;
    public boolean done;
    public final c reducer;

    public ParallelReduce$ParallelReduceSubscriber(d d10, Object object, c c10) {
        super(d10);
        this.accumulator = object;
        this.reducer = c10;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            Object object = this.accumulator;
            this.accumulator = null;
            this.complete(object);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.accumulator = null;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (!bl2) {
            Object object2 = this.reducer;
            Object object3 = this.accumulator;
            object = object2.apply(object3, object);
            object2 = "The reducer returned a null value";
            try {
                this.accumulator = object = e.a.w0.b.a.g(object, (String)object2);
            }
            catch (Throwable throwable) {
                e.a.t0.a.b(throwable);
                this.cancel();
                this.onError(throwable);
            }
        }
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

