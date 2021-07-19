/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.m1;
import f.n1$a;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;

public final class n1
implements Collection,
a {
    private final short[] a;

    private /* synthetic */ n1(short[] sArray) {
        f0.p(sArray, "storage");
        this.a = sArray;
    }

    public static final /* synthetic */ n1 c(short[] sArray) {
        f0.p(sArray, "v");
        n1 n12 = new n1(sArray);
        return n12;
    }

    public static short[] e(int n10) {
        return n1.f(new short[n10]);
    }

    public static short[] f(short[] sArray) {
        f0.p(sArray, "storage");
        return sArray;
    }

    public static boolean h(short[] sArray, short s10) {
        return ArraysKt___ArraysKt.Q7(sArray, s10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean i(short[] sArray, Collection iterator2) {
        Object object = "elements";
        f0.p(iterator2, (String)object);
        short s10 = iterator2.isEmpty();
        short s11 = 0;
        short s12 = 1;
        if (s10 != 0) {
            return s12 != 0;
        }
        iterator2 = iterator2.iterator();
        do {
            if ((s10 = iterator2.hasNext()) == 0) return s12 != 0;
            object = iterator2.next();
            boolean bl2 = object instanceof m1;
            if (bl2) {
                object = (m1)object;
                s10 = ((m1)object).Y();
                if ((s10 = (short)(ArraysKt___ArraysKt.Q7(sArray, s10) ? 1 : 0)) != 0) {
                    s10 = s12;
                    continue;
                }
            }
            s10 = 0;
            object = null;
        } while (s10 != 0);
        return s11 != 0;
    }

    public static boolean j(short[] sArray, Object object) {
        boolean bl2;
        boolean bl3 = object instanceof n1;
        return bl3 && (bl2 = f0.g(sArray, object = (Object)((n1)object).v()));
    }

    public static final boolean k(short[] sArray, short[] sArray2) {
        return f0.g(sArray, sArray2);
    }

    public static final short l(short[] sArray, int n10) {
        return m1.h(sArray[n10]);
    }

    public static int n(short[] sArray) {
        return sArray.length;
    }

    public static /* synthetic */ void o() {
    }

    public static int p(short[] sArray) {
        int n10;
        if (sArray != null) {
            n10 = Arrays.hashCode(sArray);
        } else {
            n10 = 0;
            sArray = null;
        }
        return n10;
    }

    public static boolean q(short[] sArray) {
        boolean bl2 = sArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            sArray = null;
        }
        return bl2;
    }

    public static f.x1.n1 s(short[] sArray) {
        n1$a n1$a = new n1$a(sArray);
        return n1$a;
    }

    public static final void t(short[] sArray, int n10, short s10) {
        sArray[n10] = s10;
    }

    public static String u(short[] object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UShortArray(storage=");
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

    public boolean b(short s10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsAll(Collection collection) {
        return n1.i(this.a, collection);
    }

    public boolean equals(Object object) {
        return n1.j(this.a, object);
    }

    public boolean g(short s10) {
        return n1.h(this.a, s10);
    }

    public int hashCode() {
        return n1.p(this.a);
    }

    public boolean isEmpty() {
        return n1.q(this.a);
    }

    public int m() {
        return n1.n(this.a);
    }

    public f.x1.n1 r() {
        return n1.s(this.a);
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
        return n1.u(this.a);
    }

    public final /* synthetic */ short[] v() {
        return this.a;
    }
}

