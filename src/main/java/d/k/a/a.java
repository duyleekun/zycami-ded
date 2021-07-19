/*
 * Decompiled with CFR 0.151.
 */
package d.k.a;

import d.k.a.a$a;
import d.k.a.a$b;
import d.k.a.a$c;
import e.a.f0;
import e.a.j;
import e.a.p;
import e.a.z;
import java.util.Objects;

public final class a
implements f0,
p {
    private static final a b;
    private final Object a;

    static {
        a a10;
        b = a10 = new a(null);
    }

    private a(Object object) {
        this.a = object;
    }

    public static a e(Object object) {
        Objects.requireNonNull(object, "defaultValue == null");
        a a10 = new a(object);
        return a10;
    }

    public static a f() {
        return b;
    }

    public j c(j j10) {
        Object object = this.a;
        a$a a$a = new a$a(object);
        j10 = j10.h2(a$a).Q5();
        object = new a$b(j10, a$a);
        return object;
    }

    public z d(z z10) {
        Object object = this.a;
        a$a a$a = new a$a(object);
        z10 = z10.a2(a$a).p5();
        object = new a$c(z10, a$a);
        return object;
    }
}

