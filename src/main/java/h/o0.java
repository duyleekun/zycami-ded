/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.s.a;
import f.h2.t.c0;
import f.h2.t.f0;
import h.o0$a;
import h.o0$b;
import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;

public class o0 {
    public static final o0 d;
    public static final o0$b e;
    private boolean a;
    private long b;
    private long c;

    static {
        Object object = new o0$b(null);
        e = object;
        d = object = new o0$a();
    }

    public o0 a() {
        this.a = false;
        return this;
    }

    public o0 b() {
        this.c = 0L;
        return this;
    }

    public final o0 c(long l10, TimeUnit object) {
        String string2 = "unit";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 > 0) {
            l12 = 1;
        } else {
            l12 = 0;
            string2 = null;
        }
        if (l12 != false) {
            l11 = System.nanoTime();
            l10 = ((TimeUnit)((Object)object)).toNanos(l10);
            return this.e(l11 += l10);
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("duration <= 0: ");
        ((StringBuilder)object).append(l10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public long d() {
        boolean bl2 = this.a;
        if (bl2) {
            return this.b;
        }
        String string2 = "No deadline".toString();
        IllegalStateException illegalStateException = new IllegalStateException(string2);
        throw illegalStateException;
    }

    public o0 e(long l10) {
        this.a = true;
        this.b = l10;
        return this;
    }

    public boolean f() {
        return this.a;
    }

    public final void g(o0 o02, a a10) {
        block11: {
            int n10;
            boolean bl2;
            TimeUnit timeUnit;
            long l10;
            Object object;
            long l11;
            block10: {
                f0.p(o02, "other");
                String string2 = "block";
                f0.p(a10, string2);
                l11 = this.j();
                object = e;
                long l12 = o02.j();
                l10 = this.j();
                long l13 = object.a(l12, l10);
                timeUnit = TimeUnit.NANOSECONDS;
                this.i(l13, timeUnit);
                bl2 = this.f();
                n10 = 1;
                if (!bl2) break block10;
                l10 = this.d();
                bl2 = o02.f();
                if (bl2) {
                    long l14 = this.d();
                    long l15 = o02.d();
                    l14 = Math.min(l14, l15);
                    this.e(l14);
                }
                try {
                    a10.invoke();
                }
                catch (Throwable throwable) {
                    c0.d(n10);
                    object = TimeUnit.NANOSECONDS;
                    this.i(l11, (TimeUnit)((Object)object));
                    boolean bl3 = o02.f();
                    if (bl3) {
                        this.e(l10);
                    }
                    c0.c(n10);
                    throw throwable;
                }
                c0.d(n10);
                this.i(l11, timeUnit);
                boolean bl4 = o02.f();
                if (bl4) {
                    this.e(l10);
                }
                c0.c(n10);
                break block11;
            }
            bl2 = o02.f();
            if (bl2) {
                l10 = o02.d();
                this.e(l10);
            }
            try {
                a10.invoke();
            }
            catch (Throwable throwable) {
                c0.d(n10);
                object = TimeUnit.NANOSECONDS;
                this.i(l11, (TimeUnit)((Object)object));
                boolean bl5 = o02.f();
                if (bl5) {
                    this.a();
                }
                c0.c(n10);
                throw throwable;
            }
            c0.d(n10);
            this.i(l11, timeUnit);
            boolean bl6 = o02.f();
            if (bl6) {
                this.a();
            }
            c0.c(n10);
        }
    }

    public void h() {
        Object object = Thread.interrupted();
        if (object == 0) {
            object = this.a;
            if (object != 0) {
                long l10 = this.b;
                long l11 = System.nanoTime();
                long l12 = (l10 -= l11) - (l11 = 0L);
                object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
                if (object <= 0) {
                    InterruptedIOException interruptedIOException = new InterruptedIOException("deadline reached");
                    throw interruptedIOException;
                }
            }
            return;
        }
        Thread.currentThread().interrupt();
        InterruptedIOException interruptedIOException = new InterruptedIOException("interrupted");
        throw interruptedIOException;
    }

    public o0 i(long l10, TimeUnit object) {
        String string2 = "unit";
        f0.p(object, string2);
        long l11 = 0L;
        long l12 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        if (l12 >= 0) {
            l12 = 1;
        } else {
            l12 = 0;
            string2 = null;
        }
        if (l12 != false) {
            this.c = l10 = ((TimeUnit)((Object)object)).toNanos(l10);
            return this;
        }
        object = new StringBuilder();
        ((StringBuilder)object).append("timeout < 0: ");
        ((StringBuilder)object).append(l10);
        String string3 = ((StringBuilder)object).toString();
        string3 = string3.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string3);
        throw illegalArgumentException;
    }

    public long j() {
        return this.c;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public final void k(Object object) {
        long l10;
        long l11;
        long l12;
        String string2;
        block11: {
            long l13;
            long l14;
            int n10;
            string2 = "monitor";
            f0.p(object, string2);
            try {
                long l15;
                long l16;
                n10 = this.f();
                l12 = this.j();
                l11 = 0L;
                if (n10 == 0 && (l16 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) == false) {
                    object.wait();
                    return;
                }
                l14 = System.nanoTime();
                if (n10 != 0 && (l15 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1)) != false) {
                    l13 = this.d() - l14;
                    l12 = Math.min(l12, l13);
                } else if (n10 != 0) {
                    long l17 = this.d();
                    l12 = l17 - l14;
                }
                n10 = l12 == l11 ? 0 : (l12 < l11 ? -1 : 1);
                if (n10 <= 0) break block11;
                l11 = 1000000L;
                l13 = l12 / l11;
                l11 *= l13;
                l11 = l12 - l11;
            }
            catch (InterruptedException interruptedException) {}
            n10 = (int)l11;
            object.wait(l13, n10);
            l11 = System.nanoTime() - l14;
        }
        if ((l10 = l11 == l12 ? 0 : (l11 < l12 ? -1 : 1)) < 0) {
            return;
        }
        string2 = "timeout";
        object = new InterruptedIOException(string2);
        throw object;
        Thread.currentThread().interrupt();
        object = new InterruptedIOException("interrupted");
        throw object;
    }
}

