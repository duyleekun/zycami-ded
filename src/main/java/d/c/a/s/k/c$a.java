/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.s.k;

import d.c.a.s.k.c;

public class c$a {
    private static final int c = 300;
    private final int a;
    private boolean b;

    public c$a() {
        this(300);
    }

    public c$a(int n10) {
        this.a = n10;
    }

    public c a() {
        int n10 = this.a;
        boolean bl2 = this.b;
        c c10 = new c(n10, bl2);
        return c10;
    }

    public c$a b(boolean bl2) {
        this.b = bl2;
        return this;
    }
}

