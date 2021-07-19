/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.b;

import e.a.j;
import e.a.w0.e.b.c$a;
import java.util.Iterator;

public final class c
implements Iterable {
    public final j a;
    public final Object b;

    public c(j j10, Object object) {
        this.a = j10;
        this.b = object;
    }

    public Iterator iterator() {
        Object object = this.b;
        c$a c$a = new c$a(object);
        this.a.l6(c$a);
        return c$a.d();
    }
}

