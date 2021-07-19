/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.z;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.collections.CollectionsKt___CollectionsKt;

public class a0
extends z {
    public static final List c1(Iterable iterable, Class clazz) {
        f0.p(iterable, "$this$filterIsInstance");
        f0.p(clazz, "klass");
        ArrayList arrayList = new ArrayList();
        return (List)a0.d1(iterable, arrayList, clazz);
    }

    public static final Collection d1(Iterable object, Collection collection, Class clazz) {
        boolean bl2;
        f0.p(object, "$this$filterIsInstanceTo");
        f0.p(collection, "destination");
        String string2 = "klass";
        f0.p(clazz, string2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            string2 = object.next();
            boolean bl3 = clazz.isInstance(string2);
            if (!bl3) continue;
            collection.add(string2);
        }
        return collection;
    }

    public static final void e1(List list) {
        f0.p(list, "$this$reverse");
        Collections.reverse(list);
    }

    private static final BigDecimal f1(Iterable object, l l10) {
        boolean bl2;
        long l11 = 0;
        BigDecimal bigDecimal = BigDecimal.valueOf(l11);
        Object object2 = "BigDecimal.valueOf(this.toLong())";
        f0.o(bigDecimal, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = (BigDecimal)l10.invoke(object2);
            bigDecimal = bigDecimal.add((BigDecimal)object2);
            object2 = "this.add(other)";
            f0.o(bigDecimal, (String)object2);
        }
        return bigDecimal;
    }

    private static final BigInteger g1(Iterable object, l l10) {
        boolean bl2;
        long l11 = 0;
        BigInteger bigInteger = BigInteger.valueOf(l11);
        Object object2 = "BigInteger.valueOf(this.toLong())";
        f0.o(bigInteger, (String)object2);
        object = object.iterator();
        while (bl2 = object.hasNext()) {
            object2 = object.next();
            object2 = (BigInteger)l10.invoke(object2);
            bigInteger = bigInteger.add((BigInteger)object2);
            object2 = "this.add(other)";
            f0.o(bigInteger, (String)object2);
        }
        return bigInteger;
    }

    public static final SortedSet h1(Iterable iterable) {
        f0.p(iterable, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)CollectionsKt___CollectionsKt.D5(iterable, treeSet);
    }

    public static final SortedSet i1(Iterable iterable, Comparator comparator) {
        f0.p(iterable, "$this$toSortedSet");
        f0.p(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        return (SortedSet)CollectionsKt___CollectionsKt.D5(iterable, treeSet);
    }
}

