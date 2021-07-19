/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class FlowableCreate$LatestAsyncEmitter
extends FlowableCreate$BaseEmitter {
    private static final long serialVersionUID = 4023437720691792495L;
    public volatile boolean done;
    public Throwable error;
    public final AtomicReference queue;
    public final AtomicInteger wip;

    public FlowableCreate$LatestAsyncEmitter(d serializable) {
        super((d)((Object)serializable));
        this.queue = serializable = new Serializable();
        super();
        this.wip = serializable;
    }

    public void drain() {
        AtomicInteger atomicInteger;
        int n10;
        FlowableCreate$LatestAsyncEmitter flowableCreate$LatestAsyncEmitter = this;
        Object object = this.wip;
        int n11 = ((AtomicInteger)object).getAndIncrement();
        if (n11 != 0) {
            return;
        }
        object = this.downstream;
        AtomicReference atomicReference = this.queue;
        int n12 = n10 = 1;
        do {
            boolean bl2;
            int n13;
            long l10;
            long l11;
            long l12 = this.get();
            long l13 = l11 = 0L;
            while (true) {
                l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1);
                n13 = 0;
                if (l10 == false) break;
                boolean bl3 = this.isCancelled();
                if (bl3) {
                    atomicReference.lazySet(null);
                    return;
                }
                bl3 = flowableCreate$LatestAsyncEmitter.done;
                Object var16_13 = atomicReference.getAndSet(null);
                int n14 = var16_13 == null ? n10 : 0;
                if (bl3 && n14 != 0) {
                    object = flowableCreate$LatestAsyncEmitter.error;
                    if (object != null) {
                        flowableCreate$LatestAsyncEmitter.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
                if (n14 != 0) break;
                object.onNext(var16_13);
                long l14 = 1L;
                l13 += l14;
            }
            if (l10 == false) {
                bl2 = this.isCancelled();
                if (bl2) {
                    atomicReference.lazySet(null);
                    return;
                }
                bl2 = flowableCreate$LatestAsyncEmitter.done;
                Object v10 = atomicReference.get();
                if (v10 == null) {
                    n13 = n10;
                }
                if (bl2 && n13 != 0) {
                    object = flowableCreate$LatestAsyncEmitter.error;
                    if (object != null) {
                        flowableCreate$LatestAsyncEmitter.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
            }
            if (bl2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) {
                b.e(flowableCreate$LatestAsyncEmitter, l13);
            }
            atomicInteger = flowableCreate$LatestAsyncEmitter.wip;
            n12 = -n12;
        } while ((n12 = atomicInteger.addAndGet(n12)) != 0);
    }

    public void onComplete() {
        this.done = true;
        this.drain();
    }

    public void onNext(Object object) {
        boolean bl2 = this.done;
        if (!bl2 && !(bl2 = this.isCancelled())) {
            if (object == null) {
                object = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
                this.onError((Throwable)object);
                return;
            }
            AtomicReference atomicReference = this.queue;
            atomicReference.set(object);
            this.drain();
        }
    }

    public void onRequested() {
        this.drain();
    }

    public void onUnsubscribed() {
        Serializable serializable = this.wip;
        int n10 = ((AtomicInteger)serializable).getAndIncrement();
        if (n10 == 0) {
            serializable = this.queue;
            ((AtomicReference)serializable).lazySet(null);
        }
    }

    public boolean tryOnError(Throwable throwable) {
        boolean bl2 = this.done;
        if (!bl2 && !(bl2 = this.isCancelled())) {
            boolean bl3;
            if (throwable == null) {
                String string2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                NullPointerException nullPointerException = new NullPointerException(string2);
                this.onError(nullPointerException);
            }
            this.error = throwable;
            this.done = bl3 = true;
            this.drain();
            return bl3;
        }
        return false;
    }
}

