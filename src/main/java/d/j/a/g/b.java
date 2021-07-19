/*
 * Decompiled with CFR 0.151.
 */
package d.j.a.g;

import d.j.a.g.b$a;
import d.j.a.g.b$b;

public class b {
    private Class a;
    private Class b;
    private boolean c;

    private b(Class clazz, Class clazz2) {
        this.a = clazz;
        this.b = clazz2;
    }

    public /* synthetic */ b(Class clazz, Class clazz2, b$a b$a) {
        this(clazz, clazz2);
    }

    public static /* synthetic */ boolean a(b b10, boolean bl2) {
        b10.c = bl2;
        return bl2;
    }

    public static b$b b(Class clazz) {
        b$b b$b = new b$b(clazz, clazz, null);
        return b$b;
    }

    public static b$b c(Class clazz, Class clazz2) {
        b$b b$b = new b$b(clazz, clazz2, null);
        return b$b;
    }

    public Class d() {
        return this.a;
    }

    public Class e() {
        return this.b;
    }

    public boolean f() {
        return this.c;
    }
}

