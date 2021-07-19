/*
 * Decompiled with CFR 0.151.
 */
package d.v.c.y1.g.m;

import d.v.c.b2.w.l.c;

public class b {
    private c a;
    private long b;
    private long c;
    private long d;
    private String e;

    public b(long l10, long l11, long l12, String string2) {
        this.b = l10;
        this.c = l11;
        this.d = l12;
        this.e = string2;
    }

    public long a() {
        return this.d;
    }

    public String b() {
        return this.e;
    }

    public long c() {
        return this.b;
    }

    public long d() {
        return this.c;
    }

    public c e() {
        return this.a;
    }

    public b f(long l10) {
        this.d = l10;
        return this;
    }

    public b g(String string2) {
        this.e = string2;
        return this;
    }

    public b h(long l10) {
        this.b = l10;
        return this;
    }

    public b i(long l10) {
        this.c = l10;
        return this;
    }

    public b j(c c10) {
        this.a = c10;
        return this;
    }
}

