/*
 * Decompiled with CFR 0.151.
 */
package io.reactivex.subjects;

import e.a.a1.a;
import e.a.q;
import e.a.s0.b;
import e.a.t;
import io.reactivex.subjects.MaybeSubject$MaybeDisposable;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class MaybeSubject
extends q
implements t {
    public static final MaybeSubject$MaybeDisposable[] e = new MaybeSubject$MaybeDisposable[0];
    public static final MaybeSubject$MaybeDisposable[] f = new MaybeSubject$MaybeDisposable[0];
    public final AtomicReference a;
    public final AtomicBoolean b;
    public Object c;
    public Throwable d;

    public MaybeSubject() {
        Serializable serializable;
        this.b = serializable = new AtomicBoolean();
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray = e;
        super(maybeSubject$MaybeDisposableArray);
        this.a = serializable;
    }

    public static MaybeSubject f2() {
        MaybeSubject maybeSubject = new MaybeSubject();
        return maybeSubject;
    }

    public boolean e2(MaybeSubject$MaybeDisposable maybeSubject$MaybeDisposable) {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray2;
        Object object;
        boolean bl2;
        do {
            if ((maybeSubject$MaybeDisposableArray2 = (MaybeSubject$MaybeDisposable[])this.a.get()) == (object = f)) {
                return false;
            }
            int n10 = maybeSubject$MaybeDisposableArray2.length;
            int n11 = n10 + 1;
            maybeSubject$MaybeDisposableArray = new MaybeSubject$MaybeDisposable[n11];
            System.arraycopy(maybeSubject$MaybeDisposableArray2, 0, maybeSubject$MaybeDisposableArray, 0, n10);
            maybeSubject$MaybeDisposableArray[n10] = maybeSubject$MaybeDisposable;
        } while (!(bl2 = ((AtomicReference)(object = this.a)).compareAndSet(maybeSubject$MaybeDisposableArray2, maybeSubject$MaybeDisposableArray)));
        return true;
    }

    public Throwable g2() {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (maybeSubject$MaybeDisposableArray = f)) {
            return this.d;
        }
        return null;
    }

    public Object h2() {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (maybeSubject$MaybeDisposableArray = f)) {
            return this.c;
        }
        return null;
    }

    public boolean i2() {
        boolean bl2;
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object object = this.a.get();
        if (object == (maybeSubject$MaybeDisposableArray = f) && (object = this.c) == null && (object = this.d) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean j2() {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray = (MaybeSubject$MaybeDisposable[])this.a.get();
        boolean bl2 = maybeSubject$MaybeDisposableArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            maybeSubject$MaybeDisposableArray = null;
        }
        return bl2;
    }

    public boolean k2() {
        boolean bl2;
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object object = this.a.get();
        if (object == (maybeSubject$MaybeDisposableArray = f) && (object = this.d) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public boolean l2() {
        boolean bl2;
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object object = this.a.get();
        if (object == (maybeSubject$MaybeDisposableArray = f) && (object = this.c) != null) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int m2() {
        return ((MaybeSubject$MaybeDisposable[])this.a.get()).length;
    }

    public void n2(MaybeSubject$MaybeDisposable maybeSubject$MaybeDisposable) {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray3;
            int n10;
            int n11;
            if ((n11 = (maybeSubject$MaybeDisposableArray2 = (MaybeSubject$MaybeDisposable[])this.a.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                maybeSubject$MaybeDisposableArray3 = maybeSubject$MaybeDisposableArray2[n10];
                if (maybeSubject$MaybeDisposableArray3 != maybeSubject$MaybeDisposable) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                maybeSubject$MaybeDisposableArray = e;
                continue;
            }
            int n14 = n11 + -1;
            maybeSubject$MaybeDisposableArray3 = new MaybeSubject$MaybeDisposable[n14];
            System.arraycopy(maybeSubject$MaybeDisposableArray2, 0, maybeSubject$MaybeDisposableArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(maybeSubject$MaybeDisposableArray2, n13, maybeSubject$MaybeDisposableArray3, n12, n11);
            maybeSubject$MaybeDisposableArray = maybeSubject$MaybeDisposableArray3;
        } while (!(bl2 = (atomicReference = this.a).compareAndSet(maybeSubject$MaybeDisposableArray2, maybeSubject$MaybeDisposableArray)));
    }

    public void onComplete() {
        Serializable serializable = this.b;
        int n10 = 1;
        boolean bl2 = ((AtomicBoolean)serializable).compareAndSet(false, n10 != 0);
        if (bl2) {
            serializable = this.a;
            MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray = f;
            serializable = ((AtomicReference)serializable).getAndSet(maybeSubject$MaybeDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                t t10 = ((MaybeSubject$MaybeDisposable)serializable[i10]).downstream;
                t10.onComplete();
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
            MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray = f;
            serializable = ((AtomicReference)serializable).getAndSet(maybeSubject$MaybeDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                t t10 = ((MaybeSubject$MaybeDisposable)serializable[i10]).downstream;
                t10.onError(throwable);
            }
        } else {
            e.a.a1.a.Y(throwable);
        }
    }

    public void onSubscribe(b b10) {
        MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray;
        Object v10 = this.a.get();
        if (v10 == (maybeSubject$MaybeDisposableArray = f)) {
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
            MaybeSubject$MaybeDisposable[] maybeSubject$MaybeDisposableArray = f;
            serializable = ((AtomicReference)serializable).getAndSet(maybeSubject$MaybeDisposableArray);
            n10 = ((Serializable)serializable).length;
            for (int i10 = 0; i10 < n10; ++i10) {
                t t10 = ((MaybeSubject$MaybeDisposable)serializable[i10]).downstream;
                t10.onSuccess(object);
            }
        }
    }

    public void t1(t t10) {
        Object object = new MaybeSubject$MaybeDisposable(t10, this);
        t10.onSubscribe((b)object);
        boolean bl2 = this.e2((MaybeSubject$MaybeDisposable)object);
        if (bl2) {
            boolean bl3 = ((MaybeSubject$MaybeDisposable)object).isDisposed();
            if (bl3) {
                this.n2((MaybeSubject$MaybeDisposable)object);
            }
        } else {
            object = this.d;
            if (object != null) {
                t10.onError((Throwable)object);
            } else {
                object = this.c;
                if (object == null) {
                    t10.onComplete();
                } else {
                    t10.onSuccess(object);
                }
            }
        }
    }
}

