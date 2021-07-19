/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.x0.a;
import f.x1.h$a;
import java.util.Iterator;
import java.util.Set;
import kotlin.collections.AbstractCollection;

public abstract class h
extends AbstractCollection
implements Set,
a {
    public static final h$a a;

    static {
        h$a h$a;
        a = h$a = new h$a(null);
    }

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof Set;
        if (!bl2) {
            return false;
        }
        h$a h$a = a;
        object = (Set)object;
        return h$a.a(this, (Set)object);
    }

    public int hashCode() {
        return a.b(this);
    }

    public Iterator iterator() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }
}

