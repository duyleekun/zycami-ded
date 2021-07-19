/*
 * Decompiled with CFR 0.151.
 */
package f.l2;

import f.c1;
import f.h2.t.u;
import f.s1;
import f.x1.l1;
import java.util.NoSuchElementException;

public final class s
extends l1 {
    private final int a;
    private boolean b;
    private final int c;
    private int d;

    private s(int n10, int n11, int n12) {
        this.a = n11;
        boolean bl2 = true;
        int n13 = s1.c(n10, n11);
        if (!(n12 > 0 ? n13 <= 0 : n13 >= 0)) {
            bl2 = false;
        }
        this.b = bl2;
        this.c = n12 = c1.h(n12);
        n12 = (int)(this.b ? 1 : 0);
        if (n12 == 0) {
            n10 = n11;
        }
        this.d = n10;
    }

    public /* synthetic */ s(int n10, int n11, int n12, u u10) {
        this(n10, n11, n12);
    }

    /*
     * Enabled aggressive block sorting
     */
    public int c() {
        int n10 = this.d;
        int n11 = this.a;
        if (n10 != n11) {
            this.d = n11 = c1.h(this.c + n10);
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

    public boolean hasNext() {
        return this.b;
    }
}

