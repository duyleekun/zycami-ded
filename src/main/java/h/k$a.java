/*
 * Decompiled with CFR 0.151.
 */
package h;

import f.h2.t.f0;
import f.h2.t.u;
import f.q1;
import h.k;
import h.k$b;
import h.o0;

public final class k$a {
    private k$a() {
    }

    public /* synthetic */ k$a(u u10) {
        this();
    }

    public static final /* synthetic */ boolean a(k$a k$a, k k10) {
        return k$a.d(k10);
    }

    public static final /* synthetic */ void b(k$a k$a, k k10, long l10, boolean bl2) {
        k$a.e(k10, l10, bl2);
    }

    private final boolean d(k k10) {
        Class<k> clazz = k.class;
        synchronized (clazz) {
            k k11 = k.l();
            while (k11 != null) {
                block9: {
                    k k12 = k.o(k11);
                    if (k12 != k10) break block9;
                    k12 = k.o(k10);
                    k.t(k11, k12);
                    k11 = null;
                    k.t(k10, null);
                    return false;
                }
                k11 = k.o(k11);
            }
            return true;
        }
    }

    /*
     * WARNING - void declaration
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    private final void e(k object, long l10, boolean bl2) {
        Class<k> clazz = k.class;
        synchronized (clazz) {
            k k10;
            void var4_3;
            long l11;
            Object object2 = k.l();
            if (object2 == null) {
                object2 = new k();
                k.s((k)object2);
                object2 = new k$b();
                ((Thread)object2).start();
            }
            long l12 = System.nanoTime();
            long l13 = 0L;
            long l14 = l11 - l13;
            Object object3 = l14 == 0L ? 0 : (l14 < 0L ? -1 : 1);
            if (object3 != false && var4_3 != false) {
                l13 = ((o0)object).d() - l12;
                l11 = Math.min(l11, l13) + l12;
                k.u((k)object, l11);
            } else if (object3 != false) {
                k.u((k)object, l11 += l12);
            } else {
                if (var4_3 == false) {
                    object = new AssertionError();
                    throw object;
                }
                l11 = ((o0)object).d();
                k.u((k)object, l11);
            }
            l11 = k.r((k)object, l12);
            k k11 = k.l();
            f0.m(k11);
            while ((k10 = k.o(k11)) != null) {
                k10 = k.o(k11);
                f0.m(k10);
                l13 = k.r(k10, l12);
                object3 = l11 == l13 ? 0 : (l11 < l13 ? -1 : 1);
                if (object3 < 0) break;
                k11 = k.o(k11);
                f0.m(k11);
            }
            k k12 = k.o(k11);
            k.t((k)object, k12);
            k.t(k11, (k)object);
            object = k.l();
            if (k11 == object) {
                clazz.notify();
            }
            object = q1.a;
            return;
        }
    }

    public final k c() {
        long l10;
        Object object = k.class;
        k k10 = k.l();
        f0.m(k10);
        k10 = k.o(k10);
        k k11 = null;
        if (k10 == null) {
            long l11;
            long l12;
            long l13;
            long l14 = System.nanoTime();
            long l15 = k.m();
            object.wait(l15);
            object = k.l();
            f0.m(object);
            object = k.o((k)object);
            if (object == null && (l13 = (l12 = (l11 = System.nanoTime() - l14) - (l14 = k.n())) == 0L ? 0 : (l12 < 0L ? -1 : 1)) >= 0) {
                k11 = k.l();
            }
            return k11;
        }
        long l16 = System.nanoTime();
        long l17 = (l16 = k.r(k10, l16)) - (l10 = 0L);
        Object object2 = l17 == 0L ? 0 : (l17 < 0L ? -1 : 1);
        if (object2 > 0) {
            l10 = 1000000L;
            long l18 = l16 / l10;
            int n10 = (int)(l16 - (l10 *= l18));
            object.wait(l18, n10);
            return null;
        }
        object = k.l();
        f0.m(object);
        k k12 = k.o(k10);
        k.t((k)object, k12);
        k.t(k10, null);
        return k10;
    }
}

