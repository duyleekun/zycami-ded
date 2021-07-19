/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Collections2;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.ObjectArrays;
import com.google.common.collect.Sets;
import com.google.common.collect.Synchronized$SynchronizedAsMapEntries$1;
import com.google.common.collect.Synchronized$SynchronizedSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Synchronized$SynchronizedAsMapEntries
extends Synchronized$SynchronizedSet {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedAsMapEntries(Set set, Object object) {
        super(set, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean contains(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return Maps.containsEntryImpl((Collection)object3, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return Collections2.containsAllImpl((Collection)object2, collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return Sets.equalsImpl((Set)object3, object);
        }
    }

    public Iterator iterator() {
        Iterator iterator2 = super.iterator();
        Synchronized$SynchronizedAsMapEntries$1 synchronized$SynchronizedAsMapEntries$1 = new Synchronized$SynchronizedAsMapEntries$1(this, iterator2);
        return synchronized$SynchronizedAsMapEntries$1;
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean remove(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return Maps.removeEntryImpl((Collection)object3, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean removeAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator2 = this.delegate();
            iterator2 = iterator2.iterator();
            return Iterators.removeAll(iterator2, collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean retainAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            Iterator iterator2 = this.delegate();
            iterator2 = iterator2.iterator();
            return Iterators.retainAll(iterator2, collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object[] toArray() {
        Object object = this.mutex;
        synchronized (object) {
            Object[] objectArray = this.delegate();
            return ObjectArrays.toArrayImpl((Collection)objectArray);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object[] toArray(Object[] objectArray) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return ObjectArrays.toArrayImpl((Collection)object2, objectArray);
        }
    }
}

