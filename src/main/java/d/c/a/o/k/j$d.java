/*
 * Decompiled with CFR 0.151.
 */
package d.c.a.o.k;

import d.c.a.s.h;
import java.util.concurrent.Executor;

public final class j$d {
    public final h a;
    public final Executor b;

    public j$d(h h10, Executor executor) {
        this.a = h10;
        this.b = executor;
    }

    public boolean equals(Object object) {
        boolean bl2 = object instanceof j$d;
        if (bl2) {
            object = (j$d)object;
            h h10 = this.a;
            object = ((j$d)object).a;
            return h10.equals(object);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }
}

