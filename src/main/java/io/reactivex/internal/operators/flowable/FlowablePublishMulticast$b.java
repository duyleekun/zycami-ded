/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.flowable.FlowablePublishMulticast$a;
import io.reactivex.internal.subscriptions.SubscriptionHelper;

public final class FlowablePublishMulticast$b
implements o,
e {
    public final d a;
    public final FlowablePublishMulticast$a b;
    public e c;

    public FlowablePublishMulticast$b(d d10, FlowablePublishMulticast$a flowablePublishMulticast$a) {
        this.a = d10;
        this.b = flowablePublishMulticast$a;
    }

    public void cancel() {
        this.c.cancel();
        this.b.dispose();
    }

    public void onComplete() {
        this.a.onComplete();
        this.b.dispose();
    }

    public void onError(Throwable throwable) {
        this.a.onError(throwable);
        this.b.dispose();
    }

    public void onNext(Object object) {
        this.a.onNext(object);
    }

    public void onSubscribe(e object) {
        e e10 = this.c;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.c = object;
            object = this.a;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.c.request(l10);
    }
}

