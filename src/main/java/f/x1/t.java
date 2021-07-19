/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.o1.a;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;

public class t {
    public static final List a(List list) {
        f0.p(list, "builder");
        return ((a)list).m();
    }

    private static final List b(int n10, l l10) {
        List list = t.j(n10);
        l10.invoke(list);
        return t.a(list);
    }

    private static final List c(l l10) {
        List list = t.i();
        l10.invoke(list);
        return t.a(list);
    }

    private static final int d(int n10) {
        if (n10 < 0) {
            int n11 = 3;
            boolean bl2 = f.d2.l.a(1, n11, 0);
            if (bl2) {
                CollectionsKt__CollectionsKt.V();
            } else {
                ArithmeticException arithmeticException = new ArithmeticException("Count overflow has happened.");
                throw arithmeticException;
            }
        }
        return n10;
    }

    private static final int e(int n10) {
        if (n10 < 0) {
            int n11 = 3;
            boolean bl2 = f.d2.l.a(1, n11, 0);
            if (bl2) {
                CollectionsKt__CollectionsKt.W();
            } else {
                ArithmeticException arithmeticException = new ArithmeticException("Index overflow has happened.");
                throw arithmeticException;
            }
        }
        return n10;
    }

    private static final Object[] f(Collection collection) {
        return f.h2.t.t.a(collection);
    }

    private static final Object[] g(Collection objectArray, Object[] objectArray2) {
        Objects.requireNonNull(objectArray2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objectArray = f.h2.t.t.b((Collection)objectArray, objectArray2);
        Objects.requireNonNull(objectArray, "null cannot be cast to non-null type kotlin.Array<T>");
        return objectArray;
    }

    public static final Object[] h(Object[] objectArray, boolean bl2) {
        Class<?> clazz;
        boolean bl3;
        Class<Object[]> clazz2 = Object[].class;
        String string2 = "$this$copyToArrayOfAny";
        f0.p(objectArray, string2);
        if (!bl2 || !(bl3 = f0.g(clazz = objectArray.getClass(), clazz2))) {
            int n10 = objectArray.length;
            objectArray = Arrays.copyOf(objectArray, n10, clazz2);
        }
        f0.o(objectArray, "if (isVarargs && this.ja\u2026 Array<Any?>::class.java)");
        return objectArray;
    }

    public static final List i() {
        a a10 = new a();
        return a10;
    }

    public static final List j(int n10) {
        a a10 = new a(n10);
        return a10;
    }

    public static final List k(Object list) {
        list = Collections.singletonList(list);
        f0.o(list, "java.util.Collections.singletonList(element)");
        return list;
    }

    public static final List l(Iterable iterable) {
        f0.p(iterable, "$this$shuffled");
        iterable = CollectionsKt___CollectionsKt.K5(iterable);
        Collections.shuffle(iterable);
        return iterable;
    }

    public static final List m(Iterable iterable, Random random) {
        f0.p(iterable, "$this$shuffled");
        f0.p(random, "random");
        iterable = CollectionsKt___CollectionsKt.K5(iterable);
        Collections.shuffle(iterable, random);
        return iterable;
    }

    private static final List n(Enumeration object) {
        object = Collections.list(object);
        f0.o(object, "java.util.Collections.list(this)");
        return object;
    }
}

