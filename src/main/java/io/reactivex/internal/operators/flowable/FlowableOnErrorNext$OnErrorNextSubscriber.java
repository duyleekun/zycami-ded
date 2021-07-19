/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.v0.o;
import i.g.c;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.CompositeException;
import io.reactivex.internal.subscriptions.SubscriptionArbiter;

public final class FlowableOnErrorNext$OnErrorNextSubscriber
extends SubscriptionArbiter
implements e.a.o {
    private static final long serialVersionUID = 4063763155303814625L;
    public final boolean allowFatal;
    public boolean done;
    public final d downstream;
    public final o nextSupplier;
    public boolean once;
    public long produced;

    public FlowableOnErrorNext$OnErrorNextSubscriber(d d10, o o10, boolean bl2) {
        super(false);
        this.downstream = d10;
        this.nextSupplier = o10;
        this.allowFatal = bl2;
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = bl2 = true;
        this.once = bl2;
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        Object object;
        Object object2;
        int n10 = (int)(this.once ? 1 : 0);
        if (n10 != 0) {
            n10 = this.done;
            if (n10 != 0) {
                a.Y(throwable);
                return;
            }
            this.downstream.onError(throwable);
            return;
        }
        n10 = 1;
        this.once = n10;
        boolean bl2 = this.allowFatal;
        if (bl2 && !(bl2 = throwable instanceof Exception)) {
            this.downstream.onError(throwable);
            return;
        }
        try {
            object2 = this.nextSupplier;
        }
        catch (Throwable throwable2) {
            e.a.t0.a.b(throwable2);
            object = this.downstream;
            Throwable[] throwableArray = new Throwable[2];
            throwableArray[0] = throwable;
            throwableArray[n10] = throwable2;
            CompositeException compositeException = new CompositeException(throwableArray);
            object.onError(compositeException);
            return;
        }
        object2 = object2.apply(throwable);
        object = "The nextSupplier returned a null Publisher";
        object2 = e.a.w0.b.a.g(object2, (String)object);
        object2 = (c)object2;
        long l10 = this.produced;
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 != false) {
            this.produced(l10);
        }
        object2.subscribe(this);
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        bl2 = this.once;
        if (!bl2) {
            long l10 = this.produced;
            long l11 = 1L;
            this.produced = l10 += l11;
        }
        this.downstream.onNext(object);
    }

    public void onSubscribe(e e10) {
        this.setSubscription(e10);
    }
}

