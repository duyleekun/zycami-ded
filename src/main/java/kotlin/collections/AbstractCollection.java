/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import kotlin.collections.AbstractCollection$toString$1;
import kotlin.collections.CollectionsKt___CollectionsKt;

public abstract class AbstractCollection
implements Collection,
a {
    public boolean add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public abstract int b();

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean contains(Object object) {
        boolean bl2 = this.isEmpty();
        boolean bl3 = false;
        if (!bl2) {
            boolean bl4;
            Iterator iterator2 = this.iterator();
            while (bl4 = iterator2.hasNext()) {
                Object t10 = iterator2.next();
                bl4 = f0.g(t10, object);
                if (!bl4) continue;
                bl3 = true;
                break;
            }
        }
        return bl3;
    }

    public boolean containsAll(Collection object) {
        String string2 = "elements";
        f0.p(object, string2);
        boolean bl2 = object.isEmpty();
        boolean bl3 = true;
        if (!bl2) {
            object = object.iterator();
            while (bl2 = object.hasNext()) {
                string2 = object.next();
                bl2 = this.contains(string2);
                if (bl2) continue;
                bl3 = false;
                break;
            }
        }
        return bl3;
    }

    public boolean isEmpty() {
        int n10 = this.size();
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public abstract Iterator iterator();

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
        f0.p(objectArray, "array");
        objectArray = t.b(this, objectArray);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }

    public String toString() {
        AbstractCollection$toString$1 abstractCollection$toString$1 = new AbstractCollection$toString$1(this);
        return CollectionsKt___CollectionsKt.X2(this, ", ", "[", "]", 0, null, abstractCollection$toString$1, 24, null);
    }
}

