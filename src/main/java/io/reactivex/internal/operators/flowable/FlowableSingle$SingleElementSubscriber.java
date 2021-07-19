/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.DeferredScalarSubscription;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.NoSuchElementException;

public final class FlowableSingle$SingleElementSubscriber
extends DeferredScalarSubscription
implements o {
    private static final long serialVersionUID = -5526049321428043809L;
    public final Object defaultValue;
    public boolean done;
    public final boolean failOnEmpty;
    public e upstream;

    public FlowableSingle$SingleElementSubscriber(d d10, Object object, boolean bl2) {
        super(d10);
        this.defaultValue = object;
        this.failOnEmpty = bl2;
    }

    public void cancel() {
        super.cancel();
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        Object object = this.value;
        NoSuchElementException noSuchElementException = null;
        this.value = null;
        if (object == null) {
            object = this.defaultValue;
        }
        if (object == null) {
            bl2 = this.failOnEmpty;
            if (bl2) {
                object = this.downstream;
                noSuchElementException = new NoSuchElementException();
                object.onError(noSuchElementException);
            } else {
                object = this.downstream;
                object.onComplete();
            }
        } else {
            this.complete(object);
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.done;
        if (bl2) {
            a.Y(throwable);
            return;
        }
        this.done = true;
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        Object object2 = this.value;
        if (object2 != null) {
            this.done = true;
            this.upstream.cancel();
            object = this.downstream;
            object2 = new IllegalArgumentException("Sequence contains more than one element!");
            object.onError((Throwable)object2);
            return;
        }
        this.value = object;
    }

    public void onSubscribe(e e10) {
        Object object = this.upstream;
        boolean bl2 = SubscriptionHelper.validate((e)object, e10);
        if (bl2) {
            this.upstream = e10;
            object = this.downstream;
            object.onSubscribe(this);
            long l10 = Long.MAX_VALUE;
            e10.request(l10);
        }
    }
}

