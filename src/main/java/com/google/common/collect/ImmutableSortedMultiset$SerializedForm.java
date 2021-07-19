/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.ImmutableSortedMultiset$Builder;
import com.google.common.collect.Multiset$Entry;
import com.google.common.collect.SortedMultiset;
import java.io.Serializable;
import java.util.Comparator;

public final class ImmutableSortedMultiset$SerializedForm
implements Serializable {
    public final Comparator comparator;
    public final int[] counts;
    public final Object[] elements;

    public ImmutableSortedMultiset$SerializedForm(SortedMultiset object) {
        int n10;
        Object object2 = object.comparator();
        this.comparator = object2;
        int n11 = object.entrySet().size();
        Object object3 = new Object[n11];
        this.elements = object3;
        object2 = new int[n11];
        this.counts = (int[])object2;
        object = object.entrySet().iterator();
        n11 = 0;
        object2 = null;
        while ((n10 = object.hasNext()) != 0) {
            Object object4;
            object3 = (Multiset$Entry)object.next();
            Object[] objectArray = this.elements;
            objectArray[n11] = object4 = object3.getElement();
            objectArray = this.counts;
            n10 = object3.getCount();
            objectArray[n11] = n10;
            ++n11;
        }
    }

    public Object readResolve() {
        Object[] objectArray = this.elements;
        int n10 = objectArray.length;
        Comparator comparator = this.comparator;
        ImmutableSortedMultiset$Builder immutableSortedMultiset$Builder = new ImmutableSortedMultiset$Builder(comparator);
        comparator = null;
        for (int i10 = 0; i10 < n10; ++i10) {
            Object object = this.elements[i10];
            int[] nArray = this.counts;
            int n11 = nArray[i10];
            immutableSortedMultiset$Builder.addCopies(object, n11);
        }
        return immutableSortedMultiset$Builder.build();
    }
}

