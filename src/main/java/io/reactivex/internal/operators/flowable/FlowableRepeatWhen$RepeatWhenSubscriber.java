/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.b1.a;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableRepeatWhen$WhenSourceSubscriber;

public final class FlowableRepeatWhen$RepeatWhenSubscriber
extends FlowableRepeatWhen$WhenSourceSubscriber {
    private static final long serialVersionUID = -2680129890138081029L;

    public FlowableRepeatWhen$RepeatWhenSubscriber(d d10, a a10, e e10) {
        super(d10, a10, e10);
    }

    public void onComplete() {
        Integer n10 = 0;
        this.again(n10);
    }

    public void onError(Throwable throwable) {
        this.receiver.cancel();
        this.downstream.onError(throwable);
    }
}

