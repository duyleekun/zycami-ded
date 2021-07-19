/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.h;
import f.h2.t.x0.a;
import f.x1.t;
import java.util.Collection;
import java.util.Iterator;
import kotlin.collections.ArraysKt___ArraysKt;

public final class i
implements Collection,
a {
    private final Object[] a;
    private final boolean b;

    public i(Object[] objectArray, boolean bl2) {
        f0.p(objectArray, "values");
        this.a = objectArray;
        this.b = bl2;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public int b() {
        return this.a.length;
    }

    public final Object[] c() {
        return this.a;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean contains(Object object) {
        return ArraysKt___ArraysKt.P7(this.a, object);
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

    public final boolean e() {
        return this.b;
    }

    public boolean isEmpty() {
        Object[] objectArray = this.a;
        boolean bl2 = objectArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            objectArray = null;
        }
        return bl2;
    }

    public Iterator iterator() {
        return h.a(this.a);
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

    public final Object[] toArray() {
        Object[] objectArray = this.a;
        boolean bl2 = this.b;
        return t.h(objectArray, bl2);
    }

    public Object[] toArray(Object[] objectArray) {
        return f.h2.t.t.b(this, objectArray);
    }
}

