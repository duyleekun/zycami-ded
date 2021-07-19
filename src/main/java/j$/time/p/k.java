/*
 * Decompiled with CFR 0.151.
 */
package j$.time.p;

import j$.time.Instant;
import j$.time.LocalDate;
import j$.time.e;
import j$.time.o;
import j$.time.p.a;
import j$.time.p.b;
import j$.time.p.d;
import j$.time.p.g;
import j$.time.q.s;
import java.io.Serializable;

public final class k
extends a
implements Serializable {
    public static final k a;

    static {
        k k10;
        a = k10 = new k();
    }

    private k() {
    }

    public b B(int n10, int n11, int n12) {
        return LocalDate.D(n10, n11, n12);
    }

    public d I(s s10) {
        return e.n(s10);
    }

    public String q() {
        return "ISO";
    }

    public b r(s s10) {
        return LocalDate.n(s10);
    }

    public g t(Instant instant, j$.time.k k10) {
        return o.n(instant, k10);
    }

    public boolean y(long l10) {
        long l11;
        boolean bl2;
        long l12;
        long l13 = (long)3 & l10;
        long l14 = 0L;
        long l15 = l13 - l14;
        Object object = l15 == 0L ? 0 : (l15 < 0L ? -1 : 1);
        bl2 = object == false && ((object = (l12 = (l13 = l10 % (long)100) - l14) == 0L ? 0 : (l12 < 0L ? -1 : 1)) != false || !(bl2 = (l11 = (l10 %= (l13 = 400L)) - l14) == 0L ? 0 : (l11 < 0L ? -1 : 1)));
        return bl2;
    }
}

