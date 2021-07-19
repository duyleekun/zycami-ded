/*
 * Decompiled with CFR 0.151.
 */
package d.k.b;

import d.k.b.b$a;
import d.k.b.c;
import e.a.g0;
import java.lang.reflect.Array;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class b
extends c {
    private static final Object[] f = new Object[0];
    public static final b$a[] g = new b$a[0];
    public final AtomicReference a;
    public final AtomicReference b;
    public final Lock c;
    public final Lock d;
    public long e;

    public b() {
        AtomicReference atomicReference = new AtomicReference();
        b$a[] b$aArray = atomicReference.readLock();
        this.c = b$aArray;
        atomicReference = atomicReference.writeLock();
        this.d = atomicReference;
        b$aArray = g;
        this.b = atomicReference = new AtomicReference(b$aArray);
        this.a = atomicReference = new AtomicReference();
    }

    public b(Object object) {
        this();
        Objects.requireNonNull(object, "defaultValue == null");
        this.a.lazySet(object);
    }

    public static b k8() {
        b b10 = new b();
        return b10;
    }

    public static b l8(Object object) {
        b b10 = new b(object);
        return b10;
    }

    public void K5(g0 g02) {
        b$a b$a = new b$a(g02, this);
        g02.onSubscribe(b$a);
        this.j8(b$a);
        boolean bl2 = b$a.g;
        if (bl2) {
            this.q8(b$a);
        } else {
            b$a.a();
        }
    }

    public void accept(Object object) {
        Objects.requireNonNull(object, "value == null");
        this.r8(object);
        for (b$a b$a : (b$a[])this.b.get()) {
            long l10 = this.e;
            b$a.c(object, l10);
        }
    }

    public boolean h8() {
        b$a[] b$aArray = (b$a[])this.b.get();
        boolean bl2 = b$aArray.length;
        if (bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            b$aArray = null;
        }
        return bl2;
    }

    public void j8(b$a b$a) {
        b$a[] b$aArray;
        b$a[] b$aArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            b$aArray2 = (b$a[])this.b.get();
            int n10 = b$aArray2.length;
            int n11 = n10 + 1;
            b$aArray = new b$a[n11];
            System.arraycopy(b$aArray2, 0, b$aArray, 0, n10);
            b$aArray[n10] = b$a;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(b$aArray2, b$aArray)));
    }

    public Object m8() {
        return this.a.get();
    }

    public Object[] n8() {
        Object[] objectArray = f;
        Object[] objectArray2 = this.o8(objectArray);
        if (objectArray2 == objectArray) {
            return new Object[0];
        }
        return objectArray2;
    }

    public Object[] o8(Object[] objectArray) {
        Object v10 = this.a.get();
        if (v10 == null) {
            int n10 = objectArray.length;
            if (n10 != 0) {
                objectArray[0] = null;
            }
            return objectArray;
        }
        int n11 = objectArray.length;
        int n12 = 1;
        if (n11 != 0) {
            objectArray[0] = v10;
            int n13 = objectArray.length;
            if (n13 != n12) {
                objectArray[n12] = null;
            }
        } else {
            objectArray = (Object[])Array.newInstance(objectArray.getClass().getComponentType(), n12);
            objectArray[0] = v10;
        }
        return objectArray;
    }

    public boolean p8() {
        boolean bl2;
        Object v10 = this.a.get();
        if (v10 != null) {
            bl2 = true;
        } else {
            bl2 = false;
            v10 = null;
        }
        return bl2;
    }

    public void q8(b$a b$a) {
        b$a[] b$aArray;
        b$a[] b$aArray2;
        AtomicReference atomicReference;
        boolean bl2;
        do {
            b$a[] b$aArray3;
            int n10;
            int n11;
            if ((n11 = (b$aArray2 = (b$a[])this.b.get()).length) == 0) {
                return;
            }
            int n12 = -1;
            int n13 = 0;
            for (n10 = 0; n10 < n11; ++n10) {
                b$aArray3 = b$aArray2[n10];
                if (b$aArray3 != b$a) continue;
                n12 = n10;
                break;
            }
            if (n12 < 0) {
                return;
            }
            n10 = 1;
            if (n11 == n10) {
                b$aArray = g;
                continue;
            }
            int n14 = n11 + -1;
            b$aArray3 = new b$a[n14];
            System.arraycopy(b$aArray2, 0, b$aArray3, 0, n12);
            n13 = n12 + 1;
            n11 = n11 - n12 - n10;
            System.arraycopy(b$aArray2, n13, b$aArray3, n12, n11);
            b$aArray = b$aArray3;
        } while (!(bl2 = (atomicReference = this.b).compareAndSet(b$aArray2, b$aArray)));
    }

    public void r8(Object object) {
        long l10;
        this.d.lock();
        this.e = l10 = this.e + 1L;
        this.a.lazySet(object);
        this.d.unlock();
    }

    public int s8() {
        return ((b$a[])this.b.get()).length;
    }
}

