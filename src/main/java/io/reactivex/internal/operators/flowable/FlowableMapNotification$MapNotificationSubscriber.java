/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.v0.o;
import e.a.w0.b.a;
import i.g.d;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscribers.SinglePostCompleteSubscriber;
import java.util.concurrent.Callable;

public final class FlowableMapNotification$MapNotificationSubscriber
extends SinglePostCompleteSubscriber {
    private static final long serialVersionUID = 2757120512858778108L;
    public final Callable onCompleteSupplier;
    public final o onErrorMapper;
    public final o onNextMapper;

    public FlowableMapNotification$MapNotificationSubscriber(d d10, o o10, o o11, Callable callable) {
        super(d10);
        this.onNextMapper = o10;
        this.onErrorMapper = o11;
        this.onCompleteSupplier = callable;
    }

    public void onComplete() {
        Object object;
        try {
            object = this.onCompleteSupplier;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        object = object.call();
        String string2 = "The onComplete publisher returned is null";
        object = a.g(object, string2);
        this.complete(object);
    }

    public void onError(Throwable object) {
        Object object2;
        Object object3;
        try {
            object3 = this.onErrorMapper;
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
        object2 = "The onError publisher returned is null";
        object = a.g(object3, (String)object2);
        this.complete(object);
    }

    public void onNext(Object object) {
        long l10;
        Object object2;
        try {
            object2 = this.onNextMapper;
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.downstream.onError(throwable);
            return;
        }
        object = object2.apply(object);
        object2 = "The onNext publisher returned is null";
        object = a.g(object, (String)object2);
        this.produced = l10 = this.produced + 1L;
        this.downstream.onNext(object);
    }
}

