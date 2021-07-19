/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.q1;
import h.k0;
import h.m0;
import h.n0$a;
import h.n0$b;

public final class n0 {
    private long a;
    private long b;
    private long c;
    private long d;

    public n0() {
        long l10 = System.nanoTime();
        this(l10);
    }

    public n0(long l10) {
        this.d = l10;
        this.b = 8192L;
        this.c = 262144L;
    }

    public static /* synthetic */ void e(n0 n02, long l10, long l11, long l12, int n10, Object object) {
        int n11 = n10 & 2;
        if (n11 != 0) {
            l11 = n02.b;
        }
        long l13 = l11;
        int n12 = n10 & 4;
        if (n12 != 0) {
            l12 = n02.c;
        }
        n02.d(l10, l13, l12);
    }

    private final long f(long l10) {
        long l11 = this.a;
        return (l10 *= 1000000000L) / l11;
    }

    private final long g(long l10) {
        long l11 = this.a;
        return l10 * l11 / 1000000000L;
    }

    private final void k(long l10) {
        long l11 = 1000000L;
        long l12 = l10 / l11;
        int n10 = (int)(l10 - (l11 *= l12));
        this.wait(l12, n10);
    }

    public final long a(long l10, long l11) {
        long l12 = this.a;
        long l13 = 0L;
        long l14 = l12 - l13;
        Object object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
        if (object == false) {
            return l11;
        }
        l12 = Math.max(this.d - l10, l13);
        long l15 = this.c;
        long l16 = this.g(l12);
        long l17 = (l15 -= l16) - l11;
        Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object2 >= 0) {
            l10 += l12;
            l12 = this.f(l11);
            this.d = l10 += l12;
            return l11;
        }
        l16 = this.b;
        long l18 = l15 - l16;
        Object object3 = l18 == 0L ? 0 : (l18 < 0L ? -1 : 1);
        if (object3 >= 0) {
            l11 = this.c;
            l11 = this.f(l11);
            this.d = l10 += l11;
            return l15;
        }
        l11 = Math.min(l16, l11);
        l15 = this.c;
        l15 = l11 - l15;
        long l19 = (l12 += (l15 = this.f(l15))) - l13;
        Object object4 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
        if (object4 == false) {
            l12 = this.c;
            l12 = this.f(l12);
            this.d = l10 += l12;
            return l11;
        }
        return -l12;
    }

    public final void b(long l10) {
        n0.e(this, l10, 0L, 0L, 6, null);
    }

    public final void c(long l10, long l11) {
        n0.e(this, l10, l11, 0L, 4, null);
    }

    public final void d(long l10, long l11, long l12) {
        synchronized (this) {
            String string2;
            long l13 = 0L;
            long l14 = l10 == l13 ? 0 : (l10 < l13 ? -1 : 1);
            int n10 = 1;
            l14 = l14 >= 0 ? (long)n10 : (long)0;
            if (l14 != false) {
                Object object = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                object = object > 0 ? (Object)n10 : (Object)0;
                if (object != false) {
                    object = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                    if (object < 0) {
                        n10 = 0;
                    }
                    if (n10 != 0) {
                        this.a = l10;
                        this.b = l11;
                        this.c = l12;
                        this.notifyAll();
                        q1 q12 = q1.a;
                        return;
                    }
                    string2 = "Failed requirement.";
                    string2 = string2.toString();
                    IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                    throw illegalArgumentException;
                }
                string2 = "Failed requirement.";
                string2 = string2.toString();
                IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
                throw illegalArgumentException;
            }
            string2 = "Failed requirement.";
            string2 = string2.toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
    }

    public final k0 h(k0 k02) {
        f0.p(k02, "sink");
        n0$a n0$a = new n0$a(this, k02, k02);
        return n0$a;
    }

    public final m0 i(m0 m02) {
        f0.p(m02, "source");
        n0$b n0$b = new n0$b(this, m02, m02);
        return n0$b;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final long j(long l10) {
        long l11 = 0L;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        object = object > 0 ? (Object)1 : (Object)0;
        if (object == false) {
            String string2 = "Failed requirement.".toString();
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string2);
            throw illegalArgumentException;
        }
        synchronized (this) {
            while (true) {
                long l13 = System.nanoTime();
                long l14 = (l13 = this.a(l13, l10)) - l11;
                Object l142 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
                if (l142 >= 0) {
                    return l13;
                }
                l13 = -l13;
                this.k(l13);
            }
        }
    }
}

