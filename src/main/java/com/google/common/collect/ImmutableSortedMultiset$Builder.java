/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableMultiset$Builder;
import com.google.common.collect.ImmutableSortedMultiset;
import com.google.common.collect.ImmutableSortedSet;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.RegularImmutableSortedMultiset;
import com.google.common.collect.RegularImmutableSortedSet;
import com.google.common.math.IntMath;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

public class ImmutableSortedMultiset$Builder
extends ImmutableMultiset$Builder {
    private final Comparator comparator;
    private int[] counts;
    public Object[] elements;
    private boolean forceCopyElements;
    private int length;

    public ImmutableSortedMultiset$Builder(Comparator object) {
        super(true);
        object = (Comparator)Preconditions.checkNotNull(object);
        this.comparator = object;
        int n10 = 4;
        Object[] objectArray = new Object[n10];
        this.elements = objectArray;
        object = new int[n10];
        this.counts = (int[])object;
    }

    private void dedupAndCoalesce(boolean n10) {
        Object object;
        Object object2;
        Object object3;
        int n11;
        int n12;
        int n13;
        int n14 = this.length;
        if (n14 == 0) {
            return;
        }
        Object[] objectArray = Arrays.copyOf(this.elements, n14);
        Comparator comparator = this.comparator;
        Arrays.sort(objectArray, comparator);
        int n15 = n13;
        for (n12 = n13 = 1; n12 < (n11 = objectArray.length); ++n12) {
            object3 = this.comparator;
            object2 = n15 + -1;
            object = objectArray[object2];
            Object object4 = objectArray[n12];
            n11 = object3.compare(object, object4);
            if (n11 >= 0) continue;
            objectArray[n15] = object3 = objectArray[n12];
            ++n15;
        }
        n12 = this.length;
        n11 = 0;
        object3 = null;
        Arrays.fill(objectArray, n15, n12, null);
        if (n10 != 0 && (n10 = n15 * 4) > (n11 = (n12 = this.length) * 3)) {
            n10 = n12 / 2 + n13;
            n10 = IntMath.saturatedAdd(n12, n10);
            objectArray = Arrays.copyOf(objectArray, n10);
        }
        n10 = objectArray.length;
        int[] nArray = new int[n10];
        n13 = 0;
        comparator = null;
        for (n12 = 0; n12 < (n11 = this.length); ++n12) {
            object3 = this.elements[n12];
            object = this.comparator;
            n11 = Arrays.binarySearch(objectArray, 0, n15, object3, object);
            object = this.counts;
            Object object5 = object[n12];
            if (object5 >= 0) {
                object5 = nArray[n11];
                object2 = object[n12];
                nArray[n11] = (int)(object5 += object2);
                continue;
            }
            nArray[n11] = object2 = ~object[n12];
        }
        this.elements = objectArray;
        this.counts = nArray;
        this.length = n15;
    }

    private void dedupAndCoalesceAndDeleteEmpty() {
        int n10;
        this.dedupAndCoalesce(false);
        int[] nArray = null;
        int n11 = 0;
        for (int i10 = 0; i10 < (n10 = this.length); ++i10) {
            Object object;
            int[] nArray2 = this.counts;
            int n12 = nArray2[i10];
            if (n12 <= 0) continue;
            Object[] objectArray = this.elements;
            objectArray[n11] = object = objectArray[i10];
            nArray2[n11] = n12 = nArray2[i10];
            ++n11;
        }
        Arrays.fill(this.elements, n11, n10, null);
        nArray = this.counts;
        n10 = this.length;
        Arrays.fill(nArray, n11, n10, 0);
        this.length = n11;
    }

    private void maintenance() {
        int n10 = this.length;
        Object[] objectArray = this.elements;
        int n11 = objectArray.length;
        if (n10 == n11) {
            n10 = 1;
            this.dedupAndCoalesce(n10 != 0);
        } else {
            n10 = (int)(this.forceCopyElements ? 1 : 0);
            if (n10 != 0) {
                n10 = objectArray.length;
                Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
                this.elements = objectArray2;
            }
        }
        this.forceCopyElements = false;
    }

    public ImmutableSortedMultiset$Builder add(Object object) {
        return this.addCopies(object, 1);
    }

    public ImmutableSortedMultiset$Builder add(Object ... objectArray) {
        for (Object object : objectArray) {
            this.add(object);
        }
        return this;
    }

    public ImmutableSortedMultiset$Builder addAll(Iterable iterator2) {
        int n10 = iterator2 instanceof Multiset;
        if (n10 != 0) {
            iterator2 = ((Multiset)((Object)iterator2)).entrySet().iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                Multiset$Entry multiset$Entry = (Multiset$Entry)iterator2.next();
                Object object = multiset$Entry.getElement();
                n10 = multiset$Entry.getCount();
                this.addCopies(object, n10);
            }
        } else {
            iterator2 = iterator2.iterator();
            while ((n10 = iterator2.hasNext()) != 0) {
                Object e10 = iterator2.next();
                this.add(e10);
            }
        }
        return this;
    }

    public ImmutableSortedMultiset$Builder addAll(Iterator iterator2) {
        boolean bl2;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            this.add(e10);
        }
        return this;
    }

    public ImmutableSortedMultiset$Builder addCopies(Object object, int n10) {
        Preconditions.checkNotNull(object);
        Object[] objectArray = "occurrences";
        CollectPreconditions.checkNonnegative(n10, (String)objectArray);
        if (n10 == 0) {
            return this;
        }
        this.maintenance();
        objectArray = this.elements;
        int n11 = this.length;
        objectArray[n11] = object;
        this.counts[n11] = n10;
        this.length = ++n11;
        return this;
    }

    public ImmutableSortedMultiset build() {
        int n10;
        this.dedupAndCoalesceAndDeleteEmpty();
        int n11 = this.length;
        if (n11 == 0) {
            return ImmutableSortedMultiset.emptyMultiset(this.comparator);
        }
        Object object = this.comparator;
        Object object2 = this.elements;
        RegularImmutableSortedSet regularImmutableSortedSet = (RegularImmutableSortedSet)ImmutableSortedSet.construct((Comparator)object, n11, object2);
        int n12 = this.length;
        int n13 = 1;
        object = new long[n12 += n13];
        int n14 = 0;
        while (n14 < (n10 = this.length)) {
            n10 = n14 + 1;
            reference var9_9 = object[n14];
            int[] nArray = this.counts;
            long l10 = nArray[n14];
            object[n10] = var9_9 += l10;
            n14 = n10;
        }
        this.forceCopyElements = n13;
        n14 = this.length;
        object2 = new RegularImmutableSortedMultiset(regularImmutableSortedSet, (long[])object, 0, n14);
        return object2;
    }

    public ImmutableSortedMultiset$Builder setCount(Object object, int n10) {
        Preconditions.checkNotNull(object);
        CollectPreconditions.checkNonnegative(n10, "count");
        this.maintenance();
        Object[] objectArray = this.elements;
        int n11 = this.length;
        objectArray[n11] = object;
        object = this.counts;
        object[n11] = n10 ^= 0xFFFFFFFF;
        this.length = ++n11;
        return this;
    }
}

