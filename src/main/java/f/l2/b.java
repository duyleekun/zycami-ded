/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.h2.t.f0;
import f.x1.r;
import java.util.NoSuchElementException;

public final class b
extends r {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    public b(char c10, char c11, int n10) {
        this.d = n10;
        this.a = c11;
        boolean bl2 = true;
        if (!(n10 > 0 ? (n10 = f0.t(c10, c11)) <= 0 : (n10 = f0.t(c10, c11)) >= 0)) {
            bl2 = false;
        }
        this.b = bl2;
        if (!bl2) {
            c10 = c11;
        }
        this.c = c10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public char c() {
        int n10 = this.c;
        int n11 = this.a;
        if (n10 != n11) {
            this.c = n11 = this.d + n10;
            return (char)n10;
        }
        n11 = (int)(this.b ? 1 : 0);
        if (n11 != 0) {
            n11 = 0;
            this.b = false;
            return (char)n10;
        }
        NoSuchElementException noSuchElementException = new NoSuchElementException();
        throw noSuchElementException;
    }

    public final int e() {
        return this.d;
    }

    public boolean hasNext() {
        return this.b;
    }
}

