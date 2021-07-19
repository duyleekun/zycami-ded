/*
 * Decompiled with CFR 0.151.
 */
package d.n.a;

import d.n.a.n0;
import d.n.a.z;
import java.util.concurrent.TimeUnit;

public class z$a {
    private boolean a = false;
    private boolean b = false;
    private n0 c;

    public z$a() {
        n0 n02;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.c = n02 = new n0(30, timeUnit);
    }

    public z a() {
        boolean bl2 = this.a;
        boolean bl3 = this.b;
        n0 n02 = this.c;
        z z10 = new z(bl2, bl3, n02);
        return z10;
    }

    public z$a b(boolean bl2) {
        this.a = bl2;
        return this;
    }

    public z$a c(n0 n02) {
        this.c = n02;
        return this;
    }

    public z$a d(boolean bl2) {
        this.b = bl2;
        return this;
    }
}

