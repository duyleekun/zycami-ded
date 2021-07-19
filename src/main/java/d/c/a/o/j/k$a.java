/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.j;

import d.c.a.o.j.e;
import d.c.a.o.j.e$a;
import d.c.a.o.j.k;
import d.c.a.o.k.x.b;
import java.io.InputStream;

public final class k$a
implements e$a {
    private final b a;

    public k$a(b b10) {
        this.a = b10;
    }

    public Class a() {
        return InputStream.class;
    }

    public e c(InputStream inputStream) {
        b b10 = this.a;
        k k10 = new k(inputStream, b10);
        return k10;
    }
}

