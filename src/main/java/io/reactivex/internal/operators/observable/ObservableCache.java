/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.internal.operators.observable;

import e.a.e0;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.e.e.a;
import e.a.z;
import io.reactivex.internal.operators.observable.ObservableCache$CacheDisposable;
import io.reactivex.internal.operators.observable.ObservableCache$a;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ObservableCache
extends a
implements g0 {
    public static final ObservableCache$CacheDisposable[] k = new ObservableCache$CacheDisposable[0];
    public static final ObservableCache$CacheDisposable[] l = new ObservableCache$CacheDisposable[0];
    public final AtomicBoolean b;
    public final int c;
    public final AtomicReference d;
    public volatile long e;
    public final ObservableCache$a f;
    public ObservableCache$a g;
    public int h;
    public Throwable i;
    public volatile boolean j;

    public ObservableCache(z atomicReference, int n10) {
        super((e0)((Object)atomicReference));
        this.c = n10;
        atomicReference = new AtomicReference<ObservableCache$CacheDisposable[]>();
        this.b = atomicReference;
        atomicReference = new AtomicReference<ObservableCache$CacheDisposable[]>(n10);
        this.f = atomicReference;
        this.g = atomicReference;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray = k;
        this.d = atomicReference = new AtomicReference<ObservableCache$CacheDisposable[]>(observableCache$CacheDisposableArray);
    }

    public void K5(g0 object) {
        boolean bl2;
        ObservableCache$CacheDisposable observableCache$CacheDisposable = new ObservableCache$CacheDisposable((g0)object, this);
        object.onSubscribe(observableCache$CacheDisposable);
        this.h8(observableCache$CacheDisposable);
        object = this.b;
        boolean bl3 = ((AtomicBoolean)object).get();
        if (!bl3 && (bl3 = ((AtomicBoolean)(object = this.b)).compareAndSet(false, bl2 = true))) {
            object = this.a;
            object.subscribe(this);
        } else {
            this.m8(observableCache$CacheDisposable);
        }
    }

    public void h8(ObservableCache$CacheDisposable observableCache$CacheDisposable) {
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((observableCache$CacheDisposableArray2 = (ObservableCache$CacheDisposable[])this.d.get()) == (object = l)) {
                return;
            }
            int n10 = observableCache$CacheDisposableArray2.length;
            int n11 = n10 + 1;
            observableCache$CacheDisposableArray = new ObservableCache$CacheDisposable[n11];
            System.arraycopy(observableCache$CacheDisposableArray2, 0, observableCache$CacheDisposableArray, 0, n10);
            observableCache$CacheDisposableArray[n10] = observableCache$CacheDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.d)).compareAndSet(observableCache$CacheDisposableArray2, observableCache$CacheDisposableArray)));
    }

    public long i8() {
        return this.e;
    }

    public boolean j8() {
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray = (ObservableCache$CacheDisposable[])this.d.get();
        boolean bl2 = observableCache$CacheDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            observableCache$CacheDisposableArray = null;
        }
        return bl2;
    }

    public boolean k8() {
        return this.b.get();
    }

    public void l8(ObservableCache$CacheDisposable observableCache$CacheDisposable) {
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (observableCache$CacheDisposableArray2 = (ObservableCache$CacheDisposable[])this.d.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                observableCache$CacheDisposableArray3 = observableCache$CacheDisposableArray2[n10];
                if (observableCache$CacheDisposableArray3 != observableCache$CacheDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                observableCache$CacheDisposableArray = k;
                continue;
            }
            int n14 = n11 + -1;
            observableCache$CacheDisposableArray3 = new ObservableCache$CacheDisposable[n14];
            System.arraycopy(observableCache$CacheDisposableArray2, 0, observableCache$CacheDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(observableCache$CacheDisposableArray2, n13, observableCache$CacheDisposableArray3, n12, n11);
            observableCache$CacheDisposableArray = observableCache$CacheDisposableArray3;
        } while (!(bl2 = (atomicReference = this.d).compareAndSet(observableCache$CacheDisposableArray2, observableCache$CacheDisposableArray)));
    }

    public void m8(ObservableCache$CacheDisposable serializable) {
        int n10;
        int n11 = ((AtomicInteger)serializable).getAndIncrement();
        if (n11 != 0) {
            return;
        }
        long l10 = ((ObservableCache$CacheDisposable)serializable).index;
        int n12 = ((ObservableCache$CacheDisposable)serializable).offset;
        ObservableCache$a observableCache$a = ((ObservableCache$CacheDisposable)serializable).node;
        g0 g02 = ((ObservableCache$CacheDisposable)serializable).downstream;
        int n13 = this.c;
        int n14 = n10 = 1;
        while (true) {
            boolean bl2;
            if (bl2 = ((ObservableCache$CacheDisposable)serializable).disposed) {
                ((ObservableCache$CacheDisposable)serializable).node = null;
                return;
            }
            bl2 = this.j;
            long l11 = this.e;
            long l12 = l11 - l10;
            Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
            object = object == false ? (Object)n10 : (Object)0;
            if (bl2 && object != false) {
                ((ObservableCache$CacheDisposable)serializable).node = null;
                serializable = this.i;
                if (serializable != null) {
                    g02.onError((Throwable)serializable);
                } else {
                    g02.onComplete();
                }
                return;
            }
            if (object == false) {
                if (n12 == n13) {
                    observableCache$a = observableCache$a.b;
                    n12 = 0;
                }
                Object object2 = observableCache$a.a[n12];
                g02.onNext(object2);
                n12 += n10;
                long l13 = 1L;
                l10 += l13;
                continue;
            }
            ((ObservableCache$CacheDisposable)serializable).index = l10;
            ((ObservableCache$CacheDisposable)serializable).offset = n12;
            ((ObservableCache$CacheDisposable)serializable).node = observableCache$a;
            n14 = -n14;
            if ((n14 = ((AtomicInteger)serializable).addAndGet(n14)) == 0) break;
        }
    }

    public void onComplete() {
        boolean bl2;
        this.j = bl2 = true;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray = this.d;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray2 = l;
        for (ObservableCache$CacheDisposable observableCache$CacheDisposable : observableCache$CacheDisposableArray.getAndSet(observableCache$CacheDisposableArray2)) {
            this.m8(observableCache$CacheDisposable);
        }
    }

    public void onError(Throwable serializable) {
        boolean bl2;
        this.i = serializable;
        this.j = bl2 = true;
        serializable = this.d;
        ObservableCache$CacheDisposable[] observableCache$CacheDisposableArray = l;
        for (Serializable serializable2 : ((AtomicReference)serializable).getAndSet(observableCache$CacheDisposableArray)) {
            this.m8((ObservableCache$CacheDisposable)serializable2);
        }
    }

    public void onNext(Object observableCache$CacheDisposableArray) {
        Object object;
        int n10 = this.h;
        int n11 = this.c;
        int n12 = 0;
        int n13 = 1;
        if (n10 == n11) {
            object = new ObservableCache$a(n10);
            Object[] objectArray = object.a;
            objectArray[0] = observableCache$CacheDisposableArray;
            this.h = n13;
            observableCache$CacheDisposableArray = this.g;
            observableCache$CacheDisposableArray.b = object;
            this.g = object;
        } else {
            object = this.g.a;
            object[n10] = observableCache$CacheDisposableArray;
            this.h = n10 += n13;
        }
        long l10 = this.e;
        long l11 = 1L;
        this.e = l10 += l11;
        observableCache$CacheDisposableArray = (ObservableCache$CacheDisposable[])this.d.get();
        n10 = observableCache$CacheDisposableArray.length;
        while (n12 < n10) {
            object = observableCache$CacheDisposableArray[n12];
            this.m8((ObservableCache$CacheDisposable)object);
            ++n12;
        }
    }

    public void onSubscribe(b b10) {
    }
}

