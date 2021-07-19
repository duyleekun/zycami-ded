/*
 * Decompiled with CFR 0.151.
 */
package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.StandardTable;
import com.google.common.collect.StandardTable$ColumnMap;
import com.google.common.collect.StandardTable$ColumnMap$ColumnMapEntrySet$1;
import com.google.common.collect.StandardTable$TableSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class StandardTable$ColumnMap$ColumnMapEntrySet
extends StandardTable$TableSet {
    public final /* synthetic */ StandardTable$ColumnMap this$1;

    public StandardTable$ColumnMap$ColumnMapEntrySet(StandardTable$ColumnMap object) {
        this.this$1 = object;
        object = ((StandardTable$ColumnMap)object).this$0;
        super((StandardTable)object, null);
    }

    public boolean contains(Object object) {
        Object k10;
        Object object2;
        boolean bl2 = object instanceof Map.Entry;
        if (bl2 && (bl2 = ((StandardTable)(object2 = this.this$1.this$0)).containsColumn(k10 = (object = (Map.Entry)object).getKey()))) {
            object2 = object.getKey();
            object2 = this.this$1.get(object2);
            object = object.getValue();
            return object2.equals(object);
        }
        return false;
    }

    public Iterator iterator() {
        Set set = this.this$1.this$0.columnKeySet();
        StandardTable$ColumnMap$ColumnMapEntrySet$1 standardTable$ColumnMap$ColumnMapEntrySet$1 = new StandardTable$ColumnMap$ColumnMapEntrySet$1(this);
        return Maps.asMapEntryIterator(set, standardTable$ColumnMap$ColumnMapEntrySet$1);
    }

    public boolean remove(Object object) {
        boolean bl2 = this.contains(object);
        if (bl2) {
            object = (Map.Entry)object;
            StandardTable standardTable = this.this$1.this$0;
            object = object.getKey();
            StandardTable.access$900(standardTable, object);
            return true;
        }
        return false;
    }

    public boolean removeAll(Collection object) {
        Preconditions.checkNotNull(object);
        object = object.iterator();
        return Sets.removeAllImpl((Set)this, (Iterator)object);
    }

    public boolean retainAll(Collection collection) {
        boolean bl2;
        Preconditions.checkNotNull(collection);
        Iterator iterator2 = Lists.newArrayList(this.this$1.this$0.columnKeySet().iterator()).iterator();
        boolean bl3 = false;
        StandardTable standardTable = null;
        while (bl2 = iterator2.hasNext()) {
            Object e10 = iterator2.next();
            Object object = this.this$1.this$0.column(e10);
            boolean bl4 = collection.contains(object = Maps.immutableEntry(e10, object));
            if (bl4) continue;
            standardTable = this.this$1.this$0;
            StandardTable.access$900(standardTable, e10);
            bl3 = true;
        }
        return bl3;
    }

    public int size() {
        return this.this$1.this$0.columnKeySet().size();
    }
}

