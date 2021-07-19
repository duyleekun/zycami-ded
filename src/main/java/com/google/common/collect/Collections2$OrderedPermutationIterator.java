/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.AbstractIterator;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class Collections2$OrderedPermutationIterator
extends AbstractIterator {
    public final Comparator comparator;
    public List nextPermutation;

    public Collections2$OrderedPermutationIterator(List list, Comparator comparator) {
        this.nextPermutation = list = Lists.newArrayList(list);
        this.comparator = comparator;
    }

    public void calculateNextPermutation() {
        int n10;
        int n11 = this.findNextJ();
        if (n11 == (n10 = -1)) {
            this.nextPermutation = null;
            return;
        }
        n10 = this.findNextL(n11);
        Collections.swap(this.nextPermutation, n11, n10);
        n10 = this.nextPermutation.size();
        List list = this.nextPermutation;
        Collections.reverse(list.subList(++n11, n10));
    }

    public List computeNext() {
        List list = this.nextPermutation;
        if (list == null) {
            return (List)this.endOfData();
        }
        list = ImmutableList.copyOf((Collection)list);
        this.calculateNextPermutation();
        return list;
    }

    public int findNextJ() {
        List list = this.nextPermutation;
        for (int i10 = list.size() + -2; i10 >= 0; i10 += -1) {
            Comparator comparator = this.comparator;
            Object e10 = this.nextPermutation.get(i10);
            List list2 = this.nextPermutation;
            int n10 = i10 + 1;
            int n11 = comparator.compare(e10, list2 = list2.get(n10));
            if (n11 >= 0) continue;
            return i10;
        }
        return -1;
    }

    public int findNextL(int n10) {
        Object e10 = this.nextPermutation.get(n10);
        List list = this.nextPermutation;
        for (int i10 = list.size() + -1; i10 > n10; i10 += -1) {
            Comparator comparator = this.comparator;
            Object e11 = this.nextPermutation.get(i10);
            int n11 = comparator.compare(e10, e11);
            if (n11 >= 0) continue;
            return i10;
        }
        AssertionError assertionError = new AssertionError((Object)"this statement should be unreachable");
        throw assertionError;
    }
}

