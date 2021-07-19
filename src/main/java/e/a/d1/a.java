/*
 * Decompiled with CFR 0.151.
 */
package e.a.d1;

import e.a.d1.a$a;
import e.a.d1.c;
import e.a.g0;
import e.a.s0.b;
import io.reactivex.internal.util.ExceptionHelper;
import io.reactivex.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

public final class a
extends c {
    private static final Object[] h = new Object[0];
    public static final a$a[] i = new a$a[0];
    public static final a$a[] j = new a$a[0];
    public final AtomicReference a;
    public final AtomicReference b;
    public final ReadWriteLock c;
    public final Lock d;
    public final Lock e;
    public final AtomicReference f;
    public long g;

    public a() {
        AtomicReference atomicReference = new AtomicReference();
        this.c = atomicReference;
        a$a[] a$aArray = atomicReference.readLock();
        this.d = a$aArray;
        atomicReference = atomicReference.writeLock();
        this.e = atomicReference;
        a$aArray = i;
        this.b = atomicReference = new AtomicReference(a$aArray);
        this.a = atomicReference = new AtomicReference();
        this.f = atomicReference = new AtomicReference();
    }

    public a(Object object) {
        this();
        AtomicReference atomicReference = this.a;
        object = e.a.w0.b.a.g(object, "defaultValue is null");
        atomicReference.lazySet(object);
    }

    public static a n8() {
        a a10 = new a();
        return a10;
    }

    public static a o8(Object object) {
        a a10 = new a(object);
        return a10;
    }

    public void K5(g0 g02) {
        Object object = new a$a(g02, this);
        g02.onSubscribe((b)object);
        boolean bl2 = this.m8((a$a)object);
        if (bl2) {
            boolean bl3 = ((a$a)object).g;
            if (bl3) {
                this.t8((a$a)object);
            } else {
                ((a$a)object).a();
            }
        } else {
            Throwable throwable;
            object = (Throwable)this.f.get();
            if (object == (throwable = ExceptionHelper.a)) {
                g02.onComplete();
            } else {
                g02.onError((Throwable)object);
            }
        }
    }

    public Throwable h8() {
        Object v10 = this.a.get();
        boolean bl2 = NotificationLite.isError(v10);
        if (bl2) {
            return NotificationLite.getError(v10);
        }
        return null;
    }

    public boolean i8() {
        return NotificationLite.isComplete(this.a.get());
    }

    public boolean j8() {
        a$a[] a$aArray = (a$a[])this.b.get();
        boolean bl2 = a$aArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            a$aArray = null;
        }
        return bl2;
    }

    public boolean k8() {
        return NotificationLite.isError(this.a.get());
    }

    public boolean m8(a$a a$a) {
        a$a[] a$aArray;
        a$a[] a$aArray2;
        Object object;
        boolean bl2;
        do {
            if ((a$aArray2 = (a$a[])this.b.get()) == (object = j)) {
                return false;
            }
            int n10 = a$aArray2.length;
            int n11 = n10 + 1;
            a$aArray = new a$a[n11];
            System.arraycopy(a$aArray2, 0, a$aArray, 0, n10);
            a$aArray[n10] = a$a;
        } while (!(bl2 = ((AtomicReference)(object = this.b)).compareAndSet(a$aArray2, a$aArray)));
        return true;
    }

    public void onComplete() {
        Object object = this.f;
        a$a[] a$aArray = ExceptionHelper.a;
        int n10 = 0;
        boolean bl2 = ((AtomicReference)object).compareAndSet(null, a$aArray);
        if (!bl2) {
            return;
        }
        object = NotificationLite.complete();
        for (a$a a$a : this.w8(object)) {
            long l10 = this.g;
            a$a.c(object, l10);
        }
    }

    public void onError(Throwable object) {
        e.a.w0.b.a.g(object, "onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        a$a[] a$aArray = this.f;
        int n10 = 0;
        boolean bl2 = a$aArray.compareAndSet(null, object);
        if (!bl2) {
            e.a.a1.a.Y((Throwable)object);
            return;
        }
        object = NotificationLite.error((Throwable)object);
        for (a$a a$a : this.w8(object)) {
            long l10 = this.g;
            a$a.c(object, l10);
        }
    }

    public void onNext(Object object) {
        e.a.w0.b.a.g(object, "onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        Object object2 = this.f.get();
        if (object2 != null) {
            return;
        }
        object = NotificationLite.next(object);
        this.u8(object);
        for (a$a a$a : (a$a[])this.b.get()) {
            long l10 = this.g;
            a$a.c(object, l10);
        }
    }

    public void onSubscribe(b b10) {
        Object v10 = this.f.get();
        if (v10 != null) {
            b10.dispose();
        }
    }

    public Object p8() {
        Object v10 = this.a.get();
        boolean bl2 = NotificationLite.isComplete(v10);
        if (!bl2 && !(bl2 = NotificationLite.isError(v10))) {
            return NotificationLite.getValue(v10);
        }
        return null;
    }

    public Object[] q8() {
        Object[] objectArray = h;
        Object[] objectArray2 = this.r8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] r8(Object[] objectArray) {
        int n10;
        Object object = this.a.get();
        if (object != null && (n10 = NotificationLite.isComplete(object)) == 0 && (n10 = NotificationLite.isError(object)) == 0) {
            object = NotificationLite.getValue(object);
            n10 = objectArray.length;
            int n11 = 1;
            if (n10 != 0) {
                objectArray[0] = object;
                int n12 = objectArray.length;
                if (n12 != n11) {
                    objectArray[n11] = null;
                }
            } else {
                objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n11);
                objectArray[0] = object;
            }
            return objectArray;
        }
        int n13 = objectArray.length;
        if (n13 != 0) {
            objectArray[0] = null;
        }
        return objectArray;
    }

    public boolean s8() {
        boolean bl2;
        boolean bl3;
        Object v10 = this.a.get();
        if (v10 != null && !(bl3 = NotificationLite.isComplete(v10)) && !(bl2 = NotificationLite.isError(v10))) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void t8(a$a a$a) {
        a$a[] a$aArray;
        a$a[] a$aArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            a$a[] a$aArray3;
            int n10;
            int n11;
            if ((n11 = (a$aArray2 = (a$a[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                a$aArray3 = a$aArray2[n10];
                if (a$aArray3 != a$a) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                a$aArray = i;
                continue;
            }
            int n14 = n11 + -1;
            a$aArray3 = new a$a[n14];
            System.arraycopy(a$aArray2, 0, a$aArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(a$aArray2, n13, a$aArray3, n12, n11);
            a$aArray = a$aArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(a$aArray2, a$aArray)));
    }

    public void u8(Object object) {
        long l10;
        this.e.lock();
        this.g = l10 = this.g + 1L;
        this.a.lazySet(object);
        this.e.unlock();
    }

    public int v8() {
        return ((a$a[])this.b.get()).length;
    }

    public a$a[] w8(Object object) {
        a$a[] a$aArray = this.b;
        a$a[] a$aArray2 = j;
        if ((a$aArray = a$aArray.getAndSet(a$aArray2)) != a$aArray2) {
            this.u8(object);
        }
        return a$aArray;
    }
}

