/*
 * Decompiled with CFR 0.151.
 */
package g.h0.k;

import f.h2.t.f0;
import g.h0.k.a$a;
import g.s;
import g.s$a;
import h.o;

public final class a {
    private static final int c = 262144;
    public static final a$a d;
    private long a;
    private final o b;

    static {
        a$a a$a;
        d = a$a = new a$a(null);
    }

    public a(o o10) {
        long l10;
        f0.p(o10, "source");
        this.b = o10;
        this.a = l10 = (long)262144;
    }

    public final o a() {
        return this.b;
    }

    public final s b() {
        s$a s$a = new s$a();
        String string2;
        int n10;
        while ((n10 = (n10 = (string2 = this.c()).length()) == 0 ? 1 : 0) == 0) {
            s$a.f(string2);
        }
        return s$a.i();
    }

    public final String c() {
        Object object = this.b;
        long l10 = this.a;
        object = object.p(l10);
        l10 = this.a;
        long l11 = ((String)object).length();
        this.a = l10 -= l11;
        return object;
    }
}

