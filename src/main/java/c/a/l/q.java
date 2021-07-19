/*
 * Decompiled with CFR 0.151.
 */
package c.a.l;

import c.a.e;
import c.a.l.d;
import c.a.l.l;
import c.b.a.c;

public final class q
implements c,
e {
    private static final Object c;
    public static final /* synthetic */ boolean d;
    private volatile c a;
    private volatile Object b;

    static {
        Object object;
        c = object = new Object();
    }

    private q(c c10) {
        Object object;
        this.b = object = c;
        this.a = c10;
    }

    public static c a(c c10) {
        boolean bl2 = c10 instanceof q;
        if (!bl2 && !(bl2 = c10 instanceof d)) {
            c10 = (c)l.a(c10);
            q q10 = new q(c10);
            return q10;
        }
        return c10;
    }

    public Object get() {
        Object object = this.a;
        Object object2 = this.b;
        Object object3 = c;
        if (object2 == object3) {
            this.b = object = object.get();
            object = null;
            this.a = null;
        }
        return this.b;
    }
}

