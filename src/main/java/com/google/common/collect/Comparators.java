/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.LexicographicalOrdering;
import java.util.Comparator;

public final class Comparators {
    private Comparators() {
    }

    public static boolean isInOrder(Iterable object, Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        object = object.iterator();
        int n10 = object.hasNext();
        if (n10 != 0) {
            boolean bl2;
            Object e10 = object.next();
            while (bl2 = object.hasNext()) {
                Object e11 = object.next();
                n10 = comparator.compare(e10, e11);
                if (n10 > 0) {
                    return false;
                }
                e10 = e11;
            }
        }
        return true;
    }

    public static boolean isInStrictOrder(Iterable object, Comparator comparator) {
        Preconditions.checkNotNull(comparator);
        object = object.iterator();
        int n10 = object.hasNext();
        if (n10 != 0) {
            boolean bl2;
            Object e10 = object.next();
            while (bl2 = object.hasNext()) {
                Object e11 = object.next();
                n10 = comparator.compare(e10, e11);
                if (n10 >= 0) {
                    return false;
                }
                e10 = e11;
            }
        }
        return true;
    }

    public static Comparator lexicographical(Comparator comparator) {
        comparator = (Comparator)Preconditions.checkNotNull(comparator);
        LexicographicalOrdering lexicographicalOrdering = new LexicographicalOrdering(comparator);
        return lexicographicalOrdering;
    }
}

