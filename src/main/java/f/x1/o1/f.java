/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.h2.t.x0.b;
import f.x1.d;
import f.x1.o1.c;
import java.util.Collection;
import java.util.Iterator;

public final class f
extends d
implements Collection,
b {
    private final c a;

    public f(c c10) {
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

    public final c c() {
        return this.a;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean contains(Object object) {
        return this.a.containsValue(object);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator iterator() {
        return this.a.Q();
    }

    public boolean remove(Object object) {
        return this.a.P(object);
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

