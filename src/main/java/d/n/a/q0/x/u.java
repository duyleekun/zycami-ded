/*
 * Decompiled with CFR 0.151.
 */
package d.n.a.q0.x;

import d.n.a.q0.x.i;
import d.n.a.q0.x.k;
import d.n.a.q0.x.r;

public class u
implements r {
    private final k a;
    private final i b;
    private final boolean c;
    private final int d;

    public u(k k10, i i10, int n10, boolean bl2) {
        this.a = k10;
        this.b = i10;
        this.d = n10;
        this.c = bl2;
    }

    private boolean c() {
        int n10;
        int n11 = this.c;
        n11 = n11 == 0 && (n11 = this.d) >= (n10 = 23) ? 1 : 0;
        return n11 != 0;
    }

    public boolean a() {
        k k10;
        boolean bl2 = this.c();
        if (bl2 && !(bl2 = (k10 = this.a).a())) {
            bl2 = false;
            k10 = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public boolean b() {
        return this.b.c();
    }
}

