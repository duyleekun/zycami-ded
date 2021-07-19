/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Collections2$OrderedPermutationIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.math.IntMath;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class Collections2$OrderedPermutationCollection
extends AbstractCollection {
    public final Comparator comparator;
    public final ImmutableList inputList;
    public final int size;

    public Collections2$OrderedPermutationCollection(Iterable iterable, Comparator comparator) {
        int n10;
        iterable = ImmutableList.sortedCopyOf(comparator, iterable);
        this.inputList = iterable;
        this.comparator = comparator;
        this.size = n10 = Collections2$OrderedPermutationCollection.calculateSize((List)iterable, comparator);
    }

    private static int calculateSize(List list, Comparator comparator) {
        int n10;
        int n11;
        int n12 = n11 = 1;
        int n13 = n11;
        int n14 = n11;
        while (n12 < (n10 = list.size())) {
            Object e10;
            n10 = n12 + -1;
            Object e11 = list.get(n10);
            if ((n10 = comparator.compare(e11, e10 = list.get(n12))) < 0) {
                n14 = IntMath.binomial(n12, n14);
                n13 = IntMath.saturatedMultiply(n13, n14);
                n14 = 0;
                n10 = -1 >>> 1;
                if (n13 == n10) {
                    return n10;
                }
            }
            ++n12;
            n14 += n11;
        }
        int n15 = IntMath.binomial(n12, n14);
        return IntMath.saturatedMultiply(n13, n15);
    }

    public boolean contains(Object object) {
        boolean bl2 = object instanceof List;
        if (bl2) {
            object = (List)object;
            return Collections2.access$000(this.inputList, (List)object);
        }
        return false;
    }

    public boolean isEmpty() {
        return false;
    }

    public Iterator iterator() {
        ImmutableList immutableList = this.inputList;
        Comparator comparator = this.comparator;
        Collections2$OrderedPermutationIterator collections2$OrderedPermutationIterator = new Collections2$OrderedPermutationIterator(immutableList, comparator);
        return collections2$OrderedPermutationIterator;
    }

    public int size() {
        return this.size;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("orderedPermutationCollection(");
        ImmutableList immutableList = this.inputList;
        stringBuilder.append(immutableList);
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}

