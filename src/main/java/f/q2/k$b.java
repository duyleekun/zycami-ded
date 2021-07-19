/*
 * Decompiled with CFR 0.151.
 */
package f.q2;

import f.h2.t.f0;
import f.q2.k;
import java.util.List;

public final class k$b {
    private final k a;

    public k$b(k k10) {
        f0.p(k10, "match");
        this.a = k10;
    }

    private final String a() {
        return (String)this.k().b().get(1);
    }

    private final String b() {
        return (String)this.k().b().get(10);
    }

    private final String c() {
        return (String)this.k().b().get(2);
    }

    private final String d() {
        return (String)this.k().b().get(3);
    }

    private final String e() {
        return (String)this.k().b().get(4);
    }

    private final String f() {
        return (String)this.k().b().get(5);
    }

    private final String g() {
        return (String)this.k().b().get(6);
    }

    private final String h() {
        return (String)this.k().b().get(7);
    }

    private final String i() {
        return (String)this.k().b().get(8);
    }

    private final String j() {
        return (String)this.k().b().get(9);
    }

    public final k k() {
        return this.a;
    }

    public final List l() {
        List list = this.a.b();
        int n10 = this.a.b().size();
        return list.subList(1, n10);
    }
}

