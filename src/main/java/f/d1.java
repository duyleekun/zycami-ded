/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.c1;
import f.d1$a;
import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.x1.l1;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;

public final class d1
implements Collection,
a {
    private final int[] a;

    private /* synthetic */ d1(int[] nArray) {
        f0.p(nArray, "storage");
        this.a = nArray;
    }

    public static final /* synthetic */ d1 c(int[] nArray) {
        f0.p(nArray, "v");
        d1 d12 = new d1(nArray);
        return d12;
    }

    public static int[] e(int n10) {
        return d1.f(new int[n10]);
    }

    public static int[] f(int[] nArray) {
        f0.p(nArray, "storage");
        return nArray;
    }

    public static boolean h(int[] nArray, int n10) {
        return ArraysKt___ArraysKt.N7(nArray, n10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean i(int[] nArray, Collection iterator2) {
        Object object = "elements";
        f0.p(iterator2, (String)object);
        int n10 = iterator2.isEmpty();
        int n11 = 0;
        int n12 = 1;
        if (n10 != 0) {
            return n12 != 0;
        }
        iterator2 = iterator2.iterator();
        do {
            if ((n10 = iterator2.hasNext()) == 0) return n12 != 0;
            object = iterator2.next();
            boolean bl2 = object instanceof c1;
            if (bl2) {
                object = (c1)object;
                n10 = ((c1)object).a0();
                if ((n10 = (int)(ArraysKt___ArraysKt.N7(nArray, n10) ? 1 : 0)) != 0) {
                    n10 = n12;
                    continue;
                }
            }
            n10 = 0;
            object = null;
        } while (n10 != 0);
        return n11 != 0;
    }

    public static boolean j(int[] nArray, Object object) {
        boolean bl2;
        boolean bl3 = object instanceof d1;
        return bl3 && (bl2 = f0.g(nArray, object = (Object)((d1)object).v()));
    }

    public static final boolean k(int[] nArray, int[] nArray2) {
        return f0.g(nArray, nArray2);
    }

    public static final int l(int[] nArray, int n10) {
        return c1.h(nArray[n10]);
    }

    public static int n(int[] nArray) {
        return nArray.length;
    }

    public static /* synthetic */ void o() {
    }

    public static int p(int[] nArray) {
        int n10;
        if (nArray != null) {
            n10 = Arrays.hashCode(nArray);
        } else {
            n10 = 0;
            nArray = null;
        }
        return n10;
    }

    public static boolean q(int[] nArray) {
        boolean bl2 = nArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            nArray = null;
        }
        return bl2;
    }

    public static l1 s(int[] nArray) {
        d1$a d1$a = new d1$a(nArray);
        return d1$a;
    }

    public static final void t(int[] nArray, int n10, int n11) {
        nArray[n10] = n11;
    }

    public static String u(int[] object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UIntArray(storage=");
        object = Arrays.toString(object);
        stringBuilder.append((String)object);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }

    public /* synthetic */ boolean add(Object object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean addAll(Collection object) {
        object = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw object;
    }

    public boolean b(int n10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsAll(Collection collection) {
        return d1.i(this.a, collection);
    }

    public boolean equals(Object object) {
        return d1.j(this.a, object);
    }

    public boolean g(int n10) {
        return d1.h(this.a, n10);
    }

    public int hashCode() {
        return d1.p(this.a);
    }

    public boolean isEmpty() {
        return d1.q(this.a);
    }

    public int m() {
        return d1.n(this.a);
    }

    public l1 r() {
        return d1.s(this.a);
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

    public Object[] toArray() {
        return t.a(this);
    }

    public Object[] toArray(Object[] objectArray) {
        return t.b(this, objectArray);
    }

    public String toString() {
        return d1.u(this.a);
    }

    public final /* synthetic */ int[] v() {
        return this.a;
    }
}

