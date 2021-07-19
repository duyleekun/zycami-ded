/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.m.i;

import d.c.a.o.m.i.e;

public final class f$a {
    private final Class a;
    private final Class b;
    public final e c;

    public f$a(Class clazz, Class clazz2, e e10) {
        this.a = clazz;
        this.b = clazz2;
        this.c = e10;
    }

    public boolean a(Class clazz, Class clazz2) {
        Class clazz3 = this.a;
        boolean bl2 = clazz3.isAssignableFrom(clazz);
        if (bl2 && (bl2 = clazz2.isAssignableFrom(clazz = this.b))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }
}

