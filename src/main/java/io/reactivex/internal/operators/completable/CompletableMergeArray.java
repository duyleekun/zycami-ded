/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.d;
import e.a.g;
import e.a.s0.a;
import io.reactivex.internal.operators.completable.CompletableMergeArray$InnerCompletableObserver;
import java.util.concurrent.atomic.AtomicBoolean;

public final class CompletableMergeArray
extends e.a.a {
    public final g[] a;

    public CompletableMergeArray(g[] gArray) {
        this.a = gArray;
    }

    public void L0(d object) {
        a a10 = new a();
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        int n10 = this.a.length + 1;
        CompletableMergeArray$InnerCompletableObserver completableMergeArray$InnerCompletableObserver = new CompletableMergeArray$InnerCompletableObserver((d)object, atomicBoolean, a10, n10);
        object.onSubscribe(a10);
        object = this.a;
        int n11 = ((g[])object).length;
        for (n10 = 0; n10 < n11; ++n10) {
            g g10 = object[n10];
            boolean bl2 = a10.isDisposed();
            if (bl2) {
                return;
            }
            if (g10 == null) {
                a10.dispose();
                object = new NullPointerException("A completable source is null");
                completableMergeArray$InnerCompletableObserver.onError((Throwable)object);
                return;
            }
            g10.f(completableMergeArray$InnerCompletableObserver);
        }
        completableMergeArray$InnerCompletableObserver.onComplete();
    }
}

