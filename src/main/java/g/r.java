/*
 * Decompiled with CFR 0.151.
 */
package g;

import f.h2.t.f0;
import g.b0;
import g.h0.d;
import g.r$b;
import g.t;
import g.t$b;
import g.v;
import h.m;
import h.n;
import java.util.List;

public final class r
extends b0 {
    private static final v c;
    public static final r$b d;
    private final List a;
    private final List b;

    static {
        r$b r$b;
        d = r$b = new r$b(null);
        c = v.i.c("application/x-www-form-urlencoded");
    }

    public r(List list, List list2) {
        f0.p(list, "encodedNames");
        f0.p(list2, "encodedValues");
        this.a = list = g.h0.d.c0(list);
        this.b = list = g.h0.d.c0(list2);
    }

    private final long g(n n10, boolean bl2) {
        long l10;
        if (bl2) {
            n10 = new m();
        } else {
            f0.m(n10);
            n10 = n10.getBuffer();
        }
        List list = this.a;
        int n11 = list.size();
        for (int i10 = 0; i10 < n11; ++i10) {
            int n12;
            if (i10 > 0) {
                n12 = 38;
                ((m)n10).b1(n12);
            }
            String string2 = (String)this.a.get(i10);
            ((m)n10).p1(string2);
            n12 = 61;
            ((m)n10).b1(n12);
            string2 = (String)this.b.get(i10);
            ((m)n10).p1(string2);
        }
        if (bl2) {
            l10 = ((m)n10).S0();
            ((m)n10).B();
        } else {
            l10 = 0L;
        }
        return l10;
    }

    public final int a() {
        return this.e();
    }

    public final String b(int n10) {
        return (String)this.a.get(n10);
    }

    public final String c(int n10) {
        return (String)this.b.get(n10);
    }

    public long contentLength() {
        return this.g(null, true);
    }

    public v contentType() {
        return c;
    }

    public final String d(int n10) {
        t$b t$b = t.w;
        String string2 = this.b(n10);
        return t$b.n(t$b, string2, 0, 0, true, 3, null);
    }

    public final int e() {
        return this.a.size();
    }

    public final String f(int n10) {
        t$b t$b = t.w;
        String string2 = this.c(n10);
        return t$b.n(t$b, string2, 0, 0, true, 3, null);
    }

    public void writeTo(n n10) {
        f0.p(n10, "sink");
        this.g(n10, false);
    }
}

