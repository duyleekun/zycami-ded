/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableOnBackpressureLatest$BackpressureLatestSubscriber
extends AtomicInteger
implements o,
e {
    private static final long serialVersionUID = 163080509307634843L;
    public volatile boolean cancelled;
    public final AtomicReference current;
    public volatile boolean done;
    public final d downstream;
    public Throwable error;
    public final AtomicLong requested;
    public e upstream;

    public FlowableOnBackpressureLatest$BackpressureLatestSubscriber(d d10) {
        Serializable serializable;
        this.requested = serializable = new AtomicLong();
        this.current = serializable;
        this.downstream = d10;
    }

    public void cancel() {
        int n10 = this.cancelled;
        if (n10 == 0) {
            this.cancelled = true;
            Object object = this.upstream;
            object.cancel();
            n10 = this.getAndIncrement();
            if (n10 == 0) {
                object = this.current;
                ((AtomicReference)object).lazySet(null);
            }
        }
    }

    public boolean checkTerminated(boolean bl2, boolean bl3, d d10, AtomicReference atomicReference) {
        boolean bl4 = this.cancelled;
        boolean bl5 = true;
        if (bl4) {
            atomicReference.lazySet(null);
            return bl5;
        }
        if (bl2) {
            Throwable throwable = this.error;
            if (throwable != null) {
                atomicReference.lazySet(null);
                d10.onError(throwable);
                return bl5;
            }
            if (bl3) {
                d10.onComplete();
                return bl5;
            }
        }
        return false;
    }

    public void drain() {
        boolean bl2;
        int n10 = this.getAndIncrement();
        if (n10 != 0) {
            return;
        }
        d d10 = this.downstream;
        AtomicLong atomicLong = this.requested;
        AtomicReference atomicReference = this.current;
        boolean bl3 = bl2 = true;
        do {
            long l10;
            long l11;
            long l12;
            Object var15_12;
            boolean bl4;
            long l13;
            long l14;
            long l15 = l14 = 0L;
            while (true) {
                long l16 = atomicLong.get();
                l13 = l15 == l16 ? 0 : (l15 < l16 ? -1 : 1);
                bl4 = false;
                if (l13 == false) break;
                l13 = (long)this.done;
                var15_12 = atomicReference.getAndSet(null);
                boolean bl5 = var15_12 == null ? bl2 : false;
                if ((l13 = (long)this.checkTerminated((boolean)l13, bl5, d10, atomicReference)) != false) {
                    return;
                }
                if (bl5) break;
                d10.onNext(var15_12);
                l16 = 1L;
                l15 += l16;
            }
            if ((l13 = (l12 = l15 - (l11 = atomicLong.get())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) == false) {
                l13 = (long)this.done;
                var15_12 = atomicReference.get();
                if (var15_12 == null) {
                    bl4 = bl2;
                }
                if ((l13 = (long)this.checkTerminated((boolean)l13, bl4, d10, atomicReference)) != false) {
                    return;
                }
            }
            if ((l10 = l15 == l14 ? 0 : (l15 < l14 ? -1 : 1)) != false) {
                b.e(atomicLong, l15);
            }
            bl3 = -bl3;
        } while (bl3 = this.addAndGet((int)(bl3 ? 1 : 0)));
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        this.error = throwable;
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        this.current.lazySet(object);
        this.drain();
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
            AtomicLong atomicLong = this.requested;
            b.a(atomicLong, l10);
            this.drain();
        }
    }
}

