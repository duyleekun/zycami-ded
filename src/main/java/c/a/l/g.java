/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.e;
import c.a.l.l;

public final class g
implements c.a.l.e,
e {
    private static final g b;
    private final Object a;

    static {
        g g10;
        b = g10 = new g(null);
    }

    private g(Object object) {
        this.a = object;
    }

    public static c.a.l.e a(Object object) {
        object = l.b(object, "instance cannot be null");
        g g10 = new g(object);
        return g10;
    }

    public static c.a.l.e b(Object object) {
        if (object == null) {
            object = g.c();
        } else {
            g g10 = new g(object);
            object = g10;
        }
        return object;
    }

    private static g c() {
        return b;
    }

    public Object get() {
        return this.a;
    }
}

