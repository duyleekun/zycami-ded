/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.d;
import e.a.o;
import e.a.s0.b;
import i.g.c;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableAndThenPublisher$AndThenPublisherSubscriber
extends AtomicReference
implements o,
d,
e {
    private static final long serialVersionUID = -8948264376121066672L;
    public final i.g.d downstream;
    public c other;
    public final AtomicLong requested;
    public b upstream;

    public CompletableAndThenPublisher$AndThenPublisherSubscriber(i.g.d object, c c10) {
        this.downstream = object;
        this.other = c10;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        Object object = this.other;
        if (object == null) {
            object = this.downstream;
            object.onComplete();
        } else {
            this.other = null;
            object.subscribe(this);
        }
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        this.downstream.onNext(object);
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

    public void onSubscribe(e e10) {
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredSetOnce(this, atomicLong, e10);
    }

    public void request(long l10) {
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(this, atomicLong, l10);
    }
}

