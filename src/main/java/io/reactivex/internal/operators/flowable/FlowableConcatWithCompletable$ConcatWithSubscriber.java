/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.d;
import e.a.g;
import e.a.o;
import e.a.s0.b;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableConcatWithCompletable$ConcatWithSubscriber
extends AtomicReference
implements o,
d,
e {
    private static final long serialVersionUID = -7346385463600070225L;
    public final i.g.d downstream;
    public boolean inCompletable;
    public g other;
    public e upstream;

    public FlowableConcatWithCompletable$ConcatWithSubscriber(i.g.d d10, g g10) {
        this.downstream = d10;
        this.other = g10;
    }

    public void cancel() {
        this.upstream.cancel();
        DisposableHelper.dispose(this);
    }

    public void onComplete() {
        boolean bl2 = this.inCompletable;
        if (bl2) {
            i.g.d d10 = this.downstream;
            d10.onComplete();
        } else {
            this.inCompletable = bl2 = true;
            Object object = SubscriptionHelper.CANCELLED;
            this.upstream = object;
            object = this.other;
            this.other = null;
            object.f(this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
    }

    public void onSubscribe(b b10) {
        DisposableHelper.setOnce(this, b10);
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        this.upstream.request(l10);
    }
}

