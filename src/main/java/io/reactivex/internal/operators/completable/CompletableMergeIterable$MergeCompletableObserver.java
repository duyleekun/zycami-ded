/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeIterable$MergeCompletableObserver
extends AtomicBoolean
implements d {
    private static final long serialVersionUID = -7730517613164279224L;
    public final d downstream;
    public final e.a.s0.a set;
    public final AtomicInteger wip;

    public CompletableMergeIterable$MergeCompletableObserver(d d10, e.a.s0.a a10, AtomicInteger atomicInteger) {
        this.downstream = d10;
        this.set = a10;
        this.wip = atomicInteger;
    }

    public void onComplete() {
        Object object = this.wip;
        int n10 = ((AtomicInteger)object).decrementAndGet();
        if (n10 == 0) {
            object = null;
            boolean bl2 = true;
            n10 = (int)(this.compareAndSet(false, bl2) ? 1 : 0);
            if (n10 != 0) {
                object = this.downstream;
                object.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        this.set.dispose();
        d d10 = null;
        boolean bl2 = true;
        boolean bl3 = this.compareAndSet(false, bl2);
        if (bl3) {
            d10 = this.downstream;
            d10.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.set.b(b10);
    }
}

