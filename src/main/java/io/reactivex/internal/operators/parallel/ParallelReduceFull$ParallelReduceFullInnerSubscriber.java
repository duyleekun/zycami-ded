/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.a1.a;
import e.a.o;
import e.a.v0.c;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelReduceFull$ParallelReduceFullMainSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class ParallelReduceFull$ParallelReduceFullInnerSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -7954444275102466525L;
    public boolean done;
    public final ParallelReduceFull$ParallelReduceFullMainSubscriber parent;
    public final c reducer;
    public Object value;

    public ParallelReduceFull$ParallelReduceFullInnerSubscriber(ParallelReduceFull$ParallelReduceFullMainSubscriber parallelReduceFullMainSubscriber, c c10) {
        this.parent = parallelReduceFullMainSubscriber;
        this.reducer = c10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (!bl2) {
            this.done = bl2 = true;
            ParallelReduceFull$ParallelReduceFullMainSubscriber parallelReduceFull$ParallelReduceFullMainSubscriber = this.parent;
            Object object = this.value;
            parallelReduceFull$ParallelReduceFullMainSubscriber.innerComplete(object);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.parent.innerError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (!bl2) {
            Object object2 = this.value;
            if (object2 == null) {
                this.value = object;
            } else {
                c c10 = this.reducer;
                object = c10.apply(object2, object);
                object2 = "The reducer returned a null value";
                try {
                    this.value = object = e.a.w0.b.a.g(object, (String)object2);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    object2 = (e)this.get();
                    object2.cancel();
                    this.onError(throwable);
                }
            }
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

