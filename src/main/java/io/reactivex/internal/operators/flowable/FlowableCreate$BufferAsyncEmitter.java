/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.w0.f.a;
import e.a.w0.i.b;
import i.g.d;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableCreate$BufferAsyncEmitter
extends FlowableCreate$BaseEmitter {
    private static final long serialVersionUID = 2427151001689639875L;
    public volatile boolean done;
    public Throwable error;
    public final a queue;
    public final AtomicInteger wip;

    public FlowableCreate$BufferAsyncEmitter(d object, int n10) {
        super((d)object);
        this.queue = object = new a(n10);
        this.wip = object = new AtomicInteger();
    }

    public void drain() {
        AtomicInteger atomicInteger;
        int n10;
        Object object = this.wip;
        int n11 = ((AtomicInteger)object).getAndIncrement();
        if (n11 != 0) {
            return;
        }
        object = this.downstream;
        a a10 = this.queue;
        int n12 = n10 = 1;
        do {
            boolean bl2;
            long l10;
            long l11;
            long l12 = this.get();
            long l13 = l11 = 0L;
            while ((l10 = l13 == l12 ? 0 : (l13 < l12 ? -1 : 1)) != false) {
                boolean bl3 = this.isCancelled();
                if (bl3) {
                    a10.clear();
                    return;
                }
                bl3 = this.done;
                Object object2 = a10.poll();
                int n13 = object2 == null ? n10 : 0;
                if (bl3 && n13 != 0) {
                    object = this.error;
                    if (object != null) {
                        this.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
                if (n13 != 0) break;
                object.onNext(object2);
                long l14 = 1L;
                l13 += l14;
            }
            if (l10 == false) {
                bl2 = this.isCancelled();
                if (bl2) {
                    a10.clear();
                    return;
                }
                bl2 = this.done;
                boolean bl4 = a10.isEmpty();
                if (bl2 && bl4) {
                    object = this.error;
                    if (object != null) {
                        this.error((Throwable)object);
                    } else {
                        this.complete();
                    }
                    return;
                }
            }
            if (bl2 = l13 == l11 ? 0 : (l13 < l11 ? -1 : 1)) {
                b.e(this, l13);
            }
            atomicInteger = this.wip;
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
            a a10 = this.queue;
            a10.offer(object);
            this.drain();
        }
    }

    public void onRequested() {
        this.drain();
    }

    public void onUnsubscribed() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).getAndIncrement();
        if (n10 == 0) {
            object = this.queue;
            ((a)object).clear();
        }
    }

    public boolean tryOnError(Throwable throwable) {
        boolean bl2 = this.done;
        if (!bl2 && !(bl2 = this.isCancelled())) {
            boolean bl3;
            if (throwable == null) {
                String string2 = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                throwable = new NullPointerException(string2);
            }
            this.error = throwable;
            this.done = bl3 = true;
            this.drain();
            return bl3;
        }
        return false;
    }
}

