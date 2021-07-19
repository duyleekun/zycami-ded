/*
 * Decompiled with CFR 0.151.
 */
package d.j.a.g;

import d.j.a.e.a;
import d.j.a.g.b;
import d.j.a.g.b$a;
import java.lang.reflect.Modifier;

public class b$b {
    public Class a;
    public Class b;
    private boolean c;

    private b$b(Class serializable, Class clazz) {
        if (serializable != null) {
            if (clazz != null) {
                boolean bl2 = clazz.isInterface();
                if (!bl2 && (bl2 = Modifier.isPublic(clazz.getModifiers()))) {
                    boolean bl3;
                    this.a = serializable;
                    this.b = clazz;
                    this.c = bl3 = clazz.isAnnotationPresent(a.class);
                    return;
                }
                super("the clazz parameter must be interface type and public");
                throw serializable;
            }
            super("the clazz parameter cannot be NULL");
            throw serializable;
        }
        super("the interface parameter cannot be NULL");
        throw serializable;
    }

    public /* synthetic */ b$b(Class clazz, Class clazz2, b$a b$a) {
        this(clazz, clazz2);
    }

    public b a() {
        Class clazz = this.a;
        Class clazz2 = this.b;
        b b10 = new b(clazz, clazz2, null);
        boolean bl2 = this.c;
        d.j.a.g.b.a(b10, bl2);
        return b10;
    }

    public b$b b(boolean bl2) {
        this.c = bl2;
        return this;
    }
}

