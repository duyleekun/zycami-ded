/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.SortedSetMultimap;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSetMultimap;
import java.util.Comparator;
import java.util.SortedSet;

public class Synchronized$SynchronizedSortedSetMultimap
extends Synchronized$SynchronizedSetMultimap
implements SortedSetMultimap {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedSortedSetMultimap(SortedSetMultimap sortedSetMultimap, Object object) {
        super(sortedSetMultimap, object);
    }

    public SortedSetMultimap delegate() {
        return (SortedSetMultimap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.get(object);
            object3 = this.mutex;
            return Synchronized.access$100((SortedSet)object, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet removeAll(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multimap multimap = this.delegate();
            return multimap.removeAll(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet replaceValues(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multimap multimap = this.delegate();
            return multimap.replaceValues(object, iterable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Comparator valueComparator() {
        Object object = this.mutex;
        synchronized (object) {
            Multimap multimap = this.delegate();
            return multimap.valueComparator();
        }
    }
}

