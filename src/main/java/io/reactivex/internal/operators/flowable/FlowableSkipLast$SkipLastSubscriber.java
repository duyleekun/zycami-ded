/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.ArrayDeque;

public final class FlowableSkipLast$SkipLastSubscriber
extends ArrayDeque
implements o,
e {
    private static final long serialVersionUID = -3807491841935125653L;
    public final d downstream;
    public final int skip;
    public e upstream;

    public FlowableSkipLast$SkipLastSubscriber(d d10, int n10) {
        super(n10);
        this.downstream = d10;
        this.skip = n10;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        int n10 = this.skip;
        int n11 = this.size();
        if (n10 == n11) {
            d d10 = this.downstream;
            Object e10 = this.poll();
            d10.onNext(e10);
        } else {
            e e11 = this.upstream;
            long l10 = 1L;
            e11.request(l10);
        }
        this.offer(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.upstream.request(l10);
    }
}

