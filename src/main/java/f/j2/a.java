/*
 * Decompiled with CFR 0.151.
 */
package f.j2;

import f.h2.s.q;
import f.h2.t.f0;
import f.j2.a$a;
import f.j2.a$b;
import f.j2.b;
import f.j2.f;

public final class a {
    public static final a a;

    static {
        a a10;
        a = a10 = new a();
    }

    private a() {
    }

    public final f a() {
        b b10 = new b();
        return b10;
    }

    public final f b(Object object, q q10) {
        f0.p(q10, "onChange");
        a$a a$a = new a$a(q10, object, object);
        return a$a;
    }

    public final f c(Object object, q q10) {
        f0.p(q10, "onChange");
        a$b a$b = new a$b(q10, object, object);
        return a$b;
    }
}

