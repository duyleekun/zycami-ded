/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Ordering;
import com.google.common.collect.SortedIterable;
import java.util.Comparator;
import java.util.SortedSet;

public final class SortedIterables {
    private SortedIterables() {
    }

    public static Comparator comparator(SortedSet object) {
        if ((object = object.comparator()) == null) {
            object = Ordering.natural();
        }
        return object;
    }

    public static boolean hasSameComparator(Comparator comparator, Iterable object) {
        block4: {
            block3: {
                boolean bl2;
                block2: {
                    Preconditions.checkNotNull(comparator);
                    Preconditions.checkNotNull(object);
                    bl2 = object instanceof SortedSet;
                    if (!bl2) break block2;
                    object = SortedIterables.comparator((SortedSet)object);
                    break block3;
                }
                bl2 = object instanceof SortedIterable;
                if (!bl2) break block4;
                object = ((SortedIterable)object).comparator();
            }
            return comparator.equals(object);
        }
        return false;
    }
}

