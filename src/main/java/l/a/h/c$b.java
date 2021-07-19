/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import l.a.h.b;
import l.a.h.c;
import l.a.h.c$d;

public final class c$b
implements Set {
    public final /* synthetic */ c a;

    public c$b(c c10) {
        this.a = c10;
    }

    public boolean a(Map.Entry object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean addAll(Collection object) {
        boolean bl2;
        c c10 = this.a;
        int n10 = c10.d();
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            c c11 = this.a;
            Object k10 = entry.getKey();
            entry = entry.getValue();
            c11.g(k10, entry);
        }
        object = this.a;
        int n11 = ((c)object).d();
        if (n10 != n11) {
            n11 = 1;
        } else {
            n11 = 0;
            object = null;
        }
        return n11 != 0;
    }

    public void clear() {
        this.a.a();
    }

    public boolean contains(Object object) {
        int n10 = object instanceof Map.Entry;
        if (n10 == 0) {
            return false;
        }
        Object object2 = this.a;
        Object k10 = (object = (Map.Entry)object).getKey();
        n10 = ((c)object2).e(k10);
        if (n10 < 0) {
            return false;
        }
        object2 = this.a.b(n10, 1);
        object = object.getValue();
        return b.c(object2, object);
    }

    public boolean containsAll(Collection object) {
        boolean bl2;
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            Object e10 = object.next();
            bl2 = this.contains(e10);
            if (bl2) continue;
            return false;
        }
        return true;
    }

    public boolean equals(Object object) {
        return c.k(this, object);
    }

    public int hashCode() {
        c c10 = this.a;
        int n10 = c10.d();
        int n11 = 1;
        n10 -= n11;
        int n12 = 0;
        while (n10 >= 0) {
            int n13;
            int n14;
            Object object = this.a.b(n10, 0);
            Object object2 = this.a.b(n10, n11);
            if (object == null) {
                n14 = 0;
                object = null;
            } else {
                n14 = object.hashCode();
            }
            if (object2 == null) {
                n13 = 0;
                object2 = null;
            } else {
                n13 = object2.hashCode();
            }
            n12 += (n14 ^= n13);
            n10 += -1;
        }
        return n12;
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
        c$d c$d = new c$d(c10);
        return c$d;
    }

    public boolean remove(Object object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean removeAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public boolean retainAll(Collection object) {
        object = new UnsupportedOperationException();
        throw object;
    }

    public int size() {
        return this.a.d();
    }

    public Object[] toArray() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
        throw unsupportedOperationException;
    }

    public Object[] toArray(Object[] object) {
        object = new UnsupportedOperationException();
        throw object;
    }
}

