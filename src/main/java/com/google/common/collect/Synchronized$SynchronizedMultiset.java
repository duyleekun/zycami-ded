/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.Set;

public class Synchronized$SynchronizedMultiset
extends Synchronized$SynchronizedCollection
implements Multiset {
    private static final long serialVersionUID;
    public transient Set elementSet;
    public transient Set entrySet;

    public Synchronized$SynchronizedMultiset(Multiset multiset, Object object) {
        super(multiset, object, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int add(Object object, int n10) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multiset multiset = this.delegate();
            return multiset.add(object, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int count(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multiset multiset = this.delegate();
            return multiset.count(object);
        }
    }

    public Multiset delegate() {
        return (Multiset)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set elementSet() {
        Object object = this.mutex;
        synchronized (object) {
            Collection collection = this.elementSet;
            if (collection != null) return this.elementSet;
            collection = this.delegate();
            collection = collection.elementSet();
            Object object2 = this.mutex;
            collection = Synchronized.access$300(collection, object2);
            this.elementSet = collection;
            return this.elementSet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            Collection collection = this.entrySet;
            if (collection != null) return this.entrySet;
            collection = this.delegate();
            collection = collection.entrySet();
            Object object2 = this.mutex;
            collection = Synchronized.access$300(collection, object2);
            this.entrySet = collection;
            return this.entrySet;
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
            Multiset multiset = this.delegate();
            return multiset.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int hashCode() {
        Object object = this.mutex;
        synchronized (object) {
            Multiset multiset = this.delegate();
            return multiset.hashCode();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int remove(Object object, int n10) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multiset multiset = this.delegate();
            return multiset.remove(object, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int setCount(Object object, int n10) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multiset multiset = this.delegate();
            return multiset.setCount(object, n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean setCount(Object object, int n10, int n11) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multiset multiset = this.delegate();
            return multiset.setCount(object, n10, n11);
        }
    }
}

