/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedCollection;
import java.util.Collection;
import java.util.List;
import java.util.ListIterator;

public class Synchronized$SynchronizedList
extends Synchronized$SynchronizedCollection
implements List {
    private static final long serialVersionUID;

    public Synchronized$SynchronizedList(List list, Object object) {
        super(list, object, null);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(int n10, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object3.add(n10, object);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean addAll(int n10, Collection collection) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return (int)(object2.addAll(n10, collection) ? 1 : 0) != 0;
        }
    }

    public List delegate() {
        return (List)super.delegate();
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
            return object3.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(int n10) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.get(n10);
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
            Object object2 = this.delegate();
            return object2.hashCode();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int indexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.indexOf(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public int lastIndexOf(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.lastIndexOf(object);
        }
    }

    public ListIterator listIterator() {
        return this.delegate().listIterator();
    }

    public ListIterator listIterator(int n10) {
        return this.delegate().listIterator(n10);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove(int n10) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.remove(n10);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object set(int n10, Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.set(n10, object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public List subList(int n10, int n11) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            List list = object2.subList(n10, n11);
            Object object3 = this.mutex;
            return Synchronized.access$200(list, object3);
        }
    }
}

