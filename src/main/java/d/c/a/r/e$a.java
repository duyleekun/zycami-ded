/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.r;

import d.c.a.o.g;

public class e$a {
    private final Class a;
    public final Class b;
    public final g c;

    public e$a(Class clazz, Class clazz2, g g10) {
        this.a = clazz;
        this.b = clazz2;
        this.c = g10;
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

