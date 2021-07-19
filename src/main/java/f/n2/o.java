/*
 * Decompiled with CFR 0.151.
 */
package f.n2;

import f.b2.c;
import f.b2.j.b;
import f.n2.m;
import f.q1;
import java.util.Collection;
import java.util.Iterator;

public abstract class o {
    public abstract Object b(Object var1, c var2);

    public final Object c(Iterable object, c object2) {
        boolean bl2 = object instanceof Collection;
        if (bl2) {
            Iterable iterable = object;
            iterable = (Collection)object;
            bl2 = iterable.isEmpty();
            if (bl2) {
                return q1.a;
            }
        }
        object = object.iterator();
        if ((object = this.e((Iterator)object, (c)object2)) == (object2 = b.h())) {
            return object;
        }
        return q1.a;
    }

    public abstract Object e(Iterator var1, c var2);

    public final Object f(m object, c object2) {
        object = object.iterator();
        if ((object = this.e((Iterator)object, (c)object2)) == (object2 = b.h())) {
            return object;
        }
        return q1.a;
    }
}

