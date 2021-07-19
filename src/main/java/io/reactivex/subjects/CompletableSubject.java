/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.d;
import e.a.s0.b;
import io.reactivex.subjects.CompletableSubject$CompletableDisposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class CompletableSubject
extends e.a.a
implements d {
    public static final CompletableSubject$CompletableDisposable[] d = new CompletableSubject$CompletableDisposable[0];
    public static final CompletableSubject$CompletableDisposable[] e = new CompletableSubject$CompletableDisposable[0];
    public final AtomicReference a;
    public final AtomicBoolean b;
    public Throwable c;

    public CompletableSubject() {
        Serializable serializable;
        this.b = serializable = new AtomicBoolean();
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray = d;
        super(completableSubject$CompletableDisposableArray);
        this.a = serializable;
    }

    public static CompletableSubject i1() {
        CompletableSubject completableSubject = new CompletableSubject();
        return completableSubject;
    }

    public void L0(d d10) {
        Serializable serializable = new CompletableSubject$CompletableDisposable(d10, this);
        d10.onSubscribe((b)((Object)serializable));
        boolean bl2 = this.h1((CompletableSubject$CompletableDisposable)serializable);
        if (bl2) {
            boolean bl3 = serializable.isDisposed();
            if (bl3) {
                this.o1((CompletableSubject$CompletableDisposable)serializable);
            }
        } else {
            serializable = this.c;
            if (serializable != null) {
                d10.onError((Throwable)serializable);
            } else {
                d10.onComplete();
            }
        }
    }

    public boolean h1(CompletableSubject$CompletableDisposable completableSubject$CompletableDisposable) {
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((completableSubject$CompletableDisposableArray2 = (CompletableSubject$CompletableDisposable[])this.a.get()) == (object = e)) {
                return false;
            }
            int n10 = completableSubject$CompletableDisposableArray2.length;
            int n11 = n10 + 1;
            completableSubject$CompletableDisposableArray = new CompletableSubject$CompletableDisposable[n11];
            System.arraycopy(completableSubject$CompletableDisposableArray2, 0, completableSubject$CompletableDisposableArray, 0, n10);
            completableSubject$CompletableDisposableArray[n10] = completableSubject$CompletableDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.a)).compareAndSet(completableSubject$CompletableDisposableArray2, completableSubject$CompletableDisposableArray)));
        return true;
    }

    public Throwable j1() {
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (completableSubject$CompletableDisposableArray = e)) {
            return this.c;
        }
        return null;
    }

    public boolean k1() {
        boolean bl2;
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        Object object = this.a.get();
        if (object == (completableSubject$CompletableDisposableArray = e) && (object = this.c) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean l1() {
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray = (CompletableSubject$CompletableDisposable[])this.a.get();
        boolean bl2 = completableSubject$CompletableDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            completableSubject$CompletableDisposableArray = null;
        }
        return bl2;
    }

    public boolean m1() {
        boolean bl2;
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        Object object = this.a.get();
        if (object == (completableSubject$CompletableDisposableArray = e) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int n1() {
        return ((CompletableSubject$CompletableDisposable[])this.a.get()).length;
    }

    public void o1(CompletableSubject$CompletableDisposable completableSubject$CompletableDisposable) {
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (completableSubject$CompletableDisposableArray2 = (CompletableSubject$CompletableDisposable[])this.a.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                completableSubject$CompletableDisposableArray3 = completableSubject$CompletableDisposableArray2[n10];
                if (completableSubject$CompletableDisposableArray3 != completableSubject$CompletableDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                completableSubject$CompletableDisposableArray = d;
                continue;
            }
            int n14 = n11 + -1;
            completableSubject$CompletableDisposableArray3 = new CompletableSubject$CompletableDisposable[n14];
            System.arraycopy(completableSubject$CompletableDisposableArray2, 0, completableSubject$CompletableDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(completableSubject$CompletableDisposableArray2, n13, completableSubject$CompletableDisposableArray3, n12, n11);
            completableSubject$CompletableDisposableArray = completableSubject$CompletableDisposableArray3;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(completableSubject$CompletableDisposableArray2, completableSubject$CompletableDisposableArray)));
    }

    public void onComplete() {
        Serializable serializable = this.b;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)serializable).compareAndSet(false, n10 != 0);
        if (bl2) {
            serializable = this.a;
            CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray = e;
            serializable = ((AtomicReference)serializable).getAndSet(completableSubject$CompletableDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                d d10 = ((CompletableSubject$CompletableDisposable)serializable[i10]).downstream;
                d10.onComplete();
            }
        }
    }

    public void onError(Throwable throwable) {
        e.a.w0.b.a.g(throwable, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        Serializable serializable = this.b;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)serializable).compareAndSet(false, n10 != 0);
        if (bl2) {
            this.c = throwable;
            serializable = this.a;
            CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray = e;
            serializable = ((AtomicReference)serializable).getAndSet(completableSubject$CompletableDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                d d10 = ((CompletableSubject$CompletableDisposable)serializable[i10]).downstream;
                d10.onError(throwable);
            }
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        CompletableSubject$CompletableDisposable[] completableSubject$CompletableDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (completableSubject$CompletableDisposableArray = e)) {
            b10.dispose();
        }
    }
}

