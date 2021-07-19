/*
 * Decompiled with CFR 0.151.
 */
package l.a.h;

import java.util.Collection;
import java.util.Iterator;
import l.a.h.c;
import l.a.h.c$a;

public final class c$e
implements Collection {
    public final /* synthetic */ c a;

    public c$e(c c10) {
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
        int n10 = c10.f(object);
        if (n10 >= 0) {
            n10 = 1;
        } else {
            n10 = 0;
            object = null;
        }
        return n10 != 0;
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
        c$a c$a = new c$a(c10, 1);
        return c$a;
    }

    public boolean remove(Object object) {
        c c10 = this.a;
        int n10 = c10.f(object);
        if (n10 >= 0) {
            this.a.h(n10);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        int n10;
        c c10 = this.a;
        int n11 = c10.d();
        int n12 = 0;
        c c11 = null;
        for (int i10 = 0; i10 < n11; i10 += n10) {
            Object object = this.a;
            n10 = 1;
            boolean bl2 = collection.contains(object = ((c)object).b(i10, n10));
            if (!bl2) continue;
            c11 = this.a;
            c11.h(i10);
            i10 += -1;
            n11 += -1;
            n12 = n10;
        }
        return n12 != 0;
    }

    public boolean retainAll(Collection collection) {
        int n10;
        c c10 = this.a;
        int n11 = c10.d();
        int n12 = 0;
        c c11 = null;
        for (int i10 = 0; i10 < n11; i10 += n10) {
            Object object = this.a;
            n10 = 1;
            boolean bl2 = collection.contains(object = ((c)object).b(i10, n10));
            if (bl2) continue;
            c11 = this.a;
            c11.h(i10);
            i10 += -1;
            n11 += -1;
            n12 = n10;
        }
        return n12 != 0;
    }

    public int size() {
        return this.a.d();
    }

    public Object[] toArray() {
        return this.a.q(1);
    }

    public Object[] toArray(Object[] objectArray) {
        return this.a.r(objectArray, 1);
    }
}

