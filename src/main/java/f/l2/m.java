/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.x1.m0;
import java.util.NoSuchElementException;

public final class m
extends m0 {
    private final long a;
    private boolean b;
    private long c;
    private final long d;

    public m(long l10, long l11, long l12) {
        this.d = l12;
        this.a = l11;
        long l13 = 0L;
        long l14 = l12 == l13 ? 0 : (l12 < l13 ? -1 : 1);
        boolean bl2 = true;
        if (!(l14 > 0 ? (l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) <= 0 : (l14 = l10 == l11 ? 0 : (l10 < l11 ? -1 : 1)) >= 0)) {
            bl2 = false;
        }
        this.b = bl2;
        if (!bl2) {
            l10 = l11;
        }
        this.c = l10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public long c() {
        long l10 = this.c;
        long l11 = this.a;
        long l12 = l10 - l11;
        Object object = l12 == 0L ? 0 : (l12 < 0L ? -1 : 1);
        if (object != false) {
            this.c = l11 = this.d + l10;
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

    public final long e() {
        return this.d;
    }

    public boolean hasNext() {
        return this.b;
    }
}

