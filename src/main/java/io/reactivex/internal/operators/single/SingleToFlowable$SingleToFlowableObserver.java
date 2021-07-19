/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import i.g.d;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;

public final class SingleToFlowable$SingleToFlowableObserver
extends DeferredScalarSubscription
implements l0 {
    private static final long serialVersionUID = 187782011903685568L;
    public b upstream;

    public SingleToFlowable$SingleToFlowableObserver(d d10) {
        super(d10);
    }

    public void cancel() {
        super.cancel();
        this.upstream.dispose();
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

