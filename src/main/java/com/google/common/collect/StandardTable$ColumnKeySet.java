/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Iterators;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StandardTable$ColumnKeySet
extends StandardTable$TableSet {
    public final /* synthetic */ StandardTable this$0;

    private StandardTable$ColumnKeySet(StandardTable standardTable) {
        this.this$0 = standardTable;
        super(standardTable, null);
    }

    public /* synthetic */ StandardTable$ColumnKeySet(StandardTable standardTable, StandardTable$1 standardTable$1) {
        this(standardTable);
    }

    public boolean contains(Object object) {
        return this.this$0.containsColumn(object);
    }

    public Iterator iterator() {
        return this.this$0.createColumnKeyIterator();
    }

    public boolean remove(Object object) {
        boolean bl2;
        boolean bl3 = false;
        if (object == null) {
            return false;
        }
        Iterator iterator2 = this.this$0.backingMap.values().iterator();
        while (bl2 = iterator2.hasNext()) {
            Map map = (Map)iterator2.next();
            Set set = map.keySet();
            boolean bl4 = set.remove(object);
            if (!bl4) continue;
            bl3 = true;
            bl2 = map.isEmpty();
            if (!bl2) continue;
            iterator2.remove();
        }
        return bl3;
    }

    public boolean removeAll(Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Iterator iterator2 = this.this$0.backingMap.values().iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Map map = (Map)iterator2.next();
            Iterator iterator3 = map.keySet().iterator();
            boolean bl4 = Iterators.removeAll(iterator3, collection);
            if (!bl4) continue;
            bl3 = true;
            bl2 = map.isEmpty();
            if (!bl2) continue;
            iterator2.remove();
        }
        return bl3;
    }

    public boolean retainAll(Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Iterator iterator2 = this.this$0.backingMap.values().iterator();
        boolean bl3 = false;
        while (bl2 = iterator2.hasNext()) {
            Map map = (Map)iterator2.next();
            Set set = map.keySet();
            boolean bl4 = set.retainAll(collection);
            if (!bl4) continue;
            bl3 = true;
            bl2 = map.isEmpty();
            if (!bl2) continue;
            iterator2.remove();
        }
        return bl3;
    }

    public int size() {
        return Iterators.size(this.iterator());
    }
}

