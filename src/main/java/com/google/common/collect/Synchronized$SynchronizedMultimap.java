/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedAsMap;
import com.google.common.collect.Synchronized$SynchronizedObject;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Synchronized$SynchronizedMultimap
extends Synchronized$SynchronizedObject
implements Multimap {
    private static final long serialVersionUID;
    public transient Map asMap;
    public transient Collection entries;
    public transient Set keySet;
    public transient Multiset keys;
    public transient Collection valuesCollection;

    public Synchronized$SynchronizedMultimap(Multimap multimap, Object object) {
        super(multimap, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map asMap() {
        Object object = this.mutex;
        synchronized (object) {
            Map map = this.asMap;
            if (map != null) return this.asMap;
            Object object2 = this.delegate();
            object2 = object2.asMap();
            Object object3 = this.mutex;
            this.asMap = map = new Synchronized$SynchronizedAsMap((Map)object2, object3);
            return this.asMap;
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
            Multimap multimap = this.delegate();
            multimap.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsEntry(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Multimap multimap = this.delegate();
            return multimap.containsEntry(object, object2);
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
            Multimap multimap = this.delegate();
            return multimap.containsKey(object);
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
            Multimap multimap = this.delegate();
            return multimap.containsValue(object);
        }
    }

    public Multimap delegate() {
        return (Multimap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection entries() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.entries;
            if (object2 != null) return this.entries;
            object2 = this.delegate();
            object2 = object2.entries();
            Object object3 = this.mutex;
            this.entries = object2 = Synchronized.access$400((Collection)object2, object3);
            return this.entries;
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
            Multimap multimap = this.delegate();
            return multimap.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection get(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.get(object);
            object3 = this.mutex;
            return Synchronized.access$400((Collection)object, object3);
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
            Multimap multimap = this.delegate();
            return multimap.hashCode();
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
            Multimap multimap = this.delegate();
            return multimap.isEmpty();
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
            Object object2 = this.keySet;
            if (object2 != null) return this.keySet;
            object2 = this.delegate();
            object2 = object2.keySet();
            Object object3 = this.mutex;
            this.keySet = object2 = Synchronized.access$300((Set)object2, object3);
            return this.keySet;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Multiset keys() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.keys;
            if (object2 != null) return this.keys;
            object2 = this.delegate();
            object2 = object2.keys();
            Object object3 = this.mutex;
            this.keys = object2 = Synchronized.multiset((Multiset)object2, object3);
            return this.keys;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean put(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Multimap multimap = this.delegate();
            return multimap.put(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean putAll(Multimap multimap) {
        Object object = this.mutex;
        synchronized (object) {
            Multimap multimap2 = this.delegate();
            return multimap2.putAll(multimap);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean putAll(Object object, Iterable iterable) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Multimap multimap = this.delegate();
            return multimap.putAll(object, iterable);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean remove(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Multimap multimap = this.delegate();
            return multimap.remove(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Collection removeAll(Object object) {
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
    public Collection replaceValues(Object object, Iterable iterable) {
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
    public int size() {
        Object object = this.mutex;
        synchronized (object) {
            Multimap multimap = this.delegate();
            return multimap.size();
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
            Object object2 = this.valuesCollection;
            if (object2 != null) return this.valuesCollection;
            object2 = this.delegate();
            object2 = object2.values();
            Object object3 = this.mutex;
            this.valuesCollection = object2 = Synchronized.access$500((Collection)object2, object3);
            return this.valuesCollection;
        }
    }
}

