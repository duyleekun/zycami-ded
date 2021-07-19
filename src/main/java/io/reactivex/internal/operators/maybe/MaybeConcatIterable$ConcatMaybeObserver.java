/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.t;
import e.a.w;
import e.a.w0.b.a;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.disposables.SequentialDisposable;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeConcatIterable$ConcatMaybeObserver
extends AtomicInteger
implements t,
e {
    private static final long serialVersionUID = 3520831347801429610L;
    public final AtomicReference current;
    public final SequentialDisposable disposables;
    public final d downstream;
    public long produced;
    public final AtomicLong requested;
    public final Iterator sources;

    public MaybeConcatIterable$ConcatMaybeObserver(d atomicReference, Iterator object) {
        this.downstream = atomicReference;
        this.sources = object;
        atomicReference = new AtomicReference<Iterator>();
        this.requested = atomicReference;
        atomicReference = new AtomicReference<Iterator>();
        this.disposables = atomicReference;
        object = NotificationLite.COMPLETE;
        this.current = atomicReference = new AtomicReference<Iterator>((Iterator)object);
    }

    public void cancel() {
        this.disposables.dispose();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
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
            block12: {
                n10 = sequentialDisposable.isDisposed();
                String string2 = null;
                if (n10 != 0) {
                    atomicReference.lazySet(null);
                    return;
                }
                Object object = atomicReference.get();
                if (object == null) continue;
                Object object2 = NotificationLite.COMPLETE;
                boolean bl2 = true;
                if (object != object2) {
                    long l10 = this.produced;
                    object2 = this.requested;
                    long l11 = ((AtomicLong)object2).get();
                    long l12 = l10 - l11;
                    Object object3 = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                    if (object3 != false) {
                        l11 = 1L;
                        this.produced = l10 += l11;
                        atomicReference.lazySet(null);
                        d10.onNext(object);
                    } else {
                        n10 = 0;
                        object = null;
                        bl2 = false;
                    }
                } else {
                    atomicReference.lazySet(null);
                }
                if (!bl2 || (n10 = (int)(sequentialDisposable.isDisposed() ? 1 : 0)) != 0) continue;
                try {
                    object = this.sources;
                    n10 = (int)(object.hasNext() ? 1 : 0);
                    if (n10 == 0) break block12;
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    d10.onError(throwable);
                    return;
                }
                try {
                    object = this.sources;
                    object = object.next();
                    string2 = "The source Iterator returned a null MaybeSource";
                    object = a.g(object, string2);
                    object = (w)object;
                    object.g(this);
                }
                catch (Throwable throwable) {
                    e.a.t0.a.b(throwable);
                    d10.onError(throwable);
                    return;
                }
            }
            d10.onComplete();
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

