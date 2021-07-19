/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.collect.Maps;
import com.google.common.collect.Maps$ViewCachingAbstractMap;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$Column$EntrySet;
import com.google.common.collect.StandardTable$Column$KeySet;
import com.google.common.collect.StandardTable$Column$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StandardTable$Column
extends Maps$ViewCachingAbstractMap {
    public final Object columnKey;
    public final /* synthetic */ StandardTable this$0;

    public StandardTable$Column(StandardTable object, Object object2) {
        this.this$0 = object;
        this.columnKey = object = Preconditions.checkNotNull(object2);
    }

    public boolean containsKey(Object object) {
        StandardTable standardTable = this.this$0;
        Object object2 = this.columnKey;
        return standardTable.contains(object, object2);
    }

    public Set createEntrySet() {
        StandardTable$Column$EntrySet standardTable$Column$EntrySet = new StandardTable$Column$EntrySet(this, null);
        return standardTable$Column$EntrySet;
    }

    public Set createKeySet() {
        StandardTable$Column$KeySet standardTable$Column$KeySet = new StandardTable$Column$KeySet(this);
        return standardTable$Column$KeySet;
    }

    public Collection createValues() {
        StandardTable$Column$Values standardTable$Column$Values = new StandardTable$Column$Values(this);
        return standardTable$Column$Values;
    }

    public Object get(Object object) {
        StandardTable standardTable = this.this$0;
        Object object2 = this.columnKey;
        return standardTable.get(object, object2);
    }

    public Object put(Object object, Object object2) {
        StandardTable standardTable = this.this$0;
        Object object3 = this.columnKey;
        return standardTable.put(object, object3, object2);
    }

    public Object remove(Object object) {
        StandardTable standardTable = this.this$0;
        Object object2 = this.columnKey;
        return standardTable.remove(object, object2);
    }

    public boolean removeFromColumnIf(Predicate predicate) {
        boolean bl2;
        Iterator iterator2 = this.this$0.backingMap.entrySet().iterator();
        boolean bl3 = false;
        Object object = null;
        while (bl2 = iterator2.hasNext()) {
            Map.Entry entry = iterator2.next();
            Map map = (Map)entry.getValue();
            Object object2 = this.columnKey;
            if ((object2 = map.get(object2)) == null || !(bl2 = predicate.apply(entry = Maps.immutableEntry(entry.getKey(), object2)))) continue;
            object = this.columnKey;
            map.remove(object);
            bl3 = true;
            bl2 = map.isEmpty();
            if (!bl2) continue;
            iterator2.remove();
        }
        return bl3;
    }
}

