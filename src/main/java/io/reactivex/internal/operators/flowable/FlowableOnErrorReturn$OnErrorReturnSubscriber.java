/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;

public final class FlowableOnErrorReturn$OnErrorReturnSubscriber
extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = -3740826063558713822L;
    public final o valueSupplier;

    public FlowableOnErrorReturn$OnErrorReturnSubscriber(d d10, o o10) {
        super(d10);
        this.valueSupplier = o10;
    }

    public void onComplete() {
        this.downstream.onComplete();
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        try {
            object3 = this.valueSupplier;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            object2 = this.downstream;
            Throwable[] throwableArray = new Throwable[]{object, throwable};
            CompositeException compositeException = new CompositeException(throwableArray);
            object2.onError(compositeException);
            return;
        }
        object3 = object3.apply(object);
        object2 = "The valueSupplier returned a null value";
        object = a.g(object3, (String)object2);
        this.complete(object);
    }

    public void onNext(Object object) {
        long l10;
        this.produced = l10 = this.produced + 1L;
        this.downstream.onNext(object);
    }
}

