/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.util.concurrent.atomic.AtomicLong;

public final class FlowableOnBackpressureError$BackpressureErrorSubscriber
extends AtomicLong
implements o,
e {
    private static final long serialVersionUID = -3176480756392482682L;
    public boolean done;
    public final d downstream;
    public e upstream;

    public FlowableOnBackpressureError$BackpressureErrorSubscriber(d d10) {
        this.downstream = d10;
    }

    public void cancel() {
        this.upstream.cancel();
    }

    public void onComplete() {
        boolean bl2 = this.done;
        if (bl2) {
            return;
        }
        this.done = true;
        this.downstream.onComplete();
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
        long l10;
        Object object2 = this.done;
        if (object2) {
            return;
        }
        long l11 = this.get();
        long l12 = l11 - (l10 = 0L);
        object2 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object2) {
            d d10 = this.downstream;
            d10.onNext(object);
            l11 = 1L;
            b.e(this, l11);
        } else {
            String string2 = "could not emit value due to lack of requests";
            object = new MissingBackpressureException(string2);
            this.onError((Throwable)object);
        }
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

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            b.a(this, l10);
        }
    }
}

