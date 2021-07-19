/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.i;

import e.a.a1.a;
import java.util.concurrent.atomic.AtomicLong;

public final class b {
    private b() {
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
        } while (!(bl2 = atomicLong.compareAndSet(l12, l11 = b.c(l12, l10))));
        return l12;
    }

    public static long b(AtomicLong atomicLong, long l10) {
        long l11;
        long l12;
        boolean bl2;
        do {
            long l13;
            Object object;
            if ((object = (l13 = (l12 = atomicLong.get()) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                return l11;
            }
            l11 = Long.MAX_VALUE;
            long l14 = l12 - l11;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object != false) continue;
            return l11;
        } while (!(bl2 = atomicLong.compareAndSet(l12, l11 = b.c(l12, l10))));
        return l12;
    }

    public static long c(long l10, long l11) {
        long l12 = (l10 += l11) - (l11 = 0L);
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object < 0) {
            l10 = Long.MAX_VALUE;
        }
        return l10;
    }

    public static long d(long l10, long l11) {
        long l12;
        long l13;
        long l14 = l10 * l11;
        long l15 = l10 | l11;
        int n10 = 31;
        long l16 = 0L;
        long l17 = (l15 >>>= n10) - l16;
        Object object = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object != false && (l13 = (l12 = (l10 = l14 / l10) - l11) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false) {
            return Long.MAX_VALUE;
        }
        return l14;
    }

    public static long e(AtomicLong atomicLong, long l10) {
        long l11;
        long l12;
        boolean bl2;
        do {
            long l13;
            long l14;
            if ((l14 = (l13 = (l12 = atomicLong.get()) - (l11 = Long.MAX_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                return l11;
            }
            l11 = l12 - l10;
            long l15 = 0L;
            long l16 = l11 - l15;
            Object object = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object >= 0) continue;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "More produced than requested: ";
            stringBuilder.append(string2);
            stringBuilder.append(l11);
            String string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3);
            a.Y(illegalStateException);
            l11 = l15;
        } while (!(bl2 = atomicLong.compareAndSet(l12, l11)));
        return l11;
    }

    public static long f(AtomicLong atomicLong, long l10) {
        long l11;
        long l12;
        boolean bl2;
        do {
            long l13;
            Object object;
            if ((object = (l13 = (l12 = atomicLong.get()) - (l11 = Long.MIN_VALUE)) == 0L ? 0 : (l13 < 0L ? -1 : 1)) == false) {
                return l11;
            }
            l11 = Long.MAX_VALUE;
            long l14 = l12 - l11;
            object = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object == false) {
                return l11;
            }
            l11 = l12 - l10;
            long l15 = 0L;
            long l16 = l11 - l15;
            Object object2 = l16 == 0L ? 0 : (l16 < 0L ? -1 : 1);
            if (object2 >= 0) continue;
            StringBuilder stringBuilder = new StringBuilder();
            String string2 = "More produced than requested: ";
            stringBuilder.append(string2);
            stringBuilder.append(l11);
            String string3 = stringBuilder.toString();
            IllegalStateException illegalStateException = new IllegalStateException(string3);
            a.Y(illegalStateException);
            l11 = l15;
        } while (!(bl2 = atomicLong.compareAndSet(l12, l11)));
        return l11;
    }
}

