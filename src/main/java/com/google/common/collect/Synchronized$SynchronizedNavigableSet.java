/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSortedSet;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public class Synchronized$SynchronizedNavigableSet
extends Synchronized$SynchronizedSortedSet
implements NavigableSet {
    private static final long serialVersionUID;
    public transient NavigableSet descendingSet;

    public Synchronized$SynchronizedNavigableSet(NavigableSet navigableSet, Object object) {
        super(navigableSet, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object ceiling(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.ceiling(object);
        }
    }

    public NavigableSet delegate() {
        return (NavigableSet)super.delegate();
    }

    public Iterator descendingIterator() {
        return this.delegate().descendingIterator();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet descendingSet() {
        Object object = this.mutex;
        synchronized (object) {
            NavigableSet navigableSet = this.descendingSet;
            if (navigableSet == null) {
                navigableSet = this.delegate();
                navigableSet = navigableSet.descendingSet();
                Object object2 = this.mutex;
                this.descendingSet = navigableSet = Synchronized.navigableSet(navigableSet, object2);
                return navigableSet;
            }
            return navigableSet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object floor(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.floor(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet headSet(Object navigableSet, boolean bl2) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            navigableSet = object2.headSet(navigableSet, bl2);
            Object object3 = this.mutex;
            return Synchronized.navigableSet(navigableSet, object3);
        }
    }

    public SortedSet headSet(Object object) {
        return this.headSet(object, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object higher(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.higher(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object lower(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.lower(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object pollFirst() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.pollFirst();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object pollLast() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.pollLast();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet subSet(Object navigableSet, boolean bl2, Object object, boolean bl3) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            navigableSet = object3.subSet(navigableSet, bl2, object, bl3);
            Object object4 = this.mutex;
            return Synchronized.navigableSet(navigableSet, object4);
        }
    }

    public SortedSet subSet(Object object, Object object2) {
        return this.subSet(object, true, object2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet tailSet(Object navigableSet, boolean bl2) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            navigableSet = object2.tailSet(navigableSet, bl2);
            Object object3 = this.mutex;
            return Synchronized.navigableSet(navigableSet, object3);
        }
    }

    public SortedSet tailSet(Object object) {
        return this.tailSet(object, true);
    }
}

