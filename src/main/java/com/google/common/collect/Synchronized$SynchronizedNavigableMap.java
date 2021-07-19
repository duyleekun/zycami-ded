/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedSortedMap;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

public class Synchronized$SynchronizedNavigableMap
extends Synchronized$SynchronizedSortedMap
implements NavigableMap {
    private static final long serialVersionUID;
    public transient NavigableSet descendingKeySet;
    public transient NavigableMap descendingMap;
    public transient NavigableSet navigableKeySet;

    public Synchronized$SynchronizedNavigableMap(NavigableMap navigableMap, Object object) {
        super(navigableMap, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry ceilingEntry(Object entry) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            entry = object2.ceilingEntry(entry);
            object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object ceilingKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.ceilingKey(object);
        }
    }

    public NavigableMap delegate() {
        return (NavigableMap)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet descendingKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            NavigableSet navigableSet = this.descendingKeySet;
            if (navigableSet == null) {
                navigableSet = this.delegate();
                navigableSet = navigableSet.descendingKeySet();
                Object object2 = this.mutex;
                this.descendingKeySet = navigableSet = Synchronized.navigableSet(navigableSet, object2);
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
    public NavigableMap descendingMap() {
        Object object = this.mutex;
        synchronized (object) {
            NavigableMap navigableMap = this.descendingMap;
            if (navigableMap == null) {
                navigableMap = this.delegate();
                navigableMap = navigableMap.descendingMap();
                Object object2 = this.mutex;
                this.descendingMap = navigableMap = Synchronized.navigableMap(navigableMap, object2);
                return navigableMap;
            }
            return navigableMap;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry firstEntry() {
        Object object = this.mutex;
        synchronized (object) {
            Map.Entry entry = this.delegate();
            entry = entry.firstEntry();
            Object object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry floorEntry(Object entry) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            entry = object2.floorEntry(entry);
            object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object floorKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.floorKey(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableMap headMap(Object navigableMap, boolean bl2) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            navigableMap = object2.headMap(navigableMap, bl2);
            Object object3 = this.mutex;
            return Synchronized.navigableMap(navigableMap, object3);
        }
    }

    public SortedMap headMap(Object object) {
        return this.headMap(object, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry higherEntry(Object entry) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            entry = object2.higherEntry(entry);
            object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object higherKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.higherKey(object);
        }
    }

    public Set keySet() {
        return this.navigableKeySet();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry lastEntry() {
        Object object = this.mutex;
        synchronized (object) {
            Map.Entry entry = this.delegate();
            entry = entry.lastEntry();
            Object object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry lowerEntry(Object entry) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            entry = object2.lowerEntry(entry);
            object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object lowerKey(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            return object3.lowerKey(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableSet navigableKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            NavigableSet navigableSet = this.navigableKeySet;
            if (navigableSet == null) {
                navigableSet = this.delegate();
                navigableSet = navigableSet.navigableKeySet();
                Object object2 = this.mutex;
                this.navigableKeySet = navigableSet = Synchronized.navigableSet(navigableSet, object2);
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
    public Map.Entry pollFirstEntry() {
        Object object = this.mutex;
        synchronized (object) {
            Map.Entry entry = this.delegate();
            entry = entry.pollFirstEntry();
            Object object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map.Entry pollLastEntry() {
        Object object = this.mutex;
        synchronized (object) {
            Map.Entry entry = this.delegate();
            entry = entry.pollLastEntry();
            Object object2 = this.mutex;
            return Synchronized.access$700(entry, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableMap subMap(Object navigableMap, boolean bl2, Object object, boolean bl3) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            navigableMap = object3.subMap(navigableMap, bl2, object, bl3);
            Object object4 = this.mutex;
            return Synchronized.navigableMap(navigableMap, object4);
        }
    }

    public SortedMap subMap(Object object, Object object2) {
        return this.subMap(object, true, object2, false);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public NavigableMap tailMap(Object navigableMap, boolean bl2) {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            navigableMap = object2.tailMap(navigableMap, bl2);
            Object object3 = this.mutex;
            return Synchronized.navigableMap(navigableMap, object3);
        }
    }

    public SortedMap tailMap(Object object) {
        return this.tailMap(object, true);
    }
}

