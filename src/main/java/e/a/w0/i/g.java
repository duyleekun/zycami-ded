/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.a1.a;
import e.a.g0;
import i.g.d;
import io.reactivex.internal.util.AtomicThrowable;
import java.util.concurrent.atomic.AtomicInteger;

public final class g {
    private g() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static void a(g0 g02, AtomicInteger serializable, AtomicThrowable atomicThrowable) {
        int n10 = serializable.getAndIncrement();
        if (n10 == 0) {
            serializable = atomicThrowable.terminate();
            if (serializable != null) {
                g02.onError((Throwable)serializable);
            } else {
                g02.onComplete();
            }
        }
    }

    public static void b(d d10, AtomicInteger serializable, AtomicThrowable atomicThrowable) {
        int n10 = serializable.getAndIncrement();
        if (n10 == 0) {
            serializable = atomicThrowable.terminate();
            if (serializable != null) {
                d10.onError((Throwable)serializable);
            } else {
                d10.onComplete();
            }
        }
    }

    public static void c(g0 g02, Throwable throwable, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            int n10 = atomicInteger.getAndIncrement();
            if (n10 == 0) {
                throwable = atomicThrowable.terminate();
                g02.onError(throwable);
            }
        } else {
            a.Y(throwable);
        }
    }

    public static void d(d d10, Throwable throwable, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        boolean bl2 = atomicThrowable.addThrowable(throwable);
        if (bl2) {
            int n10 = atomicInteger.getAndIncrement();
            if (n10 == 0) {
                throwable = atomicThrowable.terminate();
                d10.onError(throwable);
            }
        } else {
            a.Y(throwable);
        }
    }

    public static void e(g0 g02, Object object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        int n10;
        int n11 = atomicInteger.get();
        if (n11 == 0 && (n11 = (int)(atomicInteger.compareAndSet(0, n10 = 1) ? 1 : 0)) != 0) {
            g02.onNext(object);
            int n12 = atomicInteger.decrementAndGet();
            if (n12 != 0) {
                object = atomicThrowable.terminate();
                if (object != null) {
                    g02.onError((Throwable)object);
                } else {
                    g02.onComplete();
                }
            }
        }
    }

    public static void f(d d10, Object object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        int n10;
        int n11 = atomicInteger.get();
        if (n11 == 0 && (n11 = (int)(atomicInteger.compareAndSet(0, n10 = 1) ? 1 : 0)) != 0) {
            d10.onNext(object);
            int n12 = atomicInteger.decrementAndGet();
            if (n12 != 0) {
                object = atomicThrowable.terminate();
                if (object != null) {
                    d10.onError((Throwable)object);
                } else {
                    d10.onComplete();
                }
            }
        }
    }
}

