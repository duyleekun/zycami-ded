/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap$Builder;
import com.google.common.collect.ImmutableSortedMap;
import com.google.common.collect.RegularImmutableSortedSet;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;

public class ImmutableSortedMap$Builder
extends ImmutableMap$Builder {
    private final Comparator comparator;
    private transient Object[] keys;
    private transient Object[] values;

    public ImmutableSortedMap$Builder(Comparator comparator) {
        this(comparator, 4);
    }

    private ImmutableSortedMap$Builder(Comparator objectArray, int n10) {
        objectArray = (Comparator)Preconditions.checkNotNull(objectArray);
        this.comparator = objectArray;
        objectArray = new Object[n10];
        this.keys = objectArray;
        objectArray = new Object[n10];
        this.values = objectArray;
    }

    private void ensureCapacity(int n10) {
        Object[] objectArray = this.keys;
        int n11 = objectArray.length;
        if (n10 > n11) {
            int n12 = objectArray.length;
            n10 = ImmutableCollection$Builder.expandedCapacity(n12, n10);
            this.keys = objectArray = Arrays.copyOf(this.keys, n10);
            objectArray = this.values;
            Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
            this.values = objectArray2;
        }
    }

    public ImmutableSortedMap build() {
        int n10 = this.size;
        if (n10 != 0) {
            Object object = null;
            int n11 = 1;
            if (n10 != n11) {
                Object object2;
                Object object3;
                int n12;
                Object object4 = Arrays.copyOf(this.keys, n10);
                Object object5 = this.comparator;
                Arrays.sort(object4, object5);
                n11 = this.size;
                object5 = new Object[n11];
                for (int i10 = 0; i10 < (n12 = this.size); ++i10) {
                    Object object6;
                    int n13;
                    Object object7;
                    if (i10 > 0 && (n12 = (object3 = this.comparator).compare(object7 = object4[n13 = i10 + -1], object6 = object4[i10])) == 0) {
                        object3 = new StringBuilder();
                        ((StringBuilder)object3).append("keys required to be distinct but compared as equal: ");
                        object2 = object4[n13];
                        ((StringBuilder)object3).append(object2);
                        ((StringBuilder)object3).append(" and ");
                        object4 = object4[i10];
                        ((StringBuilder)object3).append(object4);
                        object4 = ((StringBuilder)object3).toString();
                        object5 = new IllegalArgumentException((String)object4);
                        throw object5;
                    }
                    object3 = this.keys[i10];
                    object2 = this.comparator;
                    n12 = Arrays.binarySearch(object4, object3, object2);
                    object5[n12] = object2 = this.values[i10];
                }
                object4 = ImmutableList.asImmutableList(object4);
                object2 = this.comparator;
                object3 = new RegularImmutableSortedSet((ImmutableList)object4, (Comparator)object2);
                object4 = ImmutableList.asImmutableList(object5);
                object = new ImmutableSortedMap((RegularImmutableSortedSet)object3, (ImmutableList)object4);
                return object;
            }
            Comparator comparator = this.comparator;
            Object object8 = this.keys[0];
            object = this.values[0];
            return ImmutableSortedMap.access$000(comparator, object8, object);
        }
        return ImmutableSortedMap.emptyMap(this.comparator);
    }

    public ImmutableSortedMap$Builder orderEntriesByValue(Comparator object) {
        object = new UnsupportedOperationException("Not available on ImmutableSortedMap.Builder");
        throw object;
    }

    public ImmutableSortedMap$Builder put(Object object, Object object2) {
        int n10 = this.size + 1;
        this.ensureCapacity(n10);
        CollectPreconditions.checkEntryNotNull(object, object2);
        Object[] objectArray = this.keys;
        int n11 = this.size;
        objectArray[n11] = object;
        this.values[n11] = object2;
        this.size = ++n11;
        return this;
    }

    public ImmutableSortedMap$Builder put(Map.Entry entry) {
        super.put(entry);
        return this;
    }

    public ImmutableSortedMap$Builder putAll(Iterable iterable) {
        super.putAll(iterable);
        return this;
    }

    public ImmutableSortedMap$Builder putAll(Map map) {
        super.putAll(map);
        return this;
    }
}

