/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.x1.c0;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class EmptySet
implements Set,
Serializable,
a {
    public static final EmptySet INSTANCE;
    private static final long serialVersionUID = 3406603774387020532L;

    static {
        EmptySet emptySet;
        INSTANCE = emptySet = new EmptySet();
    }

    private EmptySet() {
    }

    private final Object readResolve() {
        return INSTANCE;
    }

    public /* synthetic */ boolean add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean add(Void object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean contains(Void void_) {
        f0.p(void_, "element");
        return false;
    }

    public boolean containsAll(Collection collection) {
        f0.p(collection, "elements");
        return collection.isEmpty();
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3 = object instanceof Set;
        if (bl3 && (bl2 = (object = (Set)object).isEmpty())) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public int getSize() {
        return 0;
    }

    public int hashCode() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public Iterator iterator() {
        return c0.a;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean removeAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean retainAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public Object[] toArray() {
        return t.a(this);
    }

    public Object[] toArray(Object[] objectArray) {
        return t.b(this, objectArray);
    }

    public String toString() {
        return "[]";
    }
}

