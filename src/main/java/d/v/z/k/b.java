/*
 * Decompiled with CFR 0.151.
 */
package d.v.z.k;

import java.util.concurrent.atomic.AtomicInteger;

public final class b {
    private static final int a = 1;
    private static final int b;
    private static final AtomicInteger c;

    static {
        AtomicInteger atomicInteger;
        b = (int)Math.pow(2.0, 16.0);
        c = atomicInteger = new AtomicInteger(1);
    }

    public static int a() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            AtomicInteger atomicInteger = c;
            int n10 = atomicInteger.getAndIncrement();
            int n11 = b;
            int n12 = 1;
            atomicInteger.compareAndSet(n11, n12);
            return n10;
        }
    }

    public static void b() {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            AtomicInteger atomicInteger = c;
            int n10 = 1;
            atomicInteger.getAndSet(n10);
            return;
        }
    }

    public static void c(int n10) {
        Class<b> clazz = b.class;
        synchronized (clazz) {
            AtomicInteger atomicInteger = c;
            atomicInteger.getAndSet(n10);
            n10 = b;
            int n11 = 1;
            atomicInteger.compareAndSet(n10, n11);
            return;
        }
    }
}

