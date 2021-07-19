/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.s0.b;
import e.a.t;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

public final class MaybeToFlowable$MaybeToFlowableSubscriber
extends DeferredScalarSubscription
implements t {
    private static final long serialVersionUID = 7603343402964826922L;
    public b upstream;

    public MaybeToFlowable$MaybeToFlowableSubscriber(d d10) {
        super(d10);
    }

    public void cancel() {
        super.cancel();
        this.upstream.dispose();
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(b object) {
        b b10 = this.upstream;
        boolean bl2 = DisposableHelper.validate(b10, (b)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void onSuccess(Object object) {
        this.complete(object);
    }
}

