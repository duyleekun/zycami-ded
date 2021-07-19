/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.l0;
import e.a.s0.b;
import e.a.v0.o;
import e.a.w0.b.a;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleFlatMapPublisher$SingleFlatMapPublisherObserver
extends AtomicLong
implements l0,
e.a.o,
e {
    private static final long serialVersionUID = 7759721921468635667L;
    public b disposable;
    public final d downstream;
    public final o mapper;
    public final AtomicReference parent;

    public SingleFlatMapPublisher$SingleFlatMapPublisherObserver(d atomicReference, o o10) {
        this.downstream = atomicReference;
        this.mapper = o10;
        this.parent = atomicReference = new AtomicReference();
    }

    public void cancel() {
        this.disposable.dispose();
        SubscriptionHelper.cancel(this.parent);
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

    public void onSubscribe(b b10) {
        this.disposable = b10;
        this.downstream.onSubscribe(this);
    }

    public void onSubscribe(e e10) {
        SubscriptionHelper.deferredSetOnce(this.parent, this, e10);
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
        object2 = "the mapper returned a null Publisher";
        object = a.g(object, (String)object2);
        ((c)object).subscribe(this);
    }

    public void request(long l10) {
        SubscriptionHelper.deferredRequest(this.parent, this, l10);
    }
}

