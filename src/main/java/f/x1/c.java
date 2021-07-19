/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.t.f0;
import f.h2.t.x0.a;
import f.x1.c$a;
import f.x1.c$b;
import f.x1.c$c;
import f.x1.c$d;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.collections.AbstractCollection;

public abstract class c
extends AbstractCollection
implements List,
a {
    public static final c$a a;

    static {
        c$a c$a;
        a = c$a = new c$a(null);
    }

    public void add(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean addAll(int n10, Collection collection) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public abstract int b();

    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        boolean bl2 = object instanceof List;
        if (!bl2) {
            return false;
        }
        c$a c$a = a;
        object = (Collection)object;
        return c$a.e(this, (Collection)object);
    }

    public abstract Object get(int var1);

    public int hashCode() {
        return a.f(this);
    }

    public int indexOf(Object object) {
        int n10;
        block2: {
            boolean bl2;
            Iterator iterator2 = this.iterator();
            n10 = 0;
            while (bl2 = iterator2.hasNext()) {
                Object e10 = iterator2.next();
                bl2 = f0.g(e10, object);
                if (!bl2) {
                    ++n10;
                    continue;
                }
                break block2;
            }
            n10 = -1;
        }
        return n10;
    }

    public Iterator iterator() {
        c$b c$b = new c$b(this);
        return c$b;
    }

    public int lastIndexOf(Object object) {
        int n10;
        block1: {
            boolean bl2;
            int n11 = this.size();
            ListIterator listIterator = this.listIterator(n11);
            while (bl2 = listIterator.hasPrevious()) {
                Object e10 = listIterator.previous();
                bl2 = f0.g(e10, object);
                if (!bl2) continue;
                n10 = listIterator.nextIndex();
                break block1;
            }
            n10 = -1;
        }
        return n10;
    }

    public ListIterator listIterator() {
        c$c c$c = new c$c(this, 0);
        return c$c;
    }

    public ListIterator listIterator(int n10) {
        c$c c$c = new c$c(this, n10);
        return c$c;
    }

    public Object remove(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public Object set(int n10, Object object) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public List subList(int n10, int n11) {
        c$d c$d = new c$d(this, n10, n11);
        return c$d;
    }
}

