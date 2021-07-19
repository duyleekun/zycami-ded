/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeConcatArray$ConcatMaybeObserver
extends AtomicInteger
implements t,
e {
    private static final long serialVersionUID = 3520831347801429610L;
    public final AtomicReference current;
    public final SequentialDisposable disposables;
    public final d downstream;
    public int index;
    public long produced;
    public final AtomicLong requested;
    public final w[] sources;

    public MaybeConcatArray$ConcatMaybeObserver(d atomicReference, w[] object) {
        this.downstream = atomicReference;
        this.sources = object;
        atomicReference = new AtomicReference<w[]>();
        this.requested = atomicReference;
        atomicReference = new AtomicReference<w[]>();
        this.disposables = atomicReference;
        object = NotificationLite.COMPLETE;
        this.current = atomicReference = new AtomicReference<w[]>((w[])object);
    }

    public void cancel() {
        this.disposables.dispose();
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        AtomicReference atomicReference = this.current;
        d d10 = this.downstream;
        SequentialDisposable sequentialDisposable = this.disposables;
        do {
            Object object;
            n10 = sequentialDisposable.isDisposed();
            w[] wArray = null;
            if (n10 != 0) {
                atomicReference.lazySet(null);
                return;
            }
            Object object2 = atomicReference.get();
            if (object2 == null) continue;
            Object object3 = NotificationLite.COMPLETE;
            boolean bl2 = true;
            if (object2 != object3) {
                long l10 = this.produced;
                object3 = this.requested;
                long l11 = ((AtomicLong)object3).get();
                long l12 = l10 - l11;
                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object != false) {
                    l11 = 1L;
                    this.produced = l10 += l11;
                    atomicReference.lazySet(null);
                    d10.onNext(object2);
                } else {
                    n10 = 0;
                    object2 = null;
                    bl2 = false;
                }
            } else {
                atomicReference.lazySet(null);
            }
            if (!bl2 || (n10 = (int)(sequentialDisposable.isDisposed() ? 1 : 0)) != 0) continue;
            n10 = this.index;
            wArray = this.sources;
            object = wArray.length;
            if (n10 == object) {
                d10.onComplete();
                return;
            }
            object = n10 + 1;
            this.index = (int)object;
            object2 = wArray[n10];
            object2.g(this);
        } while ((n10 = this.decrementAndGet()) != 0);
    }

    public void onComplete() {
        AtomicReference atomicReference = this.current;
        NotificationLite notificationLite = NotificationLite.COMPLETE;
        atomicReference.lazySet(notificationLite);
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.downstream.onError(throwable);
    }

    public void onSubscribe(e.a.s0.b b10) {
        this.disposables.replace(b10);
    }

    public void onSuccess(Object object) {
        this.current.lazySet(object);
        this.drain();
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}

