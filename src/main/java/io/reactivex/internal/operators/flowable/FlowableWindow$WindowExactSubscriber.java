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

public final class FlowableWindow$WindowExactSubscriber
extends AtomicInteger
implements o,
e,
Runnable {
    private static final long serialVersionUID = -2365647875069161133L;
    public final int bufferSize;
    public final d downstream;
    public long index;
    public final AtomicBoolean once;
    public final long size;
    public e upstream;
    public UnicastProcessor window;

    public FlowableWindow$WindowExactSubscriber(d object, long l10, int n10) {
        super(1);
        this.downstream = object;
        this.size = l10;
        this.once = object = new AtomicBoolean();
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
        long l11 = this.index;
        UnicastProcessor unicastProcessor = this.window;
        long l12 = 0L;
        long l13 = l11 - l12;
        Object object2 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
        if (object2 == false) {
            this.getAndIncrement();
            int n10 = this.bufferSize;
            this.window = unicastProcessor = UnicastProcessor.S8(n10, this);
            d d10 = this.downstream;
            d10.onNext(unicastProcessor);
        }
        unicastProcessor.onNext(object);
        long l14 = this.size;
        long l15 = (l10 = ++l11 - l14) == 0L ? 0 : (l10 < 0L ? -1 : 1);
        if (l15 == false) {
            this.index = l12;
            l15 = 0;
            object = null;
            this.window = null;
            unicastProcessor.onComplete();
        } else {
            this.index = l11;
        }
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
            long l11 = this.size;
            l10 = b.d(l11, l10);
            e e10 = this.upstream;
            e10.request(l10);
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

