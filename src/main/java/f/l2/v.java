/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.g1;
import f.h2.t.u;
import f.s1;
import f.x1.m1;
import java.util.NoSuchElementException;

public final class v
extends m1 {
    private final long a;
    private boolean b;
    private final long c;
    private long d;

    private v(long l10, long l11, long l12) {
        this.a = l11;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        boolean bl2 = true;
        if (!(l14 > 0 ? (l14 = (long)s1.g(l10, l11)) <= 0 : (l14 = (long)s1.g(l10, l11)) >= 0)) {
            bl2 = false;
        }
        this.b = bl2;
        this.c = l12 = g1.h(l12);
        boolean bl3 = this.b;
        if (!bl3) {
            l10 = l11;
        }
        this.d = l10;
    }

    public /* synthetic */ v(long l10, long l11, long l12, u u10) {
        this(l10, l11, l12);
    }

    /*
     * Enabled aggressive block sorting
     */
    public long c() {
        long l10 = this.d;
        long l11 = this.a;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.d = l11 = g1.h(this.c + l10);
            return l10;
        }
        boolean bl2 = this.b;
        if (bl2) {
            boolean bl3 = false;
            this.b = false;
            return l10;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public boolean hasNext() {
        return this.b;
    }
}

