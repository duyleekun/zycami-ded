/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber;

public final class FlowableRetryWhen$RetryWhenSubscriber
extends FlowableRepeatWhen$WhenSourceSubscriber {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRetryWhen$RetryWhenSubscriber(d d10, a a10, e e10) {
        super(d10, a10, e10);
    }

    public void onComplete() {
        this.receiver.cancel();
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        this.again(throwable);
    }
}

