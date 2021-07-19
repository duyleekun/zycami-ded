/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Predicate;
import com.google.common.collect.Maps$AbstractFilteredMap;
import com.google.common.collect.Maps$FilteredEntryMap$EntrySet;
import com.google.common.collect.Maps$FilteredEntryMap$KeySet;
import com.google.common.collect.Sets;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class Maps$FilteredEntryMap
extends Maps$AbstractFilteredMap {
    public final Set filteredEntrySet;

    public Maps$FilteredEntryMap(Map object, Predicate predicate) {
        super((Map)object, predicate);
        object = object.entrySet();
        predicate = this.predicate;
        this.filteredEntrySet = object = Sets.filter((Set)object, predicate);
    }

    public static boolean removeAllKeys(Map object, Predicate predicate, Collection collection) {
        boolean bl2;
        object = object.entrySet().iterator();
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            boolean bl4 = predicate.apply(entry);
            if (!bl4 || !(bl2 = collection.contains(entry = entry.getKey()))) continue;
            object.remove();
            bl3 = true;
        }
        return bl3;
    }

    public static boolean retainAllKeys(Map object, Predicate predicate, Collection collection) {
        boolean bl2;
        object = object.entrySet().iterator();
        boolean bl3 = false;
        while (bl2 = object.hasNext()) {
            Map.Entry entry = (Map.Entry)object.next();
            boolean bl4 = predicate.apply(entry);
            if (!bl4 || (bl2 = collection.contains(entry = entry.getKey()))) continue;
            object.remove();
            bl3 = true;
        }
        return bl3;
    }

    public Set createEntrySet() {
        Maps$FilteredEntryMap$EntrySet maps$FilteredEntryMap$EntrySet = new Maps$FilteredEntryMap$EntrySet(this, null);
        return maps$FilteredEntryMap$EntrySet;
    }

    public Set createKeySet() {
        Maps$FilteredEntryMap$KeySet maps$FilteredEntryMap$KeySet = new Maps$FilteredEntryMap$KeySet(this);
        return maps$FilteredEntryMap$KeySet;
    }
}

