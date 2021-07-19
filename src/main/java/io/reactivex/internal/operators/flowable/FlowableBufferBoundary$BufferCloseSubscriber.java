/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableBufferBoundary$BufferBoundarySubscriber;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableBufferBoundary$BufferCloseSubscriber
extends AtomicReference
implements o,
b {
    private static final long serialVersionUID = -8498650778633225126L;
    public final long index;
    public final FlowableBufferBoundary$BufferBoundarySubscriber parent;

    public FlowableBufferBoundary$BufferCloseSubscriber(FlowableBufferBoundary$BufferBoundarySubscriber flowableBufferBoundary$BufferBoundarySubscriber, long l10) {
        this.parent = flowableBufferBoundary$BufferBoundarySubscriber;
        this.index = l10;
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
        SubscriptionHelper subscriptionHelper;
        Object object = this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object = this.parent;
            long l10 = this.index;
            ((FlowableBufferBoundary$BufferBoundarySubscriber)object).close(this, l10);
        }
    }

    public void onError(Throwable throwable) {
        SubscriptionHelper subscriptionHelper;
        Object object = this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object = this.parent;
            ((FlowableBufferBoundary$BufferBoundarySubscriber)object).boundaryError(this, throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        SubscriptionHelper subscriptionHelper;
        object = (e)this.get();
        if (object != (subscriptionHelper = SubscriptionHelper.CANCELLED)) {
            this.lazySet(subscriptionHelper);
            object.cancel();
            object = this.parent;
            long l10 = this.index;
            ((FlowableBufferBoundary$BufferBoundarySubscriber)object).close(this, l10);
        }
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.setOnce(this, e10, Long.MAX_VALUE);
    }
}

