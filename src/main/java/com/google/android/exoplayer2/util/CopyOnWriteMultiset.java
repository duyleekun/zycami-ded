/*
 * Decompiled with CFR 0.151.
 */
package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class CopyOnWriteMultiset
implements Iterable {
    private final Map elementCounts;
    private Set elementSet;
    private List elements;
    private final Object lock;

    public CopyOnWriteMultiset() {
        List list = new List();
        this.lock = list;
        list = new List();
        this.elementCounts = list;
        list = Collections.emptySet();
        this.elementSet = list;
        this.elements = list = Collections.emptyList();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void add(Object object) {
        Object object2 = this.lock;
        synchronized (object2) {
            Set<Object> set = this.elements;
            Object object3 = new ArrayList(set);
            object3.add(object);
            object3 = Collections.unmodifiableList(object3);
            this.elements = object3;
            object3 = this.elementCounts;
            object3 = object3.get(object);
            object3 = (Integer)object3;
            if (object3 == null) {
                Set set2 = this.elementSet;
                set = new Set<Object>(set2);
                set.add(object);
                this.elementSet = set = Collections.unmodifiableSet(set);
            }
            set = this.elementCounts;
            int n10 = 1;
            if (object3 != null) {
                int n11 = (Integer)object3;
                n10 += n11;
            }
            object3 = n10;
            set.put(object, object3);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set elementSet() {
        Object object = this.lock;
        synchronized (object) {
            return this.elementSet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Iterator iterator() {
        Object object = this.lock;
        synchronized (object) {
            List list = this.elements;
            return list.iterator();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void remove(Object set) {
        Object object = this.lock;
        synchronized (object) {
            HashSet hashSet = this.elementCounts;
            hashSet = hashSet.get(set);
            hashSet = (Integer)((Object)hashSet);
            if (hashSet == null) {
                return;
            }
            List list = this.elements;
            Object object2 = new ArrayList(list);
            object2.remove(set);
            object2 = Collections.unmodifiableList(object2);
            this.elements = object2;
            int n10 = (Integer)((Object)hashSet);
            int n11 = 1;
            if (n10 == n11) {
                hashSet = this.elementCounts;
                hashSet.remove(set);
                object2 = this.elementSet;
                hashSet = new HashSet(object2);
                hashSet.remove(set);
                this.elementSet = set = Collections.unmodifiableSet(hashSet);
            } else {
                object2 = this.elementCounts;
                int n12 = (Integer)((Object)hashSet) - n11;
                hashSet = n12;
                object2.put(set, hashSet);
            }
            return;
        }
    }
}

