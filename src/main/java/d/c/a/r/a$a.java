/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.o.a;

public final class a$a {
    private final Class a;
    public final a b;

    public a$a(Class clazz, a a10) {
        this.a = clazz;
        this.b = a10;
    }

    public boolean a(Class clazz) {
        return this.a.isAssignableFrom(clazz);
    }
}

