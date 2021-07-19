/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedMap;
import java.util.Comparator;
import java.util.SortedMap;

public class Synchronized$SynchronizedSortedMap
extends Synchronized$SynchronizedMap
implements SortedMap {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedSortedMap(SortedMap sortedMap, Object object) {
        super(sortedMap, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Comparator comparator() {
        Object object = this.mutex;
        synchronized (object) {
            Comparator comparator = this.delegate();
            return comparator.comparator();
        }
    }

    public SortedMap delegate() {
        return (SortedMap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object firstKey() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.firstKey();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedMap headMap(Object sortedMap) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            sortedMap = object2.headMap(sortedMap);
            object2 = this.mutex;
            return Synchronized.sortedMap(sortedMap, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object lastKey() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.lastKey();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedMap subMap(Object sortedMap, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            sortedMap = object3.subMap(sortedMap, object);
            object = this.mutex;
            return Synchronized.sortedMap(sortedMap, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedMap tailMap(Object sortedMap) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            sortedMap = object2.tailMap(sortedMap);
            object2 = this.mutex;
            return Synchronized.sortedMap(sortedMap, object2);
        }
    }
}

