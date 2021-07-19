/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.processors.UnicastProcessor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableWindow$WindowSkipSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    private static final long serialVersionUID = -8792836352386833856L;
    public final int bufferSize;
    public final d downstream;
    public final AtomicBoolean firstRequest;
    public long index;
    public final AtomicBoolean once;
    public final long size;
    public final long skip;
    public e upstream;
    public UnicastProcessor window;

    public FlowableWindow$WindowSkipSubscriber(d object, long l10, long l11, int n10) {
        super(1);
        this.downstream = object;
        this.size = l10;
        this.skip = l11;
        this.once = object = new AtomicBoolean();
        this.firstRequest = object = new AtomicBoolean();
        this.bufferSize = n10;
    }

    public void cancel() {
        AtomicBoolean atomicBoolean = this.once;
        boolean bl2 = true;
        boolean bl3 = atomicBoolean.compareAndSet(false, bl2);
        if (bl3) {
            this.run();
        }
    }

    public void onComplete() {
        UnicastProcessor unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.downstream.onComplete();
    }

    public void onError(Throwable throwable) {
        UnicastProcessor unicastProcessor = this.window;
        if (unicastProcessor != null) {
            this.window = null;
            unicastProcessor.onError(throwable);
        }
        this.downstream.onError(throwable);
    }

    public void onNext(Object object) {
        long l10;
        long l11;
        long l12;
        long l13 = this.index;
        UnicastProcessor unicastProcessor = this.window;
        long l14 = 0L;
        long l15 = l13 - l14;
        Object object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        if (object2 == false) {
            this.getAndIncrement();
            int n10 = this.bufferSize;
            this.window = unicastProcessor = UnicastProcessor.S8(n10, this);
            d d10 = this.downstream;
            d10.onNext(unicastProcessor);
        }
        long l16 = 1L;
        l13 += l16;
        if (unicastProcessor != null) {
            unicastProcessor.onNext(object);
        }
        if ((l12 = (l11 = l13 - (l16 = this.size)) == 0L ? 0 : (l11 < 0L ? -1 : 1)) == false) {
            l12 = 0;
            object = null;
            this.window = null;
            unicastProcessor.onComplete();
        }
        this.index = (l12 = (l10 = l13 - (l16 = this.skip)) == 0L ? 0 : (l10 < 0L ? -1 : 1)) == false ? l14 : l13;
    }

    public void onSubscribe(e object) {
        e e10 = this.upstream;
        boolean bl2 = SubscriptionHelper.validate(e10, (e)object);
        if (bl2) {
            this.upstream = object;
            object = this.downstream;
            object.onSubscribe(this);
        }
    }

    public void request(long l10) {
        boolean bl2 = SubscriptionHelper.validate(l10);
        if (bl2) {
            boolean bl3;
            Object object = this.firstRequest;
            bl2 = ((AtomicBoolean)object).get();
            if (!bl2 && (bl2 = ((AtomicBoolean)(object = this.firstRequest)).compareAndSet(false, bl3 = true))) {
                long l11 = b.d(this.size, l10);
                long l12 = this.skip;
                long l13 = this.size;
                l12 -= l13;
                l13 = 1L;
                l10 -= l13;
                l10 = b.d(l12, l10);
                l10 = b.c(l11, l10);
                object = this.upstream;
                object.request(l10);
            } else {
                long l14 = this.skip;
                l10 = b.d(l14, l10);
                object = this.upstream;
                object.request(l10);
            }
        }
    }

    public void run() {
        int n10 = this.decrementAndGet();
        if (n10 == 0) {
            e e10 = this.upstream;
            e10.cancel();
        }
    }
}

