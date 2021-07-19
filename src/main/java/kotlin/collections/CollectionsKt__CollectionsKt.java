/*
 * Decompiled with CFR 0.151.
 */
package kotlin.collections;

import f.h2.s.a;
import f.h2.s.l;
import f.h2.t.f0;
import f.k2.e;
import f.l2.k;
import f.x1.i;
import f.x1.n;
import f.x1.t;
import f.y1.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt$binarySearchBy$1;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.collections.EmptyList;

public class CollectionsKt__CollectionsKt
extends t {
    public static /* synthetic */ int A(List list, Comparable comparable, int n10, int n11, l l10, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = list.size();
        }
        f0.p(list, "$this$binarySearchBy");
        f0.p(l10, "selector");
        CollectionsKt__CollectionsKt$binarySearchBy$1 collectionsKt__CollectionsKt$binarySearchBy$1 = new CollectionsKt__CollectionsKt$binarySearchBy$1(l10, comparable);
        return CollectionsKt__CollectionsKt.t(list, n10, n11, collectionsKt__CollectionsKt$binarySearchBy$1);
    }

    private static final List B(int n10, l l10) {
        List list = t.j(n10);
        l10.invoke(list);
        return t.a(list);
    }

    private static final List C(l l10) {
        List list = t.i();
        l10.invoke(list);
        return t.a(list);
    }

    private static final boolean D(Collection collection, Collection collection2) {
        return collection.containsAll(collection2);
    }

    public static final List E() {
        return EmptyList.INSTANCE;
    }

    public static final k F(Collection collection) {
        f0.p(collection, "$this$indices");
        int n10 = collection.size() + -1;
        k k10 = new k(0, n10);
        return k10;
    }

    public static final int G(List list) {
        f0.p(list, "$this$lastIndex");
        return list.size() + -1;
    }

    private static final Object H(Collection object, a a10) {
        boolean bl2 = object.isEmpty();
        if (bl2) {
            object = a10.invoke();
        }
        return object;
    }

    private static final boolean I(Collection collection) {
        return collection.isEmpty() ^ true;
    }

    private static final boolean J(Collection collection) {
        boolean bl2;
        if (collection != null && !(bl2 = collection.isEmpty())) {
            bl2 = false;
            collection = null;
        } else {
            bl2 = true;
        }
        return bl2;
    }

    private static final List K() {
        return CollectionsKt__CollectionsKt.E();
    }

    public static final List L(Object ... object) {
        String string2 = "elements";
        f0.p(object, string2);
        int n10 = ((Object[])object).length;
        object = n10 > 0 ? n.t(object) : CollectionsKt__CollectionsKt.E();
        return object;
    }

    public static final List M(Object object) {
        object = object != null ? t.k(object) : CollectionsKt__CollectionsKt.E();
        return object;
    }

    public static final List N(Object ... objectArray) {
        f0.p(objectArray, "elements");
        return ArraysKt___ArraysKt.qa(objectArray);
    }

    private static final List O() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static final List P(Object ... object) {
        ArrayList arrayList = "elements";
        f0.p(object, (String)((Object)arrayList));
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            object = new ArrayList();
        } else {
            boolean bl2 = true;
            i i10 = new i((Object[])object, bl2);
            arrayList = new ArrayList(i10);
            object = arrayList;
        }
        return object;
    }

    public static final List Q(List list) {
        String string2 = "$this$optimizeReadOnlyList";
        f0.p(list, string2);
        int n10 = list.size();
        if (n10 != 0) {
            int n11 = 1;
            if (n10 == n11) {
                n10 = 0;
                string2 = null;
                list = t.k(list.get(0));
            }
        } else {
            list = CollectionsKt__CollectionsKt.E();
        }
        return list;
    }

    private static final Collection R(Collection collection) {
        if (collection == null) {
            collection = CollectionsKt__CollectionsKt.E();
        }
        return collection;
    }

    private static final List S(List list) {
        if (list == null) {
            list = CollectionsKt__CollectionsKt.E();
        }
        return list;
    }

    private static final void T(int n10, int n11, int n12) {
        String string2 = ").";
        CharSequence charSequence = "fromIndex (";
        if (n11 <= n12) {
            if (n11 >= 0) {
                if (n12 <= n10) {
                    return;
                }
                charSequence = new StringBuilder();
                ((StringBuilder)charSequence).append("toIndex (");
                ((StringBuilder)charSequence).append(n12);
                ((StringBuilder)charSequence).append(") is greater than size (");
                ((StringBuilder)charSequence).append(n10);
                ((StringBuilder)charSequence).append(string2);
                String string3 = ((StringBuilder)charSequence).toString();
                IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string3);
                throw indexOutOfBoundsException;
            }
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append((String)charSequence);
            stringBuilder.append(n11);
            stringBuilder.append(") is less than zero.");
            String string4 = stringBuilder.toString();
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(string4);
            throw indexOutOfBoundsException;
        }
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append((String)charSequence);
        stringBuilder.append(n11);
        stringBuilder.append(") is greater than toIndex (");
        stringBuilder.append(n12);
        stringBuilder.append(string2);
        String string5 = stringBuilder.toString();
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException(string5);
        throw illegalArgumentException;
    }

    public static final List U(Iterable iterable, e e10) {
        f0.p(iterable, "$this$shuffled");
        f0.p(e10, "random");
        iterable = CollectionsKt___CollectionsKt.K5(iterable);
        CollectionsKt___CollectionsKt.R4((List)iterable, e10);
        return iterable;
    }

    public static final void V() {
        ArithmeticException arithmeticException = new ArithmeticException("Count overflow has happened.");
        throw arithmeticException;
    }

    public static final void W() {
        ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened.");
        throw arithmeticException;
    }

    private static final List o(int n10, l l10) {
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = i10;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final List p(int n10, l l10) {
        ArrayList<Object> arrayList = new ArrayList<Object>(n10);
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = i10;
            object = l10.invoke(object);
            arrayList.add(object);
        }
        return arrayList;
    }

    private static final ArrayList q() {
        ArrayList arrayList = new ArrayList();
        return arrayList;
    }

    public static final ArrayList r(Object ... object) {
        ArrayList arrayList = "elements";
        f0.p(object, (String)((Object)arrayList));
        int n10 = ((Object[])object).length;
        if (n10 == 0) {
            object = new ArrayList();
        } else {
            boolean bl2 = true;
            i i10 = new i((Object[])object, bl2);
            arrayList = new ArrayList(i10);
            object = arrayList;
        }
        return object;
    }

    public static final Collection s(Object[] objectArray) {
        f0.p(objectArray, "$this$asCollection");
        i i10 = new i(objectArray, false);
        return i10;
    }

    public static final int t(List list, int n10, int n11, l l10) {
        f0.p(list, "$this$binarySearch");
        String string2 = "comparison";
        f0.p(l10, string2);
        int n12 = list.size();
        CollectionsKt__CollectionsKt.T(n12, n10, n11);
        n11 += -1;
        while (n10 <= n11) {
            n12 = n10 + n11 >>> 1;
            Object object = list.get(n12);
            int n13 = ((Number)(object = (Number)l10.invoke(object))).intValue();
            if (n13 < 0) {
                n10 = ++n12;
                continue;
            }
            if (n13 > 0) {
                n11 = n12 += -1;
                continue;
            }
            return n12;
        }
        return -(n10 + 1);
    }

    public static final int u(List list, Comparable comparable, int n10, int n11) {
        String string2 = "$this$binarySearch";
        f0.p(list, string2);
        int n12 = list.size();
        CollectionsKt__CollectionsKt.T(n12, n10, n11);
        n11 += -1;
        while (n10 <= n11) {
            n12 = n10 + n11 >>> 1;
            Comparable comparable2 = (Comparable)list.get(n12);
            int n13 = b.g(comparable2, comparable);
            if (n13 < 0) {
                n10 = ++n12;
                continue;
            }
            if (n13 > 0) {
                n11 = n12 += -1;
                continue;
            }
            return n12;
        }
        return -(n10 + 1);
    }

    public static final int v(List list, Object object, Comparator comparator, int n10, int n11) {
        f0.p(list, "$this$binarySearch");
        String string2 = "comparator";
        f0.p(comparator, string2);
        int n12 = list.size();
        CollectionsKt__CollectionsKt.T(n12, n10, n11);
        n11 += -1;
        while (n10 <= n11) {
            n12 = n10 + n11 >>> 1;
            Object e10 = list.get(n12);
            int n13 = comparator.compare(e10, object);
            if (n13 < 0) {
                n10 = ++n12;
                continue;
            }
            if (n13 > 0) {
                n11 = n12 += -1;
                continue;
            }
            return n12;
        }
        return -(n10 + 1);
    }

    public static /* synthetic */ int w(List list, int n10, int n11, l l10, int n12, Object object) {
        int n13 = n12 & 1;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 2) != 0) {
            n11 = list.size();
        }
        return CollectionsKt__CollectionsKt.t(list, n10, n11, l10);
    }

    public static /* synthetic */ int x(List list, Comparable comparable, int n10, int n11, int n12, Object object) {
        int n13 = n12 & 2;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 4) != 0) {
            n11 = list.size();
        }
        return CollectionsKt__CollectionsKt.u(list, comparable, n10, n11);
    }

    public static /* synthetic */ int y(List list, Object object, Comparator comparator, int n10, int n11, int n12, Object object2) {
        int n13 = n12 & 4;
        if (n13 != 0) {
            n10 = 0;
        }
        if ((n12 &= 8) != 0) {
            n11 = list.size();
        }
        return CollectionsKt__CollectionsKt.v(list, object, comparator, n10, n11);
    }

    public static final int z(List list, Comparable comparable, int n10, int n11, l l10) {
        f0.p(list, "$this$binarySearchBy");
        f0.p(l10, "selector");
        CollectionsKt__CollectionsKt$binarySearchBy$1 collectionsKt__CollectionsKt$binarySearchBy$1 = new CollectionsKt__CollectionsKt$binarySearchBy$1(l10, comparable);
        return CollectionsKt__CollectionsKt.t(list, n10, n11, collectionsKt__CollectionsKt$binarySearchBy$1);
    }
}

