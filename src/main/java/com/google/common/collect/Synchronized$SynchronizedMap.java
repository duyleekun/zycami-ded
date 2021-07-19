/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Synchronized$SynchronizedMap
extends Synchronized$SynchronizedObject
implements Map {
    private static final long serialVersionUID;
    public transient Set entrySet;
    public transient Set keySet;
    public transient Collection values;

    public Synchronized$SynchronizedMap(Map map, Object object) {
        super(map, object);
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
    public boolean containsKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.containsKey(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsValue(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.containsValue(object);
        }
    }

    public Map delegate() {
        return (Map)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set entrySet() {
        Object object = this.mutex;
        synchronized (object) {
            Set set = this.entrySet;
            if (set != null) return this.entrySet;
            set = this.delegate();
            set = set.entrySet();
            Object object2 = this.mutex;
            this.entrySet = set = Synchronized.set(set, object2);
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
            Object object3 = this.delegate();
            return object3.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.get(object);
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
    public boolean isEmpty() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            return object2.isEmpty();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set keySet() {
        Object object = this.mutex;
        synchronized (object) {
            Set set = this.keySet;
            if (set != null) return this.keySet;
            set = this.delegate();
            set = set.keySet();
            Object object2 = this.mutex;
            this.keySet = set = Synchronized.set(set, object2);
            return this.keySet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Object object4 = this.delegate();
            return object4.put(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void putAll(Map map) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2.putAll(map);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove(Object object) {
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
    public Collection values() {
        Object object = this.mutex;
        synchronized (object) {
            Collection collection = this.values;
            if (collection != null) return this.values;
            collection = this.delegate();
            collection = collection.values();
            Object object2 = this.mutex;
            this.values = collection = Synchronized.access$500(collection, object2);
            return this.values;
        }
    }
}

