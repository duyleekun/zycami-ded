/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized$1;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Iterator;

public class Synchronized$SynchronizedCollection
extends Synchronized$SynchronizedObject
implements Collection {
    private static final long serialVersionUID;

    private Synchronized$SynchronizedCollection(Collection collection, Object object) {
        super(collection, object);
    }

    public /* synthetic */ Synchronized$SynchronizedCollection(Collection collection, Object object, Synchronized$1 synchronized$1) {
        this(collection, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean add(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.add(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean addAll(Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.addAll(collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void clear() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2.clear();
            return;
        }
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
            return object3.contains(object);
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
            return object2.containsAll(collection);
        }
    }

    public Collection delegate() {
        return (Collection)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.isEmpty();
        }
    }

    public Iterator iterator() {
        return this.delegate().iterator();
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
            return object3.remove(object);
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
            Object object2 = this.delegate();
            return object2.removeAll(collection);
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
            Object object2 = this.delegate();
            return object2.retainAll(collection);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.size();
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
            return objectArray.toArray();
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
            return object2.toArray(objectArray);
        }
    }
}

