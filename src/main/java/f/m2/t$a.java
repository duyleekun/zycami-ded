/*
 * Decompiled with CFR 0.151.
 */
package f.m2;

import f.h2.t.f0;
import f.h2.t.u;
import f.m2.r;
import f.m2.t;
import kotlin.reflect.KVariance;

public final class t$a {
    private t$a() {
    }

    public /* synthetic */ t$a(u u10) {
        this();
    }

    public static /* synthetic */ void d() {
    }

    public final t a(r r10) {
        f0.p(r10, "type");
        KVariance kVariance = KVariance.IN;
        t t10 = new t(kVariance, r10);
        return t10;
    }

    public final t b(r r10) {
        f0.p(r10, "type");
        KVariance kVariance = KVariance.OUT;
        t t10 = new t(kVariance, r10);
        return t10;
    }

    public final t c() {
        return t.c;
    }

    public final t e(r r10) {
        f0.p(r10, "type");
        KVariance kVariance = KVariance.INVARIANT;
        t t10 = new t(kVariance, r10);
        return t10;
    }
}

