/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.processors;

import e.a.a1.a;
import i.g.d;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.processors.AsyncProcessor;

public final class AsyncProcessor$AsyncSubscription
extends DeferredScalarSubscription {
    private static final long serialVersionUID = 5629876084736248016L;
    public final AsyncProcessor parent;

    public AsyncProcessor$AsyncSubscription(d d10, AsyncProcessor asyncProcessor) {
        super(d10);
        this.parent = asyncProcessor;
    }

    public void cancel() {
        boolean bl2 = super.tryCancel();
        if (bl2) {
            AsyncProcessor asyncProcessor = this.parent;
            asyncProcessor.V8(this);
        }
    }

    public void onComplete() {
        boolean bl2 = this.isCancelled();
        if (!bl2) {
            d d10 = this.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.isCancelled();
        if (bl2) {
            a.Y(throwable);
        } else {
            d d10 = this.downstream;
            d10.onError(throwable);
        }
    }
}

