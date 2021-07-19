/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.o.h;

public final class f$a {
    private final Class a;
    public final h b;

    public f$a(Class clazz, h h10) {
        this.a = clazz;
        this.b = h10;
    }

    public boolean a(Class clazz) {
        return this.a.isAssignableFrom(clazz);
    }
}

