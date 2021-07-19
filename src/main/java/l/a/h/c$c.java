/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import l.a.h.c;
import l.a.h.c$a;

public final class c$c
implements Set {
    public final /* synthetic */ c a;

    public c$c(c c10) {
        this.a = c10;
    }

    public boolean add(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public void clear() {
        this.a.a();
    }

    public boolean contains(Object object) {
        c c10 = this.a;
        int n10 = c10.e(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
    }

    public boolean containsAll(Collection collection) {
        return c.j(this.a.c(), collection);
    }

    public boolean equals(Object object) {
        return c.k(this, object);
    }

    public int hashCode() {
        c c10 = this.a;
        int n10 = 0;
        for (int i10 = c10.d() + -1; i10 >= 0; i10 += -1) {
            int n11;
            Object object = this.a.b(i10, 0);
            if (object == null) {
                n11 = 0;
                object = null;
            } else {
                n11 = object.hashCode();
            }
            n10 += n11;
        }
        return n10;
    }

    public boolean isEmpty() {
        c c10 = this.a;
        int n10 = c10.d();
        if (!n10) {
            n10 = 1;
        } else {
            n10 = 0;
            c10 = null;
        }
        return n10 != 0;
    }

    public Iterator iterator() {
        c c10 = this.a;
        c$a c$a = new c$a(c10, 0);
        return c$a;
    }

    public boolean remove(Object object) {
        c c10 = this.a;
        int n10 = c10.e(object);
        if (n10 >= 0) {
            this.a.h(n10);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        return c.o(this.a.c(), collection);
    }

    public boolean retainAll(Collection collection) {
        return c.p(this.a.c(), collection);
    }

    public int size() {
        return this.a.d();
    }

    public Object[] toArray() {
        return this.a.q(0);
    }

    public Object[] toArray(Object[] objectArray) {
        return this.a.r(objectArray, 0);
    }
}

