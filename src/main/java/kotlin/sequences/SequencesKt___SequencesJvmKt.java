/*
 * Decompiled with CFR 0.151.
 */
package kotlin.sequences;

import f.h2.s.l;
import f.h2.t.f0;
import f.n2.m;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;
import kotlin.sequences.SequencesKt__SequencesKt;
import kotlin.sequences.SequencesKt___SequencesJvmKt$filterIsInstance$1;
import kotlin.sequences.SequencesKt___SequencesKt;

public class SequencesKt___SequencesJvmKt
extends SequencesKt__SequencesKt {
    private static final BigInteger A(m object, l l10) {
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

    public static final SortedSet B(m m10) {
        f0.p(m10, "$this$toSortedSet");
        TreeSet treeSet = new TreeSet();
        return (SortedSet)SequencesKt___SequencesKt.T2(m10, treeSet);
    }

    public static final SortedSet C(m m10, Comparator comparator) {
        f0.p(m10, "$this$toSortedSet");
        f0.p(comparator, "comparator");
        TreeSet treeSet = new TreeSet(comparator);
        return (SortedSet)SequencesKt___SequencesKt.T2(m10, treeSet);
    }

    public static final m x(m m10, Class clazz) {
        f0.p(m10, "$this$filterIsInstance");
        f0.p(clazz, "klass");
        SequencesKt___SequencesJvmKt$filterIsInstance$1 sequencesKt___SequencesJvmKt$filterIsInstance$1 = new SequencesKt___SequencesJvmKt$filterIsInstance$1(clazz);
        m10 = SequencesKt___SequencesKt.i0(m10, sequencesKt___SequencesJvmKt$filterIsInstance$1);
        Objects.requireNonNull(m10, "null cannot be cast to non-null type kotlin.sequences.Sequence<R>");
        return m10;
    }

    public static final Collection y(m object, Collection collection, Class clazz) {
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

    private static final BigDecimal z(m object, l l10) {
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
}

