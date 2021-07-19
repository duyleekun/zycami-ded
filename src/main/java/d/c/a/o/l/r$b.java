/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.l;

import d.c.a.o.l.o;

public class r$b {
    private final Class a;
    public final Class b;
    public final o c;

    public r$b(Class clazz, Class clazz2, o o10) {
        this.a = clazz;
        this.b = clazz2;
        this.c = o10;
    }

    public boolean a(Class clazz) {
        return this.a.isAssignableFrom(clazz);
    }

    public boolean b(Class clazz, Class clazz2) {
        boolean bl2 = this.a(clazz);
        if (bl2 && (bl2 = (clazz = this.b).isAssignableFrom(clazz2))) {
            bl2 = true;
        } else {
            bl2 = false;
            clazz = null;
        }
        return bl2;
    }
}

