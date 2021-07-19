/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.parallel;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.parallel.ParallelSortedJoin$SortedJoinSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public final class ParallelSortedJoin$SortedJoinInnerSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = 6751017204873808094L;
    public final int index;
    public final ParallelSortedJoin$SortedJoinSubscription parent;

    public ParallelSortedJoin$SortedJoinInnerSubscriber(ParallelSortedJoin$SortedJoinSubscription parallelSortedJoin$SortedJoinSubscription, int n10) {
        this.parent = parallelSortedJoin$SortedJoinSubscription;
        this.index = n10;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.parent.innerError(throwable);
    }

    public void onNext(List list) {
        ParallelSortedJoin$SortedJoinSubscription parallelSortedJoin$SortedJoinSubscription = this.parent;
        int n10 = this.index;
        parallelSortedJoin$SortedJoinSubscription.innerNext(list, n10);
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

