/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableCombineLatest$CombineLatestCoordinator;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCombineLatest$CombineLatestInnerSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = -8730235182291002949L;
    public final int index;
    public final int limit;
    public final FlowableCombineLatest$CombineLatestCoordinator parent;
    public final int prefetch;
    public int produced;

    public FlowableCombineLatest$CombineLatestInnerSubscriber(FlowableCombineLatest$CombineLatestCoordinator combineLatestCoordinator, int n10, int n11) {
        this.parent = combineLatestCoordinator;
        this.index = n10;
        this.prefetch = n11;
        int n12 = n11 >> 2;
        this.limit = n11 -= n12;
    }

    public void cancel() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        FlowableCombineLatest$CombineLatestCoordinator flowableCombineLatest$CombineLatestCoordinator = this.parent;
        int n10 = this.index;
        flowableCombineLatest$CombineLatestCoordinator.innerComplete(n10);
    }

    public void onError(Throwable throwable) {
        FlowableCombineLatest$CombineLatestCoordinator flowableCombineLatest$CombineLatestCoordinator = this.parent;
        int n10 = this.index;
        flowableCombineLatest$CombineLatestCoordinator.innerError(n10, throwable);
    }

    public void onNext(Object object) {
        FlowableCombineLatest$CombineLatestCoordinator flowableCombineLatest$CombineLatestCoordinator = this.parent;
        int n10 = this.index;
        flowableCombineLatest$CombineLatestCoordinator.innerValue(n10, object);
    }

    public void onSubscribe(e e10) {
        long l10 = this.prefetch;
        SubscriptionHelper.setOnce(this, e10, l10);
    }

    public void requestOne() {
        int n10 = this.produced + 1;
        int n11 = this.limit;
        if (n10 == n11) {
            n11 = 0;
            this.produced = 0;
            e e10 = (e)this.get();
            long l10 = n10;
            e10.request(l10);
        } else {
            this.produced = n10;
        }
    }
}

