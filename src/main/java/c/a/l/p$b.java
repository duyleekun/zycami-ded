/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.b;
import c.a.l.p;
import c.a.l.p$a;
import c.b.a.c;
import java.util.List;

public final class p$b {
    public static final /* synthetic */ boolean c;
    private final List a;
    private final List b;

    private p$b(int n10, int n11) {
        List list;
        this.a = list = c.a.l.b.e(n10);
        this.b = list = c.a.l.b.e(n11);
    }

    public /* synthetic */ p$b(int n10, int n11, p$a p$a) {
        this(n10, n11);
    }

    public p$b a(c c10) {
        this.b.add(c10);
        return this;
    }

    public p$b b(c c10) {
        this.a.add(c10);
        return this;
    }

    public p c() {
        List list = this.a;
        List list2 = this.b;
        p p10 = new p(list, list2, null);
        return p10;
    }
}

