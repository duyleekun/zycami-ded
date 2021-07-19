/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.a1.a;
import e.a.g0;
import e.a.h0;
import e.a.s0.b;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.operators.observable.ObservableUnsubscribeOn$UnsubscribeObserver$a;
import java.util.concurrent.atomic.AtomicBoolean;

public final class ObservableUnsubscribeOn$UnsubscribeObserver
extends AtomicBoolean
implements g0,
b {
    private static final long serialVersionUID = 1015244841293359600L;
    public final g0 downstream;
    public final h0 scheduler;
    public b upstream;

    public ObservableUnsubscribeOn$UnsubscribeObserver(g0 g02, h0 h02) {
        this.downstream = g02;
        this.scheduler = h02;
    }

    public void dispose() {
        h0 h02 = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            h02 = this.scheduler;
            ObservableUnsubscribeOn$UnsubscribeObserver$a observableUnsubscribeOn$UnsubscribeObserver$a = new ObservableUnsubscribeOn$UnsubscribeObserver$a(this);
            h02.e(observableUnsubscribeOn$UnsubscribeObserver$a);
        }
    }

    public boolean isDisposed() {
        return this.get();
    }

    public void onComplete() {
        boolean bl2 = this.get();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.get();
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.get();
        if (!bl2) {
            g0 g02 = this.downstream;
            g02.onNext(object);
        }
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
}

