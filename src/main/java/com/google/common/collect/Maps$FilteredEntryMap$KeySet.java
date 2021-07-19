/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$FilteredEntryMap;
import com.google.common.collect.Maps$KeySet;
import java.util.Collection;
import java.util.Map;

public class Maps$FilteredEntryMap$KeySet
extends Maps$KeySet {
    public final /* synthetic */ Maps$FilteredEntryMap this$0;

    public Maps$FilteredEntryMap$KeySet(Maps$FilteredEntryMap maps$FilteredEntryMap) {
        this.this$0 = maps$FilteredEntryMap;
        super(maps$FilteredEntryMap);
    }

    public boolean remove(Object object) {
        Maps$FilteredEntryMap maps$FilteredEntryMap = this.this$0;
        boolean bl2 = maps$FilteredEntryMap.containsKey(object);
        if (bl2) {
            this.this$0.unfiltered.remove(object);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        Object object = this.this$0;
        Map map = ((Maps$AbstractFilteredMap)object).unfiltered;
        object = ((Maps$AbstractFilteredMap)object).predicate;
        return Maps$FilteredEntryMap.removeAllKeys(map, (Predicate)object, collection);
    }

    public boolean retainAll(Collection collection) {
        Object object = this.this$0;
        Map map = ((Maps$AbstractFilteredMap)object).unfiltered;
        object = ((Maps$AbstractFilteredMap)object).predicate;
        return Maps$FilteredEntryMap.retainAllKeys(map, (Predicate)object, collection);
    }

    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return Lists.newArrayList(this.iterator()).toArray(objectArray);
    }
}

