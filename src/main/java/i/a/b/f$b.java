/*
 * Decompiled with CFR 0.151.
 */
package i.a.b;

import i.a.b.f;
import i.a.b.f$a;
import i.a.b.g;

public class f$b {
    private g a;
    private f b;

    private f$b() {
        f f10;
        g g10;
        this.a = g10 = new g();
        this.b = f10 = new f(g10, null);
    }

    public /* synthetic */ f$b(f$a f$a) {
        this();
    }

    public f$b a(String string2) {
        f.a(this.b, string2);
        return this;
    }

    public f b() {
        f.c(this.b);
        return this.b;
    }

    public f$b c() {
        this.a.g(true);
        return this;
    }

    public f$b d() {
        this.a.h(true);
        return this;
    }

    public f$b e() {
        this.a.i(true);
        return this;
    }

    public f$b f() {
        this.a.f(false);
        return this;
    }

    public f$b g() {
        f.b(this.b).j(true);
        return this;
    }
}

