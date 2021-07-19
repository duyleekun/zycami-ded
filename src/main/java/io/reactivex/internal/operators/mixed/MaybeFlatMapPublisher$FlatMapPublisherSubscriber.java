/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.s0.b;
import e.a.t;
import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeFlatMapPublisher$FlatMapPublisherSubscriber
extends AtomicReference
implements e.a.o,
t,
e {
    private static final long serialVersionUID = -8948264376121066672L;
    public final d downstream;
    public final o mapper;
    public final AtomicLong requested;
    public b upstream;

    public MaybeFlatMapPublisher$FlatMapPublisherSubscriber(d object, o o10) {
        this.downstream = object;
        this.mapper = o10;
        this.requested = object = new AtomicLong();
    }

    public void cancel() {
        this.upstream.dispose();
        SubscriptionHelper.cancel(this);
    }

    public void onComplete() {
        this.downstream.onComplete();
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

    public void onSuccess(Object object) {
        Object object2;
        try {
            object2 = this.mapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The mapper returned a null Publisher";
        object = a.g(object, (String)object2);
        ((c)object).subscribe(this);
    }

    public void request(long l10) {
        AtomicLong atomicLong = this.requested;
        SubscriptionHelper.deferredRequest(this, atomicLong, l10);
    }
}

