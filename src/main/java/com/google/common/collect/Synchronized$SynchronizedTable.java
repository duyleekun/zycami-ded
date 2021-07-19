/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.google.common.collect.Synchronized;
import com.google.common.collect.Synchronized$SynchronizedObject;
import com.google.common.collect.Synchronized$SynchronizedTable$1;
import com.google.common.collect.Synchronized$SynchronizedTable$2;
import com.google.common.collect.Table;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public final class Synchronized$SynchronizedTable
extends Synchronized$SynchronizedObject
implements Table {
    public Synchronized$SynchronizedTable(Table table, Object object) {
        super(table, object);
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set cellSet() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2 = object2.cellSet();
            Object object3 = this.mutex;
            return Synchronized.set((Set)object2, object3);
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
            Table table = this.delegate();
            table.clear();
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map column(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.column(object);
            object3 = this.mutex;
            return Synchronized.map((Map)object, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set columnKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2 = object2.columnKeySet();
            Object object3 = this.mutex;
            return Synchronized.set((Set)object2, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map columnMap() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2 = object2.columnMap();
            Object object3 = new Synchronized$SynchronizedTable$2(this);
            object2 = Maps.transformValues((Map)object2, (Function)object3);
            object3 = this.mutex;
            return Synchronized.map((Map)object2, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean contains(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Table table = this.delegate();
            return table.contains(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsColumn(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Table table = this.delegate();
            return table.containsColumn(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean containsRow(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Table table = this.delegate();
            return table.containsRow(object);
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
            Table table = this.delegate();
            return table.containsValue(object);
        }
    }

    public Table delegate() {
        return (Table)super.delegate();
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        Object object2 = this.mutex;
        synchronized (object2) {
            Table table = this.delegate();
            return table.equals(object);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object get(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Table table = this.delegate();
            return table.get(object, object2);
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
            Table table = this.delegate();
            return table.hashCode();
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
            Table table = this.delegate();
            return table.isEmpty();
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object put(Object object, Object object2, Object object3) {
        Object object4 = this.mutex;
        synchronized (object4) {
            Table table = this.delegate();
            return table.put(object, object2, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public void putAll(Table table) {
        Object object = this.mutex;
        synchronized (object) {
            Table table2 = this.delegate();
            table2.putAll(table);
            return;
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Object remove(Object object, Object object2) {
        Object object3 = this.mutex;
        synchronized (object3) {
            Table table = this.delegate();
            return table.remove(object, object2);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map row(Object object) {
        Object object2 = this.mutex;
        synchronized (object2) {
            Object object3 = this.delegate();
            object = object3.row(object);
            object3 = this.mutex;
            return Synchronized.map((Map)object, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Set rowKeySet() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2 = object2.rowKeySet();
            Object object3 = this.mutex;
            return Synchronized.set((Set)object2, object3);
        }
    }

    /*
     * Enabled aggressive block sorting
     * Enabled unnecessary exception pruning
     * Enabled aggressive exception aggregation
     */
    public Map rowMap() {
        Object object = this.mutex;
        synchronized (object) {
            Object object2 = this.delegate();
            object2 = object2.rowMap();
            Object object3 = new Synchronized$SynchronizedTable$1(this);
            object2 = Maps.transformValues((Map)object2, (Function)object3);
            object3 = this.mutex;
            return Synchronized.map((Map)object2, object3);
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
            Table table = this.delegate();
            return table.size();
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
            Object object2 = this.delegate();
            object2 = object2.values();
            Object object3 = this.mutex;
            return Synchronized.access$500((Collection)object2, object3);
        }
    }
}

