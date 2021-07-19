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
import java.util.Map;
import java.util.Set;

public final class d
extends g
implements Set,
h {
    private final c a;

    public d(c c10) {
        f0.p(c10, "backing");
        this.a = c10;
    }

    public boolean addAll(Collection object) {
        f0.p(object, "elements");
        object = new UnsupportedOperationException();
        throw object;
    }

    public int b() {
        return this.a.size();
    }

    public boolean c(Map.Entry object) {
        f0.p(object, "element");
        object = new UnsupportedOperationException();
        throw object;
    }

    public void clear() {
        this.a.clear();
    }

    public boolean containsAll(Collection collection) {
        f0.p(collection, "elements");
        return this.a.r(collection);
    }

    public boolean e(Map.Entry entry) {
        f0.p(entry, "element");
        return this.a.s(entry);
    }

    public final c f() {
        return this.a;
    }

    public boolean g(Map.Entry entry) {
        f0.p(entry, "element");
        return this.a.L(entry);
    }

    public boolean isEmpty() {
        return this.a.isEmpty();
    }

    public Iterator iterator() {
        return this.a.w();
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

