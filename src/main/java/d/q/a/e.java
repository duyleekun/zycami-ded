/*
 * Decompiled with CFR 0.151.
 */
package d.q.a;

import java.util.concurrent.atomic.AtomicLong;

public final class e {
    private e() {
        IllegalStateException illegalStateException = new IllegalStateException("No instances!");
        throw illegalStateException;
    }

    public static long a(AtomicLong atomicLong, long l10) {
        long l11;
        long l12;
        boolean bl2;
        do {
            long l13;
            long l14;
            if ((l14 = (l13 = (l12 = atomicLong.get()) - (l11 = Long.MAX_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) != false) continue;
            return l11;
        } while (!(bl2 = atomicLong.compareAndSet(l12, l11 = e.b(l12, l10))));
        return l12;
    }

    private static long b(long l10, long l11) {
        long l12 = (l10 += l11) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            l10 = Long.MAX_VALUE;
        }
        return l10;
    }
}

