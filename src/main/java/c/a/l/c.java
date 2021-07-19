/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.l.e;

public final class c
implements e {
    private c.b.a.c a;

    public void a(c.b.a.c object) {
        if (object != null) {
            c.b.a.c c10 = this.a;
            if (c10 == null) {
                this.a = object;
                return;
            }
            object = new IllegalStateException();
            throw object;
        }
        object = new IllegalArgumentException();
        throw object;
    }

    public Object get() {
        Object object = this.a;
        if (object != null) {
            return object.get();
        }
        object = new IllegalStateException();
        throw object;
    }
}

