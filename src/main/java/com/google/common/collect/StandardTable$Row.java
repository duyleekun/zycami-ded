/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$IteratorBasedAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Row$1;
import com.google.common.collect.StandardTable$Row$2;
import java.util.Iterator;
import java.util.Map;

public class StandardTable$Row
extends Maps$IteratorBasedAbstractMap {
    public Map backingRowMap;
    public final Object rowKey;
    public final /* synthetic */ StandardTable this$0;

    public StandardTable$Row(StandardTable object, Object object2) {
        this.this$0 = object;
        this.rowKey = object = Preconditions.checkNotNull(object2);
    }

    public Map backingRowMap() {
        Object object;
        boolean bl2;
        Map map = this.backingRowMap;
        if (!(map == null || (bl2 = map.isEmpty()) && (bl2 = (map = this.this$0.backingMap).containsKey(object = this.rowKey)))) {
            map = this.backingRowMap;
        } else {
            this.backingRowMap = map = this.computeBackingRowMap();
        }
        return map;
    }

    public void clear() {
        Map map = this.backingRowMap();
        if (map != null) {
            map.clear();
        }
        this.maintainEmptyInvariant();
    }

    public Map computeBackingRowMap() {
        Map map = this.this$0.backingMap;
        Object object = this.rowKey;
        return (Map)map.get(object);
    }

    public boolean containsKey(Object object) {
        boolean bl2;
        Map map = this.backingRowMap();
        if (object != null && map != null && (bl2 = Maps.safeContainsKey(map, object))) {
            bl2 = true;
        } else {
            bl2 = false;
            object = null;
        }
        return bl2;
    }

    public Iterator entryIterator() {
        Object object = this.backingRowMap();
        if (object == null) {
            return Iterators.emptyModifiableIterator();
        }
        object = object.entrySet().iterator();
        StandardTable$Row$1 standardTable$Row$1 = new StandardTable$Row$1(this, (Iterator)object);
        return standardTable$Row$1;
    }

    public Object get(Object object) {
        Map map = this.backingRowMap();
        object = object != null && map != null ? Maps.safeGet(map, object) : null;
        return object;
    }

    public void maintainEmptyInvariant() {
        boolean bl2;
        Map map = this.backingRowMap();
        if (map != null && (bl2 = (map = this.backingRowMap).isEmpty())) {
            map = this.this$0.backingMap;
            Object object = this.rowKey;
            map.remove(object);
            bl2 = false;
            map = null;
            this.backingRowMap = null;
        }
    }

    public Object put(Object object, Object object2) {
        boolean bl2;
        Preconditions.checkNotNull(object);
        Preconditions.checkNotNull(object2);
        Object object3 = this.backingRowMap;
        if (object3 != null && !(bl2 = object3.isEmpty())) {
            return this.backingRowMap.put(object, object2);
        }
        object3 = this.this$0;
        Object object4 = this.rowKey;
        return ((StandardTable)object3).put(object4, object, object2);
    }

    public Object remove(Object object) {
        Map map = this.backingRowMap();
        if (map == null) {
            return null;
        }
        object = Maps.safeRemove(map, object);
        this.maintainEmptyInvariant();
        return object;
    }

    public int size() {
        int n10;
        Map map = this.backingRowMap();
        if (map == null) {
            n10 = 0;
            map = null;
        } else {
            n10 = map.size();
        }
        return n10;
    }

    public Map.Entry wrapEntry(Map.Entry entry) {
        StandardTable$Row$2 standardTable$Row$2 = new StandardTable$Row$2(this, entry);
        return standardTable$Row$2;
    }
}

