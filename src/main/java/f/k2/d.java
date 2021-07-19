/*
 * Decompiled with CFR 0.151.
 */
package f.k2;

import f.d2.l;
import f.h2.t.f0;
import f.k2.a;
import f.k2.c;
import f.k2.e;
import java.util.Random;
import kotlin.random.KotlinRandom;

public final class d {
    public static final Random a(e e10) {
        Object object = "$this$asJavaRandom";
        f0.p(e10, (String)object);
        boolean bl2 = e10 instanceof a;
        if (!bl2) {
            bl2 = false;
            object = null;
        } else {
            object = e10;
        }
        object = (a)object;
        if (object == null || (object = ((a)object).r()) == null) {
            object = new KotlinRandom(e10);
        }
        return object;
    }

    public static final e b(Random random) {
        Object object = "$this$asKotlinRandom";
        f0.p(random, (String)object);
        boolean bl2 = random instanceof KotlinRandom;
        if (!bl2) {
            bl2 = false;
            object = null;
        } else {
            object = random;
        }
        object = (KotlinRandom)object;
        if (object == null || (object = ((KotlinRandom)object).getImpl()) == null) {
            object = new c(random);
        }
        return object;
    }

    private static final e c() {
        return l.a.b();
    }

    public static final double d(int n10, int n11) {
        long l10 = (long)n10 << 27;
        long l11 = n11;
        double d10 = l10 + l11;
        double d11 = 0x20000000000000L;
        return d10 / d11;
    }
}

