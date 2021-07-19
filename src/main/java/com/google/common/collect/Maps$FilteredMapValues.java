/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps$Values;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

public final class Maps$FilteredMapValues
extends Maps$Values {
    public final Predicate predicate;
    public final Map unfiltered;

    public Maps$FilteredMapValues(Map map, Map map2, Predicate predicate) {
        super(map);
        this.unfiltered = map2;
        this.predicate = predicate;
    }

    public boolean remove(Object object) {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.entrySet().iterator();
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Map.Entry entry = iterator2.next();
            boolean bl3 = predicate.apply(entry);
            if (!bl3 || !(bl2 = Objects.equal(entry = entry.getValue(), object))) continue;
            iterator2.remove();
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.entrySet().iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Map.Entry entry = iterator2.next();
            boolean bl4 = predicate.apply(entry);
            if (!bl4 || !(bl2 = collection.contains(entry = entry.getValue()))) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2;
        Iterator iterator2 = this.unfiltered.entrySet().iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Predicate predicate = this.predicate;
            Map.Entry entry = iterator2.next();
            boolean bl4 = predicate.apply(entry);
            if (!bl4 || (bl2 = collection.contains(entry = entry.getValue()))) continue;
            iterator2.remove();
            bl3 = true;
        }
        return bl3;
    }

    public Object[] toArray() {
        return Lists.newArrayList(this.iterator()).toArray();
    }

    public Object[] toArray(Object[] objectArray) {
        return Lists.newArrayList(this.iterator()).toArray(objectArray);
    }
}

