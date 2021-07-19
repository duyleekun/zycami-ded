/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.CollectPreconditions;
import com.google.common.collect.ImmutableCollection$Builder;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.common.collect.RegularImmutableMap;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Map;

public class ImmutableMap$Builder {
    public Object[] alternatingKeysAndValues;
    public boolean entriesUsed;
    public int size;
    public Comparator valueComparator;

    public ImmutableMap$Builder() {
        this(4);
    }

    public ImmutableMap$Builder(int n10) {
        Object[] objectArray = new Object[n10 * 2];
        this.alternatingKeysAndValues = objectArray;
        this.size = 0;
        this.entriesUsed = false;
    }

    private void ensureCapacity(int n10) {
        Object[] objectArray = this.alternatingKeysAndValues;
        int n11 = objectArray.length;
        if ((n10 *= 2) > n11) {
            n11 = objectArray.length;
            n10 = ImmutableCollection$Builder.expandedCapacity(n11, n10);
            Object[] objectArray2 = Arrays.copyOf(objectArray, n10);
            this.alternatingKeysAndValues = objectArray2;
            n10 = 0;
            objectArray2 = null;
            this.entriesUsed = false;
        }
    }

    public ImmutableMap build() {
        this.sortEntries();
        this.entriesUsed = true;
        int n10 = this.size;
        Object[] objectArray = this.alternatingKeysAndValues;
        return RegularImmutableMap.create(n10, objectArray);
    }

    public ImmutableMap$Builder orderEntriesByValue(Comparator comparator) {
        boolean bl2;
        Comparator comparator2 = this.valueComparator;
        if (comparator2 == null) {
            bl2 = true;
        } else {
            bl2 = false;
            comparator2 = null;
        }
        Preconditions.checkState(bl2, "valueComparator was already set");
        this.valueComparator = comparator = (Comparator)Preconditions.checkNotNull(comparator, "valueComparator");
        return this;
    }

    public ImmutableMap$Builder put(Object object, Object object2) {
        int n10 = this.size + 1;
        this.ensureCapacity(n10);
        CollectPreconditions.checkEntryNotNull(object, object2);
        Object[] objectArray = this.alternatingKeysAndValues;
        int n11 = this.size;
        int n12 = n11 * 2;
        objectArray[n12] = object;
        int n13 = n11 * 2 + 1;
        objectArray[n13] = object2;
        this.size = ++n11;
        return this;
    }

    public ImmutableMap$Builder put(Map.Entry entry) {
        Object k10 = entry.getKey();
        entry = entry.getValue();
        return this.put(k10, entry);
    }

    public ImmutableMap$Builder putAll(Iterable object) {
        int n10 = object instanceof Collection;
        if (n10 != 0) {
            n10 = this.size;
            Iterable iterable = object;
            iterable = (Collection)object;
            int n11 = iterable.size();
            this.ensureCapacity(n10 += n11);
        }
        object = object.iterator();
        while ((n10 = (int)(object.hasNext() ? 1 : 0)) != 0) {
            Map.Entry entry = (Map.Entry)object.next();
            this.put(entry);
        }
        return this;
    }

    public ImmutableMap$Builder putAll(Map object) {
        object = object.entrySet();
        return this.putAll((Iterable)object);
    }

    public void sortEntries() {
        Object[] objectArray = this.valueComparator;
        if (objectArray != null) {
            Object object;
            int n10;
            int n11;
            int n12;
            int n13 = this.entriesUsed;
            if (n13 != 0) {
                objectArray = this.alternatingKeysAndValues;
                n12 = this.size * 2;
                this.alternatingKeysAndValues = objectArray = Arrays.copyOf(objectArray, n12);
            }
            n13 = this.size;
            objectArray = new Map.Entry[n13];
            n12 = 0;
            Object[] objectArray2 = null;
            for (n11 = 0; n11 < (n10 = this.size); ++n11) {
                AbstractMap.SimpleImmutableEntry<Object, Object[]> simpleImmutableEntry;
                object = this.alternatingKeysAndValues;
                int n14 = n11 * 2;
                Object object2 = object[n14];
                object = object[++n14];
                objectArray[n11] = simpleImmutableEntry = new AbstractMap.SimpleImmutableEntry<Object, Object[]>(object2, (Object[])object);
            }
            objectArray2 = Ordering.from(this.valueComparator);
            object = Maps.valueFunction();
            objectArray2 = objectArray2.onResultOf((Function)object);
            Arrays.sort(objectArray, 0, n10, objectArray2);
            while (n12 < (n11 = this.size)) {
                objectArray2 = this.alternatingKeysAndValues;
                n10 = n12 * 2;
                objectArray2[n10] = object = objectArray[n12].getKey();
                objectArray2 = this.alternatingKeysAndValues;
                objectArray2[++n10] = object = objectArray[n12].getValue();
                ++n12;
            }
        }
    }
}

