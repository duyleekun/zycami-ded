/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public final class CompletableMergeArray$InnerCompletableObserver
extends AtomicInteger
implements d {
    private static final long serialVersionUID = -8360547806504310570L;
    public final d downstream;
    public final AtomicBoolean once;
    public final e.a.s0.a set;

    public CompletableMergeArray$InnerCompletableObserver(d d10, AtomicBoolean atomicBoolean, e.a.s0.a a10, int n10) {
        this.downstream = d10;
        this.once = atomicBoolean;
        this.set = a10;
        this.lazySet(n10);
    }

    public void onComplete() {
        boolean bl2;
        Object object;
        int n10 = this.decrementAndGet();
        if (n10 == 0 && (n10 = (int)(((AtomicBoolean)(object = this.once)).compareAndSet(false, bl2 = true) ? 1 : 0)) != 0) {
            object = this.downstream;
            object.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.set.dispose();
        Object object = this.once;
        boolean bl2 = true;
        boolean bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
        if (bl3) {
            object = this.downstream;
            object.onError(throwable);
        } else {
            a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        this.set.b(b10);
    }
}

