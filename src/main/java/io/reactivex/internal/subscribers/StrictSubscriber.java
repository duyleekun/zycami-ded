/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.subscribers;

import e.a.o;
import e.a.w0.i.g;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public class StrictSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = -4945028590049415624L;
    public volatile boolean done;
    public final d downstream;
    public final AtomicThrowable error;
    public final AtomicBoolean once;
    public final AtomicLong requested;
    public final AtomicReference upstream;

    public StrictSubscriber(d serializable) {
        this.downstream = serializable;
        serializable = new Serializable();
        this.error = serializable;
        serializable = new Serializable();
        this.requested = serializable;
        this.upstream = serializable = new Serializable();
        this.once = serializable;
    }

    public void cancel() {
        boolean bl2 = this.done;
        if (!bl2) {
            AtomicReference atomicReference = this.upstream;
            SubscriptionHelper.cancel(atomicReference);
        }
    }

    public void onComplete() {
        this.done = true;
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.b(d10, this, atomicThrowable);
    }

    public void onError(Throwable throwable) {
        this.done = true;
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.d(d10, throwable, this, atomicThrowable);
    }

    public void onNext(Object object) {
        d d10 = this.downstream;
        AtomicThrowable atomicThrowable = this.error;
        g.f(d10, object, this, atomicThrowable);
    }

    public void onSubscribe(e object) {
        Object object2 = this.once;
        AtomicLong atomicLong = null;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object2).compareAndSet(false, bl2);
        if (bl3) {
            this.downstream.onSubscribe(this);
            object2 = this.upstream;
            atomicLong = this.requested;
            SubscriptionHelper.deferredSetOnce((AtomicReference)object2, atomicLong, (e)object);
        } else {
            object.cancel();
            this.cancel();
            object2 = "\u00a72.12 violated: onSubscribe must be called at most once";
            object = new IllegalStateException((String)object2);
            this.onError((Throwable)object);
        }
    }

    public void request(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object <= 0) {
            this.cancel();
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "\u00a73.9 violated: positive request amount required but it was ";
            stringBuilder.append(string2);
            stringBuilder.append(l10);
            String string3 = stringBuilder.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
            this.onError(illegalArgumentException);
        } else {
            AtomicReference atomicReference = this.upstream;
            AtomicLong atomicLong = this.requested;
            SubscriptionHelper.deferredRequest(atomicReference, atomicLong, l10);
        }
    }
}

