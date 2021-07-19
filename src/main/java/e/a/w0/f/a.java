/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.f;

import e.a.w0.c.n;
import e.a.w0.i.l;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;

public final class a
implements n {
    public static final int i;
    private static final Object j;
    public final AtomicLong a;
    public int b;
    public long c;
    public final int d;
    public AtomicReferenceArray e;
    public final int f;
    public AtomicReferenceArray g;
    public final AtomicLong h;

    static {
        Object object;
        i = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
        j = object = new Object();
    }

    public a(int n10) {
        long l10;
        AtomicReferenceArray atomicReferenceArray;
        AtomicLong atomicLong;
        this.a = atomicLong = new AtomicLong();
        this.h = atomicLong = new AtomicLong();
        n10 = l.b(Math.max(8, n10));
        int n11 = n10 + -1;
        int n12 = n10 + 1;
        this.e = atomicReferenceArray = new AtomicReferenceArray(n12);
        this.d = n11;
        this.a(n10);
        this.g = atomicReferenceArray;
        this.f = n11;
        this.c = l10 = (long)(n11 + -1);
        this.q(0L);
    }

    private void a(int n10) {
        n10 /= 4;
        int n11 = i;
        this.b = n10 = Math.min(n10, n11);
    }

    private static int b(int n10) {
        return n10;
    }

    private static int c(long l10, int n10) {
        return e.a.w0.f.a.b((int)l10 & n10);
    }

    private long d() {
        return this.h.get();
    }

    private long e() {
        return this.a.get();
    }

    private long f() {
        return this.h.get();
    }

    private static Object g(AtomicReferenceArray atomicReferenceArray, int n10) {
        return atomicReferenceArray.get(n10);
    }

    private AtomicReferenceArray h(AtomicReferenceArray atomicReferenceArray, int n10) {
        n10 = e.a.w0.f.a.b(n10);
        AtomicReferenceArray atomicReferenceArray2 = (AtomicReferenceArray)e.a.w0.f.a.g(atomicReferenceArray, n10);
        e.a.w0.f.a.o(atomicReferenceArray, n10, null);
        return atomicReferenceArray2;
    }

    private long i() {
        return this.a.get();
    }

    private Object j(AtomicReferenceArray atomicReferenceArray, long l10, int n10) {
        this.g = atomicReferenceArray;
        int n11 = e.a.w0.f.a.c(l10, n10);
        return e.a.w0.f.a.g(atomicReferenceArray, n11);
    }

    private Object k(AtomicReferenceArray atomicReferenceArray, long l10, int n10) {
        this.g = atomicReferenceArray;
        Object object = e.a.w0.f.a.g(atomicReferenceArray, n10 = e.a.w0.f.a.c(l10, n10));
        if (object != null) {
            e.a.w0.f.a.o(atomicReferenceArray, n10, null);
            long l11 = 1L;
            this.n(l10 += l11);
        }
        return object;
    }

    private void l(AtomicReferenceArray atomicReferenceArray, long l10, int n10, Object object, long l11) {
        AtomicReferenceArray atomicReferenceArray2;
        int n11 = atomicReferenceArray.length();
        this.e = atomicReferenceArray2 = new AtomicReferenceArray(n11);
        l11 += l10;
        long l12 = 1L;
        this.c = l11 -= l12;
        e.a.w0.f.a.o(atomicReferenceArray2, n10, object);
        this.p(atomicReferenceArray, atomicReferenceArray2);
        object = j;
        e.a.w0.f.a.o(atomicReferenceArray, n10, object);
        this.q(l10 += l12);
    }

    private void n(long l10) {
        this.h.lazySet(l10);
    }

    private static void o(AtomicReferenceArray atomicReferenceArray, int n10, Object object) {
        atomicReferenceArray.lazySet(n10, object);
    }

    private void p(AtomicReferenceArray atomicReferenceArray, AtomicReferenceArray atomicReferenceArray2) {
        int n10 = e.a.w0.f.a.b(atomicReferenceArray.length() + -1);
        e.a.w0.f.a.o(atomicReferenceArray, n10, atomicReferenceArray2);
    }

    private void q(long l10) {
        this.a.lazySet(l10);
    }

    private boolean r(AtomicReferenceArray atomicReferenceArray, Object object, long l10, int n10) {
        e.a.w0.f.a.o(atomicReferenceArray, n10, object);
        this.q(++l10);
        return true;
    }

    public void clear() {
        boolean bl2;
        Object object;
        while ((object = this.poll()) != null || !(bl2 = this.isEmpty())) {
        }
    }

    public boolean isEmpty() {
        long l10;
        long l11 = this.i();
        long l12 = l11 - (l10 = this.f());
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object == false ? (Object)1 : (Object)0;
        return (boolean)object;
    }

    public int m() {
        long l10 = this.f();
        while (true) {
            long l11 = this.i();
            long l12 = this.f();
            long l13 = l10 - l12;
            Object object = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object == false) {
                return (int)(l11 - l12);
            }
            l10 = l12;
        }
    }

    public boolean offer(Object object) {
        String string2 = "Null is not a valid element";
        Objects.requireNonNull(object, string2);
        AtomicReferenceArray atomicReferenceArray = this.e;
        long l10 = this.e();
        int n10 = this.d;
        int n11 = e.a.w0.f.a.c(l10, n10);
        long l11 = this.c;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 < 0) {
            a a10 = this;
            return this.r(atomicReferenceArray, object, l10, n11);
        }
        l11 = (long)this.b + l10;
        l12 = e.a.w0.f.a.c(l11, n10);
        Object object2 = e.a.w0.f.a.g(atomicReferenceArray, (int)l12);
        long l13 = 1L;
        if (object2 == null) {
            this.c = l11 -= l13;
            object2 = this;
            return this.r(atomicReferenceArray, object, l10, n11);
        }
        l12 = e.a.w0.f.a.c(l13 += l10, n10);
        object2 = e.a.w0.f.a.g(atomicReferenceArray, (int)l12);
        if (object2 == null) {
            object2 = this;
            return this.r(atomicReferenceArray, object, l10, n11);
        }
        l11 = n10;
        object2 = this;
        this.l(atomicReferenceArray, l10, n11, object, l11);
        return true;
    }

    public boolean offer(Object object, Object object2) {
        int n10;
        AtomicReferenceArray atomicReferenceArray = this.e;
        long l10 = this.i();
        long l11 = (long)2 + l10;
        int n11 = e.a.w0.f.a.c(l11, n10 = this.d);
        Object object3 = e.a.w0.f.a.g(atomicReferenceArray, n11);
        if (object3 == null) {
            int n12 = e.a.w0.f.a.c(l10, n10);
            int n13 = n12 + 1;
            e.a.w0.f.a.o(atomicReferenceArray, n13, object2);
            e.a.w0.f.a.o(atomicReferenceArray, n12, object);
            this.q(l11);
        } else {
            AtomicReferenceArray atomicReferenceArray2;
            n11 = atomicReferenceArray.length();
            this.e = atomicReferenceArray2 = new AtomicReferenceArray(n11);
            int n14 = e.a.w0.f.a.c(l10, n10);
            int n15 = n14 + 1;
            e.a.w0.f.a.o(atomicReferenceArray2, n15, object2);
            e.a.w0.f.a.o(atomicReferenceArray2, n14, object);
            this.p(atomicReferenceArray, atomicReferenceArray2);
            object = j;
            e.a.w0.f.a.o(atomicReferenceArray, n14, object);
            this.q(l11);
        }
        return true;
    }

    public Object peek() {
        Object object;
        int n10;
        AtomicReferenceArray atomicReferenceArray = this.g;
        long l10 = this.d();
        int n11 = e.a.w0.f.a.c(l10, n10 = this.f);
        Object object2 = e.a.w0.f.a.g(atomicReferenceArray, n11);
        if (object2 == (object = j)) {
            n11 = n10 + 1;
            atomicReferenceArray = this.h(atomicReferenceArray, n11);
            return this.j(atomicReferenceArray, l10, n10);
        }
        return object2;
    }

    public Object poll() {
        boolean bl2;
        Object object;
        int n10;
        AtomicReferenceArray atomicReferenceArray = this.g;
        long l10 = this.d();
        int n11 = e.a.w0.f.a.c(l10, n10 = this.f);
        Object object2 = e.a.w0.f.a.g(atomicReferenceArray, n11);
        if (object2 == (object = j)) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        if (object2 != null && !bl2) {
            e.a.w0.f.a.o(atomicReferenceArray, n11, null);
            this.n(++l10);
            return object2;
        }
        if (bl2) {
            n11 = n10 + 1;
            atomicReferenceArray = this.h(atomicReferenceArray, n11);
            return this.k(atomicReferenceArray, l10, n10);
        }
        return null;
    }
}

