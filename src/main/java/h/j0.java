/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import h.i0;
import java.util.concurrent.atomic.AtomicReference;

public final class j0 {
    private static final int a;
    private static final i0 b;
    private static final int c;
    private static final AtomicReference[] d;
    public static final j0 e;

    static {
        int n10;
        AtomicReference[] atomicReferenceArray = new j0();
        e = atomicReferenceArray;
        a = 65536;
        Object object = new byte[]{};
        AtomicReference[] atomicReferenceArray2 = atomicReferenceArray;
        atomicReferenceArray = new i0((byte[])object, 0, 0, false, false);
        b = atomicReferenceArray;
        atomicReferenceArray = Runtime.getRuntime();
        c = n10 = Integer.highestOneBit(atomicReferenceArray.availableProcessors() * 2 + -1);
        atomicReferenceArray2 = new AtomicReference[n10];
        for (int i10 = 0; i10 < n10; ++i10) {
            object = new AtomicReference;
            object();
            atomicReferenceArray2[i10] = object;
        }
        d = atomicReferenceArray2;
    }

    private j0() {
    }

    private final AtomicReference a() {
        Thread thread = Thread.currentThread();
        f0.o(thread, "Thread.currentThread()");
        long l10 = thread.getId();
        long l11 = (long)c - 1L;
        int n10 = (int)(l10 & l11);
        return d[n10];
    }

    public static final void d(i0 object) {
        boolean bl2;
        f0.p(object, "segment");
        Object object2 = ((i0)object).f;
        if (object2 == null && (object2 = ((i0)object).g) == null) {
            bl2 = true;
        } else {
            bl2 = false;
            object2 = null;
        }
        if (bl2) {
            int n10;
            i0 i02;
            bl2 = ((i0)object).d;
            if (bl2) {
                return;
            }
            object2 = e.a();
            i0 i03 = (i0)((AtomicReference)object2).get();
            if (i03 == (i02 = b)) {
                return;
            }
            if (i03 != null) {
                n10 = i03.c;
            } else {
                n10 = 0;
                i02 = null;
            }
            int n11 = a;
            if (n10 >= n11) {
                return;
            }
            ((i0)object).f = i03;
            ((i0)object).b = 0;
            ((i0)object).c = n10 += 8192;
            bl2 = ((AtomicReference)object2).compareAndSet(i03, object);
            if (!bl2) {
                bl2 = false;
                object2 = null;
                ((i0)object).f = null;
            }
            return;
        }
        object2 = "Failed requirement.".toString();
        object = new IllegalArgumentException((String)object2);
        throw object;
    }

    public static final i0 e() {
        i0 i02;
        Object object = e.a();
        i0 i03 = ((AtomicReference)object).getAndSet(i02 = b);
        if (i03 == i02) {
            object = new i0();
            return object;
        }
        i02 = null;
        if (i03 == null) {
            ((AtomicReference)object).set(null);
            object = new i0();
            return object;
        }
        i0 i04 = i03.f;
        ((AtomicReference)object).set(i04);
        i03.f = null;
        i03.c = 0;
        return i03;
    }

    public final int b() {
        i0 i02 = (i0)this.a().get();
        if (i02 != null) {
            return i02.c;
        }
        return 0;
    }

    public final int c() {
        return a;
    }
}

