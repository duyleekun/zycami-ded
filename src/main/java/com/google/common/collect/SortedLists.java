/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedLists$KeyAbsentBehavior;
import com.google.common.collect.SortedLists$KeyPresentBehavior;
import java.util.Comparator;
import java.util.List;
import java.util.RandomAccess;

public final class SortedLists {
    private SortedLists() {
    }

    public static int binarySearch(List list, Function function, Comparable comparable, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Ordering ordering = Ordering.natural();
        return SortedLists.binarySearch(list, function, comparable, ordering, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, Function function, Object object, Comparator comparator, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        return SortedLists.binarySearch(Lists.transform(list, function), object, comparator, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, Comparable comparable, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparable);
        Ordering ordering = Ordering.natural();
        return SortedLists.binarySearch(list, comparable, ordering, sortedLists$KeyPresentBehavior, sortedLists$KeyAbsentBehavior);
    }

    public static int binarySearch(List list, Object object, Comparator comparator, SortedLists$KeyPresentBehavior sortedLists$KeyPresentBehavior, SortedLists$KeyAbsentBehavior sortedLists$KeyAbsentBehavior) {
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(list);
        Preconditions.checkNotNull((Object)sortedLists$KeyPresentBehavior);
        Preconditions.checkNotNull((Object)sortedLists$KeyAbsentBehavior);
        int n10 = list instanceof RandomAccess;
        if (n10 == 0) {
            list = Lists.newArrayList(list);
        }
        n10 = 0;
        int n11 = list.size() + -1;
        while (n10 <= n11) {
            int n12 = n10 + n11 >>> 1;
            Object e10 = list.get(n12);
            int n13 = comparator.compare(object, e10);
            if (n13 < 0) {
                n11 = n12 += -1;
                continue;
            }
            if (n13 > 0) {
                n10 = ++n12;
                continue;
            }
            list = list.subList(n10, ++n11);
            int n14 = sortedLists$KeyPresentBehavior.resultIndex(comparator, object, list, n12 -= n10);
            return n10 + n14;
        }
        return sortedLists$KeyAbsentBehavior.resultIndex(n10);
    }
}

