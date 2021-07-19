/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber
extends AtomicReference
implements o,
b {
    private static final long serialVersionUID = -8498650778633225126L;
    public final FlowableBufferBoundary$BufferBoundarySubscriber parent;

    public FlowableBufferBoundary$BufferBoundarySubscriber$BufferOpenSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber bufferBoundarySubscriber) {
        this.parent = bufferBoundarySubscriber;
    }

    public void dispose() {
        SubscriptionHelper.cancel(this);
    }

    public boolean isDisposed() {
        boolean bl2;
        SubscriptionHelper subscriptionHelper;
        Object v10 = this.get();
        if (v10 == (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void onComplete() {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.lazySet(subscriptionHelper);
        this.parent.openComplete(this);
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper = SubscriptionHelper.CANCELLED;
        this.lazySet(subscriptionHelper);
        this.parent.boundaryError(this, throwable);
    }

    public void onNext(Object object) {
        this.parent.open(object);
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

