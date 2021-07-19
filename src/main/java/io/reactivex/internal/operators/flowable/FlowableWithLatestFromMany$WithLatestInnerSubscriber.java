/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFromMany$WithLatestFromSubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableWithLatestFromMany$WithLatestInnerSubscriber
extends AtomicReference
implements o {
    private static final long serialVersionUID = 3256684027868224024L;
    public boolean hasValue;
    public final int index;
    public final FlowableWithLatestFromMany$WithLatestFromSubscriber parent;

    public FlowableWithLatestFromMany$WithLatestInnerSubscriber(FlowableWithLatestFromMany$WithLatestFromSubscriber withLatestFromSubscriber, int n10) {
        this.parent = withLatestFromSubscriber;
        this.index = n10;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        FlowableWithLatestFromMany$WithLatestFromSubscriber flowableWithLatestFromMany$WithLatestFromSubscriber = this.parent;
        int n10 = this.index;
        boolean bl2 = this.hasValue;
        flowableWithLatestFromMany$WithLatestFromSubscriber.innerComplete(n10, bl2);
    }

    public void onError(Throwable throwable) {
        FlowableWithLatestFromMany$WithLatestFromSubscriber flowableWithLatestFromMany$WithLatestFromSubscriber = this.parent;
        int n10 = this.index;
        flowableWithLatestFromMany$WithLatestFromSubscriber.innerError(n10, throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.hasValue;
        if (!bl2) {
            this.hasValue = bl2 = true;
        }
        FlowableWithLatestFromMany$WithLatestFromSubscriber flowableWithLatestFromMany$WithLatestFromSubscriber = this.parent;
        int n10 = this.index;
        flowableWithLatestFromMany$WithLatestFromSubscriber.innerNext(n10, object);
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

