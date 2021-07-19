/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.g0;
import e.a.w0.c.o;
import e.a.w0.f.a;
import e.a.w0.i.b;
import e.a.w0.i.j;
import e.a.w0.i.m;
import i.g.d;
import i.g.e;
import io.reactivex.exceptions.MissingBackpressureException;
import io.reactivex.internal.queue.SpscArrayQueue;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public final class n {
    public static final long a = Long.MIN_VALUE;
    public static final long b = Long.MAX_VALUE;

    private n() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static boolean a(boolean bl2, boolean bl3, g0 g02, boolean bl4, o o10, e.a.s0.b b10, j j10) {
        boolean bl5 = j10.d();
        boolean bl6 = true;
        if (bl5) {
            o10.clear();
            b10.dispose();
            return bl6;
        }
        if (bl2) {
            if (bl4) {
                if (bl3) {
                    Throwable throwable;
                    if (b10 != null) {
                        b10.dispose();
                    }
                    if ((throwable = j10.error()) != null) {
                        g02.onError(throwable);
                    } else {
                        g02.onComplete();
                    }
                    return bl6;
                }
            } else {
                Throwable throwable = j10.error();
                if (throwable != null) {
                    o10.clear();
                    if (b10 != null) {
                        b10.dispose();
                    }
                    g02.onError(throwable);
                    return bl6;
                }
                if (bl3) {
                    if (b10 != null) {
                        b10.dispose();
                    }
                    g02.onComplete();
                    return bl6;
                }
            }
        }
        return false;
    }

    public static boolean b(boolean bl2, boolean bl3, d d10, boolean bl4, o o10, m m10) {
        boolean bl5 = m10.d();
        boolean bl6 = true;
        if (bl5) {
            o10.clear();
            return bl6;
        }
        if (bl2) {
            if (bl4) {
                if (bl3) {
                    Throwable throwable = m10.error();
                    if (throwable != null) {
                        d10.onError(throwable);
                    } else {
                        d10.onComplete();
                    }
                    return bl6;
                }
            } else {
                Throwable throwable = m10.error();
                if (throwable != null) {
                    o10.clear();
                    d10.onError(throwable);
                    return bl6;
                }
                if (bl3) {
                    d10.onComplete();
                    return bl6;
                }
            }
        }
        return false;
    }

    public static o c(int n10) {
        if (n10 < 0) {
            n10 = -n10;
            a a10 = new a(n10);
            return a10;
        }
        SpscArrayQueue spscArrayQueue = new SpscArrayQueue(n10);
        return spscArrayQueue;
    }

    public static void d(e.a.w0.c.n n10, g0 g02, boolean bl2, e.a.s0.b b10, j j10) {
        int n11 = 1;
        float f10 = Float.MIN_VALUE;
        int n12 = n11;
        block0: while (true) {
            boolean bl3 = j10.c();
            boolean bl4 = n10.isEmpty();
            if (bl3 = n.a(bl3, bl4, g02, bl2, n10, b10, j10)) {
                return;
            }
            while (true) {
                bl4 = j10.c();
                Object object = n10.poll();
                int n13 = object == null ? n11 : 0;
                if (bl4 = n.a(bl4, n13 != 0, g02, bl2, n10, b10, j10)) {
                    return;
                }
                if (n13 != 0) {
                    n12 = -n12;
                    if ((n12 = j10.a(n12)) != 0) continue block0;
                    return;
                }
                j10.e(g02, object);
            }
            break;
        }
    }

    public static void e(e.a.w0.c.n object, d d10, boolean bl2, e.a.s0.b b10, m m10) {
        int n10 = 1;
        float f10 = Float.MIN_VALUE;
        int n11 = n10;
        while (true) {
            long l10;
            long l11;
            boolean bl3 = m10.c();
            Object object2 = object.poll();
            int n12 = object2 == null ? n10 : 0;
            if (bl3 = n.b(bl3, n12 != 0, d10, bl2, (o)object, m10)) {
                if (b10 != null) {
                    b10.dispose();
                }
                return;
            }
            if (n12 != 0) {
                n11 = -n11;
                if ((n11 = m10.a(n11)) != 0) continue;
                return;
            }
            long l12 = m10.requested();
            long l13 = l12 - (l11 = 0L);
            Object object3 = l13 == 0L ? 0 : (l13 < 0L ? -1 : 1);
            if (object3 == false) break;
            object3 = m10.e(d10, object2);
            if (object3 == false || !(bl3 = (l10 = l12 - (l11 = Long.MAX_VALUE)) == 0L ? 0 : (l10 < 0L ? -1 : 1))) continue;
            l12 = 1L;
            m10.f(l12);
        }
        object.clear();
        if (b10 != null) {
            b10.dispose();
        }
        object = new MissingBackpressureException("Could not emit value due to lack of requests.");
        d10.onError((Throwable)object);
    }

    public static boolean f(e.a.v0.e e10) {
        try {
            return e10.getAsBoolean();
        }
        catch (Throwable throwable) {
            e.a.t0.a.b(throwable);
            return true;
        }
    }

    public static void g(d d10, Queue queue, AtomicLong atomicLong, e.a.v0.e e10) {
        long l10;
        long l11;
        long l12;
        long l13;
        boolean bl2;
        Object object = queue.isEmpty();
        if (object) {
            d10.onComplete();
            return;
        }
        long l14 = atomicLong.get();
        object = n.h(l14, d10, queue, atomicLong, e10);
        if (object) {
            return;
        }
        do {
            long l15;
            long l16;
            long l17;
            if ((l17 = (l16 = (l15 = (l13 = atomicLong.get()) & (l11 = Long.MIN_VALUE)) - (l10 = 0L)) == 0L ? 0 : (l16 < 0L ? -1 : 1)) == false) continue;
            return;
        } while (!(bl2 = atomicLong.compareAndSet(l13, l12 = l13 | l11)));
        object = l13 == l10 ? 0 : (l13 < l10 ? -1 : 1);
        if (object) {
            n.h(l12, d10, queue, atomicLong, e10);
        }
    }

    public static boolean h(long l10, d d10, Queue queue, AtomicLong atomicLong, e.a.v0.e e10) {
        long l11 = Long.MIN_VALUE;
        long l12 = l10 & l11;
        while (true) {
            long l13;
            Object object = l12 == l10 ? 0 : (l12 < l10 ? -1 : 1);
            boolean bl2 = true;
            if (object != false) {
                object = n.f(e10);
                if (object != false) {
                    return bl2;
                }
                Object e11 = queue.poll();
                if (e11 == null) {
                    d10.onComplete();
                    return bl2;
                }
                d10.onNext(e11);
                l13 = 1L;
                l12 += l13;
                continue;
            }
            Object object2 = n.f(e10);
            if (object2) {
                return bl2;
            }
            object2 = queue.isEmpty();
            if (object2) {
                d10.onComplete();
                return bl2;
            }
            l10 = atomicLong.get();
            long l14 = l10 - l12;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) continue;
            l10 = Long.MAX_VALUE;
            l12 = -(l12 & l10);
            long l15 = (l10 &= (l12 = atomicLong.addAndGet(l12))) - (l13 = 0L);
            object2 = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
            if (!object2) {
                return false;
            }
            long l16 = l12 & l11;
            l10 = l12;
            l12 = l16;
        }
    }

    public static boolean i(long l10, d d10, Queue queue, AtomicLong atomicLong, e.a.v0.e e10) {
        long l11;
        long l12;
        long l13;
        long l14;
        boolean bl2;
        long l15 = l10;
        do {
            l14 = atomicLong.get();
            l13 = Long.MAX_VALUE & l14;
            l11 = Long.MIN_VALUE;
            l12 = l14 & l11;
        } while (!(bl2 = atomicLong.compareAndSet(l14, l13 = e.a.w0.i.b.c(l13, l10) | l12)));
        Object object = l14 == l11 ? 0 : (l14 < l11 ? -1 : 1);
        if (object == false) {
            n.h(l15 | l11, d10, queue, atomicLong, e10);
            return true;
        }
        return false;
    }

    public static void j(e e10, int n10) {
        long l10 = n10 < 0 ? Long.MAX_VALUE : (long)n10;
        e10.request(l10);
    }
}

