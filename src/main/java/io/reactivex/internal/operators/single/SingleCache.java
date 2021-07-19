/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.single;

import e.a.i0;
import e.a.l0;
import e.a.o0;
import e.a.s0.b;
import io.reactivex.internal.operators.single.SingleCache$CacheDisposable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleCache
extends i0
implements l0 {
    public static final SingleCache$CacheDisposable[] f = new SingleCache$CacheDisposable[0];
    public static final SingleCache$CacheDisposable[] g = new SingleCache$CacheDisposable[0];
    public final o0 a;
    public final AtomicInteger b;
    public final AtomicReference c;
    public Object d;
    public Throwable e;

    public SingleCache(o0 atomicReference) {
        this.a = atomicReference;
        atomicReference = new AtomicReference<SingleCache$CacheDisposable[]>();
        this.b = atomicReference;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray = f;
        this.c = atomicReference = new AtomicReference<SingleCache$CacheDisposable[]>(singleCache$CacheDisposableArray);
    }

    public boolean N1(SingleCache$CacheDisposable singleCache$CacheDisposable) {
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((singleCache$CacheDisposableArray2 = (SingleCache$CacheDisposable[])this.c.get()) == (object = g)) {
                return false;
            }
            int n10 = singleCache$CacheDisposableArray2.length;
            int n11 = n10 + 1;
            singleCache$CacheDisposableArray = new SingleCache$CacheDisposable[n11];
            System.arraycopy(singleCache$CacheDisposableArray2, 0, singleCache$CacheDisposableArray, 0, n10);
            singleCache$CacheDisposableArray[n10] = singleCache$CacheDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.c)).compareAndSet(singleCache$CacheDisposableArray2, singleCache$CacheDisposableArray)));
        return true;
    }

    public void O1(SingleCache$CacheDisposable singleCache$CacheDisposable) {
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            SingleCache$CacheDisposable[] singleCache$CacheDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (singleCache$CacheDisposableArray2 = (SingleCache$CacheDisposable[])this.c.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                singleCache$CacheDisposableArray3 = singleCache$CacheDisposableArray2[n10];
                if (singleCache$CacheDisposableArray3 != singleCache$CacheDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                singleCache$CacheDisposableArray = f;
                continue;
            }
            int n14 = n11 + -1;
            singleCache$CacheDisposableArray3 = new SingleCache$CacheDisposable[n14];
            System.arraycopy(singleCache$CacheDisposableArray2, 0, singleCache$CacheDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(singleCache$CacheDisposableArray2, n13, singleCache$CacheDisposableArray3, n12, n11);
            singleCache$CacheDisposableArray = singleCache$CacheDisposableArray3;
        } while (!(bl2 = (atomicReference = this.c).compareAndSet(singleCache$CacheDisposableArray2, singleCache$CacheDisposableArray)));
    }

    public void e1(l0 object) {
        Object object2 = new SingleCache$CacheDisposable((l0)object, this);
        object.onSubscribe((b)object2);
        boolean bl2 = this.N1((SingleCache$CacheDisposable)object2);
        if (bl2) {
            int n10;
            boolean n102 = ((SingleCache$CacheDisposable)object2).isDisposed();
            if (n102) {
                this.O1((SingleCache$CacheDisposable)object2);
            }
            if ((n10 = ((AtomicInteger)(object = this.b)).getAndIncrement()) == 0) {
                object = this.a;
                object.f(this);
            }
            return;
        }
        object2 = this.e;
        if (object2 != null) {
            object.onError((Throwable)object2);
        } else {
            object2 = this.d;
            object.onSuccess(object2);
        }
    }

    public void onError(Throwable throwable) {
        this.e = throwable;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray = this.c;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray2 = g;
        for (SingleCache$CacheDisposable singleCache$CacheDisposable : singleCache$CacheDisposableArray.getAndSet(singleCache$CacheDisposableArray2)) {
            boolean bl2 = singleCache$CacheDisposable.isDisposed();
            if (bl2) continue;
            l0 l02 = singleCache$CacheDisposable.downstream;
            l02.onError(throwable);
        }
    }

    public void onSubscribe(b b10) {
    }

    public void onSuccess(Object object) {
        this.d = object;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray = this.c;
        SingleCache$CacheDisposable[] singleCache$CacheDisposableArray2 = g;
        for (SingleCache$CacheDisposable singleCache$CacheDisposable : singleCache$CacheDisposableArray.getAndSet(singleCache$CacheDisposableArray2)) {
            boolean bl2 = singleCache$CacheDisposable.isDisposed();
            if (bl2) continue;
            l0 l02 = singleCache$CacheDisposable.downstream;
            l02.onSuccess(object);
        }
    }
}

