/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import com.uber.autodispose.AtomicThrowable;
import e.a.a1.a;
import e.a.g0;
import i.g.d;
import java.util.concurrent.atomic.AtomicInteger;

public final class v {
    private v() {
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

    public static boolean e(g0 g02, Object object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        boolean bl2;
        int n10 = atomicInteger.get();
        if (!n10 && (bl2 = atomicInteger.compareAndSet(0, n10 = 1))) {
            g02.onNext(object);
            int n11 = atomicInteger.decrementAndGet();
            if (n11 != 0) {
                object = atomicThrowable.terminate();
                if (object != null) {
                    g02.onError((Throwable)object);
                } else {
                    g02.onComplete();
                }
                return n10 != 0;
            }
        }
        return false;
    }

    public static boolean f(d d10, Object object, AtomicInteger atomicInteger, AtomicThrowable atomicThrowable) {
        boolean bl2;
        int n10 = atomicInteger.get();
        if (!n10 && (bl2 = atomicInteger.compareAndSet(0, n10 = 1))) {
            d10.onNext(object);
            int n11 = atomicInteger.decrementAndGet();
            if (n11 != 0) {
                object = atomicThrowable.terminate();
                if (object != null) {
                    d10.onError((Throwable)object);
                } else {
                    d10.onComplete();
                }
                return n10 != 0;
            }
        }
        return false;
    }
}

