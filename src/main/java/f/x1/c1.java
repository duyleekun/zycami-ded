/*
 * Decompiled with CFR 0.151.
 */
package f.x1;

import f.h2.s.l;
import f.h2.t.f0;
import f.x1.o1.g;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.collections.ArraysKt___ArraysKt;

public class c1 {
    public static final Set a(Set set) {
        f0.p(set, "builder");
        return ((g)set).c();
    }

    private static final Set b(int n10, l l10) {
        Set set = c1.e(n10);
        l10.invoke(set);
        return c1.a(set);
    }

    private static final Set c(l l10) {
        Set set = c1.d();
        l10.invoke(set);
        return c1.a(set);
    }

    public static final Set d() {
        g g10 = new g();
        return g10;
    }

    public static final Set e(int n10) {
        g g10 = new g(n10);
        return g10;
    }

    public static final Set f(Object set) {
        set = Collections.singleton(set);
        f0.o(set, "java.util.Collections.singleton(element)");
        return set;
    }

    public static final TreeSet g(Comparator comparator, Object ... objectArray) {
        f0.p(comparator, "comparator");
        f0.p(objectArray, "elements");
        TreeSet treeSet = new TreeSet(comparator);
        return (TreeSet)ArraysKt___ArraysKt.Zx(objectArray, treeSet);
    }

    public static final TreeSet h(Object ... objectArray) {
        f0.p(objectArray, "elements");
        TreeSet treeSet = new TreeSet();
        return (TreeSet)ArraysKt___ArraysKt.Zx(objectArray, treeSet);
    }
}

