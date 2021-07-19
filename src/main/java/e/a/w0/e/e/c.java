/*
 * Decompiled with CFR 0.151.
 */
package e.a.w0.e.e;

import e.a.e0;
import e.a.w0.e.e.c$a;
import java.util.Iterator;

public final class c
implements Iterable {
    public final e0 a;
    public final Object b;

    public c(e0 e02, Object object) {
        this.a = e02;
        this.b = object;
    }

    public Iterator iterator() {
        Object object = this.b;
        c$a c$a = new c$a(object);
        this.a.subscribe(c$a);
        return c$a.c();
    }
}

