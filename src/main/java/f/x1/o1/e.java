/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.h;
import f.x1.g;
import f.x1.o1.c;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public final class e
extends g
implements Set,
h {
    private final c a;

    public e(c c10) {
        f0.p(c10, "backing");
        this.a = c10;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        f0.p(object, "elements");
        object = new UnsupportedOperationException();
        throw object;
    }

    public int b() {
        return this.a.size();
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object object) {
        return this.a.containsKey(object);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator iterator() {
        return this.a.G();
    }

    public boolean remove(Object object) {
        c c10 = this.a;
        int n10 = c10.N(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean removeAll(Collection collection) {
        f0.p(collection, "elements");
        this.a.p();
        return super.removeAll(collection);
    }

    public boolean retainAll(Collection collection) {
        f0.p(collection, "elements");
        this.a.p();
        return super.retainAll(collection);
    }
}

