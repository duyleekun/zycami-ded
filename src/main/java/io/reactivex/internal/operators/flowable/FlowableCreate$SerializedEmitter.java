/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.flowable;

import e.a.a1.a;
import e.a.l;
import e.a.s0.b;
import e.a.v0.f;
import e.a.w0.c.n;
import io.reactivex.internal.operators.flowable.FlowableCreate$BaseEmitter;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class FlowableCreate$SerializedEmitter
extends AtomicInteger
implements l {
    private static final long serialVersionUID = 4883307006032401862L;
    public volatile boolean done;
    public final FlowableCreate$BaseEmitter emitter;
    public final AtomicThrowable error;
    public final n queue;

    public FlowableCreate$SerializedEmitter(FlowableCreate$BaseEmitter object) {
        this.emitter = object;
        this.error = object;
        this.queue = object = new e.a.w0.f.a(16);
    }

    public void drain() {
        int n10 = this.getAndIncrement();
        if (n10 == 0) {
            this.drainLoop();
        }
    }

    public void drainLoop() {
        int n10;
        FlowableCreate$BaseEmitter flowableCreate$BaseEmitter = this.emitter;
        Object object = this.queue;
        AtomicThrowable atomicThrowable = this.error;
        int n11 = n10 = 1;
        while (true) {
            boolean bl2;
            if (bl2 = flowableCreate$BaseEmitter.isCancelled()) {
                object.clear();
                return;
            }
            Object v10 = atomicThrowable.get();
            if (v10 != null) {
                object.clear();
                object = atomicThrowable.terminate();
                flowableCreate$BaseEmitter.onError((Throwable)object);
                return;
            }
            bl2 = this.done;
            Object object2 = object.poll();
            int n12 = object2 == null ? n10 : 0;
            if (bl2 && n12 != 0) {
                flowableCreate$BaseEmitter.onComplete();
                return;
            }
            if (n12 != 0) {
                n11 = -n11;
                if ((n11 = this.addAndGet(n11)) != 0) continue;
                return;
            }
            flowableCreate$BaseEmitter.onNext(object2);
        }
    }

    public boolean isCancelled() {
        return this.emitter.isCancelled();
    }

    public void onComplete() {
        FlowableCreate$BaseEmitter flowableCreate$BaseEmitter = this.emitter;
        boolean bl2 = flowableCreate$BaseEmitter.isCancelled();
        if (!bl2 && !(bl2 = this.done)) {
            this.done = bl2 = true;
            this.drain();
        }
    }

    public void onError(Throwable throwable) {
        boolean bl2 = this.tryOnError(throwable);
        if (!bl2) {
            a.Y(throwable);
        }
    }

    /*
     * Unable to fully structure code
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void onNext(Object var1_1) {
        var2_2 = this.emitter;
        var3_3 = var2_2.isCancelled();
        if (var3_3 != 0) return;
        var3_3 = this.done;
        if (var3_3 != 0) {
            return;
        }
        if (var1_1 == null) {
            var1_1 = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            this.onError((Throwable)var1_1);
            return;
        }
        var3_3 = this.get();
        if (var3_3 != 0) ** GOTO lbl-1000
        var2_2 = null;
        var4_4 = 1;
        var3_3 = (int)this.compareAndSet(0, var4_4);
        if (var3_3 != 0) {
            var2_2 = this.emitter;
            var2_2.onNext(var1_1);
            var5_5 = this.decrementAndGet();
            if (var5_5 == 0) {
                return;
            }
        } else lbl-1000:
        // 2 sources

        {
            var2_2 = this.queue;
            synchronized (var2_2) {
                var2_2.offer(var1_1);
            }
            var5_6 = this.getAndIncrement();
            if (var5_6 != 0) {
                return;
            }
        }
        this.drainLoop();
    }

    public long requested() {
        return this.emitter.requested();
    }

    public l serialize() {
        return this;
    }

    public void setCancellable(f f10) {
        this.emitter.setCancellable(f10);
    }

    public void setDisposable(b b10) {
        this.emitter.setDisposable(b10);
    }

    public String toString() {
        return this.emitter.toString();
    }

    public boolean tryOnError(Throwable throwable) {
        Object object = this.emitter;
        boolean bl2 = ((FlowableCreate$BaseEmitter)object).isCancelled();
        if (!bl2 && !(bl2 = this.done)) {
            boolean bl3;
            if (throwable == null) {
                object = "onError called with null. Null values are generally not allowed in 2.x operators and sources.";
                throwable = new NullPointerException((String)object);
            }
            if (bl3 = ((AtomicThrowable)(object = this.error)).addThrowable(throwable)) {
                this.done = bl3 = true;
                this.drain();
                return bl3;
            }
        }
        return false;
    }
}

