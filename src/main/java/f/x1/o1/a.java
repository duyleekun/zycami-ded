/*
 * Decompiled with CFR 0.151.
 */
package f.x1.o1;

import f.h2.t.f0;
import f.x1.c;
import f.x1.c$a;
import f.x1.e;
import f.x1.j;
import f.x1.j$a;
import f.x1.n;
import f.x1.o1.a$a;
import f.x1.o1.b;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public final class a
extends e
implements List,
RandomAccess,
f.h2.t.x0.e {
    private Object[] a;
    private int b;
    private int c;
    private boolean d;
    private final a e;
    private final a f;

    public a() {
        this(10);
    }

    public a(int n10) {
        Object[] objectArray = f.x1.o1.b.d(n10);
        this(objectArray, 0, 0, false, null, null);
    }

    private a(Object[] objectArray, int n10, int n11, boolean bl2, a a10, a a11) {
        this.a = objectArray;
        this.b = n10;
        this.c = n11;
        this.d = bl2;
        this.e = a10;
        this.f = a11;
    }

    public static final /* synthetic */ Object[] e(a a10) {
        return a10.a;
    }

    public static final /* synthetic */ int f(a a10) {
        return a10.c;
    }

    public static final /* synthetic */ int g(a a10) {
        return a10.b;
    }

    public static final /* synthetic */ void h(a a10, Object[] objectArray) {
        a10.a = objectArray;
    }

    public static final /* synthetic */ void i(a a10, int n10) {
        a10.c = n10;
    }

    public static final /* synthetic */ void j(a a10, int n10) {
        a10.b = n10;
    }

    private final void k(int n10, Collection object, int n11) {
        a a10 = this.e;
        if (a10 != null) {
            Object[] objectArray;
            a10.k(n10, (Collection)object, n11);
            this.a = objectArray = this.e.a;
            this.c = n10 = this.c + n11;
        } else {
            this.r(n10, n11);
            a10 = null;
            object = object.iterator();
            for (int i10 = 0; i10 < n11; ++i10) {
                Object[] objectArray = this.a;
                int n12 = n10 + i10;
                Object e10 = object.next();
                objectArray[n12] = e10;
            }
        }
    }

    private final void l(int n10, Object object) {
        Object[] objectArray = this.e;
        int n11 = 1;
        if (objectArray != null) {
            Object[] objectArray2;
            objectArray.l(n10, object);
            this.a = objectArray2 = this.e.a;
            this.c = n10 = this.c + n11;
        } else {
            this.r(n10, n11);
            objectArray = this.a;
            objectArray[n10] = object;
        }
    }

    private final void n() {
        Object object;
        boolean bl2 = this.d;
        if (!(bl2 || (object = this.f) != null && (bl2 = ((a)object).d))) {
            return;
        }
        object = new UnsupportedOperationException();
        throw object;
    }

    private final boolean o(List list) {
        Object[] objectArray = this.a;
        int n10 = this.b;
        int n11 = this.c;
        return f.x1.o1.b.a(objectArray, n10, n11, list);
    }

    private final void p(int n10) {
        Object[] objectArray = this.e;
        if (objectArray == null) {
            objectArray = this.a;
            int n11 = objectArray.length;
            if (n10 > n11) {
                j$a j$a = j.g;
                int n12 = objectArray.length;
                n10 = j$a.a(n12, n10);
                objectArray = this.a;
                Object[] objectArray2 = f.x1.o1.b.e(objectArray, n10);
                this.a = objectArray2;
            }
            return;
        }
        IllegalStateException illegalStateException = new IllegalStateException();
        throw illegalStateException;
    }

    private final void q(int n10) {
        int n11 = this.c + n10;
        this.p(n11);
    }

    private final void r(int n10, int n11) {
        this.q(n11);
        Object[] objectArray = this.a;
        int n12 = this.b;
        int n13 = this.c;
        n12 += n13;
        n13 = n10 + n11;
        n.c1(objectArray, objectArray, n13, n10, n12);
        this.c = n10 = this.c + n11;
    }

    private final Object s(int n10) {
        Object[] objectArray = this.e;
        if (objectArray != null) {
            int n11;
            Object object = objectArray.s(n10);
            this.c = n11 = this.c + -1;
            return object;
        }
        objectArray = this.a;
        Object object = objectArray[n10];
        int n12 = n10 + 1;
        int n13 = this.b;
        int n14 = this.c;
        n.c1(objectArray, objectArray, n10, n12, n13 += n14);
        Object[] objectArray2 = this.a;
        int n15 = this.b;
        n12 = this.c;
        n15 = n15 + n12 + -1;
        f.x1.o1.b.f(objectArray2, n15);
        this.c = n10 = this.c + -1;
        return object;
    }

    private final void t(int n10, int n11) {
        Object[] objectArray = this.e;
        if (objectArray != null) {
            super.t(n10, n11);
        } else {
            objectArray = this.a;
            int n12 = n10 + n11;
            int n13 = this.c;
            n.c1(objectArray, objectArray, n10, n12, n13);
            Object[] objectArray2 = this.a;
            int n14 = this.c;
            n12 = n14 - n11;
            f.x1.o1.b.g(objectArray2, n12, n14);
        }
        this.c = n10 = this.c - n11;
    }

    private final int u(int n10, int n11, Collection collection, boolean bl2) {
        a a10 = this.e;
        if (a10 != null) {
            n10 = a10.u(n10, n11, collection, bl2);
            this.c = n11 = this.c - n10;
            return n10;
        }
        int n12 = 0;
        a10 = null;
        int n13 = 0;
        while (n12 < n11) {
            Object object = this.a;
            int n14 = n10 + n12;
            boolean bl3 = collection.contains(object = object[n14]);
            if (bl3 == bl2) {
                Object object2;
                object = this.a;
                int n15 = n13 + 1;
                ++n12;
                object[n13 += n10] = object2 = object[n14];
                n13 = n15;
                continue;
            }
            ++n12;
        }
        int n16 = n11 - n13;
        Object[] objectArray = this.a;
        n11 += n10;
        n12 = this.c;
        n.c1(objectArray, objectArray, n10 += n13, n11, n12);
        Object[] objectArray2 = this.a;
        n11 = this.c;
        int n17 = n11 - n16;
        f.x1.o1.b.g(objectArray2, n17, n11);
        this.c = n10 = this.c - n16;
        return n16;
    }

    public void add(int n10, Object object) {
        this.n();
        c$a c$a = f.x1.c.a;
        int n11 = this.c;
        c$a.c(n10, n11);
        int n12 = this.b + n10;
        this.l(n12, object);
    }

    public boolean add(Object object) {
        this.n();
        int n10 = this.b;
        int n11 = this.c;
        this.l(n10 += n11, object);
        return true;
    }

    public boolean addAll(int n10, Collection collection) {
        f0.p(collection, "elements");
        this.n();
        c$a c$a = f.x1.c.a;
        int n11 = this.c;
        c$a.c(n10, n11);
        int n12 = collection.size();
        n11 = this.b + n10;
        this.k(n11, collection, n12);
        n10 = n12 > 0 ? 1 : 0;
        return n10 != 0;
    }

    public boolean addAll(Collection collection) {
        boolean bl2;
        String string2 = "elements";
        f0.p(collection, string2);
        this.n();
        int n10 = collection.size();
        int n11 = this.b;
        int n12 = this.c;
        this.k(n11 += n12, collection, n10);
        if (n10 > 0) {
            bl2 = true;
        } else {
            bl2 = false;
            collection = null;
        }
        return bl2;
    }

    public int b() {
        return this.c;
    }

    public Object c(int n10) {
        this.n();
        c$a c$a = f.x1.c.a;
        int n11 = this.c;
        c$a.b(n10, n11);
        int n12 = this.b + n10;
        return this.s(n12);
    }

    public void clear() {
        this.n();
        int n10 = this.b;
        int n11 = this.c;
        this.t(n10, n11);
    }

    public boolean equals(Object object) {
        boolean bl2;
        boolean bl3;
        if (!(object == this || (bl3 = object instanceof List) && (bl2 = this.o((List)(object = (List)object))))) {
            bl2 = false;
            object = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    public Object get(int n10) {
        Object[] objectArray = f.x1.c.a;
        int n11 = this.c;
        objectArray.b(n10, n11);
        objectArray = this.a;
        n11 = this.b + n10;
        return objectArray[n11];
    }

    public int hashCode() {
        Object[] objectArray = this.a;
        int n10 = this.b;
        int n11 = this.c;
        return f.x1.o1.b.b(objectArray, n10, n11);
    }

    public int indexOf(Object object) {
        int n10;
        for (int i10 = 0; i10 < (n10 = this.c); ++i10) {
            Object object2 = this.a;
            int n11 = this.b + i10;
            n10 = (int)(f0.g(object2 = object2[n11], object) ? 1 : 0);
            if (n10 == 0) continue;
            return i10;
        }
        return -1;
    }

    public boolean isEmpty() {
        int n10 = this.c;
        n10 = n10 == 0 ? 1 : 0;
        return n10 != 0;
    }

    public Iterator iterator() {
        a$a a$a = new a$a(this, 0);
        return a$a;
    }

    public int lastIndexOf(Object object) {
        for (int i10 = this.c + -1; i10 >= 0; i10 += -1) {
            Object object2 = this.a;
            int n10 = this.b + i10;
            boolean bl2 = f0.g(object2 = object2[n10], object);
            if (!bl2) continue;
            return i10;
        }
        return -1;
    }

    public ListIterator listIterator() {
        a$a a$a = new a$a(this, 0);
        return a$a;
    }

    public ListIterator listIterator(int n10) {
        Object object = f.x1.c.a;
        int n11 = this.c;
        ((c$a)object).c(n10, n11);
        object = new a$a(this, n10);
        return object;
    }

    public final List m() {
        Object object = this.e;
        if (object == null) {
            this.n();
            this.d = true;
            return this;
        }
        object = new IllegalStateException();
        throw object;
    }

    /*
     * WARNING - void declaration
     */
    public boolean remove(Object object) {
        void var2_5;
        this.n();
        int bl2 = this.indexOf(object);
        if (bl2 >= 0) {
            this.remove(bl2);
        }
        if (bl2 >= 0) {
            boolean bl3 = true;
        } else {
            boolean bl4 = false;
            object = null;
        }
        return (boolean)var2_5;
    }

    public boolean removeAll(Collection collection) {
        String string2 = "elements";
        f0.p(collection, string2);
        this.n();
        int n10 = this.b;
        int n11 = this.c;
        boolean bl2 = false;
        int n12 = this.u(n10, n11, collection, false);
        if (n12 > 0) {
            bl2 = true;
        }
        return bl2;
    }

    public boolean retainAll(Collection collection) {
        String string2 = "elements";
        f0.p(collection, string2);
        this.n();
        int n10 = this.b;
        int n11 = this.c;
        boolean bl2 = true;
        int n12 = this.u(n10, n11, collection, bl2);
        if (n12 <= 0) {
            bl2 = false;
        }
        return bl2;
    }

    public Object set(int n10, Object object) {
        this.n();
        Object[] objectArray = f.x1.c.a;
        int n11 = this.c;
        objectArray.b(n10, n11);
        objectArray = this.a;
        n11 = this.b;
        int n12 = n11 + n10;
        Object object2 = objectArray[n12];
        objectArray[n11 += n10] = object;
        return object2;
    }

    public List subList(int n10, int n11) {
        Object object = f.x1.c.a;
        int n12 = this.c;
        ((c$a)object).d(n10, n11, n12);
        Object[] objectArray = this.a;
        n12 = this.b;
        int n13 = n12 + n10;
        int n14 = n11 - n10;
        boolean bl2 = this.d;
        a a10 = this.f;
        a a11 = a10 != null ? a10 : this;
        object = new a(objectArray, n13, n14, bl2, this, a11);
        return object;
    }

    public String toString() {
        Object[] objectArray = this.a;
        int n10 = this.b;
        int n11 = this.c;
        return f.x1.o1.b.c(objectArray, n10, n11);
    }
}

