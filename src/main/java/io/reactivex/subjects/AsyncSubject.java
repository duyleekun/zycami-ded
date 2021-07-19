/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.d1.c;
import e.a.g0;
import e.a.s0.b;
import e.a.w0.b.a;
import io.reactivex.subjects.AsyncSubject$AsyncDisposable;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

public final class AsyncSubject
extends c {
    public static final AsyncSubject$AsyncDisposable[] d = new AsyncSubject$AsyncDisposable[0];
    public static final AsyncSubject$AsyncDisposable[] e = new AsyncSubject$AsyncDisposable[0];
    public final AtomicReference a;
    public Throwable b;
    public Object c;

    public AsyncSubject() {
        AtomicReference<AsyncSubject$AsyncDisposable[]> atomicReference;
        AsyncSubject$AsyncDisposable[] asyncDisposableArray = d;
        this.a = atomicReference = new AtomicReference<AsyncSubject$AsyncDisposable[]>(asyncDisposableArray);
    }

    public static AsyncSubject n8() {
        AsyncSubject asyncSubject = new AsyncSubject();
        return asyncSubject;
    }

    public void K5(g0 object) {
        AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable = new AsyncSubject$AsyncDisposable((g0)object, this);
        object.onSubscribe(asyncSubject$AsyncDisposable);
        boolean bl2 = this.m8(asyncSubject$AsyncDisposable);
        if (bl2) {
            boolean bl3 = asyncSubject$AsyncDisposable.isDisposed();
            if (bl3) {
                this.s8(asyncSubject$AsyncDisposable);
            }
        } else {
            Throwable throwable = this.b;
            if (throwable != null) {
                object.onError(throwable);
            } else {
                object = this.c;
                if (object != null) {
                    asyncSubject$AsyncDisposable.complete(object);
                } else {
                    asyncSubject$AsyncDisposable.onComplete();
                }
            }
        }
    }

    public Throwable h8() {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        object = object == (asyncSubject$AsyncDisposableArray = e) ? this.b : null;
        return object;
    }

    public boolean i8() {
        boolean bl2;
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        if (object == (asyncSubject$AsyncDisposableArray = e) && (object = this.b) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean j8() {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray = (AsyncSubject$AsyncDisposable[])this.a.get();
        boolean bl2 = asyncSubject$AsyncDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            asyncSubject$AsyncDisposableArray = null;
        }
        return bl2;
    }

    public boolean k8() {
        boolean bl2;
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        if (object == (asyncSubject$AsyncDisposableArray = e) && (object = this.b) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean m8(AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable) {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((asyncSubject$AsyncDisposableArray2 = (AsyncSubject$AsyncDisposable[])this.a.get()) == (object = e)) {
                return false;
            }
            int n10 = asyncSubject$AsyncDisposableArray2.length;
            int n11 = n10 + 1;
            asyncSubject$AsyncDisposableArray = new AsyncSubject$AsyncDisposable[n11];
            System.arraycopy(asyncSubject$AsyncDisposableArray2, 0, asyncSubject$AsyncDisposableArray, 0, n10);
            asyncSubject$AsyncDisposableArray[n10] = asyncSubject$AsyncDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.a)).compareAndSet(asyncSubject$AsyncDisposableArray2, asyncSubject$AsyncDisposableArray)));
        return true;
    }

    public Object o8() {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        object = object == (asyncSubject$AsyncDisposableArray = e) ? this.c : null;
        return object;
    }

    public void onComplete() {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        if (object == (asyncSubject$AsyncDisposableArray = e)) {
            return;
        }
        object = this.c;
        asyncSubject$AsyncDisposableArray = this.a.getAndSet(asyncSubject$AsyncDisposableArray);
        if (object == null) {
            for (AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable : asyncSubject$AsyncDisposableArray) {
                asyncSubject$AsyncDisposable.onComplete();
            }
        } else {
            int n10;
            int n11 = asyncSubject$AsyncDisposableArray.length;
            while (n10 < n11) {
                AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable = asyncSubject$AsyncDisposableArray[n10];
                asyncSubject$AsyncDisposable.complete(object);
                ++n10;
            }
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object = this.a.get();
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray = e;
        if (object == asyncSubject$AsyncDisposableArray) {
            e.a.a1.a.Y(throwable);
            return;
        }
        this.c = null;
        this.b = throwable;
        for (AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable : this.a.getAndSet(asyncSubject$AsyncDisposableArray)) {
            asyncSubject$AsyncDisposable.onError(throwable);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object v10 = this.a.get();
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray = e;
        if (v10 == asyncSubject$AsyncDisposableArray) {
            return;
        }
        this.c = object;
    }

    public void onSubscribe(b b10) {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (asyncSubject$AsyncDisposableArray = e)) {
            b10.dispose();
        }
    }

    public Object[] p8() {
        Object[] objectArray;
        Object object = this.o8();
        if (object != null) {
            int n10 = 1;
            objectArray = new Object[n10];
            objectArray[0] = object;
        } else {
            objectArray = new Object[]{};
        }
        return objectArray;
    }

    public Object[] q8(Object[] objectArray) {
        Object object = this.o8();
        if (object == null) {
            int n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        int n11 = objectArray.length;
        int n12 = 1;
        if (n11 == 0) {
            objectArray = Arrays.copyOf(objectArray, n12);
        }
        objectArray[0] = object;
        int n13 = objectArray.length;
        if (n13 != n12) {
            objectArray[n12] = null;
        }
        return objectArray;
    }

    public boolean r8() {
        boolean bl2;
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        Object object = this.a.get();
        if (object == (asyncSubject$AsyncDisposableArray = e) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public void s8(AsyncSubject$AsyncDisposable asyncSubject$AsyncDisposable) {
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray;
        AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            AsyncSubject$AsyncDisposable[] asyncSubject$AsyncDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (asyncSubject$AsyncDisposableArray2 = (AsyncSubject$AsyncDisposable[])this.a.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                asyncSubject$AsyncDisposableArray3 = asyncSubject$AsyncDisposableArray2[n10];
                if (asyncSubject$AsyncDisposableArray3 != asyncSubject$AsyncDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                asyncSubject$AsyncDisposableArray = d;
                continue;
            }
            int n14 = n11 + -1;
            asyncSubject$AsyncDisposableArray3 = new AsyncSubject$AsyncDisposable[n14];
            System.arraycopy(asyncSubject$AsyncDisposableArray2, 0, asyncSubject$AsyncDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(asyncSubject$AsyncDisposableArray2, n13, asyncSubject$AsyncDisposableArray3, n12, n11);
            asyncSubject$AsyncDisposableArray = asyncSubject$AsyncDisposableArray3;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(asyncSubject$AsyncDisposableArray2, asyncSubject$AsyncDisposableArray)));
    }
}

