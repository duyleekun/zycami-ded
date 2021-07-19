/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.x1.i1;
import f.y0;
import f.z0$a;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;

public final class z0
implements Collection,
a {
    private final byte[] a;

    private /* synthetic */ z0(byte[] byArray) {
        f0.p(byArray, "storage");
        this.a = byArray;
    }

    public static final /* synthetic */ z0 c(byte[] byArray) {
        f0.p(byArray, "v");
        z0 z02 = new z0(byArray);
        return z02;
    }

    public static byte[] e(int n10) {
        return z0.f(new byte[n10]);
    }

    public static byte[] f(byte[] byArray) {
        f0.p(byArray, "storage");
        return byArray;
    }

    public static boolean h(byte[] byArray, byte by2) {
        return ArraysKt___ArraysKt.J7(byArray, by2);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean i(byte[] byArray, Collection iterator2) {
        Object object = "elements";
        f0.p(iterator2, (String)object);
        byte by2 = iterator2.isEmpty();
        byte by3 = 0;
        byte by4 = 1;
        if (by2 != 0) {
            return by4 != 0;
        }
        iterator2 = iterator2.iterator();
        do {
            if ((by2 = iterator2.hasNext()) == 0) return by4 != 0;
            object = iterator2.next();
            boolean bl2 = object instanceof y0;
            if (bl2) {
                object = (y0)object;
                by2 = ((y0)object).Y();
                if ((by2 = (byte)(ArraysKt___ArraysKt.J7(byArray, by2) ? 1 : 0)) != 0) {
                    by2 = by4;
                    continue;
                }
            }
            by2 = 0;
            object = null;
        } while (by2 != 0);
        return by3 != 0;
    }

    public static boolean j(byte[] byArray, Object object) {
        boolean bl2;
        boolean bl3 = object instanceof z0;
        return bl3 && (bl2 = f0.g(byArray, object = (Object)((z0)object).v()));
    }

    public static final boolean k(byte[] byArray, byte[] byArray2) {
        return f0.g(byArray, byArray2);
    }

    public static final byte l(byte[] byArray, int n10) {
        return y0.h(byArray[n10]);
    }

    public static int n(byte[] byArray) {
        return byArray.length;
    }

    public static /* synthetic */ void o() {
    }

    public static int p(byte[] byArray) {
        int n10;
        if (byArray != null) {
            n10 = Arrays.hashCode(byArray);
        } else {
            n10 = 0;
            byArray = null;
        }
        return n10;
    }

    public static boolean q(byte[] byArray) {
        boolean bl2 = byArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            byArray = null;
        }
        return bl2;
    }

    public static i1 s(byte[] byArray) {
        z0$a z0$a = new z0$a(byArray);
        return z0$a;
    }

    public static final void t(byte[] byArray, int n10, byte by2) {
        byArray[n10] = by2;
    }

    public static String u(byte[] object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("UByteArray(storage=");
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

    public boolean b(byte by2) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsAll(Collection collection) {
        return z0.i(this.a, collection);
    }

    public boolean equals(Object object) {
        return z0.j(this.a, object);
    }

    public boolean g(byte by2) {
        return z0.h(this.a, by2);
    }

    public int hashCode() {
        return z0.p(this.a);
    }

    public boolean isEmpty() {
        return z0.q(this.a);
    }

    public int m() {
        return z0.n(this.a);
    }

    public i1 r() {
        return z0.s(this.a);
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
        return z0.u(this.a);
    }

    public final /* synthetic */ byte[] v() {
        return this.a;
    }
}

