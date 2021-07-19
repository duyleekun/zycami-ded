/*
 * Decompiled with CFR 0.151.
 */
package d.v.e.i;

public class e {
    private boolean a = false;
    private final Object b;

    public e(Object object) {
        this.b = object;
    }

    public static e a(Object object) {
        e e10 = new e(object);
        return e10;
    }

    public Object b() {
        boolean bl2 = this.a;
        if (bl2) {
            return null;
        }
        this.a = true;
        return this.b;
    }

    public boolean c() {
        return this.a;
    }

    public Object d() {
        return this.b;
    }
}

