/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.i0;
import e.a.l0;
import e.a.s0.b;
import io.reactivex.subjects.SingleSubject$SingleDisposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class SingleSubject
extends i0
implements l0 {
    public static final SingleSubject$SingleDisposable[] e = new SingleSubject$SingleDisposable[0];
    public static final SingleSubject$SingleDisposable[] f = new SingleSubject$SingleDisposable[0];
    public final AtomicReference a;
    public final AtomicBoolean b;
    public Object c;
    public Throwable d;

    public SingleSubject() {
        Serializable serializable;
        this.b = serializable = new AtomicBoolean();
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray = e;
        super(singleSubject$SingleDisposableArray);
        this.a = serializable;
    }

    public static SingleSubject O1() {
        SingleSubject singleSubject = new SingleSubject();
        return singleSubject;
    }

    public boolean N1(SingleSubject$SingleDisposable singleSubject$SingleDisposable) {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((singleSubject$SingleDisposableArray2 = (SingleSubject$SingleDisposable[])this.a.get()) == (object = f)) {
                return false;
            }
            int n10 = singleSubject$SingleDisposableArray2.length;
            int n11 = n10 + 1;
            singleSubject$SingleDisposableArray = new SingleSubject$SingleDisposable[n11];
            System.arraycopy(singleSubject$SingleDisposableArray2, 0, singleSubject$SingleDisposableArray, 0, n10);
            singleSubject$SingleDisposableArray[n10] = singleSubject$SingleDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.a)).compareAndSet(singleSubject$SingleDisposableArray2, singleSubject$SingleDisposableArray)));
        return true;
    }

    public Throwable P1() {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (singleSubject$SingleDisposableArray = f)) {
            return this.d;
        }
        return null;
    }

    public Object Q1() {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (singleSubject$SingleDisposableArray = f)) {
            return this.c;
        }
        return null;
    }

    public boolean R1() {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray = (SingleSubject$SingleDisposable[])this.a.get();
        boolean bl2 = singleSubject$SingleDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            singleSubject$SingleDisposableArray = null;
        }
        return bl2;
    }

    public boolean S1() {
        boolean bl2;
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        Object object = this.a.get();
        if (object == (singleSubject$SingleDisposableArray = f) && (object = this.d) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean T1() {
        boolean bl2;
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        Object object = this.a.get();
        if (object == (singleSubject$SingleDisposableArray = f) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int U1() {
        return ((SingleSubject$SingleDisposable[])this.a.get()).length;
    }

    public void V1(SingleSubject$SingleDisposable singleSubject$SingleDisposable) {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (singleSubject$SingleDisposableArray2 = (SingleSubject$SingleDisposable[])this.a.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                singleSubject$SingleDisposableArray3 = singleSubject$SingleDisposableArray2[n10];
                if (singleSubject$SingleDisposableArray3 != singleSubject$SingleDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                singleSubject$SingleDisposableArray = e;
                continue;
            }
            int n14 = n11 + -1;
            singleSubject$SingleDisposableArray3 = new SingleSubject$SingleDisposable[n14];
            System.arraycopy(singleSubject$SingleDisposableArray2, 0, singleSubject$SingleDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(singleSubject$SingleDisposableArray2, n13, singleSubject$SingleDisposableArray3, n12, n11);
            singleSubject$SingleDisposableArray = singleSubject$SingleDisposableArray3;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(singleSubject$SingleDisposableArray2, singleSubject$SingleDisposableArray)));
    }

    public void e1(l0 l02) {
        Object object = new SingleSubject$SingleDisposable(l02, this);
        l02.onSubscribe((b)object);
        boolean bl2 = this.N1((SingleSubject$SingleDisposable)object);
        if (bl2) {
            boolean bl3 = ((SingleSubject$SingleDisposable)object).isDisposed();
            if (bl3) {
                this.V1((SingleSubject$SingleDisposable)object);
            }
        } else {
            object = this.d;
            if (object != null) {
                l02.onError((Throwable)object);
            } else {
                object = this.c;
                l02.onSuccess(object);
            }
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Serializable serializable = this.b;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)serializable).compareAndSet(false, n10 != 0);
        if (bl2) {
            this.d = throwable;
            serializable = this.a;
            SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray = f;
            serializable = ((AtomicReference)serializable).getAndSet(singleSubject$SingleDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                l0 l02 = ((SingleSubject$SingleDisposable)serializable[i10]).downstream;
                l02.onError(throwable);
            }
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (singleSubject$SingleDisposableArray = f)) {
            b10.dispose();
        }
    }

    public void onSuccess(Object object) {
        e.a.w0.b.a.g(object, "onSuccess called with null. Null values are generally not allowed in 2.x operators and sources.");
        Serializable serializable = this.b;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)serializable).compareAndSet(false, n10 != 0);
        if (bl2) {
            this.c = object;
            serializable = this.a;
            SingleSubject$SingleDisposable[] singleSubject$SingleDisposableArray = f;
            serializable = ((AtomicReference)serializable).getAndSet(singleSubject$SingleDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                l0 l02 = ((SingleSubject$SingleDisposable)serializable[i10]).downstream;
                l02.onSuccess(object);
            }
        }
    }
}

