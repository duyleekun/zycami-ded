/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.s0.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableTimer$TimerSubscriber
extends AtomicReference
implements e,
Runnable {
    private static final long serialVersionUID = -2809475196591179431L;
    public final d downstream;
    public volatile boolean requested;

    public FlowableTimer$TimerSubscriber(d d10) {
        this.downstream = d10;
    }

    public void cancel() {
        DisposableHelper.dispose(this);
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            this.requested = bl2 = true;
        }
    }

    public void run() {
        Object object;
        Object object2 = this.get();
        if (object2 != (object = DisposableHelper.DISPOSED)) {
            boolean bl2 = this.requested;
            if (bl2) {
                object2 = this.downstream;
                long l10 = 0L;
                object = l10;
                object2.onNext(object);
                object2 = EmptyDisposable.INSTANCE;
                this.lazySet(object2);
                object2 = this.downstream;
                object2.onComplete();
            } else {
                object2 = EmptyDisposable.INSTANCE;
                this.lazySet(object2);
                object2 = this.downstream;
                String string2 = "Can't deliver value due to lack of requests";
                object = new MissingBackpressureException(string2);
                object2.onError((Throwable)object);
            }
        }
    }

    public void setResource(b b10) {
        DisposableHelper.trySet(this, b10);
    }
}

