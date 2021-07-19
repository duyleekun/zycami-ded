/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.maybe;

import e.a.q;
import e.a.s0.b;
import e.a.t;
import e.a.w;
import io.reactivex.internal.operators.maybe.MaybeCache$CacheDisposable;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeCache
extends q
implements t {
    public static final MaybeCache$CacheDisposable[] e = new MaybeCache$CacheDisposable[0];
    public static final MaybeCache$CacheDisposable[] f = new MaybeCache$CacheDisposable[0];
    public final AtomicReference a;
    public final AtomicReference b;
    public Object c;
    public Throwable d;

    public MaybeCache(w atomicReference) {
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray;
        this.a = maybeCache$CacheDisposableArray = new AtomicReference(atomicReference);
        maybeCache$CacheDisposableArray = e;
        this.b = atomicReference = new AtomicReference<MaybeCache$CacheDisposable[]>(maybeCache$CacheDisposableArray);
    }

    public boolean e2(MaybeCache$CacheDisposable maybeCache$CacheDisposable) {
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((maybeCache$CacheDisposableArray2 = (MaybeCache$CacheDisposable[])this.b.get()) == (object = f)) {
                return false;
            }
            int n10 = maybeCache$CacheDisposableArray2.length;
            int n11 = n10 + 1;
            maybeCache$CacheDisposableArray = new MaybeCache$CacheDisposable[n11];
            System.arraycopy(maybeCache$CacheDisposableArray2, 0, maybeCache$CacheDisposableArray, 0, n10);
            maybeCache$CacheDisposableArray[n10] = maybeCache$CacheDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(maybeCache$CacheDisposableArray2, maybeCache$CacheDisposableArray)));
        return true;
    }

    public void f2(MaybeCache$CacheDisposable maybeCache$CacheDisposable) {
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (maybeCache$CacheDisposableArray2 = (MaybeCache$CacheDisposable[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                maybeCache$CacheDisposableArray3 = maybeCache$CacheDisposableArray2[n10];
                if (maybeCache$CacheDisposableArray3 != maybeCache$CacheDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                maybeCache$CacheDisposableArray = e;
                continue;
            }
            int n14 = n11 + -1;
            maybeCache$CacheDisposableArray3 = new MaybeCache$CacheDisposable[n14];
            System.arraycopy(maybeCache$CacheDisposableArray2, 0, maybeCache$CacheDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(maybeCache$CacheDisposableArray2, n13, maybeCache$CacheDisposableArray3, n12, n11);
            maybeCache$CacheDisposableArray = maybeCache$CacheDisposableArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(maybeCache$CacheDisposableArray2, maybeCache$CacheDisposableArray)));
    }

    public void onComplete() {
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray = this.b;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray2 = f;
        for (MaybeCache$CacheDisposable maybeCache$CacheDisposable : maybeCache$CacheDisposableArray.getAndSet(maybeCache$CacheDisposableArray2)) {
            boolean bl2 = maybeCache$CacheDisposable.isDisposed();
            if (bl2) continue;
            t t10 = maybeCache$CacheDisposable.downstream;
            t10.onComplete();
        }
    }

    public void onError(Throwable throwable) {
        this.d = throwable;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray = this.b;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray2 = f;
        for (MaybeCache$CacheDisposable maybeCache$CacheDisposable : maybeCache$CacheDisposableArray.getAndSet(maybeCache$CacheDisposableArray2)) {
            boolean bl2 = maybeCache$CacheDisposable.isDisposed();
            if (bl2) continue;
            t t10 = maybeCache$CacheDisposable.downstream;
            t10.onError(throwable);
        }
    }

    public void onSubscribe(b b10) {
    }

    public void onSuccess(Object object) {
        this.c = object;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray = this.b;
        MaybeCache$CacheDisposable[] maybeCache$CacheDisposableArray2 = f;
        for (MaybeCache$CacheDisposable maybeCache$CacheDisposable : maybeCache$CacheDisposableArray.getAndSet(maybeCache$CacheDisposableArray2)) {
            boolean bl2 = maybeCache$CacheDisposable.isDisposed();
            if (bl2) continue;
            t t10 = maybeCache$CacheDisposable.downstream;
            t10.onSuccess(object);
        }
    }

    public void t1(t object) {
        Object object2 = new MaybeCache$CacheDisposable((t)object, this);
        object.onSubscribe((b)object2);
        boolean bl2 = this.e2((MaybeCache$CacheDisposable)object2);
        if (bl2) {
            boolean bl3 = ((MaybeCache$CacheDisposable)object2).isDisposed();
            if (bl3) {
                this.f2((MaybeCache$CacheDisposable)object2);
                return;
            }
            object = this.a;
            boolean bl4 = false;
            object2 = null;
            if ((object = (w)((AtomicReference)object).getAndSet(null)) != null) {
                object.g(this);
            }
            return;
        }
        boolean bl5 = ((MaybeCache$CacheDisposable)object2).isDisposed();
        if (!bl5) {
            object2 = this.d;
            if (object2 != null) {
                object.onError((Throwable)object2);
            } else {
                object2 = this.c;
                if (object2 != null) {
                    object.onSuccess(object2);
                } else {
                    object.onComplete();
                }
            }
        }
    }
}

