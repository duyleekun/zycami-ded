/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom;
import io.reactivex.internal.operators.flowable.FlowableWithLatestFrom$WithLatestFromSubscriber;

public final class FlowableWithLatestFrom$a
implements o {
    private final FlowableWithLatestFrom$WithLatestFromSubscriber a;
    public final /* synthetic */ FlowableWithLatestFrom b;

    public FlowableWithLatestFrom$a(FlowableWithLatestFrom flowableWithLatestFrom, FlowableWithLatestFrom$WithLatestFromSubscriber withLatestFromSubscriber) {
        this.b = flowableWithLatestFrom;
        this.a = withLatestFromSubscriber;
    }

    public void onComplete() {
    }

    public void onError(Throwable throwable) {
        this.a.otherError(throwable);
    }

    public void onNext(Object object) {
        this.a.lazySet(object);
    }

    public void onSubscribe(e e10) {
        FlowableWithLatestFrom$WithLatestFromSubscriber flowableWithLatestFrom$WithLatestFromSubscriber = this.a;
        boolean bl2 = flowableWithLatestFrom$WithLatestFromSubscriber.setOther(e10);
        if (bl2) {
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

