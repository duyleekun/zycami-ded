/*
 * Decompiled with CFR 0.151.
 */
package g.h0.h;

import f.h2.t.c0;
import f.h2.t.f0;
import f.h2.t.s0;
import g.h0.h.a;
import g.h0.h.c;
import g.h0.h.d;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class b {
    public static final String b(long l10) {
        Object object;
        Object object2;
        long l11 = -999500000;
        Object object3 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1);
        String string2 = " s ";
        int n10 = 1000000000;
        int n11 = 500000000;
        if (object3 <= 0) {
            object2 = new StringBuilder();
            long l12 = n11;
            l10 -= l12;
            long l13 = n10;
            ((StringBuilder)object2).append(l10 /= l13);
            ((StringBuilder)object2).append(string2);
            object = ((StringBuilder)object2).toString();
        } else {
            long l14 = -999500;
            object3 = l10 == l14 ? 0 : (l10 < l14 ? -1 : 1);
            String string3 = " ms";
            int n12 = 1000000;
            int n13 = 500000;
            if (object3 <= 0) {
                object2 = new StringBuilder();
                long l15 = n13;
                l10 -= l15;
                l15 = n12;
                ((StringBuilder)object2).append(l10 /= l15);
                ((StringBuilder)object2).append(string3);
                object = ((StringBuilder)object2).toString();
            } else {
                long l16 = 0L;
                object3 = l10 == l16 ? 0 : (l10 < l16 ? -1 : 1);
                String string4 = " \u00b5s";
                int n14 = 1000;
                int n15 = 500;
                if (object3 <= 0) {
                    object2 = new StringBuilder();
                    long l17 = n15;
                    l10 -= l17;
                    l17 = n14;
                    ((StringBuilder)object2).append(l10 /= l17);
                    ((StringBuilder)object2).append(string4);
                    object = ((StringBuilder)object2).toString();
                } else {
                    long l18 = 999500;
                    long l19 = l10 - l18;
                    object3 = l19 == 0L ? 0 : (l19 < 0L ? -1 : 1);
                    if (object3 < 0) {
                        object2 = new StringBuilder();
                        long l20 = n15;
                        l10 += l20;
                        l20 = n14;
                        ((StringBuilder)object2).append(l10 /= l20);
                        ((StringBuilder)object2).append(string4);
                        object = ((StringBuilder)object2).toString();
                    } else {
                        l16 = 999500000;
                        long l21 = l10 - l16;
                        object3 = l21 == 0L ? 0 : (l21 < 0L ? -1 : 1);
                        if (object3 < 0) {
                            object2 = new StringBuilder();
                            long l22 = n13;
                            l10 += l22;
                            l22 = n12;
                            ((StringBuilder)object2).append(l10 /= l22);
                            ((StringBuilder)object2).append(string3);
                            object = ((StringBuilder)object2).toString();
                        } else {
                            object2 = new StringBuilder();
                            long l23 = n11;
                            l10 += l23;
                            long l24 = n10;
                            ((StringBuilder)object2).append(l10 /= l24);
                            ((StringBuilder)object2).append(string2);
                            object = ((StringBuilder)object2).toString();
                        }
                    }
                }
            }
        }
        int n16 = 1;
        object2 = new Object[n16];
        object2[0] = object;
        object = Arrays.copyOf(object2, n16);
        object = String.format("%6s", object);
        f0.o(object, "java.lang.String.format(format, *args)");
        return object;
    }

    private static final void c(a object, c object2, String string2) {
        Logger logger = d.j.a();
        StringBuilder stringBuilder = new StringBuilder();
        object2 = object2.h();
        stringBuilder.append((String)object2);
        stringBuilder.append(' ');
        object2 = s0.a;
        int n10 = 1;
        Object[] objectArray = new Object[n10];
        objectArray[0] = string2;
        object2 = Arrays.copyOf(objectArray, n10);
        object2 = String.format("%-22s", object2);
        f0.o(object2, "java.lang.String.format(format, *args)");
        stringBuilder.append((String)object2);
        stringBuilder.append(": ");
        object = ((a)object).b();
        stringBuilder.append((String)object);
        object = stringBuilder.toString();
        logger.fine((String)object);
    }

    public static final Object d(a a10, c c10, f.h2.s.a object) {
        long l10;
        f0.p(a10, "task");
        f0.p(c10, "queue");
        f0.p(object, "block");
        Object object2 = d.j.a();
        Object object3 = Level.FINE;
        boolean bl2 = ((Logger)object2).isLoggable((Level)object3);
        if (bl2) {
            object3 = c10.k().h();
            l10 = object3.nanoTime();
            String string2 = "starting";
            b.c(a10, c10, string2);
        } else {
            l10 = -1;
        }
        int n10 = 1;
        try {
            object = object.invoke();
        }
        catch (Throwable throwable) {
            c0.d(n10);
            if (bl2) {
                long l11 = c10.k().h().nanoTime() - l10;
                object2 = new StringBuilder();
                ((StringBuilder)object2).append("failed a run in ");
                object3 = b.b(l11);
                ((StringBuilder)object2).append((String)object3);
                object2 = ((StringBuilder)object2).toString();
                b.c(a10, c10, (String)object2);
            }
            c0.c(n10);
            throw throwable;
        }
        c0.d(n10);
        if (bl2) {
            long l12 = c10.k().h().nanoTime() - l10;
            object2 = new StringBuilder();
            ((StringBuilder)object2).append("finished run in ");
            object3 = b.b(l12);
            ((StringBuilder)object2).append((String)object3);
            object2 = ((StringBuilder)object2).toString();
            b.c(a10, c10, (String)object2);
        }
        c0.c(n10);
        return object;
    }

    public static final void e(a a10, c c10, f.h2.s.a object) {
        f0.p(a10, "task");
        f0.p(c10, "queue");
        f0.p(object, "messageBlock");
        Logger logger = d.j.a();
        Level level = Level.FINE;
        boolean bl2 = logger.isLoggable(level);
        if (bl2) {
            object = (String)object.invoke();
            b.c(a10, c10, (String)object);
        }
    }
}

