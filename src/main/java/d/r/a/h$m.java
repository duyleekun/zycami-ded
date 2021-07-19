/*
 * Decompiled with CFR 0.151.
 */
package d.r.a;

import d.r.a.g;
import d.r.a.h$t;

public final class h$m
extends h$t {
    public int e;
    public int f;

    public h$m() {
        super(2016);
        int n10;
        this.e = n10 = -1;
        this.f = n10;
    }

    public final void d(g g10) {
        super.d(g10);
        int n10 = this.e;
        g10.c("key_dispatch_environment", n10);
        n10 = this.f;
        g10.c("key_dispatch_area", n10);
    }

    public final void e(g g10) {
        int n10;
        int n11;
        super.e(g10);
        int n12 = 1;
        this.e = n11 = g10.h("key_dispatch_environment", n12);
        this.f = n10 = g10.h("key_dispatch_area", n12);
    }
}

