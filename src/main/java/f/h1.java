/*
 * Decompiled with CFR 0.151.
 */
package f;

import f.g1;
import f.h1$a;
import f.h2.t.f0;
import f.h2.t.t;
import f.h2.t.x0.a;
import f.x1.m1;
import java.util.Arrays;
import java.util.Collection;
import kotlin.collections.ArraysKt___ArraysKt;

public final class h1
implements Collection,
a {
    private final long[] a;

    private /* synthetic */ h1(long[] lArray) {
        f0.p(lArray, "storage");
        this.a = lArray;
    }

    public static final /* synthetic */ h1 c(long[] lArray) {
        f0.p(lArray, "v");
        h1 h12 = new h1(lArray);
        return h12;
    }

    public static long[] e(int n10) {
        return h1.f(new long[n10]);
    }

    public static long[] f(long[] lArray) {
        f0.p(lArray, "storage");
        return lArray;
    }

    public static boolean h(long[] lArray, long l10) {
        return ArraysKt___ArraysKt.O7(lArray, l10);
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static boolean i(long[] lArray, Collection iterator2) {
        Object object = "elements";
        f0.p(iterator2, (String)object);
        boolean bl2 = iterator2.isEmpty();
        boolean bl3 = false;
        boolean bl4 = true;
        if (bl2) {
            return bl4;
        }
        iterator2 = iterator2.iterator();
        do {
            long l10;
            if (!(bl2 = iterator2.hasNext())) return bl4;
            object = iterator2.next();
            boolean bl5 = object instanceof g1;
            if (bl5 && (bl2 = ArraysKt___ArraysKt.O7(lArray, l10 = ((g1)(object = (g1)object)).a0()))) {
                bl2 = bl4;
                continue;
            }
            bl2 = false;
            object = null;
        } while (bl2);
        return bl3;
    }

    public static boolean j(long[] lArray, Object object) {
        boolean bl2;
        boolean bl3 = object instanceof h1;
        return bl3 && (bl2 = f0.g(lArray, object = (Object)((h1)object).v()));
    }

    public static final boolean k(long[] lArray, long[] lArray2) {
        return f0.g(lArray, lArray2);
    }

    public static final long l(long[] lArray, int n10) {
        return g1.h(lArray[n10]);
    }

    public static int n(long[] lArray) {
        return lArray.length;
    }

    public static /* synthetic */ void o() {
    }

    public static int p(long[] lArray) {
        int n10;
        if (lArray != null) {
            n10 = Arrays.hashCode(lArray);
        } else {
            n10 = 0;
            lArray = null;
        }
        return n10;
    }

    public static boolean q(long[] lArray) {
        boolean bl2 = lArray.length;
        if (!bl2) {
            bl2 = true;
        } else {
            bl2 = false;
            lArray = null;
        }
        return bl2;
    }

    public static m1 s(long[] lArray) {
        h1$a h1$a = new h1$a(lArray);
        return h1$a;
    }

    public static final void t(long[] lArray, int n10, long l10) {
        lArray[n10] = l10;
    }

    public static String u(long[] object) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ULongArray(storage=");
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

    public boolean b(long l10) {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public void clear() {
        UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException("Operation is not supported for read-only collection");
        throw unsupportedOperationException;
    }

    public boolean containsAll(Collection collection) {
        return h1.i(this.a, collection);
    }

    public boolean equals(Object object) {
        return h1.j(this.a, object);
    }

    public boolean g(long l10) {
        return h1.h(this.a, l10);
    }

    public int hashCode() {
        return h1.p(this.a);
    }

    public boolean isEmpty() {
        return h1.q(this.a);
    }

    public int m() {
        return h1.n(this.a);
    }

    public m1 r() {
        return h1.s(this.a);
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
        return h1.u(this.a);
    }

    public final /* synthetic */ long[] v() {
        return this.a;
    }
}

