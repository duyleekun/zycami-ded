/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Comparator;
import java.util.SortedSet;

public class Synchronized$SynchronizedSortedSet
extends Synchronized$SynchronizedSet
implements SortedSet {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedSortedSet(SortedSet sortedSet, Object object) {
        super(sortedSet, object);
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

    public SortedSet delegate() {
        return (SortedSet)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object first() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.first();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet headSet(Object sortedSet) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            sortedSet = object2.headSet(sortedSet);
            object2 = this.mutex;
            return Synchronized.access$100(sortedSet, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object last() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.last();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet subSet(Object sortedSet, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            sortedSet = object3.subSet(sortedSet, object);
            object = this.mutex;
            return Synchronized.access$100(sortedSet, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public SortedSet tailSet(Object sortedSet) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            sortedSet = object2.tailSet(sortedSet);
            object2 = this.mutex;
            return Synchronized.access$100(sortedSet, object2);
        }
    }
}

