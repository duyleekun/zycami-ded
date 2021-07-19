/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.mixed;

import e.a.a1.a;
import e.a.l0;
import e.a.o0;
import e.a.v0.o;
import e.a.w0.i.b;
import i.g.d;
import i.g.e;
import io.reactivex.internal.operators.mixed.FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver;
import io.reactivex.internal.subscriptions.SubscriptionHelper;
import io.reactivex.internal.util.AtomicThrowable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableSwitchMapSingle$SwitchMapSingleSubscriber
extends AtomicInteger
implements e.a.o,
e {
    public static final FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver INNER_DISPOSED;
    private static final long serialVersionUID = -5402190102429853762L;
    public volatile boolean cancelled;
    public final boolean delayErrors;
    public volatile boolean done;
    public final d downstream;
    public long emitted;
    public final AtomicThrowable errors;
    public final AtomicReference inner;
    public final o mapper;
    public final AtomicLong requested;
    public e upstream;

    static {
        FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver;
        INNER_DISPOSED = flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver = new FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver(null);
    }

    public FlowableSwitchMapSingle$SwitchMapSingleSubscriber(d atomicReference, o o10, boolean bl2) {
        this.downstream = atomicReference;
        this.mapper = o10;
        this.delayErrors = bl2;
        atomicReference = new AtomicReference();
        this.errors = atomicReference;
        atomicReference = new AtomicReference();
        this.requested = atomicReference;
        this.inner = atomicReference = new AtomicReference();
    }

    public void cancel() {
        this.cancelled = true;
        this.upstream.cancel();
        this.disposeInner();
    }

    public void disposeInner() {
        AtomicReference atomicReference = this.inner;
        FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver = INNER_DISPOSED;
        if ((atomicReference = atomicReference.getAndSet(flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)) != null && atomicReference != flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver) {
            ((FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)atomicReference).dispose();
        }
    }

    public void drain() {
        int n10;
        int n11 = this.getAndIncrement();
        if (n11 != 0) {
            return;
        }
        d d10 = this.downstream;
        Serializable serializable = this.errors;
        AtomicReference atomicReference = this.inner;
        AtomicLong atomicLong = this.requested;
        long l10 = this.emitted;
        int n12 = n10 = 1;
        while (true) {
            long l11;
            long l12;
            boolean bl2;
            if (bl2 = this.cancelled) {
                return;
            }
            Object object = ((AtomicReference)serializable).get();
            if (object != null && !(bl2 = this.delayErrors)) {
                serializable = ((AtomicThrowable)serializable).terminate();
                d10.onError((Throwable)serializable);
                return;
            }
            bl2 = this.done;
            FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver = (FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)atomicReference.get();
            int n13 = flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver == null ? n10 : 0;
            if (bl2 && n13 != 0) {
                if ((serializable = ((AtomicThrowable)serializable).terminate()) != null) {
                    d10.onError((Throwable)serializable);
                } else {
                    d10.onComplete();
                }
                return;
            }
            if (n13 == 0 && (object = flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver.item) != null && (bl2 = (l12 = l10 - (l11 = atomicLong.get())) == 0L ? 0 : (l12 < 0L ? -1 : 1))) {
                bl2 = false;
                atomicReference.compareAndSet(flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver, null);
                object = flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver.item;
                d10.onNext(object);
                long l13 = 1L;
                l10 += l13;
                continue;
            }
            this.emitted = l10;
            n12 = -n12;
            if ((n12 = this.addAndGet(n12)) == 0) break;
        }
    }

    public void innerError(FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver object, Throwable throwable) {
        AtomicReference atomicReference = this.inner;
        boolean bl2 = atomicReference.compareAndSet(object, null);
        if (bl2 && (bl2 = ((AtomicThrowable)(object = this.errors)).addThrowable(throwable))) {
            bl2 = this.delayErrors;
            if (!bl2) {
                object = this.upstream;
                object.cancel();
                this.disposeInner();
            }
            this.drain();
            return;
        }
        a.Y(throwable);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onError(Throwable throwable) {
        AtomicThrowable atomicThrowable = this.errors;
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            boolean bl3 = this.delayErrors;
            if (!bl3) {
                this.disposeInner();
            }
            this.done = bl3 = true;
            this.drain();
        } else {
            a.Y(throwable);
        }
    }

    public void onNext(Object object) {
        AtomicReference atomicReference;
        FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver;
        Object object2 = (FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)this.inner.get();
        if (object2 != null) {
            ((FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)object2).dispose();
        }
        object2 = this.mapper;
        object = object2.apply(object);
        object2 = "The mapper returned a null SingleSource";
        object = e.a.w0.b.a.g(object, (String)object2);
        try {
            object = (o0)object;
            object2 = new FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver(this);
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            this.upstream.cancel();
            object2 = this.inner;
            FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver2 = INNER_DISPOSED;
            ((AtomicReference)object2).getAndSet(flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver2);
            this.onError(throwable);
            return;
        }
        while ((flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver = (FlowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver)this.inner.get()) != (atomicReference = INNER_DISPOSED)) {
            atomicReference = this.inner;
            boolean bl2 = atomicReference.compareAndSet(flowableSwitchMapSingle$SwitchMapSingleSubscriber$SwitchMapSingleObserver, object2);
            if (!bl2) continue;
            object.f((l0)object2);
            break;
        }
        return;
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
        b.a(this.requested, l10);
        this.drain();
    }
}

