/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.x1.l0;
import java.util.NoSuchElementException;

public final class j
extends l0 {
    private final int a;
    private boolean b;
    private int c;
    private final int d;

    public j(int n10, int n11, int n12) {
        this.d = n12;
        this.a = n11;
        boolean bl2 = true;
        if (!(n12 > 0 ? n10 <= n11 : n10 >= n11)) {
            bl2 = false;
        }
        this.b = bl2;
        if (!bl2) {
            n10 = n11;
        }
        this.c = n10;
    }

    /*
     * Enabled aggressive block sorting
     */
    public int c() {
        int n10 = this.c;
        int n11 = this.a;
        if (n10 != n11) {
            this.c = n11 = this.d + n10;
            return n10;
        }
        n11 = (int)(this.b ? 1 : 0);
        if (n11 != 0) {
            n11 = 0;
            this.b = false;
            return n10;
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

