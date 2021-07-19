/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.completable;

import e.a.a;
import e.a.d;
import e.a.g;
import e.a.s0.b;
import io.reactivex.internal.operators.completable.CompletableCache$InnerCompletableCache;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableCache
extends a
implements d {
    public static final CompletableCache$InnerCompletableCache[] e = new CompletableCache$InnerCompletableCache[0];
    public static final CompletableCache$InnerCompletableCache[] f = new CompletableCache$InnerCompletableCache[0];
    public final g a;
    public final AtomicReference b;
    public final AtomicBoolean c;
    public Throwable d;

    public CompletableCache(g serializable) {
        this.a = serializable;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray = e;
        this.b = serializable = new Serializable(completableCache$InnerCompletableCacheArray);
        this.c = serializable;
    }

    public void L0(d object) {
        Serializable serializable = new CompletableCache$InnerCompletableCache(this, (d)object);
        object.onSubscribe((b)((Object)serializable));
        boolean bl2 = this.h1((CompletableCache$InnerCompletableCache)serializable);
        if (bl2) {
            boolean bl3 = serializable.isDisposed();
            if (bl3) {
                this.i1((CompletableCache$InnerCompletableCache)serializable);
            }
            object = this.c;
            serializable = null;
            bl2 = true;
            bl3 = ((AtomicBoolean)object).compareAndSet(false, bl2);
            if (bl3) {
                object = this.a;
                object.f(this);
            }
        } else {
            serializable = this.d;
            if (serializable != null) {
                object.onError((Throwable)serializable);
            } else {
                object.onComplete();
            }
        }
    }

    public boolean h1(CompletableCache$InnerCompletableCache completableCache$InnerCompletableCache) {
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray2;
        Object object;
        boolean bl2;
        do {
            if ((completableCache$InnerCompletableCacheArray2 = (CompletableCache$InnerCompletableCache[])this.b.get()) == (object = f)) {
                return false;
            }
            int n10 = completableCache$InnerCompletableCacheArray2.length;
            int n11 = n10 + 1;
            completableCache$InnerCompletableCacheArray = new CompletableCache$InnerCompletableCache[n11];
            System.arraycopy(completableCache$InnerCompletableCacheArray2, 0, completableCache$InnerCompletableCacheArray, 0, n10);
            completableCache$InnerCompletableCacheArray[n10] = completableCache$InnerCompletableCache;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(completableCache$InnerCompletableCacheArray2, completableCache$InnerCompletableCacheArray)));
        return true;
    }

    public void i1(CompletableCache$InnerCompletableCache completableCache$InnerCompletableCache) {
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray3;
            int n10;
            int n11;
            if ((n11 = (completableCache$InnerCompletableCacheArray2 = (CompletableCache$InnerCompletableCache[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                completableCache$InnerCompletableCacheArray3 = completableCache$InnerCompletableCacheArray2[n10];
                if (completableCache$InnerCompletableCacheArray3 != completableCache$InnerCompletableCache) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                completableCache$InnerCompletableCacheArray = e;
                continue;
            }
            int n14 = n11 + -1;
            completableCache$InnerCompletableCacheArray3 = new CompletableCache$InnerCompletableCache[n14];
            System.arraycopy(completableCache$InnerCompletableCacheArray2, 0, completableCache$InnerCompletableCacheArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(completableCache$InnerCompletableCacheArray2, n13, completableCache$InnerCompletableCacheArray3, n12, n11);
            completableCache$InnerCompletableCacheArray = completableCache$InnerCompletableCacheArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(completableCache$InnerCompletableCacheArray2, completableCache$InnerCompletableCacheArray)));
    }

    public void onComplete() {
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray = this.b;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray2 = f;
        for (CompletableCache$InnerCompletableCache completableCache$InnerCompletableCache : completableCache$InnerCompletableCacheArray.getAndSet(completableCache$InnerCompletableCacheArray2)) {
            boolean bl2 = completableCache$InnerCompletableCache.get();
            if (bl2) continue;
            d d10 = completableCache$InnerCompletableCache.downstream;
            d10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.d = throwable;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray = this.b;
        CompletableCache$InnerCompletableCache[] completableCache$InnerCompletableCacheArray2 = f;
        for (CompletableCache$InnerCompletableCache completableCache$InnerCompletableCache : completableCache$InnerCompletableCacheArray.getAndSet(completableCache$InnerCompletableCacheArray2)) {
            boolean bl2 = completableCache$InnerCompletableCache.get();
            if (bl2) continue;
            d d10 = completableCache$InnerCompletableCache.downstream;
            d10.onError(throwable);
        }
    }

    public void onSubscribe(b b10) {
    }
}

